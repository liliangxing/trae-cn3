package com.bytedance.trae.home.solo.setting.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementAction;
import com.bytedance.trae.kmp.host.KmpHostInfo;
import com.bytedance.trae.kmp.network.KmpHttpClient;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: DeviceManagementViewModel.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B%\b\u0002\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u000bB#\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\b\u0010\u0010J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\r\u0010%\u001a\u00020\"H\u0000¢\u0006\u0002\b&J\r\u0010'\u001a\u00020\"H\u0000¢\u0006\u0002\b(J\b\u0010)\u001a\u00020\"H\u0002J\u0016\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,H\u0082@¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\"H\u0002J\u0018\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\"2\u0006\u00100\u001a\u000201H\u0002J\u0006\u00105\u001a\u000203J\u0006\u00106\u001a\u000203R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;", "Landroidx/lifecycle/ViewModel;", "repositoryFactory", "Lkotlin/Function1;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;", "hostInfo", "Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "<init>", "(Lkotlin/jvm/functions/Function1;Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V", "repository", "(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V", "httpClient", "Lcom/bytedance/trae/kmp/network/KmpHttpClient;", "repositoryDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bytedance/trae/kmp/network/KmpHttpClient;Lcom/bytedance/trae/kmp/host/KmpHostInfo;Lkotlinx/coroutines/CoroutineDispatcher;)V", "uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "_effects", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect;", "effects", "Lkotlinx/coroutines/flow/SharedFlow;", "getEffects", "()Lkotlinx/coroutines/flow/SharedFlow;", "pollingJob", "Lkotlinx/coroutines/Job;", "onAction", "", "action", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "startPolling", "startPolling$impl_mainlandRelease", "stopPolling", "stopPolling$impl_mainlandRelease", "refresh", "refreshDevices", "showLoading", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyGuideUrl", "rename", "device", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "name", "", "delete", "downloadUrl", "displayUrl", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceManagementViewModel extends ViewModel {
    private static final long POLLING_INTERVAL_MS = 5000;
    private final MutableSharedFlow<DeviceManagementEffect> _effects;
    private final SharedFlow<DeviceManagementEffect> effects;
    private final KmpHostInfo hostInfo;
    private Job pollingJob;
    private final DeviceManagementRepository repository;
    private final StateFlow<DeviceManagementUiState> state;
    private final MutableStateFlow<DeviceManagementUiState> uiState;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeviceManagementRepository _init_$lambda$0(DeviceManagementRepository deviceManagementRepository, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "it");
        return deviceManagementRepository;
    }

    private DeviceManagementViewModel(Function1<? super CoroutineScope, ? extends DeviceManagementRepository> function1, KmpHostInfo kmpHostInfo) {
        this.hostInfo = kmpHostInfo;
        DeviceManagementViewModel deviceManagementViewModel = this;
        DeviceManagementRepository deviceManagementRepository = (DeviceManagementRepository) function1.invoke(ViewModelKt.getViewModelScope(deviceManagementViewModel));
        this.repository = deviceManagementRepository;
        Flow MutableStateFlow = StateFlowKt.MutableStateFlow(new DeviceManagementUiState(false, false, null, null, null, null, null, 127, null));
        this.uiState = MutableStateFlow;
        this.state = FlowKt.stateIn(FlowKt.combine(MutableStateFlow, deviceManagementRepository.getDevices(), new DeviceManagementViewModel$state$1(null)), ViewModelKt.getViewModelScope(deviceManagementViewModel), SharingStarted.Companion.getEagerly(), DeviceManagementUiState.copy$default((DeviceManagementUiState) MutableStateFlow.getValue(), false, false, (List) deviceManagementRepository.getDevices().getValue(), null, null, null, null, 123, null));
        MutableSharedFlow<DeviceManagementEffect> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._effects = MutableSharedFlow$default;
        this.effects = FlowKt.asSharedFlow(MutableSharedFlow$default);
        refresh();
    }

    public final StateFlow<DeviceManagementUiState> getState() {
        return this.state;
    }

    public final SharedFlow<DeviceManagementEffect> getEffects() {
        return this.effects;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeviceManagementViewModel(final DeviceManagementRepository deviceManagementRepository, KmpHostInfo kmpHostInfo) {
        this((Function1<? super CoroutineScope, ? extends DeviceManagementRepository>) new Function1() { // from class: com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                DeviceManagementRepository _init_$lambda$0;
                _init_$lambda$0 = DeviceManagementViewModel._init_$lambda$0(DeviceManagementRepository.this, (CoroutineScope) obj);
                return _init_$lambda$0;
            }
        }, kmpHostInfo);
        Intrinsics.checkNotNullParameter(deviceManagementRepository, "repository");
        Intrinsics.checkNotNullParameter(kmpHostInfo, "hostInfo");
    }

    public /* synthetic */ DeviceManagementViewModel(KmpHttpClient kmpHttpClient, KmpHostInfo kmpHostInfo, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kmpHttpClient, kmpHostInfo, (i & 4) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeviceManagementViewModel(final KmpHttpClient kmpHttpClient, KmpHostInfo kmpHostInfo, final CoroutineDispatcher coroutineDispatcher) {
        this((Function1<? super CoroutineScope, ? extends DeviceManagementRepository>) new Function1() { // from class: com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                DeviceManagementRepository _init_$lambda$1;
                _init_$lambda$1 = DeviceManagementViewModel._init_$lambda$1(kmpHttpClient, coroutineDispatcher, (CoroutineScope) obj);
                return _init_$lambda$1;
            }
        }, kmpHostInfo);
        Intrinsics.checkNotNullParameter(kmpHttpClient, "httpClient");
        Intrinsics.checkNotNullParameter(kmpHostInfo, "hostInfo");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "repositoryDispatcher");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeviceManagementRepository _init_$lambda$1(KmpHttpClient kmpHttpClient, CoroutineDispatcher coroutineDispatcher, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        return new DefaultDeviceManagementRepository(kmpHttpClient, coroutineScope, coroutineDispatcher);
    }

    public final void onAction(DeviceManagementAction action) {
        Object value;
        Object value2;
        Object value3;
        Object value4;
        Object value5;
        Object value6;
        DeviceManagementAction.OpenMenu openMenu;
        Object value7;
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, DeviceManagementAction.Refresh.INSTANCE)) {
            refresh();
            return;
        }
        if (action instanceof DeviceManagementAction.SelectGuideProduct) {
            MutableStateFlow<DeviceManagementUiState> mutableStateFlow = this.uiState;
            do {
                value7 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value7, DeviceManagementUiState.copy$default((DeviceManagementUiState) value7, false, false, null, ((DeviceManagementAction.SelectGuideProduct) action).getProduct(), null, null, null, 119, null)));
            return;
        }
        if (Intrinsics.areEqual(action, DeviceManagementAction.CopyGuideUrl.INSTANCE)) {
            copyGuideUrl();
            return;
        }
        if (action instanceof DeviceManagementAction.OpenMenu) {
            MutableStateFlow<DeviceManagementUiState> mutableStateFlow2 = this.uiState;
            do {
                value6 = mutableStateFlow2.getValue();
                openMenu = (DeviceManagementAction.OpenMenu) action;
            } while (!mutableStateFlow2.compareAndSet(value6, DeviceManagementUiState.copy$default((DeviceManagementUiState) value6, false, false, null, null, new DeviceManagementMenuState(openMenu.getDevice(), openMenu.getSource(), openMenu.getAnchorX(), openMenu.getAnchorY()), null, null, 111, null)));
            return;
        }
        if (Intrinsics.areEqual(action, DeviceManagementAction.CloseMenu.INSTANCE)) {
            MutableStateFlow<DeviceManagementUiState> mutableStateFlow3 = this.uiState;
            do {
                value5 = mutableStateFlow3.getValue();
            } while (!mutableStateFlow3.compareAndSet(value5, DeviceManagementUiState.copy$default((DeviceManagementUiState) value5, false, false, null, null, null, null, null, 111, null)));
            return;
        }
        if (action instanceof DeviceManagementAction.OpenRename) {
            MutableStateFlow<DeviceManagementUiState> mutableStateFlow4 = this.uiState;
            do {
                value4 = mutableStateFlow4.getValue();
            } while (!mutableStateFlow4.compareAndSet(value4, DeviceManagementUiState.copy$default((DeviceManagementUiState) value4, false, false, null, null, null, new DeviceManagementRenameState(((DeviceManagementAction.OpenRename) action).getDevice()), null, 79, null)));
            return;
        }
        if (Intrinsics.areEqual(action, DeviceManagementAction.CloseRename.INSTANCE)) {
            MutableStateFlow<DeviceManagementUiState> mutableStateFlow5 = this.uiState;
            do {
                value3 = mutableStateFlow5.getValue();
            } while (!mutableStateFlow5.compareAndSet(value3, DeviceManagementUiState.copy$default((DeviceManagementUiState) value3, false, false, null, null, null, null, null, 95, null)));
            return;
        }
        if (action instanceof DeviceManagementAction.SubmitRename) {
            DeviceManagementAction.SubmitRename submitRename = (DeviceManagementAction.SubmitRename) action;
            rename(submitRename.getDevice(), submitRename.getName());
            return;
        }
        if (action instanceof DeviceManagementAction.OpenDelete) {
            MutableStateFlow<DeviceManagementUiState> mutableStateFlow6 = this.uiState;
            do {
                value2 = mutableStateFlow6.getValue();
            } while (!mutableStateFlow6.compareAndSet(value2, DeviceManagementUiState.copy$default((DeviceManagementUiState) value2, false, false, null, null, null, null, new DeviceManagementDeleteState(((DeviceManagementAction.OpenDelete) action).getDevice()), 47, null)));
        } else if (Intrinsics.areEqual(action, DeviceManagementAction.CloseDelete.INSTANCE)) {
            MutableStateFlow<DeviceManagementUiState> mutableStateFlow7 = this.uiState;
            do {
                value = mutableStateFlow7.getValue();
            } while (!mutableStateFlow7.compareAndSet(value, DeviceManagementUiState.copy$default((DeviceManagementUiState) value, false, false, null, null, null, null, null, 63, null)));
        } else {
            if (!(action instanceof DeviceManagementAction.ConfirmDelete)) {
                throw new NoWhenBranchMatchedException();
            }
            delete(((DeviceManagementAction.ConfirmDelete) action).getDevice());
        }
    }

    public final void startPolling$impl_mainlandRelease() {
        stopPolling$impl_mainlandRelease();
        this.pollingJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new DeviceManagementViewModel$startPolling$1(this, null), 3, (Object) null);
    }

    public final void stopPolling$impl_mainlandRelease() {
        Job job = this.pollingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.pollingJob = null;
    }

    private final void refresh() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new DeviceManagementViewModel$refresh$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshDevices(boolean z, Continuation<? super Unit> continuation) {
        DeviceManagementViewModel$refreshDevices$1 deviceManagementViewModel$refreshDevices$1;
        int i;
        DeviceManagementViewModel deviceManagementViewModel;
        Object value;
        boolean booleanValue;
        MutableStateFlow<DeviceManagementUiState> mutableStateFlow;
        Object value2;
        if (continuation instanceof DeviceManagementViewModel$refreshDevices$1) {
            deviceManagementViewModel$refreshDevices$1 = (DeviceManagementViewModel$refreshDevices$1) continuation;
            if ((deviceManagementViewModel$refreshDevices$1.label & Integer.MIN_VALUE) != 0) {
                deviceManagementViewModel$refreshDevices$1.label -= Integer.MIN_VALUE;
                Object obj = deviceManagementViewModel$refreshDevices$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = deviceManagementViewModel$refreshDevices$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (z) {
                        MutableStateFlow<DeviceManagementUiState> mutableStateFlow2 = this.uiState;
                        do {
                            value = mutableStateFlow2.getValue();
                        } while (!mutableStateFlow2.compareAndSet(value, DeviceManagementUiState.copy$default((DeviceManagementUiState) value, true, false, null, null, null, null, null, 126, null)));
                    }
                    DeviceManagementRepository deviceManagementRepository = this.repository;
                    deviceManagementViewModel$refreshDevices$1.L$0 = this;
                    deviceManagementViewModel$refreshDevices$1.label = 1;
                    obj = deviceManagementRepository.refresh(deviceManagementViewModel$refreshDevices$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    deviceManagementViewModel = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    deviceManagementViewModel = (DeviceManagementViewModel) deviceManagementViewModel$refreshDevices$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                booleanValue = ((Boolean) obj).booleanValue();
                mutableStateFlow = deviceManagementViewModel.uiState;
                do {
                    value2 = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value2, DeviceManagementUiState.copy$default((DeviceManagementUiState) value2, false, !booleanValue, null, null, null, null, null, 124, null)));
                return Unit.INSTANCE;
            }
        }
        deviceManagementViewModel$refreshDevices$1 = new DeviceManagementViewModel$refreshDevices$1(this, continuation);
        Object obj2 = deviceManagementViewModel$refreshDevices$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = deviceManagementViewModel$refreshDevices$1.label;
        if (i != 0) {
        }
        booleanValue = ((Boolean) obj2).booleanValue();
        mutableStateFlow = deviceManagementViewModel.uiState;
        do {
            value2 = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value2, DeviceManagementUiState.copy$default((DeviceManagementUiState) value2, false, !booleanValue, null, null, null, null, null, 124, null)));
        return Unit.INSTANCE;
    }

    private final void copyGuideUrl() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new DeviceManagementViewModel$copyGuideUrl$1(this, downloadUrl(), null), 3, (Object) null);
    }

    private final void rename(DeviceManagementDevice device, String name) {
        Object obj;
        Object value;
        Object value2;
        String obj2 = StringsKt.trim(name).toString();
        if (obj2.length() == 0) {
            return;
        }
        Iterator it = ((Iterable) this.repository.getDevices().getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((DeviceManagementDevice) obj).getId(), device.getId())) {
                    break;
                }
            }
        }
        DeviceManagementDevice deviceManagementDevice = (DeviceManagementDevice) obj;
        if (deviceManagementDevice == null) {
            return;
        }
        if (Intrinsics.areEqual(deviceManagementDevice.getName(), obj2)) {
            MutableStateFlow<DeviceManagementUiState> mutableStateFlow = this.uiState;
            do {
                value2 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value2, DeviceManagementUiState.copy$default((DeviceManagementUiState) value2, false, false, null, null, null, null, null, 79, null)));
        } else {
            MutableStateFlow<DeviceManagementUiState> mutableStateFlow2 = this.uiState;
            do {
                value = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value, DeviceManagementUiState.copy$default((DeviceManagementUiState) value, false, false, null, null, null, null, null, 79, null)));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new DeviceManagementViewModel$rename$3(this, device, obj2, null), 3, (Object) null);
        }
    }

    private final void delete(DeviceManagementDevice device) {
        Object value;
        MutableStateFlow<DeviceManagementUiState> mutableStateFlow = this.uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, DeviceManagementUiState.copy$default((DeviceManagementUiState) value, false, false, null, null, null, null, null, 47, null)));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new DeviceManagementViewModel$delete$2(this, device, null), 3, (Object) null);
    }

    public final String downloadUrl() {
        return this.hostInfo.isOversea() ? "https://trae.ai" : "https://trae.cn";
    }

    public final String displayUrl() {
        return this.hostInfo.isOversea() ? "trae.ai" : "trae.cn";
    }

    /* compiled from: DeviceManagementViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$Companion;", "", "<init>", "()V", "POLLING_INTERVAL_MS", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
