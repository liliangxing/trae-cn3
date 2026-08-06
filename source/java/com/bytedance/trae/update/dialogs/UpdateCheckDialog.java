package com.bytedance.trae.update.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.Toast;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.update.bits.impl.C0906R;
import com.ss.android.update.IUpdateCheckDialog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* compiled from: UpdateCheckDialog.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0006\u0010\u001b\u001a\u00020\u0013R\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;", "Lcom/ss/android/update/IUpdateCheckDialog;", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "updateDialogWeakRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Dialog;", "getUpdateDialogWeakRef", "()Ljava/lang/ref/WeakReference;", "setUpdateDialogWeakRef", "(Ljava/lang/ref/WeakReference;)V", "processDialogWeakRef", "getProcessDialogWeakRef", "setProcessDialogWeakRef", "showCheckDialog", "", "status", "", "isShowCheckDialog", "", "showUpdateDialog", "showNoUpdateDialog", "showCheckFailureDialog", "showProgressDialog", "bits-impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UpdateCheckDialog implements IUpdateCheckDialog {
    public static final UpdateCheckDialog INSTANCE = new UpdateCheckDialog();
    private static final String TAG = "UpdateCheckDialog";
    private static WeakReference<Dialog> processDialogWeakRef;
    private static WeakReference<Dialog> updateDialogWeakRef;

    private UpdateCheckDialog() {
    }

    public final WeakReference<Dialog> getUpdateDialogWeakRef() {
        return updateDialogWeakRef;
    }

    public final void setUpdateDialogWeakRef(WeakReference<Dialog> weakReference) {
        updateDialogWeakRef = weakReference;
    }

    public final WeakReference<Dialog> getProcessDialogWeakRef() {
        return processDialogWeakRef;
    }

    public final void setProcessDialogWeakRef(WeakReference<Dialog> weakReference) {
        processDialogWeakRef = weakReference;
    }

    public void showCheckDialog(int status) {
        if (status == -2) {
            showNoUpdateDialog();
        } else if (status == -1) {
            showCheckFailureDialog();
        } else {
            if (status != 1) {
                return;
            }
            showUpdateDialog();
        }
    }

    public boolean isShowCheckDialog() {
        WeakReference<Dialog> weakReference;
        Dialog dialog;
        Dialog dialog2;
        WeakReference<Dialog> weakReference2 = updateDialogWeakRef;
        boolean isShowing = (weakReference2 == null || (dialog2 = weakReference2.get()) == null) ? false : dialog2.isShowing();
        return (isShowing || (weakReference = processDialogWeakRef) == null || (dialog = weakReference.get()) == null) ? isShowing : dialog.isShowing();
    }

    private final void showUpdateDialog() {
        Dialog dialog;
        Dialog dialog2;
        Activity currentActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            return;
        }
        WeakReference<Dialog> weakReference = updateDialogWeakRef;
        if (weakReference != null && (dialog2 = weakReference.get()) != null) {
            dialog2.dismiss();
        }
        WeakReference<Dialog> weakReference2 = processDialogWeakRef;
        if (weakReference2 != null && (dialog = weakReference2.get()) != null) {
            dialog.dismiss();
        }
        ManualCheckUpdateDialog manualCheckUpdateDialog = new ManualCheckUpdateDialog(currentActivity);
        manualCheckUpdateDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.update.dialogs.UpdateCheckDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                UpdateCheckDialog.updateDialogWeakRef = null;
            }
        });
        updateDialogWeakRef = new WeakReference<>(manualCheckUpdateDialog);
        manualCheckUpdateDialog.show();
    }

    private final void showNoUpdateDialog() {
        Activity currentActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            return;
        }
        Toast.makeText(currentActivity, C0906R.string.trae_update_already_latest, 0).show();
    }

    private final void showCheckFailureDialog() {
        Activity currentActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            return;
        }
        Toast.makeText(currentActivity, C0906R.string.trae_update_network_error, 0).show();
    }

    public final void showProgressDialog() {
        Activity currentActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            return;
        }
        UpdateProcessDialog updateProcessDialog = new UpdateProcessDialog(currentActivity, true);
        updateProcessDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.update.dialogs.UpdateCheckDialog$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                UpdateCheckDialog.processDialogWeakRef = null;
            }
        });
        processDialogWeakRef = new WeakReference<>(updateProcessDialog);
        updateProcessDialog.show();
    }
}
