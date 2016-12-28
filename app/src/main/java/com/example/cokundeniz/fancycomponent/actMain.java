package com.example.cokundeniz.fancycomponent;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class actMain extends Activity {
    RelativeLayout rlBackground;
    Paint paint;
    Canvas canvas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        BindControls();
    }

    private void BindControls() {
        rlBackground = (RelativeLayout)findViewById(R.id.rlBackground);
    }

    private void Test (){
        int i = 1 + 1 ;
        String strName = "Coşkun";
        String strSurname = "Deniz";
    }
}
