package br.com.autodoc.components.di.module;


import br.com.autodoc.components.model.UserInteractor;
import br.com.autodoc.components.ui.MainActivity;
import br.com.autodoc.components.viewModel.ViewModelFirebaseContract;
import br.com.autodoc.components.viewModel.ViewModelFirebase;
import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelFirebaseModule {

    @Provides
    ViewModelFirebaseContract.View providerHomeView(MainActivity mainActivity) {
        return mainActivity;
    }

    @Provides
    ViewModelFirebase providerViewModelFirebase(UserInteractor userInteractor, ViewModelFirebaseContract.View view) {

        return new ViewModelFirebase(userInteractor, view);
    }
}
