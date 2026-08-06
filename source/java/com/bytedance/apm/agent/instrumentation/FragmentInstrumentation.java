package com.bytedance.apm.agent.instrumentation;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.helper.PageShowHelper;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.thread.ApmHandlerThread;
import com.bytedance.apm.trace.TraceConfig;
import com.bytedance.apm.trace.mapping.ApmPageLoadMappingTool;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FragmentInstrumentation {
    private static final String TAG = "FragmentInstrumentation";
    private static long sCheckVisibilityStartTime;
    private static String sFragmentName;
    private static long sMaxWaitTime;
    private static HashSet<String> sMethodSet = new HashSet<>(32);
    private static long sOnActivityCreatedEnd;
    private static long sOnActivityCreatedStart;
    private static long sOnCreateEnd;
    private static String sOnCreateFragmentName;
    private static long sOnCreateStart;
    private static long sOnCreateTime;
    private static ViewTreeObserver.OnGlobalLayoutListener sOnGlobalLayoutListener;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnViewCreatedEnd;
    private static long sOnViewCreatedStart;
    private static WeakReference<View> sRootViewRef;
    private static Runnable sWaitViewTimeoutRunnable;

    public static void onResume(Fragment fragment) {
        if (!fragment.getUserVisibleHint() || fragment.isHidden()) {
            return;
        }
        String canonicalName = fragment.getClass().getCanonicalName();
        try {
            PageShowHelper.onPageShowHideAction(fragment, true);
            if (TextUtils.equals(canonicalName, sOnCreateFragmentName)) {
                registerOnGlobalLayoutListener(canonicalName, fragment.getView(), ApmPageLoadMappingTool.queryViewId(canonicalName), sOnCreateTime, TraceConfig.KEY_FRAGMENT_CREATE_TO_VIEW_SHOW_TIME);
            }
        } catch (Exception unused) {
        }
    }

    public static void onPause(Fragment fragment) {
        if (!fragment.getUserVisibleHint() || fragment.isHidden()) {
            return;
        }
        PageShowHelper.onPageShowHideAction(fragment, false);
    }

    public static void onHiddenChanged(Fragment fragment, boolean z) {
        PageShowHelper.onPageShowHideAction(fragment, !z);
        if (z) {
            return;
        }
        try {
            String canonicalName = fragment.getClass().getCanonicalName();
            registerOnGlobalLayoutListener(canonicalName, fragment.getView(), ApmPageLoadMappingTool.queryViewId(canonicalName), System.currentTimeMillis(), TraceConfig.KEY_FRAGMENT_HIDECHANGED_TO_VIEW_SHOW_TIME);
        } catch (Exception unused) {
        }
    }

    public static void setUserVisibleHint(Fragment fragment, boolean z) {
        if (!fragment.isResumed() || fragment.isHidden()) {
            return;
        }
        PageShowHelper.onPageShowHideAction(fragment, z);
        if (z) {
            try {
                String canonicalName = fragment.getClass().getCanonicalName();
                registerOnGlobalLayoutListener(canonicalName, fragment.getView(), ApmPageLoadMappingTool.queryViewId(canonicalName), System.currentTimeMillis(), TraceConfig.KEY_FRAGMENT_VISIBLEHINT_TO_VIEW_SHOW_TIME);
            } catch (Exception unused) {
            }
        }
    }

    public static void onCreate(String str) {
        sOnCreateFragmentName = str;
        sOnCreateTime = System.currentTimeMillis();
        if (sMaxWaitTime == 0) {
            sMaxWaitTime = ApmDelegate.getInstance().getApmInitConfig().getMaxValidPageLoadTimeMs();
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
        sOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.apm.agent.instrumentation.FragmentInstrumentation.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    if (FragmentInstrumentation.sRootViewRef != null && FragmentInstrumentation.sRootViewRef.get() != null) {
                        View findViewById = ((View) FragmentInstrumentation.sRootViewRef.get()).findViewById(num.intValue());
                        if (FragmentInstrumentation.sCheckVisibilityStartTime == 0) {
                            long unused = FragmentInstrumentation.sCheckVisibilityStartTime = System.currentTimeMillis();
                        }
                        if (findViewById == null || findViewById.getVisibility() != 0 || findViewById.getWidth() <= 0) {
                            return;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (((View) FragmentInstrumentation.sRootViewRef.get()).getViewTreeObserver().isAlive() && FragmentInstrumentation.sOnGlobalLayoutListener != null) {
                            ((View) FragmentInstrumentation.sRootViewRef.get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentInstrumentation.sOnGlobalLayoutListener);
                        }
                        ViewTreeObserver.OnGlobalLayoutListener unused2 = FragmentInstrumentation.sOnGlobalLayoutListener = null;
                        WeakReference unused3 = FragmentInstrumentation.sRootViewRef = null;
                        if (FragmentInstrumentation.sWaitViewTimeoutRunnable != null) {
                            ApmHandlerThread.getDefaultMainHandler().removeCallbacks(FragmentInstrumentation.sWaitViewTimeoutRunnable);
                        }
                        long j2 = currentTimeMillis - j;
                        if (currentTimeMillis - FragmentInstrumentation.sCheckVisibilityStartTime <= 1 || j2 >= FragmentInstrumentation.sMaxWaitTime) {
                            return;
                        }
                        MonitorTool.reportTraceTime(FragmentInstrumentation.sFragmentName, str2, j2);
                    }
                } catch (Exception unused4) {
                }
            }
        };
        view.getViewTreeObserver().addOnGlobalLayoutListener(sOnGlobalLayoutListener);
        sWaitViewTimeoutRunnable = new Runnable() { // from class: com.bytedance.apm.agent.instrumentation.FragmentInstrumentation.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (FragmentInstrumentation.sOnGlobalLayoutListener == null || FragmentInstrumentation.sRootViewRef == null || FragmentInstrumentation.sRootViewRef.get() == null) {
                        return;
                    }
                    ((View) FragmentInstrumentation.sRootViewRef.get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentInstrumentation.sOnGlobalLayoutListener);
                } catch (Exception unused) {
                }
            }
        };
        ApmHandlerThread.getDefaultMainHandler().postDelayed(sWaitViewTimeoutRunnable, sMaxWaitTime);
    }

    static boolean isValid(String str) {
        return !TextUtils.isEmpty(sFragmentName) && TextUtils.equals(str, sFragmentName);
    }

    public static void onTrace(Fragment fragment, String str, String str2, boolean z) {
        if (TextUtils.equals("onCreate", str2)) {
            if (z) {
                sFragmentName = str;
                sOnCreateStart = System.currentTimeMillis();
                return;
            } else {
                if (isValid(str)) {
                    sOnCreateEnd = System.currentTimeMillis();
                    return;
                }
                return;
            }
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
                    return;
                }
                return;
            }
            if (sOnCreateStart > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                sOnResumeEnd = currentTimeMillis;
                if (currentTimeMillis - sOnCreateStart < PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(AgentConstants.BEGIN_TIME, sOnCreateStart);
                        jSONObject.put("end_time", sOnResumeEnd);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("onCreate", sOnCreateEnd - sOnCreateStart);
                        jSONObject2.put("onViewCreated", sOnViewCreatedEnd - sOnViewCreatedStart);
                        jSONObject2.put("onActivityCreated", sOnActivityCreatedEnd - sOnActivityCreatedStart);
                        jSONObject2.put("onResume", sOnResumeEnd - sOnResumeStart);
                        jSONObject2.put("fragment_create_to_resume", sOnResumeEnd - sOnCreateStart);
                        if (fragment != null && fragment.getActivity() != null) {
                            jSONObject.put("attached_activity", fragment.getActivity().getClass().getName());
                        }
                        jSONObject.put("page_type", "fragment");
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("is_first", !sMethodSet.contains(new StringBuilder().append(sFragmentName).append(str2).toString()));
                        jSONObject3.put("scene", str);
                        sMethodSet.add(sFragmentName + str2);
                        MonitorTool.monitorPerformance("page_load", jSONObject2, jSONObject3, jSONObject);
                    } catch (Exception unused) {
                    }
                }
                sOnCreateStart = 0L;
                sFragmentName = null;
            }
        }
    }
}
