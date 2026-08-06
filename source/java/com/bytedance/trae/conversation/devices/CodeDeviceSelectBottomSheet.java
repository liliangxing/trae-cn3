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
import com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment;
import com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet;
import com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowConnectionSuccessRefreshTarget;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowDeviceClickPolicy;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowDeviceClickRoute;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowExistingDeviceIdsKt;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigatorKt;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute;
import com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet;
import com.bytedance.trae.conversation.ideproject.IDEProjectNameUtil;
import com.bytedance.trae.conversation.network.ProjectItem;
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
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeDeviceSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020#2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010*\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020\bH\u0002J\u0010\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\u000fH\u0002J\b\u00102\u001a\u000203H\u0002J$\u00104\u001a\u00020\b2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020,2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u00109\u001a\u00020\b2\u0006\u00101\u001a\u00020\u000f2\u0006\u00105\u001a\u000206H\u0002R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR.\u0010\r\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessRefreshTarget;", "<init>", "()V", "onDeviceSelected", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "", "getOnDeviceSelected", "()Lkotlin/jvm/functions/Function1;", "setOnDeviceSelected", "(Lkotlin/jvm/functions/Function1;)V", "onDeviceListChanged", "", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "getOnDeviceListChanged", "setOnDeviceListChanged", "viewModel", "Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;", "adapter", "Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;", "pickerShowEventGate", "Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;", "navigationClickGate", "Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onDestroyView", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDeviceConnectionSuccess", "selectedDeviceId", "", "tryAcceptNavigationClick", "", "showAddTargetSelector", "handleDeviceClickInFlow", "location", "currentChatMode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "openConnectGuide", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "enterFrom", "device", "openOfflineDevice", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CodeDeviceSelectBottomSheet extends BottomSheetDialogFragment implements DeviceFlowConnectionSuccessRefreshTarget {
    private static final String ARG_MODE = "arg_mode";
    private static final String ARG_PRESELECTED_DEVICE_ID = "arg_preselected_device_id";
    private static final long CLICK_DEBOUNCE_MILLIS = 500;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String STATE_PICKER_SHOW_REPORTED = "state_picker_show_reported";
    public static final String TAG = "CodeDeviceSelectBottomSheet";
    private CodeDeviceItemAdapter adapter;
    private final DeviceClickAcceptanceGate navigationClickGate = new DeviceClickAcceptanceGate(500);
    private Function1<? super List<DeviceItem>, Unit> onDeviceListChanged;
    private Function1<? super SelectedDeviceItem, Unit> onDeviceSelected;
    private DeviceEventGate pickerShowEventGate;
    private DeviceListViewModel viewModel;

    /* compiled from: CodeDeviceSelectBottomSheet.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CliType.values().length];
            try {
                iArr[CliType.IDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

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
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                CodeDeviceSelectBottomSheet.onCreateDialog$lambda$1(CodeDeviceSelectBottomSheet.this, i, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(CodeDeviceSelectBottomSheet codeDeviceSelectBottomSheet, int i, DialogInterface dialogInterface) {
        View findViewById;
        if (codeDeviceSelectBottomSheet.isAdded()) {
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
        return inflater.inflate(C0637R.layout.trae_dialog_code_device_select, container, false);
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
        deviceListViewModel3.ensureDevicesLoaded(requireContext, true);
        final View findViewById = view.findViewById(C0637R.id.progress_loading);
        final View findViewById2 = view.findViewById(C0637R.id.content_container);
        RecyclerView findViewById3 = view.findViewById(C0637R.id.rv_devices);
        TraeTitleBar traeTitleBar = (TraeTitleBar) view.findViewById(C0637R.id.title_bar);
        findViewById3.setLayoutManager(new LinearLayoutManager(getContext()));
        traeTitleBar.setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CodeDeviceSelectBottomSheet.onViewCreated$lambda$3(CodeDeviceSelectBottomSheet.this, view2);
            }
        });
        RecyclerView.Adapter codeDeviceItemAdapter = new CodeDeviceItemAdapter(new Function1() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$7;
                onViewCreated$lambda$7 = CodeDeviceSelectBottomSheet.onViewCreated$lambda$7(CodeDeviceSelectBottomSheet.this, (DeviceItem) obj);
                return onViewCreated$lambda$7;
            }
        }, new Function0() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda5
            public final Object invoke() {
                Unit onViewCreated$lambda$8;
                onViewCreated$lambda$8 = CodeDeviceSelectBottomSheet.onViewCreated$lambda$8(CodeDeviceSelectBottomSheet.this);
                return onViewCreated$lambda$8;
            }
        });
        this.adapter = codeDeviceItemAdapter;
        findViewById3.setAdapter(codeDeviceItemAdapter);
        DeviceListViewModel deviceListViewModel4 = this.viewModel;
        if (deviceListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            deviceListViewModel4 = null;
        }
        deviceListViewModel4.isLoading().observe(getViewLifecycleOwner(), new CodeDeviceSelectBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$9;
                onViewCreated$lambda$9 = CodeDeviceSelectBottomSheet.onViewCreated$lambda$9(findViewById, findViewById2, (Boolean) obj);
                return onViewCreated$lambda$9;
            }
        }));
        DeviceListViewModel deviceListViewModel5 = this.viewModel;
        if (deviceListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            deviceListViewModel = deviceListViewModel5;
        }
        deviceListViewModel.getLocations().observe(getViewLifecycleOwner(), new CodeDeviceSelectBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$14;
                onViewCreated$lambda$14 = CodeDeviceSelectBottomSheet.onViewCreated$lambda$14(CodeDeviceSelectBottomSheet.this, (List) obj);
                return onViewCreated$lambda$14;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(CodeDeviceSelectBottomSheet codeDeviceSelectBottomSheet, View view) {
        DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) codeDeviceSelectBottomSheet);
        if (deviceFlowNavigator != null) {
            deviceFlowNavigator.closeCurrentFlow();
        } else {
            codeDeviceSelectBottomSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7(final CodeDeviceSelectBottomSheet codeDeviceSelectBottomSheet, final DeviceItem deviceItem) {
        ChatMode chatMode;
        String string;
        DeviceProductType deviceProductType;
        Intrinsics.checkNotNullParameter(deviceItem, "location");
        if (!codeDeviceSelectBottomSheet.tryAcceptNavigationClick()) {
            return Unit.INSTANCE;
        }
        DeviceTracker.INSTANCE.trackDeviceSelectClick(deviceItem.getId(), deviceItem.getType(), deviceItem.isOnline(), deviceItem.isPaired());
        TraeLogUtil.INSTANCE.i(TAG, "offline_device_click: mode=code, item=" + DeviceItemKt.toDeviceLogSummary(deviceItem) + ", stateSaved=" + codeDeviceSelectBottomSheet.getChildFragmentManager().isStateSaved() + ", lifecycle=" + codeDeviceSelectBottomSheet.getLifecycle().getCurrentState());
        if (codeDeviceSelectBottomSheet.handleDeviceClickInFlow(deviceItem)) {
            return Unit.INSTANCE;
        }
        if (!deviceItem.isPaired()) {
            if (WhenMappings.$EnumSwitchMapping$0[deviceItem.getType().ordinal()] == 1) {
                deviceProductType = DeviceProductType.IDE;
            } else {
                deviceProductType = DeviceProductType.WORK;
            }
            codeDeviceSelectBottomSheet.openConnectGuide(deviceProductType, ConnectComputerGuideFragment.ENTER_FROM_CODE_ADD_DEVICE, deviceItem);
            return Unit.INSTANCE;
        }
        DeviceListViewModel deviceListViewModel = codeDeviceSelectBottomSheet.viewModel;
        CodeDeviceItemAdapter codeDeviceItemAdapter = null;
        if (deviceListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            deviceListViewModel = null;
        }
        DeviceListViewModel.selectLocation$default(deviceListViewModel, deviceItem.getId(), false, 2, null);
        if (deviceItem.getType() == CliType.REMOTE) {
            TraeLogUtil.INSTANCE.i(TAG, "offline_device_route: mode=code, route=remote_select, item=" + DeviceItemKt.toDeviceLogSummary(deviceItem));
            Function1<? super SelectedDeviceItem, Unit> function1 = codeDeviceSelectBottomSheet.onDeviceSelected;
            if (function1 != null) {
                String id = deviceItem.getId();
                String name = deviceItem.getName();
                CliType type = deviceItem.getType();
                String ideVersion = deviceItem.getIdeVersion();
                CodeDeviceItemAdapter codeDeviceItemAdapter2 = codeDeviceSelectBottomSheet.adapter;
                if (codeDeviceItemAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    codeDeviceItemAdapter = codeDeviceItemAdapter2;
                }
                function1.invoke(new SelectedDeviceItem(id, name, type, null, ideVersion, null, false, null, codeDeviceItemAdapter.getShowProductType(), 232, null));
            }
            codeDeviceSelectBottomSheet.dismiss();
        } else if (deviceItem.getType() == CliType.IDE) {
            if (deviceItem.isOnline()) {
                TraeLogUtil.INSTANCE.i(TAG, "offline_device_route: mode=code, route=ide_project, item=" + DeviceItemKt.toDeviceLogSummary(deviceItem));
                final IDEProjectBottomSheet newInstance$default = IDEProjectBottomSheet.Companion.newInstance$default(IDEProjectBottomSheet.INSTANCE, deviceItem.getId(), null, 2, null);
                newInstance$default.setProjectSelected(new IDEProjectBottomSheet.OnProjectSelectedListener() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet$onViewCreated$3$1$1
                    @Override // com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet.OnProjectSelectedListener
                    public void onProjectSelected(ProjectItem node) {
                        CodeDeviceItemAdapter codeDeviceItemAdapter3;
                        Intrinsics.checkNotNullParameter(node, "node");
                        Function1<SelectedDeviceItem, Unit> onDeviceSelected = CodeDeviceSelectBottomSheet.this.getOnDeviceSelected();
                        if (onDeviceSelected != null) {
                            String id2 = deviceItem.getId();
                            String name2 = deviceItem.getName();
                            CliType type2 = deviceItem.getType();
                            String ideVersion2 = deviceItem.getIdeVersion();
                            String folderPath = node.getFolderPath();
                            IDEProjectNameUtil iDEProjectNameUtil = IDEProjectNameUtil.INSTANCE;
                            Context requireContext = newInstance$default.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                            String projectName = iDEProjectNameUtil.getProjectName(requireContext, node.getFolderPath(), node.getWorkspaceType());
                            String projectId = node.getProjectId();
                            codeDeviceItemAdapter3 = CodeDeviceSelectBottomSheet.this.adapter;
                            if (codeDeviceItemAdapter3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                                codeDeviceItemAdapter3 = null;
                            }
                            onDeviceSelected.invoke(new SelectedDeviceItem(id2, name2, type2, folderPath, ideVersion2, projectId, false, projectName, codeDeviceItemAdapter3.getShowProductType(), 64, null));
                        }
                        CodeDeviceSelectBottomSheet.this.dismiss();
                    }
                });
                newInstance$default.show(codeDeviceSelectBottomSheet.getChildFragmentManager(), DirectoryBottomSheetFragment.TAG);
                return Unit.INSTANCE;
            }
            TraeLogUtil.INSTANCE.i(TAG, "offline_device_route: mode=code, route=offline_page, productType=IDE, item=" + DeviceItemKt.toDeviceLogSummary(deviceItem));
            codeDeviceSelectBottomSheet.openOfflineDevice(deviceItem, DeviceProductType.IDE);
        } else if (deviceItem.getType() == CliType.LOCAL) {
            if (deviceItem.isOnline()) {
                TraeLogUtil.INSTANCE.i(TAG, "offline_device_route: mode=code, route=local_directory, item=" + DeviceItemKt.toDeviceLogSummary(deviceItem));
                Bundle arguments = codeDeviceSelectBottomSheet.getArguments();
                if (arguments == null || (string = arguments.getString(ARG_MODE)) == null || (chatMode = ChatMode.valueOf(string)) == null) {
                    chatMode = ChatMode.CODE;
                }
                DirectoryBottomSheetFragment newInstance$default2 = DirectoryBottomSheetFragment.Companion.newInstance$default(DirectoryBottomSheetFragment.INSTANCE, deviceItem.getId(), chatMode, null, false, 12, null);
                newInstance$default2.setOnDirectorySelectedListener(new DirectoryBottomSheetFragment.OnDirectorySelectedListener() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet$onViewCreated$3$2$1
                    @Override // com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment.OnDirectorySelectedListener
                    public void onDirectorySelected(DirectoryNode node) {
                        CodeDeviceItemAdapter codeDeviceItemAdapter3;
                        Intrinsics.checkNotNullParameter(node, "node");
                        try {
                            DeviceTracker.INSTANCE.trackDeviceSelectPath(node.getDepth());
                        } catch (Throwable unused) {
                        }
                        Function1<SelectedDeviceItem, Unit> onDeviceSelected = CodeDeviceSelectBottomSheet.this.getOnDeviceSelected();
                        if (onDeviceSelected != null) {
                            String id2 = deviceItem.getId();
                            String name2 = deviceItem.getName();
                            CliType type2 = deviceItem.getType();
                            String path = node.getPath();
                            String ideVersion2 = deviceItem.getIdeVersion();
                            codeDeviceItemAdapter3 = CodeDeviceSelectBottomSheet.this.adapter;
                            if (codeDeviceItemAdapter3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                                codeDeviceItemAdapter3 = null;
                            }
                            onDeviceSelected.invoke(new SelectedDeviceItem(id2, name2, type2, path, ideVersion2, null, false, null, codeDeviceItemAdapter3.getShowProductType(), 224, null));
                        }
                        CodeDeviceSelectBottomSheet.this.dismiss();
                    }
                });
                newInstance$default2.show(codeDeviceSelectBottomSheet.getChildFragmentManager(), DirectoryBottomSheetFragment.TAG);
            } else {
                TraeLogUtil.INSTANCE.i(TAG, "offline_device_route: mode=code, route=offline_page, productType=WORK, item=" + DeviceItemKt.toDeviceLogSummary(deviceItem));
                codeDeviceSelectBottomSheet.openOfflineDevice(deviceItem, DeviceProductType.WORK);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8(CodeDeviceSelectBottomSheet codeDeviceSelectBottomSheet) {
        if (!codeDeviceSelectBottomSheet.tryAcceptNavigationClick()) {
            return Unit.INSTANCE;
        }
        DeviceTracker.INSTANCE.trackConnectEntryClick(ConnectComputerGuideFragment.ENTER_FROM_CODE_ADD_DEVICE, ChatMode.CODE);
        codeDeviceSelectBottomSheet.showAddTargetSelector();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$9(View view, View view2, Boolean bool) {
        view.setVisibility(bool.booleanValue() ? 0 : 8);
        view2.setVisibility(bool.booleanValue() ? 8 : 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$14(CodeDeviceSelectBottomSheet codeDeviceSelectBottomSheet, List list) {
        boolean z;
        boolean z2;
        Function1<? super List<DeviceItem>, Unit> function1;
        int i;
        int i2;
        DeviceEventGate deviceEventGate = codeDeviceSelectBottomSheet.pickerShowEventGate;
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
            boolean z3 = list2 instanceof Collection;
            if (z3 && list2.isEmpty()) {
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
            if (z3 && list2.isEmpty()) {
                i2 = 0;
            } else {
                Iterator it2 = list2.iterator();
                i2 = 0;
                while (it2.hasNext()) {
                    if ((((DeviceItem) it2.next()).getType() == CliType.IDE) && (i2 = i2 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            deviceTracker.trackDevicePickerShow(size, i, i2, ChatMode.CODE);
        }
        Intrinsics.checkNotNull(list);
        List list3 = list;
        boolean z4 = list3 instanceof Collection;
        if (!z4 || !list3.isEmpty()) {
            Iterator it3 = list3.iterator();
            while (it3.hasNext()) {
                if (((DeviceItem) it3.next()).getType() == CliType.LOCAL) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z4 || !list3.isEmpty()) {
            Iterator it4 = list3.iterator();
            while (it4.hasNext()) {
                if (((DeviceItem) it4.next()).getType() == CliType.IDE) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        boolean z5 = z && z2;
        CodeDeviceItemAdapter codeDeviceItemAdapter = codeDeviceSelectBottomSheet.adapter;
        if (codeDeviceItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            codeDeviceItemAdapter = null;
        }
        boolean z6 = codeDeviceItemAdapter.getShowProductType() != z5;
        CodeDeviceItemAdapter codeDeviceItemAdapter2 = codeDeviceSelectBottomSheet.adapter;
        if (codeDeviceItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            codeDeviceItemAdapter2 = null;
        }
        codeDeviceItemAdapter2.setShowProductType(z5);
        if (z6) {
            CodeDeviceItemAdapter codeDeviceItemAdapter3 = codeDeviceSelectBottomSheet.adapter;
            if (codeDeviceItemAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                codeDeviceItemAdapter3 = null;
            }
            if (codeDeviceItemAdapter3.getItemCount() > 0) {
                CodeDeviceItemAdapter codeDeviceItemAdapter4 = codeDeviceSelectBottomSheet.adapter;
                if (codeDeviceItemAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    codeDeviceItemAdapter4 = null;
                }
                CodeDeviceItemAdapter codeDeviceItemAdapter5 = codeDeviceSelectBottomSheet.adapter;
                if (codeDeviceItemAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    codeDeviceItemAdapter5 = null;
                }
                codeDeviceItemAdapter4.notifyItemRangeChanged(0, codeDeviceItemAdapter5.getItemCount());
            }
        }
        CodeDeviceItemAdapter codeDeviceItemAdapter6 = codeDeviceSelectBottomSheet.adapter;
        if (codeDeviceItemAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            codeDeviceItemAdapter6 = null;
        }
        codeDeviceItemAdapter6.submitList(list);
        DeviceListViewModel deviceListViewModel2 = codeDeviceSelectBottomSheet.viewModel;
        if (deviceListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            deviceListViewModel = deviceListViewModel2;
        }
        if (deviceListViewModel.shouldDispatchDeviceListChanged() && (function1 = codeDeviceSelectBottomSheet.onDeviceListChanged) != null) {
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
        deviceListViewModel.fetchDevices(context, true, selectedDeviceId);
    }

    private final boolean tryAcceptNavigationClick() {
        if (!isAdded() || getChildFragmentManager().isStateSaved() || getParentFragmentManager().isStateSaved() || !getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            return false;
        }
        return this.navigationClickGate.tryAcquire(SystemClock.elapsedRealtime());
    }

    private final void showAddTargetSelector() {
        DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) this);
        DeviceListViewModel deviceListViewModel = null;
        if (deviceFlowNavigator != null) {
            DeviceFlowContainerBottomSheet.Companion companion = DeviceFlowContainerBottomSheet.INSTANCE;
            List<? extends DeviceProductType> availableTargets$default = DeviceAddTargetPolicy.availableTargets$default(DeviceAddTargetPolicy.INSTANCE, false, 1, null);
            DeviceListViewModel deviceListViewModel2 = this.viewModel;
            if (deviceListViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                deviceListViewModel = deviceListViewModel2;
            }
            List list = (List) deviceListViewModel.getLocations().getValue();
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            deviceFlowNavigator.openNewFlow(companion.targetSelectRoute(availableTargets$default, DeviceFlowExistingDeviceIdsKt.deviceItemIdsByProduct(list), ConnectComputerGuideFragment.ENTER_FROM_CODE_ADD_DEVICE));
            return;
        }
        List<? extends DeviceProductType> availableTargets$default2 = DeviceAddTargetPolicy.availableTargets$default(DeviceAddTargetPolicy.INSTANCE, false, 1, null);
        if (availableTargets$default2.size() == 1) {
            openConnectGuide$default(this, (DeviceProductType) CollectionsKt.single(availableTargets$default2), ConnectComputerGuideFragment.ENTER_FROM_CODE_ADD_DEVICE, null, 4, null);
            return;
        }
        DeviceListViewModel deviceListViewModel3 = this.viewModel;
        if (deviceListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            deviceListViewModel = deviceListViewModel3;
        }
        List list2 = (List) deviceListViewModel.getLocations().getValue();
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        Map<DeviceProductType, Set<String>> deviceItemIdsByProduct = DeviceFlowExistingDeviceIdsKt.deviceItemIdsByProduct(list2);
        DeviceTargetSelectBottomSheet.Companion companion2 = DeviceTargetSelectBottomSheet.INSTANCE;
        Set<String> set = deviceItemIdsByProduct.get(DeviceProductType.WORK);
        if (set == null) {
            set = SetsKt.emptySet();
        }
        boolean z = !set.isEmpty();
        Set<String> set2 = deviceItemIdsByProduct.get(DeviceProductType.IDE);
        if (set2 == null) {
            set2 = SetsKt.emptySet();
        }
        DeviceTargetSelectBottomSheet newInstance = companion2.newInstance(availableTargets$default2, ConnectComputerGuideFragment.ENTER_FROM_CODE_ADD_DEVICE, z, !set2.isEmpty());
        newInstance.setOnTargetSelected(new Function1() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit showAddTargetSelector$lambda$17$lambda$16;
                showAddTargetSelector$lambda$17$lambda$16 = CodeDeviceSelectBottomSheet.showAddTargetSelector$lambda$17$lambda$16(CodeDeviceSelectBottomSheet.this, (DeviceProductType) obj);
                return showAddTargetSelector$lambda$17$lambda$16;
            }
        });
        newInstance.show(getChildFragmentManager(), DeviceTargetSelectBottomSheet.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAddTargetSelector$lambda$17$lambda$16(CodeDeviceSelectBottomSheet codeDeviceSelectBottomSheet, DeviceProductType deviceProductType) {
        Intrinsics.checkNotNullParameter(deviceProductType, "productType");
        openConnectGuide$default(codeDeviceSelectBottomSheet, deviceProductType, ConnectComputerGuideFragment.ENTER_FROM_CODE_ADD_DEVICE, null, 4, null);
        return Unit.INSTANCE;
    }

    private final boolean handleDeviceClickInFlow(DeviceItem location) {
        DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) this);
        if (deviceFlowNavigator == null) {
            return false;
        }
        DeviceFlowDeviceClickRoute resolve = DeviceFlowDeviceClickPolicy.INSTANCE.resolve(location);
        DeviceListViewModel deviceListViewModel = null;
        CodeDeviceItemAdapter codeDeviceItemAdapter = null;
        CodeDeviceItemAdapter codeDeviceItemAdapter2 = null;
        DeviceListViewModel deviceListViewModel2 = null;
        if (Intrinsics.areEqual(resolve, DeviceFlowDeviceClickRoute.SelectDeviceDirectly.INSTANCE)) {
            TraeLogUtil.INSTANCE.i(TAG, "offline_device_route: mode=code, route=remote_select, item=" + DeviceItemKt.toDeviceLogSummary(location));
            String id = location.getId();
            String name = location.getName();
            CliType type = location.getType();
            String ideVersion = location.getIdeVersion();
            CodeDeviceItemAdapter codeDeviceItemAdapter3 = this.adapter;
            if (codeDeviceItemAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                codeDeviceItemAdapter = codeDeviceItemAdapter3;
            }
            deviceFlowNavigator.notifyDeviceSelected(new SelectedDeviceItem(id, name, type, null, ideVersion, null, false, null, codeDeviceItemAdapter.getShowProductType(), 232, null));
            return true;
        }
        if (Intrinsics.areEqual(resolve, DeviceFlowDeviceClickRoute.ProjectSelect.INSTANCE)) {
            DeviceListViewModel deviceListViewModel3 = this.viewModel;
            if (deviceListViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                deviceListViewModel3 = null;
            }
            deviceListViewModel3.selectLocation(location.getId(), false);
            ChatMode currentChatMode = currentChatMode();
            CodeDeviceItemAdapter codeDeviceItemAdapter4 = this.adapter;
            if (codeDeviceItemAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                codeDeviceItemAdapter2 = codeDeviceItemAdapter4;
            }
            deviceFlowNavigator.navigate(new DeviceFlowRoute.ProjectSelect(location, currentChatMode, codeDeviceItemAdapter2.getShowProductType()));
            return true;
        }
        if (resolve instanceof DeviceFlowDeviceClickRoute.OfflineActivation) {
            DeviceListViewModel deviceListViewModel4 = this.viewModel;
            if (deviceListViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                deviceListViewModel2 = deviceListViewModel4;
            }
            deviceListViewModel2.selectLocation(location.getId(), false);
            DeviceFlowDeviceClickRoute.OfflineActivation offlineActivation = (DeviceFlowDeviceClickRoute.OfflineActivation) resolve;
            deviceFlowNavigator.navigate(new DeviceFlowRoute.OfflineActivation(new OfflineDeviceTarget(location.getId(), location.getName(), offlineActivation.getProductType(), offlineActivation.isPaired(), ConnectComputerGuideFragment.ENTER_FROM_CODE_ADD_DEVICE), new Function0() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit handleDeviceClickInFlow$lambda$19;
                    handleDeviceClickInFlow$lambda$19 = CodeDeviceSelectBottomSheet.handleDeviceClickInFlow$lambda$19(CodeDeviceSelectBottomSheet.this);
                    return handleDeviceClickInFlow$lambda$19;
                }
            }));
            return true;
        }
        if (!(resolve instanceof DeviceFlowDeviceClickRoute.BindingGuide)) {
            throw new NoWhenBranchMatchedException();
        }
        DeviceAddTargetPolicy deviceAddTargetPolicy = DeviceAddTargetPolicy.INSTANCE;
        DeviceProductType productType = ((DeviceFlowDeviceClickRoute.BindingGuide) resolve).getProductType();
        DeviceListViewModel deviceListViewModel5 = this.viewModel;
        if (deviceListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            deviceListViewModel = deviceListViewModel5;
        }
        List<DeviceItem> list = (List) deviceListViewModel.getLocations().getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        deviceFlowNavigator.navigate(new DeviceFlowRoute.ConnectGuide(BindingTarget.copy$default(deviceAddTargetPolicy.bindingTarget(productType, list, ConnectComputerGuideFragment.ENTER_FROM_CODE_ADD_DEVICE), null, null, null, DevicePairingTrigger.UNBOUND_DEVICE, location.getId(), location.getName(), 7, null)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleDeviceClickInFlow$lambda$19(CodeDeviceSelectBottomSheet codeDeviceSelectBottomSheet) {
        Context context = codeDeviceSelectBottomSheet.getContext();
        if (context != null) {
            DeviceListViewModel deviceListViewModel = codeDeviceSelectBottomSheet.viewModel;
            if (deviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                deviceListViewModel = null;
            }
            DeviceListViewModel.fetchDevices$default(deviceListViewModel, context, true, null, 4, null);
        }
        return Unit.INSTANCE;
    }

    private final ChatMode currentChatMode() {
        String string;
        ChatMode valueOf;
        Bundle arguments = getArguments();
        return (arguments == null || (string = arguments.getString(ARG_MODE)) == null || (valueOf = ChatMode.valueOf(string)) == null) ? ChatMode.CODE : valueOf;
    }

    static /* synthetic */ void openConnectGuide$default(CodeDeviceSelectBottomSheet codeDeviceSelectBottomSheet, DeviceProductType deviceProductType, String str, DeviceItem deviceItem, int i, Object obj) {
        if ((i & 4) != 0) {
            deviceItem = null;
        }
        codeDeviceSelectBottomSheet.openConnectGuide(deviceProductType, str, deviceItem);
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
        newInstance.setOnDismissListener(new Function0() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit openConnectGuide$lambda$22;
                openConnectGuide$lambda$22 = CodeDeviceSelectBottomSheet.openConnectGuide$lambda$22(CodeDeviceSelectBottomSheet.this);
                return openConnectGuide$lambda$22;
            }
        });
        newInstance.show(getChildFragmentManager(), "DeviceManagement");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openConnectGuide$lambda$22(CodeDeviceSelectBottomSheet codeDeviceSelectBottomSheet) {
        Context context = codeDeviceSelectBottomSheet.getContext();
        if (context != null) {
            DeviceListViewModel deviceListViewModel = codeDeviceSelectBottomSheet.viewModel;
            if (deviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                deviceListViewModel = null;
            }
            DeviceListViewModel.fetchDevices$default(deviceListViewModel, context, true, null, 4, null);
        }
        return Unit.INSTANCE;
    }

    private final void openOfflineDevice(final DeviceItem location, final DeviceProductType productType) {
        TraeLogUtil.INSTANCE.i(TAG, "offline_device_show_start: mode=code, productType=" + productType.name() + ", item=" + DeviceItemKt.toDeviceLogSummary(location) + ", stateSaved=" + getChildFragmentManager().isStateSaved() + ", isAdded=" + isAdded() + ", lifecycle=" + getLifecycle().getCurrentState());
        if (!isAdded() || getChildFragmentManager().isStateSaved() || !getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            TraeLogUtil.INSTANCE.w(TAG, "offline_device_show_skip: mode=code, productType=" + productType.name() + ", item=" + DeviceItemKt.toDeviceLogSummary(location) + ", stateSaved=" + getChildFragmentManager().isStateSaved() + ", isAdded=" + isAdded() + ", lifecycle=" + getLifecycle().getCurrentState());
            return;
        }
        DeviceActivateBottomSheet newInstance = DeviceActivateBottomSheet.INSTANCE.newInstance(new OfflineDeviceTarget(location.getId(), location.getName(), productType, location.isPaired(), ConnectComputerGuideFragment.ENTER_FROM_CODE_ADD_DEVICE));
        newInstance.setOnDismissListener(new Function0() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda9
            public final Object invoke() {
                Unit openOfflineDevice$lambda$24;
                openOfflineDevice$lambda$24 = CodeDeviceSelectBottomSheet.openOfflineDevice$lambda$24(CodeDeviceSelectBottomSheet.this);
                return openOfflineDevice$lambda$24;
            }
        });
        if (!location.isPaired()) {
            newInstance.setOnUnpairedDeviceOnline(new Function1() { // from class: com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    Unit openOfflineDevice$lambda$25;
                    openOfflineDevice$lambda$25 = CodeDeviceSelectBottomSheet.openOfflineDevice$lambda$25(CodeDeviceSelectBottomSheet.this, productType, location, (MobileDevice) obj);
                    return openOfflineDevice$lambda$25;
                }
            });
        }
        try {
            newInstance.show(getChildFragmentManager(), DeviceActivateBottomSheet.TAG);
            TraeLogUtil.INSTANCE.i(TAG, "offline_device_show_called: mode=code, productType=" + productType.name() + ", item=" + DeviceItemKt.toDeviceLogSummary(location));
        } catch (IllegalStateException e) {
            TraeLogUtil.INSTANCE.e(TAG, "offline_device_show_failed: mode=code, productType=" + productType.name() + ", item=" + DeviceItemKt.toDeviceLogSummary(location), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openOfflineDevice$lambda$24(CodeDeviceSelectBottomSheet codeDeviceSelectBottomSheet) {
        Context context = codeDeviceSelectBottomSheet.getContext();
        if (context != null) {
            DeviceListViewModel deviceListViewModel = codeDeviceSelectBottomSheet.viewModel;
            if (deviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                deviceListViewModel = null;
            }
            DeviceListViewModel.fetchDevices$default(deviceListViewModel, context, true, null, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openOfflineDevice$lambda$25(CodeDeviceSelectBottomSheet codeDeviceSelectBottomSheet, DeviceProductType deviceProductType, DeviceItem deviceItem, MobileDevice mobileDevice) {
        DeviceItem copy;
        Intrinsics.checkNotNullParameter(mobileDevice, "recovered");
        copy = deviceItem.copy((r20 & 1) != 0 ? deviceItem.id : mobileDevice.getId(), (r20 & 2) != 0 ? deviceItem.name : mobileDevice.getName(), (r20 & 4) != 0 ? deviceItem.model : null, (r20 & 8) != 0 ? deviceItem.iconResId : 0, (r20 & 16) != 0 ? deviceItem.isOnline : true, (r20 & 32) != 0 ? deviceItem.isSelected : false, (r20 & 64) != 0 ? deviceItem.type : null, (r20 & 128) != 0 ? deviceItem.ideVersion : null, (r20 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? deviceItem.isPaired : false);
        codeDeviceSelectBottomSheet.openConnectGuide(deviceProductType, ConnectComputerGuideFragment.ENTER_FROM_CODE_ADD_DEVICE, copy);
        return Unit.INSTANCE;
    }

    /* compiled from: CodeDeviceSelectBottomSheet.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "CLICK_DEBOUNCE_MILLIS", "", "ARG_MODE", "ARG_PRESELECTED_DEVICE_ID", "STATE_PICKER_SHOW_REPORTED", "newInstance", "Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;", "mode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "preselectedDeviceId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ CodeDeviceSelectBottomSheet newInstance$default(Companion companion, ChatMode chatMode, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.newInstance(chatMode, str);
        }

        public final CodeDeviceSelectBottomSheet newInstance(ChatMode mode, String preselectedDeviceId) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            CodeDeviceSelectBottomSheet codeDeviceSelectBottomSheet = new CodeDeviceSelectBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(CodeDeviceSelectBottomSheet.ARG_MODE, mode.name());
            if (preselectedDeviceId != null) {
                bundle.putString(CodeDeviceSelectBottomSheet.ARG_PRESELECTED_DEVICE_ID, preselectedDeviceId);
            }
            codeDeviceSelectBottomSheet.setArguments(bundle);
            return codeDeviceSelectBottomSheet;
        }
    }
}
