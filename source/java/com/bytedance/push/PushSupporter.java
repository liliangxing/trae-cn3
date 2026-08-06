package com.bytedance.push;

import android.content.Context;
import com.bytedance.android.service.manager.push.interfaze.IMultiProcessEventSenderService;
import com.bytedance.android.service.manager.push.monitor.IMultiProcessMonitor;
import com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.push.client.intelligence.ClientIntelligenceServiceImpl;
import com.bytedance.push.configuration.AbsBDPushConfiguration;
import com.bytedance.push.event.sync.SignalReportServiceImpl;
import com.bytedance.push.interfaze.IClientIntelligenceService;
import com.bytedance.push.interfaze.IEventSender;
import com.bytedance.push.interfaze.IMessageCallbackService;
import com.bytedance.push.interfaze.IMessageSpreadOutService;
import com.bytedance.push.interfaze.IMonitor;
import com.bytedance.push.interfaze.INotificationService;
import com.bytedance.push.interfaze.INotificationSwitchReport;
import com.bytedance.push.interfaze.IProcessManagerService;
import com.bytedance.push.interfaze.IProfileIdService;
import com.bytedance.push.interfaze.IPushMsgHandler;
import com.bytedance.push.interfaze.IPushNotificationManagerService;
import com.bytedance.push.interfaze.IPushRedbadgeManager;
import com.bytedance.push.interfaze.ISenderService;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.push.interfaze.ISupport;
import com.bytedance.push.interfaze.ISystemBroadcastService;
import com.bytedance.push.interfaze.IThirdSupportService;
import com.bytedance.push.interfaze.ITokenRetryService;
import com.bytedance.push.log.ILogger;
import com.bytedance.push.log.LoggerImpl;
import com.bytedance.push.monitor.MonitorImpl;
import com.bytedance.push.monitor.MonitorMock;
import com.bytedance.push.monitor.MultiProcessMonitor;
import com.bytedance.push.monitor.PushSdkMonitorServiceImpl;
import com.bytedance.push.msg.callback.MessageCallbackServiceImpl;
import com.bytedance.push.network.CommonParamProvider;
import com.bytedance.push.notification.NotificationServiceImpl;
import com.bytedance.push.notification.PushMsgHandler;
import com.bytedance.push.notification.PushNotificationManager;
import com.bytedance.push.process.manager.ProcessManagerService;
import com.bytedance.push.profile.ProfileIdServiceImpl;
import com.bytedance.push.redbadge.PushRedbadgeManager;
import com.bytedance.push.spread.out.MessageSpreadOutServiceImpl;
import com.bytedance.push.sys.broadcast.SystemBroadcastServiceImpl;
import com.bytedance.push.task.RequestSettingsTask;
import com.bytedance.push.third.PushLifeManager;
import com.bytedance.push.token.TokenRetryService;
import com.ss.android.message.IPushLifeAdapter;
import com.ss.android.message.util.ToolUtils;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushSupporter implements ISupport {
    private static PushSupporter supporter = new PushSupporter();
    private AbsBDPushConfiguration mAbsBDPushConfiguration;
    private volatile CommonParamProvider mCommonParamProvider;
    private volatile Configuration mConfiguration;
    private volatile JSONObject mFrontierSetting;
    private volatile IClientIntelligenceService mIClientIntelligenceService;
    private volatile ISignalReportService mIEventSyncService;
    private volatile IMessageCallbackService mIMessageCallbackService;
    private volatile IMultiProcessMonitor mIMultiProcessMonitor;
    private volatile IProcessManagerService mIProcessManagerService;
    private volatile IProfileIdService mIProfileIdService;
    private volatile IPushNotificationManagerService mIPushNotificationManagerService;
    private volatile IPushSdkMonitorService mIPushSdkMonitorService;
    private volatile ISystemBroadcastService mISystemBroadcastService;
    private volatile ITokenRetryService mITokenRetryService;
    private LoggerImpl mLogger = new LoggerImpl();
    private volatile IMessageSpreadOutService mMessageSpreadOutService;
    private volatile IMonitor mMonitor;
    private volatile INotificationService mNotificationService;
    private volatile INotificationSwitchReport mNotificationSwitchReport;
    private volatile IPushMsgHandler mPushHandler;
    private volatile IPushRedbadgeManager mRedbadgeManager;
    private volatile SenderService mSenderService;
    private volatile ThirdSupportService mThirdService;
    private volatile IMultiProcessEventSenderService multiProcessEventSenderService;

    public static ISupport get() {
        return supporter;
    }

    public static IEventSender statisticsService() {
        return get().getStatisticsService();
    }

    public static ILogger logger() {
        return get().getLogger();
    }

    public static IThirdSupportService thirdService() {
        return get().getThirdService();
    }

    public static IPushMsgHandler pushHandler() {
        return get().getPushHandler();
    }

    public static IMonitor monitor() {
        return get().getMonitor();
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public Map<String, String> getCommonParams() {
        return getCommonParamProvider().getHttpCommonParams();
    }

    public CommonParamProvider getCommonParamProvider() {
        if (this.mCommonParamProvider == null) {
            synchronized (this) {
                if (this.mCommonParamProvider == null) {
                    this.mCommonParamProvider = new CommonParamProvider(getConfiguration());
                }
            }
        }
        return this.mCommonParamProvider;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public INotificationService getNotificationService() {
        if (this.mNotificationService == null) {
            synchronized (this) {
                if (this.mNotificationService == null) {
                    this.mNotificationService = new NotificationServiceImpl(this);
                }
            }
        }
        return this.mNotificationService;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public ISenderService getSenderService() {
        if (this.mSenderService == null) {
            synchronized (this) {
                if (this.mSenderService == null) {
                    this.mSenderService = new SenderService();
                }
            }
        }
        return this.mSenderService;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public Configuration getConfiguration() {
        if (this.mConfiguration == null) {
            synchronized (this) {
                if (this.mConfiguration == null) {
                    this.mConfiguration = Configuration.get();
                }
            }
        }
        return this.mConfiguration;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IThirdSupportService getThirdService() {
        if (this.mThirdService == null) {
            synchronized (this) {
                if (this.mThirdService == null) {
                    this.mThirdService = new ThirdSupportService(getSenderService(), getPushHandler(), getConfiguration());
                }
            }
        }
        return this.mThirdService;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public ILogger getLogger() {
        return this.mLogger;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IPushMsgHandler getPushHandler() {
        if (this.mPushHandler == null) {
            synchronized (this) {
                if (this.mPushHandler == null) {
                    this.mPushHandler = new PushMsgHandler(getConfiguration());
                }
            }
        }
        return this.mPushHandler;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IPushLifeAdapter getPushAdapter() {
        return PushLifeManager.inst();
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IEventSender getStatisticsService() {
        return getConfiguration().mEventCallback;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IMonitor getMonitor() {
        if (this.mMonitor == null) {
            synchronized (this) {
                if (this.mMonitor == null) {
                    if (ToolUtils.isMainProcess(getConfiguration().mApplication)) {
                        this.mMonitor = new MonitorImpl();
                    } else {
                        this.mMonitor = new MonitorMock();
                    }
                }
            }
        }
        return this.mMonitor;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public String filterUrl(Context context, String str) {
        return getConfiguration().mFilter != null ? getConfiguration().mFilter.filterUrl(context, str) : str;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public void setFrontierSetting(JSONObject jSONObject) {
        this.mFrontierSetting = jSONObject;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public JSONObject getFrontierSetting() {
        return this.mFrontierSetting;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IPushRedbadgeManager getPushRedbadgeManager() {
        if (this.mRedbadgeManager == null) {
            synchronized (this) {
                if (this.mRedbadgeManager == null) {
                    this.mRedbadgeManager = new PushRedbadgeManager(getConfiguration().mApplication);
                }
            }
        }
        return this.mRedbadgeManager;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public void requestSettings(boolean z) {
        ThreadPlus.submitRunnable(new RequestSettingsTask(z, false));
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IClientIntelligenceService getClientIntelligenceService() {
        if (this.mIClientIntelligenceService == null) {
            synchronized (this) {
                if (this.mIClientIntelligenceService == null) {
                    this.mIClientIntelligenceService = new ClientIntelligenceServiceImpl(getConfiguration().mApplication);
                }
            }
        }
        return this.mIClientIntelligenceService;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IProcessManagerService getProcessManagerService() {
        if (this.mIProcessManagerService == null) {
            synchronized (this) {
                if (this.mIProcessManagerService == null) {
                    this.mIProcessManagerService = new ProcessManagerService(getConfiguration().mApplication);
                }
            }
        }
        return this.mIProcessManagerService;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IPushNotificationManagerService getPushNotificationManagerService() {
        if (this.mIPushNotificationManagerService == null) {
            synchronized (this) {
                if (this.mIPushNotificationManagerService == null) {
                    this.mIPushNotificationManagerService = new PushNotificationManager();
                }
            }
        }
        return this.mIPushNotificationManagerService;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IMultiProcessMonitor getMultiProcessMonitor() {
        if (this.mIMultiProcessMonitor == null) {
            synchronized (this) {
                if (this.mIMultiProcessMonitor == null) {
                    this.mIMultiProcessMonitor = new MultiProcessMonitor();
                }
            }
        }
        return this.mIMultiProcessMonitor;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IMessageSpreadOutService getMessageSpreadOutService() {
        if (this.mMessageSpreadOutService == null) {
            synchronized (this) {
                if (this.mMessageSpreadOutService == null) {
                    this.mMessageSpreadOutService = new MessageSpreadOutServiceImpl();
                }
            }
        }
        return this.mMessageSpreadOutService;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public INotificationSwitchReport getNotificationSwitchReport() {
        if (this.mNotificationSwitchReport == null) {
            synchronized (this) {
                if (this.mNotificationSwitchReport == null) {
                    this.mNotificationSwitchReport = new NotificationSwitchReportImpl();
                }
            }
        }
        return this.mNotificationSwitchReport;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public ISignalReportService getSignalReportService() {
        if (this.mIEventSyncService == null) {
            synchronized (this) {
                if (this.mIEventSyncService == null) {
                    this.mIEventSyncService = new SignalReportServiceImpl();
                }
            }
        }
        return this.mIEventSyncService;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IPushSdkMonitorService getPushSdkMonitorService() {
        if (this.mIPushSdkMonitorService == null) {
            synchronized (this) {
                if (this.mIPushSdkMonitorService == null) {
                    this.mIPushSdkMonitorService = new PushSdkMonitorServiceImpl();
                }
            }
        }
        return this.mIPushSdkMonitorService;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IMessageCallbackService getMessageCallbackService() {
        if (this.mIMessageCallbackService == null) {
            synchronized (this) {
                if (this.mIMessageCallbackService == null) {
                    this.mIMessageCallbackService = new MessageCallbackServiceImpl();
                }
            }
        }
        return this.mIMessageCallbackService;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IProfileIdService getIProfileIdService() {
        if (this.mIProfileIdService == null) {
            synchronized (this) {
                if (this.mIProfileIdService == null) {
                    this.mIProfileIdService = new ProfileIdServiceImpl();
                }
            }
        }
        return this.mIProfileIdService;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public ITokenRetryService getTokenRetryService() {
        if (this.mITokenRetryService == null) {
            synchronized (this) {
                if (this.mITokenRetryService == null) {
                    this.mITokenRetryService = new TokenRetryService();
                }
            }
        }
        return this.mITokenRetryService;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public ISystemBroadcastService getSystemBroadcastService() {
        if (this.mISystemBroadcastService == null) {
            synchronized (this) {
                if (this.mISystemBroadcastService == null) {
                    this.mISystemBroadcastService = new SystemBroadcastServiceImpl();
                }
            }
        }
        return this.mISystemBroadcastService;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public void init(Configuration configuration, CommonParamProvider commonParamProvider) {
        this.mConfiguration = configuration;
        this.mCommonParamProvider = commonParamProvider;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public void init(AbsBDPushConfiguration absBDPushConfiguration) {
        this.mAbsBDPushConfiguration = absBDPushConfiguration;
    }

    @Override // com.bytedance.push.interfaze.ISupport
    public IMultiProcessEventSenderService getMultiProcessEventSenderService() {
        if (this.multiProcessEventSenderService == null) {
            synchronized (this) {
                if (this.multiProcessEventSenderService == null) {
                    this.multiProcessEventSenderService = new MultiProcessEventSenderService();
                }
            }
        }
        return this.multiProcessEventSenderService;
    }
}
