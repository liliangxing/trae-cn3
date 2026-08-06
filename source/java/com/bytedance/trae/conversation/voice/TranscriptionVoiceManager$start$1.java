package com.bytedance.trae.conversation.voice;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.TranscriptionVoiceManager;
import com.bytedance.trae.conversation.voice.network.IVoiceChatApi;
import com.bytedance.trae.conversation.voice.network.StartVoiceChatData;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.bytedance.trae.network.response.HttpDataResult;
import com.facebook.common.logging.FLog;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TranscriptionVoiceManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$start$1", f = "TranscriptionVoiceManager.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TranscriptionVoiceManager$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $startTime;
    int label;
    final /* synthetic */ TranscriptionVoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TranscriptionVoiceManager$start$1(TranscriptionVoiceManager transcriptionVoiceManager, Ref.LongRef longRef, Continuation<? super TranscriptionVoiceManager$start$1> continuation) {
        super(2, continuation);
        this.this$0 = transcriptionVoiceManager;
        this.$startTime = longRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TranscriptionVoiceManager$start$1(this.this$0, this.$startTime, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        VoiceAttemptMetricsTracker voiceAttemptMetricsTracker;
        String str;
        String str2;
        Object startVoiceChat;
        VoiceAttemptMetricsTracker voiceAttemptMetricsTracker2;
        boolean isVoiceChatDataValid;
        VoiceAttemptMetricsTracker voiceAttemptMetricsTracker3;
        TranscriptionVoiceManager$rtcListener$1 transcriptionVoiceManager$rtcListener$1;
        boolean isVoiceChatDataValid2;
        VoiceAttemptMetricsTracker voiceAttemptMetricsTracker4;
        TranscriptionVoiceManager$rtcListener$1 transcriptionVoiceManager$rtcListener$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        String str3 = "";
        try {
        } catch (Throwable th) {
            this.this$0.emitError(th);
            this.this$0.onError();
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StartVoiceChatData cachedData = VoiceChatConfigWarmup.INSTANCE.getCachedData();
            if (cachedData != null) {
                FLog.d("VoiceChatSession", "preload cachedData");
                voiceAttemptMetricsTracker2 = this.this$0.attemptTracker;
                voiceAttemptMetricsTracker2.setStartPath(VoiceAttemptMetricsTracker.START_PATH_CACHED_JOIN_FIRST);
                isVoiceChatDataValid = this.this$0.isVoiceChatDataValid(cachedData);
                if (isVoiceChatDataValid) {
                    this.this$0.voiceChat = cachedData;
                    voiceAttemptMetricsTracker3 = this.this$0.attemptTracker;
                    String roomId = cachedData.getRoomId();
                    if (roomId == null) {
                        roomId = "";
                    }
                    String taskId = cachedData.getTaskId();
                    if (taskId != null) {
                        str3 = taskId;
                    }
                    voiceAttemptMetricsTracker3.captureVoiceChatData(roomId, str3);
                    this.this$0.perfJoinRoomTimestamp = System.currentTimeMillis();
                    VolcRtcClient volcRtcClient = VolcRtcClient.INSTANCE;
                    transcriptionVoiceManager$rtcListener$1 = this.this$0.rtcListener;
                    if (!volcRtcClient.join$conversation_mainlandRelease(cachedData, transcriptionVoiceManager$rtcListener$1, VolcRtcClient.CallerType.Transcription)) {
                        FLog.w("VoiceChatSession", "VolcRtcClient busy, refuse to start transcription voice (preloaded path)");
                        this.this$0.emitError(new IllegalStateException("Voice discussion is in progress"));
                        this.this$0.handleJoinRefused(cachedData);
                        return Unit.INSTANCE;
                    }
                    this.this$0.voiceStartCaptureDuration = System.currentTimeMillis() - this.$startTime.element;
                    this.this$0.emitStatus(TranscriptionVoiceManager.Status.JoiningRoom);
                    this.this$0.startRoom();
                    return Unit.INSTANCE;
                }
                FLog.w("VoiceChatSession", "preload cachedData invalid: " + cachedData);
                this.this$0.emitError(new IllegalArgumentException("invalid voiceChat data"));
                this.this$0.handleJoinRefused(cachedData);
                return Unit.INSTANCE;
            }
            FLog.d("VoiceChatSession", "no preload cachedData");
            voiceAttemptMetricsTracker = this.this$0.attemptTracker;
            voiceAttemptMetricsTracker.setStartPath(VoiceAttemptMetricsTracker.START_PATH_COLD_API);
            TranscriptionVoiceManager transcriptionVoiceManager = this.this$0;
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            transcriptionVoiceManager.conversationId = uuid;
            this.this$0.perfStartVoiceChatTimestamp = System.currentTimeMillis();
            IVoiceChatApi.Companion companion = IVoiceChatApi.INSTANCE;
            str = this.this$0.conversationId;
            str2 = this.this$0.xAppId;
            this.label = 1;
            startVoiceChat = companion.startVoiceChat(str, str2, "transcription", (r24 & 8) != 0 ? false : false, (r24 & 16) != 0 ? null : null, (r24 & 32) != 0 ? null : null, (r24 & 64) != 0 ? null : null, (r24 & 128) != 0 ? null : null, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : null, (Continuation) this);
            if (startVoiceChat == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            startVoiceChat = obj;
        }
        HttpDataResult.Success success = (HttpDataResult) startVoiceChat;
        this.this$0.perfApiRequestEndTimestamp = System.currentTimeMillis();
        if (!(success instanceof HttpDataResult.Success)) {
            FLog.w("VoiceChatSession", "startVoiceChat failed: " + success);
            this.this$0.emitError(new IllegalStateException("startVoiceChat failed"));
            this.this$0.handleJoinRefused(null);
            return Unit.INSTANCE;
        }
        StartVoiceChatData startVoiceChatData = (StartVoiceChatData) success.getBizResp().getData();
        if (startVoiceChatData != null) {
            isVoiceChatDataValid2 = this.this$0.isVoiceChatDataValid(startVoiceChatData);
            if (isVoiceChatDataValid2) {
                this.this$0.voiceChat = startVoiceChatData;
                voiceAttemptMetricsTracker4 = this.this$0.attemptTracker;
                String roomId2 = startVoiceChatData.getRoomId();
                if (roomId2 == null) {
                    roomId2 = "";
                }
                String taskId2 = startVoiceChatData.getTaskId();
                if (taskId2 != null) {
                    str3 = taskId2;
                }
                voiceAttemptMetricsTracker4.captureVoiceChatData(roomId2, str3);
                this.this$0.perfJoinRoomTimestamp = System.currentTimeMillis();
                VolcRtcClient volcRtcClient2 = VolcRtcClient.INSTANCE;
                transcriptionVoiceManager$rtcListener$12 = this.this$0.rtcListener;
                if (!volcRtcClient2.join$conversation_mainlandRelease(startVoiceChatData, transcriptionVoiceManager$rtcListener$12, VolcRtcClient.CallerType.Transcription)) {
                    FLog.w("VoiceChatSession", "VolcRtcClient busy, refuse to start transcription voice (api path)");
                    this.this$0.emitError(new IllegalStateException("Voice discussion is in progress"));
                    this.this$0.handleJoinRefused(startVoiceChatData);
                    return Unit.INSTANCE;
                }
                this.this$0.voiceStartCaptureDuration = System.currentTimeMillis() - this.$startTime.element;
                this.this$0.emitStatus(TranscriptionVoiceManager.Status.JoiningRoom);
                return Unit.INSTANCE;
            }
            FLog.w("VoiceChatSession", "startVoiceChat returns invalid data: " + startVoiceChatData);
            this.this$0.emitError(new IllegalArgumentException("invalid voiceChat data"));
            this.this$0.handleJoinRefused(startVoiceChatData);
            return Unit.INSTANCE;
        }
        FLog.w("VoiceChatSession", "startVoiceChat returned null data");
        this.this$0.emitError(new IllegalStateException("startVoiceChat empty data"));
        this.this$0.handleJoinRefused(null);
        return Unit.INSTANCE;
    }
}
