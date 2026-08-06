package com.bytedance.keva;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.ArrayMap;
import android.util.Log;
import com.bytedance.keva.Keva;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class KevaImpl extends Keva {
    static int sExecuteKevaType;
    static final Executor sExecutor;
    static final boolean sIsAsyncWriteEnable;
    static final boolean sIsEnableArrayMap;
    static final boolean sIsEnableExecutorOpt;
    static int sIsEnableLoadFromNative;
    static final boolean sIsEnableLockOpt;
    static int sIsEnableMultiProcessLoadFromNative;
    static final boolean sIsLoadOptEnable;
    static final KevaMonitor sMonitor;
    private static final ConcurrentHashMap<String, Map<String, Keva>> sPathRepoMap;
    private static final String sPortedSpRepoName;
    private static final Map<String, Keva> sRepoMap;
    private static final File sSharedPrefsDir;
    static final File sWorkDir;
    volatile long mHandle;
    private final boolean mIsMultiProcess;
    final int mMode;
    final String mName;
    String mSpecifiedPath;
    volatile Map<String, KevaValueWrapper> mValueMap = obtainMap();
    private final ConcurrentLinkedQueue<Keva.OnChangeListener> mChangeListeners = new ConcurrentLinkedQueue<>();
    private List<KevaValueWrapper> mDuplicatedOldWrappers = new ArrayList();

    /* loaded from: classes4.dex */
    protected interface PrivateConstants {
        public static final int BLOCK_TYPE_BYTES = 0;
        public static final int BLOCK_TYPE_OBJECT = 4;
        public static final int BLOCK_TYPE_STRING_ARRAY = 3;
        public static final int BLOCK_TYPE_STRING_UTF16 = 2;
        public static final int BLOCK_TYPE_STRING_UTF8 = 1;
        public static final String EMPTY_STRING = "";
        public static final int EXT_TYPE_BYTES = 7;
        public static final int EXT_TYPE_OBJECT = 71;
        public static final int EXT_TYPE_STRING_ARRAY = 55;
        public static final int EXT_TYPE_STRING_UTF16 = 39;
        public static final int EXT_TYPE_STRING_UTF8 = 23;
        public static final String FILES_DIR_NAME = "files";
        public static final String KEVA = "keva";
        public static final String LIB_NAME = "keva";
        public static final String PORTED_SP = "keva_porting_sp";
        public static final int REPORT_VALUE_SIZE_THRESHOLD = 10000;
        public static final String SP_DIR_NAME = "shared_prefs";
        public static final int TYPE_BOOL = 2;
        public static final int TYPE_BYTES = 7;
        public static final int TYPE_DOUBLE = 5;
        public static final int TYPE_FLOAT = 4;
        public static final int TYPE_INT = 1;
        public static final int TYPE_INVALID = 0;
        public static final int TYPE_LONG = 3;
        public static final int TYPE_STRING = 6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void checkReportException(long j);

    private static native void clear(long j);

    private static native boolean delete(String str);

    private native void dump(long j);

    private native void erase(long j, String str, long j2);

    private native void eraseUnusedChunk(long j, long j2);

    private static native void initialize(String str);

    private native long loadRepo(String str, int i, boolean z);

    private native long loadRepoWithPath(String str, String str2, int i);

    private native int protectPortingInterProcess(String str, boolean z, int i);

    private native long storeBoolean(long j, String str, long j2, boolean z);

    private native long storeBytes(long j, String str, long j2, byte[] bArr, int i);

    private native long storeDouble(long j, String str, long j2, double d);

    private native long storeFloat(long j, String str, long j2, float f);

    private native long storeInt(long j, String str, long j2, int i);

    private native long storeLong(long j, String str, long j2, long j3);

    private native long storeString(long j, String str, long j2, String str2);

    private native long storeStringArray(long j, String str, long j2, String[] strArr, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean contains(long j, String str, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void fetchAllKey(long j, Set<String> set);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean fetchBoolean(long j, String str, long j2, boolean z);

    protected abstract boolean fetchBoolean(String str, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native byte[] fetchBytes(long j, String str, long j2, byte[] bArr, int i);

    protected abstract byte[] fetchBytes(String str, byte[] bArr, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native double fetchDouble(long j, String str, long j2, double d);

    protected abstract double fetchDouble(String str, double d);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native float fetchFloat(long j, String str, long j2, float f);

    protected abstract float fetchFloat(String str, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int fetchInt(long j, String str, long j2, int i);

    protected abstract int fetchInt(String str, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native long fetchLong(long j, String str, long j2, long j3);

    protected abstract long fetchLong(String str, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native String fetchString(long j, String str, long j2, String str2);

    protected abstract String fetchString(String str, String str2, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native String[] fetchStringArray(long j, String str, long j2, String[] strArr, int i);

    protected abstract String[] fetchStringArray(String str, String[] strArr, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void rebuildValueMap(long j);

    /* JADX INFO: Access modifiers changed from: protected */
    public static Map obtainMap() {
        if (!sIsEnableArrayMap) {
            return new HashMap();
        }
        return new ArrayMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class PortedSpRepoHolder {
        private static final KevaImpl sInstance;
        private static final Map<String, ?> sPortedSpMap;

        private PortedSpRepoHolder() {
        }

        static {
            KevaMultiProcessImpl kevaMultiProcessImpl = new KevaMultiProcessImpl(KevaImpl.sPortedSpRepoName, null, 1);
            sInstance = kevaMultiProcessImpl;
            kevaMultiProcessImpl.init(true);
            sPortedSpMap = kevaMultiProcessImpl.buildNewMap(KevaImpl.obtainMap());
        }
    }

    private static Keva getPortedSpRepo() {
        return PortedSpRepoHolder.sInstance;
    }

    static {
        KevaBuilder kevaBuilder = KevaBuilder.getInstance();
        KevaBuilder.clearInstance();
        sRepoMap = obtainMap();
        sPathRepoMap = new ConcurrentHashMap<>();
        Executor executor = kevaBuilder.mExecutor;
        if (executor != null) {
            sExecutor = executor;
        } else {
            int max = Math.max(Runtime.getRuntime().availableProcessors() * 2, 6);
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, max, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            sExecutor = threadPoolExecutor;
        }
        String str = kevaBuilder.mPortedRepoName;
        if (str == null) {
            str = PrivateConstants.PORTED_SP;
        }
        sPortedSpRepoName = str;
        Context context = kevaBuilder.mContext;
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = new File(context.getApplicationInfo().dataDir, PrivateConstants.FILES_DIR_NAME);
        }
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }
        File file = kevaBuilder.mWorkDir;
        if (file == null) {
            file = new File(filesDir, "keva");
        }
        sSharedPrefsDir = new File(filesDir.getParent(), PrivateConstants.SP_DIR_NAME);
        KevaMonitor kevaMonitor = kevaBuilder.mMonitor;
        if (kevaMonitor == null) {
            kevaMonitor = new KevaMonitor();
        }
        sMonitor = kevaMonitor;
        kevaMonitor.logDebug("Keva version: 1.7.0.SHARED.CXXAPI-alpha.4-test");
        if (!file.exists() && !file.mkdirs()) {
            kevaMonitor.reportThrowable(1, null, null, null, new IllegalStateException("fail to create work dir " + file.getPath()));
        }
        boolean z = kevaBuilder.mEnableAsyncWrite;
        sIsAsyncWriteEnable = z;
        sIsLoadOptEnable = !z && kevaBuilder.mEnableLoadOpt;
        sIsEnableLockOpt = kevaBuilder.mEnableLockOpt;
        sIsEnableExecutorOpt = kevaBuilder.mEnableExecutorOpt;
        sExecuteKevaType = kevaBuilder.mExecuteKevaType;
        sWorkDir = file;
        sIsEnableArrayMap = kevaBuilder.mEnableArrayMap;
        sIsEnableLoadFromNative = kevaBuilder.mIsLoadFromNative;
        sIsEnableMultiProcessLoadFromNative = kevaBuilder.sIsEnableMultiProcessLoadFromNative;
        Log.d("LeakDetector", Log.getStackTraceString(new RuntimeException("sIsEnableLoadFromNative:" + sIsEnableLoadFromNative + " sIsEnableMultiProcessLoadFromNative:" + sIsEnableMultiProcessLoadFromNative)));
        try {
            kevaMonitor.loadLibrary("keva");
            initialize(file.getAbsolutePath());
        } catch (Throwable th) {
            th.printStackTrace();
            KevaMonitor kevaMonitor2 = sMonitor;
            kevaMonitor2.logDebug("fail to load so and init");
            kevaMonitor2.reportThrowable(1, null, null, null, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void forceInitImpl() {
        Log.println(4, KevaConstants.TAG, "force initializing Keva");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KevaImpl(String str, String str2, int i) {
        this.mName = str;
        this.mMode = i;
        this.mSpecifiedPath = str2;
        this.mIsMultiProcess = (i & 1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(boolean z) {
        synchronized (this) {
            if (this.mHandle != 0) {
                return;
            }
            doLoadRepo(z);
        }
    }

    private void cleanUpAfterLoadRepo() {
        if (this.mHandle == 0) {
            sMonitor.reportWarning(1, this.mName, null, null, "free space is " + Environment.getDataDirectory().getFreeSpace());
            return;
        }
        try {
            Iterator<KevaValueWrapper> it = this.mDuplicatedOldWrappers.iterator();
            while (it.hasNext()) {
                eraseUnusedChunk(this.mHandle, it.next().offset);
            }
            this.mDuplicatedOldWrappers = null;
            checkReportException(this.mHandle);
        } catch (Throwable th) {
            sMonitor.reportThrowable(1, this.mName, null, null, th);
        }
    }

    public static Keva getRepo(String str, int i) {
        return getRepoImpl(str, null, i, false);
    }

    public static Keva getRepoSync(String str, int i) {
        return getRepoImpl(str, null, i, true);
    }

    public static Keva getRepoWithPath(String str, String str2, int i, boolean z) {
        if (str2 == null || "".equals(str2) || str2.startsWith("/") || !str2.endsWith("/")) {
            throw new IllegalArgumentException("The path passed in is wrong!");
        }
        return getRepoImpl(str, str2, i, z);
    }

    private static KevaImpl getEmptyRepoImplWithPath(String str, String str2, int i, boolean z) {
        if (i < 0 || i >= 2) {
            sMonitor.reportThrowable(1, str, null, null, new IllegalArgumentException("mode is not valid! " + i));
        }
        if ((i & 1) != 0) {
            if (!z && sIsEnableMultiProcessLoadFromNative == 1) {
                return new KevaPrivateOnlyNativeImpl(str, str2, i);
            }
            return new KevaMultiProcessImpl(str, str2, i);
        }
        if (!z) {
            int i2 = sIsEnableLoadFromNative;
            if (i2 == 1) {
                return new KevaPrivateNativeImpl(str, str2, i);
            }
            if (i2 == 2) {
                return new KevaPrivateOnlyNativeImpl(str, str2, i);
            }
            return new KevaPrivateImpl(str, str2, i);
        }
        return new KevaPrivateImpl(str, str2, i);
    }

    private static Keva getRepoImpl(String str, String str2, int i, boolean z) {
        Map<String, Keva> map;
        Keva keva;
        Map<String, Keva> map2;
        boolean z2 = true;
        if (!sIsEnableLockOpt) {
            if (str2 == null) {
                map2 = sRepoMap;
            } else {
                ConcurrentHashMap<String, Map<String, Keva>> concurrentHashMap = sPathRepoMap;
                concurrentHashMap.putIfAbsent(str2, obtainMap());
                map2 = concurrentHashMap.get(str2);
            }
            synchronized (map2) {
                keva = map2.get(str);
                if (keva != null) {
                    z2 = false;
                }
                if (z2) {
                    keva = z ? getEmptyRepoImplWithPath(str, str2, i, false) : getAsyncKeva(null, str, str2, i, false);
                    map2.put(str, keva);
                }
            }
        } else {
            if (str2 == null) {
                map = sRepoMap;
            } else {
                ConcurrentHashMap<String, Map<String, Keva>> concurrentHashMap2 = sPathRepoMap;
                concurrentHashMap2.putIfAbsent(str2, obtainMap());
                map = concurrentHashMap2.get(str2);
            }
            keva = map.get(str);
            if (keva == null) {
                synchronized (map) {
                    keva = map.get(str);
                    if (keva != null) {
                        z2 = false;
                    }
                    if (z2) {
                        Keva emptyRepoImplWithPath = z ? getEmptyRepoImplWithPath(str, str2, i, false) : getAsyncKeva(null, str, str2, i, false);
                        map.put(str, emptyRepoImplWithPath);
                        keva = emptyRepoImplWithPath;
                    }
                }
            } else {
                z2 = false;
            }
        }
        if (z2) {
            if (!(keva instanceof KevaFuture)) {
                ((KevaImpl) keva).init(false);
            }
        } else if (!(keva instanceof KevaFuture)) {
            ((KevaImpl) keva).checkMode(i);
        } else {
            ((KevaFuture) keva).checkMode(i);
        }
        return keva;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KevaImpl getEmptyRepoImpl(String str, String str2, int i, boolean z) {
        return getEmptyRepoImplWithPath(str, str2, i, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkMode(int i) {
        if (this.mHandle == 0 || this.mMode == i) {
            return;
        }
        sMonitor.reportThrowable(1, this.mName, null, null, new IllegalStateException("mode is different: " + this.mMode + " != " + i));
    }

    public static Keva getRepoFromSp(Context context, String str, int i) {
        return getRepoFromSpImpl(context, str, i, false);
    }

    public static Keva getRepoFromSpSync(Context context, String str, int i) {
        return getRepoFromSpImpl(context, str, i, true);
    }

    private static Keva getAsyncKeva(final Context context, final String str, final String str2, final int i, final boolean z) {
        Callable<KevaImpl> callable = new Callable<KevaImpl>() { // from class: com.bytedance.keva.KevaImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public KevaImpl call() throws Exception {
                if (z) {
                    KevaImpl emptyRepoImpl = KevaImpl.getEmptyRepoImpl(str, str2, i, true);
                    emptyRepoImpl.doPortingFromSp(context);
                    return emptyRepoImpl;
                }
                KevaImpl emptyRepoImpl2 = KevaImpl.getEmptyRepoImpl(str, str2, i, false);
                emptyRepoImpl2.init(false);
                return emptyRepoImpl2;
            }
        };
        if (sIsAsyncWriteEnable && i == 0) {
            return new KevaAsyncWriter(str, str2, i, callable, z);
        }
        return new KevaFuture(str, str2, i, callable, z);
    }

    private static Keva getRepoFromSpImpl(Context context, String str, int i, boolean z) {
        Keva keva;
        if (isRepoPorted(str)) {
            return getRepo(str, i);
        }
        if (!existSharedPrefs(str)) {
            getPortedSpRepo().storeBoolean(str, true);
            return getRepo(str, i);
        }
        sMonitor.logDebug("do poring from sp: " + str);
        if (!sIsEnableLockOpt) {
            Map<String, Keva> map = sRepoMap;
            synchronized (map) {
                keva = map.get(str);
                r2 = keva == null;
                if (r2) {
                    keva = z ? getEmptyRepoImpl(str, null, i, true) : getAsyncKeva(context, str, null, i, true);
                    map.put(str, keva);
                }
            }
        } else {
            Map<String, Keva> map2 = sRepoMap;
            keva = map2.get(str);
            if (keva == null) {
                synchronized (map2) {
                    keva = map2.get(str);
                    r2 = keva == null;
                    if (r2) {
                        Keva emptyRepoImpl = z ? getEmptyRepoImpl(str, null, i, true) : getAsyncKeva(context, str, null, i, true);
                        map2.put(str, emptyRepoImpl);
                        keva = emptyRepoImpl;
                    }
                }
            }
        }
        if (r2) {
            if (keva instanceof KevaImpl) {
                try {
                    ((KevaImpl) keva).doPortingFromSp(context);
                } catch (UnsatisfiedLinkError e) {
                    sMonitor.reportThrowable(1, str, null, null, e);
                }
            }
        } else if (keva instanceof KevaImpl) {
            ((KevaImpl) keva).checkMode(i);
        } else {
            ((KevaFuture) keva).checkMode(i);
        }
        return keva;
    }

    private static boolean existSharedPrefs(String str) {
        return new File(sSharedPrefsDir, str + ".xml").exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doPortingFromSp(Context context) {
        String str;
        Throwable th;
        synchronized (this) {
            if (this.mHandle != 0) {
                return;
            }
            boolean z = this instanceof KevaMultiProcessImpl;
            int i = -1;
            if (z) {
                i = protectPortingInterProcess(this.mName, true, -1);
                if (isRepoPorted(this.mName)) {
                    doLoadRepo(false);
                    protectPortingInterProcess(this.mName, false, i);
                    return;
                }
            }
            int i2 = i;
            boolean z2 = !z && delete(this.mName);
            KevaMonitor kevaMonitor = sMonitor;
            kevaMonitor.logDebug("poring load empty repo >> " + this.mName);
            doLoadRepo(false);
            if (this.mHandle == 0) {
                return;
            }
            if (!z2) {
                clear();
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(this.mName, 0);
            kevaMonitor.logDebug("poring get sp >> " + this.mName);
            Map<String, ?> all = sharedPreferences.getAll();
            kevaMonitor.logDebug("poring get all value >> " + this.mName);
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    if ("".equals(key)) {
                        key = null;
                    }
                    String str2 = key;
                    KevaMonitor kevaMonitor2 = sMonitor;
                    kevaMonitor2.logDebug("poring process key: " + str2 + ", value: " + value + " >> " + this.mName);
                    KevaValueWrapper kevaValueWrapper = new KevaValueWrapper();
                    this.mValueMap.put(str2, kevaValueWrapper);
                    try {
                    } catch (Throwable th2) {
                        th = th2;
                        str = str2;
                    }
                    if (value instanceof Boolean) {
                        try {
                            kevaValueWrapper.offset = storeBoolean(this.mHandle, str2, kevaValueWrapper.offset, ((Boolean) value).booleanValue());
                            kevaValueWrapper.value = value;
                        } catch (Throwable th3) {
                            th = th3;
                            str = str2;
                            sMonitor.reportThrowable(3, this.mName, str, value, th);
                        }
                    } else if (value instanceof Integer) {
                        kevaValueWrapper.offset = storeInt(this.mHandle, str2, kevaValueWrapper.offset, ((Integer) value).intValue());
                        kevaValueWrapper.value = value;
                    } else {
                        if (value instanceof Long) {
                            str = str2;
                            kevaValueWrapper.offset = storeLong(this.mHandle, str2, kevaValueWrapper.offset, ((Long) value).longValue());
                            kevaValueWrapper.value = value;
                        } else {
                            str = str2;
                            if (value instanceof Float) {
                                kevaValueWrapper.offset = storeFloat(this.mHandle, str, kevaValueWrapper.offset, ((Float) value).floatValue());
                                kevaValueWrapper.value = value;
                            } else if (value instanceof String) {
                                kevaValueWrapper.offset = storeString(this.mHandle, str, kevaValueWrapper.offset, (String) value);
                                kevaValueWrapper.value = value;
                            } else if (value instanceof Set) {
                                Set set = (Set) value;
                                String[] strArr = new String[set.size()];
                                set.toArray(strArr);
                                kevaValueWrapper.offset = storeStringArray(this.mHandle, str, kevaValueWrapper.offset, strArr, 3);
                                kevaValueWrapper.value = strArr;
                            } else {
                                kevaMonitor2.reportThrowable(1, this.mName, str, value, new IllegalStateException("do not support type: " + value.getClass()));
                            }
                        }
                        if (!this.mIsMultiProcess) {
                            try {
                                kevaValueWrapper.loaded = true;
                            } catch (Throwable th4) {
                                th = th4;
                                th = th;
                                sMonitor.reportThrowable(3, this.mName, str, value, th);
                            }
                        }
                    }
                    str = str2;
                    if (!this.mIsMultiProcess) {
                    }
                }
            }
            getPortedSpRepo().storeBoolean(this.mName, true);
            if (z) {
                protectPortingInterProcess(this.mName, false, i2);
            }
            sMonitor.logDebug("poring set ported repo >> " + this.mName);
        }
    }

    void doLoadRepo(boolean z) {
        try {
            String str = this.mSpecifiedPath;
            if (str == null) {
                this.mHandle = loadRepo(this.mName, this.mMode, z);
            } else {
                this.mHandle = loadRepoWithPath(this.mName, str, this.mMode);
            }
            cleanUpAfterLoadRepo();
            if (z) {
                return;
            }
            sMonitor.onLoadRepo(this.mName, this.mMode);
        } catch (Throwable th) {
            sMonitor.reportThrowable(1, this.mName, null, null, th);
        }
    }

    public static boolean isRepoPorted(String str) {
        if (PortedSpRepoHolder.sPortedSpMap.get(str) != null) {
            return true;
        }
        return getPortedSpRepo().getBoolean(str, false);
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return this.mName;
    }

    public int mode() {
        return this.mMode;
    }

    private void addMapObjectWhenLoading(String str, Object obj, long j, int i) {
        List<KevaValueWrapper> list;
        if ("".equals(str)) {
            str = null;
        }
        KevaValueWrapper kevaValueWrapper = new KevaValueWrapper();
        kevaValueWrapper.value = obj;
        kevaValueWrapper.offset = j;
        kevaValueWrapper.type = i;
        if (!this.mIsMultiProcess) {
            kevaValueWrapper.loaded = true;
        }
        KevaValueWrapper put = this.mValueMap.put(str, kevaValueWrapper);
        if (put == null || (list = this.mDuplicatedOldWrappers) == null) {
            return;
        }
        list.add(put);
    }

    void addMapOffsetWhenLoading(String str, long j, int i) {
        List<KevaValueWrapper> list;
        if ("".equals(str)) {
            str = null;
        }
        KevaValueWrapper kevaValueWrapper = new KevaValueWrapper();
        kevaValueWrapper.offset = j;
        kevaValueWrapper.type = i;
        KevaValueWrapper put = this.mValueMap.put(str, kevaValueWrapper);
        if (put == null || (list = this.mDuplicatedOldWrappers) == null) {
            return;
        }
        list.add(put);
    }

    void addMapIntWhenLoading(String str, int i, long j) {
        addMapObjectWhenLoading(str, Integer.valueOf(i), j, 1);
    }

    void addMapBoolWhenLoading(String str, boolean z, long j) {
        addMapObjectWhenLoading(str, Boolean.valueOf(z), j, 2);
    }

    void addMapFloatWhenLoading(String str, float f, long j) {
        addMapObjectWhenLoading(str, Float.valueOf(f), j, 4);
    }

    void addMapDoubleWhenLoading(String str, double d, long j) {
        addMapObjectWhenLoading(str, Double.valueOf(d), j, 5);
    }

    void addMapLongWhenLoading(String str, long j, long j2) {
        addMapObjectWhenLoading(str, Long.valueOf(j), j2, 3);
    }

    static void passWarning(int i, String str, String str2, Object obj, String str3) {
        sMonitor.reportWarning(i, str, str2, obj, str3);
    }

    private KevaValueWrapper obtainWrapperLocked(String str) {
        KevaValueWrapper kevaValueWrapper = this.mValueMap.get(str);
        if (kevaValueWrapper != null) {
            return kevaValueWrapper;
        }
        KevaValueWrapper kevaValueWrapper2 = new KevaValueWrapper();
        this.mValueMap.put(str, kevaValueWrapper2);
        return kevaValueWrapper2;
    }

    private void reportBigValue(final String str, final Object obj, final int i) {
        if (i > 10000) {
            sExecutor.execute(new Runnable() { // from class: com.bytedance.keva.KevaImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    KevaImpl.sMonitor.reportWarning(3, KevaImpl.this.mName, str, obj, "value too big, size=" + i);
                }
            });
        }
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> map) {
        synchronized (this) {
            for (Map.Entry<String, KevaValueWrapper> entry : this.mValueMap.entrySet()) {
                KevaValueWrapper value = entry.getValue();
                if (value.offset != 0) {
                    String key = entry.getKey();
                    try {
                        if (!value.loaded) {
                            int i = value.type;
                            if (i == 6) {
                                value.value = fetchString(this.mHandle, key, value.offset, null);
                            } else if (i == 7) {
                                value.value = fetchBytes(this.mHandle, key, value.offset, null, 0);
                            } else {
                                if (i == 23 || i == 39) {
                                    throw new UnsupportedOperationException("keva has not implemented type " + value.type);
                                }
                                if (i == 55) {
                                    value.value = fetchStringArray(this.mHandle, key, value.offset, null, 3);
                                } else if (!this.mIsMultiProcess || value.type > 5) {
                                    throw new UnsupportedOperationException("keva has not implemented type " + value.type);
                                }
                            }
                            if (!this.mIsMultiProcess) {
                                value.loaded = true;
                            }
                        }
                        map.put(key, value.value);
                    } catch (Throwable th) {
                        sMonitor.reportThrowable(2, this.mName, key, Long.valueOf(value.offset), th);
                    }
                }
            }
        }
        return map;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String str, byte[] bArr) {
        byte[] fetchBytes;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    fetchBytes = fetchBytes(str2, bArr, 0, false);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, bArr, th);
                    return bArr;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fetchBytes;
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String str, String str2) {
        String fetchString;
        if ("".equals(str)) {
            str = null;
        }
        String str3 = str;
        synchronized (this) {
            try {
                try {
                    fetchString = fetchString(str3, str2, false);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str3, str2, th);
                    return str2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fetchString;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> fetchStringSet;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    fetchStringSet = fetchStringSet(str2, set, false);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, set, th);
                    return set;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fetchStringSet;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String str, String[] strArr) {
        String[] fetchStringArray;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    fetchStringArray = fetchStringArray(str2, strArr, false);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, strArr, th);
                    return strArr;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fetchStringArray;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String str, byte[] bArr) {
        byte[] fetchBytes;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    fetchBytes = fetchBytes(str2, bArr, 0, true);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, bArr, th);
                    return bArr;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fetchBytes;
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String str, String str2) {
        String fetchString;
        if ("".equals(str)) {
            str = null;
        }
        String str3 = str;
        synchronized (this) {
            try {
                try {
                    fetchString = fetchString(str3, str2, true);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str3, str2, th);
                    return str2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fetchString;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String str, Set<String> set) {
        Set<String> fetchStringSet;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    fetchStringSet = fetchStringSet(str2, set, true);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, set, th);
                    return set;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fetchStringSet;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String str, String[] strArr) {
        String[] fetchStringArray;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    fetchStringArray = fetchStringArray(str2, strArr, true);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, strArr, th);
                    return strArr;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fetchStringArray;
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String str, int i) {
        int fetchInt;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    fetchInt = fetchInt(str2, i);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, Integer.valueOf(i), th);
                    return i;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fetchInt;
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String str, long j) {
        long fetchLong;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    fetchLong = fetchLong(str2, j);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, Long.valueOf(j), th);
                    return j;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fetchLong;
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String str, double d) {
        double fetchDouble;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    fetchDouble = fetchDouble(str2, d);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, Double.valueOf(d), th);
                    return d;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fetchDouble;
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String str, float f) {
        float fetchFloat;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    fetchFloat = fetchFloat(str2, f);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, Float.valueOf(f), th);
                    return f;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fetchFloat;
    }

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String str, boolean z) {
        boolean fetchBoolean;
        if ("".equals(str)) {
            str = null;
        }
        String str2 = str;
        synchronized (this) {
            try {
                try {
                    fetchBoolean = fetchBoolean(str2, z);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(2, this.mName, str2, null, th);
                    return z;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fetchBoolean;
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String str, float f) {
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper obtainWrapperLocked = obtainWrapperLocked(str);
            if (this.mIsMultiProcess || !obtainWrapperLocked.loaded || obtainWrapperLocked.value == null || !obtainWrapperLocked.value.equals(Float.valueOf(f))) {
                try {
                    obtainWrapperLocked.offset = storeFloat(this.mHandle, str, obtainWrapperLocked.offset, f);
                    obtainWrapperLocked.value = Float.valueOf(f);
                    if (!this.mIsMultiProcess) {
                        obtainWrapperLocked.loaded = true;
                    }
                    notifyChangeListeners(this, str);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(3, this.mName, str, Float.valueOf(f), th);
                }
            }
        }
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String str, int i) {
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper obtainWrapperLocked = obtainWrapperLocked(str);
            if (this.mIsMultiProcess || !obtainWrapperLocked.loaded || obtainWrapperLocked.value == null || !obtainWrapperLocked.value.equals(Integer.valueOf(i))) {
                try {
                    obtainWrapperLocked.offset = storeInt(this.mHandle, str, obtainWrapperLocked.offset, i);
                    obtainWrapperLocked.value = Integer.valueOf(i);
                    if (!this.mIsMultiProcess) {
                        obtainWrapperLocked.loaded = true;
                    }
                    notifyChangeListeners(this, str);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(3, this.mName, str, Integer.valueOf(i), th);
                }
            }
        }
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String str, boolean z) {
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper obtainWrapperLocked = obtainWrapperLocked(str);
            if (this.mIsMultiProcess || !obtainWrapperLocked.loaded || obtainWrapperLocked.value == null || !obtainWrapperLocked.value.equals(Boolean.valueOf(z))) {
                try {
                    obtainWrapperLocked.offset = storeBoolean(this.mHandle, str, obtainWrapperLocked.offset, z);
                    obtainWrapperLocked.value = Boolean.valueOf(z);
                    if (!this.mIsMultiProcess) {
                        obtainWrapperLocked.loaded = true;
                    }
                    notifyChangeListeners(this, str);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(3, this.mName, str, Boolean.valueOf(z), th);
                }
            }
        }
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String str, long j) {
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper obtainWrapperLocked = obtainWrapperLocked(str);
            if (this.mIsMultiProcess || !obtainWrapperLocked.loaded || obtainWrapperLocked.value == null || !obtainWrapperLocked.value.equals(Long.valueOf(j))) {
                try {
                    obtainWrapperLocked.offset = storeLong(this.mHandle, str, obtainWrapperLocked.offset, j);
                    obtainWrapperLocked.value = Long.valueOf(j);
                    if (!this.mIsMultiProcess) {
                        obtainWrapperLocked.loaded = true;
                    }
                    notifyChangeListeners(this, str);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(3, this.mName, str, Long.valueOf(j), th);
                }
            }
        }
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String str, double d) {
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper obtainWrapperLocked = obtainWrapperLocked(str);
            if (this.mIsMultiProcess || !obtainWrapperLocked.loaded || obtainWrapperLocked.value == null || !obtainWrapperLocked.value.equals(Double.valueOf(d))) {
                try {
                    obtainWrapperLocked.offset = storeDouble(this.mHandle, str, obtainWrapperLocked.offset, d);
                    obtainWrapperLocked.value = Double.valueOf(d);
                    if (!this.mIsMultiProcess) {
                        obtainWrapperLocked.loaded = true;
                    }
                    notifyChangeListeners(this, str);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(3, this.mName, str, Double.valueOf(d), th);
                }
            }
        }
    }

    private void storeString(final String str, final String str2, boolean z) {
        final int length;
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper obtainWrapperLocked = obtainWrapperLocked(str);
            if (this.mIsMultiProcess || !obtainWrapperLocked.loaded || obtainWrapperLocked.value == null || !obtainWrapperLocked.value.equals(str2)) {
                try {
                    obtainWrapperLocked.offset = storeString(this.mHandle, str, obtainWrapperLocked.offset, str2);
                    obtainWrapperLocked.type = 6;
                    if (!z) {
                        obtainWrapperLocked.value = str2;
                        if (!this.mIsMultiProcess) {
                            obtainWrapperLocked.loaded = true;
                        }
                    } else {
                        obtainWrapperLocked.value = null;
                        obtainWrapperLocked.loaded = false;
                    }
                    notifyChangeListeners(this, str);
                } catch (Throwable th) {
                    sMonitor.reportThrowable(3, this.mName, str, str2, th);
                }
                if (str2 == null || (length = str2.length()) <= 10000) {
                    return;
                }
                sExecutor.execute(new Runnable() { // from class: com.bytedance.keva.KevaImpl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        KevaImpl.sMonitor.reportWarning(3, KevaImpl.this.mName, str, str2, "value too big, size=" + length);
                    }
                });
            }
        }
    }

    private void storeBytes(final String str, byte[] bArr, int i, boolean z) {
        final int length;
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper obtainWrapperLocked = obtainWrapperLocked(str);
            try {
                obtainWrapperLocked.offset = storeBytes(this.mHandle, str, obtainWrapperLocked.offset, bArr, i);
                obtainWrapperLocked.type = (i << 4) | 7;
                if (!z) {
                    obtainWrapperLocked.value = bArr;
                    if (!this.mIsMultiProcess) {
                        obtainWrapperLocked.loaded = true;
                    }
                } else {
                    obtainWrapperLocked.value = null;
                    obtainWrapperLocked.loaded = false;
                }
                notifyChangeListeners(this, str);
            } catch (Throwable th) {
                sMonitor.reportThrowable(3, this.mName, str, bArr, th);
            }
        }
        if (bArr == null || (length = bArr.length) <= 10000) {
            return;
        }
        sExecutor.execute(new Runnable() { // from class: com.bytedance.keva.KevaImpl.4
            @Override // java.lang.Runnable
            public void run() {
                KevaImpl.sMonitor.reportWarning(3, KevaImpl.this.mName, str, null, "value too big, size=" + length);
            }
        });
    }

    private void storeStringSet(String str, Set<String> set, boolean z) {
        String[] strArr;
        if (set != null) {
            strArr = new String[set.size()];
            set.toArray(strArr);
        } else {
            strArr = null;
        }
        storeStringArray(str, strArr, z);
    }

    private void storeStringArray(final String str, String[] strArr, boolean z) {
        final String arrays;
        final int length;
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            KevaValueWrapper obtainWrapperLocked = obtainWrapperLocked(str);
            try {
                obtainWrapperLocked.offset = storeStringArray(this.mHandle, str, obtainWrapperLocked.offset, strArr, 3);
                obtainWrapperLocked.type = 55;
                if (!z) {
                    obtainWrapperLocked.value = strArr;
                    if (!this.mIsMultiProcess) {
                        obtainWrapperLocked.loaded = true;
                    }
                } else {
                    obtainWrapperLocked.value = null;
                    obtainWrapperLocked.loaded = false;
                }
                notifyChangeListeners(this, str);
            } catch (Throwable th) {
                sMonitor.reportThrowable(3, this.mName, str, null, th);
            }
        }
        if (strArr == null || (length = (arrays = Arrays.toString(strArr)).length()) <= 10000) {
            return;
        }
        sExecutor.execute(new Runnable() { // from class: com.bytedance.keva.KevaImpl.5
            @Override // java.lang.Runnable
            public void run() {
                KevaImpl.sMonitor.reportWarning(3, KevaImpl.this.mName, str, arrays, "value too big, size=" + length);
            }
        });
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String str, String str2) {
        storeString(str, str2, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String str, Set<String> set) {
        storeStringSet(str, set, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String str, String[] strArr) {
        storeStringArray(str, strArr, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String str, byte[] bArr) {
        storeBytes(str, bArr, 0, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String str, String str2) {
        storeString(str, str2, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String str, Set<String> set) {
        storeStringSet(str, set, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String str, String[] strArr) {
        storeStringArray(str, strArr, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String str, byte[] bArr) {
        storeBytes(str, bArr, 0, true);
    }

    @Override // com.bytedance.keva.Keva
    public void erase(String str) {
        if ("".equals(str)) {
            str = null;
        }
        synchronized (this) {
            try {
                KevaValueWrapper obtainWrapperLocked = obtainWrapperLocked(str);
                erase(this.mHandle, str, obtainWrapperLocked.offset);
                obtainWrapperLocked.value = null;
                obtainWrapperLocked.offset = 0L;
                if (!this.mIsMultiProcess) {
                    obtainWrapperLocked.loaded = true;
                }
            } finally {
            }
        }
    }

    @Override // com.bytedance.keva.Keva
    public void clear() {
        synchronized (this) {
            try {
                this.mValueMap.clear();
                clear(this.mHandle);
            } finally {
            }
        }
    }

    @Override // com.bytedance.keva.Keva
    public void dump() {
        synchronized (this) {
            sMonitor.logDebug("start dumping keva " + this.mName + ", size=" + this.mValueMap.size());
            for (Map.Entry<String, KevaValueWrapper> entry : this.mValueMap.entrySet()) {
                KevaValueWrapper value = entry.getValue();
                sMonitor.logDebug("key: " + entry.getKey() + ", value: " + value.value + ", offset: " + value.offset + ", loaded: " + value.loaded);
            }
            sMonitor.logDebug("finish dumping keva " + this.mName + ", size=" + this.mValueMap.size());
        }
    }

    public void dumpNative() {
        synchronized (this) {
            dump(this.mHandle);
        }
    }

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener onChangeListener) {
        if (this.mChangeListeners.contains(onChangeListener)) {
            return;
        }
        this.mChangeListeners.add(onChangeListener);
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener onChangeListener) {
        synchronized (this) {
            this.mChangeListeners.remove(onChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyChangeListeners(Keva keva, String str) {
        if (this.mChangeListeners.isEmpty()) {
            return;
        }
        Iterator<Keva.OnChangeListener> it = this.mChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onChanged(keva, str);
        }
    }

    private Set<String> fetchStringSet(String str, Set<String> set, boolean z) {
        String[] fetchStringArray = fetchStringArray(str, set != null ? (String[]) set.toArray(new String[0]) : null, z);
        if (fetchStringArray != null) {
            return new HashSet(Arrays.asList(fetchStringArray));
        }
        return null;
    }

    private void fetchAllKey(String str, Set<String> set) {
        set.add(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class KevaValueWrapper {
        volatile boolean loaded;
        volatile long offset;
        volatile int type;
        volatile Object value;

        KevaValueWrapper() {
        }
    }
}
