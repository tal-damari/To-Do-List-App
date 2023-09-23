package com.example.todolistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<CheckBoxName> {
    private ArrayList<CheckBoxName> dataset = new ArrayList<>();
    Context context;

    public CustomAdapter(@NonNull Context context,ArrayList<CheckBoxName> dataset) {
        super(context, R.layout.item_list, dataset);

        this.context = context;
        this.dataset = dataset;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CheckBoxName name = getItem(position);

        ViewHolder viewHolder;
        final View result;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list,
                    parent,
                    false
            );
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);

            result = convertView;

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.checkBox.setText(name.getName());

        return result;
    }

    private static class ViewHolder{
        CheckBox checkBox;
        
    }
}
