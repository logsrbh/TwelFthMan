package test.labs.twelfthman;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import test.labs.twelfthman.Utils.RoundCornersTransformation;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {



    View view,x;
ViewGroup p;
Activity a;
    //Context context;
    List<NewsModel> list;


    public NewsAdapter()
    {

    }


    public NewsAdapter(Activity  a, List<NewsModel> list) {
        //this.context = context;
        this.list = list;
        this.a=a;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_news_item, parent, false);
p=parent;
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final NewsModel newsModel=list.get(position);

        holder.newsTitle.setText(newsModel.getNewstitle());

        Picasso.with(a).load(newsModel.getImageUrl()).transform(new RoundCornersTransformation(16,2,true,true)).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

animation(newsModel);
            }
        });

    }

    private void animation(NewsModel newsModel) {
        Intent intent=new Intent(a, NewsContent.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        String transitionName = a.getString(R.string.transition_string);
         View anim=x.findViewById(R.id.Start_card);
        intent.putExtra("id",newsModel.getNews_id());


        ActivityOptionsCompat options =ActivityOptionsCompat.makeSceneTransitionAnimation(a,anim, transitionName);

        // ActivityOptionsCompat.makeSceneTransitionAnimation(context,anim,transitionName);

        //Start the Intent
        ActivityCompat.startActivity(a, intent, options.toBundle());

        //context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView newsTitle;
       public ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
x=itemView;
            newsTitle = itemView.findViewById(R.id.newsTitle);
            imageView = itemView.findViewById(R.id.newsImage);
        }
    }
}
