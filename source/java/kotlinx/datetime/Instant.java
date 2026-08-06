package kotlinx.datetime;

import bytedance.jvm.time.DateTimeException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.format.DateTimeComponents;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.serializers.InstantIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import net.openid.appauth.BuildConfig;

/* compiled from: Instant.kt */
@Metadata(m4d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\tJ\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, m5d2 = {"Lkotlinx/datetime/Instant;", BuildConfig.FLAVOR, "value", "Lbytedance/jvm/time/Instant;", "<init>", "(Lbytedance/jvm/time/Instant;)V", "getValue$kotlinx_datetime_release", "()Lbytedance/jvm/time/Instant;", "epochSeconds", BuildConfig.FLAVOR, "getEpochSeconds", "()J", "nanosecondsOfSecond", BuildConfig.FLAVOR, "getNanosecondsOfSecond", "()I", "toEpochMilliseconds", "plus", "duration", "Lkotlin/time/Duration;", "plus-LRDsOJo", "(J)Lkotlinx/datetime/Instant;", "minus", "minus-LRDsOJo", "other", "minus-5sfh64U", "(Lkotlinx/datetime/Instant;)J", "compareTo", "equals", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "Companion", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
@Serializable(with = InstantIso8601Serializer.class)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class Instant implements Comparable<Instant> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Instant DISTANT_FUTURE;
    private static final Instant DISTANT_PAST;
    private static final Instant MAX;
    private static final Instant MIN;
    private final bytedance.jvm.time.Instant value;

    public Instant(bytedance.jvm.time.Instant value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    /* renamed from: getValue$kotlinx_datetime_release, reason: from getter */
    public final bytedance.jvm.time.Instant getValue() {
        return this.value;
    }

    public final long getEpochSeconds() {
        return this.value.getEpochSecond();
    }

    public final int getNanosecondsOfSecond() {
        return this.value.getNano();
    }

    public final long toEpochMilliseconds() {
        try {
            return this.value.toEpochMilli();
        } catch (ArithmeticException unused) {
            if (this.value.isAfter(bytedance.jvm.time.Instant.EPOCH)) {
                return LongCompanionObject.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        }
    }

    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public final Instant m1952minusLRDsOJo(long duration) {
        return m1953plusLRDsOJo(Duration.m1769unaryMinusUwyO8pc(duration));
    }

    /* renamed from: minus-5sfh64U, reason: not valid java name */
    public final long m1951minus5sfh64U(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Duration.Companion companion = Duration.INSTANCE;
        long duration = DurationKt.toDuration(this.value.getEpochSecond() - other.value.getEpochSecond(), DurationUnit.SECONDS);
        Duration.Companion companion2 = Duration.INSTANCE;
        return Duration.m1754plusLRDsOJo(duration, DurationKt.toDuration(this.value.getNano() - other.value.getNano(), DurationUnit.NANOSECONDS));
    }

    @Override // java.lang.Comparable
    public int compareTo(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo(other.value);
    }

    public boolean equals(Object other) {
        return this == other || ((other instanceof Instant) && Intrinsics.areEqual(this.value, ((Instant) other).value));
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        String instant = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(instant, "toString(...)");
        return instant;
    }

    /* compiled from: Instant.kt */
    @Metadata(m4d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\bJ\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017¨\u0006 "}, m5d2 = {"Lkotlinx/datetime/Instant$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "now", "Lkotlinx/datetime/Instant;", "fromEpochMilliseconds", "epochMilliseconds", BuildConfig.FLAVOR, "parse", "input", BuildConfig.FLAVOR, "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "isoString", BuildConfig.FLAVOR, "fromEpochSeconds", "epochSeconds", "nanosecondAdjustment", BuildConfig.FLAVOR, "DISTANT_PAST", "getDISTANT_PAST", "()Lkotlinx/datetime/Instant;", "DISTANT_FUTURE", "getDISTANT_FUTURE", "MIN", "getMIN$kotlinx_datetime_release", "MAX", "getMAX$kotlinx_datetime_release", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Instant> serializer() {
            return InstantIso8601Serializer.INSTANCE;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use Clock.System.now() instead", replaceWith = @ReplaceWith(expression = "Clock.System.now()", imports = {"kotlinx.datetime.Clock"}))
        public final Instant now() {
            bytedance.jvm.time.Instant instant = bytedance.jvm.time.Clock.systemUTC().instant();
            Intrinsics.checkNotNullExpressionValue(instant, "instant(...)");
            return new Instant(instant);
        }

        public final Instant fromEpochMilliseconds(long epochMilliseconds) {
            bytedance.jvm.time.Instant ofEpochMilli = bytedance.jvm.time.Instant.ofEpochMilli(epochMilliseconds);
            Intrinsics.checkNotNullExpressionValue(ofEpochMilli, "ofEpochMilli(...)");
            return new Instant(ofEpochMilli);
        }

        public final Instant parse(CharSequence input, DateTimeFormat<DateTimeComponents> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            try {
                return format.parse(input).toInstantUsingOffset();
            } catch (IllegalArgumentException e) {
                throw new DateTimeFormatException("Failed to parse an instant from '" + ((Object) input) + '\'', e);
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is only kept for binary compatibility")
        public final /* synthetic */ Instant parse(String isoString) {
            Intrinsics.checkNotNullParameter(isoString, "isoString");
            return parse$default(this, isoString, null, 2, null);
        }

        public static /* synthetic */ Instant fromEpochSeconds$default(Companion companion, long j, long j2, int i, Object obj) {
            if ((i & 2) != 0) {
                j2 = 0;
            }
            return companion.fromEpochSeconds(j, j2);
        }

        public final Instant fromEpochSeconds(long epochSeconds, long nanosecondAdjustment) {
            try {
                bytedance.jvm.time.Instant ofEpochSecond = bytedance.jvm.time.Instant.ofEpochSecond(epochSeconds, nanosecondAdjustment);
                Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(...)");
                return new Instant(ofEpochSecond);
            } catch (Exception e) {
                if ((e instanceof ArithmeticException) || (e instanceof DateTimeException)) {
                    return epochSeconds > 0 ? getMAX$kotlinx_datetime_release() : getMIN$kotlinx_datetime_release();
                }
                throw e;
            }
        }

        public final Instant fromEpochSeconds(long epochSeconds, int nanosecondAdjustment) {
            return fromEpochSeconds(epochSeconds, nanosecondAdjustment);
        }

        public final Instant getDISTANT_PAST() {
            return Instant.DISTANT_PAST;
        }

        public final Instant getDISTANT_FUTURE() {
            return Instant.DISTANT_FUTURE;
        }

        public final Instant getMIN$kotlinx_datetime_release() {
            return Instant.MIN;
        }

        public final Instant getMAX$kotlinx_datetime_release() {
            return Instant.MAX;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Instant parse$default(Companion companion, CharSequence charSequence, DateTimeFormat dateTimeFormat, int i, Object obj) {
            if ((i & 2) != 0) {
                dateTimeFormat = DateTimeComponents.Formats.INSTANCE.getISO_DATE_TIME_OFFSET();
            }
            return companion.parse(charSequence, dateTimeFormat);
        }
    }

    static {
        bytedance.jvm.time.Instant ofEpochSecond = bytedance.jvm.time.Instant.ofEpochSecond(InstantKt.DISTANT_PAST_SECONDS, 999999999L);
        Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(...)");
        DISTANT_PAST = new Instant(ofEpochSecond);
        bytedance.jvm.time.Instant ofEpochSecond2 = bytedance.jvm.time.Instant.ofEpochSecond(InstantKt.DISTANT_FUTURE_SECONDS, 0L);
        Intrinsics.checkNotNullExpressionValue(ofEpochSecond2, "ofEpochSecond(...)");
        DISTANT_FUTURE = new Instant(ofEpochSecond2);
        bytedance.jvm.time.Instant MIN2 = bytedance.jvm.time.Instant.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN2, "MIN");
        MIN = new Instant(MIN2);
        bytedance.jvm.time.Instant MAX2 = bytedance.jvm.time.Instant.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX2, "MAX");
        MAX = new Instant(MAX2);
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public final Instant m1953plusLRDsOJo(long duration) {
        try {
            bytedance.jvm.time.Instant plusNanos = this.value.plusSeconds(Duration.m1739getInWholeSecondsimpl(duration)).plusNanos(Duration.m1741getNanosecondsComponentimpl(duration));
            Intrinsics.checkNotNullExpressionValue(plusNanos, "plusNanos(...)");
            return new Instant(plusNanos);
        } catch (Exception e) {
            if ((e instanceof ArithmeticException) || (e instanceof DateTimeException)) {
                return Duration.m1752isPositiveimpl(duration) ? MAX : MIN;
            }
            throw e;
        }
    }
}
