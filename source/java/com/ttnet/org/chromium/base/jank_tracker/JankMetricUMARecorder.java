package com.ttnet.org.chromium.base.jank_tracker;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace("base::android")
/* loaded from: classes7.dex */
public class JankMetricUMARecorder {

    /* loaded from: classes7.dex */
    public interface Natives {
        void recordJankMetrics(String str, long[] jArr, long[] jArr2, long[] jArr3, int i);
    }

    public static void recordJankMetricsToUMA(JankMetrics jankMetrics, int i) {
        if (jankMetrics == null) {
            return;
        }
        JankMetricUMARecorderJni.get().recordJankMetrics(scenarioToString(i), jankMetrics.timestampsNs, jankMetrics.durationsNs, jankMetrics.jankBurstsNs, jankMetrics.skippedFrames);
    }

    public static String scenarioToString(int i) {
        switch (i) {
            case 1:
                return "Total";
            case 2:
                return "OmniboxFocus";
            case 3:
                return "NewTabPage";
            case 4:
                return "Startup";
            case 5:
                return "TabSwitcher";
            case 6:
                return "OpenLinkInNewTab";
            case 7:
                return "StartSurfaceHomepage";
            case 8:
                return "StartSurfaceTabSwitcher";
            default:
                throw new IllegalArgumentException("Invalid scenario value");
        }
    }
}
