package com.example.projectprototype;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageButton;

import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends FragmentActivity {

    private Figure.ArraysHelper arraysHelper;
    private Handler handlerTime;
    private TextView textViewPoints;
    private int time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        time = getIntent().getExtras().getInt("key");
        switch (time) {
            case 30:
                startGame(30);
                break;
            case 60:
                startGame(60);
                break;
            default:
                startGame(0);
        }
    }



    private void startTimer(int time) {
        Timer timer = new Timer();
        timer.schedule(new TimeHelper(time), 0, 1000);
    }

    private void endGame() {
        Intent intent = new Intent(this, MainActivity.class);
        if (getIntent().getExtras().getInt("record") < arraysHelper.getGamePoints()) {
            intent.putExtra("record" + time, Integer.valueOf(arraysHelper.getGamePoints()));
        }
        startActivity(intent);
    }

    private void startGame(int time) {
        TextView textView;
        textView = (TextView) findViewById(R.id.textView);
        if (time == 0) {
            textView.setVisibility(View.INVISIBLE);
            time = 0x7fffffff;
        }
        textViewPoints = (TextView) findViewById(R.id.textViewPoints);
        String str = "POINTS: 0";
        textViewPoints.setText(str);
        handlerTime = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                String str = "TIME: " + msg.what;
                textView.setText(str);
                textView.invalidate();

            }
        };
        Figure figure = new Figure();
        arraysHelper = figure.new ArraysHelper(textViewPoints);
        arraysHelper.fillArray();
        setMatrix();
        arraysHelper.setButtons();
        startTimer(time);
    }

    private void setMatrix() {
        int counter = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                switch (counter) {
                    case 0:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image1));
                        break;
                    case 1:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image2));
                        break;
                    case 2:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image3));
                        break;
                    case 3:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image4));
                        break;
                    case 4:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image5));
                        break;
                    case 5:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image6));
                        break;
                    case 6:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image7));
                        break;
                    case 7:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image8));
                        break;
                    case 8:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image9));
                        break;
                    case 9:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image10));
                        break;
                    case 10:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image11));
                        break;
                    case 11:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image12));
                        break;
                    case 12:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image13));
                        break;
                    case 13:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image14));
                        break;
                    case 14:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image15));
                        break;
                    case 15:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image16));
                        break;
                    case 16:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image17));
                        break;
                    case 17:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image18));
                        break;
                    case 18:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image19));
                        break;
                    case 19:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image20));
                        break;
                    case 20:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image21));
                        break;
                    case 21:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image22));
                        break;
                    case 22:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image23));
                        break;
                    case 23:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image24));
                        break;
                    case 24:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image25));
                        break;
                    case 25:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image26));
                        break;
                    case 26:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image27));
                        break;
                    case 27:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image28));
                        break;
                    case 28:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image29));
                        break;
                    case 29:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image30));
                        break;
                    case 30:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image31));
                        break;
                    case 31:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image32));
                        break;
                    case 32:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image33));
                        break;
                    case 33:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image34));
                        break;
                    case 34:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image35));
                        break;
                    case 35:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image36));
                        break;
                    case 36:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image37));
                        break;
                    case 37:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image38));
                        break;
                    case 38:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image39));
                        break;
                    case 39:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image40));
                        break;
                    case 40:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image41));
                        break;
                    case 41:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image42));
                        break;
                    case 42:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image43));
                        break;
                    case 43:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image44));
                        break;
                    case 44:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image45));
                        break;
                    case 45:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image46));
                        break;
                    case 46:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image47));
                        break;
                    case 47:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image48));
                        break;
                    case 48:
                        arraysHelper.putButton(j, i, (ImageButton) findViewById(R.id.image49));
                        break;
                }
                counter++;
            }
        }
    }

    class TimeHelper extends TimerTask {

        private int time;

        public TimeHelper(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            if (time >= 0) {
                handlerTime.sendEmptyMessage(time);
                time--;
            } else {
                endGame();
                cancel();
            }
        }
    }
}
