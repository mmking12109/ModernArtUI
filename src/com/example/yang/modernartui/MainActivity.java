package com.example.yang.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;

    // Colored blocks. First number is row, second is column.
    private TextView block11;
    private TextView block12;
    private TextView block21;
    private TextView block22;
    private TextView block31;
    private TextView block32;
    private TextView block_right;

    // Colors
    // Feel free to change them. There are plenty of colors to choose from in colors.xml
    // Just update the stuff in onCreate to get the correct colors.
    int start11, start12, start21, start22, start31, start32, start_right;
    int end11, end12, end21, end22, end31, end32, end_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start11 = getResources().getColor(R.color.SkyBlue);
        start12 = getResources().getColor(R.color.Goldenrod);
        start21 = getResources().getColor(R.color.SlateBlue);
        start22 = getResources().getColor(R.color.white);
        start31 = getResources().getColor(R.color.DarkGray);
        start32 = getResources().getColor(R.color.HotPink);
        start_right = getResources().getColor(R.color.green);

        end11 = getResources().getColor(R.color.bloo);
        end12 = getResources().getColor(R.color.Yellow);
        end21 = getResources().getColor(R.color.LightPink);
        end32 = getResources().getColor(R.color.Salmon);
        end_right = getResources().getColor(R.color.MediumPurple);

        seekBar = (SeekBar)findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float ratio = i / 100f;

                block11.setBackgroundColor(interpolateColor(start11, end11, ratio));
                block12.setBackgroundColor(interpolateColor(start12, end12, ratio));
                block21.setBackgroundColor(interpolateColor(start21, end21, ratio));
                block32.setBackgroundColor(interpolateColor(start32, end32, ratio));
                block_right.setBackgroundColor(interpolateColor(start_right, end_right, ratio));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        });

        // Find blocks
        block11 = (TextView)findViewById(R.id.block11);
        block12 = (TextView)findViewById(R.id.block12);
        block21 = (TextView)findViewById(R.id.block21);
        block22 = (TextView)findViewById(R.id.block22);
        block31 = (TextView)findViewById(R.id.block31);
        block32 = (TextView)findViewById(R.id.block32);
        block_right = (TextView)findViewById(R.id.block_right);

        // Set background colors
        block11.setBackgroundColor(start11);
        block12.setBackgroundColor(start12);
        block21.setBackgroundColor(start21);
        block22.setBackgroundColor(start22);
        block31.setBackgroundColor(start31);
        block32.setBackgroundColor(start32);
        block_right.setBackgroundColor(start_right);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.get_more_info:
                Dialog dialog = new MOMADialog(this);
                dialog.show();
                return true;
            default:
                return false;
        }

    }

    private float interpolate(float a, float b, float proportion) {
        return (a + ((b - a) * proportion));
    }

    // Returns an interpolated color, between a and b
    private int interpolateColor(int a, int b, float proportion) {
        float[] hsva = new float[3];
        float[] hsvb = new float[3];
        Color.colorToHSV(a, hsva);
        Color.colorToHSV(b, hsvb);
        for (int i = 0; i < 3; i++) {
            hsvb[i] = interpolate(hsva[i], hsvb[i], proportion);
        }
        return Color.HSVToColor(hsvb);
    }


}
