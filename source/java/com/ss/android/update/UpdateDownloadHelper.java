package com.ss.android.update;

import android.content.Context;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.AppTaskBuilder;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateDownloadHelper {
    private static final String TAG = "UpdateDownloadHelper";
    private boolean isPreDownload;
    private volatile boolean mCanceled;
    private final Context mContext;
    private DownloadExtraInfo mExtraInfo = null;
    private int mId;
    private WeakReference<IUpdateDownloadListener> mListenerRef;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateDownloadHelper(Context context) {
        this.mContext = context;
    }

    public void cancel() {
        this.mCanceled = true;
        this.mExtraInfo = null;
        Downloader.getInstance(this.mContext).cancel(this.mId);
    }

    public DownloadExtraInfo getExtraInfo() {
        return this.mExtraInfo;
    }

    public void setExtraInfo(DownloadExtraInfo downloadExtraInfo) {
        this.mExtraInfo = downloadExtraInfo;
    }

    public void resetExtraInfo() {
        this.mExtraInfo = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void downloadFile(final String str, String str2, String str3, final boolean z, final int i, IUpdateDownloadListener iUpdateDownloadListener, DownloadExtraInfo downloadExtraInfo) {
        this.isPreDownload = z;
        this.mCanceled = false;
        this.mListenerRef = new WeakReference<>(iUpdateDownloadListener);
        if (downloadExtraInfo == null) {
            downloadExtraInfo = DownloadExtraInfo.makeDefault();
        }
        this.mExtraInfo = downloadExtraInfo;
        AppTaskBuilder mainThreadListener = new AppTaskBuilder(this.mContext, str).saveName(str2).savePath(str3).taskKey(str + Constants.COLON_SEPARATOR + str3 + Constants.COLON_SEPARATOR + str2).needWifi(false).showNotification(false).needReuseFirstConnection(true).needDefaultHttpServiceBackUp(true).ignoreInterceptor(true).mainThreadListener(new IDownloadListener() { // from class: com.ss.android.update.UpdateDownloadHelper.1
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPrepare(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                IUpdateDownloadListener iUpdateDownloadListener2 = (IUpdateDownloadListener) UpdateDownloadHelper.this.mListenerRef.get();
                if (downloadInfo != null && iUpdateDownloadListener2 != null) {
                    if (com.bytedance.common.utility.Logger.debug()) {
                        com.bytedance.common.utility.Logger.d(UpdateDownloadHelper.TAG, "onPrepare " + downloadInfo.getTotalBytes() + " " + z);
                    }
                    iUpdateDownloadListener2.saveDownloadInfo((int) downloadInfo.getTotalBytes(), "", z);
                    iUpdateDownloadListener2.onPrepare(z);
                }
                UpdateEventUtils.downloadEvent(str, i, z, "prepare", "");
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                if (com.bytedance.common.utility.Logger.debug()) {
                    com.bytedance.common.utility.Logger.d(UpdateDownloadHelper.TAG, "onStart ");
                }
                UpdateEventUtils.downloadEvent(str, i, z, "start", "");
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onProgress(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                IUpdateDownloadListener iUpdateDownloadListener2 = (IUpdateDownloadListener) UpdateDownloadHelper.this.mListenerRef.get();
                if (downloadInfo == null || iUpdateDownloadListener2 == null) {
                    return;
                }
                if (com.bytedance.common.utility.Logger.debug()) {
                    com.bytedance.common.utility.Logger.d(UpdateDownloadHelper.TAG, "onProgress " + downloadInfo.getCurBytes() + " " + downloadInfo.getTotalBytes());
                }
                iUpdateDownloadListener2.updateProgress((int) downloadInfo.getCurBytes(), (int) downloadInfo.getTotalBytes(), z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPause(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                if (com.bytedance.common.utility.Logger.debug()) {
                    com.bytedance.common.utility.Logger.d(UpdateDownloadHelper.TAG, "onPause ");
                }
                IUpdateDownloadListener iUpdateDownloadListener2 = (IUpdateDownloadListener) UpdateDownloadHelper.this.mListenerRef.get();
                if (iUpdateDownloadListener2 != null) {
                    iUpdateDownloadListener2.downloadResult(false, z);
                }
                UpdateEventUtils.downloadEvent(str, i, z, "pause", "");
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onSuccessed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                if (com.bytedance.common.utility.Logger.debug()) {
                    com.bytedance.common.utility.Logger.d(UpdateDownloadHelper.TAG, "onSuccessed ");
                }
                IUpdateDownloadListener iUpdateDownloadListener2 = (IUpdateDownloadListener) UpdateDownloadHelper.this.mListenerRef.get();
                if (iUpdateDownloadListener2 != null) {
                    iUpdateDownloadListener2.updateProgress((int) downloadInfo.getCurBytes(), (int) downloadInfo.getTotalBytes(), z);
                    iUpdateDownloadListener2.downloadResult(true, z);
                }
                UpdateEventUtils.downloadResultEvent("");
                UpdateEventUtils.downloadEvent(str, i, z, "success", "");
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFailed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, BaseException baseException) {
                if (com.bytedance.common.utility.Logger.debug()) {
                    com.bytedance.common.utility.Logger.d(UpdateDownloadHelper.TAG, "onFailed ");
                }
                IUpdateDownloadListener iUpdateDownloadListener2 = (IUpdateDownloadListener) UpdateDownloadHelper.this.mListenerRef.get();
                if (iUpdateDownloadListener2 != null) {
                    iUpdateDownloadListener2.downloadResult(false, z);
                }
                String str4 = baseException != null ? "download fail: " + baseException.getErrorMessage() : "download fail: ";
                UpdateEventUtils.downloadResultEvent(str4);
                UpdateEventUtils.downloadEvent(str, i, z, "fail", str4);
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onCanceled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                if (com.bytedance.common.utility.Logger.debug()) {
                    com.bytedance.common.utility.Logger.d(UpdateDownloadHelper.TAG, "onCanceled ");
                }
                IUpdateDownloadListener iUpdateDownloadListener2 = (IUpdateDownloadListener) UpdateDownloadHelper.this.mListenerRef.get();
                if (iUpdateDownloadListener2 != null) {
                    iUpdateDownloadListener2.downloadResult(false, z);
                }
                UpdateEventUtils.downloadEvent(str, i, z, "cancel", "");
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                if (com.bytedance.common.utility.Logger.debug()) {
                    com.bytedance.common.utility.Logger.d(UpdateDownloadHelper.TAG, "onFirstStart ");
                }
                UpdateEventUtils.downloadEvent(str, i, z, "first_start", "");
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                if (com.bytedance.common.utility.Logger.debug()) {
                    com.bytedance.common.utility.Logger.d(UpdateDownloadHelper.TAG, "onFirstSuccess ");
                }
                UpdateEventUtils.downloadEvent(str, i, z, "first_success", "");
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetry(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, BaseException baseException) {
                if (com.bytedance.common.utility.Logger.debug()) {
                    com.bytedance.common.utility.Logger.d(UpdateDownloadHelper.TAG, "onRetry ");
                }
                UpdateEventUtils.downloadEvent(str, i, z, "retry", baseException != null ? "download retry: " + baseException.getErrorMessage() : "download retry: ");
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetryDelay(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, BaseException baseException) {
                if (com.bytedance.common.utility.Logger.debug()) {
                    com.bytedance.common.utility.Logger.d(UpdateDownloadHelper.TAG, "onRetryDelay ");
                }
                UpdateEventUtils.downloadEvent(str, i, z, "retry_delay", baseException != null ? "download retry delay: " + baseException.getErrorMessage() : "download retry delay: ");
            }
        });
        DownloadExtraInfo downloadExtraInfo2 = this.mExtraInfo;
        if (downloadExtraInfo2 != null && downloadExtraInfo2.isAlphaUpdateBgDownload) {
            mainThreadListener.retryCount(3);
        }
        int addDownloadTask = AppDownloader.getInstance().addDownloadTask(mainThreadListener);
        this.mId = addDownloadTask;
        if (addDownloadTask == 0) {
            IUpdateDownloadListener iUpdateDownloadListener2 = this.mListenerRef.get();
            if (iUpdateDownloadListener2 != null) {
                iUpdateDownloadListener2.downloadResult(false, z);
            }
            UpdateEventUtils.downloadResultEvent("does not support, mid == 0");
            UpdateEventUtils.downloadEvent(str, i, z, "unSupport", "mid == 0");
        }
        if (com.bytedance.common.utility.Logger.debug()) {
            com.bytedance.common.utility.Logger.d(TAG, "id " + this.mId);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCanceled() {
        return this.mCanceled;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DownloadExtraInfo {
        public boolean isAlphaUpdateBgDownload = false;

        public static DownloadExtraInfo makeDefault() {
            return new DownloadExtraInfo();
        }
    }
}
