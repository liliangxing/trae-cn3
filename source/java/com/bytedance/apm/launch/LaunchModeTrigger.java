package com.bytedance.apm.launch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.trace.LaunchTrace;
import com.bytedance.services.apm.api.IActivityLifeObserver;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LaunchModeTrigger {
    private static Intent firstActivityIntent = null;
    private static String firstLaunchActivityName = "";
    private static boolean isBackground = false;
    private static boolean isRestore = false;
    private static boolean isWalkOnCreate = false;
    private static String lastPauseActivityName = "";
    private static DefaultLaunchMode launchMode;
    private static long onCreateBeginTime;
    private static long onStartBeginTime;

    public static void init() {
        firstActivityIntent = LaunchSceneHelper.getFirstActivityIntent();
        ActivityLifeObserver.getInstance().register(new IActivityLifeObserver() { // from class: com.bytedance.apm.launch.LaunchModeTrigger.1
            public void onActivityResume(Activity activity) {
            }

            public void onChange(Activity activity, Fragment fragment) {
            }

            public void onFront(Activity activity) {
                String unused = LaunchModeTrigger.firstLaunchActivityName = activity.getComponentName().getClassName();
            }

            public void onBackground(Activity activity) {
                boolean unused = LaunchModeTrigger.isBackground = true;
                boolean unused2 = LaunchModeTrigger.isWalkOnCreate = false;
                String unused3 = LaunchModeTrigger.firstLaunchActivityName = "";
            }

            public void onActivityCreated(Activity activity, Bundle bundle) {
                long unused = LaunchModeTrigger.onCreateBeginTime = System.currentTimeMillis();
                boolean unused2 = LaunchModeTrigger.isRestore = bundle != null;
                boolean unused3 = LaunchModeTrigger.isWalkOnCreate = true;
            }

            public void onActivityPause(Activity activity) {
                String unused = LaunchModeTrigger.lastPauseActivityName = activity.getComponentName().getClassName();
            }

            public void onActivityStarted(Activity activity) {
                long unused = LaunchModeTrigger.onStartBeginTime = System.currentTimeMillis();
            }
        });
    }

    public static Pair<DefaultLaunchMode, Long> getLaunchMode(String str) {
        if (launchMode == null) {
            if (firstActivityIntent != null) {
                launchMode = DefaultLaunchMode.CLOD_LAUNCH;
                return new Pair<>(launchMode, Long.valueOf(LaunchTrace.getTraceStartTime()));
            }
            if (!str.equals(lastPauseActivityName)) {
                launchMode = DefaultLaunchMode.UNKNOWN_LAUNCH;
                return new Pair<>(launchMode, 0L);
            }
            if (!str.equals(firstLaunchActivityName)) {
                launchMode = DefaultLaunchMode.UNKNOWN_LAUNCH;
                return new Pair<>(launchMode, 0L);
            }
            launchMode = DefaultLaunchMode.WARM_LAUNCH;
            return new Pair<>(launchMode, Long.valueOf(onCreateBeginTime));
        }
        if (isBackground) {
            isBackground = false;
            if (!str.equals(lastPauseActivityName)) {
                launchMode = DefaultLaunchMode.UNKNOWN_LAUNCH;
                return new Pair<>(launchMode, 0L);
            }
            if (!str.equals(firstLaunchActivityName)) {
                launchMode = DefaultLaunchMode.UNKNOWN_LAUNCH;
                return new Pair<>(launchMode, 0L);
            }
            boolean z = isWalkOnCreate;
            if (z && !isRestore) {
                launchMode = DefaultLaunchMode.WARM_LAUNCH;
                return new Pair<>(launchMode, Long.valueOf(onCreateBeginTime));
            }
            if (!z) {
                launchMode = DefaultLaunchMode.HOT_LAUNCH;
                return new Pair<>(launchMode, Long.valueOf(onStartBeginTime));
            }
        }
        launchMode = DefaultLaunchMode.UNKNOWN_LAUNCH;
        return new Pair<>(launchMode, 0L);
    }
}
