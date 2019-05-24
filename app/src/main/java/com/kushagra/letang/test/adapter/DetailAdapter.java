package com.kushagra.letang.test.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.kushagra.letang.test.R;
import com.kushagra.letang.test.model.Details;

import java.util.List;

public class DetailAdapter extends BaseAdapter {

    Activity activity;
    List<Details> lstDetails;
    LayoutInflater inflater;
    EditText edtId,edtLat,edtLng,edtAlt;
    EditText edtPradesh,edtJilla,edtNagarpalika,edtWard,edtBasti,edtTole,edtSadak,edtCode;
    String jati,vasa,dharma;

    public DetailAdapter(
            Activity activity,
            List<Details> lstDetails,
            EditText edtId,
            EditText edtLat,
            EditText edtLng,
            EditText edtAlt,
            EditText edtPradesh,
            EditText edtJilla,
            EditText edtNagarpalika,
            EditText edtWard,
            EditText edtBasti,
            EditText edtTole,
            EditText edtSadak,
            String jati,
            String vasa,
            String dharma

    )
    {
        this.activity = activity;
        this.lstDetails = lstDetails;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.edtId = edtId;
        this.edtLat = edtLat;
        this.edtLng = edtLng;
        this.edtAlt = edtAlt;
        this.edtPradesh = edtPradesh;
        this.edtJilla = edtJilla;
        this.edtNagarpalika = edtNagarpalika;
        this.edtWard = edtWard;
        this.edtBasti = edtBasti;
        this.edtTole = edtTole;
        this.edtSadak = edtSadak;
        //this.edtCode = edtCode;
        this.jati = jati;
        this.vasa = vasa;
        this.dharma = dharma;
    }

    @Override
    public int getCount() {
        return lstDetails.size();
    }

    @Override
    public Object getItem(int i) {
        return lstDetails.get(i);
    }

    @Override
    public long getItemId(int i) {
        return lstDetails.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View rowView = inflater.inflate(R.layout.row,null);

        final TextView
                txtRowId,
                txtRowLat,
                txtRowWard,
                txtGharCode;
//                txtRowOwner;

        //final TextView txtRowPradesh;

        txtRowId = (TextView)rowView.findViewById(R.id.row_id);
       //txtGharCode = (TextView)rowView.findViewById(R.id.row_code);
        txtRowLat = (TextView)rowView.findViewById(R.id.row_lat);
//        txtRowWard = (TextView)rowView.findViewById(R.id.row_ward);
//        txtRowOwner = (TextView)rowView.findViewById(R.id.row_owner);


        txtRowId.setText(""+lstDetails.get(i).getId());
//        txtRow.setText(""+lstDetails.get(i).getId());
        txtRowLat.setText(""+lstDetails.get(i).getLatitude());
        //txtGharCode.setText(""+lstDetails.get(i).getHouseCode());
        //Log.d("HELLO3",lstDetails.get(i).getLatitude());
        //txtRowLng.setText(""+lstDetails.get(i).getLongitude());
        //Log.d("HELLO4",lstDetails.get(i).getLongitude());
        //txtRowAlt.setText(""+lstDetails.get(i).getAltitude());
        //txtRowPradesh.setText(""+lstDetails.get(i).getPradesh());
        //txtRowJila.setText(""+lstDetails.get(i).getJilla());
        //txtRowNagarpalika.setText(""+lstDetails.get(i).getNagarpalika());
        //txtRowWard.setText(""+lstDetails.get(i).getWard());
        //Log.d("HELLOWARD1",lstDetails.get(i).getLatitude());
        //txtRowBasti.setText(""+lstDetails.get(i).getBasti());
        //txtRowJati.setText(""+lstDetails.get(i).getJati());
        //txtGharCode.setText(""+lstDetails.get(i).getHouseCode());



        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtId.setText(""+txtRowId.getText());
//                edtLat.setText(""+txtRowLat.getText());
//                edtLng.setText(""+txtRowLng.getText());
//                edtAlt.setText(""+txtRowAlt.getText());
//                edtPradesh.setText(""+txtRowPradesh.getText());
//                edtJilla.setText(""+txtRowJati.getText());
//                edtNagarpalika.setText(""+txtRowNagarpalika.getText());
//                edtWard.setText(""+txtRowWard.getText());
//                edtBasti.setText(""+txtRowBasti.getText());



            }
        });



        return rowView;
    }
}
