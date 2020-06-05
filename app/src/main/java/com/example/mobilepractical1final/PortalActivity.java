package com.example.mobilepractical1final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class PortalActivity extends AppCompatActivity {

    private ImageView PostImage;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);
        Button btn = (Button)findViewById(R.id.Return);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PortalActivity.this, MyListActivity.class));
            }
        });

        PostImage = (ImageView)findViewById(R.id.post_Image);
        PostImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery, "Select Picture"), PICK_IMAGE);
            }


        });

    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK){
            imageUri = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                PostImage.setImageBitmap(bitmap);

            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

}
