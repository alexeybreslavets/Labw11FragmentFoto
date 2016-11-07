package com.example.user.labw11fragmentfoto;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity implements View.OnTouchListener {

    Bitmap resourceFoto;
    int bmpx, bmpy, mywidth = 0, myheight = 0, x, y, xDown = 0, yDown = 0, xMove, yMove, xUp, yUp, n = 0, h2, w2, xx1 = 1000, yy1 = 1000, xx2 = 1150, yy2 = 1230, k = 0, t = 0;
    Paint p;
    String s;
    Rect R11, R12, R21, R22, R31, R41, R51, R52, R61, R71, R72;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resourceFoto = BitmapFactory.decodeResource(getResources(), R.drawable.ui);
        bmpx = resourceFoto.getWidth();
        bmpy = resourceFoto.getHeight();
        mm = new misha(this);
        setContentView(mm);
        mm.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = (int) event.getX();   // текущая координата X пальца
        y = (int) event.getY();   // текущая координата Y пальца

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                // здесь делаем что-то, чтобы обработать событие нажатия
                n++;
                xDown = x;
                yDown = y;
                break;
            case MotionEvent.ACTION_MOVE: // движение
                // здесь обработываем событие перемещения пальца
                xMove = x;
                yMove = y;
                break;
            case MotionEvent.ACTION_UP: // отпускание
                // здесь делаем что-то, чтобы обработать событие отпускания
                xUp = x;
                yUp = y;
                break;
            case MotionEvent.ACTION_CANCEL:
                // событие отмены
                xUp = 0;
                yUp = 0;
                xMove = 0;
                yMove = 0;
                xDown = 0;
                yDown = 0;
                break;
        }
        // здесь можем вывести нужные надписи
        s = xDown + " " + yDown + " число нажатий: " + n;
        mm.invalidate();
        return true;
    }

    class misha extends View {

        public misha(Context context) {
            super(context);
            p = new Paint();
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            mywidth = w;
            myheight = h;
            super.onSizeChanged(w, h, oldw, oldh);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
            p.setTextSize(18);
            p.setTextAlign(Paint.Align.CENTER);
            h2 = canvas.getHeight();
            w2 = canvas.getWidth();
            p.setColor(Color.BLACK);
            R11 = new Rect(155, 1, 310, 231);
            R21 = new Rect(310, 1, 465, 231);
            R31 = new Rect(465, 1, 620, 231);
            R41 = new Rect(3, 300, 98, 390);
            R51 = new Rect(103, 300, 198, 390);
            R61 = new Rect(208, 300, 303, 390);
            R71 = new Rect(620, 1, 775, 231);
            if ((w2 == 480) && (h2 == 764)) {
                R12 = new Rect(50, 50, 205, 280);
                R52 = new Rect(25, 110, 120, 200);
                canvas.drawBitmap(resourceFoto, R11, R12, p);
                canvas.drawBitmap(resourceFoto, R51, R52, p);
                R72 = new Rect(255, 50, 410, 280);
                canvas.drawBitmap(resourceFoto, R71, R72, p);
                switch (n % 7){
                    case 1:
                        R22 = new Rect(255, 50, 410, 280);
                        if (k == 1) {
                            canvas.drawBitmap(resourceFoto, R11, R22, p);
                        } else if (k == 2) {
                            canvas.drawBitmap(resourceFoto, R21, R22, p);
                        } else if (k == 3) {
                            canvas.drawBitmap(resourceFoto, R31, R22, p);
                        }
                        xx1 = x;
                        yy1 = y;
                        xx2 = x + 150;
                        yy2 = y + 230;
                        if (xUp > 255 && yUp > 50 && xUp < 410 && yUp < 280){
                            R22 = new Rect(255, 50, 410, 280);
                            k = 1;
                        } else {
                            R22 = new Rect(xx1, yy1, xx2, yy2);
                        }
                        canvas.drawBitmap(resourceFoto, R11, R22, p);
                        xUp = 0;
                        yUp = 0;
                        break;
                    case 2:
                        R22 = new Rect(255, 50, 410, 280);
                        if (k == 1) {
                            canvas.drawBitmap(resourceFoto, R11, R22, p);
                        } else if (k == 2) {
                            canvas.drawBitmap(resourceFoto, R21, R22, p);
                        } else if (k == 3) {
                            canvas.drawBitmap(resourceFoto, R31, R22, p);
                        }
                        xx1 = x;
                        yy1 = y;
                        xx2 = x + 150;
                        yy2 = y + 230;
                        if (xUp > 255 && yUp > 50 && xUp < 410 && yUp < 280){
                            R22 = new Rect(255, 50, 410, 280);
                            k = 2;
                        } else {
                            R22 = new Rect(xx1, yy1, xx2, yy2);
                        }
                        canvas.drawBitmap(resourceFoto, R21, R22, p);
                        xUp = 0;
                        yUp = 0;
                        break;
                    case 3:
                        R22 = new Rect(255, 50, 410, 280);
                        if (k == 1) {
                            canvas.drawBitmap(resourceFoto, R11, R22, p);
                        } else if (k == 2) {
                            canvas.drawBitmap(resourceFoto, R21, R22, p);
                        } else if (k == 3) {
                            canvas.drawBitmap(resourceFoto, R31, R22, p);
                        }
                        xx1 = x;
                        yy1 = y;
                        xx2 = x + 150;
                        yy2 = y + 230;
                        if (xUp > 255 && yUp > 50 && xUp < 410 && yUp < 280){
                            R22 = new Rect(255, 50, 410, 280);
                            k = 3;
                        } else {
                            R22 = new Rect(xx1, yy1, xx2, yy2);
                        }
                        canvas.drawBitmap(resourceFoto, R31, R22, p);
                        xUp = 0;
                        yUp = 0;
                        break;
                    case 4:
                        R22 = new Rect(255, 50, 410, 280);
                        if (k == 1) {
                            canvas.drawBitmap(resourceFoto, R11, R22, p);
                        } else if (k == 2) {
                            canvas.drawBitmap(resourceFoto, R21, R22, p);
                        } else if (k == 3) {
                            canvas.drawBitmap(resourceFoto, R31, R22, p);
                        }
                        R22 = new Rect(230, 110, 325, 200);
                        if (t == 1){
                            canvas.drawBitmap(resourceFoto, R41, R22, p);
                        } else if (t == 2){
                            canvas.drawBitmap(resourceFoto, R51, R22, p);
                        } else if (t == 3){
                            canvas.drawBitmap(resourceFoto, R61, R22, p);
                        }
                        xx1 = x;
                        yy1 = y;
                        xx2 = x + 95;
                        yy2 = y + 90;
                        if (xUp > 255 && yUp > 50 && xUp < 410 && yUp < 280){
                            R22 = new Rect(230, 110, 325, 200);
                            t = 1;
                        } else {
                            R22 = new Rect(xx1, yy1, xx2, yy2);
                        }
                        canvas.drawBitmap(resourceFoto, R41, R22, p);
                        xUp = 0;
                        yUp = 0;
                        break;
                    case 5:
                        R22 = new Rect(255, 50, 410, 280);
                        if (k == 1) {
                            canvas.drawBitmap(resourceFoto, R11, R22, p);
                        } else if (k == 2) {
                            canvas.drawBitmap(resourceFoto, R21, R22, p);
                        } else if (k == 3) {
                            canvas.drawBitmap(resourceFoto, R31, R22, p);
                        }
                        R22 = new Rect(230, 110, 325, 200);
                        if (t == 1){
                            canvas.drawBitmap(resourceFoto, R41, R22, p);
                        } else if (t == 2){
                            canvas.drawBitmap(resourceFoto, R51, R22, p);
                        } else if (t == 3){
                            canvas.drawBitmap(resourceFoto, R61, R22, p);
                        }
                        xx1 = x;
                        yy1 = y;
                        xx2 = x + 95;
                        yy2 = y + 90;
                        if (xUp > 255 && yUp > 50 && xUp < 410 && yUp < 280){
                            R22 = new Rect(230, 110, 325, 200);
                            t = 2;
                        } else {
                            R22 = new Rect(xx1, yy1, xx2, yy2);
                        }
                        canvas.drawBitmap(resourceFoto, R51, R22, p);
                        xUp = 0;
                        yUp = 0;
                        break;
                    case 6:
                        R22 = new Rect(255, 50, 410, 280);
                        if (k == 1) {
                            canvas.drawBitmap(resourceFoto, R11, R22, p);
                        } else if (k == 2) {
                            canvas.drawBitmap(resourceFoto, R21, R22, p);
                        } else if (k == 3) {
                            canvas.drawBitmap(resourceFoto, R31, R22, p);
                        }
                        R22 = new Rect(230, 110, 325, 200);
                        if (t == 1){
                            canvas.drawBitmap(resourceFoto, R41, R22, p);
                        } else if (t == 2){
                            canvas.drawBitmap(resourceFoto, R51, R22, p);
                        } else if (t == 3){
                            canvas.drawBitmap(resourceFoto, R61, R22, p);
                        }
                        xx1 = x;
                        yy1 = y;
                        xx2 = x + 95;
                        yy2 = y + 90;
                        if (xUp > 255 && yUp > 50 && xUp < 410 && yUp < 280){
                            R22 = new Rect(230, 110, 325, 200);
                            t = 3;
                        } else {
                            R22 = new Rect(xx1, yy1, xx2, yy2);
                        }
                        canvas.drawBitmap(resourceFoto, R61, R22, p);
                        xUp = 0;
                        yUp = 0;
                        break;
                    default:
                        if (xUp < 255 && yUp < 50 && xUp > 410 && yUp > 280) {
                            p.setColor(Color.TRANSPARENT);
                            canvas.drawRect(xx1, yy1, xx2, yy2, p);
                            p.setColor(Color.BLACK);
                        }
                        k = 0;
                        t = 0;
                        xUp = 0;
                        yUp = 0;
                        break;
                }
                if ((xDown == 0) && (yDown == 0)) {
                    canvas.drawText("Screen sizes: " + w2 + " " + h2, 240, 730, p);
                } else {
                    canvas.drawText(s, 240, 730, p);
                }
            } else if ((w2 == 800) && (h2 == 444)) {
                R12 = new Rect(50, 50, 205, 280);
                R52 = new Rect(25, 110, 120, 200);
                canvas.drawBitmap(resourceFoto, R11, R12, p);
                canvas.drawBitmap(resourceFoto, R51, R52, p);
                R72 = new Rect(255, 50, 410, 280);
                canvas.drawBitmap(resourceFoto, R71, R72, p);
                switch (n % 7){
                    case 1:
                        R22 = new Rect(255, 50, 410, 280);
                        if (k == 1) {
                            canvas.drawBitmap(resourceFoto, R11, R22, p);
                        } else if (k == 2) {
                            canvas.drawBitmap(resourceFoto, R21, R22, p);
                        } else if (k == 3) {
                            canvas.drawBitmap(resourceFoto, R31, R22, p);
                        }
                        xx1 = x;
                        yy1 = y;
                        xx2 = x + 150;
                        yy2 = y + 230;
                        if (xUp > 255 && yUp > 50 && xUp < 410 && yUp < 280){
                            R22 = new Rect(255, 50, 410, 280);
                            k = 1;
                        } else {
                            R22 = new Rect(xx1, yy1, xx2, yy2);
                        }
                        canvas.drawBitmap(resourceFoto, R11, R22, p);
                        xUp = 0;
                        yUp = 0;
                        break;
                    case 2:
                        R22 = new Rect(255, 50, 410, 280);
                        if (k == 1) {
                            canvas.drawBitmap(resourceFoto, R11, R22, p);
                        } else if (k == 2) {
                            canvas.drawBitmap(resourceFoto, R21, R22, p);
                        } else if (k == 3) {
                            canvas.drawBitmap(resourceFoto, R31, R22, p);
                        }
                        xx1 = x;
                        yy1 = y;
                        xx2 = x + 150;
                        yy2 = y + 230;
                        if (xUp > 255 && yUp > 50 && xUp < 410 && yUp < 280){
                            R22 = new Rect(255, 50, 410, 280);
                            k = 2;
                        } else {
                            R22 = new Rect(xx1, yy1, xx2, yy2);
                        }
                        canvas.drawBitmap(resourceFoto, R21, R22, p);
                        xUp = 0;
                        yUp = 0;
                        break;
                    case 3:
                        R22 = new Rect(255, 50, 410, 280);
                        if (k == 1) {
                            canvas.drawBitmap(resourceFoto, R11, R22, p);
                        } else if (k == 2) {
                            canvas.drawBitmap(resourceFoto, R21, R22, p);
                        } else if (k == 3) {
                            canvas.drawBitmap(resourceFoto, R31, R22, p);
                        }
                        xx1 = x;
                        yy1 = y;
                        xx2 = x + 150;
                        yy2 = y + 230;
                        if (xUp > 255 && yUp > 50 && xUp < 410 && yUp < 280){
                            R22 = new Rect(255, 50, 410, 280);
                            k = 3;
                        } else {
                            R22 = new Rect(xx1, yy1, xx2, yy2);
                        }
                        canvas.drawBitmap(resourceFoto, R31, R22, p);
                        xUp = 0;
                        yUp = 0;
                        break;
                    case 4:
                        R22 = new Rect(255, 50, 410, 280);
                        if (k == 1) {
                            canvas.drawBitmap(resourceFoto, R11, R22, p);
                        } else if (k == 2) {
                            canvas.drawBitmap(resourceFoto, R21, R22, p);
                        } else if (k == 3) {
                            canvas.drawBitmap(resourceFoto, R31, R22, p);
                        }
                        R22 = new Rect(230, 110, 325, 200);
                        if (t == 1){
                            canvas.drawBitmap(resourceFoto, R41, R22, p);
                        } else if (t == 2){
                            canvas.drawBitmap(resourceFoto, R51, R22, p);
                        } else if (t == 3){
                            canvas.drawBitmap(resourceFoto, R61, R22, p);
                        }
                        xx1 = x;
                        yy1 = y;
                        xx2 = x + 95;
                        yy2 = y + 90;
                        if (xUp > 255 && yUp > 50 && xUp < 410 && yUp < 280){
                            R22 = new Rect(230, 110, 325, 200);
                            t = 1;
                        } else {
                            R22 = new Rect(xx1, yy1, xx2, yy2);
                        }
                        canvas.drawBitmap(resourceFoto, R41, R22, p);
                        xUp = 0;
                        yUp = 0;
                        break;
                    case 5:
                        R22 = new Rect(255, 50, 410, 280);
                        if (k == 1) {
                            canvas.drawBitmap(resourceFoto, R11, R22, p);
                        } else if (k == 2) {
                            canvas.drawBitmap(resourceFoto, R21, R22, p);
                        } else if (k == 3) {
                            canvas.drawBitmap(resourceFoto, R31, R22, p);
                        }
                        R22 = new Rect(230, 110, 325, 200);
                        if (t == 1){
                            canvas.drawBitmap(resourceFoto, R41, R22, p);
                        } else if (t == 2){
                            canvas.drawBitmap(resourceFoto, R51, R22, p);
                        } else if (t == 3){
                            canvas.drawBitmap(resourceFoto, R61, R22, p);
                        }
                        xx1 = x;
                        yy1 = y;
                        xx2 = x + 95;
                        yy2 = y + 90;
                        if (xUp > 255 && yUp > 50 && xUp < 410 && yUp < 280){
                            R22 = new Rect(230, 110, 325, 200);
                            t = 2;
                        } else {
                            R22 = new Rect(xx1, yy1, xx2, yy2);
                        }
                        canvas.drawBitmap(resourceFoto, R51, R22, p);
                        xUp = 0;
                        yUp = 0;
                        break;
                    case 6:
                        R22 = new Rect(255, 50, 410, 280);
                        if (k == 1) {
                            canvas.drawBitmap(resourceFoto, R11, R22, p);
                        } else if (k == 2) {
                            canvas.drawBitmap(resourceFoto, R21, R22, p);
                        } else if (k == 3) {
                            canvas.drawBitmap(resourceFoto, R31, R22, p);
                        }
                        R22 = new Rect(230, 110, 325, 200);
                        if (t == 1){
                            canvas.drawBitmap(resourceFoto, R41, R22, p);
                        } else if (t == 2){
                            canvas.drawBitmap(resourceFoto, R51, R22, p);
                        } else if (t == 3){
                            canvas.drawBitmap(resourceFoto, R61, R22, p);
                        }
                        xx1 = x;
                        yy1 = y;
                        xx2 = x + 95;
                        yy2 = y + 90;
                        if (xUp > 255 && yUp > 50 && xUp < 410 && yUp < 280){
                            R22 = new Rect(230, 110, 325, 200);
                            t = 3;
                        } else {
                            R22 = new Rect(xx1, yy1, xx2, yy2);
                        }
                        canvas.drawBitmap(resourceFoto, R61, R22, p);
                        xUp = 0;
                        yUp = 0;
                        break;
                    default:
                        if (xUp < 255 && yUp < 50 && xUp > 410 && yUp > 280) {
                            p.setColor(Color.TRANSPARENT);
                            canvas.drawRect(xx1, yy1, xx2, yy2, p);
                            p.setColor(Color.BLACK);
                        }
                        k = 0;
                        t = 0;
                        xUp = 0;
                        yUp = 0;
                        break;
                }
                if ((xDown == 0) && (yDown == 0)) {
                    canvas.drawText("Screen sizes: " + w2 + " " + h2, 400, 420, p);
                } else {
                    canvas.drawText(s, 400, 420, p);
                }
            } else {
                canvas.drawText("ERROR!", 400, 420, p);
            }
        }
    }
    misha mm;
}
