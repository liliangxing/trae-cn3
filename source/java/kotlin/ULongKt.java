package kotlin;

import net.openid.appauth.BuildConfig;

/* compiled from: ULong.kt */
@Metadata(m4d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b¢\u0006\u0002\u0010\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0006H\u0087\b¢\u0006\u0002\u0010\u0007\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\bH\u0087\b¢\u0006\u0002\u0010\t\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\nH\u0087\b¢\u0006\u0002\u0010\u000b\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\fH\u0087\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m5d2 = {"toULong", "Lkotlin/ULong;", BuildConfig.FLAVOR, "(B)J", BuildConfig.FLAVOR, "(S)J", BuildConfig.FLAVOR, "(I)J", BuildConfig.FLAVOR, "(J)J", BuildConfig.FLAVOR, "(F)J", BuildConfig.FLAVOR, "(D)J", "kotlin-stdlib"}, m6k = 2, m7mv = {2, 1, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ULongKt {
    private static final long toULong(byte b) {
        return ULong.m553constructorimpl(b);
    }

    private static final long toULong(short s) {
        return ULong.m553constructorimpl(s);
    }

    private static final long toULong(int i) {
        return ULong.m553constructorimpl(i);
    }

    private static final long toULong(long j) {
        return ULong.m553constructorimpl(j);
    }

    private static final long toULong(float f) {
        return UnsignedKt.doubleToULong(f);
    }

    private static final long toULong(double d) {
        return UnsignedKt.doubleToULong(d);
    }
}
