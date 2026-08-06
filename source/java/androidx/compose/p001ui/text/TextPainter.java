package androidx.compose.p001ui.text;

import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.text.style.TextForegroundStyle;
import androidx.compose.p001ui.text.style.TextOverflow;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import kotlin.Metadata;

/* compiled from: TextPainter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/TextPainter;", "", "<init>", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class TextPainter {
    public static final int $stable = 0;
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    public final void paint(Canvas canvas, TextLayoutResult textLayoutResult) {
        long j;
        boolean z = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m2593equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m2606getVisiblegIe3tQ8());
        if (z) {
            float size = (int) (textLayoutResult.getSize() >> 32);
            float size2 = (int) (textLayoutResult.getSize() & 4294967295L);
            Rect rect = RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), Size.constructor-impl((Float.floatToRawIntBits(size2) & 4294967295L) | (Float.floatToRawIntBits(size) << 32)));
            canvas.save();
            Canvas.clipRect-mtrdD-E$default(canvas, rect, 0, 2, (Object) null);
        }
        SpanStyle spanStyle = textLayoutResult.getLayoutInput().getStyle().getSpanStyle();
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.INSTANCE.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        DrawStyle drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = (DrawStyle) Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        try {
            Brush brush = spanStyle.getBrush();
            if (brush != null) {
                textLayoutResult.getMultiParagraph().m1965painthn5TExg(canvas, brush, (r17 & 4) != 0 ? Float.NaN : spanStyle.getTextForegroundStyle() != TextForegroundStyle.Unspecified.INSTANCE ? spanStyle.getTextForegroundStyle().getAlpha() : 1.0f, (r17 & 8) != 0 ? null : shadow2, (r17 & 16) != 0 ? null : textDecoration2, (r17 & 32) != 0 ? null : drawStyle2, (r17 & 64) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : 0);
            } else {
                if (spanStyle.getTextForegroundStyle() != TextForegroundStyle.Unspecified.INSTANCE) {
                    j = spanStyle.getTextForegroundStyle().mo2435getColor0d7_KjU();
                } else {
                    j = Color.Companion.getBlack-0d7_KjU();
                }
                textLayoutResult.getMultiParagraph().m1963paintLG529CI(canvas, (r14 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j, (r14 & 4) != 0 ? null : shadow2, (r14 & 8) != 0 ? null : textDecoration2, (r14 & 16) == 0 ? drawStyle2 : null, (r14 & 32) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : 0);
            }
        } finally {
            if (z) {
                canvas.restore();
            }
        }
    }
}
