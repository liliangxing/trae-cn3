package androidx.compose.ui.precompose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PreComposeView.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/precompose/PreComposeStatus;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "PRECOMPOSED", "USED", "DISPOSED", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreComposeStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PreComposeStatus[] $VALUES;
    public static final PreComposeStatus INIT = new PreComposeStatus("INIT", 0);
    public static final PreComposeStatus PRECOMPOSED = new PreComposeStatus("PRECOMPOSED", 1);
    public static final PreComposeStatus USED = new PreComposeStatus("USED", 2);
    public static final PreComposeStatus DISPOSED = new PreComposeStatus("DISPOSED", 3);

    private static final /* synthetic */ PreComposeStatus[] $values() {
        return new PreComposeStatus[]{INIT, PRECOMPOSED, USED, DISPOSED};
    }

    public static EnumEntries<PreComposeStatus> getEntries() {
        return $ENTRIES;
    }

    private PreComposeStatus(String str, int i) {
    }

    static {
        PreComposeStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static PreComposeStatus valueOf(String str) {
        return (PreComposeStatus) Enum.valueOf(PreComposeStatus.class, str);
    }

    public static PreComposeStatus[] values() {
        return (PreComposeStatus[]) $VALUES.clone();
    }
}
