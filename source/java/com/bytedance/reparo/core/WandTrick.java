package com.bytedance.reparo.core;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.log.TLog;
import com.bytedance.reparo.core.patch.DurationMetric;
import com.bytedance.reparo.core.patch.Patch;
import com.bytedance.reparo.core.utils.ProcessUtils;
import com.bytedance.reparo.core.utils.ReflectUtils;
import com.bytedance.reparo.core.utils.TimesRecorder;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class WandTrick {
    private static final int RET_APPLY_PATCH_CLASS_LOCKED = -12;
    private static final int RET_APPLY_PATCH_IDENTICAL_METHODS = -7;
    private static final int RET_APPLY_PATCH_METHODS_ON_STACK = -9;
    private static final int RET_APPLY_PATCH_UNPAIRED_METHODS = -8;
    private static final int RET_INITIALIZED_ART_FIELD_MODIFIER_INIT_ERROR = -11;
    private static final int RET_INITIALIZED_ART_METHOD_MODIFIER_INIT_ERROR = -10;
    private static final int RET_INITIALIZED_CLASS_NOT_FOUND = -4;
    private static final int RET_INITIALIZED_CRASH = -13;
    private static final int RET_INITIALIZED_INCOMPATIBLE_DEVICE = -6;
    private static final int RET_INITIALIZED_LIB_NOT_LOADED = -2;
    private static final int RET_INITIALIZED_LOAD_PLUGIN_FAILED = -5;
    private static final int RET_INITIALIZED_NOT_ALLOW_DEBUGGABLE = -1;
    private static final int RET_INITIALIZED_RESERVED = -99;
    private static final int RET_INITIALIZED_SUCCESS = 0;
    private static final int RET_INITIALIZED_SYMBOL_NOT_FOUND = -3;
    private static final int RET_NOT_INITIALIZED = Integer.MIN_VALUE;
    private static final String TAG = "WandTrick";
    public static File reparoSoFile;
    private static volatile WandTrick sInstance;
    Context mApplicationContext;
    private int mInitializedRet = Integer.MIN_VALUE;
    private volatile boolean mLibLoaded;
    private boolean mUseEntryPointDeoptimization;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native Object allocObject(Class cls);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native Object callMethodDirect(Class cls, Object obj, Object obj2, Object[] objArr, Object[] objArr2, String str, Class cls2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native Object createInstance(Class cls, Constructor constructor, Object[] objArr, Object[] objArr2);

    private native int deoptimizeNative(Object[] objArr, int[] iArr, boolean z, String[] strArr, String[] strArr2, long[] jArr);

    private native int initNative(boolean z, String str, boolean z2, String[] strArr);

    public static native void removeClassesFromClassLinker(String[] strArr, Object obj);

    public abstract RetryTaskMayFailure applyPatch(Application application, boolean z, Map<Class, PatchConfigCell> map, List<String> list, List<String> list2, List<Object> list3, DurationMetric durationMetric, Patch patch) throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void changeClinitToPreverified(Class cls);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void changeConstructorToPublic(Constructor constructor);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void changeFieldToPublic(Field field);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void changeMethodProtectedToPublic(Method method);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void changeMethodToPreverified(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void clearPointerArrayMemory(long j, int i);

    public native Constructor getClinitMethod(Class cls);

    public native boolean isSoLoaded(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int redefineClassesNative(Class[] clsArr, byte[][] bArr, Object[] objArr, int[] iArr, Object[] objArr2, String[] strArr, String[] strArr2, long[] jArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int replaceMethodNative(Object[] objArr, Object[] objArr2, int[] iArr, String[] strArr, String[] strArr2, long[] jArr);

    public static boolean isSelfSo(String str) {
        for (String str2 : BuildConfig.DEPENDENT_SO) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static WandTrick getInstanceWithoutInit() {
        if (sInstance == null) {
            synchronized (WandTrick.class) {
                if (sInstance == null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        sInstance = new ClassWand();
                    } else {
                        sInstance = new MethodWand();
                    }
                }
            }
        }
        return sInstance;
    }

    public static WandTrick getInstance() throws Exception {
        getInstanceWithoutInit();
        if (sInstance.mInitializedRet == Integer.MIN_VALUE) {
            synchronized (sInstance) {
                if (sInstance.mInitializedRet == Integer.MIN_VALUE) {
                    sInstance.init(ReparoPatch.getInstance().getPatchConfig());
                }
            }
        }
        if (sInstance.mInitializedRet != 0) {
            int i = sInstance.mInitializedRet;
            throw new PatchException("Failed to initialize wand trick, load skipped, initialize ret = " + i, i);
        }
        return sInstance;
    }

    static boolean loadSelfFix() {
        if (reparoSoFile == null) {
            return false;
        }
        boolean z = false;
        for (String str : BuildConfig.DEPENDENT_SO) {
            File file = new File(reparoSoFile, str);
            if (file.exists()) {
                System.load(file.getAbsolutePath());
                if (str.equals("libreparo.so")) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WandTrick() {
        if (!loadSelfFix()) {
            System.loadLibrary("reparo");
        }
        try {
            System.loadLibrary("jato");
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                System.loadLibrary("jatolite");
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        this.mLibLoaded = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int deoptimizeCallGraph(Application application, boolean z, Map<Class, PatchConfigCell> map, List<String> list, List<String> list2, List<Object> list3, DurationMetric durationMetric) throws Exception {
        if (map == null || map.isEmpty()) {
            throw new Exception("Invalid patch info.");
        }
        durationMetric.start("prepare_for_deopt");
        ArrayList<Class> loadAdditionalClasses = PatchUtils.loadAdditionalClasses(this.mApplicationContext, list, list2);
        if (list != null && !list.isEmpty() && loadAdditionalClasses.isEmpty()) {
            throw new Exception("Invalid additional class.");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Class> it = loadAdditionalClasses.iterator();
        while (it.hasNext()) {
            Class next = it.next();
            arrayList.addAll(getDeclaredMethods(next));
            arrayList.addAll(getDeclaredConstructors(next));
        }
        if (list3 != null) {
            arrayList.addAll(list3);
        }
        durationMetric.end("prepare_for_deopt");
        return deoptimizeMethodsCommon(arrayList.toArray(), durationMetric);
    }

    int deoptimizeMethodsCommon(Object[] objArr, DurationMetric durationMetric) throws Exception {
        String[] strArr = new String[10];
        int[] modifier = getModifier(objArr);
        durationMetric.start("deoptimizeNative");
        int deoptimizeNative = deoptimizeNative(objArr, modifier, true, strArr, durationMetric.getNativeTags(), durationMetric.getNativeTimes());
        durationMetric.end("deoptimizeNative");
        PatchLogger.logForCollideMethod("deopt", strArr);
        return deoptimizeNative;
    }

    public int deoptimizeMethodsCommonForApp(Object[] objArr) throws Exception {
        DurationMetric durationMetric = new DurationMetric();
        String[] strArr = new String[10];
        int[] modifier = getModifier(objArr);
        durationMetric.start("deoptimizeNative");
        int deoptimizeNative = deoptimizeNative(objArr, modifier, true, strArr, durationMetric.getNativeTags(), durationMetric.getNativeTimes());
        durationMetric.end("deoptimizeNative");
        PatchLogger.logForCollideMethod("deopt", strArr);
        return deoptimizeNative;
    }

    public int[] getModifier(Object[] objArr) {
        int length = objArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            if (obj instanceof Method) {
                iArr[i] = ((Method) obj).getModifiers();
            } else if (obj instanceof Constructor) {
                iArr[i] = ((Constructor) obj).getModifiers();
            } else {
                iArr[i] = 0;
            }
        }
        return iArr;
    }

    private void init(PatchConfiguration patchConfiguration) {
        init(patchConfiguration, true);
    }

    private synchronized void init(PatchConfiguration patchConfiguration, boolean z) {
        TimesRecorder timesRecorder = null;
        try {
            if (this.mInitializedRet != Integer.MIN_VALUE) {
                return;
            }
            TimesRecorder timesRecorder2 = new TimesRecorder(patchConfiguration.getPatchRootDir(), PatchConfiguration.INIT_FILE_NAME, 2, ProcessUtils.getCurrentProcessName(this.mApplicationContext));
            try {
                if (TimesRecorder.enableCrashProtect) {
                    timesRecorder2.checkOrIncrement();
                }
                this.mUseEntryPointDeoptimization = z;
                Application application = patchConfiguration.getApplication();
                this.mApplicationContext = application;
                String absolutePath = patchConfiguration.getInitFile(application).getAbsolutePath();
                if (((this.mApplicationContext.getApplicationInfo().flags & 2) != 0) && !patchConfiguration.allowDebuggable()) {
                    TLog.m320e("Hotfix disabled under debuggable mode.");
                    Toast.makeText(this.mApplicationContext, "Hotfix disabled under debuggable mode.", 0).show();
                    this.mInitializedRet = -1;
                    timesRecorder2.clear();
                    return;
                }
                if (this.mLibLoaded) {
                    String[] strArr = new String[10];
                    this.mInitializedRet = initNative(this.mUseEntryPointDeoptimization, absolutePath, patchConfiguration.enableNewAndroid(), strArr);
                    PatchLogger.logForSymbolNotFound(strArr);
                } else {
                    this.mInitializedRet = -2;
                }
                PatchLogger.m305i(TAG, "initialize wand trick complete, ret = " + this.mInitializedRet);
                if (this.mInitializedRet != RET_INITIALIZED_CRASH) {
                    timesRecorder2.clear();
                }
            } catch (Throwable th) {
                th = th;
                timesRecorder = timesRecorder2;
                if (this.mInitializedRet != RET_INITIALIZED_CRASH && timesRecorder != null) {
                    timesRecorder.clear();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Method> getDeclaredMethods(Class cls) {
        ArrayList<Method> arrayList = new ArrayList<>();
        for (Method method : ReflectUtils.getDeclaredMethods(cls).getValueIgnoreError()) {
            if (method.getDeclaringClass() == cls) {
                arrayList.add(method);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Constructor> getDeclaredConstructors(Class cls) {
        ArrayList<Constructor> arrayList = new ArrayList<>();
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            if (constructor.getDeclaringClass() == cls) {
                arrayList.add(constructor);
            }
        }
        return arrayList;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    class DummyInnerClass {
        private void first() {
        }

        private void second() {
        }

        DummyInnerClass() {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static abstract class RetryTaskMayFailure {
        public static RetryTaskMayFailure EMPTY = new RetryTaskMayFailure() { // from class: com.bytedance.reparo.core.WandTrick.RetryTaskMayFailure.1
            @Override // com.bytedance.reparo.core.WandTrick.RetryTaskMayFailure
            public int run() {
                return 0;
            }

            @Override // com.bytedance.reparo.core.WandTrick.RetryTaskMayFailure
            public boolean success(int i) {
                return true;
            }
        };
        private int mErrorCode;

        public abstract int run() throws Exception;

        public abstract boolean success(int i);

        public boolean tryRun() throws Exception {
            int run = run();
            this.mErrorCode = run;
            return success(run);
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }
    }
}
