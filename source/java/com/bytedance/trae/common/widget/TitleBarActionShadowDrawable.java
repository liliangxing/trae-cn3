package com.bytedance.trae.common.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeTitleBar.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/common/widget/TitleBarActionShadowDrawable;", "Landroid/graphics/drawable/Drawable;", "backgroundColor", "", "shadowColor", "cornerRadius", "", "shadowRadius", "shadowDy", "contentInsets", "Landroid/graphics/Rect;", "<init>", "(IIFFFLandroid/graphics/Rect;)V", "paint", "Landroid/graphics/Paint;", "rect", "Landroid/graphics/RectF;", WebViewContainer.EVENT_draw, "", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
final class TitleBarActionShadowDrawable extends Drawable {
    private final int backgroundColor;
    private final Rect contentInsets;
    private final float cornerRadius;
    private final Paint paint;
    private final RectF rect;
    private final int shadowColor;
    private final float shadowDy;
    private final float shadowRadius;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public TitleBarActionShadowDrawable(int i, int i2, float f, float f2, float f3, Rect contentInsets) {
        Intrinsics.checkNotNullParameter(contentInsets, "contentInsets");
        this.backgroundColor = i;
        this.shadowColor = i2;
        this.cornerRadius = f;
        this.shadowRadius = f2;
        this.shadowDy = f3;
        this.contentInsets = contentInsets;
        Paint paint = new Paint(1);
        paint.setColor(i);
        paint.setStyle(Paint.Style.FILL);
        paint.setShadowLayer(f2, 0.0f, f3, i2);
        this.paint = paint;
        this.rect = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.rect.set(getBounds().left + this.contentInsets.left, getBounds().top + this.contentInsets.top, getBounds().right - this.contentInsets.right, getBounds().bottom - this.contentInsets.bottom);
        RectF rectF = this.rect;
        float f = this.cornerRadius;
        canvas.drawRoundRect(rectF, f, f, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
