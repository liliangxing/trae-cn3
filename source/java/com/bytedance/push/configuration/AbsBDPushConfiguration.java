package com.bytedance.push.configuration;

import android.app.Application;
import com.bytedance.common.model.ClientDisplayFeature;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.push.Configuration;
import com.bytedance.push.DefaultKeyConfiguration;
import com.bytedance.push.img.ImageDownloader;
import com.bytedance.push.img.UrlConnectionDownloader;
import com.bytedance.push.interfaze.HMSLowVersionCallback;
import com.bytedance.push.interfaze.I18nCommonParams;
import com.bytedance.push.interfaze.ICommonParams;
import com.bytedance.push.interfaze.ICustomNotificationBuilder;
import com.bytedance.push.interfaze.IEventSender;
import com.bytedance.push.interfaze.IPushMsgShowInterceptor;
import com.bytedance.push.interfaze.IRegisterResultCallback;
import com.bytedance.push.interfaze.IRevokeEventInterceptor;
import com.bytedance.push.interfaze.IVerifyFailedListener;
import com.bytedance.push.interfaze.OnPushClickListener;
import com.bytedance.push.interfaze.OnPushReceiveHandler;
import com.bytedance.push.interfaze.SoLoader;
import com.bytedance.push.interfaze.UrlFilter;
import com.bytedance.push.monitor.IPushMonitor;
import com.bytedance.push.monitor.opentracing.ITracingMonitor;
import com.bytedance.push.sound.SoundDownloader;
import com.bytedance.push.sound.UrlConnectionSoundDownloader;
import com.ss.android.message.IPushLifeAdapter;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.KeyConfiguration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsBDPushConfiguration extends IPushCommonConfiguration {
    private final String TAG = "AbsBDPushConfiguration";
    private Application mApplication;

    public boolean autoInitRedBadge() {
        return true;
    }

    public boolean enableALog() {
        return true;
    }

    public boolean enableAutoInit() {
        return true;
    }

    public boolean enableAutoRequestSettings() {
        return false;
    }

    public boolean enableAutoStart() {
        return true;
    }

    public boolean enableEncryptPassThroughMsg() {
        return false;
    }

    public boolean enableRealTimeReportEvent() {
        return false;
    }

    public String getAdmPayloadName() {
        return "payload";
    }

    public abstract BDPushBaseConfiguration getBDPushBaseConfiguration();

    public ICustomNotificationBuilder getCustomNotificationBuilder() {
        return null;
    }

    public int[] getCustomSoundsRes() {
        return null;
    }

    public String getDefaultNotificationChannelName() {
        return null;
    }

    public String getFcmPayloadName() {
        return "payload";
    }

    public HMSLowVersionCallback getHMSLowVersionCallback() {
        return null;
    }

    public ICommonParams getHttpCommonParams() {
        return null;
    }

    public I18nCommonParams getI18nCommonParams() {
        return null;
    }

    public ITracingMonitor getITracingMonitor() {
        return null;
    }

    public IVerifyFailedListener getIVerifyFailedListener() {
        return null;
    }

    public int getLogLevel() {
        return 3;
    }

    public abstract OnPushClickListener getOnPushClickListener();

    public OnPushReceiveHandler getOnPushReceiveHandler() {
        return null;
    }

    public String getPushAlogInstanceName() {
        return null;
    }

    public List<IPushLifeAdapter> getPushLifeAdapters() {
        return null;
    }

    public IPushMonitor getPushMonitor() {
        return null;
    }

    public IPushMsgShowInterceptor getPushMsgShowInterceptor() {
        return null;
    }

    public IRegisterResultCallback getRegisterResultCallback() {
        return null;
    }

    public IRevokeEventInterceptor getRevokeEventInterceptor() {
        return null;
    }

    public UrlFilter getUrlFilter() {
        return null;
    }

    protected boolean isBoe() {
        return false;
    }

    public boolean isDebug() {
        return false;
    }

    public boolean isForbidSDKClickEvent() {
        return false;
    }

    public boolean isPreInstallVersion() {
        return false;
    }

    public AbsBDPushConfiguration(Application application) {
        this.mApplication = application;
    }

    public Application getApplication() {
        return this.mApplication;
    }

    public String getProcess() {
        return ToolUtils.getCurProcessName(getApplication());
    }

    public KeyConfiguration getKeyConfiguration() {
        return new DefaultKeyConfiguration(getBDPushBaseConfiguration().isI18n(), getBDPushBaseConfiguration().getAppInfo().getChannel());
    }

    public IEventSender getEventSender() {
        return new DefaultEventSender();
    }

    public ImageDownloader getImageDownloader() {
        return new UrlConnectionDownloader();
    }

    public SoLoader getSoLoader() {
        return new SoLoader.DefaultSoLoader();
    }

    public long getDefaultInitTimeout() {
        return TimeUnit.MINUTES.toMillis(2L);
    }

    public SoundDownloader getSoundDownloader() {
        return new UrlConnectionSoundDownloader();
    }

    public ClientDisplayFeature getClientDisplayFeature() {
        return new ClientDisplayFeature();
    }

    public Configuration getConfiguration() {
        BDPushBaseConfiguration bDPushBaseConfiguration = getBDPushBaseConfiguration();
        Configuration.Builder clientDisplayFeature = new Configuration.Builder(getApplication(), bDPushBaseConfiguration.getAppInfo(), bDPushBaseConfiguration.getHost()).withDebug(isDebug()).withIsBoe(isBoe()).withLogLevel(getLogLevel()).withProcess(getProcess()).withDefaultNotificationChannel(getDefaultNotificationChannelName()).setPushLifeAdapters(getPushLifeAdapters()).withPushEventCallback(getEventSender()).withAccountService(getAccountService()).setPushShowInterceptor(getPushMsgShowInterceptor()).setCustomNotificationBuilder(getCustomNotificationBuilder()).isI18n(bDPushBaseConfiguration.isI18n()).withFilterUninstallUrl(getUrlFilter()).withHMSLowVersionCallback(getHMSLowVersionCallback()).withImageDownloader(getImageDownloader()).withExtraCommonParam(getHttpCommonParams()).withPushClickListener(getOnPushClickListener()).withMonitorImpl(getPushMonitor()).withSoLoader(getSoLoader()).withFcmPayloadName(getFcmPayloadName()).withAdmPayloadName(getAdmPayloadName()).forbidSDKClickEvent(isForbidSDKClickEvent()).defaultInitTimeout(getDefaultInitTimeout()).setPreInstallVersion(isPreInstallVersion()).withOpenTracingMonitor(getITracingMonitor()).setMsgRevokeEventInterceptor(getRevokeEventInterceptor()).setOnVerifyFailedListener(getIVerifyFailedListener()).withSoundDownloader(getSoundDownloader()).withRegisterResultCallback(getRegisterResultCallback()).withPushKeyConfiguration(getKeyConfiguration()).withNotificationSoundsRes(getCustomSoundsRes()).withI18nCommonParams(getI18nCommonParams()).enableALog(enableALog()).setPushAlogInstanceName(getPushAlogInstanceName()).withEnableRealTimeReportEvent(enableRealTimeReportEvent()).setAutoUpdateSettings(enableAutoRequestSettings()).withIsThoughMsgEncrypt(enableEncryptPassThroughMsg()).setAutoInitRedBadge(autoInitRedBadge()).setIPushCommonConfiguration(this).setClientDisplayFeature(getClientDisplayFeature());
        if (getOnPushReceiveHandler() != null) {
            clientDisplayFeature.withPushReceiveHandler(getOnPushReceiveHandler());
        }
        if (getCustomNotificationBuilder() != null) {
            clientDisplayFeature.setCustomNotificationBuilder(getCustomNotificationBuilder());
        }
        if (getPushMsgShowInterceptor() != null) {
            clientDisplayFeature.setPushShowInterceptor(getPushMsgShowInterceptor());
        }
        return clientDisplayFeature.build();
    }
}
