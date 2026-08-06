package com.bytedance.trae.conversation.tracker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceEvents.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/DeviceRegisterStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "REGISTERED", "UNREGISTERED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceRegisterStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeviceRegisterStatus[] $VALUES;
    public static final DeviceRegisterStatus REGISTERED = new DeviceRegisterStatus("REGISTERED", 0, "registered");
    public static final DeviceRegisterStatus UNREGISTERED = new DeviceRegisterStatus("UNREGISTERED", 1, "unregistered");
    private final String value;

    private static final /* synthetic */ DeviceRegisterStatus[] $values() {
        return new DeviceRegisterStatus[]{REGISTERED, UNREGISTERED};
    }

    public static EnumEntries<DeviceRegisterStatus> getEntries() {
        return $ENTRIES;
    }

    private DeviceRegisterStatus(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        DeviceRegisterStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static DeviceRegisterStatus valueOf(String str) {
        return (DeviceRegisterStatus) Enum.valueOf(DeviceRegisterStatus.class, str);
    }

    public static DeviceRegisterStatus[] values() {
        return (DeviceRegisterStatus[]) $VALUES.clone();
    }
}
