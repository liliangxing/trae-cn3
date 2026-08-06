package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: SecuritySettingConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/SecuritySettingConfig;", "", "()V", "geckoLoaderSecureConfig", "Lcom/bytedance/ies/bullet/base/settings/GeckoLoaderSecureConfig;", "getGeckoLoaderSecureConfig", "()Lcom/bytedance/ies/bullet/base/settings/GeckoLoaderSecureConfig;", "setGeckoLoaderSecureConfig", "(Lcom/bytedance/ies/bullet/base/settings/GeckoLoaderSecureConfig;)V", "jsbAuthStrategySettingConfig", "Lcom/bytedance/ies/bullet/base/settings/JSBAuthStrategySetting;", "getJsbAuthStrategySettingConfig", "()Lcom/bytedance/ies/bullet/base/settings/JSBAuthStrategySetting;", "setJsbAuthStrategySettingConfig", "(Lcom/bytedance/ies/bullet/base/settings/JSBAuthStrategySetting;)V", "lynxSignVerifyStrategyConfig", "Lcom/bytedance/ies/bullet/base/settings/LynxSignVerifyConfig;", "getLynxSignVerifyStrategyConfig", "()Lcom/bytedance/ies/bullet/base/settings/LynxSignVerifyConfig;", "setLynxSignVerifyStrategyConfig", "(Lcom/bytedance/ies/bullet/base/settings/LynxSignVerifyConfig;)V", "monitorConfig", "Lcom/bytedance/ies/bullet/base/settings/MonitorConfig;", "getMonitorConfig", "()Lcom/bytedance/ies/bullet/base/settings/MonitorConfig;", "setMonitorConfig", "(Lcom/bytedance/ies/bullet/base/settings/MonitorConfig;)V", "secLinkConfig", "Lcom/bytedance/ies/bullet/base/settings/SecLinkConfig;", "getSecLinkConfig", "()Lcom/bytedance/ies/bullet/base/settings/SecLinkConfig;", "setSecLinkConfig", "(Lcom/bytedance/ies/bullet/base/settings/SecLinkConfig;)V", "webcastConfig", "Lcom/bytedance/ies/bullet/base/settings/LegacyWebcastConfig;", "getWebcastConfig", "()Lcom/bytedance/ies/bullet/base/settings/LegacyWebcastConfig;", "setWebcastConfig", "(Lcom/bytedance/ies/bullet/base/settings/LegacyWebcastConfig;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SecuritySettingConfig {

    @SerializedName("jsb_auth")
    private JSBAuthStrategySetting jsbAuthStrategySettingConfig = new JSBAuthStrategySetting();

    @SerializedName("lynx_sign_verify")
    private LynxSignVerifyConfig lynxSignVerifyStrategyConfig = new LynxSignVerifyConfig();

    @SerializedName("sec_link")
    private SecLinkConfig secLinkConfig = new SecLinkConfig();

    @SerializedName("gecko_loader_secure")
    private GeckoLoaderSecureConfig geckoLoaderSecureConfig = new GeckoLoaderSecureConfig();

    @SerializedName("monitor_config")
    private MonitorConfig monitorConfig = new MonitorConfig();

    @SerializedName("legacy_webcast")
    private LegacyWebcastConfig webcastConfig = new LegacyWebcastConfig();

    public final JSBAuthStrategySetting getJsbAuthStrategySettingConfig() {
        return this.jsbAuthStrategySettingConfig;
    }

    public final void setJsbAuthStrategySettingConfig(JSBAuthStrategySetting jSBAuthStrategySetting) {
        this.jsbAuthStrategySettingConfig = jSBAuthStrategySetting;
    }

    public final LynxSignVerifyConfig getLynxSignVerifyStrategyConfig() {
        return this.lynxSignVerifyStrategyConfig;
    }

    public final void setLynxSignVerifyStrategyConfig(LynxSignVerifyConfig lynxSignVerifyConfig) {
        this.lynxSignVerifyStrategyConfig = lynxSignVerifyConfig;
    }

    public final SecLinkConfig getSecLinkConfig() {
        return this.secLinkConfig;
    }

    public final void setSecLinkConfig(SecLinkConfig secLinkConfig) {
        this.secLinkConfig = secLinkConfig;
    }

    public final GeckoLoaderSecureConfig getGeckoLoaderSecureConfig() {
        return this.geckoLoaderSecureConfig;
    }

    public final void setGeckoLoaderSecureConfig(GeckoLoaderSecureConfig geckoLoaderSecureConfig) {
        this.geckoLoaderSecureConfig = geckoLoaderSecureConfig;
    }

    public final MonitorConfig getMonitorConfig() {
        return this.monitorConfig;
    }

    public final void setMonitorConfig(MonitorConfig monitorConfig) {
        this.monitorConfig = monitorConfig;
    }

    public final LegacyWebcastConfig getWebcastConfig() {
        return this.webcastConfig;
    }

    public final void setWebcastConfig(LegacyWebcastConfig legacyWebcastConfig) {
        this.webcastConfig = legacyWebcastConfig;
    }
}
