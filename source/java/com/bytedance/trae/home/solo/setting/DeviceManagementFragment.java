package com.bytedance.trae.home.solo.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.common.widget.ContextMenuPopupWindow;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.devices.BindingTarget;
import com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment;
import com.bytedance.trae.conversation.devices.DeviceAddTargetPolicy;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.devices.MobileDevice;
import com.bytedance.trae.conversation.devices.MobileIdeFeatureGate;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowRequest;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute;
import com.bytedance.trae.conversation.tracker.DeviceTracker;
import com.bytedance.trae.home.C0820R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DeviceManagementFragment.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001@B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0010H\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J(\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\tH\u0002J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0010H\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u001aH\u0002J\b\u0010*\u001a\u00020\u001aH\u0016J\b\u0010+\u001a\u00020\u001aH\u0016J\b\u0010,\u001a\u00020\u001aH\u0016J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0018H\u0016J \u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002J\u001e\u00105\u001a\u00020\u001a2\u0006\u00100\u001a\u0002012\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a07H\u0002J\u001e\u00108\u001a\u00020\u001a2\u0006\u00100\u001a\u0002012\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a07H\u0002J\b\u00109\u001a\u00020\u001aH\u0002J\u0010\u0010:\u001a\u00020\u001a2\u0006\u00100\u001a\u000201H\u0002J\u001a\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\tH\u0002J\b\u0010?\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;", "adapter", "Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;", "hasTrackedPageView", "", "actionPopup", "Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;", "isBindingGuideShowing", "isEmbeddedEmptyGuideShowing", "isRefreshingAfterEmbeddedSuccess", "selectedEmptyGuideTarget", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupEmptyGuide", "selectEmptyGuideTarget", "productType", "renderEmptyGuide", "renderEmptyGuideTab", "textViewId", "", "indicatorId", "selected", "showEmbeddedEmptyGuide", "bindEmbeddedGuideCallback", "guide", "Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;", "removeEmbeddedEmptyGuide", "onResume", "onPause", "onDestroyView", "onSaveInstanceState", "outState", "showActionPopup", "item", "Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;", "rawX", "", "rawY", "showRenameDialog", "closeAction", "Lkotlin/Function0;", "showUnbindDialog", "showAddDeviceTargetSelector", "showUnpairedDeviceBindingGuide", "showBindingDeviceFlow", "initialRoute", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;", "respectIdeGuideGate", "onBindingFlowClosed", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceManagementFragment extends Fragment {
    private static final String EMPTY_GUIDE_FRAGMENT_TAG = "device_management_empty_guide";
    private static final String STATE_EMPTY_GUIDE_PRODUCT_TYPE = "state_empty_guide_product_type";
    private ContextMenuPopupWindow actionPopup;
    private SettingsDeviceAdapter adapter;
    private boolean hasTrackedPageView;
    private boolean isBindingGuideShowing;
    private boolean isEmbeddedEmptyGuideShowing;
    private boolean isRefreshingAfterEmbeddedSuccess;
    private DeviceProductType selectedEmptyGuideTarget = DeviceProductType.WORK;
    private SettingsDeviceListViewModel viewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_device_management, container, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0057, code lost:
    
        if (r0 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        DeviceProductType deviceProductType;
        String string;
        Object obj;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModelStoreOwner requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.viewModel = (SettingsDeviceListViewModel) new ViewModelProvider(requireActivity).get(SettingsDeviceListViewModel.class);
        SettingsDeviceListViewModel settingsDeviceListViewModel = null;
        if (savedInstanceState != null && (string = savedInstanceState.getString(STATE_EMPTY_GUIDE_PRODUCT_TYPE)) != null) {
            try {
                Result.Companion companion = Result.Companion;
                DeviceManagementFragment deviceManagementFragment = this;
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
        this.selectedEmptyGuideTarget = deviceProductType;
        final ProgressBar progressBar = (ProgressBar) view.findViewById(C0820R.id.progress_loading);
        final RecyclerView findViewById = view.findViewById(C0820R.id.rv_device_management);
        final View findViewById2 = view.findViewById(C0820R.id.layout_empty_guide);
        final TextView textView = (TextView) view.findViewById(C0820R.id.btn_add_device);
        this.adapter = new SettingsDeviceAdapter(new Function1() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda4
            public final Object invoke(Object obj2) {
                Unit onViewCreated$lambda$2;
                onViewCreated$lambda$2 = DeviceManagementFragment.onViewCreated$lambda$2(DeviceManagementFragment.this, (SettingsDeviceItem) obj2);
                return onViewCreated$lambda$2;
            }
        }, new Function4() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda7
            public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                Unit onViewCreated$lambda$3;
                onViewCreated$lambda$3 = DeviceManagementFragment.onViewCreated$lambda$3(DeviceManagementFragment.this, (SettingsDeviceItem) obj2, (View) obj3, ((Float) obj4).floatValue(), ((Float) obj5).floatValue());
                return onViewCreated$lambda$3;
            }
        }, new Function2() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda8
            public final Object invoke(Object obj2, Object obj3) {
                Unit onViewCreated$lambda$4;
                onViewCreated$lambda$4 = DeviceManagementFragment.onViewCreated$lambda$4(DeviceManagementFragment.this, (SettingsDeviceItem) obj2, (Function0) obj3);
                return onViewCreated$lambda$4;
            }
        }, new Function2() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda9
            public final Object invoke(Object obj2, Object obj3) {
                Unit onViewCreated$lambda$5;
                onViewCreated$lambda$5 = DeviceManagementFragment.onViewCreated$lambda$5(DeviceManagementFragment.this, (SettingsDeviceItem) obj2, (Function0) obj3);
                return onViewCreated$lambda$5;
            }
        }, new Function0() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda10
            public final Object invoke() {
                Unit onViewCreated$lambda$6;
                onViewCreated$lambda$6 = DeviceManagementFragment.onViewCreated$lambda$6(DeviceManagementFragment.this);
                return onViewCreated$lambda$6;
            }
        });
        findViewById.setLayoutManager(new LinearLayoutManager(getContext()));
        SettingsDeviceAdapter settingsDeviceAdapter = this.adapter;
        if (settingsDeviceAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            settingsDeviceAdapter = null;
        }
        findViewById.setAdapter((RecyclerView.Adapter) settingsDeviceAdapter);
        findViewById.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$onViewCreated$7
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                SettingsDeviceAdapter settingsDeviceAdapter2;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (newState == 1) {
                    settingsDeviceAdapter2 = DeviceManagementFragment.this.adapter;
                    if (settingsDeviceAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        settingsDeviceAdapter2 = null;
                    }
                    settingsDeviceAdapter2.closeOpenItem();
                }
            }
        });
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, new OnBackPressedCallback() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$onViewCreated$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            public void handleOnBackPressed() {
                SettingsDeviceAdapter settingsDeviceAdapter2;
                SettingsDeviceAdapter settingsDeviceAdapter3;
                SettingsDeviceAdapter settingsDeviceAdapter4;
                settingsDeviceAdapter2 = DeviceManagementFragment.this.adapter;
                if (settingsDeviceAdapter2 != null) {
                    settingsDeviceAdapter3 = DeviceManagementFragment.this.adapter;
                    SettingsDeviceAdapter settingsDeviceAdapter5 = null;
                    if (settingsDeviceAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        settingsDeviceAdapter3 = null;
                    }
                    if (settingsDeviceAdapter3.hasOpenItem()) {
                        settingsDeviceAdapter4 = DeviceManagementFragment.this.adapter;
                        if (settingsDeviceAdapter4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        } else {
                            settingsDeviceAdapter5 = settingsDeviceAdapter4;
                        }
                        settingsDeviceAdapter5.closeOpenItem();
                        return;
                    }
                }
                setEnabled(false);
                DeviceManagementFragment.this.requireActivity().getOnBackPressedDispatcher().onBackPressed();
            }
        });
        ((TraeTitleBar) view.findViewById(C0820R.id.title_bar)).setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceManagementFragment.onViewCreated$lambda$7(DeviceManagementFragment.this, view2);
            }
        });
        setupEmptyGuide(view);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceManagementFragment.this.showAddDeviceTargetSelector();
            }
        });
        SettingsDeviceListViewModel settingsDeviceListViewModel2 = this.viewModel;
        if (settingsDeviceListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsDeviceListViewModel2 = null;
        }
        settingsDeviceListViewModel2.isLoading().observe(getViewLifecycleOwner(), new DeviceManagementFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda14
            public final Object invoke(Object obj2) {
                Unit onViewCreated$lambda$9;
                onViewCreated$lambda$9 = DeviceManagementFragment.onViewCreated$lambda$9(progressBar, (Boolean) obj2);
                return onViewCreated$lambda$9;
            }
        }));
        SettingsDeviceListViewModel settingsDeviceListViewModel3 = this.viewModel;
        if (settingsDeviceListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsDeviceListViewModel3 = null;
        }
        settingsDeviceListViewModel3.getDevices().observe(getViewLifecycleOwner(), new DeviceManagementFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda15
            public final Object invoke(Object obj2) {
                Unit onViewCreated$lambda$11;
                onViewCreated$lambda$11 = DeviceManagementFragment.onViewCreated$lambda$11(DeviceManagementFragment.this, view, findViewById2, findViewById, textView, (List) obj2);
                return onViewCreated$lambda$11;
            }
        }));
        SettingsDeviceListViewModel settingsDeviceListViewModel4 = this.viewModel;
        if (settingsDeviceListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsDeviceListViewModel4 = null;
        }
        settingsDeviceListViewModel4.getNewOnlineDevice().observe(getViewLifecycleOwner(), new DeviceManagementFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda16
            public final Object invoke(Object obj2) {
                Unit onViewCreated$lambda$12;
                onViewCreated$lambda$12 = DeviceManagementFragment.onViewCreated$lambda$12(DeviceManagementFragment.this, (String) obj2);
                return onViewCreated$lambda$12;
            }
        }));
        SettingsDeviceListViewModel settingsDeviceListViewModel5 = this.viewModel;
        if (settingsDeviceListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsDeviceListViewModel5 = null;
        }
        settingsDeviceListViewModel5.getRenameFailed().observe(getViewLifecycleOwner(), new DeviceManagementFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda5
            public final Object invoke(Object obj2) {
                Unit onViewCreated$lambda$13;
                onViewCreated$lambda$13 = DeviceManagementFragment.onViewCreated$lambda$13(DeviceManagementFragment.this, (Boolean) obj2);
                return onViewCreated$lambda$13;
            }
        }));
        SettingsDeviceListViewModel settingsDeviceListViewModel6 = this.viewModel;
        if (settingsDeviceListViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            settingsDeviceListViewModel = settingsDeviceListViewModel6;
        }
        settingsDeviceListViewModel.getUnbindFailed().observe(getViewLifecycleOwner(), new DeviceManagementFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda6
            public final Object invoke(Object obj2) {
                Unit onViewCreated$lambda$14;
                onViewCreated$lambda$14 = DeviceManagementFragment.onViewCreated$lambda$14(DeviceManagementFragment.this, (Boolean) obj2);
                return onViewCreated$lambda$14;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(DeviceManagementFragment deviceManagementFragment, SettingsDeviceItem settingsDeviceItem) {
        Intrinsics.checkNotNullParameter(settingsDeviceItem, "item");
        deviceManagementFragment.showUnpairedDeviceBindingGuide(settingsDeviceItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(DeviceManagementFragment deviceManagementFragment, SettingsDeviceItem settingsDeviceItem, View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(settingsDeviceItem, "item");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        deviceManagementFragment.showActionPopup(settingsDeviceItem, f, f2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4(DeviceManagementFragment deviceManagementFragment, SettingsDeviceItem settingsDeviceItem, Function0 function0) {
        Intrinsics.checkNotNullParameter(settingsDeviceItem, "item");
        Intrinsics.checkNotNullParameter(function0, "closeAction");
        deviceManagementFragment.showRenameDialog(settingsDeviceItem, function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5(DeviceManagementFragment deviceManagementFragment, SettingsDeviceItem settingsDeviceItem, Function0 function0) {
        Intrinsics.checkNotNullParameter(settingsDeviceItem, "item");
        Intrinsics.checkNotNullParameter(function0, "closeAction");
        deviceManagementFragment.showUnbindDialog(settingsDeviceItem, function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6(DeviceManagementFragment deviceManagementFragment) {
        Toast.makeText(deviceManagementFragment.requireContext(), deviceManagementFragment.getString(C0820R.string.solo_toast_unpaired_device_unsupported), 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(DeviceManagementFragment deviceManagementFragment, View view) {
        deviceManagementFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$9(ProgressBar progressBar, Boolean bool) {
        progressBar.setVisibility(bool.booleanValue() ? 0 : 8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$11(DeviceManagementFragment deviceManagementFragment, View view, View view2, RecyclerView recyclerView, TextView textView, List list) {
        if (!deviceManagementFragment.hasTrackedPageView) {
            deviceManagementFragment.hasTrackedPageView = true;
            SettingsTracker.INSTANCE.trackDeviceManagementPageView(list.size());
        }
        Intrinsics.checkNotNull(list);
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((SettingsDeviceItem) it.next()).getProductType());
        }
        boolean z = CollectionsKt.distinct(arrayList).size() > 1;
        SettingsDeviceAdapter settingsDeviceAdapter = deviceManagementFragment.adapter;
        SettingsDeviceListViewModel settingsDeviceListViewModel = null;
        if (settingsDeviceAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            settingsDeviceAdapter = null;
        }
        boolean z2 = settingsDeviceAdapter.getShowProductType() != z;
        SettingsDeviceAdapter settingsDeviceAdapter2 = deviceManagementFragment.adapter;
        if (settingsDeviceAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            settingsDeviceAdapter2 = null;
        }
        settingsDeviceAdapter2.setShowProductType(z);
        if (z2) {
            SettingsDeviceAdapter settingsDeviceAdapter3 = deviceManagementFragment.adapter;
            if (settingsDeviceAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                settingsDeviceAdapter3 = null;
            }
            if (settingsDeviceAdapter3.getItemCount() > 0) {
                SettingsDeviceAdapter settingsDeviceAdapter4 = deviceManagementFragment.adapter;
                if (settingsDeviceAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    settingsDeviceAdapter4 = null;
                }
                SettingsDeviceAdapter settingsDeviceAdapter5 = deviceManagementFragment.adapter;
                if (settingsDeviceAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    settingsDeviceAdapter5 = null;
                }
                settingsDeviceAdapter4.notifyItemRangeChanged(0, settingsDeviceAdapter5.getItemCount());
            }
        }
        SettingsDeviceAdapter settingsDeviceAdapter6 = deviceManagementFragment.adapter;
        if (settingsDeviceAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            settingsDeviceAdapter6 = null;
        }
        settingsDeviceAdapter6.submitList(list);
        boolean isEmpty = list.isEmpty();
        if (isEmpty) {
            deviceManagementFragment.isEmbeddedEmptyGuideShowing = true;
            SettingsDeviceListViewModel settingsDeviceListViewModel2 = deviceManagementFragment.viewModel;
            if (settingsDeviceListViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                settingsDeviceListViewModel2 = null;
            }
            settingsDeviceListViewModel2.setNewDeviceNotificationsEnabled(false);
            if (deviceManagementFragment.isRefreshingAfterEmbeddedSuccess && deviceManagementFragment.isResumed()) {
                SettingsDeviceListViewModel settingsDeviceListViewModel3 = deviceManagementFragment.viewModel;
                if (settingsDeviceListViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    settingsDeviceListViewModel = settingsDeviceListViewModel3;
                }
                settingsDeviceListViewModel.startPolling();
            } else {
                SettingsDeviceListViewModel settingsDeviceListViewModel4 = deviceManagementFragment.viewModel;
                if (settingsDeviceListViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    settingsDeviceListViewModel = settingsDeviceListViewModel4;
                }
                settingsDeviceListViewModel.stopPolling();
            }
            deviceManagementFragment.renderEmptyGuide(view);
        } else {
            deviceManagementFragment.isRefreshingAfterEmbeddedSuccess = false;
            deviceManagementFragment.isEmbeddedEmptyGuideShowing = false;
            deviceManagementFragment.removeEmbeddedEmptyGuide();
            if (!deviceManagementFragment.isBindingGuideShowing) {
                SettingsDeviceListViewModel settingsDeviceListViewModel5 = deviceManagementFragment.viewModel;
                if (settingsDeviceListViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    settingsDeviceListViewModel = settingsDeviceListViewModel5;
                }
                settingsDeviceListViewModel.setNewDeviceNotificationsEnabled(true);
            }
        }
        view2.setVisibility(isEmpty ? 0 : 8);
        recyclerView.setVisibility(isEmpty ? 8 : 0);
        textView.setVisibility(isEmpty ? 8 : 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$12(DeviceManagementFragment deviceManagementFragment, String str) {
        if (str != null) {
            Toast.makeText(deviceManagementFragment.requireContext(), deviceManagementFragment.getString(C0820R.string.trae_setting_device_online, new Object[]{str}), 0).show();
            SettingsDeviceListViewModel settingsDeviceListViewModel = deviceManagementFragment.viewModel;
            if (settingsDeviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                settingsDeviceListViewModel = null;
            }
            settingsDeviceListViewModel.onNewDeviceToastShown();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$13(DeviceManagementFragment deviceManagementFragment, Boolean bool) {
        if (Intrinsics.areEqual(bool, true)) {
            Toast.makeText(deviceManagementFragment.requireContext(), deviceManagementFragment.getString(C0820R.string.solo_toast_rename_failed), 0).show();
            SettingsDeviceListViewModel settingsDeviceListViewModel = deviceManagementFragment.viewModel;
            if (settingsDeviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                settingsDeviceListViewModel = null;
            }
            settingsDeviceListViewModel.onRenameFailureToastShown();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$14(DeviceManagementFragment deviceManagementFragment, Boolean bool) {
        if (Intrinsics.areEqual(bool, true)) {
            Toast.makeText(deviceManagementFragment.requireContext(), deviceManagementFragment.getString(C0820R.string.solo_toast_device_unbind_failed), 0).show();
            SettingsDeviceListViewModel settingsDeviceListViewModel = deviceManagementFragment.viewModel;
            if (settingsDeviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                settingsDeviceListViewModel = null;
            }
            settingsDeviceListViewModel.onUnbindFailureToastShown();
        }
        return Unit.INSTANCE;
    }

    private final void setupEmptyGuide(final View view) {
        view.findViewById(C0820R.id.tab_empty_guide_work).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceManagementFragment.setupEmptyGuide$lambda$15(DeviceManagementFragment.this, view, view2);
            }
        });
        view.findViewById(C0820R.id.tab_empty_guide_ide).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceManagementFragment.setupEmptyGuide$lambda$16(DeviceManagementFragment.this, view, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupEmptyGuide$lambda$15(DeviceManagementFragment deviceManagementFragment, View view, View view2) {
        deviceManagementFragment.selectEmptyGuideTarget(view, DeviceProductType.WORK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupEmptyGuide$lambda$16(DeviceManagementFragment deviceManagementFragment, View view, View view2) {
        deviceManagementFragment.selectEmptyGuideTarget(view, DeviceProductType.IDE);
    }

    private final void selectEmptyGuideTarget(View view, DeviceProductType productType) {
        if (DeviceAddTargetPolicy.availableTargets$default(DeviceAddTargetPolicy.INSTANCE, false, 1, null).contains(productType)) {
            this.selectedEmptyGuideTarget = productType;
            renderEmptyGuide(view);
        }
    }

    private final void renderEmptyGuide(View view) {
        List availableTargets$default = DeviceAddTargetPolicy.availableTargets$default(DeviceAddTargetPolicy.INSTANCE, false, 1, null);
        DeviceProductType deviceProductType = this.selectedEmptyGuideTarget;
        DeviceProductType deviceProductType2 = availableTargets$default.contains(deviceProductType) ? deviceProductType : null;
        if (deviceProductType2 == null && (deviceProductType2 = (DeviceProductType) CollectionsKt.firstOrNull(availableTargets$default)) == null) {
            deviceProductType2 = DeviceProductType.WORK;
        }
        this.selectedEmptyGuideTarget = deviceProductType2;
        view.findViewById(C0820R.id.layout_empty_guide_tabs).setVisibility(availableTargets$default.size() > 1 ? 0 : 8);
        view.findViewById(C0820R.id.tab_empty_guide_ide).setVisibility(availableTargets$default.contains(DeviceProductType.IDE) ? 0 : 8);
        renderEmptyGuideTab(view, C0820R.id.tv_empty_guide_work_tab, C0820R.id.indicator_empty_guide_work, deviceProductType2 == DeviceProductType.WORK);
        renderEmptyGuideTab(view, C0820R.id.tv_empty_guide_ide_tab, C0820R.id.indicator_empty_guide_ide, deviceProductType2 == DeviceProductType.IDE);
        showEmbeddedEmptyGuide(deviceProductType2);
    }

    private final void renderEmptyGuideTab(View view, int textViewId, int indicatorId, boolean selected) {
        int i;
        Context context = view.getContext();
        TextView textView = (TextView) view.findViewById(textViewId);
        if (selected) {
            i = C0591R.color.trae_text_text_default;
        } else {
            i = C0591R.color.trae_text_text_tertiary;
        }
        textView.setTextColor(ContextCompat.getColor(context, i));
        textView.setTypeface(Typeface.create(selected ? "sans-serif-medium" : "sans-serif", 0));
        view.findViewById(indicatorId).setVisibility(selected ? 0 : 4);
    }

    private final void showEmbeddedEmptyGuide(DeviceProductType productType) {
        if (!isAdded() || getChildFragmentManager().isStateSaved()) {
            return;
        }
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag(EMPTY_GUIDE_FRAGMENT_TAG);
        SettingsDeviceListViewModel settingsDeviceListViewModel = null;
        ConnectComputerGuideFragment connectComputerGuideFragment = findFragmentByTag instanceof ConnectComputerGuideFragment ? (ConnectComputerGuideFragment) findFragmentByTag : null;
        if ((connectComputerGuideFragment != null ? connectComputerGuideFragment.getTargetProductType() : null) == productType) {
            bindEmbeddedGuideCallback(connectComputerGuideFragment);
            return;
        }
        if (connectComputerGuideFragment != null) {
            connectComputerGuideFragment.setOnConnectionSuccessListener(null);
        }
        ConnectComputerGuideFragment.Companion companion = ConnectComputerGuideFragment.INSTANCE;
        SettingsDeviceListViewModel settingsDeviceListViewModel2 = this.viewModel;
        if (settingsDeviceListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            settingsDeviceListViewModel = settingsDeviceListViewModel2;
        }
        List list = (List) settingsDeviceListViewModel.getDevices().getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((SettingsDeviceItem) next).getProductType() == productType) {
                arrayList.add(next);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(((SettingsDeviceItem) it2.next()).getId());
        }
        Fragment newEmbeddedInstance = companion.newEmbeddedInstance(new BindingTarget(productType, linkedHashSet, ConnectComputerGuideFragment.ENTER_FROM_SETTINGS_DEVICE_MANAGEMENT, null, null, null, 56, null));
        bindEmbeddedGuideCallback(newEmbeddedInstance);
        getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(C0820R.id.empty_guide_content, newEmbeddedInstance, EMPTY_GUIDE_FRAGMENT_TAG).commit();
    }

    private final void bindEmbeddedGuideCallback(ConnectComputerGuideFragment guide) {
        guide.setOnConnectionSuccessListener(new Function1() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindEmbeddedGuideCallback$lambda$19;
                bindEmbeddedGuideCallback$lambda$19 = DeviceManagementFragment.bindEmbeddedGuideCallback$lambda$19(DeviceManagementFragment.this, (MobileDevice) obj);
                return bindEmbeddedGuideCallback$lambda$19;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindEmbeddedGuideCallback$lambda$19(DeviceManagementFragment deviceManagementFragment, MobileDevice mobileDevice) {
        Intrinsics.checkNotNullParameter(mobileDevice, "it");
        if (deviceManagementFragment.isEmbeddedEmptyGuideShowing) {
            deviceManagementFragment.isRefreshingAfterEmbeddedSuccess = true;
            SettingsDeviceListViewModel settingsDeviceListViewModel = deviceManagementFragment.viewModel;
            SettingsDeviceListViewModel settingsDeviceListViewModel2 = null;
            if (settingsDeviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                settingsDeviceListViewModel = null;
            }
            settingsDeviceListViewModel.fetchDevices();
            if (deviceManagementFragment.isResumed()) {
                SettingsDeviceListViewModel settingsDeviceListViewModel3 = deviceManagementFragment.viewModel;
                if (settingsDeviceListViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    settingsDeviceListViewModel2 = settingsDeviceListViewModel3;
                }
                settingsDeviceListViewModel2.startPolling();
            }
        }
        return Unit.INSTANCE;
    }

    private final void removeEmbeddedEmptyGuide() {
        ConnectComputerGuideFragment findFragmentByTag = getChildFragmentManager().findFragmentByTag(EMPTY_GUIDE_FRAGMENT_TAG);
        ConnectComputerGuideFragment connectComputerGuideFragment = findFragmentByTag instanceof ConnectComputerGuideFragment ? findFragmentByTag : null;
        if (connectComputerGuideFragment == null) {
            return;
        }
        connectComputerGuideFragment.setOnConnectionSuccessListener(null);
        getChildFragmentManager().beginTransaction().setReorderingAllowed(true).remove((Fragment) connectComputerGuideFragment).commitAllowingStateLoss();
    }

    public void onResume() {
        super.onResume();
        SettingsDeviceListViewModel settingsDeviceListViewModel = this.viewModel;
        if (settingsDeviceListViewModel != null) {
            SettingsDeviceListViewModel settingsDeviceListViewModel2 = null;
            if (this.isBindingGuideShowing || (this.isEmbeddedEmptyGuideShowing && !this.isRefreshingAfterEmbeddedSuccess)) {
                if (settingsDeviceListViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    settingsDeviceListViewModel = null;
                }
                settingsDeviceListViewModel.setNewDeviceNotificationsEnabled(false);
                SettingsDeviceListViewModel settingsDeviceListViewModel3 = this.viewModel;
                if (settingsDeviceListViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    settingsDeviceListViewModel2 = settingsDeviceListViewModel3;
                }
                settingsDeviceListViewModel2.stopPolling();
                return;
            }
            if (settingsDeviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                settingsDeviceListViewModel = null;
            }
            settingsDeviceListViewModel.setNewDeviceNotificationsEnabled(!this.isEmbeddedEmptyGuideShowing);
            SettingsDeviceListViewModel settingsDeviceListViewModel4 = this.viewModel;
            if (settingsDeviceListViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                settingsDeviceListViewModel4 = null;
            }
            settingsDeviceListViewModel4.fetchDevices();
            SettingsDeviceListViewModel settingsDeviceListViewModel5 = this.viewModel;
            if (settingsDeviceListViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                settingsDeviceListViewModel2 = settingsDeviceListViewModel5;
            }
            settingsDeviceListViewModel2.startPolling();
        }
    }

    public void onPause() {
        super.onPause();
        SettingsDeviceListViewModel settingsDeviceListViewModel = this.viewModel;
        SettingsDeviceAdapter settingsDeviceAdapter = null;
        if (settingsDeviceListViewModel != null) {
            if (settingsDeviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                settingsDeviceListViewModel = null;
            }
            settingsDeviceListViewModel.stopPolling();
        }
        ContextMenuPopupWindow contextMenuPopupWindow = this.actionPopup;
        if (contextMenuPopupWindow != null) {
            contextMenuPopupWindow.dismiss();
        }
        SettingsDeviceAdapter settingsDeviceAdapter2 = this.adapter;
        if (settingsDeviceAdapter2 != null) {
            if (settingsDeviceAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                settingsDeviceAdapter = settingsDeviceAdapter2;
            }
            settingsDeviceAdapter.closeOpenItem();
        }
    }

    public void onDestroyView() {
        ContextMenuPopupWindow contextMenuPopupWindow = this.actionPopup;
        if (contextMenuPopupWindow != null) {
            contextMenuPopupWindow.dismiss();
        }
        SettingsDeviceListViewModel settingsDeviceListViewModel = null;
        this.actionPopup = null;
        SettingsDeviceListViewModel settingsDeviceListViewModel2 = this.viewModel;
        if (settingsDeviceListViewModel2 != null && (this.isBindingGuideShowing || this.isEmbeddedEmptyGuideShowing)) {
            this.isBindingGuideShowing = false;
            this.isEmbeddedEmptyGuideShowing = false;
            this.isRefreshingAfterEmbeddedSuccess = false;
            if (settingsDeviceListViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                settingsDeviceListViewModel = settingsDeviceListViewModel2;
            }
            settingsDeviceListViewModel.setNewDeviceNotificationsEnabled(true);
        }
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putString(STATE_EMPTY_GUIDE_PRODUCT_TYPE, this.selectedEmptyGuideTarget.name());
        super.onSaveInstanceState(outState);
    }

    private final void showActionPopup(final SettingsDeviceItem item, float rawX, float rawY) {
        if (item.isPaired()) {
            ContextMenuPopupWindow contextMenuPopupWindow = this.actionPopup;
            if (contextMenuPopupWindow != null) {
                contextMenuPopupWindow.dismiss();
            }
            SettingsDeviceAdapter settingsDeviceAdapter = this.adapter;
            if (settingsDeviceAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                settingsDeviceAdapter = null;
            }
            settingsDeviceAdapter.closeOpenItem();
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            int i = C0591R.drawable.trae_ic_context_menu_rename;
            String string = getString(C0820R.string.solo_context_menu_rename);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            int i2 = C0591R.drawable.trae_ic_context_menu_delete;
            String string2 = getString(C0820R.string.solo_device_context_menu_unbind);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ContextMenuPopupWindow contextMenuPopupWindow2 = new ContextMenuPopupWindow(requireContext, CollectionsKt.listOf(new ContextMenuPopupWindow.Item[]{new ContextMenuPopupWindow.Item(i, string, false, null, null, C0820R.id.menu_rename, new Function0() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit showActionPopup$lambda$21;
                    showActionPopup$lambda$21 = DeviceManagementFragment.showActionPopup$lambda$21(DeviceManagementFragment.this, item);
                    return showActionPopup$lambda$21;
                }
            }, 28, null), new ContextMenuPopupWindow.Item(i2, string2, true, null, null, C0820R.id.menu_delete, new Function0() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit showActionPopup$lambda$23;
                    showActionPopup$lambda$23 = DeviceManagementFragment.showActionPopup$lambda$23(DeviceManagementFragment.this, item);
                    return showActionPopup$lambda$23;
                }
            }, 24, null)}), 0, 4, null);
            View requireView = requireView();
            Intrinsics.checkNotNullExpressionValue(requireView, "requireView(...)");
            contextMenuPopupWindow2.showNear(requireView, rawX, rawY);
            this.actionPopup = contextMenuPopupWindow2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showActionPopup$lambda$21(DeviceManagementFragment deviceManagementFragment, SettingsDeviceItem settingsDeviceItem) {
        deviceManagementFragment.showRenameDialog(settingsDeviceItem, new Function0() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda17
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showActionPopup$lambda$23(DeviceManagementFragment deviceManagementFragment, SettingsDeviceItem settingsDeviceItem) {
        deviceManagementFragment.showUnbindDialog(settingsDeviceItem, new Function0() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda18
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
        return Unit.INSTANCE;
    }

    private final void showRenameDialog(final SettingsDeviceItem item, final Function0<Unit> closeAction) {
        CustomConfirmDialog rename;
        if (item.isPaired()) {
            CustomConfirmDialog.Companion companion = CustomConfirmDialog.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            String string = getString(C0820R.string.solo_device_dialog_rename_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String name = item.getName();
            String string2 = getString(C0820R.string.solo_dialog_btn_cancel);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = getString(C0820R.string.solo_dialog_btn_confirm);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            rename = companion.rename(requireContext, string, name, (r20 & 8) != 0 ? null : null, string2, string3, new Function1() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda21
                public final Object invoke(Object obj) {
                    Unit showRenameDialog$lambda$24;
                    showRenameDialog$lambda$24 = DeviceManagementFragment.showRenameDialog$lambda$24(DeviceManagementFragment.this, item, (String) obj);
                    return showRenameDialog$lambda$24;
                }
            }, (r20 & 128) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.CustomConfirmDialog$Companion$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            } : null);
            rename.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda22
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    closeAction.invoke();
                }
            });
            rename.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRenameDialog$lambda$24(DeviceManagementFragment deviceManagementFragment, SettingsDeviceItem settingsDeviceItem, String str) {
        SettingsDeviceListViewModel settingsDeviceListViewModel = null;
        String obj = str != null ? StringsKt.trim(str).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (obj.length() > 0) {
            SettingsDeviceListViewModel settingsDeviceListViewModel2 = deviceManagementFragment.viewModel;
            if (settingsDeviceListViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                settingsDeviceListViewModel = settingsDeviceListViewModel2;
            }
            settingsDeviceListViewModel.renameDevice(settingsDeviceItem.getId(), obj);
        }
        return Unit.INSTANCE;
    }

    private final void showUnbindDialog(final SettingsDeviceItem item, final Function0<Unit> closeAction) {
        CustomConfirmDialog delete;
        if (item.isPaired()) {
            CustomConfirmDialog.Companion companion = CustomConfirmDialog.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            String string = getString(C0820R.string.solo_device_unbind_dialog_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = getString(C0820R.string.solo_device_unbind_dialog_message);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = getString(C0820R.string.solo_dialog_btn_cancel);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String string4 = getString(C0820R.string.solo_device_dialog_btn_unbind);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            delete = companion.delete(requireContext, string, string2, (r38 & 8) != 0 ? "" : string3, string4, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : null, (r38 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? 0 : 0, (r38 & 16384) != 0 ? C0591R.drawable.trae_bg_custom_dialog_btn_primary : 0, new Function0() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda19
                public final Object invoke() {
                    Unit showUnbindDialog$lambda$26;
                    showUnbindDialog$lambda$26 = DeviceManagementFragment.showUnbindDialog$lambda$26(DeviceManagementFragment.this, item);
                    return showUnbindDialog$lambda$26;
                }
            }, (r38 & 65536) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.CustomConfirmDialog$Companion$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            } : null);
            delete.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda20
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    closeAction.invoke();
                }
            });
            delete.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showUnbindDialog$lambda$26(DeviceManagementFragment deviceManagementFragment, SettingsDeviceItem settingsDeviceItem) {
        SettingsDeviceListViewModel settingsDeviceListViewModel = deviceManagementFragment.viewModel;
        if (settingsDeviceListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsDeviceListViewModel = null;
        }
        settingsDeviceListViewModel.unbindDevice(settingsDeviceItem.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAddDeviceTargetSelector() {
        List<? extends DeviceProductType> availableTargets$default = DeviceAddTargetPolicy.availableTargets$default(DeviceAddTargetPolicy.INSTANCE, false, 1, null);
        DeviceFlowContainerBottomSheet.Companion companion = DeviceFlowContainerBottomSheet.INSTANCE;
        SettingsDeviceListViewModel settingsDeviceListViewModel = this.viewModel;
        if (settingsDeviceListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsDeviceListViewModel = null;
        }
        List list = (List) settingsDeviceListViewModel.getDevices().getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        showBindingDeviceFlow$default(this, companion.targetSelectRoute(availableTargets$default, SettingsDeviceMapperKt.deviceIdsByProduct(list), ConnectComputerGuideFragment.ENTER_FROM_SETTINGS_DEVICE_MANAGEMENT), false, 2, null);
    }

    private final void showUnpairedDeviceBindingGuide(SettingsDeviceItem item) {
        SettingsDeviceListViewModel settingsDeviceListViewModel = this.viewModel;
        if (settingsDeviceListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsDeviceListViewModel = null;
        }
        List list = (List) settingsDeviceListViewModel.getDevices().getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        DeviceFlowRoute.ConnectGuide unpairedBindingRoute = SettingsDeviceMapperKt.unpairedBindingRoute(item, list, ConnectComputerGuideFragment.ENTER_FROM_SETTINGS_DEVICE_MANAGEMENT);
        if (unpairedBindingRoute == null) {
            return;
        }
        showBindingDeviceFlow(unpairedBindingRoute, false);
    }

    static /* synthetic */ void showBindingDeviceFlow$default(DeviceManagementFragment deviceManagementFragment, DeviceFlowRoute deviceFlowRoute, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        deviceManagementFragment.showBindingDeviceFlow(deviceFlowRoute, z);
    }

    private final void showBindingDeviceFlow(DeviceFlowRoute initialRoute, boolean respectIdeGuideGate) {
        DeviceProductType productType;
        if (this.isBindingGuideShowing || !isAdded() || getChildFragmentManager().isStateSaved() || !getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            return;
        }
        SettingsDeviceListViewModel settingsDeviceListViewModel = null;
        if (initialRoute instanceof DeviceFlowRoute.ConnectGuide) {
            productType = ((DeviceFlowRoute.ConnectGuide) initialRoute).getTarget().getProductType();
        } else {
            productType = initialRoute instanceof DeviceFlowRoute.OfflineActivation ? ((DeviceFlowRoute.OfflineActivation) initialRoute).getTarget().getProductType() : null;
        }
        if (!respectIdeGuideGate || productType == null || MobileIdeFeatureGate.INSTANCE.canOpenConnectGuide(productType)) {
            this.isBindingGuideShowing = true;
            DeviceTracker.INSTANCE.trackConnectEntryClick(ConnectComputerGuideFragment.ENTER_FROM_SETTINGS_DEVICE_MANAGEMENT, null);
            SettingsDeviceListViewModel settingsDeviceListViewModel2 = this.viewModel;
            if (settingsDeviceListViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                settingsDeviceListViewModel2 = null;
            }
            settingsDeviceListViewModel2.setNewDeviceNotificationsEnabled(false);
            SettingsDeviceListViewModel settingsDeviceListViewModel3 = this.viewModel;
            if (settingsDeviceListViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                settingsDeviceListViewModel = settingsDeviceListViewModel3;
            }
            settingsDeviceListViewModel.stopPolling();
            try {
                DeviceFlowContainerBottomSheet.INSTANCE.newInstance(new DeviceFlowRequest(initialRoute, new DeviceFlowCallbacks(null, null, null, new Function0() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit showBindingDeviceFlow$lambda$28;
                        showBindingDeviceFlow$lambda$28 = DeviceManagementFragment.showBindingDeviceFlow$lambda$28(DeviceManagementFragment.this);
                        return showBindingDeviceFlow$lambda$28;
                    }
                }, null, new Function0() { // from class: com.bytedance.trae.home.solo.setting.DeviceManagementFragment$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Unit showBindingDeviceFlow$lambda$29;
                        showBindingDeviceFlow$lambda$29 = DeviceManagementFragment.showBindingDeviceFlow$lambda$29(DeviceManagementFragment.this);
                        return showBindingDeviceFlow$lambda$29;
                    }
                }, 23, null))).show(getChildFragmentManager(), DeviceFlowContainerBottomSheet.TAG);
            } catch (Throwable th) {
                onBindingFlowClosed();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showBindingDeviceFlow$lambda$28(DeviceManagementFragment deviceManagementFragment) {
        deviceManagementFragment.onBindingFlowClosed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showBindingDeviceFlow$lambda$29(DeviceManagementFragment deviceManagementFragment) {
        deviceManagementFragment.onBindingFlowClosed();
        return Unit.INSTANCE;
    }

    private final void onBindingFlowClosed() {
        if (this.isBindingGuideShowing) {
            this.isBindingGuideShowing = false;
            SettingsDeviceListViewModel settingsDeviceListViewModel = this.viewModel;
            SettingsDeviceListViewModel settingsDeviceListViewModel2 = null;
            if (settingsDeviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                settingsDeviceListViewModel = null;
            }
            settingsDeviceListViewModel.setNewDeviceNotificationsEnabled(true);
            SettingsDeviceListViewModel settingsDeviceListViewModel3 = this.viewModel;
            if (settingsDeviceListViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                settingsDeviceListViewModel3 = null;
            }
            settingsDeviceListViewModel3.fetchDevices();
            if (isResumed()) {
                SettingsDeviceListViewModel settingsDeviceListViewModel4 = this.viewModel;
                if (settingsDeviceListViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    settingsDeviceListViewModel2 = settingsDeviceListViewModel4;
                }
                settingsDeviceListViewModel2.startPolling();
            }
        }
    }

    /* compiled from: DeviceManagementFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$Companion;", "", "<init>", "()V", "EMPTY_GUIDE_FRAGMENT_TAG", "", "STATE_EMPTY_GUIDE_PRODUCT_TYPE", "newInstance", "Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceManagementFragment newInstance() {
            return new DeviceManagementFragment();
        }
    }
}
