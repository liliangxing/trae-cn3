package com.github.alexzhirkevich.customqrgenerator.style;

import com.facebook.imageutils.JfifUtil;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: QrColor.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0007H\u0007¨\u0006\t"}, d2 = {"Color", "", "a", "r", "g", "b", "argb", "", "toColor", "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class QrColorKt {
    public static final int toColor(long j) {
        return Color(j);
    }

    public static final int Color(long j) {
        return Color((int) ((j >> 24) & 255), (int) ((j >> 16) & 255), (int) ((j >> 8) & 255), (int) (j & 255));
    }

    public static final int Color(int i, int i2, int i3, int i4) {
        return (RangesKt.coerceIn(i, 0, JfifUtil.MARKER_FIRST_BYTE) << 24) | (RangesKt.coerceIn(i2, 0, JfifUtil.MARKER_FIRST_BYTE) << 16) | (RangesKt.coerceIn(i3, 0, JfifUtil.MARKER_FIRST_BYTE) << 8) | RangesKt.coerceIn(i4, 0, 2555);
    }
}
