package com.capitalistlepton.munchsquad.Activity;

import android.support.v4.app.Fragment;

import com.capitalistlepton.munchsquad.Fragment.FoodFragment;


public class LoginActivity extends SingleFragmentActivity {

    /**
     * Each Activity should be composed of fragments typically 1 or 2.
     * @return
     */
    @Override
    protected Fragment createFragment() {
        return new FoodFragment();
    }
}
