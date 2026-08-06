package com.bytedance.trae.login;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeletionPendingDialogHelper.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"com/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1$onSuccess$1$1", "Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;", "deviceOverLimit", "", "token", "", "onSuccess", "onFailure", "errorCode", "errorMessage", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DeletionPendingDialogHelper$show$3$1$onSuccess$1$1 implements TraeAuthManager.TraeAuthCallback {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $funnelLoginPlatform;
    final /* synthetic */ Function0<Unit> $onRestoreSuccess;

    @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
    public void deviceOverLimit(String token) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeletionPendingDialogHelper$show$3$1$onSuccess$1$1(String str, Activity activity, Function0<Unit> function0) {
        this.$funnelLoginPlatform = str;
        this.$activity = activity;
        this.$onRestoreSuccess = function0;
    }

    @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
    public void onSuccess() {
        DeletionPendingDialogHelper.reportRestoreFunnel$default(DeletionPendingDialogHelper.INSTANCE, this.$funnelLoginPlatform, TraeAuthManager.STAGE_ACCOUNT_RESTORE_SUCCESS, null, null, null, 28, null);
        final Activity activity = this.$activity;
        final Function0<Unit> function0 = this.$onRestoreSuccess;
        activity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DeletionPendingDialogHelper$show$3$1$onSuccess$1$1.onSuccess$lambda$0(activity, function0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$0(Activity activity, Function0 function0) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        function0.invoke();
    }

    @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
    public void onFailure(String errorCode, final String errorMessage) {
        Log.e("DeletionPendingDialog", "TraeAuth after restore failed: " + errorCode + ' ' + errorMessage);
        DeletionPendingDialogHelper.INSTANCE.reportRestoreFunnel(this.$funnelLoginPlatform, TraeAuthManager.STAGE_ACCOUNT_RESTORE_FAIL, "trae_auth_after_restore", errorCode, errorMessage);
        final Activity activity = this.$activity;
        activity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.DeletionPendingDialogHelper$show$3$1$onSuccess$1$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DeletionPendingDialogHelper$show$3$1$onSuccess$1$1.onFailure$lambda$1(activity, errorMessage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFailure$lambda$1(Activity activity, String str) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        Activity activity2 = activity;
        if (str == null) {
            str = activity.getString(C0882R.string.trae_login_deletion_login_failed);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        }
        Toast.makeText(activity2, str, 0).show();
    }
}
