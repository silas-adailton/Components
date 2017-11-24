package br.com.autodoc.components.di.module;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.autodoc.components.data.RepositoryFirebase;
import br.com.autodoc.components.data.RepositoryFirebaseImpl;
import dagger.Module;
import dagger.Provides;


@Module
public class FirebaseModule {
    @Provides
    DatabaseReference getDataBaseReference() {
        return FirebaseDatabase.getInstance().getReference();
    }

    @Provides
    RepositoryFirebase getRepository(DatabaseReference databaseReference) {
        return new RepositoryFirebaseImpl(databaseReference);
    }

}
