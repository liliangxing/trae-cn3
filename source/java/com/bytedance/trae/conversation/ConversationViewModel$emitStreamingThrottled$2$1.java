package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.ParsedChatMessage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel$emitStreamingThrottled$2$1", f = "ConversationViewModel.kt", i = {1, 2}, l = {870, 3511, 878}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel$emitStreamingThrottled$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $remaining;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$emitStreamingThrottled$2$1(long j, ConversationViewModel conversationViewModel, Continuation<? super ConversationViewModel$emitStreamingThrottled$2$1> continuation) {
        super(2, continuation);
        this.$remaining = j;
        this.this$0 = conversationViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationViewModel$emitStreamingThrottled$2$1(this.$remaining, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[Catch: all -> 0x0097, TryCatch #0 {all -> 0x0097, blocks: (B:21:0x0060, B:23:0x0066, B:25:0x007d), top: B:20:0x0060 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        ConversationViewModel conversationViewModel;
        Mutex mutex2;
        Throwable th;
        ParsedChatMessage parsedChatMessage;
        boolean processTraeRefInSummary;
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(this.$remaining, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex2 = (Mutex) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            Unit unit = Unit.INSTANCE;
                            mutex2.unlock((Object) null);
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            mutex2.unlock((Object) null);
                            throw th;
                        }
                    }
                    conversationViewModel = (ConversationViewModel) this.L$1;
                    Mutex mutex3 = (Mutex) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex3;
                    parsedChatMessage = conversationViewModel.pendingStreamingMessage;
                    if (parsedChatMessage != null) {
                        conversationViewModel.lastStreamingEmitTime = System.currentTimeMillis();
                        conversationViewModel.pendingStreamingMessage = null;
                        conversationViewModel.upsertMessages(CollectionsKt.listOf(parsedChatMessage));
                        processTraeRefInSummary = conversationViewModel.processTraeRefInSummary(parsedChatMessage);
                        if (processTraeRefInSummary) {
                            mutableSharedFlow = conversationViewModel._throttledStreamingMessage;
                            this.L$0 = mutex;
                            this.L$1 = null;
                            this.label = 3;
                            if (mutableSharedFlow.emit(parsedChatMessage, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock((Object) null);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            parsedChatMessage = conversationViewModel.pendingStreamingMessage;
            if (parsedChatMessage != null) {
            }
            mutex2 = mutex;
            Unit unit22 = Unit.INSTANCE;
            mutex2.unlock((Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock((Object) null);
            throw th;
        }
        mutex = this.this$0.streamingThrottleMutex;
        conversationViewModel = this.this$0;
        this.L$0 = mutex;
        this.L$1 = conversationViewModel;
        this.label = 2;
        if (mutex.lock((Object) null, (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
    }
}
