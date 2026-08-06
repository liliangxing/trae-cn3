package com.bytedance.security.android.aopcheck.env;

import android.content.Context;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.news.common.settings.IndividualManager;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.security.android.aopcheck.BuildConfig;
import com.bytedance.security.android.aopcheck.PathTraversalChecker;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.security.android.aopcheck.reporter.ReportManager;
import com.bytedance.security.android.aopcheck.reporter.SlardarReporter;
import com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings;
import com.bytedance.security.android.aopcheck.settings.SettingContoller;
import com.bytedance.security.android.aopcheck.settings.SettingsModel;
import com.bytedance.security.android.aopcheck.utils.KevaUtil;
import com.bytedance.security.android.aopcheck.utils.LogPrint;
import com.bytedance.security.android.aopcheck.utils.ThreadPool;
import com.ss.android.agilelogger.ALog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AOPEnvironment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\bJ\b\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/security/android/aopcheck/env/AOPEnvironment;", "", "()V", "headerInfo", "Lorg/json/JSONObject;", "getHeaderInfo", "()Lorg/json/JSONObject;", "active", "", "context", "Landroid/content/Context;", "config", "Lcom/bytedance/security/android/aopcheck/env/ICommonConfig;", "initMonitor", "initParseSetting", "initReporter", "initSettings", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AOPEnvironment {
    public static final AOPEnvironment INSTANCE;
    private static final JSONObject headerInfo;

    static {
        AOPEnvironment aOPEnvironment = new AOPEnvironment();
        INSTANCE = aOPEnvironment;
        headerInfo = new JSONObject();
        aOPEnvironment.initReporter();
    }

    private AOPEnvironment() {
    }

    public final JSONObject getHeaderInfo() {
        return headerInfo;
    }

    private final void initReporter() {
        ReportManager.INSTANCE.addReporter(new SlardarReporter());
    }

    public final synchronized void active(final Context context, final ICommonConfig config) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(config, "config");
        ALog.d("AOPEnvironment", "activie aid=" + config.getHostAid() + ",version=" + config.getAppVersion() + ",channel=" + config.getChannel());
        KevaBuilder.getInstance().setContext(context);
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = headerInfo;
        jSONObject.put(Constant.KEY_AID, ReportConstant.AID);
        jSONObject.put("device_id", config.getDeviceId());
        jSONObject.put(Constant.KEY_HOST_AID, config.getHostAid());
        jSONObject.put(Constant.KEY_CHANNEL, config.getChannel());
        jSONObject.put(Constant.KEY_UPDATE_VERSION_CODE, config.getUpdateVersionCode());
        jSONObject.put(Constant.KEY_APP_VERSION, config.getAppVersion());
        jSONObject.put(Constant.KEY_APP_VERSION2, config.getAppVersion());
        jSONObject.put(Constant.KEY_AOP_CHECK_SDK_VERSION, BuildConfig.VERSION_NAME);
        ThreadPool.getDefaultThreadPool().execute(new Runnable() { // from class: com.bytedance.security.android.aopcheck.env.AOPEnvironment$active$1
            @Override // java.lang.Runnable
            public final void run() {
                if (KevaUtil.get().getBoolean(Constant.PATH_TRAVERSAL_INTERCEPT_ENABLED, false)) {
                    PathTraversalChecker.INSTANCE.setEnableIntercept(true);
                }
                if (KevaUtil.get().getBoolean(Constant.PATH_TRAVERSAL_FILE_INTERCEPT_ENABLED, false)) {
                    PathTraversalChecker.INSTANCE.setEnableFileIntercept(true);
                }
                if (KevaUtil.get().getBoolean(Constant.PATH_TRAVERSAL_FILE_READER_INTERCEPT_ENABLED, false)) {
                    PathTraversalChecker.INSTANCE.setEnableFileReaderIntercept(true);
                }
                if (KevaUtil.get().getBoolean(Constant.PATH_TRAVERSAL_FILE_WRITER_INTERCEPT_ENABLED, false)) {
                    PathTraversalChecker.INSTANCE.setEnableFileWriterIntercept(true);
                }
                if (KevaUtil.get().getBoolean(Constant.PATH_TRAVERSAL_FILE_INPUT_STREAM_INTERCEPT_ENABLED, false)) {
                    PathTraversalChecker.INSTANCE.setEnableFileInputStreamIntercept(true);
                }
                if (KevaUtil.get().getBoolean(Constant.PATH_TRAVERSAL_FILE_OUTPUT_STREAM_INTERCEPT_ENABLED, false)) {
                    PathTraversalChecker.INSTANCE.setEnableFileOutputStreamIntercept(true);
                }
                if (KevaUtil.get().getBoolean(Constant.PATH_TRAVERSAL_ZIP_FILE_INTERCEPT_ENABLED, false)) {
                    PathTraversalChecker.INSTANCE.setEnableZipFileIntercept(true);
                }
                if (KevaUtil.get().getBoolean(Constant.PATH_TRAVERSAL_CONTENT_RESOLVER_INTERCEPT_ENABLED, false)) {
                    PathTraversalChecker.INSTANCE.setEnableContentResolverIntercept(true);
                }
                if (!KevaUtil.get().getBoolean(Constant.PATH_TRAVERSAL_ENABLED, true)) {
                    PathTraversalChecker.INSTANCE.setEnable(false);
                }
                AOPEnvironment.INSTANCE.initSettings(context);
            }
        });
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        LogPrint.m177d("initDuration=" + currentTimeMillis2);
        ReportManager.INSTANCE.reportInit(currentTimeMillis2);
        ThreadPool.getDefaultThreadPool().execute(new Runnable() { // from class: com.bytedance.security.android.aopcheck.env.AOPEnvironment$active$2
            @Override // java.lang.Runnable
            public final void run() {
                AOPEnvironment.INSTANCE.initMonitor(context, config);
            }
        });
    }

    public final synchronized void initMonitor(Context context, ICommonConfig config) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(config, "config");
        LogPrint.m177d((("initMonitor : deviceid=" + config.getDeviceId() + " channel=" + config.getChannel()).toString() + " updateVersionCode=" + config.getUpdateVersionCode()).toString() + " host_aid=" + config.getHostAid());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(ReportConstant.DEFAULT_URL_RULES);
        arrayList2.add(ReportConstant.DEFAULT_URL_REPORT);
        SDKMonitorUtils.setConfigUrl(ReportConstant.AID, arrayList);
        SDKMonitorUtils.setDefaultReportUrl(ReportConstant.AID, arrayList2);
        SDKMonitorUtils.initMonitor(context, ReportConstant.AID, headerInfo, new SDKMonitor.IGetExtendParams() { // from class: com.bytedance.security.android.aopcheck.env.AOPEnvironment$initMonitor$1
            public String getSessionId() {
                return null;
            }

            public Map<String, String> getCommonParams() {
                HashMap hashMap = new HashMap();
                String optString = AOPEnvironment.INSTANCE.getHeaderInfo().optString(Constant.KEY_HOST_AID);
                Intrinsics.checkExpressionValueIsNotNull(optString, "headerInfo.optString(\n  …                        )");
                hashMap.put(Constant.KEY_HOST_AID, optString);
                hashMap.put(Constant.KEY_AOP_CHECK_SDK_VERSION, BuildConfig.VERSION_NAME);
                String optString2 = AOPEnvironment.INSTANCE.getHeaderInfo().optString(Constant.KEY_UPDATE_VERSION_CODE);
                Intrinsics.checkExpressionValueIsNotNull(optString2, "headerInfo.optString(\n  …                        )");
                hashMap.put(Constant.KEY_UPDATE_VERSION_CODE, optString2);
                return hashMap;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void initSettings(Context context) {
        SettingContoller.initSettingSdk(context);
        IndividualManager.obtainManager(Constant.KEY_SETTING_ID).registerListener(new SettingsUpdateListener() { // from class: com.bytedance.security.android.aopcheck.env.AOPEnvironment$initSettings$1
            public void onSettingsUpdate(SettingsData settingsData) {
                if ((settingsData != null ? settingsData.getAppSettings() : null) == null) {
                    return;
                }
                AOPEnvironment.INSTANCE.initParseSetting();
                KevaUtil.get().storeBoolean(Constant.PATH_TRAVERSAL_INTERCEPT_ENABLED, PathTraversalChecker.INSTANCE.getEnableIntercept());
                KevaUtil.get().storeBoolean(Constant.PATH_TRAVERSAL_FILE_INTERCEPT_ENABLED, PathTraversalChecker.INSTANCE.getEnableFileIntercept());
                KevaUtil.get().storeBoolean(Constant.PATH_TRAVERSAL_FILE_READER_INTERCEPT_ENABLED, PathTraversalChecker.INSTANCE.getEnableFileReaderIntercept());
                KevaUtil.get().storeBoolean(Constant.PATH_TRAVERSAL_FILE_WRITER_INTERCEPT_ENABLED, PathTraversalChecker.INSTANCE.getEnableFileWriterIntercept());
                KevaUtil.get().storeBoolean(Constant.PATH_TRAVERSAL_FILE_INPUT_STREAM_INTERCEPT_ENABLED, PathTraversalChecker.INSTANCE.getEnableFileInputStreamIntercept());
                KevaUtil.get().storeBoolean(Constant.PATH_TRAVERSAL_FILE_OUTPUT_STREAM_INTERCEPT_ENABLED, PathTraversalChecker.INSTANCE.getEnableFileOutputStreamIntercept());
                KevaUtil.get().storeBoolean(Constant.PATH_TRAVERSAL_ZIP_FILE_INTERCEPT_ENABLED, PathTraversalChecker.INSTANCE.getEnableZipFileIntercept());
                KevaUtil.get().storeBoolean(Constant.PATH_TRAVERSAL_CONTENT_RESOLVER_INTERCEPT_ENABLED, PathTraversalChecker.INSTANCE.getEnableContentResolverIntercept());
                KevaUtil.get().storeBoolean(Constant.PATH_TRAVERSAL_ENABLED, PathTraversalChecker.INSTANCE.getEnable());
            }
        }, false);
        initParseSetting();
    }

    public final void initParseSetting() {
        SettingsModel settingModel = ((MobiusAOPCheckSettings) IndividualManager.obtainManager(Constant.KEY_SETTING_ID).obtain(MobiusAOPCheckSettings.class)).getSettingModel();
        if (settingModel != null) {
            PathTraversalChecker pathTraversalChecker = PathTraversalChecker.INSTANCE;
            Boolean pathTraversalInterceptEnabled = settingModel.getPathTraversalInterceptEnabled();
            Intrinsics.checkExpressionValueIsNotNull(pathTraversalInterceptEnabled, "settingLocal.pathTraversalInterceptEnabled");
            pathTraversalChecker.setEnableIntercept(pathTraversalInterceptEnabled.booleanValue());
            PathTraversalChecker pathTraversalChecker2 = PathTraversalChecker.INSTANCE;
            Boolean pathTraversalEnabled = settingModel.getPathTraversalEnabled();
            Intrinsics.checkExpressionValueIsNotNull(pathTraversalEnabled, "settingLocal.pathTraversalEnabled");
            pathTraversalChecker2.setEnable(pathTraversalEnabled.booleanValue());
            PathTraversalChecker pathTraversalChecker3 = PathTraversalChecker.INSTANCE;
            Boolean enableFileIntercept = settingModel.getEnableFileIntercept();
            Intrinsics.checkExpressionValueIsNotNull(enableFileIntercept, "settingLocal.enableFileIntercept");
            pathTraversalChecker3.setEnableFileIntercept(enableFileIntercept.booleanValue());
            PathTraversalChecker pathTraversalChecker4 = PathTraversalChecker.INSTANCE;
            Boolean enableFileReaderIntercept = settingModel.getEnableFileReaderIntercept();
            Intrinsics.checkExpressionValueIsNotNull(enableFileReaderIntercept, "settingLocal.enableFileReaderIntercept");
            pathTraversalChecker4.setEnableFileReaderIntercept(enableFileReaderIntercept.booleanValue());
            PathTraversalChecker pathTraversalChecker5 = PathTraversalChecker.INSTANCE;
            Boolean enableFileWriterIntercept = settingModel.getEnableFileWriterIntercept();
            Intrinsics.checkExpressionValueIsNotNull(enableFileWriterIntercept, "settingLocal.enableFileWriterIntercept");
            pathTraversalChecker5.setEnableFileWriterIntercept(enableFileWriterIntercept.booleanValue());
            PathTraversalChecker pathTraversalChecker6 = PathTraversalChecker.INSTANCE;
            Boolean enableFileInputStreamIntercept = settingModel.getEnableFileInputStreamIntercept();
            Intrinsics.checkExpressionValueIsNotNull(enableFileInputStreamIntercept, "settingLocal.enableFileInputStreamIntercept");
            pathTraversalChecker6.setEnableFileInputStreamIntercept(enableFileInputStreamIntercept.booleanValue());
            PathTraversalChecker pathTraversalChecker7 = PathTraversalChecker.INSTANCE;
            Boolean enableFileOutputStreamIntercept = settingModel.getEnableFileOutputStreamIntercept();
            Intrinsics.checkExpressionValueIsNotNull(enableFileOutputStreamIntercept, "settingLocal.enableFileOutputStreamIntercept");
            pathTraversalChecker7.setEnableFileOutputStreamIntercept(enableFileOutputStreamIntercept.booleanValue());
            PathTraversalChecker pathTraversalChecker8 = PathTraversalChecker.INSTANCE;
            Boolean enableZipFileIntercept = settingModel.getEnableZipFileIntercept();
            Intrinsics.checkExpressionValueIsNotNull(enableZipFileIntercept, "settingLocal.enableZipFileIntercept");
            pathTraversalChecker8.setEnableZipFileIntercept(enableZipFileIntercept.booleanValue());
            PathTraversalChecker pathTraversalChecker9 = PathTraversalChecker.INSTANCE;
            Boolean enableContentResolverIntercept = settingModel.getEnableContentResolverIntercept();
            Intrinsics.checkExpressionValueIsNotNull(enableContentResolverIntercept, "settingLocal.enableContentResolverIntercept");
            pathTraversalChecker9.setEnableContentResolverIntercept(enableContentResolverIntercept.booleanValue());
        }
    }
}
