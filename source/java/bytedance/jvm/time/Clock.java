package bytedance.jvm.time;

import bytedance.jvm.time.temporal.TemporalAmount;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class Clock {
    public abstract ZoneId getZone();

    public abstract Instant instant();

    public abstract Clock withZone(ZoneId zoneId);

    public static Clock systemUTC() {
        return SystemClock.UTC;
    }

    public static Clock systemDefaultZone() {
        return new SystemClock(ZoneId.systemDefault());
    }

    public static Clock system(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId == ZoneOffset.UTC) {
            return SystemClock.UTC;
        }
        return new SystemClock(zoneId);
    }

    public static Clock tickMillis(ZoneId zoneId) {
        return new TickClock(system(zoneId), 1000000L);
    }

    public static Clock tickSeconds(ZoneId zoneId) {
        return new TickClock(system(zoneId), 1000000000L);
    }

    public static Clock tickMinutes(ZoneId zoneId) {
        return new TickClock(system(zoneId), 60000000000L);
    }

    public static Clock tick(Clock clock, Duration duration) {
        Objects.requireNonNull(clock, "baseClock");
        Objects.requireNonNull(duration, "tickDuration");
        if (duration.isNegative()) {
            throw new IllegalArgumentException("Tick duration must not be negative");
        }
        long nanos = duration.toNanos();
        if (nanos % 1000000 == 0 || 1000000000 % nanos == 0) {
            return nanos <= 1 ? clock : new TickClock(clock, nanos);
        }
        throw new IllegalArgumentException("Invalid tick duration");
    }

    public static Clock fixed(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "fixedInstant");
        Objects.requireNonNull(zoneId, "zone");
        return new FixedClock(instant, zoneId);
    }

    public static Clock offset(Clock clock, Duration duration) {
        Objects.requireNonNull(clock, "baseClock");
        Objects.requireNonNull(duration, "offsetDuration");
        return duration.equals(Duration.ZERO) ? clock : new OffsetClock(clock, duration);
    }

    public long millis() {
        return instant().toEpochMilli();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class SystemClock extends Clock implements Serializable {
        private static final long OFFSET_SEED = (System.currentTimeMillis() / 1000) - 1024;
        static final SystemClock UTC = new SystemClock(ZoneOffset.UTC);
        private static final long serialVersionUID = 6740630888130243051L;
        private final ZoneId zone;

        SystemClock(ZoneId zoneId) {
            this.zone = zoneId;
        }

        @Override // bytedance.jvm.time.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        @Override // bytedance.jvm.time.Clock
        public Clock withZone(ZoneId zoneId) {
            return zoneId.equals(this.zone) ? this : new SystemClock(zoneId);
        }

        @Override // bytedance.jvm.time.Clock
        public long millis() {
            return System.currentTimeMillis();
        }

        @Override // bytedance.jvm.time.Clock
        public Instant instant() {
            return Instant.ofEpochMilli(millis());
        }

        @Override // bytedance.jvm.time.Clock
        public boolean equals(Object obj) {
            if (obj instanceof SystemClock) {
                return this.zone.equals(((SystemClock) obj).zone);
            }
            return false;
        }

        @Override // bytedance.jvm.time.Clock
        public int hashCode() {
            return this.zone.hashCode() + 1;
        }

        public String toString() {
            return "SystemClock[" + this.zone + "]";
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    static final class FixedClock extends Clock implements Serializable {
        private static final long serialVersionUID = 7430389292664866958L;
        private final Instant instant;
        private final ZoneId zone;

        FixedClock(Instant instant, ZoneId zoneId) {
            this.instant = instant;
            this.zone = zoneId;
        }

        @Override // bytedance.jvm.time.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        @Override // bytedance.jvm.time.Clock
        public Clock withZone(ZoneId zoneId) {
            return zoneId.equals(this.zone) ? this : new FixedClock(this.instant, zoneId);
        }

        @Override // bytedance.jvm.time.Clock
        public long millis() {
            return this.instant.toEpochMilli();
        }

        @Override // bytedance.jvm.time.Clock
        public Instant instant() {
            return this.instant;
        }

        @Override // bytedance.jvm.time.Clock
        public boolean equals(Object obj) {
            if (!(obj instanceof FixedClock)) {
                return false;
            }
            FixedClock fixedClock = (FixedClock) obj;
            return this.instant.equals(fixedClock.instant) && this.zone.equals(fixedClock.zone);
        }

        @Override // bytedance.jvm.time.Clock
        public int hashCode() {
            return this.instant.hashCode() ^ this.zone.hashCode();
        }

        public String toString() {
            return "FixedClock[" + this.instant + "," + this.zone + "]";
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    static final class OffsetClock extends Clock implements Serializable {
        private static final long serialVersionUID = 2007484719125426256L;
        private final Clock baseClock;
        private final Duration offset;

        OffsetClock(Clock clock, Duration duration) {
            this.baseClock = clock;
            this.offset = duration;
        }

        @Override // bytedance.jvm.time.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // bytedance.jvm.time.Clock
        public Clock withZone(ZoneId zoneId) {
            return zoneId.equals(this.baseClock.getZone()) ? this : new OffsetClock(this.baseClock.withZone(zoneId), this.offset);
        }

        @Override // bytedance.jvm.time.Clock
        public long millis() {
            return Math.addExact(this.baseClock.millis(), this.offset.toMillis());
        }

        @Override // bytedance.jvm.time.Clock
        public Instant instant() {
            return this.baseClock.instant().plus((TemporalAmount) this.offset);
        }

        @Override // bytedance.jvm.time.Clock
        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetClock)) {
                return false;
            }
            OffsetClock offsetClock = (OffsetClock) obj;
            return this.baseClock.equals(offsetClock.baseClock) && this.offset.equals(offsetClock.offset);
        }

        @Override // bytedance.jvm.time.Clock
        public int hashCode() {
            return this.baseClock.hashCode() ^ this.offset.hashCode();
        }

        public String toString() {
            return "OffsetClock[" + this.baseClock + "," + this.offset + "]";
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    static final class TickClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6504659149906368850L;
        private final Clock baseClock;
        private final long tickNanos;

        TickClock(Clock clock, long j) {
            this.baseClock = clock;
            this.tickNanos = j;
        }

        @Override // bytedance.jvm.time.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // bytedance.jvm.time.Clock
        public Clock withZone(ZoneId zoneId) {
            return zoneId.equals(this.baseClock.getZone()) ? this : new TickClock(this.baseClock.withZone(zoneId), this.tickNanos);
        }

        @Override // bytedance.jvm.time.Clock
        public long millis() {
            long millis = this.baseClock.millis();
            return millis - Math.floorMod(millis, this.tickNanos / 1000000);
        }

        @Override // bytedance.jvm.time.Clock
        public Instant instant() {
            if (this.tickNanos % 1000000 == 0) {
                long millis = this.baseClock.millis();
                return Instant.ofEpochMilli(millis - Math.floorMod(millis, this.tickNanos / 1000000));
            }
            return this.baseClock.instant().minusNanos(Math.floorMod(r0.getNano(), this.tickNanos));
        }

        @Override // bytedance.jvm.time.Clock
        public boolean equals(Object obj) {
            if (!(obj instanceof TickClock)) {
                return false;
            }
            TickClock tickClock = (TickClock) obj;
            return this.baseClock.equals(tickClock.baseClock) && this.tickNanos == tickClock.tickNanos;
        }

        @Override // bytedance.jvm.time.Clock
        public int hashCode() {
            int hashCode = this.baseClock.hashCode();
            long j = this.tickNanos;
            return hashCode ^ ((int) (j ^ (j >>> 32)));
        }

        public String toString() {
            return "TickClock[" + this.baseClock + "," + Duration.ofNanos(this.tickNanos) + "]";
        }
    }
}
