package com.bytedance.android.monitorV2.listener;

import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.checker.DoubleReportChecker;
import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.event.EventInfo;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.standard.ContainerStandardConst;
import com.bytedance.android.monitorV2.util.ExtensionKt;
import com.bytedance.android.monitorV2.util.JsonAccessor;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.util.UrlUtil;
import com.bytedance.android.monitorV2.webview.constant.WebViewMonitorConstant;
import com.bytedance.applog.GameReportHelper;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: EventTraceToTea.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/monitorV2/listener/EventTraceToTea;", "Lcom/bytedance/android/monitorV2/listener/IBusinessEventListener;", "()V", "allowEventTypeSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "onEventCreated", "", "eventInfo", "Lcom/bytedance/android/monitorV2/event/EventInfo;", "onEventSampled", "onEventTerminated", "onEventUpdated", "onEventUploaded", "traceToTea", "eventStage", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class EventTraceToTea implements IBusinessEventListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean isInit;
    private final HashSet<String> allowEventTypeSet = SetsKt.hashSetOf(new String[]{"navigationStart", "performance", "perf"});

    @Override // com.bytedance.android.monitorV2.listener.IBusinessEventListener
    public void onEventUpdated(EventInfo eventInfo) {
        Intrinsics.checkNotNullParameter(eventInfo, "eventInfo");
    }

    @Override // com.bytedance.android.monitorV2.listener.IBusinessEventListener
    public void onEventCreated(EventInfo eventInfo) {
        Intrinsics.checkNotNullParameter(eventInfo, "eventInfo");
        traceToTea(eventInfo, "event_create");
    }

    @Override // com.bytedance.android.monitorV2.listener.IBusinessEventListener
    public void onEventTerminated(EventInfo eventInfo) {
        Intrinsics.checkNotNullParameter(eventInfo, "eventInfo");
        traceToTea(eventInfo, "event_terminated");
    }

    @Override // com.bytedance.android.monitorV2.listener.IBusinessEventListener
    public void onEventSampled(EventInfo eventInfo) {
        Intrinsics.checkNotNullParameter(eventInfo, "eventInfo");
        traceToTea(eventInfo, "event_unsampled");
    }

    @Override // com.bytedance.android.monitorV2.listener.IBusinessEventListener
    public void onEventUploaded(EventInfo eventInfo) {
        Intrinsics.checkNotNullParameter(eventInfo, "eventInfo");
        traceToTea(eventInfo, "event_uploaded");
    }

    private final void traceToTea(EventInfo eventInfo, String eventStage) {
        String str;
        String safeOptStr;
        if (this.allowEventTypeSet.contains(eventInfo.getEventType())) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.deepCopy(jSONObject, eventInfo.getInfo());
            JsonAccessor access = ExtensionKt.access(jSONObject);
            JSONObject safeOptJsonObj = JsonUtils.safeOptJsonObj(jSONObject, "nativeBase");
            JSONObject safeOptJsonObj2 = JsonUtils.safeOptJsonObj(safeOptJsonObj, ReportConst.Params.BID_INFO);
            JSONObject safeOptJsonObj3 = JsonUtils.safeOptJsonObj(jSONObject, "containerBase");
            String safeOptStr2 = JsonUtils.safeOptStr(safeOptJsonObj2, "bid");
            String safeOptStr3 = JsonUtils.safeOptStr(safeOptJsonObj2, ReportConst.Params.SETTING_BID);
            String safeOptStr4 = JsonUtils.safeOptStr(safeOptJsonObj2, "config_bid");
            String safeOptStr5 = JsonUtils.safeOptStr(safeOptJsonObj3, "container_name", null);
            String safeOptStr6 = JsonUtils.safeOptStr(safeOptJsonObj3, "schema", null);
            String safeOptStr7 = JsonUtils.safeOptStr(safeOptJsonObj3, "version", null);
            String safeOptStr8 = JsonUtils.safeOptStr(safeOptJsonObj3, ContainerStandardConst.FIELD_VIEW_TYPE, null);
            String safeOptStr9 = JsonUtils.safeOptStr(safeOptJsonObj3, "biz", null);
            String safeOptStr10 = JsonUtils.safeOptStr(safeOptJsonObj3, ContainerStandardConst.FIELD_CORE_VIEW_TYPE, null);
            String safeOptStr11 = JsonUtils.safeOptStr(safeOptJsonObj3, "core_component", null);
            String eventType = eventInfo.getEventType();
            String safeOptStr12 = JsonUtils.safeOptStr(safeOptJsonObj, "url");
            UrlUtil urlUtil = UrlUtil.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(safeOptStr12, "fFullUrl");
            String formatUrl = urlUtil.getFormatUrl(safeOptStr12);
            String safeOptStr13 = JsonUtils.safeOptStr(safeOptJsonObj, "virtual_aid");
            String safeOptStr14 = JsonUtils.safeOptStr(safeOptJsonObj, "container_type");
            String safeOptStr15 = JsonUtils.safeOptStr(safeOptJsonObj, "sdk_version");
            String safeOptStr16 = JsonUtils.safeOptStr(safeOptJsonObj, "page_version");
            if (Intrinsics.areEqual(safeOptStr14, "web")) {
                str = safeOptStr16;
                safeOptStr = JsonUtils.safeOptStr(safeOptJsonObj, ReportConst.WEB_VERSION);
            } else {
                str = safeOptStr16;
                safeOptStr = Intrinsics.areEqual(safeOptStr14, "lynx") ? JsonUtils.safeOptStr(safeOptJsonObj, "lynx_version") : "";
            }
            String str2 = safeOptStr;
            String safeOptStr17 = Intrinsics.areEqual(safeOptStr14, "web") ? JsonUtils.safeOptStr(safeOptJsonObj, "webview_type") : "";
            JSONObject jSONObject2 = new JSONObject();
            if (HybridEvent.EventPhase.EVENT_CREATE != eventInfo.getState().getEventPhase()) {
                JsonUtils.putIfNotBlank(jSONObject2, "bid", safeOptStr2);
                JsonUtils.putIfNotBlank(jSONObject2, ReportConst.Params.SETTING_BID, safeOptStr3);
                JsonUtils.putIfNotBlank(jSONObject2, "container_bid", safeOptStr4);
            }
            JsonUtils.putIfNotBlank(jSONObject2, "container_name", safeOptStr5);
            JsonUtils.putIfNotBlank(jSONObject2, "schema", safeOptStr6);
            JsonUtils.putIfNotBlank(jSONObject2, "version", safeOptStr7);
            JsonUtils.putIfNotBlank(jSONObject2, ContainerStandardConst.FIELD_VIEW_TYPE, safeOptStr8);
            JsonUtils.putIfNotBlank(jSONObject2, "biz", safeOptStr9);
            JsonUtils.putIfNotBlank(jSONObject2, ContainerStandardConst.FIELD_CORE_VIEW_TYPE, safeOptStr10);
            JsonUtils.putIfNotBlank(jSONObject2, "core_component", safeOptStr11);
            JsonUtils.putIfNotBlank(jSONObject2, MonitorConstant.STAGE, eventStage);
            JsonUtils.putIfNotBlank(jSONObject2, "event_type", eventType);
            JsonUtils.putIfNotBlank(jSONObject2, WebViewMonitorConstant.Web.FULL_URL, safeOptStr12);
            JsonUtils.putIfNotBlank(jSONObject2, WebViewMonitorConstant.Web.FORMAT_URL, formatUrl);
            JsonUtils.putIfNotBlank(jSONObject2, "virtual_aid", safeOptStr13);
            JsonUtils.putIfNotBlank(jSONObject2, "engine_type", safeOptStr14);
            JsonUtils.putIfNotBlank(jSONObject2, "sdk_version", safeOptStr15);
            JsonUtils.putIfNotBlank(jSONObject2, "page_version", str);
            JsonUtils.putIfNotBlank(jSONObject2, "engine_version", str2);
            JsonUtils.putIfNotBlank(jSONObject2, "webview_type", safeOptStr17);
            ExtensionKt.putAnyIfNotNull(jSONObject2, "annie_is_card", access.get("containerBase.context.annie_is_card"));
            DoubleReportChecker.INSTANCE.reportTea("hybrid_monitor_sdk_trace", jSONObject2);
        }
    }

    /* compiled from: EventTraceToTea.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/listener/EventTraceToTea$Companion;", "", "()V", "isInit", "", GameReportHelper.REGISTER, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void register() {
            if (!EventTraceToTea.isInit && Switches.teaReport.isEnabled()) {
                HybridMultiMonitor.getInstance().registerBusinessEventListener(new EventTraceToTea());
                EventTraceToTea.isInit = true;
            }
        }
    }
}
