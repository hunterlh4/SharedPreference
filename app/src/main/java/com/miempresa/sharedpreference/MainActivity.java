package com.miempresa.sharedpreference;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Spinner spTamaño;
    String[] itemTamaño;
    Spinner spFuente;
    String[] itemFuente;
    Spinner spColorStatus;
    Spinner spColorToolBar;
    Spinner spColorBackground;
    String[] itemcolor;
    private Window window;
    private Typeface font;
    private boolean isFirstTime = true;


    TextView tv1,tv2,tv3,tv4,tv5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spTamaño = (Spinner)findViewById(R.id.sp_sizeText);
        itemTamaño = getResources().getStringArray(R.array.ListaTamaño);
        spFuente = (Spinner)findViewById(R.id.sp_Source);
        itemFuente = getResources().getStringArray(R.array.ListaFuentes);
        spColorStatus = (Spinner)findViewById(R.id.sp_ColorStatus);
        itemcolor = getResources().getStringArray(R.array.Listacolor);
        spColorToolBar = (Spinner)findViewById(R.id.sp_ColorToolBar);
        spColorBackground = (Spinner)findViewById(R.id.sp_ColorBackground);

        tv1 = (TextView)findViewById(R.id.tv_tamaño) ;
        tv2 = (TextView)findViewById(R.id.tv_fuente) ;
        tv3 = (TextView)findViewById(R.id.tv_ColorStatus) ;
        tv4 = (TextView)findViewById(R.id.tv_ColorToolbar) ;
        tv5 = (TextView)findViewById(R.id.tv_colorBackground) ;




        this.window = getWindow();


            //TODO TAMAÑO
        ArrayAdapter<String> adapterTamaño = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item,itemTamaño);
        adapterTamaño.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTamaño.setAdapter(adapterTamaño);
        spTamaño.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (isFirstTime==true){
                    isFirstTime =false;
                }
                else {
                    String itemEscogido =  spTamaño.getSelectedItem().toString();
                    Float f= Float.parseFloat(itemEscogido);


                    if (position==0)
                    {
                    }else{
                        tv1.setTextSize(f);
                        tv2.setTextSize(f);
                        tv3.setTextSize(f);
                        tv4.setTextSize(f);
                        tv5.setTextSize(f);
                        ((TextView) parent.getChildAt(0)).setTextSize(f);




                    }
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //TODO FUENTE
        ArrayAdapter<String> adapterFuente = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item,itemFuente);
        adapterFuente.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFuente.setAdapter(adapterFuente);
        spFuente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isFirstTime==true){
                    isFirstTime =false;
                }
                else {
                    String itemEscogido ="fuentes/"+ spFuente.getSelectedItem().toString()+".ttf";

                    if (position==0)
                    {
                    }
                    else{

                        font = Typeface.createFromAsset(getAssets(), itemEscogido);

                        tv1.setTypeface(font);
                        tv2.setTypeface(font);
                        tv3.setTypeface(font);
                        tv4.setTypeface(font);
                        tv5.setTypeface(font);

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //TODO COLORSTATUS
        ArrayAdapter<String> adapterColorStatus = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item,itemcolor);
        adapterColorStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spColorStatus.setAdapter(adapterColorStatus);
        spColorStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isFirstTime==true){
                    isFirstTime =false;
                }
                else {
                    String itemEscogido =  spColorStatus.getSelectedItem().toString();
                    if (position==0)
                    {
                    }else{
                        window.setStatusBarColor (Color.parseColor(itemEscogido));
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //TODO COLORTOOLBAR
        ArrayAdapter<String> adapterColorToolbar = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item,itemcolor);
        adapterColorToolbar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spColorToolBar.setAdapter(adapterColorToolbar);
        spColorToolBar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isFirstTime==true){
                    isFirstTime =false;
                }
                else {
                    String itemEscogido =  spColorToolBar.getSelectedItem().toString();
                    if (position==0)
                    {
                    }else{

                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(itemEscogido)));
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //TODO COLOR BACKGROUND
        ArrayAdapter<String> adapterColorBackground = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item,itemcolor);
        adapterColorBackground.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spColorBackground.setAdapter(adapterColorBackground);
        spColorBackground.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (isFirstTime==true){
                    isFirstTime =false;
                }
                else {
                    String itemEscogido =  spColorBackground.getSelectedItem().toString();
                    if (position==0)
                    {
                    }else{
                        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor(itemEscogido)));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



}