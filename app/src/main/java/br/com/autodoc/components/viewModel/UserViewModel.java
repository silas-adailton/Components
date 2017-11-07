package br.com.autodoc.components.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;
import java.util.logging.Handler;

import javax.inject.Inject;

import br.com.autodoc.components.data.Repositiry;
import br.com.autodoc.components.model.User;


public class UserViewModel extends ViewModel {
    private Repositiry repositiry;

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

}
