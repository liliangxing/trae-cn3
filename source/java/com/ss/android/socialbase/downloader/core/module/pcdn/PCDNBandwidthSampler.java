package com.ss.android.socialbase.downloader.core.module.pcdn;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes7.dex */
public class PCDNBandwidthSampler implements DeviceBandwidthSampler.ISampleListener {
    private static final String TAG = "PCDNBandwidthSampler";
    private int mDownloadId;
    private long mLastTimeReading;
    private int mLowSpeedSampleCount;
    private long mPcdnDegradeBandWidthLimit;
    private int mPcdnDegradeSampleCount;
    private long mPreviousBytes;
    private volatile boolean mEnabled = false;
    private AtomicLong mPcdnTotalBytes = new AtomicLong(0);
    private List<LowSpeedListener> mLowSpeedListeners = new CopyOnWriteArrayList();

    /* loaded from: classes7.dex */
    public interface LowSpeedListener {
        void onLowSpeed();
    }

    public PCDNBandwidthSampler(int i, long j, int i2) {
        this.mDownloadId = i;
        this.mPcdnDegradeBandWidthLimit = j;
        this.mPcdnDegradeSampleCount = i2;
        if (j <= 0 || i2 <= 0) {
            return;
        }
        DeviceBandwidthSampler.getInstance().registerSampleListener(this);
    }

    public void startSampling() {
        this.mEnabled = true;
    }

    public void stopSampling() {
        this.mEnabled = false;
        DeviceBandwidthSampler.getInstance().removeSampleListener(this);
    }

    public void register(LowSpeedListener lowSpeedListener) {
        this.mLowSpeedListeners.add(lowSpeedListener);
    }

    public void addPcdnSample(long j) {
        this.mPcdnTotalBytes.addAndGet(j);
    }

    @Override // com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler.ISampleListener
    public void addSample() {
        if (this.mEnabled) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = this.mPcdnTotalBytes.get();
            long j2 = this.mLastTimeReading;
            if (j2 <= 0) {
                this.mLastTimeReading = uptimeMillis;
                this.mPreviousBytes = j;
            } else {
                addSampleImpl(j - this.mPreviousBytes, uptimeMillis - j2);
                this.mLastTimeReading = uptimeMillis;
                this.mPreviousBytes = j;
            }
        }
    }

    private void addSampleImpl(long j, long j2) {
        if (j2 == 0) {
            return;
        }
        long j3 = j / j2;
        if (Logger.debug()) {
            Logger.taskDebug(TAG, this.mDownloadId, "addSampleImpl", "Speed:" + j3 + " byteDiff:" + j + " timeDiff:" + j2);
        }
        if (j3 < this.mPcdnDegradeBandWidthLimit) {
            int i = this.mLowSpeedSampleCount + 1;
            this.mLowSpeedSampleCount = i;
            if (i > this.mPcdnDegradeSampleCount) {
                Iterator<LowSpeedListener> it = this.mLowSpeedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onLowSpeed();
                }
                this.mLowSpeedSampleCount = 0;
                return;
            }
            return;
        }
        this.mLowSpeedSampleCount = 0;
    }
}
