package com.example.dempster.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.dempster.app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pindah(View view) {
        Intent intent = new Intent(MainActivity.this, data_informasi.class);
        startActivity(intent);
    }

    public void pindah2(View view) {
        Intent intent = new Intent(MainActivity.this, data_gejala.class);
        startActivity(intent);
    }

    public void pindah3(View view) {
        Intent intent = new Intent(MainActivity.this, diagnosa.class);
        startActivity(intent);
    }
    public void bantuan(View view) {
        Intent intent = new Intent(MainActivity.this, bantuan.class);
        startActivity(intent);
    }
}
