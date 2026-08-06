package com.bytedance.crash.resource.heaptrack;

import android.os.SystemClock;
import com.bytedance.crash.Global;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.resource.ResourceMonitorAdapter;
import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.crash.tracker.ProcessTracker;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.IoUtil;
import com.bytedance.crash.util.NpthLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NativeHeapTrackAdapter extends ResourceMonitorAdapter {
    private static final String ALLOCATOR_TYPE = "ht_allocator_type";
    private static final int CMD_DUMP = 3;
    private static final int CMD_EXIT = 4;
    private static final int CMD_INIT = 0;
    private static final int CMD_STOP = 5;
    private static final int CMD_TRACK = 1;
    private static final int CMD_WAIT = 2;
    private static final String HAS_NATIVE_OOM = "has_native_oom";
    public static final String HAS_PROCESS_TRACK = "has_process_track";
    public static final String LOG_TAG = "NativeHeapTracker: ";
    private static final String NATIVE_OOM_APP = "native_oom_app";
    private static final String NATIVE_OOM_LIB = "native_oom_lib";
    private static final String NATIVE_OOM_MEM = "native_oom_mem";
    private static final String NATIVE_OOM_SIZE = "native_oom_size";
    private static final String NATIVE_OOM_THREAD = "native_oom_thread";
    private static final String NATIVE_OOM_THREAD_MEM = "native_oom_thread_mem";
    private static final String NATIVE_OOM_THREAD_SIZE = "native_oom_thread_size";
    private static final String NATIVE_SIG_CODE = "native_oom_sigcode";
    private static final int RET_OK = 0;
    private static final int STATE_EXIT = 6;
    private static final int STATE_INIT = 0;
    private static final int STATE_OBSERV = 2;
    private static final int STATE_PREPARE = 1;
    private static final int STATE_TRACING = 5;
    private static final int STATE_TRACK = 3;
    private static final int STATE_WAIT = 4;
    private static final String mHeapLocalTestConfig = "1#30#180#false#false#2#1#";
    private static NativeHeapTrackAdapter mInstance;
    private NativeHeapTrackerConfig mConfig;
    private boolean mNativeError;
    private int mNativeState;
    private boolean sIsRunning = false;
    private boolean mNeedDumpMemInfo = false;
    private boolean mDebug = true;

    public static NativeHeapTrackAdapter get() {
        if (mInstance == null) {
            synchronized (NativeHeapTrackAdapter.class) {
                if (mInstance == null) {
                    mInstance = new NativeHeapTrackAdapter();
                }
            }
        }
        return mInstance;
    }

    public static void updateConfig(NativeHeapTrackerConfig nativeHeapTrackerConfig) {
        NativeHeapTrackAdapter nativeHeapTrackAdapter = get();
        nativeHeapTrackAdapter.mConfig = nativeHeapTrackerConfig;
        nativeHeapTrackAdapter.startMonitor(nativeHeapTrackerConfig);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    protected boolean initBeforeSoLoad() {
        this.mNativeState = 0;
        this.mNativeError = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getStateMsg() {
        switch (this.mNativeState) {
            case 0:
                return "[STATE_INIT]";
            case 1:
                return "[STATE_PREPARE]";
            case 2:
                return "[STATE_OBSERV]";
            case 3:
                return "[STATE_TRACK]";
            case 4:
                return "[STATE_WAIT]";
            case 5:
                return "[STATE_TRACING]";
            case 6:
                return "[STATE_EXIT]";
            default:
                return "[STATE_UNKNOWN]";
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.crash.resource.heaptrack.NativeHeapTrackAdapter$1] */
    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    protected void executeMonitor() {
        if (this.sIsRunning) {
            NpthLog.m234i(LOG_TAG, "execute() Already running!");
            return;
        }
        if (this.mNativeState != 0) {
            NpthLog.m229e(LOG_TAG, "execute() Invalide state " + getStateMsg());
            return;
        }
        this.sIsRunning = true;
        if (initNative() != 0) {
            return;
        }
        this.mNativeState = 1;
        if (this.mNeedDumpMemInfo) {
            NativeResourceMonitor.nativeNeedDumpMemInfo(1);
        }
        new Thread("NativeHeapTracker") { // from class: com.bytedance.crash.resource.heaptrack.NativeHeapTrackAdapter.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                int i;
                int i2 = 10;
                while (true) {
                    int i3 = 0;
                    if (NativeHeapTrackAdapter.this.mNativeState == 6 || NativeHeapTrackAdapter.this.mNativeError) {
                        break;
                    }
                    int i4 = NativeHeapTrackAdapter.this.mConfig.mPollSeconds;
                    if (NativeHeapTrackAdapter.this.mDebug) {
                        NpthLog.m234i(NativeHeapTrackAdapter.LOG_TAG, NativeHeapTrackAdapter.this.getStateMsg() + "Thread running ...");
                    }
                    int i5 = NativeHeapTrackAdapter.this.mNativeState;
                    if (i5 == 1) {
                        int nativeGetHeapSize = (int) (NativeResourceMonitor.nativeGetHeapSize() / 1048576);
                        if (nativeGetHeapSize >= NativeHeapTrackAdapter.this.mConfig.mWaterLineMB) {
                            NativeHeapTrackAdapter.this.trackNative();
                            NativeHeapTrackAdapter.this.mNativeState = 2;
                        } else if (nativeGetHeapSize <= NativeHeapTrackAdapter.this.mConfig.mWaterLineMB / 4) {
                            i = NativeHeapTrackAdapter.this.mConfig.mPollSeconds;
                            i3 = i * 4;
                        } else if (nativeGetHeapSize != 0) {
                            i3 = (NativeHeapTrackAdapter.this.mConfig.mPollSeconds * NativeHeapTrackAdapter.this.mConfig.mWaterLineMB) / nativeGetHeapSize;
                        }
                        i3 = i4;
                    } else if (i5 == 2) {
                        NativeHeapTrackAdapter.this.mNativeState = 3;
                    } else if (i5 == 3) {
                        int nativeGetHeapLeakSize = (int) (NativeResourceMonitor.nativeGetHeapLeakSize() / 1048576);
                        if (NativeHeapTrackAdapter.this.mDebug) {
                            NpthLog.m234i(NativeHeapTrackAdapter.LOG_TAG, "Tracking leak " + nativeGetHeapLeakSize + " MB");
                        }
                        if (nativeGetHeapLeakSize >= (NativeHeapTrackAdapter.this.mConfig.mCollectSizeMB * 5) / 4) {
                            NativeHeapTrackAdapter.this.waitNative();
                            NativeHeapTrackAdapter.this.mNativeState = 4;
                        } else if (nativeGetHeapLeakSize < NativeHeapTrackAdapter.this.mConfig.mCollectSizeMB / 4) {
                            i = NativeHeapTrackAdapter.this.mConfig.mPollSeconds;
                            i3 = i * 4;
                        } else if (nativeGetHeapLeakSize != 0) {
                            i3 = (NativeHeapTrackAdapter.this.mConfig.mPollSeconds * NativeHeapTrackAdapter.this.mConfig.mCollectSizeMB) / nativeGetHeapLeakSize;
                        }
                        i3 = i4;
                    } else if (i5 != 4) {
                        if (i5 == 5) {
                            if (i2 == 0 || NativeHeapTrackAdapter.this.shouldStopNative()) {
                                NativeHeapTrackAdapter.this.mNativeState = 6;
                            } else {
                                i3 = i4;
                            }
                            i2--;
                        }
                        i3 = i4;
                    } else if (((int) (NativeResourceMonitor.nativeGetHeapLeakSize() / 65536)) < NativeHeapTrackAdapter.this.mConfig.mCollectSizeMB) {
                        NativeHeapTrackAdapter.this.trackNative();
                        NativeHeapTrackAdapter.this.mNativeState = 3;
                        i3 = i4;
                    } else {
                        NativeHeapTrackAdapter.this.dumpNative();
                        NativeHeapTrackAdapter.this.mNativeState = 5;
                        i3 = 30;
                    }
                    if (i3 > 0) {
                        if (NativeHeapTrackAdapter.this.mDebug) {
                            NpthLog.m234i(NativeHeapTrackAdapter.LOG_TAG, NativeHeapTrackAdapter.this.getStateMsg() + "Thread sleeping " + i3 + " seconds ...");
                        }
                        SystemClock.sleep(i3 * 1000);
                    }
                }
                NativeHeapTrackAdapter.this.sIsRunning = false;
                NativeHeapTrackAdapter.this.exitNative();
                NativeHeapTrackAdapter.this.mGuardFile.createGuardFile();
                NpthLog.m234i(NativeHeapTrackAdapter.LOG_TAG, NativeHeapTrackAdapter.this.getStateMsg() + "Thread exit!");
            }
        }.start();
    }

    private int initNative() {
        if (this.mDebug) {
            NpthLog.m234i(LOG_TAG, "initNative");
        }
        int nativeDoCommnad = NativeResourceMonitor.nativeDoCommnad(0);
        if (nativeDoCommnad != 0) {
            NpthLog.m234i(LOG_TAG, "initNative failed ret:" + nativeDoCommnad);
        }
        return nativeDoCommnad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackNative() {
        if (this.mDebug) {
            NpthLog.m234i(LOG_TAG, "trackNative");
        }
        int nativeDoCommnad = NativeResourceMonitor.nativeDoCommnad(1);
        if (nativeDoCommnad != 0) {
            NpthLog.m234i(LOG_TAG, "trackNative ret=" + nativeDoCommnad);
            this.mNativeError = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitNative() {
        if (this.mDebug) {
            NpthLog.m234i(LOG_TAG, "waitNative");
        }
        int nativeDoCommnad = NativeResourceMonitor.nativeDoCommnad(2);
        if (nativeDoCommnad != 0) {
            NpthLog.m234i(LOG_TAG, "waitNative ret=" + nativeDoCommnad);
            this.mNativeError = true;
        }
    }

    public void dumpNative() {
        if (this.mDebug) {
            NpthLog.m234i(LOG_TAG, "dumpNative");
        }
        int nativeDoCommnad = NativeResourceMonitor.nativeDoCommnad(3);
        if (nativeDoCommnad != 0) {
            NpthLog.m234i(LOG_TAG, "dumpNative ret=" + nativeDoCommnad);
            this.mNativeError = true;
        } else {
            NativeResourceMonitor.dumpNativeInfoThreads(this.mLogDir);
            dumpActivityInfo(this.mLogDir);
        }
    }

    private static void dumpActivityInfo(String str) {
        try {
            File currentFile = ProcessTracker.getInstance().getCurrentFile();
            if (currentFile == null || !currentFile.exists() || currentFile.length() <= 128) {
                return;
            }
            FileUtils.copyAppend(currentFile, new File(str, "process_track.txt"));
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("dumpActivityInfo", th);
        }
    }

    public boolean shouldStopNative() {
        if (this.mDebug) {
            NpthLog.m234i(LOG_TAG, "trying stopNative");
        }
        int nativeDoCommnad = NativeResourceMonitor.nativeDoCommnad(5);
        if (nativeDoCommnad != 0) {
            NpthLog.m234i(LOG_TAG, "stopNative ret =" + nativeDoCommnad);
        }
        return nativeDoCommnad == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitNative() {
        if (this.mDebug) {
            NpthLog.m234i(LOG_TAG, "exitNative");
        }
        int nativeDoCommnad = NativeResourceMonitor.nativeDoCommnad(4);
        if (nativeDoCommnad != 0) {
            NpthLog.m234i(LOG_TAG, "exitNative ret=" + nativeDoCommnad);
            this.mNativeError = true;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class HeapTrackerUploader extends ResourceMonitorAdapter.ResourceMonitorUploader {
        protected HeapTrackerUploader(AppMonitor appMonitor, File file) {
            super(appMonitor, file);
        }

        public static JSONArray getSoListFromFile(File file) {
            JSONArray jSONArray = new JSONArray();
            try {
                for (String str : FileUtils.readFile(file.getAbsolutePath()).split("\n")) {
                    String[] split = str.split("\\s+");
                    if (split.length >= 6) {
                        JSONObject jSONObject = new JSONObject();
                        long parseLong = Long.parseLong(split[1]);
                        long parseLong2 = Long.parseLong(split[2]);
                        long parseLong3 = Long.parseLong(split[3]);
                        long parseLong4 = Long.parseLong(split[4]);
                        long j = parseLong2 + parseLong3;
                        jSONObject.put("so_name", split[5]);
                        jSONObject.put("vm_size", Long.parseLong(split[1]));
                        jSONObject.put("rss", j);
                        jSONObject.put("avg_vm", parseLong / parseLong4);
                        jSONObject.put("avg_rss", j / parseLong4);
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
            return jSONArray;
        }

        private void parseSoList(File file, ResourceMonitorAdapter.UploaderData uploaderData) {
            JSONArray soListFromFile = getSoListFromFile(new File(file, "ht_so_list.txt"));
            if (soListFromFile.length() > 0) {
                try {
                    uploaderData.extraDataInBody.put("leak_so_list", soListFromFile);
                    JSONObject jSONObject = soListFromFile.getJSONObject(0);
                    uploaderData.filterData.put("top_so_avg_vm", getSizeRangeMultiUnit(jSONObject.optLong("avg_vm") / 1024));
                    uploaderData.filterData.put("top_so_avg_rss", getSizeRangeMultiUnit(jSONObject.optLong("avg_rss") / 1024));
                } catch (Throwable unused) {
                }
            }
        }

        private void parseProcessTrack(File file, ResourceMonitorAdapter.UploaderData uploaderData) {
            String str;
            int indexOf;
            try {
                File file2 = new File(file, "process_track.txt");
                Map<String, String> map = uploaderData.filterData;
                if (file2.exists()) {
                    BufferedReader bufferedReader = null;
                    String str2 = null;
                    try {
                        map.put("has_process_track", "true");
                        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                } else if (readLine.contains("onResume")) {
                                    str2 = readLine;
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                IoUtil.close(bufferedReader);
                                throw th;
                            }
                        }
                        if (str2 != null) {
                            String[] split = str2.split(" ", 3);
                            if (split.length > 1 && (indexOf = (str = split[1]).indexOf(".onResume")) > 0) {
                                map.put("scene", str.substring(0, indexOf));
                            }
                        }
                        IoUtil.close(bufferedReader2);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    map.put("has_process_track", "false");
                }
            } catch (Throwable th3) {
                NpthMonitor.directReportInnerException("parseProcessTrack", th3);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:71:0x01a9 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:72:0x01aa A[Catch: all -> 0x027a, IOException -> 0x027c, TryCatch #12 {IOException -> 0x027c, all -> 0x027a, blocks: (B:8:0x0029, B:11:0x0034, B:14:0x003b, B:15:0x0049, B:17:0x004d, B:19:0x0055, B:21:0x00a5, B:22:0x006d, B:24:0x0076, B:26:0x008e, B:28:0x0096, B:32:0x00a8, B:35:0x00be, B:44:0x00e8, B:47:0x00ef, B:69:0x01a1, B:72:0x01aa, B:73:0x01ab, B:75:0x01b1), top: B:7:0x0029 }] */
        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected boolean parseReport(File file, ResourceMonitorAdapter.UploaderData uploaderData) {
            int lineIndex;
            int i;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            int lineIndex2;
            boolean z = false;
            if (file == null) {
                NpthLog.m229e(NativeHeapTrackAdapter.LOG_TAG, "parseReport dir is null");
                return false;
            }
            parseSoList(file, uploaderData);
            parseProcessTrack(file, uploaderData);
            String str7 = "";
            try {
                JSONArray readFileArray = FileUtils.readFileArray(new File(file, "tombstone.txt").getAbsolutePath());
                if (readFileArray == null || (lineIndex = getLineIndex(readFileArray, 0, "pid:")) < 0) {
                    return false;
                }
                String str8 = null;
                String[] split = readFileArray.optString(lineIndex, null).trim().split("\\s");
                int i2 = 0;
                while (true) {
                    i = 1;
                    if (i2 >= split.length) {
                        break;
                    }
                    String str9 = split[i2];
                    if ("pid:".equals(str9)) {
                        String str10 = split[i2 + 1];
                        uploaderData.mPid = Long.decode(str10.substring(0, str10.length() - 1)).longValue();
                    } else if ("tid:".equals(str9)) {
                        String str11 = split[i2 + 1];
                        uploaderData.mTid = Long.decode(str11.substring(0, str11.length() - 1)).longValue();
                    } else if ("name:".equals(str9)) {
                        String str12 = split[i2 + 1];
                        uploaderData.mThreadName = str12.substring(0, str12.length() - 1);
                    }
                    i2++;
                }
                uploaderData.mProcessName = split[split.length - 2];
                StringBuilder sb = new StringBuilder();
                int lineIndex3 = getLineIndex(readFileArray, lineIndex + 1, "Signal ");
                if (lineIndex3 < 0) {
                    return false;
                }
                String optString = readFileArray.optString(lineIndex3, null);
                sb.append(optString).append('\n');
                try {
                    if (optString.startsWith("Signal 6(SIGABRT)")) {
                        Matcher matcher = Pattern.compile("Code -\\d+\\(([^\\)]+)\\)").matcher(optString);
                        if (matcher.find()) {
                            str7 = matcher.group(1);
                        }
                    }
                } catch (Throwable unused) {
                }
                int lineIndex4 = getLineIndex(readFileArray, lineIndex3 + 1, "Abort message:");
                if (lineIndex4 < 0) {
                    return false;
                }
                uploaderData.mAbortLine = readFileArray.optString(lineIndex4, null).replace("Abort message:", "abort message:");
                sb.append(uploaderData.mAbortLine).append('\n');
                try {
                } catch (Throwable unused2) {
                    str = null;
                    str2 = null;
                    str3 = null;
                }
                if (uploaderData.mAbortLine.startsWith("abort message:")) {
                    Matcher matcher2 = Pattern.compile("abort message: (\\S+):(\\d+)MB\\((\\d+)MB (\\d+)MB\\), (\\S+)\\(\\d+\\):(\\d+)MB\\((\\d+)MB (\\d+)MB\\)").matcher(uploaderData.mAbortLine);
                    if (matcher2.find()) {
                        str2 = matcher2.group(1);
                        try {
                            str3 = getSizeRangeMB(Long.decode(matcher2.group(2)).longValue());
                            try {
                                str4 = getSizeRangeMB(Long.decode(matcher2.group(3)).longValue() + Long.decode(matcher2.group(4)).longValue());
                                try {
                                    str5 = matcher2.group(5);
                                    try {
                                        str = getSizeRangeMB(Long.decode(matcher2.group(6)).longValue());
                                    } catch (Throwable unused3) {
                                        str = null;
                                    }
                                } catch (Throwable unused4) {
                                    str = null;
                                    str5 = null;
                                }
                            } catch (Throwable unused5) {
                                str = null;
                                str4 = null;
                                str5 = str4;
                                str6 = null;
                                lineIndex2 = getLineIndex(readFileArray, lineIndex4 + 1, "backtrace:");
                                if (lineIndex2 < 0) {
                                }
                            }
                        } catch (Throwable unused6) {
                            str = null;
                            str3 = null;
                            str4 = str3;
                            str5 = str4;
                            str6 = null;
                            lineIndex2 = getLineIndex(readFileArray, lineIndex4 + 1, "backtrace:");
                            if (lineIndex2 < 0) {
                            }
                        }
                        try {
                            str6 = getSizeRangeMB(Long.decode(matcher2.group(7)).longValue() + Long.decode(matcher2.group(8)).longValue());
                        } catch (Throwable unused7) {
                            str6 = null;
                            lineIndex2 = getLineIndex(readFileArray, lineIndex4 + 1, "backtrace:");
                            if (lineIndex2 < 0) {
                            }
                        }
                        lineIndex2 = getLineIndex(readFileArray, lineIndex4 + 1, "backtrace:");
                        if (lineIndex2 < 0) {
                            return false;
                        }
                        int i3 = lineIndex2 + 1;
                        while (i3 < readFileArray.length()) {
                            String optString2 = readFileArray.optString(i3, null);
                            try {
                                if (!optString2.startsWith("    #")) {
                                    break;
                                }
                                sb.append(optString2.trim()).append('\n');
                                i3++;
                                z = false;
                            } catch (IOException unused8) {
                                return false;
                            } catch (Throwable unused9) {
                                return false;
                            }
                        }
                        uploaderData.mNativeStack = sb.toString();
                        int lineIndex5 = getLineIndex(readFileArray, i3, "build id:");
                        if (lineIndex5 > 0) {
                            int i4 = lineIndex5 + 1;
                            while (i4 < readFileArray.length()) {
                                String optString3 = readFileArray.optString(i4, str8);
                                if (optString3.startsWith("    /")) {
                                    String[] split2 = optString3.trim().split("\\s");
                                    if (split2.length >= 3) {
                                        try {
                                            String str13 = split2[0];
                                            try {
                                                uploaderData.mSoUUID.put(new JSONObject().put(CrashBody.LIB_NAME, str13.substring(str13.lastIndexOf(47) + i)).put(CrashBody.LIB_UUID, buildIDToUUID(split2[split2.length - i].substring(0, split2[split2.length - i].length() - i))));
                                            } catch (IOException unused10) {
                                                return false;
                                            } catch (Throwable unused11) {
                                                return false;
                                            }
                                        } catch (IOException unused12) {
                                            return false;
                                        } catch (Throwable unused13) {
                                            return false;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                                i4++;
                                str8 = null;
                                i = 1;
                            }
                        }
                        uploaderData.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_LIB, str2);
                        uploaderData.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_SIZE, str3);
                        uploaderData.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_MEM, str4);
                        uploaderData.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_THREAD, str5);
                        uploaderData.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_THREAD_SIZE, str);
                        uploaderData.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_THREAD_MEM, str6);
                        uploaderData.filterData.put(NativeHeapTrackAdapter.NATIVE_SIG_CODE, str7);
                        return true;
                    }
                }
                str6 = null;
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                lineIndex2 = getLineIndex(readFileArray, lineIndex4 + 1, "backtrace:");
                if (lineIndex2 < 0) {
                }
            } catch (IOException unused14) {
                return z;
            } catch (Throwable unused15) {
                return z;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public void packFilterData(Map<String, String> map, ResourceMonitorAdapter.UploaderData uploaderData) {
            super.packFilterData(map, uploaderData);
            map.put(Constants.HAS_DUMP, "true");
            map.put("is_root", GeneralInfoManager.isRoot() ? "true" : "false");
            map.put(NativeHeapTrackAdapter.HAS_NATIVE_OOM, uploaderData.mNativeStack.isEmpty() ? "false" : "true");
            map.put(NativeHeapTrackAdapter.NATIVE_OOM_APP, Global.getContext().getPackageName());
            map.put(NativeHeapTrackAdapter.ALLOCATOR_TYPE, NativeBridge.getMallocType());
        }
    }

    public static void upload(AppMonitor appMonitor) {
        try {
            new HeapTrackerUploader(appMonitor, LogPath.getNativeHeapTrackerPath()).uploadAll();
        } catch (Throwable th) {
            NpthLog.m229e(LOG_TAG, "upload exception:" + th);
        }
    }
}
