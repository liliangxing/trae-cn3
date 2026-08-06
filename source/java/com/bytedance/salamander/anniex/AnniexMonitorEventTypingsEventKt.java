package com.bytedance.salamander.anniex;

import com.bytedance.android.monitorV2.constant.ReportConst;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorEventTypingsEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"eventTypeToString", "", "eventType", "Lcom/bytedance/salamander/anniex/SLEventType;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class AnniexMonitorEventTypingsEventKt {

    /* compiled from: AnniexMonitorEventTypingsEvent.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SLEventType.values().length];
            try {
                iArr[SLEventType.PV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SLEventType.FETCH_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SLEventType.JSB_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SLEventType.JSB_PERF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SLEventType.JS_EXCEPTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SLEventType.PERFORMANCE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SLEventType.BLANK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SLEventType.JSB_PAGE_VISIT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SLEventType.NATIVE_ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SLEventType.CONTAINER_ERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SLEventType.RESOURCE_PERFORMANCE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[SLEventType.RES_LOADER_PERF.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[SLEventType.RES_LOADER_PERF_TEMPLATE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[SLEventType.RES_LOADER_ERROR.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[SLEventType.RES_LOADER_ERROR_TEMPLATE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[SLEventType.AJAX.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[SLEventType.STATIC.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[SLEventType.STATIC_SRI.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String eventTypeToString(SLEventType eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        switch (WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
            case 1:
                return "navigation_start";
            case 2:
                return "fetch_error";
            case 3:
                return "jsb_error";
            case 4:
                return "jsb_perf";
            case 5:
                return ReportConst.Event.JS_EXCEPTION;
            case 6:
                return "performance";
            case 7:
                return "blank";
            case 8:
                return "jsb_pv";
            case 9:
                return "native_error";
            case 10:
                return "container_error";
            case 11:
                return "resource_performance";
            case 12:
                return ReportConst.Event.RES_LOADER_PERF;
            case 13:
                return ReportConst.Event.RES_LOADER_PERF_TEMPLATE;
            case 14:
                return ReportConst.Event.RES_LOADER_ERROR;
            case 15:
                return ReportConst.Event.RES_LOADER_ERROR_TEMPLATE;
            case 16:
                return ReportConst.Event.AJAX;
            case 17:
                return "static";
            case 18:
                return ReportConst.Event.STATIC_SRI;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
