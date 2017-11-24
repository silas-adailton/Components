package br.com.autodoc.components.di.module;

import android.arch.lifecycle.ViewModelProvider;

import br.com.autodoc.components.ViewModelFactory;
import br.com.autodoc.components.data.Repository;
import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelFactoryModule {

    @Provides
    ViewModelProvider.Factory providerFactory(Repository repositoryImpl) {

        return new ViewModelFactory(repositoryImpl);
    }
}
