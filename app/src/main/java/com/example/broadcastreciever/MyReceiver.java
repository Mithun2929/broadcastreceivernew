package com.example.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
                        if (isonline(context)){
                        Toast.makeText(context, "Internet connected", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(context, "No internet connection", Toast.LENGTH_SHORT).show();
                        }

            }catch (NullPointerException e){
       e.printStackTrace();

   }
    }
    public boolean isonline(Context context){
        try {
            ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            return(networkInfo!=null && networkInfo.isConnected());
        }catch (NullPointerException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}