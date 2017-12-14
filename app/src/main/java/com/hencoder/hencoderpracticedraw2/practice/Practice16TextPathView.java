package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice16TextPathView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path textPath = new Path();
    String text = "Hello HenCoder";

    public Practice16TextPathView(Context context) {
        super(context);
    }

    public Practice16TextPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice16TextPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 使用 Paint.getTextPath() 来获取文字的 Path
        paint.setTextSize(120);
        paint.setStyle(Paint.Style.STROKE);

        //要注意文本的起始原点 文本的左下点才是原点 若设置 （0，0）为原点则势必显式不全
        paint.getTextPath(text,0,text.length(),0,200,textPath);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(text,0,120,paint);
        canvas.drawPath(textPath, paint);
    }
}
