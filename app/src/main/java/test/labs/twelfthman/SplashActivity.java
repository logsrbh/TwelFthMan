package test.labs.twelfthman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import test.labs.twelfthman.Utils.CircleTransform;
import test.labs.twelfthman.Utils.TypeWriter;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       // ImageView circularImageView=findViewById(R.id.logo);
       //Picasso.with(this).load(R.drawable.image).transform(new CircleTransform()).into(circularImageView);
        final TypeWriter typeWriter=findViewById(R.id.textView);
        typeWriter.setText("");
        typeWriter.setCharacterDelay(90);
        typeWriter.animateText("THE TWELFTHMAN TIMES");
        final Thread background = new Thread() {
            public void run() {

                try {



                    sleep(2200);


                    Intent i=new Intent(getBaseContext(),HomeActivity.class);
                    startActivity(i);

                    finish();

                } catch (Exception e) {
                    Log.e("SplashActivity",e.getMessage());
                }
            }
        };


        background.start();
    }
}
