package bytedance.jvm.time.chrono;

import bytedance.jvm.time.Clock;
import bytedance.jvm.time.Instant;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.format.ResolverStyle;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.ValueRange;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class MinguoChronology extends AbstractChronology implements Serializable {
    public static final MinguoChronology INSTANCE = new MinguoChronology();
    static final int YEARS_DIFFERENCE = 1911;
    private static final long serialVersionUID = 1039765215346859963L;

    @Override // bytedance.jvm.time.chrono.Chronology
    public String getCalendarType() {
        return "roc";
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public String getId() {
        return "Minguo";
    }

    @Override // bytedance.jvm.time.chrono.AbstractChronology, bytedance.jvm.time.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate resolveDate(Map map, ResolverStyle resolverStyle) {
        return resolveDate((Map<TemporalField, Long>) map, resolverStyle);
    }

    private MinguoChronology() {
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public MinguoDate date(Era era, int i, int i2, int i3) {
        return date(prolepticYear(era, i), i2, i3);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public MinguoDate date(int i, int i2, int i3) {
        return new MinguoDate(LocalDate.m87of(i + YEARS_DIFFERENCE, i2, i3));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public MinguoDate dateYearDay(Era era, int i, int i2) {
        return dateYearDay(prolepticYear(era, i), i2);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public MinguoDate dateYearDay(int i, int i2) {
        return new MinguoDate(LocalDate.ofYearDay(i + YEARS_DIFFERENCE, i2));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public MinguoDate dateEpochDay(long j) {
        return new MinguoDate(LocalDate.ofEpochDay(j));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public MinguoDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public MinguoDate dateNow(ZoneId zoneId) {
        return dateNow(Clock.system(zoneId));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public MinguoDate dateNow(Clock clock) {
        return date((TemporalAccessor) LocalDate.now(clock));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public MinguoDate date(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof MinguoDate) {
            return (MinguoDate) temporalAccessor;
        }
        return new MinguoDate(LocalDate.from(temporalAccessor));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ChronoLocalDateTime<MinguoDate> localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ChronoZonedDateTime<MinguoDate> zonedDateTime(TemporalAccessor temporalAccessor) {
        return super.zonedDateTime(temporalAccessor);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ChronoZonedDateTime<MinguoDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return super.zonedDateTime(instant, zoneId);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public boolean isLeapYear(long j) {
        return IsoChronology.INSTANCE.isLeapYear(j + 1911);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public int prolepticYear(Era era, int i) {
        if (era instanceof MinguoEra) {
            return era == MinguoEra.ROC ? i : 1 - i;
        }
        throw new ClassCastException("Era must be MinguoEra");
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public MinguoEra eraOf(int i) {
        return MinguoEra.m129of(i);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public List<Era> eras() {
        return UByte$.ExternalSyntheticBackport0.m(MinguoEra.values());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bytedance.jvm.time.chrono.MinguoChronology$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C06401 {
        static final /* synthetic */ int[] $SwitchMap$bytedance$jvm$time$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$bytedance$jvm$time$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.PROLEPTIC_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ValueRange range(ChronoField chronoField) {
        int i = C06401.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[chronoField.ordinal()];
        if (i == 1) {
            ValueRange range = ChronoField.PROLEPTIC_MONTH.range();
            return ValueRange.m134of(range.getMinimum() - 22932, range.getMaximum() - 22932);
        }
        if (i == 2) {
            ValueRange range2 = ChronoField.YEAR.range();
            return ValueRange.m135of(1L, range2.getMaximum() - 1911, (-range2.getMinimum()) + 1 + 1911);
        }
        if (i == 3) {
            ValueRange range3 = ChronoField.YEAR.range();
            return ValueRange.m134of(range3.getMinimum() - 1911, range3.getMaximum() - 1911);
        }
        return chronoField.range();
    }

    @Override // bytedance.jvm.time.chrono.AbstractChronology, bytedance.jvm.time.chrono.Chronology
    public MinguoDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        return (MinguoDate) super.resolveDate(map, resolverStyle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.AbstractChronology
    public Object writeReplace() {
        return super.writeReplace();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
