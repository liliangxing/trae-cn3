package com.bytedance.salamander.anniex;

import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.ies.bullet.lynx.DefaultLynxParams;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.notification.Constants;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.rts.foundation.RTSMapKt;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: AnniexMonitorUtilsEventToMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0096\u0001\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u000b\u001a\u00020\f2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t`\n2\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t`\n2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t`\n\u001a*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\r\u001a\u00020\u0011\u001a\u000e\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u000e\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0017\u001a\u000e\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a\u001a*\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u001c\u001a\u00020\u001d\u001a*\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u001c\u001a\u00020\u001f\u001a*\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u000e\u001a\u00020!\u001a*\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u001c\u001a\u00020#\u001a2\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u001c\u001a\u00020%2\u0006\u0010&\u001a\u00020'\u001a*\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u001c\u001a\u00020)\u001a*\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u001c\u001a\u00020+\u001a\u000e\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020.\u001a\u000e\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u000201\u001a\u000e\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u000204¨\u00065"}, d2 = {"bidSourceToString", "", "bidSource", "Lcom/bytedance/salamander/anniex/BidSource;", "clientComponentToString", "clientComponent", "Lcom/bytedance/salamander/anniex/ClientComponent;", "compactEventPayload", "", "", "Lcom/bytedance/rts/foundation/RTSMap;", "eventType", "Lcom/bytedance/salamander/anniex/SLEventType;", "containerBase", "jsBase", "eventInfo", "containerBaseToMap", "Lcom/bytedance/salamander/anniex/ContainerBase;", "containerNameToString", "containerName", "Lcom/bytedance/salamander/anniex/ContainerName;", "containerTypeToString", "containerType", "Lcom/bytedance/salamander/anniex/ContainerType;", "coreViewTypeToString", "coreViewType", "Lcom/bytedance/salamander/anniex/CoreViewType;", "eventToMap", ISignalReportService.BODY_KEY_EVENT, "Lcom/bytedance/salamander/anniex/SLEvent;", "fetchErrorEventInfoToMap", "Lcom/bytedance/salamander/anniex/SLFetchErrorEvent;", "jsBaseToMap", "Lcom/bytedance/salamander/anniex/JsBase;", "jsExceptionEventInfoToMap", "Lcom/bytedance/salamander/anniex/SLJSExceptionEvent;", "jsbErrorEventInfoToMap", "Lcom/bytedance/salamander/anniex/SLJSBErrorEvent;", "config", "Lcom/bytedance/salamander/anniex/SLMonitorContainerConfig;", "jsbPerfEventToMap", "Lcom/bytedance/salamander/anniex/SLJSBPerfEvent;", "pvEventToMap", "Lcom/bytedance/salamander/anniex/SLPVEvent;", "templateResTypeToString", "resType", "Lcom/bytedance/salamander/anniex/TemplateResType;", "viewTypeToString", "viewType", "Lcom/bytedance/salamander/anniex/ViewType;", "webviewTypeToString", "webviewType", "Lcom/bytedance/salamander/anniex/WebviewType;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AnniexMonitorUtilsEventToMapKt {

    /* compiled from: AnniexMonitorUtilsEventToMap.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;
        public static final /* synthetic */ int[] $EnumSwitchMapping$8;

        static {
            int[] iArr = new int[WebviewType.values().length];
            try {
                iArr[WebviewType.TTWebView.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WebviewType.System.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WebviewType.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ContainerType.values().length];
            try {
                iArr2[ContainerType.Lynx.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ContainerType.Web.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ContainerType.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ContainerName.values().length];
            try {
                iArr3[ContainerName.AnnieX.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[TemplateResType.values().length];
            try {
                iArr4[TemplateResType.BuiltIn.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr4[TemplateResType.CDN.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr4[TemplateResType.CDNCache.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr4[TemplateResType.Gecko.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[TemplateResType.GeckoUpdate.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[TemplateResType.Offline.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr4[TemplateResType.TemplateBundle.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr4[TemplateResType.BinaryData.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr4[TemplateResType.Unknown.ordinal()] = 9;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[ViewType.values().length];
            try {
                iArr5[ViewType.Page.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr5[ViewType.Popup.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr5[ViewType.Card.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[CoreViewType.values().length];
            try {
                iArr6[CoreViewType.AnnieXCard.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr6[CoreViewType.BulletCard.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr6[CoreViewType.BDXView.ordinal()] = 3;
            } catch (NoSuchFieldError unused22) {
            }
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[ClientComponent.values().length];
            try {
                iArr7[ClientComponent.View.ordinal()] = 1;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr7[ClientComponent.Activity.ordinal()] = 2;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr7[ClientComponent.DialogFragment.ordinal()] = 3;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr7[ClientComponent.Fragment.ordinal()] = 4;
            } catch (NoSuchFieldError unused26) {
            }
            $EnumSwitchMapping$6 = iArr7;
            int[] iArr8 = new int[BidSource.values().length];
            try {
                iArr8[BidSource.Default.ordinal()] = 1;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr8[BidSource.Schema.ordinal()] = 2;
            } catch (NoSuchFieldError unused28) {
            }
            $EnumSwitchMapping$7 = iArr8;
            int[] iArr9 = new int[SLEventType.values().length];
            try {
                iArr9[SLEventType.JSB_PERF.ordinal()] = 1;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr9[SLEventType.JSB_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr9[SLEventType.JS_EXCEPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr9[SLEventType.FETCH_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr9[SLEventType.PV.ordinal()] = 5;
            } catch (NoSuchFieldError unused33) {
            }
            $EnumSwitchMapping$8 = iArr9;
        }
    }

    public static final Map<String, Object> pvEventToMap(SLPVEvent sLPVEvent) {
        Intrinsics.checkNotNullParameter(sLPVEvent, ISignalReportService.BODY_KEY_EVENT);
        Map<String, Object> containerBaseToMap = containerBaseToMap(sLPVEvent.getContainer_base());
        Map<String, Object> jsBaseToMap = jsBaseToMap(sLPVEvent.getJs_base());
        Map RTSMap = RTSMapKt.RTSMap();
        RTSMapKt.set(RTSMap, "invoke_ts", Long.valueOf(sLPVEvent.getEvent_info().getInvoke_ts()));
        return compactEventPayload(sLPVEvent.eventType(), containerBaseToMap, jsBaseToMap, RTSMap);
    }

    public static final Map<String, Object> jsbPerfEventToMap(SLJSBPerfEvent sLJSBPerfEvent) {
        Intrinsics.checkNotNullParameter(sLJSBPerfEvent, ISignalReportService.BODY_KEY_EVENT);
        Map<String, Object> containerBaseToMap = containerBaseToMap(sLJSBPerfEvent.getContainer_base());
        Map<String, Object> jsBaseToMap = jsBaseToMap(sLJSBPerfEvent.getJs_base());
        Map RTSMap = RTSMapKt.RTSMap();
        RTSMapKt.set(RTSMap, "jsb_name", sLJSBPerfEvent.getEvent_info().getInfo().getJsb_name());
        if (sLJSBPerfEvent.getEvent_info().getInfo().getJsb_protocol_version() != -1) {
            RTSMapKt.set(RTSMap, "jsb_protocol_version", Integer.valueOf(sLJSBPerfEvent.getEvent_info().getInfo().getJsb_protocol_version()));
        }
        Map RTSMap2 = RTSMapKt.RTSMap();
        RTSMapKt.set(RTSMap2, "jsb_call", Long.valueOf(sLJSBPerfEvent.getEvent_info().getPerf().getJsb_call()));
        Map RTSMap3 = RTSMapKt.RTSMap();
        RTSMapKt.set(RTSMap3, "info", RTSMap);
        RTSMapKt.set(RTSMap3, "perf", RTSMap2);
        return compactEventPayload(sLJSBPerfEvent.eventType(), containerBaseToMap, jsBaseToMap, RTSMap3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Map<String, Object> jsExceptionEventInfoToMap(SLJSExceptionEvent sLJSExceptionEvent) {
        Map map;
        String str;
        Intrinsics.checkNotNullParameter(sLJSExceptionEvent, ISignalReportService.BODY_KEY_EVENT);
        Map<String, Object> containerBaseToMap = containerBaseToMap(sLJSExceptionEvent.getContainer_base());
        Map<String, Object> jsBaseToMap = jsBaseToMap(sLJSExceptionEvent.getJs_base());
        if (sLJSExceptionEvent.getEvent_info().getNative_info() != null) {
            map = RTSMapKt.RTSMap();
            if (map != null) {
                NativeInfo native_info = sLJSExceptionEvent.getEvent_info().getNative_info();
                RTSMapKt.set(map, CDNLoader.DIAGNOSE_ERROR_CODE, Integer.valueOf(native_info != null ? native_info.getError_code() : 0));
            }
            if (map != null) {
                NativeInfo native_info2 = sLJSExceptionEvent.getEvent_info().getNative_info();
                if (native_info2 == null || (str = native_info2.getError_msg()) == null) {
                    str = "";
                }
                RTSMapKt.set(map, Constants.EVENT_PARAMS_KEY_ERROR_MSG, str);
            }
        } else {
            map = null;
        }
        JsInfo js_info = sLJSExceptionEvent.getEvent_info().getJs_info();
        if ((js_info != null ? js_info.getException() : null) != null) {
            Map RTSMap = RTSMapKt.RTSMap();
            if (RTSMap != 0) {
                JsInfo js_info2 = sLJSExceptionEvent.getEvent_info().getJs_info();
                r3 = js_info2 != null ? js_info2.getException() : null;
                Intrinsics.checkNotNull(r3);
                RTSMapKt.set(RTSMap, "exception", r3);
            }
            r3 = RTSMap;
        }
        Map RTSMap2 = RTSMapKt.RTSMap();
        RTSMapKt.set(RTSMap2, "error_ts", Long.valueOf(sLJSExceptionEvent.getEvent_info().getError_ts()));
        if (map != null) {
            RTSMapKt.set(RTSMap2, "native_info", map);
        }
        if (r3 != null) {
            RTSMapKt.set(RTSMap2, "js_info", r3);
        }
        if (sLJSExceptionEvent.getEvent_info().getRoot_cause() != null) {
            String root_cause = sLJSExceptionEvent.getEvent_info().getRoot_cause();
            Intrinsics.checkNotNull(root_cause);
            RTSMapKt.set(RTSMap2, "root_cause", root_cause);
        }
        if (sLJSExceptionEvent.getEvent_info().getContext() != null) {
            Map<String, String> context = sLJSExceptionEvent.getEvent_info().getContext();
            Intrinsics.checkNotNull(context);
            if (context.size() > 0) {
                Map<String, String> context2 = sLJSExceptionEvent.getEvent_info().getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type kotlin.Any");
                RTSMapKt.set(RTSMap2, "js_error_context", TypeIntrinsics.asMutableMap(context2));
            }
        }
        return compactEventPayload(sLJSExceptionEvent.eventType(), containerBaseToMap, jsBaseToMap, RTSMap2);
    }

    public static final Map<String, Object> jsbErrorEventInfoToMap(SLJSBErrorEvent sLJSBErrorEvent, SLMonitorContainerConfig sLMonitorContainerConfig) {
        Intrinsics.checkNotNullParameter(sLJSBErrorEvent, ISignalReportService.BODY_KEY_EVENT);
        Intrinsics.checkNotNullParameter(sLMonitorContainerConfig, "config");
        Map<String, Object> containerBaseToMap = containerBaseToMap(sLJSBErrorEvent.getContainer_base());
        Map<String, Object> jsBaseToMap = jsBaseToMap(sLJSBErrorEvent.getJs_base());
        Map RTSMap = RTSMapKt.RTSMap();
        RTSMapKt.set(RTSMap, CDNLoader.DIAGNOSE_ERROR_MESSAGE, sLJSBErrorEvent.getEvent_info().getError_message());
        RTSMapKt.set(RTSMap, "error_ts", Long.valueOf(sLJSBErrorEvent.getEvent_info().getError_ts()));
        RTSMapKt.set(RTSMap, "bridge_name", sLJSBErrorEvent.getEvent_info().getBridge_name());
        RTSMapKt.set(RTSMap, CDNLoader.DIAGNOSE_ERROR_CODE, Integer.valueOf(sLJSBErrorEvent.getEvent_info().getError_code()));
        if (sLJSBErrorEvent.getEvent_info().getRoot_cause() != null) {
            String root_cause = sLJSBErrorEvent.getEvent_info().getRoot_cause();
            Intrinsics.checkNotNull(root_cause);
            RTSMapKt.set(RTSMap, "root_cause", root_cause);
        }
        if (sLMonitorContainerConfig.getEnableJSBParamsReport()) {
            String jsb_params = sLJSBErrorEvent.getEvent_info().getJsb_params();
            if (jsb_params == null) {
                jsb_params = "{}";
            }
            RTSMapKt.set(RTSMap, "jsb_params", jsb_params);
        }
        return compactEventPayload(sLJSBErrorEvent.eventType(), containerBaseToMap, jsBaseToMap, RTSMap);
    }

    public static final Map<String, Object> fetchErrorEventInfoToMap(SLFetchErrorEvent sLFetchErrorEvent) {
        Intrinsics.checkNotNullParameter(sLFetchErrorEvent, ISignalReportService.BODY_KEY_EVENT);
        Map<String, Object> containerBaseToMap = containerBaseToMap(sLFetchErrorEvent.getContainer_base());
        Map<String, Object> jsBaseToMap = jsBaseToMap(sLFetchErrorEvent.getJs_base());
        Map RTSMap = RTSMapKt.RTSMap();
        RTSMapKt.set(RTSMap, "error_no", Integer.valueOf(sLFetchErrorEvent.getEvent_info().getError_no()));
        RTSMapKt.set(RTSMap, Constants.EVENT_PARAMS_KEY_ERROR_MSG, sLFetchErrorEvent.getEvent_info().getError_msg());
        RTSMapKt.set(RTSMap, "method", sLFetchErrorEvent.getEvent_info().getMethod());
        RTSMapKt.set(RTSMap, "url", sLFetchErrorEvent.getEvent_info().getUrl());
        RTSMapKt.set(RTSMap, "jsb_name", sLFetchErrorEvent.getEvent_info().getJsb_name());
        RTSMapKt.set(RTSMap, "status_code", Integer.valueOf(sLFetchErrorEvent.getEvent_info().getStatus_code()));
        RTSMapKt.set(RTSMap, "request_error_code", Integer.valueOf(sLFetchErrorEvent.getEvent_info().getRequest_error_code()));
        RTSMapKt.set(RTSMap, "request_error_msg", sLFetchErrorEvent.getEvent_info().getRequest_error_msg());
        RTSMapKt.set(RTSMap, "error_ts", Long.valueOf(sLFetchErrorEvent.getEvent_info().getError_ts()));
        if (sLFetchErrorEvent.getEvent_info().getLog_id() != null) {
            String log_id = sLFetchErrorEvent.getEvent_info().getLog_id();
            Intrinsics.checkNotNull(log_id);
            RTSMapKt.set(RTSMap, "log_id", log_id);
        }
        if (sLFetchErrorEvent.getEvent_info().getRoot_cause() != null) {
            String root_cause = sLFetchErrorEvent.getEvent_info().getRoot_cause();
            Intrinsics.checkNotNull(root_cause);
            RTSMapKt.set(RTSMap, "root_cause", root_cause);
        }
        return compactEventPayload(sLFetchErrorEvent.eventType(), containerBaseToMap, jsBaseToMap, RTSMap);
    }

    public static final Map<String, Object> containerBaseToMap(ContainerBase containerBase) {
        Intrinsics.checkNotNullParameter(containerBase, "containerBase");
        Map<String, Object> RTSMap = RTSMapKt.RTSMap();
        Map RTSMap2 = RTSMapKt.RTSMap();
        RTSMapKt.set(RTSMap2, MetricConstant.FIELD_CORE_VIEW_TYPE, coreViewTypeToString(containerBase.get__internal().getCore_view_type()));
        RTSMapKt.set(RTSMap2, MetricConstant.FIELD_BIZ, containerBase.get__internal().getBiz());
        RTSMapKt.set(RTSMap2, "hit_sample", Long.valueOf(containerBase.get__internal().getHit_sample()));
        RTSMapKt.set(RTSMap2, "setting_bid", containerBase.get__internal().getSetting_bid());
        RTSMapKt.set(RTSMap2, "setting_id", Long.valueOf(containerBase.get__internal().getSetting_id()));
        if (containerBase.get__internal().getContext().size() > 0) {
            RTSMapKt.set(RTSMap2, "context", containerBase.get__internal().getContext());
        }
        ClientComponent client_component = containerBase.get__internal().getClient_component();
        if ((client_component != null ? Long.valueOf(client_component.getValue()) : null) != null) {
            ClientComponent client_component2 = containerBase.get__internal().getClient_component();
            Intrinsics.checkNotNull(client_component2);
            RTSMapKt.set(RTSMap2, MetricConstant.FIELD_CLIENT_COMPONENT, clientComponentToString(client_component2));
        }
        RTSMapKt.set(RTSMap, "monitor_metric_version", containerBase.getMonitor_metric_version());
        RTSMapKt.set(RTSMap, MetricConstant.CONTAINER_NAME, containerNameToString(containerBase.getContainer_name()));
        RTSMapKt.set(RTSMap, "schema", containerBase.getSchema());
        RTSMapKt.set(RTSMap, "template_res_type", templateResTypeToString(containerBase.getTemplate_res_type()));
        RTSMapKt.set(RTSMap, "view_type", viewTypeToString(containerBase.getView_type()));
        RTSMapKt.set(RTSMap, "navigation_id", containerBase.getNavigation_id());
        RTSMapKt.set(RTSMap, "container_type", containerTypeToString(containerBase.getContainer_type()));
        RTSMapKt.set(RTSMap, "container_reuse", Boolean.valueOf(containerBase.getContainer_reuse()));
        RTSMapKt.set(RTSMap, CommonConstants.SDK_VERSION, containerBase.getSdk_version());
        if (containerBase.getNative_page().length() > 0) {
            RTSMapKt.set(RTSMap, "native_page", containerBase.getNative_page());
        }
        if (containerBase.getGecko_id() != null) {
            String gecko_id = containerBase.getGecko_id();
            Intrinsics.checkNotNull(gecko_id);
            RTSMapKt.set(RTSMap, "gecko_id", gecko_id);
        }
        if (containerBase.getLynx_version() != null) {
            String lynx_version = containerBase.getLynx_version();
            Intrinsics.checkNotNull(lynx_version);
            RTSMapKt.set(RTSMap, "lynx_version", lynx_version);
        }
        WebviewType webview_type = containerBase.getWebview_type();
        if ((webview_type != null ? Long.valueOf(webview_type.getValue()) : null) != null) {
            WebviewType webview_type2 = containerBase.getWebview_type();
            Intrinsics.checkNotNull(webview_type2);
            RTSMapKt.set(RTSMap, "webview_type", webviewTypeToString(webview_type2));
        }
        if (containerBase.getWeb_engine_version() != null) {
            String web_engine_version = containerBase.getWeb_engine_version();
            Intrinsics.checkNotNull(web_engine_version);
            RTSMapKt.set(RTSMap, "web_engine_version", web_engine_version);
        }
        if (containerBase.getUrl() != null) {
            String url = containerBase.getUrl();
            Intrinsics.checkNotNull(url);
            RTSMapKt.set(RTSMap, "url", url);
        }
        RTSMapKt.set(RTSMap, "bid", containerBase.getBid());
        RTSMapKt.set(RTSMap, "bid_source", bidSourceToString(containerBase.getBid_source()));
        if (containerBase.getPid() != null) {
            String pid = containerBase.getPid();
            Intrinsics.checkNotNull(pid);
            RTSMapKt.set(RTSMap, LynxMonitorService.KEY_PID, pid);
        }
        RTSMapKt.set(RTSMap, "__internal", RTSMap2);
        return RTSMap;
    }

    public static final Map<String, Object> jsBaseToMap(JsBase jsBase) {
        Intrinsics.checkNotNullParameter(jsBase, "jsBase");
        Map<String, Object> RTSMap = RTSMapKt.RTSMap();
        if (jsBase.getEnv() != null) {
            String env = jsBase.getEnv();
            Intrinsics.checkNotNull(env);
            RTSMapKt.set(RTSMap, PrefetchRequestConfig.PARAM_TYPE_ENV, env);
        }
        if (jsBase.getRelease() != null) {
            String release = jsBase.getRelease();
            Intrinsics.checkNotNull(release);
            RTSMapKt.set(RTSMap, "release", release);
        }
        if (jsBase.getContext().size() > 0) {
            RTSMapKt.set(RTSMap, "context", jsBase.getContext());
        }
        return RTSMap;
    }

    public static final Map<String, Object> compactEventPayload(SLEventType sLEventType, Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3) {
        Intrinsics.checkNotNullParameter(sLEventType, "eventType");
        Intrinsics.checkNotNullParameter(map, "containerBase");
        Intrinsics.checkNotNullParameter(map2, "jsBase");
        Intrinsics.checkNotNullParameter(map3, "eventInfo");
        Map RTSMap = RTSMapKt.RTSMap();
        Map<String, Object> RTSMap2 = RTSMapKt.RTSMap();
        RTSMapKt.set(RTSMap, ReportConst.KEY_EVENT_TYPE, AnniexMonitorEventTypingsEventKt.eventTypeToString(sLEventType));
        RTSMapKt.set(RTSMap, "container_base", map);
        RTSMapKt.set(RTSMap, "js_base", map2);
        RTSMapKt.set(RTSMap, "event_info", AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().convertMapToJSONString(map3));
        RTSMapKt.set(RTSMap2, "extra", RTSMap);
        return RTSMap2;
    }

    public static final String webviewTypeToString(WebviewType webviewType) {
        Intrinsics.checkNotNullParameter(webviewType, "webviewType");
        int i = WhenMappings.$EnumSwitchMapping$0[webviewType.ordinal()];
        return i != 1 ? i != 2 ? "unknown" : "system" : "ttwebview";
    }

    public static final String containerTypeToString(ContainerType containerType) {
        Intrinsics.checkNotNullParameter(containerType, "containerType");
        int i = WhenMappings.$EnumSwitchMapping$1[containerType.ordinal()];
        return i != 1 ? i != 2 ? "unknown" : "webview" : "lynx";
    }

    public static final String containerNameToString(ContainerName containerName) {
        Intrinsics.checkNotNullParameter(containerName, "containerName");
        int i = WhenMappings.$EnumSwitchMapping$2[containerName.ordinal()];
        return "AnnieX";
    }

    public static final String templateResTypeToString(TemplateResType templateResType) {
        Intrinsics.checkNotNullParameter(templateResType, "resType");
        switch (WhenMappings.$EnumSwitchMapping$3[templateResType.ordinal()]) {
            case 1:
                return "builtin";
            case 2:
                return ResourceInfo.RESOURCE_FROM_CDN;
            case 3:
                return "cdn_cache";
            case 4:
                return ResourceInfo.RESOURCE_FROM_GECKO;
            case 5:
                return RLMonitorReporter.GECKO_UPDATE;
            case 6:
                return ResourceInfo.RESOURCE_FROM_OFFLINE;
            case 7:
                return "template_bundle";
            case 8:
                return "binary_data";
            default:
                return "unknown";
        }
    }

    public static final String viewTypeToString(ViewType viewType) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        int i = WhenMappings.$EnumSwitchMapping$4[viewType.ordinal()];
        return i != 1 ? i != 2 ? "card" : "popup" : "page";
    }

    public static final String coreViewTypeToString(CoreViewType coreViewType) {
        Intrinsics.checkNotNullParameter(coreViewType, "coreViewType");
        int i = WhenMappings.$EnumSwitchMapping$5[coreViewType.ordinal()];
        return i != 2 ? i != 3 ? "AnnieXCard" : "BDXView" : "BulletCard";
    }

    public static final String clientComponentToString(ClientComponent clientComponent) {
        Intrinsics.checkNotNullParameter(clientComponent, "clientComponent");
        int i = WhenMappings.$EnumSwitchMapping$6[clientComponent.ordinal()];
        return i != 2 ? i != 3 ? i != 4 ? "view" : "fragment" : "dialogFragment" : "activity";
    }

    public static final String bidSourceToString(BidSource bidSource) {
        Intrinsics.checkNotNullParameter(bidSource, "bidSource");
        return WhenMappings.$EnumSwitchMapping$7[bidSource.ordinal()] != 2 ? DefaultLynxParams.DEFAULT_LYNX_GROUP_NAME : "schema";
    }

    public static final Map<String, Object> eventToMap(SLEvent sLEvent) {
        Intrinsics.checkNotNullParameter(sLEvent, ISignalReportService.BODY_KEY_EVENT);
        int i = WhenMappings.$EnumSwitchMapping$8[sLEvent.eventType().ordinal()];
        if (i == 1) {
            return jsbPerfEventToMap((SLJSBPerfEvent) sLEvent);
        }
        if (i == 2) {
            return jsbErrorEventInfoToMap((SLJSBErrorEvent) sLEvent, new SLMonitorContainerConfig(null, false, 3, null));
        }
        if (i == 3) {
            return jsExceptionEventInfoToMap((SLJSExceptionEvent) sLEvent);
        }
        if (i == 4) {
            return fetchErrorEventInfoToMap((SLFetchErrorEvent) sLEvent);
        }
        if (i == 5) {
            return pvEventToMap((SLPVEvent) sLEvent);
        }
        return RTSMapKt.RTSMap();
    }
}
