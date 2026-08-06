package com.ss.android.message;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes7.dex */
public class PushThreadHandlerManager implements WeakHandler.IHandler {
    private static HandlerThread sHandlerThread;
    private static volatile PushThreadHandlerManager sInstance;
    private static boolean sIsHandlerThreadInited;
    private final Set<Handler.Callback> mCallbacks = new HashSet();
    private final WeakHandler mHandler;

    public static void setStartedHandlerThread(HandlerThread handlerThread) {
        if (sIsHandlerThreadInited || handlerThread == null) {
            return;
        }
        sHandlerThread = handlerThread;
    }

    public void addHandlerCallback(Handler.Callback callback) {
        synchronized (this.mCallbacks) {
            this.mCallbacks.add(callback);
        }
    }

    public void removeHandlerCallback(Handler.Callback callback) {
        synchronized (this.mCallbacks) {
            this.mCallbacks.remove(callback);
        }
    }

    public static PushThreadHandlerManager inst() {
        if (sInstance == null) {
            synchronized (PushThreadHandlerManager.class) {
                if (sInstance == null) {
                    sInstance = new PushThreadHandlerManager();
                }
            }
        }
        return sInstance;
    }

    private PushThreadHandlerManager() {
        if (sHandlerThread == null) {
            HandlerThread handlerThread = new HandlerThread("PushThreadHandler");
            sHandlerThread = handlerThread;
            handlerThread.start();
            sIsHandlerThreadInited = true;
        }
        this.mHandler = new WeakHandler(sHandlerThread.getLooper(), this);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message message) {
        synchronized (this.mCallbacks) {
            Iterator<Handler.Callback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                if (it.next().handleMessage(message)) {
                    return;
                }
            }
        }
    }

    public Looper getLooper() {
        return sHandlerThread.getLooper();
    }

    public WeakHandler getHandler() {
        return this.mHandler;
    }

    public WeakHandler getHandler(Handler.Callback callback) {
        addHandlerCallback(callback);
        return getHandler();
    }

    public void postRunnable(Runnable runnable) {
        postRunnable(runnable, 0L);
    }

    public void postRunnable(Runnable runnable, long j) {
        if (j <= 0) {
            if (Looper.myLooper() != this.mHandler.getLooper()) {
                this.mHandler.post(runnable);
                return;
            } else {
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
        }
        this.mHandler.postDelayed(runnable, j);
    }
}
