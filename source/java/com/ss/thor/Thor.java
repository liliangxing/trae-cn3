package com.ss.thor;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public class Thor {
    private static final int FIXED_KEEP_ALIVE_SECONDS = 30;
    public static final int NO_C = 3;
    public static final int NO_I = 1;
    public static final int NO_U = 2;
    public static final int NO_UI = 4;
    public static final int NO_UIC = 5;
    private static final int SAMPLE_DEFAULT = 3000;
    public static final String TAG = "Thor";
    private static ThorCallback mCallBack;
    private static ExecutorService mExecutorService;
    private static HandlerThread mThorThread;
    private static AtomicInteger sThreadCount = new AtomicInteger(0);
    private static int sample_rate;
    private static ThorHandler thorHandler;

    public static void start(Context context, ThorCallback thorCallback) {
        start(context, thorCallback, 1, 3000);
    }

    public static void start(Context context, ThorCallback thorCallback, int i, int i2) {
        if (mThorThread == null) {
            HandlerThread handlerThread = new HandlerThread("Thor-Handler-Thread");
            mThorThread = handlerThread;
            handlerThread.start();
            thorHandler = new ThorHandler(mThorThread.getLooper());
            mCallBack = thorCallback;
            thorCallback.onStart();
            sample_rate = i2;
        }
        ThorHandler thorHandler2 = thorHandler;
        thorHandler2.sendMessage(thorHandler2.obtainMessage(i, context));
    }

    public static void stop() {
        HandlerThread handlerThread = mThorThread;
        if (handlerThread != null) {
            handlerThread.quit();
            mCallBack.onStop();
            mThorThread = null;
            thorHandler = null;
            mCallBack = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class ThorHandler extends Handler {
        public ThorHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (Thor.mCallBack == null) {
                return;
            }
            int i = message.what;
            Context context = (Context) message.obj;
            if (i == 1) {
                Thor.mCallBack.onUpdate(ThorUtils.getGalvanicNow(context), -1.0f, -1L);
            } else if (i == 2) {
                Thor.mCallBack.onUpdate(-1.0f, ThorUtils.getVoltage(context), -1L);
            } else if (i == 3) {
                Thor.mCallBack.onUpdate(-1.0f, -1.0f, ThorUtils.getCapacity(context));
            } else {
                if (i != 4) {
                    if (i == 5) {
                        Thor.mCallBack.onUpdate(ThorUtils.getGalvanicNow(context), ThorUtils.getVoltage(context), ThorUtils.getCapacity(context));
                    }
                    sendMessageDelayed(obtainMessage(i, context), Thor.sample_rate);
                }
                Thor.mCallBack.onUpdate(ThorUtils.getGalvanicNow(context), ThorUtils.getVoltage(context), -1L);
            }
            sendMessageDelayed(obtainMessage(i, context), Thor.sample_rate);
        }
    }

    public static ExecutorService getExecutorService() {
        if (mExecutorService == null) {
            synchronized (Thor.class) {
                if (mExecutorService == null) {
                    mExecutorService = createSerialExecutor();
                }
            }
        }
        return mExecutorService;
    }

    private static ThreadFactory threadFactory(final String str, final boolean z, final int i) {
        return new ThreadFactory() { // from class: com.ss.thor.Thor.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(final Runnable runnable) {
                Thread thread = new Thread(new Runnable() { // from class: com.ss.thor.Thor.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(i);
                        runnable.run();
                    }
                });
                thread.setName(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Thor.sThreadCount.incrementAndGet());
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    private static ExecutorService createSerialExecutor() {
        return Executors.newSingleThreadExecutor(threadFactory(TAG, false, 0));
    }
}
