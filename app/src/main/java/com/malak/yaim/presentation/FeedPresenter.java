package com.malak.yaim.presentation;

import com.malak.yaim.model.FlickrFeed;
import com.malak.yaim.services.FlickrService;
import hugo.weaving.DebugLog;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class FeedPresenter {
  @Inject FlickrService mService;

  @Inject public FeedPresenter() {}

  public void loadFeed() {
    mService.getFlickrAPI()
        .getPublicFeed()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<FlickrFeed>() {
          @Override public void onSubscribe(Disposable d) {}

          @DebugLog
          @Override public void onNext(FlickrFeed flickrFeed) {}

          @DebugLog
          @Override public void onError(Throwable e) {}

          @Override public void onComplete() {}
        });
  }
}
