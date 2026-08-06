package com.bytedance.vmsdk.worker.devtool;

import android.util.Log;
import com.bytedance.vmsdk.worker.JsWorker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class WorkerDevTool {
    private static final String TAG = "WorkerDevTool";
    private WorkerInspectorDelegate mDelegate;

    public WorkerDevTool(JsWorker jsWorker) {
        this.mDelegate = null;
        try {
            this.mDelegate = (WorkerInspectorDelegate) Class.forName("com.bytedance.vmsdk.devtool.WorkerInspectorDelegateImpl").getConstructor(JsWorker.class).newInstance(jsWorker);
        } catch (Exception e) {
            Log.i(TAG, "[Devtool] create WorkerInspectorDelegateImpl failed: " + e.getMessage());
        }
    }

    public void onWorkerLoaded(String str) {
        WorkerInspectorDelegate workerInspectorDelegate = this.mDelegate;
        if (workerInspectorDelegate != null) {
            workerInspectorDelegate.onWorkerLoaded(str);
        }
    }

    public void destroy() {
        WorkerInspectorDelegate workerInspectorDelegate = this.mDelegate;
        if (workerInspectorDelegate != null) {
            workerInspectorDelegate.destroy();
            this.mDelegate = null;
        }
    }
}
