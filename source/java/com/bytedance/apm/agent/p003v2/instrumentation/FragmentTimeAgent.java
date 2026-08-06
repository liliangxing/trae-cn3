package com.bytedance.apm.agent.p003v2.instrumentation;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.thread.ApmHandlerThread;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.trace.TraceConfig;
import com.bytedance.apm.trace.mapping.ApmPageLoadMappingTool;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FragmentTimeAgent {
    private static final String TAG = "FragmentTimeAgent";
    private static long sCheckVisibilityStartTime = 0;
    private static String sFragmentName = null;
    private static long sMaxWaitTime = 60000;
    private static HashSet<String> sMethodSet = new HashSet<>(32);
    private static long sOnActivityCreatedEnd;
    private static long sOnActivityCreatedStart;
    private static long sOnCreateEnd;
    private static long sOnCreateStart;
    private static ViewTreeObserver.OnGlobalLayoutListener sOnGlobalLayoutListener;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnViewCreatedEnd;
    private static long sOnViewCreatedStart;
    private static boolean sReported;
    private static WeakReference<View> sRootViewRef;
    private static Runnable sWaitViewTimeoutRunnable;

    public static void onHiddenChanged(Fragment fragment, boolean z) {
        if (z) {
            return;
        }
        try {
            String canonicalName = fragment.getClass().getCanonicalName();
            Integer queryViewId = ApmPageLoadMappingTool.queryViewId(canonicalName);
            if (queryViewId != null && queryViewId.intValue() > 0) {
                registerOnGlobalLayoutListener(canonicalName, fragment.getView(), queryViewId, System.currentTimeMillis(), TraceConfig.KEY_FRAGMENT_HIDECHANGED_TO_VIEW_SHOW_TIME);
            }
        } catch (Exception unused) {
        }
    }

    public static void setUserVisibleHint(Fragment fragment, boolean z) {
        if (z && fragment.isResumed() && !fragment.isHidden()) {
            try {
                String canonicalName = fragment.getClass().getCanonicalName();
                Integer queryViewId = ApmPageLoadMappingTool.queryViewId(canonicalName);
                if (queryViewId != null && queryViewId.intValue() > 0) {
                    registerOnGlobalLayoutListener(canonicalName, fragment.getView(), queryViewId, System.currentTimeMillis(), TraceConfig.KEY_FRAGMENT_VISIBLEHINT_TO_VIEW_SHOW_TIME);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void onTrace(Fragment fragment, String str, String str2, boolean z) {
        if (TextUtils.equals("onCreate", str2)) {
            if (z) {
                sFragmentName = str;
                sOnCreateStart = System.currentTimeMillis();
                if (sMaxWaitTime == 0) {
                    sMaxWaitTime = ApmDelegate.getInstance().getApmInitConfig().getMaxValidPageLoadTimeMs();
                }
                sReported = false;
                return;
            }
            if (isValid(str)) {
                sOnCreateEnd = System.currentTimeMillis();
                return;
            }
            return;
        }
        if (TextUtils.equals("onViewCreated", str2) && isValid(str)) {
            if (z) {
                if (sOnCreateStart > 0) {
                    sOnViewCreatedStart = System.currentTimeMillis();
                    return;
                }
                return;
            } else {
                if (sOnCreateStart > 0) {
                    sOnViewCreatedEnd = System.currentTimeMillis();
                    return;
                }
                return;
            }
        }
        if (TextUtils.equals("onActivityCreated", str2) && isValid(str)) {
            if (z) {
                if (sOnCreateStart > 0) {
                    sOnActivityCreatedStart = System.currentTimeMillis();
                    return;
                }
                return;
            } else {
                if (sOnCreateStart > 0) {
                    sOnActivityCreatedEnd = System.currentTimeMillis();
                    return;
                }
                return;
            }
        }
        if (TextUtils.equals("onResume", str2) && isValid(str)) {
            if (z) {
                if (sOnCreateStart > 0) {
                    sOnResumeStart = System.currentTimeMillis();
                    onResumeShow(fragment, str);
                    return;
                }
                return;
            }
            if (sOnCreateStart > 0) {
                sOnResumeEnd = System.currentTimeMillis();
                try {
                    Integer queryViewId = ApmPageLoadMappingTool.queryViewId(str);
                    if (queryViewId == null || queryViewId.intValue() <= 0) {
                        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.agent.v2.instrumentation.FragmentTimeAgent.1
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean contains = FragmentTimeAgent.sMethodSet.contains(FragmentTimeAgent.sFragmentName);
                                FragmentTimeAgent.sMethodSet.add(FragmentTimeAgent.sFragmentName);
                                FragmentTimeAgent.reportStats(contains, null, 0L, 0L);
                            }
                        });
                    }
                } catch (Exception unused) {
                }
                sReported = true;
                sFragmentName = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportStats(boolean z, String str, long j, long j2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "onCreate");
            jSONObject.put("start", sOnCreateStart);
            jSONObject.put(TraceStatsConsts.STATS_KEY_END, sOnCreateEnd);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", "onViewCreated");
            jSONObject2.put("start", sOnViewCreatedStart);
            jSONObject2.put(TraceStatsConsts.STATS_KEY_END, sOnViewCreatedEnd);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("name", "onActivityCreated");
            jSONObject3.put("start", sOnActivityCreatedStart);
            jSONObject3.put(TraceStatsConsts.STATS_KEY_END, sOnActivityCreatedEnd);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("name", "onResume");
            jSONObject4.put("start", sOnResumeStart);
            jSONObject4.put(TraceStatsConsts.STATS_KEY_END, sOnResumeEnd);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            jSONArray.put(jSONObject2);
            jSONArray.put(jSONObject3);
            jSONArray.put(jSONObject4);
            if (str != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("name", str);
                jSONObject5.put("start", j);
                jSONObject5.put(TraceStatsConsts.STATS_KEY_END, j2);
                jSONArray.put(jSONObject5);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("name", TraceStatsConsts.PAGE_LOAD_STATS_NAME);
            jSONObject6.put("page_type", "fragment");
            jSONObject6.put("start", sOnCreateStart);
            jSONObject6.put(TraceStatsConsts.STATS_KEY_SPANS, jSONArray);
            jSONObject6.put("launch_mode", z ? 2 : 1);
            jSONObject6.put(TraceStatsConsts.START_STATS_KEY_COLLECT_FROM, 1);
            jSONObject6.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, sFragmentName);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put(TraceStatsConsts.STATS_KEY_TRACE, jSONObject6);
            MonitorTool.monitorPerformance("page_load_trace", null, null, jSONObject7);
        } catch (Exception e) {
            if (ApmContext.isDebugMode()) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportTraceTime(String str, final String str2, final long j, final long j2) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.agent.v2.instrumentation.FragmentTimeAgent.2
            @Override // java.lang.Runnable
            public void run() {
                boolean contains = FragmentTimeAgent.sMethodSet.contains(FragmentTimeAgent.sFragmentName);
                FragmentTimeAgent.sMethodSet.add(FragmentTimeAgent.sFragmentName);
                FragmentTimeAgent.reportStats(contains, str2, j, j2);
            }
        });
    }

    public static void onResumeShow(Fragment fragment, String str) {
        if (fragment.getUserVisibleHint() && !fragment.isHidden()) {
            try {
                Integer queryViewId = ApmPageLoadMappingTool.queryViewId(str);
                if (queryViewId != null && queryViewId.intValue() > 0) {
                    registerOnGlobalLayoutListener(str, fragment.getView(), queryViewId, sOnCreateStart, TraceConfig.KEY_FRAGMENT_CREATE_TO_VIEW_SHOW_TIME);
                }
            } catch (Exception unused) {
            }
        }
    }

    private static void registerOnGlobalLayoutListener(String str, View view, final Integer num, final long j, final String str2) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        if (num == null || num.intValue() <= 0) {
            return;
        }
        sFragmentName = str;
        WeakReference<View> weakReference = sRootViewRef;
        if (weakReference != null && weakReference.get() != view) {
            ViewTreeObserver viewTreeObserver = sRootViewRef.get().getViewTreeObserver();
            if (viewTreeObserver.isAlive() && (onGlobalLayoutListener = sOnGlobalLayoutListener) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            if (sWaitViewTimeoutRunnable != null) {
                ApmHandlerThread.getDefaultMainHandler().removeCallbacks(sWaitViewTimeoutRunnable);
            }
        }
        sRootViewRef = new WeakReference<>(view);
        sCheckVisibilityStartTime = 0L;
        sOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.apm.agent.v2.instrumentation.FragmentTimeAgent.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    if (FragmentTimeAgent.sRootViewRef != null && FragmentTimeAgent.sRootViewRef.get() != null) {
                        View findViewById = ((View) FragmentTimeAgent.sRootViewRef.get()).findViewById(num.intValue());
                        if (FragmentTimeAgent.sCheckVisibilityStartTime == 0) {
                            long unused = FragmentTimeAgent.sCheckVisibilityStartTime = System.currentTimeMillis();
                        }
                        if (findViewById == null || findViewById.getVisibility() != 0 || findViewById.getWidth() <= 0) {
                            return;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (((View) FragmentTimeAgent.sRootViewRef.get()).getViewTreeObserver().isAlive() && FragmentTimeAgent.sOnGlobalLayoutListener != null) {
                            ((View) FragmentTimeAgent.sRootViewRef.get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentTimeAgent.sOnGlobalLayoutListener);
                        }
                        ViewTreeObserver.OnGlobalLayoutListener unused2 = FragmentTimeAgent.sOnGlobalLayoutListener = null;
                        WeakReference unused3 = FragmentTimeAgent.sRootViewRef = null;
                        if (FragmentTimeAgent.sWaitViewTimeoutRunnable != null) {
                            ApmHandlerThread.getDefaultMainHandler().removeCallbacks(FragmentTimeAgent.sWaitViewTimeoutRunnable);
                        }
                        long j2 = currentTimeMillis - j;
                        if (currentTimeMillis - FragmentTimeAgent.sCheckVisibilityStartTime <= 1 || j2 >= FragmentTimeAgent.sMaxWaitTime) {
                            return;
                        }
                        FragmentTimeAgent.reportTraceTime(FragmentTimeAgent.sFragmentName, str2, j, currentTimeMillis);
                    }
                } catch (Exception unused4) {
                }
            }
        };
        view.getViewTreeObserver().addOnGlobalLayoutListener(sOnGlobalLayoutListener);
        sWaitViewTimeoutRunnable = new Runnable() { // from class: com.bytedance.apm.agent.v2.instrumentation.FragmentTimeAgent.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (FragmentTimeAgent.sOnGlobalLayoutListener == null || FragmentTimeAgent.sRootViewRef == null || FragmentTimeAgent.sRootViewRef.get() == null) {
                        return;
                    }
                    ((View) FragmentTimeAgent.sRootViewRef.get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentTimeAgent.sOnGlobalLayoutListener);
                } catch (Exception unused) {
                }
            }
        };
        ApmHandlerThread.getDefaultMainHandler().postDelayed(sWaitViewTimeoutRunnable, sMaxWaitTime);
    }

    private static boolean isValid(String str) {
        return !sReported && TextUtils.equals(str, sFragmentName);
    }
}
