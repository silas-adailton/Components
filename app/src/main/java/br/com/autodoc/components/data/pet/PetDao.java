package br.com.autodoc.components.data.pet;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.autodoc.components.model.Pet;
import io.reactivex.Flowable;

@Dao
public interface PetDao {

    @Query("SELECT * FROM pet")
    Flowable<List<Pet>> getAllPet();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPet(Pet...pet);

    @Delete
    void delete(Pet pet);

}
