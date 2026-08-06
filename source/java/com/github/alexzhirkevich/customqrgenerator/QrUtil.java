package com.github.alexzhirkevich.customqrgenerator;

import android.graphics.Color;
import com.facebook.imageutils.JfifUtil;
import kotlin.Metadata;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: Util.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrUtil;", "", "()V", "mixColors", "", "color1", "color2", "proportion", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrUtil {
    public static final QrUtil INSTANCE = new QrUtil();

    private QrUtil() {
    }

    public final int mixColors(int color1, int color2, float proportion) {
        int i = (color1 >> 24) & JfifUtil.MARKER_FIRST_BYTE;
        if (i == 0) {
            return color2;
        }
        int i2 = (color2 >> 24) & JfifUtil.MARKER_FIRST_BYTE;
        if (i2 == 0) {
            return color1;
        }
        float f = 1 - proportion;
        return Color.argb(RangesKt.coerceIn(MathKt.roundToInt((i * proportion) + (i2 * f)), 0, JfifUtil.MARKER_FIRST_BYTE), RangesKt.coerceIn(MathKt.roundToInt((((color1 >> 16) & JfifUtil.MARKER_FIRST_BYTE) * proportion) + (((color2 >> 16) & JfifUtil.MARKER_FIRST_BYTE) * f)), 0, JfifUtil.MARKER_FIRST_BYTE), RangesKt.coerceIn(MathKt.roundToInt((((color1 >> 8) & JfifUtil.MARKER_FIRST_BYTE) * proportion) + (((color2 >> 8) & JfifUtil.MARKER_FIRST_BYTE) * f)), 0, JfifUtil.MARKER_FIRST_BYTE), RangesKt.coerceIn(MathKt.roundToInt(((color1 & JfifUtil.MARKER_FIRST_BYTE) * proportion) + ((color2 & JfifUtil.MARKER_FIRST_BYTE) * f)), 0, JfifUtil.MARKER_FIRST_BYTE));
    }
}
