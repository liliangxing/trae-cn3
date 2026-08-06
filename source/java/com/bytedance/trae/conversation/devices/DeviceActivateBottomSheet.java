package com.bytedance.trae.conversation.devices;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigatorKt;
import com.bytedance.trae.conversation.tracker.DeviceTracker;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: DeviceActivateBottomSheet.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u001dH\u0002J\b\u0010%\u001a\u00020\u0006H\u0002J\b\u0010&\u001a\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\u0006H\u0002J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020\u0017H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onDismissListener", "Lkotlin/Function0;", "", "getOnDismissListener", "()Lkotlin/jvm/functions/Function0;", "setOnDismissListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnpairedDeviceOnline", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "getOnUnpairedDeviceOnline", "()Lkotlin/jvm/functions/Function1;", "setOnUnpairedDeviceOnline", "(Lkotlin/jvm/functions/Function1;)V", "repository", "Lcom/bytedance/trae/conversation/CliListRepository;", "pollingJob", "Lkotlinx/coroutines/Job;", "target", "Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "renderTarget", "trackPageView", "startPolling", "stopPolling", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "readTarget", "descriptionRes", "", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceActivateBottomSheet extends BottomSheetDialogFragment {
    private static final String ARG_DEVICE_ID = "arg_device_id";
    private static final String ARG_DEVICE_NAME = "arg_device_name";
    private static final String ARG_ENTER_FROM = "arg_enter_from";
    private static final String ARG_IS_PAIRED = "arg_is_paired";
    private static final String ARG_PRODUCT_TYPE = "arg_product_type";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final OfflineDeviceTarget DEFAULT_TARGET = new OfflineDeviceTarget("", "", DeviceProductType.WORK, false, null, 24, null);
    private static final long POLL_INTERVAL_MS = 5000;
    public static final String TAG = "DeviceActivateBottomSheet";
    private Function0<Unit> onDismissListener;
    private Function1<? super MobileDevice, Unit> onUnpairedDeviceOnline;
    private Job pollingJob;
    private final CliListRepository repository = CliListRepository.INSTANCE.getInstance();
    private OfflineDeviceTarget target = DEFAULT_TARGET;

    /* compiled from: DeviceActivateBottomSheet.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceProductType.values().length];
            try {
                iArr[DeviceProductType.WORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceProductType.IDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Function0<Unit> getOnDismissListener() {
        return this.onDismissListener;
    }

    public final void setOnDismissListener(Function0<Unit> function0) {
        this.onDismissListener = function0;
    }

    public final Function1<MobileDevice, Unit> getOnUnpairedDeviceOnline() {
        return this.onUnpairedDeviceOnline;
    }

    public final void setOnUnpairedDeviceOnline(Function1<? super MobileDevice, Unit> function1) {
        this.onUnpairedDeviceOnline = function1;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final Dialog dialog = (BottomSheetDialog) onCreateDialog;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DeviceActivateBottomSheet.onCreateDialog$lambda$1(dialog, this, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(BottomSheetDialog bottomSheetDialog, DeviceActivateBottomSheet deviceActivateBottomSheet, DialogInterface dialogInterface) {
        View findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        if (findViewById != null) {
            findViewById.setBackgroundResource(android.R.color.transparent);
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            int dimensionPixelSize = deviceActivateBottomSheet.getResources().getDimensionPixelSize(C0637R.dimen.trae_device_activate_sheet_height);
            from.setPeekHeight(dimensionPixelSize);
            from.setState(3);
            from.setSkipCollapsed(true);
            from.setHideable(true);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = dimensionPixelSize;
            findViewById.setLayoutParams(layoutParams);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.trae_bottom_sheet_device_activate, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.target = readTarget();
        TraeLogUtil.INSTANCE.i(TAG, "offline_device_page_render: target=" + DeviceItemKt.toDeviceLogSummary(this.target) + ", stateSaved=" + getChildFragmentManager().isStateSaved() + ", isAdded=" + isAdded() + ", lifecycle=" + getLifecycle().getCurrentState());
        renderTarget(view);
        trackPageView();
        ((TraeTitleBar) view.findViewById(C0637R.id.title_bar)).setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceActivateBottomSheet.onViewCreated$lambda$2(DeviceActivateBottomSheet.this, view2);
            }
        });
        if (!StringsKt.isBlank(this.target.getDeviceId())) {
            startPolling();
        } else {
            TraeLogUtil.INSTANCE.w(TAG, "offline_device_poll_skip: reason=empty_target");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(DeviceActivateBottomSheet deviceActivateBottomSheet, View view) {
        Function0<Unit> function0;
        DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) deviceActivateBottomSheet);
        if (deviceFlowNavigator != null) {
            if (!deviceFlowNavigator.onRouteBack() || (function0 = deviceActivateBottomSheet.onDismissListener) == null) {
                return;
            }
            function0.invoke();
            return;
        }
        deviceActivateBottomSheet.dismiss();
    }

    private final void renderTarget(View view) {
        ((TextView) view.findViewById(C0637R.id.tv_device_activate_title)).setText(C0637R.string.trae_device_activate_title);
        ((TextView) view.findViewById(C0637R.id.tv_device_activate_description)).setText(descriptionRes(this.target.getProductType()));
    }

    private final void trackPageView() {
        String str;
        int i = WhenMappings.$EnumSwitchMapping$0[this.target.getProductType().ordinal()];
        if (i == 1) {
            str = "pc";
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = "ide";
        }
        DeviceTracker.INSTANCE.trackOfflineDevicePageView(str);
    }

    private final void startPolling() {
        stopPolling();
        TraeLogUtil.INSTANCE.i(TAG, "offline_device_poll_start: target=" + DeviceItemKt.toDeviceLogSummary(this.target));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.pollingJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new DeviceActivateBottomSheet$startPolling$1(this, null), 3, (Object) null);
    }

    private final void stopPolling() {
        Job job = this.pollingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.pollingJob = null;
    }

    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        stopPolling();
        TraeLogUtil.INSTANCE.i(TAG, "offline_device_dismiss: target=" + DeviceItemKt.toDeviceLogSummary(this.target));
        Function0<Unit> function0 = this.onDismissListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        stopPolling();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0033, code lost:
    
        if (r1 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final OfflineDeviceTarget readTarget() {
        Object obj;
        DeviceProductType deviceProductType;
        Bundle arguments = getArguments();
        if (arguments == null) {
            return DEFAULT_TARGET;
        }
        String string = arguments.getString(ARG_PRODUCT_TYPE);
        if (string != null) {
            try {
                Result.Companion companion = Result.Companion;
                DeviceActivateBottomSheet deviceActivateBottomSheet = this;
                obj = Result.constructor-impl(DeviceProductType.valueOf(string));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            deviceProductType = (DeviceProductType) obj;
        }
        deviceProductType = DeviceProductType.WORK;
        DeviceProductType deviceProductType2 = deviceProductType;
        String string2 = arguments.getString(ARG_DEVICE_ID);
        String str = string2 == null ? "" : string2;
        String string3 = arguments.getString(ARG_DEVICE_NAME);
        String str2 = string3 == null ? "" : string3;
        boolean z = arguments.getBoolean(ARG_IS_PAIRED, true);
        String string4 = arguments.getString(ARG_ENTER_FROM);
        if (string4 == null) {
            string4 = ConnectComputerGuideFragment.ENTER_FROM_DEVICE_LIST;
        }
        return new OfflineDeviceTarget(str, str2, deviceProductType2, z, string4);
    }

    private final int descriptionRes(DeviceProductType productType) {
        int i = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (i == 1) {
            return C0637R.string.trae_device_activate_work_description;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return C0637R.string.trae_device_activate_ide_description;
    }

    /* compiled from: DeviceActivateBottomSheet.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "ARG_DEVICE_ID", "ARG_DEVICE_NAME", "ARG_PRODUCT_TYPE", "ARG_IS_PAIRED", "ARG_ENTER_FROM", "POLL_INTERVAL_MS", "", "DEFAULT_TARGET", "Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;", "newInstance", "Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;", "target", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceActivateBottomSheet newInstance() {
            return new DeviceActivateBottomSheet();
        }

        public final DeviceActivateBottomSheet newInstance(OfflineDeviceTarget target) {
            Intrinsics.checkNotNullParameter(target, "target");
            DeviceActivateBottomSheet deviceActivateBottomSheet = new DeviceActivateBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(DeviceActivateBottomSheet.ARG_DEVICE_ID, target.getDeviceId());
            bundle.putString(DeviceActivateBottomSheet.ARG_DEVICE_NAME, target.getDeviceName());
            bundle.putString(DeviceActivateBottomSheet.ARG_PRODUCT_TYPE, target.getProductType().name());
            bundle.putBoolean(DeviceActivateBottomSheet.ARG_IS_PAIRED, target.isPaired());
            bundle.putString(DeviceActivateBottomSheet.ARG_ENTER_FROM, target.getEnterFrom());
            deviceActivateBottomSheet.setArguments(bundle);
            return deviceActivateBottomSheet;
        }
    }
}
