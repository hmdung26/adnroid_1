package com.example.all_lab.Lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.all_lab.R;

import java.util.ArrayList;

public class SchoolSpinnerAdapter_dunghmph18450 extends BaseAdapter {

        private final Context context;
        private final ArrayList<SchoolModel> lst;

    public SchoolSpinnerAdapter_dunghmph18450(Context context, ArrayList<SchoolModel> lst) {
        this.context = context;
        this.lst = lst;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return lst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater = ((AddSVActivity) context).getLayoutInflater();
        convertView = layoutInflater.inflate(R.layout.item_spinner, parent,false);

        ImageView imgItemSpiner = convertView.findViewById(R.id.imgItemSpiner);
        TextView txtItemSpiner = convertView.findViewById(R.id.txtItemSpiner);

        imgItemSpiner.setImageResource(lst.get(position).getImage());
        txtItemSpiner.setText("FPoly " + lst.get(position).getName());

        return convertView;
    }
}
