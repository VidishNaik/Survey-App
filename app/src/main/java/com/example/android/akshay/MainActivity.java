package com.example.android.akshay;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int in;
    int out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        in = sharedPref.getInt("in", 0);
        out = sharedPref.getInt("out", 0);
        TextView t=(TextView) findViewById(R.id.indoortext);
        t.setText(String.valueOf(in));
        t=(TextView) findViewById(R.id.outdoortext);
        t.setText(String.valueOf(out));
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences("mypref", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("in",in);
        editor.putInt("out",out);
        editor.commit();
    }

    public void indoor(View v)
    {
       in=in+1;
        displayin(in);
    }
    public void outdoor(View v)
    {
        out=out+1;
        displayout(out);
    }
    public void reset(View v)
    {
        out=0;
        in=0;
        displayout(out);
        displayin(in);
    }
    public void displayin(int a)
    {
        TextView t=(TextView) findViewById(R.id.indoortext);
        t.setText(String.valueOf(a));
    }
    public void displayout(int a)
    {
        TextView t=(TextView) findViewById(R.id.outdoortext);
        t.setText(String.valueOf(a));
    }
}
