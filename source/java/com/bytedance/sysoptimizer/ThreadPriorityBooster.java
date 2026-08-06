package com.bytedance.sysoptimizer;

import android.os.Process;

/* loaded from: classes5.dex */
public class ThreadPriorityBooster {
    private static final int PRIORITY_NOT_ADJUSTED = Integer.MAX_VALUE;
    private static final String TAG = "ThreadPriorityBooster";
    private volatile int mBoostToPriority;
    private final ThreadLocal<PriorityState> mThreadState = new ThreadLocal<PriorityState>() { // from class: com.bytedance.sysoptimizer.ThreadPriorityBooster.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public PriorityState initialValue() {
            return new PriorityState();
        }
    };

    public ThreadPriorityBooster(int i) {
        this.mBoostToPriority = i;
    }

    public void boost() {
        int threadPriority;
        PriorityState priorityState = this.mThreadState.get();
        if (priorityState.regionCounter == 0 && (threadPriority = Process.getThreadPriority(priorityState.tid)) > this.mBoostToPriority) {
            Process.setThreadPriority(priorityState.tid, this.mBoostToPriority);
            priorityState.prevPriority = threadPriority;
        }
        priorityState.regionCounter++;
    }

    public void reset() {
        PriorityState priorityState = this.mThreadState.get();
        priorityState.regionCounter--;
        if (priorityState.regionCounter != 0 || priorityState.prevPriority == Integer.MAX_VALUE) {
            return;
        }
        Process.setThreadPriority(priorityState.tid, priorityState.prevPriority);
        priorityState.prevPriority = Integer.MAX_VALUE;
    }

    protected void setBoostToPriority(int i) {
        this.mBoostToPriority = i;
        PriorityState priorityState = this.mThreadState.get();
        if (priorityState.regionCounter == 0 || Process.getThreadPriority(priorityState.tid) == i) {
            return;
        }
        Process.setThreadPriority(priorityState.tid, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class PriorityState {
        int prevPriority;
        int regionCounter;
        int tid;

        private PriorityState() {
            this.tid = Process.myTid();
            this.prevPriority = Integer.MAX_VALUE;
        }
    }
}
