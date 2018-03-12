package com.example.sunilkumar.yourcinema;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {


    String imgurl="http://image.tmdb.org/t/p/w300";

    Context context;
    ArrayList<String> idlist,namelist,picnamelist,descrlist,reldatelist;
    ArrayList<Float> ratlist;

    public CustomAdapter(Context context, ArrayList<String> idlist,ArrayList<String> namelist,ArrayList<String> picnamelist,ArrayList<String> descrlist,ArrayList<String> reldatelist,ArrayList<Float> ratlist)

    {
        super(context,R.layout. activity_custom_adapter,namelist);
        this.context=context;
        this.idlist=idlist;
        this.namelist=namelist;
        this.ratlist=ratlist;
        this.descrlist=descrlist;
        this.picnamelist=picnamelist;
        this.reldatelist=reldatelist;
    }



    public View getView(final int position, final View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View customview=inflater.inflate(R.layout.activity_custom_adapter,null);
        ImageView img=(ImageView)customview.findViewById(R.id.imageView7);

        Picasso.with(context)
                .load(imgurl+picnamelist.get(position))
                .placeholder(R.drawable.logoo)

                .into(img);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

              String mname=namelist.get(position);
                String picname=imgurl+picnamelist.get(position);
                String desc=descrlist.get(position);
                String movieid=idlist.get(position);
                float rating=ratlist.get(position);
                String rdate=reldatelist.get(position);
                Bundle bd=new Bundle();
                bd.putString("mname",mname);
                bd.putString("picname",picname);
                bd.putString("desc",desc);
                bd.putString("rdate",rdate);
                bd.putFloat("rating",rating);
                bd.putString("id",movieid);
                Intent intent=new Intent(context,ActionMoviesSelected.class);
                intent.putExtra("minfo",bd);
                 context.startActivity(intent);

                Toast.makeText(context,mname,Toast.LENGTH_LONG).show();






            }
        });

        TextView txname=(TextView)customview.findViewById(R.id.textView17);
        txname.setText(namelist.get(position));

        RatingBar rates=(RatingBar)customview.findViewById(R.id.ratingBar);
        rates.setRating(ratlist.get(position)/2);

        TextView mb=(TextView)customview.findViewById(R.id.textView25);
        mb.setText(descrlist.get(position));

        return customview;
    }




}
