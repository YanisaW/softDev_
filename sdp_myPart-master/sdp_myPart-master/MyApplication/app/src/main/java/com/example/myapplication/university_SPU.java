package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Defination.myConstatnt;

public class university_SPU extends SuperUnivActitivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university__spu);

        Button buttonHome = findViewById(R.id.homeSPU);
        buttonHome.setOnClickListener(this);

        this.constructListView(getBaseContext(), myConstatnt.SPU_CONT,R.id.spuLV);
    }

    public void openHome(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homeSPU:
                openHome();
                //Toast.makeText(this, "market_checked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
