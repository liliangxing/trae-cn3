package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.tracing.TraceMachine;
import com.bytedance.apm.constant.AgentConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JSONObjectInstrumentation {
    private static final String TAG = "JSONInstrumentation";

    public static JSONObject init(String str) throws Exception {
        TraceMachine.enterMethod("JSONObject", "init", AgentConstants.TRACE_TYPE_JSON);
        JSONObject jSONObject = new JSONObject(str);
        TraceMachine.exitMethod();
        return jSONObject;
    }
}
