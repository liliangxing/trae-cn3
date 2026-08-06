package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: DeviceManagementViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;", "current", "devices", "", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel$state$1", f = "DeviceManagementViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class DeviceManagementViewModel$state$1 extends SuspendLambda implements Function3<DeviceManagementUiState, List<? extends DeviceManagementDevice>, Continuation<? super DeviceManagementUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceManagementViewModel$state$1(Continuation<? super DeviceManagementViewModel$state$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(DeviceManagementUiState deviceManagementUiState, List<DeviceManagementDevice> list, Continuation<? super DeviceManagementUiState> continuation) {
        DeviceManagementViewModel$state$1 deviceManagementViewModel$state$1 = new DeviceManagementViewModel$state$1(continuation);
        deviceManagementViewModel$state$1.L$0 = deviceManagementUiState;
        deviceManagementViewModel$state$1.L$1 = list;
        return deviceManagementViewModel$state$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return DeviceManagementUiState.copy$default((DeviceManagementUiState) this.L$0, false, false, (List) this.L$1, null, null, null, null, 123, null);
    }
}
