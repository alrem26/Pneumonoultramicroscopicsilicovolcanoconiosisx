package com.mycompany.myfirstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;


public class WriteAComment extends ActionBarActivity {
    public static final int CAMERA_REQUEST = 10;
    ImageView containerImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_acomment);
        Firebase.setAndroidContext(this);
        final Firebase myFirebaseRef = new Firebase("https://blistering-torch-4665.firebaseio.com/");
        Button feed = (Button) findViewById(R.id.feed);
        Button camera = (Button) findViewById(R.id.camerabutton);
        containerImage = (ImageView) findViewById(R.id.imageView4);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText comment = (EditText) findViewById(R.id.comme);
                EditText username = (EditText) findViewById(R.id.nameuser);
                Firebase postRef = myFirebaseRef.child("posts");
                Map<String, String> post1 = new HashMap<String, String>();
                post1.put("username", username.getText().toString());
                post1.put("comment", comment.getText().toString());
                String encodedImage = encodeTobase64(getImageBit());
                post1.put("imageKey", encodedImage.toString());
                postRef.push().setValue(post1);


            }
        });




    }

    public static String encodeTobase64(Bitmap image)
    {
        Bitmap immagex=image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        return imageEncoded;
    }
    Bitmap imagetoBeSaved;

   public Bitmap getImageBit(){
       return imagetoBeSaved;
   }
    public void setImageBitMapp(Bitmap bit){
        imagetoBeSaved = bit;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        //Did the user chose OK? If so the if statement inside will execute
        if(resultCode==RESULT_OK){
            if(requestCode==CAMERA_REQUEST){
                //WE ARE HEARING FROM THE CAMERA
                Bitmap cameraImage = (Bitmap) data.getExtras().get("data");
                containerImage.setImageBitmap(cameraImage);
                setImageBitMapp(cameraImage);
            }
        }

    }
}
