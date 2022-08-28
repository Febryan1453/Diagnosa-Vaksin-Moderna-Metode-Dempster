package com.example.dempster.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.dempster.app.R;

public class data_informasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void pindahHome(View view) {
//        Intent intent = new Intent(MainActivity.this, data_informasi.class);
//        startActivity(intent);
        finish();
    }
}