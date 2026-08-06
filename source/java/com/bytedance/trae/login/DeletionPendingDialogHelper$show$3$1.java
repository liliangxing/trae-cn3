package com.bytedance.trae.login;

import android.app.Activity;
import android.app.Dialog;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.account.api.callback.CancelCloseAccountCallback;
import com.bytedance.sdk.account.api.response.CancelCloseAccountResponse;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeletionPendingDialogHelper.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/bytedance/trae/login/DeletionPendingDialogHelper$show$3$1", "Lcom/bytedance/sdk/account/api/callback/CancelCloseAccountCallback;", "onSuccess", "", "response", "Lcom/bytedance/sdk/account/api/response/CancelCloseAccountResponse;", "onError", "error", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DeletionPendingDialogHelper$show$3$1 extends CancelCloseAccountCallback {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ TextView $btnCancelDeletion;
    final /* synthetic */ TextView $btnExit;
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ String $funnelLoginPlatform;
    final /* synthetic */ Function0<Unit> $onRestoreSuccess;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeletionPendingDialogHelper$show$3$1(Activity activity, Dialog dialog, String str, Function0<Unit> function0, TextView textView, TextView textView2) {
        this.$activity = activity;
        this.$dialog = dialog;
        this.$funnelLoginPlatform = str;
        this.$onRestoreSuccess = function0;
        this.$btnCancelDeletion = textView;
        this.$btnExit = textView2;
    }

    public void onSuccess(CancelCloseAccountResponse response) {
        final Activity activity = this.$activity;
        final Dialog dialog = this.$dialog;
        final String str = this.$funnelLoginPlatform;
        final Function0<Unit> function0 = this.$onRestoreSuccess;
        activity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DeletionPendingDialogHelper$show$3$1.onSuccess$lambda$0(activity, dialog, str, function0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$0(Activity activity, Dialog dialog, String str, Function0 function0) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        dialog.dismiss();
        DeletionPendingDialogHelper.reportRestoreFunnel$default(DeletionPendingDialogHelper.INSTANCE, str, TraeAuthManager.STAGE_ACCOUNT_RESTORE_API_SUCCESS, null, null, null, 28, null);
        TraeAuthManager.INSTANCE.onPassportLoginSuccess("account_restore", new DeletionPendingDialogHelper$show$3$1$onSuccess$1$1(str, activity, function0));
    }

    public void onError(final CancelCloseAccountResponse response, final int error) {
        final Activity activity = this.$activity;
        final String str = this.$funnelLoginPlatform;
        final TextView textView = this.$btnCancelDeletion;
        final TextView textView2 = this.$btnExit;
        activity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.DeletionPendingDialogHelper$show$3$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DeletionPendingDialogHelper$show$3$1.onError$lambda$1(activity, response, str, error, textView, textView2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onError$lambda$1(Activity activity, CancelCloseAccountResponse cancelCloseAccountResponse, String str, int i, TextView textView, TextView textView2) {
        String string;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        if (cancelCloseAccountResponse == null || (string = cancelCloseAccountResponse.errorMsg) == null) {
            string = activity.getString(C0882R.string.trae_login_deletion_cancel_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        DeletionPendingDialogHelper.INSTANCE.reportRestoreFunnel(str, TraeAuthManager.STAGE_ACCOUNT_RESTORE_FAIL, "cancel_close_account", String.valueOf(i), string);
        Toast.makeText(activity, string, 0).show();
        DeletionPendingDialogHelper deletionPendingDialogHelper = DeletionPendingDialogHelper.INSTANCE;
        Intrinsics.checkNotNull(textView);
        Intrinsics.checkNotNull(textView2);
        deletionPendingDialogHelper.resetButtons(activity, textView, textView2);
    }
}
