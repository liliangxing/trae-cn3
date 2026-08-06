package com.ss.android.socialbase.downloader.utils;

import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadExtListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadListenerUtils {
    private static final int RECEIVE_TYPE_DATA = 1;
    private static final int RECEIVE_TYPE_HEADER = 2;
    private static final int RECEIVE_TYPE_REQUEST_LOG = 3;
    private static final int RECEIVE_TYPE_SEGMENT_DATA = 4;

    public static void notifyListener(int i, Map<Integer, IDownloadListener> map, boolean z, DownloadInfo downloadInfo, BaseException baseException, ListenerType listenerType, DownloadTask downloadTask) {
        if (!z || map == null) {
            return;
        }
        try {
            if (map.size() <= 0) {
                return;
            }
            for (IDownloadListener iDownloadListener : map.values()) {
                if (i == -7 || i == -4 || i == -3 || i == -2 || i == -1) {
                    ((IDownloadGlobalThrottleService) DownloadServiceManager.getService(IDownloadGlobalThrottleService.class)).end(downloadTask);
                }
                if (iDownloadListener != null) {
                    if (i == 1) {
                        iDownloadListener.onPrepare(downloadInfo);
                    } else if (i == 2) {
                        iDownloadListener.onStart(downloadInfo);
                    } else if (i == 4) {
                        iDownloadListener.onProgress(downloadInfo);
                    } else if (i == 5) {
                        iDownloadListener.onRetry(downloadInfo, baseException);
                    } else if (i == 6) {
                        iDownloadListener.onFirstStart(downloadInfo);
                    } else if (i != 11) {
                        switch (i) {
                            case -7:
                                if (iDownloadListener instanceof AbsDownloadListener) {
                                    ((AbsDownloadListener) iDownloadListener).onIntercept(downloadInfo);
                                    removeCallback(downloadTask, listenerType, iDownloadListener);
                                    break;
                                } else {
                                    break;
                                }
                            case -6:
                                iDownloadListener.onFirstSuccess(downloadInfo);
                                break;
                            case -5:
                            case -2:
                                iDownloadListener.onPause(downloadInfo);
                                removeCallback(downloadTask, listenerType, iDownloadListener);
                                break;
                            case -4:
                                iDownloadListener.onCanceled(downloadInfo);
                                removeCallback(downloadTask, listenerType, iDownloadListener);
                                break;
                            case -3:
                                iDownloadListener.onSuccessed(downloadInfo);
                                removeCallback(downloadTask, listenerType, iDownloadListener);
                                break;
                            case -1:
                                iDownloadListener.onFailed(downloadInfo, baseException);
                                removeCallback(downloadTask, listenerType, iDownloadListener);
                                break;
                        }
                    } else if (iDownloadListener instanceof IDownloadExtListener) {
                        ((IDownloadExtListener) iDownloadListener).onWaitingDownloadCompleteHandler(downloadInfo);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void notifyReceiveData(Map<Integer, IDownloadListener> map, DownloadInfo downloadInfo, byte[] bArr, int i) {
        notifyReceive(1, map, downloadInfo, 0L, bArr, i, null, null);
    }

    public static void notifyReceiveSegmentData(Map<Integer, IDownloadListener> map, DownloadInfo downloadInfo, long j, byte[] bArr, int i) {
        notifyReceive(4, map, downloadInfo, j, bArr, i, null, null);
    }

    public static void notifyReceiveHeader(Map<Integer, IDownloadListener> map, DownloadInfo downloadInfo, List<Pair<String, String>> list) {
        notifyReceive(2, map, downloadInfo, 0L, null, 0, list, null);
    }

    public static void notifyReceiveRequestLog(Map<Integer, IDownloadListener> map, DownloadInfo downloadInfo, String str) {
        notifyReceive(3, map, downloadInfo, 0L, null, 0, null, str);
    }

    private static void notifyReceive(int i, Map<Integer, IDownloadListener> map, DownloadInfo downloadInfo, long j, byte[] bArr, int i2, List<Pair<String, String>> list, String str) {
        if (map != null) {
            try {
                if (map.size() <= 0) {
                    return;
                }
                for (IDownloadListener iDownloadListener : map.values()) {
                    if (iDownloadListener != null && (iDownloadListener instanceof AbsDownloadListener)) {
                        if (i == 1) {
                            ((AbsDownloadListener) iDownloadListener).onReceiveData(downloadInfo, bArr, i2);
                        } else if (i == 2) {
                            ((AbsDownloadListener) iDownloadListener).onReceiveHeader(downloadInfo, list);
                        } else if (i == 3) {
                            ((AbsDownloadListener) iDownloadListener).onReceiveRequestLog(downloadInfo, str);
                        } else if (i == 4) {
                            ((AbsDownloadListener) iDownloadListener).onReceiveSegmentData(downloadInfo, j, bArr, i2);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void notifyCancelListener(DownloadTask downloadTask, DownloadInfo downloadInfo, Map<Integer, IDownloadListener> map, ListenerType listenerType, boolean z) {
        if (z) {
            for (IDownloadListener iDownloadListener : map.values()) {
                if (iDownloadListener != null) {
                    iDownloadListener.onCanceled(downloadInfo);
                    downloadTask.removeCallback(listenerType, iDownloadListener);
                }
            }
            return;
        }
        synchronized (map) {
            for (IDownloadListener iDownloadListener2 : map.values()) {
                if (iDownloadListener2 != null) {
                    iDownloadListener2.onCanceled(downloadInfo);
                    downloadTask.removeCallback(listenerType, iDownloadListener2);
                }
            }
        }
    }

    private static void removeCallback(DownloadTask downloadTask, ListenerType listenerType, IDownloadListener iDownloadListener) {
        if (downloadTask != null) {
            downloadTask.removeCallback(listenerType, iDownloadListener);
        }
    }
}
