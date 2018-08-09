package com.example.pati.mytrainingnprojecto.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Pati on 08.08.2018.
 */
@Entity(tableName = "event_table")
public class EventEntity {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;

    public EventEntity(long id, String name){
        this.id=id;
        this.name=name;
    }

    public long getId(){
        return this.id;
    }

    public String name(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventEntity that = (EventEntity) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
