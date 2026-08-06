package com.bytedance.trae.conversation.devices;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceBindingPolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECT_BUTTON", "UNBOUND_DEVICE", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevicePairingTrigger {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DevicePairingTrigger[] $VALUES;
    public static final DevicePairingTrigger CONNECT_BUTTON = new DevicePairingTrigger("CONNECT_BUTTON", 0);
    public static final DevicePairingTrigger UNBOUND_DEVICE = new DevicePairingTrigger("UNBOUND_DEVICE", 1);

    private static final /* synthetic */ DevicePairingTrigger[] $values() {
        return new DevicePairingTrigger[]{CONNECT_BUTTON, UNBOUND_DEVICE};
    }

    public static EnumEntries<DevicePairingTrigger> getEntries() {
        return $ENTRIES;
    }

    private DevicePairingTrigger(String str, int i) {
    }

    static {
        DevicePairingTrigger[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static DevicePairingTrigger valueOf(String str) {
        return (DevicePairingTrigger) Enum.valueOf(DevicePairingTrigger.class, str);
    }

    public static DevicePairingTrigger[] values() {
        return (DevicePairingTrigger[]) $VALUES.clone();
    }
}
