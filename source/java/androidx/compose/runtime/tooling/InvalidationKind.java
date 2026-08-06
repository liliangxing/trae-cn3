package androidx.compose.runtime.tooling;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GlobalCompositionObserver.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/tooling/InvalidationKind;", "", "<init>", "(Ljava/lang/String;I)V", "Remeasure", "Relayout", "Redraw", "ObserverNode", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InvalidationKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InvalidationKind[] $VALUES;
    public static final InvalidationKind Remeasure = new InvalidationKind("Remeasure", 0);
    public static final InvalidationKind Relayout = new InvalidationKind("Relayout", 1);
    public static final InvalidationKind Redraw = new InvalidationKind("Redraw", 2);
    public static final InvalidationKind ObserverNode = new InvalidationKind("ObserverNode", 3);

    private static final /* synthetic */ InvalidationKind[] $values() {
        return new InvalidationKind[]{Remeasure, Relayout, Redraw, ObserverNode};
    }

    public static EnumEntries<InvalidationKind> getEntries() {
        return $ENTRIES;
    }

    private InvalidationKind(String str, int i) {
    }

    static {
        InvalidationKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static InvalidationKind valueOf(String str) {
        return (InvalidationKind) Enum.valueOf(InvalidationKind.class, str);
    }

    public static InvalidationKind[] values() {
        return (InvalidationKind[]) $VALUES.clone();
    }
}
