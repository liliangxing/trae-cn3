package com.bytedance.trae.home.solo.setting;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsDeviceListViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel$fetchDevices$1", f = "SettingsDeviceListViewModel.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsDeviceListViewModel$fetchDevices$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SettingsDeviceListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsDeviceListViewModel$fetchDevices$1(SettingsDeviceListViewModel settingsDeviceListViewModel, Continuation<? super SettingsDeviceListViewModel$fetchDevices$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsDeviceListViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsDeviceListViewModel$fetchDevices$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        SettingsDeviceRepository settingsDeviceRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            settingsDeviceRepository = this.this$0.repository;
            final SettingsDeviceListViewModel settingsDeviceListViewModel = this.this$0;
            this.label = 1;
            if (settingsDeviceRepository.fetchDevices(new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel$fetchDevices$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = SettingsDeviceListViewModel$fetchDevices$1.invokeSuspend$lambda$0(SettingsDeviceListViewModel.this, (List) obj2);
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
    public static final Unit invokeSuspend$lambda$0(SettingsDeviceListViewModel settingsDeviceListViewModel, List list) {
        List mapDevices;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        mapDevices = settingsDeviceListViewModel.mapDevices(list);
        settingsDeviceListViewModel.previousPairedDeviceIds = SettingsDeviceMapperKt.pairedDeviceIds(mapDevices);
        mutableLiveData = settingsDeviceListViewModel._devices;
        mutableLiveData.postValue(mapDevices);
        mutableLiveData2 = settingsDeviceListViewModel._isLoading;
        mutableLiveData2.postValue(false);
        return Unit.INSTANCE;
    }
}
