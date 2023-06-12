package com.example.stormvpgit.Model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(version = 6,entities = {Cart.class,Favorite.class,Shoes.class},exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase appDataBase;

    public static AppDataBase getAppDataBase(Context context) {
        if (appDataBase == null){
            appDataBase= Room.databaseBuilder(context,AppDataBase.class,"6")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDataBase;
    }
    public abstract AppDao getDao();
}
