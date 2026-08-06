package com.bytedance.platform.thread;

import android.os.Looper;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class RenameHelper {
    private static ThreadLocal<String> sThreadLocal = new ThreadLocal<>();

    public static void nameThread(String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            if (sThreadLocal.get() == null) {
                sThreadLocal.set(Thread.currentThread().getName());
            }
            String str2 = sThreadLocal.get();
            if (str2 != null) {
                if (str2.startsWith("pool-") || str2.startsWith("Thread-")) {
                    String substring = str.substring(str.lastIndexOf("/") + 1);
                    if (!TextUtils.isEmpty(substring)) {
                        if (substring.length() <= 2) {
                            substring = str.replace("com/", "").replace("cn/", "");
                        }
                        Thread.currentThread().setName(str2 + "#" + substring);
                        return;
                    }
                    Thread.currentThread().setName(str2);
                }
            }
        }
    }

    public static String getNameByClass(String str) {
        String substring = str.substring(str.lastIndexOf("/") + 1);
        return (TextUtils.isEmpty(substring) || substring.length() > 2) ? substring : str.replace("com/", "").replace("cn/", "");
    }
}
