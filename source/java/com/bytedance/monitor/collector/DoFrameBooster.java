package com.bytedance.monitor.collector;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Choreographer;
import com.bytedance.monitor.collector.service.DoubleReflectHelper;
import com.bytedance.monitor.util.unsafe.UnsafeProxy;

/* loaded from: classes4.dex */
public class DoFrameBooster {
    public static final int SEND_AFTER_CURRENT = 1;
    public static final int SEND_AT_FRONT = 0;
    private static final String TAG = "doFrameBooster";
    private static volatile boolean isInited;
    private static Handler sFrameHandler;
    private static final ProxyFrameHandler proxyFrameHandler = new ProxyFrameHandler(Looper.getMainLooper());
    private static Object sFrameDisplayEventReceiver = null;
    private static volatile boolean sNeedHook = false;
    private static int sMessageGap = 0;
    private static int sRunMode = 1;

    public static synchronized void init() {
        synchronized (DoFrameBooster.class) {
            init(Choreographer.getInstance());
        }
    }

    public static synchronized void init(Choreographer choreographer) {
        synchronized (DoFrameBooster.class) {
            if (isInited) {
                return;
            }
            try {
                sFrameHandler = (Handler) DoubleReflectHelper.readField(choreographer, "mHandler");
                sFrameDisplayEventReceiver = DoubleReflectHelper.readField(choreographer, "mDisplayEventReceiver");
                UnsafeProxy.putObject(choreographer, UnsafeProxy.objectFieldOffset(DoubleReflectHelper.getField(Choreographer.class, "mHandler")), proxyFrameHandler);
                Log.i(TAG, "hack Choreographer Success");
                isInited = true;
            } catch (Exception e) {
                Log.e(TAG, "hack Choreographer Error", e);
            }
        }
    }

    public static void setNeedHook(boolean z) {
        sNeedHook = z;
    }

    public static void setMessageGap(int i) {
        sMessageGap = i;
    }

    public static void setRunMode(int i) {
        sRunMode = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class ProxyFrameHandler extends Handler {
        public ProxyFrameHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DoFrameBooster.sFrameHandler.handleMessage(message);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            if (message.getCallback() == DoFrameBooster.sFrameDisplayEventReceiver && DoFrameBooster.sNeedHook) {
                if (DoFrameBooster.sRunMode == 0) {
                    return sendMessageAtFrontOfQueue(message);
                }
                Message messageObject = LooperUtil.getMessageObject(LooperUtil.getMainMessageQueue());
                if (messageObject != null) {
                    return super.sendMessageAtTime(message, Math.min(messageObject.getWhen() + DoFrameBooster.sMessageGap, j));
                }
                return sendMessageAtFrontOfQueue(message);
            }
            return super.sendMessageAtTime(message, j);
        }
    }
}
