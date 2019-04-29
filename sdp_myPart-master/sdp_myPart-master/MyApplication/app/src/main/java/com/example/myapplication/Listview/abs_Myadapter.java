package com.example.myapplication.Listview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.MapsActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

public abstract class abs_Myadapter extends ArrayAdapter {
    private Context mContext;
    private ArrayList<MyBlock> myBlockArrayList;
    private ArrayList<map_block> mapBlockArrayList;
    private int mLayout;
    private String url;

    public abs_Myadapter(Context context, int layout, ArrayList<MyBlock> myBlockArrayList) {
        super(context, layout, myBlockArrayList);
        this.myBlockArrayList = myBlockArrayList;
        //this.mapBlockArrayList = mapBlockArrayList;
        this.mContext = context;
        this.mLayout = layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            view = inflater.inflate(mLayout, parent, false);
        }

        MyBlock block = myBlockArrayList.get(position);

//            ImageView img = (ImageView) view.findViewById(R.id.LocationImageView);
//            img.setImageResource(block.getImage);

        TextView tvName = (TextView) view.findViewById(R.id.spotname);
        tvName.setText(block.getLocation());

        TextView tvDesc = (TextView) view.findViewById(R.id.info);
        tvDesc.setText(block.getDescript());


        //final String URL = "https://google.com/search?q=" + block.getLocation();

        block.setButton((Button) view.findViewById(R.id.ggMap));
        block.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                openMap();
            }
        });



        return view;
    }


    public abstract void openWeb();
    public abstract void openMap() throws NoSuchMethodException;

    public String getUrl() {
        return url;
    }
}