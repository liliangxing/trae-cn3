package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.executors.AbstractPriorityRunnable;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class JobScheduler {
    static final String QUEUE_TIME_KEY = "queueTime";
    private final Runnable mDoJobRunnable;
    EncodedImage mEncodedImage;
    private final Executor mExecutor;
    private final JobRunnable mJobRunnable;
    long mJobStartTime;
    JobState mJobState;
    long mJobSubmitTime;
    private final int mMinimumJobIntervalMs;
    int mStatus;
    private final Runnable mSubmitJobRunnable;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface JobRunnable {
        void run(EncodedImage encodedImage, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class JobStartExecutorSupplier {
        private static ScheduledExecutorService sJobStarterExecutor;

        JobStartExecutorSupplier() {
        }

        static ScheduledExecutorService get() {
            if (sJobStarterExecutor == null) {
                sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
            }
            return sJobStarterExecutor;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static abstract class PriorityJobRunnable implements JobRunnable {
        private Priority mPriority;

        public PriorityJobRunnable(Priority priority) {
            this.mPriority = priority;
        }

        public Priority getPriority() {
            return this.mPriority;
        }
    }

    public JobScheduler(Executor executor, JobRunnable jobRunnable, int i) {
        this.mExecutor = executor;
        this.mJobRunnable = jobRunnable;
        this.mMinimumJobIntervalMs = i;
        if (jobRunnable instanceof PriorityJobRunnable) {
            this.mDoJobRunnable = new AbstractPriorityRunnable(Priority.getIntPriorityValue(((PriorityJobRunnable) jobRunnable).getPriority())) { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
                @Override // java.lang.Runnable
                public void run() {
                    JobScheduler.this.doJob();
                }
            };
        } else {
            this.mDoJobRunnable = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
                @Override // java.lang.Runnable
                public void run() {
                    JobScheduler.this.doJob();
                }
            };
        }
        this.mSubmitJobRunnable = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.3
            @Override // java.lang.Runnable
            public void run() {
                JobScheduler.this.submitJob();
            }
        };
        this.mEncodedImage = null;
        this.mStatus = 0;
        this.mJobState = JobState.IDLE;
        this.mJobSubmitTime = 0L;
        this.mJobStartTime = 0L;
    }

    public void clearJob() {
        EncodedImage encodedImage;
        synchronized (this) {
            encodedImage = this.mEncodedImage;
            this.mEncodedImage = null;
            this.mStatus = 0;
        }
        EncodedImage.closeSafely(encodedImage);
    }

    public boolean updateJob(EncodedImage encodedImage, int i) {
        EncodedImage encodedImage2;
        if (!shouldProcess(encodedImage, i)) {
            return false;
        }
        synchronized (this) {
            encodedImage2 = this.mEncodedImage;
            this.mEncodedImage = EncodedImage.cloneOrNull(encodedImage);
            this.mStatus = i;
        }
        EncodedImage.closeSafely(encodedImage2);
        return true;
    }

    public boolean scheduleJob() {
        long max;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            boolean z = false;
            if (!shouldProcess(this.mEncodedImage, this.mStatus)) {
                return false;
            }
            int i = C03234.f366xca5c4655[this.mJobState.ordinal()];
            if (i != 1) {
                if (i == 3) {
                    this.mJobState = JobState.RUNNING_AND_PENDING;
                }
                max = 0;
            } else {
                max = Math.max(this.mJobStartTime + this.mMinimumJobIntervalMs, uptimeMillis);
                this.mJobSubmitTime = uptimeMillis;
                this.mJobState = JobState.QUEUED;
                z = true;
            }
            if (z) {
                enqueueJob(max - uptimeMillis);
            }
            return true;
        }
    }

    /* renamed from: com.facebook.imagepipeline.producers.JobScheduler$4 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    static /* synthetic */ class C03234 {

        /* renamed from: $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState */
        static final /* synthetic */ int[] f366xca5c4655;

        static {
            int[] iArr = new int[JobState.values().length];
            f366xca5c4655 = iArr;
            try {
                iArr[JobState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f366xca5c4655[JobState.QUEUED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f366xca5c4655[JobState.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f366xca5c4655[JobState.RUNNING_AND_PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void enqueueJob(long j) {
        if (j > 0) {
            JobStartExecutorSupplier.get().schedule(this.mSubmitJobRunnable, j, TimeUnit.MILLISECONDS);
        } else {
            this.mSubmitJobRunnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitJob() {
        this.mExecutor.execute(this.mDoJobRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doJob() {
        EncodedImage encodedImage;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            encodedImage = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.mJobState = JobState.RUNNING;
            this.mJobStartTime = uptimeMillis;
        }
        try {
            if (shouldProcess(encodedImage, i)) {
                this.mJobRunnable.run(encodedImage, i);
            }
        } finally {
            EncodedImage.closeSafely(encodedImage);
            onJobFinished();
        }
    }

    private void onJobFinished() {
        long j;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            if (this.mJobState == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.mJobStartTime + this.mMinimumJobIntervalMs, uptimeMillis);
                this.mJobSubmitTime = uptimeMillis;
                this.mJobState = JobState.QUEUED;
                z = true;
            } else {
                this.mJobState = JobState.IDLE;
                j = 0;
                z = false;
            }
        }
        if (z) {
            enqueueJob(j - uptimeMillis);
        }
    }

    private static boolean shouldProcess(EncodedImage encodedImage, int i) {
        return BaseConsumer.isLast(i) || BaseConsumer.statusHasFlag(i, 4) || EncodedImage.isValid(encodedImage);
    }

    public synchronized long getQueuedTime() {
        return this.mJobStartTime - this.mJobSubmitTime;
    }
}
