package com.capitalistlepton.munchsquad.Activity;

import android.support.v4.app.Fragment;

import com.capitalistlepton.munchsquad.Fragment.LoginFragment;

/**
 * Creates a Login Activity, composed of one fragment.
 */
public class LoginActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new LoginFragment();
    }
}
