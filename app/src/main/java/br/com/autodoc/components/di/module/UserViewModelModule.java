package br.com.autodoc.components.di.module;


import android.arch.lifecycle.ViewModelProvider;

import br.com.autodoc.components.ViewModelFactory;
import br.com.autodoc.components.data.Repository;
import br.com.autodoc.components.viewModel.ListUserViewModel;
import br.com.autodoc.components.viewModel.UserViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class UserViewModelModule {

    @Provides
    UserViewModel providUserViewModel(Repository repository) {
        return new UserViewModel(repository);
    }

}
