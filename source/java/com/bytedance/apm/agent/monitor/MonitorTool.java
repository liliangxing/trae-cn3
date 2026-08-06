package com.bytedance.apm.agent.monitor;

import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.pipeline.NetDataPipeline;
import com.bytedance.apm.data.type.ApiData;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.data.type.UIActionData;
import com.bytedance.apm.thread.AsyncEventManager;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MonitorTool {
    public static void monitorUIAction(final String str, final String str2, final JSONObject jSONObject) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.agent.monitor.MonitorTool.1
            @Override // java.lang.Runnable
            public void run() {
                CommonDataPipeline.getInstance().handle(new UIActionData(str, str2, jSONObject, null));
            }
        });
    }

    public static void monitorPerformance(final String str, final JSONObject jSONObject, final JSONObject jSONObject2, final JSONObject jSONObject3) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.agent.monitor.MonitorTool.2
            @Override // java.lang.Runnable
            public void run() {
                CommonDataPipeline.getInstance().handle(new PerfData(str, "", jSONObject, jSONObject2, jSONObject3));
            }
        });
    }

    public static void monitorStart(final JSONObject jSONObject, long j, long j2) {
        try {
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AgentConstants.BEGIN_TIME, j);
            jSONObject2.put("end_time", j2);
            jSONObject2.put("from", "monitor-plugin");
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.agent.monitor.MonitorTool.3
                @Override // java.lang.Runnable
                public void run() {
                    CommonDataPipeline.getInstance().handle(new PerfData("start", "", jSONObject, null, jSONObject2));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void monitorStart(String str, long j, long j2) {
        if (j2 > j) {
            try {
                final JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, j2 - j);
                final JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(AgentConstants.BEGIN_TIME, j);
                jSONObject2.put("end_time", j2);
                AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.agent.monitor.MonitorTool.4
                    @Override // java.lang.Runnable
                    public void run() {
                        CommonDataPipeline.getInstance().handle(new PerfData("start", "", jSONObject, null, jSONObject2));
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void reportTraceTime(final String str, final String str2, final long j) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.agent.monitor.MonitorTool.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str2, j);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("scene", str);
                    CommonDataPipeline.getInstance().handle(new PerfData("page_load", "page_load", jSONObject, jSONObject2, null));
                } catch (Exception unused) {
                }
            }
        });
    }

    public static void monitorSLA(final long j, final long j2, final String str, final String str2, final String str3, final int i, final JSONObject jSONObject) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.agent.monitor.MonitorTool.6
            @Override // java.lang.Runnable
            public void run() {
                NetDataPipeline.getInstance().handle(new ApiData("api_all", j, j2, str, str2, str3, i, jSONObject));
            }
        });
    }
}
