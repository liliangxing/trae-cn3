package com.bytedance.android.tools.superkv;

import android.os.Process;
import android.util.Log;
import com.bytedance.android.tools.superkv.SuperKV;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class Debug {
    private static final String TEST_TAG = "KV_INSTRUMENTED_TEST";
    private static final String LOG_TAG = "TEST_KV@pid:" + Process.myPid();
    static boolean DEBUG = false;
    static SuperKV.Configurator.KVLogger logger = new SuperKV.Configurator.KVLogger() { // from class: com.bytedance.android.tools.superkv.Debug.1
        @Override // com.bytedance.android.tools.superkv.SuperKV.Configurator.KVLogger
        public void onLog(int i, String str) {
            if (i == 1) {
                if (Debug.DEBUG) {
                    Log.i(Debug.LOG_TAG, str);
                }
            } else if (i == 2) {
                Log.w(Debug.LOG_TAG, str);
            } else if (i != 3) {
                Log.d(Debug.LOG_TAG, str);
            } else {
                Log.e(Debug.LOG_TAG, str);
            }
        }

        @Override // com.bytedance.android.tools.superkv.SuperKV.Configurator.KVLogger
        public void onLog(int i, String str, Throwable th) {
            if (i == 1) {
                if (Debug.DEBUG) {
                    Log.i(Debug.LOG_TAG, str, th);
                }
            } else if (i == 2) {
                Log.w(Debug.LOG_TAG, str, th);
            } else if (i != 3) {
                Log.d(Debug.LOG_TAG, str, th);
            } else {
                Log.e(Debug.LOG_TAG, str, th);
            }
        }
    };

    Debug() {
    }

    static void i(String str) {
        logger.onLog(1, getMessage(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(String str) {
        logger.onLog(2, getMessage(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(String str) {
        logger.onLog(3, getMessage(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(String str, Throwable th) {
        logger.onLog(3, getMessage(str), th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tryThrow(String str, Throwable th) {
        if (DEBUG) {
            throw new KVException(str, th);
        }
        e(str, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tryThrow(Throwable th) {
        if (DEBUG) {
            throw new KVException(th);
        }
        e(th.getMessage() == null ? "No message." : th.getMessage(), th);
    }

    static void t(String str) {
        Log.i(TEST_TAG, str);
    }

    private static String getMessage(String str) {
        return "@Thread: {" + Process.myPid() + "," + Thread.currentThread().getName() + "}, msg: " + str;
    }
}
