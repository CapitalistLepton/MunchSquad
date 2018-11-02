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
import android.widget.TextView;

import com.capitalistlepton.munchsquad.Activity.LoginActivity;
import com.capitalistlepton.munchsquad.Model.Session;
import com.capitalistlepton.munchsquad.R;

public class WelcomeFragment extends Fragment {

    private static final String ARG_LOGIN_ID = "login_id";

    private TextView mWelcome;
    private Button mLogoutButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //sets view to fragment_welcome
        View v = inflater.inflate(R.layout.fragment_welcome, container, false);

        //finds xml resources:
        mWelcome = (TextView) v.findViewById(R.id.welcome_Welcome);
        mLogoutButton = (Button) v.findViewById(R.id.welcome_logout);

        mWelcome.setText("Welcome " + Session.getName() + "!");

        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        return v;
    }

    /**
     * Logs out, returns to the home screen.
     */
    private void logout() {
        Session.logout();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        getActivity().finish();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_login, menu);
    }








}
