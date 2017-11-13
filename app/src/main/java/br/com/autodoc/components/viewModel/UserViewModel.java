package br.com.autodoc.components.viewModel;

import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.data.Repositiry;
import br.com.autodoc.components.model.User;


public class UserViewModel extends ViewModel {
    Repositiry repositiry;
    private List<User> listUsers;

    @Inject
    public UserViewModel( Repositiry repositiry) {
        this.repositiry = repositiry;
    }

    public void saveUser(String userName) {

        final User user = new User();
        user.setName(userName);
        new Thread(new Runnable() {
            @Override
            public void run() {
                repositiry.insertAll(user);
            }
        }).start();

    }

    public List<User> getUsers() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                listUsers = repositiry.getAll();
            }
        }).start();

        return listUsers;
    }

}
