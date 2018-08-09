package com.example.pati.mytrainingnprojecto;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pati.mytrainingnprojecto.database.EventDao;
import com.example.pati.mytrainingnprojecto.database.EventDatabase;
import com.example.pati.mytrainingnprojecto.database.EventEntity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
