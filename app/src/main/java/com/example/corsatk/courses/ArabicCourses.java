package com.example.corsatk.courses;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.corsatk.R;
import com.example.corsatk.adapters.ImageArabicAdapter;
import com.example.corsatk.controller.CourseDetails;

import java.util.ArrayList;

public class ArabicCourses extends AppCompatActivity {
    public static String PlayList_ID;
    private GridView gridView;
    GridView gv;
   private Context context;
    private ArrayList prgmName;
    public static String [] mCourseName={
            "OOP",
            "C++",
            "C#",
            "JavaBeginner",
            "JavaAdvanced",
            "Python",
            "ASP",
            "PHP",
            "AndroidBeginner",
            "AndroidAdvanced",
            "IOSBeginner",
            "IOSAdvanced",
            "SQL",
            "Kotlin"};
    public static int [] mCourseImage={
            R.drawable.oop,
            R.drawable.cpp,
            R.drawable.c_sharp,
            R.drawable.java_bgn,
            R.drawable.java_adv,
            R.drawable.python,
            R.drawable.asp,
            R.drawable.php,
            R.drawable.and_bgn,
            R.drawable.and_adn,
            R.drawable.ios_bgn,
            R.drawable.ios_adv,
            R.drawable.sql,
            R.drawable.kotlin
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic_courses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Arabic Courses");

        //implement arrow button
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                onBackPressed();
            }
        });


        gridView = (GridView) findViewById(R.id.gridviewArabic);
        gridView.setAdapter(new ImageArabicAdapter(this, mCourseName,mCourseImage));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                switch (position){
                    // OOP
                    case 0:
                        PlayList_ID="PLb7yniFBnvZIdfxYIKqNlGsTf5oZy4dKk";
                        Intent intent0 = new Intent(getBaseContext(), CourseDetails.class);
                        intent0.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent0);
                        break;
                    // C++
                    case 1:
                        PlayList_ID="PLb7yniFBnvZIb5L73SxP-ot22gpZjezc_";
                        Intent intent = new Intent(getBaseContext(), CourseDetails.class);
                        intent.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent);
                        break;
                    //C#
                    case 2:
                        PlayList_ID="PLwj1YcMhLRN24KqNI0xQrNscBfLnYeJpL";
                        Intent intent2 = new Intent(getBaseContext(), CourseDetails.class);
                        intent2.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent2);
                        break;
                    //Java Basic
                    case 3:
                        PlayList_ID="PL28DDB2DCF87BEE43";
                        Intent intent3 = new Intent(getBaseContext(), CourseDetails.class);
                        intent3.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent3);
                        break;
                    // Java Advanced
                    case 4:
                        PlayList_ID="PLfJcnsgJ9GzIdv5sgL0jsaD1uXaj5myoE";
                        Intent intent4 = new Intent(getBaseContext(), CourseDetails.class);
                        intent4.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent4);
                        break;
                    // Paython
                    case 5:
                        PlayList_ID="PLMYF6NkLrdN8cn_nUolvhrGOOLIBybEsw";
                        Intent intent5 = new Intent(getBaseContext(), CourseDetails.class);
                        intent5.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent5);
                        break;
                    //ASP
                    case 6:
                        PlayList_ID="PLCIJjtzQPZJ86NI0dqvIpIgMEG9gLrHz7";
                        Intent intent6 = new Intent(getBaseContext(), CourseDetails.class);
                        intent6.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent6);
                        break;
                    //PHP
                    case 7:
                        PlayList_ID="PLDoPjvoNmBAzH72MTPuAAaYfReraNlQgM";
                        Intent intent7 = new Intent(getBaseContext(), CourseDetails.class);
                        intent7.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent7);
                        break;
                    //android basic
                    case 8:
                        PlayList_ID="PLF8OvnCBlEY3e0Yg990aAXreEru72_xWN";
                        Intent intent8 = new Intent(getBaseContext(), CourseDetails.class);
                        intent8.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent8);
                        break;
                    //advanced android
                    case 9:
                        PlayList_ID="PLF8OvnCBlEY3F9R_L67uCuFQuWULClfag";
                        Intent intent9 = new Intent(getBaseContext(), CourseDetails.class);
                        intent9.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent9);
                        break;
                    //ios beginner
                    case 10:
                        PlayList_ID="PLWjfdJAqv4PYPU4WsAm33euck2aJCHvzA";
                        Intent intent10 = new Intent(getBaseContext(), CourseDetails.class);
                        intent10.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent10);
                        break;
                    //ios advanced
                    case 11:
                        PlayList_ID="PLF8OvnCBlEY1BC20Bl73DuyW3LE5sGCUH";
                        Intent intent11 = new Intent(getBaseContext(), CourseDetails.class);
                        intent11.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent11);
                        break;
                    // sql
                    case 12:
                        PlayList_ID="PLq7cQMGDozxXdbbuyPdJFFMIqYeux4lSH";
                        Intent intent12 = new Intent(getBaseContext(), CourseDetails.class);
                        intent12.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent12);
                        break;
                    // Kotin
                    case 13:
                        PlayList_ID="PLs97GbUOC82kEg7WNUG5mw9eueXH0BegQ";
                        Intent intent13 = new Intent(getBaseContext(), CourseDetails.class);
                        intent13.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent13);
                        break;

                }
            }
        });


    }
}
