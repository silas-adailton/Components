package br.com.autodoc.components.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.data.Repositiry;
import br.com.autodoc.components.model.User;

public class ListUserViewModel extends ViewModel{

    private LiveData<List<User>> listUser;
    private Repositiry repositiry;

    @Inject
    public ListUserViewModel(Repositiry repositiry) {
        this.repositiry = repositiry;
    }

    public LiveData<List<User>> listUsers() {
       new Thread(new Runnable() {
           @Override
           public void run() {
               listUser = repositiry.getAll();
           }
       }).start();
      return listUser;
    }

}
