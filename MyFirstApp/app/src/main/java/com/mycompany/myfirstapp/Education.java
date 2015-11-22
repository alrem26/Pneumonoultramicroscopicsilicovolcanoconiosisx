package com.mycompany.myfirstapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.util.List;


public class Education extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        Button tuitionFeeButton = (Button) findViewById(R.id.buttontutionfee);
        tuitionFeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Education.this, TuitionFee.class);
                Education.this.startActivity(intent);
            }
        });



    }

}
