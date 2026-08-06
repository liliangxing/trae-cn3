package com.bytedance.trae.home.solo.setting;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.List;
import java.util.Set;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsDeviceListViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel$startPolling$1", f = "SettingsDeviceListViewModel.kt", i = {0, 1}, l = {69, 70}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsDeviceListViewModel$startPolling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingsDeviceListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsDeviceListViewModel$startPolling$1(SettingsDeviceListViewModel settingsDeviceListViewModel, Continuation<? super SettingsDeviceListViewModel$startPolling$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsDeviceListViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> settingsDeviceListViewModel$startPolling$1 = new SettingsDeviceListViewModel$startPolling$1(this.this$0, continuation);
        settingsDeviceListViewModel$startPolling$1.L$0 = obj;
        return settingsDeviceListViewModel$startPolling$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x005f -> B:7:0x0031). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        SettingsDeviceListViewModel$startPolling$1 settingsDeviceListViewModel$startPolling$1;
        SettingsDeviceRepository settingsDeviceRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            coroutineScope = coroutineScope2;
            settingsDeviceListViewModel$startPolling$1 = this;
            settingsDeviceRepository = settingsDeviceListViewModel$startPolling$1.this$0.repository;
            final SettingsDeviceListViewModel settingsDeviceListViewModel = settingsDeviceListViewModel$startPolling$1.this$0;
            settingsDeviceListViewModel$startPolling$1.L$0 = coroutineScope;
            settingsDeviceListViewModel$startPolling$1.label = 2;
            if (settingsDeviceRepository.fetchDevices(new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel$startPolling$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = SettingsDeviceListViewModel$startPolling$1.invokeSuspend$lambda$0(SettingsDeviceListViewModel.this, (List) obj2);
                    return invokeSuspend$lambda$0;
                }
            }, (Continuation) settingsDeviceListViewModel$startPolling$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                settingsDeviceListViewModel$startPolling$1.L$0 = coroutineScope;
                settingsDeviceListViewModel$startPolling$1.label = 1;
                if (DelayKt.delay(5000L, (Continuation) settingsDeviceListViewModel$startPolling$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                settingsDeviceRepository = settingsDeviceListViewModel$startPolling$1.this$0.repository;
                final SettingsDeviceListViewModel settingsDeviceListViewModel2 = settingsDeviceListViewModel$startPolling$1.this$0;
                settingsDeviceListViewModel$startPolling$1.L$0 = coroutineScope;
                settingsDeviceListViewModel$startPolling$1.label = 2;
                if (settingsDeviceRepository.fetchDevices(new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel$startPolling$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = SettingsDeviceListViewModel$startPolling$1.invokeSuspend$lambda$0(SettingsDeviceListViewModel.this, (List) obj2);
                        return invokeSuspend$lambda$0;
                    }
                }, (Continuation) settingsDeviceListViewModel$startPolling$1) == coroutine_suspended) {
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
        settingsDeviceListViewModel$startPolling$1 = this;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(SettingsDeviceListViewModel settingsDeviceListViewModel, List list) {
        List mapDevices;
        Set set;
        MutableLiveData mutableLiveData;
        boolean z;
        MutableLiveData mutableLiveData2;
        mapDevices = settingsDeviceListViewModel.mapDevices(list);
        set = settingsDeviceListViewModel.previousPairedDeviceIds;
        String findNewlyBoundDeviceName = SettingsDeviceMapperKt.findNewlyBoundDeviceName(mapDevices, set);
        if (findNewlyBoundDeviceName != null) {
            z = settingsDeviceListViewModel.newDeviceNotificationsEnabled;
            if (z) {
                mutableLiveData2 = settingsDeviceListViewModel._newOnlineDevice;
                mutableLiveData2.postValue(findNewlyBoundDeviceName);
            }
        }
        settingsDeviceListViewModel.previousPairedDeviceIds = SettingsDeviceMapperKt.pairedDeviceIds(mapDevices);
        mutableLiveData = settingsDeviceListViewModel._devices;
        mutableLiveData.postValue(mapDevices);
        return Unit.INSTANCE;
    }
}
