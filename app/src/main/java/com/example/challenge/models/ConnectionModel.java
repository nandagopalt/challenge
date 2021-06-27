package com.example.challenge.models;

public class ConnectionModel {
    private static final String TAG = "ConnectionModel";

    private int type;
    private boolean isConnected;

    public ConnectionModel(int type, boolean isConnected) {
        this.type = type;
        this.isConnected = isConnected;
    }

    public int getType() {
        return type;
    }

    public boolean isConnected() {
        return isConnected;
    }
}
