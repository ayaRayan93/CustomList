package com.example.ayaali.customlist;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AyaAli on a1/a12/2017.
 */

public class AdapterList extends ArrayAdapter<String> {

    private final String [] description;
    private final int [] imageIds;
    private final Activity context;

    public AdapterList(String[] description, int[] imageIds, Activity context1) {
        super(context1, R.layout.item_list, description);

        this.description = description;
        this.imageIds = imageIds;
        this.context = context1;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();

        View rowView=inflater.inflate(R.layout.item_list,null,true);
        TextView textView=(TextView) rowView.findViewById(R.id.text);
        ImageView imageView=(ImageView)rowView.findViewById(R.id.img);
        textView.setText(description[position]);
        imageView.setImageResource(imageIds[position]);

        return rowView;
    }
}
