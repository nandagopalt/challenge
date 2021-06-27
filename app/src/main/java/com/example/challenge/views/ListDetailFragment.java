package com.example.challenge.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.challenge.R;

/**
 * A simple {@link Fragment} subclass.
 *
 *
 */
public class ListDetailFragment extends Fragment {

    public ListDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_detail, container, false);
    }
}