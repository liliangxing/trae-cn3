package com.bytedance.reparo;

import android.app.Application;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.reparo.RemotePatchFetcher;
import com.bytedance.reparo.constant.Constant;
import com.bytedance.reparo.core.Options;
import com.bytedance.reparo.core.PatchManager;
import com.bytedance.reparo.core.ReparoPatch;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.common.utils.ProcessUtils;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.parse.PatchRecordInfo;
import com.bytedance.reparo.core.patch.Patch;
import com.bytedance.reparo.core.utils.CollectionUtils;
import com.bytedance.reparo.model.PatchFetchInfo;
import com.bytedance.reparo.provider.PatchChangeObserver;
import com.bytedance.reparo.provider.ReparoProvider;
import com.bytedance.reparo.secondary.EventReporter;
import com.bytedance.reparo.secondary.Logger;
import com.bytedance.reparo.secondary.MonitorConfig;
import com.bytedance.reparo.util.SimpleThreadFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PatchUpdateManager implements PatchManager.OnPatchChangeListener {
    private static final String TAG = "PatchManager";
    private static volatile PatchUpdateManager sInstance;
    private String currentAppVersionCode;
    private Application mApplication;
    private Configuration mConfiguration;
    private ScheduledExecutorService mExecutorService;
    private boolean mHasInited = false;
    private boolean mIsMainProcess;
    private RemotePatchFetcher mRemotePatchFetcher;

    private PatchUpdateManager() {
    }

    public static PatchUpdateManager getInstance() {
        if (sInstance == null) {
            synchronized (PatchUpdateManager.class) {
                if (sInstance == null) {
                    sInstance = new PatchUpdateManager();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void init(Application application, IReparoConfig iReparoConfig, boolean z, String str, Options options) {
        if (this.mHasInited) {
            return;
        }
        this.mIsMainProcess = z;
        this.mApplication = application;
        this.currentAppVersionCode = str;
        this.mConfiguration = new Configuration(this.mApplication);
        ReparoPatch reparoPatch = ReparoPatch.getInstance();
        Application application2 = this.mApplication;
        reparoPatch.init(application2, options, str, iReparoConfig.getAbiHelper(application2), z, false, MonitorConfig.getInstance().enableNewAndroid());
        ReparoPatch.getInstance().registerOnPatchChangeListener(this);
        this.mRemotePatchFetcher = new RemotePatchFetcher(this.mApplication, iReparoConfig, "0.0.4-rc.50");
        if (!z) {
            registerObserverForSubProcess();
        }
        this.mHasInited = true;
    }

    private void registerObserverForSubProcess() {
        if (this.mIsMainProcess) {
            return;
        }
        try {
            this.mApplication.getContentResolver().registerContentObserver(Constant.getAuthoritiesUri(this.mApplication), true, new PatchChangeObserver(null));
        } catch (Exception unused) {
            Logger.m326e(TAG, "registerContentObserver failed, current process name: " + ProcessUtils.getCurrentProcessName(this.mApplication));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void update() {
        if (this.mHasInited && this.mIsMainProcess) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                getExecutorService().execute(new Runnable() { // from class: com.bytedance.reparo.PatchUpdateManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PatchUpdateManager.this.updateInternal();
                    }
                });
            } else {
                updateInternal();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInternal() {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mRemotePatchFetcher.queryRemotePatchInfo(new RemotePatchFetcher.RemoteQueryCallback() { // from class: com.bytedance.reparo.PatchUpdateManager.2
            @Override // com.bytedance.reparo.RemotePatchFetcher.RemoteQueryCallback
            public void onSuccess(List<PatchFetchInfo> list) {
                PatchUpdateManager.this.onQuerySuccess(list, elapsedRealtime);
            }

            @Override // com.bytedance.reparo.RemotePatchFetcher.RemoteQueryCallback
            public void onFailed(PatchException patchException) {
                if (patchException instanceof RemotePatchFetcher.ResponseNullException) {
                    Logger.m326e(PatchUpdateManager.TAG, "query remote patch info failed: " + patchException.getMessage());
                } else {
                    Logger.m327e(PatchUpdateManager.TAG, "query remote patch info failed", patchException);
                }
                EventReporter.reportQueryRemotePatchFailed(PatchUpdateManager.TAG, patchException, elapsedRealtime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onQuerySuccess(List<PatchFetchInfo> list, long j) {
        String collectionUtils = CollectionUtils.toString(list);
        Logger.m328i(TAG, "query remote patch info success. " + collectionUtils);
        EventReporter.reportQueryRemotePatchSuccess(TAG, collectionUtils, j);
        maybeOfflineSomePatches(list);
        List<PatchFetchInfo> needUpdatePatchList = getNeedUpdatePatchList(list);
        Logger.m328i(TAG, "need update patch list: " + CollectionUtils.toString(needUpdatePatchList));
        if (needUpdatePatchList.size() > 0) {
            Iterator<PatchFetchInfo> it = needUpdatePatchList.iterator();
            while (it.hasNext()) {
                getExecutorService().execute(new PatchUpdateTask(it.next(), this.mConfiguration));
            }
        } else {
            Logger.m328i(TAG, "there is no new patch in server");
        }
    }

    private List<PatchFetchInfo> getNeedUpdatePatchList(List<PatchFetchInfo> list) {
        ArrayList arrayList = new ArrayList();
        Map<PatchRecordInfo, Patch> queryLocalPatches = ReparoPatch.getInstance().queryLocalPatches();
        for (PatchFetchInfo patchFetchInfo : list) {
            if (isPatchLegal(patchFetchInfo)) {
                Set<PatchRecordInfo> keySet = queryLocalPatches.keySet();
                if (queryLocalPatches.size() == 0) {
                    arrayList.add(patchFetchInfo);
                } else {
                    Iterator<PatchRecordInfo> it = keySet.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        if (patchFetchInfo.equals(it.next())) {
                            z = true;
                        }
                    }
                    if (!z) {
                        arrayList.add(patchFetchInfo);
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean isPatchLegal(PatchFetchInfo patchFetchInfo) {
        return (!TextUtils.equals(this.currentAppVersionCode, patchFetchInfo.getHostAppVersion()) || TextUtils.isEmpty(patchFetchInfo.getMd5()) || TextUtils.isEmpty(patchFetchInfo.getUrl())) ? false : true;
    }

    private void maybeOfflineSomePatches(List<PatchFetchInfo> list) {
        for (Map.Entry<PatchRecordInfo, Patch> entry : ReparoPatch.getInstance().queryLocalPatches().entrySet()) {
            PatchRecordInfo key = entry.getKey();
            Patch value = entry.getValue();
            Iterator<PatchFetchInfo> it = list.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (it.next().equals(key)) {
                    z = true;
                }
            }
            if (!z) {
                value.needOffline();
            }
        }
        ReparoPatch.getInstance().maybeOfflineSomePatches();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScheduledExecutorService getExecutorService() {
        if (this.mExecutorService == null) {
            this.mExecutorService = Executors.newScheduledThreadPool(1, new SimpleThreadFactory("reparo"));
        }
        return this.mExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasInited() {
        return this.mHasInited;
    }

    public void updatePatchStatusForSubProcess() {
        if (this.mIsMainProcess) {
            return;
        }
        ReparoPatch.getInstance().updatePatchLoadStatus();
    }

    @Override // com.bytedance.reparo.core.PatchManager.OnPatchChangeListener
    public void onChanged(ConcurrentHashMap<PatchRecordInfo, Patch> concurrentHashMap) {
        Object[] objArr = new Object[1];
        objArr[0] = this.mIsMainProcess ? "main" : "sub";
        Logger.m328i(TAG, String.format("patch changed in %s process", objArr));
        if (this.mIsMainProcess) {
            ReparoProvider.notifySubProcess(this.mApplication);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearPatches() {
        if (this.mHasInited) {
            FileUtils.delete(this.mConfiguration.getCacheRootDir());
            ReparoPatch.getInstance().clearAllPatches();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateFromLocal(PatchFetchInfo patchFetchInfo, File file) {
        if (this.mHasInited) {
            ReparoPatch.getInstance().update(patchFetchInfo.convertToUpdateRequest(file));
        }
    }
}
