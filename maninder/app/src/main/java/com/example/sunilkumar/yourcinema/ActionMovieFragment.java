package com.example.sunilkumar.yourcinema;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActionMovieFragment extends Fragment {


    String actionurl="https://api.themoviedb.org/3/genre/28/movies?api_key=dd958aab0d5a41dd11a54e9791f5c00a&language=en-US&include_adult=false&sort_by=created_at.asc";
        ProgressDialog pd;

     ListView lv;

    ArrayList<String> idlist,namelist,picnamelist,descrlist,reldatelist;
    ArrayList<Float> ratlist;









    public ActionMovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_action_movie, container, false);

        lv=(ListView)view.findViewById(R.id.listviewAction);





       new process().execute();





        return view;


    }





    class process extends AsyncTask<Void,Void,Void>
    {
        String incomingresult;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(getContext());
            pd.setMessage("plz wait---");
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            incomingresult=getJson();


            return null;
        }

        public String getJson()
        {
            StringBuilder sb=new StringBuilder();
            try {
                URL url = new URL(actionurl);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.connect();
                int code=con.getResponseCode();
                if(code==200)
                {

                    InputStream in=con.getInputStream();
                    Scanner obj=new Scanner(in);
                    while(obj.hasNext())
                    {
                        sb.append(obj.nextLine());
                    }

                }
                else
                {
                    Toast.makeText(getContext(), "Response Code:" + code, Toast.LENGTH_SHORT).show();

                }

            }
            catch(Exception ex){}
            return(sb.toString());
        }



        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pd.dismiss();
            try {
         idlist=new ArrayList<String>();
         namelist=new ArrayList<String>();
         picnamelist=new ArrayList<String>();
         descrlist=new ArrayList<String>();
         reldatelist=new ArrayList<String>();
                ratlist=new ArrayList<Float>();
JSONObject mainobj=new JSONObject(incomingresult);
JSONArray resultsarray=mainobj.getJSONArray("results");
                for(int i=0;i<resultsarray.length();i++)
                {
                    JSONObject resultelement=resultsarray.getJSONObject(i);
                    idlist.add(resultelement.getString("id"));
                    namelist.add(resultelement.getString("title"));
                    descrlist.add(resultelement.getString("overview"));
                    picnamelist.add(resultelement.getString("poster_path"));
                    reldatelist.add(resultelement.getString("release_date"));
                    ratlist.add((float)resultelement.getDouble("vote_average"));

                }


                CustomAdapter cs=new CustomAdapter(getContext(),idlist,namelist,picnamelist,descrlist,reldatelist,ratlist);

                lv.setAdapter(cs);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Toast.makeText(getContext(),i+"",Toast.LENGTH_LONG).show();

                    }
                });



            }
            catch(Exception ex){
                String err=ex.toString();
                Log.e("eee",err);

            }

        }
    }

}
