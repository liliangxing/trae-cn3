package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager;
import com.bytedance.trae.conversation.brainstorm.audio.AudioDeviceManager;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormMessageKt;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormSummaryEligibilityKt;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState;
import com.bytedance.trae.conversation.brainstorm.model.MessageRole;
import com.bytedance.trae.conversation.brainstorm.model.ParsedSubTaskTag;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptContext;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker;
import com.bytedance.trae.conversation.voice.VoiceDiscussionMetrics;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.bytedance.trae.conversation.voice.subtask.SubTaskUiState;
import com.bytedance.trae.conversation.voice.subtask.ToolResultMessage;
import com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Mode;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: BrainstormSessionHolder.kt */
@Metadata(d1 = {"\u0000Ç\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001D\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001oB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u00052\b\b\u0002\u0010J\u001a\u00020\u0005H\u0002J\u0016\u0010K\u001a\u00020G2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u0005J\u0010\u0010N\u001a\u00020G2\u0006\u0010O\u001a\u00020PH\u0002J\u001f\u0010Q\u001a\u00020\u00102\u0006\u0010R\u001a\u00020S2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\bTJ\u0015\u0010U\u001a\u00020\u00102\u0006\u0010R\u001a\u00020SH\u0000¢\u0006\u0002\bVJ\u0006\u0010W\u001a\u00020GJ\u0018\u0010X\u001a\u00020G2\u0006\u0010J\u001a\u00020YH\u0080@¢\u0006\u0004\bZ\u0010[J\u0006\u0010\\\u001a\u00020GJ\u0010\u0010]\u001a\u00020G2\u0006\u0010^\u001a\u00020\u0007H\u0002J\b\u0010_\u001a\u00020GH\u0002J\u001c\u0010`\u001a\u00020G2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020G0bH\u0002J\u0010\u0010d\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u0007H\u0002J\u0018\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u00052\u0006\u0010i\u001a\u00020jH\u0002J\u0010\u0010k\u001a\u00020G2\u0006\u0010l\u001a\u00020BH\u0002J\b\u0010m\u001a\u00020GH\u0002J\b\u0010n\u001a\u00020GH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000eR\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020)0!¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020B0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010E¨\u0006p"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;", "", "<init>", "()V", "TAG", "", "TIMER_TICK_MS", "", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "isActive", "", "()Z", "isMinimized", "value", "ownerConversationId", "getOwnerConversationId", "()Ljava/lang/String;", "cliConversationId", "getCliConversationId", "isMicMuted", "_elapsedMs", "elapsedMs", "getElapsedMs", "_localAudioVolume", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "localAudioVolume", "Lkotlinx/coroutines/flow/SharedFlow;", "getLocalAudioVolume", "()Lkotlinx/coroutines/flow/SharedFlow;", "_subtitleHistorySize", "", "subtitleHistorySize", "getSubtitleHistorySize", "_ended", "Lcom/bytedance/trae/conversation/brainstorm/HolderEndData;", "ended", "getEnded", "holderScope", "Lkotlinx/coroutines/CoroutineScope;", "voiceChatSession", "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;", "getVoiceChatSession$conversation_mainlandRelease", "()Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;", "setVoiceChatSession$conversation_mainlandRelease", "(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)V", "audioDeviceManager", "Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;", "getAudioDeviceManager$conversation_mainlandRelease", "()Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;", "setAudioDeviceManager$conversation_mainlandRelease", "(Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;)V", "currentSnapshot", "Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;", "voiceDiscussionAttemptLock", "timerJob", "Lkotlinx/coroutines/Job;", "subTaskTerminalJob", "pendingTerminals", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;", "internalListener", "com/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1", "Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;", "logUnrecognizedRtcFrame", "", "uid", "message", "reason", "reportWindowStateClick", "action", "windowStateBeforeClick", "reportServerToolEnd", "res", "Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;", "migrateFromViewModel", "vm", "Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;", "migrateFromViewModel$conversation_mainlandRelease", "restoreToViewModel", "restoreToViewModel$conversation_mainlandRelease", "markActiveForeground", "endSession", "Lcom/bytedance/trae/conversation/brainstorm/EndReason;", "endSession$conversation_mainlandRelease", "(Lcom/bytedance/trae/conversation/brainstorm/EndReason;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "startTimer", "sessionStartTimeMs", "stopTimer", "withVoiceDiscussionAttempt", "block", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;", "formatDuration", "ms", "buildBrainstormMessage", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;", "text", "role", "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;", "stampTerminalOnSnapshot", "finished", "startSubTaskTerminalCollect", "stopSubTaskTerminalCollect", "HolderState", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormSessionHolder {
    public static final BrainstormSessionHolder INSTANCE = new BrainstormSessionHolder();
    private static final String TAG = "BrainstormHolder";
    private static final long TIMER_TICK_MS = 300;
    private static final MutableStateFlow<Long> _elapsedMs;
    private static final MutableSharedFlow<HolderEndData> _ended;
    private static final MutableSharedFlow<Float> _localAudioVolume;
    private static final MutableStateFlow<HolderState> _state;
    private static final MutableStateFlow<Integer> _subtitleHistorySize;
    private static volatile AudioDeviceManager audioDeviceManager;
    private static volatile HolderSnapshot currentSnapshot;
    private static final StateFlow<Long> elapsedMs;
    private static final SharedFlow<HolderEndData> ended;
    private static final CoroutineScope holderScope;
    private static final BrainstormSessionHolder$internalListener$1 internalListener;
    private static final SharedFlow<Float> localAudioVolume;
    private static volatile String ownerConversationId;
    private static final ConcurrentHashMap<String, SubTaskUiState> pendingTerminals;
    private static final StateFlow<HolderState> state;
    private static Job subTaskTerminalJob;
    private static final StateFlow<Integer> subtitleHistorySize;
    private static Job timerJob;
    private static volatile BMVoiceChatSessionManager voiceChatSession;
    private static final Object voiceDiscussionAttemptLock;

    private BrainstormSessionHolder() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BrainstormSessionHolder.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ACTIVE_FG", "ACTIVE_MIN", "ENDING", "TERMINATED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class HolderState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HolderState[] $VALUES;
        public static final HolderState IDLE = new HolderState("IDLE", 0);
        public static final HolderState ACTIVE_FG = new HolderState("ACTIVE_FG", 1);
        public static final HolderState ACTIVE_MIN = new HolderState("ACTIVE_MIN", 2);
        public static final HolderState ENDING = new HolderState("ENDING", 3);
        public static final HolderState TERMINATED = new HolderState("TERMINATED", 4);

        private static final /* synthetic */ HolderState[] $values() {
            return new HolderState[]{IDLE, ACTIVE_FG, ACTIVE_MIN, ENDING, TERMINATED};
        }

        public static EnumEntries<HolderState> getEntries() {
            return $ENTRIES;
        }

        static {
            HolderState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private HolderState(String str, int i) {
        }

        public static HolderState valueOf(String str) {
            return (HolderState) Enum.valueOf(HolderState.class, str);
        }

        public static HolderState[] values() {
            return (HolderState[]) $VALUES.clone();
        }
    }

    static {
        MutableStateFlow<HolderState> MutableStateFlow = StateFlowKt.MutableStateFlow(HolderState.IDLE);
        _state = MutableStateFlow;
        state = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Long> MutableStateFlow2 = StateFlowKt.MutableStateFlow(0L);
        _elapsedMs = MutableStateFlow2;
        elapsedMs = FlowKt.asStateFlow(MutableStateFlow2);
        MutableSharedFlow<Float> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 1, (BufferOverflow) null, 4, (Object) null);
        _localAudioVolume = MutableSharedFlow$default;
        localAudioVolume = FlowKt.asSharedFlow(MutableSharedFlow$default);
        MutableStateFlow<Integer> MutableStateFlow3 = StateFlowKt.MutableStateFlow(0);
        _subtitleHistorySize = MutableStateFlow3;
        subtitleHistorySize = FlowKt.asStateFlow(MutableStateFlow3);
        MutableSharedFlow<HolderEndData> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 1, (BufferOverflow) null, 4, (Object) null);
        _ended = MutableSharedFlow$default2;
        ended = FlowKt.asSharedFlow(MutableSharedFlow$default2);
        holderScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        voiceDiscussionAttemptLock = new Object();
        pendingTerminals = new ConcurrentHashMap<>();
        internalListener = new BrainstormSessionHolder$internalListener$1();
    }

    public final StateFlow<HolderState> getState() {
        return state;
    }

    public final boolean isActive() {
        MutableStateFlow<HolderState> mutableStateFlow = _state;
        return mutableStateFlow.getValue() == HolderState.ACTIVE_FG || mutableStateFlow.getValue() == HolderState.ACTIVE_MIN;
    }

    public final boolean isMinimized() {
        return _state.getValue() == HolderState.ACTIVE_MIN;
    }

    public final String getOwnerConversationId() {
        return ownerConversationId;
    }

    public final String getCliConversationId() {
        HolderSnapshot holderSnapshot = currentSnapshot;
        if (holderSnapshot != null) {
            return holderSnapshot.getCliConversationId();
        }
        return null;
    }

    public final boolean isMicMuted() {
        BrainstormUiState uiState;
        HolderSnapshot holderSnapshot = currentSnapshot;
        if (holderSnapshot == null || (uiState = holderSnapshot.getUiState()) == null) {
            return false;
        }
        return uiState.isMicMuted();
    }

    public final StateFlow<Long> getElapsedMs() {
        return elapsedMs;
    }

    public final SharedFlow<Float> getLocalAudioVolume() {
        return localAudioVolume;
    }

    public final StateFlow<Integer> getSubtitleHistorySize() {
        return subtitleHistorySize;
    }

    public final SharedFlow<HolderEndData> getEnded() {
        return ended;
    }

    public final BMVoiceChatSessionManager getVoiceChatSession$conversation_mainlandRelease() {
        return voiceChatSession;
    }

    public final void setVoiceChatSession$conversation_mainlandRelease(BMVoiceChatSessionManager bMVoiceChatSessionManager) {
        voiceChatSession = bMVoiceChatSessionManager;
    }

    public final AudioDeviceManager getAudioDeviceManager$conversation_mainlandRelease() {
        return audioDeviceManager;
    }

    public final void setAudioDeviceManager$conversation_mainlandRelease(AudioDeviceManager audioDeviceManager2) {
        audioDeviceManager = audioDeviceManager2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void logUnrecognizedRtcFrame$default(BrainstormSessionHolder brainstormSessionHolder, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "unrecognized";
        }
        brainstormSessionHolder.logUnrecognizedRtcFrame(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logUnrecognizedRtcFrame(String uid, String message, String reason) {
        if (message.length() == 0) {
            return;
        }
        if (message.length() > 200) {
            StringBuilder sb = new StringBuilder();
            String substring = message.substring(0, 200);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            message = sb.append(substring).append("…(len=").append(message.length()).append(')').toString();
        }
        FLogger.INSTANCE.v(TAG, "internalListener.onRtcTextMessage: " + reason + " frame from uid=" + uid + ", preview=" + message);
    }

    public final void reportWindowStateClick(String action, String windowStateBeforeClick) {
        CliType cliType;
        Mode mode;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(windowStateBeforeClick, "windowStateBeforeClick");
        HolderSnapshot holderSnapshot = currentSnapshot;
        VoiceDiscussionMetrics voiceDiscussionMetrics = VoiceDiscussionMetrics.INSTANCE;
        if (holderSnapshot == null || (cliType = holderSnapshot.getVoiceCliType()) == null) {
            cliType = CliType.LOCAL;
        }
        if (holderSnapshot == null || (mode = holderSnapshot.getVoiceMode()) == null) {
            mode = Mode.WORK;
        }
        String cliConversationId = holderSnapshot != null ? holderSnapshot.getCliConversationId() : null;
        BMVoiceChatSessionManager bMVoiceChatSessionManager = voiceChatSession;
        String roomId = bMVoiceChatSessionManager != null ? bMVoiceChatSessionManager.getRoomId() : null;
        if (roomId == null) {
            roomId = "";
        }
        voiceDiscussionMetrics.reportWindowStateClick(cliType, mode, cliConversationId, roomId, action, windowStateBeforeClick);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportServerToolEnd(ToolResultMessage res) {
        CliType cliType;
        Mode mode;
        HolderSnapshot holderSnapshot = currentSnapshot;
        VoiceDiscussionMetrics voiceDiscussionMetrics = VoiceDiscussionMetrics.INSTANCE;
        if (holderSnapshot == null || (cliType = holderSnapshot.getVoiceCliType()) == null) {
            cliType = CliType.LOCAL;
        }
        if (holderSnapshot == null || (mode = holderSnapshot.getVoiceMode()) == null) {
            mode = Mode.WORK;
        }
        String cliConversationId = holderSnapshot != null ? holderSnapshot.getCliConversationId() : null;
        BMVoiceChatSessionManager bMVoiceChatSessionManager = voiceChatSession;
        String roomId = bMVoiceChatSessionManager != null ? bMVoiceChatSessionManager.getRoomId() : null;
        if (roomId == null) {
            roomId = "";
        }
        voiceDiscussionMetrics.reportServerToolEnd(cliType, mode, cliConversationId, roomId, null, null, res);
    }

    public final boolean migrateFromViewModel$conversation_mainlandRelease(BrainstormViewModel vm, String ownerConversationId2) {
        Intrinsics.checkNotNullParameter(vm, "vm");
        BMVoiceChatSessionManager detachVoiceSession$conversation_mainlandRelease = vm.detachVoiceSession$conversation_mainlandRelease();
        if (detachVoiceSession$conversation_mainlandRelease == null) {
            FLogger.INSTANCE.w(TAG, "migrateFromViewModel: vm.session is null, refuse minimize");
            return false;
        }
        AudioDeviceManager audioDeviceManager2 = vm.getAudioDeviceManager();
        HolderSnapshot snapshot$conversation_mainlandRelease = vm.snapshot$conversation_mainlandRelease();
        voiceChatSession = detachVoiceSession$conversation_mainlandRelease;
        audioDeviceManager = audioDeviceManager2;
        currentSnapshot = snapshot$conversation_mainlandRelease;
        ownerConversationId = ownerConversationId2;
        _subtitleHistorySize.setValue(Integer.valueOf(snapshot$conversation_mainlandRelease.getUiState().getSubtitleHistory().size()));
        _elapsedMs.setValue(Long.valueOf(snapshot$conversation_mainlandRelease.getUiState().getSessionElapsedMs()));
        detachVoiceSession$conversation_mainlandRelease.setListener(internalListener);
        startTimer(snapshot$conversation_mainlandRelease.getUiState().getSessionStartTimeMs());
        startSubTaskTerminalCollect();
        _state.setValue(HolderState.ACTIVE_MIN);
        if (snapshot$conversation_mainlandRelease.getUiState().isMicMuted()) {
            VolcRtcClient.INSTANCE.stopAudioCapture();
        } else {
            BrainstormVoiceForegroundService.INSTANCE.update(AppHost.INSTANCE.getApplication(), false);
            VolcRtcClient.INSTANCE.startAudioCapture();
        }
        BrainstormVoiceForegroundService.INSTANCE.update(AppHost.INSTANCE.getApplication(), snapshot$conversation_mainlandRelease.getUiState().isMicMuted());
        FLogger.INSTANCE.i(TAG, "migrated to holder; ownerConvId=" + ownerConversationId2 + ", cliId=" + snapshot$conversation_mainlandRelease.getCliConversationId());
        return true;
    }

    public final boolean restoreToViewModel$conversation_mainlandRelease(BrainstormViewModel vm) {
        Intrinsics.checkNotNullParameter(vm, "vm");
        BMVoiceChatSessionManager bMVoiceChatSessionManager = voiceChatSession;
        if (bMVoiceChatSessionManager == null) {
            FLogger.INSTANCE.w(TAG, "restoreToViewModel: holder.session is null");
            return false;
        }
        AudioDeviceManager audioDeviceManager2 = audioDeviceManager;
        HolderSnapshot holderSnapshot = currentSnapshot;
        if (holderSnapshot == null) {
            FLogger.INSTANCE.w(TAG, "restoreToViewModel: snapshot is null");
            return false;
        }
        stopTimer();
        stopSubTaskTerminalCollect();
        vm.restore$conversation_mainlandRelease(holderSnapshot);
        if (audioDeviceManager2 != null) {
            vm.attachAudioDeviceManager$conversation_mainlandRelease(audioDeviceManager2);
        }
        vm.attachVoiceSession$conversation_mainlandRelease(bMVoiceChatSessionManager);
        voiceChatSession = null;
        audioDeviceManager = null;
        currentSnapshot = null;
        ownerConversationId = null;
        pendingTerminals.clear();
        _state.setValue(HolderState.ACTIVE_FG);
        BrainstormVoiceForegroundService.INSTANCE.update(AppHost.INSTANCE.getApplication(), holderSnapshot.getUiState().isMicMuted());
        FLogger.INSTANCE.i(TAG, "restored to vm");
        return true;
    }

    public final void markActiveForeground() {
        _state.setValue(HolderState.ACTIVE_FG);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|(1:(1:9)(2:29|30))(2:31|(2:87|88)(21:35|(1:37)|38|(1:86)(1:44)|(1:46)(1:85)|47|48|49|(1:51)|53|54|(1:56)|58|(1:80)(1:62)|63|(1:65)(1:79)|66|(1:(1:69)(1:70))|(1:78)(1:73)|74|(1:76)(1:77)))|10|11|(5:15|(1:17)(1:(1:24)(1:25))|18|19|20)|26|(0)(0)|18|19|20))|89|6|(0)(0)|10|11|(5:15|(0)(0)|18|19|20)|26|(0)(0)|18|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0167, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0168, code lost:
    
        com.bytedance.trae.utils.logger.FLogger.INSTANCE.w(com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder.TAG, "endSession: coordinator.release failed", r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object endSession$conversation_mainlandRelease(EndReason endReason, Continuation<? super Unit> continuation) {
        BrainstormSessionHolder$endSession$1 brainstormSessionHolder$endSession$1;
        int i;
        int i2;
        BrainstormSessionHolder brainstormSessionHolder;
        int i3;
        BrainstormUiState uiState;
        boolean z;
        if (continuation instanceof BrainstormSessionHolder$endSession$1) {
            brainstormSessionHolder$endSession$1 = (BrainstormSessionHolder$endSession$1) continuation;
            if ((brainstormSessionHolder$endSession$1.label & Integer.MIN_VALUE) != 0) {
                brainstormSessionHolder$endSession$1.label -= Integer.MIN_VALUE;
                BrainstormSessionHolder$endSession$1 brainstormSessionHolder$endSession$12 = brainstormSessionHolder$endSession$1;
                Object obj = brainstormSessionHolder$endSession$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = brainstormSessionHolder$endSession$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow<HolderState> mutableStateFlow = _state;
                    if (mutableStateFlow.getValue() == HolderState.IDLE || mutableStateFlow.getValue() == HolderState.TERMINATED) {
                        FLogger.INSTANCE.w(TAG, "endSession noop, state=" + mutableStateFlow.getValue());
                        return Unit.INSTANCE;
                    }
                    mutableStateFlow.setValue(HolderState.ENDING);
                    HolderSnapshot holderSnapshot = currentSnapshot;
                    long coerceAtLeast = holderSnapshot != null ? RangesKt.coerceAtLeast(System.currentTimeMillis() - holderSnapshot.getUiState().getSessionStartTimeMs(), 0L) : 0L;
                    String formatDuration = formatDuration(coerceAtLeast);
                    int i4 = (holderSnapshot == null || (uiState = holderSnapshot.getUiState()) == null || !BrainstormSummaryEligibilityKt.hasSummaryWorthyInput(uiState)) ? 0 : 1;
                    String string = i4 != 0 ? AppHost.INSTANCE.getApplication().getString(C0637R.string.trae_brainstorm_summary_query, new Object[]{formatDuration}) : "";
                    Intrinsics.checkNotNull(string);
                    try {
                        BMVoiceChatSessionManager bMVoiceChatSessionManager = voiceChatSession;
                        if (bMVoiceChatSessionManager != null) {
                            bMVoiceChatSessionManager.release();
                        }
                    } catch (Throwable th) {
                        FLogger.INSTANCE.w(TAG, "endSession: session.release failed", th);
                    }
                    try {
                        AudioDeviceManager audioDeviceManager2 = audioDeviceManager;
                        if (audioDeviceManager2 != null) {
                            audioDeviceManager2.release();
                        }
                    } catch (Throwable th2) {
                        FLogger.INSTANCE.w(TAG, "endSession: audio.release failed", th2);
                    }
                    boolean z2 = (endReason == EndReason.UserAbortInActivity || endReason == EndReason.UserAbortInConversation) ? 1 : 0;
                    withVoiceDiscussionAttempt(new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            Unit endSession$lambda$4;
                            endSession$lambda$4 = BrainstormSessionHolder.endSession$lambda$4((VoiceDiscussionAttemptTracker) obj2);
                            return endSession$lambda$4;
                        }
                    });
                    FLogger.INSTANCE.i(TAG, "endSession: reason=" + endReason + ", isAbort=" + z2 + ", durationMs=" + coerceAtLeast);
                    MutableSharedFlow<HolderEndData> mutableSharedFlow = _ended;
                    String cliConversationId = holderSnapshot != null ? holderSnapshot.getCliConversationId() : null;
                    String str = (String) VoiceSubTaskCoordinator.INSTANCE.getParentConversationId().getValue();
                    if (str == null) {
                        str = holderSnapshot != null ? holderSnapshot.getParentConversationId() : null;
                    }
                    HolderEndData holderEndData = new HolderEndData(endReason, cliConversationId, str, string, z2, z2 == 0 && i4 == 0);
                    brainstormSessionHolder$endSession$12.L$0 = this;
                    brainstormSessionHolder$endSession$12.I$0 = i4;
                    brainstormSessionHolder$endSession$12.I$1 = z2;
                    brainstormSessionHolder$endSession$12.label = 1;
                    if (mutableSharedFlow.emit(holderEndData, brainstormSessionHolder$endSession$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i2 = z2;
                    brainstormSessionHolder = this;
                    i3 = i4;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = brainstormSessionHolder$endSession$12.I$1;
                    i3 = brainstormSessionHolder$endSession$12.I$0;
                    brainstormSessionHolder = (BrainstormSessionHolder) brainstormSessionHolder$endSession$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                VoiceSubTaskCoordinator voiceSubTaskCoordinator = VoiceSubTaskCoordinator.INSTANCE;
                if (i2 == 0 && i3 != 0) {
                    z = false;
                    voiceSubTaskCoordinator.release(z, i2 == 0 ? "holder_brainstorm_abort" : i3 == 0 ? "holder_brainstorm_empty_end" : "holder_brainstorm_normal_end");
                    brainstormSessionHolder.reset();
                    return Unit.INSTANCE;
                }
                z = true;
                voiceSubTaskCoordinator.release(z, i2 == 0 ? "holder_brainstorm_abort" : i3 == 0 ? "holder_brainstorm_empty_end" : "holder_brainstorm_normal_end");
                brainstormSessionHolder.reset();
                return Unit.INSTANCE;
            }
        }
        brainstormSessionHolder$endSession$1 = new BrainstormSessionHolder$endSession$1(this, continuation);
        BrainstormSessionHolder$endSession$1 brainstormSessionHolder$endSession$122 = brainstormSessionHolder$endSession$1;
        Object obj2 = brainstormSessionHolder$endSession$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = brainstormSessionHolder$endSession$122.label;
        if (i != 0) {
        }
        VoiceSubTaskCoordinator voiceSubTaskCoordinator2 = VoiceSubTaskCoordinator.INSTANCE;
        if (i2 == 0) {
            z = false;
            voiceSubTaskCoordinator2.release(z, i2 == 0 ? "holder_brainstorm_abort" : i3 == 0 ? "holder_brainstorm_empty_end" : "holder_brainstorm_normal_end");
            brainstormSessionHolder.reset();
            return Unit.INSTANCE;
        }
        z = true;
        voiceSubTaskCoordinator2.release(z, i2 == 0 ? "holder_brainstorm_abort" : i3 == 0 ? "holder_brainstorm_empty_end" : "holder_brainstorm_normal_end");
        brainstormSessionHolder.reset();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit endSession$lambda$4(VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker) {
        Intrinsics.checkNotNullParameter(voiceDiscussionAttemptTracker, "tracker");
        voiceDiscussionAttemptTracker.finishInferred();
        return Unit.INSTANCE;
    }

    public final void reset() {
        stopTimer();
        stopSubTaskTerminalCollect();
        voiceChatSession = null;
        audioDeviceManager = null;
        currentSnapshot = null;
        ownerConversationId = null;
        pendingTerminals.clear();
        _elapsedMs.setValue(0L);
        _subtitleHistorySize.setValue(0);
        _state.setValue(HolderState.IDLE);
        BrainstormVoiceForegroundService.INSTANCE.stop(AppHost.INSTANCE.getApplication());
    }

    private final void startTimer(long sessionStartTimeMs) {
        stopTimer();
        timerJob = BuildersKt.launch$default(holderScope, (CoroutineContext) null, (CoroutineStart) null, new BrainstormSessionHolder$startTimer$1(sessionStartTimeMs, null), 3, (Object) null);
    }

    private final void stopTimer() {
        Job job = timerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        timerJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void withVoiceDiscussionAttempt(Function1<? super VoiceDiscussionAttemptTracker, Unit> block) {
        synchronized (voiceDiscussionAttemptLock) {
            HolderSnapshot holderSnapshot = currentSnapshot;
            if (holderSnapshot == null) {
                return;
            }
            VoiceDiscussionAttemptState voiceDiscussionAttemptState = holderSnapshot.getVoiceDiscussionAttemptState();
            if (voiceDiscussionAttemptState == null) {
                return;
            }
            if (voiceDiscussionAttemptState.getTerminalReported()) {
                return;
            }
            VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker = new VoiceDiscussionAttemptTracker(voiceDiscussionAttemptState, null, null, null, 14, null);
            VoiceDiscussionAttemptContext context = voiceDiscussionAttemptState.getContext();
            String cliConversationId = holderSnapshot.getCliConversationId();
            if (cliConversationId == null) {
                cliConversationId = "";
            }
            String str = cliConversationId;
            BMVoiceChatSessionManager bMVoiceChatSessionManager = voiceChatSession;
            HolderSnapshot holderSnapshot2 = null;
            String roomId = bMVoiceChatSessionManager != null ? bMVoiceChatSessionManager.getRoomId() : null;
            if (roomId == null) {
                roomId = "";
            }
            voiceDiscussionAttemptTracker.updateContext(VoiceDiscussionAttemptContext.copy$default(context, null, null, str, roomId, false, false, 51, null));
            block.invoke(voiceDiscussionAttemptTracker);
            HolderSnapshot holderSnapshot3 = currentSnapshot;
            if (holderSnapshot3 != null) {
                holderSnapshot2 = holderSnapshot3.copy((r45 & 1) != 0 ? holderSnapshot3.uiState : null, (r45 & 2) != 0 ? holderSnapshot3.cliConversationId : null, (r45 & 4) != 0 ? holderSnapshot3.parentConversationId : null, (r45 & 8) != 0 ? holderSnapshot3.originConversationId : null, (r45 & 16) != 0 ? holderSnapshot3.voiceCliType : null, (r45 & 32) != 0 ? holderSnapshot3.voiceMode : null, (r45 & 64) != 0 ? holderSnapshot3.attachmentSubTaskEnabled : false, (r45 & 128) != 0 ? holderSnapshot3.perfMicCheckStartMs : 0L, (r45 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? holderSnapshot3.perfMicCheckEndMs : 0L, (r45 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? holderSnapshot3.perfApiRequestStartMs : 0L, (r45 & 1024) != 0 ? holderSnapshot3.perfJoinRoomStartMs : 0L, (r45 & 2048) != 0 ? holderSnapshot3.perfJoinRoomSuccessMs : 0L, (r45 & 4096) != 0 ? holderSnapshot3.perfBotJoinedMs : 0L, (r45 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? holderSnapshot3.perfIsNewSession : false, (r45 & 16384) != 0 ? holderSnapshot3.discussionStartPerfReported : false, (r45 & 32768) != 0 ? holderSnapshot3.sessionUserMessageCount : 0, (r45 & 65536) != 0 ? holderSnapshot3.sessionBotMessageCount : 0, (r45 & 131072) != 0 ? holderSnapshot3.sessionUserSpeakEndTimestamps : null, (r45 & 262144) != 0 ? holderSnapshot3.sessionBotSpeakStartTimestamps : null, (r45 & FConstants.SLICE_SIZE) != 0 ? holderSnapshot3.sessionHasEverEnabledSubtitle : false, (r45 & 1048576) != 0 ? holderSnapshot3.voiceDiscussionAttemptState : voiceDiscussionAttemptTracker.snapshot());
            }
            currentSnapshot = holderSnapshot2;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final String formatDuration(long ms) {
        long j = ms / 1000;
        long j2 = 3600;
        long j3 = j / j2;
        long j4 = 60;
        long j5 = (j % j2) / j4;
        long j6 = j % j4;
        if (j3 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j3), Long.valueOf(j5), Long.valueOf(j6)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j5), Long.valueOf(j6)}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BrainstormMessage buildBrainstormMessage(String text, BMVoiceChatSessionManager.MessageRole role) {
        BrainstormUiState uiState;
        List<BrainstormMessage> subtitleHistory;
        long currentTimeMillis = System.currentTimeMillis();
        if (role == BMVoiceChatSessionManager.MessageRole.USER) {
            return new BrainstormMessage("subtitle_user_" + currentTimeMillis, MessageRole.User, text, currentTimeMillis, null, null, null, null, null, 496, null);
        }
        ParsedSubTaskTag parseAttachedSubTaskId = BrainstormMessageKt.parseAttachedSubTaskId(text);
        if (!parseAttachedSubTaskId.isIncompleteHead()) {
            text = parseAttachedSubTaskId.getCleanedText();
        }
        String str = text;
        boolean z = parseAttachedSubTaskId.getSourceStatus() != null;
        String sourceTaskId = !z ? parseAttachedSubTaskId.getSourceTaskId() : null;
        SubTaskUiState subTaskUiState = sourceTaskId != null ? pendingTerminals.get(sourceTaskId) : null;
        if (parseAttachedSubTaskId.getSourceTaskId() != null) {
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder append = new StringBuilder("buildBrainstormMessage[subtask]: taskId=").append(parseAttachedSubTaskId.getSourceTaskId()).append(", role=").append(z ? "result" : "comfort").append(", status=").append(parseAttachedSubTaskId.getSourceStatus()).append(", attachedId=").append(sourceTaskId).append(", pendingTerminal=").append(subTaskUiState != null ? subTaskUiState.getState() : null).append(", snapshotHistorySize=");
            HolderSnapshot holderSnapshot = currentSnapshot;
            fLogger.d(TAG, append.append((holderSnapshot == null || (uiState = holderSnapshot.getUiState()) == null || (subtitleHistory = uiState.getSubtitleHistory()) == null) ? -1 : subtitleHistory.size()).append(", contentLen=").append(str.length()).append(", incomplete=").append(parseAttachedSubTaskId.isIncompleteHead()).toString());
        }
        return new BrainstormMessage("subtitle_bot_" + currentTimeMillis, MessageRole.Assistant, str, currentTimeMillis, sourceTaskId, z ? parseAttachedSubTaskId.getSourceTaskId() : null, parseAttachedSubTaskId.getSourceStatus(), subTaskUiState != null ? subTaskUiState.getState() : null, subTaskUiState != null ? subTaskUiState.getFailureReason() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stampTerminalOnSnapshot(SubTaskUiState finished) {
        HolderSnapshot holderSnapshot;
        int i;
        int i2;
        int i3;
        BrainstormUiState copy;
        String sourceTaskId = finished.getSourceTaskId();
        if (StringsKt.isBlank(sourceTaskId)) {
            return;
        }
        pendingTerminals.put(sourceTaskId, finished);
        HolderSnapshot holderSnapshot2 = currentSnapshot;
        if (holderSnapshot2 != null) {
            int size = holderSnapshot2.getUiState().getSubtitleHistory().size();
            List<BrainstormMessage> subtitleHistory = holderSnapshot2.getUiState().getSubtitleHistory();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subtitleHistory, 10));
            int i4 = 0;
            int i5 = 0;
            for (BrainstormMessage brainstormMessage : subtitleHistory) {
                if (Intrinsics.areEqual(brainstormMessage.getAttachedSubTaskId(), sourceTaskId)) {
                    i4++;
                    if (brainstormMessage.getSubTaskTerminalState() == null) {
                        i5++;
                        brainstormMessage = brainstormMessage.copy((r22 & 1) != 0 ? brainstormMessage.id : null, (r22 & 2) != 0 ? brainstormMessage.role : null, (r22 & 4) != 0 ? brainstormMessage.content : null, (r22 & 8) != 0 ? brainstormMessage.timestamp : 0L, (r22 & 16) != 0 ? brainstormMessage.attachedSubTaskId : null, (r22 & 32) != 0 ? brainstormMessage.taskResultRefersToTaskId : null, (r22 & 64) != 0 ? brainstormMessage.taskResultStatus : null, (r22 & 128) != 0 ? brainstormMessage.subTaskTerminalState : finished.getState(), (r22 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormMessage.subTaskFailureReason : finished.getFailureReason());
                    }
                }
                arrayList.add(brainstormMessage);
            }
            copy = r36.copy((r42 & 1) != 0 ? r36.phase : null, (r42 & 2) != 0 ? r36.subtitleHistory : arrayList, (r42 & 4) != 0 ? r36.recordingState : null, (r42 & 8) != 0 ? r36.aiReplyState : null, (r42 & 16) != 0 ? r36.aiParticipantState : null, (r42 & 32) != 0 ? r36.userParticipantState : null, (r42 & 64) != 0 ? r36.currentTranscript : null, (r42 & 128) != 0 ? r36.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r36.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r36.isSpeakerOn : false, (r42 & 1024) != 0 ? r36.isMicMuted : false, (r42 & 2048) != 0 ? r36.isSubtitleMode : false, (r42 & 4096) != 0 ? r36.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r36.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r36.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r36.timeoutState : null, (65536 & r42) != 0 ? r36.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r36.aiStageDescription : null, (r42 & 262144) != 0 ? r36.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r36.subTask : null, (r42 & 1048576) != 0 ? r36.finishedSubTasks : null, (r42 & 2097152) != 0 ? holderSnapshot2.getUiState().attachments : null);
            holderSnapshot = holderSnapshot2.copy((r45 & 1) != 0 ? holderSnapshot2.uiState : copy, (r45 & 2) != 0 ? holderSnapshot2.cliConversationId : null, (r45 & 4) != 0 ? holderSnapshot2.parentConversationId : null, (r45 & 8) != 0 ? holderSnapshot2.originConversationId : null, (r45 & 16) != 0 ? holderSnapshot2.voiceCliType : null, (r45 & 32) != 0 ? holderSnapshot2.voiceMode : null, (r45 & 64) != 0 ? holderSnapshot2.attachmentSubTaskEnabled : false, (r45 & 128) != 0 ? holderSnapshot2.perfMicCheckStartMs : 0L, (r45 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? holderSnapshot2.perfMicCheckEndMs : 0L, (r45 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? holderSnapshot2.perfApiRequestStartMs : 0L, (r45 & 1024) != 0 ? holderSnapshot2.perfJoinRoomStartMs : 0L, (r45 & 2048) != 0 ? holderSnapshot2.perfJoinRoomSuccessMs : 0L, (r45 & 4096) != 0 ? holderSnapshot2.perfBotJoinedMs : 0L, (r45 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? holderSnapshot2.perfIsNewSession : false, (r45 & 16384) != 0 ? holderSnapshot2.discussionStartPerfReported : false, (r45 & 32768) != 0 ? holderSnapshot2.sessionUserMessageCount : 0, (r45 & 65536) != 0 ? holderSnapshot2.sessionBotMessageCount : 0, (r45 & 131072) != 0 ? holderSnapshot2.sessionUserSpeakEndTimestamps : null, (r45 & 262144) != 0 ? holderSnapshot2.sessionBotSpeakStartTimestamps : null, (r45 & FConstants.SLICE_SIZE) != 0 ? holderSnapshot2.sessionHasEverEnabledSubtitle : false, (r45 & 1048576) != 0 ? holderSnapshot2.voiceDiscussionAttemptState : null);
            i3 = size;
            i = i4;
            i2 = i5;
        } else {
            holderSnapshot = null;
            i = 0;
            i2 = 0;
            i3 = -1;
        }
        currentSnapshot = holderSnapshot;
        FLogger.INSTANCE.d(TAG, "stampTerminalOnSnapshot: sourceTaskId=" + sourceTaskId + ", state=" + finished.getState() + ", matchedAnchors=" + i + ", newlyStamped=" + i2 + ", historySize=" + i3 + ", snapshotReady=" + (currentSnapshot != null));
    }

    private final void startSubTaskTerminalCollect() {
        Job job = subTaskTerminalJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        FLogger.INSTANCE.d(TAG, "startSubTaskTerminalCollect");
        subTaskTerminalJob = BuildersKt.launch$default(holderScope, (CoroutineContext) null, (CoroutineStart) null, new BrainstormSessionHolder$startSubTaskTerminalCollect$1(null), 3, (Object) null);
    }

    private final void stopSubTaskTerminalCollect() {
        FLogger.INSTANCE.d(TAG, "stopSubTaskTerminalCollect");
        Job job = subTaskTerminalJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        subTaskTerminalJob = null;
    }
}
