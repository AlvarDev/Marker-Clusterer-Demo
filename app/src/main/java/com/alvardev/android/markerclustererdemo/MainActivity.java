package com.alvardev.android.markerclustererdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btWith;
    private Button btWithout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();
        setActions();
    }

    private void setUI(){
        btWith = (Button) findViewById(R.id.bt_with);
        btWithout = (Button) findViewById(R.id.bt_without);
    }

    private void setActions(){
        btWith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(MapsWithActivity.class);
            }
        });

        btWithout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(MapsWithoutActivity.class);
            }
        });
    }

    private void goTo(Class cls){
        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);

    }

}
