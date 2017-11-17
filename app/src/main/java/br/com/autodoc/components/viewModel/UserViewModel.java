package br.com.autodoc.components.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import br.com.autodoc.components.data.Repository;
import br.com.autodoc.components.model.User;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.schedulers.Schedulers;


public class UserViewModel extends ViewModel {
    private Repository repository;
    private User user = new User();

    public UserViewModel(Repository repository) {
        this.repository = repository;
    }

    public void saveUser(String userName) {

//        final User user = new User();
        user.setName(userName);
        new Thread(new Runnable() {
            @Override
            public void run() {
                repository.insertAll(user);
            }
        }).start();

    }

    public Completable saveUserRx(String name) {

        return new CompletableFromAction(new Action() {
            @Override
            public void run() throws Exception {
//                final User user = new User();
                user.setName(name);

                repository.insertAll(user);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public LiveData<List<User>> getListUser() {

        return repository.getAll();
    }

    public Flowable<List<User>> getUser() {
        return repository.getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Completable deleteUser(int id) {

        return new CompletableFromAction(() -> {
//            final User user = new User();
            user.setId(id);
            repository.delete(user);
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
