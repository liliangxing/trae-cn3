package com.bytedance.bdinstall.oaid;

/* loaded from: classes3.dex */
public class OaidMonitor {
    private static long mInitTs;
    private static long mOnFinishFetchOaid;
    private static long mReadStartInitTs;
    private static long mRegisterWaitFinish;
    private static long mRegisterWaitOaid;
    private static long mStartSystemCall;
    private static long mSystemCallFinished;

    public static void onInit() {
        if (mInitTs > 0) {
            return;
        }
        mInitTs = System.currentTimeMillis();
    }

    public static void onRealStartInit() {
        if (mReadStartInitTs > 0) {
            return;
        }
        mReadStartInitTs = System.currentTimeMillis();
    }

    public static void onStartSystemCall() {
        if (mStartSystemCall > 0) {
            return;
        }
        mStartSystemCall = System.currentTimeMillis();
    }

    public static void onSystemCallFinished() {
        if (mSystemCallFinished > 0) {
            return;
        }
        mSystemCallFinished = System.currentTimeMillis();
    }

    public static void onOaidFinished() {
        if (mOnFinishFetchOaid > 0) {
            return;
        }
        mOnFinishFetchOaid = System.currentTimeMillis();
    }

    public static void registerWaitOaid() {
        if (mRegisterWaitOaid > 0) {
            return;
        }
        mRegisterWaitOaid = System.currentTimeMillis();
    }

    public static void registerWaitFinish() {
        if (mRegisterWaitFinish > 0) {
            return;
        }
        mRegisterWaitFinish = System.currentTimeMillis();
    }

    public static long getInitTs() {
        return mInitTs;
    }

    public static long getReadStartInitTs() {
        return mReadStartInitTs;
    }

    public static long getStartSystemCall() {
        return mStartSystemCall;
    }

    public static long getSystemCallFinished() {
        return mSystemCallFinished;
    }

    public static long getOnFinishFetchOaid() {
        return mOnFinishFetchOaid;
    }

    public static long getRegisterWaitOaid() {
        return mRegisterWaitOaid;
    }

    public static long getRegisterWaitFinish() {
        return mRegisterWaitFinish;
    }
}
