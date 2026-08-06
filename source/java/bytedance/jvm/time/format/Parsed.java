package bytedance.jvm.time.format;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.Instant;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.Period;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.chrono.ChronoLocalDate;
import bytedance.jvm.time.chrono.ChronoLocalDateTime;
import bytedance.jvm.time.chrono.ChronoZonedDateTime;
import bytedance.jvm.time.chrono.Chronology;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalAmount;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.TemporalQueries;
import bytedance.jvm.time.temporal.TemporalQuery;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.UByte$;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class Parsed implements TemporalAccessor {
    Chronology chrono;
    private ChronoLocalDate date;
    boolean leapSecond;
    private ResolverStyle resolverStyle;
    private LocalTime time;
    ZoneId zone;
    final Map<TemporalField, Long> fieldValues = new HashMap();
    Period excessDays = Period.ZERO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parsed copy() {
        Parsed parsed = new Parsed();
        parsed.fieldValues.putAll(this.fieldValues);
        parsed.zone = this.zone;
        parsed.chrono = this.chrono;
        parsed.leapSecond = this.leapSecond;
        return parsed;
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        if (this.fieldValues.containsKey(temporalField)) {
            return true;
        }
        ChronoLocalDate chronoLocalDate = this.date;
        if (chronoLocalDate != null && chronoLocalDate.isSupported(temporalField)) {
            return true;
        }
        LocalTime localTime = this.time;
        if (localTime == null || !localTime.isSupported(temporalField)) {
            return (temporalField == null || (temporalField instanceof ChronoField) || !temporalField.isSupportedBy(this)) ? false : true;
        }
        return true;
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        Objects.requireNonNull(temporalField, "field");
        Long l = this.fieldValues.get(temporalField);
        if (l != null) {
            return l.longValue();
        }
        ChronoLocalDate chronoLocalDate = this.date;
        if (chronoLocalDate != null && chronoLocalDate.isSupported(temporalField)) {
            return this.date.getLong(temporalField);
        }
        LocalTime localTime = this.time;
        if (localTime != null && localTime.isSupported(temporalField)) {
            return this.time.getLong(temporalField);
        }
        if (temporalField instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return temporalField.getFrom(this);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.zoneId()) {
            return (R) this.zone;
        }
        if (temporalQuery == TemporalQueries.chronology()) {
            return (R) this.chrono;
        }
        if (temporalQuery == TemporalQueries.localDate()) {
            ChronoLocalDate chronoLocalDate = this.date;
            if (chronoLocalDate != null) {
                return (R) LocalDate.from((TemporalAccessor) chronoLocalDate);
            }
            return null;
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return (R) this.time;
        }
        if (temporalQuery == TemporalQueries.offset()) {
            Long l = this.fieldValues.get(ChronoField.OFFSET_SECONDS);
            if (l != null) {
                return (R) ZoneOffset.ofTotalSeconds(l.intValue());
            }
            R r = (R) this.zone;
            return r instanceof ZoneOffset ? r : temporalQuery.queryFrom(this);
        }
        if (temporalQuery == TemporalQueries.zone()) {
            return temporalQuery.queryFrom(this);
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TemporalAccessor resolve(ResolverStyle resolverStyle, Set<TemporalField> set) {
        if (set != null) {
            this.fieldValues.keySet().retainAll(set);
        }
        this.resolverStyle = resolverStyle;
        resolveFields();
        resolveTimeLenient();
        crossCheck();
        resolvePeriod();
        resolveFractional();
        resolveInstant();
        return this;
    }

    private void resolveFields() {
        resolveInstantFields();
        resolveDateFields();
        resolveTimeFields();
        if (this.fieldValues.size() > 0) {
            int i = 0;
            loop0: while (i < 50) {
                Iterator<Map.Entry<TemporalField, Long>> it = this.fieldValues.entrySet().iterator();
                while (it.hasNext()) {
                    TemporalField key = it.next().getKey();
                    TemporalAccessor resolve = key.resolve(this.fieldValues, this, this.resolverStyle);
                    if (resolve != null) {
                        if (resolve instanceof ChronoZonedDateTime) {
                            ChronoZonedDateTime chronoZonedDateTime = (ChronoZonedDateTime) resolve;
                            ZoneId zoneId = this.zone;
                            if (zoneId == null) {
                                this.zone = chronoZonedDateTime.getZone();
                            } else if (!zoneId.equals(chronoZonedDateTime.getZone())) {
                                throw new DateTimeException("ChronoZonedDateTime must use the effective parsed zone: " + this.zone);
                            }
                            resolve = chronoZonedDateTime.toLocalDateTime2();
                        }
                        if (resolve instanceof ChronoLocalDateTime) {
                            ChronoLocalDateTime chronoLocalDateTime = (ChronoLocalDateTime) resolve;
                            updateCheckConflict(chronoLocalDateTime.toLocalTime(), Period.ZERO);
                            updateCheckConflict(chronoLocalDateTime.toLocalDate());
                        } else if (resolve instanceof ChronoLocalDate) {
                            updateCheckConflict((ChronoLocalDate) resolve);
                        } else if (resolve instanceof LocalTime) {
                            updateCheckConflict((LocalTime) resolve, Period.ZERO);
                        } else {
                            throw new DateTimeException("Method resolve() can only return ChronoZonedDateTime, ChronoLocalDateTime, ChronoLocalDate or LocalTime");
                        }
                    } else if (!this.fieldValues.containsKey(key)) {
                        break;
                    }
                    i++;
                }
            }
            if (i == 50) {
                throw new DateTimeException("One of the parsed fields has an incorrectly implemented resolve method");
            }
            if (i > 0) {
                resolveInstantFields();
                resolveDateFields();
                resolveTimeFields();
            }
        }
    }

    private void updateCheckConflict(TemporalField temporalField, TemporalField temporalField2, Long l) {
        Long put = this.fieldValues.put(temporalField2, l);
        if (put != null && put.longValue() != l.longValue()) {
            throw new DateTimeException("Conflict found: " + temporalField2 + " " + put + " differs from " + temporalField2 + " " + l + " while resolving  " + temporalField);
        }
    }

    private void resolveInstantFields() {
        if (this.fieldValues.containsKey(ChronoField.INSTANT_SECONDS)) {
            ZoneId zoneId = this.zone;
            if (zoneId != null) {
                resolveInstantFields0(zoneId);
                return;
            }
            Long l = this.fieldValues.get(ChronoField.OFFSET_SECONDS);
            if (l != null) {
                resolveInstantFields0(ZoneOffset.ofTotalSeconds(l.intValue()));
            }
        }
    }

    private void resolveInstantFields0(ZoneId zoneId) {
        updateCheckConflict(this.chrono.zonedDateTime(Instant.ofEpochSecond(this.fieldValues.remove(ChronoField.INSTANT_SECONDS).longValue()), zoneId).toLocalDate());
        updateCheckConflict(ChronoField.INSTANT_SECONDS, ChronoField.SECOND_OF_DAY, Long.valueOf(r5.toLocalTime().toSecondOfDay()));
    }

    private void resolveDateFields() {
        updateCheckConflict(this.chrono.resolveDate(this.fieldValues, this.resolverStyle));
    }

    private void updateCheckConflict(ChronoLocalDate chronoLocalDate) {
        ChronoLocalDate chronoLocalDate2 = this.date;
        if (chronoLocalDate2 != null) {
            if (chronoLocalDate != null && !chronoLocalDate2.equals(chronoLocalDate)) {
                throw new DateTimeException("Conflict found: Fields resolved to two different dates: " + this.date + " " + chronoLocalDate);
            }
        } else if (chronoLocalDate != null) {
            if (!this.chrono.equals(chronoLocalDate.getChronology())) {
                throw new DateTimeException("ChronoLocalDate must use the effective parsed chronology: " + this.chrono);
            }
            this.date = chronoLocalDate;
        }
    }

    private void resolveTimeFields() {
        if (this.fieldValues.containsKey(ChronoField.CLOCK_HOUR_OF_DAY)) {
            long longValue = this.fieldValues.remove(ChronoField.CLOCK_HOUR_OF_DAY).longValue();
            if (this.resolverStyle == ResolverStyle.STRICT || (this.resolverStyle == ResolverStyle.SMART && longValue != 0)) {
                ChronoField.CLOCK_HOUR_OF_DAY.checkValidValue(longValue);
            }
            ChronoField chronoField = ChronoField.CLOCK_HOUR_OF_DAY;
            ChronoField chronoField2 = ChronoField.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            updateCheckConflict(chronoField, chronoField2, Long.valueOf(longValue));
        }
        if (this.fieldValues.containsKey(ChronoField.CLOCK_HOUR_OF_AMPM)) {
            long longValue2 = this.fieldValues.remove(ChronoField.CLOCK_HOUR_OF_AMPM).longValue();
            if (this.resolverStyle == ResolverStyle.STRICT || (this.resolverStyle == ResolverStyle.SMART && longValue2 != 0)) {
                ChronoField.CLOCK_HOUR_OF_AMPM.checkValidValue(longValue2);
            }
            updateCheckConflict(ChronoField.CLOCK_HOUR_OF_AMPM, ChronoField.HOUR_OF_AMPM, Long.valueOf(longValue2 != 12 ? longValue2 : 0L));
        }
        if (this.fieldValues.containsKey(ChronoField.AMPM_OF_DAY) && this.fieldValues.containsKey(ChronoField.HOUR_OF_AMPM)) {
            long longValue3 = this.fieldValues.remove(ChronoField.AMPM_OF_DAY).longValue();
            long longValue4 = this.fieldValues.remove(ChronoField.HOUR_OF_AMPM).longValue();
            if (this.resolverStyle == ResolverStyle.LENIENT) {
                updateCheckConflict(ChronoField.AMPM_OF_DAY, ChronoField.HOUR_OF_DAY, Long.valueOf(Math.addExact(UByte$.ExternalSyntheticBackport0.m$1(longValue3, 12), longValue4)));
            } else {
                ChronoField.AMPM_OF_DAY.checkValidValue(longValue3);
                ChronoField.HOUR_OF_AMPM.checkValidValue(longValue3);
                updateCheckConflict(ChronoField.AMPM_OF_DAY, ChronoField.HOUR_OF_DAY, Long.valueOf((longValue3 * 12) + longValue4));
            }
        }
        if (this.fieldValues.containsKey(ChronoField.NANO_OF_DAY)) {
            long longValue5 = this.fieldValues.remove(ChronoField.NANO_OF_DAY).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.NANO_OF_DAY.checkValidValue(longValue5);
            }
            updateCheckConflict(ChronoField.NANO_OF_DAY, ChronoField.HOUR_OF_DAY, Long.valueOf(longValue5 / 3600000000000L));
            updateCheckConflict(ChronoField.NANO_OF_DAY, ChronoField.MINUTE_OF_HOUR, Long.valueOf((longValue5 / 60000000000L) % 60));
            updateCheckConflict(ChronoField.NANO_OF_DAY, ChronoField.SECOND_OF_MINUTE, Long.valueOf((longValue5 / 1000000000) % 60));
            updateCheckConflict(ChronoField.NANO_OF_DAY, ChronoField.NANO_OF_SECOND, Long.valueOf(longValue5 % 1000000000));
        }
        if (this.fieldValues.containsKey(ChronoField.MICRO_OF_DAY)) {
            long longValue6 = this.fieldValues.remove(ChronoField.MICRO_OF_DAY).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.MICRO_OF_DAY.checkValidValue(longValue6);
            }
            updateCheckConflict(ChronoField.MICRO_OF_DAY, ChronoField.SECOND_OF_DAY, Long.valueOf(longValue6 / 1000000));
            updateCheckConflict(ChronoField.MICRO_OF_DAY, ChronoField.MICRO_OF_SECOND, Long.valueOf(longValue6 % 1000000));
        }
        if (this.fieldValues.containsKey(ChronoField.MILLI_OF_DAY)) {
            long longValue7 = this.fieldValues.remove(ChronoField.MILLI_OF_DAY).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.MILLI_OF_DAY.checkValidValue(longValue7);
            }
            updateCheckConflict(ChronoField.MILLI_OF_DAY, ChronoField.SECOND_OF_DAY, Long.valueOf(longValue7 / 1000));
            updateCheckConflict(ChronoField.MILLI_OF_DAY, ChronoField.MILLI_OF_SECOND, Long.valueOf(longValue7 % 1000));
        }
        if (this.fieldValues.containsKey(ChronoField.SECOND_OF_DAY)) {
            long longValue8 = this.fieldValues.remove(ChronoField.SECOND_OF_DAY).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.SECOND_OF_DAY.checkValidValue(longValue8);
            }
            updateCheckConflict(ChronoField.SECOND_OF_DAY, ChronoField.HOUR_OF_DAY, Long.valueOf(longValue8 / 3600));
            updateCheckConflict(ChronoField.SECOND_OF_DAY, ChronoField.MINUTE_OF_HOUR, Long.valueOf((longValue8 / 60) % 60));
            updateCheckConflict(ChronoField.SECOND_OF_DAY, ChronoField.SECOND_OF_MINUTE, Long.valueOf(longValue8 % 60));
        }
        if (this.fieldValues.containsKey(ChronoField.MINUTE_OF_DAY)) {
            long longValue9 = this.fieldValues.remove(ChronoField.MINUTE_OF_DAY).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.MINUTE_OF_DAY.checkValidValue(longValue9);
            }
            updateCheckConflict(ChronoField.MINUTE_OF_DAY, ChronoField.HOUR_OF_DAY, Long.valueOf(longValue9 / 60));
            updateCheckConflict(ChronoField.MINUTE_OF_DAY, ChronoField.MINUTE_OF_HOUR, Long.valueOf(longValue9 % 60));
        }
        if (this.fieldValues.containsKey(ChronoField.NANO_OF_SECOND)) {
            long longValue10 = this.fieldValues.get(ChronoField.NANO_OF_SECOND).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.NANO_OF_SECOND.checkValidValue(longValue10);
            }
            if (this.fieldValues.containsKey(ChronoField.MICRO_OF_SECOND)) {
                long longValue11 = this.fieldValues.remove(ChronoField.MICRO_OF_SECOND).longValue();
                if (this.resolverStyle != ResolverStyle.LENIENT) {
                    ChronoField.MICRO_OF_SECOND.checkValidValue(longValue11);
                }
                longValue10 = (longValue10 % 1000) + (longValue11 * 1000);
                updateCheckConflict(ChronoField.MICRO_OF_SECOND, ChronoField.NANO_OF_SECOND, Long.valueOf(longValue10));
            }
            if (this.fieldValues.containsKey(ChronoField.MILLI_OF_SECOND)) {
                long longValue12 = this.fieldValues.remove(ChronoField.MILLI_OF_SECOND).longValue();
                if (this.resolverStyle != ResolverStyle.LENIENT) {
                    ChronoField.MILLI_OF_SECOND.checkValidValue(longValue12);
                }
                updateCheckConflict(ChronoField.MILLI_OF_SECOND, ChronoField.NANO_OF_SECOND, Long.valueOf((longValue12 * 1000000) + (longValue10 % 1000000)));
            }
        }
        if (this.fieldValues.containsKey(ChronoField.HOUR_OF_DAY) && this.fieldValues.containsKey(ChronoField.MINUTE_OF_HOUR) && this.fieldValues.containsKey(ChronoField.SECOND_OF_MINUTE) && this.fieldValues.containsKey(ChronoField.NANO_OF_SECOND)) {
            resolveTime(this.fieldValues.remove(ChronoField.HOUR_OF_DAY).longValue(), this.fieldValues.remove(ChronoField.MINUTE_OF_HOUR).longValue(), this.fieldValues.remove(ChronoField.SECOND_OF_MINUTE).longValue(), this.fieldValues.remove(ChronoField.NANO_OF_SECOND).longValue());
        }
    }

    private void resolveTimeLenient() {
        if (this.time == null) {
            if (this.fieldValues.containsKey(ChronoField.MILLI_OF_SECOND)) {
                long longValue = this.fieldValues.remove(ChronoField.MILLI_OF_SECOND).longValue();
                if (this.fieldValues.containsKey(ChronoField.MICRO_OF_SECOND)) {
                    long longValue2 = (longValue * 1000) + (this.fieldValues.get(ChronoField.MICRO_OF_SECOND).longValue() % 1000);
                    updateCheckConflict(ChronoField.MILLI_OF_SECOND, ChronoField.MICRO_OF_SECOND, Long.valueOf(longValue2));
                    this.fieldValues.remove(ChronoField.MICRO_OF_SECOND);
                    this.fieldValues.put(ChronoField.NANO_OF_SECOND, Long.valueOf(longValue2 * 1000));
                } else {
                    this.fieldValues.put(ChronoField.NANO_OF_SECOND, Long.valueOf(longValue * 1000000));
                }
            } else if (this.fieldValues.containsKey(ChronoField.MICRO_OF_SECOND)) {
                this.fieldValues.put(ChronoField.NANO_OF_SECOND, Long.valueOf(this.fieldValues.remove(ChronoField.MICRO_OF_SECOND).longValue() * 1000));
            }
            Long l = this.fieldValues.get(ChronoField.HOUR_OF_DAY);
            if (l != null) {
                Long l2 = this.fieldValues.get(ChronoField.MINUTE_OF_HOUR);
                Long l3 = this.fieldValues.get(ChronoField.SECOND_OF_MINUTE);
                Long l4 = this.fieldValues.get(ChronoField.NANO_OF_SECOND);
                if (l2 == null && (l3 != null || l4 != null)) {
                    return;
                }
                if (l2 != null && l3 == null && l4 != null) {
                    return;
                }
                resolveTime(l.longValue(), l2 != null ? l2.longValue() : 0L, l3 != null ? l3.longValue() : 0L, l4 != null ? l4.longValue() : 0L);
                this.fieldValues.remove(ChronoField.HOUR_OF_DAY);
                this.fieldValues.remove(ChronoField.MINUTE_OF_HOUR);
                this.fieldValues.remove(ChronoField.SECOND_OF_MINUTE);
                this.fieldValues.remove(ChronoField.NANO_OF_SECOND);
            }
        }
        if (this.resolverStyle == ResolverStyle.LENIENT || this.fieldValues.size() <= 0) {
            return;
        }
        for (Map.Entry<TemporalField, Long> entry : this.fieldValues.entrySet()) {
            TemporalField key = entry.getKey();
            if ((key instanceof ChronoField) && key.isTimeBased()) {
                ((ChronoField) key).checkValidValue(entry.getValue().longValue());
            }
        }
    }

    private void resolveTime(long j, long j2, long j3, long j4) {
        if (this.resolverStyle == ResolverStyle.LENIENT) {
            long addExact = Math.addExact(Math.addExact(Math.addExact(Math.multiplyExact(j, 3600000000000L), Math.multiplyExact(j2, 60000000000L)), Math.multiplyExact(j3, 1000000000L)), j4);
            updateCheckConflict(LocalTime.ofNanoOfDay(Math.floorMod(addExact, 86400000000000L)), Period.ofDays((int) Math.floorDiv(addExact, 86400000000000L)));
            return;
        }
        int checkValidIntValue = ChronoField.MINUTE_OF_HOUR.checkValidIntValue(j2);
        int checkValidIntValue2 = ChronoField.NANO_OF_SECOND.checkValidIntValue(j4);
        if (this.resolverStyle == ResolverStyle.SMART && j == 24 && checkValidIntValue == 0 && j3 == 0 && checkValidIntValue2 == 0) {
            updateCheckConflict(LocalTime.MIDNIGHT, Period.ofDays(1));
        } else {
            updateCheckConflict(LocalTime.m98of(ChronoField.HOUR_OF_DAY.checkValidIntValue(j), checkValidIntValue, ChronoField.SECOND_OF_MINUTE.checkValidIntValue(j3), checkValidIntValue2), Period.ZERO);
        }
    }

    private void resolvePeriod() {
        if (this.date == null || this.time == null || this.excessDays.isZero()) {
            return;
        }
        this.date = this.date.plus((TemporalAmount) this.excessDays);
        this.excessDays = Period.ZERO;
    }

    private void resolveFractional() {
        if (this.time == null) {
            if (this.fieldValues.containsKey(ChronoField.INSTANT_SECONDS) || this.fieldValues.containsKey(ChronoField.SECOND_OF_DAY) || this.fieldValues.containsKey(ChronoField.SECOND_OF_MINUTE)) {
                if (this.fieldValues.containsKey(ChronoField.NANO_OF_SECOND)) {
                    long longValue = this.fieldValues.get(ChronoField.NANO_OF_SECOND).longValue();
                    this.fieldValues.put(ChronoField.MICRO_OF_SECOND, Long.valueOf(longValue / 1000));
                    this.fieldValues.put(ChronoField.MILLI_OF_SECOND, Long.valueOf(longValue / 1000000));
                } else {
                    this.fieldValues.put(ChronoField.NANO_OF_SECOND, 0L);
                    this.fieldValues.put(ChronoField.MICRO_OF_SECOND, 0L);
                    this.fieldValues.put(ChronoField.MILLI_OF_SECOND, 0L);
                }
            }
        }
    }

    private void resolveInstant() {
        if (this.date == null || this.time == null) {
            return;
        }
        Long l = this.fieldValues.get(ChronoField.OFFSET_SECONDS);
        if (l != null) {
            this.fieldValues.put(ChronoField.INSTANT_SECONDS, Long.valueOf(this.date.atTime(this.time).atZone2(ZoneOffset.ofTotalSeconds(l.intValue())).toEpochSecond()));
        } else if (this.zone != null) {
            this.fieldValues.put(ChronoField.INSTANT_SECONDS, Long.valueOf(this.date.atTime(this.time).atZone2(this.zone).toEpochSecond()));
        }
    }

    private void updateCheckConflict(LocalTime localTime, Period period) {
        LocalTime localTime2 = this.time;
        if (localTime2 != null) {
            if (!localTime2.equals(localTime)) {
                throw new DateTimeException("Conflict found: Fields resolved to different times: " + this.time + " " + localTime);
            }
            if (!this.excessDays.isZero() && !period.isZero() && !this.excessDays.equals(period)) {
                throw new DateTimeException("Conflict found: Fields resolved to different excess periods: " + this.excessDays + " " + period);
            }
            this.excessDays = period;
            return;
        }
        this.time = localTime;
        this.excessDays = period;
    }

    private void crossCheck() {
        ChronoLocalDate chronoLocalDate = this.date;
        if (chronoLocalDate != null) {
            crossCheck(chronoLocalDate);
        }
        LocalTime localTime = this.time;
        if (localTime != null) {
            crossCheck(localTime);
            if (this.date == null || this.fieldValues.size() <= 0) {
                return;
            }
            crossCheck(this.date.atTime(this.time));
        }
    }

    private void crossCheck(TemporalAccessor temporalAccessor) {
        Iterator<Map.Entry<TemporalField, Long>> it = this.fieldValues.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<TemporalField, Long> next = it.next();
            TemporalField key = next.getKey();
            if (temporalAccessor.isSupported(key)) {
                try {
                    long j = temporalAccessor.getLong(key);
                    long longValue = next.getValue().longValue();
                    if (j != longValue) {
                        throw new DateTimeException("Conflict found: Field " + key + " " + j + " differs from " + key + " " + longValue + " derived from " + temporalAccessor);
                    }
                    it.remove();
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(this.fieldValues).append(',').append(this.chrono);
        if (this.zone != null) {
            sb.append(',').append(this.zone);
        }
        if (this.date != null || this.time != null) {
            sb.append(" resolved to ");
            ChronoLocalDate chronoLocalDate = this.date;
            if (chronoLocalDate != null) {
                sb.append(chronoLocalDate);
                if (this.time != null) {
                    sb.append('T').append(this.time);
                }
            } else {
                sb.append(this.time);
            }
        }
        return sb.toString();
    }
}
