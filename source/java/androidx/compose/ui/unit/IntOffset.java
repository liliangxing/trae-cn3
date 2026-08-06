package androidx.compose.ui.unit;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* compiled from: IntOffset.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087@\u0018\u0000 12\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b#\u0010$J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b&\u0010$J\u0018\u0010'\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020+H\u0017¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\u00020/2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u00062"}, d2 = {"Landroidx/compose/ui/unit/IntOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)I", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-iSbpLlY", "(JII)J", "minus", PreloadConfig.KEY_OTHER, "minus-qkQi6aY", "(JJ)J", "plus", "plus-qkQi6aY", "unaryMinus", "unaryMinus-nOcc-ac", "times", "operand", "", "times-Bjo55l4", "(JF)J", "div", "div-Bjo55l4", "rem", "rem-Bjo55l4", "(JI)J", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class IntOffset {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m7185constructorimpl(0);
    private static final long Max = m7185constructorimpl(9223372034707292159L);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntOffset m7182boximpl(long j) {
        return new IntOffset(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m7185constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m7189equalsimpl(long j, Object obj) {
        return (obj instanceof IntOffset) && j == ((IntOffset) obj).m7200unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7190equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final int m7191getXimpl(long j) {
        return (int) (j >> 32);
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final int m7192getYimpl(long j) {
        return (int) (j & BodyPartID.bodyIdMax);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m7193hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object other) {
        return m7189equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m7193hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m7200unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ IntOffset(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final int m7183component1impl(long j) {
        return m7191getXimpl(j);
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final int m7184component2impl(long j) {
        return m7192getYimpl(j);
    }

    /* renamed from: copy-iSbpLlY$default, reason: not valid java name */
    public static /* synthetic */ long m7187copyiSbpLlY$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = (int) (j >> 32);
        }
        if ((i3 & 2) != 0) {
            i2 = (int) (BodyPartID.bodyIdMax & j);
        }
        return m7186copyiSbpLlY(j, i, i2);
    }

    /* renamed from: copy-iSbpLlY, reason: not valid java name */
    public static final long m7186copyiSbpLlY(long j, int i, int i2) {
        return m7185constructorimpl((i << 32) | (i2 & BodyPartID.bodyIdMax));
    }

    /* renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m7194minusqkQi6aY(long j, long j2) {
        return m7185constructorimpl(((((int) (j >> 32)) - ((int) (j2 >> 32))) << 32) | ((((int) (j & BodyPartID.bodyIdMax)) - ((int) (j2 & BodyPartID.bodyIdMax))) & BodyPartID.bodyIdMax));
    }

    /* renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m7195plusqkQi6aY(long j, long j2) {
        return m7185constructorimpl(((((int) (j >> 32)) + ((int) (j2 >> 32))) << 32) | ((((int) (j & BodyPartID.bodyIdMax)) + ((int) (j2 & BodyPartID.bodyIdMax))) & BodyPartID.bodyIdMax));
    }

    /* renamed from: unaryMinus-nOcc-ac, reason: not valid java name */
    public static final long m7199unaryMinusnOccac(long j) {
        return m7185constructorimpl(((-((int) (j & BodyPartID.bodyIdMax))) & BodyPartID.bodyIdMax) | ((-((int) (j >> 32))) << 32));
    }

    /* renamed from: rem-Bjo55l4, reason: not valid java name */
    public static final long m7196remBjo55l4(long j, int i) {
        return m7185constructorimpl(((((int) (j >> 32)) % i) << 32) | ((((int) (j & BodyPartID.bodyIdMax)) % i) & BodyPartID.bodyIdMax));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m7198toStringimpl(long j) {
        return "(" + m7191getXimpl(j) + ", " + m7192getYimpl(j) + ')';
    }

    public String toString() {
        return m7198toStringimpl(this.packedValue);
    }

    /* compiled from: IntOffset.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/unit/IntOffset$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/IntOffset;", "getZero-nOcc-ac", "()J", "J", "Max", "getMax-nOcc-ac", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZero-nOcc-ac, reason: not valid java name */
        public final long m7202getZeronOccac() {
            return IntOffset.Zero;
        }

        /* renamed from: getMax-nOcc-ac, reason: not valid java name */
        public final long m7201getMaxnOccac() {
            return IntOffset.Max;
        }
    }

    /* renamed from: times-Bjo55l4, reason: not valid java name */
    public static final long m7197timesBjo55l4(long j, float f) {
        return m7185constructorimpl((Math.round(((int) (j >> 32)) * f) << 32) | (Math.round(((int) (j & BodyPartID.bodyIdMax)) * f) & BodyPartID.bodyIdMax));
    }

    /* renamed from: div-Bjo55l4, reason: not valid java name */
    public static final long m7188divBjo55l4(long j, float f) {
        return m7185constructorimpl((Math.round(((int) (j >> 32)) / f) << 32) | (Math.round(((int) (j & BodyPartID.bodyIdMax)) / f) & BodyPartID.bodyIdMax));
    }
}
