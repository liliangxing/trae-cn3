package com.bytedance.tobshadow.applog;

import android.accounts.Account;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.bytedance.tobshadow.applog.alink.IALinkListener;
import com.bytedance.tobshadow.applog.event.EventBuilder;
import com.bytedance.tobshadow.applog.event.IEventHandler;
import com.bytedance.tobshadow.applog.exposure.ViewExposureManager;
import com.bytedance.tobshadow.applog.network.INetworkClient;
import com.bytedance.tobshadow.applog.oneid.IDBindCallback;
import com.bytedance.tobshadow.applog.profile.UserProfileCallback;
import com.bytedance.tobshadow.bdtracker.AbstractC0476n1;
import com.bytedance.tobshadow.bdtracker.AbstractC0479n4;
import com.bytedance.tobshadow.bdtracker.InterfaceC0481o;
import com.bytedance.tobshadow.bdtracker.InterfaceC0526u2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IAppLogInstance {
    void activateALink(Uri uri);

    void addDataObserver(IDataObserver iDataObserver);

    void addEventJsonObserver(IEventJsonObserver iEventJsonObserver);

    void addEventObserver(IEventObserver iEventObserver);

    @Deprecated
    void addEventObserver(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver);

    @Deprecated
    String addNetCommonParams(Context context, String str, boolean z, Level level);

    void addSessionHook(ISessionObserver iSessionObserver);

    void bind(Map<String, String> map, IDBindCallback iDBindCallback);

    void clearAbTestConfigsCache();

    boolean clearDb();

    void flush();

    IALinkListener getALinkListener();

    <T> T getAbConfig(String str, T t);

    String getAbSdkVersion();

    IActiveCustomParamsCallback getActiveCustomParams();

    @Deprecated
    String getAid();

    JSONObject getAllAbTestConfigs();

    @Deprecated
    InterfaceC0481o getAppContext();

    String getAppId();

    String getClientUdid();

    Context getContext();

    String getDeepLinkUrl();

    String getDid();

    boolean getEncryptAndCompress();

    AbstractC0476n1 getEventFilterByClient();

    IEventHandler getEventHandler();

    String getExternalAbVersion();

    @Deprecated
    JSONObject getHeader();

    @Deprecated
    IHeaderCustomTimelyCallback getHeaderCustomCallback();

    <T> T getHeaderValue(String str, T t, Class<T> cls);

    String getIid();

    InitConfig getInitConfig();

    int getLaunchFrom();

    InterfaceC0526u2 getMonitor();

    INetworkClient getNetClient();

    String getOpenUdid();

    @Deprecated
    Map<String, String> getRequestHeader();

    String getSdkVersion();

    String getSessionId();

    String getSsid();

    void getSsidGroup(Map<String, String> map);

    @Deprecated
    String getUdid();

    UriConfig getUriRuntime();

    String getUserID();

    String getUserUniqueID();

    ViewExposureManager getViewExposureManager();

    JSONObject getViewProperties(View view);

    boolean hasStarted();

    void ignoreAutoTrackClick(View view);

    void ignoreAutoTrackClickByViewType(Class<?>... clsArr);

    void ignoreAutoTrackPage(Class<?>... clsArr);

    void init(Context context, InitConfig initConfig);

    void init(Context context, InitConfig initConfig, Activity activity);

    void initH5Bridge(View view, String str);

    void initMetaSec(Context context);

    void initWebViewBridge(View view, String str);

    boolean isAutoTrackClickIgnored(View view);

    boolean isAutoTrackPageIgnored(Class<?> cls);

    boolean isBavEnabled();

    boolean isH5BridgeEnable();

    boolean isH5CollectEnable();

    boolean isNewUser();

    boolean isPrivacyMode();

    boolean manualActivate();

    EventBuilder newEvent(String str);

    void onActivityPause();

    void onActivityResumed(Activity activity, int i);

    void onEventV3(String str);

    void onEventV3(String str, Bundle bundle);

    void onEventV3(String str, Bundle bundle, int i);

    void onEventV3(String str, JSONObject jSONObject);

    void onEventV3(String str, JSONObject jSONObject, int i);

    @Deprecated
    void onMiscEvent(String str, JSONObject jSONObject);

    void onPause(Context context);

    void onResume(Context context);

    void pauseDurationEvent(String str);

    void profileAppend(JSONObject jSONObject);

    void profileIncrement(JSONObject jSONObject);

    void profileSet(JSONObject jSONObject);

    void profileSetOnce(JSONObject jSONObject);

    void profileUnset(String str);

    void pullAbTestConfigs();

    void pullAbTestConfigs(int i, IPullAbTestConfigCallback iPullAbTestConfigCallback);

    @Deprecated
    void putCommonParams(Context context, Map<String, String> map, boolean z, Level level);

    void receive(AbstractC0479n4 abstractC0479n4);

    void receive(String[] strArr);

    @Deprecated
    void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback);

    void removeAllDataObserver();

    void removeDataObserver(IDataObserver iDataObserver);

    @Deprecated
    void removeEventObserver(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver);

    void removeHeaderInfo(String str);

    void removeJsonEventObserver(IEventJsonObserver iEventJsonObserver);

    void removeJsonEventObserver(IEventObserver iEventObserver);

    void removeOaidObserver(IOaidObserver iOaidObserver);

    void removeSessionHook(ISessionObserver iSessionObserver);

    void resumeDurationEvent(String str);

    void setALinkListener(IALinkListener iALinkListener);

    @Deprecated
    void setAccount(Account account);

    void setActiveCustomParams(IActiveCustomParamsCallback iActiveCustomParamsCallback);

    @Deprecated
    void setAppContext(InterfaceC0481o interfaceC0481o);

    void setAppLanguageAndRegion(String str, String str2);

    void setAppTrack(JSONObject jSONObject);

    void setClipboardEnabled(boolean z);

    void setEncryptAndCompress(boolean z);

    void setEventFilterByClient(List<String> list, boolean z);

    void setEventHandler(IEventHandler iEventHandler);

    void setExternalAbVersion(String str);

    @Deprecated
    void setExtraParams(IExtraParams iExtraParams);

    void setGPSLocation(float f, float f2, String str);

    void setGoogleAid(String str);

    void setHeaderInfo(String str, Object obj);

    void setHeaderInfo(HashMap<String, Object> hashMap);

    void setLaunchFrom(int i);

    void setOaidObserver(IOaidObserver iOaidObserver);

    void setPrivacyMode(boolean z);

    void setPullAbTestConfigsThrottleMills(Long l);

    void setRangersEventVerifyEnable(boolean z, String str);

    void setTouchPoint(String str);

    void setTracerData(JSONObject jSONObject);

    void setUriRuntime(UriConfig uriConfig);

    void setUserAgent(String str);

    void setUserID(long j);

    void setUserUniqueID(String str);

    void setUserUniqueID(String str, String str2);

    void setViewId(Dialog dialog, String str);

    void setViewId(View view, String str);

    void setViewId(Object obj, String str);

    void setViewProperties(View view, JSONObject jSONObject);

    void start();

    void startDurationEvent(String str);

    void startSimulator(String str);

    void stopDurationEvent(String str, JSONObject jSONObject);

    void stopDurationEvent(String str, JSONObject jSONObject, String str2);

    void trackClick(View view);

    void trackClick(View view, JSONObject jSONObject);

    void trackPage(Activity activity);

    void trackPage(Activity activity, JSONObject jSONObject);

    void trackPage(Object obj);

    void trackPage(Object obj, JSONObject jSONObject);

    @Deprecated
    void userProfileSetOnce(JSONObject jSONObject, UserProfileCallback userProfileCallback);

    @Deprecated
    void userProfileSync(JSONObject jSONObject, UserProfileCallback userProfileCallback);
}
