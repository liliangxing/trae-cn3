package com.bytedance.apm.block;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class EvilMethodSwitchManager {
    private static List<EvilMethodSwitchListener> mListeners = new ArrayList(2);

    public static synchronized void addListener(EvilMethodSwitchListener evilMethodSwitchListener) {
        synchronized (EvilMethodSwitchManager.class) {
            mListeners.add(evilMethodSwitchListener);
        }
    }

    public static synchronized void removeListener(EvilMethodSwitchListener evilMethodSwitchListener) {
        synchronized (EvilMethodSwitchManager.class) {
            mListeners.remove(evilMethodSwitchListener);
        }
    }

    public static synchronized void notify(boolean z, long j) {
        synchronized (EvilMethodSwitchManager.class) {
            for (EvilMethodSwitchListener evilMethodSwitchListener : mListeners) {
                if (evilMethodSwitchListener != null) {
                    evilMethodSwitchListener.onRefresh(z, j);
                }
            }
        }
    }
}
