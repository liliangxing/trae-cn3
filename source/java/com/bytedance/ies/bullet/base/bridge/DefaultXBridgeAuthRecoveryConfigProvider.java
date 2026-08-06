package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.bullet.service.base.settings.BridgeAuthRecoveryConfig;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.sdk.xbridge.cn.auth.XBridgeRecoveryConfigProvider;
import java.util.List;
import kotlin.Metadata;

/* compiled from: DefaultXBridgeAuthRecoveryConfigProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/base/bridge/DefaultXBridgeAuthRecoveryConfigProvider;", "Lcom/bytedance/sdk/xbridge/cn/auth/XBridgeRecoveryConfigProvider;", "()V", "authRequestInterval", "", "enableAuthConfigRequest", "", "enableConfigUpdate", "getCloseAuthUrls", "", "", "getConfig", "Lcom/bytedance/ies/bullet/service/base/settings/BridgeAuthRecoveryConfig;", "getSettingsVersion", "", "isCloseAllAuth", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DefaultXBridgeAuthRecoveryConfigProvider implements XBridgeRecoveryConfigProvider {
    public int getSettingsVersion() {
        return getConfig().getSettingsVersion();
    }

    public List<String> getCloseAuthUrls() {
        return getConfig().getCloseAuthUrls();
    }

    public boolean isCloseAllAuth() {
        return getConfig().getIsCloseAllAuth();
    }

    public boolean enableConfigUpdate() {
        return getConfig().getEnableConfigUpdate();
    }

    public boolean enableAuthConfigRequest() {
        return getConfig().getEnableAuthConfigRequest();
    }

    public long authRequestInterval() {
        return getConfig().getAuthRequestInterval();
    }

    private final BridgeAuthRecoveryConfig getConfig() {
        CommonConfig commonConfig;
        BridgeAuthRecoveryConfig bridgeAuthRecoveryConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        return (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (bridgeAuthRecoveryConfig = commonConfig.getBridgeAuthRecoveryConfig()) == null) ? new BridgeAuthRecoveryConfig() : bridgeAuthRecoveryConfig;
    }
}
