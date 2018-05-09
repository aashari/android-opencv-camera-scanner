package id.aashari.code.camerascannertesting2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

import id.aashari.code.camerascannertesting2.helpers.MyConstants;

public class MainActivity extends AppCompatActivity {

    Button btnOpenGallery;
    Button btnImageProcess;

    ImageView imageView;

    Uri selectedImage;
    Bitmap selectedBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeElement();
        initializeEvent();
    }

    private void initializeElement() {
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.btnOpenGallery = (Button) findViewById(R.id.btnOpenGallery);
        this.btnImageProcess = (Button) findViewById(R.id.btnImageProcess);
    }

    private void initializeEvent() {
        this.btnOpenGallery.setOnClickListener(this.btnOpenGalleryClick);
        this.btnImageProcess.setOnClickListener(this.btnImageProcessClick);
    }

    private View.OnClickListener btnOpenGalleryClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, MyConstants.GALLERY_IMAGE_LOADED);
        }
    };

    private View.OnClickListener btnImageProcessClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //save selected bitmap to our constants
            //this method will save the image to our device memory
            //so set this variable to null after the image is no longer used
            MyConstants.selectedImageBitmap = selectedBitmap;

            //create new intent to start process image
            Intent intent = new Intent(getApplicationContext(), ImageCropActivity.class);
            startActivity(intent);

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MyConstants.GALLERY_IMAGE_LOADED && resultCode == RESULT_OK && data != null) {
            selectedImage = data.getData();
            this.loadImage();
        }
    }

    private void loadImage() {
        try {
            InputStream inputStream = getContentResolver().openInputStream(this.selectedImage);
            selectedBitmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(selectedBitmap);
            btnImageProcess.setVisibility(View.VISIBLE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
