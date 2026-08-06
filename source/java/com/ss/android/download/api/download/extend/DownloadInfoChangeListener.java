package com.ss.android.download.api.download.extend;

import com.ss.android.download.api.model.DownloadShortInfo;

/* loaded from: classes7.dex */
public interface DownloadInfoChangeListener {
    void downloadInfoChange(DownloadShortInfo downloadShortInfo, int i, long j, long j2, long j3);

    void setDownloadId(long j);
}
