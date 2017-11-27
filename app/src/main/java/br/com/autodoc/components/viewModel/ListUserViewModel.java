package br.com.autodoc.components.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.data.user.Repository;
import br.com.autodoc.components.model.User;

public class ListUserViewModel extends ViewModel {

    private LiveData<List<User>> listUser = new MutableLiveData<>();
    private final Repository repositoryImpl;

    @Inject
    public ListUserViewModel(final Repository repositoryImpl) {
        this.repositoryImpl = repositoryImpl;

    }

    public LiveData<List<User>> getUsers() {
        listUser = repositoryImpl.getAll();
        return listUser;
    }
}
