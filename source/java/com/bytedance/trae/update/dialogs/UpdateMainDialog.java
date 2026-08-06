package com.bytedance.trae.update.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.update.IUpdateMainDialog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdateMainDialog.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;", "Lcom/ss/android/update/IUpdateMainDialog;", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "dialogWeakRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Dialog;", "getDialogWeakRef", "()Ljava/lang/ref/WeakReference;", "setDialogWeakRef", "(Ljava/lang/ref/WeakReference;)V", "processDialogWeakRef", "getProcessDialogWeakRef", "setProcessDialogWeakRef", "isAutoUpdate", "", "autoUpdate", "", "showMainDialog", "showProcessDialog", "isShowMainDialog", "bits-impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UpdateMainDialog implements IUpdateMainDialog {
    public static final UpdateMainDialog INSTANCE = new UpdateMainDialog();
    private static final String TAG = "UpdateMainDialog";
    private static WeakReference<Dialog> dialogWeakRef;
    private static WeakReference<Dialog> processDialogWeakRef;

    public void isAutoUpdate(boolean autoUpdate) {
    }

    private UpdateMainDialog() {
    }

    public final WeakReference<Dialog> getDialogWeakRef() {
        return dialogWeakRef;
    }

    public final void setDialogWeakRef(WeakReference<Dialog> weakReference) {
        dialogWeakRef = weakReference;
    }

    public final WeakReference<Dialog> getProcessDialogWeakRef() {
        return processDialogWeakRef;
    }

    public final void setProcessDialogWeakRef(WeakReference<Dialog> weakReference) {
        processDialogWeakRef = weakReference;
    }

    public void showMainDialog(boolean autoUpdate) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        Dialog dialog4;
        FLogger fLogger = FLogger.INSTANCE;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        StringBuilder append = new StringBuilder("showMainDialog, ").append(autoUpdate).append(", ").append(dialogWeakRef).append(", ");
        WeakReference<Dialog> weakReference = dialogWeakRef;
        Boolean bool = null;
        StringBuilder append2 = append.append((weakReference == null || (dialog4 = weakReference.get()) == null) ? null : Boolean.valueOf(dialog4.isShowing())).append(", ").append(processDialogWeakRef).append(", ");
        WeakReference<Dialog> weakReference2 = processDialogWeakRef;
        if (weakReference2 != null && (dialog3 = weakReference2.get()) != null) {
            bool = Boolean.valueOf(dialog3.isShowing());
        }
        fLogger.mo425d(str, append2.append(bool).toString());
        Activity currentActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            return;
        }
        WeakReference<Dialog> weakReference3 = dialogWeakRef;
        if (weakReference3 != null && (dialog2 = weakReference3.get()) != null) {
            dialog2.dismiss();
        }
        WeakReference<Dialog> weakReference4 = processDialogWeakRef;
        if (weakReference4 != null && (dialog = weakReference4.get()) != null) {
            dialog.dismiss();
        }
        UpdateDialog updateDialog = new UpdateDialog(currentActivity, autoUpdate);
        updateDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.update.dialogs.UpdateMainDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                UpdateMainDialog.dialogWeakRef = null;
            }
        });
        dialogWeakRef = new WeakReference<>(updateDialog);
        updateDialog.show();
    }

    public final void showProcessDialog(boolean autoUpdate) {
        Activity currentActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            return;
        }
        UpdateProcessDialog updateProcessDialog = new UpdateProcessDialog(currentActivity, true);
        updateProcessDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.update.dialogs.UpdateMainDialog$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                UpdateMainDialog.processDialogWeakRef = null;
            }
        });
        processDialogWeakRef = new WeakReference<>(updateProcessDialog);
        updateProcessDialog.show();
    }

    public boolean isShowMainDialog() {
        WeakReference<Dialog> weakReference;
        Dialog dialog;
        Dialog dialog2;
        WeakReference<Dialog> weakReference2 = dialogWeakRef;
        boolean isShowing = (weakReference2 == null || (dialog2 = weakReference2.get()) == null) ? false : dialog2.isShowing();
        return (isShowing || (weakReference = processDialogWeakRef) == null || (dialog = weakReference.get()) == null) ? isShowing : dialog.isShowing();
    }
}
