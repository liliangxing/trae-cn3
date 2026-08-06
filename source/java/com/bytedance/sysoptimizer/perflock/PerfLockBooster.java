package com.bytedance.sysoptimizer.perflock;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.sysoptimizer.SysOptimizer;
import com.bytedance.sysoptimizer.perflock.FrameworkPerfLock;

/* loaded from: classes5.dex */
public class PerfLockBooster {
    private static final String TAG = "PerfLockBooster";
    private static Handler sExecuteHandler = null;
    static boolean sFixQualUnTrustedAppAccessIssue = false;
    private static float sGlobalBoostControlLevel = 1.0f;
    private static int sGlobalExtendBoostEnableLevel;
    private static FrameworkPerfLock.PerfLockImpl sPerfLockImpl;

    private static native int boos_mtk_with_params_by_perfservice(int[] iArr, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int boost_dev_with_params(int[] iArr, int i);

    private static native int boost_mtk_dev_with_params(int[] iArr, int i);

    private static native boolean do_cpu_schedule_opt(int i, int i2, int i3);

    private static native boolean do_task_schedule_optimize(String[] strArr, int i, int i2);

    private static native boolean is_mtk_perfd_valid();

    private static native boolean is_mtk_perfservice_valid();

    private static native boolean is_qti_perfd_valid();

    private static native void release_perflock_handle(int i);

    public static boolean isQtiPerdValid(Context context) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return false;
        }
        ByteHook.init();
        try {
            return is_qti_perfd_valid();
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return false;
        }
    }

    public static void setPerlockExecuteHandler(Handler handler) {
        sExecuteHandler = handler;
    }

    public static void setsGlobalBoostControlLevel(float f) {
        sGlobalBoostControlLevel = f;
    }

    public static void setGlobalExtendBoostLevel(int i) {
        sGlobalExtendBoostEnableLevel = i;
    }

    public static boolean isExtendBoostEnable() {
        return sGlobalExtendBoostEnableLevel > 0;
    }

    public static void setsFixQualUnTrustedAppAccessIssue(boolean z) {
        sFixQualUnTrustedAppAccessIssue = z;
    }

    /* loaded from: classes5.dex */
    private static class DevBoostRunable implements Runnable {
        Context mContext;
        private String mParaString;
        private int[] mParas;
        int mRadix;
        private int mTimeout;

        private DevBoostRunable() {
            this.mContext = null;
            this.mParas = null;
            this.mTimeout = -1;
            this.mParaString = null;
            this.mRadix = -1;
        }

        public DevBoostRunable(Context context, int[] iArr, int i) {
            this.mParaString = null;
            this.mRadix = -1;
            this.mContext = context;
            this.mParas = iArr;
            this.mTimeout = i;
        }

        public DevBoostRunable(Context context, String str, int i, int i2) {
            this.mParas = null;
            this.mContext = context;
            this.mParaString = str;
            this.mRadix = i;
            this.mTimeout = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            if (this.mContext == null) {
                return;
            }
            String str = this.mParaString;
            if (str != null && (i2 = this.mRadix) != -1) {
                this.mParas = PerfLockBooster.parseStringToIntArrayByRadix(str, i2);
            }
            int[] iArr = this.mParas;
            if (iArr == null || iArr.length <= 0 || (i = this.mTimeout) == -1) {
                return;
            }
            int i3 = (int) (i * PerfLockBooster.sGlobalBoostControlLevel);
            if (SysOptimizer.loadOptimizerLibrary(this.mContext)) {
                ByteHook.init();
                try {
                    PerfLockBooster.boost_dev_with_params(this.mParas, i3);
                } catch (NoSuchMethodError e) {
                    Log.e(PerfLockBooster.TAG, "NoSuchMethodError", e);
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(PerfLockBooster.TAG, "UnsatisfiedLinkError", e2);
                }
            }
        }
    }

    public static int boostDevWithParams(Context context, int[] iArr, int i) {
        float f = sGlobalBoostControlLevel;
        if (f == 0.0f) {
            return -1;
        }
        Handler handler = sExecuteHandler;
        if (handler != null) {
            handler.postAtFrontOfQueue(new DevBoostRunable(context, iArr, i));
            return 0;
        }
        int i2 = (int) (i * f);
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ByteHook.init();
            try {
                return boost_dev_with_params(iArr, i2);
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return 0;
    }

    public static int boostDevWithParamsString(Context context, String str, int i, int i2) {
        float f = sGlobalBoostControlLevel;
        if (f == 0.0f) {
            return -1;
        }
        Handler handler = sExecuteHandler;
        if (handler != null) {
            handler.postAtFrontOfQueue(new DevBoostRunable(context, str, i, i2));
            return 0;
        }
        int i3 = (int) (i2 * f);
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ByteHook.init();
            try {
                int[] parseStringToIntArrayByRadix = parseStringToIntArrayByRadix(str, i);
                if (parseStringToIntArrayByRadix != null && parseStringToIntArrayByRadix.length > 0) {
                    return boost_dev_with_params(parseStringToIntArrayByRadix, i3);
                }
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return 0;
    }

    public static void releasePerflockHandle(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ByteHook.init();
            try {
                release_perflock_handle(i);
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
    }

    public static boolean isMTKPerdValid(Context context) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return false;
        }
        ByteHook.init();
        try {
            return is_mtk_perfd_valid();
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return false;
        }
    }

    public static int boostMTKDEVWithParams(Context context, int[] iArr, int i) {
        float f = sGlobalBoostControlLevel;
        if (f == 0.0f) {
            return -1;
        }
        int i2 = (int) (i * f);
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return 0;
        }
        ByteHook.init();
        try {
            return boost_mtk_dev_with_params(iArr, i2);
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return 0;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return 0;
        }
    }

    public static boolean isMTKPerfServiceValid(Context context) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return false;
        }
        ByteHook.init();
        try {
            return is_mtk_perfservice_valid();
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return false;
        }
    }

    public static int boostMTKByPerfservice(Context context, int[] iArr, int i) {
        float f = sGlobalBoostControlLevel;
        if (f == 0.0f) {
            return -1;
        }
        int i2 = (int) (i * f);
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return 0;
        }
        ByteHook.init();
        try {
            return boos_mtk_with_params_by_perfservice(iArr, i2);
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return 0;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int[] parseStringToIntArrayByRadix(String str, int i) {
        String[] split = str.split(",");
        int[] iArr = new int[split.length];
        for (int i2 = 0; i2 < split.length; i2++) {
            try {
                iArr[i2] = Integer.parseInt(split[i2], i);
            } catch (Exception e) {
                Log.d(TAG, "parsing int meets an exception:" + e);
                return null;
            }
        }
        return iArr;
    }

    public static boolean doTaskScheduleOptimize(Context context, String str, int i, int i2) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return true;
        }
        String[] split = str.split(",");
        ByteHook.init();
        if (split == null) {
            return true;
        }
        try {
            return do_task_schedule_optimize(split, i, i2);
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return false;
        }
    }

    public static boolean doTaskScheduleOptimize(Context context, String[] strArr, int i, int i2) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return true;
        }
        ByteHook.init();
        if (strArr == null) {
            return true;
        }
        try {
            return do_task_schedule_optimize(strArr, i, i2);
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return false;
        }
    }

    public static boolean doCPUScheduleOptimize(Context context, int i, int i2, int i3) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return true;
        }
        ByteHook.init();
        try {
            return do_cpu_schedule_opt(i, i2, i3);
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return false;
        }
    }

    /* loaded from: classes5.dex */
    private static class FrameworkBoostRunable implements Runnable {
        Context mContext;
        private String mParaString;
        private int mTimeout;
        private int mType;

        private FrameworkBoostRunable() {
            this.mContext = null;
            this.mType = -1;
            this.mTimeout = -1;
            this.mParaString = null;
        }

        public FrameworkBoostRunable(Context context, int i, String str, int i2) {
            this.mContext = context;
            this.mType = i;
            this.mParaString = str;
            this.mTimeout = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mContext == null) {
                return;
            }
            int i = (int) (this.mTimeout * PerfLockBooster.sGlobalBoostControlLevel);
            String str = this.mParaString;
            int[] parseStringToIntArrayByRadix = str != null ? PerfLockBooster.parseStringToIntArrayByRadix(str, 16) : null;
            if (PerfLockBooster.sPerfLockImpl != null) {
                PerfLockBooster.sPerfLockImpl.invokePerfBoost(parseStringToIntArrayByRadix, i);
                return;
            }
            FrameworkPerfLock.PerfLockImpl unused = PerfLockBooster.sPerfLockImpl = FrameworkPerfLock.getPerfLockImplByType(this.mType);
            if (PerfLockBooster.sPerfLockImpl == null || !PerfLockBooster.sPerfLockImpl.preparePerfParas(this.mContext)) {
                return;
            }
            PerfLockBooster.sPerfLockImpl.setExtendBoostEnable(PerfLockBooster.sGlobalExtendBoostEnableLevel);
            PerfLockBooster.sPerfLockImpl.invokePerfBoost(parseStringToIntArrayByRadix, i);
        }
    }

    public static boolean awareEvent(Context context, int i, int i2) {
        if (sGlobalBoostControlLevel == 0.0f) {
            return false;
        }
        int[] iArr = {i};
        FrameworkPerfLock.PerfLockImpl perfLockImpl = sPerfLockImpl;
        if (perfLockImpl != null) {
            return perfLockImpl.invokePerfBoost(iArr, i2);
        }
        FrameworkPerfLock.PerfLockImpl perfLockImplByType = FrameworkPerfLock.getPerfLockImplByType(4);
        sPerfLockImpl = perfLockImplByType;
        if (perfLockImplByType == null || !perfLockImplByType.preparePerfParas(context)) {
            return false;
        }
        return sPerfLockImpl.invokePerfBoost(iArr, i2);
    }

    public static boolean boostByFrameworkPerfLock(Context context, int i, String str, int i2) {
        float f = sGlobalBoostControlLevel;
        if (f == 0.0f) {
            return false;
        }
        Handler handler = sExecuteHandler;
        if (handler != null) {
            handler.postAtFrontOfQueue(new FrameworkBoostRunable(context, i, str, i2));
            return true;
        }
        int i3 = (int) (i2 * f);
        int[] parseStringToIntArrayByRadix = str != null ? parseStringToIntArrayByRadix(str, 16) : null;
        FrameworkPerfLock.PerfLockImpl perfLockImpl = sPerfLockImpl;
        if (perfLockImpl != null) {
            return perfLockImpl.invokePerfBoost(parseStringToIntArrayByRadix, i3);
        }
        FrameworkPerfLock.PerfLockImpl perfLockImplByType = FrameworkPerfLock.getPerfLockImplByType(i);
        sPerfLockImpl = perfLockImplByType;
        if (perfLockImplByType == null || !perfLockImplByType.preparePerfParas(context)) {
            return false;
        }
        sPerfLockImpl.setExtendBoostEnable(sGlobalExtendBoostEnableLevel);
        return sPerfLockImpl.invokePerfBoost(parseStringToIntArrayByRadix, i3);
    }
}
