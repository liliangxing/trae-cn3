package com.bytedance.android.monitorV2.lynx;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.lynx.impl.LynxViewDataManager;
import com.lynx.tasm.eventreport.ILynxEventReportObserver;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MonitorSDKEventReporterObserver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002J0\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00052\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002JF\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u000f0\u00142\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u0014H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/MonitorSDKEventReporterObserver;", "Lcom/lynx/tasm/eventreport/ILynxEventReportObserver;", "()V", "jsbInfoParamList", "", "", "isInfoParam", "", "param", "onEventPost", "", "sessionId", "eventName", "params", "", "", "onReportEvent", "instanceId", "", "props", "", "extraData", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MonitorSDKEventReporterObserver implements ILynxEventReportObserver {
    public static final String JSB_REPORT_INFO = "info";
    public static final String JSB_REPORT_PERF = "perf";
    public static final String JSB_TIMING = "lynxsdk_jsb_timing";
    private final List<String> jsbInfoParamList = CollectionsKt.listOf(new String[]{"jsb_module_name", "jsb_method_name", "jsb_name", "jsb_protocol_version", "jsb_bridgesdk", "jsb_status_code"});

    public void onReportEvent(String eventName, int instanceId, Map<String, ? extends Object> props, Map<String, ? extends Object> extraData) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(props, "props");
        if (Intrinsics.areEqual(eventName, JSB_TIMING)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(props);
            if (extraData != null) {
                linkedHashMap.putAll(extraData);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (isInfoParam((String) entry.getKey())) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                } else {
                    linkedHashMap3.put(entry.getKey(), entry.getValue());
                }
            }
            Object obj = extraData != null ? extraData.get(LynxViewMonitor.BDX_MONITOR_SESSION_ID) : null;
            String str = obj instanceof String ? (String) obj : null;
            onEventPost(str, ReportConst.Event.JSB_PAGE_VISIT, linkedHashMap2);
            Map<String, ? extends Object> linkedHashMap4 = new LinkedHashMap<>();
            linkedHashMap4.put("info", linkedHashMap2);
            linkedHashMap4.put("perf", linkedHashMap3);
            Unit unit = Unit.INSTANCE;
            onEventPost(str, ReportConst.Event.JSB_PER_V2, linkedHashMap4);
        }
    }

    private final boolean isInfoParam(String param) {
        return this.jsbInfoParamList.contains(param);
    }

    private final void onEventPost(String sessionId, String eventName, Map<String, ? extends Object> params) {
        LynxViewDataManager bySessionId;
        CommonEvent commonEvent = new CommonEvent(eventName);
        commonEvent.onEventCreated();
        if (params == null || sessionId == null) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
            return;
        }
        commonEvent.setNativeInfo(new LynxViewMonitor.EventNativeInfo(ReportConst.Event.JSB_PAGE_VISIT, new JSONObject(params)));
        if (commonEvent.terminateIf(Switches.lynxJsb.not(), HybridEvent.TerminateType.SWITCH_OFF) || (bySessionId = LynxViewDataManager.INSTANCE.getBySessionId(sessionId)) == null) {
            return;
        }
        bySessionId.onEventPost(commonEvent);
    }
}
