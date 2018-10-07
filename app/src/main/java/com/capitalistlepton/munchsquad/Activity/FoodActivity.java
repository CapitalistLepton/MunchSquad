package com.capitalistlepton.munchsquad.Activity;

import android.support.v4.app.Fragment;

import com.capitalistlepton.munchsquad.Fragment.FoodFragment;

public class FoodActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new FoodFragment();
    }
}
