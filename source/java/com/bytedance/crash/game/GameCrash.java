package com.bytedance.crash.game;

import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.NpthLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class GameCrash {
    private static boolean sIsDropData;

    public static void reportError(String str, String str2, String str3) {
        if ((TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) || sIsDropData) {
            return;
        }
        DefaultWorkThread.post(new UploadProcess(Thread.currentThread().getName(), System.currentTimeMillis(), str, str2, str3));
    }

    public static void setDropData(boolean z) {
        sIsDropData = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class UploadProcess implements Runnable {
        private final String mCrashName;
        private final long mCrashTime;
        private final String mReason;
        private final String mStack;
        private final String mThreadName;

        UploadProcess(String str, long j, String str2, String str3, String str4) {
            this.mThreadName = str;
            this.mCrashTime = j;
            this.mCrashName = str2;
            this.mReason = str3;
            this.mStack = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            AppMonitor appMonitor = MonitorManager.getAppMonitor();
            if (appMonitor == null) {
                return;
            }
            try {
                CrashBody assemblyCrashBody = GameSummary.assemblyCrashBody(appMonitor, this.mThreadName, this.mCrashTime, this.mCrashName, this.mReason, this.mStack);
                z = CrashUploader.uploadEvent(UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.GAME, assemblyCrashBody.getHeader().getJson()), assemblyCrashBody.getJson());
            } catch (Throwable unused) {
                z = false;
            }
            if (z) {
                return;
            }
            NpthLog.m233i("upload failed!");
        }
    }
}
