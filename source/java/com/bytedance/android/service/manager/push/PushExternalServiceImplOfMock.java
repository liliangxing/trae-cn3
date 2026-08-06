package com.bytedance.android.service.manager.push;

import android.content.Context;
import android.util.Log;
import com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService;
import com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureServiceImplOfMock;
import com.bytedance.android.service.manager.push.client.intelligence.IClientIntelligenceService;
import com.bytedance.android.service.manager.push.client.intelligence.IClientIntelligenceServiceImplOfMock;
import com.bytedance.android.service.manager.push.interfaze.IMultiProcessEventSenderService;
import com.bytedance.android.service.manager.push.interfaze.IMultiProcessEventSenderServiceImplOfMock;
import com.bytedance.android.service.manager.push.monitor.IMultiProcessMonitor;
import com.bytedance.android.service.manager.push.monitor.IMultiProcessMonitorImplOfMock;
import com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService;
import com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorServiceImplOfMock;
import com.bytedance.android.service.manager.push.notification.INotificationMonitorService;
import com.bytedance.android.service.manager.push.notification.INotificationMonitorServiceImplOfMock;
import com.bytedance.android.service.manager.push.settings.ISettingsUpdateListener;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PushExternalServiceImplOfMock implements PushExternalService {
    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void createDefaultChannel(Context context) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void onContentProviderLaunch(String str, String str2) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void onNotificationDelete(long j, JSONObject jSONObject) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void registerSettingsUpdateListener(ISettingsUpdateListener iSettingsUpdateListener) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void requestNotificationPermissionBySysDialog(String str, RequestResultCallback requestResultCallback) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void requestSettings(List<String> list, boolean z) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void requestSettingsSynchronous(List<String> list, boolean z) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void showPush(JSONObject jSONObject, int i, String str) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void showPush(JSONObject jSONObject, int i, String str, boolean z) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void triggerSignalReport(String str) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void tryUpdateNoticeState(Context context) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void tryUpdateSender() {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public void unRegisterSettingsUpdateListener(ISettingsUpdateListener iSettingsUpdateListener) {
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public String checkAndGetValidChannelId(Context context, String str) {
        Log.w("PushExternalService", "cur checkAndGetValidChannelId method is empty impl in PushExternalServiceImplOfMockClass");
        return "";
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public IMultiProcessEventSenderService getMultiProcessEventSenderService() {
        Log.w("PushExternalService", "cur getMultiProcessEventSenderService method is empty impl in PushExternalServiceImplOfMockClass");
        return new IMultiProcessEventSenderServiceImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public boolean allowStartNonMainProcess() {
        Log.w("PushExternalService", "cur allowStartNonMainProcess method is empty impl in PushExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public boolean curIsWorkerProcess(Context context) {
        Log.w("PushExternalService", "cur curIsWorkerProcess method is empty impl in PushExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public ProcessEnum getWorkerProcess(Context context) {
        Log.w("PushExternalService", "cur getWorkerProcess method is empty impl in PushExternalServiceImplOfMockClass");
        return null;
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public IClientFeatureService getClientFeatureService() {
        Log.w("PushExternalService", "cur getClientFeatureService method is empty impl in PushExternalServiceImplOfMockClass");
        return new IClientFeatureServiceImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public IClientIntelligenceService getClientIntelligenceService() {
        Log.w("PushExternalService", "cur getClientIntelligenceService method is empty impl in PushExternalServiceImplOfMockClass");
        return new IClientIntelligenceServiceImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public IMultiProcessMonitor getIMultiProcessMonitor() {
        Log.w("PushExternalService", "cur getIMultiProcessMonitor method is empty impl in PushExternalServiceImplOfMockClass");
        return new IMultiProcessMonitorImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public INotificationMonitorService getNotificationMonitorService() {
        Log.w("PushExternalService", "cur getNotificationMonitorService method is empty impl in PushExternalServiceImplOfMockClass");
        return new INotificationMonitorServiceImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public IPushSdkMonitorService getPushSdkMonitorService() {
        Log.w("PushExternalService", "cur getPushSdkMonitorService method is empty impl in PushExternalServiceImplOfMockClass");
        return new IPushSdkMonitorServiceImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public boolean isAppNotifyOpen() {
        Log.w("PushExternalService", "cur isAppNotifyOpen method is empty impl in PushExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public boolean isSupportSystemPushPermissionDialog(Context context) {
        Log.w("PushExternalService", "cur isSupportSystemPushPermissionDialog method is empty impl in PushExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public boolean isNewUserLaunch() {
        Log.w("PushExternalService", "cur isNewUserLaunch method is empty impl in PushExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.PushExternalService
    public String getCurBusinessSysAlertTypeForCustomDialog(Context context) {
        Log.w("PushExternalService", "cur getCurBusinessSysAlertTypeForCustomDialog method is empty impl in PushExternalServiceImplOfMockClass");
        return "";
    }
}
