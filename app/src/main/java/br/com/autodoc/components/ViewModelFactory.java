package br.com.autodoc.components;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import br.com.autodoc.components.viewModel.UserViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private UserViewModel userViewModel;

    public ViewModelFactory(UserViewModel userViewModel) {
        this.userViewModel = userViewModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(UserViewModel.class)) {
            return (T) userViewModel ;
        }

        throw new IllegalArgumentException("Unknown class name");

    }
}
