package com.example.sunilkumar.yourcinema;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class horrorcusomadapater extends ArrayAdapter {

    int pics[] = {R.drawable.horror1, R.drawable.horror2, R.drawable.horror3, R.drawable.horror4, R.drawable.horror5};
    static String names[] = {"Demolition (1993)", "300 (2007)", "Running Scarred (1986)", "Crank (2006)", "Desprado (1995)"};
    final float rat[] = {2.5f, 4.5f, 3.5f, 3.6f, 5.0f};

    String dis[] = {"Synopis : The plot of this action film beng in 1996 with los angles in a voilence-razed conflagration",
            "Synopis : Sin city author frank miller's sweeping take on the historic battle of themopylae comes to the screen courtesy of dawn",
            "Synopis : distinguished by a sharp witty dialoge beetween its two cop protagonist ray and danny ",
            "Synopis : distinguished by a sharp witty dialoge beetween its two cop protagonist ray and danny ",
            "Synopis : distinguished by a sharp witty dialoge beetween its two cop protagonist ray and danny ",
    };


    Context context;

    public horrorcusomadapater(Context context)

    {
        super(context, R.layout.activity_custom_adapter, names);
        this.context = context;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View customview = inflater.inflate(R.layout.activity_horrorcusomadapater, null);
        ImageView img = (ImageView) customview.findViewById(R.id.imageView7);
        img.setImageResource(pics[position]);

        TextView txname = (TextView) customview.findViewById(R.id.textView17);
        txname.setText(names[position]);

        RatingBar rates = (RatingBar) customview.findViewById(R.id.ratingBar);
        rates.setRating(rat[position]);

        TextView mb = (TextView) customview.findViewById(R.id.textView25);
        mb.setText(dis[position]);

        return customview;

    }
}
