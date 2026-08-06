package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.conversation.R;
import com.bytedance.trae.network.DebugSettings;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceStatusLabelPolicy.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;", "", "textRes", "", "<init>", "(Ljava/lang/String;II)V", "getTextRes", "()I", DebugSettings.ENTERPRISE_ENV_ONLINE, "OFFLINE", "UNPAIRED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceStatusLabel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeviceStatusLabel[] $VALUES;
    private final int textRes;
    public static final DeviceStatusLabel ONLINE = new DeviceStatusLabel(DebugSettings.ENTERPRISE_ENV_ONLINE, 0, R.string.trae_device_status_online);
    public static final DeviceStatusLabel OFFLINE = new DeviceStatusLabel("OFFLINE", 1, R.string.trae_device_status_offline);
    public static final DeviceStatusLabel UNPAIRED = new DeviceStatusLabel("UNPAIRED", 2, R.string.trae_device_status_unpaired);

    private static final /* synthetic */ DeviceStatusLabel[] $values() {
        return new DeviceStatusLabel[]{ONLINE, OFFLINE, UNPAIRED};
    }

    public static EnumEntries<DeviceStatusLabel> getEntries() {
        return $ENTRIES;
    }

    private DeviceStatusLabel(String str, int i, int i2) {
        this.textRes = i2;
    }

    public final int getTextRes() {
        return this.textRes;
    }

    static {
        DeviceStatusLabel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static DeviceStatusLabel valueOf(String str) {
        return (DeviceStatusLabel) Enum.valueOf(DeviceStatusLabel.class, str);
    }

    public static DeviceStatusLabel[] values() {
        return (DeviceStatusLabel[]) $VALUES.clone();
    }
}
