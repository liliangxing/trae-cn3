package com.bytedance.trae.conversation.devices;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.DeviceDiscoveryRefreshResult;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigatorKt;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceActivateBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet$startPolling$1", f = "DeviceActivateBottomSheet.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceActivateBottomSheet$startPolling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeviceActivateBottomSheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceActivateBottomSheet$startPolling$1(DeviceActivateBottomSheet deviceActivateBottomSheet, Continuation<? super DeviceActivateBottomSheet$startPolling$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceActivateBottomSheet;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceActivateBottomSheet$startPolling$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeviceActivateBottomSheet.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet$startPolling$1$1", f = "DeviceActivateBottomSheet.kt", i = {0, 1}, l = {117, 167}, m = "invokeSuspend", n = {"$this$repeatOnLifecycle", "$this$repeatOnLifecycle"}, s = {"L$0", "L$0"})
    /* renamed from: com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet$startPolling$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DeviceActivateBottomSheet this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07161(DeviceActivateBottomSheet deviceActivateBottomSheet, Continuation<? super C07161> continuation) {
            super(2, continuation);
            this.this$0 = deviceActivateBottomSheet;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c07161 = new C07161(this.this$0, continuation);
            c07161.L$0 = obj;
            return c07161;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0132 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0039  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0130 -> B:7:0x0033). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            C07161 c07161;
            OfflineDeviceTarget offlineDeviceTarget;
            OfflineDeviceTarget offlineDeviceTarget2;
            OfflineDeviceTarget offlineDeviceTarget3;
            OfflineDeviceTarget offlineDeviceTarget4;
            boolean z;
            OfflineDeviceTarget offlineDeviceTarget5;
            OfflineDeviceTarget offlineDeviceTarget6;
            OfflineDeviceTarget offlineDeviceTarget7;
            CliListRepository cliListRepository;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
            } else if (i == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                Object obj2 = obj;
                c07161 = this;
                List<MobileDevice> devices = ((DeviceDiscoveryRefreshResult) obj2).getDevices();
                DeviceOfflineRecoveryPolicy deviceOfflineRecoveryPolicy = DeviceOfflineRecoveryPolicy.INSTANCE;
                offlineDeviceTarget = c07161.this$0.target;
                MobileDevice findRecoveredDevice = deviceOfflineRecoveryPolicy.findRecoveredDevice(offlineDeviceTarget, devices);
                if (findRecoveredDevice != null) {
                    TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
                    StringBuilder sb = new StringBuilder("offline_device_recovered: target=");
                    offlineDeviceTarget2 = c07161.this$0.target;
                    traeLogUtil.i(DeviceActivateBottomSheet.TAG, sb.append(DeviceItemKt.toDeviceLogSummary(offlineDeviceTarget2)).append(", deviceCount=").append(devices.size()).toString());
                    DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator(c07161.this$0);
                    offlineDeviceTarget3 = c07161.this$0.target;
                    if (offlineDeviceTarget3.isPaired() || deviceFlowNavigator == null) {
                        offlineDeviceTarget4 = c07161.this$0.target;
                        if (!offlineDeviceTarget4.isPaired()) {
                            c07161.this$0.dismissAllowingStateLoss();
                            Function1<MobileDevice, Unit> onUnpairedDeviceOnline = c07161.this$0.getOnUnpairedDeviceOnline();
                            if (onUnpairedDeviceOnline != null) {
                                onUnpairedDeviceOnline.invoke(findRecoveredDevice);
                            }
                        } else if (deviceFlowNavigator != null) {
                            if (deviceFlowNavigator.onRouteBack()) {
                                Function0<Unit> onDismissListener = c07161.this$0.getOnDismissListener();
                                if (onDismissListener != null) {
                                    onDismissListener.invoke();
                                }
                            } else {
                                z = false;
                                if (z) {
                                    return Unit.INSTANCE;
                                }
                            }
                        } else {
                            c07161.this$0.dismissAllowingStateLoss();
                        }
                    } else {
                        offlineDeviceTarget5 = c07161.this$0.target;
                        DeviceProductType productType = offlineDeviceTarget5.getProductType();
                        offlineDeviceTarget6 = c07161.this$0.target;
                        Set<String> idsForProduct = DeviceBindingPolicyKt.idsForProduct(devices, offlineDeviceTarget6.getProductType());
                        offlineDeviceTarget7 = c07161.this$0.target;
                        deviceFlowNavigator.navigate(new DeviceFlowRoute.ConnectGuide(new BindingTarget(productType, idsForProduct, offlineDeviceTarget7.getEnterFrom(), DevicePairingTrigger.UNBOUND_DEVICE, findRecoveredDevice.getId(), findRecoveredDevice.getName())));
                    }
                    z = true;
                    if (z) {
                    }
                }
                c07161.L$0 = coroutineScope;
                c07161.label = 2;
                if (DelayKt.delay(5000L, (Continuation) c07161) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    cliListRepository = c07161.this$0.repository;
                    c07161.L$0 = coroutineScope;
                    c07161.label = 1;
                    obj2 = cliListRepository.refreshDiscoverableDevices((Continuation) c07161);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    List<MobileDevice> devices2 = ((DeviceDiscoveryRefreshResult) obj2).getDevices();
                    DeviceOfflineRecoveryPolicy deviceOfflineRecoveryPolicy2 = DeviceOfflineRecoveryPolicy.INSTANCE;
                    offlineDeviceTarget = c07161.this$0.target;
                    MobileDevice findRecoveredDevice2 = deviceOfflineRecoveryPolicy2.findRecoveredDevice(offlineDeviceTarget, devices2);
                    if (findRecoveredDevice2 != null) {
                    }
                    c07161.L$0 = coroutineScope;
                    c07161.label = 2;
                    if (DelayKt.delay(5000L, (Continuation) c07161) == coroutine_suspended) {
                    }
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            c07161 = this;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.RESUMED, new C07161(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
}
