package com.bytedance.trae.conversation.tracker;

import com.ss.android.http.legacy.protocol.HTTP;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TocCreditsObservation.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue$conversation_mainlandRelease", "()Ljava/lang/String;", HTTP.CONN_CLOSE, "Primary", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillingPopupAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BillingPopupAction[] $VALUES;
    public static final BillingPopupAction Close = new BillingPopupAction(HTTP.CONN_CLOSE, 0, "close");
    public static final BillingPopupAction Primary = new BillingPopupAction("Primary", 1, "primary");
    private final String value;

    private static final /* synthetic */ BillingPopupAction[] $values() {
        return new BillingPopupAction[]{Close, Primary};
    }

    public static EnumEntries<BillingPopupAction> getEntries() {
        return $ENTRIES;
    }

    private BillingPopupAction(String str, int i, String str2) {
        this.value = str2;
    }

    /* renamed from: getValue$conversation_mainlandRelease, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    static {
        BillingPopupAction[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static BillingPopupAction valueOf(String str) {
        return (BillingPopupAction) Enum.valueOf(BillingPopupAction.class, str);
    }

    public static BillingPopupAction[] values() {
        return (BillingPopupAction[]) $VALUES.clone();
    }
}
