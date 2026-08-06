package com.ss.android.socialbase.downloader.depend;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.IBizCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class BaseDownloadListenerAdaptor<D, A extends IBizCallback> {
    private Map<String, A> mBizListener = new ConcurrentHashMap();
    private D mDefaultListener;

    public A getBizListener(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.mBizListener.isEmpty()) {
            return null;
        }
        return getBizListener(downloadInfo.getMonitorScene());
    }

    public A getBizListener(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mBizListener.get(str);
    }

    public boolean addListener(A a) {
        String monitorScene = a.getMonitorScene();
        if (TextUtils.isEmpty(monitorScene)) {
            return false;
        }
        this.mBizListener.put(monitorScene, a);
        return true;
    }

    public void addListener(D d) {
        this.mDefaultListener = d;
    }

    public D getDefaultListener() {
        return this.mDefaultListener;
    }
}
