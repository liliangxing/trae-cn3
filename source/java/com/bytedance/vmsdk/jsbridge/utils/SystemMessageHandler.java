package com.bytedance.vmsdk.jsbridge.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class SystemMessageHandler extends Handler {
    private static final int SCHEDULED_WORK = 1;
    private static final String TAG = "SystemMessageHandler";
    private boolean mHasMethodBeenFound = false;
    private boolean mIsRunning = true;
    private Method mMessageMethodSetAsynchronous;
    private long mMessagePumpDelegateNative;

    private native void nativeRunWork(long j);

    private SystemMessageHandler(long j) {
        this.mMessagePumpDelegateNative = j;
    }

    public static SystemMessageHandler create(long j) {
        return new SystemMessageHandler(j);
    }

    private void scheduleWork() {
        sendMessage(obtainAsyncMessage(1));
    }

    private void stop() {
        this.mIsRunning = false;
    }

    private void findMethodSetAsynchronous() {
        if (this.mHasMethodBeenFound) {
            return;
        }
        this.mHasMethodBeenFound = true;
    }

    private Message obtainAsyncMessage(int i) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.setAsynchronous(true);
        return obtain;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.mIsRunning) {
            nativeRunWork(this.mMessagePumpDelegateNative);
        }
    }
}
