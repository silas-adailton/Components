package br.com.autodoc.components.model;


import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.data.user.RepositoryFirebase;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class UserInteractor {

    private RepositoryFirebase repositoryFirebase;

    @Inject
    public UserInteractor(RepositoryFirebase repositoryFirebase) {
        this.repositoryFirebase = repositoryFirebase;
    }



    public Flowable<List<UserFirebase>> listUser() {

        return repositoryFirebase.listUser()
                .flatMap(Flowable::fromIterable)
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .map(user -> {
                    user.setName(user.getName().toUpperCase());
                    return user;
                })
                .filter(user -> user.getName().contains(""))
                .toList().toFlowable();

    }


    public Observable<List<UserFirebase>> listUserTeste() {

        return repositoryFirebase.listMessage()
                .flatMap(Observable::fromIterable)
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .map(user -> {
                    user.setName(user.getName().toUpperCase());
                    return user;
                })
                .filter(user -> user.getName().contains(""))
                .toList().toObservable();

    }
    public static final class Request {

        private UserFirebase userFirebase;

        public Request(UserFirebase home) {
            this.userFirebase = home;
        }

        public UserFirebase getMessage() {
            return userFirebase;
        }


    }
}
