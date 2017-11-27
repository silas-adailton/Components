package br.com.autodoc.components.viewModel;

import android.arch.lifecycle.LiveData;

import java.util.List;

import br.com.autodoc.components.data.pet.RepositoryPet;
import br.com.autodoc.components.data.user.Repository;
import br.com.autodoc.components.model.Pet;
import br.com.autodoc.components.model.User;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.schedulers.Schedulers;


public class ViewModel extends android.arch.lifecycle.ViewModel {
    private Repository repository;
    private RepositoryPet repositoryPet;
    private User user = new User();

    public ViewModel(Repository repository, RepositoryPet repositoryPet) {
        this.repository = repository;
        this.repositoryPet = repositoryPet;
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

    public Completable savePetRx(Pet pet) {

        return new CompletableFromAction(new Action() {
            @Override
            public void run() throws Exception {

                repositoryPet.insertPet(pet);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public Flowable<List<Pet>> getPet() {
        return repositoryPet.getAllPet()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Completable deletePets(Pet pet) {

        return new CompletableFromAction(() -> {

            repositoryPet.delete(pet);
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
