package kotlin;

import net.openid.appauth.BuildConfig;

/* compiled from: UInt.kt */
@Metadata(m4d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b¢\u0006\u0002\u0010\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0006H\u0087\b¢\u0006\u0002\u0010\u0007\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\bH\u0087\b¢\u0006\u0002\u0010\t\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\nH\u0087\b¢\u0006\u0002\u0010\u000b\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\fH\u0087\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m5d2 = {"toUInt", "Lkotlin/UInt;", BuildConfig.FLAVOR, "(B)I", BuildConfig.FLAVOR, "(S)I", BuildConfig.FLAVOR, "(I)I", BuildConfig.FLAVOR, "(J)I", BuildConfig.FLAVOR, "(F)I", BuildConfig.FLAVOR, "(D)I", "kotlin-stdlib"}, m6k = 2, m7mv = {2, 1, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class UIntKt {
    private static final int toUInt(byte b) {
        return UInt.m474constructorimpl(b);
    }

    private static final int toUInt(short s) {
        return UInt.m474constructorimpl(s);
    }

    private static final int toUInt(int i) {
        return UInt.m474constructorimpl(i);
    }

    private static final int toUInt(long j) {
        return UInt.m474constructorimpl((int) j);
    }

    private static final int toUInt(float f) {
        return UnsignedKt.doubleToUInt(f);
    }

    private static final int toUInt(double d) {
        return UnsignedKt.doubleToUInt(d);
    }
}
