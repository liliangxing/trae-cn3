package com.bytedance.trae.conversation.voice;

import android.os.SystemClock;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.ReducerConstants;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.facebook.common.logging.FLog;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: VoiceAttemptMetricsTracker.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0000\u0018\u0000 I2\u00020\u0001:\u0002HIBY\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010#\u001a\u00020\nJ\u0016\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006J\u000e\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0006J\u0006\u0010)\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u001aJ\u0006\u0010,\u001a\u00020\nJ\u000e\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\"J\u0016\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006J\u0006\u00102\u001a\u00020\nJ&\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u000208J\u0006\u0010:\u001a\u00020\nJ\r\u0010;\u001a\u00020\u001aH\u0000¢\u0006\u0002\b<J\r\u0010=\u001a\u00020\u0004H\u0000¢\u0006\u0002\b>J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0002J\u0010\u0010A\u001a\u00020\u00042\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010B\u001a\u00020\u00042\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010C\u001a\u00020\u00042\u0006\u00107\u001a\u000208H\u0002J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020EH\u0002J\u0010\u0010G\u001a\u00020\"2\u0006\u00107\u001a\u000208H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;", "", "elapsedRealtime", "Lkotlin/Function0;", "", "traceIdFactory", "", "reportEvent", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "", "logEventForLocalDebug", "Lkotlin/Function1;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "transcriptionTraceId", "attemptRoomId", "attemptTaskId", "attemptStartElapsedMs", "voiceReleaseElapsedMs", "finalTextElapsedMs", "firstVoiceVolumeElapsedMs", "firstSubvElapsedMs", "firstRecognizedTextElapsedMs", "lastRecognizedTextElapsedMs", "volumeSampleCount", "", "volumeSum", "maxVolume", "silentVolumeSampleCount", "finalTextLength", "finalSource", "startPath", "attemptReported", "", "reset", "captureVoiceChatData", "roomId", "taskId", "setStartPath", "path", "onVoiceRelease", "onAudioVolume", "volume", "onFirstSubv", "onRecognizedText", "isNotBlank", "markFinalText", "text", TimonPipeline.KEY_SOURCE, "setFinalSourceCancel", "report", "outcome", "failureReason", "inputStateWhenFinal", "session", "Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;", "_paragraphCount", "onParagraph", "paragraphCount", "paragraphCount$conversation_mainlandRelease", "recordingDurationMs", "recordingDurationMs$conversation_mainlandRelease", "deltaFromAttemptStart", "timestampMs", "computeStartVoiceChatRequestMs", "computeJoinRoomMs", "computeStartTotalMs", "averageVolume", "", "silentRatio", "hasReceivedVoiceDuringAttempt", "SessionSnapshot", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceAttemptMetricsTracker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String ERROR_REASON_THROWABLE = "Throwable";
    public static final String EVENT_ATTEMPT_END = "voice_transcription_attempt_end";
    private static final String FINAL_SOURCE_CANCEL = "cancel";
    public static final String FINAL_SOURCE_CONV_THINKING = "conv_thinking";
    public static final String FINAL_SOURCE_CURRENT_TEXT_FALLBACK = "current_text_fallback";
    public static final String FINAL_SOURCE_EMPTY = "empty";
    public static final String FINAL_SOURCE_PARAGRAPH = "paragraph";
    private static final String FINAL_SOURCE_UNKNOWN = "unknown";
    private static final int FIRST_VOICE_VOLUME_THRESHOLD = 13;
    public static final String INPUT_STATE_UNKNOWN = "unknown";
    private static final int MAX_FAILURE_REASON_LENGTH = 120;
    public static final String OUTCOME_AUTO_SEND = "auto_send";
    public static final String OUTCOME_CANCEL = "cancel";
    public static final String OUTCOME_EMPTY_TEXT = "empty_text";
    public static final String OUTCOME_ERROR = "error";
    public static final String OUTCOME_FILL_INPUT = "fill_input";
    public static final String OUTCOME_START_FAILED = "start_failed";
    private static final long PERF_MISSING_VALUE = -1;
    private static final int SILENT_VOLUME_THRESHOLD = 5;
    public static final String START_PATH_CACHED_JOIN_FIRST = "cached_join_first";
    public static final String START_PATH_COLD_API = "cold_api";
    private static final String START_PATH_UNKNOWN = "unknown";
    private static final String TAG = "VoiceChatSession";
    private int _paragraphCount;
    private boolean attemptReported;
    private String attemptRoomId;
    private long attemptStartElapsedMs;
    private String attemptTaskId;
    private final Function0<Long> elapsedRealtime;
    private String finalSource;
    private long finalTextElapsedMs;
    private int finalTextLength;
    private long firstRecognizedTextElapsedMs;
    private long firstSubvElapsedMs;
    private long firstVoiceVolumeElapsedMs;
    private long lastRecognizedTextElapsedMs;
    private final Function1<JSONObject, Unit> logEventForLocalDebug;
    private int maxVolume;
    private final Function2<String, JSONObject, Unit> reportEvent;
    private int silentVolumeSampleCount;
    private String startPath;
    private final Function0<String> traceIdFactory;
    private String transcriptionTraceId;
    private long voiceReleaseElapsedMs;
    private int volumeSampleCount;
    private long volumeSum;

    public VoiceAttemptMetricsTracker() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VoiceAttemptMetricsTracker(Function0<Long> function0, Function0<String> function02, Function2<? super String, ? super JSONObject, Unit> function2, Function1<? super JSONObject, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, "elapsedRealtime");
        Intrinsics.checkNotNullParameter(function02, "traceIdFactory");
        Intrinsics.checkNotNullParameter(function2, "reportEvent");
        Intrinsics.checkNotNullParameter(function1, "logEventForLocalDebug");
        this.elapsedRealtime = function0;
        this.traceIdFactory = function02;
        this.reportEvent = function2;
        this.logEventForLocalDebug = function1;
        this.transcriptionTraceId = "";
        this.attemptRoomId = "";
        this.attemptTaskId = "";
        this.maxVolume = -1;
        this.finalSource = "unknown";
        this.startPath = "unknown";
    }

    public /* synthetic */ VoiceAttemptMetricsTracker(Function0 function0, Function0 function02, Function2 function2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0() { // from class: com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$$ExternalSyntheticLambda0
            public final Object invoke() {
                long _init_$lambda$0;
                _init_$lambda$0 = VoiceAttemptMetricsTracker._init_$lambda$0();
                return Long.valueOf(_init_$lambda$0);
            }
        } : function0, (i & 2) != 0 ? new Function0() { // from class: com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$$ExternalSyntheticLambda1
            public final Object invoke() {
                String _init_$lambda$1;
                _init_$lambda$1 = VoiceAttemptMetricsTracker._init_$lambda$1();
                return _init_$lambda$1;
            }
        } : function02, (i & 4) != 0 ? new Function2() { // from class: com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit _init_$lambda$2;
                _init_$lambda$2 = VoiceAttemptMetricsTracker._init_$lambda$2((String) obj, (JSONObject) obj2);
                return _init_$lambda$2;
            }
        } : function2, (i & 8) != 0 ? new Function1() { // from class: com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit _init_$lambda$3;
                _init_$lambda$3 = VoiceAttemptMetricsTracker._init_$lambda$3((JSONObject) obj);
                return _init_$lambda$3;
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _init_$lambda$0() {
        return SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$1() {
        return UUID.randomUUID().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$2(String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, Fields.EVENT);
        Intrinsics.checkNotNullParameter(jSONObject, "params");
        IApplog.INSTANCE.reportEvent(str, jSONObject);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$3(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "params");
        INSTANCE.logAttemptEndForLocalDebug(jSONObject);
        return Unit.INSTANCE;
    }

    /* compiled from: VoiceAttemptMetricsTracker.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u000fHÆ\u0003J\t\u0010,\u001a\u00020\u000fHÆ\u0003Jw\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fHÆ\u0001J\u0013\u0010.\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u000fHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 ¨\u00062"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;", "", "conversationId", "", "hasReceiveVoice", "", "voiceStartTimestamp", "", "voiceReleaseTimestamp", "perfStartVoiceChatTimestamp", "perfApiRequestEndTimestamp", "perfJoinRoomTimestamp", "perfJoinRoomSuccessTimestamp", "perfPublishStreamTimestamp", "subvMessageCount", "", "asrCallbackCount", "<init>", "(Ljava/lang/String;ZJJJJJJJII)V", "getConversationId", "()Ljava/lang/String;", "getHasReceiveVoice", "()Z", "getVoiceStartTimestamp", "()J", "getVoiceReleaseTimestamp", "getPerfStartVoiceChatTimestamp", "getPerfApiRequestEndTimestamp", "getPerfJoinRoomTimestamp", "getPerfJoinRoomSuccessTimestamp", "getPerfPublishStreamTimestamp", "getSubvMessageCount", "()I", "getAsrCallbackCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class SessionSnapshot {
        private final int asrCallbackCount;
        private final String conversationId;
        private final boolean hasReceiveVoice;
        private final long perfApiRequestEndTimestamp;
        private final long perfJoinRoomSuccessTimestamp;
        private final long perfJoinRoomTimestamp;
        private final long perfPublishStreamTimestamp;
        private final long perfStartVoiceChatTimestamp;
        private final int subvMessageCount;
        private final long voiceReleaseTimestamp;
        private final long voiceStartTimestamp;

        /* renamed from: component1, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        /* renamed from: component10, reason: from getter */
        public final int getSubvMessageCount() {
            return this.subvMessageCount;
        }

        /* renamed from: component11, reason: from getter */
        public final int getAsrCallbackCount() {
            return this.asrCallbackCount;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getHasReceiveVoice() {
            return this.hasReceiveVoice;
        }

        /* renamed from: component3, reason: from getter */
        public final long getVoiceStartTimestamp() {
            return this.voiceStartTimestamp;
        }

        /* renamed from: component4, reason: from getter */
        public final long getVoiceReleaseTimestamp() {
            return this.voiceReleaseTimestamp;
        }

        /* renamed from: component5, reason: from getter */
        public final long getPerfStartVoiceChatTimestamp() {
            return this.perfStartVoiceChatTimestamp;
        }

        /* renamed from: component6, reason: from getter */
        public final long getPerfApiRequestEndTimestamp() {
            return this.perfApiRequestEndTimestamp;
        }

        /* renamed from: component7, reason: from getter */
        public final long getPerfJoinRoomTimestamp() {
            return this.perfJoinRoomTimestamp;
        }

        /* renamed from: component8, reason: from getter */
        public final long getPerfJoinRoomSuccessTimestamp() {
            return this.perfJoinRoomSuccessTimestamp;
        }

        /* renamed from: component9, reason: from getter */
        public final long getPerfPublishStreamTimestamp() {
            return this.perfPublishStreamTimestamp;
        }

        public final SessionSnapshot copy(String conversationId, boolean hasReceiveVoice, long voiceStartTimestamp, long voiceReleaseTimestamp, long perfStartVoiceChatTimestamp, long perfApiRequestEndTimestamp, long perfJoinRoomTimestamp, long perfJoinRoomSuccessTimestamp, long perfPublishStreamTimestamp, int subvMessageCount, int asrCallbackCount) {
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            return new SessionSnapshot(conversationId, hasReceiveVoice, voiceStartTimestamp, voiceReleaseTimestamp, perfStartVoiceChatTimestamp, perfApiRequestEndTimestamp, perfJoinRoomTimestamp, perfJoinRoomSuccessTimestamp, perfPublishStreamTimestamp, subvMessageCount, asrCallbackCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SessionSnapshot)) {
                return false;
            }
            SessionSnapshot sessionSnapshot = (SessionSnapshot) other;
            return Intrinsics.areEqual(this.conversationId, sessionSnapshot.conversationId) && this.hasReceiveVoice == sessionSnapshot.hasReceiveVoice && this.voiceStartTimestamp == sessionSnapshot.voiceStartTimestamp && this.voiceReleaseTimestamp == sessionSnapshot.voiceReleaseTimestamp && this.perfStartVoiceChatTimestamp == sessionSnapshot.perfStartVoiceChatTimestamp && this.perfApiRequestEndTimestamp == sessionSnapshot.perfApiRequestEndTimestamp && this.perfJoinRoomTimestamp == sessionSnapshot.perfJoinRoomTimestamp && this.perfJoinRoomSuccessTimestamp == sessionSnapshot.perfJoinRoomSuccessTimestamp && this.perfPublishStreamTimestamp == sessionSnapshot.perfPublishStreamTimestamp && this.subvMessageCount == sessionSnapshot.subvMessageCount && this.asrCallbackCount == sessionSnapshot.asrCallbackCount;
        }

        public int hashCode() {
            return (((((((((((((((((((this.conversationId.hashCode() * 31) + Boolean.hashCode(this.hasReceiveVoice)) * 31) + Long.hashCode(this.voiceStartTimestamp)) * 31) + Long.hashCode(this.voiceReleaseTimestamp)) * 31) + Long.hashCode(this.perfStartVoiceChatTimestamp)) * 31) + Long.hashCode(this.perfApiRequestEndTimestamp)) * 31) + Long.hashCode(this.perfJoinRoomTimestamp)) * 31) + Long.hashCode(this.perfJoinRoomSuccessTimestamp)) * 31) + Long.hashCode(this.perfPublishStreamTimestamp)) * 31) + Integer.hashCode(this.subvMessageCount)) * 31) + Integer.hashCode(this.asrCallbackCount);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("SessionSnapshot(conversationId=");
            sb.append(this.conversationId).append(", hasReceiveVoice=").append(this.hasReceiveVoice).append(", voiceStartTimestamp=").append(this.voiceStartTimestamp).append(", voiceReleaseTimestamp=").append(this.voiceReleaseTimestamp).append(", perfStartVoiceChatTimestamp=").append(this.perfStartVoiceChatTimestamp).append(", perfApiRequestEndTimestamp=").append(this.perfApiRequestEndTimestamp).append(", perfJoinRoomTimestamp=").append(this.perfJoinRoomTimestamp).append(", perfJoinRoomSuccessTimestamp=").append(this.perfJoinRoomSuccessTimestamp).append(", perfPublishStreamTimestamp=").append(this.perfPublishStreamTimestamp).append(", subvMessageCount=").append(this.subvMessageCount).append(", asrCallbackCount=").append(this.asrCallbackCount).append(')');
            return sb.toString();
        }

        public SessionSnapshot(String str, boolean z, long j, long j2, long j3, long j4, long j5, long j6, long j7, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.conversationId = str;
            this.hasReceiveVoice = z;
            this.voiceStartTimestamp = j;
            this.voiceReleaseTimestamp = j2;
            this.perfStartVoiceChatTimestamp = j3;
            this.perfApiRequestEndTimestamp = j4;
            this.perfJoinRoomTimestamp = j5;
            this.perfJoinRoomSuccessTimestamp = j6;
            this.perfPublishStreamTimestamp = j7;
            this.subvMessageCount = i;
            this.asrCallbackCount = i2;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final boolean getHasReceiveVoice() {
            return this.hasReceiveVoice;
        }

        public final long getVoiceStartTimestamp() {
            return this.voiceStartTimestamp;
        }

        public final long getVoiceReleaseTimestamp() {
            return this.voiceReleaseTimestamp;
        }

        public final long getPerfStartVoiceChatTimestamp() {
            return this.perfStartVoiceChatTimestamp;
        }

        public final long getPerfApiRequestEndTimestamp() {
            return this.perfApiRequestEndTimestamp;
        }

        public final long getPerfJoinRoomTimestamp() {
            return this.perfJoinRoomTimestamp;
        }

        public final long getPerfJoinRoomSuccessTimestamp() {
            return this.perfJoinRoomSuccessTimestamp;
        }

        public final long getPerfPublishStreamTimestamp() {
            return this.perfPublishStreamTimestamp;
        }

        public final int getSubvMessageCount() {
            return this.subvMessageCount;
        }

        public final int getAsrCallbackCount() {
            return this.asrCallbackCount;
        }
    }

    public final void reset() {
        this.transcriptionTraceId = (String) this.traceIdFactory.invoke();
        this.attemptRoomId = "";
        this.attemptTaskId = "";
        this.attemptStartElapsedMs = ((Number) this.elapsedRealtime.invoke()).longValue();
        this.voiceReleaseElapsedMs = 0L;
        this.finalTextElapsedMs = 0L;
        this.firstVoiceVolumeElapsedMs = 0L;
        this.firstSubvElapsedMs = 0L;
        this.firstRecognizedTextElapsedMs = 0L;
        this.lastRecognizedTextElapsedMs = 0L;
        this.volumeSampleCount = 0;
        this.volumeSum = 0L;
        this.maxVolume = -1;
        this.silentVolumeSampleCount = 0;
        this.finalTextLength = 0;
        this.finalSource = "unknown";
        this.startPath = "unknown";
        this._paragraphCount = 0;
        this.attemptReported = false;
    }

    public final void captureVoiceChatData(String roomId, String taskId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.attemptRoomId = roomId;
        this.attemptTaskId = taskId;
    }

    public final void setStartPath(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.startPath = path;
    }

    public final void onVoiceRelease() {
        if (this.voiceReleaseElapsedMs == 0) {
            this.voiceReleaseElapsedMs = ((Number) this.elapsedRealtime.invoke()).longValue();
        }
    }

    public final void onAudioVolume(int volume) {
        if (this.attemptStartElapsedMs <= 0 || this.attemptReported) {
            return;
        }
        int coerceIn = RangesKt.coerceIn(volume, 0, ReducerConstants.REQUEST_CODE);
        this.volumeSampleCount++;
        this.volumeSum += coerceIn;
        this.maxVolume = Math.max(this.maxVolume, coerceIn);
        if (coerceIn < 5) {
            this.silentVolumeSampleCount++;
        }
        if (this.firstVoiceVolumeElapsedMs != 0 || coerceIn < 13) {
            return;
        }
        this.firstVoiceVolumeElapsedMs = ((Number) this.elapsedRealtime.invoke()).longValue();
    }

    public final void onFirstSubv() {
        if (this.firstSubvElapsedMs == 0) {
            this.firstSubvElapsedMs = ((Number) this.elapsedRealtime.invoke()).longValue();
        }
    }

    public final void onRecognizedText(boolean isNotBlank) {
        if (isNotBlank) {
            long longValue = ((Number) this.elapsedRealtime.invoke()).longValue();
            if (this.firstRecognizedTextElapsedMs == 0) {
                this.firstRecognizedTextElapsedMs = longValue;
            }
            this.lastRecognizedTextElapsedMs = longValue;
        }
    }

    public final void markFinalText(String text, String source) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
        this.finalTextElapsedMs = ((Number) this.elapsedRealtime.invoke()).longValue();
        this.finalTextLength = text.length();
        this.finalSource = source;
    }

    public final void setFinalSourceCancel() {
        this.finalSource = "cancel";
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005e A[Catch: all -> 0x017f, TryCatch #0 {all -> 0x017f, blocks: (B:7:0x0030, B:9:0x0046, B:11:0x004e, B:12:0x0056, B:14:0x005e, B:15:0x0067, B:18:0x016e), top: B:6:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void report(String outcome, String failureReason, String inputStateWhenFinal, SessionSnapshot session) {
        long j;
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        Intrinsics.checkNotNullParameter(inputStateWhenFinal, "inputStateWhenFinal");
        Intrinsics.checkNotNullParameter(session, "session");
        if (this.attemptStartElapsedMs <= 0 || this.attemptReported) {
            return;
        }
        this.attemptReported = true;
        try {
            long longValue = ((Number) this.elapsedRealtime.invoke()).longValue();
            long recordingDurationMs$conversation_mainlandRelease = recordingDurationMs$conversation_mainlandRelease();
            long j2 = this.voiceReleaseElapsedMs;
            if (j2 > 0) {
                long j3 = this.finalTextElapsedMs;
                if (j3 > 0) {
                    j = RangesKt.coerceAtLeast(j3 - j2, 0L);
                    long j4 = this.finalTextElapsedMs;
                    long coerceAtLeast = j4 <= 0 ? RangesKt.coerceAtLeast(longValue - j4, 0L) : -1L;
                    long coerceAtLeast2 = RangesKt.coerceAtLeast(longValue - this.attemptStartElapsedMs, 0L);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("trace_id", this.transcriptionTraceId);
                    jSONObject.put("conversation_id", session.getConversationId());
                    jSONObject.put("room_id", this.attemptRoomId);
                    jSONObject.put(NewTaskTracker.Param.TASK_ID, this.attemptTaskId);
                    jSONObject.put("start_path", this.startPath);
                    jSONObject.put("outcome", outcome);
                    jSONObject.put("failure_reason", INSTANCE.normalizeFailureReason(failureReason));
                    jSONObject.put("recording_duration_ms", recordingDurationMs$conversation_mainlandRelease);
                    jSONObject.put("start_total_ms", computeStartTotalMs(session));
                    jSONObject.put("start_voice_chat_request_ms", computeStartVoiceChatRequestMs(session));
                    jSONObject.put("join_room_ms", computeJoinRoomMs(session));
                    jSONObject.put("first_voice_volume_ms", deltaFromAttemptStart(this.firstVoiceVolumeElapsedMs));
                    jSONObject.put("first_subv_ms", deltaFromAttemptStart(this.firstSubvElapsedMs));
                    jSONObject.put("first_recognized_text_ms", deltaFromAttemptStart(this.firstRecognizedTextElapsedMs));
                    jSONObject.put("last_recognized_text_ms", deltaFromAttemptStart(this.lastRecognizedTextElapsedMs));
                    jSONObject.put("release_to_final_ms", j);
                    jSONObject.put("final_to_apply_ms", coerceAtLeast);
                    jSONObject.put("total_duration_ms", coerceAtLeast2);
                    jSONObject.put("recognized_text_length", this.finalTextLength);
                    jSONObject.put("asr_callback_count", session.getAsrCallbackCount());
                    jSONObject.put("subv_message_count", session.getSubvMessageCount());
                    jSONObject.put("paragraph_count", get_paragraphCount());
                    jSONObject.put("avg_volume", averageVolume());
                    jSONObject.put("max_volume", this.maxVolume);
                    jSONObject.put("silent_ratio", silentRatio());
                    jSONObject.put("network_rtt_ms", -1L);
                    jSONObject.put("packet_loss", -1L);
                    jSONObject.put("input_state_when_final", inputStateWhenFinal);
                    jSONObject.put("final_source", this.finalSource);
                    jSONObject.put("has_receive_voice", !hasReceivedVoiceDuringAttempt(session) ? "1" : "0");
                    this.logEventForLocalDebug.invoke(jSONObject);
                    this.reportEvent.invoke(EVENT_ATTEMPT_END, jSONObject);
                }
            }
            j = -1;
            long j42 = this.finalTextElapsedMs;
            if (j42 <= 0) {
            }
            long coerceAtLeast22 = RangesKt.coerceAtLeast(longValue - this.attemptStartElapsedMs, 0L);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("trace_id", this.transcriptionTraceId);
            jSONObject2.put("conversation_id", session.getConversationId());
            jSONObject2.put("room_id", this.attemptRoomId);
            jSONObject2.put(NewTaskTracker.Param.TASK_ID, this.attemptTaskId);
            jSONObject2.put("start_path", this.startPath);
            jSONObject2.put("outcome", outcome);
            jSONObject2.put("failure_reason", INSTANCE.normalizeFailureReason(failureReason));
            jSONObject2.put("recording_duration_ms", recordingDurationMs$conversation_mainlandRelease);
            jSONObject2.put("start_total_ms", computeStartTotalMs(session));
            jSONObject2.put("start_voice_chat_request_ms", computeStartVoiceChatRequestMs(session));
            jSONObject2.put("join_room_ms", computeJoinRoomMs(session));
            jSONObject2.put("first_voice_volume_ms", deltaFromAttemptStart(this.firstVoiceVolumeElapsedMs));
            jSONObject2.put("first_subv_ms", deltaFromAttemptStart(this.firstSubvElapsedMs));
            jSONObject2.put("first_recognized_text_ms", deltaFromAttemptStart(this.firstRecognizedTextElapsedMs));
            jSONObject2.put("last_recognized_text_ms", deltaFromAttemptStart(this.lastRecognizedTextElapsedMs));
            jSONObject2.put("release_to_final_ms", j);
            jSONObject2.put("final_to_apply_ms", coerceAtLeast);
            jSONObject2.put("total_duration_ms", coerceAtLeast22);
            jSONObject2.put("recognized_text_length", this.finalTextLength);
            jSONObject2.put("asr_callback_count", session.getAsrCallbackCount());
            jSONObject2.put("subv_message_count", session.getSubvMessageCount());
            jSONObject2.put("paragraph_count", get_paragraphCount());
            jSONObject2.put("avg_volume", averageVolume());
            jSONObject2.put("max_volume", this.maxVolume);
            jSONObject2.put("silent_ratio", silentRatio());
            jSONObject2.put("network_rtt_ms", -1L);
            jSONObject2.put("packet_loss", -1L);
            jSONObject2.put("input_state_when_final", inputStateWhenFinal);
            jSONObject2.put("final_source", this.finalSource);
            jSONObject2.put("has_receive_voice", !hasReceivedVoiceDuringAttempt(session) ? "1" : "0");
            this.logEventForLocalDebug.invoke(jSONObject2);
            this.reportEvent.invoke(EVENT_ATTEMPT_END, jSONObject2);
        } catch (Throwable th) {
            FLog.w(TAG, "reportAttemptEnd failed", th);
        }
    }

    public final void onParagraph() {
        this._paragraphCount++;
    }

    /* renamed from: paragraphCount$conversation_mainlandRelease, reason: from getter */
    public final int get_paragraphCount() {
        return this._paragraphCount;
    }

    public final long recordingDurationMs$conversation_mainlandRelease() {
        long j = this.voiceReleaseElapsedMs;
        if (j > 0) {
            long j2 = this.attemptStartElapsedMs;
            if (j2 > 0) {
                return RangesKt.coerceAtLeast(j - j2, 0L);
            }
        }
        return -1L;
    }

    private final long deltaFromAttemptStart(long timestampMs) {
        if (timestampMs > 0) {
            long j = this.attemptStartElapsedMs;
            if (j > 0) {
                return RangesKt.coerceAtLeast(timestampMs - j, 0L);
            }
        }
        return -1L;
    }

    private final long computeStartVoiceChatRequestMs(SessionSnapshot session) {
        if (session.getPerfStartVoiceChatTimestamp() <= 0 || session.getPerfApiRequestEndTimestamp() <= 0) {
            return -1L;
        }
        return RangesKt.coerceAtLeast(session.getPerfApiRequestEndTimestamp() - session.getPerfStartVoiceChatTimestamp(), 0L);
    }

    private final long computeJoinRoomMs(SessionSnapshot session) {
        if (session.getPerfJoinRoomTimestamp() <= 0 || session.getPerfJoinRoomSuccessTimestamp() <= 0) {
            return -1L;
        }
        return RangesKt.coerceAtLeast(session.getPerfJoinRoomSuccessTimestamp() - session.getPerfJoinRoomTimestamp(), 0L);
    }

    private final long computeStartTotalMs(SessionSnapshot session) {
        if (session.getVoiceStartTimestamp() <= 0) {
            return -1L;
        }
        long perfPublishStreamTimestamp = session.getPerfPublishStreamTimestamp() > 0 ? session.getPerfPublishStreamTimestamp() : session.getVoiceReleaseTimestamp() > 0 ? session.getVoiceReleaseTimestamp() : 0L;
        if (perfPublishStreamTimestamp > 0) {
            return RangesKt.coerceAtLeast(perfPublishStreamTimestamp - session.getVoiceStartTimestamp(), 0L);
        }
        return -1L;
    }

    private final double averageVolume() {
        int i = this.volumeSampleCount;
        if (i > 0) {
            return this.volumeSum / i;
        }
        return -1.0d;
    }

    private final double silentRatio() {
        int i = this.volumeSampleCount;
        if (i > 0) {
            return this.silentVolumeSampleCount / i;
        }
        return -1.0d;
    }

    private final boolean hasReceivedVoiceDuringAttempt(SessionSnapshot session) {
        return session.getHasReceiveVoice() || this.firstSubvElapsedMs > 0 || this.firstRecognizedTextElapsedMs > 0 || session.getSubvMessageCount() > 0 || session.getAsrCallbackCount() > 0;
    }

    /* compiled from: VoiceAttemptMetricsTracker.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$Companion;", "", "<init>", "()V", "TAG", "", "EVENT_ATTEMPT_END", "OUTCOME_AUTO_SEND", "OUTCOME_FILL_INPUT", "OUTCOME_EMPTY_TEXT", "OUTCOME_CANCEL", "OUTCOME_START_FAILED", "OUTCOME_ERROR", "START_PATH_COLD_API", "START_PATH_CACHED_JOIN_FIRST", "FINAL_SOURCE_PARAGRAPH", "FINAL_SOURCE_CURRENT_TEXT_FALLBACK", "FINAL_SOURCE_CONV_THINKING", "FINAL_SOURCE_EMPTY", "START_PATH_UNKNOWN", "FINAL_SOURCE_UNKNOWN", "FINAL_SOURCE_CANCEL", "INPUT_STATE_UNKNOWN", "PERF_MISSING_VALUE", "", "FIRST_VOICE_VOLUME_THRESHOLD", "", "SILENT_VOLUME_THRESHOLD", "reportImmediate", "", "outcome", "failureReason", "inputStateWhenFinal", "failureReasonFor", "error", "", "normalizeFailureReason", "reason", "logAttemptEndForLocalDebug", "params", "Lorg/json/JSONObject;", "ERROR_REASON_THROWABLE", "MAX_FAILURE_REASON_LENGTH", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void logAttemptEndForLocalDebug(JSONObject params) {
        }

        private Companion() {
        }

        public final void reportImmediate(String outcome, String failureReason, String inputStateWhenFinal) {
            Intrinsics.checkNotNullParameter(outcome, "outcome");
            Intrinsics.checkNotNullParameter(failureReason, "failureReason");
            Intrinsics.checkNotNullParameter(inputStateWhenFinal, "inputStateWhenFinal");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("trace_id", UUID.randomUUID().toString());
                jSONObject.put("conversation_id", "");
                jSONObject.put("room_id", "");
                jSONObject.put(NewTaskTracker.Param.TASK_ID, "");
                jSONObject.put("start_path", "unknown");
                jSONObject.put("outcome", outcome);
                jSONObject.put("failure_reason", VoiceAttemptMetricsTracker.INSTANCE.normalizeFailureReason(failureReason));
                jSONObject.put("recording_duration_ms", -1L);
                jSONObject.put("start_total_ms", -1L);
                jSONObject.put("start_voice_chat_request_ms", -1L);
                jSONObject.put("join_room_ms", -1L);
                jSONObject.put("first_voice_volume_ms", -1L);
                jSONObject.put("first_subv_ms", -1L);
                jSONObject.put("first_recognized_text_ms", -1L);
                jSONObject.put("last_recognized_text_ms", -1L);
                jSONObject.put("release_to_final_ms", -1L);
                jSONObject.put("final_to_apply_ms", -1L);
                jSONObject.put("total_duration_ms", 0L);
                jSONObject.put("recognized_text_length", 0);
                jSONObject.put("asr_callback_count", 0);
                jSONObject.put("subv_message_count", 0);
                jSONObject.put("paragraph_count", 0);
                jSONObject.put("avg_volume", -1.0d);
                jSONObject.put("max_volume", -1L);
                jSONObject.put("silent_ratio", -1.0d);
                jSONObject.put("network_rtt_ms", -1L);
                jSONObject.put("packet_loss", -1L);
                jSONObject.put("input_state_when_final", inputStateWhenFinal);
                jSONObject.put("final_source", "unknown");
                jSONObject.put("has_receive_voice", "0");
                logAttemptEndForLocalDebug(jSONObject);
                IApplog.INSTANCE.reportEvent(VoiceAttemptMetricsTracker.EVENT_ATTEMPT_END, jSONObject);
            } catch (Throwable th) {
                FLog.w(VoiceAttemptMetricsTracker.TAG, "reportImmediateAttemptEnd failed", th);
            }
        }

        public final String failureReasonFor(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            String simpleName = error.getClass().getSimpleName();
            Intrinsics.checkNotNull(simpleName);
            if (!(!StringsKt.isBlank(simpleName))) {
                simpleName = null;
            }
            if (simpleName == null) {
                simpleName = VoiceAttemptMetricsTracker.ERROR_REASON_THROWABLE;
            }
            return normalizeFailureReason(simpleName);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String normalizeFailureReason(String reason) {
            return StringsKt.take(StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(reason, '\r', ' ', false, 4, (Object) null), '\n', ' ', false, 4, (Object) null)).toString(), 120);
        }
    }
}
