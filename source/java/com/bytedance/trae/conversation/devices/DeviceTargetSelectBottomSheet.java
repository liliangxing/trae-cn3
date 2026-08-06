package com.bytedance.trae.conversation.devices;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigatorKt;
import com.bytedance.trae.conversation.tracker.DeviceEventGate;
import com.bytedance.trae.conversation.tracker.DeviceTracker;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceTargetSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J@\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 2\b\b\u0001\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J2\u0010&\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0011H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060*H\u0002J\b\u0010+\u001a\u00020$H\u0002R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onTargetSelected", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "", "getOnTargetSelected", "()Lkotlin/jvm/functions/Function1;", "setOnTargetSelected", "(Lkotlin/jvm/functions/Function1;)V", "pageExposureGate", "Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;", "targetClickGate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "bindOrHideTargetItem", "itemView", "productType", "availableTargets", "", "iconRes", "", "title", "", "subtitle", "bindTargetItem", "onSaveInstanceState", "outState", "onDestroyView", "", "trackingEnterFrom", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceTargetSelectBottomSheet extends BottomSheetDialogFragment {
    private static final String ARG_AVAILABLE_TARGETS = "arg_available_targets";
    private static final String ARG_ENTER_FROM = "arg_enter_from";
    private static final String ARG_HAS_IDE_DEVICE = "arg_has_ide_device";
    private static final String ARG_HAS_WORK_DEVICE = "arg_has_work_device";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String STATE_PAGE_EXPOSURE_REPORTED = "state_page_exposure_reported";
    private static final String STATE_TARGET_CLICK_REPORTED = "state_target_click_reported";
    public static final String TAG = "DeviceTargetSelectBottomSheet";
    private Function1<? super DeviceProductType, Unit> onTargetSelected;
    private DeviceEventGate pageExposureGate = new DeviceEventGate(false, 1, null);
    private DeviceEventGate targetClickGate = new DeviceEventGate(false, 1, null);

    public final Function1<DeviceProductType, Unit> getOnTargetSelected() {
        return this.onTargetSelected;
    }

    public final void setOnTargetSelected(Function1<? super DeviceProductType, Unit> function1) {
        this.onTargetSelected = function1;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.pageExposureGate = new DeviceEventGate(savedInstanceState != null && savedInstanceState.getBoolean(STATE_PAGE_EXPOSURE_REPORTED));
        this.targetClickGate = new DeviceEventGate(savedInstanceState != null && savedInstanceState.getBoolean(STATE_TARGET_CLICK_REPORTED));
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        Dialog dialog = (BottomSheetDialog) onCreateDialog;
        final int dimensionPixelSize = getResources().getDimensionPixelSize(C0637R.dimen.trae_device_target_select_sheet_height);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DeviceTargetSelectBottomSheet.onCreateDialog$lambda$2(dimensionPixelSize, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$2(int i, DialogInterface dialogInterface) {
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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(C0637R.layout.bottom_sheet_device_target_select, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Set<? extends DeviceProductType> set = CollectionsKt.toSet(availableTargets());
        TraeTitleBar traeTitleBar = (TraeTitleBar) view.findViewById(C0637R.id.title_bar);
        traeTitleBar.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceTargetSelectBottomSheet.onViewCreated$lambda$5$lambda$3(DeviceTargetSelectBottomSheet.this, view2);
            }
        });
        traeTitleBar.setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceTargetSelectBottomSheet.onViewCreated$lambda$5$lambda$4(DeviceTargetSelectBottomSheet.this, view2);
            }
        });
        View findViewById = view.findViewById(C0637R.id.item_work);
        View findViewById2 = view.findViewById(C0637R.id.item_ide);
        Intrinsics.checkNotNull(findViewById);
        DeviceProductType deviceProductType = DeviceProductType.WORK;
        int i = C0637R.drawable.trae_device_target_work_icon;
        String string = getString(C0637R.string.trae_device_add_target_work);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(C0637R.string.trae_device_target_select_work_subtitle);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        bindOrHideTargetItem(findViewById, deviceProductType, set, i, string, string2);
        Intrinsics.checkNotNull(findViewById2);
        DeviceProductType deviceProductType2 = DeviceProductType.IDE;
        int i2 = C0637R.drawable.trae_device_target_ide_icon;
        String string3 = getString(C0637R.string.trae_device_add_target_ide);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(C0637R.string.trae_device_target_select_ide_subtitle);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        bindOrHideTargetItem(findViewById2, deviceProductType2, set, i2, string3, string4);
        if (this.pageExposureGate.tryConsume()) {
            DeviceTracker deviceTracker = DeviceTracker.INSTANCE;
            String trackingEnterFrom = trackingEnterFrom();
            int size = set.size();
            Bundle arguments = getArguments();
            boolean z = arguments != null && arguments.getBoolean(ARG_HAS_WORK_DEVICE);
            Bundle arguments2 = getArguments();
            deviceTracker.trackTargetSelectShow(trackingEnterFrom, size, z, arguments2 != null && arguments2.getBoolean(ARG_HAS_IDE_DEVICE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$3(DeviceTargetSelectBottomSheet deviceTargetSelectBottomSheet, View view) {
        DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) deviceTargetSelectBottomSheet);
        if (deviceFlowNavigator != null) {
            deviceFlowNavigator.onRouteBack();
        } else {
            deviceTargetSelectBottomSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$4(DeviceTargetSelectBottomSheet deviceTargetSelectBottomSheet, View view) {
        DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) deviceTargetSelectBottomSheet);
        if (deviceFlowNavigator != null) {
            deviceFlowNavigator.closeCurrentFlow();
        } else {
            deviceTargetSelectBottomSheet.dismiss();
        }
    }

    private final void bindOrHideTargetItem(View itemView, DeviceProductType productType, Set<? extends DeviceProductType> availableTargets, int iconRes, String title, String subtitle) {
        if (!availableTargets.contains(productType)) {
            itemView.setVisibility(8);
            itemView.setOnClickListener(null);
        } else {
            itemView.setVisibility(0);
            bindTargetItem(itemView, productType, iconRes, title, subtitle);
        }
    }

    private final void bindTargetItem(View itemView, final DeviceProductType productType, int iconRes, String title, String subtitle) {
        ((ImageView) itemView.findViewById(C0637R.id.iv_target_icon)).setImageResource(iconRes);
        ((TextView) itemView.findViewById(C0637R.id.tv_target_title)).setText(title);
        ((TextView) itemView.findViewById(C0637R.id.tv_target_subtitle)).setText(subtitle);
        itemView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeviceTargetSelectBottomSheet.bindTargetItem$lambda$6(DeviceTargetSelectBottomSheet.this, productType, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindTargetItem$lambda$6(DeviceTargetSelectBottomSheet deviceTargetSelectBottomSheet, DeviceProductType deviceProductType, View view) {
        if (deviceTargetSelectBottomSheet.targetClickGate.tryConsume()) {
            DeviceTracker.INSTANCE.trackTargetSelectClick(deviceTargetSelectBottomSheet.trackingEnterFrom(), deviceProductType);
            DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) deviceTargetSelectBottomSheet);
            Function1<? super DeviceProductType, Unit> function1 = deviceTargetSelectBottomSheet.onTargetSelected;
            if (function1 != null) {
                function1.invoke(deviceProductType);
            }
            if (deviceFlowNavigator == null) {
                deviceTargetSelectBottomSheet.dismiss();
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putBoolean(STATE_PAGE_EXPOSURE_REPORTED, this.pageExposureGate.getIsConsumed());
        outState.putBoolean(STATE_TARGET_CLICK_REPORTED, this.targetClickGate.getIsConsumed());
        super.onSaveInstanceState(outState);
    }

    public void onDestroyView() {
        super.onDestroyView();
        FragmentActivity activity = getActivity();
        boolean z = false;
        if (activity != null && activity.isChangingConfigurations()) {
            z = true;
        }
        if (z) {
            return;
        }
        this.pageExposureGate.reset();
        this.targetClickGate.reset();
    }

    private final List<DeviceProductType> availableTargets() {
        DeviceProductType deviceProductType;
        Bundle arguments = getArguments();
        ArrayList<String> stringArrayList = arguments != null ? arguments.getStringArrayList(ARG_AVAILABLE_TARGETS) : null;
        ArrayList<String> arrayList = stringArrayList;
        if (arrayList == null || arrayList.isEmpty()) {
            return DeviceAddTargetPolicy.availableTargets$default(DeviceAddTargetPolicy.INSTANCE, false, 1, null);
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : stringArrayList) {
            DeviceProductType[] values = DeviceProductType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    deviceProductType = null;
                    break;
                }
                deviceProductType = values[i];
                if (Intrinsics.areEqual(deviceProductType.name(), str)) {
                    break;
                }
                i++;
            }
            if (deviceProductType != null) {
                arrayList2.add(deviceProductType);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            arrayList3 = DeviceAddTargetPolicy.availableTargets$default(DeviceAddTargetPolicy.INSTANCE, false, 1, null);
        }
        return arrayList3;
    }

    private final String trackingEnterFrom() {
        String string;
        Bundle arguments = getArguments();
        return (arguments == null || (string = arguments.getString(ARG_ENTER_FROM)) == null) ? ConnectComputerGuideFragment.ENTER_FROM_DEVICE_LIST : string;
    }

    /* compiled from: DeviceTargetSelectBottomSheet.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "ARG_AVAILABLE_TARGETS", "ARG_ENTER_FROM", "ARG_HAS_WORK_DEVICE", "ARG_HAS_IDE_DEVICE", "STATE_PAGE_EXPOSURE_REPORTED", "STATE_TARGET_CLICK_REPORTED", "newInstance", "Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;", "availableTargets", "", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "enterFrom", "hasWorkDevice", "", "hasIdeDevice", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DeviceTargetSelectBottomSheet newInstance$default(Companion companion, List list, String str, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = DeviceAddTargetPolicy.availableTargets$default(DeviceAddTargetPolicy.INSTANCE, false, 1, null);
            }
            if ((i & 2) != 0) {
                str = ConnectComputerGuideFragment.ENTER_FROM_DEVICE_LIST;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                z2 = false;
            }
            return companion.newInstance(list, str, z, z2);
        }

        public final DeviceTargetSelectBottomSheet newInstance(List<? extends DeviceProductType> availableTargets, String enterFrom, boolean hasWorkDevice, boolean hasIdeDevice) {
            Intrinsics.checkNotNullParameter(availableTargets, "availableTargets");
            Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
            DeviceTargetSelectBottomSheet deviceTargetSelectBottomSheet = new DeviceTargetSelectBottomSheet();
            Bundle bundle = new Bundle();
            List<? extends DeviceProductType> list = availableTargets;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((DeviceProductType) it.next()).name());
            }
            bundle.putStringArrayList(DeviceTargetSelectBottomSheet.ARG_AVAILABLE_TARGETS, new ArrayList<>(arrayList));
            bundle.putString(DeviceTargetSelectBottomSheet.ARG_ENTER_FROM, enterFrom);
            bundle.putBoolean(DeviceTargetSelectBottomSheet.ARG_HAS_WORK_DEVICE, hasWorkDevice);
            bundle.putBoolean(DeviceTargetSelectBottomSheet.ARG_HAS_IDE_DEVICE, hasIdeDevice);
            deviceTargetSelectBottomSheet.setArguments(bundle);
            return deviceTargetSelectBottomSheet;
        }
    }
}
