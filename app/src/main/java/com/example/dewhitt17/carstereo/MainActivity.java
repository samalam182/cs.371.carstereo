package com.example.dewhitt17.carstereo;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.os.Vibrator;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener{

    public ToggleButton power;
    public ToggleButton AMFM;
    public TextView FM;
    public TextView vol;
    public SeekBar volBar;
    public int amStation = 530;
    public int fmStation = 881;
    public Button forward;
    public Button backward;
    public Button one;
    public Button two;
    public Button three;
    public Button four;
    public Button five;
    public Button six;
    public int[] fmPreset = {909, 929, 949, 969, 989, 1009};
    public int[] amPreset = {550, 600, 650, 700, 750, 800};

    Vibrator v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        power = (ToggleButton) findViewById(R.id.Powerbutton);
        power.setOnClickListener(this);
        power.setBackgroundColor(Color.BLUE);

        AMFM = (ToggleButton) findViewById(R.id.AMFMTog);
        AMFM.setOnClickListener(this);

        FM = (TextView) findViewById(R.id.FMDisp);
        FM.setOnClickListener(this);
        FM.setText("" + amStation + " AM");

        vol = (TextView) findViewById(R.id.volDisp);
        vol.setOnClickListener(this);

        volBar = (SeekBar) findViewById(R.id.volbar);
        volBar.setOnClickListener(this);

        forward = (Button) findViewById(R.id.seekForward);
        forward.setOnClickListener(this);

        backward = (Button) findViewById(R.id.seekBack);
        backward.setOnClickListener(this);

        one = (Button) findViewById(R.id.preset1);
        one.setOnClickListener(this);
        one.setOnLongClickListener(this);

        two = (Button) findViewById(R.id.preset2);
        two.setOnClickListener(this);
        two.setOnLongClickListener(this);

        three = (Button) findViewById(R.id.preset3);
        three.setOnClickListener(this);
        three.setOnLongClickListener(this);

        four = (Button) findViewById(R.id.preset4);
        four.setOnClickListener(this);
        four.setOnLongClickListener(this);

        five = (Button) findViewById(R.id.preset5);
        five.setOnClickListener(this);
        five.setOnLongClickListener(this);

        six = (Button) findViewById(R.id.preset6);
        six.setOnClickListener(this);
        six.setOnLongClickListener(this);

        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.Powerbutton) {
            if (power.isChecked()) {
                power.setBackgroundColor(Color.BLUE);
                FM.setText("" + amStation + " AM");
                FM.setTextColor(Color.CYAN);
                volBar.setProgress(20);
                vol.setText("" + volBar.getProgress());
                vol.setTextColor(Color.BLUE);

            } else {
                power.setBackgroundColor(Color.RED);
                FM.setTextColor(Color.GRAY);
                FM.setText("Radio Off");
                vol.setText("0");
                vol.setTextColor(Color.GRAY);
                volBar.setProgress(0);
                AMFM.setChecked(false);
            }
        }
        if (view.getId() == R.id.AMFMTog) {
            if (AMFM.isChecked() && power.isChecked()) {
                FM.setText("" + (double)fmStation/10 + " FM");
            }
            else if(power.isChecked())
            {
                FM.setText("" + amStation + " AM");
            }
        }

        if(view.getId() == R.id.seekForward){
            if(AMFM.isChecked()  && power.isChecked()){
                fmStation += 2;
                if(fmStation > 1079)
                {
                    fmStation = 881;
                }
                FM.setText("" + (double)fmStation/10 + " FM");
            }
            else if(power.isChecked()){
                amStation += 10;
                if(amStation > 1700){
                    amStation = 530;
                }
                FM.setText("" + amStation + " AM");
            }
        }
        if(view.getId() == R.id.seekBack){
            if(AMFM.isChecked()  && power.isChecked()){
                fmStation -= 2;
                if(fmStation < 881)
                {
                    fmStation = 1079;
                }
                FM.setText("" + (double)fmStation/10 + " FM");
            }
            else if(power.isChecked()) {
                amStation -= 10;
                if(amStation < 530){
                    amStation = 1700;
                }
                FM.setText("" + amStation + " AM");
            }
        }

        if(view.getId() == R.id.preset1){
            if(AMFM.isChecked()  && power.isChecked()){
                FM.setText("" + (double)fmPreset[0]/10 + " FM");
                fmStation = fmPreset[0];
            }
            else if(power.isChecked()) {
                FM.setText("" + amPreset[0] + " AM");
                amStation = amPreset[0];
            }

        }

        if(view.getId() == R.id.preset2){
            if(AMFM.isChecked()  && power.isChecked()){
                FM.setText("" + (double)fmPreset[1]/10 + " FM");
                fmStation = fmPreset[1];
            }
            else if(power.isChecked()) {
                FM.setText("" + amPreset[1] + " AM");
                amStation = amPreset[1];
            }
        }

        if(view.getId() == R.id.preset3){
            if(AMFM.isChecked()  && power.isChecked()){
                FM.setText("" + (double)fmPreset[2]/10 + " FM");
                fmStation = fmPreset[2];
            }
            else if(power.isChecked()) {
                FM.setText("" + amPreset[2] + " AM");
                amStation = amPreset[2];
            }
        }

        if(view.getId() == R.id.preset4){
            if(AMFM.isChecked()  && power.isChecked()){
                FM.setText("" + (double)fmPreset[3]/10 + " FM");
                fmStation = fmPreset[3];
            }
            else if(power.isChecked()) {
                FM.setText("" + amPreset[3] + " AM");
                amStation = amPreset[3];
            }
        }

        if(view.getId() == R.id.preset5){
            if(AMFM.isChecked()  && power.isChecked()){
                FM.setText("" + (double)fmPreset[4]/10 + " FM");
                fmStation = fmPreset[4];
            }
            else if(power.isChecked()) {
                FM.setText("" + amPreset[4] + " AM");
                amStation = amPreset[4];
            }
        }

        if(view.getId() == R.id.preset6){
            if(AMFM.isChecked()  && power.isChecked()){
                FM.setText("" + (double)fmPreset[5]/10 + " FM");
                fmStation = fmPreset[5];
            }
            else if(power.isChecked()) {
                FM.setText("" + amPreset[5] + " AM");
                amStation = amPreset[5];
            }
        }


    }


    @Override
    public boolean onLongClick(View view) {
        if(view.getId() == R.id.preset1){
            if(AMFM.isChecked()  && power.isChecked()){
                fmPreset[0] = fmStation;
                v.vibrate(500);
            }
            else if(power.isChecked()) {
                amPreset[0] = amStation;
                v.vibrate(500);
            }

        }

        if(view.getId() == R.id.preset2){
            if(AMFM.isChecked()  && power.isChecked()){
                fmPreset[1] = fmStation;
                v.vibrate(500);
            }
            else if(power.isChecked()) {
                amPreset[1] = amStation;
                v.vibrate(500);
            }
        }

        if(view.getId() == R.id.preset3){
            if(AMFM.isChecked()  && power.isChecked()){
                fmPreset[2] = fmStation;
                v.vibrate(500);
            }
            else if(power.isChecked()) {
                amPreset[2] = amStation;
                v.vibrate(500);
            }
        }

        if(view.getId() == R.id.preset4){
            if(AMFM.isChecked()  && power.isChecked()){
                fmPreset[3] = fmStation;
                v.vibrate(500);
            }
            else if(power.isChecked()) {
                amPreset[3] = amStation;
                v.vibrate(500);
            }
        }

        if(view.getId() == R.id.preset5){
            if(AMFM.isChecked()  && power.isChecked()){
                fmPreset[4] = fmStation;
                v.vibrate(500);
            }
            else if(power.isChecked()) {
                amPreset[4] = amStation;
                v.vibrate(500);
            }
        }

        if(view.getId() == R.id.preset6){
            if(AMFM.isChecked()  && power.isChecked()){
                fmPreset[5] = fmStation;
                v.vibrate(500);
            }
            else if(power.isChecked()) {
                amPreset[5] = amStation;
                v.vibrate(500);
            }
        }
        return false;
    }
}

