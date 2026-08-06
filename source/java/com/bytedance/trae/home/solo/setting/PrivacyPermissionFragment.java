package com.bytedance.trae.home.solo.setting;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrivacyPermissionFragment.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initSystemPermissionSection", "showGoSettingsDialog", "titleRes", "", "descRes", "goToSystemSettings", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PrivacyPermissionFragment extends Fragment {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_privacy_permission, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((TraeTitleBar) view.findViewById(C0820R.id.title_bar)).setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.PrivacyPermissionFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PrivacyPermissionFragment.onViewCreated$lambda$0(PrivacyPermissionFragment.this, view2);
            }
        });
        initSystemPermissionSection(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(PrivacyPermissionFragment privacyPermissionFragment, View view) {
        privacyPermissionFragment.getParentFragmentManager().popBackStack();
    }

    private final void initSystemPermissionSection(View view) {
        for (Map.Entry entry : MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(C0820R.id.btn_push), new Pair(Integer.valueOf(C0820R.string.trae_setting_privacy_dialog_title_push), Integer.valueOf(C0820R.string.trae_setting_privacy_dialog_desc_push))), TuplesKt.to(Integer.valueOf(C0820R.id.btn_camera_photo), new Pair(Integer.valueOf(C0820R.string.trae_setting_privacy_dialog_title_camera_photo), Integer.valueOf(C0820R.string.trae_setting_privacy_dialog_desc_camera_photo))), TuplesKt.to(Integer.valueOf(C0820R.id.btn_photo), new Pair(Integer.valueOf(C0820R.string.trae_setting_privacy_dialog_title_photo), Integer.valueOf(C0820R.string.trae_setting_privacy_dialog_desc_photo))), TuplesKt.to(Integer.valueOf(C0820R.id.btn_recording), new Pair(Integer.valueOf(C0820R.string.trae_setting_privacy_dialog_title_recording), Integer.valueOf(C0820R.string.trae_setting_privacy_dialog_desc_recording))), TuplesKt.to(Integer.valueOf(C0820R.id.btn_file_access), new Pair(Integer.valueOf(C0820R.string.trae_setting_privacy_dialog_title_file_access), Integer.valueOf(C0820R.string.trae_setting_privacy_dialog_desc_file_access)))}).entrySet()) {
            int intValue = ((Number) entry.getKey()).intValue();
            final Pair pair = (Pair) entry.getValue();
            ((LinearLayout) view.findViewById(intValue)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.PrivacyPermissionFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PrivacyPermissionFragment.initSystemPermissionSection$lambda$2$lambda$1(PrivacyPermissionFragment.this, pair, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSystemPermissionSection$lambda$2$lambda$1(PrivacyPermissionFragment privacyPermissionFragment, Pair pair, View view) {
        privacyPermissionFragment.showGoSettingsDialog(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue());
    }

    private final void showGoSettingsDialog(int titleRes, int descRes) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        String string = getString(titleRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(descRes);
        String string3 = getString(C0820R.string.trae_setting_privacy_dialog_btn_cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(C0820R.string.trae_setting_privacy_dialog_btn_confirm);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        new CustomConfirmDialog(context, new CustomConfirmDialog.Config(string, string2, null, null, string3, string4, null, 0.0f, null, null, null, null, 0, 0, 0, null, null, null, false, new Function1() { // from class: com.bytedance.trae.home.solo.setting.PrivacyPermissionFragment$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit showGoSettingsDialog$lambda$3;
                showGoSettingsDialog$lambda$3 = PrivacyPermissionFragment.showGoSettingsDialog$lambda$3(PrivacyPermissionFragment.this, (String) obj);
                return showGoSettingsDialog$lambda$3;
            }
        }, null, 1572812, null)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGoSettingsDialog$lambda$3(PrivacyPermissionFragment privacyPermissionFragment, String str) {
        privacyPermissionFragment.goToSystemSettings();
        return Unit.INSTANCE;
    }

    private final void goToSystemSettings() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", AppHost.INSTANCE.getApplication().getPackageName(), null));
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    /* compiled from: PrivacyPermissionFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PrivacyPermissionFragment newInstance() {
            return new PrivacyPermissionFragment();
        }
    }
}
