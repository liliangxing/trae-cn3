package androidx.compose.ui.unit;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* compiled from: Dp.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u001bH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u0006#"}, d2 = {"Landroidx/compose/ui/unit/DpOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "Landroidx/compose/ui/unit/Dp;", "getX-D9Ej5fM$annotations", "()V", "getX-D9Ej5fM", "(J)F", "y", "getY-D9Ej5fM$annotations", "getY-D9Ej5fM", "copy", "copy-tPigGR8", "(JFF)J", "minus", PreloadConfig.KEY_OTHER, "minus-CB-Mgk4", "(JJ)J", "plus", "plus-CB-Mgk4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class DpOffset {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m7119constructorimpl(0);
    private static final long Unspecified = m7119constructorimpl(androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m7118boximpl(long j) {
        return new DpOffset(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m7119constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m7122equalsimpl(long j, Object obj) {
        return (obj instanceof DpOffset) && j == ((DpOffset) obj).m7132unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7123equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getX-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m7125getXD9Ej5fM$annotations() {
    }

    /* renamed from: getY-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m7127getYD9Ej5fM$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m7128hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object other) {
        return m7122equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m7128hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m7132unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ DpOffset(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* renamed from: copy-tPigGR8$default, reason: not valid java name */
    public static /* synthetic */ long m7121copytPigGR8$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m7124getXD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m7126getYD9Ej5fM(j);
        }
        return m7120copytPigGR8(j, f, f2);
    }

    /* renamed from: minus-CB-Mgk4, reason: not valid java name */
    public static final long m7129minusCBMgk4(long j, long j2) {
        float m7063constructorimpl = Dp.m7063constructorimpl(m7124getXD9Ej5fM(j) - m7124getXD9Ej5fM(j2));
        float m7063constructorimpl2 = Dp.m7063constructorimpl(m7126getYD9Ej5fM(j) - m7126getYD9Ej5fM(j2));
        return m7119constructorimpl((Float.floatToRawIntBits(m7063constructorimpl) << 32) | (BodyPartID.bodyIdMax & Float.floatToRawIntBits(m7063constructorimpl2)));
    }

    /* renamed from: plus-CB-Mgk4, reason: not valid java name */
    public static final long m7130plusCBMgk4(long j, long j2) {
        float m7063constructorimpl = Dp.m7063constructorimpl(m7124getXD9Ej5fM(j) + m7124getXD9Ej5fM(j2));
        float m7063constructorimpl2 = Dp.m7063constructorimpl(m7126getYD9Ej5fM(j) + m7126getYD9Ej5fM(j2));
        return m7119constructorimpl((Float.floatToRawIntBits(m7063constructorimpl) << 32) | (BodyPartID.bodyIdMax & Float.floatToRawIntBits(m7063constructorimpl2)));
    }

    public String toString() {
        return m7131toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m7131toStringimpl(long j) {
        return (j > androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? 1 : (j == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? 0 : -1)) != 0 ? "(" + ((Object) Dp.m7074toStringimpl(m7124getXD9Ej5fM(j))) + ", " + ((Object) Dp.m7074toStringimpl(m7126getYD9Ej5fM(j))) + ')' : "DpOffset.Unspecified";
    }

    /* compiled from: Dp.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/unit/DpOffset$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/DpOffset;", "getZero-RKDOV3M", "()J", "J", "Unspecified", "getUnspecified-RKDOV3M", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZero-RKDOV3M, reason: not valid java name */
        public final long m7134getZeroRKDOV3M() {
            return DpOffset.Zero;
        }

        /* renamed from: getUnspecified-RKDOV3M, reason: not valid java name */
        public final long m7133getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }
    }

    /* renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m7124getXD9Ej5fM(long j) {
        return Dp.m7063constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    /* renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m7126getYD9Ej5fM(long j) {
        return Dp.m7063constructorimpl(Float.intBitsToFloat((int) (j & BodyPartID.bodyIdMax)));
    }

    /* renamed from: copy-tPigGR8, reason: not valid java name */
    public static final long m7120copytPigGR8(long j, float f, float f2) {
        return m7119constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & BodyPartID.bodyIdMax));
    }
}
