package com.example.innofuel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addEventFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addEventFragment extends Fragment {


    public addEventFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment addEventFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static addEventFragment newInstance() {
        addEventFragment fragment = new addEventFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_event, container, false);
    }
}