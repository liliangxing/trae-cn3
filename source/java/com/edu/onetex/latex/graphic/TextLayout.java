package com.edu.onetex.latex.graphic;

import android.graphics.Typeface;
import android.text.TextPaint;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/edu/onetex/latex/graphic/TextLayout;", "", "()V", "Companion", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class TextLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TextPaint PAINT = new TextPaint();
    private static final android.graphics.Rect TEXT_BOUNDS = new android.graphics.Rect();

    @JvmStatic
    public static final Rect getBounds(String str, Font font) {
        return INSTANCE.getBounds(str, font);
    }

    /* compiled from: TextLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/edu/onetex/latex/graphic/TextLayout$Companion;", "", "()V", "PAINT", "Landroid/text/TextPaint;", "TEXT_BOUNDS", "Landroid/graphics/Rect;", "getBounds", "Lcom/edu/onetex/latex/graphic/Rect;", "txt", "", PreloadConfig.KEY_FONT, "Lcom/edu/onetex/latex/graphic/Font;", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Rect getBounds(String txt, Font font) {
            Intrinsics.checkNotNullParameter(txt, "txt");
            Intrinsics.checkNotNullParameter(font, "font");
            Typeface typeface = TextLayout.PAINT.getTypeface();
            TextLayout.PAINT.setTypeface(font.getTypeface());
            TextLayout.PAINT.setTextSize(font.getSize());
            TextLayout.PAINT.getTextBounds(txt, 0, txt.length(), TextLayout.TEXT_BOUNDS);
            Rect rect = new Rect(0.0f, TextLayout.PAINT.getFontMetricsInt().ascent, TextLayout.PAINT.measureText(txt), TextLayout.PAINT.getFontMetricsInt().descent - TextLayout.PAINT.getFontMetricsInt().ascent);
            TextLayout.PAINT.setTypeface(typeface);
            return rect;
        }
    }
}
