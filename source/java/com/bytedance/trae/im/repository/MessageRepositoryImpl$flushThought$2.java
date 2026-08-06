package com.bytedance.trae.im.repository;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.repository.MessageRepositoryImpl;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MessageRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.im.repository.MessageRepositoryImpl$flushThought$2", f = "MessageRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class MessageRepositoryImpl$flushThought$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $taskId;
    int label;
    final /* synthetic */ MessageRepositoryImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRepositoryImpl$flushThought$2(MessageRepositoryImpl messageRepositoryImpl, String str, Continuation<? super MessageRepositoryImpl$flushThought$2> continuation) {
        super(2, continuation);
        this.this$0 = messageRepositoryImpl;
        this.$taskId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessageRepositoryImpl$flushThought$2(this.this$0, this.$taskId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        HashMap hashMap;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            hashMap = this.this$0.pendingMap;
            MessageRepositoryImpl.PendingThought pendingThought = (MessageRepositoryImpl.PendingThought) hashMap.remove(this.$taskId);
            if (pendingThought == null) {
                return Unit.INSTANCE;
            }
            if (pendingThought.getBuffer().length() > 0) {
                this.this$0.writePending(this.$taskId, pendingThought);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
