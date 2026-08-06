package com.bytedance.monitor.collector;

import android.util.Pair;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import com.bytedance.monitor.util.thread.TaskRunnable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsMonitor {
    protected IAsyncTaskManager mAsyncTaskManager;
    protected String mCollectorType;
    protected int mRunMode;
    protected int mState = 0;
    protected volatile boolean isHyperMode = false;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public @interface RunMode {
        public static final int ASCRIBE = 3;
        public static final int NORMAL = 1;
        public static final int OFFLINE = 2;
        public static final int TURNOFF = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pair<String, ?> dumpInfo() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pair<String, ?> dumpInfosRange(long j, long j2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpInfosToALog(long j, long j2, long j3) {
    }

    protected abstract void updateConfig(int i);

    public AbsMonitor(int i, String str) {
        this.mRunMode = 1;
        this.mCollectorType = str;
        this.mRunMode = i;
        PerfMonitorManager.getInstance().addCollector(this);
        this.mAsyncTaskManager = AsyncTaskUtil.getAsyncTaskManagerInstance();
    }

    public String getMonitorType() {
        return this.mCollectorType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start() {
        if (this.mState < 0) {
            throw new IllegalStateException("collector has destroyed, can not start.");
        }
        this.mState = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        this.mState = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startHyperMode() {
        this.isHyperMode = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopHyperMode() {
        this.isHyperMode = false;
    }

    public final void refreshConfig(final int i) {
        TaskRunnable wrapLightWeightTask = AsyncTaskUtil.wrapLightWeightTask("refreshConfig", new Runnable() { // from class: com.bytedance.monitor.collector.AbsMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                if (AbsMonitor.this.mState > -1 && AbsMonitor.this.mState == 2) {
                    int i2 = AbsMonitor.this.mRunMode;
                    int i3 = i;
                    if (i2 != i3) {
                        AbsMonitor.this.mRunMode = i3;
                        AbsMonitor.this.updateConfig(i);
                    }
                }
            }
        });
        IAsyncTaskManager iAsyncTaskManager = this.mAsyncTaskManager;
        if (iAsyncTaskManager != null) {
            iAsyncTaskManager.post(wrapLightWeightTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        this.mState = -1;
    }
}
