package org.techtown.project_elect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;

public class Colorchange extends Fragment {

    static int[] cilckedcolor;
    static int[] color;
    static int in;
    static int ch;
    static Button schedule_button;
    static Button major_button;
    static Button more_button;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static Colorchange newInstance(int[] a, int[] b, Button b1, Button b2, Button b3) {
        cilckedcolor = a;
        color = b;
        schedule_button = b1;
        major_button = b2;
        more_button = b3;
        in=0;
        ch=0;
        return new Colorchange();
    }
    static void check(int a){
        ch=a;

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.color, container, false);


        final RadioButton red = view.findViewById(R.id.red);
        final RadioButton green = view.findViewById(R.id.green);
        final  RadioButton orenge = view.findViewById(R.id.orenge);
        final  RadioButton black = view.findViewById(R.id.black);
        final  RadioButton bule = view.findViewById(R.id.blue);

        switch (ch){
            case 0:bule.setChecked(true);break;
            case 1:green.setChecked(true);break;
            case 2:red.setChecked(true);break;
            case 3:black.setChecked(true);break;
            case 4:orenge.setChecked(true);break;
        }

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                more_button.setBackgroundColor(cilckedcolor[2]);
                schedule_button.setBackgroundColor(color[2]);
                major_button.setBackgroundColor(color[2]);
                in = 2;

            }
        });

        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                more_button.setBackgroundColor(cilckedcolor[3]);
                schedule_button.setBackgroundColor(color[3]);
                major_button.setBackgroundColor(color[3]);

                in=3;
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                more_button.setBackgroundColor(cilckedcolor[1]);
                schedule_button.setBackgroundColor(color[1]);
                major_button.setBackgroundColor(color[1]);
                in = 1;

            }
        });

        orenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                more_button.setBackgroundColor(cilckedcolor[4]);
                schedule_button.setBackgroundColor(color[4]);
                major_button.setBackgroundColor(color[4]);
                in = 4;

            }
        });

        bule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                more_button.setBackgroundColor(cilckedcolor[0]);
                schedule_button.setBackgroundColor(color[0]);
                major_button.setBackgroundColor(color[0]);
                in = 0;

            }
        });

        return view;
    }

    static int getindex() {
        int index = in;
        return index;
    }
}
