package test.labs.twelfthman.Adapter;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import test.labs.twelfthman.Model.LeagueTableModel;
import test.labs.twelfthman.R;

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.MyViewHolder> {
    int i = 0;
    List<LeagueTableModel> list;
    View view;
    Activity activity;

    public LeagueAdapter(List<LeagueTableModel> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.league_table_single, parent, false);


        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        LeagueTableModel leagueTableModel = list.get(position);
        holder.group_.setText("Group " + list.get(position).getGroup());

        //1St ROW
        holder.group_.setText("Group " + list.get(position).getGroup());
        holder.pts1.setText(list.get(position).getPts());
        holder.teamno1.setText(list.get(position).getTeamno());
        holder.ga1.setText(list.get(position).getGa());
        holder.pts1.setText(list.get(position).getPts());
        holder.teamname1.setText(list.get(position).getTeamName());
        holder.pj1.setText(list.get(position).getPj());
        holder.gf1.setText(list.get(position).getGf());
        holder.diff1.setText(list.get(position).getDiff());

        SvgLoader.pluck()
                .with(activity)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(list.get(position).getImageurl(), holder.imageView1);

        //2nd ROW
        holder.pts2.setText(list.get(position).getPts());
        holder.teamno2.setText(list.get(position).getTeamno());
        holder.ga2.setText(list.get(position).getGa());
        holder.pts2.setText(list.get(position).getPts());
        holder.teamname2.setText(list.get(position).getTeamName());
        holder.pj2.setText(list.get(position).getPj());
        holder.gf2.setText(list.get(position).getGf());
        holder.diff2.setText(list.get(position).getDiff());

        SvgLoader.pluck()
                .with(activity)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(list.get(position).getImageurl(), holder.imageView2);


        //3rd ROW
        holder.pts3.setText(list.get(position).getPts());
        holder.teamno3.setText(list.get(position).getTeamno());
        holder.ga3.setText(list.get(position).getGa());
        holder.pts3.setText(list.get(position).getPts());
        holder.teamname3.setText(list.get(position).getTeamName());
        holder.pj3.setText(list.get(position).getPj());
        holder.gf3.setText(list.get(position).getGf());
        holder.diff3.setText(list.get(position).getDiff());

        SvgLoader.pluck()
                .with(activity)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(list.get(position).getImageurl(), holder.imageView3);

        //4th ROW
        holder.pts4.setText(list.get(position).getPts());
        holder.teamno4.setText(list.get(position).getTeamno());
        holder.ga4.setText(list.get(position).getGa());
        holder.pts4.setText(list.get(position).getPts());
        holder.teamname4.setText(list.get(position).getTeamName());
        holder.pj4.setText(list.get(position).getPj());
        holder.gf4.setText(list.get(position).getGf());
        holder.diff4.setText(list.get(position).getDiff());

        SvgLoader.pluck()
                .with(activity)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(list.get(position).getImageurl(), holder.imageView4);

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView teamno1, teamname1, pj1, gf1, ga1, pts1, diff1, group1;
        CircleImageView imageView1;


        TextView teamno2, teamname2, pj2, gf2, ga2, pts2, diff2, group2;
        CircleImageView imageView2;

        TextView teamno3, teamname3, pj3, gf3, ga3, pts3, diff3, group3;
        CircleImageView imageView3;

        TextView teamno4, teamname4, pj4, gf4, ga4, pts4, diff4, group4;
        CircleImageView imageView4;

        TextView group_;

        public MyViewHolder(View itemView) {
            super(itemView);
            group_ = itemView.findViewById(R.id.group);


            imageView1 = itemView.findViewById(R.id.team_image1);
            teamname1 = itemView.findViewById(R.id.team_name1);
            teamno1 = itemView.findViewById(R.id.team_no1);
            pj1 = itemView.findViewById(R.id.team_pj1);
            gf1 = itemView.findViewById(R.id.team_gf1);
            ga1 = itemView.findViewById(R.id.team_ga1);
            diff1 = itemView.findViewById(R.id.team_diff1);
            pts1 = itemView.findViewById(R.id.team_pts1);


            imageView2 = itemView.findViewById(R.id.team_image2);
            teamname2 = itemView.findViewById(R.id.team_name2);
            teamno2 = itemView.findViewById(R.id.team_no2);
            pj2 = itemView.findViewById(R.id.team_pj2);
            gf2 = itemView.findViewById(R.id.team_gf2);
            ga2 = itemView.findViewById(R.id.team_ga2);
            diff2 = itemView.findViewById(R.id.team_diff2);
            pts2 = itemView.findViewById(R.id.team_pts2);


            imageView3 = itemView.findViewById(R.id.team_image3);
            teamname3 = itemView.findViewById(R.id.team_name3);
            teamno3 = itemView.findViewById(R.id.team_no3);
            pj3 = itemView.findViewById(R.id.team_pj3);
            gf3 = itemView.findViewById(R.id.team_gf3);
            ga3 = itemView.findViewById(R.id.team_ga3);
            diff3 = itemView.findViewById(R.id.team_diff3);
            pts3 = itemView.findViewById(R.id.team_pts3);


            imageView4 = itemView.findViewById(R.id.team_image4);
            teamname4 = itemView.findViewById(R.id.team_name4);
            teamno4 = itemView.findViewById(R.id.team_no4);
            pj4 = itemView.findViewById(R.id.team_pj4);
            gf4 = itemView.findViewById(R.id.team_gf4);
            ga4 = itemView.findViewById(R.id.team_ga4);
            diff4 = itemView.findViewById(R.id.team_diff4);
            pts4 = itemView.findViewById(R.id.team_pts4);


        }
    }
}
