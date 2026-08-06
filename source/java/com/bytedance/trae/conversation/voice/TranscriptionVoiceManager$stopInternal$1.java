package com.bytedance.trae.conversation.voice;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.TranscriptionVoiceManager;
import com.bytedance.trae.conversation.voice.network.IVoiceChatApi;
import com.bytedance.trae.conversation.voice.network.StartVoiceChatData;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$stopInternal$1", f = "TranscriptionVoiceManager.kt", i = {}, l = {491}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TranscriptionVoiceManager$stopInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StartVoiceChatData $current;
    int label;
    final /* synthetic */ TranscriptionVoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TranscriptionVoiceManager$stopInternal$1(TranscriptionVoiceManager transcriptionVoiceManager, StartVoiceChatData startVoiceChatData, Continuation<? super TranscriptionVoiceManager$stopInternal$1> continuation) {
        super(2, continuation);
        this.this$0 = transcriptionVoiceManager;
        this.$current = startVoiceChatData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TranscriptionVoiceManager$stopInternal$1(this.this$0, this.$current, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        Object stopVoiceChat;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FLog.d("VoiceChatSession", "stopVoiceChat");
                this.this$0.botCompleteText = "";
                this.this$0.currentRecognizedText = "";
                this.this$0.definiteText = "";
                StartVoiceChatData startVoiceChatData = this.$current;
                if ((startVoiceChatData != null ? startVoiceChatData.getAppId() : null) != null && this.$current.getRoomId() != null && this.$current.getTaskId() != null) {
                    IVoiceChatApi.Companion companion = IVoiceChatApi.INSTANCE;
                    str = this.this$0.conversationId;
                    str2 = this.this$0.xAppId;
                    this.label = 1;
                    stopVoiceChat = companion.stopVoiceChat(str, str2, "transcription", this.$current.getAppId(), this.$current.getRoomId(), this.$current.getTaskId(), (r19 & 64) != 0 ? "" : null, (Continuation) this);
                    if (stopVoiceChat == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Throwable th) {
            try {
                FLog.e("VoiceChatSession", "stopVoiceChat failed", th);
            } finally {
                VolcRtcClient.INSTANCE.leaveRoom();
                this.this$0.emitStatus(TranscriptionVoiceManager.Status.Stopped);
            }
        }
        return Unit.INSTANCE;
    }
}
