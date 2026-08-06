package com.bytedance.push.monitor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.service.manager.push.monitor.IMultiProcessMonitor;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.bytedance.common.process.cross.IMethodObserver;
import com.bytedance.push.Configuration;
import com.ss.android.message.util.ToolUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MultiProcessMonitor implements IMultiProcessMonitor, IMethodObserver {
    private final String METHOD_NAME_MULTI_PROCESS_MONITOR = "multi_process_monitor";

    public String getMethodName() {
        return "multi_process_monitor";
    }

    public void init(Context context) {
        if (ToolUtils.isMainProcess(context)) {
            CrossProcessHelper.getInstance().registerMethodObserver(this);
        }
    }

    public void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (ToolUtils.isMainProcess(Configuration.get().mApplication)) {
            PushMonitor.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(jSONObject == null ? "" : jSONObject.toString());
        arrayList.add(jSONObject2 == null ? "" : jSONObject2.toString());
        arrayList.add(jSONObject3 != null ? jSONObject3.toString() : "");
        CrossProcessHelper.getInstance().callMethod(ProcessEnum.MAIN, "multi_process_monitor", arrayList, true);
    }

    public String onMethodCall(ProcessEnum processEnum, List list) {
        try {
            String str = (String) list.get(0);
            String str2 = (String) list.get(1);
            String str3 = (String) list.get(2);
            String str4 = (String) list.get(3);
            monitorEvent(str, TextUtils.isEmpty(str2) ? null : new JSONObject(str2), TextUtils.isEmpty(str3) ? null : new JSONObject(str3), TextUtils.isEmpty(str4) ? null : new JSONObject(str4));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }
}
