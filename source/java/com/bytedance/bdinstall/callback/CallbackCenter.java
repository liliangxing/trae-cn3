package com.bytedance.bdinstall.callback;

import android.os.Looper;
import com.bytedance.bdinstall.ExecutorUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class CallbackCenter {
    private final Object sLock = new Object();
    private final Object VALUE = new Object();
    private final ConcurrentHashMap<Type, ValueHolder> OBSERVERS_MAP = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<CallbackWrapper, Object> CALLBACK_WRAPPERS = new ConcurrentHashMap<>();
    private String mAid = null;

    public void init(String str) {
        this.mAid = str;
    }

    public <EVENT> void register(Callback<EVENT> callback) {
        register(false, callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <EVENT> void register(boolean z, Callback<EVENT> callback) {
        if (callback == 0) {
            return;
        }
        Type type = ((ParameterizedType) callback.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        synchronized (this.sLock) {
            ValueHolder valueHolder = this.OBSERVERS_MAP.get(type);
            if (valueHolder == null) {
                valueHolder = new ValueHolder();
                this.OBSERVERS_MAP.put(type, valueHolder);
            }
            valueHolder.put(callback, this.VALUE);
            if (callback instanceof CallbackWrapper) {
                this.CALLBACK_WRAPPERS.put((CallbackWrapper) callback, this.VALUE);
            }
            if (z && valueHolder.value != null) {
                callbackWhenRegister(callback, valueHolder, valueHolder.value);
            }
        }
    }

    private <EVENT> void callbackWhenRegister(final Callback<EVENT> callback, final ValueHolder valueHolder, final Object obj) {
        ExecutorUtil.runOnHandlerThread(this.mAid, new Runnable() { // from class: com.bytedance.bdinstall.callback.CallbackCenter.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator<Callback> it = valueHolder.keySet().iterator();
                while (it.hasNext()) {
                    if (callback == it.next()) {
                        callback.onCall(obj);
                        return;
                    }
                }
            }
        });
    }

    public <EVENT> void unregister(Callback<EVENT> callback) {
        if (callback == null) {
            return;
        }
        Type type = ((ParameterizedType) callback.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        synchronized (this.sLock) {
            ValueHolder valueHolder = this.OBSERVERS_MAP.get(type);
            if (valueHolder != null) {
                valueHolder.remove(callback);
            }
        }
    }

    public void unregister(Object obj) {
        CallbackWrapper callbackWrapper;
        if (obj == null) {
            return;
        }
        synchronized (this.sLock) {
            Iterator<CallbackWrapper> it = this.CALLBACK_WRAPPERS.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    callbackWrapper = null;
                    break;
                } else {
                    callbackWrapper = it.next();
                    if (callbackWrapper.getListener() == obj) {
                        break;
                    }
                }
            }
            if (callbackWrapper != null) {
                unregister(callbackWrapper);
                this.CALLBACK_WRAPPERS.remove(callbackWrapper);
            }
        }
    }

    public <Event> void postEvent(final Event event) {
        ValueHolder valueHolder;
        if (Looper.myLooper() != ExecutorUtil.getLooper(this.mAid)) {
            ExecutorUtil.runOnHandlerThread(this.mAid, new Runnable() { // from class: com.bytedance.bdinstall.callback.CallbackCenter.2
                @Override // java.lang.Runnable
                public void run() {
                    CallbackCenter.this.postEvent(event);
                }
            });
            return;
        }
        synchronized (this.sLock) {
            valueHolder = this.OBSERVERS_MAP.get(event.getClass());
            if (valueHolder == null) {
                valueHolder = new ValueHolder();
                this.OBSERVERS_MAP.put(event.getClass(), valueHolder);
            }
        }
        valueHolder.value = event;
        for (Callback callback : valueHolder.keySet()) {
            if (callback != null) {
                callback.onCall(event);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class ValueHolder {
        ConcurrentHashMap<Callback, Object> callbacks;
        Object value;

        private ValueHolder() {
            this.callbacks = new ConcurrentHashMap<>();
        }

        void remove(Callback callback) {
            this.callbacks.remove(callback);
        }

        public boolean isEmpty() {
            return this.callbacks.isEmpty();
        }

        Set<Callback> keySet() {
            return this.callbacks.keySet();
        }

        public void put(Callback callback, Object obj) {
            this.callbacks.put(callback, obj);
        }
    }
}
