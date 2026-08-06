package com.bytedance.common.wschannel;

import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.message.PushThreadHandlerManager;

/* loaded from: classes3.dex */
public class SocketHandler implements WeakHandler.IHandler {
    private static WeakHandler mHandler;
    private static volatile SocketHandler sInstance;

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message message) {
    }

    public static void setStartedHandlerThread(HandlerThread handlerThread) {
        synchronized (SocketHandler.class) {
            if (mHandler == null) {
                mHandler = new WeakHandler(handlerThread.getLooper(), new WeakHandler.IHandler() { // from class: com.bytedance.common.wschannel.SocketHandler.1
                    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
                    public void handleMsg(Message message) {
                    }
                });
            }
        }
    }

    public static SocketHandler inst() {
        if (sInstance == null) {
            synchronized (SocketHandler.class) {
                if (sInstance == null) {
                    sInstance = new SocketHandler();
                }
            }
        }
        return sInstance;
    }

    private SocketHandler() {
        if (mHandler == null) {
            try {
                mHandler = PushThreadHandlerManager.inst().getHandler();
            } catch (Throwable unused) {
                HandlerThread handlerThread = new HandlerThread("WsHT");
                handlerThread.start();
                mHandler = new WeakHandler(handlerThread.getLooper(), this);
            }
        }
    }

    public WeakHandler getHandler() {
        return mHandler;
    }

    public void postRunnable(Runnable runnable) {
        postRunnable(runnable, 0L);
    }

    public void postRunnable(Runnable runnable, long j) {
        if (j <= 0) {
            mHandler.post(runnable);
        } else {
            mHandler.postDelayed(runnable, j);
        }
    }
}
