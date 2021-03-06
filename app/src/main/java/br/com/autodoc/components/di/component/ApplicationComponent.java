package br.com.autodoc.components.di.component;

import javax.inject.Singleton;

import br.com.autodoc.components.MainApplication;
import br.com.autodoc.components.di.module.ActivityBuilder;
import br.com.autodoc.components.di.module.ApplicationModule;
import br.com.autodoc.components.di.module.FirebaseModule;
import br.com.autodoc.components.di.module.RepositoryModule;
import br.com.autodoc.components.di.module.UserModule;
import br.com.autodoc.components.di.module.ViewModelFirebaseModule;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        ActivityBuilder.class,
        RepositoryModule.class,
        UserModule.class,
        FirebaseModule.class,
        ViewModelFirebaseModule.class
})
public interface ApplicationComponent extends AndroidInjector<MainApplication>{
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<MainApplication> {
    }

}
