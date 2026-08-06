package com.bytedance.sdk.open.aweme.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.sdk.open.aweme.R;

/* loaded from: classes5.dex */
public class RoundCornerImageView extends ImageView {
    private int defaultRadius;
    private float height;
    private int leftBottomRadius;
    private int leftTopRadius;
    private int radius;
    private int rightBottomRadius;
    private int rightTopRadius;
    private float width;

    public RoundCornerImageView(Context context) {
        this(context, null);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.defaultRadius = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundCornerImageView);
        this.radius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_radius, this.defaultRadius);
        this.leftTopRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_left_top_radius, this.defaultRadius);
        this.rightTopRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_right_top_radius, this.defaultRadius);
        this.rightBottomRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_right_bottom_radius, this.defaultRadius);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_left_bottom_radius, this.defaultRadius);
        this.leftBottomRadius = dimensionPixelOffset;
        int i = this.defaultRadius;
        if (i == this.leftTopRadius) {
            this.leftTopRadius = this.radius;
        }
        if (i == this.rightTopRadius) {
            this.rightTopRadius = this.radius;
        }
        if (i == this.rightBottomRadius) {
            this.rightBottomRadius = this.radius;
        }
        if (i == dimensionPixelOffset) {
            this.leftBottomRadius = this.radius;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int max = Math.max(this.leftTopRadius, this.leftBottomRadius) + Math.max(this.rightTopRadius, this.rightBottomRadius);
        int max2 = Math.max(this.leftTopRadius, this.rightTopRadius) + Math.max(this.leftBottomRadius, this.rightBottomRadius);
        if (this.width >= max && this.height > max2) {
            Path path = new Path();
            path.moveTo(this.leftTopRadius, 0.0f);
            path.lineTo(this.width - this.rightTopRadius, 0.0f);
            float f = this.width;
            path.quadTo(f, 0.0f, f, this.rightTopRadius);
            path.lineTo(this.width, this.height - this.rightBottomRadius);
            float f2 = this.width;
            float f3 = this.height;
            path.quadTo(f2, f3, f2 - this.rightBottomRadius, f3);
            path.lineTo(this.leftBottomRadius, this.height);
            float f4 = this.height;
            path.quadTo(0.0f, f4, 0.0f, f4 - this.leftBottomRadius);
            path.lineTo(0.0f, this.leftTopRadius);
            path.quadTo(0.0f, 0.0f, this.leftTopRadius, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
    }

    public void setDefaultRadius(int i) {
        this.defaultRadius = i;
    }

    public void setLeftBottomRadius(int i) {
        this.leftBottomRadius = i;
    }

    public void setLeftTopRadius(int i) {
        this.leftTopRadius = i;
    }

    public void setRightBottomRadius(int i) {
        this.rightBottomRadius = i;
    }

    public void setRightTopRadius(int i) {
        this.rightTopRadius = i;
    }
}
