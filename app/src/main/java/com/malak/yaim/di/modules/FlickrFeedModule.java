package com.malak.yaim.di.modules;

import com.malak.yaim.view.FlickrActivity;
import com.malak.yaim.di.scopes.PerActivity;
import com.malak.yaim.services.FlickrService;
import dagger.Module;
import dagger.Provides;

@Module
public class FlickrFeedModule {
  private FlickrActivity mActivity;

  public FlickrFeedModule(final FlickrActivity activity) {
    mActivity = activity;
  }

  @Provides @PerActivity FlickrActivity providesFlickrActivity() {
    return mActivity;
  }

  @Provides @PerActivity FlickrService providesFlickrService() {
    return new FlickrService();
  }
}
