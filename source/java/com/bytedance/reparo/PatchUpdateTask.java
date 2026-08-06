package com.bytedance.reparo;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.reparo.core.ReparoPatch;
import com.bytedance.reparo.core.common.utils.DigestUtils;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.exception.PatchDownloadException;
import com.bytedance.reparo.download.PatchDownloader;
import com.bytedance.reparo.model.PatchFetchInfo;
import com.bytedance.reparo.secondary.EventReporter;
import com.bytedance.reparo.secondary.Logger;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PatchUpdateTask implements Runnable {
    private static final String TAG = "PatchUpdateTask";
    private Configuration mConfiguration;
    private PatchFetchInfo mPatchFetchInfo;
    private long startTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PatchUpdateTask(PatchFetchInfo patchFetchInfo, Configuration configuration) {
        this.mPatchFetchInfo = patchFetchInfo;
        this.mConfiguration = configuration;
    }

    @Override // java.lang.Runnable
    public void run() {
        markStart();
        try {
            doRun();
        } catch (Throwable th) {
            Logger.m327e(TAG, "something wrong", th);
        }
    }

    private void doRun() {
        final File downloadCacheFile = getDownloadCacheFile();
        new PatchDownloader().downloadPatch(this.mPatchFetchInfo.getUrl(), downloadCacheFile, new PatchDownloader.DownloadCallback() { // from class: com.bytedance.reparo.PatchUpdateTask.1
            @Override // com.bytedance.reparo.download.PatchDownloader.DownloadCallback
            public void onDownloadSuccess(File file) {
                PatchUpdateTask.this.handleDownloadSuccess(file);
            }

            @Override // com.bytedance.reparo.download.PatchDownloader.DownloadCallback
            public void onDownloadFailed(PatchDownloadException patchDownloadException) {
                PatchUpdateTask.this.handleDownloadFailed(patchDownloadException, downloadCacheFile);
            }
        });
    }

    private void markStart() {
        this.startTime = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDownloadSuccess(File file) {
        if (!TextUtils.equals(this.mPatchFetchInfo.getMd5(), DigestUtils.md5Hex(file))) {
            handleDownloadFailed(new PatchDownloadException("md5 not match, update skipped.", 1), file);
            return;
        }
        Logger.m328i(TAG, "download success, save into " + file.getAbsolutePath());
        EventReporter.reportDownloadPatchSuccess(TAG, this.mPatchFetchInfo, file, this.startTime);
        ReparoPatch.getInstance().update(this.mPatchFetchInfo.convertToUpdateRequest(file));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDownloadFailed(PatchDownloadException patchDownloadException, File file) {
        EventReporter.reportDownloadPatchFailed(TAG, this.mPatchFetchInfo, patchDownloadException, this.startTime);
        Logger.m327e(TAG, "download failed. ", patchDownloadException);
        FileUtils.delete(file);
    }

    private File getDownloadCacheFile() {
        return this.mConfiguration.getDownloadCacheFile(String.valueOf(this.mPatchFetchInfo.getVersionCode()), this.mPatchFetchInfo.getHostAppVersion() + "-" + this.mPatchFetchInfo.getVersionCode() + "-" + System.currentTimeMillis() + "-" + this.mPatchFetchInfo.getMd5() + ".patch");
    }
}
