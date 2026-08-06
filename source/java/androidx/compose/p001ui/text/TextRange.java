package androidx.compose.p001ui.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TextRange.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006("}, d2 = {"Landroidx/compose/ui/text/TextRange;", "", "packedValue", "", "constructor-impl", "(J)J", "start", "", "getStart-impl", "(J)I", "end", "getEnd-impl", "min", "getMin-impl", "max", "getMax-impl", "collapsed", "", "getCollapsed-impl", "(J)Z", "reversed", "getReversed-impl", "length", "getLength-impl", "intersects", "other", "intersects-5zc-tL8", "(JJ)Z", "contains", "contains-5zc-tL8", "offset", "contains-impl", "(JI)Z", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class TextRange {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = TextRangeKt.TextRange(0);
    private final long packedValue;

    /* renamed from: box-impl */
    public static final /* synthetic */ TextRange m2110boximpl(long j) {
        return new TextRange(j);
    }

    /* renamed from: constructor-impl */
    public static long m2111constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl */
    public static boolean m2114equalsimpl(long j, Object obj) {
        return (obj instanceof TextRange) && j == ((TextRange) obj).getPackedValue();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m2115equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getEnd-impl */
    public static final int m2117getEndimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: getStart-impl */
    public static final int m2122getStartimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl */
    public static int m2123hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object other) {
        return m2114equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m2123hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ TextRange(long j) {
        this.packedValue = j;
    }

    /* renamed from: getMin-impl */
    public static final int m2120getMinimpl(long j) {
        return Math.min(m2122getStartimpl(j), m2117getEndimpl(j));
    }

    /* renamed from: getMax-impl */
    public static final int m2119getMaximpl(long j) {
        return Math.max(m2122getStartimpl(j), m2117getEndimpl(j));
    }

    /* renamed from: getCollapsed-impl */
    public static final boolean m2116getCollapsedimpl(long j) {
        return m2122getStartimpl(j) == m2117getEndimpl(j);
    }

    /* renamed from: getReversed-impl */
    public static final boolean m2121getReversedimpl(long j) {
        return m2122getStartimpl(j) > m2117getEndimpl(j);
    }

    /* renamed from: getLength-impl */
    public static final int m2118getLengthimpl(long j) {
        return m2119getMaximpl(j) - m2120getMinimpl(j);
    }

    /* renamed from: intersects-5zc-tL8 */
    public static final boolean m2124intersects5zctL8(long j, long j2) {
        return (m2120getMinimpl(j) < m2119getMaximpl(j2)) & (m2120getMinimpl(j2) < m2119getMaximpl(j));
    }

    /* renamed from: contains-5zc-tL8 */
    public static final boolean m2112contains5zctL8(long j, long j2) {
        return (m2120getMinimpl(j) <= m2120getMinimpl(j2)) & (m2119getMaximpl(j2) <= m2119getMaximpl(j));
    }

    /* renamed from: contains-impl */
    public static final boolean m2113containsimpl(long j, int i) {
        return i < m2119getMaximpl(j) && m2120getMinimpl(j) <= i;
    }

    public String toString() {
        return m2125toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl */
    public static String m2125toStringimpl(long j) {
        return "TextRange(" + m2122getStartimpl(j) + ", " + m2117getEndimpl(j) + ')';
    }

    /* compiled from: TextRange.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/TextRange$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/text/TextRange;", "getZero-d9O1mEE", "()J", "J", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZero-d9O1mEE */
        public final long m2127getZerod9O1mEE() {
            return TextRange.Zero;
        }
    }
}
