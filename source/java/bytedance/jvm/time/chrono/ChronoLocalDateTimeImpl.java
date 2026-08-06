package bytedance.jvm.time.chrono;

import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.chrono.ChronoLocalDate;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.Temporal;
import bytedance.jvm.time.temporal.TemporalAdjuster;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.TemporalUnit;
import bytedance.jvm.time.temporal.ValueRange;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Objects;
import kotlin.UByte$;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ChronoLocalDateTimeImpl<D extends ChronoLocalDate> implements ChronoLocalDateTime<D>, Temporal, TemporalAdjuster, Serializable {
    static final int HOURS_PER_DAY = 24;
    static final long MICROS_PER_DAY = 86400000000L;
    static final long MILLIS_PER_DAY = 86400000;
    static final int MINUTES_PER_DAY = 1440;
    static final int MINUTES_PER_HOUR = 60;
    static final long NANOS_PER_DAY = 86400000000000L;
    static final long NANOS_PER_HOUR = 3600000000000L;
    static final long NANOS_PER_MINUTE = 60000000000L;
    static final long NANOS_PER_SECOND = 1000000000;
    static final int SECONDS_PER_DAY = 86400;
    static final int SECONDS_PER_HOUR = 3600;
    static final int SECONDS_PER_MINUTE = 60;
    private static final long serialVersionUID = 4556003607393004514L;
    private final transient D date;
    private final transient LocalTime time;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: of */
    public static <R extends ChronoLocalDate> ChronoLocalDateTimeImpl<R> m119of(R r, LocalTime localTime) {
        return new ChronoLocalDateTimeImpl<>(r, localTime);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <R extends ChronoLocalDate> ChronoLocalDateTimeImpl<R> ensureValid(Chronology chronology, Temporal temporal) {
        ChronoLocalDateTimeImpl<R> chronoLocalDateTimeImpl = (ChronoLocalDateTimeImpl) temporal;
        if (chronology.equals(chronoLocalDateTimeImpl.getChronology())) {
            return chronoLocalDateTimeImpl;
        }
        throw new ClassCastException("Chronology mismatch, required: " + chronology.getId() + ", actual: " + chronoLocalDateTimeImpl.getChronology().getId());
    }

    private ChronoLocalDateTimeImpl(D d, LocalTime localTime) {
        Objects.requireNonNull(d, "date");
        Objects.requireNonNull(localTime, "time");
        this.date = d;
        this.time = localTime;
    }

    private ChronoLocalDateTimeImpl<D> with(Temporal temporal, LocalTime localTime) {
        D d = this.date;
        return (d == temporal && this.time == localTime) ? this : new ChronoLocalDateTimeImpl<>(ChronoLocalDateImpl.ensureValid(d.getChronology(), temporal), localTime);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateTime
    public D toLocalDate() {
        return this.date;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateTime
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateTime, bytedance.jvm.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField != null && temporalField.isSupportedBy(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        return chronoField.isDateBased() || chronoField.isTimeBased();
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return ((ChronoField) temporalField).isTimeBased() ? this.time.range(temporalField) : this.date.range(temporalField);
        }
        return temporalField.rangeRefinedBy(this);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return ((ChronoField) temporalField).isTimeBased() ? this.time.get(temporalField) : this.date.get(temporalField);
        }
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return ((ChronoField) temporalField).isTimeBased() ? this.time.getLong(temporalField) : this.date.getLong(temporalField);
        }
        return temporalField.getFrom(this);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateTime, bytedance.jvm.time.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof ChronoLocalDate) {
            return with((ChronoLocalDate) temporalAdjuster, this.time);
        }
        if (temporalAdjuster instanceof LocalTime) {
            return with(this.date, (LocalTime) temporalAdjuster);
        }
        if (temporalAdjuster instanceof ChronoLocalDateTimeImpl) {
            return ensureValid(this.date.getChronology(), (ChronoLocalDateTimeImpl) temporalAdjuster);
        }
        return ensureValid(this.date.getChronology(), (ChronoLocalDateTimeImpl) temporalAdjuster.adjustInto(this));
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateTime, bytedance.jvm.time.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> with(TemporalField temporalField, long j) {
        if (temporalField instanceof ChronoField) {
            if (((ChronoField) temporalField).isTimeBased()) {
                return with(this.date, this.time.with(temporalField, j));
            }
            return with(this.date.with(temporalField, j), this.time);
        }
        return ensureValid(this.date.getChronology(), temporalField.adjustInto(this, j));
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateTime, bytedance.jvm.time.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (C06321.$SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusNanos(j);
                case 2:
                    return plusDays(j / MICROS_PER_DAY).plusNanos((j % MICROS_PER_DAY) * 1000);
                case 3:
                    return plusDays(j / MILLIS_PER_DAY).plusNanos((j % MILLIS_PER_DAY) * 1000000);
                case 4:
                    return plusSeconds(j);
                case 5:
                    return plusMinutes(j);
                case 6:
                    return plusHours(j);
                case 7:
                    return plusDays(j / 256).plusHours((j % 256) * 12);
                default:
                    return with(this.date.plus(j, temporalUnit), this.time);
            }
        }
        return ensureValid(this.date.getChronology(), temporalUnit.addTo(this, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bytedance.jvm.time.chrono.ChronoLocalDateTimeImpl$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C06321 {
        static final /* synthetic */ int[] $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private ChronoLocalDateTimeImpl<D> plusDays(long j) {
        return with(this.date.plus(j, ChronoUnit.DAYS), this.time);
    }

    private ChronoLocalDateTimeImpl<D> plusHours(long j) {
        return plusWithOverflow(this.date, j, 0L, 0L, 0L);
    }

    private ChronoLocalDateTimeImpl<D> plusMinutes(long j) {
        return plusWithOverflow(this.date, 0L, j, 0L, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChronoLocalDateTimeImpl<D> plusSeconds(long j) {
        return plusWithOverflow(this.date, 0L, 0L, j, 0L);
    }

    private ChronoLocalDateTimeImpl<D> plusNanos(long j) {
        return plusWithOverflow(this.date, 0L, 0L, 0L, j);
    }

    private ChronoLocalDateTimeImpl<D> plusWithOverflow(D d, long j, long j2, long j3, long j4) {
        if ((j | j2 | j3 | j4) == 0) {
            return with(d, this.time);
        }
        long j5 = (j4 / NANOS_PER_DAY) + (j3 / 86400) + (j2 / 1440) + (j / 24);
        long j6 = (j4 % NANOS_PER_DAY) + ((j3 % 86400) * NANOS_PER_SECOND) + ((j2 % 1440) * NANOS_PER_MINUTE) + ((j % 24) * NANOS_PER_HOUR);
        long nanoOfDay = this.time.toNanoOfDay();
        long j7 = j6 + nanoOfDay;
        long floorDiv = j5 + Math.floorDiv(j7, NANOS_PER_DAY);
        long floorMod = Math.floorMod(j7, NANOS_PER_DAY);
        return with(d.plus(floorDiv, ChronoUnit.DAYS), floorMod == nanoOfDay ? this.time : LocalTime.ofNanoOfDay(floorMod));
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateTime
    /* renamed from: atZone */
    public ChronoZonedDateTime<D> atZone2(ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofBest(this, zoneId, null);
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        Objects.requireNonNull(temporal, "endExclusive");
        ChronoLocalDateTime<? extends ChronoLocalDate> localDateTime = getChronology().localDateTime(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            if (temporalUnit.isTimeBased()) {
                long j = localDateTime.getLong(ChronoField.EPOCH_DAY) - this.date.getLong(ChronoField.EPOCH_DAY);
                switch (C06321.$SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                    case 1:
                        j = Math.multiplyExact(j, NANOS_PER_DAY);
                        break;
                    case 2:
                        j = Math.multiplyExact(j, MICROS_PER_DAY);
                        break;
                    case 3:
                        j = Math.multiplyExact(j, MILLIS_PER_DAY);
                        break;
                    case 4:
                        j = UByte$.ExternalSyntheticBackport0.m$1(j, SECONDS_PER_DAY);
                        break;
                    case 5:
                        j = UByte$.ExternalSyntheticBackport0.m$1(j, 1440);
                        break;
                    case 6:
                        j = UByte$.ExternalSyntheticBackport0.m$1(j, 24);
                        break;
                    case 7:
                        j = UByte$.ExternalSyntheticBackport0.m$1(j, 2);
                        break;
                }
                return Math.addExact(j, this.time.until(localDateTime.toLocalTime(), temporalUnit));
            }
            ChronoLocalDate localDate = localDateTime.toLocalDate();
            if (localDateTime.toLocalTime().isBefore(this.time)) {
                localDate = localDate.minus(1L, (TemporalUnit) ChronoUnit.DAYS);
            }
            return this.date.until(localDate, temporalUnit);
        }
        Objects.requireNonNull(temporalUnit, "unit");
        return temporalUnit.between(this, localDateTime);
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.date);
        objectOutput.writeObject(this.time);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ChronoLocalDateTime<?> readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        return ((ChronoLocalDate) objectInput.readObject()).atTime((LocalTime) objectInput.readObject());
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateTime
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDateTime) && compareTo((ChronoLocalDateTime<?>) obj) == 0;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateTime
    public int hashCode() {
        return toLocalDate().hashCode() ^ toLocalTime().hashCode();
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateTime
    public String toString() {
        return toLocalDate().toString() + 'T' + toLocalTime().toString();
    }
}
