package com.example.sunilkumar.yourcinema;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ActorDetailsActivity extends AppCompatActivity {

    TextView detailsTV ,actorTv;
    String actionurl;
    ProgressDialog pd;
    String json_string ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_details);
        detailsTV=(TextView)findViewById(R.id.textViewActorProfile);
        actorTv=(TextView)findViewById(R.id.textViewActorname);

        Intent intent=getIntent();
        Bundle bd=intent.getBundleExtra("info");


        String id = bd.getString("id");
        String actorname = bd.getString("actorname");
        actorTv.setText("About "+actorname);


        actionurl = "https://api.themoviedb.org/3/person/"+ id+"?api_key=dd958aab0d5a41dd11a54e9791f5c00a&language=en-US";
new biographyprocess().execute();
    }

    class biographyprocess extends AsyncTask<Void,Void,Void>
    {
        String incomingresult;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           pd =new ProgressDialog(ActorDetailsActivity.this);
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
                String biography=mainobj.getString("biography");
                if(!biography.equals(""))
                {
                    detailsTV.setText(biography);

                }
                else
                {
                    detailsTV.setText("Biography is not available");

                }


            }
            catch(Exception ex){
                String err=ex.toString();
                Log.e("eee",err);

            }


        }
    }
}
