package com.bytedance.geckox.policy.queue;

import com.bytedance.geckox.logger.GeckoLogger;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class UpdateTaskManager {
    private final AtomicBoolean paused = new AtomicBoolean(false);
    private final Object pauseLock = new Object();

    AtomicBoolean getPause() {
        return this.paused;
    }

    public void pauseUpdate() {
        GeckoLogger.d("gecko update pause");
        this.paused.set(true);
    }

    public void resumeUpdate() {
        GeckoLogger.d("gecko update resume");
        this.paused.set(false);
        synchronized (this.pauseLock) {
            this.pauseLock.notifyAll();
        }
    }

    public Object getPauseLock() {
        return this.pauseLock;
    }

    public boolean waitIfPaused() {
        AtomicBoolean pause = getPause();
        if (!pause.get()) {
            return false;
        }
        synchronized (getPauseLock()) {
            if (pause.get()) {
                try {
                    GeckoLogger.d("channel update wait:" + new SimpleDateFormat("MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())));
                    getPauseLock().wait();
                } catch (InterruptedException unused) {
                    return true;
                }
            }
        }
        return false;
    }
}
