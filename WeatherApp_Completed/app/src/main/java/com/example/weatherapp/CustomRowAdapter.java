package com.example.weatherapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CustomRowAdapter extends ArrayAdapter<String> {
    Context context;
    //Integer images;
    Integer[] images;
    ArrayList<String> weathers;
    ArrayList<String> winds;
    ArrayList<String> descriptions;
    ArrayList<String> dates;
    ArrayList<String> temperatures;


    public CustomRowAdapter(Context context, int layoutToBeInflated,
                            ArrayList<String> weathers, ArrayList<String> dates, ArrayList<String> descriptions,
                            ArrayList<String> temperatures, ArrayList<String> winds, Integer[] images) {

        super(context, R.layout.custom_row, weathers);
        this.context = context;
        this.images = images;
        this.weathers = weathers;
        this.winds = winds;
        this.descriptions = descriptions;
        this.dates = dates;
        this.temperatures = temperatures;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.custom_row, null);

        TextView tvDate;
        TextView tvWeather;
        TextView tvDescription;
        TextView tvTemperature;
        TextView tvWind;
        TextView tvTime;
        ImageView ivIcon;

        tvDate = (TextView) row.findViewById(R.id.tvDateFm);
        tvWeather = (TextView) row.findViewById(R.id.tvWeather);
        tvDescription = (TextView) row.findViewById(R.id.tvDescription);
        tvTemperature = (TextView) row.findViewById(R.id.tvTemperature);
        tvWind= (TextView) row.findViewById(R.id.tvWind);
        ivIcon = (ImageView) row.findViewById(R.id.ivWeather);

        tvWeather.setText(weathers.get(position));
        tvDescription.setText(descriptions.get(position));
        tvTemperature.setText(temperatures.get(position));
        tvDate.setText(dates.get(position));
        tvWind.setText(winds.get(position));
        ivIcon.setImageResource(images[position]);

        int colorSet;

        if(weathers.get(position).toLowerCase().contains("mưa"))
        {
            colorSet = Color.argb(50, 34, 37, 166);
            row.setBackgroundColor(colorSet);
        }
        else if(weathers.get(position).toLowerCase().contains("âm u"))
        {
            colorSet = Color.argb(50, 148, 88, 201);
            row.setBackgroundColor(colorSet);
        }
        else if(weathers.get(position).toLowerCase().contains("mây"))
        {
            colorSet = Color.argb(50, 46, 240, 211);
            row.setBackgroundColor(colorSet);
        }
        else
        {
            colorSet = Color.argb(100, 248, 233, 6);
            row.setBackgroundColor(colorSet);
        }

        row.invalidate();
        return row;
    }
}
