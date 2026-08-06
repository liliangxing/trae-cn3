package com.ss.mediakit.downloader;

import com.ss.mediakit.medialoader.AVMDLLog;
import com.ss.mediakit.net.AVMDLThreadPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AVMDLDownLoadTask {
    public static final int IsHttpOpen = 0;
    public static final int IsHttpRead = 1;
    public static final int IsInValidStep = -1;
    public static final int IsReponseHeader = 0;
    public static final int IsResponseComplete = 3;
    public static final int IsResponseData = 1;
    public static final int IsResponseDownloadInterruptEnd = 5;
    public static final int IsResponseError = 2;
    public static final int IsResponseInfo = 4;
    private static final String TAG = "AVMDLDownLoadTask";
    private File file;
    FileOutputStream fos;
    private Future mFuture;
    private AVMDLRequest mRequest;
    private AVMDLResponse mResponse;
    private long mHandle = 0;
    private boolean mIsRunning = false;
    private int mStep = -1;
    private Lock mHandleLock = new ReentrantLock();
    private Lock mResonseLock = new ReentrantLock();

    private static native void _notifyLoadInfo(long j, int i, long j2, long j3, String str);

    private static native int _onRecvData(long j, byte[] bArr, int i);

    public int open(long j, Object obj, Object obj2, int i, int i2, int i3) {
        if (j == 0 || obj == null) {
            AVMDLLog.m228e(TAG, "handle zero err");
            return -1;
        }
        AVMDLRequest aVMDLRequest = (AVMDLRequest) obj;
        if (aVMDLRequest.urls == null || aVMDLRequest.urls.length == 0) {
            AVMDLLog.m228e(TAG, "no url err");
            return -2;
        }
        this.mRequest = aVMDLRequest;
        setHandle(j);
        this.mStep = 0;
        this.mIsRunning = true;
        this.mFuture = AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.mediakit.downloader.AVMDLDownLoadTask.1
            @Override // java.lang.Runnable
            public void run() {
                AVMDLLog.m226d(AVMDLDownLoadTask.TAG, new StringBuilder("request start:").append(AVMDLDownLoadTask.this.mRequest.urls[0]).toString() != null ? AVMDLDownLoadTask.this.mRequest.urls[0] : "url is null");
                AVMDLResponse aVMDLResponse = new AVMDLResponse(AVMDLDownLoadTask.this.mRequest, null, null);
                byte[] bArr = new byte[32768];
                while (AVMDLDownLoadTask.this.mIsRunning) {
                    int i4 = AVMDLDownLoadTask.this.mStep;
                    if (i4 == 0) {
                        aVMDLResponse = AVMDLDownLoadTask.this.httOpen(aVMDLResponse.request);
                        if (aVMDLResponse != null && aVMDLResponse.isOpenSuccessful()) {
                            AVMDLDownLoadTask.this.mStep = 1;
                        } else {
                            AVMDLDownLoadTask.this.notifyToNative(2, -777L, 0L, null);
                            AVMDLLog.m226d(AVMDLDownLoadTask.TAG, "request is error http open fail");
                            return;
                        }
                    } else if (i4 != 1) {
                        continue;
                    } else {
                        aVMDLResponse = AVMDLDownLoadTask.this.httpRead(aVMDLResponse, bArr);
                        if (!aVMDLResponse.isReadSuccessful()) {
                            AVMDLLog.m226d(AVMDLDownLoadTask.TAG, "read fail try http open");
                            AVMDLDownLoadTask.this.mStep = 0;
                        } else if (aVMDLResponse.isFinish()) {
                            AVMDLDownLoadTask.this.notifyToNative(3, 0L, aVMDLResponse.contentlength, null);
                            AVMDLLog.m226d(AVMDLDownLoadTask.TAG, "request is finish");
                            return;
                        }
                    }
                }
                AVMDLLog.m226d(AVMDLDownLoadTask.TAG, "request is interrupt end url:" + AVMDLDownLoadTask.this.mRequest.urls[0]);
                AVMDLDownLoadTask.this.notifyToNative(5, 0L, 0L, null);
            }
        });
        return 0;
    }

    public void close() {
        setHandle(0L);
        this.mIsRunning = false;
        cancelResponse();
    }

    private void setHandle(final long j) {
        try {
            this.mHandleLock.lock();
            this.mHandle = j;
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.downloader.AVMDLDownLoadTask$$ExternalSyntheticLambda3
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "set handle:%d", Long.valueOf(j));
                    return format;
                }
            });
        } finally {
            this.mHandleLock.unlock();
        }
    }

    private void cancelResponse() {
        try {
            this.mResonseLock.lock();
            if (this.mResponse != null) {
                AVMDLLog.m226d(TAG, "start cancel response");
                final long currentTimeMillis = System.currentTimeMillis();
                this.mResponse.cancel();
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.downloader.AVMDLDownLoadTask$$ExternalSyntheticLambda2
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "end cancel cost time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return format;
                    }
                });
            }
        } finally {
            this.mResonseLock.unlock();
        }
    }

    private void setResponse(AVMDLResponse aVMDLResponse) {
        this.mResonseLock.lock();
        this.mResponse = aVMDLResponse;
        this.mResonseLock.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AVMDLResponse httOpen(AVMDLRequest aVMDLRequest) {
        AVMDLResponse aVMDLResponse;
        AVMDLLog.m226d(TAG, "start http open, url:" + aVMDLRequest.urls[aVMDLRequest.mCurlUrlIndex] + "object:" + this + "handle:" + this.mHandle);
        int i = aVMDLRequest.mCurlUrlIndex;
        setResponse(null);
        final int i2 = i;
        do {
            if (AVMDLLog.isLogLevelEnabled(1)) {
                final int i3 = aVMDLRequest.mUrlState[i2];
                final int i4 = aVMDLRequest.mUrlErrCount[i2];
                final int i5 = aVMDLRequest.mMaxTryCout;
                final String str = aVMDLRequest.urls[i2];
                final int i6 = i2;
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.downloader.AVMDLDownLoadTask$$ExternalSyntheticLambda0
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        return AVMDLDownLoadTask.lambda$httOpen$2(i6, i3, i4, i5, str);
                    }
                });
            }
            if (aVMDLRequest.mUrlState[i2] == 0 && (aVMDLRequest.mMaxTryCout <= 0 || aVMDLRequest.mUrlErrCount[i2] < aVMDLRequest.mMaxTryCout)) {
                try {
                    aVMDLResponse = AVMDLHttpExcutor.excute(aVMDLRequest, i2);
                } catch (IOException e) {
                    AVMDLLog.m226d(TAG, "io exception:" + e.getLocalizedMessage() + "for url:" + aVMDLRequest.urls[i2]);
                    aVMDLResponse = null;
                }
                if (aVMDLResponse != null && aVMDLResponse.isOpenSuccessful()) {
                    AVMDLLog.m226d(TAG, "http open suc");
                    setResponse(aVMDLResponse);
                    notifyToNative(0, aVMDLResponse.statusCode, aVMDLResponse.contentlength, null);
                    AVMDLLog.m226d(TAG, "end http open");
                    aVMDLResponse.request = aVMDLRequest;
                    return aVMDLResponse;
                }
                int[] iArr = aVMDLRequest.mUrlErrCount;
                iArr[i2] = iArr[i2] + 1;
                if (aVMDLResponse != null && aVMDLResponse.statusCode >= 400 && aVMDLResponse.statusCode < 600) {
                    aVMDLRequest.mUrlState[i2] = 1;
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.downloader.AVMDLDownLoadTask$$ExternalSyntheticLambda1
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "set url state forbidden index:%d", Integer.valueOf(i2));
                            return format;
                        }
                    });
                }
            }
            i2 = (i2 + 1) % aVMDLRequest.urls.length;
        } while (i2 != i);
        AVMDLLog.m226d(TAG, "end http open");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$httOpen$2(int i, int i2, int i3, int i4, String str) {
        return String.format(Locale.US, "http open index:%d state:%d trycount:%d maxTry:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) + " url:" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AVMDLResponse httpRead(AVMDLResponse aVMDLResponse, byte[] bArr) {
        int readData = aVMDLResponse.readData(bArr);
        if (readData > 0) {
            try {
                this.mHandleLock.lock();
                long j = this.mHandle;
                if (j != 0) {
                    _onRecvData(j, bArr, readData);
                }
            } finally {
                this.mHandleLock.unlock();
            }
        }
        return aVMDLResponse;
    }

    public void notifyToNative(final int i, final long j, final long j2, String str) {
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.downloader.AVMDLDownLoadTask$$ExternalSyntheticLambda4
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "notify type:%d code:%d param:%d ", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2));
                return format;
            }
        });
        try {
            this.mHandleLock.lock();
            long j3 = this.mHandle;
            if (j3 != 0) {
                _notifyLoadInfo(j3, i, j, j2, str);
            }
        } finally {
            this.mHandleLock.unlock();
        }
    }
}
