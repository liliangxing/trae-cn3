package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LocalTimeFormat.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/datetime/format/AmPmMarker;", "", "<init>", "(Ljava/lang/String;I)V", "AM", "PM", "kotlinx-datetime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AmPmMarker {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AmPmMarker[] $VALUES;
    public static final AmPmMarker AM = new AmPmMarker("AM", 0);
    public static final AmPmMarker PM = new AmPmMarker("PM", 1);

    private static final /* synthetic */ AmPmMarker[] $values() {
        return new AmPmMarker[]{AM, PM};
    }

    public static EnumEntries<AmPmMarker> getEntries() {
        return $ENTRIES;
    }

    private AmPmMarker(String str, int i) {
    }

    static {
        AmPmMarker[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AmPmMarker valueOf(String str) {
        return (AmPmMarker) Enum.valueOf(AmPmMarker.class, str);
    }

    public static AmPmMarker[] values() {
        return (AmPmMarker[]) $VALUES.clone();
    }
}
