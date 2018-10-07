package com.capitalistlepton.munchsquad.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.capitalistlepton.munchsquad.R;

public class UserRegisterFragment extends Fragment {

    private String mUsername, mPassword, mAddress, mEmail;
    private EditText mUsernameText, mPasswordText, mAddressText, mEmailText;
    private Button mRegisterButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //sets view to fragment_login
        View v = inflater.inflate(R.layout.fragment_user_register, container, false);

        mRegisterButton = v.findViewById(R.id.user_register_button);


        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handle register button
            }
        });

        return v;

    }
}