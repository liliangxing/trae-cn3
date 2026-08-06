package com.bytedance.android.monitor.base;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IReportData {
    String getBiz();

    IMonitorData getContainerBase();

    IMonitorData getContainerInfo();

    String getContainerType();

    String getEventType();

    JSONObject getJsBase();

    JSONObject getJsInfo();

    IMonitorData getNativeBase();

    BaseNativeInfo getNativeInfo();
}
