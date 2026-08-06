package com.bytedance.frameworks.baselib.network.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class PlatformHandlerThread {
    private static final String BACKGROUND_THREAD_NAME = "back_handler_thread";
    private static final String DEFAULT_THREAD_NAME = "common_handler_thread";
    private static final String MARK = "\u200b";
    private static final String TAG = "PlatformHandlerThread";
    private static volatile Handler backgroundHandler;
    private static volatile HandlerThread backgroundHandlerThread;
    private static volatile Handler defaultHandler;
    private static volatile HandlerThread defaultHandlerThread;
    private static volatile Handler defaultMainHandler = new Handler(Looper.getMainLooper());
    private static HashMap<String, HandlerThread> handlerThreads = new HashMap<>();
    private static List<String> whiteList = Arrays.asList("NpthHandlerThread", "NewVideo-HandlerThread", "trace_time_update_thread");
    private static List<String> normalList = Arrays.asList("DBHelper-AsyncOp-New");
    private static Map<String, String> groupMap = new HashMap();

    public static Handler getDefaultMainHandler() {
        return defaultMainHandler;
    }

    public static Handler getDefaultHandler() {
        Handler handler;
        synchronized (PlatformHandlerThread.class) {
            if (defaultHandler == null) {
                getDefaultHandlerThread();
            }
            handler = defaultHandler;
        }
        return handler;
    }

    public static HandlerThread getDefaultHandlerThread() {
        HandlerThread handlerThread;
        synchronized (PlatformHandlerThread.class) {
            if (defaultHandlerThread == null) {
                defaultHandlerThread = new InnerHandlerThread(DEFAULT_THREAD_NAME);
                defaultHandlerThread.start();
                defaultHandler = new Handler(defaultHandlerThread.getLooper());
            }
            handlerThread = defaultHandlerThread;
        }
        return handlerThread;
    }

    public static Handler getBackgroundHandler() {
        Handler handler;
        synchronized (PlatformHandlerThread.class) {
            if (backgroundHandler == null) {
                getBackgroundHandlerThread();
            }
            handler = backgroundHandler;
        }
        return handler;
    }

    public static HandlerThread getBackgroundHandlerThread() {
        HandlerThread handlerThread;
        synchronized (PlatformHandlerThread.class) {
            if (backgroundHandlerThread == null) {
                backgroundHandlerThread = new InnerHandlerThread(BACKGROUND_THREAD_NAME, 10);
                backgroundHandlerThread.start();
                backgroundHandler = new Handler(backgroundHandlerThread.getLooper());
            }
            handlerThread = backgroundHandlerThread;
        }
        return handlerThread;
    }

    public static HandlerThread getNewHandlerThread(String str) {
        return getNewHandlerThread(str, 0, "");
    }

    public static HandlerThread getNewHandlerThread(String str, String str2) {
        return getNewHandlerThread(str, 0, str2);
    }

    public static HandlerThread getNewHandlerThread(String str, int i, String str2) {
        Iterator<Map.Entry<String, HandlerThread>> it = handlerThreads.entrySet().iterator();
        while (it.hasNext()) {
            if (!it.next().getValue().isAlive()) {
                it.remove();
            }
        }
        HandlerThread handlerThread = handlerThreads.get(str);
        if (handlerThread != null) {
            return handlerThread;
        }
        InnerHandlerThread innerHandlerThread = new InnerHandlerThread(str, i);
        innerHandlerThread.start();
        handlerThreads.put(str, innerHandlerThread);
        return innerHandlerThread;
    }

    private static String getNameByCommonPackage(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "platform_handler";
        }
        String[] split = str.split("/");
        if (split.length < 4) {
            return "platform_handler";
        }
        String str3 = split[0] + split[1] + split[2] + split[3];
        String str4 = groupMap.get(str3);
        if (!TextUtils.isEmpty(str4)) {
            return str4;
        }
        groupMap.put(str3, str2);
        return str2;
    }

    /* loaded from: classes2.dex */
    public static class InnerHandlerThread extends HandlerThread {
        private volatile boolean isStart;

        public InnerHandlerThread(String str) {
            super(str);
            this.isStart = false;
        }

        public InnerHandlerThread(String str, int i) {
            super(str, i);
            this.isStart = false;
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            if (this.isStart) {
                return;
            }
            this.isStart = true;
            super.start();
        }
    }
}
