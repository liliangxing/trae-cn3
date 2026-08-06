package com.bytedance.platform.thread.monitor;

import com.bytedance.platform.thread.IPoolName;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class WaitTimeoutTask implements Runnable {
    private ThreadPoolExecutor executor;
    private Runnable r;

    public WaitTimeoutTask(ThreadPoolExecutor threadPoolExecutor, Runnable runnable) {
        this.r = runnable;
        this.executor = threadPoolExecutor;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("poolName", ((IPoolName) this.executor).getName());
            jSONObject.put("poolInfo", this.executor.toString());
            jSONObject.put("task", this.r.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ThreadMonitor.monitorCommon("pool-wait-timeout", jSONObject);
    }
}
