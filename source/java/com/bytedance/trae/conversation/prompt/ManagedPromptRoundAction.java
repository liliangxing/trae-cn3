package com.bytedance.trae.conversation.prompt;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ManagedPromptArbitrationPolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptRoundAction;", "", "<init>", "(Ljava/lang/String;I)V", "Complete", "Retry", "ContinueToLowerPriority", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManagedPromptRoundAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ManagedPromptRoundAction[] $VALUES;
    public static final ManagedPromptRoundAction Complete = new ManagedPromptRoundAction("Complete", 0);
    public static final ManagedPromptRoundAction Retry = new ManagedPromptRoundAction("Retry", 1);
    public static final ManagedPromptRoundAction ContinueToLowerPriority = new ManagedPromptRoundAction("ContinueToLowerPriority", 2);

    private static final /* synthetic */ ManagedPromptRoundAction[] $values() {
        return new ManagedPromptRoundAction[]{Complete, Retry, ContinueToLowerPriority};
    }

    public static EnumEntries<ManagedPromptRoundAction> getEntries() {
        return $ENTRIES;
    }

    private ManagedPromptRoundAction(String str, int i) {
    }

    static {
        ManagedPromptRoundAction[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ManagedPromptRoundAction valueOf(String str) {
        return (ManagedPromptRoundAction) Enum.valueOf(ManagedPromptRoundAction.class, str);
    }

    public static ManagedPromptRoundAction[] values() {
        return (ManagedPromptRoundAction[]) $VALUES.clone();
    }
}
