package com.bytedance.apm.agent.tracing;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.trace.mapping.ApmPageLoadMappingTool;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AutoPageTraceHelper {
    private static boolean sIsFirstWindowFocusChangedActivity;
    private static final HashSet<String> sMethodSet = new HashSet<>(32);
    private static final ConcurrentLinkedQueue<PageTraceEntity> sPageList = new ConcurrentLinkedQueue<>();
    private static long sMaxValidTimeMs = TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS;

    public static void setMaxValidTimeMs(long j) {
        sMaxValidTimeMs = j;
    }

    public static void onTrace(String str, String str2, boolean z) {
        if (TextUtils.equals("onCreate", str2)) {
            if (z) {
                if (!sIsFirstWindowFocusChangedActivity) {
                    AutoLaunchTraceHelper.launcherActivityOnCreateStart(str);
                }
                ConcurrentLinkedQueue<PageTraceEntity> concurrentLinkedQueue = sPageList;
                if (concurrentLinkedQueue.size() > 50) {
                    concurrentLinkedQueue.poll();
                }
                concurrentLinkedQueue.add(new PageTraceEntity(str, System.currentTimeMillis()));
                return;
            }
            if (!sIsFirstWindowFocusChangedActivity) {
                AutoLaunchTraceHelper.launcherActivityOnCreateEnd();
            }
            PageTraceEntity peek = sPageList.peek();
            if (peek != null) {
                peek.onCreateEndTs = System.currentTimeMillis();
                return;
            }
            return;
        }
        if (TextUtils.equals("onResume", str2)) {
            if (z) {
                if (!sIsFirstWindowFocusChangedActivity) {
                    AutoLaunchTraceHelper.launcherActivityOnResumeStart(str);
                }
                PageTraceEntity peek2 = sPageList.peek();
                if (peek2 != null) {
                    peek2.onResumeStartTs = System.currentTimeMillis();
                    return;
                }
                return;
            }
            if (!sIsFirstWindowFocusChangedActivity) {
                AutoLaunchTraceHelper.launcherActivityOnResumeEnd();
            }
            PageTraceEntity peek3 = sPageList.peek();
            if (peek3 != null) {
                peek3.onResumeEndTs = System.currentTimeMillis();
                return;
            }
            return;
        }
        if (!TextUtils.equals(AgentConstants.ON_WINDOW_FOCUS_CHANGED, str2)) {
            if (TextUtils.equals(AgentConstants.ON_START, str2)) {
                if (z) {
                    if (sIsFirstWindowFocusChangedActivity) {
                        return;
                    }
                    AutoLaunchTraceHelper.launcherActivityOnStartStart(str);
                    return;
                } else {
                    if (sIsFirstWindowFocusChangedActivity) {
                        return;
                    }
                    AutoLaunchTraceHelper.launcherActivityOnStartEnd(str);
                    return;
                }
            }
            return;
        }
        if (z) {
            if (!sIsFirstWindowFocusChangedActivity) {
                AutoLaunchTraceHelper.launcherActivityOnWindowFocusChangedStart(str);
                sIsFirstWindowFocusChangedActivity = true;
            }
            PageTraceEntity peek4 = sPageList.peek();
            if (peek4 == null || peek4.onWindowFocusTs != 0) {
                return;
            }
            peek4.onWindowFocusTs = System.currentTimeMillis();
            if (ApmPageLoadMappingTool.queryViewId(str) == null) {
                AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.agent.tracing.AutoPageTraceHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AutoPageTraceHelper.reportStats();
                    }
                });
            }
        }
    }

    public static void reportViewIdStats(long j, String str) {
        PageTraceEntity peek = sPageList.peek();
        if (peek == null || !TextUtils.equals(str, peek.pageName)) {
            return;
        }
        peek.onViewShowTs = j;
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.agent.tracing.AutoPageTraceHelper.2
            @Override // java.lang.Runnable
            public void run() {
                AutoPageTraceHelper.reportStats();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0125 A[Catch: Exception -> 0x0139, TryCatch #0 {Exception -> 0x0139, blocks: (B:3:0x0007, B:5:0x0010, B:7:0x001a, B:9:0x0022, B:15:0x002a, B:17:0x0038, B:19:0x0084, B:20:0x0097, B:22:0x00b5, B:24:0x00c3, B:29:0x00e9, B:32:0x00fd, B:34:0x0125, B:35:0x012e, B:39:0x00cf, B:41:0x00dd), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void reportStats() {
        try {
            int size = sPageList.size();
            for (int i = 0; i < size; i++) {
                ConcurrentLinkedQueue<PageTraceEntity> concurrentLinkedQueue = sPageList;
                PageTraceEntity peek = concurrentLinkedQueue.peek();
                if (peek == null) {
                    return;
                }
                if (peek.onWindowFocusTs == 0 && peek.onViewShowTs == 0) {
                    return;
                }
                PageTraceEntity poll = concurrentLinkedQueue.poll();
                if (!poll.isCreateAndResumeValid()) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", "onCreate");
                jSONObject.put("start", poll.onCreateStartTs);
                jSONObject.put(TraceStatsConsts.STATS_KEY_END, poll.onCreateEndTs);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("name", "onResume");
                jSONObject2.put("start", poll.onResumeStartTs);
                jSONObject2.put(TraceStatsConsts.STATS_KEY_END, poll.onResumeEndTs);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("name", AgentConstants.ON_WINDOW_FOCUS_CHANGED);
                jSONObject3.put("start", poll.onWindowFocusTs);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                jSONArray.put(jSONObject2);
                jSONArray.put(jSONObject3);
                if (poll.onViewShowTs > 0) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("name", "viewShow");
                    jSONObject4.put("start", poll.onViewShowTs);
                    jSONArray.put(jSONObject4);
                }
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("name", TraceStatsConsts.PAGE_LOAD_STATS_NAME);
                jSONObject5.put("page_type", "activity");
                jSONObject5.put("start", poll.onCreateStartTs);
                if (poll.onViewShowTs > 0) {
                    jSONObject5.put(TraceStatsConsts.STATS_KEY_END, poll.onViewShowTs);
                    if (poll.onViewShowTs - poll.onCreateStartTs >= 0) {
                        if (poll.onViewShowTs - poll.onCreateStartTs > sMaxValidTimeMs) {
                        }
                        jSONObject5.put(TraceStatsConsts.STATS_KEY_SPANS, jSONArray);
                        HashSet<String> hashSet = sMethodSet;
                        int i2 = !hashSet.contains(poll.pageName) ? 2 : 1;
                        hashSet.add(poll.pageName);
                        jSONObject5.put("launch_mode", i2);
                        jSONObject5.put(TraceStatsConsts.START_STATS_KEY_COLLECT_FROM, 1);
                        jSONObject5.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, poll.pageName);
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put(TraceStatsConsts.STATS_KEY_TRACE, jSONObject5);
                        if (ApmAlogHelper.isFeedbackALogEnabled()) {
                            ApmAlogHelper.feedbackI("PageLoadTrace", jSONObject5.toString());
                        }
                        MonitorTool.monitorPerformance("page_load_trace", null, null, jSONObject6);
                    }
                } else {
                    jSONObject5.put(TraceStatsConsts.STATS_KEY_END, poll.onWindowFocusTs);
                    if (poll.onWindowFocusTs - poll.onCreateStartTs >= 0) {
                        if (poll.onWindowFocusTs - poll.onCreateStartTs > sMaxValidTimeMs) {
                        }
                        jSONObject5.put(TraceStatsConsts.STATS_KEY_SPANS, jSONArray);
                        HashSet<String> hashSet2 = sMethodSet;
                        if (!hashSet2.contains(poll.pageName)) {
                        }
                        hashSet2.add(poll.pageName);
                        jSONObject5.put("launch_mode", i2);
                        jSONObject5.put(TraceStatsConsts.START_STATS_KEY_COLLECT_FROM, 1);
                        jSONObject5.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, poll.pageName);
                        JSONObject jSONObject62 = new JSONObject();
                        jSONObject62.put(TraceStatsConsts.STATS_KEY_TRACE, jSONObject5);
                        if (ApmAlogHelper.isFeedbackALogEnabled()) {
                        }
                        MonitorTool.monitorPerformance("page_load_trace", null, null, jSONObject62);
                    }
                }
            }
        } catch (Exception e) {
            if (ApmContext.isDebugMode()) {
                e.printStackTrace();
            }
        }
    }
}
