package bytedance.jvm.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.DayOfWeek;
import bytedance.jvm.time.format.ResolverStyle;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.TemporalAdjusters;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.TemporalUnit;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class AbstractChronology implements Chronology {
    private static final ConcurrentHashMap<String, Chronology> CHRONOS_BY_ID = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Chronology> CHRONOS_BY_TYPE = new ConcurrentHashMap<>();
    private static final Locale JAPANESE_CALENDAR_LOCALE = new Locale("ja", "JP", "JP");

    static Chronology registerChrono(Chronology chronology) {
        return registerChrono(chronology, chronology.getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Chronology registerChrono(Chronology chronology, String str) {
        String calendarType;
        Chronology putIfAbsent = CHRONOS_BY_ID.putIfAbsent(str, chronology);
        if (putIfAbsent == null && (calendarType = chronology.getCalendarType()) != null) {
            CHRONOS_BY_TYPE.putIfAbsent(calendarType, chronology);
        }
        return putIfAbsent;
    }

    private static boolean initCache() {
        if (CHRONOS_BY_ID.get(ExifInterface.TAG_RW2_ISO) != null) {
            return false;
        }
        registerChrono(HijrahChronology.INSTANCE);
        registerChrono(JapaneseChronology.INSTANCE);
        registerChrono(MinguoChronology.INSTANCE);
        registerChrono(ThaiBuddhistChronology.INSTANCE);
        Iterator it = ServiceLoader.load(AbstractChronology.class, null).iterator();
        while (it.hasNext()) {
            AbstractChronology abstractChronology = (AbstractChronology) it.next();
            if (!abstractChronology.getId().equals(ExifInterface.TAG_RW2_ISO)) {
                registerChrono(abstractChronology);
            }
        }
        registerChrono(IsoChronology.INSTANCE);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Chronology ofLocale(Locale locale) {
        Objects.requireNonNull(locale, "locale");
        String calendarType = getCalendarType(locale);
        if (calendarType == null || "iso".equals(calendarType) || "iso8601".equals(calendarType)) {
            return IsoChronology.INSTANCE;
        }
        do {
            Chronology chronology = CHRONOS_BY_TYPE.get(calendarType);
            if (chronology != null) {
                return chronology;
            }
        } while (initCache());
        Iterator it = ServiceLoader.load(Chronology.class).iterator();
        while (it.hasNext()) {
            Chronology chronology2 = (Chronology) it.next();
            if (calendarType.equals(chronology2.getCalendarType())) {
                return chronology2;
            }
        }
        throw new DateTimeException("Unknown calendar system: " + calendarType);
    }

    private static String getCalendarType(Locale locale) {
        String unicodeLocaleType = locale.getUnicodeLocaleType("ca");
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        if (locale.equals(JAPANESE_CALENDAR_LOCALE)) {
            return "japanese";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: of */
    public static Chronology m118of(String str) {
        Objects.requireNonNull(str, "id");
        do {
            Chronology of0 = of0(str);
            if (of0 != null) {
                return of0;
            }
        } while (initCache());
        Iterator it = ServiceLoader.load(Chronology.class).iterator();
        while (it.hasNext()) {
            Chronology chronology = (Chronology) it.next();
            if (str.equals(chronology.getId()) || str.equals(chronology.getCalendarType())) {
                return chronology;
            }
        }
        throw new DateTimeException("Unknown chronology: " + str);
    }

    private static Chronology of0(String str) {
        Chronology chronology = CHRONOS_BY_ID.get(str);
        return chronology == null ? CHRONOS_BY_TYPE.get(str) : chronology;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<Chronology> getAvailableChronologies() {
        initCache();
        HashSet hashSet = new HashSet(CHRONOS_BY_ID.values());
        Iterator it = ServiceLoader.load(Chronology.class).iterator();
        while (it.hasNext()) {
            hashSet.add((Chronology) it.next());
        }
        return hashSet;
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ChronoLocalDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        if (map.containsKey(ChronoField.EPOCH_DAY)) {
            return dateEpochDay(map.remove(ChronoField.EPOCH_DAY).longValue());
        }
        resolveProlepticMonth(map, resolverStyle);
        ChronoLocalDate resolveYearOfEra = resolveYearOfEra(map, resolverStyle);
        if (resolveYearOfEra != null) {
            return resolveYearOfEra;
        }
        if (!map.containsKey(ChronoField.YEAR)) {
            return null;
        }
        if (map.containsKey(ChronoField.MONTH_OF_YEAR)) {
            if (map.containsKey(ChronoField.DAY_OF_MONTH)) {
                return resolveYMD(map, resolverStyle);
            }
            if (map.containsKey(ChronoField.ALIGNED_WEEK_OF_MONTH)) {
                if (map.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH)) {
                    return resolveYMAA(map, resolverStyle);
                }
                if (map.containsKey(ChronoField.DAY_OF_WEEK)) {
                    return resolveYMAD(map, resolverStyle);
                }
            }
        }
        if (map.containsKey(ChronoField.DAY_OF_YEAR)) {
            return resolveYD(map, resolverStyle);
        }
        if (!map.containsKey(ChronoField.ALIGNED_WEEK_OF_YEAR)) {
            return null;
        }
        if (map.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR)) {
            return resolveYAA(map, resolverStyle);
        }
        if (map.containsKey(ChronoField.DAY_OF_WEEK)) {
            return resolveYAD(map, resolverStyle);
        }
        return null;
    }

    void resolveProlepticMonth(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        Long remove = map.remove(ChronoField.PROLEPTIC_MONTH);
        if (remove != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.PROLEPTIC_MONTH.checkValidValue(remove.longValue());
            }
            ChronoLocalDate with = dateNow().with((TemporalField) ChronoField.DAY_OF_MONTH, 1L).with((TemporalField) ChronoField.PROLEPTIC_MONTH, remove.longValue());
            addFieldValue(map, ChronoField.MONTH_OF_YEAR, with.get(ChronoField.MONTH_OF_YEAR));
            addFieldValue(map, ChronoField.YEAR, with.get(ChronoField.YEAR));
        }
    }

    ChronoLocalDate resolveYearOfEra(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        int intExact;
        Long remove = map.remove(ChronoField.YEAR_OF_ERA);
        if (remove != null) {
            Long remove2 = map.remove(ChronoField.ERA);
            if (resolverStyle != ResolverStyle.LENIENT) {
                intExact = range(ChronoField.YEAR_OF_ERA).checkValidIntValue(remove.longValue(), ChronoField.YEAR_OF_ERA);
            } else {
                intExact = Math.toIntExact(remove.longValue());
            }
            if (remove2 != null) {
                addFieldValue(map, ChronoField.YEAR, prolepticYear(eraOf(range(ChronoField.ERA).checkValidIntValue(remove2.longValue(), ChronoField.ERA)), intExact));
                return null;
            }
            if (map.containsKey(ChronoField.YEAR)) {
                addFieldValue(map, ChronoField.YEAR, prolepticYear(dateYearDay(range(ChronoField.YEAR).checkValidIntValue(map.get(ChronoField.YEAR).longValue(), ChronoField.YEAR), 1).getEra(), intExact));
                return null;
            }
            if (resolverStyle == ResolverStyle.STRICT) {
                map.put(ChronoField.YEAR_OF_ERA, remove);
                return null;
            }
            if (eras().isEmpty()) {
                addFieldValue(map, ChronoField.YEAR, intExact);
                return null;
            }
            addFieldValue(map, ChronoField.YEAR, prolepticYear(r8.get(r8.size() - 1), intExact));
            return null;
        }
        if (!map.containsKey(ChronoField.ERA)) {
            return null;
        }
        range(ChronoField.ERA).checkValidValue(map.get(ChronoField.ERA).longValue(), ChronoField.ERA);
        return null;
    }

    ChronoLocalDate resolveYMD(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        int checkValidIntValue = range(ChronoField.YEAR).checkValidIntValue(map.remove(ChronoField.YEAR).longValue(), ChronoField.YEAR);
        if (resolverStyle == ResolverStyle.LENIENT) {
            long subtractExact = Math.subtractExact(map.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1L);
            return date(checkValidIntValue, 1, 1).plus(subtractExact, (TemporalUnit) ChronoUnit.MONTHS).plus(Math.subtractExact(map.remove(ChronoField.DAY_OF_MONTH).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        int checkValidIntValue2 = range(ChronoField.MONTH_OF_YEAR).checkValidIntValue(map.remove(ChronoField.MONTH_OF_YEAR).longValue(), ChronoField.MONTH_OF_YEAR);
        int checkValidIntValue3 = range(ChronoField.DAY_OF_MONTH).checkValidIntValue(map.remove(ChronoField.DAY_OF_MONTH).longValue(), ChronoField.DAY_OF_MONTH);
        if (resolverStyle == ResolverStyle.SMART) {
            try {
                return date(checkValidIntValue, checkValidIntValue2, checkValidIntValue3);
            } catch (DateTimeException unused) {
                return date(checkValidIntValue, checkValidIntValue2, 1).with(TemporalAdjusters.lastDayOfMonth());
            }
        }
        return date(checkValidIntValue, checkValidIntValue2, checkValidIntValue3);
    }

    ChronoLocalDate resolveYD(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        int checkValidIntValue = range(ChronoField.YEAR).checkValidIntValue(map.remove(ChronoField.YEAR).longValue(), ChronoField.YEAR);
        if (resolverStyle == ResolverStyle.LENIENT) {
            return dateYearDay(checkValidIntValue, 1).plus(Math.subtractExact(map.remove(ChronoField.DAY_OF_YEAR).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        return dateYearDay(checkValidIntValue, range(ChronoField.DAY_OF_YEAR).checkValidIntValue(map.remove(ChronoField.DAY_OF_YEAR).longValue(), ChronoField.DAY_OF_YEAR));
    }

    ChronoLocalDate resolveYMAA(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        int checkValidIntValue = range(ChronoField.YEAR).checkValidIntValue(map.remove(ChronoField.YEAR).longValue(), ChronoField.YEAR);
        if (resolverStyle == ResolverStyle.LENIENT) {
            long subtractExact = Math.subtractExact(map.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1L);
            return date(checkValidIntValue, 1, 1).plus(subtractExact, (TemporalUnit) ChronoUnit.MONTHS).plus(Math.subtractExact(map.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Math.subtractExact(map.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        int checkValidIntValue2 = range(ChronoField.MONTH_OF_YEAR).checkValidIntValue(map.remove(ChronoField.MONTH_OF_YEAR).longValue(), ChronoField.MONTH_OF_YEAR);
        ChronoLocalDate plus = date(checkValidIntValue, checkValidIntValue2, 1).plus(((range(ChronoField.ALIGNED_WEEK_OF_MONTH).checkValidIntValue(map.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue(), ChronoField.ALIGNED_WEEK_OF_MONTH) - 1) * 7) + (range(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH).checkValidIntValue(map.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH).longValue(), ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH) - 1), (TemporalUnit) ChronoUnit.DAYS);
        if (resolverStyle != ResolverStyle.STRICT || plus.get(ChronoField.MONTH_OF_YEAR) == checkValidIntValue2) {
            return plus;
        }
        throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
    }

    ChronoLocalDate resolveYMAD(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        int checkValidIntValue = range(ChronoField.YEAR).checkValidIntValue(map.remove(ChronoField.YEAR).longValue(), ChronoField.YEAR);
        if (resolverStyle == ResolverStyle.LENIENT) {
            return resolveAligned(date(checkValidIntValue, 1, 1), Math.subtractExact(map.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1L), Math.subtractExact(map.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue(), 1L), Math.subtractExact(map.remove(ChronoField.DAY_OF_WEEK).longValue(), 1L));
        }
        int checkValidIntValue2 = range(ChronoField.MONTH_OF_YEAR).checkValidIntValue(map.remove(ChronoField.MONTH_OF_YEAR).longValue(), ChronoField.MONTH_OF_YEAR);
        ChronoLocalDate with = date(checkValidIntValue, checkValidIntValue2, 1).plus((range(ChronoField.ALIGNED_WEEK_OF_MONTH).checkValidIntValue(map.remove(ChronoField.ALIGNED_WEEK_OF_MONTH).longValue(), ChronoField.ALIGNED_WEEK_OF_MONTH) - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).with(TemporalAdjusters.nextOrSame(DayOfWeek.m85of(range(ChronoField.DAY_OF_WEEK).checkValidIntValue(map.remove(ChronoField.DAY_OF_WEEK).longValue(), ChronoField.DAY_OF_WEEK))));
        if (resolverStyle != ResolverStyle.STRICT || with.get(ChronoField.MONTH_OF_YEAR) == checkValidIntValue2) {
            return with;
        }
        throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
    }

    ChronoLocalDate resolveYAA(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        int checkValidIntValue = range(ChronoField.YEAR).checkValidIntValue(map.remove(ChronoField.YEAR).longValue(), ChronoField.YEAR);
        if (resolverStyle == ResolverStyle.LENIENT) {
            return dateYearDay(checkValidIntValue, 1).plus(Math.subtractExact(map.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Math.subtractExact(map.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        ChronoLocalDate plus = dateYearDay(checkValidIntValue, 1).plus(((range(ChronoField.ALIGNED_WEEK_OF_YEAR).checkValidIntValue(map.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue(), ChronoField.ALIGNED_WEEK_OF_YEAR) - 1) * 7) + (range(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR).checkValidIntValue(map.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR).longValue(), ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR) - 1), (TemporalUnit) ChronoUnit.DAYS);
        if (resolverStyle != ResolverStyle.STRICT || plus.get(ChronoField.YEAR) == checkValidIntValue) {
            return plus;
        }
        throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
    }

    ChronoLocalDate resolveYAD(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        int checkValidIntValue = range(ChronoField.YEAR).checkValidIntValue(map.remove(ChronoField.YEAR).longValue(), ChronoField.YEAR);
        if (resolverStyle == ResolverStyle.LENIENT) {
            return resolveAligned(dateYearDay(checkValidIntValue, 1), 0L, Math.subtractExact(map.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue(), 1L), Math.subtractExact(map.remove(ChronoField.DAY_OF_WEEK).longValue(), 1L));
        }
        ChronoLocalDate with = dateYearDay(checkValidIntValue, 1).plus((range(ChronoField.ALIGNED_WEEK_OF_YEAR).checkValidIntValue(map.remove(ChronoField.ALIGNED_WEEK_OF_YEAR).longValue(), ChronoField.ALIGNED_WEEK_OF_YEAR) - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).with(TemporalAdjusters.nextOrSame(DayOfWeek.m85of(range(ChronoField.DAY_OF_WEEK).checkValidIntValue(map.remove(ChronoField.DAY_OF_WEEK).longValue(), ChronoField.DAY_OF_WEEK))));
        if (resolverStyle != ResolverStyle.STRICT || with.get(ChronoField.YEAR) == checkValidIntValue) {
            return with;
        }
        throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
    }

    ChronoLocalDate resolveAligned(ChronoLocalDate chronoLocalDate, long j, long j2, long j3) {
        long j4;
        ChronoLocalDate plus = chronoLocalDate.plus(j, (TemporalUnit) ChronoUnit.MONTHS).plus(j2, (TemporalUnit) ChronoUnit.WEEKS);
        if (j3 > 7) {
            long j5 = j3 - 1;
            plus = plus.plus(j5 / 7, (TemporalUnit) ChronoUnit.WEEKS);
            j4 = j5 % 7;
        } else {
            if (j3 < 1) {
                plus = plus.plus(Math.subtractExact(j3, 7L) / 7, (TemporalUnit) ChronoUnit.WEEKS);
                j4 = (j3 + 6) % 7;
            }
            return plus.with(TemporalAdjusters.nextOrSame(DayOfWeek.m85of((int) j3)));
        }
        j3 = j4 + 1;
        return plus.with(TemporalAdjusters.nextOrSame(DayOfWeek.m85of((int) j3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFieldValue(Map<TemporalField, Long> map, ChronoField chronoField, long j) {
        Long l = map.get(chronoField);
        if (l != null && l.longValue() != j) {
            throw new DateTimeException("Conflict found: " + chronoField + " " + l + " differs from " + chronoField + " " + j);
        }
        map.put(chronoField, Long.valueOf(j));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // bytedance.jvm.time.chrono.Chronology, java.lang.Comparable
    public int compareTo(Chronology chronology) {
        return getId().compareTo(chronology.getId());
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractChronology) && compareTo((Chronology) obj) == 0;
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public int hashCode() {
        return getClass().hashCode() ^ getId().hashCode();
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public String toString() {
        return getId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Chronology readExternal(DataInput dataInput) throws IOException {
        return Chronology.m120of(dataInput.readUTF());
    }
}
