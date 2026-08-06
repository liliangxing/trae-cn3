package com.bytedance.bdturing.livedetect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.util.List;

/* loaded from: classes3.dex */
public class DetectDebugView extends View {
    private static final String TAG = "DetectDebugInfoView";
    private float keyPtRadius;
    private Paint mBoxPaint;
    private List<RectF> mFaceList;
    private int mHeight;
    private Paint mKeyPtPaint;
    private List<List<PointF>> mPointList;
    private int mWidth;

    public DetectDebugView(Context context) {
        this(context, null);
    }

    public DetectDebugView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetectDebugView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        Paint paint = new Paint();
        this.mBoxPaint = paint;
        paint.setAntiAlias(true);
        this.mBoxPaint.setStyle(Paint.Style.STROKE);
        this.mBoxPaint.setColor(-16711936);
        this.mBoxPaint.setStrokeWidth(3.0f);
        Paint paint2 = new Paint();
        this.mKeyPtPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mKeyPtPaint.setColor(SupportMenu.CATEGORY_MASK);
        this.mKeyPtPaint.setAntiAlias(true);
        this.keyPtRadius = 3.0f;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mWidth == i && this.mHeight == i2) {
            return;
        }
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void updateInfo(List<List<PointF>> list, List<RectF> list2) {
        this.mPointList = list;
        this.mFaceList = list2;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawKeyPt(canvas);
        drawFaceBox(canvas);
    }

    private void drawFaceBox(Canvas canvas) {
        List<RectF> list = this.mFaceList;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.mFaceList.size(); i++) {
            RectF rectF = this.mFaceList.get(i);
            canvas.drawRect(rectF.left * this.mWidth, rectF.top * this.mHeight, rectF.right * this.mWidth, rectF.bottom * this.mHeight, this.mBoxPaint);
        }
    }

    private void drawKeyPt(Canvas canvas) {
        List<List<PointF>> list = this.mPointList;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.mPointList.size(); i++) {
            List<PointF> list2 = this.mPointList.get(i);
            for (int i2 = 0; i2 < list2.size(); i2++) {
                PointF pointF = list2.get(i2);
                canvas.drawCircle(pointF.x * this.mWidth, pointF.y * this.mHeight, this.keyPtRadius, this.mKeyPtPaint);
            }
        }
    }
}
