package com.lynx.tasm.ui.image.fresco;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.executors.HandlerExecutorServiceImpl;

/* loaded from: classes7.dex */
public class LynxUIThreadImmediateExecutor extends HandlerExecutorServiceImpl {
    private static Handler mHandler;
    private static volatile LynxUIThreadImmediateExecutor sInstance;

    private LynxUIThreadImmediateExecutor(Handler handler) {
        super(handler);
    }

    public static LynxUIThreadImmediateExecutor getInstance() {
        if (sInstance == null) {
            synchronized (LynxUIThreadImmediateExecutor.class) {
                if (sInstance == null) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    mHandler = handler;
                    sInstance = new LynxUIThreadImmediateExecutor(handler);
                }
            }
        }
        return sInstance;
    }

    @Override // com.facebook.common.executors.HandlerExecutorServiceImpl, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (isHandlerThread()) {
            runnable.run();
            return;
        }
        Handler handler = mHandler;
        if (handler != null) {
            Message obtain = Message.obtain(handler, runnable);
            obtain.setAsynchronous(true);
            mHandler.sendMessageAtFrontOfQueue(obtain);
        }
    }
}
