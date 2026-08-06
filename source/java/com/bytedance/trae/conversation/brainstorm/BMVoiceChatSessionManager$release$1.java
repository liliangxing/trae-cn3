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
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$release$1", f = "BMVoiceChatSessionManager.kt", i = {}, l = {537}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BMVoiceChatSessionManager$release$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StartVoiceChatData $current;
    final /* synthetic */ String $sceneId;
    int label;
    final /* synthetic */ BMVoiceChatSessionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BMVoiceChatSessionManager$release$1(StartVoiceChatData startVoiceChatData, String str, BMVoiceChatSessionManager bMVoiceChatSessionManager, Continuation<? super BMVoiceChatSessionManager$release$1> continuation) {
        super(2, continuation);
        this.$current = startVoiceChatData;
        this.$sceneId = str;
        this.this$0 = bMVoiceChatSessionManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BMVoiceChatSessionManager$release$1(this.$current, this.$sceneId, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Throwable th) {
            try {
                FLogger.INSTANCE.w("BMVoiceChatSession", "stopVoiceChat on release failed", th);
            } finally {
                this.this$0.releaseFinally();
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$current.getAppId() != null && this.$current.getRoomId() != null && this.$current.getTaskId() != null) {
                FLogger.INSTANCE.d("BMVoiceChatSession", "release stopVoiceChat request: scene=" + this.$sceneId + ", room=" + this.$current.getRoomId() + ", task=" + this.$current.getTaskId());
                IVoiceChatApi.Companion companion = IVoiceChatApi.INSTANCE;
                str = this.this$0.conversationId;
                str2 = this.this$0.xAppId;
                String str4 = this.$sceneId;
                String appId = this.$current.getAppId();
                String roomId = this.$current.getRoomId();
                String taskId = this.$current.getTaskId();
                str3 = this.this$0.ppeEnv;
                this.label = 1;
                if (companion.stopVoiceChat(str, str2, str4, appId, roomId, taskId, str3, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        FLogger.INSTANCE.d("BMVoiceChatSession", "release stopVoiceChat success: room=" + this.$current.getRoomId() + ", task=" + this.$current.getTaskId());
        return Unit.INSTANCE;
    }
}
