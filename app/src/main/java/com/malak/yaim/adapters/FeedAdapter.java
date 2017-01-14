package com.malak.yaim.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.malak.yaim.model.Item;
import java.util.List;
import javax.inject.Inject;

public class FeedAdapter extends RecyclerView.Adapter {
  private List<Item> mImagesMetadata;

  @Inject FeedAdapter() {}

  public void setDataset(final List<Item> items) {
    mImagesMetadata = items;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return null;
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

  }

  @Override public int getItemCount() {
    return 0;
  }
}
