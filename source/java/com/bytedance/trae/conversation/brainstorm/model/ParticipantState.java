package com.bytedance.trae.conversation.brainstorm.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BrainstormUiState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "Speaking", "Thinking", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ParticipantState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ParticipantState[] $VALUES;
    public static final ParticipantState Idle = new ParticipantState("Idle", 0);
    public static final ParticipantState Speaking = new ParticipantState("Speaking", 1);
    public static final ParticipantState Thinking = new ParticipantState("Thinking", 2);

    private static final /* synthetic */ ParticipantState[] $values() {
        return new ParticipantState[]{Idle, Speaking, Thinking};
    }

    public static EnumEntries<ParticipantState> getEntries() {
        return $ENTRIES;
    }

    private ParticipantState(String str, int i) {
    }

    static {
        ParticipantState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ParticipantState valueOf(String str) {
        return (ParticipantState) Enum.valueOf(ParticipantState.class, str);
    }

    public static ParticipantState[] values() {
        return (ParticipantState[]) $VALUES.clone();
    }
}
