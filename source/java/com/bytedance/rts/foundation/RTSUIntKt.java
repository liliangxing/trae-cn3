package com.bytedance.rts.foundation;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* compiled from: RTSUInt.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a$\u0010\u0007\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0001ø\u0001\u0001¢\u0006\u0002\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0006\u001a\u001f\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0006\u001a\u001f\u0010\u0018\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"hashCode", "", "Lkotlin/UInt$Companion;", "number", "Lkotlin/UInt;", "hashCode-Qn1smSk", "(Lkotlin/UInt$Companion;I)I", "parseUInt", "str", "", "radix", "(Lkotlin/UInt$Companion;Ljava/lang/String;I)I", "toFloat", "", "toFloat-Qn1smSk", "(Lkotlin/UInt$Companion;I)F", "toFloat64", "", "toFloat64-Qn1smSk", "(Lkotlin/UInt$Companion;I)D", "toInt", "toInt-Qn1smSk", "toInt32", "toInt32-Qn1smSk", "toInt64", "", "toInt64-Qn1smSk", "(Lkotlin/UInt$Companion;I)J", "lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RTSUIntKt {
    /* renamed from: toInt-Qn1smSk, reason: not valid java name */
    public static final int m831toIntQn1smSk(UInt.Companion companion, int i) {
        Intrinsics.checkNotNullParameter(companion, "$this$toInt");
        return i;
    }

    /* renamed from: toInt32-Qn1smSk, reason: not valid java name */
    public static final int m832toInt32Qn1smSk(UInt.Companion companion, int i) {
        Intrinsics.checkNotNullParameter(companion, "$this$toInt32");
        return i;
    }

    /* renamed from: toInt64-Qn1smSk, reason: not valid java name */
    public static final long m833toInt64Qn1smSk(UInt.Companion companion, int i) {
        Intrinsics.checkNotNullParameter(companion, "$this$toInt64");
        return i & 4294967295L;
    }

    public static /* synthetic */ int parseUInt$default(UInt.Companion companion, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 10;
        }
        return parseUInt(companion, str, i);
    }

    public static final int parseUInt(UInt.Companion companion, String str, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(str, "str");
        return UStringsKt.toUInt(str, i);
    }

    /* renamed from: toFloat-Qn1smSk, reason: not valid java name */
    public static final float m829toFloatQn1smSk(UInt.Companion companion, int i) {
        Intrinsics.checkNotNullParameter(companion, "$this$toFloat");
        return (float) UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toFloat64-Qn1smSk, reason: not valid java name */
    public static final double m830toFloat64Qn1smSk(UInt.Companion companion, int i) {
        Intrinsics.checkNotNullParameter(companion, "$this$toFloat64");
        return UnsignedKt.uintToDouble(i);
    }

    /* renamed from: hashCode-Qn1smSk, reason: not valid java name */
    public static final int m828hashCodeQn1smSk(UInt.Companion companion, int i) {
        Intrinsics.checkNotNullParameter(companion, "$this$hashCode");
        return UInt.hashCode-impl(i);
    }
}
