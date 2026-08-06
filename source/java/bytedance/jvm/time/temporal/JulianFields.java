package bytedance.jvm.time.temporal;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.chrono.ChronoLocalDate;
import bytedance.jvm.time.chrono.Chronology;
import bytedance.jvm.time.format.ResolverStyle;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class JulianFields {
    private static final long JULIAN_DAY_OFFSET = 2440588;
    public static final TemporalField JULIAN_DAY = Field.JULIAN_DAY;
    public static final TemporalField MODIFIED_JULIAN_DAY = Field.MODIFIED_JULIAN_DAY;
    public static final TemporalField RATA_DIE = Field.RATA_DIE;

    private JulianFields() {
        throw new AssertionError("Not instantiable");
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private enum Field implements TemporalField {
        JULIAN_DAY("JulianDay", ChronoUnit.DAYS, ChronoUnit.FOREVER, JulianFields.JULIAN_DAY_OFFSET),
        MODIFIED_JULIAN_DAY("ModifiedJulianDay", ChronoUnit.DAYS, ChronoUnit.FOREVER, 40587),
        RATA_DIE("RataDie", ChronoUnit.DAYS, ChronoUnit.FOREVER, 719163);

        private static final long serialVersionUID = -7501623920830201812L;
        private final transient TemporalUnit baseUnit;
        private final transient String name;
        private final transient long offset;
        private final transient ValueRange range;
        private final transient TemporalUnit rangeUnit;

        @Override // bytedance.jvm.time.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public /* bridge */ /* synthetic */ TemporalAccessor resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            return resolve((Map<TemporalField, Long>) map, temporalAccessor, resolverStyle);
        }

        Field(String str, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, long j) {
            this.name = str;
            this.baseUnit = temporalUnit;
            this.rangeUnit = temporalUnit2;
            this.range = ValueRange.m134of((-365243219162L) + j, 365241780471L + j);
            this.offset = j;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public TemporalUnit getBaseUnit() {
            return this.baseUnit;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public TemporalUnit getRangeUnit() {
            return this.rangeUnit;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public ValueRange range() {
            return this.range;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
            return temporalAccessor.isSupported(ChronoField.EPOCH_DAY);
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
            if (!isSupportedBy(temporalAccessor)) {
                throw new DateTimeException("Unsupported field: " + this);
            }
            return range();
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public long getFrom(TemporalAccessor temporalAccessor) {
            return temporalAccessor.getLong(ChronoField.EPOCH_DAY) + this.offset;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public <R extends Temporal> R adjustInto(R r, long j) {
            if (!range().isValidValue(j)) {
                throw new DateTimeException("Invalid value: " + this.name + " " + j);
            }
            return (R) r.with(ChronoField.EPOCH_DAY, Math.subtractExact(j, this.offset));
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public ChronoLocalDate resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            long longValue = map.remove(this).longValue();
            Chronology from = Chronology.from(temporalAccessor);
            if (resolverStyle == ResolverStyle.LENIENT) {
                return from.dateEpochDay(Math.subtractExact(longValue, this.offset));
            }
            range().checkValidValue(longValue, this);
            return from.dateEpochDay(longValue - this.offset);
        }

        @Override // java.lang.Enum, bytedance.jvm.time.temporal.TemporalField
        public String toString() {
            return this.name;
        }
    }
}
