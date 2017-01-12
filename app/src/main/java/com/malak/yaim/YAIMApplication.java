package com.malak.yaim;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;

public class YAIMApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();
    initializeLeakCanary();
  }

  private void initializeLeakCanary() {
    if (!LeakCanary.isInAnalyzerProcess(this) && BuildConfig.DEBUG) LeakCanary.install(this);
  }
}
