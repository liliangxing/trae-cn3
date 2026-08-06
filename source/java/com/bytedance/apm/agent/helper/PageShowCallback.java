package com.bytedance.apm.agent.helper;

import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.agent.p003v2.InstructOperationSwitch;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.applog.server.Api;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PageShowCallback {
    public static void onPageShowHideAction(Object obj, boolean z) {
        if (InstructOperationSwitch.sUiSwitch) {
            String name = obj instanceof String ? (String) obj : obj.getClass().getName();
            JSONObject jSONObject = new JSONObject();
            try {
                if (obj instanceof IPageMonitor) {
                    jSONObject.put(Api.COL_LABEL, ((IPageMonitor) obj).getMonitorLabel());
                }
            } catch (Exception unused) {
            }
            String str = z ? "page_show" : "page_hide";
            if (z && ApmDelegate.getInstance().getApmInitConfig().getTraceListener() != null) {
                ApmDelegate.getInstance().getApmInitConfig().getTraceListener().pageShow(name, true);
            }
            MonitorTool.monitorUIAction(str, name, jSONObject);
        }
    }
}
