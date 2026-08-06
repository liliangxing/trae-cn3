package com.bytedance.crash.resource.vmmonitor;

import android.os.SystemClock;
import com.bytedance.crash.Global;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.resource.ResourceMonitorAdapter;
import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class VmMonitorAdapter extends ResourceMonitorAdapter {
    public static final int CMD_DUMP = 5;
    public static final int CMD_GET_LEAK_SIZE = 6;
    public static final int CMD_GET_RSS_SIZE = 8;
    public static final int CMD_GET_VM_SIZE = 7;
    public static final int CMD_HOOK = 1;
    public static final int CMD_RECOVER = 0;
    public static final int CMD_START_MONITOR = 3;
    public static final int CMD_STOP_MONITOR = 4;
    public static final int CMD_UNHOOK = 2;
    public static final int CRASH_DUMP = 0;
    public static final int MODE_1_STATE_EXIT = 4;
    public static final int MODE_1_STATE_MONITOR = 2;
    public static final int MODE_1_STATE_OBSERVE = 1;
    public static final int MODE_1_STATE_PREPARE = 0;
    public static final int MODE_1_STATE_RECOVERED = 5;
    public static final int MODE_1_STATE_WAIT = 3;
    public static final int MONITOR_MMAP = 0;
    public static final int MONITOR_MPROTECT = 1;
    public static final int RECOVER_ALL = 1;
    public static final int RECOVER_PARTIAL = 0;
    public static final int RET_OK = 0;
    public static final long SIZE_K = 1024;
    public static final int STATE_NATIVE_ERROR = -1;
    private static final String TAG = "VmMonitor: ";
    private static VmMonitorAdapter mInstance = null;
    private static long minRssKB = 512000;
    private static MonitorState mmapState = null;
    private static MonitorState mprotectState = null;
    private static long originVmSize = 819200;
    protected VmMonitorConfig mConfig;
    private int mMonitorType;

    private static String getCommandString(int i) {
        return i != 0 ? i != 1 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? i != 7 ? "unknown command" : "get_vm_size" : "get_leak_size" : "dump" : "stop_monitor" : "start_monitor" : "hook" : "recover";
    }

    static /* synthetic */ long access$300() {
        return getRssSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class MonitorState {
        int monitorType;
        boolean hasInit = false;
        boolean hookState = false;
        boolean unHookState = true;
        boolean isRunning = false;
        int nativeState = 0;

        public MonitorState(int i) {
            this.monitorType = i;
        }
    }

    public static VmMonitorAdapter get() {
        if (mInstance == null) {
            synchronized (VmMonitorAdapter.class) {
                if (mInstance == null) {
                    mInstance = new VmMonitorAdapter();
                }
            }
        }
        return mInstance;
    }

    public static void updateConfig(VmMonitorConfig vmMonitorConfig) {
        VmMonitorAdapter vmMonitorAdapter = get();
        vmMonitorAdapter.mConfig = vmMonitorConfig;
        vmMonitorAdapter.startMonitor(vmMonitorConfig);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    protected void executeMonitor() {
        mmapState = new MonitorState(1);
        mprotectState = new MonitorState(2);
        if ((this.mConfig.mMonitorType & 1) != 0) {
            originVmSize = getVmSize();
            executeVmMonitor();
        }
        if ((this.mConfig.mMonitorType & 2) != 0) {
            startMonitorNative(1);
        }
    }

    public void stopMprotectMonitor() {
        unHook(1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.crash.resource.vmmonitor.VmMonitorAdapter$1] */
    private void executeVmMonitor() {
        if (checkStateAndHook(0)) {
            if (mmapState.isRunning) {
                NpthLog.m227d("VmMonitor: execute water line mode Already running");
                return;
            }
            mmapState.isRunning = true;
            mmapState.nativeState = 0;
            new Thread("mmapWaterLineModeMonitor") { // from class: com.bytedance.crash.resource.vmmonitor.VmMonitorAdapter.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    long waterLineKB;
                    long j = VmMonitorAdapter.this.mConfig.mSleepTime;
                    while (true) {
                        int i = VmMonitorAdapter.mmapState.nativeState;
                        if (i == 0) {
                            VmMonitorAdapter.mmapState.nativeState = 1;
                        } else if (i == 1) {
                            long waterSize = VmMonitorAdapter.getWaterSize(VmMonitorAdapter.this.mConfig.mEnablePhyMode);
                            NpthLog.m227d("VmMonitor: growSize: " + waterSize + ", originVmSize: " + VmMonitorAdapter.originVmSize + ", mwaterLine: " + VmMonitorAdapter.this.mConfig.getWaterLineKB());
                            if (waterSize >= VmMonitorAdapter.this.mConfig.getWaterLineKB()) {
                                VmMonitorAdapter.mmapState.nativeState = 2;
                                if (VmMonitorAdapter.this.mConfig.mEnablePhyMode) {
                                    long unused = VmMonitorAdapter.minRssKB = VmMonitorAdapter.access$300();
                                }
                                VmMonitorAdapter.this.startMonitorNative(0);
                            } else {
                                if (waterSize > VmMonitorAdapter.this.mConfig.getWaterLineKB() / 4) {
                                    if (waterSize != 0) {
                                        waterLineKB = VmMonitorAdapter.this.mConfig.getWaterLineKB() / waterSize;
                                        j *= waterLineKB;
                                    }
                                }
                                j *= 4;
                            }
                        } else if (i == 2) {
                            long leakSize = VmMonitorAdapter.getLeakSize(VmMonitorAdapter.this.mConfig.mEnablePhyMode);
                            NpthLog.m227d("VmMonitor: leakSize: " + leakSize + ", dumpleaksize: " + VmMonitorAdapter.this.mConfig.getDumpSizeKB());
                            if (leakSize >= (VmMonitorAdapter.this.mConfig.getDumpSizeKB() * 5) / 4) {
                                VmMonitorAdapter.mmapState.nativeState = 3;
                                VmMonitorAdapter.this.stopMonitorNative(0);
                            } else {
                                if (leakSize >= VmMonitorAdapter.this.mConfig.getDumpSizeKB() / 4) {
                                    if (leakSize != 0) {
                                        waterLineKB = VmMonitorAdapter.this.mConfig.getDumpSizeKB() / leakSize;
                                        j *= waterLineKB;
                                    }
                                }
                                j *= 4;
                            }
                        } else if (i == 3) {
                            if (VmMonitorAdapter.getLeakSize(VmMonitorAdapter.this.mConfig.mEnablePhyMode) < VmMonitorAdapter.this.mConfig.getDumpSizeKB()) {
                                VmMonitorAdapter.mmapState.nativeState = 2;
                                VmMonitorAdapter.this.startMonitorNative(0);
                            } else {
                                VmMonitorAdapter.mmapState.nativeState = 4;
                                VmMonitorAdapter.this.unHook(0);
                                VmMonitorAdapter.this.dumpNative(0);
                            }
                        }
                        if (VmMonitorAdapter.mmapState.nativeState == -1 || VmMonitorAdapter.mmapState.nativeState == 4 || VmMonitorAdapter.mmapState.nativeState == 5) {
                            break;
                        }
                        try {
                            j = Math.max(j, VmMonitorAdapter.this.mConfig.mSleepTime);
                            if (VmMonitorAdapter.this.mConfig.mDebug) {
                                j = 1000;
                            }
                            SystemClock.sleep(j);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    VmMonitorAdapter.this.mGuardFile.createGuardFile();
                    NpthLog.m234i(VmMonitorAdapter.TAG, "Thread exit!");
                    VmMonitorAdapter.mmapState.isRunning = false;
                }
            }.start();
        }
    }

    private static MonitorState getState(int i) {
        return i == 0 ? mmapState : mprotectState;
    }

    private void setState(int i) {
        getState(i).isRunning = false;
    }

    private boolean checkState(MonitorState monitorState) {
        return (monitorState == null || monitorState.nativeState == 4 || monitorState.nativeState == -1 || monitorState.nativeState == 5) ? false : true;
    }

    private boolean checkStateAndHook(int i) {
        MonitorState state = getState(i);
        if (!checkState(state)) {
            return false;
        }
        if (!state.hookState && state.unHookState) {
            startHook(i);
        }
        return state.hookState;
    }

    private static void setErrorState(int i, int i2, int i3) {
        if (i3 != 0) {
            getState(i).nativeState = -1;
            NpthLog.m227d(TAG + getCommandString(i2) + ": " + i3);
        }
    }

    public int doDumpNativeForce(String str) {
        if (str == null) {
            return -1;
        }
        return NativeResourceMonitor.vmMonitorDumpNative(this.mConfig.mMonitorType, 0, str);
    }

    private static long getAndRefreshRss() {
        long rssSize = getRssSize();
        if (rssSize < minRssKB) {
            minRssKB = rssSize;
        }
        return rssSize;
    }

    public static long getWaterSize(boolean z) {
        long vmSize;
        long j;
        if (z) {
            vmSize = getAndRefreshRss();
            j = minRssKB;
        } else {
            vmSize = getVmSize();
            j = originVmSize;
        }
        return vmSize - j;
    }

    public static long getVmSize() {
        return Math.max(0, NativeResourceMonitor.vmMonitorDoCommand(7, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getLeakSize(boolean z) {
        if (z) {
            return getAndRefreshRss() - minRssKB;
        }
        return getVmLeakSize();
    }

    private static long getVmLeakSize() {
        MonitorState monitorState;
        if (NativeResourceMonitor.vmMonitorDoCommand(6, 0) < 0 && (monitorState = mmapState) != null) {
            monitorState.nativeState = -1;
        }
        return Math.max(0, r0);
    }

    private static long getRssSize() {
        MonitorState monitorState;
        if (NativeResourceMonitor.vmMonitorDoCommand(8, 0) < 0 && (monitorState = mmapState) != null) {
            monitorState.nativeState = -1;
        }
        return Math.max(0, r0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void recoverNative(int i) {
        NpthLog.m227d("VmMonitor: recover");
        if (i == 1) {
            mmapState.nativeState = 5;
        }
        setErrorState(0, 0, NativeResourceMonitor.vmMonitorDoCommand(0, i));
    }

    private void startHook(int i) {
        NpthLog.m227d("VmMonitor: start hook: " + i);
        MonitorState monitorState = i == 0 ? mmapState : mprotectState;
        if (monitorState.hookState) {
            return;
        }
        int vmMonitorDoCommand = NativeResourceMonitor.vmMonitorDoCommand(1, i);
        monitorState.hookState = vmMonitorDoCommand == 0;
        monitorState.unHookState = false;
        setErrorState(i, 1, vmMonitorDoCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unHook(int i) {
        NpthLog.m227d("VmMonitor: exit hook");
        MonitorState monitorState = i == 0 ? mmapState : mprotectState;
        if (monitorState.hookState) {
            int vmMonitorDoCommand = NativeResourceMonitor.vmMonitorDoCommand(2, i);
            monitorState.unHookState = vmMonitorDoCommand == 0;
            monitorState.hookState = true ^ monitorState.unHookState;
            setErrorState(i, 2, vmMonitorDoCommand);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMonitorNative(int i) {
        NpthLog.m227d("VmMonitor: start monitor native");
        if (checkStateAndHook(i)) {
            setErrorState(i, 3, NativeResourceMonitor.vmMonitorDoCommand(3, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopMonitorNative(int i) {
        NpthLog.m227d("VmMonitor: stop monitor native");
        setErrorState(i, 4, NativeResourceMonitor.vmMonitorDoCommand(4, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dumpNative(int i) {
        NativeResourceMonitor.vmMonitorDumpMaps(this.mLogDir);
        NativeResourceMonitor.vmMonitorDoCommand(5, 1);
        int vmMonitorDoCommand = NativeResourceMonitor.vmMonitorDoCommand(5, i);
        setErrorState(i, 5, vmMonitorDoCommand);
        if (vmMonitorDoCommand != 0) {
            return;
        }
        DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.resource.vmmonitor.VmMonitorAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                VmMonitorAdapter.recoverNative(1);
            }
        }, 60000L);
        setState(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class VmMonitorUploader extends ResourceMonitorAdapter.ResourceMonitorUploader {
        public VmMonitorUploader(AppMonitor appMonitor, File file) {
            super(appMonitor, file);
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        protected boolean parseReport(File file, ResourceMonitorAdapter.UploaderData uploaderData) {
            File file2 = new File(file, "tombstone.txt");
            File file3 = new File(file, "javastack.txt");
            if (!file2.exists()) {
                return false;
            }
            try {
                if (file3.exists()) {
                    uploaderData.mJavaStack = FileUtils.readFile(file3.getAbsolutePath());
                }
                JSONArray readFileArray = FileUtils.readFileArray(file2.getAbsolutePath());
                if (readFileArray == null) {
                    NpthLog.m234i(VmMonitorAdapter.TAG, "stack content is null");
                    return false;
                }
                int lineIndex = getLineIndex(readFileArray, 0, "pid:");
                if (lineIndex >= 0) {
                    String[] split = readFileArray.optString(lineIndex, null).trim().split("\\s");
                    int i = 0;
                    while (true) {
                        if (i >= split.length) {
                            break;
                        }
                        if ("name:".equals(split[i])) {
                            uploaderData.mThreadName = split[i + 1];
                            break;
                        }
                        i++;
                    }
                }
                StringBuilder sb = new StringBuilder();
                int lineIndex2 = getLineIndex(readFileArray, lineIndex + 1, "Signal ");
                if (lineIndex2 >= 0) {
                    sb.append(readFileArray.optString(lineIndex2, null)).append('\n');
                }
                int lineIndex3 = getLineIndex(readFileArray, lineIndex2 + 1, "Abort message:");
                if (lineIndex3 >= 0) {
                    uploaderData.mAbortLine = readFileArray.optString(lineIndex3, null).replace("Abort message:", "abort message:");
                    sb.append(uploaderData.mAbortLine).append('\n');
                    if (uploaderData.mAbortLine.startsWith("abort message:")) {
                        try {
                            Matcher matcher = Pattern.compile("^.*:\\s+(\\S+):.*,.*,.*:\\s+(\\S+)\\(.*:(\\S+)\\s+(\\S+)\\).*$").matcher(uploaderData.mAbortLine);
                            if (matcher.find()) {
                                uploaderData.filterData.put("mmap_leak_lib", matcher.group(1));
                                uploaderData.filterData.put("mmap_leak_reason", matcher.group(2));
                                uploaderData.filterData.put("mmap_leak_size", getSizeRange(matcher.group(3), matcher.group(4)));
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                int lineIndex4 = getLineIndex(readFileArray, lineIndex3 + 1, "backtrace:");
                if (lineIndex4 >= 0) {
                    for (int i2 = lineIndex4 + 1; i2 < readFileArray.length(); i2++) {
                        String optString = readFileArray.optString(i2, null);
                        if (!optString.startsWith("    #")) {
                            break;
                        }
                        sb.append(optString.trim()).append('\n');
                    }
                    uploaderData.mNativeStack = sb.toString();
                }
                return true;
            } catch (Throwable unused2) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public void packFilterData(Map<String, String> map, ResourceMonitorAdapter.UploaderData uploaderData) {
            super.packFilterData(map, uploaderData);
            map.put("mmap_monitor", "true");
            map.put("has_mmap_leak", "true");
            map.put("is_root", GeneralInfoManager.isRoot() ? "true" : "false");
            map.put("mmap_leak_app", Global.getContext().getPackageName());
        }
    }

    public static void upload(AppMonitor appMonitor) {
        try {
            new VmMonitorUploader(appMonitor, LogPath.getVmMonitorPath()).uploadAll();
        } catch (Throwable th) {
            NpthLog.m229e(TAG, "upload exception:" + th);
        }
    }
}
