package com.example.quartlemobile2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EventAdapter extends BaseAdapter {

    private ArrayList<Event> data;

    public EventAdapter(){
        data = new ArrayList<>();
    }

    public void addEvent(Event event){
        data.add(event);
        notifyDataSetChanged();
    }

    public void clear(){
        data.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewView = inflater.inflate(R.layout.cont,null);

        Event event = data.get(pos);



        TextView name = viewView.findViewById(R.id.contName);
        TextView date = viewView.findViewById(R.id.contDate);
        TextView points = viewView.findViewById(R.id.contPoints);

        name.setText(event.getName());
        date.setText(event.getDate());
        points.setText(event.getPoints()+ " Points");

        return viewView;
    }
}
