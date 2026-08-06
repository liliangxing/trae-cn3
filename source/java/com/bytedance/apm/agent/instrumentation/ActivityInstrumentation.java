package com.bytedance.apm.agent.instrumentation;

import android.text.TextUtils;
import com.bytedance.apm.agent.helper.PageShowHelper;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.apm.constant.PerfConsts;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ActivityInstrumentation {
    private static final String TAG = "ActivityInstrumentation";
    static boolean isFirstWindowFocusChanged;
    private static String sActivityName;
    private static HashSet<String> sMethodSet = new HashSet<>(32);
    private static long sOnCreateEnd;
    private static long sOnCreateStart;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnWindowFocusedChangeStart;

    static boolean isValid(String str) {
        return !TextUtils.isEmpty(sActivityName) && TextUtils.equals(str, sActivityName);
    }

    public static void onTrace(String str, String str2, boolean z) {
        if (TextUtils.equals("onCreate", str2)) {
            if (z) {
                sActivityName = str;
                sOnCreateStart = System.currentTimeMillis();
                if (isFirstWindowFocusChanged) {
                    return;
                }
                AppInstrumentation.launcherActivityOnCreateStart(sActivityName);
                return;
            }
            if (isValid(str)) {
                sOnCreateEnd = System.currentTimeMillis();
                if (isFirstWindowFocusChanged) {
                    return;
                }
                AppInstrumentation.launcherActivityOnCreateEnd();
                return;
            }
            return;
        }
        boolean z2 = true;
        if (TextUtils.equals("onResume", str2) && isValid(str)) {
            if (z) {
                if (sOnCreateStart > 0) {
                    sOnResumeStart = System.currentTimeMillis();
                    if (!isFirstWindowFocusChanged) {
                        AppInstrumentation.launcherActivityOnResumeStart(sActivityName);
                    }
                    PageShowHelper.onPageShowHideAction(sActivityName, true);
                    return;
                }
                return;
            }
            if (sOnCreateStart > 0) {
                sOnResumeEnd = System.currentTimeMillis();
                if (isFirstWindowFocusChanged) {
                    return;
                }
                AppInstrumentation.launcherActivityOnResumeEnd();
                return;
            }
            return;
        }
        if (TextUtils.equals(AgentConstants.ON_WINDOW_FOCUS_CHANGED, str2) && isValid(str) && sOnCreateStart > 0) {
            if (!isFirstWindowFocusChanged) {
                AppInstrumentation.launcherActivityOnWindowFocusChangedStart(sActivityName);
                isFirstWindowFocusChanged = true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            sOnWindowFocusedChangeStart = currentTimeMillis;
            if (currentTimeMillis - sOnCreateStart < PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(AgentConstants.BEGIN_TIME, sOnCreateStart);
                    jSONObject.put("end_time", sOnWindowFocusedChangeStart);
                    jSONObject.put("page_type", "activity");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("onCreate", sOnCreateEnd - sOnCreateStart);
                    jSONObject2.put("onResume", sOnResumeEnd - sOnResumeStart);
                    jSONObject2.put("activityOnCreateToWindowFocusChanged", sOnWindowFocusedChangeStart - sOnCreateStart);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("scene", sActivityName);
                    if (sMethodSet.contains(sActivityName + str2)) {
                        z2 = false;
                    }
                    jSONObject3.put("is_first", z2);
                    sMethodSet.add(sActivityName + str2);
                    MonitorTool.monitorPerformance("page_load", jSONObject2, jSONObject3, jSONObject);
                } catch (Exception unused) {
                }
            }
            sOnCreateStart = 0L;
            sActivityName = null;
        }
    }
}
