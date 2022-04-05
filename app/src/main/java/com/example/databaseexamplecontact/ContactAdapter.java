package com.example.databaseexamplecontact;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    private List<Contact> list;
    private Context context;
    private final int idlayout;
    private int selectedIndex = -1;

    public ContactAdapter(Context context, int idlayout, List<Contact> list){
        this.context = context;
        this.idlayout = idlayout;
        this.list = list;
    }

    @Override
    public int getCount() {
            return list.size();
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
            view  = LayoutInflater.from(viewGroup.getContext()).inflate(idlayout,viewGroup, false);
        }
        TextView name = (TextView) view.findViewById(R.id.twName);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.idLayoutContact);
        final ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.idConstrantLayout);

        final Contact contact = list.get(i);
        name.setText(contact.getName());

        if(view.isSelected()){
            selectedIndex = i;
        }
        if(selectedIndex==i)
            constraintLayout.setBackgroundColor(Color.YELLOW);
        else
            constraintLayout.setBackgroundColor(Color.WHITE);

        return view;
    }
}
