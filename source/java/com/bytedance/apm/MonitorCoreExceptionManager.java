package com.bytedance.apm;

import android.util.Log;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import java.util.HashSet;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MonitorCoreExceptionManager {
    private static final String TAG = "apm_";
    private ExceptionCallBack mExceptionCallBack;
    private HashSet<String> mOnceMessages;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface ExceptionCallBack {
        void directReportError(Throwable th, String str);

        void ensureNotReachHere(String str);

        void ensureNotReachHere(Throwable th, String str);

        void ensureNotReachHere(Throwable th, String str, Map<String, String> map);
    }

    private MonitorCoreExceptionManager() {
        this.mOnceMessages = new HashSet<>();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class Holder {
        private static final MonitorCoreExceptionManager INSTANCE = new MonitorCoreExceptionManager();

        private Holder() {
        }
    }

    public static MonitorCoreExceptionManager getInstance() {
        return Holder.INSTANCE;
    }

    public void setExceptionCallback(ExceptionCallBack exceptionCallBack) {
        this.mExceptionCallBack = exceptionCallBack;
        setExceptionCallbackForAsyncTask();
    }

    private void setExceptionCallbackForAsyncTask() {
        AsyncTaskUtil.getAsyncTaskManagerInstance().setExceptionListener(new IAsyncTaskManager.ExceptionListener() { // from class: com.bytedance.apm.MonitorCoreExceptionManager.1
            public void directReportError(Throwable th, String str) {
                if (MonitorCoreExceptionManager.this.mExceptionCallBack != null) {
                    MonitorCoreExceptionManager.this.mExceptionCallBack.directReportError(th, str);
                }
            }
        });
    }

    public void ensureNotReachHere(Throwable th, String str) {
        if (this.mExceptionCallBack != null && !this.mOnceMessages.contains(str)) {
            this.mOnceMessages.add(str);
            this.mExceptionCallBack.ensureNotReachHere(th, TAG + str);
        }
        if (ApmContext.isDebugMode()) {
            th.printStackTrace();
        }
    }

    public void directReportError(Throwable th, String str) {
        try {
            ExceptionCallBack exceptionCallBack = this.mExceptionCallBack;
            if (exceptionCallBack != null) {
                exceptionCallBack.directReportError(th, str);
            }
        } catch (Throwable unused) {
        }
        if (ApmContext.isDebugMode() || ApmContext.isLocalChannel()) {
            throw new RuntimeException(th);
        }
    }

    public void ensureNotReachHere(String str) {
        if (this.mExceptionCallBack != null && !this.mOnceMessages.contains(str)) {
            this.mOnceMessages.add(str);
            this.mExceptionCallBack.ensureNotReachHere(TAG + str);
        }
        if (ApmContext.isDebugMode()) {
            Log.e(TAG, "ensureNotReachHere", new RuntimeException(str));
            System.exit(1);
        }
    }

    public void ensureNotReachHere(Throwable th, String str, Map<String, String> map) {
        if (this.mExceptionCallBack == null || this.mOnceMessages.contains(str)) {
            return;
        }
        this.mOnceMessages.add(str);
        this.mExceptionCallBack.ensureNotReachHere(th, TAG + str, map);
    }
}
