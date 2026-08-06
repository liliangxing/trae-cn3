package com.bytedance.push;

import android.content.Context;
import com.bytedance.android.push.service.manager.annotation.ServiceProvider;
import com.bytedance.android.service.manager.push.PushExternalService;
import com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService;
import com.bytedance.android.service.manager.push.client.intelligence.IClientIntelligenceService;
import com.bytedance.android.service.manager.push.interfaze.IMultiProcessEventSenderService;
import com.bytedance.android.service.manager.push.monitor.IMultiProcessMonitor;
import com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService;
import com.bytedance.android.service.manager.push.notification.INotificationMonitorService;
import com.bytedance.android.service.manager.push.settings.ISettingsUpdateListener;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.client.intelligence.FeatureCollectionHelper;
import com.bytedance.push.monitor.ProcessStartMonitor;
import com.bytedance.push.monitor.multiprocess.PushMultiProcessMonitor;
import com.bytedance.push.notification.NotificationShowMonitor;
import com.bytedance.push.task.RequestSettingsTask;
import com.bytedance.push.third.PushChannelHelper;
import com.ss.android.message.AppProvider;
import com.ss.android.pushmanager.setting.PushSetting;
import java.util.List;
import org.json.JSONObject;

@ServiceProvider
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushServiceProvider implements PushExternalService {
    public void showPush(JSONObject jSONObject, int i, String str) {
        PushSupporter.get().getPushHandler().handlePassThroughMsg(jSONObject, i, str);
    }

    public void showPush(JSONObject jSONObject, int i, String str, boolean z) {
        PushSupporter.get().getPushHandler().handlePassThroughMsg(jSONObject, i, str, z);
    }

    public String checkAndGetValidChannelId(Context context, String str) {
        return PushSupporter.get().getNotificationService().checkAndGetValidChannelId(context, str);
    }

    public void createDefaultChannel(Context context) {
        PushSupporter.get().getNotificationService().createDefaultChannel(context);
    }

    public IMultiProcessEventSenderService getMultiProcessEventSenderService() {
        return PushSupporter.get().getMultiProcessEventSenderService();
    }

    public void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        PushMultiProcessMonitor.getInstance().monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
    }

    public boolean allowStartNonMainProcess() {
        return PushSupporter.get().getProcessManagerService().allowStartNonMainProcess();
    }

    public boolean curIsWorkerProcess(Context context) {
        return PushSupporter.get().getProcessManagerService().curIsWorkerProcess(context);
    }

    public ProcessEnum getWorkerProcess(Context context) {
        return PushSupporter.get().getProcessManagerService().getWorkerProcessEnum(context);
    }

    public void tryUpdateSender() {
        PushSupporter.get().getSenderService().tryUpdateSender(false);
    }

    public void tryUpdateNoticeState(Context context) {
        PushSupporter.get().getNotificationSwitchReport().tryUpdateNoticeStateByAlliance(context);
    }

    public void onNotificationDelete(long j, JSONObject jSONObject) {
        BDPush.getPushService().onNotificationDelete(j, jSONObject);
    }

    public IClientFeatureService getClientFeatureService() {
        return FeatureCollectionHelper.getInstance(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication);
    }

    public IClientIntelligenceService getClientIntelligenceService() {
        return PushSupporter.get().getClientIntelligenceService();
    }

    public IMultiProcessMonitor getIMultiProcessMonitor() {
        return PushSupporter.get().getMultiProcessMonitor();
    }

    public INotificationMonitorService getNotificationMonitorService() {
        return NotificationShowMonitor.inst();
    }

    public IPushSdkMonitorService getPushSdkMonitorService() {
        return PushSupporter.get().getPushSdkMonitorService();
    }

    public boolean isAppNotifyOpen() {
        return PushSetting.getInstance().isPushNotifyEnable();
    }

    public boolean isSupportSystemPushPermissionDialog(Context context) {
        return PushChannelHelper.inst(context).isSupportSystemPushPermissionDialog();
    }

    public void requestNotificationPermissionBySysDialog(String str, RequestResultCallback requestResultCallback) {
        PushChannelHelper.inst(AppProvider.getApp()).requestNotificationPermissionByBusinessAlert(str, requestResultCallback);
    }

    public void triggerSignalReport(String str) {
        PushSupporter.get().getSignalReportService().triggerSignalReport(str);
    }

    public void registerSettingsUpdateListener(ISettingsUpdateListener iSettingsUpdateListener) {
        PushSetting.getInstance().registerSettingsUpdateListener(iSettingsUpdateListener);
    }

    public void unRegisterSettingsUpdateListener(ISettingsUpdateListener iSettingsUpdateListener) {
        PushSetting.getInstance().unRegisterSettingsUpdateListener(iSettingsUpdateListener);
    }

    public void requestSettings(List<String> list, boolean z) {
        ThreadPlus.submitRunnable(new RequestSettingsTask(true, z, list, false));
    }

    public void requestSettingsSynchronous(List<String> list, boolean z) {
        new RequestSettingsTask(true, z, list, true).run();
    }

    public void onContentProviderLaunch(String str, String str2) {
        ProcessStartMonitor.getInstance().onContentProviderLaunch(str, str2);
    }

    public boolean isNewUserLaunch() {
        return PushSupporter.get().getConfiguration().mIsNewUser;
    }

    public String getCurBusinessSysAlertTypeForCustomDialog(Context context) {
        return PushChannelHelper.inst(context).getCurBusinessSysAlertTypeForCustomDialog();
    }
}
