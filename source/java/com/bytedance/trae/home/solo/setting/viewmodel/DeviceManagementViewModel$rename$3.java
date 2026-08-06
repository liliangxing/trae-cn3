package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementEffect;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceManagementViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel$rename$3", f = "DeviceManagementViewModel.kt", i = {}, l = {183, 184}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceManagementViewModel$rename$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeviceManagementDevice $device;
    final /* synthetic */ String $trimmed;
    int label;
    final /* synthetic */ DeviceManagementViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceManagementViewModel$rename$3(DeviceManagementViewModel deviceManagementViewModel, DeviceManagementDevice deviceManagementDevice, String str, Continuation<? super DeviceManagementViewModel$rename$3> continuation) {
        super(2, continuation);
        this.this$0 = deviceManagementViewModel;
        this.$device = deviceManagementDevice;
        this.$trimmed = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManagementViewModel$rename$3(this.this$0, this.$device, this.$trimmed, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        DeviceManagementRepository deviceManagementRepository;
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            deviceManagementRepository = this.this$0.repository;
            this.label = 1;
            obj = deviceManagementRepository.renameDevice(this.$device.getId(), this.$trimmed, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            mutableSharedFlow = this.this$0._effects;
            this.label = 2;
            if (mutableSharedFlow.emit(DeviceManagementEffect.RefreshDeviceCache.INSTANCE, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
