package com.bytedance.trae.conversation.devices;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment;
import com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowConnectionSuccessRefreshTarget;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowDeviceClickPolicy;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowDeviceClickRoute;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowExistingDeviceIdsKt;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigatorKt;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute;
import com.bytedance.trae.conversation.tracker.DeviceClickAcceptanceGate;
import com.bytedance.trae.conversation.tracker.DeviceEventGate;
import com.bytedance.trae.conversation.tracker.DeviceTracker;
import com.bytedance.trae.conversation.widget.ChatMode;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020#2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010*\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u000fH\u0002J\b\u00101\u001a\u000202H\u0002J$\u00103\u001a\u00020\b2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020,2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u00108\u001a\u00020\b2\u0006\u00100\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0002R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR.\u0010\r\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessRefreshTarget;", "<init>", "()V", "onDeviceSelected", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "", "getOnDeviceSelected", "()Lkotlin/jvm/functions/Function1;", "setOnDeviceSelected", "(Lkotlin/jvm/functions/Function1;)V", "onDeviceListChanged", "", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "getOnDeviceListChanged", "setOnDeviceListChanged", "viewModel", "Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;", "adapter", "Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;", "pickerShowEventGate", "Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;", "navigationClickGate", "Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onDestroyView", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDeviceConnectionSuccess", "selectedDeviceId", "", "tryAcceptNavigationClick", "", "handleDeviceClickInFlow", "location", "currentChatMode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "openConnectGuide", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "enterFrom", "device", "openOfflineDevice", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceSelectBottomSheet extends BottomSheetDialogFragment implements DeviceFlowConnectionSuccessRefreshTarget {
    private static final String ARG_MODE = "arg_mode";
    private static final String ARG_PRESELECTED_DEVICE_ID = "arg_preselected_device_id";
    private static final long CLICK_DEBOUNCE_MILLIS = 500;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String STATE_PICKER_SHOW_REPORTED = "state_picker_show_reported";
    public static final String TAG = "TaskLocationBottomSheet";
    private DeviceItemAdapter adapter;
    private final DeviceClickAcceptanceGate navigationClickGate = new DeviceClickAcceptanceGate(500);
    private Function1<? super List<DeviceItem>, Unit> onDeviceListChanged;
    private Function1<? super SelectedDeviceItem, Unit> onDeviceSelected;
    private DeviceEventGate pickerShowEventGate;
    private DeviceListViewModel viewModel;

    public final Function1<SelectedDeviceItem, Unit> getOnDeviceSelected() {
        return this.onDeviceSelected;
    }

    public final void setOnDeviceSelected(Function1<? super SelectedDeviceItem, Unit> function1) {
        this.onDeviceSelected = function1;
    }

    public final Function1<List<DeviceItem>, Unit> getOnDeviceListChanged() {
        return this.onDeviceListChanged;
    }

    public final void setOnDeviceListChanged(Function1<? super List<DeviceItem>, Unit> function1) {
        this.onDeviceListChanged = function1;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean z = false;
        if (savedInstanceState != null && savedInstanceState.getBoolean(STATE_PICKER_SHOW_REPORTED)) {
            z = true;
        }
        this.pickerShowEventGate = new DeviceEventGate(z);
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        DeviceEventGate deviceEventGate = this.pickerShowEventGate;
        if (deviceEventGate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickerShowEventGate");
            deviceEventGate = null;
        }
        outState.putBoolean(STATE_PICKER_SHOW_REPORTED, deviceEventGate.getIsConsumed());
        super.onSaveInstanceState(outState);
    }

    public void onDestroyView() {
        super.onDestroyView();
        FragmentActivity activity = getActivity();
        boolean z = false;
        if (activity != null && activity.isChangingConfigurations()) {
            z = true;
        }
        if (!z) {
            DeviceEventGate deviceEventGate = this.pickerShowEventGate;
            if (deviceEventGate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickerShowEventGate");
                deviceEventGate = null;
            }
            deviceEventGate.reset();
        }
        this.navigationClickGate.release();
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        Dialog dialog = (BottomSheetDialog) onCreateDialog;
        final int i = (int) (StatusBarUtils.FLAG_NOTCH_PORTRAIT * getResources().getDisplayMetrics().density);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.devices.DeviceSelectBottomSheet$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DeviceSelectBottomSheet.onCreateDialog$lambda$1(DeviceSelectBottomSheet.this, i, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(DeviceSelectBottomSheet deviceSelectBottomSheet, int i, DialogInterface dialogInterface) {
        View findViewById;
        if (deviceSelectBottomSheet.isAdded()) {
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
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.trae_dialog_task_location, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.viewModel = (DeviceListViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceListViewModel.class);
        Bundle arguments = getArguments();
        DeviceListViewModel deviceListViewModel = null;
        if (arguments != null && (string = arguments.getString(ARG_PRESELECTED_DEVICE_ID)) != null) {
            DeviceListViewModel deviceListViewModel2 = this.viewModel;
            if (deviceListViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                deviceListViewModel2 = null;
            }
            deviceListViewModel2.setPreselectedDeviceId(string);
        }
        DeviceListViewModel deviceListViewModel3 = this.viewModel;
        if (deviceListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            deviceListViewModel3 = null;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        deviceListViewModel3.ensureDevicesLoaded(requireContext, false);
        final View findViewById = view.findViewById(C0637R.id.progress_loading);
        final View findViewById2 = view.findViewById(C0637R.id.content_container);
        RecyclerView findViewById3 = view.findViewById(C0637R.id.rv_devices);
        TraeTitleBar traeTitleBar = (TraeTitleBar) view.findViewById(C0637R.id.title_bar);
        View findViewById4 = view.findViewById(C0637R.id.btn_add_device);
        findViewById3.setLayoutManager(new LinearLayoutManager(getContext()));
        traeTitleBar.setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.DeviceSelectBottomSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceSelectBottomSheet.onViewCreated$lambda$3(DeviceSelectBottomSheet.this, view2);
            }
        });
        findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.DeviceSelectBottomSheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceSelectBottomSheet.onViewCreated$lambda$4(DeviceSelectBottomSheet.this, view2);
            }
        });
        DeviceItemAdapter deviceItemAdapter = new DeviceItemAdapter(new Function1() { // from class: com.bytedance.trae.conversation.devices.DeviceSelectBottomSheet$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$7;
                onViewCreated$lambda$7 = DeviceSelectBottomSheet.onViewCreated$lambda$7(DeviceSelectBottomSheet.this, (DeviceItem) obj);
                return onViewCreated$lambda$7;
            }
        });
        this.adapter = deviceItemAdapter;
        deviceItemAdapter.setShowProductType(CliListRepository.INSTANCE.getInstance().hasMultipleLocalCliTypes());
        DeviceItemAdapter deviceItemAdapter2 = this.adapter;
        if (deviceItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            deviceItemAdapter2 = null;
        }
        findViewById3.setAdapter((RecyclerView.Adapter) deviceItemAdapter2);
        DeviceListViewModel deviceListViewModel4 = this.viewModel;
        if (deviceListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            deviceListViewModel4 = null;
        }
        deviceListViewModel4.isLoading().observe(getViewLifecycleOwner(), new DeviceSelectBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.devices.DeviceSelectBottomSheet$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$8;
                onViewCreated$lambda$8 = DeviceSelectBottomSheet.onViewCreated$lambda$8(findViewById, findViewById2, (Boolean) obj);
                return onViewCreated$lambda$8;
            }
        }));
        DeviceListViewModel deviceListViewModel5 = this.viewModel;
        if (deviceListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            deviceListViewModel = deviceListViewModel5;
        }
        deviceListViewModel.getLocations().observe(getViewLifecycleOwner(), new DeviceSelectBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.devices.DeviceSelectBottomSheet$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$11;
                onViewCreated$lambda$11 = DeviceSelectBottomSheet.onViewCreated$lambda$11(DeviceSelectBottomSheet.this, (List) obj);
                return onViewCreated$lambda$11;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(DeviceSelectBottomSheet deviceSelectBottomSheet, View view) {
        DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) deviceSelectBottomSheet);
        if (deviceFlowNavigator != null) {
            deviceFlowNavigator.closeCurrentFlow();
        } else {
            deviceSelectBottomSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(DeviceSelectBottomSheet deviceSelectBottomSheet, View view) {
        if (deviceSelectBottomSheet.tryAcceptNavigationClick()) {
            DeviceTracker.INSTANCE.trackConnectEntryClick(ConnectComputerGuideFragment.ENTER_FROM_DEVICE_LIST, ChatMode.MTC);
            DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) deviceSelectBottomSheet);
            if (deviceFlowNavigator != null) {
                DeviceFlowContainerBottomSheet.Companion companion = DeviceFlowContainerBottomSheet.INSTANCE;
                List<? extends DeviceProductType> listOf = CollectionsKt.listOf(DeviceProductType.WORK);
                DeviceListViewModel deviceListViewModel = deviceSelectBottomSheet.viewModel;
                if (deviceListViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    deviceListViewModel = null;
                }
                List list = (List) deviceListViewModel.getLocations().getValue();
                if (list == null) {
                    list = CollectionsKt.emptyList();
                }
                deviceFlowNavigator.openNewFlow(companion.targetSelectRoute(listOf, DeviceFlowExistingDeviceIdsKt.deviceItemIdsByProduct(list), ConnectComputerGuideFragment.ENTER_FROM_DEVICE_LIST));
                return;
            }
            openConnectGuide$default(deviceSelectBottomSheet, DeviceProductType.WORK, ConnectComputerGuideFragment.ENTER_FROM_DEVICE_LIST, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7(final DeviceSelectBottomSheet deviceSelectBottomSheet, final DeviceItem deviceItem) {
        ChatMode chatMode;
        String string;
        Intrinsics.checkNotNullParameter(deviceItem, "location");
        if (!deviceSelectBottomSheet.tryAcceptNavigationClick()) {
            return Unit.INSTANCE;
        }
        DeviceTracker.INSTANCE.trackDeviceSelectClick(deviceItem.getId(), deviceItem.getType(), deviceItem.isOnline(), deviceItem.isPaired());
        TraeLogUtil.INSTANCE.i(TAG, "offline_device_click: mode=work, item=" + DeviceItemKt.toDeviceLogSummary(deviceItem) + ", stateSaved=" + deviceSelectBottomSheet.getChildFragmentManager().isStateSaved() + ", lifecycle=" + deviceSelectBottomSheet.getLifecycle().getCurrentState());
        if (deviceSelectBottomSheet.handleDeviceClickInFlow(deviceItem)) {
            return Unit.INSTANCE;
        }
        if (!deviceItem.isPaired()) {
            deviceSelectBottomSheet.openConnectGuide(DeviceProductType.WORK, ConnectComputerGuideFragment.ENTER_FROM_DEVICE_LIST, deviceItem);
            return Unit.INSTANCE;
        }
        DeviceListViewModel deviceListViewModel = deviceSelectBottomSheet.viewModel;
        if (deviceListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            deviceListViewModel = null;
        }
        DeviceListViewModel.selectLocation$default(deviceListViewModel, deviceItem.getId(), false, 2, null);
        if (deviceItem.getType() == CliType.REMOTE) {
            TraeLogUtil.INSTANCE.i(TAG, "offline_device_route: mode=work, route=remote_select, item=" + DeviceItemKt.toDeviceLogSummary(deviceItem));
            Function1<? super SelectedDeviceItem, Unit> function1 = deviceSelectBottomSheet.onDeviceSelected;
            if (function1 != null) {
                function1.invoke(new SelectedDeviceItem(deviceItem.getId(), deviceItem.getName(), deviceItem.getType(), null, deviceItem.getIdeVersion(), null, false, null, false, 488, null));
            }
            deviceSelectBottomSheet.dismiss();
        } else if (deviceItem.getType() == CliType.LOCAL) {
            if (deviceItem.isOnline()) {
                TraeLogUtil.INSTANCE.i(TAG, "offline_device_route: mode=work, route=local_directory, item=" + DeviceItemKt.toDeviceLogSummary(deviceItem));
                Bundle arguments = deviceSelectBottomSheet.getArguments();
                if (arguments == null || (string = arguments.getString(ARG_MODE)) == null || (chatMode = ChatMode.valueOf(string)) == null) {
                    chatMode = ChatMode.MTC;
                }
                DirectoryBottomSheetFragment newInstance$default = DirectoryBottomSheetFragment.Companion.newInstance$default(DirectoryBottomSheetFragment.INSTANCE, deviceItem.getId(), chatMode, null, false, 12, null);
                newInstance$default.setOnDirectorySelectedListener(new DirectoryBottomSheetFragment.OnDirectorySelectedListener() { // from class: com.bytedance.trae.conversation.devices.DeviceSelectBottomSheet$onViewCreated$4$1$1
                    @Override // com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment.OnDirectorySelectedListener
                    public void onDirectorySelected(DirectoryNode node) {
                        Intrinsics.checkNotNullParameter(node, "node");
                        try {
                            DeviceTracker.INSTANCE.trackDeviceSelectPath(node.getDepth());
                        } catch (Throwable unused) {
                        }
                        Function1<SelectedDeviceItem, Unit> onDeviceSelected = DeviceSelectBottomSheet.this.getOnDeviceSelected();
                        if (onDeviceSelected != null) {
                            onDeviceSelected.invoke(new SelectedDeviceItem(deviceItem.getId(), deviceItem.getName(), deviceItem.getType(), node.getPath(), deviceItem.getIdeVersion(), null, false, null, false, 480, null));
                        }
                        DeviceSelectBottomSheet.this.dismiss();
                    }
                });
                newInstance$default.show(deviceSelectBottomSheet.getChildFragmentManager(), DirectoryBottomSheetFragment.TAG);
            } else {
                TraeLogUtil.INSTANCE.i(TAG, "offline_device_route: mode=work, route=offline_page, item=" + DeviceItemKt.toDeviceLogSummary(deviceItem));
                deviceSelectBottomSheet.openOfflineDevice(deviceItem, DeviceProductType.WORK);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8(View view, View view2, Boolean bool) {
        view.setVisibility(bool.booleanValue() ? 0 : 8);
        view2.setVisibility(bool.booleanValue() ? 8 : 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$11(DeviceSelectBottomSheet deviceSelectBottomSheet, List list) {
        Function1<? super List<DeviceItem>, Unit> function1;
        int i;
        DeviceEventGate deviceEventGate = deviceSelectBottomSheet.pickerShowEventGate;
        DeviceListViewModel deviceListViewModel = null;
        if (deviceEventGate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickerShowEventGate");
            deviceEventGate = null;
        }
        if (deviceEventGate.tryConsume()) {
            DeviceTracker deviceTracker = DeviceTracker.INSTANCE;
            int size = list.size();
            Intrinsics.checkNotNull(list);
            List list2 = list;
            boolean z = list2 instanceof Collection;
            int i2 = 0;
            if (z && list2.isEmpty()) {
                i = 0;
            } else {
                Iterator it = list2.iterator();
                i = 0;
                while (it.hasNext()) {
                    if ((((DeviceItem) it.next()).getType() == CliType.LOCAL) && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            if (!z || !list2.isEmpty()) {
                Iterator it2 = list2.iterator();
                int i3 = 0;
                while (it2.hasNext()) {
                    if ((((DeviceItem) it2.next()).getType() == CliType.IDE) && (i3 = i3 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
                i2 = i3;
            }
            deviceTracker.trackDevicePickerShow(size, i, i2, ChatMode.MTC);
        }
        DeviceItemAdapter deviceItemAdapter = deviceSelectBottomSheet.adapter;
        if (deviceItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            deviceItemAdapter = null;
        }
        deviceItemAdapter.submitList(list);
        DeviceListViewModel deviceListViewModel2 = deviceSelectBottomSheet.viewModel;
        if (deviceListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            deviceListViewModel = deviceListViewModel2;
        }
        if (deviceListViewModel.shouldDispatchDeviceListChanged() && (function1 = deviceSelectBottomSheet.onDeviceListChanged) != null) {
            Intrinsics.checkNotNull(list);
            function1.invoke(list);
        }
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.conversation.devices.flow.DeviceFlowConnectionSuccessRefreshTarget
    public void onDeviceConnectionSuccess(String selectedDeviceId) {
        Context context;
        if (this.viewModel == null || (context = getContext()) == null) {
            return;
        }
        DeviceListViewModel deviceListViewModel = this.viewModel;
        if (deviceListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            deviceListViewModel = null;
        }
        deviceListViewModel.fetchDevices(context, false, selectedDeviceId);
    }

    private final boolean tryAcceptNavigationClick() {
        if (!isAdded() || getChildFragmentManager().isStateSaved() || getParentFragmentManager().isStateSaved() || !getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            return false;
        }
        return this.navigationClickGate.tryAcquire(SystemClock.elapsedRealtime());
    }

    private final boolean handleDeviceClickInFlow(DeviceItem location) {
        DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) this);
        if (deviceFlowNavigator == null) {
            return false;
        }
        DeviceFlowDeviceClickRoute resolve = DeviceFlowDeviceClickPolicy.INSTANCE.resolve(location);
        if (Intrinsics.areEqual(resolve, DeviceFlowDeviceClickRoute.SelectDeviceDirectly.INSTANCE)) {
            TraeLogUtil.INSTANCE.i(TAG, "offline_device_route: mode=work, route=remote_select, item=" + DeviceItemKt.toDeviceLogSummary(location));
            deviceFlowNavigator.notifyDeviceSelected(new SelectedDeviceItem(location.getId(), location.getName(), location.getType(), null, location.getIdeVersion(), null, false, null, false, 488, null));
            return true;
        }
        DeviceListViewModel deviceListViewModel = null;
        if (Intrinsics.areEqual(resolve, DeviceFlowDeviceClickRoute.ProjectSelect.INSTANCE)) {
            DeviceListViewModel deviceListViewModel2 = this.viewModel;
            if (deviceListViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                deviceListViewModel = deviceListViewModel2;
            }
            deviceListViewModel.selectLocation(location.getId(), false);
            deviceFlowNavigator.navigate(new DeviceFlowRoute.ProjectSelect(location, currentChatMode(), false));
            return true;
        }
        if (resolve instanceof DeviceFlowDeviceClickRoute.OfflineActivation) {
            DeviceListViewModel deviceListViewModel3 = this.viewModel;
            if (deviceListViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                deviceListViewModel = deviceListViewModel3;
            }
            deviceListViewModel.selectLocation(location.getId(), false);
            DeviceFlowDeviceClickRoute.OfflineActivation offlineActivation = (DeviceFlowDeviceClickRoute.OfflineActivation) resolve;
            deviceFlowNavigator.navigate(new DeviceFlowRoute.OfflineActivation(new OfflineDeviceTarget(location.getId(), location.getName(), offlineActivation.getProductType(), offlineActivation.isPaired(), ConnectComputerGuideFragment.ENTER_FROM_DEVICE_LIST), new Function0() { // from class: com.bytedance.trae.conversation.devices.DeviceSelectBottomSheet$$ExternalSyntheticLambda9
                public final Object invoke() {
                    Unit handleDeviceClickInFlow$lambda$14;
                    handleDeviceClickInFlow$lambda$14 = DeviceSelectBottomSheet.handleDeviceClickInFlow$lambda$14(DeviceSelectBottomSheet.this);
                    return handleDeviceClickInFlow$lambda$14;
                }
            }));
            return true;
        }
        if (!(resolve instanceof DeviceFlowDeviceClickRoute.BindingGuide)) {
            throw new NoWhenBranchMatchedException();
        }
        DeviceAddTargetPolicy deviceAddTargetPolicy = DeviceAddTargetPolicy.INSTANCE;
        DeviceProductType productType = ((DeviceFlowDeviceClickRoute.BindingGuide) resolve).getProductType();
        DeviceListViewModel deviceListViewModel4 = this.viewModel;
        if (deviceListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            deviceListViewModel = deviceListViewModel4;
        }
        List<DeviceItem> list = (List) deviceListViewModel.getLocations().getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        deviceFlowNavigator.navigate(new DeviceFlowRoute.ConnectGuide(BindingTarget.copy$default(deviceAddTargetPolicy.bindingTarget(productType, list, ConnectComputerGuideFragment.ENTER_FROM_DEVICE_LIST), null, null, null, DevicePairingTrigger.UNBOUND_DEVICE, location.getId(), location.getName(), 7, null)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleDeviceClickInFlow$lambda$14(DeviceSelectBottomSheet deviceSelectBottomSheet) {
        Context context = deviceSelectBottomSheet.getContext();
        if (context != null) {
            DeviceListViewModel deviceListViewModel = deviceSelectBottomSheet.viewModel;
            if (deviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                deviceListViewModel = null;
            }
            DeviceListViewModel.fetchDevices$default(deviceListViewModel, context, false, null, 4, null);
        }
        return Unit.INSTANCE;
    }

    private final ChatMode currentChatMode() {
        String string;
        ChatMode valueOf;
        Bundle arguments = getArguments();
        return (arguments == null || (string = arguments.getString(ARG_MODE)) == null || (valueOf = ChatMode.valueOf(string)) == null) ? ChatMode.MTC : valueOf;
    }

    static /* synthetic */ void openConnectGuide$default(DeviceSelectBottomSheet deviceSelectBottomSheet, DeviceProductType deviceProductType, String str, DeviceItem deviceItem, int i, Object obj) {
        if ((i & 4) != 0) {
            deviceItem = null;
        }
        deviceSelectBottomSheet.openConnectGuide(deviceProductType, str, deviceItem);
    }

    private final void openConnectGuide(DeviceProductType productType, String enterFrom, DeviceItem device) {
        DevicePairingTrigger devicePairingTrigger;
        DeviceAddTargetPolicy deviceAddTargetPolicy = DeviceAddTargetPolicy.INSTANCE;
        DeviceListViewModel deviceListViewModel = this.viewModel;
        if (deviceListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            deviceListViewModel = null;
        }
        List<DeviceItem> list = (List) deviceListViewModel.getLocations().getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        BindingTarget bindingTarget = deviceAddTargetPolicy.bindingTarget(productType, list, enterFrom);
        ConnectComputerGuideFragment.Companion companion = ConnectComputerGuideFragment.INSTANCE;
        if (device == null) {
            devicePairingTrigger = DevicePairingTrigger.CONNECT_BUTTON;
        } else {
            devicePairingTrigger = DevicePairingTrigger.UNBOUND_DEVICE;
        }
        ConnectComputerGuideFragment newInstance = companion.newInstance(BindingTarget.copy$default(bindingTarget, null, null, null, devicePairingTrigger, device != null ? device.getId() : null, device != null ? device.getName() : null, 7, null));
        newInstance.setOnDismissListener(new Function0() { // from class: com.bytedance.trae.conversation.devices.DeviceSelectBottomSheet$$ExternalSyntheticLambda8
            public final Object invoke() {
                Unit openConnectGuide$lambda$17;
                openConnectGuide$lambda$17 = DeviceSelectBottomSheet.openConnectGuide$lambda$17(DeviceSelectBottomSheet.this);
                return openConnectGuide$lambda$17;
            }
        });
        newInstance.show(getChildFragmentManager(), "DeviceManagement");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openConnectGuide$lambda$17(DeviceSelectBottomSheet deviceSelectBottomSheet) {
        Context context = deviceSelectBottomSheet.getContext();
        if (context != null) {
            DeviceListViewModel deviceListViewModel = deviceSelectBottomSheet.viewModel;
            if (deviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                deviceListViewModel = null;
            }
            DeviceListViewModel.fetchDevices$default(deviceListViewModel, context, false, null, 4, null);
        }
        return Unit.INSTANCE;
    }

    private final void openOfflineDevice(final DeviceItem location, final DeviceProductType productType) {
        TraeLogUtil.INSTANCE.i(TAG, "offline_device_show_start: mode=work, productType=" + productType.name() + ", item=" + DeviceItemKt.toDeviceLogSummary(location) + ", stateSaved=" + getChildFragmentManager().isStateSaved() + ", isAdded=" + isAdded() + ", lifecycle=" + getLifecycle().getCurrentState());
        if (!isAdded() || getChildFragmentManager().isStateSaved() || !getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            TraeLogUtil.INSTANCE.w(TAG, "offline_device_show_skip: mode=work, productType=" + productType.name() + ", item=" + DeviceItemKt.toDeviceLogSummary(location) + ", stateSaved=" + getChildFragmentManager().isStateSaved() + ", isAdded=" + isAdded() + ", lifecycle=" + getLifecycle().getCurrentState());
            return;
        }
        DeviceActivateBottomSheet newInstance = DeviceActivateBottomSheet.INSTANCE.newInstance(new OfflineDeviceTarget(location.getId(), location.getName(), productType, location.isPaired(), ConnectComputerGuideFragment.ENTER_FROM_DEVICE_LIST));
        newInstance.setOnDismissListener(new Function0() { // from class: com.bytedance.trae.conversation.devices.DeviceSelectBottomSheet$$ExternalSyntheticLambda6
            public final Object invoke() {
                Unit openOfflineDevice$lambda$19;
                openOfflineDevice$lambda$19 = DeviceSelectBottomSheet.openOfflineDevice$lambda$19(DeviceSelectBottomSheet.this);
                return openOfflineDevice$lambda$19;
            }
        });
        if (!location.isPaired()) {
            newInstance.setOnUnpairedDeviceOnline(new Function1() { // from class: com.bytedance.trae.conversation.devices.DeviceSelectBottomSheet$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    Unit openOfflineDevice$lambda$20;
                    openOfflineDevice$lambda$20 = DeviceSelectBottomSheet.openOfflineDevice$lambda$20(DeviceSelectBottomSheet.this, productType, location, (MobileDevice) obj);
                    return openOfflineDevice$lambda$20;
                }
            });
        }
        try {
            newInstance.show(getChildFragmentManager(), DeviceActivateBottomSheet.TAG);
            TraeLogUtil.INSTANCE.i(TAG, "offline_device_show_called: mode=work, productType=" + productType.name() + ", item=" + DeviceItemKt.toDeviceLogSummary(location));
        } catch (IllegalStateException e) {
            TraeLogUtil.INSTANCE.e(TAG, "offline_device_show_failed: mode=work, productType=" + productType.name() + ", item=" + DeviceItemKt.toDeviceLogSummary(location), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openOfflineDevice$lambda$19(DeviceSelectBottomSheet deviceSelectBottomSheet) {
        Context context = deviceSelectBottomSheet.getContext();
        if (context != null) {
            DeviceListViewModel deviceListViewModel = deviceSelectBottomSheet.viewModel;
            if (deviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                deviceListViewModel = null;
            }
            DeviceListViewModel.fetchDevices$default(deviceListViewModel, context, false, null, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openOfflineDevice$lambda$20(DeviceSelectBottomSheet deviceSelectBottomSheet, DeviceProductType deviceProductType, DeviceItem deviceItem, MobileDevice mobileDevice) {
        DeviceItem copy;
        Intrinsics.checkNotNullParameter(mobileDevice, "recovered");
        copy = deviceItem.copy((r20 & 1) != 0 ? deviceItem.id : mobileDevice.getId(), (r20 & 2) != 0 ? deviceItem.name : mobileDevice.getName(), (r20 & 4) != 0 ? deviceItem.model : null, (r20 & 8) != 0 ? deviceItem.iconResId : 0, (r20 & 16) != 0 ? deviceItem.isOnline : true, (r20 & 32) != 0 ? deviceItem.isSelected : false, (r20 & 64) != 0 ? deviceItem.type : null, (r20 & 128) != 0 ? deviceItem.ideVersion : null, (r20 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? deviceItem.isPaired : false);
        deviceSelectBottomSheet.openConnectGuide(deviceProductType, ConnectComputerGuideFragment.ENTER_FROM_DEVICE_LIST, copy);
        return Unit.INSTANCE;
    }

    /* compiled from: DeviceSelectBottomSheet.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "CLICK_DEBOUNCE_MILLIS", "", "ARG_MODE", "ARG_PRESELECTED_DEVICE_ID", "STATE_PICKER_SHOW_REPORTED", "newInstance", "Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet;", "mode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "preselectedDeviceId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeviceSelectBottomSheet newInstance$default(Companion companion, ChatMode chatMode, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.newInstance(chatMode, str);
        }

        public final DeviceSelectBottomSheet newInstance(ChatMode mode, String preselectedDeviceId) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            DeviceSelectBottomSheet deviceSelectBottomSheet = new DeviceSelectBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(DeviceSelectBottomSheet.ARG_MODE, mode.name());
            if (preselectedDeviceId != null) {
                bundle.putString(DeviceSelectBottomSheet.ARG_PRESELECTED_DEVICE_ID, preselectedDeviceId);
            }
            deviceSelectBottomSheet.setArguments(bundle);
            return deviceSelectBottomSheet;
        }
    }
}
