package com.bytedance.trae.conversation.tracker;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceEvents.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/DeviceTrackCliType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "REMOTE", "LOCAL", "LOCAL_IDE", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceTrackCliType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeviceTrackCliType[] $VALUES;
    private final String value;
    public static final DeviceTrackCliType REMOTE = new DeviceTrackCliType("REMOTE", 0, "remote");
    public static final DeviceTrackCliType LOCAL = new DeviceTrackCliType("LOCAL", 1, ImagesContract.LOCAL);
    public static final DeviceTrackCliType LOCAL_IDE = new DeviceTrackCliType("LOCAL_IDE", 2, "local_ide");

    private static final /* synthetic */ DeviceTrackCliType[] $values() {
        return new DeviceTrackCliType[]{REMOTE, LOCAL, LOCAL_IDE};
    }

    public static EnumEntries<DeviceTrackCliType> getEntries() {
        return $ENTRIES;
    }

    private DeviceTrackCliType(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        DeviceTrackCliType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static DeviceTrackCliType valueOf(String str) {
        return (DeviceTrackCliType) Enum.valueOf(DeviceTrackCliType.class, str);
    }

    public static DeviceTrackCliType[] values() {
        return (DeviceTrackCliType[]) $VALUES.clone();
    }
}
