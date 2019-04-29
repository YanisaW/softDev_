package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCalculate = findViewById(R.id.button1);
        Button buttonUniversity = findViewById(R.id.button2);
        Button buttonMrt = findViewById(R.id.button3);
        Button buttonArl = findViewById(R.id.button4);
        Button buttonPurpleLine = findViewById(R.id.button5);
        Button buttonBts = findViewById(R.id.button6);
        Button buttonMinibus = findViewById(R.id.button7);
        Button buttonbus = findViewById(R.id.button8);

        buttonCalculate.setOnClickListener(this);
        buttonUniversity.setOnClickListener(this);
        buttonMrt.setOnClickListener(this);
        buttonArl.setOnClickListener(this);
        buttonPurpleLine.setOnClickListener(this);
        buttonBts.setOnClickListener(this);
        buttonMinibus.setOnClickListener(this);
        buttonbus.setOnClickListener(this);

        /* buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });  */
    }

    public void openActivity1(){   // Calculate fee
        //Intent intent = new Intent(this,Activity2.class);
        //startActivity(intent);
    }
    public void openActivity2(){   // University Spot
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }
    public void openActivity3(){   // MRT
        Intent intent = new Intent(this,MRT.class);
        startActivity(intent);
    }
    public void openActivity4(){   // ARL
        Intent intent = new Intent(this,ARL.class);
        startActivity(intent);
    }
    public void openActivity5(){   // PurpleLine
        Intent intent = new Intent(this,PurpleLine.class);
        startActivity(intent);
    }
    public void openActivity6(){   // BTS
        //Toast.makeText(this,"BTS_Clicked",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,testComponent.class);
        startActivity(intent);
    }
    public void openActivity7(){   // Minibus-SongTaew
        //Intent intent = new Intent(this,Activity2.class);
        //startActivity(intent);
    }
    public void openActivity8(){   // Bus
        //Intent intent = new Intent(this,Activity2.class);
        //startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                Toast.makeText(this,"CalculatedFee_Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2: // UniversityMenu
                openActivity2();
                break;
            case R.id.button3: //MRT
                openActivity3();
                break;
            case R.id.button4: // ARL
                openActivity4();
                break;
            case R.id.button5: // Purple line
                //Toast.makeText(this,"PurpleLine_Clicked",Toast.LENGTH_SHORT).show();
                openActivity5();
                break;
            case R.id.button6: // BTS
                openActivity6();
                break;
            case R.id.button7:
                Toast.makeText(this,"Minibus_Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button8:
                Toast.makeText(this,"Bus_Clicked",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
