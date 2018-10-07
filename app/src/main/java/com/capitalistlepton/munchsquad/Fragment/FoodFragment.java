package com.capitalistlepton.munchsquad.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.capitalistlepton.munchsquad.R;

public class FoodFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //enables menu
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //sets view to fragment_login
        View v = inflater.inflate(R.layout.fragment_food, container, false);

        return v;

    }
}
