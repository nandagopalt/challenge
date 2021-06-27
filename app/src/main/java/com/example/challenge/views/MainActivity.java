package com.example.challenge.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.Toast;

import com.example.challenge.R;
import com.example.challenge.models.ConnectionModel;
import com.example.challenge.network.ConnectionLiveData;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private ConnectionLiveData connectionLiveData;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this, R.id.navhost_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController);

        connectionLiveData = new ConnectionLiveData(getApplicationContext());
        connectionLiveData.observe(this, new Observer<ConnectionModel>() {
            @Override
            public void onChanged(ConnectionModel connectionModel) {
                if(!connectionModel.isConnected()) {
                    Toast.makeText(MainActivity.this, "Check connection !", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Connected !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}