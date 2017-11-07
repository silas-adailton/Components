package br.com.autodoc.components.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.data.Repositiry;
import br.com.autodoc.components.model.User;

public class ListUserViewModel extends ViewModel{

    private Repositiry repositiry;
    private LiveData<List<User>> listUser;

    @Inject
    public ListUserViewModel(LiveData<List<User>> listUser, Repositiry repositiry) {
        this.listUser = listUser;
        this.repositiry = repositiry;
    }

    public LiveData<List<User>> listUser() {

      return listUser = (LiveData<List<User>>) repositiry.getAll();
    }

}
