package br.com.autodoc.components.di.module;


import br.com.autodoc.components.data.Repositiry;
import br.com.autodoc.components.viewModel.UserViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class UserViewModelModule {

    @Provides
    UserViewModel providUserViewModel(Repositiry repositiry) {
        return new UserViewModel(repositiry);
    }
}
