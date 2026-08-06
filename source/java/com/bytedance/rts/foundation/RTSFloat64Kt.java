package com.bytedance.rts.foundation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: RTSFloat64.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\t"}, d2 = {"toExponential", "", "", "fractionDigits", "", "(DLjava/lang/Integer;)Ljava/lang/String;", "toFixed", "toPrecision", "precision", "lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class RTSFloat64Kt {
    public static final String toFixed(double d, Integer num) {
        int intValue = num != null ? num.intValue() : 0;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%." + intValue + "f", java.util.Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public static final String toExponential(double d, Integer num) {
        int intValue = num != null ? num.intValue() : -1;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%." + intValue + "e", java.util.Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public static final String toPrecision(double d, Integer num) {
        int intValue = num != null ? num.intValue() : 0;
        if (!(intValue > 0)) {
            throw new IllegalArgumentException("Precision must be greater than 0".toString());
        }
        BigDecimal bigDecimal = new BigDecimal(d);
        String plainString = bigDecimal.setScale((intValue - bigDecimal.precision()) + bigDecimal.scale(), RoundingMode.HALF_UP).toPlainString();
        Intrinsics.checkNotNullExpressionValue(plainString, "scaledBd.toPlainString()");
        return plainString;
    }
}
