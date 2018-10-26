package com.capitalistlepton.munchsquad.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                boolean result;
                String status;
                result = Login.createUser(mNameText.toString(), mPasswordText.toString(), mUsernameText.toString());
                if (result) status = "Account created";
                else status = "Error Occured";

                Toast.makeText(getContext(), status,Toast.LENGTH_SHORT).show();
            }
        });

        return v;

    }
}