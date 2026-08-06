package com.bytedance.trae.conversation.chat.error;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AgentErrorLevel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;", "", "<init>", "(Ljava/lang/String;I)V", "ERROR", "WARN", "INFO", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AgentErrorLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AgentErrorLevel[] $VALUES;
    public static final AgentErrorLevel ERROR = new AgentErrorLevel("ERROR", 0);
    public static final AgentErrorLevel WARN = new AgentErrorLevel("WARN", 1);
    public static final AgentErrorLevel INFO = new AgentErrorLevel("INFO", 2);

    private static final /* synthetic */ AgentErrorLevel[] $values() {
        return new AgentErrorLevel[]{ERROR, WARN, INFO};
    }

    public static EnumEntries<AgentErrorLevel> getEntries() {
        return $ENTRIES;
    }

    private AgentErrorLevel(String str, int i) {
    }

    static {
        AgentErrorLevel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AgentErrorLevel valueOf(String str) {
        return (AgentErrorLevel) Enum.valueOf(AgentErrorLevel.class, str);
    }

    public static AgentErrorLevel[] values() {
        return (AgentErrorLevel[]) $VALUES.clone();
    }
}
