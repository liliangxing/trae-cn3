package kotlinx.datetime;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.ZoneOffset;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.TimeZoneSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import net.openid.appauth.BuildConfig;

/* compiled from: TimeZoneJvm.kt */
@Metadata(m4d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\f\u001a\u00020\r*\u00020\u000eJ\n\u0010\u000f\u001a\u00020\u000e*\u00020\rJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, m5d2 = {"Lkotlinx/datetime/TimeZone;", BuildConfig.FLAVOR, "zoneId", "Lbytedance/jvm/time/ZoneId;", "<init>", "(Lbytedance/jvm/time/ZoneId;)V", "getZoneId$kotlinx_datetime_release", "()Lbytedance/jvm/time/ZoneId;", "id", BuildConfig.FLAVOR, "getId", "()Ljava/lang/String;", "toLocalDateTime", "Lkotlinx/datetime/LocalDateTime;", "Lkotlinx/datetime/Instant;", "toInstant", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
@Serializable(with = TimeZoneSerializer.class)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class TimeZone {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FixedOffsetTimeZone UTC;
    private final ZoneId zoneId;

    public TimeZone(ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        this.zoneId = zoneId;
    }

    /* renamed from: getZoneId$kotlinx_datetime_release, reason: from getter */
    public final ZoneId getZoneId() {
        return this.zoneId;
    }

    public final String getId() {
        String id = this.zoneId.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        return id;
    }

    public final LocalDateTime toLocalDateTime(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return TimeZoneKt.toLocalDateTime(instant, this);
    }

    public final Instant toInstant(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        return TimeZoneKt.toInstant(localDateTime, this);
    }

    public boolean equals(Object other) {
        return this == other || ((other instanceof TimeZone) && Intrinsics.areEqual(this.zoneId, ((TimeZone) other).zoneId));
    }

    public int hashCode() {
        return this.zoneId.hashCode();
    }

    public String toString() {
        String zoneId = this.zoneId.toString();
        Intrinsics.checkNotNullExpressionValue(zoneId, "toString(...)");
        return zoneId;
    }

    /* compiled from: TimeZoneJvm.kt */
    @Metadata(m4d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, m5d2 = {"Lkotlinx/datetime/TimeZone$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "currentSystemDefault", "Lkotlinx/datetime/TimeZone;", "UTC", "Lkotlinx/datetime/FixedOffsetTimeZone;", "getUTC", "()Lkotlinx/datetime/FixedOffsetTimeZone;", "of", "zoneId", BuildConfig.FLAVOR, "ofZone", "Lbytedance/jvm/time/ZoneId;", "ofZone$kotlinx_datetime_release", "availableZoneIds", BuildConfig.FLAVOR, "getAvailableZoneIds", "()Ljava/util/Set;", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TimeZone> serializer() {
            return TimeZoneSerializer.INSTANCE;
        }

        public final TimeZone currentSystemDefault() {
            ZoneId systemDefault = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(systemDefault, "systemDefault(...)");
            return ofZone$kotlinx_datetime_release(systemDefault);
        }

        public final FixedOffsetTimeZone getUTC() {
            return TimeZone.UTC;
        }

        /* renamed from: of */
        public final TimeZone m61of(String zoneId) {
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            try {
                ZoneId of = ZoneId.of(zoneId);
                Intrinsics.checkNotNullExpressionValue(of, "of(...)");
                return ofZone$kotlinx_datetime_release(of);
            } catch (Exception e) {
                if (e instanceof DateTimeException) {
                    throw new IllegalTimeZoneException(e);
                }
                throw e;
            }
        }

        public final TimeZone ofZone$kotlinx_datetime_release(ZoneId zoneId) {
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            if (zoneId instanceof ZoneOffset) {
                return new FixedOffsetTimeZone(new UtcOffset((ZoneOffset) zoneId));
            }
            if (TimeZoneKt__TimeZoneJvmKt.access$isFixedOffset(zoneId)) {
                ZoneOffset normalized = zoneId.normalized();
                Intrinsics.checkNotNull(normalized, "null cannot be cast to non-null type bytedance.jvm.time.ZoneOffset");
                return new FixedOffsetTimeZone(new UtcOffset(normalized), zoneId);
            }
            return new TimeZone(zoneId);
        }

        public final Set<String> getAvailableZoneIds() {
            Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
            Intrinsics.checkNotNullExpressionValue(availableZoneIds, "getAvailableZoneIds(...)");
            return availableZoneIds;
        }
    }

    static {
        ZoneOffset UTC2 = ZoneOffset.UTC;
        Intrinsics.checkNotNullExpressionValue(UTC2, "UTC");
        UTC = UtcOffsetKt.asTimeZone(new UtcOffset(UTC2));
    }
}
