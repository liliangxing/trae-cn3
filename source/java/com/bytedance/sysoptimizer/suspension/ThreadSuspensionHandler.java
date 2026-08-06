package com.bytedance.sysoptimizer.suspension;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class ThreadSuspensionHandler extends HandlerThread implements Handler.Callback {
    private static final int MSG_CHECK_THREAD_SUSPENSION = 1;
    private static final int MSG_QUIT = 2;
    private static final int MSG_RESUME_THREAD = 0;
    private static final String TAG = "ThreadSuspension";
    private String[] ignoredThreadNameArray;
    private final Set<String> ignoredThreadNameSet;
    private final AtomicBoolean mCheckQuitFlag;
    private boolean mEnableCrash;
    private long mIntervalCheckDuration;
    private final int mMainThreadTid;
    private float mRatio;
    private long mSuspendDuration;
    private ThreadSuspendedCallback mSuspendedCallback;
    private Runnable mThreadFinishedCallback;
    private Handler mThreadHandler;
    private static final AtomicBoolean sNativeHasInited = new AtomicBoolean(false);
    private static boolean mJniInitSuccess = true;

    private void setupParam(SuspensionParam suspensionParam) {
        if (suspensionParam == null) {
            return;
        }
        this.mSuspendDuration = suspensionParam.getThreadSuspendDuration();
        this.mIntervalCheckDuration = suspensionParam.getIntervalCheckSuspensionDuration();
        this.mRatio = suspensionParam.getRatio();
        this.mEnableCrash = suspensionParam.isEnableCrashWhenInitFailed();
        Set<String> ignoredThreadSet = suspensionParam.getIgnoredThreadSet();
        if (ignoredThreadSet == null || ignoredThreadSet.isEmpty()) {
            return;
        }
        this.ignoredThreadNameSet.addAll(ignoredThreadSet);
    }

    public ThreadSuspensionHandler(String str, int i, SuspensionParam suspensionParam) {
        this(str, 0, i, suspensionParam, null, null);
    }

    public ThreadSuspensionHandler(String str, int i, int i2, SuspensionParam suspensionParam, ThreadSuspendedCallback threadSuspendedCallback, Runnable runnable) {
        super(str, i);
        this.mCheckQuitFlag = new AtomicBoolean(false);
        this.mSuspendDuration = 500L;
        this.mIntervalCheckDuration = 2000L;
        this.mRatio = 1.0f;
        this.mSuspendedCallback = null;
        this.mThreadFinishedCallback = null;
        this.mEnableCrash = false;
        HashSet<String> hashSet = new HashSet<String>() { // from class: com.bytedance.sysoptimizer.suspension.ThreadSuspensionHandler.1
            {
                add("main");
            }
        };
        this.ignoredThreadNameSet = hashSet;
        this.mMainThreadTid = i2;
        hashSet.add(str);
        this.mSuspendedCallback = threadSuspendedCallback;
        this.mThreadFinishedCallback = runnable;
        setupParam(suspensionParam);
        int size = hashSet.size();
        String[] strArr = new String[size];
        this.ignoredThreadNameArray = strArr;
        if (size > 0) {
            this.ignoredThreadNameArray = (String[]) hashSet.toArray(strArr);
        }
    }

    public void setSuspendedCallback(ThreadSuspendedCallback threadSuspendedCallback) {
        this.mSuspendedCallback = threadSuspendedCallback;
    }

    public void setThreadFinishedCallback(Runnable runnable) {
        this.mThreadFinishedCallback = runnable;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        this.mThreadHandler = new Handler(getLooper(), this);
        sNativeHasInited.getAndSet(true);
        if (!mJniInitSuccess) {
            Log.e(TAG, " jni init error, thread suspend task stoped");
            Message obtain = Message.obtain();
            obtain.what = 2;
            this.mThreadHandler.sendMessage(obtain);
            return;
        }
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        this.mThreadHandler.sendMessage(obtain2);
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Runnable runnable = this.mThreadFinishedCallback;
        if (runnable != null) {
            runnable.run();
        }
        this.mThreadFinishedCallback = null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.mThreadHandler.removeMessages(1);
                    this.mSuspendedCallback = null;
                    if (!this.mThreadHandler.hasMessages(0)) {
                        logI("MSG_QUIT do quit !!!");
                        doQuit();
                    }
                }
            } else if (!this.mCheckQuitFlag.get() && !this.mCheckQuitFlag.get()) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                this.mThreadHandler.sendMessageDelayed(obtain, this.mIntervalCheckDuration);
            }
        } else if (this.mCheckQuitFlag.get() && !this.mThreadHandler.hasMessages(0)) {
            logI("MSG_RESUME_THREAD do quit !!!");
            doQuit();
        }
        return true;
    }

    private void onThreadSuspended(int i, String str, long j) {
        delayResumeThread(j, this.mSuspendDuration);
        ThreadSuspendedCallback threadSuspendedCallback = this.mSuspendedCallback;
        if (threadSuspendedCallback != null) {
            threadSuspendedCallback.onThreadSuspended(i, str);
        }
    }

    private void delayResumeThread(long j, long j2) {
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = Long.valueOf(j);
        this.mThreadHandler.sendMessageDelayed(obtain, j2);
    }

    public void stopTask() {
        if (this.mCheckQuitFlag.get()) {
            return;
        }
        this.mCheckQuitFlag.set(true);
        this.mThreadHandler.removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 2;
        this.mThreadHandler.sendMessage(obtain);
    }

    private void logI(String str) {
        Log.i(TAG, str);
    }

    private void doQuit() {
        quitSafely();
    }
}
