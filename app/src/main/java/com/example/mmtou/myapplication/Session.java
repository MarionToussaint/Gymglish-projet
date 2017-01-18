package com.example.mmtou.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mmtou on 17/01/2017.
 */

public class Session {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context ctx;

    public Session(Context ctx){
        this.ctx = ctx;
        pref = ctx.getSharedPreferences("myapplication",Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void setLoggedIn(boolean loggedin){
        editor.putBoolean("loggedInMode",loggedin);
        editor.commit();
    }

    public boolean log(){
        return pref.getBoolean("loggedInMode",false);
    }
}
