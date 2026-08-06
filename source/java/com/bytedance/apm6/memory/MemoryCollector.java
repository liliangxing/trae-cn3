package com.bytedance.apm6.memory;

import android.app.Activity;
import com.bytedance.apm.listener.IMemoryReachTopListener;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.memory.bean.MemoryCollectInfo;
import com.bytedance.apm6.memory.config.MemoryConfig;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.memory.listener.IMemoryDataListener;
import com.bytedance.apm6.memory.monitorable.MemoryPerfDataEvent;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.DummyLifecycleListener;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MemoryCollector {
    private static final long MIN_COLLECT_TIME = 30000;
    private static final String TAG = "MemoryCollector";
    private MemoryConfig config;
    private volatile boolean inited;
    private volatile boolean isPaused;
    private volatile boolean isStart;
    private MemoryLifecycleListener lifecycleListener;
    private volatile IMemoryReachTopListener listener;
    private List<IMemoryDataListener> mList;
    private AsyncTask memoryCollector;
    private Map<Object, Object> mmapInfo;
    private long pollingIntervalMillis;

    private MemoryCollector() {
        this.pollingIntervalMillis = 0L;
        this.lifecycleListener = new MemoryLifecycleListener();
        this.mList = new CopyOnWriteArrayList();
    }

    public static MemoryCollector getInstance() {
        return InnerHolder.instance;
    }

    public void addMapInfo(Map<Object, Object> map) {
        if (map == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        this.mmapInfo = hashMap;
        hashMap.putAll(map);
    }

    public void addMemoryCallBackListener(IMemoryDataListener iMemoryDataListener) {
        if (iMemoryDataListener != null) {
            this.mList.add(iMemoryDataListener);
        }
    }

    public void removeMemoryCallBackListener(IMemoryDataListener iMemoryDataListener) {
        if (iMemoryDataListener != null) {
            this.mList.remove(iMemoryDataListener);
        }
    }

    public final synchronized void init() {
        if (this.inited) {
            return;
        }
        this.inited = true;
        updateConfig(((MemoryConfigService) ServiceManager.getService(MemoryConfigService.class)).getConfig());
    }

    public void initGCInfo() {
        MemoryStatistics.getInstance().init();
    }

    public void resume() {
        this.isPaused = false;
    }

    public void pause() {
        this.isPaused = true;
    }

    public synchronized void updateConfig(MemoryConfig memoryConfig) {
        if (memoryConfig == null) {
            return;
        }
        this.config = memoryConfig;
        if (ApmContext.isDebugMode()) {
            Logger.m119d("APM-Memory", "updateConfig: " + memoryConfig);
        }
        if (!memoryConfig.isApm6SampleEnable()) {
            stop();
            ActivityLifecycleService activityLifecycleService = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
            if (activityLifecycleService != null) {
                activityLifecycleService.unregister(this.lifecycleListener);
            }
            if (ApmContext.isDebugMode()) {
                Logger.m119d("APM-Memory", "isApm6SampleEnable: " + memoryConfig.isApm6SampleEnable());
            }
            return;
        }
        ActivityLifecycleService activityLifecycleService2 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        if (activityLifecycleService2 != null) {
            if (memoryConfig.isStopWhenBackground()) {
                activityLifecycleService2.unregister(this.lifecycleListener);
                activityLifecycleService2.register(this.lifecycleListener);
            } else {
                activityLifecycleService2.unregister(this.lifecycleListener);
            }
        }
        long memoryCollectionInterval = memoryConfig.memoryCollectionInterval() * 1000;
        this.pollingIntervalMillis = memoryCollectionInterval;
        if (memoryCollectionInterval < 30000) {
            if (ApmContext.isDebugMode()) {
                Logger.m119d("APM-Memory", "pollingIntervalMillis: " + this.pollingIntervalMillis);
            }
            this.pollingIntervalMillis = 30000L;
        }
        if (ApmContext.isDebugMode()) {
            Logger.m119d("APM-Memory", "result pollingIntervalMillis: " + this.pollingIntervalMillis);
        }
        AsyncTask asyncTask = this.memoryCollector;
        if (asyncTask != null && asyncTask.getLoopInterval() != this.pollingIntervalMillis) {
            stop();
        }
        start();
        IMapsCollectService iMapsCollectService = (IMapsCollectService) ServiceManager.getService(IMapsCollectService.class);
        if (iMapsCollectService != null) {
            iMapsCollectService.start();
        }
    }

    public void registerReachTopListener(IMemoryReachTopListener iMemoryReachTopListener) {
        this.listener = iMemoryReachTopListener;
    }

    public void unregisterReachTopListener() {
        this.listener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void start() {
        if (!this.isStart) {
            this.isStart = true;
            if (ApmContext.isDebugMode()) {
                Logger.m119d("APM-Memory", "start");
            }
            scheduleCollectMemory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void stop() {
        if (this.isStart) {
            this.isStart = false;
            cancelCollectMemory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void collect() {
        long currentTimeMillis = System.currentTimeMillis();
        MemoryPerfDataEvent collectWithConfig = MemoryStatistics.getInstance().collectWithConfig(this.config);
        if (collectWithConfig == null) {
            if (ApmContext.isDebugMode()) {
                Logger.m119d("APM-Memory", "collectWithConfig return is null");
                return;
            }
            return;
        }
        collectWithConfig.setMmapInfo(this.mmapInfo);
        this.mmapInfo = null;
        if (ApmContext.isDebugMode()) {
            Logger.m119d("APM-Memory", String.format("collect[isUploadEnable=%s cost=%s]: %s", Boolean.valueOf(this.config.isUploadEnable()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), collectWithConfig.toJsonObject().toString()));
        }
        if (this.config.isUploadEnable()) {
            sendPerfData(collectWithConfig);
        } else if (ApmAlogHelper.isFeedbackALogEnabled()) {
            ApmAlogHelper.feedbackI(TAG, collectWithConfig.toJsonObject().toString());
        }
        if (collectWithConfig.getJavaUsedMemoryRate() > this.config.memoryTopCheckThreshold() && this.listener != null) {
            this.listener.onReachTop("reach_top_java");
        }
        List<IMemoryDataListener> list = this.mList;
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            MemoryCollectInfo memoryCollectInfo = collectWithConfig.getMemoryCollectInfo();
            Iterator<IMemoryDataListener> it = this.mList.iterator();
            while (it.hasNext()) {
                it.next().onMemoryCallback(memoryCollectInfo);
            }
        } catch (Exception unused) {
        }
    }

    private void scheduleCollectMemory() {
        if (this.memoryCollector == null) {
            if (ApmContext.isDebugMode()) {
                Logger.m119d("APM-Memory", "scheduleCollectMemory");
            }
            this.memoryCollector = new AsyncTask(0L, this.pollingIntervalMillis) { // from class: com.bytedance.apm6.memory.MemoryCollector.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MemoryCollector.this.isPaused) {
                        return;
                    }
                    MemoryCollector.this.collect();
                }
            };
            AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.memoryCollector);
        }
    }

    private void cancelCollectMemory() {
        if (ApmContext.isDebugMode()) {
            Logger.m119d("APM-Memory", "cancelCollectMemory");
        }
        if (this.memoryCollector != null) {
            AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(this.memoryCollector);
            this.memoryCollector = null;
        }
    }

    private void sendPerfData(Monitorable monitorable) {
        if (monitorable == null) {
            return;
        }
        Monitor.record(monitorable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class MemoryLifecycleListener extends DummyLifecycleListener {
        private MemoryLifecycleListener() {
        }

        @Override // com.bytedance.apm6.service.lifecycle.DummyLifecycleListener, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public final void onFront(Activity activity) {
            if (ApmContext.isDebugMode()) {
                Logger.m119d("APM-Memory", "isStopWhenBackground:" + MemoryCollector.this.isStopWhenBackground());
            }
            if (MemoryCollector.this.isStopWhenBackground()) {
                MemoryCollector.this.start();
            }
        }

        @Override // com.bytedance.apm6.service.lifecycle.DummyLifecycleListener, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public final void onBackground(Activity activity) {
            if (ApmContext.isDebugMode()) {
                Logger.m119d("APM-Memory", "isStopWhenBackground:" + MemoryCollector.this.isStopWhenBackground());
            }
            if (MemoryCollector.this.isStopWhenBackground()) {
                MemoryCollector.this.stop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isStopWhenBackground() {
        MemoryConfig memoryConfig = this.config;
        return memoryConfig != null && memoryConfig.isStopWhenBackground();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class InnerHolder {
        private static final MemoryCollector instance = new MemoryCollector();

        private InnerHolder() {
        }
    }
}
