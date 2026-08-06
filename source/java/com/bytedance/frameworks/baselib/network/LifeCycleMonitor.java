package com.bytedance.frameworks.baselib.network;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class LifeCycleMonitor implements Application.ActivityLifecycleCallbacks {
    private static boolean mAppAlive;
    private static WeakHandler sHandler = new WeakHandler(Looper.getMainLooper(), new WeakHandler.IHandler() { // from class: com.bytedance.frameworks.baselib.network.LifeCycleMonitor.1
        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public void handleMsg(Message message) {
        }
    });
    private List<NetworkAppStateListener> mListeners = new CopyOnWriteArrayList();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public LifeCycleMonitor() {
        if (getActivity() != null) {
            mAppAlive = true;
        }
    }

    private static Activity getActivity() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(invoke);
            if (map == null) {
                return null;
            }
            for (Object obj : map.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void addListener(NetworkAppStateListener networkAppStateListener) {
        this.mListeners.add(networkAppStateListener);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (!mAppAlive) {
            mAppAlive = true;
            Iterator<NetworkAppStateListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onEnterToForeground();
            }
        }
        sHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (mAppAlive) {
            Iterator<NetworkAppStateListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                sHandler.postDelayed(it.next().getBGRunnable(), r0.getEnterBackgroundDelayMills());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class NetworkAppStateListener {
        private Runnable mBGRunnable;
        private int mEnterBackgroundDelayMills;

        public abstract void onEnterToBackground();

        public abstract void onEnterToForeground();

        public NetworkAppStateListener() {
            this.mEnterBackgroundDelayMills = 30000;
            this.mBGRunnable = new Runnable() { // from class: com.bytedance.frameworks.baselib.network.LifeCycleMonitor.NetworkAppStateListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LifeCycleMonitor.mAppAlive) {
                        boolean unused = LifeCycleMonitor.mAppAlive = false;
                        NetworkAppStateListener.this.onEnterToBackground();
                    }
                }
            };
        }

        public NetworkAppStateListener(int i) {
            this.mEnterBackgroundDelayMills = 30000;
            this.mBGRunnable = new Runnable() { // from class: com.bytedance.frameworks.baselib.network.LifeCycleMonitor.NetworkAppStateListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LifeCycleMonitor.mAppAlive) {
                        boolean unused = LifeCycleMonitor.mAppAlive = false;
                        NetworkAppStateListener.this.onEnterToBackground();
                    }
                }
            };
            this.mEnterBackgroundDelayMills = i;
        }

        public Runnable getBGRunnable() {
            return this.mBGRunnable;
        }

        public int getEnterBackgroundDelayMills() {
            return this.mEnterBackgroundDelayMills;
        }

        public void setEnterBackgroundDelayMills(int i) {
            this.mEnterBackgroundDelayMills = i;
        }
    }
}
