package com.bytedance.reparo.core;

import android.app.Application;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.exception.PatchInstallException;
import com.bytedance.reparo.core.install.PatchInstaller;
import com.bytedance.reparo.core.load.AsyncLoadResult;
import com.bytedance.reparo.core.parse.AbiHelper;
import com.bytedance.reparo.core.parse.LocalRecord;
import com.bytedance.reparo.core.parse.LocalRecordParser;
import com.bytedance.reparo.core.parse.PatchRecordInfo;
import com.bytedance.reparo.core.patch.DurationMetric;
import com.bytedance.reparo.core.patch.Patch;
import com.bytedance.reparo.core.patch.SoPatch;
import com.bytedance.reparo.core.utils.ExecutorServiceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PatchManager {
    private static final int LOAD_FAKE_REASON_SAME_ISSUE_ID = 2;
    private static final int LOAD_FAKE_REASON_SO = 1;
    private static final String TAG = "PatchManager";
    private static final Object mInstallLock = new Object();
    private static final Object mPatchChangeLock = new Object();
    private AbiHelper mAbiHelper;
    private Application mApplication;
    private PatchConfiguration mConfiguration;
    private String mCurrentHostAppVersion;
    private boolean mIsMainProcess;
    private LocalRecord mLocalRecord;
    private LocalRecordParser mLocalRecordParser;
    private List<OnPatchChangeListener> mOnPatchChangeListeners;
    private Options mOptions;
    private ConcurrentHashMap<PatchRecordInfo, Patch> mPatches = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, UpdateRequest> mUpdateRequest = new ConcurrentHashMap<>();
    private final Set<Patch> offlinePatches = new HashSet();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface OnPatchChangeListener {
        void onChanged(ConcurrentHashMap<PatchRecordInfo, Patch> concurrentHashMap);
    }

    private PatchManager() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PatchManager(Application application, PatchConfiguration patchConfiguration, Options options, AbiHelper abiHelper, String str, boolean z) {
        this.mApplication = application;
        this.mConfiguration = patchConfiguration;
        this.mOptions = options;
        this.mAbiHelper = abiHelper;
        this.mIsMainProcess = z;
        this.mCurrentHostAppVersion = str;
        LocalRecordParser localRecordParser = new LocalRecordParser(patchConfiguration);
        this.mLocalRecordParser = localRecordParser;
        this.mLocalRecord = localRecordParser.read();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        String hostAppVersion = this.mLocalRecord.getHostAppVersion();
        Log.i(TAG, "init in " + (this.mIsMainProcess ? "main" : "sub") + " process, current host app version is " + this.mCurrentHostAppVersion);
        if (!TextUtils.isEmpty(hostAppVersion) && !TextUtils.equals(this.mCurrentHostAppVersion, hostAppVersion)) {
            this.mLocalRecord.setHostAppVersion(this.mCurrentHostAppVersion);
            clearAllPatches(false);
        } else {
            if (TextUtils.isEmpty(this.mLocalRecord.getHostAppVersion())) {
                this.mLocalRecord.setHostAppVersion(this.mCurrentHostAppVersion);
            }
            loadAllPatches(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearAllPatches(boolean z) {
        synchronized (mPatchChangeLock) {
            Object[] objArr = new Object[1];
            objArr[0] = this.mIsMainProcess ? "main" : "sub";
            PatchLogger.m305i(TAG, String.format("clear all patches in %s process.", objArr));
            this.mLocalRecord.getPatchRecordInfoSet().clear();
            keepPatchConsistencyInMemory();
            if (this.mIsMainProcess) {
                storeLocalRecord();
                FileUtils.delete(this.mConfiguration.getInstallRootDir());
                if (z) {
                    notifyPatchChanged();
                }
            }
        }
    }

    public void update(final UpdateRequest updateRequest) {
        if (this.mIsMainProcess) {
            final String configId = updateRequest.getConfigId();
            synchronized (mInstallLock) {
                if (this.mUpdateRequest.containsKey(configId)) {
                    PatchLogger.m305i(TAG, "the patch update request already exist. " + updateRequest.toString());
                    return;
                }
                if (isPatchAlreadyUpdated(updateRequest)) {
                    PatchLogger.m305i(TAG, "the patch already updated." + updateRequest.toString());
                    return;
                }
                this.mUpdateRequest.put(configId, updateRequest);
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                new PatchInstaller(this.mApplication, updateRequest.getPatchFile(), this.mConfiguration.getInstallDir(updateRequest), this.mOptions, this.mAbiHelper, this.mConfiguration).install(new PatchInstaller.PatchInstallListener() { // from class: com.bytedance.reparo.core.PatchManager.1
                    @Override // com.bytedance.reparo.core.install.PatchInstaller.PatchInstallListener
                    public void onInstallSuccess(PatchInstaller.InstallResult installResult) {
                        Patch parse = Patch.parse(updateRequest, installResult, PatchManager.this.mOptions, PatchManager.this.mConfiguration, PatchManager.this.mAbiHelper);
                        PatchEventReporter.reportInstallSuccess(parse, elapsedRealtime);
                        PatchManager.this.saveNewPatch(parse, true);
                        final PatchRecordInfo copy = parse.getRecordInfo().copy();
                        AsyncLoadResult asyncLoadResult = new AsyncLoadResult() { // from class: com.bytedance.reparo.core.PatchManager.1.1
                            @Override // com.bytedance.reparo.core.load.AsyncLoadResult
                            public void onLoadSuccess() {
                                PatchEventReporter.reportUpdateSuccess(copy, elapsedRealtime);
                            }

                            @Override // com.bytedance.reparo.core.load.AsyncLoadResult
                            public void onLoadFailed(PatchException patchException) {
                                PatchEventReporter.reportUpdateFailed(copy, patchException, 1, elapsedRealtime);
                            }
                        };
                        if (parse.getRecordInfo().isHasNonSelfSo()) {
                            PatchManager.this.loadPatchInFake(parse, 1, asyncLoadResult);
                        } else {
                            PatchManager.this.loadPatch(parse, asyncLoadResult);
                        }
                        PatchManager.this.mUpdateRequest.remove(configId);
                    }

                    @Override // com.bytedance.reparo.core.install.PatchInstaller.PatchInstallListener
                    public void onInstallFailed(PatchInstallException patchInstallException) {
                        PatchManager.this.mUpdateRequest.remove(configId);
                        PatchRecordInfo parse = updateRequest.parse();
                        PatchLogger.m304e(PatchManager.TAG, "install patch failed. " + parse.toString(), patchInstallException);
                        PatchEventReporter.reportInstallFailed(parse, patchInstallException, elapsedRealtime);
                        PatchEventReporter.reportUpdateFailed(parse, patchInstallException, 0, elapsedRealtime);
                    }
                });
            }
        }
    }

    private boolean isPatchAlreadyUpdated(UpdateRequest updateRequest) {
        synchronized (mPatchChangeLock) {
            Iterator<PatchRecordInfo> it = this.mPatches.keySet().iterator();
            while (it.hasNext()) {
                if (updateRequest.equals(it.next())) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean hasEverBeenOnlineWithSameIssueId(Patch patch) {
        synchronized (mPatchChangeLock) {
            for (PatchRecordInfo patchRecordInfo : this.mPatches.keySet()) {
                Patch patch2 = this.mPatches.get(patchRecordInfo);
                if (patch2 != null && patch2.isOnline() && TextUtils.equals(patchRecordInfo.getIssueId(), patch.getRecordInfo().getIssueId())) {
                    return true;
                }
            }
            Iterator<Patch> it = this.offlinePatches.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getRecordInfo().getIssueId(), patch.getRecordInfo().getIssueId())) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveNewPatch(Patch patch, boolean z) {
        synchronized (mPatchChangeLock) {
            if (this.mPatches.contains(patch)) {
                return;
            }
            this.mPatches.put(patch.getRecordInfo(), patch);
            this.mLocalRecord.addNewPatchRecord(patch.getRecordInfo());
            storeLocalRecord();
            if (z) {
                notifyPatchChanged();
            }
        }
    }

    private void notifyPatchChanged() {
        List<OnPatchChangeListener> list = this.mOnPatchChangeListeners;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<OnPatchChangeListener> it = this.mOnPatchChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onChanged(this.mPatches);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerOnPatchChangeListener(OnPatchChangeListener onPatchChangeListener) {
        if (this.mOnPatchChangeListeners == null) {
            this.mOnPatchChangeListeners = new ArrayList();
        }
        if (this.mOnPatchChangeListeners.contains(onPatchChangeListener)) {
            return;
        }
        this.mOnPatchChangeListeners.add(onPatchChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregisterOnPatchChangeListener(OnPatchChangeListener onPatchChangeListener) {
        List<OnPatchChangeListener> list = this.mOnPatchChangeListeners;
        if (list == null || !list.contains(onPatchChangeListener)) {
            return;
        }
        this.mOnPatchChangeListeners.remove(onPatchChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPatchInFake(Patch patch, int i, AsyncLoadResult asyncLoadResult) {
        if ((i & 1) != 0) {
            PatchLogger.m305i(TAG, "load in fake " + patch.getRecordInfo().toString() + " : there are so libraries in the patch");
        }
        if ((i & 2) != 0) {
            PatchLogger.m305i(TAG, "load in fake " + patch.getRecordInfo().toString() + " : the patch of the same issueId has been posted online");
        }
        patch.loadSuccess();
        patch.setOnline(true);
        asyncLoadResult.success();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void loadPatch(final Patch patch, AsyncLoadResult asyncLoadResult) {
        if (patch.isOnline()) {
            PatchLogger.m305i(TAG, "already load " + patch.getRecordInfo().toString());
            asyncLoadResult.success();
            return;
        }
        PatchLogger.m305i(TAG, "start load patch " + patch.getRecordInfo().toString());
        if (hasEverBeenOnlineWithSameIssueId(patch)) {
            loadPatchInFake(patch, 2, asyncLoadResult);
            return;
        }
        final PatchRecordInfo copy = patch.getRecordInfo().copy();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final DurationMetric durationMetric = new DurationMetric();
        try {
            patch.load(new AsyncLoadResult(asyncLoadResult) { // from class: com.bytedance.reparo.core.PatchManager.2
                @Override // com.bytedance.reparo.core.load.AsyncLoadResult
                public void onLoadSuccess() {
                    patch.loadSuccess();
                    patch.setOnline(true);
                    if (!copy.equals(patch.getRecordInfo())) {
                        PatchManager.this.storeLocalRecord();
                    }
                    PatchLogger.m305i(PatchManager.TAG, "load patch success" + copy.toString());
                    PatchEventReporter.reportPatchLoadSuccess(copy, elapsedRealtime, durationMetric);
                }

                @Override // com.bytedance.reparo.core.load.AsyncLoadResult
                public void onLoadFailed(PatchException patchException) {
                    PatchLogger.m304e(PatchManager.TAG, "load patch failed " + copy.toString(), patchException);
                    PatchEventReporter.reportPatchLoadFailed(copy, patchException, elapsedRealtime);
                    patch.loadFailed();
                    if (copy.equals(patch.getRecordInfo())) {
                        return;
                    }
                    PatchManager.this.storeLocalRecord();
                }
            }, durationMetric);
        } catch (Throwable th) {
            asyncLoadResult.failed(new PatchException("unknownError", th, 0));
        }
    }

    List<Map.Entry<PatchRecordInfo, Patch>> patchListByPatchId(Collection<Map.Entry<PatchRecordInfo, Patch>> collection) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(collection);
        Collections.sort(arrayList, new Comparator<Map.Entry<PatchRecordInfo, Patch>>() { // from class: com.bytedance.reparo.core.PatchManager.3
            @Override // java.util.Comparator
            public int compare(Map.Entry<PatchRecordInfo, Patch> entry, Map.Entry<PatchRecordInfo, Patch> entry2) {
                return entry2.getKey().getPatchId().compareTo(entry.getKey().getPatchId());
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadAllPatches(boolean z) {
        int i;
        if (z) {
            refreshLocalRecord();
        }
        keepPatchConsistencyInMemory();
        if (!z) {
            Iterator<Map.Entry<PatchRecordInfo, Patch>> it = patchListByPatchId(this.mPatches.entrySet()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SoPatch soPatch = it.next().getValue().soPatch;
                if (soPatch != null && soPatch.hasSelfFixSo()) {
                    WandTrick.reparoSoFile = soPatch.getLibraryDir();
                    break;
                }
            }
        }
        Iterator<Map.Entry<PatchRecordInfo, Patch>> it2 = this.mPatches.entrySet().iterator();
        while (it2.hasNext()) {
            Patch value = it2.next().getValue();
            if (value != null && !value.isOnline()) {
                if (z) {
                    if (value.getRecordInfo().isHasSoLibraries()) {
                        i = 1;
                    } else {
                        i = hasEverBeenOnlineWithSameIssueId(value) ? 2 : 0;
                    }
                    if (i != 0) {
                        loadPatchInFake(value, i, AsyncLoadResult.EMPTY);
                    } else {
                        postLoadTask(value);
                    }
                } else {
                    postLoadTask(value);
                }
            }
        }
    }

    private void keepPatchConsistencyInMemory() {
        synchronized (mPatchChangeLock) {
            Iterator<PatchRecordInfo> it = this.mLocalRecord.getPatchRecordInfoSet().iterator();
            while (it.hasNext()) {
                PatchRecordInfo next = it.next();
                if (!this.mLocalRecord.isPatchRecordInfoLegal(next)) {
                    it.remove();
                    if (this.mIsMainProcess) {
                        FileUtils.delete(next.getInstallDir());
                        storeLocalRecord();
                    }
                }
            }
            Iterator<Map.Entry<PatchRecordInfo, Patch>> it2 = this.mPatches.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<PatchRecordInfo, Patch> next2 = it2.next();
                Patch value = next2.getValue();
                if (value != null) {
                    if (!this.mLocalRecord.getPatchRecordInfoSet().contains(next2.getKey())) {
                        offlinePatch(value);
                        it2.remove();
                    }
                }
            }
            for (PatchRecordInfo patchRecordInfo : this.mLocalRecord.getPatchRecordInfoSet()) {
                if (this.mPatches.get(patchRecordInfo) == null) {
                    this.mPatches.put(patchRecordInfo, Patch.obtain(patchRecordInfo, this.mOptions, this.mConfiguration, this.mAbiHelper));
                }
            }
        }
    }

    private void offlinePatch(Patch patch) {
        PatchLogger.m305i(TAG, "start offline patch " + patch.getRecordInfo().toString());
        patch.offline();
        this.offlinePatches.add(patch);
        patch.setOnline(false);
        if (this.mIsMainProcess) {
            FileUtils.delete(patch.getRecordInfo().getInstallDir());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void storeLocalRecord() {
        if (this.mIsMainProcess) {
            this.mLocalRecord.store(this.mLocalRecordParser);
        }
    }

    private void postLoadTask(final Patch patch) {
        PatchRecordInfo recordInfo = patch.getRecordInfo();
        if (!this.mIsMainProcess && !recordInfo.isSupportSubProcess()) {
            PatchLogger.m305i(TAG, "the patch doesn't support sub process " + recordInfo.toString());
            return;
        }
        boolean isAsyncLoad = recordInfo.isAsyncLoad();
        PatchLogger.m305i(TAG, "postLoadTask, asyncLoad = " + isAsyncLoad);
        if (!isAsyncLoad) {
            loadPatch(patch, AsyncLoadResult.EMPTY);
        } else {
            getExecutorService().execute(new Runnable() { // from class: com.bytedance.reparo.core.PatchManager.4
                @Override // java.lang.Runnable
                public void run() {
                    PatchManager.this.loadPatch(patch, AsyncLoadResult.EMPTY);
                }
            });
        }
    }

    private ExecutorService getExecutorService() {
        return ExecutorServiceUtils.getReparoCoreExecutorService();
    }

    private void refreshLocalRecord() {
        synchronized (mPatchChangeLock) {
            LocalRecord read = this.mLocalRecordParser.read();
            if (!TextUtils.equals(this.mLocalRecord.getHostAppVersion(), read.getHostAppVersion())) {
                this.mLocalRecord.setHostAppVersion(read.getHostAppVersion());
            }
            Set<PatchRecordInfo> patchRecordInfoSet = this.mLocalRecord.getPatchRecordInfoSet();
            Iterator<PatchRecordInfo> it = patchRecordInfoSet.iterator();
            while (it.hasNext()) {
                if (!read.getPatchRecordInfoSet().contains(it.next())) {
                    it.remove();
                }
            }
            patchRecordInfoSet.addAll(read.getPatchRecordInfoSet());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void maybeOfflineSomePatches() {
        synchronized (mPatchChangeLock) {
            boolean z = false;
            for (Map.Entry<PatchRecordInfo, Patch> entry : this.mPatches.entrySet()) {
                Patch value = entry.getValue();
                if (value != null && value.isNeedOffline()) {
                    if (value.soPatch == null) {
                        this.mLocalRecord.getPatchRecordInfoSet().remove(entry.getKey());
                    } else {
                        entry.getKey().makeIllegalNextStart();
                    }
                    z = true;
                }
            }
            if (z) {
                keepPatchConsistencyInMemory();
                storeLocalRecord();
                notifyPatchChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<PatchRecordInfo, Patch> queryLocalPatches() {
        keepPatchConsistencyInMemory();
        return this.mPatches;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class LoadResult {
        boolean isSuccess;
        Throwable throwable;

        private LoadResult(boolean z, Throwable th) {
            this.isSuccess = z;
            this.throwable = th;
        }

        static LoadResult obtainSuccess() {
            return new LoadResult(true, null);
        }

        static LoadResult obtainFailed(Throwable th) {
            return new LoadResult(false, th);
        }
    }
}
