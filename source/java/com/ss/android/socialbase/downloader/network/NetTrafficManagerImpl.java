package com.ss.android.socialbase.downloader.network;

import com.ss.android.socialbase.downloader.network.NetTrafficManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public class NetTrafficManagerImpl {
    private static final long BANDWIDTH_LOWER_BOUND = 3;
    private static final int BYTES_TO_BITS = 8;
    private static final double DEFAULT_DECAY_CONSTANT = 0.05d;
    private static final int DEFAULT_GOOD_BANDWIDTH = 2000;
    private static final long DEFAULT_HYSTERESIS_PERCENT = 20;
    private static final int DEFAULT_MODERATE_BANDWIDTH = 550;
    private static final int DEFAULT_POOR_BANDWIDTH = 150;
    private static final double DEFAULT_SAMPLES_TO_QUALITY_CHANGE = 5.0d;
    private static final double HYSTERESIS_BOTTOM_MULTIPLIER = 0.8d;
    private static final double HYSTERESIS_TOP_MULTIPLIER = 1.25d;
    private final AtomicReference<NetworkQuality> currentNetworkQuality;
    private volatile boolean initiateStateChange;
    private final List<NetTrafficManager.NetworkStateChangeListener> listenerList;
    private final ExponentialGeometricAverage mDownloadBandwidth;
    private AtomicReference<NetworkQuality> nextNetworkQuality;
    private int sampleCount;

    /* synthetic */ NetTrafficManagerImpl(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* loaded from: classes7.dex */
    private static class ConnectionClassManagerHolder {
        public static final NetTrafficManagerImpl instance = new NetTrafficManagerImpl(null);

        private ConnectionClassManagerHolder() {
        }
    }

    public static NetTrafficManagerImpl getInstance() {
        return ConnectionClassManagerHolder.instance;
    }

    private NetTrafficManagerImpl() {
        this.mDownloadBandwidth = new ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
        this.initiateStateChange = false;
        this.currentNetworkQuality = new AtomicReference<>(NetworkQuality.UNKNOWN);
        this.listenerList = new CopyOnWriteArrayList();
    }

    public synchronized void addBandwidth(long j, long j2) {
        NetworkQuality currentNetworkQuality;
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d < 3.0d) {
            return;
        }
        try {
            this.mDownloadBandwidth.addMeasurement(d);
            currentNetworkQuality = getCurrentNetworkQuality();
        } catch (Throwable unused) {
        }
        if (this.initiateStateChange) {
            this.sampleCount++;
            if (currentNetworkQuality != this.nextNetworkQuality.get()) {
                this.initiateStateChange = false;
                this.sampleCount = 1;
            }
            if (this.sampleCount >= DEFAULT_SAMPLES_TO_QUALITY_CHANGE && significantlyOutsideCurrentBand()) {
                this.initiateStateChange = false;
                this.sampleCount = 1;
                this.currentNetworkQuality.set(this.nextNetworkQuality.get());
                notifyListeners();
            }
            return;
        }
        if (this.currentNetworkQuality.get() != currentNetworkQuality) {
            this.initiateStateChange = true;
            this.nextNetworkQuality = new AtomicReference<>(currentNetworkQuality);
        }
    }

    private boolean significantlyOutsideCurrentBand() {
        double d;
        if (this.mDownloadBandwidth == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.$SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[this.currentNetworkQuality.get().ordinal()];
            double d2 = 150.0d;
            if (i == 1) {
                d = 0.0d;
            } else if (i == 2) {
                d2 = 550.0d;
                d = 150.0d;
            } else if (i == 3) {
                d = 550.0d;
                d2 = 2000.0d;
            } else {
                if (i != 4) {
                    return true;
                }
                d2 = 3.4028234663852886E38d;
                d = 2000.0d;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.socialbase.downloader.network.NetTrafficManagerImpl$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality;

        static {
            int[] iArr = new int[NetworkQuality.values().length];
            $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality = iArr;
            try {
                iArr[NetworkQuality.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void reset() {
        try {
            ExponentialGeometricAverage exponentialGeometricAverage = this.mDownloadBandwidth;
            if (exponentialGeometricAverage != null) {
                exponentialGeometricAverage.reset();
            }
            this.currentNetworkQuality.set(NetworkQuality.UNKNOWN);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized NetworkQuality getCurrentNetworkQuality() {
        ExponentialGeometricAverage exponentialGeometricAverage = this.mDownloadBandwidth;
        if (exponentialGeometricAverage == null) {
            return NetworkQuality.UNKNOWN;
        }
        try {
            return mapBandwidthQuality(exponentialGeometricAverage.getAverage());
        } catch (Throwable th) {
            th.printStackTrace();
            return NetworkQuality.UNKNOWN;
        }
    }

    private NetworkQuality mapBandwidthQuality(double d) {
        if (d < 0.0d) {
            return NetworkQuality.UNKNOWN;
        }
        if (d < 150.0d) {
            return NetworkQuality.POOR;
        }
        if (d < 550.0d) {
            return NetworkQuality.MODERATE;
        }
        if (d < 2000.0d) {
            return NetworkQuality.GOOD;
        }
        return NetworkQuality.EXCELLENT;
    }

    public synchronized double getDownloadKBitsPerSecond() {
        ExponentialGeometricAverage exponentialGeometricAverage;
        exponentialGeometricAverage = this.mDownloadBandwidth;
        return exponentialGeometricAverage == null ? -1.0d : exponentialGeometricAverage.getAverage();
    }

    public double getRealTimeSpeed() {
        ExponentialGeometricAverage exponentialGeometricAverage = this.mDownloadBandwidth;
        if (exponentialGeometricAverage == null) {
            return 0.0d;
        }
        return exponentialGeometricAverage.getRealTimeSpeed();
    }

    public NetworkQuality register(NetTrafficManager.NetworkStateChangeListener networkStateChangeListener) {
        if (networkStateChangeListener != null) {
            this.listenerList.add(networkStateChangeListener);
        }
        return this.currentNetworkQuality.get();
    }

    public void remove(NetTrafficManager.NetworkStateChangeListener networkStateChangeListener) {
        if (networkStateChangeListener != null) {
            this.listenerList.remove(networkStateChangeListener);
        }
    }

    private void notifyListeners() {
        try {
            int size = this.listenerList.size();
            for (int i = 0; i < size; i++) {
                this.listenerList.get(i).onBandwidthStateChange(this.currentNetworkQuality.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
