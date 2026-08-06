package com.bytedance.monitor.collector;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.view.Choreographer;
import com.bytedance.monitor.util.unsafe.UnsafeProxy;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class LooperMonitorUtil {
    private static Handler sFrameHandler;
    private static Handler sHandler;
    private static ProxyH proxyH = new ProxyH();
    private static ProxyFrameHandler proxyFrameHandler = new ProxyFrameHandler();
    public static Message mainMessages = Message.obtain();

    public static void init() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mH");
            declaredField.setAccessible(true);
            sHandler = (Handler) declaredField.get(invoke);
            UnsafeProxy.putObject(invoke, UnsafeProxy.objectFieldOffset(declaredField), proxyH);
            Choreographer choreographer = Choreographer.getInstance();
            Class<?> cls2 = choreographer.getClass();
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            Field field = (Field) declaredMethod2.invoke(cls2, "mHandler");
            field.setAccessible(true);
            sFrameHandler = (Handler) field.get(choreographer);
            UnsafeProxy.putObject(choreographer, UnsafeProxy.objectFieldOffset(field), proxyFrameHandler);
            Looper mainLooper = Looper.getMainLooper();
            Field field2 = (Field) declaredMethod2.invoke(mainLooper.getClass(), "mQueue");
            field2.setAccessible(true);
            MessageQueue messageQueue = (MessageQueue) field2.get(mainLooper);
            Field field3 = (Field) declaredMethod2.invoke(messageQueue.getClass(), "mMessages");
            field3.setAccessible(true);
            mainMessages = (Message) field3.get(messageQueue);
        } catch (Exception e) {
            EnsureManager.getEnsureImpl().ensureNotReachHere(e, "LooperMonitorUtil init error");
        }
    }

    /* loaded from: classes4.dex */
    static class ProxyFrameHandler extends Handler {
        ProxyFrameHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LooperMonitorUtil.sFrameHandler.handleMessage(message);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            return super.sendMessageAtTime(message, j);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            if (message.getCallback() != null) {
                super.dispatchMessage(message);
            } else {
                super.dispatchMessage(message);
            }
        }
    }

    /* loaded from: classes4.dex */
    static class ProxyH extends Handler {
        ProxyH() {
        }

        String codeToString(int i) {
            return Integer.toString(i);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LooperMonitorUtil.sHandler.handleMessage(message);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            super.dispatchMessage(message);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            return super.sendMessageAtTime(message, j);
        }
    }
}
