package io.noties.markwon.core.spans.codeblock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import androidx.core.content.ContextCompat;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.facebook.imageutils.JfifUtil;
import com.lynx.tasm.animation.AnimationConstant;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomDynamicDrawableSpan.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJR\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\u000fH\u0016J4\u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lio/noties/markwon/core/spans/codeblock/CustomDynamicDrawableSpan;", "Landroid/text/style/DynamicDrawableSpan;", "context", "Landroid/content/Context;", "resourceId", "", "verticalPadding", "endPadding", "startPadding", "verticalAlignment", "isFinished", "", "(Landroid/content/Context;IIIIIZ)V", "mDrawableRef", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/Drawable;", WebViewContainer.EVENT_draw, "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", AnimationConstant.PROP_STR_TOP, "y", AnimationConstant.PROP_STR_BOTTOM, "paint", "Landroid/graphics/Paint;", "getCachedDrawable", "getDrawable", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomDynamicDrawableSpan extends DynamicDrawableSpan {
    private final Context context;
    private final int endPadding;
    private final boolean isFinished;
    private WeakReference<Drawable> mDrawableRef;
    private final int resourceId;
    private final int startPadding;
    private final int verticalPadding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomDynamicDrawableSpan(Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        super(i5);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.resourceId = i;
        this.verticalPadding = i2;
        this.endPadding = i3;
        this.startPadding = i4;
        this.isFinished = z;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable = ContextCompat.getDrawable(this.context, this.resourceId);
        if (drawable == null) {
            return null;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return drawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable cachedDrawable = getCachedDrawable();
        if (cachedDrawable == null) {
            return 0;
        }
        Rect bounds = cachedDrawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "d.getBounds()");
        if (fm != null) {
            fm.ascent = -bounds.bottom;
            fm.descent = 0;
            fm.top = fm.ascent;
            fm.bottom = 0;
        }
        return bounds.right + this.endPadding + this.startPadding;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable cachedDrawable = getCachedDrawable();
        if (cachedDrawable == null) {
            return;
        }
        canvas.save();
        int i = bottom - cachedDrawable.getBounds().bottom;
        if (((DynamicDrawableSpan) this).mVerticalAlignment == 1) {
            i -= paint.getFontMetricsInt().descent;
        } else if (((DynamicDrawableSpan) this).mVerticalAlignment == 2) {
            i = (top + ((bottom - top) / 2)) - (cachedDrawable.getBounds().height() / 2);
        }
        canvas.translate(x + this.startPadding, i - this.verticalPadding);
        cachedDrawable.setAlpha(this.isFinished ? JfifUtil.MARKER_FIRST_BYTE : 127);
        cachedDrawable.draw(canvas);
        canvas.restore();
    }

    private final Drawable getCachedDrawable() {
        WeakReference<Drawable> weakReference = this.mDrawableRef;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = getDrawable();
        this.mDrawableRef = new WeakReference<>(drawable2);
        return drawable2;
    }
}
