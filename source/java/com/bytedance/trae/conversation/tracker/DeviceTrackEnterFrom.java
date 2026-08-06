package com.bytedance.trae.conversation.tracker;

import com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceEvents.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NEW_FEATURE_PROMPT", "DEVICE_PICKER", "SETTINGS", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceTrackEnterFrom {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeviceTrackEnterFrom[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String value;
    public static final DeviceTrackEnterFrom NEW_FEATURE_PROMPT = new DeviceTrackEnterFrom("NEW_FEATURE_PROMPT", 0, "new_feature_prompt");
    public static final DeviceTrackEnterFrom DEVICE_PICKER = new DeviceTrackEnterFrom("DEVICE_PICKER", 1, "device_picker");
    public static final DeviceTrackEnterFrom SETTINGS = new DeviceTrackEnterFrom("SETTINGS", 2, "settings");

    private static final /* synthetic */ DeviceTrackEnterFrom[] $values() {
        return new DeviceTrackEnterFrom[]{NEW_FEATURE_PROMPT, DEVICE_PICKER, SETTINGS};
    }

    public static EnumEntries<DeviceTrackEnterFrom> getEntries() {
        return $ENTRIES;
    }

    private DeviceTrackEnterFrom(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        DeviceTrackEnterFrom[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: DeviceEvents.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;", "", "<init>", "()V", "from", "Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;", "value", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceTrackEnterFrom from(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, DeviceTrackEnterFrom.NEW_FEATURE_PROMPT.getValue()) || Intrinsics.areEqual(value, ConnectComputerGuideFragment.ENTER_FROM_NEW_FEATURE_POPUP)) {
                return DeviceTrackEnterFrom.NEW_FEATURE_PROMPT;
            }
            if (Intrinsics.areEqual(value, DeviceTrackEnterFrom.DEVICE_PICKER.getValue()) || Intrinsics.areEqual(value, ConnectComputerGuideFragment.ENTER_FROM_DEVICE_LIST) || Intrinsics.areEqual(value, ConnectComputerGuideFragment.ENTER_FROM_CODE_ADD_DEVICE) || Intrinsics.areEqual(value, ConnectComputerGuideFragment.ENTER_FROM_NEW_TASK)) {
                return DeviceTrackEnterFrom.DEVICE_PICKER;
            }
            if (Intrinsics.areEqual(value, DeviceTrackEnterFrom.SETTINGS.getValue()) || Intrinsics.areEqual(value, ConnectComputerGuideFragment.ENTER_FROM_SETTINGS_DEVICE_MANAGEMENT)) {
                return DeviceTrackEnterFrom.SETTINGS;
            }
            return null;
        }
    }

    public static DeviceTrackEnterFrom valueOf(String str) {
        return (DeviceTrackEnterFrom) Enum.valueOf(DeviceTrackEnterFrom.class, str);
    }

    public static DeviceTrackEnterFrom[] values() {
        return (DeviceTrackEnterFrom[]) $VALUES.clone();
    }
}
