package com.capitalistlepton.munchsquad;

import android.support.v4.app.Fragment;


public class LoginActivity extends SingleFragmentActivity {

    /**
     * Each Activity should be composed of fragments typically 1 or 2.
     * @return
     */
    @Override
    protected Fragment createFragment() {
        return new LoginFragment();
    }
}
