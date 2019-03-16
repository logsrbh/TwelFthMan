package com.example.saurabh.twelfthman;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Saurabh on 10-01-2018.
 */

public class Share extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.share, container, false);

        Button btfb, bttw, btgp, btln;

        btfb = (Button) view.findViewById(R.id.btfb);
        btgp = (Button) view.findViewById(R.id.btgp);
        bttw = (Button) view.findViewById(R.id.bttw);
        btln = (Button) view.findViewById(R.id.btln);
        btfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {

                    case R.id.btfb:

                        String s = "https://www.facebook.com/Twelfthmantimes";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(s));
                        startActivity(i);
                        break;


                }
            }

        });

        bttw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {

                    case R.id.bttw:

                        String st = "http://www.twitter.com/the12thmantimes";
                        Intent i2 = new Intent(Intent.ACTION_VIEW);
                        i2.setData(Uri.parse(st));
                        startActivity(i2);
                        break;
                }
            }

        });



        btgp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.btgp:
                    String stt = "https://plus.google.com/105539643606954415470";
                    Intent i3 = new Intent(Intent.ACTION_VIEW);
                    i3.setData(Uri.parse(stt));
                    startActivity(i3);


                }

            }
        });

        btln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {

                    case R.id.btln:

                        String sttt = "https://in.linkedin.com";
                        Intent i4 = new Intent(Intent.ACTION_VIEW);
                        i4.setData(Uri.parse(sttt));
                        startActivity(i4);
                        break;
                }
            }

        });
        return view;
    }
}
