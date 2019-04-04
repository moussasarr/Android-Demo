package com.example.connnectit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlaceAdapter extends ArrayAdapter<Place> {
    Context mContext;
    int mLayoutResourceId;
    Place[] mdata;

    public PlaceAdapter(Context context, int resource, Place[] data){
        super(context, resource, data);
        mContext = context;
        mLayoutResourceId = resource;
        mdata = data;
    }


    @Override
    public Place getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View row = convertView;
        PlaceHolder holder = null;

        //If we currently don' t have a row view to reuse

        if(row == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId, parent, false);

            holder = new PlaceHolder();
            holder.nameView = row.findViewById(R.id.row_title);
            holder.imageView = row.findViewById(R.id.row_img);
            holder.zipView = row.findViewById(R.id.row_text);
            row.setTag(holder);

        } else {
            holder = (PlaceHolder) row.getTag();

        }
        Place place = mdata[position];
        holder.nameView.setText(place.mNameOfPlace);
        holder.zipView.setText(String.valueOf(place.mZipCode));
        int resId = mContext.getResources().getIdentifier(place.mNameOfImage, "drawable", mContext.getPackageName());
        holder.imageView.setImageResource(resId);
        int rowPosition = position;
        holder.imageView.setTag(rowPosition);
        holder.imageView.setOnClickListener(PopupClickListener);

        return row;



//        LayoutInflater inflater = LayoutInflater.from(mContext);
//        row = inflater.inflate(mLayoutResourceId, parent, false);
//
//        TextView nameView = row.findViewById(R.id.row_title);
//        ImageView imageView = row.findViewById(R.id.row_img);
//        TextView zipView = row.findViewById(R.id.row_text);
//        Place place = mdata[position];
//
//        nameView.setText(place.mNameOfPlace);
//        zipView.setText(String.valueOf(place.mZipCode));
//        int resId = mContext.getResources().getIdentifier(place.mNameOfImage, "drawable", mContext.getPackageName());
//        imageView.setImageResource(resId);
//        return row;
    }


    View.OnClickListener PopupClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer viewPosition = (Integer) v.getTag();
            Place p = mdata[viewPosition];
            Toast.makeText(v.getContext(), p.mNameOfImage, Toast.LENGTH_SHORT).show();
        }
    };


    private static class PlaceHolder {
        TextView nameView;
        TextView zipView;
        ImageView imageView;
    }

}
