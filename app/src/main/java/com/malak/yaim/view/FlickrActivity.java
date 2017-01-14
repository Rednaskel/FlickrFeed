package com.malak.yaim.view;

import android.os.Bundle;
import com.malak.yaim.BaseActivity;
import com.malak.yaim.R;
import com.malak.yaim.adapters.FeedAdapter;
import com.malak.yaim.presentation.FeedPresenter;
import javax.inject.Inject;

public class FlickrActivity extends BaseActivity {
  @Inject FeedPresenter mPresenter;
  @Inject FeedAdapter mAdapter;

  @Override public void initializeInjector() {
    getApplicationComponent().inject(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_flickr_feed);
  }

  @Override protected void onResume() {
    super.onResume();
    mPresenter.onResumed();
  }
}