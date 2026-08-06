package com.bytedance.observer;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.bytedance.apm.block.LooperObserverMonitor;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public class ObserverWrapper extends LooperObserverMonitor.BaseObserver implements Looper.Observer {
    private Looper.Observer mOriginObserver;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            throw new IllegalStateException("load class error");
        }
    }

    @Override // com.bytedance.apm.block.LooperObserverMonitor.BaseObserver
    protected void setup(Object obj) {
        if (obj != null && (obj instanceof Looper.Observer)) {
            this.mOriginObserver = (Looper.Observer) obj;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object messageDispatchStarting() {
        Object obj;
        if (LooperObserverMonitor.sOriginObserver != null) {
            Looper.Observer observer = this.mOriginObserver;
            if (observer != null) {
                obj = observer.messageDispatchStarting();
            } else {
                try {
                    obj = LooperObserverMonitor.messageDispatchStarting.invoke(LooperObserverMonitor.sOriginObserver, new Object[0]);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                }
            }
            if (LooperObserverMonitor.sMainThread == Thread.currentThread()) {
                messageDispatchStarting(LooperObserverMonitor.sStart);
            }
            return obj;
        }
        obj = null;
        if (LooperObserverMonitor.sMainThread == Thread.currentThread()) {
        }
        return obj;
    }

    public void messageDispatched(Object obj, Message message) {
        if (LooperObserverMonitor.sOriginObserver != null) {
            Looper.Observer observer = this.mOriginObserver;
            if (observer != null) {
                observer.messageDispatched(obj, message);
            } else {
                try {
                    LooperObserverMonitor.messageDispatched.invoke(LooperObserverMonitor.sOriginObserver, obj, message);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (LooperObserverMonitor.sMainThread == Thread.currentThread()) {
            messageDispatched(LooperObserverMonitor.sEnd, message);
        }
    }

    public void dispatchingThrewException(Object obj, Message message, Exception exc) {
        if (LooperObserverMonitor.sOriginObserver != null) {
            Looper.Observer observer = this.mOriginObserver;
            if (observer != null) {
                observer.dispatchingThrewException(obj, message, exc);
                return;
            }
            try {
                LooperObserverMonitor.dispatchingThrewException.invoke(LooperObserverMonitor.sOriginObserver, obj, message, exc);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }
}
