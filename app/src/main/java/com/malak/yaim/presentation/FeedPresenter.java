package com.malak.yaim.presentation;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.malak.yaim.model.FlickrFeed;
import com.malak.yaim.services.FlickrService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class FeedPresenter {
  private FlickrService mService;

  @Inject public FeedPresenter(FlickrService service) {
    mService = service;
  }

  public void onCreated() {
    loadFeed();
  }

  public void onResumed() {
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
        .doOnNext(list -> {
          /*TODO Update UI adapter with list of URLs*/
        })
        .doOnError(throwable -> {
          /*TODO Update UI with error*/
          if (throwable instanceof HttpException) {
            ((HttpException) throwable).code();
          }
        })
        .subscribe();
  }
}