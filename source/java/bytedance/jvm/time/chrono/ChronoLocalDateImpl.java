package bytedance.jvm.time.chrono;

import androidx.core.location.LocationRequestCompat;
import bytedance.jvm.time.chrono.ChronoLocalDate;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.Temporal;
import bytedance.jvm.time.temporal.TemporalAdjuster;
import bytedance.jvm.time.temporal.TemporalAmount;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.TemporalUnit;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import java.io.Serializable;
import java.util.Objects;
import kotlin.UByte$;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class ChronoLocalDateImpl<D extends ChronoLocalDate> implements ChronoLocalDate, Temporal, TemporalAdjuster, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    abstract D plusDays(long j);

    abstract D plusMonths(long j);

    abstract D plusYears(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <D extends ChronoLocalDate> D ensureValid(Chronology chronology, Temporal temporal) {
        D d = (D) temporal;
        if (chronology.equals(d.getChronology())) {
            return d;
        }
        throw new ClassCastException("Chronology mismatch, expected: " + chronology.getId() + ", actual: " + d.getChronology().getId());
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public D with(TemporalAdjuster temporalAdjuster) {
        return (D) super.with(temporalAdjuster);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public D with(TemporalField temporalField, long j) {
        return (D) super.with(temporalField, j);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public D plus(TemporalAmount temporalAmount) {
        return (D) super.plus(temporalAmount);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public D plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (C06311.$SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusDays(j);
                case 2:
                    return plusDays(UByte$.ExternalSyntheticBackport0.m$1(j, 7));
                case 3:
                    return plusMonths(j);
                case 4:
                    return plusYears(j);
                case 5:
                    return plusYears(UByte$.ExternalSyntheticBackport0.m$1(j, 10));
                case 6:
                    return plusYears(UByte$.ExternalSyntheticBackport0.m$1(j, 100));
                case 7:
                    return plusYears(UByte$.ExternalSyntheticBackport0.m$1(j, 1000));
                case 8:
                    return with((TemporalField) ChronoField.ERA, Math.addExact(getLong(ChronoField.ERA), j));
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
        }
        return (D) super.plus(j, temporalUnit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bytedance.jvm.time.chrono.ChronoLocalDateImpl$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C06311 {
        static final /* synthetic */ int[] $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.WEEKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.ERAS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public D minus(TemporalAmount temporalAmount) {
        return (D) super.minus(temporalAmount);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public D minus(long j, TemporalUnit temporalUnit) {
        return (D) super.minus(j, temporalUnit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public D plusWeeks(long j) {
        return plusDays(UByte$.ExternalSyntheticBackport0.m$1(j, 7));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public D minusYears(long j) {
        return j == Long.MIN_VALUE ? (D) ((ChronoLocalDateImpl) plusYears(LocationRequestCompat.PASSIVE_INTERVAL)).plusYears(1L) : plusYears(-j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public D minusMonths(long j) {
        return j == Long.MIN_VALUE ? (D) ((ChronoLocalDateImpl) plusMonths(LocationRequestCompat.PASSIVE_INTERVAL)).plusMonths(1L) : plusMonths(-j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public D minusWeeks(long j) {
        return j == Long.MIN_VALUE ? (D) ((ChronoLocalDateImpl) plusWeeks(LocationRequestCompat.PASSIVE_INTERVAL)).plusWeeks(1L) : plusWeeks(-j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public D minusDays(long j) {
        return j == Long.MIN_VALUE ? (D) ((ChronoLocalDateImpl) plusDays(LocationRequestCompat.PASSIVE_INTERVAL)).plusDays(1L) : plusDays(-j);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        Objects.requireNonNull(temporal, "endExclusive");
        ChronoLocalDate date = getChronology().date(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            switch (C06311.$SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return daysUntil(date);
                case 2:
                    return daysUntil(date) / 7;
                case 3:
                    return monthsUntil(date);
                case 4:
                    return monthsUntil(date) / 12;
                case 5:
                    return monthsUntil(date) / 120;
                case 6:
                    return monthsUntil(date) / MonitorConstants.FETCH_SETTING_INTERVAL;
                case 7:
                    return monthsUntil(date) / 12000;
                case 8:
                    return date.getLong(ChronoField.ERA) - getLong(ChronoField.ERA);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
        }
        Objects.requireNonNull(temporalUnit, "unit");
        return temporalUnit.between(this, date);
    }

    private long daysUntil(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate.toEpochDay() - toEpochDay();
    }

    private long monthsUntil(ChronoLocalDate chronoLocalDate) {
        if (getChronology().range(ChronoField.MONTH_OF_YEAR).getMaximum() != 12) {
            throw new IllegalStateException("ChronoLocalDateImpl only supports Chronologies with 12 months per year");
        }
        return (((chronoLocalDate.getLong(ChronoField.PROLEPTIC_MONTH) * 32) + chronoLocalDate.get(ChronoField.DAY_OF_MONTH)) - ((getLong(ChronoField.PROLEPTIC_MONTH) * 32) + get(ChronoField.DAY_OF_MONTH))) / 32;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDate) && compareTo((ChronoLocalDate) obj) == 0;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public int hashCode() {
        long epochDay = toEpochDay();
        return ((int) (epochDay ^ (epochDay >>> 32))) ^ getChronology().hashCode();
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public String toString() {
        long j = getLong(ChronoField.YEAR_OF_ERA);
        long j2 = getLong(ChronoField.MONTH_OF_YEAR);
        long j3 = getLong(ChronoField.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(getChronology().toString()).append(" ").append(getEra()).append(" ").append(j).append(j2 < 10 ? "-0" : "-").append(j2).append(j3 >= 10 ? "-" : "-0").append(j3);
        return sb.toString();
    }
}
