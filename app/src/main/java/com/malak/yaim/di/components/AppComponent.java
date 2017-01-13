package com.malak.yaim.di.components;

import android.content.Context;
import com.malak.yaim.di.modules.AppModule;
import com.malak.yaim.di.scopes.PerApp;
import dagger.Component;

@PerApp
@Component(modules = AppModule.class)
public interface AppComponent {
  Context context();
}
