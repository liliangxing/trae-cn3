package com.bytedance.bdturing.setting;

import android.os.Looper;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.ttnet.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigProvider.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/bytedance/bdturing/setting/ConfigProviderChecker;", "Lcom/bytedance/bdturing/setting/ConfigProvider;", "configProvider", "(Lcom/bytedance/bdturing/setting/ConfigProvider;)V", "getConfigProvider", "()Lcom/bytedance/bdturing/setting/ConfigProvider;", "getAppId", "", "getAppName", "getAppVersion", "getAppVersionCode", "getChannel", "getDeviceId", "getHttpClient", "Lcom/bytedance/bdturing/ttnet/HttpClient;", "getInstallId", "getLang", "getRegion", "getSDKVersion", "getServiceInterceptor", "Lcom/bytedance/bdturing/setting/ServiceInterceptor;", "getWorkerLooper", "Landroid/os/Looper;", "setting_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConfigProviderChecker implements ConfigProvider {
    private final ConfigProvider configProvider;

    @Override // com.bytedance.bdturing.setting.ConfigProvider
    public String getAppId() {
        return this.configProvider.getAppId();
    }

    @Override // com.bytedance.bdturing.setting.ConfigProvider
    public String getAppName() {
        return this.configProvider.getAppName();
    }

    @Override // com.bytedance.bdturing.setting.ConfigProvider
    public String getAppVersion() {
        return this.configProvider.getAppVersion();
    }

    @Override // com.bytedance.bdturing.setting.ConfigProvider
    public String getAppVersionCode() {
        return this.configProvider.getAppVersionCode();
    }

    @Override // com.bytedance.bdturing.setting.ConfigProvider
    public String getChannel() {
        return this.configProvider.getChannel();
    }

    @Override // com.bytedance.bdturing.setting.ConfigProvider
    public String getDeviceId() {
        return this.configProvider.getDeviceId();
    }

    @Override // com.bytedance.bdturing.setting.ConfigProvider
    public HttpClient getHttpClient() {
        return this.configProvider.getHttpClient();
    }

    @Override // com.bytedance.bdturing.setting.ConfigProvider
    public String getInstallId() {
        return this.configProvider.getInstallId();
    }

    @Override // com.bytedance.bdturing.setting.ConfigProvider
    public String getLang() {
        return this.configProvider.getLang();
    }

    @Override // com.bytedance.bdturing.setting.ConfigProvider
    public String getSDKVersion() {
        return this.configProvider.getSDKVersion();
    }

    @Override // com.bytedance.bdturing.setting.ConfigProvider
    public ServiceInterceptor getServiceInterceptor() {
        return this.configProvider.getServiceInterceptor();
    }

    @Override // com.bytedance.bdturing.setting.ConfigProvider
    public Looper getWorkerLooper() {
        return this.configProvider.getWorkerLooper();
    }

    public ConfigProviderChecker(ConfigProvider configProvider) {
        Intrinsics.checkNotNullParameter(configProvider, "configProvider");
        this.configProvider = configProvider;
    }

    public final ConfigProvider getConfigProvider() {
        return this.configProvider;
    }

    @Override // com.bytedance.bdturing.setting.ConfigProvider
    public String getRegion() {
        String region = this.configProvider.getRegion();
        if ((Intrinsics.areEqual(region, Region.CN.getValue()) ? true : Intrinsics.areEqual(region, Region.SINGAPOER.getValue()) ? true : Intrinsics.areEqual(region, Region.USA_EAST.getValue()) ? true : Intrinsics.areEqual(region, Region.INDIA.getValue()) ? true : Intrinsics.areEqual(region, Region.BOE.getValue())) || !LogUtil.isDebug()) {
            return region;
        }
        throw new RuntimeException("not support this region");
    }
}
