package br.com.autodoc.components.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.data.Repositiry;
import br.com.autodoc.components.model.User;
import dagger.android.support.DaggerAppCompatActivity;

public class ListUserViewModel extends DaggerAppCompatActivity{

    Repositiry repositiry;
    List<User> listUser;// = new ArrayList<>();
//    private final LiveData<List<User>>listUserLive;

    @Inject
    public ListUserViewModel(Repositiry repositiry) {
        this.repositiry = repositiry;
//        listUserLive = repositiry.getAllLive();
    }

    public List<User> getUsers() {

      new Thread(new Runnable() {
          @Override
          public void run() {
              listUser = repositiry.getAll();
          }
      }).start();

      return listUser;


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                return listUserLive;
//            }
//        }).start();

//        return listUserLive;

    }

}
