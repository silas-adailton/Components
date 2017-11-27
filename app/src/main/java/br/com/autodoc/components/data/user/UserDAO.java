package br.com.autodoc.components.data.user;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.autodoc.components.model.User;
import io.reactivex.Flowable;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM User")
    LiveData<List<User>> getAll();

    @Query("SELECT * FROM User")
    Flowable<List<User>> getUser();

    @Insert
    void insertAll(User... userEntities);

    @Delete
    void delete(User user);
}
