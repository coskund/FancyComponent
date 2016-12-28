package com.example.cokundeniz.fancycomponent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Display;
import android.widget.RelativeLayout;

public class actMain extends Activity {
    RelativeLayout rlBackground;
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;
    int intScreenWidth, intScreenHeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        GetScreenSize();
        BindControls();
    }

    private void GetScreenSize() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        intScreenWidth = size.x;
        intScreenHeight = size.y;
    }

    private void BindControls() {
        paint = new Paint();
        paint.setColor(Color.rgb(220,220,150));
        bitmap = Bitmap.createBitmap(intScreenWidth,intScreenHeight,Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.rgb(50,100,255));
        canvas.drawRoundRect(new RectF(100, 100, 200, 200), 20, 20, paint);
        BitmapDrawable drBackground = new BitmapDrawable(getResources(),bitmap);

        rlBackground = (RelativeLayout)findViewById(R.id.rlBackground);
        rlBackground.setBackgroundDrawable(drBackground);
    }

    private void Test (){
        int i = 1 + 1 ;
        String strName = "Coşkun";
        String strSurname = "Deniz";
    }
}
