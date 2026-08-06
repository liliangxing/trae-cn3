package com.ss.android.download.api.config;

import android.app.Activity;
import android.content.Context;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;

/* loaded from: classes7.dex */
public interface DownloadActionListener {
    void onItemClick(Activity activity, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig);

    void onItemStart(Context context, DownloadModel downloadModel, DownloadController downloadController);

    void onOpenApp(Context context, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig, String str);
}
