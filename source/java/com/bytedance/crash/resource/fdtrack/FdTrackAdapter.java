package com.bytedance.crash.resource.fdtrack;

import android.os.SystemClock;
import com.bytedance.crash.Global;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.resource.ResourceMonitorAdapter;
import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FdTrackAdapter extends ResourceMonitorAdapter {
    private static final int CMD_DUMP = 3;
    private static final int CMD_EXIT = 4;
    private static final int CMD_INIT = 0;
    private static final int CMD_TRACK = 1;
    private static final int CMD_WAIT = 2;
    private static final int CONFIG_SIZE = 6;
    private static final int CRASH_DUMP = 0;
    private static final String FD_LEAK_APP = "fd_leak_app";
    private static final String FD_LEAK_COUNT_RANGE = "fd_leak_count_range";
    private static final String FD_LEAK_LIB = "fd_leak_lib";
    private static final String FD_LEAK_REASON = "fd_leak_reason";
    private static final int GET_FD_COUNT_OBSERVE = 0;
    private static final int GET_FD_COUNT_TRACK = 1;
    private static final String HAS_FD_TRACK = "has_fd_track";
    private static final int PARAM_SIZE = 3;
    private static final int PRE_DUMP = 1;
    private static final int RET_OK = 0;
    private static final int SLEEPING_TIME_MIN = 1000;
    private static final int STATE_EXIT = 5;
    private static final int STATE_INIT = 0;
    private static final int STATE_OBSERV = 2;
    private static final int STATE_PREPARE = 1;
    private static final int STATE_TRACK = 3;
    private static final int STATE_WAIT = 4;
    public static final String TAG = "FdTracker: ";
    private static FdTrackAdapter mInstance;
    private FdTrackConfig mConfig;
    private boolean mIsRunning;
    private int mState;

    public static FdTrackAdapter get() {
        if (mInstance == null) {
            synchronized (FdTrackAdapter.class) {
                if (mInstance == null) {
                    mInstance = new FdTrackAdapter();
                }
            }
        }
        return mInstance;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.crash.resource.fdtrack.FdTrackAdapter$1] */
    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    protected void executeMonitor() {
        NpthLog.m234i(TAG, "begin execute");
        if (executeSafetyCheck()) {
            this.mIsRunning = true;
            new Thread("npthFdTracker") { // from class: com.bytedance.crash.resource.fdtrack.FdTrackAdapter.1
                /* JADX WARN: Code restructure failed: missing block: B:14:0x0080, code lost:
                
                    if (r2 < r10.this$0.mConfig.mWaterLine) goto L29;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:27:0x00a9, code lost:
                
                    if (r2 < (r10.this$0.mConfig.mDumpLine / 4)) goto L29;
                 */
                @Override // java.lang.Thread, java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    long j = FdTrackAdapter.this.mConfig.mSleepTime;
                    while (FdTrackAdapter.this.mState != 5) {
                        int fdCount = FdTrackAdapter.this.getFdCount();
                        NpthLog.m234i(FdTrackAdapter.TAG, "state: " + FdTrackAdapter.this.mState + " === fd count: " + fdCount);
                        int i = FdTrackAdapter.this.mState;
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (i == 4) {
                                        if (fdCount > FdTrackAdapter.this.mConfig.mDumpLine) {
                                            FdTrackAdapter.this.nativeDump();
                                            FdTrackAdapter.this.mState = 5;
                                            FdTrackAdapter.this.mIsRunning = false;
                                        } else {
                                            FdTrackAdapter.this.nativeTrack();
                                            FdTrackAdapter.this.mState = 3;
                                        }
                                    }
                                } else if (fdCount > FdTrackAdapter.this.mConfig.mDumpLine) {
                                    FdTrackAdapter.this.nativeWait();
                                    FdTrackAdapter.this.mState = 4;
                                    j = FdTrackAdapter.this.mConfig.mSleepTime;
                                }
                            } else if (fdCount > FdTrackAdapter.this.mConfig.mWaterLine) {
                                FdTrackAdapter.this.nativeTrack();
                                FdTrackAdapter.this.mState = 3;
                                j = FdTrackAdapter.this.mConfig.mSleepTime;
                            } else {
                                if (fdCount >= FdTrackAdapter.this.mConfig.mWaterLine / 4) {
                                    j /= 4;
                                }
                                j *= 4;
                            }
                        } else if (FdTrackAdapter.this.nativeInit() != 0) {
                            FdTrackAdapter.this.mState = 5;
                        } else {
                            FdTrackAdapter.this.mState = 2;
                        }
                        j = Math.max(1000L, j);
                        try {
                            j = Math.max(j, FdTrackAdapter.this.mConfig.mSleepTime);
                            SystemClock.sleep(j);
                        } catch (Throwable unused) {
                        }
                    }
                    FdTrackAdapter.this.mGuardFile.createGuardFile();
                    NpthLog.m227d("FdTracker: Thread Exit");
                    FdTrackAdapter.this.nativeExit();
                }
            }.start();
        }
    }

    private boolean executeSafetyCheck() {
        if (this.mIsRunning) {
            NpthLog.m234i(TAG, "already is running");
            return false;
        }
        if (this.mState != 0) {
            NpthLog.m234i(TAG, "invalid state");
            return false;
        }
        this.mState = 1;
        return true;
    }

    private int getFdTypeFromParam(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int i = 0;
        for (String str2 : str.split(",")) {
            int parseInt = Integer.parseInt(str2);
            if (parseInt >= 0 && parseInt < 32) {
                i += 1 << parseInt;
            }
        }
        NpthLog.m234i(TAG, "monitor type: " + i);
        return i;
    }

    public static void updateConfig(FdTrackConfig fdTrackConfig) {
        FdTrackAdapter fdTrackAdapter = get();
        fdTrackAdapter.mConfig = fdTrackConfig;
        fdTrackAdapter.startMonitor(fdTrackConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFdCount() {
        return NativeResourceMonitor.fdTrackGetFdCount(this.mState <= 2 ? 0 : 1);
    }

    public static int dumpNativeForCrash(File file) {
        if (file == null) {
            return -1;
        }
        return NativeResourceMonitor.fdTrackDumpNative(0, file.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nativeInit() {
        return NativeResourceMonitor.fdTrackDoCommand(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nativeTrack() {
        return NativeResourceMonitor.fdTrackDoCommand(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nativeWait() {
        return NativeResourceMonitor.fdTrackDoCommand(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nativeDump() {
        return NativeResourceMonitor.fdTrackDoCommand(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nativeExit() {
        return NativeResourceMonitor.fdTrackDoCommand(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class FdTrackUploader extends ResourceMonitorAdapter.ResourceMonitorUploader {
        public FdTrackUploader(AppMonitor appMonitor, File file) {
            super(appMonitor, file);
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        protected boolean parseReport(File file, ResourceMonitorAdapter.UploaderData uploaderData) {
            String optString;
            File file2 = new File(file, "tombstone.txt");
            File file3 = new File(file, "javastack.txt");
            File file4 = new File(file, "fd_types.txt");
            if (!file2.exists()) {
                return false;
            }
            try {
                if (file3.exists()) {
                    uploaderData.mJavaStack = FileUtils.readFile(file3.getAbsolutePath());
                }
                JSONArray readFileArray = FileUtils.readFileArray(file2.getAbsolutePath());
                if (readFileArray == null) {
                    NpthLog.m234i(FdTrackAdapter.TAG, "stack content is null");
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
                            String str = split[i + 1];
                            uploaderData.mThreadName = str.substring(0, str.length());
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
                            Matcher matcher = Pattern.compile("^.*:\\s+(\\S+):.*,.*,\\s+\\S+\\s+(\\S+)\\(.*$").matcher(uploaderData.mAbortLine);
                            if (matcher.find()) {
                                uploaderData.filterData.put(FdTrackAdapter.FD_LEAK_LIB, matcher.group(1));
                                uploaderData.filterData.put(FdTrackAdapter.FD_LEAK_REASON, matcher.group(2));
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                int lineIndex4 = getLineIndex(readFileArray, lineIndex3 + 1, "backtrace:");
                if (lineIndex4 >= 0) {
                    for (int i2 = lineIndex4 + 1; i2 < readFileArray.length(); i2++) {
                        String optString2 = readFileArray.optString(i2, null);
                        if (!optString2.startsWith("    #")) {
                            break;
                        }
                        sb.append(optString2.trim()).append('\n');
                    }
                    uploaderData.mNativeStack = sb.toString();
                }
                try {
                    JSONArray readFileArray2 = FileUtils.readFileArray(file4.getAbsolutePath());
                    if (readFileArray2 != null && (optString = readFileArray2.optString(0, null)) != null && !"".equals(optString)) {
                        uploaderData.filterData.put(FdTrackAdapter.FD_LEAK_COUNT_RANGE, getFdLeakCountRange(optString.trim().split(" ")[1]));
                    }
                    uploaderData.filterData.put(FdTrackAdapter.HAS_FD_TRACK, "true");
                } catch (Throwable unused2) {
                }
                return true;
            } catch (Throwable unused3) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public void packFilterData(Map<String, String> map, ResourceMonitorAdapter.UploaderData uploaderData) {
            super.packFilterData(map, uploaderData);
            map.put("is_root", GeneralInfoManager.isRoot() ? "true" : "false");
            map.put(FdTrackAdapter.FD_LEAK_APP, Global.getContext().getPackageName());
        }

        public static boolean hasFdLeak(String str) {
            return !"".equals(str);
        }

        private static String getFdLeakCountRange(String str) {
            int parseInt = Integer.parseInt(str);
            return parseInt < 300 ? "0 ~ 200" : parseInt < 500 ? "200 ~ 500" : parseInt < 800 ? "500 ~ 800" : parseInt < 1024 ? "800 ~ 1000" : parseInt < 1500 ? "1000 ~ 1500" : "> 1500";
        }
    }

    public static void upload(AppMonitor appMonitor) {
        try {
            new FdTrackUploader(appMonitor, LogPath.getFdTrackPath()).uploadAll();
        } catch (Throwable th) {
            NpthLog.m229e(TAG, "upload exception:" + th);
        }
    }
}
