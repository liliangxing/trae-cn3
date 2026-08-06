package com.bytedance.perf.monitor;

import org.json.JSONArray;

/* loaded from: classes4.dex */
public class SliverEvilMethodDetector {
    private static final String TAG = "EvilMethod_Detector";
    private static IPluginInfoCallBack mPluginInfoCallBack;
    private static JSONArray pluginInfo;

    /* loaded from: classes4.dex */
    public interface IPluginInfoCallBack {
        JSONArray getPluginInfo();
    }

    public static void setPluginInfo(JSONArray jSONArray) {
        pluginInfo = jSONArray;
    }

    public static void setPluginInfoCallback(IPluginInfoCallBack iPluginInfoCallBack) {
        mPluginInfoCallBack = iPluginInfoCallBack;
    }
}
