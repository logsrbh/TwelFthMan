package test.labs.twelfthman.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import ir.apend.slider.model.Slide;
import ir.apend.slider.ui.Slider;
import test.labs.twelfthman.NewsAdapter;
import test.labs.twelfthman.NewsModel;
import test.labs.twelfthman.R;

public class HomeFragment extends Fragment {
    static String one, two, three, four;
    private RecyclerView newsRecycler;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private View v;
    private FirebaseFirestore db;
    private LinearLayoutManager linearLayoutManager;
    private List<NewsModel> newsList;
    private RecyclerView.Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.collapsingtoolbar_, container, false);

        setCollapsingToolbar();

        recyclerviewSetup();

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        newsList = new ArrayList<>();
        newsRecycler.setHasFixedSize(true);
        newsRecycler.setLayoutManager(linearLayoutManager);
        db = FirebaseFirestore.getInstance();
        loadNews();
        loadSlider();
        return v;
    }

    private void recyclerviewSetup() {

        newsRecycler = v.findViewById(R.id.newsRecycler);
        AppBarLayout appbar = v.findViewById(R.id.appbar);
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    private void setCollapsingToolbar() {
/*
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");*/


        collapsingToolbarLayout = (CollapsingToolbarLayout) v.findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitleEnabled(false);
    }

    private void loadNews() {

        db.collection("newsPost").orderBy("time", Query.Direction.DESCENDING).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot document : task.getResult()) {
                        NewsModel newsModel = document.toObject(NewsModel.class);
                        newsModel.setImageUrl((String) document.get("imageURL"));
                        newsModel.setNewstitle((String) document.get("title"));
                        newsModel.setNews_id(document.getId());
                        newsModel.setContent((String) document.get("content"));
                        newsList.add(newsModel);
                        Log.e("data is", newsModel.getImageUrl() + "  " + newsModel.getNewstitle());
                    }
                } else {
                    Log.e("Error getting document", task.getException().getMessage());
                }
                adapter = new NewsAdapter(getActivity(), newsList);
                newsRecycler.setAdapter(adapter);
            }

        });

    }

    private void loadSlider() {


        db.collection("sliderImages").document("images").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful())
                {
                    DocumentSnapshot doc=task.getResult();
                    one= (String) doc.get("one");
                    two= (String) doc.get("two");
                    three= (String) doc.get("three");
                    four= (String) doc.get("four");
                    Log.e("one",one);
                    Log.e("two",two);
                    Log.e("three",three);
                    Log.e("four",four);

                }
            }
        });

        Slider slider = v.findViewById(R.id.slider);
        List<Slide> slideList = new ArrayList<>();

        slideList.add(new Slide(0, "https://firebasestorage.googleapis.com/v0/b/twelfthman-5b453.appspot.com/o/slider_images%2FFOOT.jpg?alt=media&token=2333500b-e584-4e5c-bcb6-72c2d6f827c7", getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        slideList.add(new Slide(1, "https://firebasestorage.googleapis.com/v0/b/twelfthman-5b453.appspot.com/o/slider_images%2Ffootball.jpg?alt=media&token=a0c110fb-34eb-4ef8-8fa1-cbf13e63506b", getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        slideList.add(new Slide(2, "https://firebasestorage.googleapis.com/v0/b/twelfthman-5b453.appspot.com/o/slider_images%2FFS_Associations_Home.jpg?alt=media&token=f3d8c792-c947-488d-a540-26d2a62dc180", getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        slideList.add(new Slide(3, "https://firebasestorage.googleapis.com/v0/b/twelfthman-5b453.appspot.com/o/slider_images%2F18messi.jpg?alt=media&token=338b46e2-9126-497e-b8a4-d1cb4a651c4e", getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));

        slider.setItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://the12thman.in/"));
                startActivity(intent);
            }
        });

        slider.addSlides(slideList);
    }
}
