package com.bytedance.webx.base;

import com.bytedance.webx.base.report.IReportAgent;

/* loaded from: classes6.dex */
public class WebXConfig {
    private static IReportAgent reportAgent;

    public static IReportAgent getReportAgent() {
        return reportAgent;
    }

    public static void setReportAgent(IReportAgent iReportAgent) {
        reportAgent = iReportAgent;
    }
}
