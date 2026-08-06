package kotlin.internal;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UInt;
import kotlin.ULong;
import net.openid.appauth.BuildConfig;

/* compiled from: UProgressionUtil.kt */
@Metadata(m4d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0006\u001a'\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, m5d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", BuildConfig.FLAVOR, "getProgressionLastElement-Nkh28Cs", BuildConfig.FLAVOR, "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, m6k = 2, m7mv = {2, 1, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m1591differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int compare;
        int m13m = UByte$$ExternalSyntheticBackport0.m13m(i, i3);
        int m13m2 = UByte$$ExternalSyntheticBackport0.m13m(i2, i3);
        compare = Integer.compare(m13m ^ Integer.MIN_VALUE, m13m2 ^ Integer.MIN_VALUE);
        int m474constructorimpl = UInt.m474constructorimpl(m13m - m13m2);
        return compare >= 0 ? m474constructorimpl : UInt.m474constructorimpl(m474constructorimpl + i3);
    }

    /* renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m1592differenceModulosambcqE(long j, long j2, long j3) {
        int compare;
        long m$1 = UByte$$ExternalSyntheticBackport0.m$1(j, j3);
        long m$12 = UByte$$ExternalSyntheticBackport0.m$1(j2, j3);
        compare = Long.compare(m$1 ^ Long.MIN_VALUE, m$12 ^ Long.MIN_VALUE);
        long m553constructorimpl = ULong.m553constructorimpl(m$1 - m$12);
        return compare >= 0 ? m553constructorimpl : ULong.m553constructorimpl(m553constructorimpl + j3);
    }

    /* renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m1594getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        int compare;
        int compare2;
        if (i3 > 0) {
            compare2 = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
            return compare2 >= 0 ? i2 : UInt.m474constructorimpl(i2 - m1591differenceModuloWZ9TVnA(i2, i, UInt.m474constructorimpl(i3)));
        }
        if (i3 < 0) {
            compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
            return compare <= 0 ? i2 : UInt.m474constructorimpl(i2 + m1591differenceModuloWZ9TVnA(i, i2, UInt.m474constructorimpl(-i3)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    /* renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m1593getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        int compare;
        int compare2;
        if (j3 > 0) {
            compare2 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            return compare2 >= 0 ? j2 : ULong.m553constructorimpl(j2 - m1592differenceModulosambcqE(j2, j, ULong.m553constructorimpl(j3)));
        }
        if (j3 < 0) {
            compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            return compare <= 0 ? j2 : ULong.m553constructorimpl(j2 + m1592differenceModulosambcqE(j, j2, ULong.m553constructorimpl(-j3)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
