package com.bytedance.apm.block.trace;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.FrameMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.bytedance.apm.block.AbsLooperObserver;
import com.bytedance.apm.constant.CommonConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.core.ILifecycle;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.thread.ThreadWithBlockingQueue;
import com.bytedance.apm.thread.ThreadWithHandler;
import com.bytedance.monitor.collector.AbsLooperDispatchListener;
import com.bytedance.monitor.collector.LooperMonitor;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MainThreadMonitor implements BeatLifecycle, ILifecycle {
    private static final String ADD_CALLBACK = "addCallbackLocked";
    public static final int CALLBACK_INPUT = 0;
    private static final String FRAME_CALLBACK_TOKEN = "FRAME_CALLBACK_TOKEN";
    private static final String TAG = "MainThreadMonitor";
    private static boolean blockDetectorAdded;
    private static AbsLooperObserver mFrameObserver;
    private static final MainThreadMonitor sInstance = new MainThreadMonitor();
    private Method addInputQueue;
    private Object callbackQueueLock;
    private Object[] callbackQueues;
    Runnable callbackRunnable;
    private Choreographer choreographer;
    private IFrameCostCallBack iFrameCostCallBack;
    private volatile boolean isAlive;
    private boolean isEnableCloseListener;
    private boolean isEnableFpsAllocOpt;
    public boolean isEnableLooperOpt;
    private boolean isInit;
    private long[] mFrameInfo;
    public final MainThreadInfo mainThreadInfo = new MainThreadInfo();
    private long[] dispatchTimeMs = new long[4];
    private final List<AbsLooperObserver> observers = new CopyOnWriteArrayList();
    private boolean mFpsLifeCycleChanged = false;
    private boolean mFullFpsTracer = false;
    private boolean isBelongFrame = false;
    private boolean isBelongJavaMessage = false;
    private boolean callbackExist = false;
    final ThreadWithBlockingQueue mThreadWithBlockingQueue = new ThreadWithBlockingQueue(CommonConsts.APM_INNER_LOOPER_COST);
    final ThreadWithHandler mThreadWithHandler = new ThreadWithHandler(CommonConsts.APM_INNER_LOOPER_COST);
    private HashMap<String, Window.OnFrameMetricsAvailableListener> listenerHashMap = new HashMap<>();
    private long mFrameTimeMs = -1;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IFrameCostCallBack {
        void frameCostCallBack(FrameMetrics frameMetrics);
    }

    private boolean isNeedHookDoFrame() {
        return false;
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onBackground(Activity activity) {
    }

    public static MainThreadMonitor getMonitor() {
        return sInstance;
    }

    private MainThreadMonitor() {
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void setFrameCostCallBack(IFrameCostCallBack iFrameCostCallBack) {
        this.iFrameCostCallBack = iFrameCostCallBack;
    }

    public void start() {
        this.mThreadWithBlockingQueue.start();
        this.mThreadWithHandler.start();
    }

    public void init() {
        if (this.isInit) {
            return;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new AssertionError("must be init in main thread!");
        }
        ActivityLifeObserver.getInstance().register(this);
        LooperMonitor.init();
        LooperMonitor.setFirstListener(new AbsLooperDispatchListener() { // from class: com.bytedance.apm.block.trace.MainThreadMonitor.1
            public boolean isValid() {
                return MainThreadMonitor.this.isAlive;
            }

            public void dispatchStart(String str) {
                super.dispatchStart(str);
                MainThreadMonitor.this.dispatchBegin(str);
            }

            public void dispatchEnd(String str, Message message) {
                super.dispatchEnd(str, message);
                MainThreadMonitor.this.dispatchEnd();
            }
        });
        this.isInit = true;
    }

    public void setFullFpsTracer(boolean z) {
        this.mFullFpsTracer = z;
    }

    public void setFpsLifeCycleChange(boolean z) {
        this.mFpsLifeCycleChanged = z;
    }

    public ThreadWithHandler getThreadWithHandler() {
        return this.mThreadWithHandler;
    }

    public ThreadWithBlockingQueue getThreadWithBlockingQueue() {
        return this.mThreadWithBlockingQueue;
    }

    public void addObserver(AbsLooperObserver absLooperObserver) {
        if (!this.isAlive) {
            onStart();
        }
        if (this.observers.contains(absLooperObserver)) {
            return;
        }
        this.observers.add(absLooperObserver);
        if (this.isEnableLooperOpt) {
            LooperMonitor.unBlockLooperMonitor();
        }
    }

    public void setBlockDetectorAdded() {
        blockDetectorAdded = true;
    }

    public boolean isBlockDetectorAdded() {
        return blockDetectorAdded;
    }

    public void removeObserver(AbsLooperObserver absLooperObserver) {
        this.observers.remove(absLooperObserver);
        if (this.isEnableLooperOpt) {
            if (getObservers() == 0 && LooperMonitor.getLisenerSize() == 0) {
                LooperMonitor.blockLooperMonitor();
                return;
            }
            return;
        }
        if (this.observers.isEmpty()) {
            onStop();
        }
    }

    public int getObservers() {
        int size = this.observers.size();
        return (!isBlockDetectorAdded() || SamplerHelper.getPerfSecondStageSwitch("block_monitor")) ? size : size - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchBegin(String str) {
        this.isBelongJavaMessage = true;
        this.dispatchTimeMs[0] = AbsLooperDispatchListener.uptime;
        this.dispatchTimeMs[2] = AbsLooperDispatchListener.cpuTime;
        List<AbsLooperObserver> list = this.observers;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AbsLooperObserver absLooperObserver = list.get(i);
            if (!absLooperObserver.isDispatchBegin()) {
                absLooperObserver.dispatchBegin(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    public void dispatchEnd() {
        int i;
        boolean z;
        boolean z2 = this.isBelongFrame;
        if (isNeedHookDoFrame() && this.isBelongFrame) {
            doFrameEnd();
            long j = AbsLooperDispatchListener.uptime;
            if (this.mFrameInfo != null) {
                if (PerfMonitorManager.getInstance().getFrameCallback() != null) {
                    PerfMonitorManager.getInstance().getFrameCallback().doFrame(this.mFrameInfo);
                }
                JankTracer.getInstance().doFrame(this.mFrameInfo, j);
            }
        }
        char c = 1;
        this.dispatchTimeMs[1] = AbsLooperDispatchListener.uptime;
        this.dispatchTimeMs[3] = AbsLooperDispatchListener.cpuTime;
        List<AbsLooperObserver> list = this.observers;
        int size = list.size();
        boolean z3 = 0;
        int i2 = 0;
        while (i2 < size) {
            AbsLooperObserver absLooperObserver = list.get(i2);
            if (absLooperObserver.isDispatchBegin()) {
                long[] jArr = this.dispatchTimeMs;
                i = i2;
                z = z3;
                absLooperObserver.dispatchEnd(jArr[z3], jArr[2], jArr[c], jArr[3], z2);
            } else {
                i = i2;
                z = z3;
            }
            i2 = i + 1;
            z3 = z;
            c = 1;
        }
        this.mainThreadInfo.reset();
        this.isBelongJavaMessage = z3;
    }

    /* renamed from: com.bytedance.apm.block.trace.MainThreadMonitor$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    class RunnableC01912 implements Runnable {
        final /* synthetic */ long val$begin;
        final /* synthetic */ long val$end;

        RunnableC01912(long j, long j2) {
            this.val$begin = j;
            this.val$end = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MainThreadMonitor.this.observers.iterator();
            while (it.hasNext()) {
                ((AbsLooperObserver) it.next()).doFrame(ActivityLifeObserver.getInstance().getTopActivityClassName(), this.val$begin, this.val$end);
            }
        }
    }

    @Override // com.bytedance.apm.block.trace.BeatLifecycle
    public synchronized void onStart() {
        if (ApmContext.isMainProcessSimple()) {
            if (!this.isInit) {
                throw new RuntimeException("never init!");
            }
            if (!this.isAlive) {
                this.isAlive = true;
            }
            if (isNeedHookDoFrame()) {
                addFrameCallback(this.callbackRunnable);
            }
        }
    }

    @Override // com.bytedance.apm.block.trace.BeatLifecycle
    public synchronized void onStop() {
        if (ApmContext.isMainProcess()) {
            if (!this.isInit) {
                throw new RuntimeException("MainThreadMonitor is never init!");
            }
            if (this.isAlive) {
                this.isAlive = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void addFrameCallback(Runnable runnable) {
        if (this.isAlive) {
            if (this.callbackExist) {
                return;
            }
            try {
                synchronized (this.callbackQueueLock) {
                    Method method = this.addInputQueue;
                    if (method != null) {
                        method.invoke(this.callbackQueues[0], -1L, runnable, null);
                        this.callbackExist = true;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void doFrameBegin() {
        this.isBelongFrame = true;
    }

    private void doFrameEnd() {
        addFrameCallback(this.callbackRunnable);
        this.isBelongFrame = false;
    }

    public void doInputCallbackHook() {
        try {
            if (this.mFrameInfo == null) {
                this.mFrameTimeMs = AbsLooperDispatchListener.uptime;
            } else if (Build.VERSION.SDK_INT >= 31) {
                this.mFrameTimeMs = this.mFrameInfo[2] / BatteryFactorConfig.WIFI_BPS;
            } else {
                this.mFrameTimeMs = this.mFrameInfo[1] / BatteryFactorConfig.WIFI_BPS;
            }
            doFrameBegin();
        } finally {
            this.callbackExist = false;
        }
    }

    @Override // com.bytedance.apm.block.trace.BeatLifecycle
    public boolean isAlive() {
        return this.isAlive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T reflectObject(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return (T) declaredField.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T reflectHideObject(Object obj, String str) {
        try {
            Field field = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(obj.getClass(), str);
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Method reflectChoreographerMethod(Object obj, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Method reflectHideMethod(Class cls, String str, Class<?>... clsArr) {
        try {
            Method method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class).invoke(cls, str, clsArr);
            method.setAccessible(true);
            return method;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onFront(Activity activity) {
        if (this.choreographer == null && isNeedHookDoFrame()) {
            try {
                this.choreographer = Choreographer.getInstance();
            } catch (Exception unused) {
            }
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.block.trace.MainThreadMonitor.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MainThreadMonitor.this.callbackRunnable = new Runnable() { // from class: com.bytedance.apm.block.trace.MainThreadMonitor.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    MainThreadMonitor.this.doInputCallbackHook();
                                } catch (Throwable unused2) {
                                }
                            }
                        };
                        MainThreadMonitor mainThreadMonitor = MainThreadMonitor.this;
                        mainThreadMonitor.callbackQueueLock = mainThreadMonitor.reflectObject(mainThreadMonitor.choreographer, "mLock");
                        if (MainThreadMonitor.this.callbackQueueLock == null) {
                            MainThreadMonitor mainThreadMonitor2 = MainThreadMonitor.this;
                            mainThreadMonitor2.callbackQueueLock = mainThreadMonitor2.reflectHideObject(mainThreadMonitor2.choreographer, "mLock");
                        }
                        MainThreadMonitor mainThreadMonitor3 = MainThreadMonitor.this;
                        mainThreadMonitor3.callbackQueues = (Object[]) mainThreadMonitor3.reflectObject(mainThreadMonitor3.choreographer, "mCallbackQueues");
                        if (MainThreadMonitor.this.callbackQueues == null) {
                            MainThreadMonitor mainThreadMonitor4 = MainThreadMonitor.this;
                            mainThreadMonitor4.callbackQueues = (Object[]) mainThreadMonitor4.reflectHideObject(mainThreadMonitor4.choreographer, "mCallbackQueues");
                        }
                        if (Build.VERSION.SDK_INT == 28) {
                            MainThreadMonitor mainThreadMonitor5 = MainThreadMonitor.this;
                            mainThreadMonitor5.mFrameInfo = (long[]) mainThreadMonitor5.reflectHideObject(mainThreadMonitor5.reflectHideObject(mainThreadMonitor5.choreographer, "mFrameInfo"), "mFrameInfo");
                        } else if (Build.VERSION.SDK_INT > 28) {
                            MainThreadMonitor mainThreadMonitor6 = MainThreadMonitor.this;
                            mainThreadMonitor6.mFrameInfo = (long[]) mainThreadMonitor6.reflectHideObject(mainThreadMonitor6.reflectHideObject(mainThreadMonitor6.choreographer, "mFrameInfo"), "frameInfo");
                        } else {
                            MainThreadMonitor mainThreadMonitor7 = MainThreadMonitor.this;
                            mainThreadMonitor7.mFrameInfo = (long[]) mainThreadMonitor7.reflectObject(mainThreadMonitor7.reflectObject(mainThreadMonitor7.choreographer, "mFrameInfo"), "mFrameInfo");
                        }
                        if (MainThreadMonitor.this.mFrameInfo == null) {
                            EnsureManager.ensureNotReachHere("FrameInfoIsNull");
                        }
                        if (MainThreadMonitor.this.callbackQueueLock == null) {
                            EnsureManager.ensureNotReachHere("CallbackQueueLockIsNull");
                        }
                        if (MainThreadMonitor.this.callbackQueues == null) {
                            EnsureManager.ensureNotReachHere("callbackQueuesIsNull");
                        }
                        MainThreadMonitor mainThreadMonitor8 = MainThreadMonitor.this;
                        mainThreadMonitor8.addInputQueue = mainThreadMonitor8.reflectChoreographerMethod(mainThreadMonitor8.callbackQueues[0], MainThreadMonitor.ADD_CALLBACK, Long.TYPE, Object.class, Object.class);
                        MainThreadMonitor mainThreadMonitor9 = MainThreadMonitor.this;
                        mainThreadMonitor9.addFrameCallback(mainThreadMonitor9.callbackRunnable);
                    } catch (Exception e) {
                        EnsureManager.ensureNotReachHere(e, "MainThreadMonitor_fullFps");
                    }
                }
            });
        }
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            Window window = activity.getWindow();
            window.setCallback(new MonitorWindowCallback(window.getCallback()) { // from class: com.bytedance.apm.block.trace.MainThreadMonitor.4
                @Override // android.view.Window.Callback
                public boolean dispatchKeyEvent(KeyEvent keyEvent) {
                    if (!MainThreadMonitor.this.isBelongJavaMessage) {
                        MainThreadMonitor.this.mainThreadInfo.addInputEventInfo(keyEvent.getEventTime());
                    }
                    return this.callback.dispatchKeyEvent(keyEvent);
                }

                @Override // android.view.Window.Callback
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    if (!MainThreadMonitor.this.isBelongJavaMessage) {
                        MainThreadMonitor.this.mainThreadInfo.addInputEventInfo(motionEvent.getEventTime());
                    }
                    return this.callback.dispatchTouchEvent(motionEvent);
                }
            });
            final String name = activity.getClass().getName();
            String obj = activity.toString();
            LooperMonitor.checkLooperState();
            if (!this.mFpsLifeCycleChanged && this.mThreadWithHandler.isReady()) {
                Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener = new Window.OnFrameMetricsAvailableListener() { // from class: com.bytedance.apm.block.trace.MainThreadMonitor.5
                    @Override // android.view.Window.OnFrameMetricsAvailableListener
                    public void onFrameMetricsAvailable(Window window2, FrameMetrics frameMetrics, final int i) {
                        if (MainThreadMonitor.this.isEnableFpsAllocOpt) {
                            final long metric = (((((frameMetrics.getMetric(0) + frameMetrics.getMetric(1)) + frameMetrics.getMetric(2)) + frameMetrics.getMetric(3)) + frameMetrics.getMetric(4)) + frameMetrics.getMetric(5)) / BatteryFactorConfig.WIFI_BPS;
                            final long metric2 = frameMetrics.getMetric(9);
                            if (metric2 == 0 && MainThreadMonitor.this.iFrameCostCallBack != null) {
                                MainThreadMonitor.this.iFrameCostCallBack.frameCostCallBack(frameMetrics);
                            }
                            MainThreadMonitor.this.mThreadWithBlockingQueue.post(new Runnable() { // from class: com.bytedance.apm.block.trace.MainThreadMonitor.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (metric2 == 0) {
                                        if (MainThreadMonitor.mFrameObserver == null || !MainThreadMonitor.this.isEnableLooperOpt) {
                                            Iterator it = MainThreadMonitor.this.observers.iterator();
                                            while (it.hasNext()) {
                                                ((AbsLooperObserver) it.next()).onFrameMetricsAvailable(name, metric, i);
                                            }
                                            return;
                                        }
                                        MainThreadMonitor.mFrameObserver.onFrameMetricsAvailable(name, metric, i);
                                    }
                                }
                            });
                            return;
                        }
                        final FrameMetrics frameMetrics2 = new FrameMetrics(frameMetrics);
                        if (frameMetrics2.getMetric(9) == 0 && MainThreadMonitor.this.iFrameCostCallBack != null) {
                            MainThreadMonitor.this.iFrameCostCallBack.frameCostCallBack(frameMetrics2);
                        }
                        MainThreadMonitor.this.mThreadWithBlockingQueue.post(new Runnable() { // from class: com.bytedance.apm.block.trace.MainThreadMonitor.5.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (frameMetrics2.getMetric(9) == 0) {
                                    if (MainThreadMonitor.mFrameObserver == null || !MainThreadMonitor.this.isEnableLooperOpt) {
                                        Iterator it = MainThreadMonitor.this.observers.iterator();
                                        while (it.hasNext()) {
                                            ((AbsLooperObserver) it.next()).onFrameMetricsAvailable(name, frameMetrics2, i);
                                        }
                                        return;
                                    }
                                    MainThreadMonitor.mFrameObserver.onFrameMetricsAvailable(name, frameMetrics2, i);
                                }
                            }
                        });
                    }
                };
                this.listenerHashMap.put(obj, onFrameMetricsAvailableListener);
                if (this.isEnableCloseListener) {
                    return;
                }
                window.addOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener, this.mThreadWithHandler.mRealHandler);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onActivityDestroyed(Activity activity) {
        try {
            Window.OnFrameMetricsAvailableListener remove = this.listenerHashMap.remove(activity.toString());
            if (remove != null) {
                activity.getWindow().removeOnFrameMetricsAvailableListener(remove);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onActivityResumed(Activity activity) {
        if (this.mFpsLifeCycleChanged) {
            try {
                Window window = activity.getWindow();
                final String name = activity.getClass().getName();
                String obj = activity.toString();
                HashMap<String, Window.OnFrameMetricsAvailableListener> hashMap = this.listenerHashMap;
                if ((hashMap == null || !hashMap.containsKey(obj)) && this.mThreadWithHandler.isReady()) {
                    Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener = new Window.OnFrameMetricsAvailableListener() { // from class: com.bytedance.apm.block.trace.MainThreadMonitor.6
                        @Override // android.view.Window.OnFrameMetricsAvailableListener
                        public void onFrameMetricsAvailable(Window window2, FrameMetrics frameMetrics, final int i) {
                            if (MainThreadMonitor.this.isEnableFpsAllocOpt) {
                                final long metric = (((((frameMetrics.getMetric(0) + frameMetrics.getMetric(1)) + frameMetrics.getMetric(2)) + frameMetrics.getMetric(3)) + frameMetrics.getMetric(4)) + frameMetrics.getMetric(5)) / BatteryFactorConfig.WIFI_BPS;
                                final long metric2 = frameMetrics.getMetric(9);
                                MainThreadMonitor.this.mThreadWithBlockingQueue.post(new Runnable() { // from class: com.bytedance.apm.block.trace.MainThreadMonitor.6.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (metric2 == 0) {
                                            if (MainThreadMonitor.mFrameObserver == null || !MainThreadMonitor.this.isEnableLooperOpt) {
                                                Iterator it = MainThreadMonitor.this.observers.iterator();
                                                while (it.hasNext()) {
                                                    ((AbsLooperObserver) it.next()).onFrameMetricsAvailable(name, metric, i);
                                                }
                                                return;
                                            }
                                            MainThreadMonitor.mFrameObserver.onFrameMetricsAvailable(name, metric, i);
                                        }
                                    }
                                });
                            } else {
                                final FrameMetrics frameMetrics2 = new FrameMetrics(frameMetrics);
                                MainThreadMonitor.this.mThreadWithBlockingQueue.post(new Runnable() { // from class: com.bytedance.apm.block.trace.MainThreadMonitor.6.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (frameMetrics2.getMetric(9) == 0) {
                                            if (MainThreadMonitor.mFrameObserver == null || !MainThreadMonitor.this.isEnableLooperOpt) {
                                                Iterator it = MainThreadMonitor.this.observers.iterator();
                                                while (it.hasNext()) {
                                                    ((AbsLooperObserver) it.next()).onFrameMetricsAvailable(name, frameMetrics2, i);
                                                }
                                                return;
                                            }
                                            MainThreadMonitor.mFrameObserver.onFrameMetricsAvailable(name, frameMetrics2, i);
                                        }
                                    }
                                });
                            }
                        }
                    };
                    this.listenerHashMap.put(obj, onFrameMetricsAvailableListener);
                    if (this.isEnableCloseListener) {
                        return;
                    }
                    window.addOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener, this.mThreadWithHandler.mRealHandler);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void setEnableFpsAllocOpt(boolean z) {
        this.isEnableFpsAllocOpt = z;
    }

    public void setEnableCloseListener(boolean z) {
        this.isEnableCloseListener = z;
    }

    public boolean isEnableCloseListener() {
        return this.isEnableCloseListener;
    }

    public void setEnableLooperOpt(boolean z) {
        this.isEnableLooperOpt = z;
    }

    public boolean isEnableLooperOpt() {
        return this.isEnableLooperOpt;
    }

    public void setFrameObserver(AbsLooperObserver absLooperObserver) {
        mFrameObserver = absLooperObserver;
    }
}
