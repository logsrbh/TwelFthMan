package com.example.saurabh.twelfthman;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Saurabh on 10-01-2018.
 */

public class OtherSports extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.othersports, container, false);

        String[] items = {"WWE","FITNESS"};

        ListView listView =(ListView) view.findViewById(R.id.lstother);

        ArrayAdapter<String> ListviewAdapter =new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,items);

        listView.setAdapter(ListviewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position ==0){
                    Intent i = new Intent(getActivity(),Wwe.class);
                    startActivity(i);

                }else if (position ==1){
                    Intent i2 = new Intent(getActivity(),Fitness.class);
                    startActivity(i2);
                }
            }
        });

        return view;
    }
}

