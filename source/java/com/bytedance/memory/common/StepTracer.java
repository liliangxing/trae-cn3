package com.bytedance.memory.common;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class StepTracer {
    private JSONObject mMonitorJs = new JSONObject();
    private long mCurrentTime = System.currentTimeMillis();

    public void trace(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(" cost ").append(System.currentTimeMillis() - this.mCurrentTime).append("ms Memory ").append(MemoryUtils.getAppUsedMemory());
        try {
            this.mMonitorJs.put(str, sb.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.mCurrentTime = System.currentTimeMillis();
    }

    public JSONObject getMonitorJson() {
        return this.mMonitorJs;
    }
}
