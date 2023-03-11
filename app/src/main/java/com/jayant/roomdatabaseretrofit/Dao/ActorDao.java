package com.jayant.roomdatabaseretrofit.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.jayant.roomdatabaseretrofit.Modal.Actor;
import com.jayant.roomdatabaseretrofit.Modal.Smartfolder;
import com.jayant.roomdatabaseretrofit.Modal.Urls;

import java.util.List;

@Dao
public interface ActorDao {
   /* @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Actor> actorList);

    @Query("SELECT * FROM actor")
    LiveData<List<Actor>> getAllActors();

    @Query("DELETE FROM actor")
    void deleteAll(); */


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Smartfolder> actorList);

    @Query("SELECT * FROM smart_folder")
    LiveData<List<Smartfolder>> getAllActors();

    @Query("DELETE FROM smart_folder")
    void deleteAll();
}
