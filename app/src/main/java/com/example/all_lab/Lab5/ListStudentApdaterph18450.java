package com.example.all_lab.Lab5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.all_lab.R;

import java.util.ArrayList;
import java.util.List;

public class ListStudentApdaterph18450 extends BaseAdapter implements Filterable {

    private final Context context;
    private  List<StudenModelph18450> lstSt;
    private final List<StudenModelph18450> lstStold;



    public ListStudentApdaterph18450(Context context, List<StudenModelph18450> lstSt) {
        this.context = context;
        this.lstStold= lstSt;
        this.lstSt = lstSt;
    }

    @Override
    public int getCount() {
        if (lstSt != null){
            return lstSt.size();
        }
        else {return 0;}

    }

    @Override
    public Object getItem(int position) {
        return lstSt.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txtNameSV, txtDiaChiSV,txtCoSo;
        Button btnUpdateSV,btnDeleteSV;
        LayoutInflater inflater = ((DSSVienActivity) context).getLayoutInflater();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_listview, parent, false);
        }


        txtCoSo = convertView.findViewById(R.id.txtCoSo);
        txtNameSV = convertView.findViewById(R.id.txtNameSV);
        txtDiaChiSV = convertView.findViewById(R.id.txtDiaChiSV);
        btnUpdateSV = convertView.findViewById(R.id.btnUpdateSV);
        btnDeleteSV = convertView.findViewById(R.id.btnDeleteSV);


        txtNameSV.setText("Họ tên: " + lstSt.get(position).getName());
        txtDiaChiSV.setText("Địa chỉ: " + lstSt.get(position).getAddress());
        txtCoSo.setText( lstSt.get(position).getBranch());

        btnDeleteSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lstSt.remove(position);
                notifyDataSetChanged();
                Toast.makeText(context,"Xóa thành công",Toast.LENGTH_LONG).show();
            }
        });

        btnUpdateSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context , AddSVActivity.class);
                StudenModelph18450 stedit = new StudenModelph18450(lstSt.get(position).getBranch(),lstSt.get(position).getName(),lstSt.get(position).getAddress());
                i.putExtra("editst",stedit);
                context.startActivity(i);
            }
        });
        return convertView;
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String s = constraint.toString();
                if (s.isEmpty()){
                    lstSt = lstStold;
                }else {
                    List<StudenModelph18450> lstS = new ArrayList<>();
                    for (StudenModelph18450 st : lstStold){
                    if (st.getName().toLowerCase().contains(s.toLowerCase())){
                        lstS.add(st);
                    }
                    }

                    lstSt = lstS;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = lstSt;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
            lstSt = (List<StudenModelph18450>) results.values;
            notifyDataSetChanged();
            }
        };
    }
}
