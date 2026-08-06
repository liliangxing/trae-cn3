package com.bytedance.sysoptimizer.java;

import android.os.Build;
import android.os.Handler;
import android.os.Message;

/* loaded from: classes5.dex */
public class AndroidNWindowManagerProtector {
    private static final int LAUNCH_ACTIVITY = 100;
    private static final int MAX_RETRY_COUNT = 3;
    private static final String TAG = "WindowManagerProtector";
    private static GuardListener guardListener;
    private static int retryCount;

    /* loaded from: classes5.dex */
    public interface GuardListener {
        void onGuardFailed();

        void onGuardSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class CrashGuardCallback implements Handler.Callback {
        Handler.Callback originCallBack;
        Handler systemHandler;

        CrashGuardCallback(Handler handler, Handler.Callback callback) {
            this.systemHandler = handler;
            this.originCallBack = callback;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                Handler.Callback callback = this.originCallBack;
                if (callback != null && callback.handleMessage(message)) {
                    AndroidNWindowManagerProtector.resetRetryCount();
                    return true;
                }
                Handler handler = this.systemHandler;
                if (handler != null) {
                    handler.handleMessage(message);
                    AndroidNWindowManagerProtector.resetRetryCount();
                }
                return true;
            } catch (Throwable th) {
                if (th instanceof StackOverflowError) {
                    if (message == null || message.what != 100 || AndroidNWindowManagerProtector.retryWhenWindowManagerStackOverFlow(message, this.systemHandler)) {
                        return false;
                    }
                    if (AndroidNWindowManagerProtector.guardListener != null) {
                        AndroidNWindowManagerProtector.guardListener.onGuardFailed();
                    }
                    throw th;
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void resetRetryCount() {
        if (retryCount > 0) {
            retryCount = 0;
        }
        GuardListener guardListener2 = guardListener;
        if (guardListener2 != null) {
            guardListener2.onGuardSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean retryWhenWindowManagerStackOverFlow(Message message, Handler handler) {
        if (retryCount > 3) {
            return false;
        }
        try {
            Thread.sleep(20L);
            Message message2 = new Message();
            message2.copyFrom(message);
            handler.sendMessage(message2);
            retryCount++;
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void install(GuardListener guardListener2) {
        if (Build.VERSION.SDK_INT == 24 || Build.VERSION.SDK_INT == 25) {
            takeOverSystemCallback();
            guardListener = guardListener2;
        }
    }

    private static void takeOverSystemCallback() {
        Handler handler;
        Object invokeStaticMethod = ReflectionUtils.invokeStaticMethod("android.app.ActivityThread", "currentActivityThread");
        if (invokeStaticMethod == null || (handler = (Handler) ReflectionUtils.getFieldObject("android.app.ActivityThread", "mH", invokeStaticMethod)) == null) {
            return;
        }
        ReflectionUtils.setFieldObject(handler, "mCallback", new CrashGuardCallback(handler, (Handler.Callback) ReflectionUtils.getFieldObject("android.app.ActivityThread$H", "mCallback", handler)));
    }
}
