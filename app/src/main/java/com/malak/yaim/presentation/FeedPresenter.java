package com.malak.yaim.presentation;

import com.malak.yaim.services.FlickrService;
import javax.inject.Inject;

public class FeedPresenter {
  @Inject FlickrService mService;

  @Inject public FeedPresenter() {}
}
