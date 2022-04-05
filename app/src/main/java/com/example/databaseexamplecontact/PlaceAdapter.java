package com.example.databaseexamplecontact;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class PlaceAdapter extends BaseAdapter {
    private  List<Place> placeList;
    private    Context context;
  private  final int idLayout;

    public PlaceAdapter(Context context,List<Place> placeList, int idLayout) {
        this.placeList = placeList;
        this.context = context;
        this.idLayout = idLayout;
    }

    @Override
    public int getCount() {
        return placeList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view  = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout,viewGroup, false);
        }
        TextView name = (TextView) view.findViewById(R.id.tvwPlace);
        final Place place = placeList.get(i);
        name.setText(place.getName());
        return view;
    }
}
