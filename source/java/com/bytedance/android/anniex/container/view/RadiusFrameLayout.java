package com.bytedance.android.anniex.container.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RadiusFrameLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J&\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0010R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/anniex/container/view/RadiusFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "rectF", "Landroid/graphics/RectF;", "rounds", "", WebViewContainer.EVENT_dispatchDraw, "", "canvas", "Landroid/graphics/Canvas;", WebViewContainer.EVENT_draw, "setRadius", "radius", "", "topLeft", "topRight", "bottomRight", "bottomLeft", "radii", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class RadiusFrameLayout extends FrameLayout {
    private final Path path;
    private final RectF rectF;
    private float[] rounds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadiusFrameLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.path = new Path();
        this.rectF = new RectF();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadiusFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.path = new Path();
        this.rectF = new RectF();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadiusFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.path = new Path();
        this.rectF = new RectF();
    }

    public final void setRadius(float radius) {
        this.rounds = new float[]{radius, radius, radius, radius, radius, radius, radius, radius};
        invalidate();
    }

    public final void setRadius(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        float f = 0;
        if (topLeft > f || topRight > f || bottomLeft > f || bottomRight > f) {
            this.rounds = new float[]{topLeft, topLeft, topRight, topRight, bottomRight, bottomRight, bottomLeft, bottomLeft};
            invalidate();
        }
    }

    public final void setRadius(float[] radii) {
        Intrinsics.checkNotNullParameter(radii, "radii");
        this.rounds = radii;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float[] fArr = this.rounds;
        if (fArr != null) {
            this.rectF.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.path.reset();
            this.path.addRoundRect(this.rectF, fArr, Path.Direction.CW);
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.path);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float[] fArr = this.rounds;
        if (fArr != null) {
            this.rectF.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.path.reset();
            this.path.addRoundRect(this.rectF, fArr, Path.Direction.CW);
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.path);
        }
        super.draw(canvas);
    }
}
