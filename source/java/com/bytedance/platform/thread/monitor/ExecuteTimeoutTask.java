package com.bytedance.platform.thread.monitor;

import com.bytedance.platform.thread.IPoolName;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ExecuteTimeoutTask implements Runnable {
    private ThreadPoolExecutor executor;
    private Runnable r;
    private Thread thread;

    public ExecuteTimeoutTask(ThreadPoolExecutor threadPoolExecutor, Thread thread, Runnable runnable) {
        this.executor = threadPoolExecutor;
        this.thread = thread;
        this.r = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("poolName", ((IPoolName) this.executor).getName());
            jSONObject.put("poolInfo", this.executor.toString());
            jSONObject.put("threadName", this.thread.getName());
            jSONObject.put("stack", ThreadMonitor.getStackTraceString(this.thread.getStackTrace()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ThreadMonitor.monitorCommon("pool-execute-timeout", jSONObject);
    }
}
