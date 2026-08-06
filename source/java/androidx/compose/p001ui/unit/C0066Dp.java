package androidx.compose.p001ui.unit;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Dp.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u000f\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0011\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0011\u0010\u0013J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0014\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0016\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0016\u0010\u0013J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0000H\u0097\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u001bH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010\t\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006#"}, d2 = {"Landroidx/compose/ui/unit/Dp;", "", StrategyConstants.VALUE, "", "constructor-impl", "(F)F", "getValue", "()F", "plus", "other", "plus-5rwHm24", "(FF)F", "minus", "minus-5rwHm24", "unaryMinus", "unaryMinus-D9Ej5fM", "div", "div-u2uoSUM", "", "(FI)F", "div-0680j_4", "times", "times-u2uoSUM", "compareTo", "compareTo-0680j_4", "(FF)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* renamed from: androidx.compose.ui.unit.Dp */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0066Dp implements Comparable<C0066Dp> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float Hairline = m2680constructorimpl(0.0f);
    private static final float Infinity = m2680constructorimpl(Float.POSITIVE_INFINITY);
    private static final float Unspecified = m2680constructorimpl(Float.NaN);
    private final float value;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ C0066Dp m2678boximpl(float f) {
        return new C0066Dp(f);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static float m2680constructorimpl(float f) {
        return f;
    }

    /* renamed from: div-0680j_4, reason: not valid java name */
    public static final float m2681div0680j_4(float f, float f2) {
        return f / f2;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2684equalsimpl(float f, Object obj) {
        return (obj instanceof C0066Dp) && Float.compare(f, ((C0066Dp) obj).m2694unboximpl()) == 0;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2685equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2686hashCodeimpl(float f) {
        return Float.hashCode(f);
    }

    public boolean equals(Object other) {
        return m2684equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m2686hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m2694unboximpl() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(C0066Dp c0066Dp) {
        return m2693compareTo0680j_4(c0066Dp.m2694unboximpl());
    }

    private /* synthetic */ C0066Dp(float f) {
        this.value = f;
    }

    public final float getValue() {
        return this.value;
    }

    /* renamed from: plus-5rwHm24, reason: not valid java name */
    public static final float m2688plus5rwHm24(float f, float f2) {
        return m2680constructorimpl(f + f2);
    }

    /* renamed from: minus-5rwHm24, reason: not valid java name */
    public static final float m2687minus5rwHm24(float f, float f2) {
        return m2680constructorimpl(f - f2);
    }

    /* renamed from: unaryMinus-D9Ej5fM, reason: not valid java name */
    public static final float m2692unaryMinusD9Ej5fM(float f) {
        return m2680constructorimpl(-f);
    }

    /* renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m2682divu2uoSUM(float f, float f2) {
        return m2680constructorimpl(f / f2);
    }

    /* renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m2683divu2uoSUM(float f, int i) {
        return m2680constructorimpl(f / i);
    }

    /* renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m2689timesu2uoSUM(float f, float f2) {
        return m2680constructorimpl(f * f2);
    }

    /* renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m2690timesu2uoSUM(float f, int i) {
        return m2680constructorimpl(f * i);
    }

    /* renamed from: compareTo-0680j_4, reason: not valid java name */
    public int m2693compareTo0680j_4(float f) {
        return m2679compareTo0680j_4(this.value, f);
    }

    /* renamed from: compareTo-0680j_4, reason: not valid java name */
    public static int m2679compareTo0680j_4(float f, float f2) {
        return Float.compare(f, f2);
    }

    public String toString() {
        return m2691toStringimpl(this.value);
    }

    /* compiled from: Dp.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/unit/Dp$Companion;", "", "<init>", "()V", "Hairline", "Landroidx/compose/ui/unit/Dp;", "getHairline-D9Ej5fM$annotations", "getHairline-D9Ej5fM", "()F", "F", "Infinity", "getInfinity-D9Ej5fM$annotations", "getInfinity-D9Ej5fM", "Unspecified", "getUnspecified-D9Ej5fM$annotations", "getUnspecified-D9Ej5fM", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.unit.Dp$Companion, reason: from kotlin metadata */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getHairline-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m2695getHairlineD9Ej5fM$annotations() {
        }

        /* renamed from: getInfinity-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m2696getInfinityD9Ej5fM$annotations() {
        }

        /* renamed from: getUnspecified-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m2697getUnspecifiedD9Ej5fM$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getHairline-D9Ej5fM, reason: not valid java name */
        public final float m2698getHairlineD9Ej5fM() {
            return C0066Dp.Hairline;
        }

        /* renamed from: getInfinity-D9Ej5fM, reason: not valid java name */
        public final float m2699getInfinityD9Ej5fM() {
            return C0066Dp.Infinity;
        }

        /* renamed from: getUnspecified-D9Ej5fM, reason: not valid java name */
        public final float m2700getUnspecifiedD9Ej5fM() {
            return C0066Dp.Unspecified;
        }
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2691toStringimpl(float f) {
        return Float.isNaN(f) ? "Dp.Unspecified" : f + ".dp";
    }
}
