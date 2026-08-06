package com.bytedance.trae.login;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.ies.bullet.service.monitor.fluency.FluencyHelper;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.interfaze.IMessageCallbackService;
import com.bytedance.sdk.account.impl.BDAccountAPIV3Impl;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeletionPendingDialogHelper.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eJ4\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eJ>\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J>\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/login/DeletionPendingDialogHelper;", "", "<init>", "()V", "TAG", "", "ERROR_CODE_ACCOUNT_DELETION_PENDING", "", IMessageCallbackService.EVENT_TYPE_SHOW, "", "activity", "Landroid/app/Activity;", "token", "onRestoreSuccess", "Lkotlin/Function0;", "onExit", "funnelLoginPlatform", "reportRestoreFunnel", "loginPlatform", FluencyHelper.STAGE, "failedStep", "errorCode", ISignalReportConstants.KEY_REASON, "resetButtons", "btnCancel", "Landroid/widget/TextView;", "btnExit", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DeletionPendingDialogHelper {
    public static final int ERROR_CODE_ACCOUNT_DELETION_PENDING = 1075;
    public static final DeletionPendingDialogHelper INSTANCE = new DeletionPendingDialogHelper();
    private static final String TAG = "DeletionPendingDialog";

    private DeletionPendingDialogHelper() {
    }

    public final void show(Activity activity, String token, Function0<Unit> onRestoreSuccess) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(onRestoreSuccess, "onRestoreSuccess");
        show(activity, token, onRestoreSuccess, null);
    }

    public final void show(Activity activity, String token, Function0<Unit> onRestoreSuccess, Function0<Unit> onExit) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(onRestoreSuccess, "onRestoreSuccess");
        show(activity, token, onRestoreSuccess, onExit, null);
    }

    public final void show(final Activity activity, final String token, final Function0<Unit> onRestoreSuccess, final Function0<Unit> onExit, final String funnelLoginPlatform) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(onRestoreSuccess, "onRestoreSuccess");
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C0820R.layout.dialog_account_deletion_pending);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout((int) (activity.getResources().getDisplayMetrics().widthPixels * 0.8d), -2);
            window.setGravity(17);
            window.setDimAmount(0.5f);
        }
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        final TextView textView = (TextView) dialog.findViewById(C0820R.id.btn_exit);
        final TextView textView2 = (TextView) dialog.findViewById(C0820R.id.btn_cancel_deletion);
        reportRestoreFunnel$default(this, funnelLoginPlatform, TraeAuthManager.STAGE_ACCOUNT_DELETION_PENDING_SHOWN, null, null, null, 28, null);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.DeletionPendingDialogHelper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeletionPendingDialogHelper.show$lambda$1(funnelLoginPlatform, dialog, onExit, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.DeletionPendingDialogHelper$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeletionPendingDialogHelper.show$lambda$2(funnelLoginPlatform, textView2, textView, token, activity, dialog, onRestoreSuccess, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$1(String str, Dialog dialog, Function0 function0, View view) {
        reportRestoreFunnel$default(INSTANCE, str, TraeAuthManager.STAGE_ACCOUNT_RESTORE_EXIT, "user_exit", null, null, 24, null);
        dialog.dismiss();
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2(String str, TextView textView, TextView textView2, String str2, Activity activity, Dialog dialog, Function0 function0, View view) {
        reportRestoreFunnel$default(INSTANCE, str, TraeAuthManager.STAGE_ACCOUNT_RESTORE_CLICK, null, null, null, 28, null);
        textView.setEnabled(false);
        textView2.setEnabled(false);
        textView.setText("...");
        BDAccountAPIV3Impl.instance().cancelCloseAccountWithToken(str2, new DeletionPendingDialogHelper$show$3$1(activity, dialog, str, function0, textView, textView2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void reportRestoreFunnel$default(DeletionPendingDialogHelper deletionPendingDialogHelper, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        deletionPendingDialogHelper.reportRestoreFunnel(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportRestoreFunnel(String loginPlatform, String stage, String failedStep, String errorCode, String reason) {
        String str = loginPlatform;
        if (str == null || str.length() == 0) {
            return;
        }
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, stage, loginPlatform, null, failedStep, errorCode, reason, null, null, null, null, null, 1984, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetButtons(Activity activity, TextView btnCancel, TextView btnExit) {
        btnCancel.setEnabled(true);
        btnExit.setEnabled(true);
        btnCancel.setText(activity.getString(C0882R.string.trae_login_deletion_cancel_deletion));
    }
}
