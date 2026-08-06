package com.bytedance.geckox.policy.ebretry;

import com.bytedance.geckox.task.HandlerTask;
import com.bytedance.geckox.task.HandlerTimerTaskManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class ExponentialBackoffRetry {
    private static final int DEFAULT_RETRY_INTERVAL = 5;
    private static final int MAX_RETRY_COUNT = 8;
    private static final int MAX_RETRY_DURATION = 5115;
    private static final long TIME_UNIT = 1000;
    private IEBRetryTask mTask;
    private int mRetryCount = 0;
    private int mTotalRetryDuration = 0;
    private AtomicBoolean mIsRetrying = new AtomicBoolean(false);

    public ExponentialBackoffRetry(IEBRetryTask iEBRetryTask) {
        this.mTask = iEBRetryTask;
    }

    public void retry() {
        if (this.mIsRetrying.compareAndSet(false, true)) {
            sendRetryMessage();
        }
    }

    public boolean isRetrying() {
        return this.mIsRetrying.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRetryMessage() {
        int i = this.mRetryCount + 1;
        this.mRetryCount = i;
        long retryDelay = getRetryDelay(i);
        int i2 = (int) (this.mTotalRetryDuration + retryDelay);
        this.mTotalRetryDuration = i2;
        if (i2 > MAX_RETRY_DURATION) {
            stopRetry();
        } else {
            HandlerTimerTaskManager.inst().schedule(new EBRTimerTask(), retryDelay * 1000);
        }
    }

    public void stopRetry() {
        if (isRetrying()) {
            this.mRetryCount = 0;
            HandlerTimerTaskManager.inst().cancel(2);
            this.mIsRetrying.set(false);
        }
    }

    private long getRetryDelay(int i) {
        return (long) Math.floor((Math.random() + 0.5d) * Math.pow(2.0d, Math.min(i - 2, 8)) * 5.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class EBRTimerTask extends HandlerTask {
        @Override // com.bytedance.geckox.task.HandlerTask
        public int taskType() {
            return 2;
        }

        private EBRTimerTask() {
        }

        @Override // com.bytedance.geckox.task.HandlerTask
        public void execute() {
            ExponentialBackoffRetry.this.mTask.execute();
            ExponentialBackoffRetry.this.sendRetryMessage();
        }
    }
}
