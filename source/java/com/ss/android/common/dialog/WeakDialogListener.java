package com.ss.android.common.dialog;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class WeakDialogListener implements IDialogListener {
    private final WeakReference<IDialogListener> mRef;

    public WeakDialogListener(IDialogListener iDialogListener) {
        this.mRef = new WeakReference<>(iDialogListener);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        IDialogListener iDialogListener = this.mRef.get();
        if (iDialogListener != null) {
            iDialogListener.onShow(dialogInterface);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        IDialogListener iDialogListener = this.mRef.get();
        if (iDialogListener != null) {
            iDialogListener.onDismiss(dialogInterface);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        IDialogListener iDialogListener = this.mRef.get();
        if (iDialogListener != null) {
            iDialogListener.onCancel(dialogInterface);
        }
    }
}
