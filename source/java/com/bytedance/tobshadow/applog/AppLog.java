package com.bytedance.tobshadow.applog;

import android.accounts.Account;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.tobshadow.applog.alink.IALinkListener;
import com.bytedance.tobshadow.applog.event.EventBuilder;
import com.bytedance.tobshadow.applog.event.IEventHandler;
import com.bytedance.tobshadow.applog.exposure.ViewExposureManager;
import com.bytedance.tobshadow.applog.log.LogUtils;
import com.bytedance.tobshadow.applog.network.INetworkClient;
import com.bytedance.tobshadow.applog.oneid.IDBindCallback;
import com.bytedance.tobshadow.applog.profile.UserProfileCallback;
import com.bytedance.tobshadow.bdtracker.C0411e;
import com.bytedance.tobshadow.bdtracker.C0467m;
import com.bytedance.tobshadow.bdtracker.InterfaceC0481o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppLog {

    /* renamed from: a */
    public static final IAppLogInstance f266a = newInstance();

    /* renamed from: b */
    public static volatile boolean f267b = false;

    public static void activateALink(Uri uri) {
        f266a.activateALink(uri);
    }

    public static void addDataObserver(IDataObserver iDataObserver) {
        f266a.addDataObserver(iDataObserver);
    }

    public static void addEventJsonObserver(IEventJsonObserver iEventJsonObserver) {
        f266a.addEventJsonObserver(iEventJsonObserver);
    }

    public static void addEventObserver(IEventObserver iEventObserver) {
        f266a.addEventObserver(iEventObserver);
    }

    @Deprecated
    public static void addEventObserver(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver) {
        f266a.addEventObserver(iEventObserver, iPresetEventObserver);
    }

    @Deprecated
    public static String addNetCommonParams(Context context, String str, boolean z, Level level) {
        return f266a.addNetCommonParams(context, str, z, level);
    }

    public static void addSessionHook(ISessionObserver iSessionObserver) {
        f266a.addSessionHook(iSessionObserver);
    }

    public static void bind(Map<String, String> map, IDBindCallback iDBindCallback) {
        f266a.bind(map, iDBindCallback);
    }

    public static boolean clearDb() {
        return f266a.clearDb();
    }

    public static void flush() {
        f266a.flush();
    }

    public static <T> T getAbConfig(String str, T t) {
        return (T) f266a.getAbConfig(str, t);
    }

    public static String getAbSdkVersion() {
        return f266a.getAbSdkVersion();
    }

    public static IActiveCustomParamsCallback getActiveCustomParams() {
        return f266a.getActiveCustomParams();
    }

    @Deprecated
    public static String getAid() {
        return f266a.getAid();
    }

    public static JSONObject getAllAbTestConfigs() {
        return f266a.getAllAbTestConfigs();
    }

    @Deprecated
    public static InterfaceC0481o getAppContext() {
        return f266a.getAppContext();
    }

    public static String getAppId() {
        return f266a.getAppId();
    }

    public static String getClientUdid() {
        return f266a.getClientUdid();
    }

    public static Context getContext() {
        return f266a.getContext();
    }

    public static String getDid() {
        return f266a.getDid();
    }

    public static boolean getEncryptAndCompress() {
        return f266a.getEncryptAndCompress();
    }

    public static String getExternalAbVersion() {
        return f266a.getExternalAbVersion();
    }

    @Deprecated
    public static JSONObject getHeader() {
        return f266a.getHeader();
    }

    @Deprecated
    public static IHeaderCustomTimelyCallback getHeaderCustomCallback() {
        return f266a.getHeaderCustomCallback();
    }

    public static <T> T getHeaderValue(String str, T t, Class<T> cls) {
        return (T) f266a.getHeaderValue(str, t, cls);
    }

    public static String getIid() {
        return f266a.getIid();
    }

    public static InitConfig getInitConfig() {
        return f266a.getInitConfig();
    }

    public static IAppLogInstance getInstance() {
        return f266a;
    }

    public static INetworkClient getNetClient() {
        return f266a.getNetClient();
    }

    public static String getOpenUdid() {
        return f266a.getOpenUdid();
    }

    @Deprecated
    public static Map<String, String> getRequestHeader() {
        return f266a.getRequestHeader();
    }

    public static String getSdkVersion() {
        return f266a.getSdkVersion();
    }

    public static String getSessionId() {
        return f266a.getSessionId();
    }

    public static String getSsid() {
        return f266a.getSsid();
    }

    public static void getSsidGroup(Map<String, String> map) {
        f266a.getSsidGroup(map);
    }

    @Deprecated
    public static String getUdid() {
        return f266a.getUdid();
    }

    public static UriConfig getUriRuntime() {
        return f266a.getUriRuntime();
    }

    public static String getUserID() {
        return f266a.getUserID();
    }

    public static String getUserUniqueID() {
        return f266a.getUserUniqueID();
    }

    public static ViewExposureManager getViewExposureManager() {
        return f266a.getViewExposureManager();
    }

    public static JSONObject getViewProperties(View view) {
        return f266a.getViewProperties(view);
    }

    public static boolean hasStarted() {
        return f266a.hasStarted();
    }

    public static void ignoreAutoTrackClick(View view) {
        f266a.ignoreAutoTrackClick(view);
    }

    public static void ignoreAutoTrackClickByViewType(Class<?>... clsArr) {
        f266a.ignoreAutoTrackClickByViewType(clsArr);
    }

    public static void ignoreAutoTrackPage(Class<?>... clsArr) {
        f266a.ignoreAutoTrackPage(clsArr);
    }

    public static void init(Context context, InitConfig initConfig) {
        synchronized (AppLog.class) {
            if (C0411e.m365a(f267b, "Default AppLog is initialized, please create another instance by `AppLog.newInstance()`")) {
                return;
            }
            f267b = true;
            if (TextUtils.isEmpty(initConfig.getSpName())) {
                initConfig.setSpName("applog_stats");
            }
            f266a.init(context, initConfig);
        }
    }

    public static void init(Context context, InitConfig initConfig, Activity activity) {
        synchronized (AppLog.class) {
            if (C0411e.m365a(f267b, "Default AppLog is initialized, please create another instance by `new AppLogInstance()`")) {
                return;
            }
            f267b = true;
            if (TextUtils.isEmpty(initConfig.getSpName())) {
                initConfig.setSpName("applog_stats");
            }
            f266a.init(context, initConfig, activity);
        }
    }

    public static void initH5Bridge(View view, String str) {
        f266a.initH5Bridge(view, str);
    }

    public static void initWebViewBridge(View view, String str) {
        f266a.initWebViewBridge(view, str);
    }

    public static boolean isAutoTrackClickIgnored(View view) {
        return f266a.isAutoTrackClickIgnored(view);
    }

    public static boolean isAutoTrackPageIgnored(Class<?> cls) {
        return f266a.isAutoTrackPageIgnored(cls);
    }

    public static boolean isH5BridgeEnable() {
        return f266a.isH5BridgeEnable();
    }

    public static boolean isH5CollectEnable() {
        return f266a.isH5CollectEnable();
    }

    public static boolean isNewUser() {
        return f266a.isNewUser();
    }

    public static boolean isPrivacyMode() {
        return f266a.isPrivacyMode();
    }

    public static boolean manualActivate() {
        return f266a.manualActivate();
    }

    public static EventBuilder newEvent(String str) {
        return f266a.newEvent(str);
    }

    public static IAppLogInstance newInstance() {
        return new C0467m();
    }

    public static void onActivityPause() {
        f266a.onActivityPause();
    }

    public static void onActivityResumed(Activity activity, int i) {
        f266a.onActivityResumed(activity, i);
    }

    public static void onEventV3(String str) {
        f266a.onEventV3(str);
    }

    public static void onEventV3(String str, Bundle bundle) {
        f266a.onEventV3(str, bundle);
    }

    public static void onEventV3(String str, Bundle bundle, int i) {
        f266a.onEventV3(str, bundle, i);
    }

    public static void onEventV3(String str, JSONObject jSONObject) {
        f266a.onEventV3(str, jSONObject);
    }

    public static void onEventV3(String str, JSONObject jSONObject, int i) {
        f266a.onEventV3(str, jSONObject, i);
    }

    @Deprecated
    public static void onMiscEvent(String str, JSONObject jSONObject) {
        f266a.onMiscEvent(str, jSONObject);
    }

    public static void onPause(Context context) {
        f266a.onPause(context);
    }

    public static void onResume(Context context) {
        f266a.onResume(context);
    }

    public static void pauseDurationEvent(String str) {
        f266a.pauseDurationEvent(str);
    }

    public static void profileAppend(JSONObject jSONObject) {
        f266a.profileAppend(jSONObject);
    }

    public static void profileIncrement(JSONObject jSONObject) {
        f266a.profileIncrement(jSONObject);
    }

    public static void profileSet(JSONObject jSONObject) {
        f266a.profileSet(jSONObject);
    }

    public static void profileSetOnce(JSONObject jSONObject) {
        f266a.profileSetOnce(jSONObject);
    }

    public static void profileUnset(String str) {
        f266a.profileUnset(str);
    }

    public static void pullAbTestConfigs() {
        f266a.pullAbTestConfigs();
    }

    public static void pullAbTestConfigs(int i, IPullAbTestConfigCallback iPullAbTestConfigCallback) {
        f266a.pullAbTestConfigs(i, iPullAbTestConfigCallback);
    }

    @Deprecated
    public static void putCommonParams(Context context, Map<String, String> map, boolean z, Level level) {
        f266a.putCommonParams(context, map, z, level);
    }

    @Deprecated
    public static void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback) {
        f266a.registerHeaderCustomCallback(iHeaderCustomTimelyCallback);
    }

    public static void removeAllDataObserver() {
        f266a.removeAllDataObserver();
    }

    public static void removeDataObserver(IDataObserver iDataObserver) {
        f266a.removeDataObserver(iDataObserver);
    }

    public static void removeEventJsonObserver(IEventJsonObserver iEventJsonObserver) {
        f266a.removeJsonEventObserver(iEventJsonObserver);
    }

    public static void removeEventObserver(IEventObserver iEventObserver) {
        f266a.removeJsonEventObserver(iEventObserver);
    }

    @Deprecated
    public static void removeEventObserver(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver) {
        f266a.removeEventObserver(iEventObserver, iPresetEventObserver);
    }

    public static void removeHeaderInfo(String str) {
        f266a.removeHeaderInfo(str);
    }

    public static void removeOaidObserver(IOaidObserver iOaidObserver) {
        f266a.removeOaidObserver(iOaidObserver);
    }

    public static void removeSessionHook(ISessionObserver iSessionObserver) {
        f266a.removeSessionHook(iSessionObserver);
    }

    public static void resumeDurationEvent(String str) {
        f266a.resumeDurationEvent(str);
    }

    public static void setALinkListener(IALinkListener iALinkListener) {
        f266a.setALinkListener(iALinkListener);
    }

    @Deprecated
    public static void setAccount(Account account) {
        f266a.setAccount(account);
    }

    public static void setActiveCustomParams(IActiveCustomParamsCallback iActiveCustomParamsCallback) {
        f266a.setActiveCustomParams(iActiveCustomParamsCallback);
    }

    @Deprecated
    public static void setAppContext(InterfaceC0481o interfaceC0481o) {
        f266a.setAppContext(interfaceC0481o);
    }

    public static void setAppLanguageAndRegion(String str, String str2) {
        f266a.setAppLanguageAndRegion(str, str2);
    }

    public static void setAppTrack(JSONObject jSONObject) {
        f266a.setAppTrack(jSONObject);
    }

    public static void setClipboardEnabled(boolean z) {
        f266a.setClipboardEnabled(z);
    }

    public static void setDevToolsEnable(boolean z) {
        LogUtils.setEnable(z);
    }

    public static void setEncryptAndCompress(boolean z) {
        f266a.setEncryptAndCompress(z);
    }

    public static void setEventFilterByClient(List<String> list, boolean z) {
        f266a.setEventFilterByClient(list, z);
    }

    public static void setEventHandler(IEventHandler iEventHandler) {
        f266a.setEventHandler(iEventHandler);
    }

    public static void setExternalAbVersion(String str) {
        f266a.setExternalAbVersion(str);
    }

    @Deprecated
    public static void setExtraParams(IExtraParams iExtraParams) {
        f266a.setExtraParams(iExtraParams);
    }

    public static void setGPSLocation(float f, float f2, String str) {
        f266a.setGPSLocation(f, f2, str);
    }

    public static void setGoogleAid(String str) {
        f266a.setGoogleAid(str);
    }

    public static void setHeaderInfo(String str, Object obj) {
        f266a.setHeaderInfo(str, obj);
    }

    public static void setHeaderInfo(HashMap<String, Object> hashMap) {
        f266a.setHeaderInfo(hashMap);
    }

    public static void setOaidObserver(IOaidObserver iOaidObserver) {
        f266a.setOaidObserver(iOaidObserver);
    }

    public static void setPrivacyMode(boolean z) {
        f266a.setPrivacyMode(z);
    }

    public static void setPullAbTestConfigsThrottleMills(Long l) {
        f266a.setPullAbTestConfigsThrottleMills(l);
    }

    public static void setRangersEventVerifyEnable(boolean z, String str) {
        f266a.setRangersEventVerifyEnable(z, str);
    }

    public static void setTouchPoint(String str) {
        f266a.setTouchPoint(str);
    }

    public static void setTracerData(JSONObject jSONObject) {
        f266a.setTracerData(jSONObject);
    }

    public static void setUriRuntime(UriConfig uriConfig) {
        f266a.setUriRuntime(uriConfig);
    }

    public static void setUserAgent(String str) {
        f266a.setUserAgent(str);
    }

    public static void setUserID(long j) {
        f266a.setUserID(j);
    }

    public static void setUserUniqueID(String str) {
        f266a.setUserUniqueID(str);
    }

    public static void setUserUniqueID(String str, String str2) {
        f266a.setUserUniqueID(str, str2);
    }

    public static void setViewId(Dialog dialog, String str) {
        f266a.setViewId(dialog, str);
    }

    public static void setViewId(View view, String str) {
        f266a.setViewId(view, str);
    }

    public static void setViewId(Object obj, String str) {
        f266a.setViewId(obj, str);
    }

    public static void setViewProperties(View view, JSONObject jSONObject) {
        f266a.setViewProperties(view, jSONObject);
    }

    public static void start() {
        f266a.start();
    }

    public static void startDurationEvent(String str) {
        f266a.startDurationEvent(str);
    }

    public static void startSimulator(String str) {
        f266a.startSimulator(str);
    }

    public static void stopDurationEvent(String str, JSONObject jSONObject) {
        f266a.stopDurationEvent(str, jSONObject);
    }

    public static void stopDurationEvent(String str, JSONObject jSONObject, String str2) {
        f266a.stopDurationEvent(str, jSONObject, str2);
    }

    public static void trackClick(View view) {
        f266a.trackClick(view);
    }

    public static void trackClick(View view, JSONObject jSONObject) {
        f266a.trackClick(view, jSONObject);
    }

    public static void trackPage(Activity activity) {
        f266a.trackPage(activity);
    }

    public static void trackPage(Activity activity, JSONObject jSONObject) {
        f266a.trackPage(activity, jSONObject);
    }

    public static void trackPage(Object obj) {
        f266a.trackPage(obj);
    }

    public static void trackPage(Object obj, JSONObject jSONObject) {
        f266a.trackPage(obj, jSONObject);
    }

    @Deprecated
    public static void userProfileSetOnce(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        f266a.userProfileSetOnce(jSONObject, userProfileCallback);
    }

    @Deprecated
    public static void userProfileSync(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        f266a.userProfileSync(jSONObject, userProfileCallback);
    }
}
