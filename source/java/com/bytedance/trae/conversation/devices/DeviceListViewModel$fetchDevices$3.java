package com.bytedance.trae.conversation.devices;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.DeviceDiscoveryRefreshResult;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.multilanguage.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceListViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.devices.DeviceListViewModel$fetchDevices$3", f = "DeviceListViewModel.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceListViewModel$fetchDevices$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isCodeMode;
    int label;
    final /* synthetic */ DeviceListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceListViewModel$fetchDevices$3(DeviceListViewModel deviceListViewModel, Context context, boolean z, Continuation<? super DeviceListViewModel$fetchDevices$3> continuation) {
        super(2, continuation);
        this.this$0 = deviceListViewModel;
        this.$context = context;
        this.$isCodeMode = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceListViewModel$fetchDevices$3(this.this$0, this.$context, this.$isCodeMode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CliListRepository cliListRepository;
        Object refreshDiscoverableDevices;
        String str;
        int i;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            cliListRepository = this.this$0.repository;
            this.label = 1;
            refreshDiscoverableDevices = cliListRepository.refreshDiscoverableDevices((Continuation) this);
            if (refreshDiscoverableDevices == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            refreshDiscoverableDevices = obj;
        }
        List<MobileDevice> devices = ((DeviceDiscoveryRefreshResult) refreshDiscoverableDevices).getDevices();
        String string = this.$context.getString(R.string.trae_solo_cloud);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        DeviceItem deviceItem = new DeviceItem("cloud", string, null, C0637R.drawable.ic_remote, true, false, CliType.REMOTE, null, false, 388, null);
        List<DeviceItem> plus = CollectionsKt.plus(CollectionsKt.listOf(deviceItem), DeviceListMapperKt.toSelectableDeviceItems(devices, this.$isCodeMode, C0637R.drawable.ic_computer));
        DeviceListSelectionPolicy deviceListSelectionPolicy = DeviceListSelectionPolicy.INSTANCE;
        str = this.this$0.sessionSelectedDeviceId;
        DeviceListSelectionResult applySelection = deviceListSelectionPolicy.applySelection(plus, str, this.this$0.getPreselectedDeviceId());
        this.this$0.sessionSelectedDeviceId = applySelection.getSessionSelectedDeviceId();
        List<DeviceItem> devices2 = applySelection.getDevices();
        DeviceListViewModel deviceListViewModel = this.this$0;
        i = deviceListViewModel.deviceListRevision;
        deviceListViewModel.deviceListRevision = i + 1;
        mutableLiveData = this.this$0._devices;
        mutableLiveData.postValue(devices2);
        mutableLiveData2 = this.this$0._isLoading;
        mutableLiveData2.postValue(Boxing.boxBoolean(false));
        this.this$0.logFetchResult(this.$isCodeMode, devices.size(), devices2);
        return Unit.INSTANCE;
    }
}
