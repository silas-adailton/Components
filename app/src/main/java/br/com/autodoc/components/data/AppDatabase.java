package br.com.autodoc.components.data;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import br.com.autodoc.components.data.pet.PetDao;
import br.com.autodoc.components.data.user.UserDAO;
import br.com.autodoc.components.model.Pet;
import br.com.autodoc.components.model.User;

@Database(entities = {User.class, Pet.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "usuario";

    private static final Object LOCK = new Object();
    private static AppDatabase sInstance;

    public static AppDatabase getsInstance(Context context) {
        Log.d(LOG_TAG, "Obtendo a instancia do BD");

        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .build();

                Log.d(LOG_TAG, "Criou um novo database");
            }
        }

        return sInstance;
    }

    public abstract UserDAO userDAO();
    public abstract PetDao petDao();
}
