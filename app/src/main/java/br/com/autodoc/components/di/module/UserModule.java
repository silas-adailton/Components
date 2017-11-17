package br.com.autodoc.components.di.module;

import br.com.autodoc.components.model.User;
import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Provides
    User providerUser() {
        return new User();
    }
}
