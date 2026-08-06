package com.bytedance.trae.conversation.devices;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: ConnectComputerGuideViewModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u0019\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;", "Landroidx/lifecycle/ViewModel;", "target", "Lcom/bytedance/trae/conversation/devices/BindingTarget;", "discovery", "Lcom/bytedance/trae/conversation/devices/BindingDeviceDiscovery;", "pollIntervalMs", "", "<init>", "(Lcom/bytedance/trae/conversation/devices/BindingTarget;Lcom/bytedance/trae/conversation/devices/BindingDeviceDiscovery;J)V", "stateMachine", "Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/trae/conversation/devices/BindingGuideState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "pollingJob", "Lkotlinx/coroutines/Job;", "start", "", "consumeSucceededDevice", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "stop", "onCleared", "Factory", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConnectComputerGuideViewModel extends ViewModel {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final long POLL_INTERVAL_MS = 5000;
    private final MutableStateFlow<BindingGuideState> _state;
    private final BindingDeviceDiscovery discovery;
    private final long pollIntervalMs;
    private Job pollingJob;
    private final StateFlow<BindingGuideState> state;
    private final BindingGuideStateMachine stateMachine;

    public /* synthetic */ ConnectComputerGuideViewModel(BindingTarget bindingTarget, DefaultBindingDeviceDiscovery defaultBindingDeviceDiscovery, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bindingTarget, (i & 2) != 0 ? DefaultBindingDeviceDiscovery.INSTANCE : defaultBindingDeviceDiscovery, (i & 4) != 0 ? 5000L : j);
    }

    public ConnectComputerGuideViewModel(BindingTarget bindingTarget, BindingDeviceDiscovery bindingDeviceDiscovery, long j) {
        Intrinsics.checkNotNullParameter(bindingTarget, "target");
        Intrinsics.checkNotNullParameter(bindingDeviceDiscovery, "discovery");
        this.discovery = bindingDeviceDiscovery;
        this.pollIntervalMs = j;
        BindingGuideStateMachine bindingGuideStateMachine = new BindingGuideStateMachine(bindingTarget);
        this.stateMachine = bindingGuideStateMachine;
        MutableStateFlow<BindingGuideState> MutableStateFlow = StateFlowKt.MutableStateFlow(bindingGuideStateMachine.getCurrentState());
        this._state = MutableStateFlow;
        this.state = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<BindingGuideState> getState() {
        return this.state;
    }

    public final void start() {
        Job job = this.pollingJob;
        boolean z = false;
        if (job != null && job.isActive()) {
            z = true;
        }
        if (z) {
            return;
        }
        this.pollingJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConnectComputerGuideViewModel$start$1(this, null), 3, (Object) null);
    }

    public final MobileDevice consumeSucceededDevice() {
        return this.stateMachine.consumeSucceededDevice();
    }

    public final void stop() {
        Job job = this.pollingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.pollingJob = null;
    }

    protected void onCleared() {
        stop();
        super.onCleared();
    }

    /* compiled from: ConnectComputerGuideViewModel.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "target", "Lcom/bytedance/trae/conversation/devices/BindingTarget;", "<init>", "(Lcom/bytedance/trae/conversation/devices/BindingTarget;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Factory implements ViewModelProvider.Factory {
        private final BindingTarget target;

        public Factory(BindingTarget bindingTarget) {
            Intrinsics.checkNotNullParameter(bindingTarget, "target");
            this.target = bindingTarget;
        }

        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            if (!modelClass.isAssignableFrom(ConnectComputerGuideViewModel.class)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            return new ConnectComputerGuideViewModel(this.target, null, 0L, 6, null);
        }
    }

    /* compiled from: ConnectComputerGuideViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$Companion;", "", "<init>", "()V", "POLL_INTERVAL_MS", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
