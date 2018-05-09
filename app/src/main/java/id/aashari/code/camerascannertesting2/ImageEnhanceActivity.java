package id.aashari.code.camerascannertesting2;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import id.aashari.code.camerascannertesting2.helpers.MyConstants;
import id.aashari.code.camerascannertesting2.libraries.NativeClass;

public class ImageEnhanceActivity extends AppCompatActivity {

    ImageView imageView;
    Bitmap selectedImageBitmap;

    Button btnImageToBW;
    Button btnImageToMagicColor;
    Button btnImageToGray;

    NativeClass nativeClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_enhance);

        initializeElement();
        initializeImage();
    }

    private void initializeElement() {

        nativeClass = new NativeClass();

        imageView = findViewById(R.id.imageView);
        btnImageToGray = findViewById(R.id.btnImageToGray);
        btnImageToBW = findViewById(R.id.btnImageToBW);
        btnImageToMagicColor = findViewById(R.id.btnImageToMagicColor);

        btnImageToBW.setOnClickListener(btnImageToBWClick);
        btnImageToMagicColor.setOnClickListener(btnImageToMagicColorClick);
        btnImageToGray.setOnClickListener(btnImageToGrayClick);

    }

    private void initializeImage() {

        selectedImageBitmap = MyConstants.selectedImageBitmap;
        MyConstants.selectedImageBitmap = null;

        imageView.setImageBitmap(selectedImageBitmap);

    }

    private View.OnClickListener btnImageToBWClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO: create BW
            //imageView.setImageBitmap(nativeClass.getBWBitmap(selectedImageBitmap));
        }
    };

    private View.OnClickListener btnImageToMagicColorClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO: create magic color
            //imageView.setImageBitmap(nativeClass.getMagicColorBitmap(selectedImageBitmap));
        }
    };

    private View.OnClickListener btnImageToGrayClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO: create Gray
            //imageView.setImageBitmap(nativeClass.getGrayBitmap(selectedImageBitmap));
        }
    };


}
