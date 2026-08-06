package androidx.compose.foundation.internal;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;

/* compiled from: ClipboardUtils.android.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0010J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u0019J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.¢\u0006\u0004\b/\u0010\u0010J\u000e\u0010\n\u001a\u00020\u00072\u0006\u00100\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/compose/foundation/internal/EncodeHelper;", "", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "reset", "", "encodedString", "", "encode", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "byte", "", "int", "", "float", "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "string", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class EncodeHelper {
    public static final int $stable = 8;
    private Parcel parcel = Parcel.obtain();

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }

    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void encode(SpanStyle spanStyle) {
        if (!Color.m4840equalsimpl0(spanStyle.getColor-0d7_KjU(), Color.INSTANCE.m4875getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m852encode8_81llA(spanStyle.getColor-0d7_KjU());
        }
        if (!TextUnit.equals-impl0(spanStyle.getFontSize-XSAIIZE(), TextUnit.Companion.getUnspecified-XSAIIZE())) {
            encode((byte) 2);
            m849encodeR2X_6o(spanStyle.getFontSize-XSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle fontStyle = spanStyle.getFontStyle-4Lr2A7w();
        if (fontStyle != null) {
            int i = fontStyle.unbox-impl();
            encode((byte) 4);
            m854encodenzbMABs(i);
        }
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis-ZQGJjVo();
        if (fontSynthesis != null) {
            int i2 = fontSynthesis.unbox-impl();
            encode((byte) 5);
            m851encode6p3vJLY(i2);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.equals-impl0(spanStyle.getLetterSpacing-XSAIIZE(), TextUnit.Companion.getUnspecified-XSAIIZE())) {
            encode((byte) 7);
            m849encodeR2X_6o(spanStyle.getLetterSpacing-XSAIIZE());
        }
        BaselineShift baselineShift = spanStyle.getBaselineShift-5SSeXJ0();
        if (baselineShift != null) {
            float f = baselineShift.unbox-impl();
            encode((byte) 8);
            m850encode4Dl_Bck(f);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m4840equalsimpl0(spanStyle.getBackground-0d7_KjU(), Color.INSTANCE.m4875getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m852encode8_81llA(spanStyle.getBackground-0d7_KjU());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode((byte) 11);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) 12);
            encode(shadow);
        }
    }

    /* renamed from: encode-8_81llA, reason: not valid java name */
    public final void m852encode8_81llA(long color) {
        m853encodeVKZWuLQ(color);
    }

    /* renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m849encodeR2X_6o(long textUnit) {
        long j = TextUnit.getType-UIouoOA(textUnit);
        byte b = 0;
        if (!TextUnitType.equals-impl0(j, TextUnitType.Companion.getUnspecified-UIouoOA())) {
            if (TextUnitType.equals-impl0(j, TextUnitType.Companion.getSp-UIouoOA())) {
                b = 1;
            } else if (TextUnitType.equals-impl0(j, TextUnitType.Companion.getEm-UIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(textUnit), TextUnitType.Companion.getUnspecified-UIouoOA())) {
            return;
        }
        encode(TextUnit.getValue-impl(textUnit));
    }

    public final void encode(FontWeight fontWeight) {
        encode(fontWeight.getWeight());
    }

    /* renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m854encodenzbMABs(int fontStyle) {
        byte b = 0;
        if (!FontStyle.equals-impl0(fontStyle, FontStyle.Companion.getNormal-_-LCdwA()) && FontStyle.equals-impl0(fontStyle, FontStyle.Companion.getItalic-_-LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    /* renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m851encode6p3vJLY(int fontSynthesis) {
        byte b = 0;
        if (!FontSynthesis.equals-impl0(fontSynthesis, FontSynthesis.Companion.getNone-GVVA2EU())) {
            if (FontSynthesis.equals-impl0(fontSynthesis, FontSynthesis.Companion.getAll-GVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.equals-impl0(fontSynthesis, FontSynthesis.Companion.getWeight-GVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.equals-impl0(fontSynthesis, FontSynthesis.Companion.getStyle-GVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m850encode4Dl_Bck(float baselineShift) {
        encode(baselineShift);
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        m852encode8_81llA(shadow.getColor());
        encode(Float.intBitsToFloat((int) (shadow.getOffset() >> 32)));
        encode(Float.intBitsToFloat((int) (shadow.getOffset() & 4294967295L)));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte r2) {
        this.parcel.writeByte(r2);
    }

    public final void encode(int r2) {
        this.parcel.writeInt(r2);
    }

    public final void encode(float r2) {
        this.parcel.writeFloat(r2);
    }

    /* renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m853encodeVKZWuLQ(long uLong) {
        this.parcel.writeLong(uLong);
    }

    public final void encode(String string) {
        this.parcel.writeString(string);
    }
}
