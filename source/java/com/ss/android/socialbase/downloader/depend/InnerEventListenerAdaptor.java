package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class InnerEventListenerAdaptor extends AbsInnerEventListener {
    private BaseDownloadListenerAdaptor<InnerEventListener, AbsInnerEventListener> mBaseAdapter;

    private InnerEventListenerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor<>();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class SingletonInstance {
        private static final InnerEventListenerAdaptor INSTANCE = new InnerEventListenerAdaptor();

        private SingletonInstance() {
        }
    }

    public static InnerEventListenerAdaptor getInstance() {
        return SingletonInstance.INSTANCE;
    }

    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onUnityEvent(int i, String str, JSONObject jSONObject) {
        AbsInnerEventListener bizListener = this.mBaseAdapter.getBizListener(Downloader.getInstance(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()).getDownloadInfo(i));
        if (bizListener != null) {
            bizListener.onUnityEvent(i, str, jSONObject);
            return;
        }
        InnerEventListener defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            defaultListener.onUnityEvent(i, str, jSONObject);
        }
    }

    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onEvent(int i, String str, JSONObject jSONObject) {
        AbsInnerEventListener bizListener = this.mBaseAdapter.getBizListener(Downloader.getInstance(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()).getDownloadInfo(i));
        if (bizListener != null) {
            bizListener.onEvent(i, str, jSONObject);
            return;
        }
        InnerEventListener defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            defaultListener.onEvent(i, str, jSONObject);
        }
    }

    public InnerEventListener addEventListener(InnerEventListener innerEventListener) {
        if (!(innerEventListener instanceof AbsInnerEventListener ? this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<InnerEventListener, AbsInnerEventListener>) innerEventListener) : false)) {
            this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<InnerEventListener, AbsInnerEventListener>) innerEventListener);
        }
        return this;
    }
}
