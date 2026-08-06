package com.bytedance.ies.uikit.imageview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public class KeepRatioImageView extends ImageView {
    public KeepRatioImageView(Context context) {
        super(context);
    }

    public KeepRatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KeepRatioImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                setMeasuredDimension(0, 0);
            } else {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                if (size2 == 0 && size == 0) {
                    setMeasuredDimension(size, size2);
                } else if (size2 == 0) {
                    setMeasuredDimension(size, (drawable.getIntrinsicHeight() * size) / drawable.getIntrinsicWidth());
                } else if (size == 0) {
                    setMeasuredDimension((drawable.getIntrinsicWidth() * size2) / drawable.getIntrinsicHeight(), size2);
                } else {
                    setMeasuredDimension(size, size2);
                }
            }
        } catch (Exception unused) {
            super.onMeasure(i, i2);
        }
    }
}
