package com.bytedance.trae.home.solo.setting.viewmodel;

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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceManagementViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel$startPolling$1", f = "DeviceManagementViewModel.kt", i = {0, 1}, l = {130, 131}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceManagementViewModel$startPolling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceManagementViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceManagementViewModel$startPolling$1(DeviceManagementViewModel deviceManagementViewModel, Continuation<? super DeviceManagementViewModel$startPolling$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceManagementViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deviceManagementViewModel$startPolling$1 = new DeviceManagementViewModel$startPolling$1(this.this$0, continuation);
        deviceManagementViewModel$startPolling$1.L$0 = obj;
        return deviceManagementViewModel$startPolling$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0055 -> B:7:0x0031). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        DeviceManagementViewModel$startPolling$1 deviceManagementViewModel$startPolling$1;
        Object refreshDevices;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            coroutineScope = coroutineScope2;
            deviceManagementViewModel$startPolling$1 = this;
            deviceManagementViewModel$startPolling$1.L$0 = coroutineScope;
            deviceManagementViewModel$startPolling$1.label = 2;
            refreshDevices = deviceManagementViewModel$startPolling$1.this$0.refreshDevices(false, (Continuation) deviceManagementViewModel$startPolling$1);
            if (refreshDevices == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                deviceManagementViewModel$startPolling$1.L$0 = coroutineScope;
                deviceManagementViewModel$startPolling$1.label = 1;
                if (DelayKt.delay(5000L, (Continuation) deviceManagementViewModel$startPolling$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deviceManagementViewModel$startPolling$1.L$0 = coroutineScope;
                deviceManagementViewModel$startPolling$1.label = 2;
                refreshDevices = deviceManagementViewModel$startPolling$1.this$0.refreshDevices(false, (Continuation) deviceManagementViewModel$startPolling$1);
                if (refreshDevices == coroutine_suspended) {
                }
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    return Unit.INSTANCE;
                }
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            coroutineScope = coroutineScope3;
        }
        deviceManagementViewModel$startPolling$1 = this;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
        }
    }
}
