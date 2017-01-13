package com.malak.yaim.di.modules;

import com.malak.yaim.view.FlickrFeed;
import com.malak.yaim.di.scopes.PerActivity;
import com.malak.yaim.services.FlickrService;
import dagger.Module;
import dagger.Provides;

@Module
public class FlickrFeedModule {
  private FlickrFeed mActivity;

  public FlickrFeedModule(final FlickrFeed activity) {
    mActivity = activity;
  }

  @Provides @PerActivity FlickrFeed providesFlickrActivity() {
    return mActivity;
  }

  @Provides @PerActivity FlickrService providesFlickrService() {
    return new FlickrService();
  }
}
