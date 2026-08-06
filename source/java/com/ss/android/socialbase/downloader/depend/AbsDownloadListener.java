package com.ss.android.socialbase.downloader.depend;

import android.util.Pair;
import com.lynx.tasm.gesture.handler.GestureConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsDownloadListener implements IDownloadListener {
    private static final String TAG = "AbsDownloadListener";

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        Logger.taskDebug(TAG, downloadInfo, "onPrepare", "Name: " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        Logger.taskDebug(TAG, downloadInfo, GestureConstants.ON_START, "Name: " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null || downloadInfo.getTotalBytes() == 0) {
            return;
        }
        Logger.taskDebug(TAG, downloadInfo.getId(), "onProgress", String.format("Name: %s %.2f%%", downloadInfo.getName(), Float.valueOf((((float) downloadInfo.getCurBytes()) / ((float) downloadInfo.getTotalBytes())) * 100.0f)));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        Logger.taskDebug(TAG, downloadInfo, "onPause", "Name: " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        Logger.taskDebug(TAG, downloadInfo, "onSuccessed", "Name: " + downloadInfo.getName() + " " + downloadInfo.isSuccessByCache());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        Logger.taskDebug(str, downloadInfo, "onFailed", String.format("Name: %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        Logger.taskDebug(TAG, downloadInfo, "onCanceled", "Name: " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        Logger.taskDebug(TAG, downloadInfo, "onFirstStart", "Name: " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        Logger.taskDebug(TAG, downloadInfo, "onFirstSuccess", "Name: " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        Logger.taskDebug(str, downloadInfo, "onRetry", String.format("Name: %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        Logger.taskDebug(str, downloadInfo, "onRetryDelay", String.format("Name: %s because of : %s", objArr));
    }

    public void onIntercept(DownloadInfo downloadInfo) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        Logger.taskDebug(TAG, downloadInfo, "onIntercept", "Name: " + downloadInfo.getName());
    }

    public void onReceiveData(DownloadInfo downloadInfo, byte[] bArr, int i) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        Logger.taskDebug(TAG, downloadInfo, "onReceiveData", "Name: " + downloadInfo.getName() + " data len:" + i);
    }

    public void onReceiveSegmentData(DownloadInfo downloadInfo, long j, byte[] bArr, int i) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        Logger.taskDebug(TAG, downloadInfo, "onReceiveSegmentData", "Name: " + downloadInfo.getName() + "offset:" + j + " data len:" + i);
    }

    public void onReceiveHeader(DownloadInfo downloadInfo, List<Pair<String, String>> list) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        Logger.taskDebug(TAG, downloadInfo, "onReceiveHeader", "Name: " + downloadInfo.getName() + " header:" + list);
    }

    public void onReceiveRequestLog(DownloadInfo downloadInfo, String str) {
        if (!Logger.debugScene(downloadInfo) || downloadInfo == null) {
            return;
        }
        Logger.taskDebug(TAG, downloadInfo, "onReceiveRequestLog", "Name: " + downloadInfo.getName() + " requestLog:" + str);
    }
}
