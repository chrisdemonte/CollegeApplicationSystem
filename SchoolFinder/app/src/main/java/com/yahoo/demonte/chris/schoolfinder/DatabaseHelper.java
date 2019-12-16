package com.yahoo.demonte.chris.schoolfinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "college_list.db";
    public static final String TABLE_NAME = "college_data_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "State";
    public static final String COL_4 = "City";
    public static final String COL_5 = "Zip";
    public static final String COL_6 = "State_Fips";
    public static final String COL_7 = "Region";
    public static final String COL_8 = "Locale";
    public static final String COL_9 = "Longitude";
    public static final String COL_10 = "Latitude";
    public static final String COL_11 = "Accreditor";
    public static final String COL_12 = "School_URL";
    public static final String COL_13 = "Degrees_Awarded";
    public static final String COL_14 = "Ownership";
    public static final String COL_15 = "Size";
    public static final String COL_16 = "Admission_Rate";
    public static final String COL_17 = "Math_SAT_25th_Percentile";
    public static final String COL_18 = "Math_SAT_75th_Percentile";
    public static final String COL_19 = "Reading_SAT_25th_Percentile";
    public static final String COL_20 = "Reading_SAT_75th_Percentile";
    public static final String COL_21 = "In_State_Tuition";
    public static final String COL_22 = "Out_Of_State_Tuition";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ("+COL_1+" INTEGER PRIMARY KEY,"+COL_2+" TEXT,"+COL_3+" TEXT,"+COL_4+" TEXT,"+COL_5+" TEXT,"+
                COL_6+" INTEGER,"+COL_7+" INTEGER,"+COL_8+" INTEGER,"+COL_9+" TEXT,"+COL_10+" TEXT,"+COL_11+" TEXT,"+COL_12+" TEXT,"+COL_13+" INTEGER,"+
                COL_14+" INTEGER,"+COL_15+" INTEGER,"+COL_16+" REAL,"+COL_17+" REAL,"+COL_18+" REAL,"+COL_19+" REAL,"+COL_20+" REAL,"+
                COL_21+" INTEGER,"+COL_22+" INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }
    public boolean insertSchool (School school){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(COL_1, school.getId());
        contentValue.put(COL_2, school.getName());
        contentValue.put(COL_3, school.getState());
        contentValue.put(COL_4, school.getCity());
        contentValue.put(COL_5, school.getZip());
        contentValue.put(COL_6, school.getState_fips());
        contentValue.put(COL_7, school.getRegion_id());
        contentValue.put(COL_8, school.getLocale());
        contentValue.put(COL_9, school.getLon());
        contentValue.put(COL_10, school.getLat());
        contentValue.put(COL_11, school.getAccreditor());
        contentValue.put(COL_12, school.getSchool_url());
        contentValue.put(COL_13, school.getDegrees_awarded());
        contentValue.put(COL_14, school.getOwnership());
        contentValue.put(COL_15, school.getSize());
        contentValue.put(COL_16, school.getAdmission_rate());
        contentValue.put(COL_17, school.getMath_sat_25th());
        contentValue.put(COL_18, school.getMath_sat_75th());
        contentValue.put(COL_19, school.getReading_sat_25th());
        contentValue.put(COL_20, school.getReading_sat_75th());
        contentValue.put(COL_21, school.getIn_state_tuition());
        contentValue.put(COL_22, school.getOut_of_state_tuition());
        long result = db.insert(TABLE_NAME, null, contentValue);
        return result != -1;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
    public Cursor getSearchResult(String whereStatement, String[] params){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT "+COL_1+" FROM "+TABLE_NAME+ whereStatement, params);
        return  res;
    }
    public Cursor getAutofill(String args, String[] params){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT "+COL_2+" FROM "+TABLE_NAME+ " WHERE " +COL_2+ " LIKE '" + args +"%'", null);
        return  res;
    }
}