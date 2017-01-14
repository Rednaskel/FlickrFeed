package com.malak.yaim.di.components;

import com.malak.yaim.di.scopes.PerApp;
import com.malak.yaim.view.FlickrActivity;
import dagger.Component;

@PerApp
@Component
public interface AppComponent {
  void inject(FlickrActivity activity);
}
