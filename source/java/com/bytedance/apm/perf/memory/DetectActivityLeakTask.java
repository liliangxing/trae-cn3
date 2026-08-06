package com.bytedance.apm.perf.memory;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.config.ActivityLeakDetectConfig;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.memory.utils.ActivityLeakFixer;
import com.bytedance.apm.perf.memory.utils.KeyedWeakReference;
import com.bytedance.apm.perf.memory.utils.SimpleActivityLifecycleCallbacks;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DetectActivityLeakTask {
    private static final long ACTIVITY_LEAK_CHECK_DELAY_MILLIS = 60000;
    private static final String ACTIVITY_LEAK_SWITCH = "activity_leak_switch";
    private static final String LEAK_CHECK_THREAD_NAME = "LeakCheck-Thread";
    private static final String TAG = "DetectActivityLeakTask";
    private ActivityLeakDetectConfig mActivityLeakDetectConfig;
    private volatile IAsyncTaskManager mAsyncTaskManager;
    private Handler mHandler;
    private ReferenceQueue<Object> mQueue;
    private Set<String> mRetainedKeys;
    private long mWaitDetectTimeMs;
    private static DetectActivityLeakTask mTask = new DetectActivityLeakTask();
    private static boolean mInited = false;

    public static void init(Application application, ActivityLeakDetectConfig activityLeakDetectConfig) {
        if (application == null || activityLeakDetectConfig == null || mInited) {
            return;
        }
        mInited = true;
        mTask.run(application, activityLeakDetectConfig);
    }

    public void run(Application application, ActivityLeakDetectConfig activityLeakDetectConfig) {
        this.mActivityLeakDetectConfig = activityLeakDetectConfig;
        this.mWaitDetectTimeMs = activityLeakDetectConfig.getWaitDetectActivityTimeMs();
        long currentTimeMillis = System.currentTimeMillis();
        initLeakCheck(application);
        if (ApmContext.isDebugMode()) {
            Logger.m88i(TAG, "initActivityLeakCheck done, cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
        }
    }

    private void initLeakCheck(Application application) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mQueue = new ReferenceQueue<>();
        this.mRetainedKeys = new CopyOnWriteArraySet();
        application.registerActivityLifecycleCallbacks(new SimpleActivityLifecycleCallbacks() { // from class: com.bytedance.apm.perf.memory.DetectActivityLeakTask.1
            @Override // com.bytedance.apm.perf.memory.utils.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                boolean serviceSwitch = SamplerHelper.getServiceSwitch(DetectActivityLeakTask.ACTIVITY_LEAK_SWITCH);
                if (ApmContext.isDebugMode()) {
                    Logger.m88i(DetectActivityLeakTask.TAG, "activity_leak_switch : " + serviceSwitch);
                }
                if (serviceSwitch) {
                    String uuid = UUID.randomUUID().toString();
                    DetectActivityLeakTask.this.mRetainedKeys.add(uuid);
                    KeyedWeakReference keyedWeakReference = new KeyedWeakReference(activity, uuid, "", DetectActivityLeakTask.this.mQueue);
                    String activityName = DetectActivityLeakTask.this.getActivityName(activity);
                    if (ApmContext.isDebugMode()) {
                        Logger.m88i(DetectActivityLeakTask.TAG, "Wait Check Leak:" + activityName);
                    }
                    DetectActivityLeakTask.this.checkActivityLeak(keyedWeakReference, activityName);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkActivityLeak(final KeyedWeakReference keyedWeakReference, final String str) {
        if (this.mAsyncTaskManager == null) {
            this.mAsyncTaskManager = AsyncTaskUtil.getAsyncTaskManagerInstance();
        }
        this.mAsyncTaskManager.postDelayed(AsyncTaskUtil.wrapLightWeightTask(LEAK_CHECK_THREAD_NAME, new Runnable() { // from class: com.bytedance.apm.perf.memory.DetectActivityLeakTask.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DetectActivityLeakTask.this.removeWeaklyReachableReferences();
                    if (!DetectActivityLeakTask.this.gone(keyedWeakReference)) {
                        if (DetectActivityLeakTask.this.mActivityLeakDetectConfig.isGcDetect()) {
                            DetectActivityLeakTask.this.runGc();
                            DetectActivityLeakTask.this.removeWeaklyReachableReferences();
                            if (!DetectActivityLeakTask.this.gone(keyedWeakReference)) {
                                DetectActivityLeakTask.this.dealActivityLeak(keyedWeakReference, str);
                                return;
                            } else {
                                if (ApmContext.isDebugMode()) {
                                    Logger.m86d(DetectActivityLeakTask.TAG, "No Leak:" + str);
                                    return;
                                }
                                return;
                            }
                        }
                        DetectActivityLeakTask.this.dealActivityLeak(keyedWeakReference, str);
                        return;
                    }
                    if (ApmContext.isDebugMode()) {
                        Logger.m86d(DetectActivityLeakTask.TAG, "No Leak First Check:" + str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }), getWaitDetectTimeMs());
    }

    private long getWaitDetectTimeMs() {
        if (this.mWaitDetectTimeMs <= 0) {
            this.mWaitDetectTimeMs = 60000L;
        }
        return this.mWaitDetectTimeMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealActivityLeak(KeyedWeakReference keyedWeakReference, String str) {
        if (ApmContext.isDebugMode()) {
            Logger.m87e(TAG, "Leak:" + str);
        }
        Activity activity = (Activity) keyedWeakReference.get();
        if (activity == null) {
            return;
        }
        if (this.mActivityLeakDetectConfig.isUnbindActivityLeak()) {
            fixActivityLeak(keyedWeakReference);
        }
        if (this.mActivityLeakDetectConfig.isReportActivityLeakEvent()) {
            uploadLeakActivity(activity);
        }
        this.mRetainedKeys.remove(keyedWeakReference.key);
        IActivityLeakListener activityLeakListener = this.mActivityLeakDetectConfig.getActivityLeakListener();
        if (activityLeakListener != null) {
            activityLeakListener.onActivityLeaked(activity);
        }
    }

    private void fixActivityLeak(final KeyedWeakReference keyedWeakReference) {
        this.mHandler.post(new Runnable() { // from class: com.bytedance.apm.perf.memory.DetectActivityLeakTask.3
            @Override // java.lang.Runnable
            public void run() {
                DetectActivityLeakTask.this.waitForIdle(keyedWeakReference);
            }
        });
    }

    private void enqueueReferences() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException unused) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runGc() {
        long currentTimeMillis = System.currentTimeMillis();
        Runtime.getRuntime().gc();
        enqueueReferences();
        System.runFinalization();
        if (ApmContext.isDebugMode()) {
            Logger.m88i(TAG, "GC time done, cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
        }
    }

    private void uploadLeakActivity(Activity activity) {
        if (activity == null) {
            return;
        }
        ActivityLeakFixer.uploadLeakEvent(activity.getClass().getName());
        if (ApmContext.isDebugMode()) {
            Logger.m88i(TAG, "upload leak activity:" + activity.getLocalClassName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitForIdle(final KeyedWeakReference keyedWeakReference) {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.apm.perf.memory.DetectActivityLeakTask.4
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                Activity activity = (Activity) keyedWeakReference.get();
                if (activity == null) {
                    return false;
                }
                ActivityLeakFixer.unbindDrawables(activity);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getActivityName(Activity activity) {
        return activity.getLocalClassName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeWeaklyReachableReferences() {
        while (true) {
            KeyedWeakReference keyedWeakReference = (KeyedWeakReference) this.mQueue.poll();
            if (keyedWeakReference == null) {
                return;
            } else {
                this.mRetainedKeys.remove(keyedWeakReference.key);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gone(KeyedWeakReference keyedWeakReference) {
        return !this.mRetainedKeys.contains(keyedWeakReference.key);
    }
}
