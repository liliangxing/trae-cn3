package com.bytedance.trae.conversation.voice;

import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.conversation.voice.TranscriptionVoiceManager;
import com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker;
import com.bytedance.trae.conversation.voice.VoiceChatApiPaths;
import com.bytedance.trae.conversation.voice.network.StartVoiceChatData;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.bytedance.trae.conversation.voice.subtitle.SubtitleBinaryProtocol;
import com.bytedance.trae.platform.service.ApmService;
import com.bytedance.trae.utils.logger.FLogger;
import com.facebook.common.logging.FLog;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* compiled from: TranscriptionVoiceManager.kt */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0007\b\u0000\u0018\u0000 V2\u00020\u0001:\u0003TUVB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010+\u001a\u00020\u0011J\u0010\u0010,\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010-\u001a\u00020\nJ\u0010\u0010.\u001a\u00020\n2\b\b\u0002\u0010/\u001a\u00020\u0011J\u0006\u00100\u001a\u00020\nJ\u0018\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\nH\u0002J\u0010\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u0016H\u0002J\u0012\u00108\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010:\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u0003H\u0002J\u0010\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u0003H\u0002J\u0010\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020&H\u0002J\"\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00032\b\b\u0002\u0010H\u001a\u00020\u00032\b\b\u0002\u0010I\u001a\u00020\u0003J\b\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u0003H\u0002J\u0010\u0010N\u001a\u00020\n2\u0006\u0010O\u001a\u00020&H\u0002J\u0010\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020RH\u0002J\u0018\u0010S\u001a\u00020\n2\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u000204H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;", "", "xAppId", "", "<init>", "(Ljava/lang/String;)V", "rtcListener", "com/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1", "Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;", "onError", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "uiScope", "listener", "Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener;", "hasStartedVoiceChat", "", "hasReceiveVoice", "hasStop", "conversationId", "voiceChat", "Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;", "definiteText", "currentRecognizedText", "botCompleteText", "waitBotJob", "Lkotlinx/coroutines/Job;", "isWaitingBotResponse", "voiceStartTimestamp", "", "voiceReleaseTimestamp", "perfStartVoiceChatTimestamp", "perfApiRequestEndTimestamp", "perfJoinRoomTimestamp", "perfJoinRoomSuccessTimestamp", "perfPublishStreamTimestamp", "subvMessageCount", "", "asrCallbackCount", "voiceStartCaptureDuration", "attemptTracker", "Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;", "isRunning", "start", "startRoom", "stop", "ignoreFinalText", "release", "handleBinaryMessage", "uid", "message", "", "stopInternal", "isVoiceChatDataValid", "data", "handleJoinRefused", "current", "stopVoiceChatBestEffort", "emitStatus", PageDataManager.EXTRA_STATUS, "Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;", "emitRecognizedText", "text", "emitFinalText", "emitError", "error", "", "emitLocalAudioVolume", "volume", "reportAttemptOutcome", "outcome", "inputStateWhenFinal", "failureReason", "buildSessionSnapshot", "Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;", "reportVoiceSessionPerf", "finalText", "reportVoiceStartPerf", DBData.FIELD_TYPE, "emitConversationState", "state", "Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;", "handleSubvMessage", "Status", "Listener", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TranscriptionVoiceManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EVENT_SESSION_PERF = "rtc_voice_session_perf";
    private static final String EVENT_START_PERF = "rtc_voice_start_perf";
    public static final String OUTCOME_AUTO_SEND = "auto_send";
    public static final String OUTCOME_CANCEL = "cancel";
    public static final String OUTCOME_EMPTY_TEXT = "empty_text";
    public static final String OUTCOME_ERROR = "error";
    public static final String OUTCOME_FILL_INPUT = "fill_input";
    public static final String OUTCOME_START_FAILED = "start_failed";
    private static final long POLL_INTERVAL_MS = 2000;
    private static final String TAG = "VoiceChatSession";
    private int asrCallbackCount;
    private final VoiceAttemptMetricsTracker attemptTracker;
    private String botCompleteText;
    private String conversationId;
    private String currentRecognizedText;
    private String definiteText;
    private boolean hasReceiveVoice;
    private boolean hasStartedVoiceChat;
    private boolean hasStop;
    private boolean isWaitingBotResponse;
    private Listener listener;
    private long perfApiRequestEndTimestamp;
    private long perfJoinRoomSuccessTimestamp;
    private long perfJoinRoomTimestamp;
    private long perfPublishStreamTimestamp;
    private long perfStartVoiceChatTimestamp;
    private final TranscriptionVoiceManager$rtcListener$1 rtcListener;
    private final CoroutineScope scope;
    private int subvMessageCount;
    private final CoroutineScope uiScope;
    private StartVoiceChatData voiceChat;
    private long voiceReleaseTimestamp;
    private long voiceStartCaptureDuration;
    private long voiceStartTimestamp;
    private Job waitBotJob;
    private final String xAppId;

    /* compiled from: TranscriptionVoiceManager.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener;", "", "onStatus", "", PageDataManager.EXTRA_STATUS, "Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;", "onRecognizedText", "text", "", "onFinalText", "onError", "error", "", "onLocalAudioVolume", "volume", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface Listener {

        /* compiled from: TranscriptionVoiceManager.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class DefaultImpls {
            public static void onLocalAudioVolume(Listener listener, float f) {
            }
        }

        void onError(Throwable error);

        void onFinalText(String text);

        void onLocalAudioVolume(float volume);

        void onRecognizedText(String text);

        void onStatus(Status status);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TranscriptionVoiceManager() {
        this(r0, 1, r0);
        String str = null;
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$rtcListener$1] */
    public TranscriptionVoiceManager(String str) {
        Intrinsics.checkNotNullParameter(str, "xAppId");
        this.xAppId = str;
        this.rtcListener = new VolcRtcClient.Listener() { // from class: com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$rtcListener$1
            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onUserMessage(String uid, String message) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                Intrinsics.checkNotNullParameter(message, "message");
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onAudioInputDeviceStateChanged(String str2, int i, int i2) {
                VolcRtcClient.Listener.DefaultImpls.onAudioInputDeviceStateChanged(this, str2, i, i2);
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onLocalAudioProperties(VolcRtcClient.RtcLocalAudioProperties rtcLocalAudioProperties) {
                VolcRtcClient.Listener.DefaultImpls.onLocalAudioProperties(this, rtcLocalAudioProperties);
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onNetworkQuality(VolcRtcClient.RtcNetworkQuality rtcNetworkQuality, List<VolcRtcClient.RtcNetworkQuality> list) {
                VolcRtcClient.Listener.DefaultImpls.onNetworkQuality(this, rtcNetworkQuality, list);
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onJoinedRoom(String roomId) {
                Intrinsics.checkNotNullParameter(roomId, "roomId");
                TranscriptionVoiceManager.this.perfJoinRoomSuccessTimestamp = System.currentTimeMillis();
                TranscriptionVoiceManager.this.emitStatus(TranscriptionVoiceManager.Status.JoinedRoom);
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onRemoteUserJoined(String uid) {
                long j;
                Intrinsics.checkNotNullParameter(uid, "uid");
                j = TranscriptionVoiceManager.this.perfPublishStreamTimestamp;
                if (j == 0) {
                    TranscriptionVoiceManager.this.perfPublishStreamTimestamp = System.currentTimeMillis();
                }
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onRoomBinaryMessage(String uid, byte[] message) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                Intrinsics.checkNotNullParameter(message, "message");
                TranscriptionVoiceManager.this.handleBinaryMessage(uid, message);
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onError(Throwable error) {
                boolean z;
                Intrinsics.checkNotNullParameter(error, "error");
                TranscriptionVoiceManager.this.emitError(error);
                z = TranscriptionVoiceManager.this.hasStartedVoiceChat;
                if (z) {
                    TranscriptionVoiceManager.this.onError();
                }
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onServerParamsSetResult(int error) {
                FLog.d("VoiceChatSession", "onServerParamsSetResult: error=" + error);
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onLocalAudioLevel(int volume) {
                TranscriptionVoiceManager.this.emitLocalAudioVolume(volume);
            }
        };
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO().limitedParallelism(1)));
        this.uiScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.conversationId = uuid;
        this.definiteText = "";
        this.currentRecognizedText = "";
        this.botCompleteText = "";
        this.attemptTracker = new VoiceAttemptMetricsTracker(null, null, null, null, 15, null);
    }

    public /* synthetic */ TranscriptionVoiceManager(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? VoiceChatApiPaths.HeaderValue.DEFAULT_X_APP_ID : str);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: TranscriptionVoiceManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;", "", "<init>", "(Ljava/lang/String;I)V", "Starting", "JoiningRoom", "JoinedRoom", "WaitingBotResponse", "Stopped", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Status {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;
        public static final Status Starting = new Status("Starting", 0);
        public static final Status JoiningRoom = new Status("JoiningRoom", 1);
        public static final Status JoinedRoom = new Status("JoinedRoom", 2);
        public static final Status WaitingBotResponse = new Status("WaitingBotResponse", 3);
        public static final Status Stopped = new Status("Stopped", 4);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{Starting, JoiningRoom, JoinedRoom, WaitingBotResponse, Stopped};
        }

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }

        private Status(String str, int i) {
        }

        static {
            Status[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    public final void onError() {
        VolcRtcClient.INSTANCE.removeListener(this.rtcListener);
        stopInternal();
    }

    /* renamed from: isRunning, reason: from getter */
    public final boolean getHasStartedVoiceChat() {
        return this.hasStartedVoiceChat;
    }

    public final void start(Listener listener) {
        if (this.hasStartedVoiceChat) {
            return;
        }
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = System.currentTimeMillis();
        this.listener = listener;
        this.hasReceiveVoice = false;
        this.hasStop = false;
        this.hasStartedVoiceChat = true;
        this.definiteText = "";
        this.currentRecognizedText = "";
        this.botCompleteText = "";
        this.isWaitingBotResponse = false;
        Job job = this.waitBotJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.waitBotJob = null;
        this.voiceStartTimestamp = System.currentTimeMillis();
        this.voiceReleaseTimestamp = 0L;
        this.perfStartVoiceChatTimestamp = 0L;
        this.perfApiRequestEndTimestamp = 0L;
        this.perfJoinRoomTimestamp = 0L;
        this.perfJoinRoomSuccessTimestamp = 0L;
        this.perfPublishStreamTimestamp = 0L;
        this.subvMessageCount = 0;
        this.asrCallbackCount = 0;
        this.voiceStartCaptureDuration = 0L;
        this.attemptTracker.reset();
        emitStatus(Status.Starting);
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new TranscriptionVoiceManager$start$1(this, longRef, null), 3, (Object) null);
    }

    public final void startRoom() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.conversationId = uuid;
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new TranscriptionVoiceManager$startRoom$1(this, null), 3, (Object) null);
    }

    public static /* synthetic */ void stop$default(TranscriptionVoiceManager transcriptionVoiceManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        transcriptionVoiceManager.stop(z);
    }

    public final void stop(boolean ignoreFinalText) {
        if (this.hasStartedVoiceChat) {
            this.hasStop = true;
            FLog.d(TAG, "stop");
            if (this.voiceReleaseTimestamp == 0) {
                this.voiceReleaseTimestamp = System.currentTimeMillis();
                this.attemptTracker.onVoiceRelease();
            }
            if (ignoreFinalText) {
                this.currentRecognizedText = "";
                this.definiteText = "";
                this.botCompleteText = "";
                this.attemptTracker.setFinalSourceCancel();
                VolcRtcClient.INSTANCE.removeListener(this.rtcListener);
            }
            VolcRtcClient.INSTANCE.stopAudioCapture();
            BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new TranscriptionVoiceManager$stop$1(this, ignoreFinalText, null), 3, (Object) null);
        }
    }

    public final void release() {
        boolean z = this.hasStartedVoiceChat;
        StartVoiceChatData startVoiceChatData = this.voiceChat;
        FLog.w(TAG, "release on release failed" + z);
        this.hasStartedVoiceChat = false;
        this.hasReceiveVoice = false;
        this.hasStop = true;
        this.isWaitingBotResponse = false;
        Job job = this.waitBotJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.waitBotJob = null;
        this.voiceChat = null;
        this.listener = null;
        if (z && startVoiceChatData != null) {
            BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new TranscriptionVoiceManager$release$1(startVoiceChatData, this, null), 3, (Object) null);
            return;
        }
        VolcRtcClient.INSTANCE.leaveRoom();
        Job job2 = this.scope.getCoroutineContext().get(Job.Key);
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        Job job3 = this.uiScope.getCoroutineContext().get(Job.Key);
        if (job3 != null) {
            Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005b, code lost:
    
        if (r1 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleBinaryMessage(String uid, byte[] message) {
        String str;
        try {
            Integer readMagic = SubtitleBinaryProtocol.INSTANCE.readMagic(message);
            if (readMagic != null && readMagic.intValue() == 1937072758) {
                FLogger.INSTANCE.d(TAG, "MAGIC_SUBV");
                handleSubvMessage(uid, message);
                return;
            }
            if (readMagic.intValue() == 1668247158) {
                ConversationStateMessage unpackConvMessage = SubtitleBinaryProtocol.INSTANCE.unpackConvMessage(message);
                if (unpackConvMessage == null || !this.hasStop) {
                    return;
                }
                emitConversationState(unpackConvMessage);
                return;
            }
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("unknown binary message magic: 0x");
            if (readMagic != null) {
                str = Integer.toString(readMagic.intValue(), CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
            }
            str = "null";
            fLogger.w(TAG, sb.append(str).append(", size=").append(message.length).toString());
        } catch (Throwable th) {
            FLogger.INSTANCE.e(TAG, "handleBinaryMessage error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopInternal() {
        if (this.hasStartedVoiceChat) {
            this.hasStartedVoiceChat = false;
            this.hasReceiveVoice = false;
            this.isWaitingBotResponse = false;
            Job job = this.waitBotJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.waitBotJob = null;
            StartVoiceChatData startVoiceChatData = this.voiceChat;
            this.voiceChat = null;
            BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new TranscriptionVoiceManager$stopInternal$1(this, startVoiceChatData, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isVoiceChatDataValid(StartVoiceChatData data) {
        String appId = data.getAppId();
        if (appId == null || StringsKt.isBlank(appId)) {
            return false;
        }
        String roomId = data.getRoomId();
        if (roomId == null || StringsKt.isBlank(roomId)) {
            return false;
        }
        String userId = data.getUserId();
        if (userId == null || StringsKt.isBlank(userId)) {
            return false;
        }
        String token = data.getToken();
        return !(token == null || StringsKt.isBlank(token));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleJoinRefused(StartVoiceChatData current) {
        this.hasStartedVoiceChat = false;
        this.hasReceiveVoice = false;
        this.hasStop = false;
        this.isWaitingBotResponse = false;
        Job job = this.waitBotJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.waitBotJob = null;
        this.voiceChat = null;
        VolcRtcClient.INSTANCE.removeListener(this.rtcListener);
        stopVoiceChatBestEffort(current);
        emitStatus(Status.Stopped);
    }

    private final void stopVoiceChatBestEffort(StartVoiceChatData current) {
        String str = this.conversationId;
        if ((current != null ? current.getAppId() : null) == null || current.getRoomId() == null || current.getTaskId() == null) {
            return;
        }
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new TranscriptionVoiceManager$stopVoiceChatBestEffort$1(this, current, str, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitStatus(Status status) {
        Listener listener = this.listener;
        if (listener == null) {
            return;
        }
        BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new TranscriptionVoiceManager$emitStatus$1(listener, status, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitRecognizedText(String text) {
        Listener listener = this.listener;
        if (listener == null) {
            return;
        }
        BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new TranscriptionVoiceManager$emitRecognizedText$1(listener, text, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitFinalText(String text) {
        FLog.d(TAG, "emitFinalText: text=" + text);
        Listener listener = this.listener;
        if (listener == null) {
            return;
        }
        BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new TranscriptionVoiceManager$emitFinalText$1(listener, text, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitError(Throwable error) {
        this.attemptTracker.report((this.voiceReleaseTimestamp == 0 && this.perfPublishStreamTimestamp == 0) ? "start_failed" : "error", VoiceAttemptMetricsTracker.INSTANCE.failureReasonFor(error), "unknown", buildSessionSnapshot());
        Listener listener = this.listener;
        if (listener == null) {
            return;
        }
        BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new TranscriptionVoiceManager$emitError$1(listener, error, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitLocalAudioVolume(int volume) {
        this.attemptTracker.onAudioVolume(volume);
        Listener listener = this.listener;
        if (listener == null) {
            return;
        }
        BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new TranscriptionVoiceManager$emitLocalAudioVolume$1(listener, RangesKt.coerceIn(volume / 255.0f, 0.0f, 1.0f), null), 3, (Object) null);
    }

    public static /* synthetic */ void reportAttemptOutcome$default(TranscriptionVoiceManager transcriptionVoiceManager, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "unknown";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        transcriptionVoiceManager.reportAttemptOutcome(str, str2, str3);
    }

    public final void reportAttemptOutcome(String outcome, String inputStateWhenFinal, String failureReason) {
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        Intrinsics.checkNotNullParameter(inputStateWhenFinal, "inputStateWhenFinal");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        this.attemptTracker.report(outcome, failureReason, inputStateWhenFinal, buildSessionSnapshot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VoiceAttemptMetricsTracker.SessionSnapshot buildSessionSnapshot() {
        return new VoiceAttemptMetricsTracker.SessionSnapshot(this.conversationId, this.hasReceiveVoice, this.voiceStartTimestamp, this.voiceReleaseTimestamp, this.perfStartVoiceChatTimestamp, this.perfApiRequestEndTimestamp, this.perfJoinRoomTimestamp, this.perfJoinRoomSuccessTimestamp, this.perfPublishStreamTimestamp, this.subvMessageCount, this.asrCallbackCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportVoiceSessionPerf(String finalText) {
        try {
            if (this.voiceStartTimestamp <= 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long max = Math.max(currentTimeMillis - this.voiceStartTimestamp, 0L);
            long j = this.voiceReleaseTimestamp;
            long max2 = j > 0 ? Math.max(currentTimeMillis - j, 0L) : 0L;
            StartVoiceChatData startVoiceChatData = this.voiceChat;
            String roomId = startVoiceChatData != null ? startVoiceChatData.getRoomId() : null;
            if (roomId == null) {
                roomId = "";
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("room_id", roomId);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("total_duration_ms", max);
            jSONObject2.put("release_to_final_ms", max2);
            jSONObject2.put("recognized_text_length", finalText.length());
            jSONObject2.put("asr_callback_count", this.asrCallbackCount);
            jSONObject2.put("subv_message_count", this.subvMessageCount);
            ApmService.INSTANCE.monitorEventForSlardar(EVENT_SESSION_PERF, new JSONObject(), jSONObject2, jSONObject);
            IApplog.Companion companion = IApplog.INSTANCE;
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("total_duration_ms", max);
            jSONObject3.put("release_to_final_ms", max2);
            jSONObject3.put("recognized_text_length", finalText.length());
            jSONObject3.put("asr_callback_count", this.asrCallbackCount);
            jSONObject3.put("subv_message_count", this.subvMessageCount);
            jSONObject3.put("room_id", roomId);
            Unit unit = Unit.INSTANCE;
            companion.reportEvent(EVENT_SESSION_PERF, jSONObject3);
        } catch (Throwable th) {
            FLog.w(TAG, "reportVoiceSessionPerf failed", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d A[Catch: all -> 0x00dd, TryCatch #2 {all -> 0x00dd, blocks: (B:3:0x0017, B:7:0x0020, B:9:0x0024, B:12:0x002e, B:14:0x0034, B:16:0x003d, B:17:0x0047, B:19:0x004d, B:21:0x0057, B:22:0x0062, B:25:0x0071, B:41:0x0069), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0069 A[Catch: all -> 0x00dd, TryCatch #2 {all -> 0x00dd, blocks: (B:3:0x0017, B:7:0x0020, B:9:0x0024, B:12:0x002e, B:14:0x0034, B:16:0x003d, B:17:0x0047, B:19:0x004d, B:21:0x0057, B:22:0x0062, B:25:0x0071, B:41:0x0069), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void reportVoiceStartPerf(int type) {
        String str;
        String str2;
        long j;
        long j2;
        String str3;
        String str4;
        long j3;
        long j4;
        try {
            if (this.voiceStartTimestamp <= 0) {
                return;
            }
            StartVoiceChatData startVoiceChatData = this.voiceChat;
            String roomId = startVoiceChatData != null ? startVoiceChatData.getRoomId() : null;
            if (roomId == null) {
                roomId = "";
            }
            long j5 = this.perfStartVoiceChatTimestamp;
            try {
                try {
                    if (j5 > 0) {
                        str = EVENT_START_PERF;
                        str2 = "start_capture_ms";
                        long j6 = this.perfApiRequestEndTimestamp;
                        if (j6 > 0) {
                            j = Math.max(j6 - j5, 0L);
                            j2 = this.perfJoinRoomTimestamp;
                            if (j2 <= 0) {
                                str3 = "from_type";
                                str4 = "total_ms";
                                long j7 = this.perfJoinRoomSuccessTimestamp;
                                if (j7 > 0) {
                                    j3 = Math.max(j7 - j2, 0L);
                                    j4 = this.perfPublishStreamTimestamp;
                                    if (j4 <= 0) {
                                        j4 = Math.max(this.voiceReleaseTimestamp, this.voiceStartTimestamp);
                                    }
                                    long max = Math.max(j4 - this.voiceStartTimestamp, 0L);
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("room_id", roomId);
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("start_voice_chat_request_ms", j);
                                    jSONObject2.put("join_room_ms", j3);
                                    String str5 = str4;
                                    jSONObject2.put(str5, max);
                                    String str6 = str;
                                    String str7 = str3;
                                    jSONObject2.put(str7, type);
                                    String str8 = roomId;
                                    String str9 = str2;
                                    jSONObject2.put(str9, this.voiceStartCaptureDuration);
                                    ApmService.INSTANCE.monitorEventForSlardar(str6, (JSONObject) null, jSONObject2, jSONObject);
                                    IApplog.Companion companion = IApplog.INSTANCE;
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put("start_voice_chat_request_ms", j);
                                    jSONObject3.put("join_room_ms", j3);
                                    jSONObject3.put(str5, max);
                                    jSONObject3.put(str7, type);
                                    jSONObject3.put(str9, this.voiceStartCaptureDuration);
                                    jSONObject3.put("room_id", str8);
                                    Unit unit = Unit.INSTANCE;
                                    companion.reportEvent(str6, jSONObject3);
                                    return;
                                }
                            } else {
                                str3 = "from_type";
                                str4 = "total_ms";
                            }
                            j3 = 0;
                            j4 = this.perfPublishStreamTimestamp;
                            if (j4 <= 0) {
                            }
                            long max2 = Math.max(j4 - this.voiceStartTimestamp, 0L);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("room_id", roomId);
                            JSONObject jSONObject22 = new JSONObject();
                            jSONObject22.put("start_voice_chat_request_ms", j);
                            jSONObject22.put("join_room_ms", j3);
                            String str52 = str4;
                            jSONObject22.put(str52, max2);
                            String str62 = str;
                            String str72 = str3;
                            jSONObject22.put(str72, type);
                            String str82 = roomId;
                            String str92 = str2;
                            jSONObject22.put(str92, this.voiceStartCaptureDuration);
                            ApmService.INSTANCE.monitorEventForSlardar(str62, (JSONObject) null, jSONObject22, jSONObject4);
                            IApplog.Companion companion2 = IApplog.INSTANCE;
                            JSONObject jSONObject32 = new JSONObject();
                            jSONObject32.put("start_voice_chat_request_ms", j);
                            jSONObject32.put("join_room_ms", j3);
                            jSONObject32.put(str52, max2);
                            jSONObject32.put(str72, type);
                            jSONObject32.put(str92, this.voiceStartCaptureDuration);
                            jSONObject32.put("room_id", str82);
                            Unit unit2 = Unit.INSTANCE;
                            companion2.reportEvent(str62, jSONObject32);
                            return;
                        }
                    } else {
                        str = EVENT_START_PERF;
                        str2 = "start_capture_ms";
                    }
                    jSONObject32.put(str92, this.voiceStartCaptureDuration);
                    jSONObject32.put("room_id", str82);
                    Unit unit22 = Unit.INSTANCE;
                    companion2.reportEvent(str62, jSONObject32);
                    return;
                } catch (Throwable th) {
                    th = th;
                    FLog.w(TAG, "reportVoiceStartPerf failed", th);
                    return;
                }
                jSONObject22.put(str92, this.voiceStartCaptureDuration);
                ApmService.INSTANCE.monitorEventForSlardar(str62, (JSONObject) null, jSONObject22, jSONObject4);
                IApplog.Companion companion22 = IApplog.INSTANCE;
                JSONObject jSONObject322 = new JSONObject();
                jSONObject322.put("start_voice_chat_request_ms", j);
                jSONObject322.put("join_room_ms", j3);
                jSONObject322.put(str52, max2);
                jSONObject322.put(str72, type);
            } catch (Throwable th2) {
                th = th2;
            }
            j = 0;
            j2 = this.perfJoinRoomTimestamp;
            if (j2 <= 0) {
            }
            j3 = 0;
            j4 = this.perfPublishStreamTimestamp;
            if (j4 <= 0) {
            }
            long max22 = Math.max(j4 - this.voiceStartTimestamp, 0L);
            JSONObject jSONObject42 = new JSONObject();
            jSONObject42.put("room_id", roomId);
            JSONObject jSONObject222 = new JSONObject();
            jSONObject222.put("start_voice_chat_request_ms", j);
            jSONObject222.put("join_room_ms", j3);
            String str522 = str4;
            jSONObject222.put(str522, max22);
            String str622 = str;
            String str722 = str3;
            jSONObject222.put(str722, type);
            String str822 = roomId;
            String str922 = str2;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private final void emitConversationState(ConversationStateMessage state) {
        FLogger.INSTANCE.d(TAG, "emitConversationState:" + state);
        if (state.getStage().getCode() == 2 && this.hasStartedVoiceChat) {
            VolcRtcClient.INSTANCE.removeListener(this.rtcListener);
            String str = this.botCompleteText;
            if (StringsKt.isBlank(str)) {
                str = this.currentRecognizedText;
            }
            String str2 = str;
            this.attemptTracker.markFinalText(str2, StringsKt.isBlank(str2) ? VoiceAttemptMetricsTracker.FINAL_SOURCE_EMPTY : VoiceAttemptMetricsTracker.FINAL_SOURCE_CONV_THINKING);
            reportVoiceStartPerf(1);
            reportVoiceSessionPerf(str2);
            emitFinalText(str2);
            stopInternal();
            this.botCompleteText = "";
            this.currentRecognizedText = "";
            this.definiteText = "";
        }
    }

    private final void handleSubvMessage(String uid, byte[] message) {
        try {
            this.subvMessageCount++;
            this.attemptTracker.onFirstSubv();
            SubtitleBinaryProtocol.SubtitlePayload unpackSubvMessage = SubtitleBinaryProtocol.INSTANCE.unpackSubvMessage(message);
            if (unpackSubvMessage == null) {
                FLog.w(TAG, "subtitle unpack failed: size=" + message.length + ", head=" + CollectionsKt.joinToString$default(ArraysKt.take(message, 16), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        CharSequence handleSubvMessage$lambda$7;
                        handleSubvMessage$lambda$7 = TranscriptionVoiceManager.handleSubvMessage$lambda$7(((Byte) obj).byteValue());
                        return handleSubvMessage$lambda$7;
                    }
                }, 30, (Object) null));
                return;
            }
            StartVoiceChatData startVoiceChatData = this.voiceChat;
            String botName = startVoiceChatData != null ? startVoiceChatData.getBotName() : null;
            BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new TranscriptionVoiceManager$handleSubvMessage$2(unpackSubvMessage, botName == null ? "" : botName, this, uid, null), 3, (Object) null);
        } catch (Throwable th) {
            FLog.w(TAG, "handleSubvMessage error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence handleSubvMessage$lambda$7(byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* compiled from: TranscriptionVoiceManager.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Companion;", "", "<init>", "()V", "TAG", "", "POLL_INTERVAL_MS", "", "EVENT_SESSION_PERF", "EVENT_START_PERF", "OUTCOME_AUTO_SEND", "OUTCOME_FILL_INPUT", "OUTCOME_EMPTY_TEXT", "OUTCOME_CANCEL", "OUTCOME_START_FAILED", "OUTCOME_ERROR", "failureReasonFor", "error", "", "reportImmediateAttemptEnd", "", "outcome", "failureReason", "inputStateWhenFinal", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String failureReasonFor(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return VoiceAttemptMetricsTracker.INSTANCE.failureReasonFor(error);
        }

        public final void reportImmediateAttemptEnd(String outcome, String failureReason, String inputStateWhenFinal) {
            Intrinsics.checkNotNullParameter(outcome, "outcome");
            Intrinsics.checkNotNullParameter(failureReason, "failureReason");
            Intrinsics.checkNotNullParameter(inputStateWhenFinal, "inputStateWhenFinal");
            VoiceAttemptMetricsTracker.INSTANCE.reportImmediate(outcome, failureReason, inputStateWhenFinal);
        }
    }
}
