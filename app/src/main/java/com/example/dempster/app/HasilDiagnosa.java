package com.example.dempster.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.dempster.app.R;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class HasilDiagnosa extends AppCompatActivity {
    Button btnKembali;
    TextView tvPenyakit, tvPersentase;
    ImageView gbrPenyakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_diagnosa);
        btnKembali = findViewById(R.id.btnKembali);
        tvPenyakit = findViewById(R.id.tvPenyakit);
        gbrPenyakit = findViewById(R.id.gbrPenyakit);
        tvPersentase = findViewById(R.id.tvPersentase);
        Bundle a = getIntent().getExtras();
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        double hasil = a.getDouble("kalkulasi");
        tvPersentase.setText(df.format((hasil * 100)) + "%");
        tvPenyakit.setText(a.getString("penyakit"));
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}