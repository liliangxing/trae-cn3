package com.ttnet.org.chromium.base.metrics;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class CachingUmaRecorder implements UmaRecorder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_HISTOGRAM_COUNT = 256;
    static final int MAX_USER_ACTION_COUNT = 256;
    private static final String TAG = "CachingUmaRecorder";
    private UmaRecorder mDelegate;
    private int mDroppedUserActionCount;
    private List<Callback<String>> mUserActionCallbacksForTesting;
    private final ReentrantReadWriteLock mRwLock = new ReentrantReadWriteLock(false);
    private Map<String, Histogram> mHistogramByName = new HashMap();
    private AtomicInteger mDroppedHistogramSampleCount = new AtomicInteger();
    private List<UserAction> mUserActions = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class Histogram {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final int MAX_SAMPLE_COUNT = 256;
        private final int mMax;
        private final int mMin;
        private final String mName;
        private final int mNumBuckets;
        private final List<Integer> mSamples = new ArrayList(1);
        private final int mType;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes7.dex */
        @interface Type {
            public static final int BOOLEAN = 1;
            public static final int EXPONENTIAL = 2;
            public static final int LINEAR = 3;
            public static final int SPARSE = 4;
        }

        Histogram(int i, String str, int i2, int i3, int i4) {
            this.mType = i;
            this.mName = str;
            this.mMin = i2;
            this.mMax = i3;
            this.mNumBuckets = i4;
        }

        synchronized boolean addSample(int i, String str, int i2, int i3, int i4, int i5) {
            if (this.mSamples.size() >= 256) {
                return false;
            }
            this.mSamples.add(Integer.valueOf(i2));
            return true;
        }

        synchronized int flushTo(UmaRecorder umaRecorder) {
            int size;
            int i = this.mType;
            int i2 = 0;
            if (i == 1) {
                for (int i3 = 0; i3 < this.mSamples.size(); i3++) {
                    umaRecorder.recordBooleanHistogram(this.mName, this.mSamples.get(i3).intValue() != 0);
                }
            } else if (i == 2) {
                while (i2 < this.mSamples.size()) {
                    umaRecorder.recordExponentialHistogram(this.mName, this.mSamples.get(i2).intValue(), this.mMin, this.mMax, this.mNumBuckets);
                    i2++;
                }
            } else if (i == 3) {
                while (i2 < this.mSamples.size()) {
                    umaRecorder.recordLinearHistogram(this.mName, this.mSamples.get(i2).intValue(), this.mMin, this.mMax, this.mNumBuckets);
                    i2++;
                }
            } else if (i == 4) {
                while (i2 < this.mSamples.size()) {
                    umaRecorder.recordSparseHistogram(this.mName, this.mSamples.get(i2).intValue());
                    i2++;
                }
            }
            size = this.mSamples.size();
            this.mSamples.clear();
            return size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class UserAction {
        private final long mElapsedRealtimeMillis;
        private final String mName;

        UserAction(String str, long j) {
            this.mName = str;
            this.mElapsedRealtimeMillis = j;
        }

        void flushTo(UmaRecorder umaRecorder) {
            umaRecorder.recordUserAction(this.mName, this.mElapsedRealtimeMillis);
        }
    }

    public UmaRecorder setDelegate(UmaRecorder umaRecorder) {
        Map<String, Histogram> map;
        int i;
        this.mRwLock.writeLock().lock();
        try {
            UmaRecorder umaRecorder2 = this.mDelegate;
            this.mDelegate = umaRecorder;
            if (BuildConfig.IS_FOR_TEST) {
                swapUserActionCallbacksForTesting(umaRecorder2, umaRecorder);
            }
            if (umaRecorder == null) {
                return umaRecorder2;
            }
            List<UserAction> list = null;
            int i2 = 0;
            if (this.mHistogramByName.isEmpty()) {
                map = null;
                i = 0;
            } else {
                map = this.mHistogramByName;
                this.mHistogramByName = new HashMap();
                i = this.mDroppedHistogramSampleCount.getAndSet(0);
            }
            if (!this.mUserActions.isEmpty()) {
                list = this.mUserActions;
                this.mUserActions = new ArrayList();
                int i3 = this.mDroppedUserActionCount;
                this.mDroppedUserActionCount = 0;
                i2 = i3;
            }
            this.mRwLock.readLock().lock();
            if (map != null) {
                try {
                    flushHistogramsAlreadyLocked(map, i);
                } catch (Throwable th) {
                    this.mRwLock.readLock().unlock();
                    throw th;
                }
            }
            if (list != null) {
                flushUserActionsAlreadyLocked(list, i2);
            }
            this.mRwLock.readLock().unlock();
            return umaRecorder2;
        } finally {
            this.mRwLock.writeLock().unlock();
        }
    }

    private void flushHistogramsAlreadyLocked(Map<String, Histogram> map, int i) {
        int size = map.size();
        Iterator<Histogram> it = map.values().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += it.next().flushTo(this.mDelegate);
        }
        Log.i(TAG, "Flushed %d samples from %d histograms.", Integer.valueOf(i2), Integer.valueOf(size));
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.DroppedHistogramSampleCount", i, 1, 1000000, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.FlushedHistogramCount", size, 1, AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.InputHistogramSampleCount", i2 + i, 1, 1000000, 50);
    }

    private void flushUserActionsAlreadyLocked(List<UserAction> list, int i) {
        Iterator<UserAction> it = list.iterator();
        while (it.hasNext()) {
            it.next().flushTo(this.mDelegate);
        }
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.DroppedUserActionCount", i, 1, 1000, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.InputUserActionCount", list.size() + i, 1, 10000, 50);
    }

    private void cacheOrRecordHistogramSample(int i, String str, int i2, int i3, int i4, int i5) {
        if (tryAppendOrRecordSample(i, str, i2, i3, i4, i5)) {
            return;
        }
        this.mRwLock.writeLock().lock();
        try {
            if (this.mDelegate == null) {
                cacheHistogramSampleAlreadyWriteLocked(i, str, i2, i3, i4, i5);
                return;
            }
            this.mRwLock.readLock().lock();
            try {
                recordHistogramSampleAlreadyLocked(i, str, i2, i3, i4, i5);
            } finally {
                this.mRwLock.readLock().unlock();
            }
        } finally {
            this.mRwLock.writeLock().unlock();
        }
    }

    private boolean tryAppendOrRecordSample(int i, String str, int i2, int i3, int i4, int i5) {
        this.mRwLock.readLock().lock();
        try {
            if (this.mDelegate != null) {
                recordHistogramSampleAlreadyLocked(i, str, i2, i3, i4, i5);
            } else {
                Histogram histogram = this.mHistogramByName.get(str);
                if (histogram != null) {
                    if (!histogram.addSample(i, str, i2, i3, i4, i5)) {
                        this.mDroppedHistogramSampleCount.incrementAndGet();
                    }
                } else {
                    this.mRwLock.readLock().unlock();
                    return false;
                }
            }
            return true;
        } finally {
            this.mRwLock.readLock().unlock();
        }
    }

    private void cacheHistogramSampleAlreadyWriteLocked(int i, String str, int i2, int i3, int i4, int i5) {
        Histogram histogram = this.mHistogramByName.get(str);
        if (histogram == null) {
            if (this.mHistogramByName.size() >= 256) {
                this.mDroppedHistogramSampleCount.incrementAndGet();
                return;
            } else {
                Histogram histogram2 = new Histogram(i, str, i3, i4, i5);
                this.mHistogramByName.put(str, histogram2);
                histogram = histogram2;
            }
        }
        if (histogram.addSample(i, str, i2, i3, i4, i5)) {
            return;
        }
        this.mDroppedHistogramSampleCount.incrementAndGet();
    }

    private void recordHistogramSampleAlreadyLocked(int i, String str, int i2, int i3, int i4, int i5) {
        if (i == 1) {
            this.mDelegate.recordBooleanHistogram(str, i2 != 0);
            return;
        }
        if (i == 2) {
            this.mDelegate.recordExponentialHistogram(str, i2, i3, i4, i5);
        } else if (i == 3) {
            this.mDelegate.recordLinearHistogram(str, i2, i3, i4, i5);
        } else {
            if (i == 4) {
                this.mDelegate.recordSparseHistogram(str, i2);
                return;
            }
            throw new UnsupportedOperationException("Unknown histogram type " + i);
        }
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordBooleanHistogram(String str, boolean z) {
        cacheOrRecordHistogramSample(1, str, z ? 1 : 0, 0, 0, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordExponentialHistogram(String str, int i, int i2, int i3, int i4) {
        cacheOrRecordHistogramSample(2, str, i, i2, i3, i4);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordLinearHistogram(String str, int i, int i2, int i3, int i4) {
        cacheOrRecordHistogramSample(3, str, i, i2, i3, i4);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordSparseHistogram(String str, int i) {
        cacheOrRecordHistogramSample(4, str, i, 0, 0, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordUserAction(String str, long j) {
        this.mRwLock.readLock().lock();
        try {
            UmaRecorder umaRecorder = this.mDelegate;
            if (umaRecorder != null) {
                umaRecorder.recordUserAction(str, j);
                return;
            }
            this.mRwLock.readLock().unlock();
            this.mRwLock.writeLock().lock();
            try {
                if (this.mDelegate == null) {
                    if (this.mUserActions.size() < 256) {
                        this.mUserActions.add(new UserAction(str, j));
                    } else {
                        this.mDroppedUserActionCount++;
                    }
                    if (this.mUserActionCallbacksForTesting != null) {
                        for (int i = 0; i < this.mUserActionCallbacksForTesting.size(); i++) {
                            this.mUserActionCallbacksForTesting.get(i).onResult(str);
                        }
                    }
                    return;
                }
                this.mRwLock.readLock().lock();
                try {
                    this.mDelegate.recordUserAction(str, j);
                } finally {
                }
            } finally {
                this.mRwLock.writeLock().unlock();
            }
        } finally {
        }
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public int getHistogramValueCountForTesting(String str, int i) {
        int i2;
        this.mRwLock.readLock().lock();
        try {
            UmaRecorder umaRecorder = this.mDelegate;
            if (umaRecorder != null) {
                return umaRecorder.getHistogramValueCountForTesting(str, i);
            }
            Histogram histogram = this.mHistogramByName.get(str);
            if (histogram == null) {
                return 0;
            }
            synchronized (histogram) {
                i2 = 0;
                for (int i3 = 0; i3 < histogram.mSamples.size(); i3++) {
                    if (((Integer) histogram.mSamples.get(i3)).intValue() == i) {
                        i2++;
                    }
                }
            }
            return i2;
        } finally {
            this.mRwLock.readLock().unlock();
        }
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public int getHistogramTotalCountForTesting(String str) {
        int size;
        this.mRwLock.readLock().lock();
        try {
            UmaRecorder umaRecorder = this.mDelegate;
            if (umaRecorder != null) {
                return umaRecorder.getHistogramTotalCountForTesting(str);
            }
            Histogram histogram = this.mHistogramByName.get(str);
            if (histogram == null) {
                this.mRwLock.readLock().unlock();
                return 0;
            }
            synchronized (histogram) {
                size = histogram.mSamples.size();
            }
            return size;
        } finally {
            this.mRwLock.readLock().unlock();
        }
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void addUserActionCallbackForTesting(Callback<String> callback) {
        this.mRwLock.writeLock().lock();
        try {
            if (this.mUserActionCallbacksForTesting == null) {
                this.mUserActionCallbacksForTesting = new ArrayList();
            }
            this.mUserActionCallbacksForTesting.add(callback);
            UmaRecorder umaRecorder = this.mDelegate;
            if (umaRecorder != null) {
                umaRecorder.addUserActionCallbackForTesting(callback);
            }
        } finally {
            this.mRwLock.writeLock().unlock();
        }
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void removeUserActionCallbackForTesting(Callback<String> callback) {
        this.mRwLock.writeLock().lock();
        try {
            List<Callback<String>> list = this.mUserActionCallbacksForTesting;
            if (list == null) {
                return;
            }
            list.remove(callback);
            UmaRecorder umaRecorder = this.mDelegate;
            if (umaRecorder != null) {
                umaRecorder.removeUserActionCallbackForTesting(callback);
            }
        } finally {
            this.mRwLock.writeLock().unlock();
        }
    }

    private void swapUserActionCallbacksForTesting(UmaRecorder umaRecorder, UmaRecorder umaRecorder2) {
        if (this.mUserActionCallbacksForTesting == null) {
            return;
        }
        for (int i = 0; i < this.mUserActionCallbacksForTesting.size(); i++) {
            if (umaRecorder != null) {
                umaRecorder.removeUserActionCallbackForTesting(this.mUserActionCallbacksForTesting.get(i));
            }
            if (umaRecorder2 != null) {
                umaRecorder2.addUserActionCallbackForTesting(this.mUserActionCallbacksForTesting.get(i));
            }
        }
    }
}
