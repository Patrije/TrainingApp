package com.example.pati.mytrainingnprojecto.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by Pati on 08.08.2018.
 */

public class DataRepository {

    private EventDao eventDao;
    private LiveData<List<EventEntity>> allEvents;

    DataRepository(Application application) {
        EventDatabase eventDatabase = EventDatabase.getEventDatabase(application);
        eventDao=eventDatabase.eventDao();
        allEvents=eventDao.getAllEvents();
    }

   LiveData<List<EventEntity>> getAllEvents(){
        return allEvents;
    }

    public void insert(EventEntity eventEntity){
        new insertAsyncTask(eventDao).execute(eventEntity);
    }
    private static class insertAsyncTask extends AsyncTask<EventEntity, Void, Void>{

        private EventDao asyncTaskDao;

        insertAsyncTask(EventDao dao){
            asyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final EventEntity... params){
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
