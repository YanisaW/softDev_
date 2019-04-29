package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.Defination.myConstatnt;

public class PurpleLine extends SuperSkytrainActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purple_line);

        // Spinner
        this.spinner = findViewById(R.id.items);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.purple,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //----------------------------------------------

        // RadioButton
        RadioButton cbMarket = (RadioButton) findViewById(R.id.marketCB);
        RadioButton cbRestaurant = (RadioButton) findViewById(R.id.restaurantCB);
        RadioButton cbNature = (RadioButton) findViewById(R.id.natureCB);
        RadioButton cbShopping = (RadioButton) findViewById(R.id.shoppingCB);
        RadioButton cbOthers = (RadioButton) findViewById(R.id.othersCB) ;
        Button searchButton  = (Button)findViewById(R.id.searchButton);

        cbMarket.setOnClickListener(this);
        cbRestaurant.setOnClickListener(this);
        cbNature.setOnClickListener(this);
        cbShopping.setOnClickListener(this);
        cbOthers.setOnClickListener(this);
        searchButton.setOnClickListener(this);

        this.constructListView(getBaseContext(), "VIOLET_MRT_TABLE", myConstatnt.VIOLET_CONST,R.id.violetPage);
    }

    // Spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        this.whenSpinnerSelected();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    //----------------------------------------------------------
    // RadioButton & Search button
    @Override
    public void onClick(View v) {
        this.whenClick(v);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.gc();
        finish();
    }
}
