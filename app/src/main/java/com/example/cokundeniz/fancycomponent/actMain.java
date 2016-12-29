package com.example.cokundeniz.fancycomponent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
        rlBackground = (RelativeLayout)findViewById(R.id.rlBackground);


        new CountDownTimer(10000,100) {
            int i=0;
            public void onTick(long millisUntilFinished) {
                i++;
                bitmap = Bitmap.createBitmap(intScreenWidth,intScreenHeight,Bitmap.Config.ARGB_8888);
                canvas = new Canvas(bitmap);
                canvas.drawColor(Color.rgb(50,100,255));

                paint = new Paint();
                paint.setColor(Color.rgb(255,255,100));
                canvas.drawRoundRect(new RectF(100+i, 100, 300+i, 300), 20, 20, paint);


                Typeface plain = Typeface.createFromAsset(getApplicationContext().getAssets(),"fonts/unsplats.ttf");
                Typeface bold = Typeface.create(plain,Typeface.BOLD);
                paint.setTypeface(bold);
                paint.setColor(Color.BLACK);
                paint.setTextSize(40);
                canvas.drawText("Coskun", 125+i, 200, paint);

                BitmapDrawable drBackground = new BitmapDrawable(getResources(),bitmap);
                rlBackground.setBackgroundDrawable(drBackground);
            }

            public void onFinish() {
                Toast.makeText(getApplicationContext(),"Çizim bitti !\ni = " + String.valueOf(i),Toast.LENGTH_SHORT).show();
            }

        }.start();

    }



    private void Test (){
        int i = 1 + 1 ;
        String strName = "Coşkun";
        String strSurname = "Deniz";
    }
}
