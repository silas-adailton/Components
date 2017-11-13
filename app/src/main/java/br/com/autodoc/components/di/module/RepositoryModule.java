package br.com.autodoc.components.di.module;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import javax.inject.Singleton;

import br.com.autodoc.components.ViewModelFactory;
import br.com.autodoc.components.data.AppDatabase;
import br.com.autodoc.components.data.Repository;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    AppDatabase providerAppDatabase(Context context) {

        return AppDatabase.getsInstance(context);
    }

}
