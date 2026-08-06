package com.bytedance.apm.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ApmHandlerThread {
    private static HashSet<HandlerThread> handlerThreads = new HashSet<>();
    private static volatile Handler defaultMainHandler = new Handler(Looper.getMainLooper());

    public static Handler getDefaultMainHandler() {
        return defaultMainHandler;
    }

    public static HandlerThread getNewHandlerThread(String str) {
        return getNewHandlerThread(str, -1);
    }

    public static HandlerThread getNewHandlerThread(String str, int i) {
        Iterator<HandlerThread> it = handlerThreads.iterator();
        while (it.hasNext()) {
            if (!it.next().isAlive()) {
                it.remove();
            }
        }
        HandlerThread handlerThread = new HandlerThread(str);
        if (i != -1) {
            handlerThread.setPriority(i);
        }
        handlerThread.start();
        handlerThreads.add(handlerThread);
        return handlerThread;
    }

    public static ThreadWithHandler getThreadWithHandler(String str) {
        ThreadWithHandler threadWithHandler = new ThreadWithHandler(str);
        threadWithHandler.start();
        return threadWithHandler;
    }
}
