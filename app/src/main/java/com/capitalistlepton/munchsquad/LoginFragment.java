package com.capitalistlepton.munchsquad;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    private static final String ARG_LOGIN_ID = "login_id";

    private String mUsername, mPassword;
    private EditText mUsernameText, mPasswordText;
    private Button mLoginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //enables menu
        setHasOptionsMenu(true);
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

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUsername = mUsernameText.getText().toString();
                mPassword = mPasswordText.getText().toString();
                Toast t = Toast.makeText(getActivity(), "Username: " +mUsername +"\n Password: "+mPassword, Toast.LENGTH_SHORT);
                t.show();
            }
        });


                return v;

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_login, menu);
    }

}
