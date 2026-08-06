package com.bytedance.kmp.network.websocket;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Websocket.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.websocket.Websocket$register$2", f = "Websocket.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Websocket$register$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ RawWebsocketInfo $info;
    final /* synthetic */ IRawWsEventListener $listener;
    int label;
    final /* synthetic */ Websocket this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Websocket$register$2(IRawWsEventListener iRawWsEventListener, Websocket websocket, RawWebsocketInfo rawWebsocketInfo, Continuation<? super Websocket$register$2> continuation) {
        super(2, continuation);
        this.$listener = iRawWsEventListener;
        this.this$0 = websocket;
        this.$info = rawWebsocketInfo;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Websocket$register$2(this.$listener, this.this$0, this.$info, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IRawWsService iRawWsService;
        AtomicInt atomicInt;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SafeRawWsEventListenerDecorator safeRawWsEventListenerDecorator = new SafeRawWsEventListenerDecorator(this.$listener);
            iRawWsService = this.this$0.wsService;
            this.label = 1;
            obj = iRawWsService.register(this.$info, safeRawWsEventListenerDecorator, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        int intValue = ((Number) obj).intValue();
        atomicInt = this.this$0.wsId;
        atomicInt.setValue(intValue);
        return Boxing.boxInt(intValue);
    }
}
