package com.ss.android.socialbase.downloader.segment;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MultiSegmentWriter {
    private static final int MIN_CACHE_BYTES = 65536;
    private static final int MIN_CACHE_TIME_MS = 200;
    private static final int MIN_SYNC_STEP_BYTE = 65536;
    private static final long MIN_SYNC_TIME_MS = 500;
    private static final String TAG = "MultiSegmentWriter";
    private final IDownloadRunnableCallback callback;
    private final DownloadInfo downloadInfo;
    private BaseException exception;
    private final boolean hasSyncStrategy;
    private final boolean isMonitorRw;
    private final long minSyncLength;
    private final IBufferPool pool;
    private final DownloadSetting setting;
    private final long syncIntervalMsBg;
    private final long syncIntervalMsFg;
    private long syncTimeNs;
    private final List<SegmentOutput> outputs = new LinkedList();
    private final List<SegmentOutput> doneOutputs = new ArrayList();
    private volatile boolean threadDirty = false;
    private volatile boolean paused = false;
    private volatile boolean canceled = false;
    private boolean needSync = true;
    private volatile long lastSyncBytes = 0;
    private volatile long lastSyncTimestamp = 0;
    private final IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();
    private final AppStatusManager appStatusManager = AppStatusManager.getInstance();

    private boolean isNeedSync(long j, long j2) {
        return j > 65536 && j2 > MIN_SYNC_TIME_MS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiSegmentWriter(DownloadInfo downloadInfo, IDownloadRunnableCallback iDownloadRunnableCallback, IBufferPool iBufferPool) {
        this.downloadInfo = downloadInfo;
        this.callback = iDownloadRunnableCallback;
        this.pool = iBufferPool;
        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
        this.setting = obtain;
        boolean z = obtain.optInt(DownloadSettingKeys.SYNC_STRATEGY, 0) == 1;
        this.hasSyncStrategy = z;
        if (z) {
            long optInt = obtain.optInt(DownloadSettingKeys.SYNC_INTERVAL_MS_FG, 5000);
            long optInt2 = obtain.optInt(DownloadSettingKeys.SYNC_INTERVAL_MS_BG, 1000);
            this.syncIntervalMsFg = Math.max(optInt, MIN_SYNC_TIME_MS);
            this.syncIntervalMsBg = Math.max(optInt2, MIN_SYNC_TIME_MS);
            this.minSyncLength = obtain.optLong(DownloadSettingKeys.SYNC_MIN_LENGTH, 10485760L);
        } else {
            this.syncIntervalMsFg = 0L;
            this.syncIntervalMsBg = 0L;
            this.minSyncLength = 0L;
        }
        this.isMonitorRw = obtain.optInt(DownloadSettingKeys.MONITOR_RW) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void assignOutput(SegmentOutput segmentOutput) {
        synchronized (this) {
            this.outputs.add(segmentOutput);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x03c5, code lost:
    
        r3.onProgress(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x02fc, code lost:
    
        r3.onProgress(r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x039e A[Catch: all -> 0x044d, TryCatch #15 {all -> 0x044d, blocks: (B:153:0x0234, B:155:0x0238, B:158:0x023e, B:160:0x0244, B:162:0x0265, B:209:0x02f6, B:210:0x02f8, B:95:0x038f, B:97:0x0393, B:100:0x0398, B:102:0x039e, B:103:0x03bf, B:104:0x03c1), top: B:12:0x0036, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0238 A[Catch: all -> 0x044d, TryCatch #15 {all -> 0x044d, blocks: (B:153:0x0234, B:155:0x0238, B:158:0x023e, B:160:0x0244, B:162:0x0265, B:209:0x02f6, B:210:0x02f8, B:95:0x038f, B:97:0x0393, B:100:0x0398, B:102:0x039e, B:103:0x03bf, B:104:0x03c1), top: B:12:0x0036, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0244 A[Catch: all -> 0x044d, TRY_LEAVE, TryCatch #15 {all -> 0x044d, blocks: (B:153:0x0234, B:155:0x0238, B:158:0x023e, B:160:0x0244, B:162:0x0265, B:209:0x02f6, B:210:0x02f8, B:95:0x038f, B:97:0x0393, B:100:0x0398, B:102:0x039e, B:103:0x03bf, B:104:0x03c1), top: B:12:0x0036, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x029f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0274 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x032f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x049a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0393 A[Catch: all -> 0x044d, TryCatch #15 {all -> 0x044d, blocks: (B:153:0x0234, B:155:0x0238, B:158:0x023e, B:160:0x0244, B:162:0x0265, B:209:0x02f6, B:210:0x02f8, B:95:0x038f, B:97:0x0393, B:100:0x0398, B:102:0x039e, B:103:0x03bf, B:104:0x03c1), top: B:12:0x0036, inners: #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loopAndWrite(IInput iInput) throws BaseException {
        int i;
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        Throwable th;
        long j6;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        Throwable th5;
        Throwable th6;
        if (this.paused || this.canceled) {
            return;
        }
        int i2 = 0;
        this.exception = null;
        DownloadInfo downloadInfo = this.downloadInfo;
        IDownloadRunnableCallback iDownloadRunnableCallback = this.callback;
        IBufferPool iBufferPool = this.pool;
        long curBytes = downloadInfo.getCurBytes();
        long nanoTime = System.nanoTime();
        boolean z2 = this.isMonitorRw;
        int i3 = 0;
        boolean z3 = 0;
        if (this.hasSyncStrategy) {
            long totalBytes = downloadInfo.getTotalBytes();
            if (totalBytes > 0 && totalBytes <= this.minSyncLength) {
                this.needSync = false;
            }
        }
        try {
            try {
                try {
                    downloadInfo.updateRealStartDownloadTime();
                } catch (BaseException e) {
                    e = e;
                    i = 0;
                    z = true;
                    i2 = 0;
                }
                try {
                    this.lastSyncTimestamp = SystemClock.uptimeMillis();
                    i2 = 0;
                    j3 = 0;
                    long j7 = 0;
                    long j8 = 0;
                    long j9 = 0;
                    while (true) {
                        if (z2) {
                            try {
                                j8 = System.nanoTime();
                            } catch (StreamClosedException e2) {
                                e = e2;
                                j4 = j7;
                                i = z3 ? 1 : 0;
                                i3 = i2;
                                try {
                                    this.exception = e;
                                    throw e;
                                } catch (Throwable th7) {
                                    th = th7;
                                    i2 = i3;
                                    j = j4;
                                    j5 = j3;
                                    if (i2 > 0) {
                                    }
                                    if (this.canceled) {
                                    }
                                    th5 = null;
                                    synchronized (this) {
                                    }
                                }
                            } catch (BaseException e3) {
                                e = e3;
                                j2 = j3;
                                j6 = j7;
                                i = z3 ? 1 : 0;
                                z = true;
                                if (!this.paused) {
                                }
                                if (!this.canceled) {
                                }
                                th4 = null;
                                synchronized (this) {
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                j2 = j3;
                                j = j7;
                                i = z3 ? 1 : 0;
                                z = true;
                                if (!this.paused) {
                                }
                                if (this.canceled) {
                                }
                                th2 = null;
                                synchronized (this) {
                                }
                            }
                        }
                        try {
                            Buffer read = iInput.read();
                            if (z2) {
                                j3 += System.nanoTime() - j8;
                            }
                            j2 = j3;
                            try {
                                int i4 = read.size;
                                if (i4 == -1) {
                                    try {
                                        outputDone(read.output);
                                        iBufferPool.recycle(read);
                                        j3 = j2;
                                    } catch (StreamClosedException e4) {
                                        e = e4;
                                        j4 = j7;
                                        i = z3 ? 1 : 0;
                                        j3 = j2;
                                        i3 = i2;
                                        this.exception = e;
                                        throw e;
                                    } catch (BaseException e5) {
                                        e = e5;
                                        j6 = j7;
                                        i = z3 ? 1 : 0;
                                        z = true;
                                        if (!this.paused) {
                                        }
                                        if (!this.canceled) {
                                        }
                                        th4 = null;
                                        synchronized (this) {
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                        j = j7;
                                        i = z3 ? 1 : 0;
                                        z = true;
                                        if (!this.paused) {
                                        }
                                        if (this.canceled) {
                                        }
                                        th2 = null;
                                        synchronized (this) {
                                        }
                                    }
                                } else {
                                    if (z2) {
                                        j8 = System.nanoTime();
                                    }
                                    read.output.write(read);
                                    if (z2) {
                                        j7 += System.nanoTime() - j8;
                                    }
                                    j4 = j7;
                                    try {
                                        try {
                                            iBufferPool.recycle(read);
                                            if (this.threadDirty) {
                                                if (this.paused) {
                                                    break;
                                                }
                                                try {
                                                    if (this.canceled) {
                                                        break;
                                                    } else {
                                                        this.threadDirty = z3;
                                                    }
                                                } catch (StreamClosedException e6) {
                                                    e = e6;
                                                    i = z3 ? 1 : 0;
                                                    j3 = j2;
                                                    i3 = i2;
                                                    this.exception = e;
                                                    throw e;
                                                } catch (Throwable th10) {
                                                    th = th10;
                                                    i = z3 ? 1 : 0;
                                                    j = j4;
                                                    z = true;
                                                    if (!this.paused && !this.canceled) {
                                                        if (Logger.debug()) {
                                                            th.printStackTrace();
                                                            Logger.taskDebug(TAG, downloadInfo.getId(), "loopAndWrite", "Throwable: " + th);
                                                        }
                                                        try {
                                                            DownloadHelper.parseException(th, "loopAndWrite");
                                                            if (i2 > 0) {
                                                                try {
                                                                    iDownloadRunnableCallback.onProgress(i2);
                                                                } catch (Throwable unused) {
                                                                }
                                                            }
                                                            if (!this.canceled) {
                                                                try {
                                                                    this.needSync = z;
                                                                    flushAndSync();
                                                                } catch (Throwable th11) {
                                                                    th3 = th11;
                                                                    if (Logger.debug()) {
                                                                        Logger.taskDebug(TAG, downloadInfo.getId(), "loopAndWrite", "Finally sync, e = " + th3);
                                                                    }
                                                                    synchronized (this) {
                                                                        close(this.outputs);
                                                                        this.outputs.clear();
                                                                    }
                                                                    DownloadMonitorHelper.monitorDownloadIO(this.setting, downloadInfo, downloadInfo.getUrl(), null, this.paused, this.canceled, this.exception, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z2, j2, j, this.syncTimeNs, null);
                                                                    if (th3 != null) {
                                                                        if (((this.paused || this.canceled || this.exception != null) ? 1 : i) == 0) {
                                                                            try {
                                                                                DownloadHelper.parseException(th3, "loopAndWrite_finally");
                                                                                return;
                                                                            } catch (BaseException e7) {
                                                                                this.exception = e7;
                                                                                throw e7;
                                                                            }
                                                                        }
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                            }
                                                            th3 = null;
                                                            synchronized (this) {
                                                            }
                                                        } catch (BaseException e8) {
                                                            this.exception = e8;
                                                            throw e8;
                                                        }
                                                    }
                                                    if (this.canceled) {
                                                        try {
                                                            this.needSync = true;
                                                            flushAndSync();
                                                        } catch (Throwable th12) {
                                                            th2 = th12;
                                                            if (Logger.debug()) {
                                                                Logger.taskDebug(TAG, downloadInfo.getId(), "loopAndWrite", "Finally sync, e = " + th2);
                                                            }
                                                            synchronized (this) {
                                                                close(this.outputs);
                                                                this.outputs.clear();
                                                            }
                                                            DownloadMonitorHelper.monitorDownloadIO(this.setting, downloadInfo, downloadInfo.getUrl(), null, this.paused, this.canceled, this.exception, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z2, j2, j, this.syncTimeNs, null);
                                                            if (th2 != null) {
                                                                if (((this.paused || this.canceled || this.exception != null) ? 1 : i) == 0) {
                                                                    try {
                                                                        DownloadHelper.parseException(th2, "loopAndWrite_finally");
                                                                        return;
                                                                    } catch (BaseException e9) {
                                                                        this.exception = e9;
                                                                        throw e9;
                                                                    }
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                    }
                                                    th2 = null;
                                                    synchronized (this) {
                                                    }
                                                }
                                            }
                                            i = z3 ? 1 : 0;
                                            z = true;
                                            i2 += i4;
                                            if (i2 >= 65536) {
                                                try {
                                                    long uptimeMillis = SystemClock.uptimeMillis();
                                                    if (uptimeMillis - j9 > 200) {
                                                        boolean onProgress = iDownloadRunnableCallback.onProgress(i2);
                                                        try {
                                                            if (this.needSync) {
                                                                checkAndSync(uptimeMillis, onProgress);
                                                            }
                                                            if (!DeviceBandwidthSampler.isWifi()) {
                                                                if (downloadInfo.isOnlyWifi()) {
                                                                    DeviceBandwidthSampler.updateNetworkStatus();
                                                                    if (DeviceBandwidthSampler.isMobileNet()) {
                                                                        throw new DownloadOnlyWifiException();
                                                                    }
                                                                }
                                                                if (downloadInfo.isDownloadFromReserveWifi() && downloadInfo.isPauseReserveOnWifi()) {
                                                                    DeviceBandwidthSampler.updateNetworkStatus();
                                                                    if (DeviceBandwidthSampler.isMobileNet()) {
                                                                        throw new DownloadPauseReserveWifiException();
                                                                    }
                                                                }
                                                            }
                                                            j9 = uptimeMillis;
                                                            j3 = j2;
                                                            j7 = j4;
                                                            i2 = i;
                                                            z3 = i2;
                                                        } catch (StreamClosedException e10) {
                                                            e = e10;
                                                            j3 = j2;
                                                            i3 = i;
                                                            this.exception = e;
                                                            throw e;
                                                        } catch (BaseException e11) {
                                                            e = e11;
                                                            j6 = j4;
                                                            i2 = i;
                                                            if (!this.paused) {
                                                            }
                                                            if (!this.canceled) {
                                                            }
                                                            th4 = null;
                                                            synchronized (this) {
                                                            }
                                                        } catch (Throwable th13) {
                                                            th = th13;
                                                            j = j4;
                                                            i2 = i;
                                                            if (!this.paused) {
                                                                if (Logger.debug()) {
                                                                }
                                                                DownloadHelper.parseException(th, "loopAndWrite");
                                                                if (i2 > 0) {
                                                                }
                                                                if (!this.canceled) {
                                                                }
                                                                th3 = null;
                                                                synchronized (this) {
                                                                }
                                                            }
                                                            if (this.canceled) {
                                                            }
                                                            th2 = null;
                                                            synchronized (this) {
                                                            }
                                                        }
                                                    }
                                                } catch (StreamClosedException e12) {
                                                    e = e12;
                                                    i3 = i2;
                                                    j3 = j2;
                                                    this.exception = e;
                                                    throw e;
                                                } catch (BaseException e13) {
                                                    e = e13;
                                                    j6 = j4;
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                    j = j4;
                                                    if (!this.paused) {
                                                    }
                                                    if (this.canceled) {
                                                    }
                                                    th2 = null;
                                                    synchronized (this) {
                                                    }
                                                }
                                            }
                                            j3 = j2;
                                            j7 = j4;
                                            z3 = i;
                                        } catch (BaseException e14) {
                                            e = e14;
                                            i = z3 ? 1 : 0;
                                            j6 = j4;
                                            z = true;
                                            if (!this.paused) {
                                                if (Logger.debug()) {
                                                }
                                                this.exception = e;
                                                throw e;
                                            }
                                            if (!this.canceled) {
                                            }
                                            th4 = null;
                                            synchronized (this) {
                                            }
                                        }
                                    } catch (StreamClosedException e15) {
                                        e = e15;
                                        i = z3 ? 1 : 0;
                                    } catch (Throwable th15) {
                                        th = th15;
                                        i = z3 ? 1 : 0;
                                        z = true;
                                    }
                                }
                            } catch (StreamClosedException e16) {
                                e = e16;
                                i = z3 ? 1 : 0;
                                i3 = i2;
                                j4 = j7;
                            } catch (BaseException e17) {
                                e = e17;
                                i = z3 ? 1 : 0;
                                j6 = j7;
                                z = true;
                                if (!this.paused) {
                                }
                                if (!this.canceled) {
                                }
                                th4 = null;
                                synchronized (this) {
                                }
                            } catch (Throwable th16) {
                                th = th16;
                                i = z3 ? 1 : 0;
                                z = true;
                                j = j7;
                                if (!this.paused) {
                                }
                                if (this.canceled) {
                                }
                                th2 = null;
                                synchronized (this) {
                                }
                            }
                        } catch (StreamClosedException e18) {
                            e = e18;
                            i = z3 ? 1 : 0;
                            i3 = i2;
                            j4 = j7;
                        } catch (BaseException e19) {
                            e = e19;
                            i = z3 ? 1 : 0;
                            j2 = j3;
                        } catch (Throwable th17) {
                            th = th17;
                            i = z3 ? 1 : 0;
                            z = true;
                            j2 = j3;
                        }
                    }
                    if (i2 > 0) {
                        try {
                            iDownloadRunnableCallback.onProgress(i2);
                        } catch (Throwable unused2) {
                        }
                    }
                    if (!this.canceled) {
                        try {
                            this.needSync = true;
                            flushAndSync();
                        } catch (Throwable th18) {
                            th6 = th18;
                            if (Logger.debug()) {
                                Logger.taskDebug(TAG, downloadInfo.getId(), "loopAndWrite", "Finally sync, e = " + th6);
                            }
                        }
                    }
                    th6 = null;
                    synchronized (this) {
                        close(this.outputs);
                        this.outputs.clear();
                    }
                    long curBytes2 = downloadInfo.getCurBytes() - curBytes;
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    DownloadSetting downloadSetting = this.setting;
                    String url = downloadInfo.getUrl();
                    boolean z4 = this.paused;
                    boolean z5 = this.canceled;
                    BaseException baseException = this.exception;
                    long j10 = this.syncTimeNs;
                    boolean z6 = z3 ? 1 : 0;
                    DownloadMonitorHelper.monitorDownloadIO(downloadSetting, downloadInfo, url, null, z4, z5, baseException, curBytes2, nanoTime2, z2, j2, j4, j10, null);
                    if (th6 != null) {
                        if ((this.paused || this.canceled || this.exception != null) ? true : z6) {
                            return;
                        }
                        try {
                            DownloadHelper.parseException(th6, "loopAndWrite_finally");
                        } catch (BaseException e20) {
                            this.exception = e20;
                            throw e20;
                        }
                    }
                } catch (BaseException e21) {
                    e = e21;
                    i = 0;
                    i2 = 0;
                    z = true;
                    j6 = 0;
                    j2 = 0;
                    if (!this.paused && !this.canceled) {
                        if (Logger.debug()) {
                            e.printStackTrace();
                            Logger.taskDebug(TAG, downloadInfo.getId(), "loopAndWrite", "BaseException: " + e);
                        }
                        this.exception = e;
                        throw e;
                    }
                    if (!this.canceled) {
                        try {
                            this.needSync = z;
                            flushAndSync();
                        } catch (Throwable th19) {
                            th4 = th19;
                            if (Logger.debug()) {
                                Logger.taskDebug(TAG, downloadInfo.getId(), "loopAndWrite", "Finally sync, e = " + th4);
                            }
                            synchronized (this) {
                                close(this.outputs);
                                this.outputs.clear();
                            }
                            DownloadMonitorHelper.monitorDownloadIO(this.setting, downloadInfo, downloadInfo.getUrl(), null, this.paused, this.canceled, this.exception, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z2, j2, j6, this.syncTimeNs, null);
                            if (th4 != null) {
                                if (((this.paused || this.canceled || this.exception != null) ? 1 : i) == 0) {
                                    try {
                                        DownloadHelper.parseException(th4, "loopAndWrite_finally");
                                        return;
                                    } catch (BaseException e22) {
                                        this.exception = e22;
                                        throw e22;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                    }
                    th4 = null;
                    synchronized (this) {
                    }
                }
            } catch (Throwable th20) {
                j5 = j2;
                th = th20;
                if (i2 > 0) {
                    try {
                        iDownloadRunnableCallback.onProgress(i2);
                    } catch (Throwable unused3) {
                    }
                }
                if (this.canceled) {
                    try {
                        this.needSync = true;
                        flushAndSync();
                    } catch (Throwable th21) {
                        th5 = th21;
                        if (Logger.debug()) {
                            Logger.taskDebug(TAG, downloadInfo.getId(), "loopAndWrite", "Finally sync, e = " + th5);
                        }
                        synchronized (this) {
                        }
                    }
                }
                th5 = null;
                synchronized (this) {
                    close(this.outputs);
                    this.outputs.clear();
                }
                DownloadMonitorHelper.monitorDownloadIO(this.setting, downloadInfo, downloadInfo.getUrl(), null, this.paused, this.canceled, this.exception, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z2, j5, j, this.syncTimeNs, null);
                if (th5 == null) {
                    throw th;
                }
                if (((this.paused || this.canceled || this.exception != null) ? 1 : i) != 0) {
                    throw th;
                }
                try {
                    DownloadHelper.parseException(th5, "loopAndWrite_finally");
                    throw th;
                } catch (BaseException e23) {
                    this.exception = e23;
                    throw e23;
                }
            }
        } catch (StreamClosedException e24) {
            e = e24;
            i = 0;
            j3 = 0;
            j4 = 0;
        } catch (Throwable th22) {
            th = th22;
            i = 0;
            z = true;
            i2 = 0;
            j = 0;
            j2 = 0;
        }
    }

    private void checkAndSync(long j, boolean z) throws IOException {
        long j2 = j - this.lastSyncTimestamp;
        if (this.hasSyncStrategy) {
            if (j2 > (this.appStatusManager.isAppForeground() ? this.syncIntervalMsFg : this.syncIntervalMsBg)) {
                flushAndSync();
                this.lastSyncTimestamp = j;
                return;
            }
            return;
        }
        long curBytes = this.downloadInfo.getCurBytes() - this.lastSyncBytes;
        if (z || isNeedSync(curBytes, j2)) {
            flushAndSync();
            this.lastSyncTimestamp = j;
        }
    }

    public long getLastSyncBytes() {
        return this.lastSyncBytes;
    }

    private void outputDone(IOutput iOutput) {
        synchronized (this) {
            this.doneOutputs.add((SegmentOutput) iOutput);
        }
    }

    private void flushAndSync() throws IOException {
        boolean z;
        boolean z2 = this.isMonitorRw;
        long nanoTime = z2 ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.downloadInfo;
        IDownloadCache iDownloadCache = this.downloadCache;
        List<SegmentOutput> list = this.outputs;
        List<SegmentOutput> list2 = this.doneOutputs;
        Map<Long, Segment> segmentMap = iDownloadCache.getSegmentMap(downloadInfo.getId());
        if (segmentMap == null) {
            segmentMap = new HashMap<>(4);
        }
        synchronized (this) {
            flush(list);
            try {
                if (this.needSync) {
                    sync(list);
                }
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
                z = false;
            }
            updateSegmentToMap(list, segmentMap);
            if (list2.size() > 0) {
                close(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z) {
            downloadInfo.updateRealDownloadTime(true);
            iDownloadCache.updateSegments(downloadInfo.getId(), segmentMap);
            iDownloadCache.updateDownloadInfo(downloadInfo);
            this.lastSyncBytes = downloadInfo.getCurBytes();
        }
        if (z2) {
            this.syncTimeNs += System.nanoTime() - nanoTime;
        }
    }

    private void flush(List<SegmentOutput> list) throws IOException {
        Iterator<SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            it.next().flush();
        }
    }

    private void sync(List<SegmentOutput> list) throws IOException {
        Iterator<SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            it.next().sync();
        }
    }

    private void close(List<SegmentOutput> list) {
        Iterator<SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    private void updateSegmentToMap(List<SegmentOutput> list, Map<Long, Segment> map) {
        Iterator<SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            Segment segment = it.next().getSegment();
            Segment segment2 = map.get(Long.valueOf(segment.getStartOffset()));
            if (segment2 == null) {
                map.put(Long.valueOf(segment.getStartOffset()), new Segment(segment));
            } else {
                segment2.setCurrentOffset(segment.getCurrentOffset());
                segment2.setEndOffset(segment.getEndOffset());
            }
        }
    }

    public void cancel() {
        this.canceled = true;
        this.threadDirty = true;
    }

    public void pause() {
        this.paused = true;
        this.threadDirty = true;
    }
}
