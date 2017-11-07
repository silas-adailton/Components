package br.com.autodoc.components.di.module;

import android.content.Context;

import br.com.autodoc.components.MainApplication;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    Context provideContext(MainApplication application) {
        return application.getApplicationContext();
    }
}
