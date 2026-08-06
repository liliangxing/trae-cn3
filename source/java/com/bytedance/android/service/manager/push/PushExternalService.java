package com.bytedance.android.service.manager.push;

import android.content.Context;
import com.bytedance.android.push.service.manager.annotation.ExternalService;
import com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService;
import com.bytedance.android.service.manager.push.client.intelligence.IClientIntelligenceService;
import com.bytedance.android.service.manager.push.interfaze.IMultiProcessEventSenderService;
import com.bytedance.android.service.manager.push.monitor.IMultiProcessMonitor;
import com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService;
import com.bytedance.android.service.manager.push.notification.INotificationMonitorService;
import com.bytedance.android.service.manager.push.settings.ISettingsUpdateListener;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import java.util.List;
import org.json.JSONObject;

@ExternalService
/* loaded from: classes3.dex */
public interface PushExternalService {
    public static final String METHOD_DELETE_PROVIDER = "delete_provider";
    public static final String METHOD_GET_TYPE = "get_type_provider";
    public static final String METHOD_INSERT_PROVIDER = "insert_provider";
    public static final String METHOD_QUERY_PROVIDER = "query_provider";
    public static final String METHOD_UPDATE_PROVIDER = "update_provider";
    public static final String SETTINGS_REQUEST_TYPE_ALLIANCE_SDK = "alliance_sdk";
    public static final String SETTINGS_REQUEST_TYPE_PUSH_SDK = "PushSDK";
    public static final String SIGNAL_SCENE_APP_LAUNCH = "app_launch";
    public static final String SIGNAL_SCENE_DEPTHS = "depths";

    boolean allowStartNonMainProcess();

    String checkAndGetValidChannelId(Context context, String str);

    void createDefaultChannel(Context context);

    boolean curIsWorkerProcess(Context context);

    IClientFeatureService getClientFeatureService();

    IClientIntelligenceService getClientIntelligenceService();

    String getCurBusinessSysAlertTypeForCustomDialog(Context context);

    IMultiProcessMonitor getIMultiProcessMonitor();

    IMultiProcessEventSenderService getMultiProcessEventSenderService();

    INotificationMonitorService getNotificationMonitorService();

    IPushSdkMonitorService getPushSdkMonitorService();

    ProcessEnum getWorkerProcess(Context context);

    boolean isAppNotifyOpen();

    boolean isNewUserLaunch();

    boolean isSupportSystemPushPermissionDialog(Context context);

    void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    void onContentProviderLaunch(String str, String str2);

    void onNotificationDelete(long j, JSONObject jSONObject);

    void registerSettingsUpdateListener(ISettingsUpdateListener iSettingsUpdateListener);

    void requestNotificationPermissionBySysDialog(String str, RequestResultCallback requestResultCallback);

    void requestSettings(List<String> list, boolean z);

    void requestSettingsSynchronous(List<String> list, boolean z);

    void showPush(JSONObject jSONObject, int i, String str);

    void showPush(JSONObject jSONObject, int i, String str, boolean z);

    void triggerSignalReport(String str);

    void tryUpdateNoticeState(Context context);

    void tryUpdateSender();

    void unRegisterSettingsUpdateListener(ISettingsUpdateListener iSettingsUpdateListener);
}
