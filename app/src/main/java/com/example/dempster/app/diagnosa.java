package com.example.dempster.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.example.dempster.app.R;

import java.util.ArrayList;
import java.util.List;

public class diagnosa extends AppCompatActivity {

    ListView listViewData;
    Button btnProses;
    ArrayAdapter<String> adapter;
    String[] arrayPeliculas = {"Nyeri Pada Lokasi Suntik",
            "Bengkak Dan Keram  Sekitar Vaksin","Demam","Muncul Rasa Gatal Pada Tubuh","Kemerahan Seluruh Tubuh","Jantung Berdebar-Debar",
            "Tekanan Darah Turun","Nafsu Makan Meningkat","Mudah Lelah","Sakit Kepala","Kesadaran Menurun"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosa);

        listViewData = findViewById(R.id.listview_data);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, arrayPeliculas);
        listViewData.setAdapter(adapter);
        btnProses = findViewById(R.id.btnProses);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Integer> dataPilihan = new ArrayList<>();
                String itemSelected = "Selected items : \n";
                if (listViewData.getCheckedItemCount() < 2) {
                    Toast.makeText(diagnosa.this, "Pilihan Diagnosa harus lebih dari 1", Toast.LENGTH_SHORT).show();
                } else {
                    for (int i = 0; i < listViewData.getCount(); i++) {
                        if (listViewData.isItemChecked(i)) {
                            dataPilihan.add(i);
                            itemSelected += listViewData.getItemAtPosition(i) + "\n";
                        }
                    }

                    Dempter h = new Dempter(dataPilihan);

                    Intent next = new Intent(diagnosa.this, HasilDiagnosa.class);
                    next.putExtra("penyakit", h.getDiagnosapenyakit());
                    next.putExtra("kalkulasi", h.persentase());
                    startActivity(next);
                }
            }
        });
    }
}