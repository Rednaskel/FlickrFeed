package com.malak.yaim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.malak.yaim.di.components.AppComponent;

public abstract class BaseActivity extends AppCompatActivity {

  public abstract void initializeInjector();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initializeInjector();
  }

  protected AppComponent getApplicationComponent() {
    return ((YAIMApplication) getApplication()).getAppComponent();
  }
}
