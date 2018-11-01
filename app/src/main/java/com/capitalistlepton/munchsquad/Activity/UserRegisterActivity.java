package com.capitalistlepton.munchsquad.Activity;

import android.support.v4.app.Fragment;

import com.capitalistlepton.munchsquad.Fragment.UserRegisterFragment;

/**
 * Creates a User Register Activity, composed of one fragment.
 */
public class UserRegisterActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new UserRegisterFragment();
    }
}
