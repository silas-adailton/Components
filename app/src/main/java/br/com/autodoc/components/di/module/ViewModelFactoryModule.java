package br.com.autodoc.components.di.module;

import android.arch.lifecycle.ViewModelProvider;

import br.com.autodoc.components.ViewModelFactory;
import br.com.autodoc.components.data.pet.RepositoryPet;
import br.com.autodoc.components.data.user.Repository;
import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelFactoryModule {

    @Provides
    ViewModelProvider.Factory providerFactory(Repository repository, RepositoryPet repositoryPet) {

        return new ViewModelFactory(repository, repositoryPet);
    }
}
