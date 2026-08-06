package com.bytedance.trae.conversation.devices.newfeature;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: NewFeaturePromptPolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntry;", "", "<init>", "(Ljava/lang/String;I)V", "NEW_CHAT", "TASK_LIST", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewFeaturePromptEntry {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NewFeaturePromptEntry[] $VALUES;
    public static final NewFeaturePromptEntry NEW_CHAT = new NewFeaturePromptEntry("NEW_CHAT", 0);
    public static final NewFeaturePromptEntry TASK_LIST = new NewFeaturePromptEntry("TASK_LIST", 1);

    private static final /* synthetic */ NewFeaturePromptEntry[] $values() {
        return new NewFeaturePromptEntry[]{NEW_CHAT, TASK_LIST};
    }

    public static EnumEntries<NewFeaturePromptEntry> getEntries() {
        return $ENTRIES;
    }

    private NewFeaturePromptEntry(String str, int i) {
    }

    static {
        NewFeaturePromptEntry[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static NewFeaturePromptEntry valueOf(String str) {
        return (NewFeaturePromptEntry) Enum.valueOf(NewFeaturePromptEntry.class, str);
    }

    public static NewFeaturePromptEntry[] values() {
        return (NewFeaturePromptEntry[]) $VALUES.clone();
    }
}
