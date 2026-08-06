package com.bytedance.rts.foundation;

import kotlin.Metadata;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RTSFloat64.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/rts/foundation/Float64;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class Float64 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final double EPSILON = 2.220446049250313E-16d;
    public static final double MAX_SAFE_INTEGER = 9.007199254740991E15d;
    public static final double MAX_VALUE = Double.MAX_VALUE;
    public static final double MIN_SAFE_INTEGER = -9.007199254740991E15d;
    public static final double MIN_VALUE = Double.MIN_VALUE;
    public static final double NEGATIVE_INFINITY = Double.NEGATIVE_INFINITY;
    public static final double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;

    /* compiled from: RTSFloat64.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u0004J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/bytedance/rts/foundation/Float64$Companion;", "", "()V", "EPSILON", "", "MAX_SAFE_INTEGER", "MAX_VALUE", "MIN_SAFE_INTEGER", "MIN_VALUE", "NEGATIVE_INFINITY", "POSITIVE_INFINITY", "hashCode", "", "number", "isFinite", "", "isInteger", "isNaN", "isSafeInteger", "parseFloat64", "str", "", "toFloat", "", "toInt", "toInt32", "toInt64", "", "toUInt", "Lkotlin/UInt;", "toUInt-OGnWXxg", "(D)I", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isInteger(double number) {
            return ((double) ((long) number)) == number;
        }

        public final float toFloat(double number) {
            return (float) number;
        }

        public final int toInt(double number) {
            return (int) number;
        }

        public final int toInt32(double number) {
            return (int) number;
        }

        public final long toInt64(double number) {
            return (long) number;
        }

        private Companion() {
        }

        public final boolean isFinite(double number) {
            return (Double.isInfinite(number) || Double.isNaN(number)) ? false : true;
        }

        public final boolean isNaN(double number) {
            return Double.isNaN(number);
        }

        public final boolean isSafeInteger(double number) {
            return isInteger(number) && number <= 9.007199254740991E15d && number >= -9.007199254740991E15d;
        }

        public final double parseFloat64(String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            return Double.parseDouble(str);
        }

        /* renamed from: toUInt-OGnWXxg, reason: not valid java name */
        public final int m7868toUIntOGnWXxg(double number) {
            return UnsignedKt.doubleToUInt(number);
        }

        public final int hashCode(double number) {
            return Double.hashCode(number);
        }
    }
}
