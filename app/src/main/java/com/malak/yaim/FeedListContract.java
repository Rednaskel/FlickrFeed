package com.malak.yaim;

import android.support.annotation.NonNull;
import com.malak.yaim.model.Item;
import java.util.List;

public interface FeedListContract {

  interface View {
    void showPhotos(@NonNull final List<Item> flickrFeedItems);

    void showErrorMsg();
  }

  interface Presenter {
    void bind(final FeedListContract.View view);

    void onCreated();

    void onRestarted();

    void onRefreshButtonClicked();
  }
}
