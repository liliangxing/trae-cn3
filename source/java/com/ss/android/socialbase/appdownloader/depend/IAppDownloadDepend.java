package com.ss.android.socialbase.appdownloader.depend;

import android.content.Context;

/* loaded from: classes7.dex */
public interface IAppDownloadDepend {
    boolean getAllowBootReceiver();

    boolean getAllowNetwork(Context context);

    IDownloadAlertDialogBuilder getThemedAlertDlgBuilder(Context context);
}
