package br.com.autodoc.components.di.module;

import br.com.autodoc.components.ui.ListUserActivity;
import br.com.autodoc.components.ui.MainActivity;
import br.com.autodoc.components.viewModel.ListUserViewModel;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {UserViewModelModule.class})
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = {ListUserViewModelModule.class})
    abstract ListUserActivity contributeListUserActivity();

//    @ContributesAndroidInjector(modules = {RepositoryModule.class})
//    abstract ListUserViewModel contributeListUserViewModel();
}
