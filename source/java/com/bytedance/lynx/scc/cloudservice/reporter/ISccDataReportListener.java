package com.bytedance.lynx.scc.cloudservice.reporter;

import java.util.Map;

/* loaded from: classes4.dex */
public interface ISccDataReportListener {
    void onDataReport(String event, Map<String, String> map);
}
