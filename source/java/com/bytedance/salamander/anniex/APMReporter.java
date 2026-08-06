package com.bytedance.salamander.anniex;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorReportAPM.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/salamander/anniex/APMReporter;", "", "()V", "report", "", "eventType", "Lcom/bytedance/salamander/anniex/SLEventType;", "result", "", "", "Lcom/bytedance/rts/foundation/RTSMap;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class APMReporter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String LOG_TYPE_P_ZERO = "bd_hybrid_monitor_p_zero";
    private static String LOG_TYPE_P_ONE = "bd_hybrid_monitor_p_one";
    private static String LOG_TYPE_NORMAL = "bd_hybrid_monitor_normal";

    /* compiled from: AnniexMonitorReportAPM.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SLEventType.values().length];
            try {
                iArr[SLEventType.PV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SLEventType.STATIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SLEventType.JS_EXCEPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SLEventType.FETCH_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SLEventType.JSB_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SLEventType.NATIVE_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SLEventType.STATIC_SRI.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SLEventType.RES_LOADER_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SLEventType.RES_LOADER_ERROR_TEMPLATE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SLEventType.CONTAINER_ERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SLEventType.PERFORMANCE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[SLEventType.AJAX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[SLEventType.BLANK.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[SLEventType.RES_LOADER_PERF.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[SLEventType.RES_LOADER_PERF_TEMPLATE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void report(SLEventType eventType, Map<String, Object> result) {
        String str;
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(result, "result");
        switch (WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
            case 1:
                str = LOG_TYPE_P_ZERO;
                break;
            case 2:
                str = LOG_TYPE_P_ZERO;
                break;
            case 3:
                str = LOG_TYPE_P_ZERO;
                break;
            case 4:
                str = LOG_TYPE_P_ZERO;
                break;
            case 5:
                str = LOG_TYPE_P_ZERO;
                break;
            case 6:
                str = LOG_TYPE_P_ZERO;
                break;
            case 7:
                str = LOG_TYPE_P_ZERO;
                break;
            case 8:
                str = LOG_TYPE_P_ZERO;
                break;
            case 9:
                str = LOG_TYPE_P_ZERO;
                break;
            case 10:
                str = LOG_TYPE_P_ZERO;
                break;
            case 11:
                str = LOG_TYPE_P_ONE;
                break;
            case 12:
                str = LOG_TYPE_P_ONE;
                break;
            case 13:
                str = LOG_TYPE_P_ONE;
                break;
            case 14:
                str = LOG_TYPE_P_ONE;
                break;
            case 15:
                str = LOG_TYPE_P_ONE;
                break;
            default:
                str = LOG_TYPE_NORMAL;
                break;
        }
        AnniexMonitorFoundationImplALogImplKt.getALogImpl().mo360d("SLMonitor report: ", AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().convertMapToJSONString(result));
        AnniexMonitorFoundationImplHeimdallrImplKt.getHeimdallrImpl().monitorCommonLog(str, result);
        Iterator<T> it = SLAnnieXMonitorManager.INSTANCE.getInstance().getReportListeners().iterator();
        while (it.hasNext()) {
            ((ISLMonitorReportListener) it.next()).onEventReport(AnniexMonitorEventTypingsEventKt.eventTypeToString(eventType), result, "event_upload");
        }
    }

    /* compiled from: AnniexMonitorReportAPM.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/salamander/anniex/APMReporter$Companion;", "", "()V", "LOG_TYPE_NORMAL", "", "getLOG_TYPE_NORMAL", "()Ljava/lang/String;", "setLOG_TYPE_NORMAL", "(Ljava/lang/String;)V", "LOG_TYPE_P_ONE", "getLOG_TYPE_P_ONE", "setLOG_TYPE_P_ONE", "LOG_TYPE_P_ZERO", "getLOG_TYPE_P_ZERO", "setLOG_TYPE_P_ZERO", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public String getLOG_TYPE_P_ZERO() {
            return APMReporter.LOG_TYPE_P_ZERO;
        }

        public void setLOG_TYPE_P_ZERO(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            APMReporter.LOG_TYPE_P_ZERO = str;
        }

        public String getLOG_TYPE_P_ONE() {
            return APMReporter.LOG_TYPE_P_ONE;
        }

        public void setLOG_TYPE_P_ONE(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            APMReporter.LOG_TYPE_P_ONE = str;
        }

        public String getLOG_TYPE_NORMAL() {
            return APMReporter.LOG_TYPE_NORMAL;
        }

        public void setLOG_TYPE_NORMAL(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            APMReporter.LOG_TYPE_NORMAL = str;
        }
    }
}
