package com.example.myapplication.Filter;

import com.example.myapplication.Listview.MyBlock;

import java.util.ArrayList;

public class SearchFilter {
    private int selectedStation = 1;
    private int typeLocation = 1;

    public SearchFilter() {
    }

    public int getSelectedStation() {
        return selectedStation;
    }

    public void setSelectedStation(int selectedStation) {
        this.selectedStation = selectedStation;
    }

    public int getTypeLocation() {
        return typeLocation;
    }

    public void setTypeLocation(int typeLocation) {
        this.typeLocation = typeLocation;
    }

    public void filtering(ArrayList<MyBlock> bufferList, ArrayList<MyBlock> allBlocksList) {
        bufferList.clear();
        for (MyBlock block : allBlocksList) {
            if (block.getStatinID() == this.selectedStation && block.getType() == this.typeLocation) {
                bufferList.add(block);
            }
        }
    }

    @Override
    public String toString() {
        return
                "selectedStation=" + selectedStation +
                        "\ntypeLocation=" + typeLocation
                ;
    }
}
