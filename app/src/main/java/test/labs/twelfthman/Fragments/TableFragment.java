package test.labs.twelfthman.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.labs.twelfthman.Adapter.LeagueAdapter;
import test.labs.twelfthman.Model.LeagueTableModel;
import test.labs.twelfthman.R;

public class TableFragment extends Fragment {
    private static final String TAG = "tag";
    TextView LeagueName;
    View v;
    String JsonURL = "http://api.football-data.org/v1/competitions/467/leagueTable";
    RequestQueue requestQueue;
    String name;
    RecyclerView recyclerView;
    LeagueAdapter leagueAdapter;
    LinearLayoutManager mLayoutManager;
    List<LeagueTableModel> list;
    LeagueTableModel leagueTableModel;
    String teamname, teamno, pj, pts, group, gf, ga, diff, imageurl;

    JSONArray jsonObject;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.activity_soccer_season, container, false);

        LeagueName = v.findViewById(R.id.league_name);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        list = new ArrayList<>();
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        requestQueue = Volley.newRequestQueue(getContext());


        loadTable();


        return v;
    }


    void loadTable() {

        // Start the queue
        requestQueue.start();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, JsonURL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            name = response.getString("leagueCaption");
                            LeagueName.setText(name);
                            JSONObject standingJsonObject = response.getJSONObject("standings");


                            jsonObject = standingJsonObject.getJSONArray("A");
                            for (int j = 0; j < jsonObject.length(); j++) {

                                JSONObject jsonObject1 = jsonObject.getJSONObject(j);

                                teamname = jsonObject1.getString("team");
                                teamno = String.valueOf(j + 1);
                                group = jsonObject1.getString("group");
                                pj = jsonObject1.getString("playedGames");
                                gf = jsonObject1.getString("goals");
                                ga = jsonObject1.getString("goalsAgainst");
                                diff = jsonObject1.getString("goalDifference");
                                pts = jsonObject1.getString("points");
                                imageurl = jsonObject1.getString("crestURI");
                                Log.e("in", teamname);


                                leagueTableModel = new LeagueTableModel(group, teamno, teamname, imageurl, pj, gf, ga, diff, pts);
                                list.add(leagueTableModel);




                            }

                            leagueAdapter = new LeagueAdapter(list, getActivity());

                            recyclerView.setAdapter(leagueAdapter);


                            /*jsonObject = standingJsonObject.getJSONArray("B");
                            for (int j = 0; j < jsonObject.length(); j++) {

                                JSONObject jsonObject1 = jsonObject.getJSONObject(j);

                                teamname = jsonObject1.getString("team");
                                teamno = String.valueOf(j + 1);
                                group = jsonObject1.getString("group");
                                pj = jsonObject1.getString("playedGames");
                                gf = jsonObject1.getString("goals");
                                ga = jsonObject1.getString("goalsAgainst");
                                diff = jsonObject1.getString("goalDifference");
                                pts = jsonObject1.getString("points");
                                imageurl = jsonObject1.getString("crestURI");
                                leagueTableModel = new LeagueTableModel(group, teamno, teamname, imageurl, pj, gf, ga, diff, pts);

                                list.add(leagueTableModel);

                            }


                            jsonObject = standingJsonObject.getJSONArray("C");
                            for (int j = 0; j < jsonObject.length(); j++) {

                                JSONObject jsonObject1 = jsonObject.getJSONObject(j);

                                teamname = jsonObject1.getString("team");
                                teamno = String.valueOf(j + 1);
                                group = jsonObject1.getString("group");
                                pj = jsonObject1.getString("playedGames");
                                gf = jsonObject1.getString("goals");
                                ga = jsonObject1.getString("goalsAgainst");
                                diff = jsonObject1.getString("goalDifference");
                                pts = jsonObject1.getString("points");
                                imageurl = jsonObject1.getString("crestURI");
                                leagueTableModel = new LeagueTableModel(group, teamno, teamname, imageurl, pj, gf, ga, diff, pts);
                                list.add(leagueTableModel);

                            }


                            jsonObject = standingJsonObject.getJSONArray("D");
                            for (int j = 0; j < jsonObject.length(); j++) {

                                JSONObject jsonObject1 = jsonObject.getJSONObject(j);

                                teamname = jsonObject1.getString("team");
                                teamno = String.valueOf(j + 1);
                                group = jsonObject1.getString("group");
                                pj = jsonObject1.getString("playedGames");
                                gf = jsonObject1.getString("goals");
                                ga = jsonObject1.getString("goalsAgainst");
                                diff = jsonObject1.getString("goalDifference");
                                pts = jsonObject1.getString("points");
                                imageurl = jsonObject1.getString("crestURI");
                                leagueTableModel = new LeagueTableModel(group, teamno, teamname, imageurl, pj, gf, ga, diff, pts);
                                list.add(leagueTableModel);


                            }*/
                        } catch (JSONException e) {
                            Log.e(TAG, e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Log.d(TAG, "Error: " + error.getMessage());

                        if (error instanceof NetworkError) {
                        } else if (error instanceof ServerError) {
                        } else if (error instanceof AuthFailureError) {
                        } else if (error instanceof ParseError) {
                        } else if (error instanceof NoConnectionError) {
                        } else if (error instanceof TimeoutError) {
                        }
                    }

                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-Auth-Token", "db3b7f763acc4b499cacf91ac26ba863 ");


                return params;
            }
        };
        requestQueue.add(jsonObjReq);


    }
}