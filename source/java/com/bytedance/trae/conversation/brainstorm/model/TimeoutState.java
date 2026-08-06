package com.bytedance.trae.conversation.brainstorm.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BrainstormUiState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "Warning", "Expired", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TimeoutState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TimeoutState[] $VALUES;
    public static final TimeoutState Normal = new TimeoutState("Normal", 0);
    public static final TimeoutState Warning = new TimeoutState("Warning", 1);
    public static final TimeoutState Expired = new TimeoutState("Expired", 2);

    private static final /* synthetic */ TimeoutState[] $values() {
        return new TimeoutState[]{Normal, Warning, Expired};
    }

    public static EnumEntries<TimeoutState> getEntries() {
        return $ENTRIES;
    }

    private TimeoutState(String str, int i) {
    }

    static {
        TimeoutState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static TimeoutState valueOf(String str) {
        return (TimeoutState) Enum.valueOf(TimeoutState.class, str);
    }

    public static TimeoutState[] values() {
        return (TimeoutState[]) $VALUES.clone();
    }
}
