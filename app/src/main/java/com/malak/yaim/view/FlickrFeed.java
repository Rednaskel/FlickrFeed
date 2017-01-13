package com.malak.yaim.view;

import android.os.Bundle;
import com.malak.yaim.BaseActivity;
import com.malak.yaim.R;
import com.malak.yaim.di.components.DaggerFlickrFeedComponent;
import com.malak.yaim.di.components.FlickrFeedComponent;
import com.malak.yaim.di.modules.FlickrFeedModule;

public class FlickrFeed extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_flickr_feed);
  }

  @Override public void initializeInjector() {
    final FlickrFeedComponent component = DaggerFlickrFeedComponent.builder()
        .appComponent(getApplicationComponent())
        .flickrFeedModule(new FlickrFeedModule(this))
        .build();
    component.inject(this);
  }
}
