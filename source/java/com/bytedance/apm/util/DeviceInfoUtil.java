package com.bytedance.apm.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.MonitorCoreExceptionManager;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.internal.SpManager;
import com.bytedance.apm.thread.AsyncEventManager;
import java.io.BufferedReader;
import java.io.FileReader;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DeviceInfoUtil {
    private static final long APP_BYTES_PER_MEGABYTE = 1048576;
    private static final long BYTES_PER_DISK_MEGABYTE = 1073741824;
    private static final long BYTES_PER_MEGABYTE = 536870912;
    private static final long CHECK_FS_INFO_INTERVAL = 604800000;
    private static final String DL_MALLOC = "dlmalloc";
    private static final int INVALID_DATA = -1;
    private static final String JE_MALLOC = "jemalloc";
    private static final String UNKNOWN = "unknown";
    private int mCpuCoreNum;
    private String mCpuModel;
    private double mDataPartitionAvailableRatio;
    private long mDataPartitionAvailableSize;
    private long mDataPartitionTotalSize;
    private boolean mEnabled;
    private boolean mHasJavaHeapLeak;
    private boolean mIsApp64Bit;
    private boolean mIsDevice64Bit;
    private boolean mIsExternalStorageMounted;
    private boolean mIsExternalStorageRemovable;
    private boolean mIsJBAndAbove;
    private long mJavaHeapSizeMaxMega;
    private long mJavaHeapSizeUsedMega;
    private String mMallocImpl;
    private long mNativeHeapSizeMega;
    private int mPhysicMemSizeMega;
    private double mSdcardAvailableRatio;
    private long mSdcardAvailableSize;
    private long mSdcardTotalSize;
    private double mSystemAvailableRatio;
    private long mSystemAvailableSize;
    private long mSystemTotalSize;

    private String getMallocImpl() {
        return "unknown";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class InstanceHolder {
        static final DeviceInfoUtil holder = new DeviceInfoUtil();

        private InstanceHolder() {
        }
    }

    public static DeviceInfoUtil getInstance() {
        return InstanceHolder.holder;
    }

    private DeviceInfoUtil() {
        checkThread();
        this.mEnabled = ApmContext.isDeviceInfoOnPerfDataEnabled();
        initDeviceInfo();
    }

    private void checkThread() {
        if (ThreadUtils.isMainThread()) {
            final Throwable th = new Throwable("Don't use DeviceInfoUtil on main thread.");
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.util.DeviceInfoUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    MonitorCoreExceptionManager.getInstance().directReportError(th, "apm_error");
                }
            });
        }
    }

    private void initDeviceInfo() {
        if (this.mEnabled) {
            try {
                initCpuInfo();
                initMemInfo();
                initStorageInfo();
            } catch (Throwable unused) {
            }
        }
    }

    private void initCpuInfo() {
        String str = ApmContext.getContext().getApplicationInfo().nativeLibraryDir;
        if (!TextUtils.isEmpty(str) && str.endsWith("arm64")) {
            this.mIsApp64Bit = true;
        }
        StringBuilder sb = new StringBuilder();
        if (Build.SUPPORTED_ABIS.length > 0) {
            for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                sb.append(Build.SUPPORTED_ABIS[i]);
                if (i != Build.SUPPORTED_ABIS.length - 1) {
                    sb.append(", ");
                }
            }
        } else {
            sb = new StringBuilder(Build.CPU_ABI);
        }
        String sb2 = sb.toString();
        if (sb2 != null && sb2.contains("64")) {
            this.mIsDevice64Bit = true;
        }
        initCpuModel();
    }

    private void initCpuModel() {
        SpManager spManager = SpManager.getInstance();
        String string = spManager.getString(CommonKey.KEY_SP_CPU_MODEL);
        int i = spManager.getInt(CommonKey.KEY_SP_CPU_CORE_NUM);
        if (!TextUtils.isEmpty(string)) {
            this.mCpuModel = string;
            this.mCpuCoreNum = i;
            return;
        }
        updateCpuModel();
        if (TextUtils.isEmpty(this.mCpuModel)) {
            this.mCpuModel = "unknown";
        }
        spManager.saveAsync(CommonKey.KEY_SP_CPU_MODEL, this.mCpuModel);
        spManager.saveAsync(CommonKey.KEY_SP_CPU_CORE_NUM, this.mCpuCoreNum);
    }

    private void updateCpuModel() {
        BufferedReader bufferedReader;
        Throwable th;
        int i;
        String str;
        BufferedReader bufferedReader2 = null;
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            i = 0;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split(":");
                        if (split.length == 2) {
                            if (split[0].startsWith("Hardware")) {
                                str2 = split[1].trim();
                            } else if (split[0].startsWith("processor")) {
                                i++;
                            }
                        }
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception unused2) {
                    str = str2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    str2 = str;
                    this.mCpuModel = str2;
                    this.mCpuCoreNum = i;
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            }
            bufferedReader.close();
        } catch (Exception unused5) {
            i = 0;
            str = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
        this.mCpuModel = str2;
        this.mCpuCoreNum = i;
        if (TextUtils.isEmpty(str2) || !RomUtils.isHwDevice()) {
            return;
        }
        this.mCpuModel = Build.HARDWARE;
    }

    private void initMemInfo() {
        ActivityManager activityManager = (ActivityManager) ApmContext.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        this.mPhysicMemSizeMega = (int) (memoryInfo.totalMem / BYTES_PER_MEGABYTE);
        this.mMallocImpl = JE_MALLOC;
    }

    private void updateMemInfo() {
        this.mNativeHeapSizeMega = Debug.getNativeHeapAllocatedSize() / 1048576;
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long freeMemory = runtime.freeMemory();
        long j = runtime.totalMemory();
        this.mJavaHeapSizeMaxMega = maxMemory / 1048576;
        long j2 = j - freeMemory;
        this.mJavaHeapSizeUsedMega = j2 / 1048576;
        this.mHasJavaHeapLeak = ((float) j2) > ((float) maxMemory) * 0.95f;
    }

    private void initStorageInfo() {
        String str;
        this.mIsJBAndAbove = true;
        StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        if (this.mIsJBAndAbove) {
            this.mSystemAvailableSize = statFs.getAvailableBytes();
            this.mSystemTotalSize = statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        } else {
            this.mSystemAvailableSize = statFs.getBlockSize() * statFs.getAvailableBlocks();
            this.mSystemTotalSize = statFs.getBlockSize() * statFs.getBlockCount();
        }
        this.mSystemAvailableRatio = getAvailableRatio(this.mSystemAvailableSize, this.mSystemTotalSize);
        try {
            StatFs statFs2 = new StatFs(ApmContext.getContext().getFilesDir().getAbsolutePath());
            if (this.mIsJBAndAbove) {
                this.mDataPartitionAvailableSize = statFs2.getAvailableBytes();
                this.mDataPartitionTotalSize = statFs2.getBlockSizeLong() * statFs2.getBlockCountLong();
            } else {
                this.mDataPartitionAvailableSize = statFs2.getBlockSize() * statFs2.getAvailableBlocks();
                this.mDataPartitionTotalSize = statFs2.getBlockSize() * statFs2.getBlockCount();
            }
            this.mDataPartitionAvailableRatio = getAvailableRatio(this.mDataPartitionAvailableSize, this.mDataPartitionTotalSize);
        } catch (Throwable unused) {
        }
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception unused2) {
            str = null;
        }
        boolean equals = TextUtils.equals(str, "mounted");
        this.mIsExternalStorageMounted = equals;
        try {
            if (equals) {
                StatFs statFs3 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
                if (this.mIsJBAndAbove) {
                    this.mSdcardAvailableSize = statFs3.getAvailableBytes();
                    this.mSdcardTotalSize = statFs3.getBlockSizeLong() * statFs3.getBlockCountLong();
                } else {
                    this.mSdcardAvailableSize = statFs3.getBlockSize() * statFs3.getAvailableBlocks();
                    this.mSdcardTotalSize = statFs3.getBlockSize() * statFs3.getBlockCount();
                }
                this.mSdcardAvailableRatio = getAvailableRatio(this.mSdcardAvailableSize, this.mSdcardTotalSize);
            } else {
                this.mSdcardTotalSize = 0L;
            }
        } catch (Throwable unused3) {
        }
        this.mIsExternalStorageRemovable = Environment.isExternalStorageRemovable();
    }

    private double getAvailableRatio(long j, long j2) {
        if (j2 == 0) {
            return 0.0d;
        }
        return Math.round((j / j2) * 100.0d) / 100.0d;
    }

    public void addCpuInfo(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !this.mEnabled) {
            return;
        }
        jSONObject.put(PerfConsts.PERF_KEY_IS_APP_64_BIT, this.mIsApp64Bit);
        jSONObject.put(PerfConsts.PERF_KEY_IS_DEVICE_64_BIT, this.mIsDevice64Bit);
        jSONObject.put(PerfConsts.PERF_KEY_CPU_MODEL, this.mCpuModel);
        int i = this.mCpuCoreNum;
        if (i > 0) {
            jSONObject.put(PerfConsts.PERF_KEY_CPU_CORE_NUM, i);
        }
    }

    public void addConstantMemInfo(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !this.mEnabled) {
            return;
        }
        jSONObject.put("apm_physical_mem", this.mPhysicMemSizeMega);
        jSONObject.put("apm_malloc_impl", this.mMallocImpl);
    }

    public void addRealTimeMemInfo(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !this.mEnabled) {
            return;
        }
        updateMemInfo();
        jSONObject.put("apm_native_heap_size", this.mNativeHeapSizeMega);
        jSONObject.put("apm_java_heap_leak", this.mHasJavaHeapLeak);
        jSONObject.put("apm_java_heap_used", this.mJavaHeapSizeUsedMega);
        jSONObject.put("apm_java_heap_max", this.mJavaHeapSizeMaxMega);
    }

    public void addStorageInfo(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !this.mEnabled) {
            return;
        }
        if (this.mSystemTotalSize != 0) {
            jSONObject.put(PerfConsts.PERF_KEY_SYSTEM_AVAILABLE_SIZE, this.mSystemAvailableSize / 1048576);
            jSONObject.put(PerfConsts.PERF_KEY_SYSTEM_AVAILABLE_RATIO, this.mSystemAvailableRatio);
        }
        if (this.mDataPartitionTotalSize != 0) {
            jSONObject.put(PerfConsts.PERF_KEY_DATA_AVAILABLE_SIZE, getSize(this.mDataPartitionAvailableSize));
            jSONObject.put(PerfConsts.PERF_KEY_DATA_AVAILABLE_RATIO, this.mDataPartitionAvailableRatio);
        }
        if (this.mSdcardTotalSize != 0) {
            jSONObject.put(PerfConsts.PERF_KEY_SDCARD_AVAILABLE_SIZE, getSize(this.mSdcardAvailableSize));
            jSONObject.put(PerfConsts.PERF_KEY_SDCARD_AVAILABLE_RATIO, this.mSdcardAvailableRatio);
        }
        if (this.mIsExternalStorageMounted) {
            jSONObject.put(PerfConsts.PERF_KEY_EXTERNAL_STORAGE_REMOVABLE, this.mIsExternalStorageRemovable);
        }
    }

    public void addRealTimeDeviceInfo(JSONObject jSONObject) {
        addRealTimeDeviceInfo(jSONObject, false);
    }

    public void addConstantDeviceInfo(JSONObject jSONObject) {
        addConstantDeviceInfo(jSONObject, false);
    }

    public void addRealTimeDeviceInfo(JSONObject jSONObject, boolean z) {
        if (this.mEnabled || z) {
            try {
                getInstance().addRealTimeMemInfo(jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    public void addConstantDeviceInfo(JSONObject jSONObject, boolean z) {
        if (this.mEnabled || z) {
            try {
                getInstance().addCpuInfo(jSONObject);
                getInstance().addConstantMemInfo(jSONObject);
                getInstance().addStorageInfo(jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    private long getSize(long j) {
        return j / 1073741824;
    }
}
