package com.ss.android.article.base.p003ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SSDialog extends Dialog {
    protected Activity mContext;

    public SSDialog(Activity activity) {
        super(activity);
        this.mContext = activity;
    }

    public SSDialog(Activity activity, int i) {
        super(activity, i);
        this.mContext = activity;
    }

    protected SSDialog(Activity activity, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(activity, z, onCancelListener);
        this.mContext = activity;
    }

    public boolean isViewValid() {
        return !this.mContext.isFinishing();
    }

    @Override // android.app.Dialog
    public void show() {
        if (isViewValid()) {
            super.show();
        }
    }
}
