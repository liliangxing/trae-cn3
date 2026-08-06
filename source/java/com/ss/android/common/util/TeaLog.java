package com.ss.android.common.util;

import android.util.Log;

/* loaded from: classes7.dex */
public class TeaLog {

    /* loaded from: classes7.dex */
    public static class Task {
        private static final String TASK_TAG = "TeaLog_Task";
        public static boolean isSwitchOn;

        public static void w(String str) {
            if (isSwitchOn) {
                Log.w(TASK_TAG, str);
            }
        }

        public static void i(String str) {
            if (isSwitchOn) {
                Log.i(TASK_TAG, str);
            }
        }

        public static void d(String str) {
            if (isSwitchOn) {
                Log.d(TASK_TAG, str);
            }
        }
    }
}
