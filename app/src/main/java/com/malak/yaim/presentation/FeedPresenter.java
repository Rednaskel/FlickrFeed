package com.malak.yaim.presentation;

import com.malak.yaim.FeedListContract;
import com.malak.yaim.model.FlickrFeed;
import com.malak.yaim.services.FlickrService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class FeedPresenter implements FeedListContract.Presenter {
  private FlickrService mService;
  private FeedListContract.View mView;

  @Inject public FeedPresenter(FlickrService service) {
    mService = service;
  }

  @Override public void bind(FeedListContract.View view) {
    mView = view;
  }

  public void onCreated() {
    loadFeed();
  }

  @Override public void onRestarted() {
    loadFeed();
  }

  /**
   * Observe and subscribe to Flickr service. (trigger image download)
   * Updates UI with feeds' images or with error messages.
   *
   * @see FlickrService
   **/
  private void loadFeed() {
    mService.getFlickrAPI()
        .getPublicFeed()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(FlickrFeed::getItems)
        .doOnNext(list -> mView.showPhotos(list))
        .doOnError(throwable -> mView.showErrorMsg())
        .subscribe();
  }
}