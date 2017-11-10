package br.com.autodoc.components;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import br.com.autodoc.components.viewModel.ListUserViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private ListUserViewModel listUserViewModel;

    @Inject
    public ViewModelFactory(ListUserViewModel listUserViewModel) {
        this.listUserViewModel = listUserViewModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(listUserViewModel.getClass())) {

            return (T) listUserViewModel;
        }
        throw new IllegalArgumentException("Unknown class name ");
    }
}
