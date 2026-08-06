package com.bytedance.apm;

import com.bytedance.apm.config.FluencyConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FluencySwitchManager {
    private static List<FluencySwitchListener> mListeners = new ArrayList(2);

    public static synchronized void addListener(FluencySwitchListener fluencySwitchListener) {
        synchronized (FluencySwitchManager.class) {
            mListeners.add(fluencySwitchListener);
        }
    }

    public static synchronized void removeListener(FluencySwitchListener fluencySwitchListener) {
        synchronized (FluencySwitchManager.class) {
            mListeners.remove(fluencySwitchListener);
        }
    }

    public static synchronized void notify(FluencyConfig fluencyConfig) {
        synchronized (FluencySwitchManager.class) {
            for (FluencySwitchListener fluencySwitchListener : mListeners) {
                if (fluencySwitchListener != null) {
                    fluencySwitchListener.onRefresh(fluencyConfig);
                }
            }
        }
    }
}
