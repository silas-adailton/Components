package br.com.autodoc.components.viewModel;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import br.com.autodoc.components.data.Repository;
import br.com.autodoc.components.model.User;


public class UserViewModel extends ViewModel {
    private Repository repository;

    @Inject
    public UserViewModel( Repository repository) {
        this.repository = repository;
    }

    public void saveUser(String userName) {

        final User user = new User();
        user.setName(userName);
        new Thread(new Runnable() {
            @Override
            public void run() {
                repository.insertAll(user);
            }
        }).start();

    }

}
