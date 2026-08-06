package com.bytedance.apm.agent.tracing;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.thread.AsyncEventManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AutoLaunchTraceHelper {
    private static long sAttachBaseContextEndTime = 0;
    private static long sAttachBaseContextStartTime = 0;
    private static long sConstructorEndTime = 0;
    private static long sConstructorStartTime = 0;
    private static boolean sIsValid = false;
    private static long sLauncherActivityCreateEndTime = 0;
    private static long sLauncherActivityCreateStartTime = 0;
    public static String sLauncherActivityName = null;
    private static long sLauncherActivityOnWindowFocusChangedTime = 0;
    private static long sLauncherActivityResumeEndTime = 0;
    private static long sLauncherActivityResumeStartTime = 0;
    private static long sLauncherActivityStartEndTime = 0;
    private static long sLauncherActivityStartStartTime = 0;
    private static long sMaxValidTimeMs = 15000;
    private static long sOnCreateEndTime;
    private static long sOnCreateStartTime;

    public static void assignAppTime(long j, long j2, long j3, long j4, long j5, long j6) {
        LaunchAnalysisContext.getInstance().logD("assignAppTime: " + sOnCreateEndTime);
        sConstructorStartTime = j;
        sConstructorEndTime = j2;
        sAttachBaseContextStartTime = j3;
        sAttachBaseContextEndTime = j4;
        sOnCreateStartTime = j5;
        sOnCreateEndTime = j6;
        ApmContext.setAppLaunchStartTimestamp(j);
    }

    public static void launcherActivityOnCreateStart(String str) {
        LaunchAnalysisContext.getInstance().logD(str + " onCreateStart " + sLauncherActivityCreateStartTime + " " + (sLauncherActivityCreateStartTime - sOnCreateEndTime < 800));
        if (sLauncherActivityCreateStartTime == 0) {
            sLauncherActivityCreateStartTime = System.currentTimeMillis();
            LaunchAnalysisContext.getInstance().logD(str + " onCreateStart " + sLauncherActivityCreateStartTime + "  " + sOnCreateEndTime + " " + (sLauncherActivityCreateStartTime - sOnCreateEndTime < 800));
            if (sLauncherActivityCreateStartTime - sOnCreateEndTime < 800) {
                sIsValid = true;
                sLauncherActivityName = str;
            }
        }
    }

    public static void launcherActivityOnCreateEnd() {
        LaunchAnalysisContext.getInstance().logD("onCreateEnd " + sLauncherActivityCreateStartTime + " " + sLauncherActivityCreateEndTime);
        if (sLauncherActivityCreateEndTime == 0 && sIsValid) {
            sLauncherActivityCreateEndTime = System.currentTimeMillis();
        }
    }

    public static void launcherActivityOnStartStart(String str) {
        LaunchAnalysisContext.getInstance().logD(str + " onStart " + sLauncherActivityStartStartTime);
        if (sLauncherActivityStartStartTime == 0 && sIsValid) {
            sLauncherActivityStartStartTime = System.currentTimeMillis();
        }
    }

    public static void launcherActivityOnStartEnd(String str) {
        LaunchAnalysisContext.getInstance().logD("onStartEnd " + sLauncherActivityStartStartTime + " " + sLauncherActivityStartEndTime);
        if (sLauncherActivityStartEndTime == 0 && sIsValid) {
            sLauncherActivityStartEndTime = System.currentTimeMillis();
        }
    }

    public static void launcherActivityOnResumeStart(String str) {
        LaunchAnalysisContext.getInstance().logD(str + " onResume " + sLauncherActivityResumeStartTime);
        if (sLauncherActivityResumeStartTime == 0 && sIsValid) {
            sLauncherActivityResumeStartTime = System.currentTimeMillis();
        }
    }

    public static void launcherActivityOnResumeEnd() {
        LaunchAnalysisContext.getInstance().logD("onResumeEnd " + sLauncherActivityResumeStartTime + " " + sLauncherActivityResumeEndTime);
        if (sLauncherActivityResumeEndTime == 0 && sIsValid) {
            sLauncherActivityResumeEndTime = System.currentTimeMillis();
        }
    }

    public static void launcherActivityOnWindowFocusChangedStart(String str) {
        LaunchAnalysisContext.getInstance().logD("OnWindowFocusChanged " + str + " " + sLauncherActivityOnWindowFocusChangedTime + " " + sOnCreateStartTime + " " + sIsValid);
        if (sLauncherActivityOnWindowFocusChangedTime == 0 && sOnCreateStartTime > 0 && sIsValid) {
            sLauncherActivityOnWindowFocusChangedTime = System.currentTimeMillis();
            sLauncherActivityName = str;
            sIsValid = false;
        }
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.agent.tracing.AutoLaunchTraceHelper.1
            @Override // java.lang.Runnable
            public void run() {
                AutoLaunchTraceHelper.reportStats();
            }
        });
    }

    public static JSONArray assemblySpan() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        jSONObject.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "app_constructor");
        jSONObject.put("start", sConstructorStartTime);
        jSONObject.put("end", sConstructorEndTime);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        jSONObject2.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "app_attachBaseContext");
        jSONObject2.put("start", sAttachBaseContextStartTime);
        jSONObject2.put("end", sAttachBaseContextEndTime);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        jSONObject3.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "app_onCreate");
        jSONObject3.put("start", sOnCreateStartTime);
        jSONObject3.put("end", sOnCreateEndTime);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        jSONObject4.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "activity_onCreate");
        jSONObject4.put("start", sLauncherActivityCreateStartTime);
        jSONObject4.put("end", sLauncherActivityCreateEndTime);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        jSONObject5.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "activity_onResume");
        jSONObject5.put("start", sLauncherActivityResumeStartTime);
        jSONObject5.put("end", sLauncherActivityResumeEndTime);
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        jSONObject6.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "activity_onStart");
        jSONObject6.put("start", sLauncherActivityStartStartTime);
        jSONObject6.put("end", sLauncherActivityStartEndTime);
        if (sLauncherActivityOnWindowFocusChangedTime > 0) {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
            jSONObject7.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "activity_onWindowFocusChanged");
            jSONObject7.put("start", sLauncherActivityOnWindowFocusChangedTime);
            jSONArray.put(jSONObject7);
        }
        jSONArray.put(jSONObject);
        jSONArray.put(jSONObject2);
        jSONArray.put(jSONObject3);
        jSONArray.put(jSONObject4);
        jSONArray.put(jSONObject5);
        jSONArray.put(jSONObject6);
        return jSONArray;
    }

    public static void setMaxValidTimeMs(long j) {
        sMaxValidTimeMs = j;
    }

    public static void reportStats() {
        try {
            if (ApmContext.getLaunchMode() == -1) {
                LaunchAnalysisContext.getInstance().logD("auto launch mode not init");
                return;
            }
            long j = sLauncherActivityOnWindowFocusChangedTime - sConstructorStartTime;
            if (j > 0 && j <= sMaxValidTimeMs) {
                JSONArray assemblySpan = assemblySpan();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", TraceStatsConsts.START_STATS_NAME);
                jSONObject.put("start", sConstructorStartTime);
                jSONObject.put("end", sLauncherActivityOnWindowFocusChangedTime);
                jSONObject.put(TraceStatsConsts.STATS_KEY_SPANS, assemblySpan);
                jSONObject.put(TraceStatsConsts.START_STATS_KEY_COLLECT_FROM, 1);
                jSONObject.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, sLauncherActivityName);
                jSONObject.put("launch_mode", ApmContext.getLaunchMode());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TraceStatsConsts.STATS_KEY_TRACE, jSONObject);
                if (ApmContext.isDebugMode()) {
                    LaunchAnalysisContext.getInstance().logD("auto span: " + jSONObject);
                }
                CommonDataPipeline.getInstance().handle(new PerfData("start_trace", "", null, null, jSONObject2));
            }
        } catch (JSONException unused) {
        }
    }
}
