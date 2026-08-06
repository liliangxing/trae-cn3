package com.bytedance.trae.conversation.tracker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TocCreditsObservation.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/BillingPopupShowSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Normal", "Restored", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillingPopupShowSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BillingPopupShowSource[] $VALUES;
    public static final BillingPopupShowSource Normal = new BillingPopupShowSource("Normal", 0, "normal");
    public static final BillingPopupShowSource Restored = new BillingPopupShowSource("Restored", 1, "restored");
    private final String value;

    private static final /* synthetic */ BillingPopupShowSource[] $values() {
        return new BillingPopupShowSource[]{Normal, Restored};
    }

    public static EnumEntries<BillingPopupShowSource> getEntries() {
        return $ENTRIES;
    }

    private BillingPopupShowSource(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        BillingPopupShowSource[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static BillingPopupShowSource valueOf(String str) {
        return (BillingPopupShowSource) Enum.valueOf(BillingPopupShowSource.class, str);
    }

    public static BillingPopupShowSource[] values() {
        return (BillingPopupShowSource[]) $VALUES.clone();
    }
}
