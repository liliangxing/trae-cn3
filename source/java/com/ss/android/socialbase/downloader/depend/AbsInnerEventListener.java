package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.monitor.InnerEventListener;

/* loaded from: classes7.dex */
public abstract class AbsInnerEventListener extends BaseDownloadListenerAdaptor<InnerEventListener, AbsInnerEventListener> implements InnerEventListener, IBizCallback {
    @Override // com.ss.android.socialbase.downloader.depend.IBizCallback
    public String getMonitorScene() {
        return null;
    }
}
