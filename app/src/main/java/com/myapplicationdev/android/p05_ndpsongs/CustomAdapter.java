package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> List;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {

        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        List = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);
        TextView tvSinger = rowView.findViewById(R.id.textViewSinger);
        TextView tvStar = rowView.findViewById(R.id.textViewStars);

        // Obtain the Android Version information based on the position
        Song currentVersion = List.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentVersion.getTitle());
        tvDate.setText(currentVersion.getYearReleased());
        tvSinger.setText(currentVersion.getSingers());
        tvStar.setText(currentVersion.getStars());

        return rowView;
    }

}

