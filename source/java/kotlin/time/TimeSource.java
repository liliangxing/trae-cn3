package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import net.openid.appauth.BuildConfig;

/* compiled from: TimeSource.kt */
@Metadata(m4d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0007"}, m5d2 = {"Lkotlin/time/TimeSource;", BuildConfig.FLAVOR, "markNow", "Lkotlin/time/TimeMark;", "WithComparableMarks", "Monotonic", "Companion", "kotlin-stdlib"}, m6k = 1, m7mv = {2, 1, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface TimeSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: TimeSource.kt */
    @Metadata(m4d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m5d2 = {"Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/TimeSource;", "markNow", "Lkotlin/time/ComparableTimeMark;", "kotlin-stdlib"}, m6k = 1, m7mv = {2, 1, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public interface WithComparableMarks extends TimeSource {
        @Override // kotlin.time.TimeSource
        ComparableTimeMark markNow();
    }

    TimeMark markNow();

    /* compiled from: TimeSource.kt */
    @Metadata(m4d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, m5d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource$WithComparableMarks;", "<init>", "()V", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", BuildConfig.FLAVOR, "ValueTimeMark", "kotlin-stdlib"}, m6k = 1, m7mv = {2, 1, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class Monotonic implements WithComparableMarks {
        public static final Monotonic INSTANCE = new Monotonic();

        private Monotonic() {
        }

        @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ ComparableTimeMark markNow() {
            return ValueTimeMark.m1840boximpl(m1839markNowz9LOYto());
        }

        @Override // kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ TimeMark markNow() {
            return ValueTimeMark.m1840boximpl(m1839markNowz9LOYto());
        }

        /* renamed from: markNow-z9LOYto, reason: not valid java name */
        public long m1839markNowz9LOYto() {
            return MonotonicTimeSource.INSTANCE.m1834markNowz9LOYto();
        }

        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }

        /* compiled from: TimeSource.kt */
        @Metadata(m4d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0001H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\u0004\n\u0002\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004¨\u0006$"}, m5d2 = {"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/ComparableTimeMark;", "reading", BuildConfig.FLAVOR, "Lkotlin/time/ValueTimeMarkReading;", "constructor-impl", "(J)J", "J", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "plus", "duration", "plus-LRDsOJo", "(JJ)J", "minus", "minus-LRDsOJo", "hasPassedNow", BuildConfig.FLAVOR, "hasPassedNow-impl", "(J)Z", "hasNotPassedNow", "hasNotPassedNow-impl", "other", "minus-UwyO8pc", "(JLkotlin/time/ComparableTimeMark;)J", "minus-6eNON_k", "compareTo", BuildConfig.FLAVOR, "compareTo-6eNON_k", "(JJ)I", "equals", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "kotlin-stdlib"}, m6k = 1, m7mv = {2, 1, 0}, m9xi = 48)
        @JvmInline
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        public static final class ValueTimeMark implements ComparableTimeMark {
            private final long reading;

            /* renamed from: box-impl, reason: not valid java name */
            public static final /* synthetic */ ValueTimeMark m1840boximpl(long j) {
                return new ValueTimeMark(j);
            }

            /* renamed from: constructor-impl, reason: not valid java name */
            public static long m1843constructorimpl(long j) {
                return j;
            }

            /* renamed from: equals-impl, reason: not valid java name */
            public static boolean m1845equalsimpl(long j, Object obj) {
                return (obj instanceof ValueTimeMark) && j == ((ValueTimeMark) obj).getReading();
            }

            /* renamed from: equals-impl0, reason: not valid java name */
            public static final boolean m1846equalsimpl0(long j, long j2) {
                return j == j2;
            }

            /* renamed from: hashCode-impl, reason: not valid java name */
            public static int m1849hashCodeimpl(long j) {
                return Long.hashCode(j);
            }

            /* renamed from: toString-impl, reason: not valid java name */
            public static String m1854toStringimpl(long j) {
                return "ValueTimeMark(reading=" + j + ')';
            }

            @Override // kotlin.time.ComparableTimeMark
            public boolean equals(Object other) {
                return m1845equalsimpl(this.reading, other);
            }

            @Override // kotlin.time.ComparableTimeMark
            public int hashCode() {
                return m1849hashCodeimpl(this.reading);
            }

            public String toString() {
                return m1854toStringimpl(this.reading);
            }

            /* renamed from: unbox-impl, reason: not valid java name and from getter */
            public final /* synthetic */ long getReading() {
                return this.reading;
            }

            /* renamed from: compareTo-impl, reason: not valid java name */
            public static int m1842compareToimpl(long j, ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m1840boximpl(j).compareTo(other);
            }

            @Override // java.lang.Comparable
            public int compareTo(ComparableTimeMark comparableTimeMark) {
                return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
            }

            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ ComparableTimeMark mo1715minusLRDsOJo(long j) {
                return m1840boximpl(m1855minusLRDsOJo(j));
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo1715minusLRDsOJo(long j) {
                return m1840boximpl(m1855minusLRDsOJo(j));
            }

            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ ComparableTimeMark mo1717plusLRDsOJo(long j) {
                return m1840boximpl(m1856plusLRDsOJo(j));
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo1717plusLRDsOJo(long j) {
                return m1840boximpl(m1856plusLRDsOJo(j));
            }

            private /* synthetic */ ValueTimeMark(long j) {
                this.reading = j;
            }

            /* renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
            public static long m1844elapsedNowUwyO8pc(long j) {
                return MonotonicTimeSource.INSTANCE.m1833elapsedFrom6eNON_k(j);
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: elapsedNow-UwyO8pc */
            public long mo1714elapsedNowUwyO8pc() {
                return m1844elapsedNowUwyO8pc(this.reading);
            }

            /* renamed from: plus-LRDsOJo, reason: not valid java name */
            public static long m1853plusLRDsOJo(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m1831adjustReading6QKq23U(j, j2);
            }

            /* renamed from: plus-LRDsOJo, reason: not valid java name */
            public long m1856plusLRDsOJo(long j) {
                return m1853plusLRDsOJo(this.reading, j);
            }

            /* renamed from: minus-LRDsOJo, reason: not valid java name */
            public static long m1851minusLRDsOJo(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m1831adjustReading6QKq23U(j, Duration.m1769unaryMinusUwyO8pc(j2));
            }

            /* renamed from: minus-LRDsOJo, reason: not valid java name */
            public long m1855minusLRDsOJo(long j) {
                return m1851minusLRDsOJo(this.reading, j);
            }

            /* renamed from: hasPassedNow-impl, reason: not valid java name */
            public static boolean m1848hasPassedNowimpl(long j) {
                return !Duration.m1751isNegativeimpl(m1844elapsedNowUwyO8pc(j));
            }

            @Override // kotlin.time.TimeMark
            public boolean hasPassedNow() {
                return m1848hasPassedNowimpl(this.reading);
            }

            /* renamed from: hasNotPassedNow-impl, reason: not valid java name */
            public static boolean m1847hasNotPassedNowimpl(long j) {
                return Duration.m1751isNegativeimpl(m1844elapsedNowUwyO8pc(j));
            }

            @Override // kotlin.time.TimeMark
            public boolean hasNotPassedNow() {
                return m1847hasNotPassedNowimpl(this.reading);
            }

            @Override // kotlin.time.ComparableTimeMark
            /* renamed from: minus-UwyO8pc */
            public long mo1716minusUwyO8pc(ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m1852minusUwyO8pc(this.reading, other);
            }

            /* renamed from: minus-UwyO8pc, reason: not valid java name */
            public static long m1852minusUwyO8pc(long j, ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                if (!(other instanceof ValueTimeMark)) {
                    throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) m1854toStringimpl(j)) + " and " + other);
                }
                return m1850minus6eNON_k(j, ((ValueTimeMark) other).getReading());
            }

            /* renamed from: minus-6eNON_k, reason: not valid java name */
            public static final long m1850minus6eNON_k(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m1832differenceBetweenfRLX17w(j, j2);
            }

            /* renamed from: compareTo-6eNON_k, reason: not valid java name */
            public static final int m1841compareTo6eNON_k(long j, long j2) {
                return Duration.m1724compareToLRDsOJo(m1850minus6eNON_k(j, j2), Duration.INSTANCE.m1816getZEROUwyO8pc());
            }
        }
    }

    /* compiled from: TimeSource.kt */
    @Metadata(m4d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5d2 = {"Lkotlin/time/TimeSource$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "kotlin-stdlib"}, m6k = 1, m7mv = {2, 1, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
