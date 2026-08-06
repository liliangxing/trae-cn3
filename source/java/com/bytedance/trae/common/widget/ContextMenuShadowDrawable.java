package com.bytedance.trae.common.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextMenuPopupWindow.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;", "Landroid/graphics/drawable/Drawable;", "cornerRadius", "", "shadowRadius", "shadowDy", "shadowColor", "", "cardInsets", "Landroid/graphics/Rect;", "<init>", "(FFFILandroid/graphics/Rect;)V", "paint", "Landroid/graphics/Paint;", "rect", "Landroid/graphics/RectF;", WebViewContainer.EVENT_draw, "", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
final class ContextMenuShadowDrawable extends Drawable {
    private final Rect cardInsets;
    private final float cornerRadius;
    private final Paint paint;
    private final RectF rect;
    private final int shadowColor;
    private final float shadowDy;
    private final float shadowRadius;

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return -3;
    }

    public ContextMenuShadowDrawable(float f, float f2, float f3, int i, Rect cardInsets) {
        Intrinsics.checkNotNullParameter(cardInsets, "cardInsets");
        this.cornerRadius = f;
        this.shadowRadius = f2;
        this.shadowDy = f3;
        this.shadowColor = i;
        this.cardInsets = cardInsets;
        Paint paint = new Paint(1);
        paint.setColor(i);
        paint.setStyle(Paint.Style.FILL);
        paint.setShadowLayer(f2, 0.0f, f3, i);
        this.paint = paint;
        this.rect = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.rect.set(getBounds().left + this.cardInsets.left, getBounds().top + this.cardInsets.top, getBounds().right - this.cardInsets.right, getBounds().bottom - this.cardInsets.bottom);
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
