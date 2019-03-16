package com.example.saurabh.twelfthman;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Saurabh on 10-01-2018.
 */

public class Fanzone extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fanzone, container, false);

        String[] menuItems ={"Art Galley", "Be A 12th Man", "Videos","Polls","Quiz","Poetry"};

        ListView listView = (ListView) view.findViewById(R.id.lst);

        ArrayAdapter<String> ListviewAdapter = new ArrayAdapter<String>(
                     getActivity(),android.R.layout.simple_list_item_1, menuItems);

         listView.setAdapter(ListviewAdapter);

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              if (position == 0){
                  Toast.makeText(getActivity(),"You Clicked the Art Gallery",Toast.LENGTH_SHORT).show();
              } else if (position == 1){
                  Intent intent = new Intent(getActivity(),BeA12thman.class);
                  startActivity(intent);
              } else if (position == 2){
                  Toast.makeText(getActivity(),"Videos are not Uploded yet keep patience !!!", Toast.LENGTH_SHORT).show();

              }else if (position == 3){
                  Toast.makeText(getActivity(),"Polls are not ready",Toast.LENGTH_SHORT).show();

              }else if (position == 4){
                  Toast.makeText(getActivity(),"Quiz will be available soon",Toast.LENGTH_SHORT).show();

              }else if (position == 5){
                  Toast.makeText(getActivity(), "You clicked the Poetry ",Toast.LENGTH_SHORT).show();
              }
             }
         });


        return view;
    }
}
