package com.example.applicationlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView text;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        showToast("onCreate has happened");
    }


    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart has happened");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("onResume has happened");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("onPause has happened");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop has happened");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy has happened");
    }

    void showToast (String message){
        String time = time();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        String list = messageList(text.getText().toString());
        text.setText(String.format(list + "\n" + message + " at " + time));
    }

    String time(){
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        return timeFormat.format(date);
    }

    String messageList(String string){
        String [] list = string.split("\n");
        if (list.length>6) {
            return String.join("\n", Arrays.copyOfRange(list, 1, list.length));
        }
        return string;
    }


}