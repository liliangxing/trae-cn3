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
@DebugMetadata(c = "com.bytedance.trae.im.repository.MessageRepositoryImpl$appendThought$2", f = "MessageRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class MessageRepositoryImpl$appendThought$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fragment;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $taskId;
    int label;
    final /* synthetic */ MessageRepositoryImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRepositoryImpl$appendThought$2(MessageRepositoryImpl messageRepositoryImpl, String str, String str2, String str3, Continuation<? super MessageRepositoryImpl$appendThought$2> continuation) {
        super(2, continuation);
        this.this$0 = messageRepositoryImpl;
        this.$taskId = str;
        this.$fragment = str2;
        this.$messageId = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessageRepositoryImpl$appendThought$2(this.this$0, this.$taskId, this.$fragment, this.$messageId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        HashMap hashMap;
        int i;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            hashMap = this.this$0.pendingMap;
            HashMap hashMap2 = hashMap;
            String str = this.$taskId;
            String str2 = this.$messageId;
            Object obj2 = hashMap2.get(str);
            if (obj2 == null) {
                obj2 = new MessageRepositoryImpl.PendingThought(str2);
                hashMap2.put(str, obj2);
            }
            MessageRepositoryImpl.PendingThought pendingThought = (MessageRepositoryImpl.PendingThought) obj2;
            pendingThought.getBuffer().append(this.$fragment);
            pendingThought.setFragmentCount(pendingThought.getFragmentCount() + 1);
            int fragmentCount = pendingThought.getFragmentCount();
            i = this.this$0.batchSize;
            if (fragmentCount >= i) {
                this.this$0.writePending(this.$taskId, pendingThought);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
