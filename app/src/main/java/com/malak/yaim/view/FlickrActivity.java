package com.malak.yaim.view;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.malak.yaim.BaseActivity;
import com.malak.yaim.FeedListContract;
import com.malak.yaim.R;
import com.malak.yaim.adapters.FeedAdapter;
import com.malak.yaim.model.Item;
import com.malak.yaim.presentation.FeedPresenter;
import java.util.List;
import javax.inject.Inject;

public class FlickrActivity extends BaseActivity implements FeedListContract.View {
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

    if (isInternetConnected()) mPresenter.onCreated();
  }

  @Override public void showPhotos(@NonNull List<Item> flickrFeedItems) {
    mAdapter.setDataset(flickrFeedItems);
  }

  @Override public void showErrorMsg(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }

  private boolean isInternetConnected() {
    final ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    final NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
  }
}