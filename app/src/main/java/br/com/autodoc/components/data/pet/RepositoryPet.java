package br.com.autodoc.components.data.pet;


import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.data.AppDatabase;
import br.com.autodoc.components.model.Pet;
import io.reactivex.Flowable;

public class RepositoryPet implements PetDao {

    private AppDatabase appDatabase;

    @Inject
    public RepositoryPet(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public Flowable<List<Pet>> getAllPet() {
        return appDatabase.petDao().getAllPet();
    }

    @Override
    public void insertPet(Pet... pet) {
        appDatabase.petDao().insertPet(pet);
    }

    @Override
    public void delete(Pet pet) {
        appDatabase.petDao().delete(pet);
    }
}
