package com.bytedance.trae.conversation.brainstorm.widget;

import com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.network.IVoiceChatApi;
import com.bytedance.trae.network.response.HttpDataResult;
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
/* compiled from: BrainstormVoiceHistorySheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$fetchHistory$2", f = "BrainstormVoiceHistorySheet.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormVoiceHistorySheet$fetchHistory$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BrainstormVoiceHistorySheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormVoiceHistorySheet$fetchHistory$2(BrainstormVoiceHistorySheet brainstormVoiceHistorySheet, Continuation<? super BrainstormVoiceHistorySheet$fetchHistory$2> continuation) {
        super(2, continuation);
        this.this$0 = brainstormVoiceHistorySheet;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrainstormVoiceHistorySheet$fetchHistory$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String sessionId;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IVoiceChatApi.Companion companion = IVoiceChatApi.INSTANCE;
            sessionId = this.this$0.getSessionId();
            this.label = 1;
            obj = IVoiceChatApi.Companion.getVoiceChatHistory$default(companion, sessionId, this.this$0.getConversationId(), BMVoiceChatSessionManager.SCENE_ID_CHAT, null, null, (Continuation) this, 24, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        HttpDataResult httpDataResult = (HttpDataResult) obj;
        if (!this.this$0.isAdded()) {
            return Unit.INSTANCE;
        }
        this.this$0.renderResult(httpDataResult);
        return Unit.INSTANCE;
    }
}
