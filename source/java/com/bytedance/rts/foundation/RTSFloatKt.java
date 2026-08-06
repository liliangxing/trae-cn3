package com.bytedance.rts.foundation;

import kotlin.Metadata;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RTSFloat.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"hashCode", "", "Lkotlin/Float$Companion;", "number", "", "parseFloat", "str", "", "toFloat64", "", "toInt", "toInt32", "toInt64", "", "toUInt", "Lkotlin/UInt;", "(Lkotlin/jvm/internal/FloatCompanionObject;F)I", "lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class RTSFloatKt {
    public static final double toFloat64(FloatCompanionObject floatCompanionObject, float f) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return f;
    }

    public static final int toInt(FloatCompanionObject floatCompanionObject, float f) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return (int) f;
    }

    public static final int toInt32(FloatCompanionObject floatCompanionObject, float f) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return (int) f;
    }

    public static final long toInt64(FloatCompanionObject floatCompanionObject, float f) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return f;
    }

    public static final float parseFloat(FloatCompanionObject floatCompanionObject, String str) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "str");
        return Float.parseFloat(str);
    }

    public static final int toUInt(FloatCompanionObject floatCompanionObject, float f) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return UnsignedKt.doubleToUInt(f);
    }

    public static final int hashCode(FloatCompanionObject floatCompanionObject, float f) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return Float.hashCode(f);
    }
}
