package androidx.compose.p001ui.unit;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TextUnit.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087@\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0007\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0086\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0086\n¢\u0006\u0004\b\u000b\u0010\u000eJ\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000fH\u0086\n¢\u0006\u0004\b\u000b\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0086\n¢\u0006\u0004\b\u0012\u0010\fJ\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0086\n¢\u0006\u0004\b\u0012\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000fH\u0086\n¢\u0006\u0004\b\u0012\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010*\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u000fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010\u0005R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b&\u0010$R\u0011\u0010'\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b(\u0010)\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006-"}, d2 = {"Landroidx/compose/ui/unit/TextUnit;", "", "packedValue", "", "constructor-impl", "(J)J", "unaryMinus", "unaryMinus-XSAIIZE", "div", "other", "", "div-kPz2Gy4", "(JF)J", "", "(JD)J", "", "(JI)J", "times", "times-kPz2Gy4", "compareTo", "compareTo--R2X_6o", "(JJ)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "rawType", "getRawType$annotations", "()V", "getRawType-impl", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Landroidx/compose/ui/unit/TextUnitType;", "getType-UIouoOA", "isSp", "", "isSp-impl", "(J)Z", "isEm", "isEm-impl", StrategyConstants.VALUE, "getValue-impl", "(J)F", "equals", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class TextUnit {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TextUnitType[] TextUnitTypes = {TextUnitType.m2899boximpl(TextUnitType.INSTANCE.m2908getUnspecifiedUIouoOA()), TextUnitType.m2899boximpl(TextUnitType.INSTANCE.m2907getSpUIouoOA()), TextUnitType.m2899boximpl(TextUnitType.INSTANCE.m2906getEmUIouoOA())};
    private static final long Unspecified = TextUnitKt.pack(0, Float.NaN);
    private final long packedValue;

    /* renamed from: box-impl */
    public static final /* synthetic */ TextUnit m2864boximpl(long j) {
        return new TextUnit(j);
    }

    /* renamed from: constructor-impl */
    public static long m2866constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl */
    public static boolean m2870equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnit) && j == ((TextUnit) obj).getPackedValue();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m2871equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getRawType$annotations() {
    }

    /* renamed from: getRawType-impl */
    public static final long m2872getRawTypeimpl(long j) {
        return j & 1095216660480L;
    }

    /* renamed from: hashCode-impl */
    public static int m2875hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object other) {
        return m2870equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m2875hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ TextUnit(long j) {
        this.packedValue = j;
    }

    /* renamed from: unaryMinus-XSAIIZE */
    public static final long m2882unaryMinusXSAIIZE(long j) {
        TextUnitKt.m2887checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m2872getRawTypeimpl(j), -m2874getValueimpl(j));
    }

    /* renamed from: div-kPz2Gy4 */
    public static final long m2868divkPz2Gy4(long j, float f) {
        TextUnitKt.m2887checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m2872getRawTypeimpl(j), m2874getValueimpl(j) / f);
    }

    /* renamed from: div-kPz2Gy4 */
    public static final long m2867divkPz2Gy4(long j, double d) {
        TextUnitKt.m2887checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m2872getRawTypeimpl(j), (float) (m2874getValueimpl(j) / d));
    }

    /* renamed from: div-kPz2Gy4 */
    public static final long m2869divkPz2Gy4(long j, int i) {
        TextUnitKt.m2887checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m2872getRawTypeimpl(j), m2874getValueimpl(j) / i);
    }

    /* renamed from: times-kPz2Gy4 */
    public static final long m2879timeskPz2Gy4(long j, float f) {
        TextUnitKt.m2887checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m2872getRawTypeimpl(j), m2874getValueimpl(j) * f);
    }

    /* renamed from: times-kPz2Gy4 */
    public static final long m2878timeskPz2Gy4(long j, double d) {
        TextUnitKt.m2887checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m2872getRawTypeimpl(j), (float) (m2874getValueimpl(j) * d));
    }

    /* renamed from: times-kPz2Gy4 */
    public static final long m2880timeskPz2Gy4(long j, int i) {
        TextUnitKt.m2887checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m2872getRawTypeimpl(j), m2874getValueimpl(j) * i);
    }

    /* renamed from: compareTo--R2X_6o */
    public static final int m2865compareToR2X_6o(long j, long j2) {
        TextUnitKt.m2888checkArithmeticNB67dxo(j, j2);
        return Float.compare(m2874getValueimpl(j), m2874getValueimpl(j2));
    }

    public String toString() {
        return m2881toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl */
    public static String m2881toStringimpl(long j) {
        long m2873getTypeUIouoOA = m2873getTypeUIouoOA(j);
        return TextUnitType.m2902equalsimpl0(m2873getTypeUIouoOA, TextUnitType.INSTANCE.m2908getUnspecifiedUIouoOA()) ? "Unspecified" : TextUnitType.m2902equalsimpl0(m2873getTypeUIouoOA, TextUnitType.INSTANCE.m2907getSpUIouoOA()) ? m2874getValueimpl(j) + ".sp" : TextUnitType.m2902equalsimpl0(m2873getTypeUIouoOA, TextUnitType.INSTANCE.m2906getEmUIouoOA()) ? m2874getValueimpl(j) + ".em" : "Invalid";
    }

    /* compiled from: TextUnit.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/unit/TextUnit$Companion;", "", "<init>", "()V", "TextUnitTypes", "", "Landroidx/compose/ui/unit/TextUnitType;", "getTextUnitTypes$ui_unit", "()[Landroidx/compose/ui/unit/TextUnitType;", "[Landroidx/compose/ui/unit/TextUnitType;", "Unspecified", "Landroidx/compose/ui/unit/TextUnit;", "getUnspecified-XSAIIZE$annotations", "getUnspecified-XSAIIZE", "()J", "J", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-XSAIIZE$annotations */
        public static /* synthetic */ void m2884getUnspecifiedXSAIIZE$annotations() {
        }

        private Companion() {
        }

        public final TextUnitType[] getTextUnitTypes$ui_unit() {
            return TextUnit.TextUnitTypes;
        }

        /* renamed from: getUnspecified-XSAIIZE */
        public final long m2885getUnspecifiedXSAIIZE() {
            return TextUnit.Unspecified;
        }
    }

    /* renamed from: getType-UIouoOA */
    public static final long m2873getTypeUIouoOA(long j) {
        return TextUnitTypes[(int) (m2872getRawTypeimpl(j) >>> 32)].getType();
    }

    /* renamed from: isSp-impl */
    public static final boolean m2877isSpimpl(long j) {
        return m2872getRawTypeimpl(j) == 4294967296L;
    }

    /* renamed from: isEm-impl */
    public static final boolean m2876isEmimpl(long j) {
        return m2872getRawTypeimpl(j) == 8589934592L;
    }

    /* renamed from: getValue-impl */
    public static final float m2874getValueimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }
}
