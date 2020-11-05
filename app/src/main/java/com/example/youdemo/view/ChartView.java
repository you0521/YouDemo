package com.example.youdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.youdemo.R;

/**
 * author：  jcy
 * data：2020/4/29
 * time：14:42
 * description：
 */
public class ChartView extends View {

    private final Context mContext;
    //测量的高度
    private int mHeight;
    //测量的宽度
    private int mWidth;

    private int[] xData = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    private Paint mXTextPaint;
    private Paint paint4;
    private Paint paintOT;
    private Paint paintOB;
    //柱状图距离底部的距离
    private int mBottomHeight;
    private int[] mZhuData = {3,5,9,11,15,20,30,15,5,1};
    private int maxHeight;
    private Paint mPaintText;

    public ChartView(Context context) {
        this(context, null);
    }

    public ChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        //X轴文字的画笔
        mXTextPaint = new Paint();
        paintOT = new Paint();
        paintOB = new Paint();
        paint4 = new Paint();
        mXTextPaint.setStrokeWidth(3);
        mXTextPaint.setColor(getResources().getColor(R.color.colorAccent));
        mXTextPaint.setTextSize(20);
        mXTextPaint.setAntiAlias(true);

        //柱状图上面的文字
        mPaintText = new Paint();
        mPaintText.setStrokeWidth(3);
        mPaintText.setColor(getResources().getColor(R.color.text));
        mPaintText.setTextAlign(Paint.Align.CENTER);
        mPaintText.setTextSize(20);
        mPaintText.setAntiAlias(true);


        paintOT.setStyle(Paint.Style.FILL_AND_STROKE);
        paintOT.setStrokeWidth(2);
        paintOT.setAntiAlias(true);
        paintOT.setColor(getResources().getColor(R.color.ovalTop));

        paintOB.setStyle(Paint.Style.FILL_AND_STROKE);
        paintOB.setStrokeWidth(2);
        paintOB.setAntiAlias(true);
        paintOB.setColor(getResources().getColor(R.color.ovalBot));

        paint4.setStyle(Paint.Style.FILL_AND_STROKE);
        paint4.setStrokeWidth(mWidth/15);
        paint4.setAntiAlias(true);
        paint4.setColor(Color.GREEN);


        for (int i = 0; i < mZhuData.length; i++) {
            if (maxHeight < mZhuData[i]){
                maxHeight = mZhuData[i];
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.mWidth = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mBottomHeight = mHeight - 10;
        //画x轴坐标
//        drawXText(canvas);
        //画圆柱
        drawZhu(canvas);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawZhu(Canvas canvas) {
        for (int i = 0; i < mZhuData.length; i++) {
            float startX = mWidth*(i+1)/11;
            float stopY = mBottomHeight*0.9f/maxHeight*mZhuData[i];


            paint4.setStrokeWidth(mWidth/15);
            paint4.setShader(new LinearGradient(startX,mBottomHeight,startX,mBottomHeight-stopY,
                    getResources().getColor(R.color.stop), getResources().getColor(R.color.start), Shader.TileMode.MIRROR));
            canvas.drawLine(startX,mBottomHeight,startX,mBottomHeight-stopY,paint4);
            //柱状图一半的宽度
            float a  = mWidth/15/2;
            //椭圆高度的一半
            float b = mWidth/125;
            canvas.drawOval(startX-a,mBottomHeight-stopY-b,startX+a,mBottomHeight-stopY+b,paintOT);
            canvas.drawOval(startX-a,mBottomHeight-b,startX+a,mBottomHeight+b,paintOB);
//        canvas.drawLine(400,150,400,600,paintOT);

            /**
             *  画柱状图上面的文字
            */
            String x = String.valueOf(mZhuData[i])+"%";
            canvas.drawText(x,startX,mBottomHeight-stopY-b-5,mPaintText);



        }
    }

    private void drawXText(Canvas canvas) {
        if (xData != null && xData.length > 0) {
            for (int i = 0; i < xData.length; i++) {
                float startX = mWidth *(i+1)/12;
                String s = String.valueOf(xData[i]);
                float v = mXTextPaint.measureText(s);
                canvas.drawText(String.valueOf(xData[i]),startX-v/2,mHeight,mXTextPaint);
            }
        }
    }


    public void setData(int[] zhuData){
        this.mZhuData = zhuData;

        for (int i = 0; i < mZhuData.length; i++) {
            if (maxHeight < mZhuData[i]){
                maxHeight = mZhuData[i];
            }
        }
    }
}
