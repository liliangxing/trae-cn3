package com.bytedance.trae.home.solo.setting;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.common.activity.SimpleWebViewActivity;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common.widget.UrlSpanTextView;
import com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.tracker.DeviceTracker;
import com.bytedance.trae.home.C0820R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AddDevicesFragment.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;", "pageExposureReported", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "openUrl", IWeixinService.ResponseConstants.URL, "", "onSaveInstanceState", "outState", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AddDevicesFragment extends Fragment {
    private static final String STATE_PAGE_EXPOSURE_REPORTED = "state_page_exposure_reported";
    private boolean pageExposureReported;
    private SettingsDeviceListViewModel viewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean z = false;
        if (savedInstanceState != null && savedInstanceState.getBoolean(STATE_PAGE_EXPOSURE_REPORTED)) {
            z = true;
        }
        this.pageExposureReported = z;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_add_devices, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (!this.pageExposureReported) {
            this.pageExposureReported = true;
            DeviceTracker.trackPairingPageView$default(DeviceTracker.INSTANCE, ConnectComputerGuideFragment.ENTER_FROM_SETTINGS_DEVICE_MANAGEMENT, DeviceProductType.WORK, null, 4, null);
        }
        ViewModelStoreOwner requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.viewModel = (SettingsDeviceListViewModel) new ViewModelProvider(requireActivity).get(SettingsDeviceListViewModel.class);
        ((TraeTitleBar) view.findViewById(C0820R.id.title_bar)).setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AddDevicesFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddDevicesFragment.onViewCreated$lambda$0(AddDevicesFragment.this, view2);
            }
        });
        UrlSpanTextView urlSpanTextView = (UrlSpanTextView) view.findViewById(C0820R.id.tv_step1_url);
        urlSpanTextView.setUrlSpannedText("  ".concat(AppHost.INSTANCE.isOversea() ? "trae.ai" : "trae.cn"));
        urlSpanTextView.setOnClickListener(new UrlSpanTextView.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AddDevicesFragment$onViewCreated$2
            @Override // com.bytedance.trae.common.widget.UrlSpanTextView.OnClickListener
            public void onUrlClick(String url) {
                Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
                AddDevicesFragment.this.openUrl(AppHost.INSTANCE.isOversea() ? "https://trae.ai" : "https://trae.cn");
            }
        });
        ((ImageView) view.findViewById(C0820R.id.btn_copy_url)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AddDevicesFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddDevicesFragment.onViewCreated$lambda$1(AddDevicesFragment.this, view2);
            }
        });
        SettingsDeviceListViewModel settingsDeviceListViewModel = this.viewModel;
        if (settingsDeviceListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsDeviceListViewModel = null;
        }
        settingsDeviceListViewModel.getNewOnlineDevice().observe(getViewLifecycleOwner(), new AddDevicesFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.home.solo.setting.AddDevicesFragment$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$2;
                onViewCreated$lambda$2 = AddDevicesFragment.onViewCreated$lambda$2(AddDevicesFragment.this, (String) obj);
                return onViewCreated$lambda$2;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(AddDevicesFragment addDevicesFragment, View view) {
        addDevicesFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(AddDevicesFragment addDevicesFragment, View view) {
        DeviceTracker.INSTANCE.trackDownloadLinkCopyClick(ConnectComputerGuideFragment.ENTER_FROM_SETTINGS_DEVICE_MANAGEMENT, DeviceProductType.WORK);
        String str = AppHost.INSTANCE.isOversea() ? "https://trae.ai" : "https://trae.cn";
        Object systemService = addDevicesFragment.requireContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(IWeixinService.ResponseConstants.URL, str));
        Toast.makeText(addDevicesFragment.requireContext(), C0820R.string.trae_setting_url_copied, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(AddDevicesFragment addDevicesFragment, String str) {
        if (str != null) {
            Toast.makeText(addDevicesFragment.requireContext(), addDevicesFragment.getString(C0820R.string.trae_setting_device_online, new Object[]{str}), 0).show();
            SettingsDeviceListViewModel settingsDeviceListViewModel = addDevicesFragment.viewModel;
            if (settingsDeviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                settingsDeviceListViewModel = null;
            }
            settingsDeviceListViewModel.onNewDeviceToastShown();
            addDevicesFragment.getParentFragmentManager().popBackStack();
        }
        return Unit.INSTANCE;
    }

    public void onResume() {
        super.onResume();
        SettingsDeviceListViewModel settingsDeviceListViewModel = this.viewModel;
        if (settingsDeviceListViewModel != null) {
            if (settingsDeviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                settingsDeviceListViewModel = null;
            }
            settingsDeviceListViewModel.startPolling();
        }
    }

    public void onPause() {
        super.onPause();
        SettingsDeviceListViewModel settingsDeviceListViewModel = this.viewModel;
        if (settingsDeviceListViewModel != null) {
            if (settingsDeviceListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                settingsDeviceListViewModel = null;
            }
            settingsDeviceListViewModel.stopPolling();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openUrl(String url) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        try {
            if (AppHost.INSTANCE.isOversea()) {
                SimpleWebViewActivity.Companion.start$default(SimpleWebViewActivity.INSTANCE, context, url, false, 4, null);
            } else {
                String str = "sslocal://webview?hide_nav_bar=1&url=" + Uri.encode(url, ":/?=&#");
                AnnieX annieX = AnnieX.INSTANCE;
                Uri parse = Uri.parse(str);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                AnnieX.open$default(annieX, context, parse, (Function1) null, 4, (Object) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* compiled from: AddDevicesFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$Companion;", "", "<init>", "()V", "STATE_PAGE_EXPOSURE_REPORTED", "", "newInstance", "Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDevicesFragment newInstance() {
            return new AddDevicesFragment();
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putBoolean(STATE_PAGE_EXPOSURE_REPORTED, this.pageExposureReported);
        super.onSaveInstanceState(outState);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
    
        if (r0.isChangingConfigurations() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDestroyView() {
        boolean z;
        super.onDestroyView();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            z = true;
        }
        z = false;
        if (z) {
            return;
        }
        this.pageExposureReported = false;
    }
}
