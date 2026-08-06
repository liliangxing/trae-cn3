package com.bytedance.sysoptimizer.perflock;

import android.content.Context;
import android.util.Log;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class FrameworkPerfLock {
    private static final String TAG = "FrameworkPerfLock";
    private static final int[] sQualcommPerfLockParas = {1077936128, 1, 1086324736, 1, 1082146816, UnixStat.PERM_MASK, 1082147072, UnixStat.PERM_MASK, 1082147328, UnixStat.PERM_MASK, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1082130944, UnixStat.PERM_MASK, 1099005952, 255, 1098907648, 255, 1086455808, 20, 1086439424, 30};
    private static final int[] sQualcommPerfLockExtendGPU = {1077936128, 1, 1086324736, 1, 1082146816, UnixStat.PERM_MASK, 1082147072, UnixStat.PERM_MASK, 1082147328, UnixStat.PERM_MASK, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1082130944, UnixStat.PERM_MASK, 1099005952, 255, 1098907648, 255, 1086455808, 20, 1086439424, 30, 1124073472, 255, 1119944704, 1, 1128267776, 65535, 1115734016, UnixStat.PERM_MASK, 1115750400, UnixStat.PERM_MASK};
    private static final int[] sMTKPowerHalParas = {8388608, 4, 8388864, 4, 21037056, 1, 4194304, 16777215, 4194560, 16777215, 4194816, 16777215};
    private static final int[] sMTKPowerHalExtendParas = {8388608, 4, 8388864, 4, 21037056, 1, 4194304, 16777215, 4194560, 16777215, 4194816, 16777215, 12582912, 16777215, 12599296, 16777215};

    private FrameworkPerfLock() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0001. Please report as an issue. */
    public static PerfLockImpl getPerfLockImplByType(int i) {
        PerfLockImpl qualCommPerfLock;
        switch (i) {
            case 1:
                qualCommPerfLock = new QualCommPerfLock();
                return qualCommPerfLock;
            case 2:
                qualCommPerfLock = new QualcommOriginPerfLock();
                return qualCommPerfLock;
            case 3:
                qualCommPerfLock = new MTCommonPerfLock();
                return qualCommPerfLock;
            case 4:
                qualCommPerfLock = new HuaweiAwarePerfLock();
                return qualCommPerfLock;
            case 5:
                qualCommPerfLock = new HuaweiUniperfPerfLock();
                return qualCommPerfLock;
            case 6:
                qualCommPerfLock = new OppoPerfLock();
                return qualCommPerfLock;
            case 7:
                qualCommPerfLock = new VivoPerfLock();
                return qualCommPerfLock;
            case 8:
                qualCommPerfLock = new MTPowerHALPerfLock();
                return qualCommPerfLock;
            default:
                return null;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class PerfLockImpl {
        int mExtendBoostEnableLevel = 0;
        Method mPerfBoostMethod;
        Class<?> mPerfClazz;
        Object mPerfClazzObj;

        boolean invokePerfBoostImpl(int[] iArr, int i) throws Exception {
            return false;
        }

        boolean preparePerfParasImpl(Context context) throws Exception {
            return false;
        }

        public final boolean preparePerfParas(Context context) {
            try {
                return preparePerfParasImpl(context);
            } catch (Exception e) {
                Log.e(FrameworkPerfLock.TAG, "prepare catch a exception:" + e);
                return false;
            }
        }

        public final boolean invokePerfBoost(int[] iArr, int i) {
            try {
                return invokePerfBoostImpl(iArr, i);
            } catch (Exception e) {
                Log.e(FrameworkPerfLock.TAG, "invoke catch a exception:" + e);
                return false;
            }
        }

        public final void setExtendBoostEnable(int i) {
            this.mExtendBoostEnableLevel = i;
        }
    }

    /* loaded from: classes5.dex */
    private static class QualCommPerfLock extends PerfLockImpl {
        private AtomicBoolean mHasFixed;
        private Class<?> mQPerformanceClazz;
        private Field mRestrictUnTrustedAppAccessField;

        private QualCommPerfLock() {
            this.mHasFixed = new AtomicBoolean(false);
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean preparePerfParasImpl(Context context) throws Exception {
            this.mPerfClazz = Class.forName("android.util.BoostFramework");
            try {
                this.mPerfClazzObj = DoubleReflectUtils.getConstructor(this.mPerfClazz, Context.class).newInstance(context);
            } catch (Throwable unused) {
                this.mPerfClazzObj = DoubleReflectUtils.getConstructor(this.mPerfClazz, new Class[0]).newInstance(new Object[0]);
            }
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(this.mPerfClazz, "perfLockAcquire", Integer.TYPE, int[].class);
            return true;
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean invokePerfBoostImpl(int[] iArr, int i) throws Exception {
            fixQualcommUnTrustedAppAccessIssue();
            if (this.mPerfBoostMethod == null) {
                return false;
            }
            if ((this.mExtendBoostEnableLevel & 1) != 0) {
                Log.d(FrameworkPerfLock.TAG, "use extend new paras");
                if (iArr == null) {
                    iArr = FrameworkPerfLock.sQualcommPerfLockExtendGPU;
                }
            } else if (iArr == null) {
                iArr = FrameworkPerfLock.sQualcommPerfLockParas;
            }
            Object invoke = this.mPerfBoostMethod.invoke(this.mPerfClazzObj, Integer.valueOf(i), iArr);
            if (invoke == null) {
                return false;
            }
            Log.e(FrameworkPerfLock.TAG, "return handle = " + invoke);
            return ((Integer) invoke).intValue() > 0;
        }

        private void fixQualcommUnTrustedAppAccessIssue() {
            if (PerfLockBooster.sFixQualUnTrustedAppAccessIssue && this.mHasFixed.compareAndSet(false, true)) {
                try {
                    Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass("com.qualcomm.qti.Performance");
                    this.mQPerformanceClazz = loadClass;
                    Field fieldInner = DoubleReflectUtils.getFieldInner(loadClass, "RestrictUnTrustedAppAccess");
                    this.mRestrictUnTrustedAppAccessField = fieldInner;
                    if (fieldInner != null) {
                        Log.d(FrameworkPerfLock.TAG, "mRestrictUnTrustedAppAccessField setBoolean before = " + this.mRestrictUnTrustedAppAccessField.get(null));
                        this.mRestrictUnTrustedAppAccessField.setBoolean(null, false);
                        Log.d(FrameworkPerfLock.TAG, "mRestrictUnTrustedAppAccessField setBoolean after = " + this.mRestrictUnTrustedAppAccessField.get(null));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    private static class HuaweiAwarePerfLock extends PerfLockImpl {
        private HuaweiAwarePerfLock() {
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean preparePerfParasImpl(Context context) throws Exception {
            this.mPerfClazz = Class.forName("android.rms.iaware.IAwareSdk");
            if (this.mPerfClazz == null) {
                return false;
            }
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(this.mPerfClazz, "asyncSendData", String.class, Integer.TYPE);
            return true;
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean invokePerfBoostImpl(int[] iArr, int i) throws Exception {
            int i2 = (iArr == null || iArr.length <= 0) ? 4099 : iArr[0];
            if (this.mPerfBoostMethod == null) {
                return false;
            }
            this.mPerfBoostMethod.invoke(null, "UniperfClient", Integer.valueOf(i2));
            Log.d(FrameworkPerfLock.TAG, "invoked perflock para code " + i2);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    private static class HuaweiUniperfPerfLock extends PerfLockImpl {
        private HuaweiUniperfPerfLock() {
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean preparePerfParasImpl(Context context) throws Exception {
            this.mPerfClazz = Class.forName("android.iawareperf.UniPerf");
            Method methodInner = DoubleReflectUtils.getMethodInner(this.mPerfClazz, "getInstance", new Class[0]);
            if (methodInner != null) {
                this.mPerfClazzObj = methodInner.invoke(null, new Object[0]);
            }
            if (this.mPerfClazzObj == null) {
                return false;
            }
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(this.mPerfClazz, "uniPerfEvent", Integer.TYPE, String.class, int[].class);
            return true;
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean invokePerfBoostImpl(int[] iArr, int i) throws Exception {
            int i2 = (iArr == null || iArr.length <= 0) ? 4099 : iArr[0];
            if (this.mPerfBoostMethod == null) {
                return false;
            }
            this.mPerfBoostMethod.invoke(this.mPerfClazzObj, Integer.valueOf(i2), "", new int[]{i});
            return true;
        }
    }

    /* loaded from: classes5.dex */
    private static class QualcommOriginPerfLock extends PerfLockImpl {
        private AtomicBoolean mHasFixed;
        private Field mRestrictUnTrustedAppAccessField;

        private QualcommOriginPerfLock() {
            this.mHasFixed = new AtomicBoolean(false);
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean preparePerfParasImpl(Context context) throws Exception {
            this.mPerfClazz = ClassLoader.getSystemClassLoader().loadClass("com.qualcomm.qti.Performance");
            this.mPerfClazzObj = DoubleReflectUtils.getConstructor(this.mPerfClazz, Context.class).newInstance(context);
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(this.mPerfClazz, "perfLockAcquire", Integer.TYPE, int[].class);
            return true;
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean invokePerfBoostImpl(int[] iArr, int i) throws Exception {
            fixQualcommUnTrustedAppAccessIssue();
            if (this.mPerfBoostMethod == null) {
                return false;
            }
            if (iArr == null) {
                iArr = FrameworkPerfLock.sQualcommPerfLockParas;
            }
            Object invoke = this.mPerfBoostMethod.invoke(this.mPerfClazzObj, Integer.valueOf(i), iArr);
            if (invoke == null) {
                return false;
            }
            Log.e(FrameworkPerfLock.TAG, "return handle = " + invoke);
            return ((Integer) invoke).intValue() > 0;
        }

        private void fixQualcommUnTrustedAppAccessIssue() {
            if (PerfLockBooster.sFixQualUnTrustedAppAccessIssue && this.mHasFixed.compareAndSet(false, true)) {
                try {
                    Field fieldInner = DoubleReflectUtils.getFieldInner(this.mPerfClazz, "RestrictUnTrustedAppAccess");
                    this.mRestrictUnTrustedAppAccessField = fieldInner;
                    if (fieldInner != null) {
                        Log.d(FrameworkPerfLock.TAG, "mRestrictUnTrustedAppAccessField setBoolean before = " + this.mRestrictUnTrustedAppAccessField.get(null));
                        this.mRestrictUnTrustedAppAccessField.setBoolean(null, false);
                        Log.d(FrameworkPerfLock.TAG, "mRestrictUnTrustedAppAccessField setBoolean after = " + this.mRestrictUnTrustedAppAccessField.get(null));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    private static class MTCommonPerfLock extends PerfLockImpl {
        private MTCommonPerfLock() {
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean preparePerfParasImpl(Context context) throws Exception {
            this.mPerfClazz = ClassLoader.getSystemClassLoader().loadClass("com.mediatek.boostframework.Performance");
            this.mPerfClazzObj = this.mPerfClazz.newInstance();
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(this.mPerfClazz, "perfLockAcquire", Integer.TYPE, int[].class);
            return true;
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean invokePerfBoostImpl(int[] iArr, int i) throws Exception {
            if (iArr == null) {
                iArr = new int[]{8388608, 4, 8388864, 4, 4194304, 16777215, 4194560, 16777215};
            }
            if (this.mPerfBoostMethod == null) {
                return false;
            }
            this.mPerfBoostMethod.invoke(this.mPerfClazzObj, Integer.valueOf(i), iArr);
            Log.d(FrameworkPerfLock.TAG, "MT Common perflock is invoked");
            return true;
        }
    }

    /* loaded from: classes5.dex */
    private static class MTPowerHALPerfLock extends PerfLockImpl {
        private MTPowerHALPerfLock() {
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean preparePerfParasImpl(Context context) throws Exception {
            this.mPerfClazz = ClassLoader.getSystemClassLoader().loadClass("com.mediatek.powerhalmgr.PowerHalMgrImpl");
            this.mPerfClazzObj = this.mPerfClazz.newInstance();
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(this.mPerfClazz, "perfLockAcquire", Integer.TYPE, Integer.TYPE, int[].class);
            return true;
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean invokePerfBoostImpl(int[] iArr, int i) throws Exception {
            if ((this.mExtendBoostEnableLevel & 1) != 0) {
                Log.d(FrameworkPerfLock.TAG, "use extend new paras");
                if (iArr == null) {
                    iArr = FrameworkPerfLock.sMTKPowerHalExtendParas;
                }
            } else if (iArr == null) {
                iArr = FrameworkPerfLock.sMTKPowerHalParas;
            }
            if (this.mPerfBoostMethod == null) {
                return false;
            }
            this.mPerfBoostMethod.invoke(this.mPerfClazzObj, 0, Integer.valueOf(i), iArr);
            Log.d(FrameworkPerfLock.TAG, "MT power hal perflock is invoked");
            return true;
        }
    }

    /* loaded from: classes5.dex */
    private static class VivoPerfLock extends PerfLockImpl {
        private VivoPerfLock() {
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean preparePerfParasImpl(Context context) throws Exception {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            Class<?> loadClass = systemClassLoader.loadClass("vivo.app.VivoFrameworkFactory");
            this.mPerfClazz = systemClassLoader.loadClass("vivo.app.vperf.AbsVivoPerfManager");
            Method methodInner = DoubleReflectUtils.getMethodInner(loadClass, "getFrameworkFactoryImpl", new Class[0]);
            Object invoke = methodInner != null ? methodInner.invoke(null, new Object[0]) : null;
            Method methodInner2 = DoubleReflectUtils.getMethodInner(loadClass, "getVivoPerfManager", Context.class);
            if (methodInner2 != null && invoke != null) {
                this.mPerfClazzObj = methodInner2.invoke(invoke, context);
            }
            if (this.mPerfClazz == null || this.mPerfClazzObj == null) {
                return false;
            }
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(this.mPerfClazz, "perfLockAcquire", Integer.TYPE, int[].class);
            return true;
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean invokePerfBoostImpl(int[] iArr, int i) throws Exception {
            if (this.mPerfBoostMethod == null) {
                return false;
            }
            if ((this.mExtendBoostEnableLevel & 1) != 0) {
                Log.d(FrameworkPerfLock.TAG, "use extend new paras");
                if (iArr == null) {
                    iArr = FrameworkPerfLock.sQualcommPerfLockExtendGPU;
                }
            } else if (iArr == null) {
                iArr = FrameworkPerfLock.sQualcommPerfLockParas;
            }
            Object invoke = this.mPerfBoostMethod.invoke(this.mPerfClazzObj, Integer.valueOf(i), iArr);
            if (invoke == null) {
                return false;
            }
            Log.e(FrameworkPerfLock.TAG, "return handle = " + invoke);
            return ((Integer) invoke).intValue() > 0;
        }
    }

    /* loaded from: classes5.dex */
    private static class OppoPerfLock extends PerfLockImpl {
        private OppoPerfLock() {
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean preparePerfParasImpl(Context context) throws Exception {
            this.mPerfClazz = ClassLoader.getSystemClassLoader().loadClass("android.os.PerformanceManager");
            if (this.mPerfClazz == null) {
                return false;
            }
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(this.mPerfClazz, "enableMultiThreadOptimize", new Class[0]);
            return true;
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        boolean invokePerfBoostImpl(int[] iArr, int i) throws Exception {
            if (this.mPerfBoostMethod == null) {
                return false;
            }
            this.mPerfBoostMethod.invoke(null, new Object[0]);
            return true;
        }
    }
}
