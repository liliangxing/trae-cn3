package com.bytedance.trae.conversation.voice;

import android.os.SystemClock;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.conversation.network.ModelSelectionRepository;
import com.bytedance.trae.im.service.Mode;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: VoiceDiscussionAttemptTracker.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\b\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012&\b\u0002\u0010\u0007\u001a \u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\n\u0012\u0004\u0012\u00020\u000b0\b\u0012&\b\u0002\u0010\f\u001a \u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\n\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aJ\"\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020 J\u0018\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u001e\u001a\u00020\tJ\u0006\u0010$\u001a\u00020\u0015J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\u0015H\u0002J\u0014\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010(H\u0002J\b\u0010)\u001a\u00020\u0006H\u0002J$\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\t2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\nH\u0002J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\tH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0007\u001a \u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\n\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\f\u001a \u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\n\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;", "", "initialState", "Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;", "elapsedRealtime", "Lkotlin/Function0;", "", "reportEvent", "Lkotlin/Function2;", "", "", "", "logEvent", "<init>", "(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "state", IFileDataCacheService.TYPE_SNAPSHOT, "updateContext", "context", "Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;", "recordStage", "", "stage", "Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;", "onLocalAudioVolume", "volume", "", "recordSignal", "signal", "Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;", "failureReason", AccountMonitorConstants.CommonParameter.ERROR, "", "finish", "outcome", "Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;", "finishInferred", "inferOutcome", "canRecord", "baseParams", "", "elapsedSinceStart", "reportSafely", Fields.EVENT, "params", "stageOrder", "value", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceDiscussionAttemptTracker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EVENT_ATTEMPT_END = "voice_discussion_attempt_end";
    private static final float FIRST_VOICE_VOLUME_THRESHOLD = 0.05f;
    private static final int MAX_FAILURE_REASON_LENGTH = 120;
    private static final long MISSING_STAGE_MS = -1;
    private static final String TAG = "VoiceDiscussionAttempt";
    private final Function0<Long> elapsedRealtime;
    private final Function2<String, Map<String, ? extends Object>, Unit> logEvent;
    private final Function2<String, Map<String, ? extends Object>, Unit> reportEvent;
    private VoiceDiscussionAttemptState state;

    /* JADX WARN: Multi-variable type inference failed */
    public VoiceDiscussionAttemptTracker(VoiceDiscussionAttemptState voiceDiscussionAttemptState, Function0<Long> function0, Function2<? super String, ? super Map<String, ? extends Object>, Unit> function2, Function2<? super String, ? super Map<String, ? extends Object>, Unit> function22) {
        Intrinsics.checkNotNullParameter(voiceDiscussionAttemptState, "initialState");
        Intrinsics.checkNotNullParameter(function0, "elapsedRealtime");
        Intrinsics.checkNotNullParameter(function2, "reportEvent");
        Intrinsics.checkNotNullParameter(function22, "logEvent");
        this.elapsedRealtime = function0;
        this.reportEvent = function2;
        this.logEvent = function22;
        this.state = voiceDiscussionAttemptState;
    }

    public /* synthetic */ VoiceDiscussionAttemptTracker(VoiceDiscussionAttemptState voiceDiscussionAttemptState, Function0 function0, Function2 function2, Function2 function22, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(voiceDiscussionAttemptState, (i & 2) != 0 ? new Function0() { // from class: com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker$$ExternalSyntheticLambda0
            public final Object invoke() {
                long _init_$lambda$0;
                _init_$lambda$0 = VoiceDiscussionAttemptTracker._init_$lambda$0();
                return Long.valueOf(_init_$lambda$0);
            }
        } : function0, (i & 4) != 0 ? new Function2() { // from class: com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit _init_$lambda$3;
                _init_$lambda$3 = VoiceDiscussionAttemptTracker._init_$lambda$3((String) obj, (Map) obj2);
                return _init_$lambda$3;
            }
        } : function2, (i & 8) != 0 ? new Function2() { // from class: com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit _init_$lambda$4;
                _init_$lambda$4 = VoiceDiscussionAttemptTracker._init_$lambda$4((String) obj, (Map) obj2);
                return _init_$lambda$4;
            }
        } : function22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _init_$lambda$0() {
        return SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$3(String str, Map map) {
        Intrinsics.checkNotNullParameter(str, Fields.EVENT);
        Intrinsics.checkNotNullParameter(map, "params");
        IApplog.Companion companion = IApplog.INSTANCE;
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        Unit unit = Unit.INSTANCE;
        companion.reportEvent(str, jSONObject);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$4(String str, Map map) {
        Intrinsics.checkNotNullParameter(str, Fields.EVENT);
        Intrinsics.checkNotNullParameter(map, "params");
        FLogger.INSTANCE.d(TAG, str + ": " + map);
        return Unit.INSTANCE;
    }

    public final synchronized VoiceDiscussionAttemptState snapshot() {
        return this.state;
    }

    public final synchronized void updateContext(VoiceDiscussionAttemptContext context) {
        VoiceDiscussionAttemptState copy;
        Intrinsics.checkNotNullParameter(context, "context");
        if (canRecord()) {
            copy = r2.copy((r24 & 1) != 0 ? r2.attemptId : null, (r24 & 2) != 0 ? r2.startedAtElapsedMs : 0L, (r24 & 4) != 0 ? r2.context : context, (r24 & 8) != 0 ? r2.stageElapsedMs : null, (r24 & 16) != 0 ? r2.recordedSignals : null, (r24 & 32) != 0 ? r2.furthestStage : null, (r24 & 64) != 0 ? r2.latestSignal : null, (r24 & 128) != 0 ? r2.latestFailureReason : null, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r2.errorCode : 0, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? this.state.terminalReported : false);
            this.state = copy;
        }
    }

    public final synchronized boolean recordStage(VoiceDiscussionAttemptStage stage) {
        VoiceDiscussionAttemptState copy;
        Intrinsics.checkNotNullParameter(stage, "stage");
        boolean z = false;
        if (canRecord() && !this.state.getStageElapsedMs().containsKey(stage.getValue())) {
            String furthestStage = this.state.getFurthestStage();
            if (stage.getOrder() >= stageOrder(furthestStage)) {
                furthestStage = stage.getValue();
            }
            String str = furthestStage;
            if (stage == VoiceDiscussionAttemptStage.PERMISSION_GRANTED && Intrinsics.areEqual(this.state.getLatestSignal(), VoiceDiscussionAttemptSignal.PERMISSION_DENIED.getValue())) {
                z = true;
            }
            VoiceDiscussionAttemptState voiceDiscussionAttemptState = this.state;
            copy = voiceDiscussionAttemptState.copy((r24 & 1) != 0 ? voiceDiscussionAttemptState.attemptId : null, (r24 & 2) != 0 ? voiceDiscussionAttemptState.startedAtElapsedMs : 0L, (r24 & 4) != 0 ? voiceDiscussionAttemptState.context : null, (r24 & 8) != 0 ? voiceDiscussionAttemptState.stageElapsedMs : MapsKt.plus(voiceDiscussionAttemptState.getStageElapsedMs(), TuplesKt.to(stage.getValue(), Long.valueOf(elapsedSinceStart()))), (r24 & 16) != 0 ? voiceDiscussionAttemptState.recordedSignals : null, (r24 & 32) != 0 ? voiceDiscussionAttemptState.furthestStage : str, (r24 & 64) != 0 ? voiceDiscussionAttemptState.latestSignal : z ? "" : this.state.getLatestSignal(), (r24 & 128) != 0 ? voiceDiscussionAttemptState.latestFailureReason : z ? "" : this.state.getLatestFailureReason(), (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? voiceDiscussionAttemptState.errorCode : 0, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? voiceDiscussionAttemptState.terminalReported : false);
            this.state = copy;
            return true;
        }
        return false;
    }

    public final synchronized boolean onLocalAudioVolume(float volume) {
        boolean z;
        if (INSTANCE.isVoiceDetected(volume) && this.state.getStageElapsedMs().containsKey(VoiceDiscussionAttemptStage.RTC_JOINED.getValue())) {
            z = recordStage(VoiceDiscussionAttemptStage.FIRST_VOICE_DETECTED);
        }
        return z;
    }

    public static /* synthetic */ boolean recordSignal$default(VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker, VoiceDiscussionAttemptSignal voiceDiscussionAttemptSignal, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = voiceDiscussionAttemptSignal.getValue();
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return voiceDiscussionAttemptTracker.recordSignal(voiceDiscussionAttemptSignal, str, i);
    }

    public final synchronized boolean recordSignal(VoiceDiscussionAttemptSignal signal, String failureReason, int errorCode) {
        VoiceDiscussionAttemptState copy;
        Intrinsics.checkNotNullParameter(signal, "signal");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        if (canRecord() && !this.state.getRecordedSignals().contains(signal.getValue())) {
            String normalizeFailureReason = INSTANCE.normalizeFailureReason(failureReason);
            VoiceDiscussionAttemptState voiceDiscussionAttemptState = this.state;
            Set plus = SetsKt.plus(voiceDiscussionAttemptState.getRecordedSignals(), signal.getValue());
            String value = signal.getValue();
            Integer valueOf = Integer.valueOf(errorCode);
            if (!(valueOf.intValue() != 0)) {
                valueOf = null;
            }
            copy = voiceDiscussionAttemptState.copy((r24 & 1) != 0 ? voiceDiscussionAttemptState.attemptId : null, (r24 & 2) != 0 ? voiceDiscussionAttemptState.startedAtElapsedMs : 0L, (r24 & 4) != 0 ? voiceDiscussionAttemptState.context : null, (r24 & 8) != 0 ? voiceDiscussionAttemptState.stageElapsedMs : null, (r24 & 16) != 0 ? voiceDiscussionAttemptState.recordedSignals : plus, (r24 & 32) != 0 ? voiceDiscussionAttemptState.furthestStage : null, (r24 & 64) != 0 ? voiceDiscussionAttemptState.latestSignal : value, (r24 & 128) != 0 ? voiceDiscussionAttemptState.latestFailureReason : normalizeFailureReason, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? voiceDiscussionAttemptState.errorCode : valueOf != null ? valueOf.intValue() : this.state.getErrorCode(), (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? voiceDiscussionAttemptState.terminalReported : false);
            this.state = copy;
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean finish$default(VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker, VoiceDiscussionAttemptOutcome voiceDiscussionAttemptOutcome, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return voiceDiscussionAttemptTracker.finish(voiceDiscussionAttemptOutcome, str);
    }

    public final synchronized boolean finish(VoiceDiscussionAttemptOutcome outcome, String failureReason) {
        VoiceDiscussionAttemptState copy;
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        if (!canRecord()) {
            return false;
        }
        String normalizeFailureReason = INSTANCE.normalizeFailureReason(failureReason);
        copy = r4.copy((r24 & 1) != 0 ? r4.attemptId : null, (r24 & 2) != 0 ? r4.startedAtElapsedMs : 0L, (r24 & 4) != 0 ? r4.context : null, (r24 & 8) != 0 ? r4.stageElapsedMs : null, (r24 & 16) != 0 ? r4.recordedSignals : null, (r24 & 32) != 0 ? r4.furthestStage : null, (r24 & 64) != 0 ? r4.latestSignal : null, (r24 & 128) != 0 ? r4.latestFailureReason : null, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r4.errorCode : 0, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? this.state.terminalReported : true);
        this.state = copy;
        Map<String, Object> baseParams = baseParams();
        baseParams.put("outcome", outcome.getValue());
        baseParams.put("last_stage", this.state.getFurthestStage());
        baseParams.put("latest_signal", this.state.getLatestSignal());
        baseParams.put("failure_reason", normalizeFailureReason);
        baseParams.put("error_code", Integer.valueOf(this.state.getErrorCode()));
        baseParams.put("total_duration_ms", Long.valueOf(elapsedSinceStart()));
        baseParams.put("stage_count", Integer.valueOf(this.state.getStageElapsedMs().size()));
        for (VoiceDiscussionAttemptStage voiceDiscussionAttemptStage : VoiceDiscussionAttemptStage.getEntries()) {
            String str = voiceDiscussionAttemptStage.getValue() + "_ms";
            Long l = this.state.getStageElapsedMs().get(voiceDiscussionAttemptStage.getValue());
            baseParams.put(str, Long.valueOf(l != null ? l.longValue() : -1L));
        }
        Unit unit = Unit.INSTANCE;
        reportSafely(EVENT_ATTEMPT_END, baseParams);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0023 A[Catch: all -> 0x0032, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x000d, B:9:0x0011, B:11:0x0015, B:13:0x0019, B:18:0x0023, B:19:0x002c), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean finishInferred() {
        VoiceDiscussionAttemptOutcome inferOutcome;
        boolean z;
        inferOutcome = inferOutcome();
        if (inferOutcome != VoiceDiscussionAttemptOutcome.PERMISSION_DENIED && inferOutcome != VoiceDiscussionAttemptOutcome.HEALTH_CHECK_BLOCKED && inferOutcome != VoiceDiscussionAttemptOutcome.START_API_FAILED && inferOutcome != VoiceDiscussionAttemptOutcome.RTC_JOIN_FAILED && inferOutcome != VoiceDiscussionAttemptOutcome.RTC_RUNTIME_ERROR && inferOutcome != VoiceDiscussionAttemptOutcome.CONVERSATION_ERROR) {
            z = false;
        }
        z = true;
        return finish(inferOutcome, !z ? this.state.getLatestFailureReason() : "");
    }

    private final VoiceDiscussionAttemptOutcome inferOutcome() {
        int stageOrder = stageOrder(this.state.getFurthestStage());
        String latestSignal = this.state.getLatestSignal();
        boolean z = Intrinsics.areEqual(latestSignal, VoiceDiscussionAttemptSignal.PERMISSION_DENIED.getValue()) && !this.state.getStageElapsedMs().containsKey(VoiceDiscussionAttemptStage.PERMISSION_GRANTED.getValue());
        if (stageOrder >= VoiceDiscussionAttemptStage.ROUND_REPORTED.getOrder()) {
            return VoiceDiscussionAttemptOutcome.SUCCESS;
        }
        if (stageOrder >= VoiceDiscussionAttemptStage.THINKING_RECEIVED.getOrder()) {
            return VoiceDiscussionAttemptOutcome.ROUND_NOT_FINALIZED;
        }
        if (z && stageOrder < VoiceDiscussionAttemptStage.RECORDING_STARTED.getOrder()) {
            return VoiceDiscussionAttemptOutcome.PERMISSION_DENIED;
        }
        if (Intrinsics.areEqual(latestSignal, VoiceDiscussionAttemptSignal.CONVERSATION_ERROR.getValue())) {
            return VoiceDiscussionAttemptOutcome.CONVERSATION_ERROR;
        }
        if (stageOrder >= VoiceDiscussionAttemptStage.RTC_JOINED.getOrder() && Intrinsics.areEqual(latestSignal, VoiceDiscussionAttemptSignal.RTC_ERROR.getValue())) {
            return VoiceDiscussionAttemptOutcome.RTC_RUNTIME_ERROR;
        }
        if (stageOrder >= VoiceDiscussionAttemptStage.FIRST_VOICE_DETECTED.getOrder()) {
            return VoiceDiscussionAttemptOutcome.SPEECH_NO_THINKING;
        }
        if (stageOrder >= VoiceDiscussionAttemptStage.RTC_JOINED.getOrder()) {
            return VoiceDiscussionAttemptOutcome.JOINED_NO_SPEECH;
        }
        if (stageOrder >= VoiceDiscussionAttemptStage.DISCUSSION_STARTED.getOrder() && Intrinsics.areEqual(latestSignal, VoiceDiscussionAttemptSignal.START_API_FAILED.getValue())) {
            return VoiceDiscussionAttemptOutcome.START_API_FAILED;
        }
        if (stageOrder >= VoiceDiscussionAttemptStage.DISCUSSION_STARTED.getOrder() && Intrinsics.areEqual(latestSignal, VoiceDiscussionAttemptSignal.RTC_ERROR.getValue())) {
            return VoiceDiscussionAttemptOutcome.RTC_JOIN_FAILED;
        }
        if (stageOrder >= VoiceDiscussionAttemptStage.DISCUSSION_STARTED.getOrder()) {
            return VoiceDiscussionAttemptOutcome.START_ABANDON;
        }
        if (stageOrder >= VoiceDiscussionAttemptStage.ACTIVITY_SHOWN.getOrder() && Intrinsics.areEqual(latestSignal, VoiceDiscussionAttemptSignal.PERMISSION_DENIED.getValue())) {
            return VoiceDiscussionAttemptOutcome.PERMISSION_DENIED;
        }
        if (stageOrder >= VoiceDiscussionAttemptStage.ACTIVITY_SHOWN.getOrder() && Intrinsics.areEqual(latestSignal, VoiceDiscussionAttemptSignal.HEALTH_CHECK_BLOCKED.getValue())) {
            return VoiceDiscussionAttemptOutcome.HEALTH_CHECK_BLOCKED;
        }
        if (stageOrder >= VoiceDiscussionAttemptStage.INTRO_SHOWN.getOrder()) {
            return VoiceDiscussionAttemptOutcome.INTRO_ABANDON;
        }
        if (stageOrder >= VoiceDiscussionAttemptStage.ACTIVITY_SHOWN.getOrder()) {
            return VoiceDiscussionAttemptOutcome.ACTIVITY_ABANDON;
        }
        if (stageOrder >= VoiceDiscussionAttemptStage.ACTIVITY_LAUNCH_REQUESTED.getOrder()) {
            return VoiceDiscussionAttemptOutcome.ACTIVITY_NOT_SHOWN;
        }
        return VoiceDiscussionAttemptOutcome.UNKNOWN;
    }

    private final boolean canRecord() {
        return (StringsKt.isBlank(this.state.getAttemptId()) ^ true) && this.state.getStartedAtElapsedMs() > 0 && !this.state.getTerminalReported();
    }

    private final Map<String, Object> baseParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        VoiceDiscussionAttemptContext context = this.state.getContext();
        String str = context.getMode() == Mode.CODE ? "code" : ModelSelectionRepository.MODE_MTC;
        linkedHashMap.put("attempt_id", this.state.getAttemptId());
        linkedHashMap.put("cli_type", context.getCliType().getValue());
        linkedHashMap.put("mode", context.getMode().getValue());
        linkedHashMap.put("chat_mode", str);
        linkedHashMap.put("env_mode", context.getCliType().getValue() + '_' + str);
        linkedHashMap.put("conversation_id", context.getConversationId());
        linkedHashMap.put("room_id", context.getRoomId());
        linkedHashMap.put("is_new_session", context.isNewSession() ? "1" : "0");
        linkedHashMap.put("has_seen_intro", context.getHasSeenIntro() ? "1" : "0");
        return linkedHashMap;
    }

    private final long elapsedSinceStart() {
        return RangesKt.coerceAtLeast(((Number) this.elapsedRealtime.invoke()).longValue() - this.state.getStartedAtElapsedMs(), 0L);
    }

    private final void reportSafely(String event, Map<String, ? extends Object> params) {
        try {
            this.reportEvent.invoke(event, params);
            this.logEvent.invoke(event, params);
        } catch (Throwable th) {
            FLogger.INSTANCE.w(TAG, "report failed: event=" + event, th);
        }
    }

    private final int stageOrder(String value) {
        Object obj;
        Iterator it = VoiceDiscussionAttemptStage.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((VoiceDiscussionAttemptStage) obj).getValue(), value)) {
                break;
            }
        }
        VoiceDiscussionAttemptStage voiceDiscussionAttemptStage = (VoiceDiscussionAttemptStage) obj;
        if (voiceDiscussionAttemptStage != null) {
            return voiceDiscussionAttemptStage.getOrder();
        }
        return -1;
    }

    /* compiled from: VoiceDiscussionAttemptTracker.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;", "", "<init>", "()V", "TAG", "", "EVENT_ATTEMPT_END", "MAX_FAILURE_REASON_LENGTH", "", "FIRST_VOICE_VOLUME_THRESHOLD", "", "MISSING_STAGE_MS", "", "isVoiceDetected", "", "volume", "normalizeFailureReason", "reason", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isVoiceDetected(float volume) {
            return volume >= VoiceDiscussionAttemptTracker.FIRST_VOICE_VOLUME_THRESHOLD;
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String normalizeFailureReason(String reason) {
            return StringsKt.take(StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(reason, '\r', ' ', false, 4, (Object) null), '\n', ' ', false, 4, (Object) null)).toString(), 120);
        }
    }
}
