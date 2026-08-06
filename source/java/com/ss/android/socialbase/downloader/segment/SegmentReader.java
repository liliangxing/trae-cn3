package com.ss.android.socialbase.downloader.segment;

import android.os.Process;
import android.text.TextUtils;
import com.lynx.tasm.p001ui.image.ImageDelegate;
import com.ss.android.pushmanager.PushCommonConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy;
import com.ss.android.socialbase.downloader.downloader.NetworkRetryStrategy;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadStenographer;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SegmentReader implements Runnable {
    private static final int SEGMENT_APPLY_RETRY_MAX_COUNT = 50;
    private static final int SWITCH_URL_MAX_COUNT = 30;
    private static final String TAG = "SegmentReader";
    private volatile boolean changeSegment;
    private volatile boolean closed;
    volatile long connectEndTime;
    volatile long connectStartTime;
    String curHostIp;
    String curHostRealIp;
    private int curRetryCount;
    volatile Segment curSegment;
    String curUrl;
    private final DownloadInfo downloadInfo;
    private final DownloadTask downloadTask;
    private volatile long endOffsetInConnection;
    private boolean exited;
    private boolean failed;
    private BaseException failedException;
    private NetworkFailoverStrategy failoverStrategy;
    private Future future;
    private final ISegmentCallback host;
    private IDownloadHttpConnection httpConnection;
    private HttpResponse httpResponse;
    private boolean httpsToHttpRetryUsed;
    private long lastConnectStartTime;
    private boolean mCanSleep;
    private final IBufferPool pool;
    private volatile long readBytes;
    volatile long readEndTime;
    volatile long readStartTime;
    private volatile boolean reconnect;
    private int retryCount;
    private NetworkRetryStrategy retryStrategy;
    private int segmentApplyRetryTimes;
    private volatile long segmentNewEndOffset;
    private final DownloadSetting setting;
    private long startOffsetInConnection;
    private DownloadStenographer stenographer;
    private int switchUrlTimes;
    private Thread thread;
    private volatile boolean threadDirty;
    final int threadIndex;
    UrlRecord urlRecord;
    private final List<Segment> succeedSegments = new ArrayList();
    private volatile long curSegmentReadOffset = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SegmentReader(DownloadTask downloadTask, DownloadInfo downloadInfo, SegmentDispatcher segmentDispatcher, IBufferPool iBufferPool, UrlRecord urlRecord, int i) {
        this.downloadTask = downloadTask;
        this.downloadInfo = downloadInfo;
        this.host = segmentDispatcher;
        this.pool = iBufferPool;
        this.setting = DownloadSetting.obtain(downloadInfo.getId());
        this.urlRecord = urlRecord;
        this.threadIndex = i;
        this.retryStrategy = new NetworkRetryStrategy(downloadInfo);
        this.failoverStrategy = new NetworkFailoverStrategy(downloadInfo);
    }

    @Override // java.lang.Runnable
    public void run() {
        ISegmentCallback iSegmentCallback;
        Segment obtainSegment;
        ISegmentCallback iSegmentCallback2;
        ISegmentCallback iSegmentCallback3;
        Process.setThreadPriority(10);
        try {
            try {
                this.thread = Thread.currentThread();
                this.host.onReaderRun(this);
                this.urlRecord.recordUse(this);
                while (true) {
                    obtainSegment = this.host.obtainSegment(this, this.urlRecord);
                    if (obtainSegment != null) {
                        this.curSegment = obtainSegment;
                        try {
                            try {
                            } catch (SegmentApplyException e) {
                                Logger.taskError(TAG, this.downloadInfo.getId(), "run", "SegmentApplyException, Exception = " + e);
                                int i = this.segmentApplyRetryTimes;
                                if (i >= 50) {
                                    Logger.taskError(TAG, this.downloadInfo.getId(), "run", "Segment apply failed " + this.segmentApplyRetryTimes + "times, thread_index = " + this.threadIndex);
                                    this.curSegment = null;
                                    iSegmentCallback2 = this.host;
                                    break;
                                } else {
                                    this.segmentApplyRetryTimes = i + 1;
                                    this.curSegment = null;
                                    iSegmentCallback3 = this.host;
                                }
                            }
                            if (!download(obtainSegment)) {
                                if (!this.closed) {
                                    Logger.taskError(TAG, this.downloadInfo.getId(), "run", "Download segment failed, segment = " + obtainSegment + ", thread_index = " + this.threadIndex + ", failedException = " + this.failedException);
                                    break;
                                }
                                break;
                            } else {
                                this.succeedSegments.add(obtainSegment);
                                this.curSegment = null;
                                iSegmentCallback3 = this.host;
                                iSegmentCallback3.unObtainSegment(this, obtainSegment);
                            }
                        } catch (Throwable th) {
                            this.curSegment = null;
                            this.host.unObtainSegment(this, obtainSegment);
                            throw th;
                        }
                    } else if (Logger.debug()) {
                        Logger.taskDebug(TAG, this.downloadInfo.getId(), "run", "No more segment, thread_index: " + this.threadIndex);
                    }
                }
                this.curSegment = null;
                iSegmentCallback2 = this.host;
                iSegmentCallback2.unObtainSegment(this, obtainSegment);
                this.urlRecord.recordUnUse(this);
                iSegmentCallback = this.host;
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                    this.urlRecord.recordUnUse(this);
                    iSegmentCallback = this.host;
                } catch (Throwable th3) {
                    try {
                        this.urlRecord.recordUnUse(this);
                        this.host.onReaderExit(this);
                    } catch (Throwable unused) {
                    }
                    this.thread = null;
                    throw th3;
                }
            }
            iSegmentCallback.onReaderExit(this);
        } catch (Throwable unused2) {
        }
        this.thread = null;
    }

    private boolean download(Segment segment) throws BaseException {
        initParams();
        while (true) {
            try {
                doConnect(segment);
                loopAndRead(segment);
                releaseDownload();
                return true;
            } catch (SegmentApplyException e) {
                this.failedException = e;
                throw e;
            } catch (Throwable th) {
                try {
                    Logger.taskError(TAG, this.downloadInfo.getId(), "download", "e = " + th + ", threadIndex = " + this.threadIndex + ", reconnect = " + this.reconnect + ", closed = " + this.closed);
                    if (this.closed) {
                        return false;
                    }
                    if (this.reconnect) {
                        this.reconnect = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        if (this.changeSegment) {
                            this.changeSegment = false;
                            throw new SegmentApplyException(5, "download");
                        }
                    } else {
                        if (th instanceof BaseException) {
                            e = th;
                        } else {
                            try {
                                DownloadHelper.parseException(th, "download");
                                e = null;
                            } catch (BaseException e2) {
                                e = e2;
                            }
                        }
                        if (e == null || !handleFailedAndCheckRetry(segment, e)) {
                            return false;
                        }
                    }
                } finally {
                    releaseDownload();
                }
            }
        }
    }

    private void releaseDownload() {
        this.lastConnectStartTime = this.connectStartTime;
        this.connectStartTime = -1L;
        this.connectEndTime = -1L;
        this.readStartTime = -1L;
        this.readEndTime = -1L;
        closeConnection();
    }

    private void closeConnection() {
        IDownloadHttpConnection iDownloadHttpConnection = this.httpConnection;
        if (iDownloadHttpConnection != null) {
            try {
                if (Logger.debug()) {
                    Logger.taskDebug(TAG, this.downloadInfo.getId(), "closeConnection", "Thread: " + this.threadIndex);
                }
                iDownloadHttpConnection.end();
                iDownloadHttpConnection.cancel();
            } catch (Throwable unused) {
            }
        }
    }

    private void initParams() {
        this.httpsToHttpRetryUsed = false;
        resetRetryTimes();
    }

    private void resetRetryTimes() {
        this.retryCount = this.urlRecord.isMainUrl ? this.downloadInfo.getRetryCount() : this.downloadInfo.getBackUpUrlRetryCount();
        this.curRetryCount = 0;
        this.retryStrategy.reset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean switchUrlRecord(UrlRecord urlRecord) {
        int i = this.switchUrlTimes;
        if (i >= 30) {
            return false;
        }
        this.switchUrlTimes = i + 1;
        UrlRecord urlRecord2 = this.urlRecord;
        if (urlRecord2 != null) {
            urlRecord2.recordUnUse(this);
        }
        urlRecord.recordUse(this);
        this.urlRecord = urlRecord;
        resetRetryTimes();
        return true;
    }

    int getCurRetryCount() {
        return this.curRetryCount;
    }

    int getRetryCount() {
        return this.retryCount;
    }

    private boolean handleFailedAndCheckRetry(Segment segment, BaseException baseException) {
        Logger.taskError(TAG, this.downloadInfo.getId(), "handleFailedAndCheckRetry", "Exception = " + baseException + ", curRetryCount = " + this.curRetryCount + ", retryCount = " + this.retryCount);
        this.failedException = baseException;
        this.urlRecord.recordFailed();
        if (!this.host.onSegmentRetry(this, this.urlRecord, segment, baseException, this.curRetryCount, this.retryCount)) {
            return false;
        }
        int i = this.curRetryCount;
        if (i < this.retryCount) {
            this.curRetryCount = i + 1;
            return true;
        }
        this.failoverStrategy.handleError(baseException);
        if (this.retryStrategy.canRetry(baseException)) {
            this.retryStrategy.doRetry();
            this.downloadInfo.setCurNetworkRetryCount(this.retryStrategy.getTotalRetryCount());
            return true;
        }
        if (checkCanUseHttpsToHttpRetry(baseException)) {
            return true;
        }
        this.host.onSegmentFailed(this, this.urlRecord, segment, baseException);
        return false;
    }

    private boolean checkCanUseHttpsToHttpRetry(BaseException baseException) {
        if (!DownloadHelper.isHttpsError(baseException)) {
            return false;
        }
        String str = this.urlRecord.url;
        if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.downloadInfo.isNeedHttpsToHttpRetry() || this.httpsToHttpRetryUsed) {
            return false;
        }
        this.httpsToHttpRetryUsed = true;
        resetRetryTimes();
        return true;
    }

    private void doConnect(Segment segment) throws BaseException {
        createConnection(segment);
        this.host.onSegmentConnected(this, segment, this.urlRecord, this.httpResponse);
        this.urlRecord.recordSucceed();
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x020a: INVOKE 
      (r8v2 ?? I:java.lang.String)
      (r5 I:com.ss.android.socialbase.downloader.network.IDownloadHttpConnection)
      (r2 I:java.lang.Throwable)
      (r3 I:com.ss.android.socialbase.downloader.depend.IDownloadCdnListener)
     STATIC call: com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadCDN(java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.IDownloadCdnListener):void A[MD:(java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.IDownloadCdnListener):void (m)], block:B:82:0x01fe */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x020a: INVOKE 
      (r8 I:java.lang.String)
      (r5 I:com.ss.android.socialbase.downloader.network.IDownloadHttpConnection)
      (r2 I:java.lang.Throwable)
      (r3 I:com.ss.android.socialbase.downloader.depend.IDownloadCdnListener)
     STATIC call: com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadCDN(java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.IDownloadCdnListener):void A[MD:(java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.IDownloadCdnListener):void (m)], block:B:82:0x01fe */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0155 A[Catch: all -> 0x01c0, BaseException -> 0x01c4, TRY_ENTER, TryCatch #11 {BaseException -> 0x01c4, all -> 0x01c0, blocks: (B:24:0x0155, B:26:0x0162, B:28:0x0166, B:29:0x016f, B:31:0x0175, B:35:0x01ba, B:36:0x01bf, B:37:0x01c8, B:38:0x01d6), top: B:22:0x0153 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c8 A[Catch: all -> 0x01c0, BaseException -> 0x01c4, TryCatch #11 {BaseException -> 0x01c4, all -> 0x01c0, blocks: (B:24:0x0155, B:26:0x0162, B:28:0x0166, B:29:0x016f, B:31:0x0175, B:35:0x01ba, B:36:0x01bf, B:37:0x01c8, B:38:0x01d6), top: B:22:0x0153 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void createConnection(Segment segment) throws BaseException {
        IDownloadHttpConnection iDownloadHttpConnection;
        String str;
        String monitorDownloadCDN;
        IDownloadHttpConnection monitorDownloadCDN2;
        Throwable th;
        boolean z;
        IDownloadHttpConnection downloadWithConnection;
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.connectEndTime = 0L;
                this.connectStartTime = currentTimeMillis;
                this.startOffsetInConnection = segment.getCurrentOffsetRead();
                this.endOffsetInConnection = segment.getEndOffset();
                if (this.endOffsetInConnection > 0) {
                    try {
                        if (this.startOffsetInConnection > this.endOffsetInConnection) {
                            throw new SegmentApplyException(6, "createConn, " + segment);
                        }
                    } catch (BaseException e) {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        iDownloadHttpConnection = null;
                        str = null;
                        DownloadHelper.parseException(th, "createConn");
                        this.connectEndTime = System.currentTimeMillis();
                        DownloadMonitorHelper.monitorDownloadCDN(str, iDownloadHttpConnection, th, this.downloadTask.getCdnListener());
                    }
                }
                this.stenographer = new DownloadStenographer();
                List<HttpHeader> addRangeHeader = DownloadHelper.addRangeHeader(this.downloadInfo.getExtraHeaders(), this.downloadInfo.geteTag(), this.startOffsetInConnection, this.endOffsetInConnection);
                addRangeHeader.add(new HttpHeader("Segment-Index", String.valueOf(segment.getIndex())));
                addRangeHeader.add(new HttpHeader("Thread-Index", String.valueOf(this.threadIndex)));
                addRangeHeader.add(new HttpHeader("extra_download_id", String.valueOf(this.downloadInfo.getId())));
                DownloadHelper.addTTNetParam(this.setting, addRangeHeader, this.downloadInfo);
                this.failoverStrategy.handleHeader(addRangeHeader);
                str = this.urlRecord.url;
                try {
                    if (this.httpsToHttpRetryUsed) {
                        try {
                            if (!TextUtils.isEmpty(str) && str.startsWith("https")) {
                                str = str.replaceFirst("https", ImageDelegate.HTTP_PREFIX);
                            }
                        } catch (BaseException e2) {
                            throw e2;
                        } catch (Throwable th3) {
                            th = th3;
                            iDownloadHttpConnection = null;
                            DownloadHelper.parseException(th, "createConn");
                            this.connectEndTime = System.currentTimeMillis();
                            DownloadMonitorHelper.monitorDownloadCDN(str, iDownloadHttpConnection, th, this.downloadTask.getCdnListener());
                        }
                    }
                    String str2 = this.urlRecord.f82ip;
                    if (Logger.debug()) {
                        Logger.taskDebug(TAG, this.downloadInfo.getId(), "createConnection", "Url = " + str + ", ip = " + str2 + ", segment = " + segment + ", threadIndex = " + this.threadIndex);
                    }
                    this.curUrl = str;
                    this.curHostIp = str2;
                    boolean isNeedDefaultHttpServiceBackUp = this.downloadInfo.isNeedDefaultHttpServiceBackUp();
                    int maxBytes = this.downloadInfo.getMaxBytes();
                    try {
                        if (currentTimeMillis - this.lastConnectStartTime > 3000) {
                            if (this.setting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT) > 0) {
                                z = true;
                                downloadWithConnection = DownloadComponentManager.downloadWithConnection(isNeedDefaultHttpServiceBackUp, maxBytes, str, str2, addRangeHeader, 0, z, this.downloadInfo);
                                if (downloadWithConnection != null) {
                                    throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                                }
                                this.httpConnection = downloadWithConnection;
                                this.httpResponse = new HttpResponse(str, downloadWithConnection);
                                if (this.closed) {
                                    throw new StreamClosedException("createConn");
                                }
                                if (downloadWithConnection instanceof AbsDownloadHttpConnection) {
                                    this.curHostRealIp = ((AbsDownloadHttpConnection) downloadWithConnection).getHostIp();
                                }
                                if (Logger.debug()) {
                                    Logger.taskDebug(TAG, this.downloadInfo.getId(), "createConnection", "Url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.curHostRealIp + ", threadIndex = " + this.threadIndex);
                                }
                                this.connectEndTime = System.currentTimeMillis();
                                DownloadMonitorHelper.monitorDownloadCDN(str, downloadWithConnection, null, this.downloadTask.getCdnListener());
                                return;
                            }
                        }
                        if (downloadWithConnection != null) {
                        }
                    } catch (BaseException e3) {
                        throw e3;
                    } catch (Throwable th4) {
                        th = th4;
                        iDownloadHttpConnection = downloadWithConnection;
                        DownloadHelper.parseException(th, "createConn");
                        this.connectEndTime = System.currentTimeMillis();
                        DownloadMonitorHelper.monitorDownloadCDN(str, iDownloadHttpConnection, th, this.downloadTask.getCdnListener());
                    }
                    z = false;
                    downloadWithConnection = DownloadComponentManager.downloadWithConnection(isNeedDefaultHttpServiceBackUp, maxBytes, str, str2, addRangeHeader, 0, z, this.downloadInfo);
                } catch (BaseException e4) {
                    e = e4;
                    throw e;
                } catch (Throwable th5) {
                    th = th5;
                    iDownloadHttpConnection = null;
                    th = th;
                    DownloadHelper.parseException(th, "createConn");
                    this.connectEndTime = System.currentTimeMillis();
                    DownloadMonitorHelper.monitorDownloadCDN(str, iDownloadHttpConnection, th, this.downloadTask.getCdnListener());
                }
            } catch (Throwable th6) {
                this.connectEndTime = System.currentTimeMillis();
                DownloadMonitorHelper.monitorDownloadCDN(monitorDownloadCDN, monitorDownloadCDN2, "https", this.downloadTask.getCdnListener());
                throw th6;
            }
        } catch (BaseException e5) {
            e = e5;
        } catch (Throwable th7) {
            th = th7;
            iDownloadHttpConnection = null;
            str = null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:207:0x0193
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Removed duplicated region for block: B:288:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x044a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void loopAndRead(com.ss.android.socialbase.downloader.segment.Segment r41) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1162
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.SegmentReader.loopAndRead(com.ss.android.socialbase.downloader.segment.Segment):void");
    }

    private Buffer probeFirstBuffer(IBufferPool iBufferPool, InputStream inputStream) throws InterruptedException, BaseException, IOException {
        int i;
        Buffer obtain = iBufferPool.obtain();
        try {
            i = inputStream.read(obtain.data);
        } catch (Throwable th) {
            th = th;
            i = -1;
        }
        try {
            if (i == -1) {
                throw new BaseException(1073, "probe");
            }
            obtain.size = i;
            if (i == -1) {
                iBufferPool.recycle(obtain);
            }
            return obtain;
        } catch (Throwable th2) {
            th = th2;
            if (i == -1) {
                iBufferPool.recycle(obtain);
            }
            throw th;
        }
    }

    private long refreshSegmentEndOffset() {
        long j = this.segmentNewEndOffset;
        this.segmentNewEndOffset = 0L;
        if (j <= 0) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    public boolean adjustSegmentEndOffset(long j) {
        long j2 = this.endOffsetInConnection;
        if (j <= 0 && j2 > 0) {
            return false;
        }
        if (j > j2 && j2 > 0) {
            return false;
        }
        this.segmentNewEndOffset = j;
        this.threadDirty = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateReadBytes() {
        UrlRecord urlRecord = this.urlRecord;
        try {
            synchronized (this.host) {
                long readingBytes = getReadingBytes();
                if (readingBytes > 0) {
                    this.readBytes += readingBytes;
                    urlRecord.increaseDownloadBytes(readingBytes);
                }
                this.curSegmentReadOffset = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public long getReadBytes() {
        long readingBytes;
        synchronized (this.host) {
            readingBytes = this.readBytes + getReadingBytes();
        }
        return readingBytes;
    }

    public long getReadingBytes() {
        synchronized (this.host) {
            long j = this.curSegmentReadOffset;
            long j2 = this.startOffsetInConnection;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    public long getCurSegmentReadOffset() {
        return this.curSegmentReadOffset;
    }

    public void close() {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, this.downloadInfo.getId(), PushCommonConstants.VALUE_CLOSE, "ThreadIndex: " + this.threadIndex);
        }
        synchronized (this) {
            this.closed = true;
            this.threadDirty = true;
        }
        closeConnection();
        Future future = this.future;
        if (future != null) {
            this.future = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void reconnect() {
        reconnect(false);
    }

    public void reconnect(boolean z) {
        if (Logger.debug()) {
            Logger.taskDebug(TAG, this.downloadInfo.getId(), "reconnect", "ThreadIndex: " + this.threadIndex);
        }
        synchronized (this) {
            this.changeSegment = z;
            this.reconnect = true;
            this.threadDirty = true;
        }
        closeConnection();
        Thread thread = this.thread;
        if (thread != null) {
            try {
                if (Logger.debug()) {
                    Logger.taskDebug(TAG, this.downloadInfo.getId(), "reconnect", "Interrupt ThreadIndex: " + this.threadIndex);
                }
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFuture(Future future) {
        this.future = future;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFailed(boolean z) {
        this.failed = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFailed() {
        return this.failed;
    }

    public boolean isExited() {
        return this.exited;
    }

    public void setExited(boolean z) {
        this.exited = z;
    }

    BaseException getFailedException() {
        return this.failedException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markProgress(long j) {
        long j2 = this.curSegmentReadOffset;
        DownloadStenographer downloadStenographer = this.stenographer;
        if (j2 < 0 || downloadStenographer == null) {
            return;
        }
        if (Logger.debug()) {
            Logger.taskDebug(TAG, this.downloadInfo.getId(), "markProgress", "CurSegmentReadOffset = " + j2 + ", threadIndex = " + this.threadIndex);
        }
        downloadStenographer.markProgress(j2, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getRecentDownloadSpeed(long j, long j2) {
        DownloadStenographer downloadStenographer = this.stenographer;
        if (downloadStenographer == null) {
            return -1L;
        }
        return downloadStenographer.getRecentDownloadSpeed(j, j2);
    }

    long getCurSegmentDownloadSpeed(long j) {
        long j2 = this.readStartTime;
        if (j2 <= 0) {
            return -1L;
        }
        long j3 = j - j2;
        if (j3 <= 0) {
            return -1L;
        }
        long j4 = this.curSegmentReadOffset;
        long j5 = this.startOffsetInConnection;
        if (j5 < 0 || j4 < j5) {
            return 0L;
        }
        return (j4 - j5) / j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getStartOffsetInConnection() {
        return this.startOffsetInConnection;
    }
}
