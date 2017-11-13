package br.com.autodoc.components.di.module;

import br.com.autodoc.components.view.ListUserActivity;
import br.com.autodoc.components.view.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {UserViewModelModule.class})
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = {ListUserViewModelModule.class})
    abstract ListUserActivity contributeListUserActivity();
}
