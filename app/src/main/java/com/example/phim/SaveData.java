package com.example.phim;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SaveData {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SaveData(){
        editor.clear();
    };
     public SaveData(Context context, String key, String data){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();

        editor.putString(key,data);
        editor.commit();
    }


}
