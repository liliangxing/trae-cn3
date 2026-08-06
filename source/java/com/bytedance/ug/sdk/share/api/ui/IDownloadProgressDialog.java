package com.bytedance.ug.sdk.share.api.ui;

import android.content.DialogInterface;

/* loaded from: classes4.dex */
public interface IDownloadProgressDialog {
    void dismiss();

    void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener);

    void setProgress(int i);

    void show();
}
