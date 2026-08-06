package com.ss.android.socialbase.downloader.network.throttle;

import android.net.TrafficStats;
import com.ss.android.socialbase.downloader.network.ExponentialGeometricAverage;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class SmartThrottleInputStream extends ThrottleInputStream {
    private static final double DEFAULT_DECAY_CONSTANT = 0.1d;
    public static final float DEFAULT_THROTTLE_FACTOR_MAX = 0.7f;
    public static final float DEFAULT_THROTTLE_FACTOR_MIN = 0.1f;
    private static final int LEFT_MOVE = -1;
    private static final int RIGHT_MOVE = 1;
    private static final String TAG = "SmartThrottle";
    private long curReadBytes;
    private long curTotalBytes;
    private double lastOtherAvgSpeed;
    private double lastReadAvgSpeed;
    private long lastReadBytes;
    private long lastStatsSpeedTime;
    private double lastTotalAvgSpeed;
    private long lastTotalBytes;
    private long lastUpdateThrottleFactorTime;
    private int otherSpeedDeltaThreshold;
    private long overSleepTime;
    private double pendingOtherAvgSpeedDelta;
    private final ExponentialGeometricAverage readSpeedAverage;
    private long statsSpeedPeriod;
    private float throttleFactor;
    private float throttleFactorMax;
    private final float throttleFactorMiddle;
    private float throttleFactorMin;
    private int throttleFactorMoveTrend;
    private float throttleFactorStep;
    private final ExponentialGeometricAverage totalSpeedAverage;
    private long updateThrottleFactorPeriod;

    public SmartThrottleInputStream(InputStream inputStream, float f, float f2) {
        super(inputStream);
        this.throttleFactorMin = 0.1f;
        this.throttleFactorMax = 0.7f;
        this.throttleFactor = 0.1f;
        this.throttleFactorStep = 0.1f;
        this.statsSpeedPeriod = 1000L;
        this.updateThrottleFactorPeriod = 2000L;
        this.readSpeedAverage = new ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
        this.totalSpeedAverage = new ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
        this.throttleFactorMoveTrend = 1;
        this.otherSpeedDeltaThreshold = 60;
        if (f < f2 && f >= 0.0f && f < 1.0f) {
            this.throttleFactorMin = f;
        }
        if (f < f2 && f2 > 0.0f && f2 <= 1.0f) {
            this.throttleFactorMax = f2;
        }
        this.throttleFactorMiddle = (this.throttleFactorMin + this.throttleFactorMax) / 2.0f;
    }

    @Override // com.ss.android.socialbase.downloader.network.throttle.ThrottleInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.throttleNetSpeed == -1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.periodStartTime > this.throttlePeriod) {
                this.periodStartTime = currentTimeMillis;
                statsSpeed(currentTimeMillis);
                updateThrottleFactor(currentTimeMillis);
                long j = (long) (this.throttlePeriod * (1.0f - this.throttleFactor));
                long j2 = this.overSleepTime;
                if (j2 >= j) {
                    this.overSleepTime = j2 - j;
                } else {
                    if (j2 > 0) {
                        j -= j2;
                        this.overSleepTime = 0L;
                    }
                    if (j > 0) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        try {
                            Thread.sleep(j);
                            long currentTimeMillis3 = (System.currentTimeMillis() - currentTimeMillis2) - j;
                            if (currentTimeMillis3 > 0) {
                                this.overSleepTime = currentTimeMillis3;
                            }
                        } catch (InterruptedException e) {
                            throw new IOException(e);
                        }
                    }
                }
            }
            int superRead = superRead(bArr, i, i2);
            if (superRead != -1) {
                this.curReadBytes += superRead;
            }
            return superRead;
        }
        return super.read(bArr, i, i2);
    }

    private void statsSpeed(long j) {
        long j2 = this.lastStatsSpeedTime;
        if (j - j2 >= this.statsSpeedPeriod) {
            double d = j - j2;
            if (j2 <= 0 || d <= 0.0d) {
                this.lastStatsSpeedTime = j;
                this.lastTotalBytes = TrafficStats.getTotalRxBytes();
                this.lastReadBytes = this.curReadBytes;
                return;
            }
            this.lastStatsSpeedTime = j;
            long totalRxBytes = TrafficStats.getTotalRxBytes();
            this.curTotalBytes = totalRxBytes;
            long j3 = this.curReadBytes;
            long j4 = j3 - this.lastReadBytes;
            long j5 = totalRxBytes - this.lastTotalBytes;
            this.lastReadBytes = j3;
            this.lastTotalBytes = totalRxBytes;
            this.readSpeedAverage.addMeasurement(j4 / d);
            this.totalSpeedAverage.addMeasurement(j5 / d);
        }
    }

    private void updateThrottleFactor(long j) {
        long j2 = this.lastUpdateThrottleFactorTime;
        if (j - j2 >= this.updateThrottleFactorPeriod) {
            if (j2 == 0) {
                this.lastUpdateThrottleFactorTime = j;
                return;
            }
            this.lastUpdateThrottleFactorTime = j;
            double average = this.readSpeedAverage.getAverage();
            double average2 = this.totalSpeedAverage.getAverage();
            double d = average2 - average;
            double d2 = average - this.lastReadAvgSpeed;
            double d3 = average2 - this.lastTotalAvgSpeed;
            double d4 = d - this.lastOtherAvgSpeed;
            this.lastReadAvgSpeed = average;
            this.lastTotalAvgSpeed = average2;
            this.lastOtherAvgSpeed = d;
            int calculatorThrottleFactorTrend = calculatorThrottleFactorTrend(d2, d3, d4);
            if (calculatorThrottleFactorTrend > 0) {
                rightMoveThrottleFactor();
                return;
            }
            if (calculatorThrottleFactorTrend < 0) {
                leftMoveThrottleFactor();
            } else if (this.throttleFactor < this.throttleFactorMiddle) {
                addThrottleFactor(this.throttleFactorStep);
            } else {
                addThrottleFactor(-this.throttleFactorStep);
            }
        }
    }

    private int calculatorThrottleFactorTrend(double d, double d2, double d3) {
        double d4 = d3 + this.pendingOtherAvgSpeedDelta;
        this.pendingOtherAvgSpeedDelta = 0.0d;
        int i = this.otherSpeedDeltaThreshold;
        if (d4 >= i || d4 < (-i)) {
            return -1;
        }
        this.pendingOtherAvgSpeedDelta = d4;
        return d4 > ((double) (((float) (-i)) / 2.0f)) ? 1 : 0;
    }

    private void leftMoveThrottleFactor() {
        float f;
        if (this.throttleFactor > this.throttleFactorMiddle) {
            f = (-this.throttleFactorStep) * 2.0f;
        } else {
            f = -this.throttleFactorStep;
        }
        addThrottleFactor(f);
    }

    private void rightMoveThrottleFactor() {
        float f;
        if (this.throttleFactor < this.throttleFactorMiddle) {
            f = this.throttleFactorStep * 2.0f;
        } else {
            f = this.throttleFactorStep;
        }
        addThrottleFactor(f);
    }

    private void addThrottleFactor(float f) {
        float max;
        if (f > 0.0f) {
            if (this.throttleFactor >= this.throttleFactorMax) {
                f = -this.throttleFactorStep;
            }
        } else if (f < 0.0f && this.throttleFactor <= this.throttleFactorMin) {
            f = this.throttleFactorStep;
        }
        float f2 = this.throttleFactor + f;
        this.throttleFactor = f2;
        if (f > 0.0f) {
            this.throttleFactorMoveTrend = 1;
            max = Math.min(f2, this.throttleFactorMax);
        } else {
            this.throttleFactorMoveTrend = -1;
            max = Math.max(this.throttleFactorMin, f2);
        }
        this.throttleFactor = max;
    }
}
