package com.bytedance.push.interfaze;

import android.content.Context;
import com.bytedance.android.service.manager.push.interfaze.IMultiProcessEventSenderService;
import com.bytedance.android.service.manager.push.monitor.IMultiProcessMonitor;
import com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService;
import com.bytedance.push.Configuration;
import com.bytedance.push.Keep;
import com.bytedance.push.configuration.AbsBDPushConfiguration;
import com.bytedance.push.log.ILogger;
import com.bytedance.push.network.CommonParamProvider;
import com.ss.android.message.IPushLifeAdapter;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ISupport extends Keep {
    String filterUrl(Context context, String str);

    IClientIntelligenceService getClientIntelligenceService();

    Map<String, String> getCommonParams();

    Configuration getConfiguration();

    JSONObject getFrontierSetting();

    IProfileIdService getIProfileIdService();

    ILogger getLogger();

    IMessageCallbackService getMessageCallbackService();

    IMessageSpreadOutService getMessageSpreadOutService();

    IMonitor getMonitor();

    IMultiProcessEventSenderService getMultiProcessEventSenderService();

    IMultiProcessMonitor getMultiProcessMonitor();

    INotificationService getNotificationService();

    INotificationSwitchReport getNotificationSwitchReport();

    IProcessManagerService getProcessManagerService();

    IPushLifeAdapter getPushAdapter();

    IPushMsgHandler getPushHandler();

    IPushNotificationManagerService getPushNotificationManagerService();

    IPushRedbadgeManager getPushRedbadgeManager();

    IPushSdkMonitorService getPushSdkMonitorService();

    ISenderService getSenderService();

    ISignalReportService getSignalReportService();

    IEventSender getStatisticsService();

    ISystemBroadcastService getSystemBroadcastService();

    IThirdSupportService getThirdService();

    ITokenRetryService getTokenRetryService();

    void init(Configuration configuration, CommonParamProvider commonParamProvider);

    void init(AbsBDPushConfiguration absBDPushConfiguration);

    void requestSettings(boolean z);

    void setFrontierSetting(JSONObject jSONObject);
}
