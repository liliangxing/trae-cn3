package com.bytedance.trae.conversation.devices.flow;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.devices.BindingTarget;
import com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet;
import com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment;
import com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet;
import com.bytedance.trae.conversation.devices.DeviceAddTargetPolicy;
import com.bytedance.trae.conversation.devices.DeviceBindingPolicyKt;
import com.bytedance.trae.conversation.devices.DeviceItem;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.devices.DeviceSelectBottomSheet;
import com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet;
import com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment;
import com.bytedance.trae.conversation.devices.DirectoryNode;
import com.bytedance.trae.conversation.devices.MobileDevice;
import com.bytedance.trae.conversation.devices.MobileIdeFeatureGate;
import com.bytedance.trae.conversation.devices.OfflineDeviceTarget;
import com.bytedance.trae.conversation.devices.SelectedDeviceItem;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowConnectionSuccessDestination;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute;
import com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptBottomSheet;
import com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet;
import com.bytedance.trae.conversation.ideproject.IDEProjectNameUtil;
import com.bytedance.trae.conversation.network.ProjectItem;
import com.bytedance.trae.conversation.tracker.DeviceTracker;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFlowContainerBottomSheet.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0016\u0010#\u001a\u00020\f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J\b\u0010'\u001a\u00020\fH\u0016J\u0010\u0010(\u001a\u00020\f2\u0006\u0010!\u001a\u00020\nH\u0016J\u0014\u0010)\u001a\u00020\f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\fH\u0002J\u0010\u0010.\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u0006H\u0002J\b\u0010/\u001a\u00020\fH\u0016J\u0010\u00100\u001a\u00020\f2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u00104\u001a\u0002052\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u00106\u001a\u0002052\u0006\u0010\u001a\u001a\u000207H\u0002J\u0010\u00108\u001a\u0002052\u0006\u0010\u001a\u001a\u000209H\u0002J\u0010\u0010:\u001a\u0002052\u0006\u0010\u001a\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u0002052\u0006\u0010\u001a\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u0002052\u0006\u0010\u001a\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u0002052\u0006\u0010\u001a\u001a\u00020?H\u0002J\u0010\u0010A\u001a\u0002052\u0006\u0010\u001a\u001a\u00020?H\u0002J\u0010\u0010B\u001a\u0002052\u0006\u0010\u001a\u001a\u00020CH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;", "<init>", "()V", "requestKey", "", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;", "deferredConnectionSuccessDevice", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "navigate", "route", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;", "openNewFlow", "onRouteBack", "", "closeCurrentFlow", "notifyDeviceSelected", "device", "Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "notifyDeviceListChanged", "devices", "", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "notifyConnectionSuccess", "notifyConnectionSuccessWithDevice", "notifyCurrentRouteConnectionSuccess", "selectedDeviceId", "returnToDeviceSelectionAfterBinding", "canMutateChildFragmentState", "completeDeferredConnectionSuccessIfPossible", "completeReturnToDeviceSelection", "onResume", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "showInitialRoute", "createRouteFragment", "Landroidx/fragment/app/Fragment;", "createDeviceSelectFragment", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;", "createTargetSelectFragment", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;", "createNewFeaturePromptFragment", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;", "createConnectGuideFragment", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;", "createProjectSelectFragment", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;", "createIdeProjectSelectFragment", "createDirectorySelectFragment", "createOfflineActivationFragment", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceFlowContainerBottomSheet extends BottomSheetDialogFragment implements DeviceFlowNavigator {
    private static final String ARG_REQUEST_KEY = "arg_request_key";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "DeviceFlowContainerBottomSheet";
    private MobileDevice deferredConnectionSuccessDevice;
    private DeviceFlowRequest request;
    private String requestKey;

    /* compiled from: DeviceFlowContainerBottomSheet.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceFlowBackAction.values().length];
            try {
                iArr[DeviceFlowBackAction.PopRoute.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceFlowBackAction.CloseFlow.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeviceFlowBackAction.Defer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_REQUEST_KEY) : null;
        this.requestKey = string;
        this.request = string != null ? DeviceFlowStore.INSTANCE.get(string) : null;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        Dialog dialog = (BottomSheetDialog) onCreateDialog;
        final int dimensionPixelSize = getResources().getDimensionPixelSize(C0637R.dimen.trae_connect_guide_sheet_height);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DeviceFlowContainerBottomSheet.onCreateDialog$lambda$3(dimensionPixelSize, dialogInterface);
            }
        });
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean onCreateDialog$lambda$4;
                onCreateDialog$lambda$4 = DeviceFlowContainerBottomSheet.onCreateDialog$lambda$4(DeviceFlowContainerBottomSheet.this, dialogInterface, i, keyEvent);
                return onCreateDialog$lambda$4;
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$3(int i, DialogInterface dialogInterface) {
        View findViewById;
        BottomSheetDialog bottomSheetDialog = dialogInterface instanceof BottomSheetDialog ? (BottomSheetDialog) dialogInterface : null;
        if (bottomSheetDialog == null || (findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet)) == null) {
            return;
        }
        findViewById.setBackgroundResource(android.R.color.transparent);
        BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
        from.setPeekHeight(i);
        from.setState(3);
        from.setSkipCollapsed(true);
        from.setHideable(true);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = i;
        findViewById.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateDialog$lambda$4(DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        deviceFlowContainerBottomSheet.closeCurrentFlow();
        return true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(C0637R.layout.bottom_sheet_device_flow_container, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        DeviceFlowRequest deviceFlowRequest = this.request;
        if (deviceFlowRequest == null) {
            dismissAllowingStateLoss();
        } else if (savedInstanceState == null && getChildFragmentManager().findFragmentById(C0637R.id.device_flow_content) == null) {
            showInitialRoute(deviceFlowRequest.getInitialRoute());
        }
    }

    @Override // com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator
    public void navigate(DeviceFlowRoute route) {
        Intrinsics.checkNotNullParameter(route, "route");
        getChildFragmentManager().beginTransaction().setCustomAnimations(C0637R.anim.trae_slide_in_right, C0637R.anim.trae_slide_out_left, C0637R.anim.trae_slide_in_left, C0637R.anim.trae_slide_out_right).replace(C0637R.id.device_flow_content, createRouteFragment(route), route.getClass().getSimpleName()).addToBackStack(route.getClass().getSimpleName()).commitAllowingStateLoss();
    }

    @Override // com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator
    public void openNewFlow(DeviceFlowRoute route) {
        Intrinsics.checkNotNullParameter(route, "route");
        DeviceFlowRequest deviceFlowRequest = this.request;
        if (deviceFlowRequest == null) {
            return;
        }
        INSTANCE.newInstance(new DeviceFlowRequest(route, DeviceFlowNestedFlowCallbacks.INSTANCE.withCurrentRouteRefresh(deviceFlowRequest.getCallbacks(), new DeviceFlowContainerBottomSheet$openNewFlow$1(this), new DeviceFlowContainerBottomSheet$openNewFlow$2(this)))).show(getParentFragmentManager(), TAG);
    }

    @Override // com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator
    public boolean onRouteBack() {
        if (!isAdded()) {
            TraeLogUtil.INSTANCE.w(TAG, "device_flow_route_back_deferred: reason=not_added");
            return false;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        int i = WhenMappings.$EnumSwitchMapping$0[DeviceFlowBackPolicy.INSTANCE.leftAction(childFragmentManager.getBackStackEntryCount(), getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) && !childFragmentManager.isStateSaved()).ordinal()];
        if (i == 1) {
            childFragmentManager.popBackStack();
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                TraeLogUtil.INSTANCE.w(TAG, "device_flow_route_back_deferred: stateSaved=" + childFragmentManager.isStateSaved() + ", lifecycle=" + getLifecycle().getCurrentState());
                return false;
            }
            closeCurrentFlow();
        }
        return true;
    }

    @Override // com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator
    public void closeCurrentFlow() {
        dismissAllowingStateLoss();
    }

    @Override // com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator
    public void notifyDeviceSelected(SelectedDeviceItem device) {
        DeviceFlowCallbacks callbacks;
        Function1<SelectedDeviceItem, Unit> onDeviceSelected;
        Intrinsics.checkNotNullParameter(device, "device");
        DeviceFlowRequest deviceFlowRequest = this.request;
        if (deviceFlowRequest != null && (callbacks = deviceFlowRequest.getCallbacks()) != null && (onDeviceSelected = callbacks.getOnDeviceSelected()) != null) {
            onDeviceSelected.invoke(device);
        }
        dismissAllowingStateLoss();
    }

    @Override // com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator
    public void notifyDeviceListChanged(List<DeviceItem> devices) {
        DeviceFlowCallbacks callbacks;
        Function1<List<DeviceItem>, Unit> onDeviceListChanged;
        Intrinsics.checkNotNullParameter(devices, "devices");
        DeviceFlowRequest deviceFlowRequest = this.request;
        if (deviceFlowRequest == null || (callbacks = deviceFlowRequest.getCallbacks()) == null || (onDeviceListChanged = callbacks.getOnDeviceListChanged()) == null) {
            return;
        }
        onDeviceListChanged.invoke(devices);
    }

    @Override // com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator
    public void notifyConnectionSuccess() {
        DeviceFlowCallbacks callbacks;
        Function0<Unit> onConnectionSuccess;
        DeviceFlowRequest deviceFlowRequest = this.request;
        if (deviceFlowRequest != null && (callbacks = deviceFlowRequest.getCallbacks()) != null && (onConnectionSuccess = callbacks.getOnConnectionSuccess()) != null) {
            onConnectionSuccess.invoke();
        }
        dismissAllowingStateLoss();
    }

    @Override // com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator
    public void notifyConnectionSuccessWithDevice(MobileDevice device) {
        DeviceFlowCallbacks callbacks;
        Function0<Unit> onConnectionSuccess;
        DeviceFlowCallbacks callbacks2;
        Function1<MobileDevice, Unit> onConnectionSuccessWithDevice;
        Intrinsics.checkNotNullParameter(device, "device");
        if (returnToDeviceSelectionAfterBinding(device)) {
            return;
        }
        DeviceFlowRequest deviceFlowRequest = this.request;
        if (deviceFlowRequest != null && (callbacks2 = deviceFlowRequest.getCallbacks()) != null && (onConnectionSuccessWithDevice = callbacks2.getOnConnectionSuccessWithDevice()) != null) {
            onConnectionSuccessWithDevice.invoke(device);
        }
        DeviceFlowRequest deviceFlowRequest2 = this.request;
        if (deviceFlowRequest2 != null && (callbacks = deviceFlowRequest2.getCallbacks()) != null && (onConnectionSuccess = callbacks.getOnConnectionSuccess()) != null) {
            onConnectionSuccess.invoke();
        }
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void notifyCurrentRouteConnectionSuccess$default(DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        deviceFlowContainerBottomSheet.notifyCurrentRouteConnectionSuccess(str);
    }

    private final void notifyCurrentRouteConnectionSuccess(String selectedDeviceId) {
        DeviceFlowConnectionSuccessRefreshTarget findFragmentById = getChildFragmentManager().findFragmentById(C0637R.id.device_flow_content);
        DeviceFlowConnectionSuccessRefreshTarget deviceFlowConnectionSuccessRefreshTarget = findFragmentById instanceof DeviceFlowConnectionSuccessRefreshTarget ? findFragmentById : null;
        if (deviceFlowConnectionSuccessRefreshTarget != null) {
            deviceFlowConnectionSuccessRefreshTarget.onDeviceConnectionSuccess(selectedDeviceId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean returnToDeviceSelectionAfterBinding(MobileDevice device) {
        DeviceFlowRoute initialRoute;
        DeviceFlowRequest deviceFlowRequest = this.request;
        if (deviceFlowRequest == null || (initialRoute = deviceFlowRequest.getInitialRoute()) == null) {
            return false;
        }
        DeviceFlowConnectionSuccessDestination destination = DeviceFlowConnectionSuccessPolicy.INSTANCE.destination(initialRoute, device, canMutateChildFragmentState());
        if (destination instanceof DeviceFlowConnectionSuccessDestination.DeferReturnToDeviceSelection) {
            this.deferredConnectionSuccessDevice = device;
        } else if (destination instanceof DeviceFlowConnectionSuccessDestination.ReturnToDeviceSelection) {
            completeReturnToDeviceSelection(((DeviceFlowConnectionSuccessDestination.ReturnToDeviceSelection) destination).getSelectedDeviceId());
        } else {
            if (Intrinsics.areEqual(destination, DeviceFlowConnectionSuccessDestination.NotifyHost.INSTANCE)) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        }
        return true;
    }

    private final boolean canMutateChildFragmentState() {
        return isAdded() && getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) && !getChildFragmentManager().isStateSaved();
    }

    private final void completeDeferredConnectionSuccessIfPossible() {
        MobileDevice mobileDevice = this.deferredConnectionSuccessDevice;
        if (mobileDevice == null || !isAdded() || getChildFragmentManager().isStateSaved()) {
            return;
        }
        completeReturnToDeviceSelection(mobileDevice.getId());
    }

    private final void completeReturnToDeviceSelection(String selectedDeviceId) {
        this.deferredConnectionSuccessDevice = null;
        getChildFragmentManager().popBackStackImmediate((String) null, 1);
        notifyCurrentRouteConnectionSuccess(selectedDeviceId);
    }

    public void onResume() {
        super.onResume();
        completeDeferredConnectionSuccessIfPossible();
    }

    public void onDismiss(DialogInterface dialog) {
        DeviceFlowCallbacks callbacks;
        Function0<Unit> onDismiss;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        DeviceFlowRequest deviceFlowRequest = this.request;
        if (deviceFlowRequest != null && (callbacks = deviceFlowRequest.getCallbacks()) != null && (onDismiss = callbacks.getOnDismiss()) != null) {
            onDismiss.invoke();
        }
        String str = this.requestKey;
        if (str != null) {
            DeviceFlowStore.INSTANCE.remove(str);
        }
        this.deferredConnectionSuccessDevice = null;
        this.request = null;
        this.requestKey = null;
    }

    private final void showInitialRoute(DeviceFlowRoute route) {
        getChildFragmentManager().beginTransaction().replace(C0637R.id.device_flow_content, createRouteFragment(route), route.getClass().getSimpleName()).commitAllowingStateLoss();
    }

    private final Fragment createRouteFragment(DeviceFlowRoute route) {
        if (route instanceof DeviceFlowRoute.DeviceSelect) {
            return createDeviceSelectFragment((DeviceFlowRoute.DeviceSelect) route);
        }
        if (route instanceof DeviceFlowRoute.TargetSelect) {
            return createTargetSelectFragment((DeviceFlowRoute.TargetSelect) route);
        }
        if (route instanceof DeviceFlowRoute.NewFeaturePrompt) {
            return createNewFeaturePromptFragment((DeviceFlowRoute.NewFeaturePrompt) route);
        }
        if (route instanceof DeviceFlowRoute.ConnectGuide) {
            return createConnectGuideFragment((DeviceFlowRoute.ConnectGuide) route);
        }
        if (route instanceof DeviceFlowRoute.ProjectSelect) {
            return createProjectSelectFragment((DeviceFlowRoute.ProjectSelect) route);
        }
        if (route instanceof DeviceFlowRoute.OfflineActivation) {
            return createOfflineActivationFragment((DeviceFlowRoute.OfflineActivation) route);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Fragment createDeviceSelectFragment(DeviceFlowRoute.DeviceSelect route) {
        DeviceFlowRequest deviceFlowRequest = this.request;
        final DeviceFlowCallbacks callbacks = deviceFlowRequest != null ? deviceFlowRequest.getCallbacks() : null;
        if (route.getCodeMode()) {
            Fragment newInstance = CodeDeviceSelectBottomSheet.INSTANCE.newInstance(route.getMode(), route.getPreselectedDeviceId());
            newInstance.setOnDeviceSelected(new Function1() { // from class: com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit createDeviceSelectFragment$lambda$8$lambda$6;
                    createDeviceSelectFragment$lambda$8$lambda$6 = DeviceFlowContainerBottomSheet.createDeviceSelectFragment$lambda$8$lambda$6(DeviceFlowCallbacks.this, (SelectedDeviceItem) obj);
                    return createDeviceSelectFragment$lambda$8$lambda$6;
                }
            });
            newInstance.setOnDeviceListChanged(new Function1() { // from class: com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit createDeviceSelectFragment$lambda$8$lambda$7;
                    createDeviceSelectFragment$lambda$8$lambda$7 = DeviceFlowContainerBottomSheet.createDeviceSelectFragment$lambda$8$lambda$7(DeviceFlowCallbacks.this, (List) obj);
                    return createDeviceSelectFragment$lambda$8$lambda$7;
                }
            });
            return newInstance;
        }
        Fragment newInstance2 = DeviceSelectBottomSheet.INSTANCE.newInstance(route.getMode(), route.getPreselectedDeviceId());
        newInstance2.setOnDeviceSelected(new Function1() { // from class: com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit createDeviceSelectFragment$lambda$11$lambda$9;
                createDeviceSelectFragment$lambda$11$lambda$9 = DeviceFlowContainerBottomSheet.createDeviceSelectFragment$lambda$11$lambda$9(DeviceFlowCallbacks.this, (SelectedDeviceItem) obj);
                return createDeviceSelectFragment$lambda$11$lambda$9;
            }
        });
        newInstance2.setOnDeviceListChanged(new Function1() { // from class: com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit createDeviceSelectFragment$lambda$11$lambda$10;
                createDeviceSelectFragment$lambda$11$lambda$10 = DeviceFlowContainerBottomSheet.createDeviceSelectFragment$lambda$11$lambda$10(DeviceFlowCallbacks.this, (List) obj);
                return createDeviceSelectFragment$lambda$11$lambda$10;
            }
        });
        return newInstance2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createDeviceSelectFragment$lambda$8$lambda$6(DeviceFlowCallbacks deviceFlowCallbacks, SelectedDeviceItem selectedDeviceItem) {
        Function1<SelectedDeviceItem, Unit> onDeviceSelected;
        Intrinsics.checkNotNullParameter(selectedDeviceItem, "device");
        if (deviceFlowCallbacks != null && (onDeviceSelected = deviceFlowCallbacks.getOnDeviceSelected()) != null) {
            onDeviceSelected.invoke(selectedDeviceItem);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createDeviceSelectFragment$lambda$8$lambda$7(DeviceFlowCallbacks deviceFlowCallbacks, List list) {
        Function1<List<DeviceItem>, Unit> onDeviceListChanged;
        Intrinsics.checkNotNullParameter(list, "devices");
        if (deviceFlowCallbacks != null && (onDeviceListChanged = deviceFlowCallbacks.getOnDeviceListChanged()) != null) {
            onDeviceListChanged.invoke(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createDeviceSelectFragment$lambda$11$lambda$9(DeviceFlowCallbacks deviceFlowCallbacks, SelectedDeviceItem selectedDeviceItem) {
        Function1<SelectedDeviceItem, Unit> onDeviceSelected;
        Intrinsics.checkNotNullParameter(selectedDeviceItem, "device");
        if (deviceFlowCallbacks != null && (onDeviceSelected = deviceFlowCallbacks.getOnDeviceSelected()) != null) {
            onDeviceSelected.invoke(selectedDeviceItem);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createDeviceSelectFragment$lambda$11$lambda$10(DeviceFlowCallbacks deviceFlowCallbacks, List list) {
        Function1<List<DeviceItem>, Unit> onDeviceListChanged;
        Intrinsics.checkNotNullParameter(list, "devices");
        if (deviceFlowCallbacks != null && (onDeviceListChanged = deviceFlowCallbacks.getOnDeviceListChanged()) != null) {
            onDeviceListChanged.invoke(list);
        }
        return Unit.INSTANCE;
    }

    private final Fragment createTargetSelectFragment(final DeviceFlowRoute.TargetSelect route) {
        DeviceTargetSelectBottomSheet.Companion companion = DeviceTargetSelectBottomSheet.INSTANCE;
        List<DeviceProductType> availableTargets = route.getAvailableTargets();
        String enterFrom = route.getEnterFrom();
        Set<String> set = route.getExistingDeviceIdsByProduct().get(DeviceProductType.WORK);
        if (set == null) {
            set = SetsKt.emptySet();
        }
        boolean z = !set.isEmpty();
        Set<String> set2 = route.getExistingDeviceIdsByProduct().get(DeviceProductType.IDE);
        if (set2 == null) {
            set2 = SetsKt.emptySet();
        }
        Fragment newInstance = companion.newInstance(availableTargets, enterFrom, z, !set2.isEmpty());
        newInstance.setOnTargetSelected(new Function1() { // from class: com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit createTargetSelectFragment$lambda$13$lambda$12;
                createTargetSelectFragment$lambda$13$lambda$12 = DeviceFlowContainerBottomSheet.createTargetSelectFragment$lambda$13$lambda$12(DeviceFlowContainerBottomSheet.this, route, (DeviceProductType) obj);
                return createTargetSelectFragment$lambda$13$lambda$12;
            }
        });
        return newInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createTargetSelectFragment$lambda$13$lambda$12(DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet, DeviceFlowRoute.TargetSelect targetSelect, DeviceProductType deviceProductType) {
        Intrinsics.checkNotNullParameter(deviceProductType, "productType");
        if (!MobileIdeFeatureGate.INSTANCE.canOpenConnectGuide(deviceProductType)) {
            return Unit.INSTANCE;
        }
        Set<String> set = targetSelect.getExistingDeviceIdsByProduct().get(deviceProductType);
        if (set == null) {
            set = SetsKt.emptySet();
        }
        deviceFlowContainerBottomSheet.navigate(new DeviceFlowRoute.ConnectGuide(new BindingTarget(deviceProductType, set, targetSelect.getEnterFrom(), null, null, null, 56, null)));
        return Unit.INSTANCE;
    }

    private final Fragment createNewFeaturePromptFragment(final DeviceFlowRoute.NewFeaturePrompt route) {
        Fragment newInstance = NewFeaturePromptBottomSheet.INSTANCE.newInstance(route.getProductType(), route.getHasRegisteredWork(), route.getHasRegisteredIDE());
        newInstance.setOnConfirm(new Function0() { // from class: com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda4
            public final Object invoke() {
                Unit createNewFeaturePromptFragment$lambda$15$lambda$14;
                createNewFeaturePromptFragment$lambda$15$lambda$14 = DeviceFlowContainerBottomSheet.createNewFeaturePromptFragment$lambda$15$lambda$14(DeviceFlowRoute.NewFeaturePrompt.this, this);
                return createNewFeaturePromptFragment$lambda$15$lambda$14;
            }
        });
        return newInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createNewFeaturePromptFragment$lambda$15$lambda$14(DeviceFlowRoute.NewFeaturePrompt newFeaturePrompt, DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet) {
        DeviceFlowCallbacks callbacks;
        Function1<DeviceProductType, Unit> onNewFeaturePromptConfirmed;
        if (!MobileIdeFeatureGate.INSTANCE.canOpenConnectGuide(newFeaturePrompt.getProductType())) {
            return Unit.INSTANCE;
        }
        DeviceFlowRequest deviceFlowRequest = deviceFlowContainerBottomSheet.request;
        if (deviceFlowRequest != null && (callbacks = deviceFlowRequest.getCallbacks()) != null && (onNewFeaturePromptConfirmed = callbacks.getOnNewFeaturePromptConfirmed()) != null) {
            onNewFeaturePromptConfirmed.invoke(newFeaturePrompt.getProductType());
        }
        deviceFlowContainerBottomSheet.navigate(new DeviceFlowRoute.ConnectGuide(new BindingTarget(newFeaturePrompt.getProductType(), DeviceBindingPolicyKt.idsForProduct(newFeaturePrompt.getDevices(), newFeaturePrompt.getProductType()), ConnectComputerGuideFragment.ENTER_FROM_NEW_FEATURE_POPUP, null, null, null, 56, null)));
        return Unit.INSTANCE;
    }

    private final Fragment createConnectGuideFragment(DeviceFlowRoute.ConnectGuide route) {
        return ConnectComputerGuideFragment.INSTANCE.newInstance(route.getTarget());
    }

    private final Fragment createProjectSelectFragment(DeviceFlowRoute.ProjectSelect route) {
        if (route.getDevice().getType() == CliType.IDE) {
            return createIdeProjectSelectFragment(route);
        }
        return createDirectorySelectFragment(route);
    }

    private final Fragment createIdeProjectSelectFragment(final DeviceFlowRoute.ProjectSelect route) {
        final Fragment newInstance$default = IDEProjectBottomSheet.Companion.newInstance$default(IDEProjectBottomSheet.INSTANCE, route.getDevice().getId(), null, 2, null);
        newInstance$default.setProjectSelected(new IDEProjectBottomSheet.OnProjectSelectedListener() { // from class: com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet$createIdeProjectSelectFragment$1$1
            @Override // com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet.OnProjectSelectedListener
            public void onProjectSelected(ProjectItem node) {
                Intrinsics.checkNotNullParameter(node, "node");
                DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet = DeviceFlowContainerBottomSheet.this;
                String id = route.getDevice().getId();
                String name = route.getDevice().getName();
                CliType type = route.getDevice().getType();
                String ideVersion = route.getDevice().getIdeVersion();
                String folderPath = node.getFolderPath();
                IDEProjectNameUtil iDEProjectNameUtil = IDEProjectNameUtil.INSTANCE;
                Context requireContext = newInstance$default.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                deviceFlowContainerBottomSheet.notifyDeviceSelected(new SelectedDeviceItem(id, name, type, folderPath, ideVersion, node.getProjectId(), false, iDEProjectNameUtil.getProjectName(requireContext, node.getFolderPath(), node.getWorkspaceType()), route.getShowProductType(), 64, null));
            }
        });
        return newInstance$default;
    }

    private final Fragment createDirectorySelectFragment(final DeviceFlowRoute.ProjectSelect route) {
        Fragment newInstance$default = DirectoryBottomSheetFragment.Companion.newInstance$default(DirectoryBottomSheetFragment.INSTANCE, route.getDevice().getId(), route.getMode(), null, false, 12, null);
        newInstance$default.setOnDirectorySelectedListener(new DirectoryBottomSheetFragment.OnDirectorySelectedListener() { // from class: com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1
            @Override // com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment.OnDirectorySelectedListener
            public void onDirectorySelected(DirectoryNode node) {
                Intrinsics.checkNotNullParameter(node, "node");
                try {
                    Result.Companion companion = Result.Companion;
                    DeviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1 deviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1 = this;
                    DeviceTracker.INSTANCE.trackDeviceSelectPath(node.getDepth());
                    Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
                DeviceFlowContainerBottomSheet.this.notifyDeviceSelected(new SelectedDeviceItem(route.getDevice().getId(), route.getDevice().getName(), route.getDevice().getType(), node.getPath(), route.getDevice().getIdeVersion(), null, false, null, route.getShowProductType(), 224, null));
            }
        });
        return newInstance$default;
    }

    private final Fragment createOfflineActivationFragment(DeviceFlowRoute.OfflineActivation route) {
        Fragment newInstance = DeviceActivateBottomSheet.INSTANCE.newInstance(route.getTarget());
        newInstance.setOnDismissListener(route.getOnClosed());
        return newInstance;
    }

    /* compiled from: DeviceFlowContainerBottomSheet.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ8\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0005J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "ARG_REQUEST_KEY", "newInstance", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;", "targetSelectRoute", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;", "availableTargets", "", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "existingDeviceIdsByProduct", "", "", "enterFrom", "offlineActivationRoute", "device", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "productType", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceFlowContainerBottomSheet newInstance(DeviceFlowRequest request) {
            Intrinsics.checkNotNullParameter(request, OauthTokenTriggerScene.REQUEST);
            DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet = new DeviceFlowContainerBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(DeviceFlowContainerBottomSheet.ARG_REQUEST_KEY, DeviceFlowStore.INSTANCE.put(request));
            deviceFlowContainerBottomSheet.setArguments(bundle);
            return deviceFlowContainerBottomSheet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DeviceFlowRoute targetSelectRoute$default(Companion companion, List list, Map map, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = DeviceAddTargetPolicy.availableTargets$default(DeviceAddTargetPolicy.INSTANCE, false, 1, null);
            }
            return companion.targetSelectRoute(list, map, str);
        }

        public final DeviceFlowRoute targetSelectRoute(List<? extends DeviceProductType> availableTargets, Map<DeviceProductType, ? extends Set<String>> existingDeviceIdsByProduct, String enterFrom) {
            Intrinsics.checkNotNullParameter(availableTargets, "availableTargets");
            Intrinsics.checkNotNullParameter(existingDeviceIdsByProduct, "existingDeviceIdsByProduct");
            Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
            if (availableTargets.size() == 1) {
                DeviceProductType deviceProductType = (DeviceProductType) CollectionsKt.single(availableTargets);
                Set<String> set = existingDeviceIdsByProduct.get(deviceProductType);
                if (set == null) {
                    set = SetsKt.emptySet();
                }
                return new DeviceFlowRoute.ConnectGuide(new BindingTarget(deviceProductType, set, enterFrom, null, null, null, 56, null));
            }
            return new DeviceFlowRoute.TargetSelect(availableTargets, existingDeviceIdsByProduct, enterFrom);
        }

        public final DeviceFlowRoute offlineActivationRoute(DeviceItem device, DeviceProductType productType) {
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(productType, "productType");
            return new DeviceFlowRoute.OfflineActivation(new OfflineDeviceTarget(device.getId(), device.getName(), productType, device.isPaired(), null, 16, null), null, 2, null);
        }
    }
}
