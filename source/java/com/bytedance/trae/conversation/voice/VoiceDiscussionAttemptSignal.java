package com.bytedance.trae.conversation.voice;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: VoiceDiscussionAttemptTracker.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PERMISSION_DENIED", "HEALTH_CHECK_BLOCKED", "START_API_FAILED", "RTC_ERROR", "CONVERSATION_ERROR", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VoiceDiscussionAttemptSignal {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VoiceDiscussionAttemptSignal[] $VALUES;
    private final String value;
    public static final VoiceDiscussionAttemptSignal PERMISSION_DENIED = new VoiceDiscussionAttemptSignal("PERMISSION_DENIED", 0, "permission_denied");
    public static final VoiceDiscussionAttemptSignal HEALTH_CHECK_BLOCKED = new VoiceDiscussionAttemptSignal("HEALTH_CHECK_BLOCKED", 1, "health_check_blocked");
    public static final VoiceDiscussionAttemptSignal START_API_FAILED = new VoiceDiscussionAttemptSignal("START_API_FAILED", 2, "start_api_failed");
    public static final VoiceDiscussionAttemptSignal RTC_ERROR = new VoiceDiscussionAttemptSignal("RTC_ERROR", 3, "rtc_error");
    public static final VoiceDiscussionAttemptSignal CONVERSATION_ERROR = new VoiceDiscussionAttemptSignal("CONVERSATION_ERROR", 4, "conversation_error");

    private static final /* synthetic */ VoiceDiscussionAttemptSignal[] $values() {
        return new VoiceDiscussionAttemptSignal[]{PERMISSION_DENIED, HEALTH_CHECK_BLOCKED, START_API_FAILED, RTC_ERROR, CONVERSATION_ERROR};
    }

    public static EnumEntries<VoiceDiscussionAttemptSignal> getEntries() {
        return $ENTRIES;
    }

    private VoiceDiscussionAttemptSignal(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        VoiceDiscussionAttemptSignal[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static VoiceDiscussionAttemptSignal valueOf(String str) {
        return (VoiceDiscussionAttemptSignal) Enum.valueOf(VoiceDiscussionAttemptSignal.class, str);
    }

    public static VoiceDiscussionAttemptSignal[] values() {
        return (VoiceDiscussionAttemptSignal[]) $VALUES.clone();
    }
}
