package br.com.autodoc.components.di.module;

import android.content.Context;

import br.com.autodoc.components.data.AppDatabase;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    private AppDatabase appDatabase;

    @Provides
    AppDatabase providerAppDatabase(Context context) {
        appDatabase = AppDatabase.getsInstance(context);

        return appDatabase;
    }

}
