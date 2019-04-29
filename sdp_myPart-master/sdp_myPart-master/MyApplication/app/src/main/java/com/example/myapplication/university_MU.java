package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Defination.myConstatnt;

public class university_MU extends SuperUnivActitivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university__mu);

        Button buttonHome = findViewById(R.id.homeMU);
        buttonHome.setOnClickListener(this);

        this.constructListView(getBaseContext(), myConstatnt.MU_CONT,R.id.muLV);
    }
    public void openHome(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homeMU:
                openHome();
                //Toast.makeText(this, "market_checked", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
