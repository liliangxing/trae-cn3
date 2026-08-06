package io.noties.markwon.ext.onetex;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.behavior.PropsConstants;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.image.AsyncDrawableSpan;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LatexFallbackAsyncDrawableSpan.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJR\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexFallbackAsyncDrawableSpan;", "Lio/noties/markwon/image/AsyncDrawableSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "drawable", "Lio/noties/markwon/ext/onetex/LatexFallbackAsyncDrawable;", "alignment", "", "(Lio/noties/markwon/core/MarkwonTheme;Lio/noties/markwon/ext/onetex/LatexFallbackAsyncDrawable;I)V", "getDrawable", "()Lio/noties/markwon/ext/onetex/LatexFallbackAsyncDrawable;", "lastDrawRect", "Landroid/graphics/Rect;", "draw", "", "canvas", "Landroid/graphics/Canvas;", PropsConstants.TEXT, "", "start", "end", "x", "", PropsConstants.HIT_SLOP_TOP, "y", PropsConstants.HIT_SLOP_BOTTOM, "paint", "Landroid/graphics/Paint;", "Companion", "markdown-latex_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class LatexFallbackAsyncDrawableSpan extends AsyncDrawableSpan {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int alignment;
    private final LatexFallbackAsyncDrawable drawable;
    private final Rect lastDrawRect;

    public final LatexFallbackAsyncDrawable getDrawable() {
        return this.drawable;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LatexFallbackAsyncDrawableSpan(MarkwonTheme markwonTheme, LatexFallbackAsyncDrawable latexFallbackAsyncDrawable, int i) {
        super(markwonTheme, latexFallbackAsyncDrawable, i, false);
        Intrinsics.checkNotNullParameter(markwonTheme, "theme");
        Intrinsics.checkNotNullParameter(latexFallbackAsyncDrawable, "drawable");
        this.drawable = latexFallbackAsyncDrawable;
        this.alignment = i;
        this.lastDrawRect = new Rect();
    }

    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Unit unit;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        int i = (int) x;
        this.drawable.setOffsetX(i);
        super.draw(canvas, text, start, end, x, top, y, bottom, paint);
        Drawable result = this.drawable.getResult();
        if (result != null) {
            this.lastDrawRect.set(result.getBounds());
            Rect rect = this.lastDrawRect;
            Companion companion = INSTANCE;
            int i2 = this.alignment;
            Rect bounds = result.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "it.bounds");
            rect.offset(i, (int) companion.getTranslationY(i2, top, bottom, paint, bounds));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.lastDrawRect.setEmpty();
        }
    }

    /* compiled from: LatexFallbackAsyncDrawableSpan.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexFallbackAsyncDrawableSpan$Companion;", "", "()V", "getTranslationY", "", "alignment", "", PropsConstants.HIT_SLOP_TOP, PropsConstants.HIT_SLOP_BOTTOM, "paint", "Landroid/graphics/Paint;", "bounds", "Landroid/graphics/Rect;", "markdown-latex_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float getTranslationY(int alignment, int top, int bottom, Paint paint, Rect bounds) {
            int i = bottom - bounds.bottom;
            if (2 == alignment) {
                return i - (((bottom - top) - bounds.height()) / 2.0f);
            }
            if (1 == alignment) {
                i -= paint.getFontMetricsInt().descent;
            }
            return i;
        }
    }
}
