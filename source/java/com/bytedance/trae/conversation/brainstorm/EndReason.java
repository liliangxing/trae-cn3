package com.bytedance.trae.conversation.brainstorm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HolderTypes.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/EndReason;", "", "<init>", "(Ljava/lang/String;I)V", "UserEndInActivity", "UserAbortInActivity", "UserAbortInConversation", "UserBackInConversation", "SessionTimeout", "InterruptedBySwitchSession", "ProcessRecovery", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EndReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EndReason[] $VALUES;
    public static final EndReason UserEndInActivity = new EndReason("UserEndInActivity", 0);
    public static final EndReason UserAbortInActivity = new EndReason("UserAbortInActivity", 1);
    public static final EndReason UserAbortInConversation = new EndReason("UserAbortInConversation", 2);
    public static final EndReason UserBackInConversation = new EndReason("UserBackInConversation", 3);
    public static final EndReason SessionTimeout = new EndReason("SessionTimeout", 4);
    public static final EndReason InterruptedBySwitchSession = new EndReason("InterruptedBySwitchSession", 5);
    public static final EndReason ProcessRecovery = new EndReason("ProcessRecovery", 6);

    private static final /* synthetic */ EndReason[] $values() {
        return new EndReason[]{UserEndInActivity, UserAbortInActivity, UserAbortInConversation, UserBackInConversation, SessionTimeout, InterruptedBySwitchSession, ProcessRecovery};
    }

    public static EnumEntries<EndReason> getEntries() {
        return $ENTRIES;
    }

    private EndReason(String str, int i) {
    }

    static {
        EndReason[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static EndReason valueOf(String str) {
        return (EndReason) Enum.valueOf(EndReason.class, str);
    }

    public static EndReason[] values() {
        return (EndReason[]) $VALUES.clone();
    }
}
