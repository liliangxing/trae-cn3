package com.bytedance.crash.dart;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.IUploadCallback;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DartCrash {
    private static boolean sIsDropData;

    public static void reportError(String str) {
        reportError(str, null, null, null);
    }

    public static void reportError(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, IUploadCallback iUploadCallback) {
        if (sIsDropData) {
            return;
        }
        DefaultWorkThread.post(new UploadProcess(Thread.currentThread().getName(), System.currentTimeMillis(), str, map, map2, iUploadCallback));
    }

    public static void setDropData(boolean z) {
        sIsDropData = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class UploadProcess implements Runnable {
        private final IUploadCallback mCallback;
        private final long mCrashTime;
        private final Map<? extends String, ? extends String> mCustomData;
        private final Map<String, String> mCustomLongData;
        private final String mMessage;
        private final String mThreadName;

        UploadProcess(String str, long j, String str2, Map<? extends String, ? extends String> map, Map<String, String> map2, IUploadCallback iUploadCallback) {
            this.mCrashTime = j;
            this.mMessage = str2;
            this.mCustomData = map;
            this.mCustomLongData = map2;
            this.mCallback = iUploadCallback;
            this.mThreadName = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            AppMonitor appMonitor = MonitorManager.getAppMonitor();
            if (appMonitor == null) {
                return;
            }
            try {
                CrashBody assemblyCrashBody = DartSummary.assemblyCrashBody(appMonitor, this.mThreadName, this.mCrashTime, this.mMessage, this.mCustomData, this.mCustomLongData);
                z = CrashUploader.uploadEvent(UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.DART, assemblyCrashBody.getHeader().getJson()), assemblyCrashBody.getJson());
            } catch (Throwable unused) {
                z = false;
            }
            IUploadCallback iUploadCallback = this.mCallback;
            if (iUploadCallback != null) {
                try {
                    iUploadCallback.afterUpload(z);
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
