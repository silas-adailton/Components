package br.com.autodoc.components;


import br.com.autodoc.components.di.component.DaggerApplicationComponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MainApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<MainApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().create(this);
    }
}
