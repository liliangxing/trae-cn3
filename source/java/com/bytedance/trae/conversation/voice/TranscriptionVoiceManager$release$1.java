package com.bytedance.trae.conversation.voice;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.network.IVoiceChatApi;
import com.bytedance.trae.conversation.voice.network.StartVoiceChatData;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.facebook.common.logging.FLog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TranscriptionVoiceManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$release$1", f = "TranscriptionVoiceManager.kt", i = {}, l = {409}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TranscriptionVoiceManager$release$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StartVoiceChatData $current;
    int label;
    final /* synthetic */ TranscriptionVoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TranscriptionVoiceManager$release$1(StartVoiceChatData startVoiceChatData, TranscriptionVoiceManager transcriptionVoiceManager, Continuation<? super TranscriptionVoiceManager$release$1> continuation) {
        super(2, continuation);
        this.$current = startVoiceChatData;
        this.this$0 = transcriptionVoiceManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TranscriptionVoiceManager$release$1(this.$current, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x009d, code lost:
    
        if (r0 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x009f, code lost:
    
        kotlinx.coroutines.Job.DefaultImpls.cancel$default(r0, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00e2, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00dd, code lost:
    
        if (r0 == null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Job job;
        CoroutineScope coroutineScope2;
        CoroutineScope coroutineScope3;
        CoroutineScope coroutineScope4;
        Job job2;
        String str;
        String str2;
        Object stopVoiceChat;
        CoroutineScope coroutineScope5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$current.getAppId() != null && this.$current.getRoomId() != null && this.$current.getTaskId() != null) {
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
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            coroutineScope5 = this.this$0.uiScope;
            job2 = (Job) coroutineScope5.getCoroutineContext().get(Job.Key);
        } catch (Throwable th) {
            try {
                FLog.w("VoiceChatSession", "stopVoiceChat on release failed", th);
                VolcRtcClient.INSTANCE.leaveRoom();
                coroutineScope3 = this.this$0.scope;
                Job job3 = coroutineScope3.getCoroutineContext().get(Job.Key);
                if (job3 != null) {
                    Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
                }
                coroutineScope4 = this.this$0.uiScope;
                job2 = coroutineScope4.getCoroutineContext().get(Job.Key);
            } finally {
                VolcRtcClient.INSTANCE.leaveRoom();
                coroutineScope = this.this$0.scope;
                job = coroutineScope.getCoroutineContext().get(Job.Key);
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                coroutineScope2 = this.this$0.uiScope;
                Job job4 = coroutineScope2.getCoroutineContext().get(Job.Key);
                if (job4 != null) {
                    Job.DefaultImpls.cancel$default(job4, (CancellationException) null, 1, (Object) null);
                }
            }
        }
    }
}
