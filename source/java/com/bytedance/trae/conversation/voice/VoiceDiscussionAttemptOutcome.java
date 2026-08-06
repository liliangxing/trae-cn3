package com.bytedance.trae.conversation.voice;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: VoiceDiscussionAttemptTracker.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SUCCESS", "BLOCKED_IDE_VERSION", "PERMISSION_DENIED", "HEALTH_CHECK_BLOCKED", "PREREQUISITE_FAILED", "ACTIVITY_NOT_SHOWN", "ACTIVITY_ABANDON", "INTRO_ABANDON", "START_API_FAILED", "RTC_JOIN_FAILED", "RTC_RUNTIME_ERROR", "CONVERSATION_ERROR", "START_ABANDON", "JOINED_NO_SPEECH", "SPEECH_NO_THINKING", "ROUND_NOT_FINALIZED", "UNKNOWN", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VoiceDiscussionAttemptOutcome {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VoiceDiscussionAttemptOutcome[] $VALUES;
    private final String value;
    public static final VoiceDiscussionAttemptOutcome SUCCESS = new VoiceDiscussionAttemptOutcome("SUCCESS", 0, "success");
    public static final VoiceDiscussionAttemptOutcome BLOCKED_IDE_VERSION = new VoiceDiscussionAttemptOutcome("BLOCKED_IDE_VERSION", 1, "blocked_ide_version");
    public static final VoiceDiscussionAttemptOutcome PERMISSION_DENIED = new VoiceDiscussionAttemptOutcome("PERMISSION_DENIED", 2, "permission_denied");
    public static final VoiceDiscussionAttemptOutcome HEALTH_CHECK_BLOCKED = new VoiceDiscussionAttemptOutcome("HEALTH_CHECK_BLOCKED", 3, "health_check_blocked");
    public static final VoiceDiscussionAttemptOutcome PREREQUISITE_FAILED = new VoiceDiscussionAttemptOutcome("PREREQUISITE_FAILED", 4, "prerequisite_failed");
    public static final VoiceDiscussionAttemptOutcome ACTIVITY_NOT_SHOWN = new VoiceDiscussionAttemptOutcome("ACTIVITY_NOT_SHOWN", 5, "activity_not_shown");
    public static final VoiceDiscussionAttemptOutcome ACTIVITY_ABANDON = new VoiceDiscussionAttemptOutcome("ACTIVITY_ABANDON", 6, "activity_abandon");
    public static final VoiceDiscussionAttemptOutcome INTRO_ABANDON = new VoiceDiscussionAttemptOutcome("INTRO_ABANDON", 7, "intro_abandon");
    public static final VoiceDiscussionAttemptOutcome START_API_FAILED = new VoiceDiscussionAttemptOutcome("START_API_FAILED", 8, "start_api_failed");
    public static final VoiceDiscussionAttemptOutcome RTC_JOIN_FAILED = new VoiceDiscussionAttemptOutcome("RTC_JOIN_FAILED", 9, "rtc_join_failed");
    public static final VoiceDiscussionAttemptOutcome RTC_RUNTIME_ERROR = new VoiceDiscussionAttemptOutcome("RTC_RUNTIME_ERROR", 10, "rtc_runtime_error");
    public static final VoiceDiscussionAttemptOutcome CONVERSATION_ERROR = new VoiceDiscussionAttemptOutcome("CONVERSATION_ERROR", 11, "conversation_error");
    public static final VoiceDiscussionAttemptOutcome START_ABANDON = new VoiceDiscussionAttemptOutcome("START_ABANDON", 12, "start_abandon");
    public static final VoiceDiscussionAttemptOutcome JOINED_NO_SPEECH = new VoiceDiscussionAttemptOutcome("JOINED_NO_SPEECH", 13, "joined_no_speech");
    public static final VoiceDiscussionAttemptOutcome SPEECH_NO_THINKING = new VoiceDiscussionAttemptOutcome("SPEECH_NO_THINKING", 14, "speech_no_thinking");
    public static final VoiceDiscussionAttemptOutcome ROUND_NOT_FINALIZED = new VoiceDiscussionAttemptOutcome("ROUND_NOT_FINALIZED", 15, "round_not_finalized");
    public static final VoiceDiscussionAttemptOutcome UNKNOWN = new VoiceDiscussionAttemptOutcome("UNKNOWN", 16, "unknown");

    private static final /* synthetic */ VoiceDiscussionAttemptOutcome[] $values() {
        return new VoiceDiscussionAttemptOutcome[]{SUCCESS, BLOCKED_IDE_VERSION, PERMISSION_DENIED, HEALTH_CHECK_BLOCKED, PREREQUISITE_FAILED, ACTIVITY_NOT_SHOWN, ACTIVITY_ABANDON, INTRO_ABANDON, START_API_FAILED, RTC_JOIN_FAILED, RTC_RUNTIME_ERROR, CONVERSATION_ERROR, START_ABANDON, JOINED_NO_SPEECH, SPEECH_NO_THINKING, ROUND_NOT_FINALIZED, UNKNOWN};
    }

    public static EnumEntries<VoiceDiscussionAttemptOutcome> getEntries() {
        return $ENTRIES;
    }

    private VoiceDiscussionAttemptOutcome(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        VoiceDiscussionAttemptOutcome[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static VoiceDiscussionAttemptOutcome valueOf(String str) {
        return (VoiceDiscussionAttemptOutcome) Enum.valueOf(VoiceDiscussionAttemptOutcome.class, str);
    }

    public static VoiceDiscussionAttemptOutcome[] values() {
        return (VoiceDiscussionAttemptOutcome[]) $VALUES.clone();
    }
}
