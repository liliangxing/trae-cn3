package com.bytedance.trae.conversation.devices.flow;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceFlowBackPolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackAction;", "", "<init>", "(Ljava/lang/String;I)V", "PopRoute", "CloseFlow", "Defer", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceFlowBackAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeviceFlowBackAction[] $VALUES;
    public static final DeviceFlowBackAction PopRoute = new DeviceFlowBackAction("PopRoute", 0);
    public static final DeviceFlowBackAction CloseFlow = new DeviceFlowBackAction("CloseFlow", 1);
    public static final DeviceFlowBackAction Defer = new DeviceFlowBackAction("Defer", 2);

    private static final /* synthetic */ DeviceFlowBackAction[] $values() {
        return new DeviceFlowBackAction[]{PopRoute, CloseFlow, Defer};
    }

    public static EnumEntries<DeviceFlowBackAction> getEntries() {
        return $ENTRIES;
    }

    private DeviceFlowBackAction(String str, int i) {
    }

    static {
        DeviceFlowBackAction[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static DeviceFlowBackAction valueOf(String str) {
        return (DeviceFlowBackAction) Enum.valueOf(DeviceFlowBackAction.class, str);
    }

    public static DeviceFlowBackAction[] values() {
        return (DeviceFlowBackAction[]) $VALUES.clone();
    }
}
