package com.bytedance.lynx.service.trace;

/* loaded from: classes4.dex */
public class TraceEventDef {
    public static final String EVENT_REPORTER_SERVICE_REPORT_EVENT = "LynxEventReporterServiceProxy.onReportEvent";
    public static final String LYNX_SERVICE_INIT = "LynxServiceInitializer.initialize";
    public static final String LYNX_SETTINGS_FETCH_ENTER = "LynxSettingsDownloader.fetchSettings.enter";
    public static final String LYNX_SETTINGS_FETCH_FINISH = "LynxSettingsDownloader.fetchSettings.finish";
    public static final String LYNX_SETTINGS_FETCH_UPDATE = "LynxSettingsDownloader.updateSettingsData";
    public static final String LYNX_SETTINGS_SCHEDULE = "LynxSettingsDownloader.scheduleFetchSettings";
    public static final String LYNX_VIEW_CONFIG_PROCESSOR_SET_CONFIG = "LynxViewConfigProcessor.setConfig";
    public static final String MONITOR_PROXY_FORMAT_EVENT = "LynxMonitorServiceProxy.formatEventReporter";
    public static final String MONITOR_PROXY_REPORT_CRASH_GLOBAL_CONTEXT_TAG = "LynxMonitorServiceProxy.reportCrashGlobalContextTag";
    public static final String MONITOR_PROXY_REPORT_IMAGE_INFO = "LynxMonitorServiceProxy.reportImageInfo";
    public static final String MONITOR_PROXY_REPORT_IMAGE_STATUS = "LynxMonitorServiceProxy.reportImageStatus";
    public static final String MONITOR_PROXY_REPORT_RESOURCE_STATUS = "LynxMonitorServiceProxy.reportResourceStatus";
    public static final String MONITOR_PROXY_REPORT_TRAIL_EVENT = "LynxMonitorServiceProxy.reportTrailEvent";
    public static final String SETTINGS_INIT_MESSAGE = "LynxSettingsManager.initialize";
    public static final String SETTINGS_UPDATE_MESSAGE = "LynxSettingsManager.update";
}
