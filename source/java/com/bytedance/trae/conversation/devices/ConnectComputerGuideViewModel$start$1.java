package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.conversation.DeviceDiscoveryRefreshResult;
import com.bytedance.trae.conversation.devices.BindingGuideStableState;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConnectComputerGuideViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.devices.ConnectComputerGuideViewModel$start$1", f = "ConnectComputerGuideViewModel.kt", i = {0, 1}, l = {41, 50}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConnectComputerGuideViewModel$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ConnectComputerGuideViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectComputerGuideViewModel$start$1(ConnectComputerGuideViewModel connectComputerGuideViewModel, Continuation<? super ConnectComputerGuideViewModel$start$1> continuation) {
        super(2, continuation);
        this.this$0 = connectComputerGuideViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> connectComputerGuideViewModel$start$1 = new ConnectComputerGuideViewModel$start$1(this.this$0, continuation);
        connectComputerGuideViewModel$start$1.L$0 = obj;
        return connectComputerGuideViewModel$start$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00a3 -> B:7:0x0031). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        ConnectComputerGuideViewModel$start$1 connectComputerGuideViewModel$start$1;
        MutableStateFlow mutableStateFlow;
        BindingGuideStateMachine bindingGuideStateMachine;
        BindingGuideStableState onRefreshFailed;
        MutableStateFlow mutableStateFlow2;
        long j;
        BindingGuideStateMachine bindingGuideStateMachine2;
        BindingDeviceDiscovery bindingDeviceDiscovery;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        } else {
            if (i == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope3 = coroutineScope2;
                connectComputerGuideViewModel$start$1 = this;
                DeviceDiscoveryRefreshResult deviceDiscoveryRefreshResult = (DeviceDiscoveryRefreshResult) obj;
                mutableStateFlow = connectComputerGuideViewModel$start$1.this$0._state;
                if (!deviceDiscoveryRefreshResult.isSuccess()) {
                    bindingGuideStateMachine2 = connectComputerGuideViewModel$start$1.this$0.stateMachine;
                    onRefreshFailed = bindingGuideStateMachine2.onRefreshSucceeded(deviceDiscoveryRefreshResult.getDevices());
                } else {
                    bindingGuideStateMachine = connectComputerGuideViewModel$start$1.this$0.stateMachine;
                    onRefreshFailed = bindingGuideStateMachine.onRefreshFailed();
                }
                mutableStateFlow.setValue(onRefreshFailed);
                mutableStateFlow2 = connectComputerGuideViewModel$start$1.this$0._state;
                if (!(((BindingGuideState) mutableStateFlow2.getValue()).getDisplayState() instanceof BindingGuideStableState.Succeeded)) {
                    j = connectComputerGuideViewModel$start$1.this$0.pollIntervalMs;
                    connectComputerGuideViewModel$start$1.L$0 = coroutineScope3;
                    connectComputerGuideViewModel$start$1.label = 2;
                    if (DelayKt.delay(j, (Continuation) connectComputerGuideViewModel$start$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope = coroutineScope3;
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        bindingDeviceDiscovery = connectComputerGuideViewModel$start$1.this$0.discovery;
                        connectComputerGuideViewModel$start$1.L$0 = coroutineScope;
                        connectComputerGuideViewModel$start$1.label = 1;
                        Object refresh = bindingDeviceDiscovery.refresh((Continuation) connectComputerGuideViewModel$start$1);
                        if (refresh == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineScope3 = coroutineScope;
                        obj = refresh;
                        DeviceDiscoveryRefreshResult deviceDiscoveryRefreshResult2 = (DeviceDiscoveryRefreshResult) obj;
                        mutableStateFlow = connectComputerGuideViewModel$start$1.this$0._state;
                        if (!deviceDiscoveryRefreshResult2.isSuccess()) {
                        }
                        mutableStateFlow.setValue(onRefreshFailed);
                        mutableStateFlow2 = connectComputerGuideViewModel$start$1.this$0._state;
                        if (!(((BindingGuideState) mutableStateFlow2.getValue()).getDisplayState() instanceof BindingGuideStableState.Succeeded)) {
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            coroutineScope = coroutineScope4;
        }
        connectComputerGuideViewModel$start$1 = this;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
        }
        return Unit.INSTANCE;
    }
}
