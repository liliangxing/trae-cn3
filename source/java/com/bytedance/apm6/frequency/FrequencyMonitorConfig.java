package com.bytedance.apm6.frequency;

import java.util.HashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class FrequencyMonitorConfig {
    private static final float DEFAULT_EXCEPTION_BACKGROUND_THRESHOLD = 100.0f;
    private static final float DEFAULT_EXCEPTION_FRONT_THRESHOLD = 1000.0f;
    private static final float DEFAULT_REPORT_BACKGROUND_THRESHOLD = 2.0f;
    private static final float DEFAULT_REPORT_FRONT_THRESHOLD = 20.0f;
    public static final int MAX_SAMPLING_RANGE = 10000;
    private final HashMap<String, Float> mBackExceptionThresholdPerMin;
    private final int mBackgroundExceptionCheckInterval;
    private final boolean mEnableExceptionMonitor;
    private final boolean mEnableFrequencyMonitor;
    private final int mEventSamplingRate;
    private final int mExceptionReportTopCount;
    private final int mFrontExceptionCheckInterval;
    private final HashMap<String, Float> mFrontExceptionThresholdPerMin;
    private final HashMap<String, Float> mReportBackgroundThreshold;
    private final HashMap<String, Float> mReportFrontThreshold;
    private final int mReportInterval;

    FrequencyMonitorConfig(boolean z, boolean z2, int i, int i2, HashMap<String, Float> hashMap, HashMap<String, Float> hashMap2, int i3, int i4, int i5, HashMap<String, Float> hashMap3, HashMap<String, Float> hashMap4) {
        this.mEnableFrequencyMonitor = z;
        this.mEnableExceptionMonitor = z2;
        this.mFrontExceptionCheckInterval = i;
        this.mBackgroundExceptionCheckInterval = i2;
        this.mFrontExceptionThresholdPerMin = hashMap;
        this.mBackExceptionThresholdPerMin = hashMap2;
        this.mExceptionReportTopCount = i3;
        this.mReportInterval = i4;
        this.mEventSamplingRate = i5;
        this.mReportFrontThreshold = hashMap3;
        this.mReportBackgroundThreshold = hashMap4;
    }

    public boolean enableFrequencyMonitor() {
        return this.mEnableFrequencyMonitor;
    }

    public boolean enableExceptionMonitor() {
        return this.mEnableExceptionMonitor;
    }

    public int getExceptionCheckInterval(boolean z) {
        return (z ? this.mFrontExceptionCheckInterval : this.mBackgroundExceptionCheckInterval) * 1000;
    }

    public float getExceptionThresholdOfCategory(String str, boolean z) {
        if (z) {
            Float f = this.mFrontExceptionThresholdPerMin.get(str);
            return f == null ? DEFAULT_EXCEPTION_FRONT_THRESHOLD : f.floatValue();
        }
        Float f2 = this.mBackExceptionThresholdPerMin.get(str);
        if (f2 == null) {
            return 100.0f;
        }
        return f2.floatValue();
    }

    public int getExceptionReportTopCount() {
        return this.mExceptionReportTopCount;
    }

    public int getReportInterval() {
        return this.mReportInterval * 1000;
    }

    public int getEventSamplingRate() {
        return this.mEventSamplingRate;
    }

    public float getReportThresholdOfCategory(String str, boolean z) {
        if (z) {
            Float f = this.mReportFrontThreshold.get(str);
            return f == null ? DEFAULT_REPORT_FRONT_THRESHOLD : f.floatValue();
        }
        Float f2 = this.mReportBackgroundThreshold.get(str);
        return f2 == null ? DEFAULT_REPORT_BACKGROUND_THRESHOLD : f2.floatValue();
    }

    public String toString() {
        return "FrequencyMonitorConfig{mEnableFrequencyMonitor=" + this.mEnableFrequencyMonitor + ", mEnableExceptionMonitor=" + this.mEnableExceptionMonitor + ", mBackgroundExceptionCheckInterval=" + this.mBackgroundExceptionCheckInterval + ", mFrontExceptionCheckInterval=" + this.mFrontExceptionCheckInterval + ", mFrontExceptionThresholdPerMin=" + this.mFrontExceptionThresholdPerMin + ", mBackExceptionThresholdPerMin=" + this.mBackExceptionThresholdPerMin + ", mExceptionReportTopCount=" + this.mExceptionReportTopCount + ", mReportInterval=" + this.mReportInterval + ", mEventSamplingRate=" + this.mEventSamplingRate + ", mReportFrontThreshold=" + this.mReportFrontThreshold + ", mReportBackgroundThreshold=" + this.mReportBackgroundThreshold + AbstractJsonLexerKt.END_OBJ;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private boolean enableFrequencyMonitor = false;
        private boolean enableExceptionMonitor = false;
        private int frontExceptionCheckInterval = 120;
        private int backgroundExceptionCheckInterval = 600;
        private HashMap<String, Float> frontExceptionThresholdPerMin = new HashMap<>();
        private HashMap<String, Float> backgroundExceptionThresholdPerMin = new HashMap<>();
        private int exceptionReportTopCount = 5;
        private int reportInterval = 600;
        private int eventSamplingRate = 1000;
        private HashMap<String, Float> frontReportThreshold = new HashMap<>();
        private HashMap<String, Float> backgroundReportThreshold = new HashMap<>();

        public Builder enableFrequencyMonitor(boolean z) {
            this.enableFrequencyMonitor = z;
            return this;
        }

        public Builder enableExceptionMonitor(boolean z) {
            this.enableExceptionMonitor = z;
            return this;
        }

        public Builder frontExceptionCheckInterval(int i) {
            if (i > 0) {
                this.frontExceptionCheckInterval = i;
            }
            return this;
        }

        public Builder backgroundExceptionCheckInterval(int i) {
            if (i > 0) {
                this.backgroundExceptionCheckInterval = i;
            }
            return this;
        }

        public Builder frontExceptionThresholdPerMin(HashMap<String, Float> hashMap) {
            if (hashMap != null) {
                this.frontExceptionThresholdPerMin = hashMap;
            }
            return this;
        }

        public Builder backgroundExceptionThresholdPerMin(HashMap<String, Float> hashMap) {
            if (hashMap != null) {
                this.backgroundExceptionThresholdPerMin = hashMap;
            }
            return this;
        }

        public Builder exceptionReportTopCount(int i) {
            if (i > 0) {
                this.exceptionReportTopCount = i;
            }
            return this;
        }

        public Builder reportInterval(int i) {
            if (i > 0) {
                this.reportInterval = i;
            }
            return this;
        }

        public Builder eventSamplingRate(int i) {
            if (i > 0 && i <= 10000) {
                this.eventSamplingRate = i;
            }
            return this;
        }

        public Builder frontReportThreshold(HashMap<String, Float> hashMap) {
            if (hashMap != null) {
                this.frontReportThreshold = hashMap;
            }
            return this;
        }

        public Builder backgroundReportThreshold(HashMap<String, Float> hashMap) {
            if (hashMap != null) {
                this.backgroundReportThreshold = hashMap;
            }
            return this;
        }

        public FrequencyMonitorConfig build() {
            return new FrequencyMonitorConfig(this.enableFrequencyMonitor, this.enableExceptionMonitor, this.frontExceptionCheckInterval, this.backgroundExceptionCheckInterval, this.frontExceptionThresholdPerMin, this.backgroundExceptionThresholdPerMin, this.exceptionReportTopCount, this.reportInterval, this.eventSamplingRate, this.frontReportThreshold, this.backgroundReportThreshold);
        }
    }
}
