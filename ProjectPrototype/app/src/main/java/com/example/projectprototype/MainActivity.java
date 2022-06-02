package com.example.projectprototype;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sPref;
    private final String RECORD_30 = "record_30";
    private final String RECORD_60 = "record_60";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        sPref = getPreferences(MODE_PRIVATE);
        Bundle extras = getIntent().getExtras();
        TextView textView30 = findViewById(R.id.textView30);
        String str = "RECORD: " + sPref.getInt(RECORD_30, 0);
        if (extras != null) {
            int value = extras.getInt("record30");
            if (value != 0) {
                str = "RECORD: " + value;
                SharedPreferences.Editor editor = sPref.edit();
                editor.putInt(RECORD_30, value);
                editor.commit();
            }
        }
        textView30.setText(str);
        TextView textView60 = findViewById(R.id.textView60);
        str = "RECORD: " + sPref.getInt(RECORD_60, 0);
        if (extras != null) {
            int value = extras.getInt("record60");
            if (value != 0) {
                str = "RECORD: " + value;
                SharedPreferences.Editor editor = sPref.edit();
                editor.putInt(RECORD_60, value);
                editor.commit();
            }
        }
        textView60.setText(str);
        ((Button) findViewById(R.id.button30)).setOnClickListener(v -> newGame(0));
        ((Button) findViewById(R.id.button60)).setOnClickListener(v -> newGame(1));
        ((Button) findViewById(R.id.buttonNoTime)).setOnClickListener(v -> newGame(2));
    }

    private void newGame(int gameNumber) {
        int time;
        int record;
        Intent intent = new Intent(this, GameActivity.class);
        switch (gameNumber) {
            case 0:
                time = 30;
                record = sPref.getInt(RECORD_30, 0);
                break;
            case 1:
                time = 60;
                record = sPref.getInt(RECORD_60, 0);
                break;
            default:
                time = 0;
                record = -1;
        }
        intent.putExtra("record", record);
        intent.putExtra("key", time);
        startActivity(intent);
    }
}