package com.example.pati.mytrainingnprojecto.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.arch.persistence.room.OnConflictStrategy;

/**
 * Created by Pati on 08.08.2018.
 */

@Database(entities = {EventEntity.class}, version = 1)
public abstract class EventDatabase extends RoomDatabase {

    public EventDao eventDao;
    private static EventDatabase INSTANCE;

static EventDatabase getEventDatabase(final Context context){
    if(INSTANCE==null){
        synchronized (EventDatabase.class){
            if(INSTANCE==null){
                INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                        EventDatabase.class, "event_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
