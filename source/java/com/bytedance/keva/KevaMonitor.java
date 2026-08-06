package com.bytedance.keva;

import android.util.Log;

/* loaded from: classes4.dex */
public class KevaMonitor {
    /* JADX INFO: Access modifiers changed from: protected */
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadRepo(String str, int i) {
        Log.println(4, KevaConstants.TAG, "load repo: " + str + ", with mode: " + i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportThrowable(int i, String str, String str2, Object obj, Throwable th) {
        Log.e(KevaConstants.TAG, "action: [" + i + "], repo: [" + str + "], key: [" + str2 + "], value: [" + obj + "], msg: " + th.getMessage(), th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportWarning(int i, String str, String str2, Object obj, String str3) {
        Log.println(5, KevaConstants.TAG, "action: [" + i + "], repo: [" + str + "], key: [" + str2 + "], value: [" + obj + "], msg: " + str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void logDebug(String str) {
        Log.println(4, KevaConstants.TAG, str);
    }
}
