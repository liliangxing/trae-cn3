package com.bytedance.rts.foundation;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* compiled from: RTSInt64.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/rts/foundation/Int64;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Int64 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long MAX_VALUE = Long.MAX_VALUE;
    public static final long MIN_VALUE = Long.MIN_VALUE;

    /* compiled from: RTSInt64.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/bytedance/rts/foundation/Int64$Companion;", "", "()V", "MAX_VALUE", "", "MIN_VALUE", "hashCode", "", "number", "parseInt64", "str", "", "radix", "toFloat", "", "toFloat64", "", "toInt", "toInt32", "toUInt", "Lkotlin/UInt;", "toUInt-OGnWXxg", "(J)I", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float toFloat(long number) {
            return (float) number;
        }

        public final double toFloat64(long number) {
            return number;
        }

        public final int toInt(long number) {
            return (int) number;
        }

        public final int toInt32(long number) {
            return (int) number;
        }

        private Companion() {
        }

        public static /* synthetic */ long parseInt64$default(Companion companion, String str, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 10;
            }
            return companion.parseInt64(str, i);
        }

        public final long parseInt64(String str, int radix) {
            Intrinsics.checkNotNullParameter(str, "str");
            return Long.parseLong(str, CharsKt.checkRadix(radix));
        }

        /* renamed from: toUInt-OGnWXxg, reason: not valid java name */
        public final int m816toUIntOGnWXxg(long number) {
            return UInt.constructor-impl((int) number);
        }

        public final int hashCode(long number) {
            return Long.hashCode(number);
        }
    }
}
