package bytedance.jvm.time;

import java.io.Serializable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class DesugarClock {
    static final long NANOS_PER_MILLI = 1000000;

    private DesugarClock() {
    }

    public static Clock tickMillis(ZoneId zoneId) {
        return new DesugarTickClock(Clock.system(zoneId), NANOS_PER_MILLI);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    static final class DesugarTickClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6504659149906368850L;
        private final Clock baseClock;
        private final long tickNanos;

        DesugarTickClock(Clock clock, long j) {
            this.baseClock = clock;
            this.tickNanos = j;
        }

        @Override // bytedance.jvm.time.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // bytedance.jvm.time.Clock
        public Clock withZone(ZoneId zoneId) {
            return zoneId.equals(this.baseClock.getZone()) ? this : new DesugarTickClock(this.baseClock.withZone(zoneId), this.tickNanos);
        }

        @Override // bytedance.jvm.time.Clock
        public long millis() {
            long millis = this.baseClock.millis();
            return millis - Math.floorMod(millis, this.tickNanos / DesugarClock.NANOS_PER_MILLI);
        }

        @Override // bytedance.jvm.time.Clock
        public Instant instant() {
            if (this.tickNanos % DesugarClock.NANOS_PER_MILLI == 0) {
                long millis = this.baseClock.millis();
                return Instant.ofEpochMilli(millis - Math.floorMod(millis, this.tickNanos / DesugarClock.NANOS_PER_MILLI));
            }
            return this.baseClock.instant().minusNanos(Math.floorMod(r0.getNano(), this.tickNanos));
        }

        @Override // bytedance.jvm.time.Clock
        public boolean equals(Object obj) {
            if (!(obj instanceof DesugarTickClock)) {
                return false;
            }
            DesugarTickClock desugarTickClock = (DesugarTickClock) obj;
            return this.baseClock.equals(desugarTickClock.baseClock) && this.tickNanos == desugarTickClock.tickNanos;
        }

        @Override // bytedance.jvm.time.Clock
        public int hashCode() {
            int hashCode = this.baseClock.hashCode();
            long j = this.tickNanos;
            return hashCode ^ ((int) (j ^ (j >>> 32)));
        }

        public String toString() {
            return "DesugarTickClock[" + this.baseClock + "," + Duration.ofNanos(this.tickNanos) + "]";
        }
    }
}
