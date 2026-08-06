package com.bytedance.trae.conversation.tracker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceEvents.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "STEP2_COMPLETE", "STEP1_COMPLETE", "STEP1_INCOMPLETE", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevicePairResultDetail {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DevicePairResultDetail[] $VALUES;
    private final String value;
    public static final DevicePairResultDetail STEP2_COMPLETE = new DevicePairResultDetail("STEP2_COMPLETE", 0, "step2_complete");
    public static final DevicePairResultDetail STEP1_COMPLETE = new DevicePairResultDetail("STEP1_COMPLETE", 1, "step1_complete");
    public static final DevicePairResultDetail STEP1_INCOMPLETE = new DevicePairResultDetail("STEP1_INCOMPLETE", 2, "step1_incomplete");

    private static final /* synthetic */ DevicePairResultDetail[] $values() {
        return new DevicePairResultDetail[]{STEP2_COMPLETE, STEP1_COMPLETE, STEP1_INCOMPLETE};
    }

    public static EnumEntries<DevicePairResultDetail> getEntries() {
        return $ENTRIES;
    }

    private DevicePairResultDetail(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        DevicePairResultDetail[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static DevicePairResultDetail valueOf(String str) {
        return (DevicePairResultDetail) Enum.valueOf(DevicePairResultDetail.class, str);
    }

    public static DevicePairResultDetail[] values() {
        return (DevicePairResultDetail[]) $VALUES.clone();
    }
}
