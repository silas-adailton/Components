package br.com.autodoc.components.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.data.Repository;
import br.com.autodoc.components.model.User;

public class ListUserViewModel extends ViewModel {

    private LiveData<List<User>> listUser = new MutableLiveData<>();
//    private List<User> list;
    private final Repository repository;

//    public ListUserViewModel() {
//    }

    @Inject
    public ListUserViewModel(final Repository repository) {
        this.repository = repository;


        new Thread(new Runnable() {
            @Override
            public void run() {
                listUser = repository.getAll();
            }
        }).start();
    }

//    public LiveData<List<User>> getUsers() {
//       new Thread(new Runnable() {
//           @Override
//           public void run() {
//               listUser = repository.getAll();
//           }
//       }).start();
//      return listUser;
//    }

    public LiveData<List<User>> getUsers() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                    list = repository.getAll();
//
//            }
//        }).start();
        return listUser;
    }
}
