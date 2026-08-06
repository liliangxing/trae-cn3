package com.bytedance.ttnet.config;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTask;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.networkstackapplib.TTNETScoreAPI;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsRunnable;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl;
import com.bytedance.ttnet.TTNetInit;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TTHttpCallThrottleControl implements IHttpCallThrottleControl {
    private static volatile TTHttpCallThrottleControl mInstance;
    private final Map<Runnable, Executor> mAsyncReqExecutorMap;
    private final ReadWriteLock mCurrentConfigRWLock;
    private final Lock mCurrentConfigReadLock;
    private final Lock mCurrentConfigWriteLock;
    private final AtomicLong mLastP0StartTime;
    private final Set<Request> mP1AsyncSet;
    private final Set<Request> mP1SyncSet;
    private final ReadWriteLock mReleaseP1EnqueueLock;
    private final Lock mReleaseP1EnqueueWriteLock;
    private final Condition mReleaseP1ExecuteCondition;
    private final Lock mReleaseP1ExecuteLock;
    private final Set<Request> mRuntimePOSet;
    private final AtomicBoolean mTncStateDelayEnabled = new AtomicBoolean(false);
    private final Map<String, StateConfig> mStateConfigMap = new ConcurrentHashMap();
    private volatile StateConfig mCurrentConfig = new StateConfig();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum DelayMode {
        NO_DELAY,
        BLACK_LIST,
        WHITE_LIST,
        RUNTIME,
        NOT_REACHED
    }

    public TTHttpCallThrottleControl() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mCurrentConfigRWLock = reentrantReadWriteLock;
        this.mCurrentConfigReadLock = reentrantReadWriteLock.readLock();
        this.mCurrentConfigWriteLock = reentrantReadWriteLock.writeLock();
        this.mP1AsyncSet = new CopyOnWriteArraySet();
        this.mP1SyncSet = new CopyOnWriteArraySet();
        this.mLastP0StartTime = new AtomicLong(0L);
        this.mRuntimePOSet = new CopyOnWriteArraySet();
        this.mAsyncReqExecutorMap = new ConcurrentHashMap();
        ReentrantReadWriteLock reentrantReadWriteLock2 = new ReentrantReadWriteLock();
        this.mReleaseP1EnqueueLock = reentrantReadWriteLock2;
        this.mReleaseP1EnqueueWriteLock = reentrantReadWriteLock2.writeLock();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mReleaseP1ExecuteLock = reentrantLock;
        this.mReleaseP1ExecuteCondition = reentrantLock.newCondition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class StateConfig {
        int asyncReqDelayMaxCount;
        Map<String, Integer> blackList;
        Set<String> blackListForRuntime;
        int delayDisableTimeMs;
        DelayMode delayMode;
        Set<String> dropList;
        int p0CheckCountdownMs;
        Set<String> p0List;
        int p1MaxWaitMs;
        int randomSendLowerBoundMs;
        int randomSendUpperBoundMs;
        int state;
        String stateName;
        int syncReqDelayMaxCount;
        Set<String> whiteList;
        int whiteListDelayTimeMs;
        Set<String> whiteListForRuntime;

        private StateConfig() {
            this.delayMode = DelayMode.NO_DELAY;
            this.state = -1;
            this.stateName = "";
            this.delayDisableTimeMs = BytePatchException.ErrorCode.paramsError;
            this.syncReqDelayMaxCount = 5;
            this.asyncReqDelayMaxCount = 5;
            this.dropList = new CopyOnWriteArraySet();
            this.blackList = new ConcurrentHashMap();
            this.whiteList = new CopyOnWriteArraySet();
            this.whiteListDelayTimeMs = 100;
            this.p0List = new CopyOnWriteArraySet();
            this.blackListForRuntime = new CopyOnWriteArraySet();
            this.whiteListForRuntime = new CopyOnWriteArraySet();
            this.p0CheckCountdownMs = 5000;
            this.p1MaxWaitMs = 5000;
            this.randomSendUpperBoundMs = TTNETScoreAPI.MAX_WAIT_TIME;
            this.randomSendLowerBoundMs = 500;
        }
    }

    public static TTHttpCallThrottleControl getInstance() {
        if (mInstance == null) {
            synchronized (TTHttpCallThrottleControl.class) {
                if (mInstance == null) {
                    mInstance = new TTHttpCallThrottleControl();
                }
            }
        }
        return mInstance;
    }

    public void onServerConfigChangedFromTNCHandler(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2 = jSONObject.optJSONArray("tt_req_delay_config");
        boolean z = jSONObject.optInt("state_delay_enabled") > 0;
        boolean z2 = TTNetInit.getStateDelayNewStrategyEnabled() && (jSONObject.optInt("state_new_strategy_enabled", 1) > 0);
        if (!z || optJSONArray2 == null || z2) {
            this.mStateConfigMap.clear();
            this.mTncStateDelayEnabled.set(z);
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (int i = 0; i < optJSONArray2.length(); i++) {
            StateConfig stateConfig = new StateConfig();
            JSONObject optJSONObject = optJSONArray2.optJSONObject(i);
            if (optJSONObject != null) {
                stateConfig.stateName = optJSONObject.optString("state_name", "");
                if (!optJSONObject.isNull("bl_with_delay_ms")) {
                    stateConfig.delayMode = DelayMode.BLACK_LIST;
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("bl_with_delay_ms");
                    if (optJSONObject2 != null) {
                        Iterator<String> keys = optJSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            stateConfig.blackList.put(next, Integer.valueOf(optJSONObject2.optInt(next)));
                        }
                    }
                } else if (!optJSONObject.isNull("wl")) {
                    stateConfig.delayMode = DelayMode.WHITE_LIST;
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("wl");
                    if (optJSONArray3 != null) {
                        for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                            stateConfig.whiteList.add((String) optJSONArray3.opt(i2));
                        }
                    }
                    stateConfig.whiteListDelayTimeMs = optJSONObject.optInt("delay_time_ms", BytePatchException.ErrorCode.paramsError);
                    if (stateConfig.whiteListDelayTimeMs <= 0) {
                        stateConfig.whiteListDelayTimeMs = BytePatchException.ErrorCode.paramsError;
                    }
                } else if (!optJSONObject.isNull("p0")) {
                    stateConfig.delayMode = DelayMode.RUNTIME;
                    JSONArray optJSONArray4 = optJSONObject.optJSONArray("p0");
                    if (optJSONArray4 != null) {
                        for (int i3 = 0; i3 < optJSONArray4.length(); i3++) {
                            stateConfig.p0List.add((String) optJSONArray4.opt(i3));
                        }
                    }
                    JSONArray optJSONArray5 = optJSONObject.optJSONArray("bl_for_runtime");
                    if (optJSONArray5 != null) {
                        for (int i4 = 0; i4 < optJSONArray5.length(); i4++) {
                            stateConfig.blackListForRuntime.add((String) optJSONArray5.opt(i4));
                        }
                    }
                    JSONArray optJSONArray6 = optJSONObject.optJSONArray("wl_for_runtime");
                    if (optJSONArray6 != null) {
                        for (int i5 = 0; i5 < optJSONArray6.length(); i5++) {
                            stateConfig.whiteListForRuntime.add((String) optJSONArray6.opt(i5));
                        }
                    }
                    stateConfig.p0CheckCountdownMs = optJSONObject.optInt("p0_check_max_ms", 5000);
                    stateConfig.p1MaxWaitMs = optJSONObject.optInt("p1_wait_max_ms", 5000);
                    stateConfig.randomSendUpperBoundMs = optJSONObject.optInt("random_send_ubound_ms", TTNETScoreAPI.MAX_WAIT_TIME);
                    stateConfig.randomSendLowerBoundMs = optJSONObject.optInt("random_send_lbound_ms", 500);
                }
                if ((stateConfig.blackList.size() > 0 || stateConfig.whiteList.size() > 0 || stateConfig.p0List.size() > 0) && !TextUtils.isEmpty(stateConfig.stateName)) {
                    stateConfig.delayDisableTimeMs = optJSONObject.optInt("delay_disable_time_ms", BytePatchException.ErrorCode.paramsError);
                    if (stateConfig.delayDisableTimeMs <= 0) {
                        stateConfig.delayDisableTimeMs = BytePatchException.ErrorCode.paramsError;
                    }
                    if (!optJSONObject.isNull("dl") && (optJSONArray = optJSONObject.optJSONArray("dl")) != null) {
                        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                            stateConfig.dropList.add((String) optJSONArray.opt(i6));
                        }
                    }
                    stateConfig.state = optJSONObject.optInt("state", -1);
                    stateConfig.syncReqDelayMaxCount = optJSONObject.optInt("sync_req_delay_max_count", 10);
                    stateConfig.asyncReqDelayMaxCount = optJSONObject.optInt("async_req_delay_max_count", 10);
                    concurrentHashMap.put(stateConfig.stateName, stateConfig);
                }
            }
        }
        this.mStateConfigMap.clear();
        this.mStateConfigMap.putAll(concurrentHashMap);
        this.mTncStateDelayEnabled.set(z);
    }

    public void setAppState(String str) {
        releaseAllP1Request();
        StateConfig stateConfig = this.mStateConfigMap.get(str);
        this.mCurrentConfigWriteLock.lock();
        try {
            if (Logger.debug()) {
                Logger.d("delayrefine", "setAppState " + str);
            }
            if (stateConfig == this.mCurrentConfig) {
                return;
            }
            if (stateConfig == null) {
                stateConfig = new StateConfig();
            }
            this.mCurrentConfig = stateConfig;
            if (this.mCurrentConfig.delayMode != DelayMode.NO_DELAY) {
                NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new NetworkAsyncTask(this.mCurrentConfig.delayDisableTimeMs, 0L) { // from class: com.bytedance.ttnet.config.TTHttpCallThrottleControl.1
                    public void run() {
                        TTHttpCallThrottleControl.this.setAppState("");
                    }
                });
            }
        } finally {
            this.mCurrentConfigWriteLock.unlock();
        }
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request request) throws Exception {
        if (!this.mTncStateDelayEnabled.get() || request == null || request.getPath() == null || request.getMetrics() == null) {
            return;
        }
        this.mCurrentConfigReadLock.lock();
        try {
            try {
                int noneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException = getNoneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException(false, this.mCurrentConfig, request);
                if (Logger.debug()) {
                    Logger.d("delayrefine", "get sleep time " + noneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException + " path is " + request.getPath());
                }
                if (noneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException > 0) {
                    sleepForSpecificTimeMs(noneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException, request);
                    return;
                }
                if (noneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException == 0) {
                    return;
                }
                this.mCurrentConfigReadLock.lock();
                int i = this.mCurrentConfig.randomSendLowerBoundMs;
                int i2 = this.mCurrentConfig.randomSendUpperBoundMs;
                int i3 = this.mCurrentConfig.p1MaxWaitMs;
                try {
                    try {
                        if (this.mCurrentConfig.delayMode == DelayMode.RUNTIME && checkRequestForRuntime(this.mCurrentConfig, request)) {
                            if (!p1CheckP0Done()) {
                                this.mCurrentConfigReadLock.unlock();
                                this.mReleaseP1ExecuteLock.lock();
                                try {
                                    try {
                                        request.getMetrics().delayStartTimeStamp = SystemClock.uptimeMillis();
                                        this.mP1SyncSet.add(request);
                                        if (Logger.debug()) {
                                            Logger.d("delayrefine", "execute p1 add request " + request.getPath() + " after added me, sync size is " + this.mP1SyncSet.size());
                                        }
                                        this.mReleaseP1ExecuteCondition.await(i3, TimeUnit.MILLISECONDS);
                                        int p1RandomDelayTime = getP1RandomDelayTime(false, i, i2);
                                        long j = p1RandomDelayTime;
                                        request.getMetrics().randomSendTime = j;
                                        if (p1RandomDelayTime > 0) {
                                            Thread.sleep(j);
                                        }
                                        if (Logger.debug()) {
                                            Logger.d("delayrefine", "execute p1 release now " + request.getPath() + " random is " + p1RandomDelayTime);
                                        }
                                        request.getMetrics().stateDelayTime = SystemClock.uptimeMillis() - request.getMetrics().delayStartTimeStamp;
                                        request.getMetrics().delayedWithState = true;
                                    } catch (Exception unused) {
                                        Logger.e("sleeping interrupted");
                                    }
                                } finally {
                                    this.mReleaseP1ExecuteLock.unlock();
                                }
                            }
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                } finally {
                }
            } finally {
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void sleepForSpecificTimeMs(int i, Request request) {
        if (i <= 0) {
            return;
        }
        this.mP1SyncSet.add(request);
        request.getMetrics().delayStartTimeStamp = System.currentTimeMillis();
        request.getMetrics().delayedWithState = true;
        try {
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } finally {
            request.getMetrics().stateDelayTime = System.currentTimeMillis() - request.getMetrics().delayStartTimeStamp;
        }
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(final Request request, final Executor executor, final Runnable runnable) throws IOException {
        if (!this.mTncStateDelayEnabled.get() || request == null || request.getPath() == null || request.getMetrics() == null) {
            return false;
        }
        this.mCurrentConfigReadLock.lock();
        int i = this.mCurrentConfig.p1MaxWaitMs;
        try {
            try {
                int noneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException = getNoneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException(true, this.mCurrentConfig, request);
                if (Logger.debug()) {
                    Logger.d("delayrefine", "get sleep time " + noneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException + " path is " + request.getPath());
                }
                if (noneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException > 0) {
                    statePostDelay(noneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException, executor, runnable, request);
                    return true;
                }
                if (noneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException != 0 && this.mCurrentConfig.delayMode == DelayMode.RUNTIME && checkRequestForRuntime(this.mCurrentConfig, request) && !p1CheckP0Done()) {
                    this.mCurrentConfigReadLock.unlock();
                    this.mReleaseP1EnqueueWriteLock.lock();
                    try {
                        this.mP1AsyncSet.add(request);
                        if (Logger.debug()) {
                            Logger.d("delayrefine", "enqueue p1 add request " + request.getPath() + " after added me, async size is " + this.mP1AsyncSet.size());
                        }
                        request.getMetrics().delayStartTimeStamp = System.currentTimeMillis();
                        this.mAsyncReqExecutorMap.put(runnable, executor);
                        request.getMetrics().delayedWithState = true;
                        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new NetworkAsyncTask(i, 0L) { // from class: com.bytedance.ttnet.config.TTHttpCallThrottleControl.2
                            public void run() {
                                TTHttpCallThrottleControl.this.mReleaseP1EnqueueWriteLock.lock();
                                try {
                                    if (TTHttpCallThrottleControl.this.mAsyncReqExecutorMap.containsKey(runnable)) {
                                        if (Logger.debug()) {
                                            Logger.d("delayrefine", "release p1 from auto max time " + request.getPath());
                                        }
                                        request.getMetrics().stateDelayTime = System.currentTimeMillis() - request.getMetrics().delayStartTimeStamp;
                                        executor.execute(runnable);
                                        TTHttpCallThrottleControl.this.mAsyncReqExecutorMap.remove(runnable);
                                    }
                                } finally {
                                    TTHttpCallThrottleControl.this.mReleaseP1EnqueueWriteLock.unlock();
                                }
                            }
                        });
                        return true;
                    } finally {
                        this.mReleaseP1EnqueueWriteLock.unlock();
                    }
                }
                return false;
            } catch (Exception e) {
                throw e;
            }
        } finally {
            this.mCurrentConfigReadLock.unlock();
        }
    }

    private void statePostDelay(final int i, final Executor executor, final Runnable runnable, final Request request) {
        if (i <= 0) {
            return;
        }
        request.getMetrics().delayStartTimeStamp = System.currentTimeMillis();
        request.getMetrics().delayedWithState = true;
        SsRunnable ssRunnable = new SsRunnable() { // from class: com.bytedance.ttnet.config.TTHttpCallThrottleControl.3
            @Override // java.lang.Runnable
            public void run() {
                request.getMetrics().stateDelayTime = System.currentTimeMillis() - request.getMetrics().delayStartTimeStamp;
                executor.execute(runnable);
            }

            @Override // com.bytedance.retrofit2.SsRunnable
            public int priority() {
                return request.getPriorityLevel();
            }

            @Override // com.bytedance.retrofit2.SsRunnable
            public boolean isStreaming() {
                return request.isResponseStreaming();
            }

            @Override // com.bytedance.retrofit2.SsRunnable
            public int getRequestDelayTime() {
                return i;
            }

            @Override // com.bytedance.retrofit2.SsRunnable
            public RetrofitMetrics getRetrofitMetrics() {
                return request.getMetrics();
            }
        };
        this.mP1AsyncSet.add(request);
        executor.execute(ssRunnable);
    }

    private boolean p1CheckP0Done() {
        return System.currentTimeMillis() - this.mLastP0StartTime.get() > ((long) this.mCurrentConfig.p0CheckCountdownMs) || this.mRuntimePOSet.size() <= 0;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void notifyRequestCompleted(final Request request) {
        if ((this.mTncStateDelayEnabled.get() || this.mRuntimePOSet.size() > 0) && request != null) {
            NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new NetworkAsyncTask() { // from class: com.bytedance.ttnet.config.TTHttpCallThrottleControl.4
                public void run() {
                    boolean remove = TTHttpCallThrottleControl.this.mRuntimePOSet.remove(request);
                    if (Logger.debug() && request.getMetrics() != null) {
                        Logger.d("delayrefine", "notifyRequestCompleted " + request.getPath() + " after remove p0 set size is " + TTHttpCallThrottleControl.this.mRuntimePOSet.size() + " sync size when send is " + request.getMetrics().syncDelayCount + " async size when send is " + request.getMetrics().asyncDelayCount + " is delay? " + request.getMetrics().delayedWithState + " delay time is " + request.getMetrics().stateDelayTime + " random time is " + request.getMetrics().randomSendTime + " delay state is " + request.getMetrics().delayState);
                    }
                    TTHttpCallThrottleControl.this.mP1AsyncSet.remove(request);
                    TTHttpCallThrottleControl.this.mP1SyncSet.remove(request);
                    if (remove && TTHttpCallThrottleControl.this.mRuntimePOSet.size() == 0) {
                        if (Logger.debug()) {
                            Logger.d("delayrefine", "release when all p0 done");
                        }
                        TTHttpCallThrottleControl.this.releaseAllP1Request();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseAllP1Request() {
        if (Logger.debug()) {
            Logger.d("delayrefine", "releaseAllP1Request, " + this.mP1SyncSet.size() + " " + this.mP1AsyncSet.size());
        }
        this.mReleaseP1ExecuteLock.lock();
        try {
            this.mReleaseP1ExecuteCondition.signalAll();
            this.mReleaseP1ExecuteLock.unlock();
            this.mCurrentConfigReadLock.lock();
            try {
                int i = this.mCurrentConfig.randomSendLowerBoundMs;
                int i2 = this.mCurrentConfig.randomSendUpperBoundMs;
                this.mCurrentConfigReadLock.unlock();
                this.mReleaseP1EnqueueWriteLock.lock();
                try {
                    for (Map.Entry<Runnable, Executor> entry : this.mAsyncReqExecutorMap.entrySet()) {
                        final Runnable key = entry.getKey();
                        final Executor value = entry.getValue();
                        final int p1RandomDelayTime = getP1RandomDelayTime(true, i, i2);
                        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new NetworkAsyncTask(p1RandomDelayTime, 0L) { // from class: com.bytedance.ttnet.config.TTHttpCallThrottleControl.5
                            public void run() {
                                TTHttpCallThrottleControl.this.mReleaseP1EnqueueWriteLock.lock();
                                try {
                                    if (TTHttpCallThrottleControl.this.mAsyncReqExecutorMap.containsKey(key)) {
                                        Runnable runnable = key;
                                        if (runnable instanceof SsRunnable) {
                                            RetrofitMetrics retrofitMetrics = ((SsRunnable) runnable).getRetrofitMetrics();
                                            retrofitMetrics.stateDelayTime = System.currentTimeMillis() - retrofitMetrics.delayStartTimeStamp;
                                            retrofitMetrics.randomSendTime = p1RandomDelayTime;
                                        }
                                        if (Logger.debug()) {
                                            Logger.d("delayrefine", "release p1 from all p0 done, random is " + p1RandomDelayTime);
                                        }
                                        value.execute(key);
                                        TTHttpCallThrottleControl.this.mAsyncReqExecutorMap.remove(key);
                                    }
                                } finally {
                                    TTHttpCallThrottleControl.this.mReleaseP1EnqueueWriteLock.unlock();
                                }
                            }
                        });
                    }
                    this.mReleaseP1EnqueueWriteLock.unlock();
                    this.mP1AsyncSet.clear();
                    this.mP1SyncSet.clear();
                } catch (Throwable th) {
                    this.mReleaseP1EnqueueWriteLock.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                this.mCurrentConfigReadLock.unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            this.mReleaseP1ExecuteLock.unlock();
            throw th3;
        }
    }

    private int getP1RandomDelayTime(boolean z, int i, int i2) {
        if (z && this.mP1AsyncSet.size() <= 5) {
            return 0;
        }
        if (z || this.mP1SyncSet.size() > 5) {
            return new SecureRandom().nextInt((i2 - i) + 1) + i;
        }
        return 0;
    }

    private Integer getMapValueIfMatch(Map<String, Integer> map, String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : map.keySet()) {
            if (str.startsWith(str2)) {
                return map.get(str2);
            }
        }
        return null;
    }

    private boolean isMatch(Set<String> set, String str) {
        if (str == null) {
            return false;
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    private int getNoneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException(boolean z, StateConfig stateConfig, Request request) throws IOException {
        request.getMetrics().delayState = stateConfig.state;
        request.getMetrics().syncDelayCount = this.mP1SyncSet.size();
        request.getMetrics().asyncDelayCount = this.mP1AsyncSet.size();
        if (isMatch(stateConfig.dropList, request.getPath())) {
            throw new DroppedByThrottleControlException();
        }
        if (z && this.mP1AsyncSet.size() >= stateConfig.asyncReqDelayMaxCount) {
            return 0;
        }
        if (!z && this.mP1SyncSet.size() >= stateConfig.syncReqDelayMaxCount) {
            return 0;
        }
        if (stateConfig.delayMode == DelayMode.BLACK_LIST) {
            Integer mapValueIfMatch = getMapValueIfMatch(stateConfig.blackList, request.getPath());
            if (mapValueIfMatch != null) {
                return mapValueIfMatch.intValue();
            }
            return 0;
        }
        if (stateConfig.delayMode != DelayMode.WHITE_LIST) {
            return -1;
        }
        if (isMatch(stateConfig.whiteList, request.getPath())) {
            return 0;
        }
        return stateConfig.whiteListDelayTimeMs;
    }

    private boolean checkRequestForRuntime(StateConfig stateConfig, Request request) {
        if (isMatch(stateConfig.p0List, request.getPath())) {
            this.mLastP0StartTime.set(System.currentTimeMillis());
            this.mRuntimePOSet.add(request);
            if (!Logger.debug()) {
                return false;
            }
            Logger.d("delayrefine", "p0 add request " + request.getPath() + " size " + this.mRuntimePOSet.size());
            return false;
        }
        if (stateConfig.blackListForRuntime.size() > 0) {
            return isMatch(stateConfig.blackListForRuntime, request.getPath());
        }
        if (stateConfig.whiteListForRuntime.size() > 0) {
            return !isMatch(stateConfig.whiteListForRuntime, request.getPath());
        }
        return true;
    }
}
