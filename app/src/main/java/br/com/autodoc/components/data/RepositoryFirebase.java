package br.com.autodoc.components.data;


import java.util.List;

import br.com.autodoc.components.model.UserFirebase;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public interface RepositoryFirebase {

    Observable<List<UserFirebase>> listMessage();
    Flowable<List<UserFirebase>> listUser();
}
