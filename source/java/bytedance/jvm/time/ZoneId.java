package bytedance.jvm.time;

import bytedance.jvm.time.format.DateTimeFormatterBuilder;
import bytedance.jvm.time.format.TextStyle;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.TemporalQueries;
import bytedance.jvm.time.temporal.TemporalQuery;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import bytedance.jvm.time.zone.ZoneRules;
import bytedance.jvm.time.zone.ZoneRulesException;
import bytedance.jvm.time.zone.ZoneRulesProvider;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class ZoneId implements Serializable {
    public static final Map<String, String> SHORT_IDS = UByte$.ExternalSyntheticBackport0.m(new Map.Entry[]{UByte$.ExternalSyntheticBackport0.m("ACT", "Australia/Darwin"), UByte$.ExternalSyntheticBackport0.m("AET", "Australia/Sydney"), UByte$.ExternalSyntheticBackport0.m("AGT", "America/Argentina/Buenos_Aires"), UByte$.ExternalSyntheticBackport0.m("ART", "Africa/Cairo"), UByte$.ExternalSyntheticBackport0.m("AST", "America/Anchorage"), UByte$.ExternalSyntheticBackport0.m("BET", "America/Sao_Paulo"), UByte$.ExternalSyntheticBackport0.m("BST", "Asia/Dhaka"), UByte$.ExternalSyntheticBackport0.m("CAT", "Africa/Harare"), UByte$.ExternalSyntheticBackport0.m("CNT", "America/St_Johns"), UByte$.ExternalSyntheticBackport0.m("CST", "America/Chicago"), UByte$.ExternalSyntheticBackport0.m("CTT", "Asia/Shanghai"), UByte$.ExternalSyntheticBackport0.m("EAT", "Africa/Addis_Ababa"), UByte$.ExternalSyntheticBackport0.m("ECT", "Europe/Paris"), UByte$.ExternalSyntheticBackport0.m("IET", "America/Indiana/Indianapolis"), UByte$.ExternalSyntheticBackport0.m("IST", "Asia/Kolkata"), UByte$.ExternalSyntheticBackport0.m("JST", "Asia/Tokyo"), UByte$.ExternalSyntheticBackport0.m("MIT", "Pacific/Apia"), UByte$.ExternalSyntheticBackport0.m("NET", "Asia/Yerevan"), UByte$.ExternalSyntheticBackport0.m("NST", "Pacific/Auckland"), UByte$.ExternalSyntheticBackport0.m("PLT", "Asia/Karachi"), UByte$.ExternalSyntheticBackport0.m("PNT", "America/Phoenix"), UByte$.ExternalSyntheticBackport0.m("PRT", "America/Puerto_Rico"), UByte$.ExternalSyntheticBackport0.m("PST", "America/Los_Angeles"), UByte$.ExternalSyntheticBackport0.m("SST", "Pacific/Guadalcanal"), UByte$.ExternalSyntheticBackport0.m("VST", "Asia/Ho_Chi_Minh"), UByte$.ExternalSyntheticBackport0.m("EST", "-05:00"), UByte$.ExternalSyntheticBackport0.m("MST", "-07:00"), UByte$.ExternalSyntheticBackport0.m("HST", "-10:00")});
    private static final long serialVersionUID = 8352817235686L;

    public abstract String getId();

    public abstract ZoneRules getRules();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void write(DataOutput dataOutput) throws IOException;

    public static ZoneId systemDefault() {
        return DesugarTimeZone.toZoneId(TimeZone.getDefault());
    }

    public static Set<String> getAvailableZoneIds() {
        return new HashSet(ZoneRulesProvider.getAvailableZoneIds());
    }

    /* renamed from: of */
    public static ZoneId m112of(String str, Map<String, String> map) {
        Objects.requireNonNull(str, "zoneId");
        Objects.requireNonNull(map, "aliasMap");
        return m111of((String) UByte$.ExternalSyntheticBackport0.m(map.get(str), str));
    }

    /* renamed from: of */
    public static ZoneId m111of(String str) {
        return m113of(str, true);
    }

    public static ZoneId ofOffset(String str, ZoneOffset zoneOffset) {
        Objects.requireNonNull(str, "prefix");
        Objects.requireNonNull(zoneOffset, "offset");
        if (str.isEmpty()) {
            return zoneOffset;
        }
        if (!str.equals("GMT") && !str.equals("UTC") && !str.equals("UT")) {
            throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: " + str);
        }
        if (zoneOffset.getTotalSeconds() != 0) {
            str = str.concat(zoneOffset.getId());
        }
        return new ZoneRegion(str, zoneOffset.getRules());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: of */
    public static ZoneId m113of(String str, boolean z) {
        Objects.requireNonNull(str, "zoneId");
        if (str.length() <= 1 || str.startsWith("+") || str.startsWith("-")) {
            return ZoneOffset.m114of(str);
        }
        if (str.startsWith("UTC") || str.startsWith("GMT")) {
            return ofWithPrefix(str, 3, z);
        }
        if (str.startsWith("UT")) {
            return ofWithPrefix(str, 2, z);
        }
        return ZoneRegion.ofId(str, z);
    }

    private static ZoneId ofWithPrefix(String str, int i, boolean z) {
        String substring = str.substring(0, i);
        if (str.length() == i) {
            return ofOffset(substring, ZoneOffset.UTC);
        }
        if (str.charAt(i) != '+' && str.charAt(i) != '-') {
            return ZoneRegion.ofId(str, z);
        }
        try {
            ZoneOffset m114of = ZoneOffset.m114of(str.substring(i));
            if (m114of == ZoneOffset.UTC) {
                return ofOffset(substring, m114of);
            }
            return ofOffset(substring, m114of);
        } catch (DateTimeException e) {
            throw new DateTimeException("Invalid ID for offset-based ZoneId: " + str, e);
        }
    }

    public static ZoneId from(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.zone());
        if (zoneId != null) {
            return zoneId;
        }
        throw new DateTimeException("Unable to obtain ZoneId from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != ZoneRegion.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().appendZoneText(textStyle).toFormatter(locale).format(toTemporal());
    }

    private TemporalAccessor toTemporal() {
        return new TemporalAccessor() { // from class: bytedance.jvm.time.ZoneId.1
            @Override // bytedance.jvm.time.temporal.TemporalAccessor
            public boolean isSupported(TemporalField temporalField) {
                return false;
            }

            @Override // bytedance.jvm.time.temporal.TemporalAccessor
            public long getLong(TemporalField temporalField) {
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }

            @Override // bytedance.jvm.time.temporal.TemporalAccessor
            public <R> R query(TemporalQuery<R> temporalQuery) {
                if (temporalQuery == TemporalQueries.zoneId()) {
                    return (R) ZoneId.this;
                }
                return (R) super.query(temporalQuery);
            }
        };
    }

    public ZoneId normalized() {
        try {
            ZoneRules rules = getRules();
            if (rules.isFixedOffset()) {
                return rules.getOffset(Instant.EPOCH);
            }
        } catch (ZoneRulesException unused) {
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return getId().equals(((ZoneId) obj).getId());
        }
        return false;
    }

    public int hashCode() {
        return getId().hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public String toString() {
        return getId();
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }
}
