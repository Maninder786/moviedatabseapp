package com.example.sunilkumar.yourcinema;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,
            image11,image12,image13,image14,image15,image16,image17,image18
            ,image19,image20,image21,image22,image23,image24,image25,image26,image27,image28,image29,image30;

    TextView text1,text2,text3,text4,text5,text6,text7,text9,text10,text11,text12,text13,text14,text15,text16,text17,text18,text19,text20,
            text21,text22,text23,text24,text25,text26,
    text27,text28,text29,text30,text31,text32,text33,text34,text35,text36;
    public HomeFragment() {
        // Required empty public const1ructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_home, container, false);

                image1=(ImageView)view.findViewById(R.id.ActionM1);
               image2=(ImageView)view.findViewById(R.id.ActionM2);
               image3=(ImageView)view.findViewById(R.id.ActionM3);
                image4=(ImageView)view.findViewById(R.id.ActionM4);
                image5=(ImageView)view.findViewById(R.id.ActionM5);
                image6=(ImageView)view.findViewById(R.id.ActionM6);

                image7=(ImageView)view.findViewById(R.id.AdvantureM1);
                image8=(ImageView)view.findViewById(R.id.AdvantureM2);
                image9=(ImageView)view.findViewById(R.id.AdvantureM3);
                image10=(ImageView)view.findViewById(R.id.AdvantureM4);
                image11=(ImageView)view.findViewById(R.id.AdvantureM5);
                image12=(ImageView)view.findViewById(R.id.AdvantureM6);

                image13=(ImageView)view.findViewById(R.id.Comedym1);
                image14=(ImageView)view.findViewById(R.id.Comedym2);
                image15=(ImageView)view.findViewById(R.id.Comedym3);
                image16=(ImageView)view.findViewById(R.id.Comedym4);
                image17=(ImageView)view.findViewById(R.id.Comedym5);
                image18 =(ImageView)view.findViewById(R.id.Comedym6);


                image19=(ImageView)view.findViewById(R.id.Crimem1);
                image20=(ImageView)view.findViewById(R.id.Crimem2);
                image21=(ImageView)view.findViewById(R.id.crimem3);
                image22=(ImageView)view.findViewById(R.id.Crimem4);
                image23=(ImageView)view.findViewById(R.id.Crimem5);
                image24=(ImageView)view.findViewById(R.id.Crimem6);

                image25=(ImageView)view.findViewById(R.id.horrorm1);
                image26=(ImageView)view.findViewById(R.id.horrorm2);
                image27=(ImageView)view.findViewById(R.id.horrorm3);
                image28=(ImageView)view.findViewById(R.id.horrorm4);
                image29=(ImageView)view.findViewById(R.id.horrorm5);
                image30=(ImageView)view.findViewById(R.id.horrorm6);


                text1=(TextView)view.findViewById(R.id.horrort1);
                text4=(TextView)view.findViewById(R.id.horrort2);
                text5=(TextView)view.findViewById(R.id.horrort3);
                text6=(TextView)view.findViewById(R.id.horrort4);
                text7=(TextView)view.findViewById(R.id.horrort5);
                text9=(TextView)view.findViewById(R.id.horrort6);

               text10=(TextView)view.findViewById(R.id.Crime01);
                text11=(TextView)view.findViewById(R.id.crimet1);
                text12=(TextView)view.findViewById(R.id.crimet2);
                text13=(TextView)view.findViewById(R.id.crimet3);
                text14=(TextView)view.findViewById(R.id.crimet4);
                text15=(TextView)view.findViewById(R.id.crimet5);
                text16=(TextView)view.findViewById(R.id.crimet6);


                text17=(TextView)view.findViewById(R.id.Comedy01);
                text18=(TextView)view.findViewById(R.id.Comedy1);
                text19=(TextView)view.findViewById(R.id.Comedy2);
                text20=(TextView)view.findViewById(R.id.Comedy3);
                text21=(TextView)view.findViewById(R.id.Comedy4);
                text22=(TextView)view.findViewById(R.id.Comedy5);
                text23=(TextView)view.findViewById(R.id.Comedy6);

                text24=(TextView)view.findViewById(R.id.AdvantureT01);
                text25=(TextView)view.findViewById(R.id.AdvantureT1);
                text26=(TextView)view.findViewById(R.id.AdvantureT2);
                text27=(TextView)view.findViewById(R.id.AdvantureT3);
                text28=(TextView)view.findViewById(R.id.AdvantureT4);
                text29=(TextView)view.findViewById(R.id.AdvantureT5);
                text30=(TextView)view.findViewById(R.id.AdvantureT6);

                text31=(TextView)view.findViewById(R.id.ActionT01);
                text32=(TextView)view.findViewById(R.id.ActionT1);
                text33=(TextView)view.findViewById(R.id.ActionT2);
                text34=(TextView)view.findViewById(R.id.ActionT3);
                text35=(TextView)view.findViewById(R.id.ActionT4);
                text36=(TextView)view.findViewById(R.id.ActionT5);
            text36=(TextView)view.findViewById(R.id.ActionT6);


        return view;
    }

}
