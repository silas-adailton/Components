package br.com.autodoc.components.viewModel;


import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.model.UserFirebase;
import br.com.autodoc.components.model.UserInteractor;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Consumer;

public class ViewModelFirebase {

    private UserInteractor userInteractor;
    private ViewModelFirebaseContract.View view;

    @Inject
    public ViewModelFirebase(UserInteractor userInteractor, ViewModelFirebaseContract.View view) {
        this.userInteractor = userInteractor;
        this.view = view;
    }

    public void showListMessage() {

        userInteractor.listUser().subscribe(new Consumer<List<UserFirebase>>() {
            @Override
            public void accept(List<UserFirebase> list) throws Exception {
                view.showUserFirebase(list);
            }
        });
    }

    public void showListMessageTeste() {

        userInteractor.listUser().subscribe(new FlowableSubscriber<List<UserFirebase>>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(List<UserFirebase> list) {
                view.showUserFirebase(list);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });

//        userInteractor.listUserTeste().subscribe(new Consumer<List<UserFirebase>>() {
//            @Override
//            public void accept(List<UserFirebase> list) throws Exception {
//                view.showUserFirebase(list);
//            }
//        });
    }
}
