package com.bytedance.retrofit2;

/* loaded from: classes4.dex */
public class AppActivityResumeSuspendRecorder {
    private static volatile long sAppActivityResumeState;
    private static volatile boolean sAppActivityResumed;

    public static void OnAppActiviyResume() {
        if (sAppActivityResumed) {
            return;
        }
        sAppActivityResumed = true;
        sAppActivityResumeState++;
    }

    public static void OnAppActivitySuspend() {
        if (sAppActivityResumed) {
            sAppActivityResumed = false;
            sAppActivityResumeState++;
        }
    }

    public static long GetAppActivityResumeState() {
        return sAppActivityResumeState;
    }
}
