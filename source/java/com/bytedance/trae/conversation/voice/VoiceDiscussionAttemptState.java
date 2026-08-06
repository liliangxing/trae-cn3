package com.bytedance.trae.conversation.voice;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceDiscussionAttemptTracker.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u0015\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003J\t\u0010/\u001a\u00020\u0012HÆ\u0003J\u007f\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00101\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0010HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00065"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;", "", "attemptId", "", "startedAtElapsedMs", "", "context", "Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;", "stageElapsedMs", "", "recordedSignals", "", "furthestStage", "latestSignal", "latestFailureReason", AccountMonitorConstants.CommonParameter.ERROR, "", "terminalReported", "", "<init>", "(Ljava/lang/String;JLcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;Ljava/util/Map;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getAttemptId", "()Ljava/lang/String;", "getStartedAtElapsedMs", "()J", "getContext", "()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;", "getStageElapsedMs", "()Ljava/util/Map;", "getRecordedSignals", "()Ljava/util/Set;", "getFurthestStage", "getLatestSignal", "getLatestFailureReason", "getErrorCode", "()I", "getTerminalReported", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class VoiceDiscussionAttemptState {
    private final String attemptId;
    private final VoiceDiscussionAttemptContext context;
    private final int errorCode;
    private final String furthestStage;
    private final String latestFailureReason;
    private final String latestSignal;
    private final Set<String> recordedSignals;
    private final Map<String, Long> stageElapsedMs;
    private final long startedAtElapsedMs;
    private final boolean terminalReported;

    /* renamed from: component1, reason: from getter */
    public final String getAttemptId() {
        return this.attemptId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getTerminalReported() {
        return this.terminalReported;
    }

    /* renamed from: component2, reason: from getter */
    public final long getStartedAtElapsedMs() {
        return this.startedAtElapsedMs;
    }

    /* renamed from: component3, reason: from getter */
    public final VoiceDiscussionAttemptContext getContext() {
        return this.context;
    }

    public final Map<String, Long> component4() {
        return this.stageElapsedMs;
    }

    public final Set<String> component5() {
        return this.recordedSignals;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFurthestStage() {
        return this.furthestStage;
    }

    /* renamed from: component7, reason: from getter */
    public final String getLatestSignal() {
        return this.latestSignal;
    }

    /* renamed from: component8, reason: from getter */
    public final String getLatestFailureReason() {
        return this.latestFailureReason;
    }

    /* renamed from: component9, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    public final VoiceDiscussionAttemptState copy(String attemptId, long startedAtElapsedMs, VoiceDiscussionAttemptContext context, Map<String, Long> stageElapsedMs, Set<String> recordedSignals, String furthestStage, String latestSignal, String latestFailureReason, int errorCode, boolean terminalReported) {
        Intrinsics.checkNotNullParameter(attemptId, "attemptId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(stageElapsedMs, "stageElapsedMs");
        Intrinsics.checkNotNullParameter(recordedSignals, "recordedSignals");
        Intrinsics.checkNotNullParameter(furthestStage, "furthestStage");
        Intrinsics.checkNotNullParameter(latestSignal, "latestSignal");
        Intrinsics.checkNotNullParameter(latestFailureReason, "latestFailureReason");
        return new VoiceDiscussionAttemptState(attemptId, startedAtElapsedMs, context, stageElapsedMs, recordedSignals, furthestStage, latestSignal, latestFailureReason, errorCode, terminalReported);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceDiscussionAttemptState)) {
            return false;
        }
        VoiceDiscussionAttemptState voiceDiscussionAttemptState = (VoiceDiscussionAttemptState) other;
        return Intrinsics.areEqual(this.attemptId, voiceDiscussionAttemptState.attemptId) && this.startedAtElapsedMs == voiceDiscussionAttemptState.startedAtElapsedMs && Intrinsics.areEqual(this.context, voiceDiscussionAttemptState.context) && Intrinsics.areEqual(this.stageElapsedMs, voiceDiscussionAttemptState.stageElapsedMs) && Intrinsics.areEqual(this.recordedSignals, voiceDiscussionAttemptState.recordedSignals) && Intrinsics.areEqual(this.furthestStage, voiceDiscussionAttemptState.furthestStage) && Intrinsics.areEqual(this.latestSignal, voiceDiscussionAttemptState.latestSignal) && Intrinsics.areEqual(this.latestFailureReason, voiceDiscussionAttemptState.latestFailureReason) && this.errorCode == voiceDiscussionAttemptState.errorCode && this.terminalReported == voiceDiscussionAttemptState.terminalReported;
    }

    public int hashCode() {
        return (((((((((((((((((this.attemptId.hashCode() * 31) + Long.hashCode(this.startedAtElapsedMs)) * 31) + this.context.hashCode()) * 31) + this.stageElapsedMs.hashCode()) * 31) + this.recordedSignals.hashCode()) * 31) + this.furthestStage.hashCode()) * 31) + this.latestSignal.hashCode()) * 31) + this.latestFailureReason.hashCode()) * 31) + Integer.hashCode(this.errorCode)) * 31) + Boolean.hashCode(this.terminalReported);
    }

    public String toString() {
        return "VoiceDiscussionAttemptState(attemptId=" + this.attemptId + ", startedAtElapsedMs=" + this.startedAtElapsedMs + ", context=" + this.context + ", stageElapsedMs=" + this.stageElapsedMs + ", recordedSignals=" + this.recordedSignals + ", furthestStage=" + this.furthestStage + ", latestSignal=" + this.latestSignal + ", latestFailureReason=" + this.latestFailureReason + ", errorCode=" + this.errorCode + ", terminalReported=" + this.terminalReported + ')';
    }

    public VoiceDiscussionAttemptState(String str, long j, VoiceDiscussionAttemptContext voiceDiscussionAttemptContext, Map<String, Long> map, Set<String> set, String str2, String str3, String str4, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "attemptId");
        Intrinsics.checkNotNullParameter(voiceDiscussionAttemptContext, "context");
        Intrinsics.checkNotNullParameter(map, "stageElapsedMs");
        Intrinsics.checkNotNullParameter(set, "recordedSignals");
        Intrinsics.checkNotNullParameter(str2, "furthestStage");
        Intrinsics.checkNotNullParameter(str3, "latestSignal");
        Intrinsics.checkNotNullParameter(str4, "latestFailureReason");
        this.attemptId = str;
        this.startedAtElapsedMs = j;
        this.context = voiceDiscussionAttemptContext;
        this.stageElapsedMs = map;
        this.recordedSignals = set;
        this.furthestStage = str2;
        this.latestSignal = str3;
        this.latestFailureReason = str4;
        this.errorCode = i;
        this.terminalReported = z;
    }

    public final String getAttemptId() {
        return this.attemptId;
    }

    public final long getStartedAtElapsedMs() {
        return this.startedAtElapsedMs;
    }

    public /* synthetic */ VoiceDiscussionAttemptState(String str, long j, VoiceDiscussionAttemptContext voiceDiscussionAttemptContext, Map map, Set set, String str2, String str3, String str4, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, (i2 & 4) != 0 ? new VoiceDiscussionAttemptContext(null, null, null, null, false, false, 63, null) : voiceDiscussionAttemptContext, (i2 & 8) != 0 ? MapsKt.emptyMap() : map, (i2 & 16) != 0 ? SetsKt.emptySet() : set, (i2 & 32) != 0 ? "" : str2, (i2 & 64) != 0 ? "" : str3, (i2 & 128) != 0 ? "" : str4, (i2 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? 0 : i, (i2 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? false : z);
    }

    public final VoiceDiscussionAttemptContext getContext() {
        return this.context;
    }

    public final Map<String, Long> getStageElapsedMs() {
        return this.stageElapsedMs;
    }

    public final Set<String> getRecordedSignals() {
        return this.recordedSignals;
    }

    public final String getFurthestStage() {
        return this.furthestStage;
    }

    public final String getLatestSignal() {
        return this.latestSignal;
    }

    public final String getLatestFailureReason() {
        return this.latestFailureReason;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final boolean getTerminalReported() {
        return this.terminalReported;
    }
}
