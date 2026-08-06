package com.bytedance.trae.conversation.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadingDotsSpan.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ4\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016JR\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/trae/conversation/widget/LoadingDotsSpan;", "Landroid/text/style/ReplacementSpan;", "dotColors", "", "dotRadius", "", "dotSpacing", "dotCount", "", "<init>", "([IFFI)V", "alphas", "", "getAlphas", "()[F", "scales", "getScales", "baseRadii", "getSize", "paint", "Landroid/graphics/Paint;", "text", "", "start", "end", "fm", "Landroid/graphics/Paint$FontMetricsInt;", WebViewContainer.EVENT_draw, "", "canvas", "Landroid/graphics/Canvas;", "x", "top", "y", "bottom", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoadingDotsSpan extends ReplacementSpan {
    private final float[] alphas;
    private final float[] baseRadii;
    private final int[] dotColors;
    private final int dotCount;
    private final float dotRadius;
    private final float dotSpacing;
    private final float[] scales;

    public /* synthetic */ LoadingDotsSpan(int[] iArr, float f, float f2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr, f, (i2 & 4) != 0 ? f : f2, (i2 & 8) != 0 ? 2 : i);
    }

    public LoadingDotsSpan(int[] dotColors, float f, float f2, int i) {
        Intrinsics.checkNotNullParameter(dotColors, "dotColors");
        this.dotColors = dotColors;
        this.dotRadius = f;
        this.dotSpacing = f2;
        this.dotCount = i;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            fArr[i2] = 1.0f;
        }
        this.alphas = fArr;
        int i3 = this.dotCount;
        float[] fArr2 = new float[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            fArr2[i4] = 1.0f;
        }
        this.scales = fArr2;
        int i5 = this.dotCount;
        float[] fArr3 = new float[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            float f3 = this.dotRadius;
            if (i6 != 0) {
                f3 *= 0.65f;
            }
            fArr3[i6] = f3;
        }
        this.baseRadii = fArr3;
    }

    public final float[] getAlphas() {
        return this.alphas;
    }

    public final float[] getScales() {
        return this.scales;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        float f = this.dotSpacing;
        double d = 0.0d;
        for (int i = 0; i < this.baseRadii.length; i++) {
            d += r5[i] * 2;
        }
        return (int) (f + ((float) d) + ((this.dotCount - 1) * this.dotSpacing));
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        int color = paint.getColor();
        int alpha = paint.getAlpha();
        float f = (top + bottom) / 2.0f;
        float f2 = x + this.dotSpacing + this.baseRadii[0];
        int i = this.dotCount;
        for (int i2 = 0; i2 < i; i2++) {
            paint.setColor(this.dotColors[i2]);
            paint.setAlpha((int) (this.alphas[i2] * 255));
            canvas.drawCircle(f2, f, this.baseRadii[i2] * this.scales[i2], paint);
            if (i2 < this.dotCount - 1) {
                float[] fArr = this.baseRadii;
                f2 += fArr[i2] + this.dotSpacing + fArr[i2 + 1];
            }
        }
        paint.setColor(color);
        paint.setAlpha(alpha);
    }
}
