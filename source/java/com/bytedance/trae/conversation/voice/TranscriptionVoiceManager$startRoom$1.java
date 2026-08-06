package com.bytedance.trae.conversation.voice;

import android.text.TextUtils;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.network.IVoiceChatApi;
import com.bytedance.trae.conversation.voice.network.StartVoiceChatData;
import com.bytedance.trae.network.response.HttpDataResult;
import com.facebook.common.logging.FLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TranscriptionVoiceManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$startRoom$1", f = "TranscriptionVoiceManager.kt", i = {}, l = {258}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TranscriptionVoiceManager$startRoom$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TranscriptionVoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TranscriptionVoiceManager$startRoom$1(TranscriptionVoiceManager transcriptionVoiceManager, Continuation<? super TranscriptionVoiceManager$startRoom$1> continuation) {
        super(2, continuation);
        this.this$0 = transcriptionVoiceManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TranscriptionVoiceManager$startRoom$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String botName;
        Object startVoiceChat;
        boolean isVoiceChatDataValid;
        VoiceAttemptMetricsTracker voiceAttemptMetricsTracker;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            Exception exc = e;
            FLog.w("VoiceChatSession", "startRoom failed", exc);
            this.this$0.emitError(exc);
            this.this$0.stopInternal();
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StartVoiceChatData cachedData = VoiceChatConfigWarmup.INSTANCE.getCachedData();
            if (cachedData != null) {
                this.this$0.perfStartVoiceChatTimestamp = System.currentTimeMillis();
                IVoiceChatApi.Companion companion = IVoiceChatApi.INSTANCE;
                str = this.this$0.conversationId;
                str2 = this.this$0.xAppId;
                String roomId = cachedData.getRoomId();
                String userId = cachedData.getUserId();
                String taskId = cachedData.getTaskId();
                String token = cachedData.getToken();
                if (!TextUtils.isEmpty(cachedData.getBotUserId())) {
                    botName = cachedData.getBotUserId();
                } else {
                    botName = cachedData.getBotName();
                }
                this.label = 1;
                startVoiceChat = companion.startVoiceChat(str, str2, "transcription", (r24 & 8) != 0 ? false : false, (r24 & 16) != 0 ? null : roomId, (r24 & 32) != 0 ? null : userId, (r24 & 64) != 0 ? null : taskId, (r24 & 128) != 0 ? null : token, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : botName, (Continuation) this);
                if (startVoiceChat == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        startVoiceChat = obj;
        HttpDataResult.Success success = (HttpDataResult) startVoiceChat;
        this.this$0.perfApiRequestEndTimestamp = System.currentTimeMillis();
        if (!(success instanceof HttpDataResult.Success)) {
            FLog.w("VoiceChatSession", "startRoom startVoiceChat failed: " + success);
            this.this$0.emitError(new IllegalStateException("startVoiceChat failed"));
            this.this$0.stopInternal();
            return Unit.INSTANCE;
        }
        StartVoiceChatData startVoiceChatData = (StartVoiceChatData) success.getBizResp().getData();
        if (startVoiceChatData != null) {
            isVoiceChatDataValid = this.this$0.isVoiceChatDataValid(startVoiceChatData);
            if (isVoiceChatDataValid) {
                this.this$0.voiceChat = startVoiceChatData;
                voiceAttemptMetricsTracker = this.this$0.attemptTracker;
                String roomId2 = startVoiceChatData.getRoomId();
                String str3 = "";
                if (roomId2 == null) {
                    roomId2 = "";
                }
                String taskId2 = startVoiceChatData.getTaskId();
                if (taskId2 != null) {
                    str3 = taskId2;
                }
                voiceAttemptMetricsTracker.captureVoiceChatData(roomId2, str3);
                return Unit.INSTANCE;
            }
            FLog.w("VoiceChatSession", "startRoom startVoiceChat returns invalid data: " + startVoiceChatData);
            this.this$0.emitError(new IllegalArgumentException("invalid voiceChat data"));
            this.this$0.stopInternal();
            return Unit.INSTANCE;
        }
        FLog.w("VoiceChatSession", "startRoom startVoiceChat returned null data");
        this.this$0.emitError(new IllegalStateException("startVoiceChat empty data"));
        this.this$0.stopInternal();
        return Unit.INSTANCE;
    }
}
