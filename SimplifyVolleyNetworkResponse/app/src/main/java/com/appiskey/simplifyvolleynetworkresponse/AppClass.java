package com.appiskey.simplifyvolleynetworkresponse;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Dell 5521 on 5/7/2016.
 */
public class AppClass extends Application{
    public static RequestQueue requestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(this);

    }
}
