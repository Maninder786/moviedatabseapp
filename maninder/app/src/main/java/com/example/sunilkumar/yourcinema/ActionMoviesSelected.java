package com.example.sunilkumar.yourcinema;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ActionMoviesSelected extends AppCompatActivity {



    String actionurl,videourl;
    ProgressDialog pd;
TextView tvDirname,tvWriter;
Button btnTrailer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_movies_selected);

        Intent intent=this.getIntent();
        Bundle bd=intent.getBundleExtra("minfo");
        String mname=bd.getString("mname");
        String picname=bd.getString("picname");
        String desc=bd.getString("desc");
        float rating=bd.getFloat("rating");
        String rdate=bd.getString("rdate");
        String movieid=bd.getString("id");
         tvDirname=(TextView)findViewById(R.id.textViewDirector);




        tvWriter=(TextView)findViewById(R.id.textViewWriter);


       actionurl=" https://api.themoviedb.org/3/movie/"+movieid+"/credits?api_key=dd958aab0d5a41dd11a54e9791f5c00a";
        videourl="https://api.themoviedb.org/3/movie/"+movieid+"/videos?api_key=dd958aab0d5a41dd11a54e9791f5c00a";
        //https://api.themoviedb.org/3/movie/198663/videos?api_key=aea98560d69710b3e9cd0a5e28a60613&language=en-US

        ImageView im=(ImageView)findViewById(R.id.imageView7);
        Picasso.with(ActionMoviesSelected.this)
                .load(picname)
                .placeholder(R.drawable.logoo)

                .into(im);

        TextView text1=(TextView)findViewById(R.id.textView17);
text1.setText(mname);

        TextView text2=(TextView)findViewById(R.id.textView25);
        text2.setText(desc);

        TextView text3=(TextView)findViewById(R.id.textView3);
           text3.setText("Release Date:"+rdate);

        RatingBar rat1=(RatingBar)findViewById(R.id.ratingBar);
        rat1.setRating(rating/2);

        btnTrailer=(Button)findViewById(R.id.buttonTrailer);
        btnTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

new videosprocess().execute();



            }
        });












       new process().execute();
























    }


    class process extends AsyncTask<Void,Void,Void>
    {
        String incomingresult;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(ActionMoviesSelected.this);
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
                   // Toast.makeText(getContext(), "Response Code:" + code, Toast.LENGTH_SHORT).show();

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

                JSONObject mainobj=new JSONObject(incomingresult);
                JSONArray crewsarray=mainobj.getJSONArray("crew");
                JSONObject directorobj=crewsarray.getJSONObject(0);

                final String directorname=directorobj.getString("name");
                final String directorid=directorobj.getString("id");
                 JSONObject writerobj1=crewsarray.getJSONObject(1);

                final String writername=writerobj1.getString("name");
                final String writerid=writerobj1.getString("id");
                 //JSONObject writerobj2=crewsarray.getJSONObject(2);


               tvDirname.setText("Director: "+directorname);
                tvDirname.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {

                        Bundle bd=new Bundle();
                        bd.putString("id",directorid);
                        bd.putString("actorname",directorname);

                        Intent intent = new Intent(ActionMoviesSelected.this, ActorDetailsActivity.class);
                        intent.putExtra("info",bd);

                        startActivity(intent);



                    }
                });
                tvWriter.setText("Writer: "+writername);
                tvWriter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Bundle bd=new Bundle();
                        bd.putString("id",writerid);
                        bd.putString("actorname",writername);

                        Intent intent = new Intent(ActionMoviesSelected.this, ActorDetailsActivity.class);
                        intent.putExtra("info",bd);
                        startActivity(intent);

                    }
                });

            }
            catch(Exception ex){
                String err=ex.toString();
                Log.e("eee",err);

            }

        }
    }


    class videosprocess extends AsyncTask<Void,Void,Void>
    {
        String incomingresult;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(ActionMoviesSelected.this);
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
                URL url = new URL(videourl);
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
                    // Toast.makeText(getContext(), "Response Code:" + code, Toast.LENGTH_SHORT).show();

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

                JSONObject mainobj=new JSONObject(incomingresult);
                JSONArray resultsarray=mainobj.getJSONArray("results");


                if (resultsarray.length()==0){

                    Toast.makeText(ActionMoviesSelected.this,"Video is not available",Toast.LENGTH_LONG).show();
                }
                else {

                    JSONObject videoobject=resultsarray.getJSONObject(0);

                    String videokey=videoobject.getString("key");
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v="+videokey)));
                    Log.i("Video", "Video Playing....");


                }

            }
            catch(Exception ex){
                String err=ex.toString();
                Log.e("eee",err);

            }


        }
    }

}
