package bytedance.jvm.time.temporal;

import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.chrono.Chronology;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class TemporalQueries {
    static final TemporalQuery<ZoneId> ZONE_ID = new TemporalQuery<ZoneId>() { // from class: bytedance.jvm.time.temporal.TemporalQueries.1
        public String toString() {
            return "ZoneId";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // bytedance.jvm.time.temporal.TemporalQuery
        public ZoneId queryFrom(TemporalAccessor temporalAccessor) {
            return (ZoneId) temporalAccessor.query(TemporalQueries.ZONE_ID);
        }
    };
    static final TemporalQuery<Chronology> CHRONO = new TemporalQuery<Chronology>() { // from class: bytedance.jvm.time.temporal.TemporalQueries.2
        public String toString() {
            return "Chronology";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // bytedance.jvm.time.temporal.TemporalQuery
        public Chronology queryFrom(TemporalAccessor temporalAccessor) {
            return (Chronology) temporalAccessor.query(TemporalQueries.CHRONO);
        }
    };
    static final TemporalQuery<TemporalUnit> PRECISION = new TemporalQuery<TemporalUnit>() { // from class: bytedance.jvm.time.temporal.TemporalQueries.3
        public String toString() {
            return "Precision";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // bytedance.jvm.time.temporal.TemporalQuery
        public TemporalUnit queryFrom(TemporalAccessor temporalAccessor) {
            return (TemporalUnit) temporalAccessor.query(TemporalQueries.PRECISION);
        }
    };
    static final TemporalQuery<ZoneOffset> OFFSET = new TemporalQuery<ZoneOffset>() { // from class: bytedance.jvm.time.temporal.TemporalQueries.4
        public String toString() {
            return "ZoneOffset";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // bytedance.jvm.time.temporal.TemporalQuery
        public ZoneOffset queryFrom(TemporalAccessor temporalAccessor) {
            if (temporalAccessor.isSupported(ChronoField.OFFSET_SECONDS)) {
                return ZoneOffset.ofTotalSeconds(temporalAccessor.get(ChronoField.OFFSET_SECONDS));
            }
            return null;
        }
    };
    static final TemporalQuery<ZoneId> ZONE = new TemporalQuery<ZoneId>() { // from class: bytedance.jvm.time.temporal.TemporalQueries.5
        public String toString() {
            return "Zone";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // bytedance.jvm.time.temporal.TemporalQuery
        public ZoneId queryFrom(TemporalAccessor temporalAccessor) {
            ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.ZONE_ID);
            return zoneId != null ? zoneId : (ZoneId) temporalAccessor.query(TemporalQueries.OFFSET);
        }
    };
    static final TemporalQuery<LocalDate> LOCAL_DATE = new TemporalQuery<LocalDate>() { // from class: bytedance.jvm.time.temporal.TemporalQueries.6
        public String toString() {
            return "LocalDate";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // bytedance.jvm.time.temporal.TemporalQuery
        public LocalDate queryFrom(TemporalAccessor temporalAccessor) {
            if (temporalAccessor.isSupported(ChronoField.EPOCH_DAY)) {
                return LocalDate.ofEpochDay(temporalAccessor.getLong(ChronoField.EPOCH_DAY));
            }
            return null;
        }
    };
    static final TemporalQuery<LocalTime> LOCAL_TIME = new TemporalQuery<LocalTime>() { // from class: bytedance.jvm.time.temporal.TemporalQueries.7
        public String toString() {
            return "LocalTime";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // bytedance.jvm.time.temporal.TemporalQuery
        public LocalTime queryFrom(TemporalAccessor temporalAccessor) {
            if (temporalAccessor.isSupported(ChronoField.NANO_OF_DAY)) {
                return LocalTime.ofNanoOfDay(temporalAccessor.getLong(ChronoField.NANO_OF_DAY));
            }
            return null;
        }
    };

    private TemporalQueries() {
    }

    public static TemporalQuery<ZoneId> zoneId() {
        return ZONE_ID;
    }

    public static TemporalQuery<Chronology> chronology() {
        return CHRONO;
    }

    public static TemporalQuery<TemporalUnit> precision() {
        return PRECISION;
    }

    public static TemporalQuery<ZoneId> zone() {
        return ZONE;
    }

    public static TemporalQuery<ZoneOffset> offset() {
        return OFFSET;
    }

    public static TemporalQuery<LocalDate> localDate() {
        return LOCAL_DATE;
    }

    public static TemporalQuery<LocalTime> localTime() {
        return LOCAL_TIME;
    }
}
