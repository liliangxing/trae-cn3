package com.bytedance.trae.conversation.chat.grouping;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PlanItemGrouper.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", DebugCoroutineInfoImplKt.RUNNING, "SUCCESS", "FAILED", "SKIPPED", "WAITING_CONFIRM", "WAITING_CONFIRM_REDLIST", "CANCELED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlanItemExecutionStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PlanItemExecutionStatus[] $VALUES;
    public static final PlanItemExecutionStatus PENDING = new PlanItemExecutionStatus("PENDING", 0);
    public static final PlanItemExecutionStatus RUNNING = new PlanItemExecutionStatus(DebugCoroutineInfoImplKt.RUNNING, 1);
    public static final PlanItemExecutionStatus SUCCESS = new PlanItemExecutionStatus("SUCCESS", 2);
    public static final PlanItemExecutionStatus FAILED = new PlanItemExecutionStatus("FAILED", 3);
    public static final PlanItemExecutionStatus SKIPPED = new PlanItemExecutionStatus("SKIPPED", 4);
    public static final PlanItemExecutionStatus WAITING_CONFIRM = new PlanItemExecutionStatus("WAITING_CONFIRM", 5);
    public static final PlanItemExecutionStatus WAITING_CONFIRM_REDLIST = new PlanItemExecutionStatus("WAITING_CONFIRM_REDLIST", 6);
    public static final PlanItemExecutionStatus CANCELED = new PlanItemExecutionStatus("CANCELED", 7);

    private static final /* synthetic */ PlanItemExecutionStatus[] $values() {
        return new PlanItemExecutionStatus[]{PENDING, RUNNING, SUCCESS, FAILED, SKIPPED, WAITING_CONFIRM, WAITING_CONFIRM_REDLIST, CANCELED};
    }

    public static EnumEntries<PlanItemExecutionStatus> getEntries() {
        return $ENTRIES;
    }

    private PlanItemExecutionStatus(String str, int i) {
    }

    static {
        PlanItemExecutionStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static PlanItemExecutionStatus valueOf(String str) {
        return (PlanItemExecutionStatus) Enum.valueOf(PlanItemExecutionStatus.class, str);
    }

    public static PlanItemExecutionStatus[] values() {
        return (PlanItemExecutionStatus[]) $VALUES.clone();
    }
}
