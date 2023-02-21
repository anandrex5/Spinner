package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Spinner spinner;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);

        spinner = findViewById(R.id.spinnerCountry);

        //create an adapter from resource because we need adapter transfer information Array to
        //Spinner we need to create an Adapter
        adapter = ArrayAdapter.createFromResource(this,R.array.countries, android.R.layout.simple_spinner_item);

        //set dropDownViewResource
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //set adapter
        spinner.setAdapter(adapter);

        //now we select from something from the spinner it will shown on textView

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //creating an new string which name is Country
                String country = parent.getItemAtPosition(position).toString();

                //set as an result to selected country from spinner
                result.setText(country);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}