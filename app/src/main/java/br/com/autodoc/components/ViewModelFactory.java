package br.com.autodoc.components;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import br.com.autodoc.components.data.Repository;
import br.com.autodoc.components.data.RepositoryFirebase;
import br.com.autodoc.components.viewModel.ListUserViewModel;
import br.com.autodoc.components.viewModel.UserViewModel;

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
        else if (modelClass.isAssignableFrom(UserViewModel.class)) {
            return (T) new UserViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown class name ");
    }

//    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;
//
//    @Inject
//    public ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
//        this.creators = creators;
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public <T extends ViewModel> T create(Class<T> modelClass) {
//        Provider<? extends ViewModel> creator = creators.get(modelClass);
//        if (creator == null) {
//            for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : creators.entrySet()) {
//                if (modelClass.isAssignableFrom(entry.getKey())) {
//                    creator = entry.getValue();
//                    break;
//                }
//            }
//        }
//        if (creator == null) {
//            throw new IllegalArgumentException("unknown model class " + modelClass);
//        }
//        try {
//            return (T) creator.get();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }


}
