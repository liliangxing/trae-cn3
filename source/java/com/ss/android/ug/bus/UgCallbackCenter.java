package com.ss.android.ug.bus;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class UgCallbackCenter {
    private static final Object VALUE = new Object();
    private static final ConcurrentHashMap<Type, ConcurrentHashMap<Callback, Object>> OBSERVERS_MAP = new ConcurrentHashMap<>();
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());

    /* loaded from: classes7.dex */
    public interface Callback<T> {
        void onCall(T t);
    }

    public static <EVENT> void register(Callback<EVENT> callback) {
        register(null, callback);
    }

    public static <EVENT> void register(final LifecycleOwner lifecycleOwner, final Callback<EVENT> callback) {
        if (callback == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            MAIN_HANDLER.post(new Runnable() { // from class: com.ss.android.ug.bus.UgCallbackCenter.1
                @Override // java.lang.Runnable
                public void run() {
                    UgCallbackCenter.register(LifecycleOwner.this, callback);
                }
            });
            return;
        }
        final Type type = ((ParameterizedType) callback.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        ConcurrentHashMap<Type, ConcurrentHashMap<Callback, Object>> concurrentHashMap = OBSERVERS_MAP;
        final ConcurrentHashMap<Callback, Object> concurrentHashMap2 = concurrentHashMap.get(type);
        if (concurrentHashMap2 == null) {
            concurrentHashMap2 = new ConcurrentHashMap<>();
            concurrentHashMap.put(type, concurrentHashMap2);
        }
        concurrentHashMap2.put(callback, VALUE);
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.ss.android.ug.bus.UgCallbackCenter.2
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                void onDestroy() {
                    concurrentHashMap2.remove(callback);
                    if (concurrentHashMap2.isEmpty()) {
                        UgCallbackCenter.OBSERVERS_MAP.remove(type);
                    }
                }
            });
        }
    }

    public static <EVENT> void unregister(final Callback<EVENT> callback) {
        if (callback == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            MAIN_HANDLER.post(new Runnable() { // from class: com.ss.android.ug.bus.UgCallbackCenter.3
                @Override // java.lang.Runnable
                public void run() {
                    UgCallbackCenter.unregister(Callback.this);
                }
            });
            return;
        }
        Type type = ((ParameterizedType) callback.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        ConcurrentHashMap<Type, ConcurrentHashMap<Callback, Object>> concurrentHashMap = OBSERVERS_MAP;
        ConcurrentHashMap<Callback, Object> concurrentHashMap2 = concurrentHashMap.get(type);
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.remove(callback);
            if (concurrentHashMap2.isEmpty()) {
                concurrentHashMap.remove(type);
            }
        }
    }

    public static <Event> void postEvent(final Event event) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            MAIN_HANDLER.post(new Runnable() { // from class: com.ss.android.ug.bus.UgCallbackCenter.4
                @Override // java.lang.Runnable
                public void run() {
                    UgCallbackCenter.postEvent(event);
                }
            });
            return;
        }
        ConcurrentHashMap<Callback, Object> concurrentHashMap = OBSERVERS_MAP.get(event.getClass());
        if (concurrentHashMap != null) {
            for (Callback callback : concurrentHashMap.keySet()) {
                if (callback != null) {
                    callback.onCall(event);
                }
            }
        }
    }
}
