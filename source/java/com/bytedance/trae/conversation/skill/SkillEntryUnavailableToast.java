package com.bytedance.trae.conversation.skill;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SkillEntryPolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;", "", "<init>", "(Ljava/lang/String;I)V", "DEVICE_OFFLINE", "WORKSPACE_CLOSED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SkillEntryUnavailableToast {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SkillEntryUnavailableToast[] $VALUES;
    public static final SkillEntryUnavailableToast DEVICE_OFFLINE = new SkillEntryUnavailableToast("DEVICE_OFFLINE", 0);
    public static final SkillEntryUnavailableToast WORKSPACE_CLOSED = new SkillEntryUnavailableToast("WORKSPACE_CLOSED", 1);

    private static final /* synthetic */ SkillEntryUnavailableToast[] $values() {
        return new SkillEntryUnavailableToast[]{DEVICE_OFFLINE, WORKSPACE_CLOSED};
    }

    public static EnumEntries<SkillEntryUnavailableToast> getEntries() {
        return $ENTRIES;
    }

    private SkillEntryUnavailableToast(String str, int i) {
    }

    static {
        SkillEntryUnavailableToast[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SkillEntryUnavailableToast valueOf(String str) {
        return (SkillEntryUnavailableToast) Enum.valueOf(SkillEntryUnavailableToast.class, str);
    }

    public static SkillEntryUnavailableToast[] values() {
        return (SkillEntryUnavailableToast[]) $VALUES.clone();
    }
}
