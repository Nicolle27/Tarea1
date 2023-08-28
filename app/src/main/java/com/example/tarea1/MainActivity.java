package com.example.tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
private Spinner Escuela;
private Spinner Carrera;
private Spinner Cuota;
private TextView CostoCarrera;
private TextView CostoPension;
private TextView GastoAdi;
private TextView Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Escuela = (Spinner)findViewById(R.id.spinnerEscuela);
        Carrera = (Spinner)findViewById(R.id.spinnerCarrera);
        Cuota = (Spinner)findViewById(R.id.spinnerCuota);
        CostoCarrera = (TextView) findViewById(R.id.textCostCarrera);
        CostoPension = (TextView) findViewById(R.id.textPension);
        GastoAdi = (TextView) findViewById(R.id.textGasto);
        Total = (TextView) findViewById(R.id.textTotal);
        String [] CuotasSpinner= {"4","5","6"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CuotasSpinner);
        Cuota.setAdapter(adapter);

        String [] EscuelasSpinner= {"FIA","FCS","FACHIED"};
        ArrayAdapter <String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, EscuelasSpinner);
        Escuela.setAdapter(adapter1);

        Escuela.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedEscuela = EscuelasSpinner[position];

                int carrerasArrayId = getResources().getIdentifier("carreras_" + selectedEscuela.toLowerCase(), "array", getPackageName());
                String[] carrerasArray = getResources().getStringArray(carrerasArrayId);

                ArrayAdapter<String> adapterCarrera = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, carrerasArray);
                Carrera.setAdapter(adapterCarrera);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

    }
}