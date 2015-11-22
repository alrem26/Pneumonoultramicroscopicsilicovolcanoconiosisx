package com.mycompany.myfirstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.io.InputStream;
import java.util.List;


public class TuitionFee extends ActionBarActivity {

   // Firebase myFirebaseRef = new Firebase("https://blistering-torch-4665.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuition_fee);
        Button goToFeedback = (Button) findViewById(R.id.feedbackbutton);

        goToFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(TuitionFee.this, WriteAComment.class);
                TuitionFee.this.startActivity(intent);
            }
        });

       /* final TextView usrnm = (TextView) findViewById(R.id.name);
        myFirebaseRef.child("username").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                  //prints "Do you have data? You'll love Firebase."
                  usrnm.setText(snapshot.getValue().toString());
            }

            @Override public void onCancelled(FirebaseError error) { }

        });*/
    }


    /*public void newTextRight(String message) {

        TextView msg = new TextView(TuitionFee.this);
        msg.setText(message);
        msg.setPadding(10, 10, 10, 10);
        msg.setTextColor(getResources().getColor(R.color.bgColor));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(5, 15, 0, 0);
        params.gravity = Gravity.RIGHT;
        msg.setLayoutParams(params);
        msg.setGravity(Gravity.CENTER);
        LinearLayout chat = (LinearLayout) findViewById(R.id.tuitionlayout);
        chat.addView(msg);
    }

    public void newTextLeft(String message) {

        TextView msg = new TextView(TuitionFee.this);
        msg.setText(message);
        msg.setPadding(10, 10, 10, 10);
        msg.setTextColor(getResources().getColor(R.color.bgColor));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(5, 15, 0, 0);
        params.gravity = Gravity.LEFT;
        msg.setLayoutParams(params);
        msg.setGravity(Gravity.CENTER);
        LinearLayout chat = (LinearLayout) findViewById(R.id.tuitionlayout);
        chat.setOrientation(LinearLayout.VERTICAL);
        chat.addView(msg);
    } */
}
