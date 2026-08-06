package com.bytedance.trae.conversation.brainstorm.health;

import android.content.Context;
import android.media.AudioManager;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.trae.conversation.brainstorm.health.OutputVolumeMuteDetector;
import com.bytedance.trae.conversation.brainstorm.health.RtcLowAudioDetector;
import com.bytedance.trae.conversation.brainstorm.health.VoicePrompt;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState;
import com.bytedance.trae.conversation.brainstorm.model.ParticipantState;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceHealthMonitor.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 52\u00020\u0001:\u00015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u0010J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020 J \u0010%\u001a\u0004\u0018\u00010\u00122\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010)\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001b\u0010/\u001a\u0004\u0018\u00010'*\u0002002\u0006\u00101\u001a\u00020'H\u0002¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0002J\b\u00104\u001a\u00020\u000eH\u0002R\u0018\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "lowAudioDetector", "Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;", "outputVolumeDetector", "Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;", "isAiListening", "", "lastUserSubtitleAtMs", "", "checkPreflight", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;", "trigger", "Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;", "setAiListening", "", "listening", "resetRuntime", "resetOutputVolume", "markUserSubtitle", "timestampMs", "onRtcAudioProperties", "properties", "Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;", "uiState", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;", "onRtcNetworkQuality", "", "local", "Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;", "onRtcAudioInputDeviceStateChanged", "state", "", "error", "onOutputVolumeCheck", "canCheckLowAudio", "canCheckOutputVolume", "readOutputVolumeSnapshot", "Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;", "hasSystemAudioProblem", "safeStreamVolume", "Landroid/media/AudioManager;", "stream", "(Landroid/media/AudioManager;I)Ljava/lang/Integer;", "isWeakRtcNetwork", "isMicPermissionGranted", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceHealthMonitor {
    private static final double RTC_WEAK_NETWORK_LOSS_RATE = 0.2d;
    private static final int RTC_WEAK_NETWORK_RTT_MS = 800;
    private static final String TAG = "VoiceHealthMonitor";
    private final Context appContext;
    private boolean isAiListening;
    private long lastUserSubtitleAtMs;
    private final RtcLowAudioDetector lowAudioDetector;
    private final OutputVolumeMuteDetector outputVolumeDetector;

    public VoiceHealthMonitor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.appContext = context.getApplicationContext();
        this.lowAudioDetector = new RtcLowAudioDetector();
        this.outputVolumeDetector = new OutputVolumeMuteDetector();
    }

    public final VoicePrompt.Health checkPreflight(VoiceCheckTrigger trigger) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        if (!trigger.getCheckPermission() || isMicPermissionGranted()) {
            return null;
        }
        return VoicePrompt.Health.MicPermissionDenied.INSTANCE;
    }

    public final void setAiListening(boolean listening) {
        this.isAiListening = listening;
        if (listening) {
            return;
        }
        this.lowAudioDetector.reset();
    }

    public final void resetRuntime() {
        this.isAiListening = false;
        this.lowAudioDetector.reset();
        this.outputVolumeDetector.reset();
    }

    public final void resetOutputVolume() {
        this.outputVolumeDetector.reset();
    }

    public static /* synthetic */ void markUserSubtitle$default(VoiceHealthMonitor voiceHealthMonitor, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = System.currentTimeMillis();
        }
        voiceHealthMonitor.markUserSubtitle(j);
    }

    public final void markUserSubtitle(long timestampMs) {
        this.lastUserSubtitleAtMs = timestampMs;
    }

    public final VoicePrompt.Health onRtcAudioProperties(VolcRtcClient.RtcLocalAudioProperties properties, BrainstormUiState uiState) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        if (!canCheckLowAudio(uiState)) {
            this.lowAudioDetector.reset();
            return null;
        }
        boolean z = System.currentTimeMillis() - this.lastUserSubtitleAtMs <= RtcLowAudioDetector.ASR_FALLBACK_MS;
        RtcLowAudioDetector.Evaluation onAudioSample = this.lowAudioDetector.onAudioSample(properties.getLinearVolume(), properties.getVad(), properties.getTimestampMs(), z);
        if (onAudioSample == null) {
            return null;
        }
        if (onAudioSample.getWindowHit() || onAudioSample.getConfirmed()) {
            FLogger.INSTANCE.i(TAG, "low_audio_eval confirmed=" + onAudioSample.getConfirmed() + ", windowHit=" + onAudioSample.getWindowHit() + ", hitCount=" + onAudioSample.getHitCount() + ", avgVolume=" + onAudioSample.getAvgVolume() + ", maxVolume=" + onAudioSample.getMaxVolume() + ", voicedSize=" + onAudioSample.getVoicedSize() + ", totalSize=" + onAudioSample.getTotalSize() + ", lowRatio=" + onAudioSample.getLowRatio() + ", recentUserSubtitle=" + z + ", aiState=" + uiState.getAiParticipantState());
        }
        if (onAudioSample.getConfirmed()) {
            return VoicePrompt.Health.LowAudioInput.INSTANCE;
        }
        return null;
    }

    public final List<VoicePrompt.Health> onRtcNetworkQuality(VolcRtcClient.RtcNetworkQuality local, BrainstormUiState uiState) {
        Intrinsics.checkNotNullParameter(local, "local");
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        if (!uiState.isRtcJoined()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        if (isWeakRtcNetwork(local)) {
            arrayList.add(VoicePrompt.Health.WeakNetwork.INSTANCE);
        }
        if (hasSystemAudioProblem(uiState)) {
            arrayList.add(VoicePrompt.Health.LowAudioInput.INSTANCE);
        }
        return arrayList;
    }

    public final VoicePrompt.Health onRtcAudioInputDeviceStateChanged(int state, int error, BrainstormUiState uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        if (!uiState.isRtcJoined()) {
            return null;
        }
        if (error != 0 || state == 3) {
            return VoicePrompt.Health.LowAudioInput.INSTANCE;
        }
        return null;
    }

    public final VoicePrompt.Health onOutputVolumeCheck(BrainstormUiState uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        OutputVolumeMuteDetector.Evaluation evaluate = this.outputVolumeDetector.evaluate(canCheckOutputVolume(uiState), readOutputVolumeSnapshot(uiState));
        if (evaluate.getCheckHit() || evaluate.getConfirmed()) {
            FLogger.INSTANCE.i(TAG, "output_volume_eval confirmed=" + evaluate.getConfirmed() + ", checkHit=" + evaluate.getCheckHit() + ", hitCount=" + evaluate.getHitCount() + ", device=" + evaluate.getAudioDevice() + ", inCommunication=" + evaluate.isInCommunicationMode() + ", musicVolume=" + evaluate.getMusicVolume() + ", voiceCallVolume=" + evaluate.getVoiceCallVolume() + ", aiState=" + uiState.getAiParticipantState());
        }
        if (evaluate.getConfirmed()) {
            return VoicePrompt.Health.OutputVolumeMuted.INSTANCE;
        }
        return null;
    }

    private final boolean canCheckLowAudio(BrainstormUiState uiState) {
        return (!this.isAiListening || !uiState.isRtcJoined() || uiState.isMicMuted() || uiState.getAiParticipantState() == ParticipantState.Speaking || uiState.getAiParticipantState() == ParticipantState.Thinking) ? false : true;
    }

    private final boolean canCheckOutputVolume(BrainstormUiState uiState) {
        return uiState.isRtcJoined() && uiState.getAiParticipantState() == ParticipantState.Speaking;
    }

    private final OutputVolumeMuteDetector.Snapshot readOutputVolumeSnapshot(BrainstormUiState uiState) {
        Object systemService = this.appContext.getSystemService(FConstants.URI_AUDIO);
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        return new OutputVolumeMuteDetector.Snapshot(uiState.getCurrentAudioDevice(), audioManager != null && audioManager.getMode() == 3, audioManager != null ? safeStreamVolume(audioManager, 3) : null, audioManager != null ? safeStreamVolume(audioManager, 0) : null);
    }

    private final boolean hasSystemAudioProblem(BrainstormUiState uiState) {
        if (!uiState.isRtcJoined()) {
            return false;
        }
        Object systemService = this.appContext.getSystemService(FConstants.URI_AUDIO);
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        return (audioManager == null || uiState.isMicMuted() || !audioManager.isMicrophoneMute()) ? false : true;
    }

    private final Integer safeStreamVolume(AudioManager audioManager, int i) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Integer.valueOf(audioManager.getStreamVolume(i)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (Integer) obj;
    }

    private final boolean isWeakRtcNetwork(VolcRtcClient.RtcNetworkQuality local) {
        return local.getTxQuality() >= 4 || local.getRxQuality() >= 4 || local.getTxQuality() == 6 || local.getRxQuality() == 6 || local.getFractionLost() >= RTC_WEAK_NETWORK_LOSS_RATE || local.getRtt() >= RTC_WEAK_NETWORK_RTT_MS;
    }

    private final boolean isMicPermissionGranted() {
        return ContextCompat.checkSelfPermission(this.appContext, "android.permission.RECORD_AUDIO") == 0;
    }
}
