package com.bytedance.trae.settings.impl;

import android.app.Application;
import android.os.Build;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.news.common.settings.SettingsConfig;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.news.common.settings.SettingsLazyConfig;
import com.bytedance.news.common.settings.api.model.SettingsRequestParamsModel;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.AppUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsConfigProviderImpl.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;", "Lcom/bytedance/news/common/settings/SettingsConfigProvider;", "<init>", "()V", "settingsRequestService", "Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl;", "settingsAbVersionService", "Lcom/bytedance/trae/settings/impl/SettingsAbVersionServiceImpl;", "settingsConfig", "Lcom/bytedance/news/common/settings/SettingsConfig;", "settingsLazyConfig", "Lcom/bytedance/news/common/settings/SettingsLazyConfig;", "requestParamsModel", "Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;", "getConfig", "getRequestParamsModel", "getLazyConfig", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SettingsConfigProviderImpl implements SettingsConfigProvider {
    private SettingsRequestParamsModel requestParamsModel;
    private SettingsConfig settingsConfig;
    private SettingsLazyConfig settingsLazyConfig;
    private final SettingsRequestServiceImpl settingsRequestService = new SettingsRequestServiceImpl();
    private final SettingsAbVersionServiceImpl settingsAbVersionService = new SettingsAbVersionServiceImpl();

    @Override // com.bytedance.news.common.settings.SettingsConfigProvider
    public SettingsConfig getConfig() {
        if (this.settingsConfig == null) {
            Application application = AppHost.Companion.getApplication();
            this.settingsConfig = new SettingsConfig.Builder().context(application).requestService(this.settingsRequestService).isMainProcess(AppUtils.isMainProcess(application)).setAbReportService(this.settingsAbVersionService).requestParamsModel(getRequestParamsModel()).build();
        }
        SettingsConfig settingsConfig = this.settingsConfig;
        Intrinsics.checkNotNull(settingsConfig);
        return settingsConfig;
    }

    private final SettingsRequestParamsModel getRequestParamsModel() {
        SettingsRequestParamsModel settingsRequestParamsModel = this.requestParamsModel;
        if (settingsRequestParamsModel == null) {
            SettingsRequestParamsModel settingsRequestParamsModel2 = new SettingsRequestParamsModel();
            settingsRequestParamsModel2.appId = AppHost.Companion.getAppId();
            settingsRequestParamsModel2.channel = AppHost.Companion.getBuildChannel();
            settingsRequestParamsModel2.devicePlatform = "android";
            settingsRequestParamsModel2.deviceBrand = Build.BRAND;
            settingsRequestParamsModel2.deviceType = Build.MODEL;
            settingsRequestParamsModel2.osApi = Build.VERSION.SDK_INT;
            settingsRequestParamsModel2.osVersion = Build.VERSION.RELEASE;
            settingsRequestParamsModel2.versionCode = AppHost.Companion.getVersionCode();
            settingsRequestParamsModel2.updateVersionCode = AppHost.Companion.getUpdateVersionCode();
            String installId = IApplog.Companion.getInstallId();
            if (installId.length() > 0) {
                try {
                    settingsRequestParamsModel2.iid = Long.parseLong(installId);
                } catch (NumberFormatException unused) {
                }
            }
            String deviceId = IApplog.Companion.getDeviceId();
            if (deviceId.length() > 0) {
                try {
                    settingsRequestParamsModel2.deviceId = Long.parseLong(deviceId);
                } catch (NumberFormatException unused2) {
                }
            }
            this.requestParamsModel = settingsRequestParamsModel2;
        } else if (settingsRequestParamsModel != null) {
            if (settingsRequestParamsModel.iid == 0) {
                String installId2 = IApplog.Companion.getInstallId();
                if (installId2.length() > 0) {
                    try {
                        settingsRequestParamsModel.iid = Long.parseLong(installId2);
                    } catch (NumberFormatException unused3) {
                    }
                }
            }
            if (settingsRequestParamsModel.deviceId == 0) {
                String deviceId2 = IApplog.Companion.getDeviceId();
                if (deviceId2.length() > 0) {
                    try {
                        settingsRequestParamsModel.deviceId = Long.parseLong(deviceId2);
                    } catch (NumberFormatException unused4) {
                    }
                }
            }
        }
        SettingsRequestParamsModel settingsRequestParamsModel3 = this.requestParamsModel;
        Intrinsics.checkNotNull(settingsRequestParamsModel3);
        return settingsRequestParamsModel3;
    }

    @Override // com.bytedance.news.common.settings.SettingsConfigProvider
    public SettingsLazyConfig getLazyConfig() {
        String str;
        if (this.settingsLazyConfig == null) {
            try {
                str = String.valueOf(AppHost.Companion.getUpdateVersionCode());
            } catch (Exception unused) {
                str = ViewVisibleBridge.INVISIBLE;
            }
            this.settingsLazyConfig = new SettingsLazyConfig.Builder().updateVersionCode(str).build();
        }
        SettingsLazyConfig settingsLazyConfig = this.settingsLazyConfig;
        Intrinsics.checkNotNull(settingsLazyConfig);
        return settingsLazyConfig;
    }
}
