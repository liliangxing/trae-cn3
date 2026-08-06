package com.bytedance.trae.conversation.brainstorm.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BrainstormUiState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "Thinking", "Replying", "Interrupted", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AiReplyState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AiReplyState[] $VALUES;
    public static final AiReplyState Idle = new AiReplyState("Idle", 0);
    public static final AiReplyState Thinking = new AiReplyState("Thinking", 1);
    public static final AiReplyState Replying = new AiReplyState("Replying", 2);
    public static final AiReplyState Interrupted = new AiReplyState("Interrupted", 3);

    private static final /* synthetic */ AiReplyState[] $values() {
        return new AiReplyState[]{Idle, Thinking, Replying, Interrupted};
    }

    public static EnumEntries<AiReplyState> getEntries() {
        return $ENTRIES;
    }

    private AiReplyState(String str, int i) {
    }

    static {
        AiReplyState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AiReplyState valueOf(String str) {
        return (AiReplyState) Enum.valueOf(AiReplyState.class, str);
    }

    public static AiReplyState[] values() {
        return (AiReplyState[]) $VALUES.clone();
    }
}
