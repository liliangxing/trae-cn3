package androidx.compose.p001ui.unit;

import androidx.compose.p001ui.util.MathHelpersKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;

/* compiled from: IntOffset.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001a'\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u0016\u0010\u0014\u001a\u001c\u0010\u0011\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u000eH\u0087\u0002¢\u0006\u0004\b\u0017\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u000eH\u0087\u0002¢\u0006\u0004\b\u0018\u0010\u0014\u001a\u0013\u0010\u0019\u001a\u00020\u0001*\u00020\u000eH\u0007¢\u0006\u0004\b\u001a\u0010\u0010¨\u0006\u001b"}, d2 = {"IntOffset", "Landroidx/compose/ui/unit/IntOffset;", "x", "", "y", "(II)J", "lerp", "start", "stop", "fraction", "", "lerp-81ZRxRo", "(JJF)J", "toOffset", "Landroidx/compose/ui/geometry/Offset;", "toOffset--gyyYBs", "(J)J", "plus", "offset", "plus-Nv-tHpc", "(JJ)J", "minus", "minus-Nv-tHpc", "plus-oCl6YwE", "minus-oCl6YwE", "round", "round-k-4lQ0M", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class IntOffsetKt {
    public static final long IntOffset(int i, int i2) {
        return IntOffset.m2802constructorimpl((i2 & 4294967295L) | (i << 32));
    }

    /* renamed from: lerp-81ZRxRo, reason: not valid java name */
    public static final long m2820lerp81ZRxRo(long j, long j2, float f) {
        return IntOffset.m2802constructorimpl((MathHelpersKt.lerp(IntOffset.m2808getXimpl(j), IntOffset.m2808getXimpl(j2), f) << 32) | (MathHelpersKt.lerp(IntOffset.m2809getYimpl(j), IntOffset.m2809getYimpl(j2), f) & 4294967295L));
    }

    /* renamed from: toOffset--gyyYBs, reason: not valid java name */
    public static final long m2826toOffsetgyyYBs(long j) {
        float m2808getXimpl = IntOffset.m2808getXimpl(j);
        float m2809getYimpl = IntOffset.m2809getYimpl(j);
        return Offset.constructor-impl((Float.floatToRawIntBits(m2809getYimpl) & 4294967295L) | (Float.floatToRawIntBits(m2808getXimpl) << 32));
    }

    /* renamed from: plus-oCl6YwE, reason: not valid java name */
    public static final long m2824plusoCl6YwE(long j, long j2) {
        float m2808getXimpl = IntOffset.m2808getXimpl(j) + Float.intBitsToFloat((int) (j2 >> 32));
        float m2809getYimpl = IntOffset.m2809getYimpl(j) + Float.intBitsToFloat((int) (j2 & 4294967295L));
        return Offset.constructor-impl((Float.floatToRawIntBits(m2808getXimpl) << 32) | (Float.floatToRawIntBits(m2809getYimpl) & 4294967295L));
    }

    /* renamed from: minus-oCl6YwE, reason: not valid java name */
    public static final long m2822minusoCl6YwE(long j, long j2) {
        float m2808getXimpl = IntOffset.m2808getXimpl(j) - Float.intBitsToFloat((int) (j2 >> 32));
        float m2809getYimpl = IntOffset.m2809getYimpl(j) - Float.intBitsToFloat((int) (j2 & 4294967295L));
        return Offset.constructor-impl((Float.floatToRawIntBits(m2808getXimpl) << 32) | (Float.floatToRawIntBits(m2809getYimpl) & 4294967295L));
    }

    /* renamed from: plus-Nv-tHpc, reason: not valid java name */
    public static final long m2823plusNvtHpc(long j, long j2) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) + IntOffset.m2808getXimpl(j2);
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) + IntOffset.m2809getYimpl(j2);
        return Offset.constructor-impl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    /* renamed from: minus-Nv-tHpc, reason: not valid java name */
    public static final long m2821minusNvtHpc(long j, long j2) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - IntOffset.m2808getXimpl(j2);
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - IntOffset.m2809getYimpl(j2);
        return Offset.constructor-impl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    /* renamed from: round-k-4lQ0M, reason: not valid java name */
    public static final long m2825roundk4lQ0M(long j) {
        return IntOffset.m2802constructorimpl((Math.round(Float.intBitsToFloat((int) (j & 4294967295L))) & 4294967295L) | (Math.round(Float.intBitsToFloat((int) (j >> 32))) << 32));
    }
}
