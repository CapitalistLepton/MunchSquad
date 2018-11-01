package com.capitalistlepton.munchsquad.Activity;

import android.support.v4.app.Fragment;

import com.capitalistlepton.munchsquad.Fragment.WelcomeFragment;

/**
 * Creates a Welcome Activity, composed of one fragment.
 */
public class WelcomeActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() { return new WelcomeFragment(); }
}
