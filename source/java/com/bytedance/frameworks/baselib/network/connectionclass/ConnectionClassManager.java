package com.bytedance.frameworks.baselib.network.connectionclass;

import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class ConnectionClassManager {
    static final long BANDWIDTH_LOWER_BOUND = 3;
    private static final int BYTES_TO_BITS = 8;
    private static final double DEFAULT_DECAY_CONSTANT = 0.05d;
    static final int DEFAULT_GOOD_BANDWIDTH = 560;
    static final long DEFAULT_HYSTERESIS_PERCENT = 20;
    static final int DEFAULT_MODERATE_BANDWIDTH = 112;
    static final int DEFAULT_POOR_BANDWIDTH = 28;
    static final double DEFAULT_SAMPLES_TO_QUALITY_CHANGE = 5.0d;
    private static final double HYSTERESIS_BOTTOM_MULTIPLIER = 0.8d;
    private static final double HYSTERESIS_TOP_MULTIPLIER = 1.25d;
    private AtomicReference<ConnectionQuality> mNextBandwidthConnectionQuality;
    private int mSampleCounter;
    private ExponentialGeometricAverage mDownloadBandwidth = new ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
    private volatile boolean mInitiateStateChange = false;
    private AtomicReference<ConnectionQuality> mCurrentBandwidthConnectionQuality = new AtomicReference<>(ConnectionQuality.UNKNOWN);
    private ArrayList<ConnectionClassStateChangeListener> mListenerList = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface ConnectionClassStateChangeListener {
        void onBandwidthStateChange(ConnectionQuality connectionQuality);
    }

    /* loaded from: classes2.dex */
    private static class ConnectionClassManagerHolder {
        public static final ConnectionClassManager instance = new ConnectionClassManager();

        private ConnectionClassManagerHolder() {
        }
    }

    public static ConnectionClassManager getInstance() {
        return ConnectionClassManagerHolder.instance;
    }

    public synchronized void addBandwidth(long j, long j2) {
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d < 3.0d) {
            return;
        }
        try {
            if (Logger.debug()) {
                Logger.d("ConnectionClassManager", "bytes = " + j + " timeInMs = " + j2 + " bandwidth = " + d);
            }
            this.mDownloadBandwidth.addMeasurement(d);
        } catch (Throwable unused) {
        }
        if (this.mInitiateStateChange) {
            this.mSampleCounter++;
            if (getCurrentBandwidthQuality() != this.mNextBandwidthConnectionQuality.get()) {
                this.mInitiateStateChange = false;
                this.mSampleCounter = 1;
            }
            if (this.mSampleCounter >= DEFAULT_SAMPLES_TO_QUALITY_CHANGE && significantlyOutsideCurrentBand()) {
                this.mInitiateStateChange = false;
                this.mSampleCounter = 1;
                this.mCurrentBandwidthConnectionQuality.set(this.mNextBandwidthConnectionQuality.get());
                notifyListeners();
            }
            return;
        }
        if (this.mCurrentBandwidthConnectionQuality.get() != getCurrentBandwidthQuality()) {
            this.mInitiateStateChange = true;
            this.mNextBandwidthConnectionQuality = new AtomicReference<>(getCurrentBandwidthQuality());
        }
    }

    private boolean significantlyOutsideCurrentBand() {
        double d;
        if (this.mDownloadBandwidth == null) {
            return false;
        }
        try {
            ConnectionQuality connectionQuality = this.mCurrentBandwidthConnectionQuality.get();
            double d2 = 28.0d;
            if (ConnectionQuality.POOR == connectionQuality) {
                d = 0.0d;
            } else {
                if (ConnectionQuality.MODERATE != connectionQuality) {
                    d2 = 560.0d;
                    if (ConnectionQuality.GOOD != connectionQuality) {
                        d = ConnectionQuality.EXCELLENT == connectionQuality ? 3.4028234663852886E38d : 112.0d;
                        return true;
                    }
                }
                double d3 = d2;
                d2 = d;
                d = d3;
            }
            double average = this.mDownloadBandwidth.getAverage();
            if (average > d2) {
                if (average > d2 * HYSTERESIS_TOP_MULTIPLIER) {
                    return true;
                }
            } else if (average < d * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public void reset() {
        try {
            ExponentialGeometricAverage exponentialGeometricAverage = this.mDownloadBandwidth;
            if (exponentialGeometricAverage != null) {
                exponentialGeometricAverage.reset();
            }
            this.mCurrentBandwidthConnectionQuality.set(ConnectionQuality.UNKNOWN);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized ConnectionQuality getCurrentBandwidthQuality() {
        ExponentialGeometricAverage exponentialGeometricAverage = this.mDownloadBandwidth;
        if (exponentialGeometricAverage == null) {
            return ConnectionQuality.UNKNOWN;
        }
        try {
            return mapBandwidthQuality(exponentialGeometricAverage.getAverage());
        } catch (Throwable th) {
            th.printStackTrace();
            return ConnectionQuality.UNKNOWN;
        }
    }

    private ConnectionQuality mapBandwidthQuality(double d) {
        if (d < 0.0d) {
            return ConnectionQuality.UNKNOWN;
        }
        if (d < 28.0d) {
            return ConnectionQuality.POOR;
        }
        if (d < 112.0d) {
            return ConnectionQuality.MODERATE;
        }
        if (d < 560.0d) {
            return ConnectionQuality.GOOD;
        }
        return ConnectionQuality.EXCELLENT;
    }

    public synchronized double getDownloadKBitsPerSecond() {
        ExponentialGeometricAverage exponentialGeometricAverage;
        exponentialGeometricAverage = this.mDownloadBandwidth;
        return exponentialGeometricAverage == null ? -1.0d : exponentialGeometricAverage.getAverage();
    }

    public ConnectionQuality register(ConnectionClassStateChangeListener connectionClassStateChangeListener) {
        if (connectionClassStateChangeListener != null) {
            this.mListenerList.add(connectionClassStateChangeListener);
        }
        return this.mCurrentBandwidthConnectionQuality.get();
    }

    public void remove(ConnectionClassStateChangeListener connectionClassStateChangeListener) {
        if (connectionClassStateChangeListener != null) {
            this.mListenerList.remove(connectionClassStateChangeListener);
        }
    }

    private void notifyListeners() {
        try {
            int size = this.mListenerList.size();
            for (int i = 0; i < size; i++) {
                this.mListenerList.get(i).onBandwidthStateChange(this.mCurrentBandwidthConnectionQuality.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
