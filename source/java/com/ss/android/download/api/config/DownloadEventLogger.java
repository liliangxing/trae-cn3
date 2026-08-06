package com.ss.android.download.api.config;

import com.ss.android.download.api.model.DownloadEventModel;

/* loaded from: classes7.dex */
public interface DownloadEventLogger {
    void onEvent(DownloadEventModel downloadEventModel);

    void onV3Event(DownloadEventModel downloadEventModel);
}
