package com.capitalistlepton.munchsquad.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.capitalistlepton.munchsquad.Activity.LoginActivity;
import com.capitalistlepton.munchsquad.Model.Login;
import com.capitalistlepton.munchsquad.R;

public class UserRegisterFragment extends Fragment {

    private EditText mNameText, mUsernameText, mPasswordText;
    private Button mRegisterButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_user_register, container, false);
        mRegisterButton = v.findViewById(R.id.user_register_button);
        mNameText = v.findViewById(R.id.user_register_name);
        mUsernameText = v.findViewById(R.id.user_register_username);
        mPasswordText = v.findViewById(R.id.user_register_password);


        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean success = Login.createUser(mNameText.getText().toString(),
                        mPasswordText.getText().toString(), mUsernameText.getText().toString());
                if (success) {
                    redirectToLogin();
                } else {
                    CharSequence msg = "Failed to create new account";
                    Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    private void redirectToLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}
