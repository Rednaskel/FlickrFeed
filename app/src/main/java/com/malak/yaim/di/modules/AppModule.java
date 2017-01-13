package com.malak.yaim.di.modules;

import android.content.Context;
import com.malak.yaim.YAIMApplication;
import com.malak.yaim.di.scopes.PerApp;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
private final YAIMApplication mApp;

  public AppModule(final YAIMApplication app) {
    mApp = app;
  }

  @Provides @PerApp Context provideApplicationContext() { return mApp; }
}
