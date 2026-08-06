package com.bytedance.apm.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.IActivityLifeObserver;

/* loaded from: classes3.dex */
public class FpsUtil {
    private static final int DEFAULT_REFRESH_RATE = 60;
    private static final float ONE_SECOND_IN_MILLIS = 1000.0f;
    private static final int REFRESH_RATE_120 = 120;
    private static final int REFRESH_RATE_60 = 60;
    private static final int REFRESH_RATE_90 = 90;
    private static final float ROUNDING_THRESHOLD = 5.1f;
    private static int sCurrentRefreshRate;
    private static int sDeviceMaxRefreshRate;
    private static float sFrameIntervalMillis;
    private static int sRealMaxRate;
    private static int sRealRefreshRate;
    private static boolean sUsingMaxRefreshRate;

    static {
        init();
    }

    private static void init() {
        Context context = ApmContext.getContext();
        ActivityLifeObserver.getInstance().register(new IActivityLifeObserver() { // from class: com.bytedance.apm.util.FpsUtil.1
            @Override // com.bytedance.services.apm.api.IActivityLifeObserver
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // com.bytedance.services.apm.api.IActivityLifeObserver
            public void onActivityPause(Activity activity) {
            }

            @Override // com.bytedance.services.apm.api.IActivityLifeObserver
            public void onActivityResume(Activity activity) {
            }

            @Override // com.bytedance.services.apm.api.IActivityLifeObserver
            public void onActivityStarted(Activity activity) {
            }

            @Override // com.bytedance.services.apm.api.IActivityLifeObserver
            public void onBackground(Activity activity) {
            }

            @Override // com.bytedance.services.apm.api.IActivityLifeObserver
            public void onChange(Activity activity, Fragment fragment) {
            }

            @Override // com.bytedance.services.apm.api.IActivityLifeObserver
            public void onFront(Activity activity) {
                FpsUtil.refreshData(activity);
            }
        });
        float f = 0.0f;
        if (!ApmContext.supportMultiFrameRate() || context == null) {
            sDeviceMaxRefreshRate = 60;
            sCurrentRefreshRate = 60;
            sUsingMaxRefreshRate = true;
            sFrameIntervalMillis = ONE_SECOND_IN_MILLIS / 60;
            sRealMaxRate = 60;
            sRealRefreshRate = 60;
            if (context != null) {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                sRealRefreshRate = getRoundedRate(defaultDisplay.getRefreshRate());
                for (Display.Mode mode : defaultDisplay.getSupportedModes()) {
                    float refreshRate = mode.getRefreshRate();
                    if (refreshRate > f) {
                        f = refreshRate;
                    }
                }
                sRealMaxRate = getRoundedRate(f);
                return;
            }
            return;
        }
        Display defaultDisplay2 = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        float refreshRate2 = defaultDisplay2.getRefreshRate();
        for (Display.Mode mode2 : defaultDisplay2.getSupportedModes()) {
            float refreshRate3 = mode2.getRefreshRate();
            if (refreshRate3 > f) {
                f = refreshRate3;
            }
        }
        int roundedRate = getRoundedRate(refreshRate2);
        sCurrentRefreshRate = roundedRate;
        sRealRefreshRate = roundedRate;
        int roundedRate2 = getRoundedRate(f);
        sDeviceMaxRefreshRate = roundedRate2;
        int i = sCurrentRefreshRate;
        sUsingMaxRefreshRate = i == roundedRate2;
        sFrameIntervalMillis = ONE_SECOND_IN_MILLIS / i;
    }

    private static int getRoundedRate(float f) {
        if (Math.abs(f - 60.0f) < ROUNDING_THRESHOLD) {
            return 60;
        }
        if (Math.abs(f - 90.0f) < ROUNDING_THRESHOLD) {
            return 90;
        }
        if (Math.abs(f - 120.0f) < ROUNDING_THRESHOLD) {
            return 120;
        }
        return (int) f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void refreshData(Activity activity) {
        float refreshRate = activity.getWindowManager().getDefaultDisplay().getRefreshRate();
        sRealRefreshRate = getRoundedRate(refreshRate);
        if (ApmContext.supportMultiFrameRate()) {
            int roundedRate = getRoundedRate(refreshRate);
            sCurrentRefreshRate = roundedRate;
            sUsingMaxRefreshRate = roundedRate == sDeviceMaxRefreshRate;
            sFrameIntervalMillis = ONE_SECOND_IN_MILLIS / roundedRate;
        }
    }

    public static float getFrameIntervalMillis() {
        return sFrameIntervalMillis;
    }

    public static int getRefreshRate() {
        return sCurrentRefreshRate;
    }

    public static int getDeviceMaxRefreshRate() {
        return sDeviceMaxRefreshRate;
    }

    public static boolean isUsingMaxRefreshRate() {
        return sUsingMaxRefreshRate;
    }

    public static int getRealRefreshRate() {
        return sRealRefreshRate;
    }

    public static int getRealMaxRate() {
        return sRealMaxRate;
    }
}
