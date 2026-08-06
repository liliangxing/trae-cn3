package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* compiled from: AnniexMonitorReportAPM.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"apmReporter", "Lcom/bytedance/salamander/anniex/APMReporter;", "getApmReporter", "()Lcom/bytedance/salamander/anniex/APMReporter;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AnniexMonitorReportAPMKt {
    private static final APMReporter apmReporter = new APMReporter();

    public static final APMReporter getApmReporter() {
        return apmReporter;
    }
}
