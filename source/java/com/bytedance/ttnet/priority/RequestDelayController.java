package com.bytedance.ttnet.priority;

import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTask;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsRunnable;
import com.bytedance.retrofit2.client.Request;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RequestDelayController {
    private static final int DEFAULT_RANDOM_SEND_LOWER_BOUNDS_MS = 500;
    private static final int DEFAULT_RANDOM_SEND_UPPER_BOUNDS_MS = 3000;
    private static final int DEFAULT_SPARSE_SEND_INTERVAL_MS = 100;
    private int mAsyncReqDelayMaxCount;
    private final Map<Runnable, Executor> mAsyncReqExecutorMap;
    private final Set<Request> mAsyncSet;
    private int mRandomSendLowerBoundMs;
    private int mRandomSendUpperBoundMs;
    private final ReadWriteLock mReleaseEnqueueLock;
    private final Lock mReleaseEnqueueWriteLock;
    private final Condition mReleaseExecuteCondition;
    private final Lock mReleaseExecuteLock;
    private int mSparseSendIntervalMs;
    private String mOwnerStateName = null;
    private final Set<Request> mSyncSet = new CopyOnWriteArraySet();
    private int mSyncReqDelayMaxCount = -1;

    public RequestDelayController() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mReleaseExecuteLock = reentrantLock;
        this.mReleaseExecuteCondition = reentrantLock.newCondition();
        this.mAsyncSet = new CopyOnWriteArraySet();
        this.mAsyncReqDelayMaxCount = -1;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReleaseEnqueueLock = reentrantReadWriteLock;
        this.mReleaseEnqueueWriteLock = reentrantReadWriteLock.writeLock();
        this.mAsyncReqExecutorMap = new ConcurrentHashMap();
        this.mRandomSendLowerBoundMs = DEFAULT_RANDOM_SEND_LOWER_BOUNDS_MS;
        this.mRandomSendUpperBoundMs = 3000;
        this.mSparseSendIntervalMs = 100;
    }

    public void initWithTncConfig(JSONObject jSONObject, String str) {
        this.mSyncReqDelayMaxCount = jSONObject.optInt("sync_req_delay_max_count", -1);
        this.mAsyncReqDelayMaxCount = jSONObject.optInt("async_req_delay_max_count", -1);
        this.mRandomSendLowerBoundMs = jSONObject.optInt("random_send_lbound_ms", DEFAULT_RANDOM_SEND_LOWER_BOUNDS_MS);
        this.mRandomSendUpperBoundMs = jSONObject.optInt("random_send_ubound_ms", 3000);
        this.mSparseSendIntervalMs = jSONObject.optInt("sparse_send_interval_ms", 100);
        setOwnerStateName(str);
    }

    public void initWithLocal(int i, int i2, int i3) {
        this.mSyncReqDelayMaxCount = i;
        this.mAsyncReqDelayMaxCount = i2;
        this.mSparseSendIntervalMs = i3;
    }

    public void setOwnerStateName(String str) {
        this.mOwnerStateName = str;
    }

    public void requestBlockingDelay(Request request, boolean z, boolean z2, long j) {
        int p1RandomDelayTime;
        long uptimeMillis;
        StringBuilder sb;
        if (j <= 0) {
            return;
        }
        if (z || this.mSyncSet.size() < this.mSyncReqDelayMaxCount) {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            this.mSyncSet.add(request);
            request.getMetrics().syncDelayCount = this.mSyncSet.size();
            request.getMetrics().delayStateName = this.mOwnerStateName;
            request.getMetrics().delayedWithState = true;
            if (Logger.debug()) {
                Logger.d("RequestDelay", "Delay request before await");
            }
            this.mReleaseExecuteLock.lock();
            try {
                try {
                    this.mReleaseExecuteCondition.await(j, TimeUnit.MILLISECONDS);
                    this.mReleaseExecuteLock.unlock();
                    p1RandomDelayTime = getP1RandomDelayTime();
                    if (Logger.debug()) {
                        Logger.d("RequestDelay", "Delay request :" + request.getPath() + " time:" + p1RandomDelayTime + " start random now");
                    }
                    if (p1RandomDelayTime > 0) {
                        try {
                            Thread.sleep(p1RandomDelayTime);
                        } catch (InterruptedException unused) {
                            Logger.e("sleeping interrupted");
                        }
                    }
                    uptimeMillis = SystemClock.uptimeMillis();
                } catch (Throwable th) {
                    this.mReleaseExecuteLock.unlock();
                    int p1RandomDelayTime2 = getP1RandomDelayTime();
                    if (Logger.debug()) {
                        Logger.d("RequestDelay", "Delay request :" + request.getPath() + " time:" + p1RandomDelayTime2 + " start random now");
                    }
                    if (p1RandomDelayTime2 > 0) {
                        try {
                            Thread.sleep(p1RandomDelayTime2);
                        } catch (InterruptedException unused2) {
                            Logger.e("sleeping interrupted");
                        }
                    }
                    long uptimeMillis3 = SystemClock.uptimeMillis();
                    if (Logger.debug()) {
                        Logger.d("RequestDelay", "Delay request end random " + p1RandomDelayTime2 + " delay all " + (uptimeMillis3 - uptimeMillis2));
                    }
                    request.getMetrics().randomSendTime = p1RandomDelayTime2;
                    request.getMetrics().stateDelayTime = SystemClock.uptimeMillis() - uptimeMillis2;
                    throw th;
                }
            } catch (Exception e) {
                if (Logger.debug()) {
                    Logger.d("RequestDelay", "Delay request await interrupted " + e.getMessage());
                }
                this.mReleaseExecuteLock.unlock();
                p1RandomDelayTime = getP1RandomDelayTime();
                if (Logger.debug()) {
                    Logger.d("RequestDelay", "Delay request :" + request.getPath() + " time:" + p1RandomDelayTime + " start random now");
                }
                if (p1RandomDelayTime > 0) {
                    try {
                        Thread.sleep(p1RandomDelayTime);
                    } catch (InterruptedException unused3) {
                        Logger.e("sleeping interrupted");
                    }
                }
                uptimeMillis = SystemClock.uptimeMillis();
                if (Logger.debug()) {
                    sb = new StringBuilder("Delay request end random ");
                }
            }
            if (Logger.debug()) {
                sb = new StringBuilder("Delay request end random ");
                Logger.d("RequestDelay", sb.append(p1RandomDelayTime).append(" delay all ").append(uptimeMillis - uptimeMillis2).toString());
            }
            request.getMetrics().randomSendTime = p1RandomDelayTime;
            request.getMetrics().stateDelayTime = SystemClock.uptimeMillis() - uptimeMillis2;
        }
    }

    public boolean requestAsyncDelay(final Request request, boolean z, long j, final Runnable runnable, final Executor executor) {
        if (j <= 0) {
            return false;
        }
        if (!z && this.mAsyncSet.size() >= this.mAsyncReqDelayMaxCount) {
            return false;
        }
        this.mAsyncReqExecutorMap.put(runnable, executor);
        this.mAsyncSet.add(request);
        request.getMetrics().delayStartTimeStamp = SystemClock.uptimeMillis();
        request.getMetrics().delayStateName = this.mOwnerStateName;
        request.getMetrics().asyncDelayCount = this.mAsyncSet.size();
        request.getMetrics().delayedWithState = true;
        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new NetworkAsyncTask(j, 0L) { // from class: com.bytedance.ttnet.priority.RequestDelayController.1
            public void run() {
                RequestDelayController.this.mReleaseEnqueueWriteLock.lock();
                try {
                    if (RequestDelayController.this.mAsyncReqExecutorMap.containsKey(runnable)) {
                        executor.execute(runnable);
                        RequestDelayController.this.mAsyncReqExecutorMap.remove(runnable);
                        request.getMetrics().stateDelayTime = SystemClock.uptimeMillis() - request.getMetrics().delayStartTimeStamp;
                    }
                } finally {
                    RequestDelayController.this.mReleaseEnqueueWriteLock.unlock();
                }
            }
        });
        return true;
    }

    public void releaseAllDelayedRequests() {
        this.mReleaseExecuteLock.lock();
        try {
            this.mReleaseExecuteCondition.signalAll();
            this.mReleaseExecuteLock.unlock();
            this.mReleaseEnqueueWriteLock.lock();
            try {
                int i = 0;
                for (Map.Entry<Runnable, Executor> entry : this.mAsyncReqExecutorMap.entrySet()) {
                    final Runnable key = entry.getKey();
                    final Executor value = entry.getValue();
                    if (useRandomOrSparse()) {
                        i = getP1RandomDelayTime();
                    } else {
                        i += this.mSparseSendIntervalMs;
                    }
                    final int i2 = i;
                    NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new NetworkAsyncTask(i, 0L) { // from class: com.bytedance.ttnet.priority.RequestDelayController.2
                        public void run() {
                            RequestDelayController.this.mReleaseEnqueueWriteLock.lock();
                            try {
                                if (RequestDelayController.this.mAsyncReqExecutorMap.containsKey(key)) {
                                    Runnable runnable = key;
                                    if (runnable instanceof SsRunnable) {
                                        RetrofitMetrics retrofitMetrics = ((SsRunnable) runnable).getRetrofitMetrics();
                                        retrofitMetrics.stateDelayTime = SystemClock.uptimeMillis() - retrofitMetrics.delayStartTimeStamp;
                                        retrofitMetrics.randomSendTime = i2;
                                    }
                                    value.execute(key);
                                    RequestDelayController.this.mAsyncReqExecutorMap.remove(key);
                                }
                            } finally {
                                RequestDelayController.this.mReleaseEnqueueWriteLock.unlock();
                            }
                        }
                    });
                }
                this.mReleaseEnqueueWriteLock.unlock();
                this.mAsyncSet.clear();
                this.mSyncSet.clear();
            } catch (Throwable th) {
                this.mReleaseEnqueueWriteLock.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            this.mReleaseExecuteLock.unlock();
            throw th2;
        }
    }

    public void notifyRequestCompleted(Request request) {
        if (request == null) {
            return;
        }
        this.mSyncSet.remove(request);
        this.mAsyncSet.remove(request);
    }

    private boolean useRandomOrSparse() {
        return this.mSparseSendIntervalMs <= 0;
    }

    private int getP1RandomDelayTime() {
        int i = this.mRandomSendLowerBoundMs;
        if (i <= 0) {
            i = DEFAULT_RANDOM_SEND_LOWER_BOUNDS_MS;
        }
        int i2 = this.mRandomSendUpperBoundMs;
        if (i2 <= 0) {
            i2 = 3000;
        }
        if (i >= i2) {
            return 0;
        }
        return new Random().nextInt((i2 - i) + 1) + i;
    }
}
