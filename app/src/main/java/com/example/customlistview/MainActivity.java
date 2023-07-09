package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<CountryModelClass> dataModels;
    private static CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//adapter view : listView
    listView = findViewById(R.id.listView);
// data source
    dataModels = new ArrayList<>();
        dataModels.add(new CountryModelClass("brazil", "5", R.drawable.brazil));
        dataModels.add(new CountryModelClass("alemania", "4", R.drawable.germany));
        dataModels.add(new CountryModelClass("france", "2", R.drawable.france));
        dataModels.add(new CountryModelClass("spain", "1", R.drawable.spain));
        dataModels.add(new CountryModelClass("unitedkingdom", "1", R.drawable.unitedkingdom));
        dataModels.add(new CountryModelClass("saudiarabia", "0", R.drawable.saudiarabia));
        dataModels.add(new CountryModelClass("unitedstates", "0", R.drawable.unitedstates));


//adapter
        adapter = new CustomAdapter(dataModels, getApplicationContext());

        listView.setAdapter(adapter);

        // handling events on listView items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Equipo: " + adapter.getItem(i).getCountry_name() + "\n" + "Titulos: " + adapter.getItem(i).getCup_win_count(), Toast.LENGTH_LONG).show();
            }
        });
    }
}