package com.malak.yaim.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.malak.yaim.BaseActivity;
import com.malak.yaim.R;
import com.malak.yaim.adapters.FeedAdapter;
import com.malak.yaim.presentation.FeedPresenter;
import javax.inject.Inject;

public class FlickrActivity extends BaseActivity {
  @Inject FeedPresenter mPresenter;
  @Inject FeedAdapter mAdapter;

  @BindView(R.id.feed_recycler_view) RecyclerView mRecycler;

  @Override public void initializeInjector() {
    getApplicationComponent().inject(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_flickr_feed);
    ButterKnife.bind(this);

    final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
    mRecycler.setLayoutManager(layoutManager);
    mRecycler.setHasFixedSize(true);
    mRecycler.setAdapter(mAdapter);
  }

  @Override protected void onResume() {
    super.onResume();
    mPresenter.onResumed();
  }
}