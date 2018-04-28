package id.aashari.code.camerascanner.Helpers;

import android.graphics.Bitmap;

public class NativeClass {

    static {
        System.loadLibrary("opencv_java3");
        System.loadLibrary("Scanner");
    }

    public native Bitmap getScannedBitmap(Bitmap bitmap, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4);

    public native Bitmap getGrayBitmap(Bitmap bitmap);

    public native Bitmap getMagicColorBitmap(Bitmap bitmap);

    public native Bitmap getBWBitmap(Bitmap bitmap);

    public native float[] getPoints(Bitmap bitmap);

}
