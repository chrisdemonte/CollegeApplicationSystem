package com.yahoo.demonte.chris.schoolfinder;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class SearchResultAdapter extends BaseAdapter {
    private LayoutInflater mInflator;
    private ArrayList<School> schoolList;
    private boolean colorize;

    public SearchResultAdapter(Context c, ArrayList<School> schools){
        schoolList = schools;
        if (schoolList.size() < 1){
            School nullSchool = new School(-1, "No schools were found", "", "", "", 0,0,0,"","","","",-1,-1,-1,-1,-1,-1,-1,-1,-1,-1);
            schoolList.add(nullSchool);
        }
        mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return schoolList.size();
    }

    @Override
    public Object getItem(int position) {
        return schoolList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflator.inflate(R.layout.college_result_button_layout, null);
        TextView name = (TextView) v.findViewById(R.id.resultTabName);
        TextView info = (TextView) v.findViewById(R.id.resultTabInfo);


        School theSchool = (School) getItem(position);

        if (colorize == true){
            if (UserManager.currentUser.getMathScore() >= theSchool.getMath_sat_75th() && UserManager.currentUser.getReadingScore() >= theSchool.getReading_sat_75th()){
                name.setBackgroundColor(Color.parseColor("#a6f097"));
            }
            else if (UserManager.currentUser.getMathScore() >= theSchool.getMath_sat_25th() && UserManager.currentUser.getReadingScore() >= theSchool.getReading_sat_25th()){
                name.setBackgroundColor(Color.parseColor("#def097"));
            }
            else {
                name.setBackgroundColor(Color.parseColor("#f0c897"));
            }

        }


        String n = " " + theSchool.getName();
        String i;
        if (n.contentEquals(" No schools were found")){
            i = "";
        }
        else {
            i = " " + theSchool.getCity() + ", " + theSchool.getState() + ", " + theSchool.getZip();
        }
        name.setText(n);
        info.setText(i);

        return v;
    }
    public void changeChoices (ArrayList<School> schools, boolean colorize){
        this.colorize = colorize;
        this.schoolList = schools;
        if (this.schoolList.size() == 0){
            School nullSchool = new School(-1, "No schools were found", "", "", "", 0,0,0,"","","","",-1,-1,-1,-1,-1,-1,-1,-1,-1,-1);
            schoolList.add(nullSchool);
        }
        this.notifyDataSetChanged();
    }
}
