package com.example.saurabh.twelfthman;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Saurabh on 10-01-2018.
 */

public class SignIn extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signin, container, false);


       //Button bt1 = (Button) view.findViewById(R.id.buttonSignIN);
       //bt1.setOnClickListener(new View.OnClickListener() {
         //  @Override
           //public void onClick(View view) {

               //Toast.

           //}
       //});



        return view;
    }
}
