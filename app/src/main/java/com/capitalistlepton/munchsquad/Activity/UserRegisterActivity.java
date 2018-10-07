package com.capitalistlepton.munchsquad.Activity;

import android.support.v4.app.Fragment;

import com.capitalistlepton.munchsquad.Fragment.UserRegisterFragment;

public class UserRegisterActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new UserRegisterFragment();
    }
}
