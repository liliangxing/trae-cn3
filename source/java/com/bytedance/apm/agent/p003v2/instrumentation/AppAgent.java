package com.bytedance.apm.agent.p003v2.instrumentation;

import android.text.TextUtils;
import com.bytedance.apm.agent.tracing.AutoLaunchTraceHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AppAgent {
    private static final String ATTACH_BASE_CONTEXT = "attachBaseContext";
    private static final String CONSTRUCT = "<init>";
    private static final String ON_CREATE = "onCreate";
    private static long attachBaseContextEndTime;
    private static long attachBaseContextStartTime;
    private static long constructorEndTime;
    private static long constructorStartTime;
    private static long onCreateEndTime;
    private static long onCreateStartTime;

    public static void onTrace(String str, boolean z) {
        if (TextUtils.equals(str, CONSTRUCT)) {
            if (z) {
                constructorStartTime = System.currentTimeMillis();
                return;
            } else {
                constructorEndTime = System.currentTimeMillis();
                return;
            }
        }
        if (TextUtils.equals(str, ATTACH_BASE_CONTEXT)) {
            if (z) {
                attachBaseContextStartTime = System.currentTimeMillis();
                return;
            } else {
                attachBaseContextEndTime = System.currentTimeMillis();
                return;
            }
        }
        if (TextUtils.equals(str, "onCreate")) {
            if (z) {
                onCreateStartTime = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            onCreateEndTime = currentTimeMillis;
            AutoLaunchTraceHelper.assignAppTime(constructorStartTime, constructorEndTime, attachBaseContextStartTime, attachBaseContextEndTime, onCreateStartTime, currentTimeMillis);
        }
    }
}
