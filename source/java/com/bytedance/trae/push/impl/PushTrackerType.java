package com.bytedance.trae.push.impl;

import com.bytedance.android.service.manager.push.trace.Constants;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PushEventManager.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/push/impl/PushTrackerType;", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "actionName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "getActionName", "START", "FAIL", "TOUCHED_ROUTER", "VALIDATE_FAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PushTrackerType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PushTrackerType[] $VALUES;
    private final String actionName;
    private final String eventName;
    public static final PushTrackerType START = new PushTrackerType("START", 0, "rd_push_process_start", Constants.NODE_PROCESS_START);
    public static final PushTrackerType FAIL = new PushTrackerType("FAIL", 1, "rd_push_process_fail", "process_fail");
    public static final PushTrackerType TOUCHED_ROUTER = new PushTrackerType("TOUCHED_ROUTER", 2, "rd_push_process_touch_router", "process_touch_router");
    public static final PushTrackerType VALIDATE_FAIL = new PushTrackerType("VALIDATE_FAIL", 3, "rd_push_params_validate_fail", "process_validate_fail");

    private static final /* synthetic */ PushTrackerType[] $values() {
        return new PushTrackerType[]{START, FAIL, TOUCHED_ROUTER, VALIDATE_FAIL};
    }

    public static EnumEntries<PushTrackerType> getEntries() {
        return $ENTRIES;
    }

    private PushTrackerType(String str, int i, String str2, String str3) {
        this.eventName = str2;
        this.actionName = str3;
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final String getEventName() {
        return this.eventName;
    }

    static {
        PushTrackerType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static PushTrackerType valueOf(String str) {
        return (PushTrackerType) Enum.valueOf(PushTrackerType.class, str);
    }

    public static PushTrackerType[] values() {
        return (PushTrackerType[]) $VALUES.clone();
    }
}
