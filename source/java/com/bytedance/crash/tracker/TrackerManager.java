package com.bytedance.crash.tracker;

import com.bytedance.crash.runtime.DefaultWorkThread;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TrackerManager {
    public static void start() {
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.tracker.TrackerManager.1
            @Override // java.lang.Runnable
            public void run() {
                BatteryTracker.start();
            }
        });
    }

    public static void startActivityTrack() {
        ActivityLifecycle.start();
    }
}
