package br.com.autodoc.components.di.module;

import android.arch.lifecycle.ViewModelProvider;

import br.com.autodoc.components.ViewModelFactory;
import br.com.autodoc.components.data.Repository;
import br.com.autodoc.components.viewModel.ListUserViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class ListUserViewModelModule {

//    @Provides
//    ListUserViewModel providerListUserViewModel(Repository repository) {
//
//        return new ListUserViewModel(repository);
//    }

    @Provides
    ViewModelProvider.Factory provideViewModelFactory(Repository repository){
        return new ViewModelFactory(repository);
    }
}
