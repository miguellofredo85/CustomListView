package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<CountryModelClass> {
    private ArrayList<CountryModelClass> countryArrayList;
    Context context;

    public CustomAdapter(ArrayList<CountryModelClass> data, Context context){
        super(context, R.layout.item_list_layout, data);
        this.countryArrayList = data;
        this.context = context;
    }

    private static class ViewHolder{
        TextView name_country, wins;
        ImageView flag_image;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CountryModelClass dataModel = getItem(position); // data from this position
        ViewHolder viewHolder;
    final View result;

    if(convertView == null){
        viewHolder = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(getContext());

        convertView = inflater.inflate(
                R.layout.item_list_layout,
                parent,
                false
                );

        viewHolder.name_country = (TextView) convertView.findViewById(R.id.textViewName);
        viewHolder.wins = (TextView) convertView.findViewById(R.id.textViewWins);
        viewHolder.flag_image = (ImageView) convertView.findViewById(R.id.imageView);

        result = convertView;
        convertView.setTag(viewHolder);
    }else {
        viewHolder = (ViewHolder) convertView.getTag();
        result = convertView;
    }

    viewHolder.name_country.setText(dataModel.getCountry_name());
    viewHolder.wins.setText(dataModel.getCup_win_count());
    viewHolder.flag_image.setImageResource(dataModel.getFlag_img());

    return convertView;
    }
}
