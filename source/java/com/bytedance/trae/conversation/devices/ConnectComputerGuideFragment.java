package com.bytedance.trae.conversation.devices;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.databinding.FragmentConnectComputerGuideBinding;
import com.bytedance.trae.conversation.devices.BindingGuideStableState;
import com.bytedance.trae.conversation.devices.ConnectComputerGuideViewModel;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigatorKt;
import com.bytedance.trae.conversation.share.ShareUtils;
import com.bytedance.trae.conversation.tracker.DeviceEventGate;
import com.bytedance.trae.conversation.tracker.DevicePairingEventTracker;
import com.bytedance.trae.conversation.tracker.DevicePairingFunnelEventTracker;
import com.bytedance.trae.conversation.tracker.DevicePairingTerminalResult;
import com.bytedance.trae.conversation.tracker.DeviceTracker;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: ConnectComputerGuideFragment.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 U2\u00020\u0001:\u0001UB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J$\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u0002022\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00109\u001a\u00020\u0006H\u0002J\u0012\u0010:\u001a\u00020\u00062\b\b\u0001\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020\u0006H\u0002J\u0010\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020\u00062\u0006\u0010B\u001a\u00020,H\u0002J\u001a\u0010C\u001a\u00020\u00062\u0006\u0010B\u001a\u00020,2\b\b\u0001\u0010;\u001a\u00020<H\u0002J\b\u0010D\u001a\u00020\u0006H\u0002J\b\u0010E\u001a\u00020\u0006H\u0002J\b\u0010F\u001a\u00020\u0006H\u0002J\u0010\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020\u0006H\u0016J\u0010\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u000200H\u0016J\b\u0010M\u001a\u00020\u0006H\u0016J\b\u0010N\u001a\u00020\u0006H\u0002J\b\u0010O\u001a\u00020 H\u0002J\b\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020SH\u0002R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onDismissListener", "Lkotlin/Function0;", "", "getOnDismissListener", "()Lkotlin/jvm/functions/Function0;", "setOnDismissListener", "(Lkotlin/jvm/functions/Function0;)V", "onConnectionSuccessListener", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "getOnConnectionSuccessListener", "()Lkotlin/jvm/functions/Function1;", "setOnConnectionSuccessListener", "(Lkotlin/jvm/functions/Function1;)V", "targetProductType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "getTargetProductType", "()Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "_binding", "Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;", "binding", "getBinding", "()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;", "viewModel", "Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;", "successJob", "Lkotlinx/coroutines/Job;", "bindingTarget", "Lcom/bytedance/trae/conversation/devices/BindingTarget;", "pairingStartedAtMillis", "", "pageExposureGate", "Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;", "pairingEventTracker", "Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;", "pairingFunnelEventTracker", "Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;", "statusSpinnerAnimator", "Landroid/animation/ObjectAnimator;", "statusSpinnerView", "Landroid/widget/ImageView;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "renderBindingTarget", "loadHeroGif", "resId", "", "observeBindingState", "renderBindingState", "state", "Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;", "showWaitingStatus", "imageView", "showStaticStatus", "stopStatusSpinner", "scheduleSuccessCompletion", "completeConnectionSuccess", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onStop", "onSaveInstanceState", "outState", "onDestroyView", "reportPairingExitIfNeeded", "readBindingTarget", "isEmbeddedPresentation", "", "downloadUrl", "", "displayUrl", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConnectComputerGuideFragment extends BottomSheetDialogFragment {
    private static final String ARG_DEVICE_ID = "arg_device_id";
    private static final String ARG_DEVICE_NAME = "arg_device_name";
    private static final String ARG_EMBEDDED_PRESENTATION = "arg_embedded_presentation";
    private static final String ARG_ENTER_FROM = "arg_enter_from";
    private static final String ARG_EXISTING_DEVICE_IDS = "arg_existing_device_ids";
    private static final String ARG_ONLINE_DEVICE_IDS = "arg_online_device_ids";
    private static final String ARG_PRODUCT_TYPE = "arg_product_type";
    private static final String ARG_TRIGGER_BY = "arg_trigger_by";
    public static final String ENTER_FROM_CODE_ADD_DEVICE = "code_add_device";
    public static final String ENTER_FROM_DEVICE_ACTIVATE = "device_activate";
    public static final String ENTER_FROM_DEVICE_LIST = "device_list";
    public static final String ENTER_FROM_NEW_FEATURE_POPUP = "new_feature_popup";
    public static final String ENTER_FROM_SETTINGS_DEVICE_MANAGEMENT = "settings_device_management";
    private static final String STATE_PAGE_EXPOSURE_REPORTED = "state_page_exposure_reported";
    private static final String STATE_PAIRING_RESULT_REPORTED = "state_pairing_result_reported";
    private static final String STATE_PAIRING_STARTED_AT_MILLIS = "state_pairing_started_at_millis";
    private static final String STATE_STEP1_COMPLETED_REPORTED = "state_step1_completed_reported";
    private static final String STATE_STEP2_EXPOSURE_REPORTED = "state_step2_exposure_reported";
    private static final long STATUS_SPINNER_DURATION_MS = 1000;
    private static final long SUCCESS_DISPLAY_DURATION_MS = 2000;
    private FragmentConnectComputerGuideBinding _binding;
    private Function1<? super MobileDevice, Unit> onConnectionSuccessListener;
    private Function0<Unit> onDismissListener;
    private DevicePairingEventTracker pairingEventTracker;
    private DevicePairingFunnelEventTracker pairingFunnelEventTracker;
    private long pairingStartedAtMillis;
    private ObjectAnimator statusSpinnerAnimator;
    private ImageView statusSpinnerView;
    private Job successJob;
    private ConnectComputerGuideViewModel viewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ENTER_FROM_NEW_TASK = "new_task";
    private static final BindingTarget DEFAULT_BINDING_TARGET = new BindingTarget(DeviceProductType.WORK, SetsKt.emptySet(), ENTER_FROM_NEW_TASK, null, null, null, 56, null);
    private BindingTarget bindingTarget = DEFAULT_BINDING_TARGET;
    private DeviceEventGate pageExposureGate = new DeviceEventGate(false, 1, null);

    public final Function0<Unit> getOnDismissListener() {
        return this.onDismissListener;
    }

    public final void setOnDismissListener(Function0<Unit> function0) {
        this.onDismissListener = function0;
    }

    public final Function1<MobileDevice, Unit> getOnConnectionSuccessListener() {
        return this.onConnectionSuccessListener;
    }

    public final void setOnConnectionSuccessListener(Function1<? super MobileDevice, Unit> function1) {
        this.onConnectionSuccessListener = function1;
    }

    public final DeviceProductType getTargetProductType() {
        return readBindingTarget().getProductType();
    }

    private final FragmentConnectComputerGuideBinding getBinding() {
        FragmentConnectComputerGuideBinding fragmentConnectComputerGuideBinding = this._binding;
        Intrinsics.checkNotNull(fragmentConnectComputerGuideBinding);
        return fragmentConnectComputerGuideBinding;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final Dialog dialog = (BottomSheetDialog) onCreateDialog;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ConnectComputerGuideFragment.onCreateDialog$lambda$1(dialog, this, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(BottomSheetDialog bottomSheetDialog, ConnectComputerGuideFragment connectComputerGuideFragment, DialogInterface dialogInterface) {
        View findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        if (findViewById != null) {
            findViewById.setBackgroundResource(android.R.color.transparent);
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            int dimensionPixelSize = connectComputerGuideFragment.getResources().getDimensionPixelSize(C0637R.dimen.trae_connect_guide_sheet_height);
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
        this._binding = FragmentConnectComputerGuideBinding.inflate(inflater, container, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(View view, Bundle savedInstanceState) {
        long elapsedRealtime;
        ConnectComputerGuideViewModel connectComputerGuideViewModel;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.bindingTarget = readBindingTarget();
        this.viewModel = (ConnectComputerGuideViewModel) new ViewModelProvider((ViewModelStoreOwner) this, new ConnectComputerGuideViewModel.Factory(this.bindingTarget)).get(ConnectComputerGuideViewModel.class);
        renderBindingTarget();
        DeviceEventGate deviceEventGate = new DeviceEventGate(savedInstanceState != null && savedInstanceState.getBoolean(STATE_PAGE_EXPOSURE_REPORTED));
        this.pageExposureGate = deviceEventGate;
        if (deviceEventGate.tryConsume()) {
            DeviceTracker.INSTANCE.trackPairingPageView(this.bindingTarget.getEnterFrom(), this.bindingTarget.getProductType(), this.bindingTarget.getTriggerBy());
        }
        ConnectComputerGuideViewModel connectComputerGuideViewModel2 = null;
        if (savedInstanceState != null) {
            Long valueOf = Long.valueOf(savedInstanceState.getLong(STATE_PAIRING_STARTED_AT_MILLIS));
            if (!(valueOf.longValue() > 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                elapsedRealtime = valueOf.longValue();
                long j = elapsedRealtime;
                this.pairingStartedAtMillis = j;
                this.pairingEventTracker = new DevicePairingEventTracker(j, ConnectComputerGuideFragment$onViewCreated$2.INSTANCE, new Function1() { // from class: com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit onViewCreated$lambda$3;
                        onViewCreated$lambda$3 = ConnectComputerGuideFragment.onViewCreated$lambda$3(ConnectComputerGuideFragment.this, (DevicePairingTerminalResult) obj);
                        return onViewCreated$lambda$3;
                    }
                }, savedInstanceState == null && savedInstanceState.getBoolean(STATE_PAIRING_RESULT_REPORTED));
                this.pairingFunnelEventTracker = new DevicePairingFunnelEventTracker(savedInstanceState == null && savedInstanceState.getBoolean(STATE_STEP1_COMPLETED_REPORTED), savedInstanceState == null && savedInstanceState.getBoolean(STATE_STEP2_EXPOSURE_REPORTED), new Function0() { // from class: com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit onViewCreated$lambda$4;
                        onViewCreated$lambda$4 = ConnectComputerGuideFragment.onViewCreated$lambda$4(ConnectComputerGuideFragment.this);
                        return onViewCreated$lambda$4;
                    }
                }, new Function0() { // from class: com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit onViewCreated$lambda$5;
                        onViewCreated$lambda$5 = ConnectComputerGuideFragment.onViewCreated$lambda$5(ConnectComputerGuideFragment.this);
                        return onViewCreated$lambda$5;
                    }
                });
                if (!isEmbeddedPresentation()) {
                    getBinding().titleBar.setVisibility(8);
                    getBinding().getRoot().setBackgroundResource(C0591R.color.trae_bg_bg_base_secondary);
                } else {
                    getBinding().titleBar.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$$ExternalSyntheticLambda5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            ConnectComputerGuideFragment.onViewCreated$lambda$6(ConnectComputerGuideFragment.this, view2);
                        }
                    });
                }
                getBinding().btnShare.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ConnectComputerGuideFragment.onViewCreated$lambda$8(ConnectComputerGuideFragment.this, view2);
                    }
                });
                observeBindingState();
                connectComputerGuideViewModel = this.viewModel;
                if (connectComputerGuideViewModel != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    connectComputerGuideViewModel2 = connectComputerGuideViewModel;
                }
                connectComputerGuideViewModel2.start();
            }
        }
        elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = elapsedRealtime;
        this.pairingStartedAtMillis = j2;
        this.pairingEventTracker = new DevicePairingEventTracker(j2, ConnectComputerGuideFragment$onViewCreated$2.INSTANCE, new Function1() { // from class: com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$3;
                onViewCreated$lambda$3 = ConnectComputerGuideFragment.onViewCreated$lambda$3(ConnectComputerGuideFragment.this, (DevicePairingTerminalResult) obj);
                return onViewCreated$lambda$3;
            }
        }, savedInstanceState == null && savedInstanceState.getBoolean(STATE_PAIRING_RESULT_REPORTED));
        this.pairingFunnelEventTracker = new DevicePairingFunnelEventTracker(savedInstanceState == null && savedInstanceState.getBoolean(STATE_STEP1_COMPLETED_REPORTED), savedInstanceState == null && savedInstanceState.getBoolean(STATE_STEP2_EXPOSURE_REPORTED), new Function0() { // from class: com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit onViewCreated$lambda$4;
                onViewCreated$lambda$4 = ConnectComputerGuideFragment.onViewCreated$lambda$4(ConnectComputerGuideFragment.this);
                return onViewCreated$lambda$4;
            }
        }, new Function0() { // from class: com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$$ExternalSyntheticLambda4
            public final Object invoke() {
                Unit onViewCreated$lambda$5;
                onViewCreated$lambda$5 = ConnectComputerGuideFragment.onViewCreated$lambda$5(ConnectComputerGuideFragment.this);
                return onViewCreated$lambda$5;
            }
        });
        if (!isEmbeddedPresentation()) {
        }
        getBinding().btnShare.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectComputerGuideFragment.onViewCreated$lambda$8(ConnectComputerGuideFragment.this, view2);
            }
        });
        observeBindingState();
        connectComputerGuideViewModel = this.viewModel;
        if (connectComputerGuideViewModel != null) {
        }
        connectComputerGuideViewModel2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(ConnectComputerGuideFragment connectComputerGuideFragment, DevicePairingTerminalResult devicePairingTerminalResult) {
        Intrinsics.checkNotNullParameter(devicePairingTerminalResult, "result");
        DeviceTracker.INSTANCE.trackPairResult$conversation_mainlandRelease(devicePairingTerminalResult.getDurationMillis(), devicePairingTerminalResult.isSuccess(), connectComputerGuideFragment.bindingTarget.getEnterFrom(), connectComputerGuideFragment.bindingTarget.getProductType(), devicePairingTerminalResult.getResultDetail(), connectComputerGuideFragment.bindingTarget.getTriggerBy());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4(ConnectComputerGuideFragment connectComputerGuideFragment) {
        DeviceTracker.INSTANCE.trackPairingStep1Complete(connectComputerGuideFragment.bindingTarget.getEnterFrom(), connectComputerGuideFragment.bindingTarget.getProductType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5(ConnectComputerGuideFragment connectComputerGuideFragment) {
        DeviceTracker.INSTANCE.trackPairingStep2Show(connectComputerGuideFragment.bindingTarget.getEnterFrom(), connectComputerGuideFragment.bindingTarget.getProductType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(ConnectComputerGuideFragment connectComputerGuideFragment, View view) {
        connectComputerGuideFragment.reportPairingExitIfNeeded();
        DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) connectComputerGuideFragment);
        if (deviceFlowNavigator != null) {
            deviceFlowNavigator.onRouteBack();
        } else {
            connectComputerGuideFragment.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$8(final ConnectComputerGuideFragment connectComputerGuideFragment, View view) {
        DeviceTracker.INSTANCE.trackPairingPageShareClick(connectComputerGuideFragment.bindingTarget.getEnterFrom(), connectComputerGuideFragment.bindingTarget.getProductType());
        Context context = connectComputerGuideFragment.getContext();
        if (context == null) {
            return;
        }
        ShareUtils.INSTANCE.shareLink(context, connectComputerGuideFragment.downloadUrl(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : new Function1() { // from class: com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$8$lambda$7;
                onViewCreated$lambda$8$lambda$7 = ConnectComputerGuideFragment.onViewCreated$lambda$8$lambda$7(ConnectComputerGuideFragment.this, (ComponentName) obj);
                return onViewCreated$lambda$8$lambda$7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8$lambda$7(ConnectComputerGuideFragment connectComputerGuideFragment, ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "component");
        DeviceTracker deviceTracker = DeviceTracker.INSTANCE;
        String enterFrom = connectComputerGuideFragment.bindingTarget.getEnterFrom();
        String packageName = componentName.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        deviceTracker.trackShareChannelSelect(enterFrom, packageName);
        return Unit.INSTANCE;
    }

    private final void renderBindingTarget() {
        ConnectComputerGuideContent content = ConnectComputerGuideContentPolicy.INSTANCE.content(this.bindingTarget.getProductType());
        loadHeroGif(content.getHeroRes());
        getBinding().tvStep1.setText(content.getStep1Res());
        getBinding().traeUrl.setText(displayUrl());
        getBinding().tvStep2.setText(content.getStep2Res());
    }

    private final void loadHeroGif(int resId) {
        getBinding().ivConnectGuideImage.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.parse("res:///" + resId)).setAutoPlayAnimations(true).setOldController(getBinding().ivConnectGuideImage.getController()).build());
    }

    private final void observeBindingState() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConnectComputerGuideFragment$observeBindingState$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderBindingState(BindingGuideStableState state) {
        int color = ContextCompat.getColor(requireContext(), C0591R.color.trae_text_text_default);
        int color2 = ContextCompat.getColor(requireContext(), C0591R.color.trae_border_border_neutral_l1);
        int color3 = ContextCompat.getColor(requireContext(), C0591R.color.trae_status_primary_default);
        int color4 = ContextCompat.getColor(requireContext(), C0591R.color.trae_status_success_default);
        int color5 = ContextCompat.getColor(requireContext(), C0591R.color.trae_text_text_disabled);
        if (state instanceof BindingGuideStableState.WaitingForDesktop) {
            getBinding().step1Card.setStrokeColor(color);
            ImageView imageView = getBinding().ivStep1Status;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivStep1Status");
            showWaitingStatus(imageView);
            getBinding().tvStep1Status.setText(C0637R.string.trae_connect_guide_waiting_connection);
            getBinding().tvStep1Status.setTextColor(color3);
            getBinding().step2Card.setStrokeColor(color2);
            ImageView imageView2 = getBinding().ivStep2Status;
            Intrinsics.checkNotNullExpressionValue(imageView2, "ivStep2Status");
            showStaticStatus(imageView2, C0637R.drawable.trae_ic_connect_guide_inactive);
            getBinding().tvStep2Status.setText(C0637R.string.trae_connect_guide_awaiting_authorization);
            getBinding().tvStep2Status.setTextColor(color5);
            return;
        }
        if (state instanceof BindingGuideStableState.WaitingForAuthorization) {
            DevicePairingFunnelEventTracker devicePairingFunnelEventTracker = this.pairingFunnelEventTracker;
            if (devicePairingFunnelEventTracker != null) {
                devicePairingFunnelEventTracker.onAuthorizationStepAvailable();
            }
            getBinding().step1Card.setStrokeColor(color2);
            ImageView imageView3 = getBinding().ivStep1Status;
            Intrinsics.checkNotNullExpressionValue(imageView3, "ivStep1Status");
            showStaticStatus(imageView3, C0637R.drawable.checkmark_circle_1);
            getBinding().tvStep1Status.setText(C0637R.string.trae_connect_guide_connected_to_pc);
            getBinding().tvStep1Status.setTextColor(color4);
            getBinding().step2Card.setStrokeColor(color);
            ImageView imageView4 = getBinding().ivStep2Status;
            Intrinsics.checkNotNullExpressionValue(imageView4, "ivStep2Status");
            showWaitingStatus(imageView4);
            getBinding().tvStep2Status.setText(C0637R.string.trae_connect_guide_awaiting_authorization);
            getBinding().tvStep2Status.setTextColor(color3);
            return;
        }
        if (!(state instanceof BindingGuideStableState.Succeeded)) {
            throw new NoWhenBranchMatchedException();
        }
        DevicePairingFunnelEventTracker devicePairingFunnelEventTracker2 = this.pairingFunnelEventTracker;
        if (devicePairingFunnelEventTracker2 != null) {
            devicePairingFunnelEventTracker2.onAuthorizationStepAvailable();
        }
        getBinding().step1Card.setStrokeColor(color2);
        ImageView imageView5 = getBinding().ivStep1Status;
        Intrinsics.checkNotNullExpressionValue(imageView5, "ivStep1Status");
        showStaticStatus(imageView5, C0637R.drawable.checkmark_circle_1);
        getBinding().tvStep1Status.setText(C0637R.string.trae_connect_guide_connected_to_pc);
        getBinding().tvStep1Status.setTextColor(color4);
        getBinding().step2Card.setStrokeColor(color);
        ImageView imageView6 = getBinding().ivStep2Status;
        Intrinsics.checkNotNullExpressionValue(imageView6, "ivStep2Status");
        showStaticStatus(imageView6, C0637R.drawable.checkmark_circle_1);
        getBinding().tvStep2Status.setText(C0637R.string.trae_connect_guide_connected);
        getBinding().tvStep2Status.setTextColor(color4);
    }

    private final void showWaitingStatus(ImageView imageView) {
        imageView.setImageResource(C0637R.drawable.trae_ic_connect_guide_waiting);
        if (this.statusSpinnerView == imageView) {
            ObjectAnimator objectAnimator = this.statusSpinnerAnimator;
            boolean z = false;
            if (objectAnimator != null && objectAnimator.isStarted()) {
                z = true;
            }
            if (z) {
                return;
            }
        }
        stopStatusSpinner();
        imageView.setRotation(0.0f);
        this.statusSpinnerView = imageView;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) View.ROTATION, 0.0f, 360.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
        this.statusSpinnerAnimator = ofFloat;
    }

    private final void showStaticStatus(ImageView imageView, int resId) {
        if (this.statusSpinnerView == imageView) {
            stopStatusSpinner();
        }
        imageView.setRotation(0.0f);
        imageView.setImageResource(resId);
    }

    private final void stopStatusSpinner() {
        ObjectAnimator objectAnimator = this.statusSpinnerAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ImageView imageView = this.statusSpinnerView;
        if (imageView != null) {
            imageView.setRotation(0.0f);
        }
        this.statusSpinnerAnimator = null;
        this.statusSpinnerView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleSuccessCompletion() {
        Job job = this.successJob;
        boolean z = false;
        if (job != null && job.isActive()) {
            z = true;
        }
        if (z) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.successJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConnectComputerGuideFragment$scheduleSuccessCompletion$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completeConnectionSuccess() {
        ConnectComputerGuideViewModel connectComputerGuideViewModel = this.viewModel;
        if (connectComputerGuideViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            connectComputerGuideViewModel = null;
        }
        MobileDevice consumeSucceededDevice = connectComputerGuideViewModel.consumeSucceededDevice();
        if (consumeSucceededDevice == null) {
            return;
        }
        BindingTarget bindingTarget = this.bindingTarget;
        this.bindingTarget = BindingTarget.copy$default(bindingTarget, null, SetsKt.plus(bindingTarget.getExistingDeviceIds(), consumeSucceededDevice.getId()), null, null, consumeSucceededDevice.getId(), consumeSucceededDevice.getName(), 13, null);
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, getString(com.bytedance.trae.multilanguage.R.string.trae_setting_device_online, new Object[]{consumeSucceededDevice.getName()}), 0).show();
        }
        DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) this);
        if (deviceFlowNavigator != null) {
            deviceFlowNavigator.notifyConnectionSuccessWithDevice(consumeSucceededDevice);
            return;
        }
        if (isEmbeddedPresentation()) {
            Function1<? super MobileDevice, Unit> function1 = this.onConnectionSuccessListener;
            if (function1 != null) {
                function1.invoke(consumeSucceededDevice);
                return;
            }
            return;
        }
        dismissAllowingStateLoss();
    }

    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        reportPairingExitIfNeeded();
        super.onDismiss(dialog);
        ConnectComputerGuideViewModel connectComputerGuideViewModel = this.viewModel;
        if (connectComputerGuideViewModel != null) {
            if (connectComputerGuideViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                connectComputerGuideViewModel = null;
            }
            connectComputerGuideViewModel.stop();
        }
        Job job = this.successJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.successJob = null;
        Function0<Unit> function0 = this.onDismissListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onStop() {
        stopStatusSpinner();
        super.onStop();
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_PAGE_EXPOSURE_REPORTED, this.pageExposureGate.getIsConsumed());
        outState.putLong(STATE_PAIRING_STARTED_AT_MILLIS, this.pairingStartedAtMillis);
        DevicePairingEventTracker devicePairingEventTracker = this.pairingEventTracker;
        outState.putBoolean(STATE_PAIRING_RESULT_REPORTED, devicePairingEventTracker != null && devicePairingEventTracker.getIsReported());
        DevicePairingFunnelEventTracker devicePairingFunnelEventTracker = this.pairingFunnelEventTracker;
        outState.putBoolean(STATE_STEP1_COMPLETED_REPORTED, devicePairingFunnelEventTracker != null && devicePairingFunnelEventTracker.isStep1Reported());
        DevicePairingFunnelEventTracker devicePairingFunnelEventTracker2 = this.pairingFunnelEventTracker;
        outState.putBoolean(STATE_STEP2_EXPOSURE_REPORTED, devicePairingFunnelEventTracker2 != null && devicePairingFunnelEventTracker2.isStep2Reported());
    }

    public void onDestroyView() {
        FragmentActivity activity = getActivity();
        boolean z = false;
        if (!(activity != null && activity.isChangingConfigurations())) {
            reportPairingExitIfNeeded();
        }
        ConnectComputerGuideViewModel connectComputerGuideViewModel = this.viewModel;
        if (connectComputerGuideViewModel != null) {
            if (connectComputerGuideViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                connectComputerGuideViewModel = null;
            }
            connectComputerGuideViewModel.stop();
        }
        stopStatusSpinner();
        Job job = this.successJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.successJob = null;
        this.pairingEventTracker = null;
        this.pairingFunnelEventTracker = null;
        this.onConnectionSuccessListener = null;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && activity2.isChangingConfigurations()) {
            z = true;
        }
        if (!z) {
            this.pageExposureGate.reset();
            this.pairingStartedAtMillis = 0L;
        }
        this._binding = null;
        super.onDestroyView();
    }

    private final void reportPairingExitIfNeeded() {
        DevicePairingEventTracker devicePairingEventTracker = this.pairingEventTracker;
        if (devicePairingEventTracker == null) {
            return;
        }
        ConnectComputerGuideViewModel connectComputerGuideViewModel = this.viewModel;
        if (connectComputerGuideViewModel != null) {
            if (connectComputerGuideViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                connectComputerGuideViewModel = null;
            }
            if (((BindingGuideState) connectComputerGuideViewModel.getState().getValue()).getDisplayState() instanceof BindingGuideStableState.Succeeded) {
                devicePairingEventTracker.onPairingSucceeded();
                return;
            }
        }
        DevicePairingFunnelEventTracker devicePairingFunnelEventTracker = this.pairingFunnelEventTracker;
        boolean z = false;
        if (devicePairingFunnelEventTracker != null && devicePairingFunnelEventTracker.isStep1Reported()) {
            z = true;
        }
        devicePairingEventTracker.onPairingExited(z);
    }

    /* compiled from: ConnectComputerGuideFragment.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001d\u001a\u00020\u001e2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00070 j\b\u0012\u0004\u0012\u00020\u0007`!J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0005J.\u0010\u001d\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070'2\u0006\u0010(\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;", "", "<init>", "()V", "DEFAULT_BINDING_TARGET", "Lcom/bytedance/trae/conversation/devices/BindingTarget;", "ARG_PRODUCT_TYPE", "", "ARG_EXISTING_DEVICE_IDS", "ARG_ENTER_FROM", "ARG_DEVICE_ID", "ARG_DEVICE_NAME", "ARG_TRIGGER_BY", "ARG_EMBEDDED_PRESENTATION", "STATE_PAGE_EXPOSURE_REPORTED", "STATE_PAIRING_STARTED_AT_MILLIS", "STATE_PAIRING_RESULT_REPORTED", "STATE_STEP1_COMPLETED_REPORTED", "STATE_STEP2_EXPOSURE_REPORTED", "ARG_ONLINE_DEVICE_IDS", "SUCCESS_DISPLAY_DURATION_MS", "", "STATUS_SPINNER_DURATION_MS", "ENTER_FROM_NEW_TASK", "ENTER_FROM_DEVICE_LIST", "ENTER_FROM_CODE_ADD_DEVICE", "ENTER_FROM_NEW_FEATURE_POPUP", "ENTER_FROM_SETTINGS_DEVICE_MANAGEMENT", "ENTER_FROM_DEVICE_ACTIVATE", "newInstance", "Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;", "onlineDeviceIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "target", "newEmbeddedInstance", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "existingDeviceIds", "", "enterFrom", "triggerBy", "Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConnectComputerGuideFragment newInstance(ArrayList<String> onlineDeviceIds) {
            Intrinsics.checkNotNullParameter(onlineDeviceIds, "onlineDeviceIds");
            ConnectComputerGuideFragment newInstance$default = newInstance$default(this, DeviceProductType.WORK, onlineDeviceIds, ConnectComputerGuideFragment.ENTER_FROM_NEW_TASK, null, 8, null);
            Bundle arguments = newInstance$default.getArguments();
            if (arguments != null) {
                arguments.putStringArrayList(ConnectComputerGuideFragment.ARG_ONLINE_DEVICE_IDS, onlineDeviceIds);
            }
            return newInstance$default;
        }

        public final ConnectComputerGuideFragment newInstance(BindingTarget target) {
            Intrinsics.checkNotNullParameter(target, "target");
            ConnectComputerGuideFragment newInstance = newInstance(target.getProductType(), target.getExistingDeviceIds(), target.getEnterFrom(), target.getTriggerBy());
            Bundle arguments = newInstance.getArguments();
            if (arguments != null) {
                arguments.putString(ConnectComputerGuideFragment.ARG_DEVICE_ID, target.getDeviceId());
            }
            Bundle arguments2 = newInstance.getArguments();
            if (arguments2 != null) {
                arguments2.putString(ConnectComputerGuideFragment.ARG_DEVICE_NAME, target.getDeviceName());
            }
            return newInstance;
        }

        public final ConnectComputerGuideFragment newEmbeddedInstance(BindingTarget target) {
            Intrinsics.checkNotNullParameter(target, "target");
            ConnectComputerGuideFragment newInstance = newInstance(target);
            Bundle arguments = newInstance.getArguments();
            if (arguments != null) {
                arguments.putBoolean(ConnectComputerGuideFragment.ARG_EMBEDDED_PRESENTATION, true);
            }
            return newInstance;
        }

        public static /* synthetic */ ConnectComputerGuideFragment newInstance$default(Companion companion, DeviceProductType deviceProductType, Collection collection, String str, DevicePairingTrigger devicePairingTrigger, int i, Object obj) {
            if ((i & 8) != 0) {
                devicePairingTrigger = DevicePairingTrigger.CONNECT_BUTTON;
            }
            return companion.newInstance(deviceProductType, collection, str, devicePairingTrigger);
        }

        public final ConnectComputerGuideFragment newInstance(DeviceProductType productType, Collection<String> existingDeviceIds, String enterFrom, DevicePairingTrigger triggerBy) {
            Intrinsics.checkNotNullParameter(productType, "productType");
            Intrinsics.checkNotNullParameter(existingDeviceIds, "existingDeviceIds");
            Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
            Intrinsics.checkNotNullParameter(triggerBy, "triggerBy");
            ConnectComputerGuideFragment connectComputerGuideFragment = new ConnectComputerGuideFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ConnectComputerGuideFragment.ARG_PRODUCT_TYPE, productType.name());
            bundle.putStringArrayList(ConnectComputerGuideFragment.ARG_EXISTING_DEVICE_IDS, new ArrayList<>(existingDeviceIds));
            bundle.putString(ConnectComputerGuideFragment.ARG_ENTER_FROM, enterFrom);
            bundle.putString(ConnectComputerGuideFragment.ARG_TRIGGER_BY, triggerBy.name());
            connectComputerGuideFragment.setArguments(bundle);
            return connectComputerGuideFragment;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0034, code lost:
    
        if (r1 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final BindingTarget readBindingTarget() {
        Object obj;
        DeviceProductType deviceProductType;
        Object obj2;
        DevicePairingTrigger devicePairingTrigger;
        Bundle arguments = getArguments();
        if (arguments == null) {
            return DEFAULT_BINDING_TARGET;
        }
        String string = arguments.getString(ARG_PRODUCT_TYPE);
        if (string != null) {
            try {
                Result.Companion companion = Result.Companion;
                ConnectComputerGuideFragment connectComputerGuideFragment = this;
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
        ArrayList<String> stringArrayList = arguments.getStringArrayList(ARG_EXISTING_DEVICE_IDS);
        Set set = CollectionsKt.toSet((stringArrayList == null && (stringArrayList = arguments.getStringArrayList(ARG_ONLINE_DEVICE_IDS)) == null) ? CollectionsKt.emptyList() : stringArrayList);
        String string2 = arguments.getString(ARG_ENTER_FROM);
        if (string2 == null) {
            string2 = ENTER_FROM_NEW_TASK;
        }
        String str = string2;
        String string3 = arguments.getString(ARG_TRIGGER_BY);
        if (string3 != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                ConnectComputerGuideFragment connectComputerGuideFragment2 = this;
                obj2 = Result.constructor-impl(DevicePairingTrigger.valueOf(string3));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
            }
            DevicePairingTrigger devicePairingTrigger2 = (DevicePairingTrigger) (Result.isFailure-impl(obj2) ? null : obj2);
            if (devicePairingTrigger2 != null) {
                devicePairingTrigger = devicePairingTrigger2;
                return new BindingTarget(deviceProductType2, set, str, devicePairingTrigger, arguments.getString(ARG_DEVICE_ID), arguments.getString(ARG_DEVICE_NAME));
            }
        }
        devicePairingTrigger = DevicePairingTrigger.CONNECT_BUTTON;
        return new BindingTarget(deviceProductType2, set, str, devicePairingTrigger, arguments.getString(ARG_DEVICE_ID), arguments.getString(ARG_DEVICE_NAME));
    }

    private final boolean isEmbeddedPresentation() {
        Bundle arguments = getArguments();
        return arguments != null && arguments.getBoolean(ARG_EMBEDDED_PRESENTATION);
    }

    private final String downloadUrl() {
        return ConnectComputerGuideContentPolicy.INSTANCE.downloadUrl(AppHost.INSTANCE.isOversea());
    }

    private final String displayUrl() {
        return ConnectComputerGuideContentPolicy.INSTANCE.displayUrl(AppHost.INSTANCE.isOversea());
    }
}
