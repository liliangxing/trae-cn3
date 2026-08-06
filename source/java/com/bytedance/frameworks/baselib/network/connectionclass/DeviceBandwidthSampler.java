package com.bytedance.frameworks.baselib.network.connectionclass;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.thread.PlatformHandlerThread;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class DeviceBandwidthSampler {
    private static long sPreviousBytes = -1;
    private final ConnectionClassManager mConnectionClassManager;
    private SamplingHandler mHandler;
    private boolean mInvalid;
    private long mLastTimeReading;
    private AtomicInteger mSamplingCounter;
    private HandlerThread mThread;

    /* loaded from: classes2.dex */
    private static class DeviceBandwidthSamplerHolder {
        public static final DeviceBandwidthSampler instance = new DeviceBandwidthSampler(ConnectionClassManager.getInstance());

        private DeviceBandwidthSamplerHolder() {
        }
    }

    public static DeviceBandwidthSampler getInstance() {
        return DeviceBandwidthSamplerHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DeviceBandwidthSampler(ConnectionClassManager connectionClassManager) {
        this.mInvalid = false;
        this.mConnectionClassManager = connectionClassManager;
        try {
            this.mSamplingCounter = new AtomicInteger();
            HandlerThread newHandlerThread = PlatformHandlerThread.getNewHandlerThread("ParseThread");
            this.mThread = newHandlerThread;
            newHandlerThread.start();
            this.mHandler = new SamplingHandler(this.mThread.getLooper());
        } catch (Throwable unused) {
            this.mInvalid = true;
        }
    }

    public void startSampling() {
        try {
            if (!this.mInvalid && this.mSamplingCounter.getAndIncrement() == 0) {
                if (Logger.debug()) {
                    Logger.d("ConnectionClassManager", "startSampling");
                }
                this.mHandler.startSamplingThread();
                this.mLastTimeReading = SystemClock.elapsedRealtime();
            }
        } catch (Throwable unused) {
        }
    }

    public void stopSampling() {
        try {
            if (!this.mInvalid && this.mSamplingCounter.decrementAndGet() == 0) {
                if (Logger.debug()) {
                    Logger.d("ConnectionClassManager", "stopSampling");
                }
                this.mHandler.stopSamplingThread();
                addFinalSample();
            }
        } catch (Throwable unused) {
        }
    }

    protected void addSample() {
        try {
            long totalRxBytes = TrafficStats.getTotalRxBytes();
            long j = sPreviousBytes;
            long j2 = totalRxBytes - j;
            if (j >= 0) {
                synchronized (this) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    this.mConnectionClassManager.addBandwidth(j2, elapsedRealtime - this.mLastTimeReading);
                    this.mLastTimeReading = elapsedRealtime;
                }
            }
            sPreviousBytes = totalRxBytes;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void addFinalSample() {
        addSample();
        sPreviousBytes = -1L;
    }

    public boolean isSampling() {
        return this.mSamplingCounter.get() != 0;
    }

    /* loaded from: classes2.dex */
    private class SamplingHandler extends Handler {
        private static final int MSG_START = 1;
        static final long SAMPLE_TIME = 1000;

        public SamplingHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (message.what != 1) {
                    return;
                }
                DeviceBandwidthSampler.this.addSample();
                sendEmptyMessageDelayed(1, 1000L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void startSamplingThread() {
            sendEmptyMessage(1);
        }

        public void stopSamplingThread() {
            removeMessages(1);
        }
    }
}
