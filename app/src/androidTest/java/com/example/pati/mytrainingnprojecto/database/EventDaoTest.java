package com.example.pati.mytrainingnprojecto.database;

import android.app.usage.UsageEvents;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.pati.mytrainingnprojecto.LiveDataTestUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Pati on 08.08.2018.
 */

@RunWith(AndroidJUnit4.class)
public class EventDaoTest {

private EventDatabase eventDatabase;
private EventDao theeventDao;

    @Before
    public void setUp() throws Exception {
        Context context= InstrumentationRegistry.getTargetContext();
        eventDatabase= Room.inMemoryDatabaseBuilder(context,EventDatabase.class).build();
        theeventDao=eventDatabase.eventDao();
    }

    @Test
    public void getAllEvents() throws InterruptedException {
        EventEntity eventEntity= new EventEntity(1,"first_event");
        theeventDao.insert(eventEntity);
        List<EventEntity> eventList= LiveDataTestUtil.getValue(theeventDao.getAllEvents());
        assertEquals(eventEntity,eventList.get(0));
    }

    @After
    public void tearDown() throws Exception {
    }

}