package com.ss.android.socialbase.downloader.core;

import com.ss.android.socialbase.downloader.exception.BaseException;

/* loaded from: classes7.dex */
public interface IDownloadModuleChain {
    void onDownloadStart();

    void proceed() throws BaseException;
}
