package com.bytedance.trae.conversation.prompt;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ManagedPromptArbitrationPolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;", "", "<init>", "(Ljava/lang/String;I)V", "Shown", "TemporarilyBlocked", "NotShown", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManagedPromptDisplayOutcome {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ManagedPromptDisplayOutcome[] $VALUES;
    public static final ManagedPromptDisplayOutcome Shown = new ManagedPromptDisplayOutcome("Shown", 0);
    public static final ManagedPromptDisplayOutcome TemporarilyBlocked = new ManagedPromptDisplayOutcome("TemporarilyBlocked", 1);
    public static final ManagedPromptDisplayOutcome NotShown = new ManagedPromptDisplayOutcome("NotShown", 2);

    private static final /* synthetic */ ManagedPromptDisplayOutcome[] $values() {
        return new ManagedPromptDisplayOutcome[]{Shown, TemporarilyBlocked, NotShown};
    }

    public static EnumEntries<ManagedPromptDisplayOutcome> getEntries() {
        return $ENTRIES;
    }

    private ManagedPromptDisplayOutcome(String str, int i) {
    }

    static {
        ManagedPromptDisplayOutcome[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ManagedPromptDisplayOutcome valueOf(String str) {
        return (ManagedPromptDisplayOutcome) Enum.valueOf(ManagedPromptDisplayOutcome.class, str);
    }

    public static ManagedPromptDisplayOutcome[] values() {
        return (ManagedPromptDisplayOutcome[]) $VALUES.clone();
    }
}
