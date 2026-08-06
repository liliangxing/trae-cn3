package com.bytedance.trae.conversation.voice.subtask;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SubTaskProtocol.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;", "", "<init>", "(Ljava/lang/String;I)V", "Creating", "Thinking", "Streaming", "Done", "Failed", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubTaskRenderState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SubTaskRenderState[] $VALUES;
    public static final SubTaskRenderState Creating = new SubTaskRenderState("Creating", 0);
    public static final SubTaskRenderState Thinking = new SubTaskRenderState("Thinking", 1);
    public static final SubTaskRenderState Streaming = new SubTaskRenderState("Streaming", 2);
    public static final SubTaskRenderState Done = new SubTaskRenderState("Done", 3);
    public static final SubTaskRenderState Failed = new SubTaskRenderState("Failed", 4);

    private static final /* synthetic */ SubTaskRenderState[] $values() {
        return new SubTaskRenderState[]{Creating, Thinking, Streaming, Done, Failed};
    }

    public static EnumEntries<SubTaskRenderState> getEntries() {
        return $ENTRIES;
    }

    private SubTaskRenderState(String str, int i) {
    }

    static {
        SubTaskRenderState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SubTaskRenderState valueOf(String str) {
        return (SubTaskRenderState) Enum.valueOf(SubTaskRenderState.class, str);
    }

    public static SubTaskRenderState[] values() {
        return (SubTaskRenderState[]) $VALUES.clone();
    }
}
