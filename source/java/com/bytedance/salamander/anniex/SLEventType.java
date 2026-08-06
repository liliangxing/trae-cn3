package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* compiled from: AnniexMonitorEventTypingsEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/salamander/anniex/SLEventType;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "PV", "FETCH_ERROR", "JSB_ERROR", "JSB_PERF", "JS_EXCEPTION", "PERFORMANCE", "BLANK", "JSB_PAGE_VISIT", "NATIVE_ERROR", "CONTAINER_ERROR", "RESOURCE_PERFORMANCE", "RES_LOADER_PERF", "RES_LOADER_PERF_TEMPLATE", "RES_LOADER_ERROR", "RES_LOADER_ERROR_TEMPLATE", "AJAX", "STATIC", "STATIC_SRI", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public enum SLEventType {
    PV(0),
    FETCH_ERROR(1),
    JSB_ERROR(2),
    JSB_PERF(3),
    JS_EXCEPTION(4),
    PERFORMANCE(5),
    BLANK(6),
    JSB_PAGE_VISIT(7),
    NATIVE_ERROR(8),
    CONTAINER_ERROR(9),
    RESOURCE_PERFORMANCE(10),
    RES_LOADER_PERF(11),
    RES_LOADER_PERF_TEMPLATE(12),
    RES_LOADER_ERROR(13),
    RES_LOADER_ERROR_TEMPLATE(14),
    AJAX(15),
    STATIC(16),
    STATIC_SRI(17);

    private final long value;

    SLEventType(long j) {
        this.value = j;
    }

    public final long getValue() {
        return this.value;
    }
}
