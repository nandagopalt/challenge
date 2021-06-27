package com.example.challenge.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.lifecycle.LiveData;

import com.example.challenge.models.ConnectionModel;


public class ConnectionLiveData extends LiveData<ConnectionModel> {

    private Context context;

    public ConnectionLiveData(Context context) {
        this.context = context;
    }

    @Override
    protected void onActive() {
        super.onActive();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(networkReceiver, filter);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        context.unregisterReceiver(networkReceiver);
    }

    private BroadcastReceiver networkReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getExtras() != null) {
                isNetworkAvailable(context);
            }
        }
    };

    private void isNetworkAvailable(Context context) {
        boolean isConnected;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Network nw = connectivityManager.getActiveNetwork();
            if (nw == null)
                postValue(new ConnectionModel(0, false));
            NetworkCapabilities actNw = connectivityManager.getNetworkCapabilities(nw);
            if(actNw != null) {
                isConnected = actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
                if (isConnected)
                    postValue(new ConnectionModel(NetworkCapabilities.TRANSPORT_WIFI, true));
                else {
                    isConnected = actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR);
                    if (isConnected)
                        postValue(new ConnectionModel(NetworkCapabilities.TRANSPORT_CELLULAR, true));
                }
            } else {
                postValue(new ConnectionModel(0, false));
            }
        } else {
            NetworkInfo nwInfo = connectivityManager.getActiveNetworkInfo();
            isConnected = nwInfo != null && nwInfo.isConnected();
            if(isConnected)
                postValue(new ConnectionModel(nwInfo.getType(), nwInfo.isConnected()));
        }
    }
}


