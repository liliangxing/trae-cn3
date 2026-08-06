package com.bytedance.trae.home.solo.task;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TaskModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskDisplayState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "WAITING", "ERROR", "IDLE", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TaskDisplayState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TaskDisplayState[] $VALUES;
    public static final TaskDisplayState LOADING = new TaskDisplayState("LOADING", 0);
    public static final TaskDisplayState WAITING = new TaskDisplayState("WAITING", 1);
    public static final TaskDisplayState ERROR = new TaskDisplayState("ERROR", 2);
    public static final TaskDisplayState IDLE = new TaskDisplayState("IDLE", 3);

    private static final /* synthetic */ TaskDisplayState[] $values() {
        return new TaskDisplayState[]{LOADING, WAITING, ERROR, IDLE};
    }

    public static EnumEntries<TaskDisplayState> getEntries() {
        return $ENTRIES;
    }

    private TaskDisplayState(String str, int i) {
    }

    static {
        TaskDisplayState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static TaskDisplayState valueOf(String str) {
        return (TaskDisplayState) Enum.valueOf(TaskDisplayState.class, str);
    }

    public static TaskDisplayState[] values() {
        return (TaskDisplayState[]) $VALUES.clone();
    }
}
