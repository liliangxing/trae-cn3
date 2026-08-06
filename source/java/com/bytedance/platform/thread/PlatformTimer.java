package com.bytedance.platform.thread;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class PlatformTimer extends Timer {
    private static ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1);
    private Set<ScheduledFuture> set;

    private PlatformTimer() {
        this.set = new HashSet();
        super.cancel();
    }

    private PlatformTimer(boolean z) {
        super(z);
        this.set = new HashSet();
        super.cancel();
    }

    private PlatformTimer(String str) {
        super(str);
        this.set = new HashSet();
        super.cancel();
    }

    private PlatformTimer(String str, boolean z) {
        super(str, z);
        this.set = new HashSet();
        super.cancel();
    }

    /* loaded from: classes4.dex */
    private static class NoCancelTimerHolder {
        private static Timer timer = new Timer("platform-no-cancel-timer") { // from class: com.bytedance.platform.thread.PlatformTimer.NoCancelTimerHolder.1
            @Override // java.util.Timer
            public void cancel() {
                throw new RuntimeException("NoCancelTimer禁止调用取消方法");
            }
        };

        private NoCancelTimerHolder() {
        }
    }

    /* loaded from: classes4.dex */
    private static class PoolTimerHolder {
        private static PlatformTimer timer = new PlatformTimer("platform-pool-timer");

        private PoolTimerHolder() {
        }
    }

    public static Timer getNoCancelTimer() {
        return NoCancelTimerHolder.timer;
    }

    public static Timer getPoolTimer() {
        return PoolTimerHolder.timer;
    }

    @Override // java.util.Timer
    public void schedule(TimerTask timerTask, long j) {
        this.set.add(pool.schedule(timerTask, j, TimeUnit.MILLISECONDS));
    }

    @Override // java.util.Timer
    public void schedule(TimerTask timerTask, Date date) {
        this.set.add(pool.schedule(timerTask, date.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS));
    }

    @Override // java.util.Timer
    public void schedule(TimerTask timerTask, long j, long j2) {
        pool.scheduleAtFixedRate(timerTask, j, j2, TimeUnit.MILLISECONDS);
    }

    @Override // java.util.Timer
    public void schedule(TimerTask timerTask, Date date, long j) {
        this.set.add(pool.scheduleAtFixedRate(timerTask, date.getTime() - System.currentTimeMillis(), j, TimeUnit.MILLISECONDS));
    }

    @Override // java.util.Timer
    public void scheduleAtFixedRate(TimerTask timerTask, long j, long j2) {
        this.set.add(pool.scheduleAtFixedRate(timerTask, j, j2, TimeUnit.MILLISECONDS));
    }

    @Override // java.util.Timer
    public void scheduleAtFixedRate(TimerTask timerTask, Date date, long j) {
        this.set.add(pool.scheduleAtFixedRate(timerTask, date.getTime() - System.currentTimeMillis(), j, TimeUnit.MILLISECONDS));
    }

    @Override // java.util.Timer
    public void cancel() {
        Iterator<ScheduledFuture> it = this.set.iterator();
        while (it.hasNext()) {
            it.next().cancel(false);
        }
        this.set.clear();
    }

    @Override // java.util.Timer
    public int purge() {
        Iterator<ScheduledFuture> it = this.set.iterator();
        while (it.hasNext()) {
            it.next().cancel(false);
        }
        int size = this.set.size();
        this.set.clear();
        return size;
    }
}
