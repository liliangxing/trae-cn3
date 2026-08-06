package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.network.IVoiceChatApi;
import com.bytedance.trae.conversation.voice.network.StartVoiceChatData;
import com.bytedance.trae.utils.logger.FLogger;
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
/* compiled from: BMVoiceChatSessionManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$stopVoiceChatBestEffort$1", f = "BMVoiceChatSessionManager.kt", i = {}, l = {441}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BMVoiceChatSessionManager$stopVoiceChatBestEffort$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ StartVoiceChatData $current;
    final /* synthetic */ String $sceneId;
    int label;
    final /* synthetic */ BMVoiceChatSessionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BMVoiceChatSessionManager$stopVoiceChatBestEffort$1(String str, BMVoiceChatSessionManager bMVoiceChatSessionManager, String str2, StartVoiceChatData startVoiceChatData, Continuation<? super BMVoiceChatSessionManager$stopVoiceChatBestEffort$1> continuation) {
        super(2, continuation);
        this.$conversationId = str;
        this.this$0 = bMVoiceChatSessionManager;
        this.$sceneId = str2;
        this.$current = startVoiceChatData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BMVoiceChatSessionManager$stopVoiceChatBestEffort$1(this.$conversationId, this.this$0, this.$sceneId, this.$current, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IVoiceChatApi.Companion companion = IVoiceChatApi.INSTANCE;
                String str3 = this.$conversationId;
                str = this.this$0.xAppId;
                String str4 = this.$sceneId;
                String appId = this.$current.getAppId();
                String roomId = this.$current.getRoomId();
                String taskId = this.$current.getTaskId();
                str2 = this.this$0.ppeEnv;
                this.label = 1;
                if (companion.stopVoiceChat(str3, str, str4, appId, roomId, taskId, str2, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Throwable th) {
            FLogger.INSTANCE.w("BMVoiceChatSession", "stopVoiceChat after join refused failed", th);
        }
        return Unit.INSTANCE;
    }
}
