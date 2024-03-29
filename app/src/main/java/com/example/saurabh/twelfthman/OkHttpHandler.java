package com.example.saurabh.twelfthman;

import android.os.AsyncTask;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHandler extends AsyncTask<String,String,String> {

        OkHttpClient client = new OkHttpClient();
    ResultFromUrl resultFromUrl;
    public OkHttpHandler(MainActivity mainActivity) {
        resultFromUrl   = mainActivity;
    }

    @Override
        protected String doInBackground(String...params) {

            Request.Builder builder = new Request.Builder();
            builder.url(params[0]);
            Request request = builder.build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }



    @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        resultFromUrl.retunA(s);
        }
    }