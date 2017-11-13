package br.com.autodoc.components;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import br.com.autodoc.components.data.Repository;
import br.com.autodoc.components.viewModel.ListUserViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

   private final Repository repository;
    @Inject
    public ViewModelFactory(Repository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ListUserViewModel.class)) {

            return (T) new ListUserViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown class name ");
    }


}
