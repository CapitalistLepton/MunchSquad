package com.capitalistlepton.munchsquad.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.capitalistlepton.munchsquad.Activity.UserRegisterActivity;
import com.capitalistlepton.munchsquad.Activity.WelcomeActivity;
import com.capitalistlepton.munchsquad.Model.Login;
import com.capitalistlepton.munchsquad.Model.Session;
import com.capitalistlepton.munchsquad.R;

/**
 * Handles User logging into application.
 */
public class LoginFragment extends Fragment {

    private static final String ARG_LOGIN_ID = "login_id";

    private EditText mUsernameText, mPasswordText;
    private Button mLoginButton;
    private TextView mNewUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Enable menu
        //setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //sets view to fragment_login
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        //finds xml resources:
        mUsernameText = (EditText) v.findViewById(R.id.login_username);
        mPasswordText = (EditText) v.findViewById(R.id.login_password);
        mLoginButton = (Button) v.findViewById(R.id.login_login_button);
        mNewUser = (TextView) v.findViewById(R.id.login_new_user);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        mNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newUser();
            }
        });
        return v;
    }

    /**
     * Displays new user page, handles account creation.
     */
    private void newUser() {
        Intent intent = new Intent(getActivity(), UserRegisterActivity.class);
        startActivity(intent);
    }

    /**
     * Displays the welcome page, logs in.
     */
    private void login() {
        boolean valid = Login.validate(mUsernameText.getText().toString(),
                mPasswordText.getText().toString());
        if (valid) {
            Session.login(mUsernameText.getText().toString());
            Intent intent = new Intent(getActivity(), WelcomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            getActivity().finish();
        } else {
            Toast.makeText(getContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_login, menu);
    }

}
