package test.labs.twelfthman;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.uncopt.android.widget.text.justify.JustifiedTextView;

public class NewsContent extends AppCompatActivity {


    ImageView imageContent;
    JustifiedTextView content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.news_content);

        String newsId = getIntent().getStringExtra("id");
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/IBMPlexSans-Bold.ttf");
        imageContent = findViewById(R.id.imageContent);
        content = findViewById(R.id.content);
        content.setTypeface(type);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("newsPost").document(newsId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                content.setText((String) task.getResult().get("content"));

                Glide.with(getApplicationContext()).load((String) task.getResult().get("imageURL")).into(imageContent);
            }
        });


    }
}
