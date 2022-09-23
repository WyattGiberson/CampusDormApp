package com.hfad.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner dormSpin = findViewById(R.id.dormSpin);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.halls_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        dormSpin.setAdapter(adapter);

        Spinner mealSpin = findViewById(R.id.mealSpin);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.meal_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mealSpin.setAdapter(adapter2);

        Button btn = (Button) findViewById(R.id.calcCost);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hall = (String)dormSpin.getSelectedItem();
                String prices = (String)mealSpin.getSelectedItem();
                int hallPrice = 0, mealPrice = 0, price = 0;

               if(hall.equals("Allen Hall")) {
                    hallPrice = 1800;
                }
               else if(hall.equals("Pike Hall")){
                    hallPrice = 2200;
                }
               else if(hall.equals("Farthing Hall")){
                   hallPrice = 2800;
                }
               else if(hall.equals("University Suites")){
                   hallPrice = 3000;
               }

               if(prices.equals("7 meals per week")){
                   mealPrice = 600;
               }
               else if(prices.equals("14 meals per week")){
                    mealPrice = 1100;
               }
               else if(prices.equals("Unlimited meals per week")){
                    mealPrice = 1800;
               }

                price = hallPrice + mealPrice;
                Button btn = (Button) findViewById(R.id.calcCost);
                TextView textViewToChange = (TextView) findViewById(R.id.totalTxt);
                textViewToChange.setText("$" + price);
            }
        });
    }
}
