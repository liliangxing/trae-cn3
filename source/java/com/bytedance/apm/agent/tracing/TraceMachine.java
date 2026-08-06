package com.bytedance.apm.agent.tracing;

import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.apm.util.ThreadUtils;
import java.util.HashSet;
import java.util.Stack;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TraceMachine {
    private static final String TAG = "TraceMachine";
    private static ThreadLocal<Stack<Trace>> traceStackThreadLocal = new ThreadLocal<>();
    private static HashSet<String> sMethodSet = new HashSet<>(32);
    private static AgentLog log = AgentLogManager.getAgentLog();

    public static void enterMethod(String str, String str2, String str3, String str4) {
        Trace trace = new Trace(str, str2, str3, System.currentTimeMillis(), str4);
        if (traceStackThreadLocal.get() == null) {
            Stack<Trace> stack = new Stack<>();
            stack.push(trace);
            traceStackThreadLocal.set(stack);
            return;
        }
        traceStackThreadLocal.get().push(trace);
    }

    public static void enterMethod(String str, String str2, String str3) {
        enterMethod(str, str, str2, str3);
    }

    public static void exitMethod() {
        exitMethod("");
    }

    public static void exitMethod(String str) {
        if (traceStackThreadLocal.get() == null) {
            return;
        }
        Stack<Trace> stack = traceStackThreadLocal.get();
        if (stack.isEmpty()) {
            return;
        }
        Trace pop = stack.pop();
        pop.setExitTime(System.currentTimeMillis());
        pop.setExtraData(str);
        handleCost(pop);
    }

    @Deprecated
    private static void handleCost(Trace trace) {
        try {
            long j = trace.entryTime;
            long j2 = trace.exitTime;
            long longValue = Long.valueOf(j2 - j).longValue();
            if (longValue > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AgentConstants.BEGIN_TIME, j);
                jSONObject.put("end_time", j2);
                JSONObject jSONObject2 = new JSONObject();
                if ("page_load".equals(trace.traceType)) {
                    jSONObject2.put(trace.methodName, longValue);
                } else {
                    jSONObject2.put(trace.className + "#" + trace.methodName, longValue);
                }
                JSONObject jSONObject3 = new JSONObject();
                if ("page_load".equals(trace.traceType)) {
                    jSONObject3.put("scene", trace.scene);
                    jSONObject3.put("is_first", !sMethodSet.contains(new StringBuilder().append(trace.className).append(trace.methodName).toString()));
                    sMethodSet.add(trace.className + trace.methodName);
                } else {
                    jSONObject3.put("is_main", ThreadUtils.isMainThread());
                }
                jSONObject.put("extra_data", trace.extraData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
