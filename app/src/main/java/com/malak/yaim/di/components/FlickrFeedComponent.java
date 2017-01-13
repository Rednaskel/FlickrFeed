package com.malak.yaim.di.components;

import com.malak.yaim.FlickrFeed;
import com.malak.yaim.di.modules.FlickrFeedModule;
import com.malak.yaim.di.scopes.PerActivity;
import com.malak.yaim.services.FlickrService;
import dagger.Component;

@PerActivity
@Component(
    dependencies = AppComponent.class,
    modules = FlickrFeedModule.class
)
public interface FlickrFeedComponent {
  void inject(final FlickrFeed activity);

  FlickrFeed activity();
  FlickrService service();
}
