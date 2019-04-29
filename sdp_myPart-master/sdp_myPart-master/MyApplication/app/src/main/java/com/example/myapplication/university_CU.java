package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Defination.myConstatnt;

public class university_CU extends SuperUnivActitivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university__cu);

        Button buttonHome = findViewById(R.id.homeCU);
        buttonHome.setOnClickListener(this);

        this.constructListView(getBaseContext(), myConstatnt.CU_CONST,R.id.cuLV);
    }

    public void openHome(){   // Calculate fee
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homeCU:
                openHome();
                break;
        }
    }
}
