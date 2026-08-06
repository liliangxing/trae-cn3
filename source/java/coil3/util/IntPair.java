package coil3.util;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* compiled from: collections.common.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\tJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0013"}, d2 = {"Lcoil3/util/IntPair;", "", "value", "", "constructor-impl", "(J)J", "first", "", "second", "(II)J", "getFirst-impl", "(J)I", "getSecond-impl", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class IntPair {
    private final long value;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntPair m7630boximpl(long j) {
        return new IntPair(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static long m7632constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m7633equalsimpl(long j, Object obj) {
        return (obj instanceof IntPair) && j == ((IntPair) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7634equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getFirst-impl, reason: not valid java name */
    public static final int m7635getFirstimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: getSecond-impl, reason: not valid java name */
    public static final int m7636getSecondimpl(long j) {
        return (int) (j & BodyPartID.bodyIdMax);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m7637hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m7638toStringimpl(long j) {
        return "IntPair(value=" + j + ')';
    }

    public boolean equals(Object other) {
        return m7633equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m7637hashCodeimpl(this.value);
    }

    public String toString() {
        return m7638toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }

    private /* synthetic */ IntPair(long j) {
        this.value = j;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m7631constructorimpl(int i, int i2) {
        return m7632constructorimpl((i2 & BodyPartID.bodyIdMax) | (i << 32));
    }
}
