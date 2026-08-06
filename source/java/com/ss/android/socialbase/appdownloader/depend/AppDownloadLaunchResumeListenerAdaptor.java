package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppDownloadLaunchResumeListenerAdaptor extends AbsAppDownloadLaunchResumeListener {
    private BaseDownloadListenerAdaptor<IAppDownloadLaunchResumeListener, AbsAppDownloadLaunchResumeListener> mBaseAdapter;

    private AppDownloadLaunchResumeListenerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SingletonInstance {
        private static final AppDownloadLaunchResumeListenerAdaptor INSTANCE = new AppDownloadLaunchResumeListenerAdaptor();

        private SingletonInstance() {
        }
    }

    public static AppDownloadLaunchResumeListenerAdaptor getInstance() {
        return SingletonInstance.INSTANCE;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadLaunchResumeListener
    public void onLaunchResume(List<DownloadInfo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap();
        IAppDownloadLaunchResumeListener defaultListener = this.mBaseAdapter.getDefaultListener();
        ArrayList arrayList = defaultListener != null ? new ArrayList() : null;
        for (DownloadInfo downloadInfo : list) {
            AbsAppDownloadLaunchResumeListener bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
            if (bizListener != null) {
                List list2 = (List) hashMap.get(bizListener);
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(downloadInfo);
                hashMap.put(bizListener, list2);
            } else if (arrayList != null) {
                arrayList.add(downloadInfo);
            }
        }
        if (!hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                ((IAppDownloadLaunchResumeListener) entry.getKey()).onLaunchResume((List) entry.getValue());
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        defaultListener.onLaunchResume(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadLaunchResumeListener
    public void onResumeDownload(DownloadInfo downloadInfo, boolean z) {
        AbsAppDownloadLaunchResumeListener bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
        if (bizListener != null) {
            bizListener.onResumeDownload(downloadInfo, z);
            return;
        }
        IAppDownloadLaunchResumeListener defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            defaultListener.onResumeDownload(downloadInfo, z);
        }
    }

    public IAppDownloadLaunchResumeListener addListener(IAppDownloadLaunchResumeListener iAppDownloadLaunchResumeListener) {
        if (!(iAppDownloadLaunchResumeListener instanceof AbsAppDownloadLaunchResumeListener ? this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IAppDownloadLaunchResumeListener, AbsAppDownloadLaunchResumeListener>) iAppDownloadLaunchResumeListener) : false)) {
            this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IAppDownloadLaunchResumeListener, AbsAppDownloadLaunchResumeListener>) iAppDownloadLaunchResumeListener);
        }
        return this;
    }
}
