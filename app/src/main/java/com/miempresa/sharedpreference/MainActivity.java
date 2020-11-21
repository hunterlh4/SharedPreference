package com.miempresa.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spTamaño;
    String[] itemTamaño;
    Spinner spFuente;
    String[] itemFuente;
    Spinner spColor;
    String[] itemColor;
    private Window window;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spTamaño = (Spinner)findViewById(R.id.sp_sizeText);
        itemTamaño = getResources().getStringArray(R.array.ListaTamaño);
        spFuente = (Spinner)findViewById(R.id.sp_Source);
        itemFuente = getResources().getStringArray(R.array.ListaFuentes);
        spColor = (Spinner)findViewById(R.id.sp_Color);
        itemColor = getResources().getStringArray(R.array.Listacolor);
        this.window = getWindow();

        ArrayAdapter<String> adapterTamaño = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item,itemTamaño);
        adapterTamaño.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTamaño.setAdapter(adapterTamaño);
        spTamaño.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> adapterFuente = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item,itemFuente);
        adapterFuente.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFuente.setAdapter(adapterFuente);
        spFuente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> adapterColor = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item,itemColor);
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spColor.setAdapter(adapterColor);
        spColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color =  spTamaño.getSelectedItem().toString();

                Toast.makeText(getApplicationContext(),color,Toast.LENGTH_LONG).show();


                window.setStatusBarColor(Color.parseColor(color));
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(color)));
                window.setBackgroundDrawable(new ColorDrawable(Color.parseColor(color)));
                window.setNavigationBarColor(Color.parseColor(color));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }
}