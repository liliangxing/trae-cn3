package com.bytedance.trae.home.solo.setting.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceManagementViewModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;", "", "<init>", "(Ljava/lang/String;I)V", "LongPress", "Swipe", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceManagementMenuSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeviceManagementMenuSource[] $VALUES;
    public static final DeviceManagementMenuSource LongPress = new DeviceManagementMenuSource("LongPress", 0);
    public static final DeviceManagementMenuSource Swipe = new DeviceManagementMenuSource("Swipe", 1);

    private static final /* synthetic */ DeviceManagementMenuSource[] $values() {
        return new DeviceManagementMenuSource[]{LongPress, Swipe};
    }

    public static EnumEntries<DeviceManagementMenuSource> getEntries() {
        return $ENTRIES;
    }

    private DeviceManagementMenuSource(String str, int i) {
    }

    static {
        DeviceManagementMenuSource[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static DeviceManagementMenuSource valueOf(String str) {
        return (DeviceManagementMenuSource) Enum.valueOf(DeviceManagementMenuSource.class, str);
    }

    public static DeviceManagementMenuSource[] values() {
        return (DeviceManagementMenuSource[]) $VALUES.clone();
    }
}
