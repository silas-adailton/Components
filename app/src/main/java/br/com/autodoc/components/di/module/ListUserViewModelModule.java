package br.com.autodoc.components.di.module;

import br.com.autodoc.components.data.Repositiry;
import br.com.autodoc.components.viewModel.ListUserViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class ListUserViewModelModule {

    @Provides
    ListUserViewModel providerListUserViewModel( Repositiry repositiry) {

        return new ListUserViewModel(repositiry);
    }
}
