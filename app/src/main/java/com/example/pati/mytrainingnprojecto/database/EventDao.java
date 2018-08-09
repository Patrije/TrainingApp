package com.example.pati.mytrainingnprojecto.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Pati on 08.08.2018.
 */

@Dao
public interface EventDao {

    @Insert
    void insert(EventEntity eventEntity);

    @Insert
    void insert(List<EventEntity> eventsList);

    @Query("DELETE FROM event_table")
    void deleteAll();

    @Query("SELECT *FROM event_table")
    LiveData<List<EventEntity>> getAllEvents();


}
