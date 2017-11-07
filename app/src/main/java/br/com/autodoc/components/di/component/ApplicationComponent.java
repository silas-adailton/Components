package br.com.autodoc.components.di.component;

import javax.inject.Singleton;

import br.com.autodoc.components.MainApplication;
import br.com.autodoc.components.di.module.ActivityBuilder;
import br.com.autodoc.components.di.module.ApplicationModule;
import br.com.autodoc.components.di.module.ListUserViewModelModule;
import br.com.autodoc.components.di.module.RepositoryModule;
import br.com.autodoc.components.di.module.UserViewModelModule;
import br.com.autodoc.components.viewModel.ListUserViewModel;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        ActivityBuilder.class,
        RepositoryModule.class,
        UserViewModelModule.class,
        ListUserViewModelModule.class
})
public interface ApplicationComponent extends AndroidInjector<MainApplication>{
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<MainApplication> {
    }

}
