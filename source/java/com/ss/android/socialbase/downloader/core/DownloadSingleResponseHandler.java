package com.ss.android.socialbase.downloader.core;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckWifiTaskValidModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.NetworkRetryStrategy;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.throttle.SmartThrottleInputStream;
import com.ss.android.socialbase.downloader.network.throttle.ThrottleInputStream;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadFileRandomAccess;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadSingleResponseHandler {
    private static final int MIN_CACHE_TIME_MS = 1000;
    private static String TAG = "DownloadSingleResponseHandler";
    private IDownloadRunnableCallback mCallback;
    private volatile boolean mCanceled;
    private long mCurOffset;
    private IDownloadCache mDownloadCache;
    private long mDownloadChunkContentLen;
    private DownloadInfo mDownloadInfo;
    private IDownloadHttpConnection mHttpConnection;
    private boolean mIsFirstRead = true;
    private volatile boolean mNeedUpdateThrottleNetSpeed;
    private NetworkRetryStrategy mNetworkRetryStrategy;
    private volatile boolean mPaused;
    private DownloadSetting mSetting;

    public DownloadSingleResponseHandler(DownloadCommonParams downloadCommonParams, IDownloadHttpConnection iDownloadHttpConnection, long j, long j2, IDownloadRunnableCallback iDownloadRunnableCallback) {
        this.mDownloadInfo = downloadCommonParams.mDownloadInfo;
        this.mDownloadCache = downloadCommonParams.mDownloadCache;
        this.mNetworkRetryStrategy = downloadCommonParams.mRetryStrategy;
        this.mSetting = downloadCommonParams.mSetting;
        this.mHttpConnection = iDownloadHttpConnection;
        this.mCurOffset = j;
        this.mDownloadChunkContentLen = j2;
        this.mCallback = iDownloadRunnableCallback;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(8:(8:155|156|157|158|159|160|161|(14:163|(1:165)|166|167|(2:169|(1:174))|178|179|180|181|(1:183)|184|(4:186|(3:217|218|(1:220))|188|189)(1:254)|(2:191|(1:196))(1:216)|214))(1:273)|180|181|(0)|184|(0)(0)|(0)(0)|214)|264|166|167|(0)|178|179) */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x018c, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(1051, "Fail to verify data");
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0249, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0247, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x04b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0168 A[Catch: all -> 0x0247, BaseException -> 0x0249, TryCatch #31 {BaseException -> 0x0249, all -> 0x0247, blocks: (B:167:0x0164, B:169:0x0168, B:171:0x017c, B:175:0x0183, B:176:0x018c, B:178:0x018d, B:191:0x01dd, B:193:0x01e5), top: B:166:0x0164 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x01a1 A[Catch: all -> 0x0242, BaseException -> 0x0244, TryCatch #30 {BaseException -> 0x0244, all -> 0x0242, blocks: (B:181:0x0199, B:183:0x01a1, B:184:0x01a6, B:186:0x01b2), top: B:180:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x01b2 A[Catch: all -> 0x0242, BaseException -> 0x0244, TRY_LEAVE, TryCatch #30 {BaseException -> 0x0244, all -> 0x0242, blocks: (B:181:0x0199, B:183:0x01a1, B:184:0x01a6, B:186:0x01b2), top: B:180:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x01dd A[Catch: all -> 0x0247, BaseException -> 0x0249, TRY_ENTER, TryCatch #31 {BaseException -> 0x0249, all -> 0x0247, blocks: (B:167:0x0164, B:169:0x0168, B:171:0x017c, B:175:0x0183, B:176:0x018c, B:178:0x018d, B:191:0x01dd, B:193:0x01e5), top: B:166:0x0164 }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0238 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x04ad A[Catch: all -> 0x04ae, TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x04ae, blocks: (B:226:0x0430, B:248:0x04ad), top: B:225:0x0430 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0356 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleResponse() throws BaseException {
        int i;
        byte[] bArr;
        String str;
        String str2;
        long j;
        long j2;
        AbsDownloadHttpConnection absDownloadHttpConnection;
        int i2;
        InputStream inputStream;
        RandomAccessOutputStream randomAccessOutputStream;
        String str3;
        String str4;
        int i3;
        InputStream inputStream2;
        String str5;
        IDownloadRunnableCallback iDownloadRunnableCallback;
        long uptimeMillis;
        long j3;
        String str6 = " isFirstRead:";
        String str7 = "Exception:";
        long contentLength = DownloadUtils.getContentLength(this.mHttpConnection);
        if (contentLength == 0) {
            this.mHttpConnection.end();
            throw new DownloadRetryNeedlessException(1004, "the content-length is 0");
        }
        long j4 = this.mCurOffset;
        if (this.mDownloadInfo.getVerifyCurBytes() > 0) {
            i = (int) (this.mDownloadInfo.getVerifyCurBytes() - this.mDownloadInfo.getCurBytes());
            bArr = readVerifyData(i);
        } else {
            i = 0;
            bArr = null;
        }
        IDownloadHttpConnection iDownloadHttpConnection = this.mHttpConnection;
        AbsDownloadHttpConnection absDownloadHttpConnection2 = iDownloadHttpConnection instanceof AbsDownloadHttpConnection ? (AbsDownloadHttpConnection) iDownloadHttpConnection : null;
        try {
            DownloadInfo downloadInfo = this.mDownloadInfo;
            RandomAccessOutputStream createOutputStream = DownloadHelper.createOutputStream(downloadInfo, downloadInfo.getTempPath(), this.mDownloadInfo.getTempName(), -1, true);
            try {
                try {
                    if (this.mDownloadInfo.isFastDownload()) {
                        j2 = j4;
                    } else {
                        j2 = j4;
                        try {
                            createOutputStream.seek(this.mCurOffset - this.mDownloadInfo.getStartOffset());
                        } catch (IOException e) {
                            e = e;
                            str = " isFirstRead:";
                            str2 = "Exception:";
                            j = contentLength;
                            absDownloadHttpConnection = absDownloadHttpConnection2;
                            try {
                                throw new BaseException(1054, e);
                            } catch (BaseException e2) {
                                e = e2;
                                randomAccessOutputStream = createOutputStream;
                                str3 = str;
                                str4 = str2;
                                absDownloadHttpConnection2 = absDownloadHttpConnection;
                                i3 = 0;
                                inputStream2 = null;
                                try {
                                    Logger.taskError(TAG, this.mDownloadInfo.getId(), "handleResponse", str4 + e.toString() + str3 + this.mIsFirstRead);
                                    if (!isStoppedStatus()) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    i2 = i3;
                                    inputStream = inputStream2;
                                    if (i2 > 0) {
                                    }
                                    if (randomAccessOutputStream != null) {
                                        updateDB();
                                    }
                                    this.mHttpConnection.end();
                                    DownloadUtils.safeClose(inputStream);
                                    DownloadUtils.safeClose(randomAccessOutputStream);
                                    if (absDownloadHttpConnection2 != null) {
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                randomAccessOutputStream = createOutputStream;
                                i2 = 0;
                                inputStream = null;
                                try {
                                    Logger.taskError(TAG, this.mDownloadInfo.getId(), "handleResponse", str2 + th.toString() + str + this.mIsFirstRead);
                                    if (absDownloadHttpConnection != null) {
                                    }
                                    if (isStoppedStatus()) {
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    absDownloadHttpConnection2 = absDownloadHttpConnection;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            str = " isFirstRead:";
                            str2 = "Exception:";
                            j = contentLength;
                            randomAccessOutputStream = createOutputStream;
                            absDownloadHttpConnection = absDownloadHttpConnection2;
                            i2 = 0;
                            inputStream = null;
                            Logger.taskError(TAG, this.mDownloadInfo.getId(), "handleResponse", str2 + th.toString() + str + this.mIsFirstRead);
                            if (absDownloadHttpConnection != null) {
                            }
                            if (isStoppedStatus()) {
                            }
                        }
                    }
                    try {
                        inputStream = this.mHttpConnection.getInputStream();
                        try {
                            try {
                                this.mDownloadInfo.updateRealStartDownloadTime();
                                boolean isIgnoreDataVerify = this.mDownloadInfo.isIgnoreDataVerify();
                                if (this.mDownloadInfo.getOpenLimitSpeed() && absDownloadHttpConnection2 != null) {
                                    try {
                                        absDownloadHttpConnection2.setThrottleNetSpeedWhenRunning(DownloadConstants.LIMIT_SPEED_EVERTS_ECOND);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        str = " isFirstRead:";
                                        str2 = "Exception:";
                                        j = contentLength;
                                        randomAccessOutputStream = createOutputStream;
                                        absDownloadHttpConnection = absDownloadHttpConnection2;
                                        i2 = 0;
                                        Logger.taskError(TAG, this.mDownloadInfo.getId(), "handleResponse", str2 + th.toString() + str + this.mIsFirstRead);
                                        if (absDownloadHttpConnection != null) {
                                            absDownloadHttpConnection2 = absDownloadHttpConnection;
                                            try {
                                                absDownloadHttpConnection2.onThrowable(th);
                                            } catch (Throwable th6) {
                                                th = th6;
                                                if (i2 > 0) {
                                                    try {
                                                        this.mCallback.onProgress(i2);
                                                    } catch (Throwable unused) {
                                                    }
                                                }
                                                if (randomAccessOutputStream != null && !this.mCanceled) {
                                                    updateDB();
                                                }
                                                this.mHttpConnection.end();
                                                DownloadUtils.safeClose(inputStream);
                                                DownloadUtils.safeClose(randomAccessOutputStream);
                                                if (absDownloadHttpConnection2 != null) {
                                                    throw th;
                                                }
                                                if (TextUtils.isEmpty(absDownloadHttpConnection2.getRequestLog())) {
                                                    throw th;
                                                }
                                                this.mDownloadInfo.setRequestLog(absDownloadHttpConnection2.getRequestLog());
                                                if (!this.mDownloadInfo.isHandleRequest()) {
                                                    throw th;
                                                }
                                                this.mCallback.onReceiveRequestLog(absDownloadHttpConnection2.getRequestLog());
                                                throw th;
                                            }
                                        } else {
                                            absDownloadHttpConnection2 = absDownloadHttpConnection;
                                        }
                                        if (isStoppedStatus()) {
                                            if (i2 > 0) {
                                                try {
                                                    this.mCallback.onProgress(i2);
                                                } catch (Throwable unused2) {
                                                }
                                            }
                                            if (randomAccessOutputStream != null && !this.mCanceled) {
                                                updateDB();
                                            }
                                            this.mHttpConnection.end();
                                            DownloadUtils.safeClose(inputStream);
                                            DownloadUtils.safeClose(randomAccessOutputStream);
                                            if (absDownloadHttpConnection2 == null || TextUtils.isEmpty(absDownloadHttpConnection2.getRequestLog())) {
                                                return;
                                            }
                                            this.mDownloadInfo.setRequestLog(absDownloadHttpConnection2.getRequestLog());
                                            if (this.mDownloadInfo.isHandleRequest()) {
                                                this.mCallback.onReceiveRequestLog(absDownloadHttpConnection2.getRequestLog());
                                                return;
                                            }
                                            return;
                                        }
                                        try {
                                            DownloadHelper.parseException(th, "ResponseHandler");
                                            if (i2 > 0) {
                                                try {
                                                    this.mCallback.onProgress(i2);
                                                } catch (Throwable unused3) {
                                                }
                                            }
                                            if (randomAccessOutputStream != null && !this.mCanceled) {
                                                updateDB();
                                            }
                                            this.mHttpConnection.end();
                                            DownloadUtils.safeClose(inputStream);
                                            DownloadUtils.safeClose(randomAccessOutputStream);
                                            if (absDownloadHttpConnection2 != null && !TextUtils.isEmpty(absDownloadHttpConnection2.getRequestLog())) {
                                                this.mDownloadInfo.setRequestLog(absDownloadHttpConnection2.getRequestLog());
                                                if (this.mDownloadInfo.isHandleRequest()) {
                                                    iDownloadRunnableCallback = this.mCallback;
                                                    str5 = absDownloadHttpConnection2.getRequestLog();
                                                    iDownloadRunnableCallback.onReceiveRequestLog(str5);
                                                }
                                            }
                                            if (this.mDownloadInfo.isIgnoreDataVerify()) {
                                            }
                                        } catch (BaseException e3) {
                                            DownloadHelper.injectRemoteIp(this.mHttpConnection, e3);
                                            throw e3;
                                        }
                                    }
                                }
                                if (this.mSetting.optInt(DownloadSettingKeys.USE_DEFAULT_THROTTLE_SPEED, 1) == 1) {
                                    long throttleNetSpeed = this.mDownloadInfo.getThrottleNetSpeed();
                                    if (throttleNetSpeed == -1 || throttleNetSpeed > 0) {
                                        this.mNeedUpdateThrottleNetSpeed = true;
                                    }
                                }
                                int writeBufferSize = DownloadComponentManager.getWriteBufferSize();
                                if (absDownloadHttpConnection2 != null) {
                                    if (absDownloadHttpConnection2.isOkhttp()) {
                                        writeBufferSize = DownloadConstants.OKHTTP_SEGMENT_SIZE;
                                    }
                                    List<Pair<String, String>> responseHeaders = absDownloadHttpConnection2.getResponseHeaders();
                                    if (responseHeaders != null) {
                                        this.mDownloadInfo.setHttpResponseHeader(responseHeaders.toString());
                                    }
                                    if (this.mDownloadInfo.isHandleRequest()) {
                                        this.mCallback.onReceiveHeader(responseHeaders);
                                    }
                                }
                                byte[] bArr2 = new byte[writeBufferSize];
                                InputStream inputStream3 = inputStream;
                                i3 = 0;
                                long j5 = 0;
                                while (true) {
                                    try {
                                        try {
                                            if (this.mNeedUpdateThrottleNetSpeed) {
                                                try {
                                                    this.mNeedUpdateThrottleNetSpeed = false;
                                                    inputStream3 = updateThrottleForInputStream(inputStream3);
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    str = str6;
                                                    str2 = str7;
                                                    j = contentLength;
                                                    i2 = i3;
                                                    inputStream = inputStream3;
                                                    absDownloadHttpConnection = absDownloadHttpConnection2;
                                                    randomAccessOutputStream = createOutputStream;
                                                    Logger.taskError(TAG, this.mDownloadInfo.getId(), "handleResponse", str2 + th.toString() + str + this.mIsFirstRead);
                                                    if (absDownloadHttpConnection != null) {
                                                    }
                                                    if (isStoppedStatus()) {
                                                    }
                                                }
                                            }
                                            DownloadHelper.trySleepDownloadingTask(this.mDownloadInfo);
                                            int read = inputStream3.read(bArr2);
                                            if (read == -1) {
                                                j = contentLength;
                                                absDownloadHttpConnection = absDownloadHttpConnection2;
                                                break;
                                            }
                                            try {
                                                if (isIgnoreDataVerify) {
                                                    str = str6;
                                                    str2 = str7;
                                                    j = contentLength;
                                                } else {
                                                    j = contentLength;
                                                    try {
                                                        j3 = this.mDownloadChunkContentLen;
                                                        str = str6;
                                                        str2 = str7;
                                                    } catch (Throwable th8) {
                                                        th = th8;
                                                        str = str6;
                                                        str2 = str7;
                                                    }
                                                    try {
                                                        long j6 = this.mCurOffset;
                                                        if (j3 > j6 - j2) {
                                                            absDownloadHttpConnection = absDownloadHttpConnection2;
                                                            if (j3 < (j6 - j2) + read) {
                                                                read = (int) (j3 - (j6 - j2));
                                                            }
                                                            if (this.mIsFirstRead) {
                                                                this.mIsFirstRead = false;
                                                                this.mNetworkRetryStrategy.reset();
                                                                if (this.mDownloadInfo.getVerifyCurBytes() > 0 && !checkDataEquals(bArr, bArr2, i)) {
                                                                    break;
                                                                }
                                                            }
                                                            createOutputStream.write(bArr2, 0, read);
                                                            this.mCurOffset += read;
                                                            i2 = i3 + read;
                                                            if (this.mDownloadInfo.isHandleRequest()) {
                                                                this.mCallback.onReceiveData(bArr2, read);
                                                            }
                                                            uptimeMillis = SystemClock.uptimeMillis();
                                                            if (uptimeMillis - j5 <= 1000) {
                                                                if (this.mCallback.onProgress(i2)) {
                                                                    try {
                                                                        if (!this.mCanceled) {
                                                                            updateDB();
                                                                        }
                                                                    } catch (BaseException e4) {
                                                                        e = e4;
                                                                        inputStream2 = inputStream3;
                                                                        str3 = str;
                                                                        absDownloadHttpConnection2 = absDownloadHttpConnection;
                                                                        i3 = 0;
                                                                        randomAccessOutputStream = createOutputStream;
                                                                        str4 = str2;
                                                                        Logger.taskError(TAG, this.mDownloadInfo.getId(), "handleResponse", str4 + e.toString() + str3 + this.mIsFirstRead);
                                                                        if (!isStoppedStatus()) {
                                                                        }
                                                                    } catch (Throwable th9) {
                                                                        th = th9;
                                                                        inputStream = inputStream3;
                                                                        i2 = 0;
                                                                        randomAccessOutputStream = createOutputStream;
                                                                        Logger.taskError(TAG, this.mDownloadInfo.getId(), "handleResponse", str2 + th.toString() + str + this.mIsFirstRead);
                                                                        if (absDownloadHttpConnection != null) {
                                                                        }
                                                                        if (isStoppedStatus()) {
                                                                        }
                                                                    }
                                                                }
                                                                DownloadCheckWifiTaskValidModule.checkWifiTaskValid(this.mDownloadInfo);
                                                                j5 = uptimeMillis;
                                                                i3 = 0;
                                                            } else {
                                                                i3 = i2;
                                                            }
                                                            if (isIgnoreDataVerify) {
                                                                long j7 = this.mDownloadChunkContentLen;
                                                                if (j7 >= 0 && j7 <= this.mCurOffset - j2) {
                                                                    break;
                                                                }
                                                            }
                                                            str6 = str;
                                                            contentLength = j;
                                                            str7 = str2;
                                                            absDownloadHttpConnection2 = absDownloadHttpConnection;
                                                        }
                                                    } catch (BaseException e5) {
                                                        e = e5;
                                                        inputStream2 = inputStream3;
                                                        str3 = str;
                                                        randomAccessOutputStream = createOutputStream;
                                                        str4 = str2;
                                                        Logger.taskError(TAG, this.mDownloadInfo.getId(), "handleResponse", str4 + e.toString() + str3 + this.mIsFirstRead);
                                                        if (!isStoppedStatus()) {
                                                        }
                                                    } catch (Throwable th10) {
                                                        th = th10;
                                                        absDownloadHttpConnection = absDownloadHttpConnection2;
                                                        i2 = i3;
                                                        inputStream = inputStream3;
                                                        randomAccessOutputStream = createOutputStream;
                                                        Logger.taskError(TAG, this.mDownloadInfo.getId(), "handleResponse", str2 + th.toString() + str + this.mIsFirstRead);
                                                        if (absDownloadHttpConnection != null) {
                                                        }
                                                        if (isStoppedStatus()) {
                                                        }
                                                    }
                                                }
                                                if (this.mDownloadInfo.isHandleRequest()) {
                                                }
                                                uptimeMillis = SystemClock.uptimeMillis();
                                                if (uptimeMillis - j5 <= 1000) {
                                                }
                                                if (isIgnoreDataVerify) {
                                                }
                                                str6 = str;
                                                contentLength = j;
                                                str7 = str2;
                                                absDownloadHttpConnection2 = absDownloadHttpConnection;
                                            } catch (BaseException e6) {
                                                e = e6;
                                                i3 = i2;
                                                inputStream2 = inputStream3;
                                                str3 = str;
                                                absDownloadHttpConnection2 = absDownloadHttpConnection;
                                                randomAccessOutputStream = createOutputStream;
                                                str4 = str2;
                                                Logger.taskError(TAG, this.mDownloadInfo.getId(), "handleResponse", str4 + e.toString() + str3 + this.mIsFirstRead);
                                                if (!isStoppedStatus()) {
                                                }
                                            } catch (Throwable th11) {
                                                th = th11;
                                                inputStream = inputStream3;
                                                randomAccessOutputStream = createOutputStream;
                                                Logger.taskError(TAG, this.mDownloadInfo.getId(), "handleResponse", str2 + th.toString() + str + this.mIsFirstRead);
                                                if (absDownloadHttpConnection != null) {
                                                }
                                                if (isStoppedStatus()) {
                                                }
                                            }
                                            absDownloadHttpConnection = absDownloadHttpConnection2;
                                            if (this.mIsFirstRead) {
                                            }
                                            createOutputStream.write(bArr2, 0, read);
                                            this.mCurOffset += read;
                                            i2 = i3 + read;
                                        } catch (BaseException e7) {
                                            e = e7;
                                            str3 = str6;
                                            inputStream2 = inputStream3;
                                            randomAccessOutputStream = createOutputStream;
                                            str4 = str7;
                                            Logger.taskError(TAG, this.mDownloadInfo.getId(), "handleResponse", str4 + e.toString() + str3 + this.mIsFirstRead);
                                            if (!isStoppedStatus()) {
                                                throw e;
                                            }
                                            if (i3 > 0) {
                                                try {
                                                    this.mCallback.onProgress(i3);
                                                } catch (Throwable unused4) {
                                                }
                                            }
                                            if (randomAccessOutputStream != null && !this.mCanceled) {
                                                updateDB();
                                            }
                                            this.mHttpConnection.end();
                                            DownloadUtils.safeClose(inputStream2);
                                            DownloadUtils.safeClose(randomAccessOutputStream);
                                            if (absDownloadHttpConnection2 == null || TextUtils.isEmpty(absDownloadHttpConnection2.getRequestLog())) {
                                                return;
                                            }
                                            this.mDownloadInfo.setRequestLog(absDownloadHttpConnection2.getRequestLog());
                                            if (this.mDownloadInfo.isHandleRequest()) {
                                                this.mCallback.onReceiveRequestLog(absDownloadHttpConnection2.getRequestLog());
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (Throwable th12) {
                                        th = th12;
                                        str = str6;
                                        str2 = str7;
                                        j = contentLength;
                                    }
                                }
                                if (i3 > 0) {
                                    try {
                                        this.mCallback.onProgress(i3);
                                    } catch (Throwable unused5) {
                                    }
                                }
                                if (createOutputStream != null && !this.mCanceled) {
                                    updateDB();
                                }
                                this.mHttpConnection.end();
                                DownloadUtils.safeClose(inputStream3);
                                DownloadUtils.safeClose(createOutputStream);
                            } catch (Throwable th13) {
                                th = th13;
                                str = " isFirstRead:";
                                str2 = "Exception:";
                                j = contentLength;
                                absDownloadHttpConnection = absDownloadHttpConnection2;
                                randomAccessOutputStream = createOutputStream;
                            }
                        } catch (BaseException e8) {
                            e = e8;
                            str3 = " isFirstRead:";
                            randomAccessOutputStream = createOutputStream;
                            inputStream2 = inputStream;
                            i3 = 0;
                        }
                    } catch (Throwable th14) {
                        th = th14;
                        str = " isFirstRead:";
                        str2 = "Exception:";
                        j = contentLength;
                        absDownloadHttpConnection = absDownloadHttpConnection2;
                        randomAccessOutputStream = createOutputStream;
                        i2 = 0;
                        inputStream = null;
                        Logger.taskError(TAG, this.mDownloadInfo.getId(), "handleResponse", str2 + th.toString() + str + this.mIsFirstRead);
                        if (absDownloadHttpConnection != null) {
                        }
                        if (isStoppedStatus()) {
                        }
                    }
                } catch (BaseException e9) {
                    e = e9;
                    str3 = " isFirstRead:";
                    randomAccessOutputStream = createOutputStream;
                    i3 = 0;
                    inputStream2 = null;
                }
            } catch (IOException e10) {
                e = e10;
                str = " isFirstRead:";
                str2 = "Exception:";
                j = contentLength;
                j2 = j4;
            } catch (Throwable th15) {
                th = th15;
                str = " isFirstRead:";
                str2 = "Exception:";
                j = contentLength;
                j2 = j4;
            }
        } catch (BaseException e11) {
            e = e11;
            str3 = " isFirstRead:";
            str4 = "Exception:";
            i3 = 0;
            randomAccessOutputStream = null;
        } catch (Throwable th16) {
            th = th16;
            str = " isFirstRead:";
            str2 = "Exception:";
            j = contentLength;
            j2 = j4;
            absDownloadHttpConnection = absDownloadHttpConnection2;
            i2 = 0;
            inputStream = null;
            randomAccessOutputStream = null;
        }
        if (absDownloadHttpConnection != null && !TextUtils.isEmpty(absDownloadHttpConnection.getRequestLog())) {
            this.mDownloadInfo.setRequestLog(absDownloadHttpConnection.getRequestLog());
            if (this.mDownloadInfo.isHandleRequest()) {
                iDownloadRunnableCallback = this.mCallback;
                str5 = absDownloadHttpConnection.getRequestLog();
                iDownloadRunnableCallback.onReceiveRequestLog(str5);
            }
        }
        if (this.mDownloadInfo.isIgnoreDataVerify()) {
            long j8 = this.mCurOffset - j2;
            if (j8 >= 0) {
                long j9 = this.mDownloadChunkContentLen;
                if (j9 >= 0 && j9 != j8) {
                    throw new BaseException(1051, String.format(Locale.US, "handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", Long.valueOf(j8), Long.valueOf(j), Long.valueOf(this.mDownloadChunkContentLen), Long.valueOf(this.mDownloadInfo.getStartOffset()), Long.valueOf(this.mDownloadInfo.getEndOffset()), Long.valueOf(this.mCurOffset), Long.valueOf(j2)));
                }
            }
        }
    }

    private boolean isStoppedStatus() {
        return this.mPaused || this.mCanceled;
    }

    public void pause() {
        if (this.mPaused) {
            return;
        }
        this.mPaused = true;
        cancelConnection();
    }

    public void cancel() {
        if (this.mCanceled) {
            return;
        }
        this.mCanceled = true;
        cancelConnection();
    }

    public long getCurOffset() {
        return this.mCurOffset;
    }

    private void cancelConnection() {
        if (this.mHttpConnection == null) {
            return;
        }
        DownloadComponentManager.submitIOTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadSingleResponseHandler.this.mHttpConnection.end();
            }
        }, true);
    }

    private void updateDB() {
        try {
            this.mDownloadInfo.updateRealDownloadTime(true);
            this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setThrottleNetSpeed(long j, int i) {
        this.mDownloadInfo.setThrottleNetSpeed(j, i);
        this.mNeedUpdateThrottleNetSpeed = true;
    }

    private InputStream updateThrottleForInputStream(InputStream inputStream) {
        ThrottleInputStream smartThrottleInputStream;
        if (inputStream instanceof ThrottleInputStream) {
            smartThrottleInputStream = (ThrottleInputStream) inputStream;
        } else {
            smartThrottleInputStream = new SmartThrottleInputStream(inputStream, (float) this.mSetting.optDouble(DownloadSettingKeys.THROTTLE_FACTOR_MIN, 0.10000000149011612d), (float) this.mSetting.optDouble(DownloadSettingKeys.THROTTLE_FACTOR_MAX, 0.699999988079071d));
        }
        smartThrottleInputStream.setThrottleNetSpeed(this.mDownloadInfo.getThrottleNetSpeed(), this.mDownloadInfo.getThrottleSmoothness());
        return smartThrottleInputStream;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        if (r2 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] readVerifyData(int i) {
        DownloadFileRandomAccess downloadFileRandomAccess;
        try {
            downloadFileRandomAccess = new DownloadFileRandomAccess(new FileInputStream(new File(this.mDownloadInfo.getTempPath(), this.mDownloadInfo.getTempName())));
            try {
                downloadFileRandomAccess.seek(this.mDownloadInfo.getCurBytes(), 0L);
                byte[] bArr = new byte[i];
                if (downloadFileRandomAccess.read(bArr, 0, i) == i) {
                    try {
                        downloadFileRandomAccess.close();
                    } catch (Throwable unused) {
                    }
                    return bArr;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                } catch (Throwable th2) {
                    if (downloadFileRandomAccess != null) {
                        try {
                            downloadFileRandomAccess.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            downloadFileRandomAccess = null;
        }
        try {
            downloadFileRandomAccess.close();
        } catch (Throwable unused3) {
            return null;
        }
    }

    private boolean checkDataEquals(byte[] bArr, byte[] bArr2, int i) {
        if (bArr != null && bArr.length >= i && bArr2 != null && bArr2.length >= i) {
            for (int i2 = 0; i2 < i; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
            }
        }
        return true;
    }
}
