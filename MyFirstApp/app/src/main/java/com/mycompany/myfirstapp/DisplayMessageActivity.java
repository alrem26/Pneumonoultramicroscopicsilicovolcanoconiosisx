package com.mycompany.myfirstapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DisplayMessageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get the message from the intent
        setContentView(R.layout.activity_display_message);
        Button category = (Button) findViewById(R.id.categories);
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(DisplayMessageActivity.this, Categories.class);
                DisplayMessageActivity.this.startActivity(intent);
            }
        });
        //Create Text View

        //Set Text view as the activity layout (I have no idea what I am doing huehue)

    }
}
