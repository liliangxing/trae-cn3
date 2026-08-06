package com.bytedance.webx.seclink;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.webx.base.WebXConfig;
import com.bytedance.webx.base.logger.ILogger;
import com.bytedance.webx.base.report.IReportAgent;
import com.bytedance.webx.seclink.base.IBizInfoProvider;
import com.bytedance.webx.seclink.base.IExceptionHandler;
import com.bytedance.webx.seclink.base.INetApi;
import com.bytedance.webx.seclink.base.ISecLinkStrategy;
import com.bytedance.webx.seclink.base.impl.AsyncSecStrategy;
import com.bytedance.webx.seclink.base.impl.AsyncSecStrategyV2;
import com.bytedance.webx.seclink.cache.UrlSecLinkCache;
import com.bytedance.webx.seclink.config.AppSecConfig;
import com.bytedance.webx.seclink.request.CheckUrlSecManager;
import com.bytedance.webx.seclink.setting.SettingConfig;
import com.bytedance.webx.seclink.setting.SettingManager;
import com.bytedance.webx.seclink.util.Log;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.bytedance.webx.seclink.util.SecLinkTaskExecutor;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SecLinkFacade {
    private static Context context;
    private static IExceptionHandler exceptionHandler;
    private static AppSecConfig globalConfig;
    private static String globalSecLinkHost;
    private static boolean isEnable;
    private static boolean isInit;

    @Deprecated
    public static void init(Context context2, String str, String str2, String str3) {
        init(context2, new AppSecConfig.Builder().aid(str).lang(str2).host(str3).build());
    }

    @Deprecated
    public static void init(Context context2, AppSecConfig appSecConfig) {
        if (context2 == null) {
            throw new RuntimeException("context can not be null.");
        }
        if (appSecConfig == null) {
            throw new RuntimeException("config can not be null.");
        }
        if (TextUtils.isEmpty(appSecConfig.getAid())) {
            throw new RuntimeException("app_id can not be empty.");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(globalSecLinkHost)) {
            appSecConfig.setHost(globalSecLinkHost);
        }
        boolean z = globalConfig != null;
        if (z) {
            updateConfig(appSecConfig);
        } else {
            context = context2.getApplicationContext();
            globalConfig = appSecConfig;
            isEnable = true;
        }
        SettingManager.getInstance().init();
        ReportUtil.init(System.currentTimeMillis() - currentTimeMillis, ReportUtil.Event.EVENT_INIT, "updateCfg=" + z);
    }

    public static void initSecLink(Context context2, AppSecConfig appSecConfig) throws RuntimeException {
        if (isInit) {
            return;
        }
        if (context2 == null) {
            throw new RuntimeException("context can not be null.");
        }
        if (appSecConfig == null) {
            throw new RuntimeException("config can not be null.");
        }
        if (TextUtils.isEmpty(appSecConfig.getAid())) {
            throw new RuntimeException("app_id can not be empty.");
        }
        if (TextUtils.isEmpty(appSecConfig.getAppVersion())) {
            throw new RuntimeException("appVersion can not be empty.");
        }
        if (appSecConfig.getDeviceProvider() == null) {
            throw new RuntimeException("deviceInfoProver can not be null.");
        }
        if (!TextUtils.isEmpty(globalSecLinkHost)) {
            appSecConfig.setHost(globalSecLinkHost);
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = globalConfig != null;
        if (z) {
            updateConfig(appSecConfig);
        } else {
            context = context2.getApplicationContext();
            globalConfig = appSecConfig;
            isEnable = true;
        }
        AppSecConfig appSecConfig2 = globalConfig;
        if (appSecConfig2 != null && appSecConfig2.getReportAgent() != null) {
            setReportAgent(globalConfig.getReportAgent());
        }
        AppSecConfig appSecConfig3 = globalConfig;
        if (appSecConfig3 != null && appSecConfig3.getNetClient() != null) {
            setNetApi(globalConfig.getNetClient());
        }
        ReportUtil.init(System.currentTimeMillis() - currentTimeMillis, "initSecLink", "updateCfg=" + z);
        SettingManager.getInstance().init();
        isInit = true;
    }

    public static boolean isInitiated() {
        return globalConfig != null;
    }

    private static void updateConfig(AppSecConfig appSecConfig) {
        if (!TextUtils.isEmpty(appSecConfig.getAid())) {
            globalConfig.setAid(appSecConfig.getAid());
        }
        if (!TextUtils.isEmpty(appSecConfig.getLang())) {
            globalConfig.setLang(appSecConfig.getLang());
        }
        if (!TextUtils.isEmpty(appSecConfig.getHost())) {
            globalConfig.setHost(appSecConfig.getHost());
        }
        if (!TextUtils.isEmpty(appSecConfig.getAppVersion())) {
            globalConfig.setAppVersion(appSecConfig.getAppVersion());
        }
        if (!TextUtils.isEmpty(appSecConfig.getChannel())) {
            globalConfig.setChannel(appSecConfig.getChannel());
        }
        if (!TextUtils.isEmpty(appSecConfig.getDid())) {
            globalConfig.setDid(appSecConfig.getDid());
        }
        if (appSecConfig.getDeviceProvider() != null) {
            globalConfig.setDeviceProvider(appSecConfig.getDeviceProvider());
        }
        if (appSecConfig.getGlobalBizInfoProvider() != null) {
            globalConfig.setGlobalBizInfoProvider(appSecConfig.getGlobalBizInfoProvider());
        }
        if (appSecConfig.getTimeout() > 0) {
            globalConfig.setTimeout(appSecConfig.getTimeout());
        }
        if (appSecConfig.getNetClient() != null) {
            globalConfig.setNetClient(appSecConfig.getNetClient());
        }
        if (appSecConfig.getReportAgent() != null) {
            globalConfig.setReportAgent(appSecConfig.getReportAgent());
        }
        List<String> prefixAllowList = appSecConfig.getPrefixAllowList();
        if (prefixAllowList == null || prefixAllowList.size() <= 0) {
            return;
        }
        List<String> prefixAllowList2 = globalConfig.getPrefixAllowList();
        if (prefixAllowList2 != null && prefixAllowList2.size() > 0) {
            for (int i = 0; i < prefixAllowList.size(); i++) {
                String str = prefixAllowList.get(i);
                if (!prefixAllowList2.contains(str)) {
                    prefixAllowList2.add(str);
                }
            }
            return;
        }
        globalConfig.setPrefixAllowList(prefixAllowList);
    }

    public static void setReportAgent(IReportAgent iReportAgent) {
        if (iReportAgent != null) {
            WebXConfig.setReportAgent(iReportAgent);
        }
    }

    public static void updateLanguage(String str) {
        if (getLinkConfig() != null) {
            getLinkConfig().setLang(str);
        }
    }

    public static void updateAid(String str) {
        if (getLinkConfig() != null) {
            getLinkConfig().setAid(str);
        }
    }

    public static void setSafeLinkEnable(boolean z) {
        isEnable = z;
    }

    public static void setSceneConfig(SettingConfig.SceneConfig sceneConfig) {
        SettingManager.getInstance().setSceneConfig(sceneConfig);
    }

    public static void setExceptionHandler(IExceptionHandler iExceptionHandler) {
        exceptionHandler = iExceptionHandler;
    }

    public static IExceptionHandler getExceptionHandler() {
        return exceptionHandler;
    }

    public static Context getContext() {
        return context;
    }

    public static boolean isSafeLinkEnable() {
        return isEnable;
    }

    public static void setExecutor(ExecutorService executorService) {
        SecLinkTaskExecutor.getInstance().setExecutor(executorService);
    }

    public static void setCacheValidTime(long j) {
        UrlSecLinkCache.getInstance().setValidTime(j);
    }

    public static void setErrorConfig(int i, long j, long j2) {
        CheckUrlSecManager.setErrorConfig(i, j, j2);
    }

    public static AppSecConfig getLinkConfig() {
        return globalConfig;
    }

    public static boolean containInAllowList(String str) {
        if (getLinkConfig() != null) {
            return getLinkConfig().containInAllowList(str);
        }
        return false;
    }

    public static void addAllowList(List<String> list) {
        if (getLinkConfig() != null) {
            getLinkConfig().addAllowList(list);
        }
    }

    public static void addAllowList(String str) {
        if (getLinkConfig() != null) {
            getLinkConfig().addAllowList(str);
        }
    }

    public static void removeAllowList(String str) {
        if (getLinkConfig() != null) {
            getLinkConfig().removeAllowList(str);
        }
    }

    public static void setLogEnable(boolean z) {
        Log.setEnable(z);
    }

    public static void setLogger(ILogger iLogger) {
        Log.setSecLinkLog(iLogger);
    }

    public static ISecLinkStrategy generateAsyncStrategy(WebView webView, String str) {
        return generateAsyncStrategy(webView, "", str);
    }

    public static ISecLinkStrategy generateAsyncStrategy(WebView webView, String str, String str2) {
        if (SettingManager.getInstance().useVerifyModeV2(str2)) {
            return new AsyncSecStrategyV2(webView, str, str2);
        }
        return new AsyncSecStrategy(webView, str, str2);
    }

    public static void setNetApi(INetApi iNetApi) {
        if (iNetApi != null) {
            CheckUrlSecManager.setNetApi(iNetApi);
        }
    }

    public static void setBizInfoProvider(IBizInfoProvider iBizInfoProvider) {
        AppSecConfig linkConfig = getLinkConfig();
        if (linkConfig != null) {
            linkConfig.setGlobalBizInfoProvider(iBizInfoProvider);
        }
    }

    public static IBizInfoProvider getBizInfoProvider() {
        AppSecConfig linkConfig = getLinkConfig();
        if (linkConfig != null) {
            return linkConfig.getGlobalBizInfoProvider();
        }
        return null;
    }

    public static void setGlobalSecLinkHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        globalSecLinkHost = str;
    }

    public static String getVerifyHost() {
        return SettingManager.getInstance().getVerifyHost();
    }
}
