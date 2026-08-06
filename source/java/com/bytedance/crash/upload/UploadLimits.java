package com.bytedance.crash.upload;

import com.bytedance.crash.Global;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class UploadLimits {
    private static final String CRASH_ALL = "crash_all";
    private static final String ENSURE_ALL = "ensure_all";
    private static final long ONE_DAY = 86400000;
    private static final String TAG = "UploadLimits";
    private static final String UPLOAD_LIMIT_DIR = "uploadLimits";
    private static final String UPLOAD_LIMIT_FILE = ".times";
    private static volatile boolean isInited;
    private static boolean sCrashLimitCallbackInvoked;
    private static boolean sEnsureLimitCallbackInvoked;
    private static UploadLimits sInstance;
    private long createTime = 0;
    private final File mFile;
    private final HashMap<String, Long> mTimesMap;
    private static final CrashLimitCallback sLimitCallback = new CrashLimitCallback();
    private static int mCrashStackLimit = 50;
    private static int mCrashAllLimit = 100;
    private static int mEnsureAllLimit = 100;
    private static int mEnsureStackLimit = 2;
    private static int mEnsureMsgLimit = 5;
    private static boolean isNoLimit = false;

    public static UploadLimits get() {
        if (sInstance == null) {
            synchronized (UploadLimits.class) {
                if (sInstance == null) {
                    sInstance = new UploadLimits();
                }
            }
        }
        return sInstance;
    }

    private UploadLimits() {
        String str = App.getProcessName().replace(".", "_").replace(":", "-") + UPLOAD_LIMIT_FILE;
        File file = new File(Global.getRootDirectory(), UPLOAD_LIMIT_DIR);
        FileSystemUtils.createDirectory(file);
        this.mFile = new File(file, str);
        HashMap<String, Long> readUploadTimesFile = readUploadTimesFile();
        this.mTimesMap = readUploadTimesFile;
        NpthLog.m234i(TAG, "upload_times:" + readUploadTimesFile);
        isInited = true;
    }

    public static boolean isInited() {
        return isInited;
    }

    public static void updateConfig(UploadLimitConfig uploadLimitConfig) {
        if (uploadLimitConfig == null) {
            return;
        }
        mCrashStackLimit = uploadLimitConfig.getCrashLimitIssue();
        mCrashAllLimit = uploadLimitConfig.getCrashLimitAll();
        mEnsureAllLimit = uploadLimitConfig.getExceptionAllLimit();
        mEnsureMsgLimit = uploadLimitConfig.getExceptionMsgLimit();
        mEnsureStackLimit = uploadLimitConfig.getExceptionStackLimit();
        isNoLimit = uploadLimitConfig.isNoLimit();
        NpthLog.m234i(TAG, "updateConfig:" + uploadLimitConfig);
    }

    private HashMap<String, Long> readUploadTimesFile() {
        JSONArray readFileArray;
        HashMap<String, Long> hashMap = new HashMap<>();
        if (!this.mFile.exists()) {
            this.createTime = System.currentTimeMillis();
            return hashMap;
        }
        try {
            readFileArray = FileUtils.readFileArray(this.mFile);
        } catch (Throwable unused) {
            this.createTime = System.currentTimeMillis();
            FileUtils.deleteFile(this.mFile);
        }
        if (JSONUtils.isEmpty(readFileArray)) {
            return hashMap;
        }
        Long safeParse = safeParse(readFileArray.optString(0, null));
        if (System.currentTimeMillis() - safeParse.longValue() >= 86400000) {
            NpthLog.m234i(TAG, "limit file exceed 1 day");
            this.createTime = System.currentTimeMillis();
            FileUtils.deleteFile(this.mFile);
            return hashMap;
        }
        this.createTime = safeParse.longValue();
        for (int i = 1; i < readFileArray.length(); i++) {
            String[] split = readFileArray.optString(i, "").split(" ");
            if (split.length == 2) {
                hashMap.put(split[0], Long.decode(split[1]));
            }
        }
        return hashMap;
    }

    private static Long safeParse(String str) {
        try {
            return Long.decode(str);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public void writeUploadTimesFile() {
        try {
            StringBuilder append = new StringBuilder().append(this.createTime).append('\n');
            for (Map.Entry<String, Long> entry : this.mTimesMap.entrySet()) {
                append.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
            }
            NpthLog.m234i("CustomException", "writeUploadTimesFile:" + ((Object) append));
            FileUtils.writeFile(this.mFile, append.toString(), false);
        } catch (Exception e) {
            NpthMonitor.reportInnerException("NPTH_ANR_ERROR_AppMonitor", e);
            NpthLog.m232e(e);
        }
    }

    private static void callEnsureLimitListener() {
        if (sEnsureLimitCallbackInvoked) {
            return;
        }
        sEnsureLimitCallbackInvoked = true;
        sLimitCallback.onLimitExceed("ensure");
    }

    private static void callCrashLimitListener() {
        if (sCrashLimitCallbackInvoked) {
            return;
        }
        sCrashLimitCallbackInvoked = true;
        sLimitCallback.onLimitExceed(CrashManager.DIR_NAME);
    }

    public boolean checkCrashTotalLimit() {
        return checkLimit(CRASH_ALL, mCrashAllLimit);
    }

    public boolean checkCrashLimit(String str) {
        if (isNoLimit) {
            return false;
        }
        String md5 = Digest.getMD5(str);
        boolean checkLimit = checkLimit(md5, mCrashStackLimit);
        boolean checkLimit2 = checkLimit(CRASH_ALL, mCrashAllLimit);
        if (checkLimit || checkLimit2) {
            callCrashLimitListener();
            return true;
        }
        updateTimes(md5);
        updateTimes(CRASH_ALL);
        return false;
    }

    public boolean checkEnsureAllLimit() {
        return checkLimit(ENSURE_ALL, mEnsureAllLimit);
    }

    public boolean checkEnsureLimit(String str, String str2) {
        if (isNoLimit) {
            return false;
        }
        boolean checkLimit = checkLimit(str2, mEnsureStackLimit);
        boolean checkLimit2 = str != null ? checkLimit(str, mEnsureMsgLimit) : false;
        boolean checkLimit3 = checkLimit(ENSURE_ALL, mEnsureAllLimit);
        NpthLog.m234i("CustomException", "checkEnsureLimit:" + str2 + " " + mEnsureStackLimit + "=" + checkLimit + " " + str + " " + mEnsureMsgLimit + "=" + checkLimit2 + " totalExceed=" + checkLimit3);
        boolean z = checkLimit || checkLimit2 || checkLimit3;
        if (z) {
            callEnsureLimitListener();
        }
        return z;
    }

    public void updateEnsureUploadTimes(String str, String str2) {
        if (str != null) {
            updateTimes(str);
        }
        if (str2 != null) {
            updateTimes(str2);
        }
        updateTimes(ENSURE_ALL);
    }

    public synchronized boolean checkLimit(String str, long j) {
        if (str == null) {
            return false;
        }
        Long l = this.mTimesMap.get(str);
        if (l == null) {
            l = 0L;
        }
        return l.longValue() >= j;
    }

    private synchronized void updateTimes(String str) {
        NpthLog.m234i(TAG, "updateTimes:" + str);
        if (str == null) {
            return;
        }
        Long l = this.mTimesMap.get(str);
        this.mTimesMap.put(str, Long.valueOf(l != null ? 1 + l.longValue() : 1L));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class CrashLimitCallback {
        protected void onLimitExceed() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onLimitExceed(String str) {
            try {
                onLimitExceed();
            } catch (Throwable unused) {
            }
        }
    }
}
