package com.example.den.herome.customdraws;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by den on 2017-04-25.
 */

public class MainFragmentDraw extends View {
    private Paint paint;
    public MainFragmentDraw(Context context) {
        super(context);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int circleRadius = 15;

        int firstPointX = 60;
        int firstPointY = 30;

        int secondPointX = 960;
        int secondPointY = 30;

        int thirdPointX = 1010;
        int thirdPointY = 80;

        int fourthPointX = 1010;
        int fourthPointY = 500;

        int fifthPointX = 960;
        int fifthPointY = 550;

        int sixPointX = 110;
        int sixPointY = 550;

        int sevenPointX = 60;
        int sevenPointY = 600;

        int eightPointX = 60;
        int eightPointY = 1115;

        int ninePointX = 110;
        int ninePointY = 1165;

        int tenPointX = 960;
        int tenPointY = 1165;

        int elevenPointX = 1010;
        int elevenPointY = 1215;

        int twelvePointX = 1010;
        int twelvePointY = 1300;

        int thirteenPointX = 960;
        int thirteenPointY = 1360;

        int lastPointX = 60;
        int lastPointY = 1360;
        paint.setARGB(255,255,255,255);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        canvas.drawCircle(firstPointX,firstPointY,circleRadius,paint);
        canvas.drawLine(firstPointX+circleRadius,firstPointY,secondPointX,secondPointY,paint);

        RectF rect = new RectF();
        rect.set(secondPointX - 50,
                 secondPointY ,
                 thirdPointX ,
                 thirdPointY + 50);
//        canvas.drawRect(rect,paint);
        canvas.drawArc(rect,270,90,false,paint);

        canvas.drawLine(thirdPointX,thirdPointY,fourthPointX,fourthPointY,paint);


        rect.set(fifthPointX - 50,
                fourthPointY -50,
                fourthPointX ,
                fifthPointY );
//        canvas.drawRect(rect1,paint);
        canvas.drawArc(rect,0,90,false,paint);

        canvas.drawLine(fifthPointX,fifthPointY,sixPointX,sixPointY,paint);

        rect.set(sixPointX - 50,
                sixPointY,
                sevenPointX + 100,
                sevenPointY + 50);

//        canvas.drawRect(rect,paint);
        canvas.drawArc(rect,180,90,false,paint);
        canvas.drawLine(sevenPointX,sevenPointY,eightPointX,eightPointY,paint);

        rect.set(eightPointX,
                eightPointY - 50,
                ninePointX + 50,
                ninePointY );

//        canvas.drawRect(rect,paint);
        canvas.drawArc(rect,90,90,false,paint);
        canvas.drawLine(ninePointX,ninePointY,tenPointX ,tenPointY,paint);

        rect.set(tenPointX - 50,
                tenPointY ,
                elevenPointX ,
                elevenPointY + 50);

//        canvas.drawRect(rect,paint);
        canvas.drawArc(rect,270,90,false,paint);
        canvas.drawLine(elevenPointX,elevenPointY,twelvePointX,twelvePointY + 5,paint);

        rect.set(thirteenPointX -50,
                twelvePointY - 55,
                twelvePointX,
                thirteenPointY);

//        canvas.drawRect(rect,paint);
        canvas.drawArc(rect,0,90,false,paint);

        canvas.drawLine(thirteenPointX,thirteenPointY,lastPointX,lastPointY,paint);
        canvas.drawCircle(lastPointX - circleRadius,lastPointY,circleRadius,paint);

    }
}
