package com.bytedance.apm.trace.model.cross;

import com.bytedance.apm.trace.api.TracingContext;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class TracingCrossManager {
    private static Map<Long, TracingContext> sCrossTracingContext = new ConcurrentHashMap();

    public static void registerCross(long j, TracingContext tracingContext) {
        sCrossTracingContext.put(Long.valueOf(j), tracingContext);
    }

    public static void unRegisterCross(long j) {
        sCrossTracingContext.remove(Long.valueOf(j));
    }

    public static void onPassBackAsChild(String str, String str2, ArrayList<NativeSpan> arrayList) {
        TracingContext tracingContext = sCrossTracingContext.get(Long.valueOf(Long.parseLong(str)));
        if (tracingContext != null) {
            sCrossTracingContext.remove(Long.valueOf(Long.parseLong(str)));
            tracingContext.assembleAsChild(str2, arrayList);
        }
    }

    public static void onPassBackAsReference(String str, String str2, ArrayList<NativeSpan> arrayList) {
        TracingContext tracingContext = sCrossTracingContext.get(Long.valueOf(Long.parseLong(str)));
        if (tracingContext != null) {
            sCrossTracingContext.remove(Long.valueOf(Long.parseLong(str)));
            tracingContext.assembleAsReference(str2, arrayList);
        }
    }
}
