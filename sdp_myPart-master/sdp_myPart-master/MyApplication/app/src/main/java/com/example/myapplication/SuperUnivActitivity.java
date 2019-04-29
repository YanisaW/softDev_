package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.myapplication.Filter.SearchFilter;
import com.example.myapplication.Listview.*;
import com.example.myapplication.R;
import com.example.myapplication.javaSQL.SqliteHelper;

import java.io.IOException;
import java.util.ArrayList;

import com.example.myapplication.Defination.myConstatnt;

public class SuperUnivActitivity extends AppCompatActivity {

    private ArrayList<MyBlock> blockList = new ArrayList<>();
    private ArrayList<MyBlock> allBlock = new ArrayList<>();
    private SqliteHelper myDB;
    private SearchFilter searchFilter = new SearchFilter();
    private Myadapter myadapter;
    private ArrayList<map_block> mapList = new ArrayList<>();
    private  ArrayList<map_block> allMap = new ArrayList<>();
    protected ListView listView;


    class Myadapter extends abs_Myadapter {
        Myadapter(Context context, int layout, ArrayList<MyBlock> myBlockArrayList) {
            super(context, layout, myBlockArrayList);
        }

        @Override
        public void openMap() throws NoSuchMethodException {
            Intent intent = new Intent(SuperUnivActitivity.this,MapsActivity.class);
            /*intent.putExtra("lati_start", String.valueOf(map_block.class.getMethod("getLati_start", double.class)));
            intent.putExtra("longi_start",String.valueOf(map_block.class.getMethod("getLongi_start", double.class)));
            intent.putExtra("lati_dest",String.valueOf(map_block.class.getMethod("getLati_dest", double.class)));
            intent.putExtra("longi_dest",String.valueOf(map_block.class.getMethod("getLongi_dest", double.class)));*/
            startActivity(intent);
        }

        @Override
        public void openWeb() {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(getUrl()));
            startActivity(intent);
        }
    }

    ;

    protected void constructListView(Context context, int UNIV_CONST, int listviewID) {
        this.listView = findViewById(listviewID);
        myDB = new SqliteHelper(getBaseContext(), "UNIV_TABLE");
        try {
            myDB.createDB();
        } catch (IOException e) {
            throw new Error("Cannot Create Database");
        }
        try {
            myDB.openDB();

        } catch (SQLiteException e) {
            throw e;
        }

        Cursor line = myDB.getTable();
        line.moveToFirst();
        do {
            int uID = line.getInt(line.getColumnIndex("univ_id"));
            if (uID == UNIV_CONST) {
                int type = line.getInt(line.getColumnIndex("type"));

                String location = line.getString(line.getColumnIndex("location"));
                String availTime = line.getString(line.getColumnIndex("available_time"));
                String descript = line.getString(line.getColumnIndex("description")) + "\n\n" + "เวลาทำการ: " + availTime;

                Double lati_start = line.getDouble(line.getColumnIndex("start_latitude"));
                Double longi_start = line.getDouble(line.getColumnIndex("start_longitude"));
                Double lati_dest = line.getDouble(line.getColumnIndex("dest_latitude"));
                Double longi_dest = line.getDouble(line.getColumnIndex("dest_longitude"));

                MyBlock myBlock = new MyBlock(uID, type, location, descript/*, lati_start, longi_start, lati_dest, longi_dest*/);
                blockList.add(myBlock);

                map_block map = new map_block(lati_start, longi_start, lati_dest, longi_dest);
                mapList.add(map);

            }

        } while (line.moveToNext());

        allBlock.addAll(blockList);
        allMap.addAll(mapList);
        myadapter = new Myadapter(context, R.layout.btsspot_01, blockList);
        listView.setAdapter(myadapter);
    }
}
