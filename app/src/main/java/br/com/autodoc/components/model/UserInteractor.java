package br.com.autodoc.components.model;


import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.data.RepositoryFirebase;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class UserInteractor {

    private RepositoryFirebase repositoryFirebase;

    @Inject
    public UserInteractor(RepositoryFirebase repositoryFirebase) {
        this.repositoryFirebase = repositoryFirebase;
    }



    public Flowable<List<UserFirebase>> listMessage() {

        return repositoryFirebase.listUser()
                .flatMap(list -> Flowable.fromIterable(list))
                .sorted(new Comparator<UserFirebase>() {
                    @Override
                    public int compare(UserFirebase o1, UserFirebase o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                })
                .map(user -> {
                    user.setName(user.getName().toUpperCase());
                    return user;
                })
                .filter(user -> user.getName().contains(""))
                .toList().toFlowable();

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
