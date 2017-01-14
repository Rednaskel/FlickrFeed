package com.malak.yaim.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.malak.yaim.R;
import com.malak.yaim.model.Item;
import java.util.List;
import javax.inject.Inject;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
  private List<Item> mImagesMetadata;

  @Inject FeedAdapter() {}

  public void setDataset(final List<Item> items) {
    mImagesMetadata = items;
  }

  @Override public FeedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view = LayoutInflater
        .from(parent.getContext())
        .inflate(R.layout.feed_item, parent, false);

    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(FeedAdapter.ViewHolder holder, int position) {
    /* TODO 1. add Picasso call */
    /*TODO 2. bind metadata to text views */
  }

  @Override public int getItemCount() {
    return mImagesMetadata != null ? mImagesMetadata.size() : 0;
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.feed_item_image) ImageView mFeedItemImage;

    ViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }
}