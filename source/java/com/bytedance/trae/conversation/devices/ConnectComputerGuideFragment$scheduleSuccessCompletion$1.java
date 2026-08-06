package com.bytedance.trae.conversation.devices;

import androidx.lifecycle.Lifecycle;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowConnectionSuccessLifecycleKt;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConnectComputerGuideFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$scheduleSuccessCompletion$1", f = "ConnectComputerGuideFragment.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConnectComputerGuideFragment$scheduleSuccessCompletion$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConnectComputerGuideFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectComputerGuideFragment$scheduleSuccessCompletion$1(ConnectComputerGuideFragment connectComputerGuideFragment, Continuation<? super ConnectComputerGuideFragment$scheduleSuccessCompletion$1> continuation) {
        super(2, continuation);
        this.this$0 = connectComputerGuideFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConnectComputerGuideFragment$scheduleSuccessCompletion$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Lifecycle lifecycle = this.this$0.getViewLifecycleOwner().getLifecycle();
            final ConnectComputerGuideFragment connectComputerGuideFragment = this.this$0;
            this.label = 1;
            if (DeviceFlowConnectionSuccessLifecycleKt.runConnectionSuccessWhenResumed(lifecycle, 2000L, new Function0() { // from class: com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$scheduleSuccessCompletion$1$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = ConnectComputerGuideFragment$scheduleSuccessCompletion$1.invokeSuspend$lambda$0(ConnectComputerGuideFragment.this);
                    return invokeSuspend$lambda$0;
                }
            }, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(ConnectComputerGuideFragment connectComputerGuideFragment) {
        connectComputerGuideFragment.completeConnectionSuccess();
        return Unit.INSTANCE;
    }
}
