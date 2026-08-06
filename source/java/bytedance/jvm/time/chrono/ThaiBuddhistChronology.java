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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ThaiBuddhistChronology extends AbstractChronology implements Serializable {
    private static final HashMap<String, String[]> ERA_FULL_NAMES;
    private static final HashMap<String, String[]> ERA_NARROW_NAMES;
    private static final HashMap<String, String[]> ERA_SHORT_NAMES;
    private static final String FALLBACK_LANGUAGE = "en";
    public static final ThaiBuddhistChronology INSTANCE = new ThaiBuddhistChronology();
    private static final String TARGET_LANGUAGE = "th";
    static final int YEARS_DIFFERENCE = 543;
    private static final long serialVersionUID = 2775954514031616474L;

    @Override // bytedance.jvm.time.chrono.Chronology
    public String getCalendarType() {
        return "buddhist";
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public String getId() {
        return "ThaiBuddhist";
    }

    @Override // bytedance.jvm.time.chrono.AbstractChronology, bytedance.jvm.time.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate resolveDate(Map map, ResolverStyle resolverStyle) {
        return resolveDate((Map<TemporalField, Long>) map, resolverStyle);
    }

    static {
        HashMap<String, String[]> hashMap = new HashMap<>();
        ERA_NARROW_NAMES = hashMap;
        HashMap<String, String[]> hashMap2 = new HashMap<>();
        ERA_SHORT_NAMES = hashMap2;
        HashMap<String, String[]> hashMap3 = new HashMap<>();
        ERA_FULL_NAMES = hashMap3;
        hashMap.put(FALLBACK_LANGUAGE, new String[]{"BB", "BE"});
        hashMap.put(TARGET_LANGUAGE, new String[]{"BB", "BE"});
        hashMap2.put(FALLBACK_LANGUAGE, new String[]{"B.B.", "B.E."});
        hashMap2.put(TARGET_LANGUAGE, new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        hashMap3.put(FALLBACK_LANGUAGE, new String[]{"Before Buddhist", "Budhhist Era"});
        hashMap3.put(TARGET_LANGUAGE, new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private ThaiBuddhistChronology() {
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ThaiBuddhistDate date(Era era, int i, int i2, int i3) {
        return date(prolepticYear(era, i), i2, i3);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ThaiBuddhistDate date(int i, int i2, int i3) {
        return new ThaiBuddhistDate(LocalDate.m87of(i - 543, i2, i3));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ThaiBuddhistDate dateYearDay(Era era, int i, int i2) {
        return dateYearDay(prolepticYear(era, i), i2);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ThaiBuddhistDate dateYearDay(int i, int i2) {
        return new ThaiBuddhistDate(LocalDate.ofYearDay(i - 543, i2));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ThaiBuddhistDate dateEpochDay(long j) {
        return new ThaiBuddhistDate(LocalDate.ofEpochDay(j));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ThaiBuddhistDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ThaiBuddhistDate dateNow(ZoneId zoneId) {
        return dateNow(Clock.system(zoneId));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ThaiBuddhistDate dateNow(Clock clock) {
        return date((TemporalAccessor) LocalDate.now(clock));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ThaiBuddhistDate date(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof ThaiBuddhistDate) {
            return (ThaiBuddhistDate) temporalAccessor;
        }
        return new ThaiBuddhistDate(LocalDate.from(temporalAccessor));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ChronoLocalDateTime<ThaiBuddhistDate> localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ChronoZonedDateTime<ThaiBuddhistDate> zonedDateTime(TemporalAccessor temporalAccessor) {
        return super.zonedDateTime(temporalAccessor);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ChronoZonedDateTime<ThaiBuddhistDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return super.zonedDateTime(instant, zoneId);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public boolean isLeapYear(long j) {
        return IsoChronology.INSTANCE.isLeapYear(j - 543);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public int prolepticYear(Era era, int i) {
        if (era instanceof ThaiBuddhistEra) {
            return era == ThaiBuddhistEra.BE ? i : 1 - i;
        }
        throw new ClassCastException("Era must be BuddhistEra");
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ThaiBuddhistEra eraOf(int i) {
        return ThaiBuddhistEra.m131of(i);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public List<Era> eras() {
        return UByte$.ExternalSyntheticBackport0.m(ThaiBuddhistEra.values());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bytedance.jvm.time.chrono.ThaiBuddhistChronology$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C06421 {
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
        int i = C06421.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[chronoField.ordinal()];
        if (i == 1) {
            ValueRange range = ChronoField.PROLEPTIC_MONTH.range();
            return ValueRange.m134of(range.getMinimum() + 6516, range.getMaximum() + 6516);
        }
        if (i == 2) {
            ValueRange range2 = ChronoField.YEAR.range();
            return ValueRange.m135of(1L, 1 + (-(range2.getMinimum() + 543)), range2.getMaximum() + 543);
        }
        if (i == 3) {
            ValueRange range3 = ChronoField.YEAR.range();
            return ValueRange.m134of(range3.getMinimum() + 543, range3.getMaximum() + 543);
        }
        return chronoField.range();
    }

    @Override // bytedance.jvm.time.chrono.AbstractChronology, bytedance.jvm.time.chrono.Chronology
    public ThaiBuddhistDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        return (ThaiBuddhistDate) super.resolveDate(map, resolverStyle);
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
