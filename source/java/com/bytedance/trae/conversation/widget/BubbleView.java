package com.bytedance.trae.conversation.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.R;

/* loaded from: classes5.dex */
public class BubbleView extends View {
    private float arrowCenterXPx;
    private float arrowHeightPx;
    private float arrowWidthPx;
    private final Paint backgroundPaint;
    private final Path bubblePath;
    private float cornerRadiusPx;
    private Paint shadowPaint;

    public BubbleView(Context context) {
        super(context);
        this.backgroundPaint = new Paint(1);
        this.bubblePath = new Path();
        init();
    }

    public BubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.backgroundPaint = new Paint(1);
        this.bubblePath = new Path();
        init();
    }

    public BubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.backgroundPaint = new Paint(1);
        this.bubblePath = new Path();
        init();
    }

    private void init() {
        float f = getResources().getDisplayMetrics().density;
        this.cornerRadiusPx = 16.0f * f;
        this.arrowWidthPx = 56.0f * f;
        this.arrowHeightPx = 13.0f * f;
        this.arrowCenterXPx = 53.0f * f;
        int color = ContextCompat.getColor(getContext(), R.color.trae_bg_bg_invert);
        this.backgroundPaint.setColor(color);
        this.backgroundPaint.setStyle(Paint.Style.FILL);
        Paint paint = new Paint(1);
        this.shadowPaint = paint;
        paint.setColor(color);
        this.shadowPaint.setStyle(Paint.Style.FILL);
        this.shadowPaint.setShadowLayer(25.0f * f, 0.0f, f * 12.0f, Color.argb(20, 0, 0, 0));
        setLayerType(1, null);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        buildBubblePath(i, i2);
    }

    private void buildBubblePath(int i, int i2) {
        this.bubblePath.reset();
        float f = i2 - this.arrowHeightPx;
        RectF rectF = new RectF(0.0f, 0.0f, i, f);
        Path path = this.bubblePath;
        float f2 = this.cornerRadiusPx;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        float f3 = this.arrowCenterXPx;
        float f4 = this.arrowWidthPx;
        float f5 = f4 / 2.0f;
        float f6 = f3 - f5;
        float f7 = this.arrowHeightPx;
        Path path2 = new Path();
        path2.moveTo(f6, f);
        float f8 = f + (0.9f * f7);
        path2.cubicTo((0.22f * f4) + f6, f, f6 + (0.38f * f4), f8, f3, f + f7);
        path2.cubicTo(f6 + (0.62f * f4), f8, f6 + (f4 * 0.78f), f, f5 + f3, f);
        path2.close();
        this.bubblePath.op(path2, Path.Op.UNION);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.bubblePath, this.shadowPaint);
        canvas.drawPath(this.bubblePath, this.backgroundPaint);
    }
}
