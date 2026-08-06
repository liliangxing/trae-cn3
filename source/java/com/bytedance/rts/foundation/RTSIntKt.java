package com.bytedance.rts.foundation;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* compiled from: RTSInt.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u001c\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u001a\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"hashCode", "", "Lkotlin/Int$Companion;", "number", "parseInt", "str", "", "radix", "toFloat", "", "toFloat64", "", "toInt32", "toInt64", "", "toUInt", "Lkotlin/UInt;", "(Lkotlin/jvm/internal/IntCompanionObject;I)I", "lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RTSIntKt {
    public static final float toFloat(IntCompanionObject intCompanionObject, int i) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return i;
    }

    public static final double toFloat64(IntCompanionObject intCompanionObject, int i) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return i;
    }

    public static final int toInt32(IntCompanionObject intCompanionObject, int i) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return i;
    }

    public static final long toInt64(IntCompanionObject intCompanionObject, int i) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return i;
    }

    public static /* synthetic */ int parseInt$default(IntCompanionObject intCompanionObject, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 10;
        }
        return parseInt(intCompanionObject, str, i);
    }

    public static final int parseInt(IntCompanionObject intCompanionObject, String str, int i) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "str");
        return Integer.parseInt(str, CharsKt.checkRadix(i));
    }

    public static final int toUInt(IntCompanionObject intCompanionObject, int i) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return UInt.constructor-impl(i);
    }

    public static final int hashCode(IntCompanionObject intCompanionObject, int i) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return Integer.hashCode(i);
    }
}
