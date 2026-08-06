package androidx.compose.ui.prewarm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.apache.commons.codec.language.bm.Rule;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ComposePreWarm.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/prewarm/ComposePreWarmType;", "", "<init>", "(Ljava/lang/String;I)V", "COMPOSE_ONLY", "COMPOSE_AND_LAYOUT", Rule.ALL, "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposePreWarmType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ComposePreWarmType[] $VALUES;
    public static final ComposePreWarmType COMPOSE_ONLY = new ComposePreWarmType("COMPOSE_ONLY", 0);
    public static final ComposePreWarmType COMPOSE_AND_LAYOUT = new ComposePreWarmType("COMPOSE_AND_LAYOUT", 1);
    public static final ComposePreWarmType ALL = new ComposePreWarmType(Rule.ALL, 2);

    private static final /* synthetic */ ComposePreWarmType[] $values() {
        return new ComposePreWarmType[]{COMPOSE_ONLY, COMPOSE_AND_LAYOUT, ALL};
    }

    public static EnumEntries<ComposePreWarmType> getEntries() {
        return $ENTRIES;
    }

    private ComposePreWarmType(String str, int i) {
    }

    static {
        ComposePreWarmType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ComposePreWarmType valueOf(String str) {
        return (ComposePreWarmType) Enum.valueOf(ComposePreWarmType.class, str);
    }

    public static ComposePreWarmType[] values() {
        return (ComposePreWarmType[]) $VALUES.clone();
    }
}
