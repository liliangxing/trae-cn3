package com.bytedance.trae.home.solo.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.login.api.LoginDeviceInfo;
import com.bytedance.trae.login.api.LoginDeviceListResult;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugLoginDevicesFragment.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u0016\u0010\u001d\u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "adapter", "Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;", "progressLoading", "Landroid/widget/ProgressBar;", "rvDevices", "Landroidx/recyclerview/widget/RecyclerView;", "tvEmpty", "Landroid/widget/TextView;", "isLoading", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "fetchDevices", "setLoading", "loading", "showDevices", "devices", "", "Lcom/bytedance/trae/login/api/LoginDeviceInfo;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DebugLoginDevicesFragment extends Fragment {
    private DebugLoginDevicesAdapter adapter;
    private boolean isLoading;
    private ProgressBar progressLoading;
    private RecyclerView rvDevices;
    private TextView tvEmpty;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(C0820R.layout.fragment_debug_login_devices, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.progressLoading = (ProgressBar) view.findViewById(C0820R.id.progress_loading);
        this.rvDevices = view.findViewById(C0820R.id.rv_login_devices);
        this.tvEmpty = (TextView) view.findViewById(C0820R.id.tv_empty);
        ((TraeTitleBar) view.findViewById(C0820R.id.title_bar)).setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DebugLoginDevicesFragment.onViewCreated$lambda$0(DebugLoginDevicesFragment.this, view2);
            }
        });
        this.adapter = new DebugLoginDevicesAdapter();
        RecyclerView recyclerView = this.rvDevices;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        RecyclerView recyclerView2 = this.rvDevices;
        if (recyclerView2 != null) {
            DebugLoginDevicesAdapter debugLoginDevicesAdapter = this.adapter;
            if (debugLoginDevicesAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                debugLoginDevicesAdapter = null;
            }
            recyclerView2.setAdapter((RecyclerView.Adapter) debugLoginDevicesAdapter);
        }
        fetchDevices();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(DebugLoginDevicesFragment debugLoginDevicesFragment, View view) {
        debugLoginDevicesFragment.getParentFragmentManager().popBackStack();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.progressLoading = null;
        this.rvDevices = null;
        this.tvEmpty = null;
    }

    private final void fetchDevices() {
        if (this.isLoading) {
            return;
        }
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null) {
            showDevices(CollectionsKt.emptyList());
            Toast.makeText(getContext(), C0820R.string.trae_setting_debug_login_devices_load_failed, 0).show();
        } else {
            this.isLoading = true;
            setLoading(true);
            iLoginService.listLoginDevices(new Function1() { // from class: com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit fetchDevices$lambda$2;
                    fetchDevices$lambda$2 = DebugLoginDevicesFragment.fetchDevices$lambda$2(DebugLoginDevicesFragment.this, (LoginDeviceListResult) obj);
                    return fetchDevices$lambda$2;
                }
            }, new Function1() { // from class: com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit fetchDevices$lambda$4;
                    fetchDevices$lambda$4 = DebugLoginDevicesFragment.fetchDevices$lambda$4(DebugLoginDevicesFragment.this, (String) obj);
                    return fetchDevices$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fetchDevices$lambda$2(final DebugLoginDevicesFragment debugLoginDevicesFragment, final LoginDeviceListResult loginDeviceListResult) {
        Intrinsics.checkNotNullParameter(loginDeviceListResult, "result");
        View view = debugLoginDevicesFragment.getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    DebugLoginDevicesFragment.fetchDevices$lambda$2$lambda$1(DebugLoginDevicesFragment.this, loginDeviceListResult);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchDevices$lambda$2$lambda$1(DebugLoginDevicesFragment debugLoginDevicesFragment, LoginDeviceListResult loginDeviceListResult) {
        debugLoginDevicesFragment.isLoading = false;
        debugLoginDevicesFragment.setLoading(false);
        debugLoginDevicesFragment.showDevices(loginDeviceListResult.getDevices());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fetchDevices$lambda$4(final DebugLoginDevicesFragment debugLoginDevicesFragment, String str) {
        View view = debugLoginDevicesFragment.getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    DebugLoginDevicesFragment.fetchDevices$lambda$4$lambda$3(DebugLoginDevicesFragment.this);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchDevices$lambda$4$lambda$3(DebugLoginDevicesFragment debugLoginDevicesFragment) {
        debugLoginDevicesFragment.isLoading = false;
        debugLoginDevicesFragment.setLoading(false);
        debugLoginDevicesFragment.showDevices(CollectionsKt.emptyList());
        Toast.makeText(debugLoginDevicesFragment.getContext(), C0820R.string.trae_setting_debug_login_devices_load_failed, 0).show();
    }

    private final void setLoading(boolean loading) {
        ProgressBar progressBar = this.progressLoading;
        if (progressBar != null) {
            progressBar.setVisibility(loading ? 0 : 8);
        }
    }

    private final void showDevices(List<LoginDeviceInfo> devices) {
        DebugLoginDevicesAdapter debugLoginDevicesAdapter = this.adapter;
        if (debugLoginDevicesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            debugLoginDevicesAdapter = null;
        }
        debugLoginDevicesAdapter.submitList(devices);
        TextView textView = this.tvEmpty;
        if (textView != null) {
            textView.setVisibility(devices.isEmpty() ? 0 : 8);
        }
        RecyclerView recyclerView = this.rvDevices;
        if (recyclerView != null) {
            recyclerView.setVisibility(devices.isEmpty() ? 8 : 0);
        }
    }

    /* compiled from: DebugLoginDevicesFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DebugLoginDevicesFragment newInstance() {
            return new DebugLoginDevicesFragment();
        }
    }
}
