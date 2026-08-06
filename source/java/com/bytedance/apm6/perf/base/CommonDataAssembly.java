package com.bytedance.apm6.perf.base;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.type.PerfData;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CommonDataAssembly {
    public static void wrapPerfException(JSONObject jSONObject, String str) throws JSONException {
        jSONObject.put("timestamp", System.currentTimeMillis());
        jSONObject.put("crash_time", System.currentTimeMillis());
        jSONObject.put("is_main_process", ApmContext.isMainProcess());
        jSONObject.put("process_name", ApmContext.getCurrentProcessName());
        jSONObject.put("event_type", str);
        jSONObject.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());
    }

    public static void wrapPerfStatus(PerfData perfData) {
        String sceneString = PerfFilterManager.getInstance().getSceneString();
        JSONObject jSONObject = perfData.extraStatus;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (TextUtils.isEmpty(sceneString)) {
                sceneString = ActivityLifeObserver.getInstance().getTopActivityClassName();
            }
            jSONObject.put("scene", sceneString);
            jSONObject.put("process_name", ApmContext.getCurrentProcessName());
            jSONObject.put("is_main_process", ApmContext.isMainProcess());
            if (jSONObject.isNull(CommonKey.KEY_IS_FRONT)) {
                jSONObject.put(CommonKey.KEY_IS_FRONT, ActivityLifeObserver.getInstance().isForeground());
            }
            perfData.extraStatus = jSONObject;
        } catch (JSONException unused) {
        }
    }

    public static void wrapFilters(PerfData perfData, boolean z) {
        perfData.appendFilters(PerfFilterManager.getInstance().getPerfFiltersJson(z));
    }
}
