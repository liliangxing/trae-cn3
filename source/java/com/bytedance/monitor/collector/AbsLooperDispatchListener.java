package com.bytedance.monitor.collector;

import android.os.Message;

/* loaded from: classes4.dex */
public abstract class AbsLooperDispatchListener {
    public static long cpuTime;
    public static long uptime;
    public volatile boolean isHasDispatchStart = false;

    public void dispatchEnd(String str) {
    }

    public boolean isValid() {
        return false;
    }

    public void dispatchStart(String str) {
        this.isHasDispatchStart = true;
    }

    public void dispatchEnd(String str, Message message) {
        this.isHasDispatchStart = false;
        dispatchEnd(str);
    }
}
