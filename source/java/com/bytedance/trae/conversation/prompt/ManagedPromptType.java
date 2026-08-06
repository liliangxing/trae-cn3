package com.bytedance.trae.conversation.prompt;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ManagedPromptArbitrationPolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;", "", "<init>", "(Ljava/lang/String;I)V", "BillingUpgrade", "MobileIdeGuide", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManagedPromptType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ManagedPromptType[] $VALUES;
    public static final ManagedPromptType BillingUpgrade = new ManagedPromptType("BillingUpgrade", 0);
    public static final ManagedPromptType MobileIdeGuide = new ManagedPromptType("MobileIdeGuide", 1);

    private static final /* synthetic */ ManagedPromptType[] $values() {
        return new ManagedPromptType[]{BillingUpgrade, MobileIdeGuide};
    }

    public static EnumEntries<ManagedPromptType> getEntries() {
        return $ENTRIES;
    }

    private ManagedPromptType(String str, int i) {
    }

    static {
        ManagedPromptType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ManagedPromptType valueOf(String str) {
        return (ManagedPromptType) Enum.valueOf(ManagedPromptType.class, str);
    }

    public static ManagedPromptType[] values() {
        return (ManagedPromptType[]) $VALUES.clone();
    }
}
