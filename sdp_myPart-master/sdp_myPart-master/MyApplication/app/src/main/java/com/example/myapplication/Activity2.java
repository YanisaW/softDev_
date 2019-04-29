package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button CU = findViewById(R.id.buttonCU);
        Button KMITL = findViewById(R.id.buttonKMITL);
        Button TU = findViewById(R.id.buttonTU);
        Button ThaiJP = findViewById(R.id.buttonTHJP);
        Button SPU = findViewById(R.id.buttonSPU);
        Button MU = findViewById(R.id.buttonMU);

        CU.setOnClickListener(this);
        KMITL.setOnClickListener(this);
        TU.setOnClickListener(this);
        ThaiJP.setOnClickListener(this);
        SPU.setOnClickListener(this);
        MU.setOnClickListener(this);
    }

    public void openCU(){   // Open CU spot
        Intent intent = new Intent(this,university_CU.class);
        startActivity(intent);
    }
    public void openKMITL(){   // Open KMITL spot
        Intent intent = new Intent(this,university_KMITL.class);
        startActivity(intent);
    }
    public void openTU(){   // Open TU spot
        Intent intent = new Intent(this,university_TU.class);
        startActivity(intent);
    }
    public void openTHJP(){   // Open Thai-Nichi spot
        //Intent intent = new Intent(this,Activity2.class);
        //startActivity(intent);
    }
    public void openSPU(){   // Open SPU spot
        Intent intent = new Intent(this,university_SPU.class);
        startActivity(intent);
    }
    public void openMU(){   // Open MU spot
        Intent intent = new Intent(this,university_MU.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonCU:
                openCU();
                break;
            case R.id.buttonKMITL:
                openKMITL();
                //Toast.makeText(this, "KMITL_Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonTU:
                openTU();
                break;
            case R.id.buttonTHJP:
                Toast.makeText(this, "ThaiNichi_Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSPU:
                openSPU();
                break;
            case R.id.buttonMU:
                openMU();
                break;

        }
    }


}
