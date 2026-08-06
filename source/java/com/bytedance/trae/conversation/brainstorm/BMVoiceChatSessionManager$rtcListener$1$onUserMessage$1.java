package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
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

/* compiled from: BMVoiceChatSessionManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$rtcListener$1$onUserMessage$1", f = "BMVoiceChatSessionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class BMVoiceChatSessionManager$rtcListener$1$onUserMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $message;
    final /* synthetic */ String $uid;
    int label;
    final /* synthetic */ BMVoiceChatSessionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BMVoiceChatSessionManager$rtcListener$1$onUserMessage$1(BMVoiceChatSessionManager bMVoiceChatSessionManager, String str, String str2, Continuation<? super BMVoiceChatSessionManager$rtcListener$1$onUserMessage$1> continuation) {
        super(2, continuation);
        this.this$0 = bMVoiceChatSessionManager;
        this.$uid = str;
        this.$message = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BMVoiceChatSessionManager$rtcListener$1$onUserMessage$1(this.this$0, this.$uid, this.$message, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String rtcDiag;
        BMVoiceChatSessionManager.Listener listener;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                listener = this.this$0.listener;
                if (listener != null) {
                    listener.onRtcTextMessage(this.$uid, this.$message);
                }
            } catch (Throwable th) {
                FLogger fLogger = FLogger.INSTANCE;
                rtcDiag = this.this$0.rtcDiag("onUserMessage forward failed: uid=" + this.$uid + ", length=" + this.$message.length());
                fLogger.w("BMVoiceChatSession", rtcDiag, th);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
