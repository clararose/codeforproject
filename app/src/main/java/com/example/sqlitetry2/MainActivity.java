package com.example.sqlitetry2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("creating dbhandler");
        lst = (TextView) findViewById(R.id.list);
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 2);
        lst.setText(dbHandler.loadHandler());
    }
}