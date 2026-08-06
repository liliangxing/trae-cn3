package com.ss.android.download.api.config;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes7.dex */
public interface DownloadPermissionChecker {
    void checkPermission(Activity activity, String[] strArr, IPermissionCallback iPermissionCallback);

    boolean hasPermission(Context context, String str);
}
