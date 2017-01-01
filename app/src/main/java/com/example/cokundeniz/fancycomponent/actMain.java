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
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class actMain extends Activity implements View.OnClickListener{
    RelativeLayout rlBackground;
    LinearLayout llPlayground;
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;
    Random random;
    int intScreenWidth, intScreenHeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        GetScreenSize();
        BindControls();
        DrawSquare();
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
        rlBackground.setOnClickListener(this);
        llPlayground = (LinearLayout)findViewById(R.id.llPlayground);
        //llPlayground.setOnClickListener(this);

        final int rnd = random.nextInt(500);

        new CountDownTimer(35000,100) {
            int i=0;
            public void onTick(long millisUntilFinished) {
                i++;
                bitmap = Bitmap.createBitmap(intScreenWidth,intScreenHeight,Bitmap.Config.ARGB_8888);
                canvas = new Canvas(bitmap);
                canvas.drawColor(Color.rgb(50,100,255));

                paint = new Paint();
                paint.setColor(Color.rgb(255,255,100));
                canvas.drawRoundRect(new RectF(100+i, 100, 300+i, 300), 20, 20, paint);

                canvas.drawCircle((intScreenWidth/2)+rnd, (intScreenHeight/2)+350-i, 5, paint);

                Typeface plain = Typeface.createFromAsset(getApplicationContext().getAssets(),"fonts/unsplats.ttf");
                Typeface bold = Typeface.create(plain,Typeface.BOLD);
                paint.setTypeface(bold);
                paint.setColor(Color.rgb(204, 51, 255));
                paint.setTextSize(60);
                canvas.drawText("Coskun", 125+i, 200, paint);
                canvas.drawText("Deniz", 125+i, 250, paint);

                BitmapDrawable drBackground = new BitmapDrawable(getResources(),bitmap);
                rlBackground.setBackgroundDrawable(drBackground);
            }

            public void onFinish() {
                Toast.makeText(getApplicationContext(),"Çizim bitti !\ni = " + String.valueOf(i),Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    private void DrawSquare() {
        bitmap = Bitmap.createBitmap(intScreenWidth,intScreenHeight,Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        //canvas.drawColor(Color.rgb(50,100,255));

        paint = new Paint();
        paint.setColor(Color.argb(180,255,255,255));
        canvas.drawRoundRect(new RectF(0, 80, intScreenWidth, 320), 0, 0, paint);

        //Draw Line
        paint.setColor(Color.rgb(0,0,0));
        paint.setStrokeWidth(10);
        canvas.drawLine((intScreenWidth/2)-250,(intScreenHeight/2)+350,(intScreenWidth/2)+250,(intScreenHeight/2)+350,paint);

        BitmapDrawable drPlayground = new BitmapDrawable(getResources(),bitmap);
        llPlayground.setBackgroundDrawable(drPlayground);
    }





    @Override
    public void onClick(View v) {
        if(v==rlBackground){
            Toast.makeText(getApplicationContext(),"Arka layout",Toast.LENGTH_SHORT).show();
        }
        if(v==llPlayground){
            Toast.makeText(getApplicationContext(),"Ön layout",Toast.LENGTH_SHORT).show();
        }
    }
}
