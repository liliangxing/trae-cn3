package com.bytedance.android.monitorV2.base;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IReportData {
    void addTag(String str, Object obj);

    IMonitorData getContainerBase();

    IMonitorData getContainerInfo();

    String getContainerType();

    String getEventType();

    JSONObject getJsBase();

    JSONObject getJsInfo();

    IMonitorData getNativeBase();

    BaseNativeInfo getNativeInfo();

    Map<String, Object> getTags();
}
