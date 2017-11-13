package br.com.autodoc.components.data;


import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.model.User;

public class Repositiry implements UserDAO {

    private AppDatabase appDatabase;

    @Inject
    public Repositiry(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public List<User> getAll() {
        return appDatabase.userDAO().getAll();
    }

    @Override
    public void insertAll(User... users) {
        appDatabase.userDAO().insertAll(users);
    }

    @Override
    public void delete(User user) {
        appDatabase.userDAO().delete(user);
    }
}
