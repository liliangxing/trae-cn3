package com.bytedance.ug.sdk.share.api.p008ui;

import android.content.DialogInterface;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IDownloadProgressDialog {
    void dismiss();

    void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener);

    void setProgress(int i);

    void show();
}
