package bytedance.jvm.time;

import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.Temporal;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalAdjuster;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.TemporalQueries;
import bytedance.jvm.time.temporal.TemporalQuery;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import bytedance.jvm.time.temporal.ValueRange;
import bytedance.jvm.time.zone.ZoneRules;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, TemporalAdjuster, Comparable<ZoneOffset>, Serializable {
    private static final long serialVersionUID = 2357656521762053153L;

    /* renamed from: id */
    private final transient String f94id;
    private final int totalSeconds;
    private static final ConcurrentMap<Integer, ZoneOffset> SECONDS_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    private static final ConcurrentMap<String, ZoneOffset> ID_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = ofTotalSeconds(0);
    public static final ZoneOffset MIN = ofTotalSeconds(-64800);
    private static final int MAX_SECONDS = 64800;
    public static final ZoneOffset MAX = ofTotalSeconds(MAX_SECONDS);

    private static int totalSeconds(int i, int i2, int i3) {
        return (i * 3600) + (i2 * 60) + i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bd  */
    /* renamed from: of */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ZoneOffset m114of(String str) {
        int parseNumber;
        int i;
        int i2;
        char charAt;
        Objects.requireNonNull(str, "offsetId");
        ZoneOffset zoneOffset = ID_CACHE.get(str);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        int length = str.length();
        if (length == 2) {
            str = str.charAt(0) + "0" + str.charAt(1);
        } else if (length != 3) {
            if (length == 5) {
                parseNumber = parseNumber(str, 1, false);
                i = parseNumber(str, 3, false);
            } else if (length == 6) {
                parseNumber = parseNumber(str, 1, false);
                i = parseNumber(str, 4, true);
            } else {
                if (length == 7) {
                    parseNumber = parseNumber(str, 1, false);
                    i = parseNumber(str, 3, false);
                    i2 = parseNumber(str, 5, false);
                } else if (length == 9) {
                    parseNumber = parseNumber(str, 1, false);
                    i = parseNumber(str, 4, true);
                    i2 = parseNumber(str, 7, true);
                } else {
                    throw new DateTimeException("Invalid ID for ZoneOffset, invalid format: " + str);
                }
                charAt = str.charAt(0);
                if (charAt == '+' && charAt != '-') {
                    throw new DateTimeException("Invalid ID for ZoneOffset, plus/minus not found when expected: " + str);
                }
                if (charAt == '-') {
                    return ofHoursMinutesSeconds(-parseNumber, -i, -i2);
                }
                return ofHoursMinutesSeconds(parseNumber, i, i2);
            }
            i2 = 0;
            charAt = str.charAt(0);
            if (charAt == '+') {
            }
            if (charAt == '-') {
            }
        }
        parseNumber = parseNumber(str, 1, false);
        i = 0;
        i2 = 0;
        charAt = str.charAt(0);
        if (charAt == '+') {
        }
        if (charAt == '-') {
        }
    }

    private static int parseNumber(CharSequence charSequence, int i, boolean z) {
        if (z && charSequence.charAt(i - 1) != ':') {
            throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) charSequence));
        }
        char charAt = charSequence.charAt(i);
        char charAt2 = charSequence.charAt(i + 1);
        if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9') {
            throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) charSequence));
        }
        return ((charAt - '0') * 10) + (charAt2 - '0');
    }

    public static ZoneOffset ofHours(int i) {
        return ofHoursMinutesSeconds(i, 0, 0);
    }

    public static ZoneOffset ofHoursMinutes(int i, int i2) {
        return ofHoursMinutesSeconds(i, i2, 0);
    }

    public static ZoneOffset ofHoursMinutesSeconds(int i, int i2, int i3) {
        validate(i, i2, i3);
        return ofTotalSeconds(totalSeconds(i, i2, i3));
    }

    public static ZoneOffset from(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.query(TemporalQueries.offset());
        if (zoneOffset != null) {
            return zoneOffset;
        }
        throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    private static void validate(int i, int i2, int i3) {
        if (i < -18 || i > 18) {
            throw new DateTimeException("Zone offset hours not in valid range: value " + i + " is not in the range -18 to 18");
        }
        if (i > 0) {
            if (i2 < 0 || i3 < 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i < 0) {
            if (i2 > 0 || i3 > 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i2 > 0 && i3 < 0) || (i2 < 0 && i3 > 0)) {
            throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (i2 < -59 || i2 > 59) {
            throw new DateTimeException("Zone offset minutes not in valid range: value " + i2 + " is not in the range -59 to 59");
        }
        if (i3 < -59 || i3 > 59) {
            throw new DateTimeException("Zone offset seconds not in valid range: value " + i3 + " is not in the range -59 to 59");
        }
        if (Math.abs(i) == 18 && (i2 | i3) != 0) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
    }

    public static ZoneOffset ofTotalSeconds(int i) {
        if (i < -64800 || i > MAX_SECONDS) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i % 900 == 0) {
            Integer valueOf = Integer.valueOf(i);
            ConcurrentMap<Integer, ZoneOffset> concurrentMap = SECONDS_CACHE;
            ZoneOffset zoneOffset = concurrentMap.get(valueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            concurrentMap.putIfAbsent(valueOf, new ZoneOffset(i));
            ZoneOffset zoneOffset2 = concurrentMap.get(valueOf);
            ID_CACHE.putIfAbsent(zoneOffset2.getId(), zoneOffset2);
            return zoneOffset2;
        }
        return new ZoneOffset(i);
    }

    private ZoneOffset(int i) {
        this.totalSeconds = i;
        this.f94id = buildId(i);
    }

    private static String buildId(int i) {
        if (i == 0) {
            return "Z";
        }
        int abs = Math.abs(i);
        StringBuilder sb = new StringBuilder();
        int i2 = abs / 3600;
        int i3 = (abs / 60) % 60;
        sb.append(i < 0 ? "-" : "+").append(i2 < 10 ? "0" : "").append(i2).append(i3 < 10 ? ":0" : ":").append(i3);
        int i4 = abs % 60;
        if (i4 != 0) {
            sb.append(i4 >= 10 ? ":" : ":0").append(i4);
        }
        return sb.toString();
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    @Override // bytedance.jvm.time.ZoneId
    public String getId() {
        return this.f94id;
    }

    @Override // bytedance.jvm.time.ZoneId
    public ZoneRules getRules() {
        return ZoneRules.m141of(this);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.OFFSET_SECONDS : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return super.range(temporalField);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (temporalField instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (temporalField instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return temporalField.getFrom(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return (temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.zone()) ? this : (R) super.query(temporalQuery);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.OFFSET_SECONDS, this.totalSeconds);
    }

    @Override // java.lang.Comparable
    public int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.totalSeconds - this.totalSeconds;
    }

    @Override // bytedance.jvm.time.ZoneId
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.totalSeconds == ((ZoneOffset) obj).totalSeconds;
    }

    @Override // bytedance.jvm.time.ZoneId
    public int hashCode() {
        return this.totalSeconds;
    }

    @Override // bytedance.jvm.time.ZoneId
    public String toString() {
        return this.f94id;
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.ZoneId
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(8);
        writeExternal(dataOutput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        int i = this.totalSeconds;
        int i2 = i % 900 == 0 ? i / 900 : 127;
        dataOutput.writeByte(i2);
        if (i2 == 127) {
            dataOutput.writeInt(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneOffset readExternal(DataInput dataInput) throws IOException {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ofTotalSeconds(dataInput.readInt()) : ofTotalSeconds(readByte * 900);
    }
}
