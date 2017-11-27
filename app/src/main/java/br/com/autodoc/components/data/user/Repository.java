package br.com.autodoc.components.data.user;


import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.data.AppDatabase;
import br.com.autodoc.components.model.User;
import io.reactivex.Flowable;

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
    public Flowable<List<User>> getUser() {
        return appDatabase.userDAO().getUser();
    }

    @Override
    public void insertAll(User... userEntities) {
        appDatabase.userDAO().insertAll(userEntities);
    }

    @Override
    public void delete(User user) {
        appDatabase.userDAO().delete(user);
    }
}
