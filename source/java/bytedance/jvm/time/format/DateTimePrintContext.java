package bytedance.jvm.time.format;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.Instant;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.chrono.ChronoLocalDate;
import bytedance.jvm.time.chrono.Chronology;
import bytedance.jvm.time.chrono.IsoChronology;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.TemporalQueries;
import bytedance.jvm.time.temporal.TemporalQuery;
import bytedance.jvm.time.temporal.ValueRange;
import java.util.Locale;
import java.util.Objects;
import kotlin.UByte$;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class DateTimePrintContext {
    private DateTimeFormatter formatter;
    private int optional;
    private TemporalAccessor temporal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimePrintContext(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        this.temporal = adjust(temporalAccessor, dateTimeFormatter);
        this.formatter = dateTimeFormatter;
    }

    private static TemporalAccessor adjust(final TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        Chronology chronology = dateTimeFormatter.getChronology();
        ZoneId zone = dateTimeFormatter.getZone();
        if (chronology == null && zone == null) {
            return temporalAccessor;
        }
        Chronology chronology2 = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        final ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.zoneId());
        final ChronoLocalDate chronoLocalDate = null;
        if (Objects.equals(chronology, chronology2)) {
            chronology = null;
        }
        if (Objects.equals(zone, zoneId)) {
            zone = null;
        }
        if (chronology == null && zone == null) {
            return temporalAccessor;
        }
        final Chronology chronology3 = chronology != null ? chronology : chronology2;
        if (zone != null) {
            if (temporalAccessor.isSupported(ChronoField.INSTANT_SECONDS)) {
                return ((Chronology) UByte$.ExternalSyntheticBackport0.m(chronology3, IsoChronology.INSTANCE)).zonedDateTime(Instant.from(temporalAccessor), zone);
            }
            if ((zone.normalized() instanceof ZoneOffset) && temporalAccessor.isSupported(ChronoField.OFFSET_SECONDS) && temporalAccessor.get(ChronoField.OFFSET_SECONDS) != zone.getRules().getOffset(Instant.EPOCH).getTotalSeconds()) {
                throw new DateTimeException("Unable to apply override zone '" + zone + "' because the temporal object being formatted has a different offset but does not represent an instant: " + temporalAccessor);
            }
        }
        if (zone != null) {
            zoneId = zone;
        }
        if (chronology != null) {
            if (temporalAccessor.isSupported(ChronoField.EPOCH_DAY)) {
                chronoLocalDate = chronology3.date(temporalAccessor);
            } else if (chronology != IsoChronology.INSTANCE || chronology2 != null) {
                for (ChronoField chronoField : ChronoField.values()) {
                    if (chronoField.isDateBased() && temporalAccessor.isSupported(chronoField)) {
                        throw new DateTimeException("Unable to apply override chronology '" + chronology + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + temporalAccessor);
                    }
                }
            }
        }
        return new TemporalAccessor() { // from class: bytedance.jvm.time.format.DateTimePrintContext.1
            @Override // bytedance.jvm.time.temporal.TemporalAccessor
            public boolean isSupported(TemporalField temporalField) {
                if (ChronoLocalDate.this != null && temporalField.isDateBased()) {
                    return ChronoLocalDate.this.isSupported(temporalField);
                }
                return temporalAccessor.isSupported(temporalField);
            }

            @Override // bytedance.jvm.time.temporal.TemporalAccessor
            public ValueRange range(TemporalField temporalField) {
                if (ChronoLocalDate.this != null && temporalField.isDateBased()) {
                    return ChronoLocalDate.this.range(temporalField);
                }
                return temporalAccessor.range(temporalField);
            }

            @Override // bytedance.jvm.time.temporal.TemporalAccessor
            public long getLong(TemporalField temporalField) {
                if (ChronoLocalDate.this != null && temporalField.isDateBased()) {
                    return ChronoLocalDate.this.getLong(temporalField);
                }
                return temporalAccessor.getLong(temporalField);
            }

            @Override // bytedance.jvm.time.temporal.TemporalAccessor
            public <R> R query(TemporalQuery<R> temporalQuery) {
                if (temporalQuery == TemporalQueries.chronology()) {
                    return (R) chronology3;
                }
                if (temporalQuery == TemporalQueries.zoneId()) {
                    return (R) zoneId;
                }
                if (temporalQuery == TemporalQueries.precision()) {
                    return (R) temporalAccessor.query(temporalQuery);
                }
                return temporalQuery.queryFrom(this);
            }

            public String toString() {
                return temporalAccessor + (chronology3 != null ? " with chronology " + chronology3 : "") + (zoneId != null ? " with zone " + zoneId : "");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TemporalAccessor getTemporal() {
        return this.temporal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Locale getLocale() {
        return this.formatter.getLocale();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecimalStyle getDecimalStyle() {
        return this.formatter.getDecimalStyle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startOptional() {
        this.optional++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endOptional() {
        this.optional--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <R> R getValue(TemporalQuery<R> temporalQuery) {
        R r = (R) this.temporal.query(temporalQuery);
        if (r == null && this.optional == 0) {
            throw new DateTimeException("Unable to extract " + temporalQuery + " from temporal " + this.temporal);
        }
        return r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Long getValue(TemporalField temporalField) {
        if (this.optional <= 0 || this.temporal.isSupported(temporalField)) {
            return Long.valueOf(this.temporal.getLong(temporalField));
        }
        return null;
    }

    public String toString() {
        return this.temporal.toString();
    }
}
