package br.com.autodoc.components.data;


import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.model.User;

public class Repository implements UserDAO {

    private AppDatabase appDatabase;

    @Inject
    public Repository(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public LiveData<List<User>> getAll() {
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
