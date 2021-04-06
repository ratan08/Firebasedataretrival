package com.group.firebasedataretrival;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShowFragment extends Fragment {

    String name;
    String email;
    String address;



    public ShowFragment() {
        // Required empty public constructor
    }

    public ShowFragment(String name,String email,String address) {
        this.name = name;
        this.email = email;
        this.address = address;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         TextView name1,email1,number1;
        View view = inflater.inflate(R.layout.fragment_show, container, false);

        name1 = view.findViewById(R.id.viewName);
        email1 = view.findViewById(R.id.viewEmail);
        number1 = view.findViewById(R.id.viewNumber);

        name1.setText(name);
        email1.setText(email);
        number1.setText(address);
        return view;
    }
}