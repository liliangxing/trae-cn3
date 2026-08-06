package com.bytedance.sysoptimizer.javahook;

import java.security.AccessControlContext;

/* loaded from: classes5.dex */
public class ProxyThread {
    private static final String TAG = "ProxyThread";

    public void run() throws Throwable {
    }

    public ProxyThread() throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_Thread_INIT, this, new Object[0]);
        AHook.getCallback().d(TAG, "ProxyThread() called");
    }

    public ProxyThread(Runnable runnable) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_Thread_INIT_1, this, runnable);
        AHook.getCallback().d(TAG, "ProxyThread() called with: target = [" + runnable + "], this = [" + this + "]");
    }

    ProxyThread(Runnable runnable, AccessControlContext accessControlContext) {
    }

    public ProxyThread(ThreadGroup threadGroup, Runnable runnable) {
    }

    public ProxyThread(String str) {
    }

    public ProxyThread(ThreadGroup threadGroup, String str) {
    }

    ProxyThread(ThreadGroup threadGroup, String str, int i, boolean z) {
    }

    public ProxyThread(Runnable runnable, String str) {
    }

    public ProxyThread(ThreadGroup threadGroup, Runnable runnable, String str) {
    }

    public ProxyThread(ThreadGroup threadGroup, Runnable runnable, String str, long j) {
    }

    public synchronized void start() throws Throwable {
    }
}
