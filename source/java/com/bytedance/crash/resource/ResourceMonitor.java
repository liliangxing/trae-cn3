package com.bytedance.crash.resource;

import com.bytedance.bdturing.BdTuring;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.resource.fdtrack.FdTrackAdapter;
import com.bytedance.crash.resource.fdtrack.FdTrackConfig;
import com.bytedance.crash.resource.gwpasan.GwpAsanAdapter;
import com.bytedance.crash.resource.gwpasan.GwpAsanConfig;
import com.bytedance.crash.resource.heaptrack.NativeHeapTrackAdapter;
import com.bytedance.crash.resource.heaptrack.NativeHeapTrackerConfig;
import com.bytedance.crash.resource.refmonitor.RefMonitorAdapter;
import com.bytedance.crash.resource.refmonitor.RefMonitorConfig;
import com.bytedance.crash.resource.tlsmonitor.TLSMonitorAdapter;
import com.bytedance.crash.resource.tlsmonitor.TLSMonitorConfig;
import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.crash.resource.vmmonitor.VmMonitorAdapter;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NumRanges;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ResourceMonitor {
    private static final int BIT_MMAP = 0;
    private static final int BIT_MPROTECT = 1;
    protected static final String KEY_APP_32_OR_64 = "app_32_or_64";
    protected static final String KEY_ENABLE_GWP_ASAN = "enable_gwp_asan";
    protected static final String KEY_ENABLE_NATIVE_HEAP_TRACK = "enable_native_heap_track";
    protected static final String KEY_ENABLE_PRIO_MONITOR = "enable_setpriority_monitor";
    protected static final String KEY_ENABLE_REF_MONITOR = "enable_monitor_reference";
    protected static final String KEY_ENABLE_TLS_MONITOR = "enable_pthread_key_monitor";
    protected static final String KEY_ENABLE_VM_MONITOR_MMAP = "enable_mmap_monitor";
    protected static final String KEY_ENABLE_VM_MONITOR_MPROTECT = "enable_mprotect_monitor";
    protected static final String KEY_FD_TRACK_ALLOW_LOOP_MONITOR = "allow_loop_monitor";
    protected static final String KEY_FD_TRACK_BT_LIMIT = "backtrace_limit";
    protected static final String KEY_FD_TRACK_DUMP_LINE = "track_dump_line";
    protected static final String KEY_FD_TRACK_ENABLE = "enable_fd_track";
    protected static final String KEY_FD_TRACK_SLEEP_TIME = "track_sleep_time";
    protected static final String KEY_FD_TRACK_WATER_LINE = "track_water_line";
    protected static final String KEY_GWP_ASAN_CONFIG = "gwp_asan_set_init_param";
    protected static final String KEY_HEAP_TRACK_PARAMS = "native_heap_params";
    protected static final String KEY_MPROTECT_PROTS = "mprotect_monitor_prots";
    protected static final String KEY_PRIO_POLICY_CONFIG = "priority_policy_config";
    protected static final String KEY_REF_MONITOR_BT_FLAG = "ref_monitor_bt_flag";
    protected static final String KEY_REF_MONITOR_LIMITS = "ref_monitor_limits";
    protected static final String KEY_REF_MONITOR_TYPE = "ref_monitor_type";
    protected static final String KEY_VMM_PHY_CONFIG = "mmap_phy_config";
    protected static final String KEY_VM_MONITOR_LINE = "mmap_water_config";
    protected static final String KEY_VM_MONITOR_PARAMS = "mmap_monitor_params";
    protected static boolean mFdTrackerEnabled;
    protected static boolean mIsGwpAsanEnabled;
    protected static boolean mIsHeapTrackerEnabled;
    protected static boolean mIsVmmEnabled;
    protected FdTrackConfig mFdTrackConfig;
    protected GwpAsanConfig mGwpAsanConfig;
    protected NativeHeapTrackerConfig mNativeHeapTrackerConfig;
    protected RefMonitorConfig mRefMonitorConfig;
    protected TLSMonitorConfig mTLSMonitorConfig;
    protected VmMonitorConfig mVmMonitorConfig;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class ResourceMonitorHolder {
        public static final ResourceMonitor instance = new ResourceMonitor();

        private ResourceMonitorHolder() {
        }
    }

    public static void upload(AppMonitor appMonitor) {
        GwpAsanAdapter.upload(appMonitor);
        NativeHeapTrackAdapter.upload(appMonitor);
        VmMonitorAdapter.upload(appMonitor);
        FdTrackAdapter.upload(appMonitor);
        RefMonitorAdapter.upload(appMonitor);
    }

    public static void deleteCrashLog() {
        try {
            FileUtils.deleteFile(LogPath.getVmMonitorPath());
            FileUtils.deleteFile(LogPath.getGwpAsanLogPath());
            FileUtils.deleteFile(LogPath.getFdTrackPath());
            FileUtils.deleteFile(LogPath.getNativeHeapTrackerPath());
            FileUtils.deleteFile(LogPath.getRefMonitorPath());
            FileUtils.deleteFile(LogPath.getTLSMonitorPath());
            FileUtils.deleteFile(LogPath.getPriorityMonitorPath());
        } catch (Throwable unused) {
        }
    }

    public static void updateConfig(JSONObject jSONObject, JSONObject jSONObject2) {
        ResourceMonitorHolder.instance.doUpdateConfig(jSONObject, jSONObject2);
    }

    public void doUpdateConfig(JSONObject jSONObject, JSONObject jSONObject2) {
        boolean z = jSONObject.optInt(KEY_ENABLE_NATIVE_HEAP_TRACK) == 1;
        boolean z2 = jSONObject.optInt(KEY_APP_32_OR_64) == 1;
        boolean z3 = jSONObject.optInt(KEY_ENABLE_GWP_ASAN) == 1;
        boolean z4 = jSONObject.optInt(KEY_ENABLE_VM_MONITOR_MMAP) == 1;
        boolean z5 = jSONObject.optInt(KEY_ENABLE_VM_MONITOR_MPROTECT) == 1;
        boolean z6 = jSONObject.optInt(KEY_ENABLE_REF_MONITOR) == 1;
        boolean z7 = jSONObject2.optInt(KEY_FD_TRACK_ENABLE) == 1;
        boolean z8 = jSONObject.optInt(KEY_ENABLE_TLS_MONITOR) == 1;
        boolean z9 = z4 || z5;
        if (z8) {
            enableTlsKeyMonitor();
        }
        if (z && !mFdTrackerEnabled && !mIsGwpAsanEnabled && !mIsVmmEnabled) {
            mIsHeapTrackerEnabled = true;
            if (NativeBridge.is64BitRuntime() == z2) {
                parseHeapTrackerConfig(jSONObject);
            }
        }
        if (z3 && !mIsHeapTrackerEnabled && !mIsVmmEnabled && !z9) {
            mIsGwpAsanEnabled = true;
            parseGWPAsanConfig(jSONObject);
        }
        if (z9 && !mIsHeapTrackerEnabled && !mIsGwpAsanEnabled && !mFdTrackerEnabled) {
            mIsVmmEnabled = true;
            parseVmMonitorConfig(z4, z5, jSONObject);
        }
        if (z7 && !mIsHeapTrackerEnabled && !mIsVmmEnabled) {
            mFdTrackerEnabled = true;
            parseFdTrackConfig(jSONObject2);
        }
        if ((!mIsVmmEnabled || mIsHeapTrackerEnabled || mIsGwpAsanEnabled) && z6) {
            parseRefMonitorConfig(jSONObject);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r7 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseVmMonitorConfig(boolean z, boolean z2, JSONObject jSONObject) {
        boolean z3;
        if (z2) {
            z3 = (z ? 1 : 0) | 2;
        }
        VmMonitorConfig vmMonitorConfig = new VmMonitorConfig(z3, jSONObject.optJSONArray(KEY_VM_MONITOR_LINE), jSONObject.optJSONArray(KEY_VM_MONITOR_PARAMS), jSONObject.optJSONArray(KEY_MPROTECT_PROTS), jSONObject.optJSONArray(KEY_VMM_PHY_CONFIG));
        this.mVmMonitorConfig = vmMonitorConfig;
        VmMonitorAdapter.updateConfig(vmMonitorConfig);
    }

    private void parseFdTrackConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        FdTrackConfig fdTrackConfig = new FdTrackConfig(true, jSONObject.optInt(KEY_FD_TRACK_ALLOW_LOOP_MONITOR) == 1, jSONObject.optInt(KEY_FD_TRACK_WATER_LINE), jSONObject.optInt(KEY_FD_TRACK_DUMP_LINE), jSONObject.optInt(KEY_FD_TRACK_SLEEP_TIME), jSONObject.optInt(KEY_FD_TRACK_BT_LIMIT));
        this.mFdTrackConfig = fdTrackConfig;
        FdTrackAdapter.updateConfig(fdTrackConfig);
    }

    private void parseRefMonitorConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt(KEY_REF_MONITOR_TYPE);
        int optInt2 = jSONObject.optInt(KEY_REF_MONITOR_BT_FLAG);
        JSONArray optJSONArray = jSONObject.optJSONArray(KEY_REF_MONITOR_LIMITS);
        if (optJSONArray == null || optJSONArray.length() < 3) {
            optJSONArray = new JSONArray();
            optJSONArray.put(BdTuring.VERIFY_FAIL_IDENTITY_VERIFY);
            optJSONArray.put(BdTuring.VERIFY_FAIL_IDENTITY_VERIFY);
            optJSONArray.put(500);
        }
        RefMonitorConfig refMonitorConfig = new RefMonitorConfig(optInt, optJSONArray, optInt2);
        this.mRefMonitorConfig = refMonitorConfig;
        RefMonitorAdapter.updateConfig(refMonitorConfig);
    }

    private void parseGWPAsanConfig(JSONObject jSONObject) {
        GwpAsanConfig gwpAsanConfig = new GwpAsanConfig(jSONObject.optJSONArray(KEY_GWP_ASAN_CONFIG));
        this.mGwpAsanConfig = gwpAsanConfig;
        GwpAsanAdapter.updateConfig(gwpAsanConfig);
    }

    protected void enableTlsKeyMonitor() {
        TLSMonitorConfig tLSMonitorConfig = new TLSMonitorConfig();
        this.mTLSMonitorConfig = tLSMonitorConfig;
        TLSMonitorAdapter.updateConfig(tLSMonitorConfig);
    }

    public FdTrackConfig getFdTrackConfig() {
        return this.mFdTrackConfig;
    }

    public RefMonitorConfig getRefMonitorConfig() {
        return this.mRefMonitorConfig;
    }

    public VmMonitorConfig getVmMonitorConfig() {
        return this.mVmMonitorConfig;
    }

    public GwpAsanConfig getGwpAsanConfig() {
        return this.mGwpAsanConfig;
    }

    private void parseHeapTrackerConfig(JSONObject jSONObject) {
        NativeHeapTrackerConfig nativeHeapTrackerConfig = new NativeHeapTrackerConfig(jSONObject.optJSONArray(KEY_HEAP_TRACK_PARAMS));
        this.mNativeHeapTrackerConfig = nativeHeapTrackerConfig;
        NativeHeapTrackAdapter.updateConfig(nativeHeapTrackerConfig);
    }

    public static boolean appendResourceMonitorTags(JSONObject jSONObject, File file) {
        return parseTagInfoForCrash(jSONObject, new File(file, "ht_leak_tags.txt"));
    }

    protected static boolean parseTagInfoForCrash(JSONObject jSONObject, File file) {
        if (!file.exists()) {
            return false;
        }
        try {
            NumRanges numRanges = new NumRanges("MB");
            numRanges.set(new Long[]{0L, 1L, 128L, 256L, 384L, 512L, 768L, 1024L});
            for (String str : FileUtils.readFile(file.getAbsolutePath()).split("\n")) {
                if (str != null && !str.trim().isEmpty()) {
                    String[] split = str.split(":");
                    if (split.length == 2) {
                        String trim = split[1].trim();
                        try {
                            trim = numRanges.get(Long.parseLong(trim));
                        } catch (NumberFormatException unused) {
                        }
                        jSONObject.put(split[0].trim(), trim);
                    }
                }
            }
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static void appendResourceMonitorData(JSONObject jSONObject, File file) {
        JSONUtils.put(jSONObject, "leak_so_list", NativeHeapTrackAdapter.HeapTrackerUploader.getSoListFromFile(new File(file, "ht_so_list.txt")));
    }
}
