package com.malak.yaim;

import android.app.Application;
import android.support.annotation.NonNull;
import com.malak.yaim.di.components.AppComponent;
import com.malak.yaim.di.components.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

public class YAIMApplication extends Application {
  private AppComponent mAppComponent;

  @Override public void onCreate() {
    super.onCreate();
    initializeLeakCanary();
    initializeInjector();
  }

  @NonNull public AppComponent getAppComponent() {
    return mAppComponent;
  }

  private void initializeInjector() {
    mAppComponent = DaggerAppComponent.create();
  }

  private void initializeLeakCanary() {
    if (!LeakCanary.isInAnalyzerProcess(this) && BuildConfig.DEBUG) LeakCanary.install(this);
  }
}
