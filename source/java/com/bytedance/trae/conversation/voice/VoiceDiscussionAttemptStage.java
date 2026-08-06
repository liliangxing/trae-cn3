package com.bytedance.trae.conversation.voice;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: VoiceDiscussionAttemptTracker.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;", "", "value", "", "order", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getValue", "()Ljava/lang/String;", "getOrder$conversation_mainlandRelease", "()I", "CLICK", "ELIGIBILITY_PASSED", "ACTIVITY_LAUNCH_REQUESTED", "ACTIVITY_SHOWN", "PERMISSION_GRANTED", "INTRO_SHOWN", "DISCUSSION_STARTED", "RECORDING_STARTED", "RTC_JOINED", "FIRST_VOICE_DETECTED", "USER_FINAL_RECEIVED", "THINKING_RECEIVED", "ROUND_REPORTED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VoiceDiscussionAttemptStage {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VoiceDiscussionAttemptStage[] $VALUES;
    private final int order;
    private final String value;
    public static final VoiceDiscussionAttemptStage CLICK = new VoiceDiscussionAttemptStage("CLICK", 0, "click", 0);
    public static final VoiceDiscussionAttemptStage ELIGIBILITY_PASSED = new VoiceDiscussionAttemptStage("ELIGIBILITY_PASSED", 1, "eligibility_passed", 10);
    public static final VoiceDiscussionAttemptStage ACTIVITY_LAUNCH_REQUESTED = new VoiceDiscussionAttemptStage("ACTIVITY_LAUNCH_REQUESTED", 2, "activity_launch_requested", 20);
    public static final VoiceDiscussionAttemptStage ACTIVITY_SHOWN = new VoiceDiscussionAttemptStage("ACTIVITY_SHOWN", 3, "activity_shown", 30);
    public static final VoiceDiscussionAttemptStage PERMISSION_GRANTED = new VoiceDiscussionAttemptStage("PERMISSION_GRANTED", 4, "permission_granted", 40);
    public static final VoiceDiscussionAttemptStage INTRO_SHOWN = new VoiceDiscussionAttemptStage("INTRO_SHOWN", 5, "intro_shown", 50);
    public static final VoiceDiscussionAttemptStage DISCUSSION_STARTED = new VoiceDiscussionAttemptStage("DISCUSSION_STARTED", 6, "discussion_started", 60);
    public static final VoiceDiscussionAttemptStage RECORDING_STARTED = new VoiceDiscussionAttemptStage("RECORDING_STARTED", 7, "recording_started", 70);
    public static final VoiceDiscussionAttemptStage RTC_JOINED = new VoiceDiscussionAttemptStage("RTC_JOINED", 8, "rtc_joined", 80);
    public static final VoiceDiscussionAttemptStage FIRST_VOICE_DETECTED = new VoiceDiscussionAttemptStage("FIRST_VOICE_DETECTED", 9, "first_voice_detected", 90);
    public static final VoiceDiscussionAttemptStage USER_FINAL_RECEIVED = new VoiceDiscussionAttemptStage("USER_FINAL_RECEIVED", 10, "user_final_received", 100);
    public static final VoiceDiscussionAttemptStage THINKING_RECEIVED = new VoiceDiscussionAttemptStage("THINKING_RECEIVED", 11, "thinking_received", 110);
    public static final VoiceDiscussionAttemptStage ROUND_REPORTED = new VoiceDiscussionAttemptStage("ROUND_REPORTED", 12, "round_reported", 120);

    private static final /* synthetic */ VoiceDiscussionAttemptStage[] $values() {
        return new VoiceDiscussionAttemptStage[]{CLICK, ELIGIBILITY_PASSED, ACTIVITY_LAUNCH_REQUESTED, ACTIVITY_SHOWN, PERMISSION_GRANTED, INTRO_SHOWN, DISCUSSION_STARTED, RECORDING_STARTED, RTC_JOINED, FIRST_VOICE_DETECTED, USER_FINAL_RECEIVED, THINKING_RECEIVED, ROUND_REPORTED};
    }

    public static EnumEntries<VoiceDiscussionAttemptStage> getEntries() {
        return $ENTRIES;
    }

    private VoiceDiscussionAttemptStage(String str, int i, String str2, int i2) {
        this.value = str2;
        this.order = i2;
    }

    /* renamed from: getOrder$conversation_mainlandRelease, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        VoiceDiscussionAttemptStage[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static VoiceDiscussionAttemptStage valueOf(String str) {
        return (VoiceDiscussionAttemptStage) Enum.valueOf(VoiceDiscussionAttemptStage.class, str);
    }

    public static VoiceDiscussionAttemptStage[] values() {
        return (VoiceDiscussionAttemptStage[]) $VALUES.clone();
    }
}
