package com.ss.android.download.api.download;

/* loaded from: classes7.dex */
public interface DownloadController {
    int getDowloadChunkCount();

    int getDownloadMode();

    Object getExtraClickOperation();

    int getInterceptFlag();

    int getLinkMode();

    boolean isAddToDownloadManage();

    boolean isEnableBackDialog();

    boolean isEnableMultipleDownload();

    boolean shouldUseNewWebView();
}
