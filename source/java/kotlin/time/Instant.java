package kotlin.time;

import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.time.Duration;
import net.openid.appauth.BuildConfig;

/* compiled from: Instant.kt */
@Metadata(m4d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u0005J\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001cH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\""}, m5d2 = {"Lkotlin/time/Instant;", BuildConfig.FLAVOR, "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "epochSeconds", BuildConfig.FLAVOR, "nanosecondsOfSecond", BuildConfig.FLAVOR, "<init>", "(JI)V", "getEpochSeconds", "()J", "getNanosecondsOfSecond", "()I", "toEpochMilliseconds", "plus", "duration", "Lkotlin/time/Duration;", "plus-LRDsOJo", "(J)Lkotlin/time/Instant;", "minus", "minus-LRDsOJo", "other", "minus-UwyO8pc", "(Lkotlin/time/Instant;)J", "compareTo", "equals", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "writeReplace", "Companion", "kotlin-stdlib"}, m6k = 1, m7mv = {2, 1, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class Instant implements Comparable<Instant>, Serializable {
    private final long epochSeconds;
    private final int nanosecondsOfSecond;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Instant MIN = new Instant(-31557014167219200L, 0);
    private static final Instant MAX = new Instant(31556889864403199L, 999999999);

    public Instant(long j, int i) {
        this.epochSeconds = j;
        this.nanosecondsOfSecond = i;
        boolean z = false;
        if (-31557014167219200L <= j && j < 31556889864403200L) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("Instant exceeds minimum or maximum instant".toString());
        }
    }

    public final long getEpochSeconds() {
        return this.epochSeconds;
    }

    public final int getNanosecondsOfSecond() {
        return this.nanosecondsOfSecond;
    }

    public final long toEpochMilliseconds() {
        long j = this.epochSeconds;
        long j2 = 1000;
        if (j >= 0) {
            if (j != 1) {
                if (j != 0) {
                    long j3 = j * 1000;
                    if (j3 / 1000 != j) {
                        return LongCompanionObject.MAX_VALUE;
                    }
                    int i = (j > Long.MIN_VALUE ? 1 : (j == Long.MIN_VALUE ? 0 : -1));
                    j2 = j3;
                } else {
                    j2 = 0;
                }
            }
            long j4 = this.nanosecondsOfSecond / 1000000;
            long j5 = j2 + j4;
            return ((j2 ^ j5) >= 0 || (j4 ^ j2) < 0) ? j5 : LongCompanionObject.MAX_VALUE;
        }
        long j6 = j + 1;
        if (j6 != 1) {
            if (j6 != 0) {
                long j7 = j6 * 1000;
                if (j7 / 1000 != j6) {
                    return Long.MIN_VALUE;
                }
                int i2 = (j6 > Long.MIN_VALUE ? 1 : (j6 == Long.MIN_VALUE ? 0 : -1));
                j2 = j7;
            } else {
                j2 = 0;
            }
        }
        long j8 = (this.nanosecondsOfSecond / 1000000) - 1000;
        long j9 = j2 + j8;
        if ((j2 ^ j9) >= 0 || (j8 ^ j2) < 0) {
            return j9;
        }
        return Long.MIN_VALUE;
    }

    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public final Instant m1823minusLRDsOJo(long duration) {
        return m1825plusLRDsOJo(Duration.m1769unaryMinusUwyO8pc(duration));
    }

    /* renamed from: minus-UwyO8pc, reason: not valid java name */
    public final long m1824minusUwyO8pc(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Duration.Companion companion = Duration.INSTANCE;
        long duration = DurationKt.toDuration(this.epochSeconds - other.epochSeconds, DurationUnit.SECONDS);
        Duration.Companion companion2 = Duration.INSTANCE;
        return Duration.m1754plusLRDsOJo(duration, DurationKt.toDuration(this.nanosecondsOfSecond - other.nanosecondsOfSecond, DurationUnit.NANOSECONDS));
    }

    @Override // java.lang.Comparable
    public int compareTo(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int compare = Intrinsics.compare(this.epochSeconds, other.epochSeconds);
        return compare != 0 ? compare : Intrinsics.compare(this.nanosecondsOfSecond, other.nanosecondsOfSecond);
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (other instanceof Instant) {
                Instant instant = (Instant) other;
                if (this.epochSeconds != instant.epochSeconds || this.nanosecondsOfSecond != instant.nanosecondsOfSecond) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Long.hashCode(this.epochSeconds) + (this.nanosecondsOfSecond * 51);
    }

    public String toString() {
        String formatIso;
        formatIso = InstantKt.formatIso(this);
        return formatIso;
    }

    private final Object writeReplace() {
        return InstantJvmKt.serializedInstant(this);
    }

    /* compiled from: Instant.kt */
    @Metadata(m4d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006\u0019"}, m5d2 = {"Lkotlin/time/Instant$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "now", "Lkotlin/time/Instant;", "fromEpochMilliseconds", "epochMilliseconds", BuildConfig.FLAVOR, "fromEpochSeconds", "epochSeconds", "nanosecondAdjustment", BuildConfig.FLAVOR, "parse", "input", BuildConfig.FLAVOR, "DISTANT_PAST", "getDISTANT_PAST", "()Lkotlin/time/Instant;", "DISTANT_FUTURE", "getDISTANT_FUTURE", "MIN", "getMIN$kotlin_stdlib", "MAX", "getMAX$kotlin_stdlib", "kotlin-stdlib"}, m6k = 1, m7mv = {2, 1, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use Clock.System.now() instead", replaceWith = @ReplaceWith(expression = "Clock.System.now()", imports = {"kotlin.time.Clock"}))
        public final Instant now() {
            throw new NotImplementedError(null, 1, null);
        }

        public final Instant fromEpochMilliseconds(long epochMilliseconds) {
            long j = epochMilliseconds / 1000;
            if ((epochMilliseconds ^ 1000) < 0 && j * 1000 != epochMilliseconds) {
                j--;
            }
            long j2 = epochMilliseconds % 1000;
            int i = (int) ((j2 + (1000 & (((j2 ^ 1000) & ((-j2) | j2)) >> 63))) * 1000000);
            if (j < -31557014167219200L) {
                return getMIN$kotlin_stdlib();
            }
            if (j > 31556889864403199L) {
                return getMAX$kotlin_stdlib();
            }
            return fromEpochSeconds(j, i);
        }

        public static /* synthetic */ Instant fromEpochSeconds$default(Companion companion, long j, long j2, int i, Object obj) {
            if ((i & 2) != 0) {
                j2 = 0;
            }
            return companion.fromEpochSeconds(j, j2);
        }

        public final Instant fromEpochSeconds(long epochSeconds, long nanosecondAdjustment) {
            long j = nanosecondAdjustment / 1000000000;
            if ((nanosecondAdjustment ^ 1000000000) < 0 && j * 1000000000 != nanosecondAdjustment) {
                j--;
            }
            long j2 = epochSeconds + j;
            if ((epochSeconds ^ j2) < 0 && (j ^ epochSeconds) >= 0) {
                return epochSeconds > 0 ? Instant.INSTANCE.getMAX$kotlin_stdlib() : Instant.INSTANCE.getMIN$kotlin_stdlib();
            }
            if (j2 < -31557014167219200L) {
                return getMIN$kotlin_stdlib();
            }
            if (j2 > 31556889864403199L) {
                return getMAX$kotlin_stdlib();
            }
            long j3 = nanosecondAdjustment % 1000000000;
            return new Instant(j2, (int) (j3 + ((((j3 ^ 1000000000) & ((-j3) | j3)) >> 63) & 1000000000)));
        }

        public final Instant fromEpochSeconds(long epochSeconds, int nanosecondAdjustment) {
            return fromEpochSeconds(epochSeconds, nanosecondAdjustment);
        }

        public final Instant parse(CharSequence input) {
            Instant parseIso;
            Intrinsics.checkNotNullParameter(input, "input");
            parseIso = InstantKt.parseIso(input);
            return parseIso;
        }

        public final Instant getDISTANT_PAST() {
            return fromEpochSeconds(kotlinx.datetime.InstantKt.DISTANT_PAST_SECONDS, 999999999);
        }

        public final Instant getDISTANT_FUTURE() {
            return fromEpochSeconds(kotlinx.datetime.InstantKt.DISTANT_FUTURE_SECONDS, 0);
        }

        public final Instant getMIN$kotlin_stdlib() {
            return Instant.MIN;
        }

        public final Instant getMAX$kotlin_stdlib() {
            return Instant.MAX;
        }
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public final Instant m1825plusLRDsOJo(long duration) {
        long m1739getInWholeSecondsimpl = Duration.m1739getInWholeSecondsimpl(duration);
        int m1741getNanosecondsComponentimpl = Duration.m1741getNanosecondsComponentimpl(duration);
        if (m1739getInWholeSecondsimpl == 0 && m1741getNanosecondsComponentimpl == 0) {
            return this;
        }
        long j = this.epochSeconds;
        long j2 = j + m1739getInWholeSecondsimpl;
        if ((j ^ j2) >= 0 || (m1739getInWholeSecondsimpl ^ j) < 0) {
            return INSTANCE.fromEpochSeconds(j2, this.nanosecondsOfSecond + m1741getNanosecondsComponentimpl);
        }
        return Duration.m1752isPositiveimpl(duration) ? MAX : MIN;
    }
}
