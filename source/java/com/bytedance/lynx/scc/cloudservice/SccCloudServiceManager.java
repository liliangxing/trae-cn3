package com.bytedance.lynx.scc.cloudservice;

import com.bytedance.lynx.scc.cloudservice.network.INetAdapter;
import com.bytedance.lynx.scc.cloudservice.reporter.ISccDataReportListener;
import com.bytedance.lynx.scc.cloudservice.utils.SccUtils;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class SccCloudServiceManager {
    private static INetAdapter netAdapter;
    private static ISccDataReportListener reportListener;
    private static SccConfig sConfig;
    private static final SccSettings sSettings = new SccSettings();

    public static void setNetAdapter(INetAdapter adapter) {
        synchronized (SccCloudServiceManager.class) {
            netAdapter = adapter;
        }
    }

    public static INetAdapter getNetAdapter() {
        INetAdapter iNetAdapter;
        synchronized (SccCloudServiceManager.class) {
            iNetAdapter = netAdapter;
        }
        return iNetAdapter;
    }

    public static void registerDataReportListener(ISccDataReportListener listener) {
        synchronized (SccCloudServiceManager.class) {
            reportListener = listener;
        }
    }

    public static void onDataReport(String event, Map<String, String> map) {
        synchronized (SccCloudServiceManager.class) {
            ISccDataReportListener iSccDataReportListener = reportListener;
            if (iSccDataReportListener == null) {
                return;
            }
            iSccDataReportListener.onDataReport(event, map);
        }
    }

    public static void setSettingsJsonConfig(JsonObject json) {
        SccSettings.fromJson(json, sSettings);
    }

    public static SccSettings getGlobalSccSettings() {
        return sSettings;
    }

    public static void addDomainsAllowList(List<String> domains) {
        if (domains == null) {
            return;
        }
        SccUtils.removeTrailingSlash(domains);
        sSettings.addAllowDomains(domains);
    }

    public static void clearAllowList() {
        sSettings.clearAllowDomains();
    }

    public static boolean isDebug() {
        return sSettings.isDebug();
    }

    public static SccConfig getSccConfig() {
        if (sConfig == null) {
            sConfig = new SccConfig();
        }
        return sConfig;
    }

    public static void setSccConfig(SccConfig config) {
        sConfig = config;
    }
}
