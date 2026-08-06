package com.bytedance.ies.argus.repository;

import com.bytedance.ies.argus.strategy.provider.BaseStrategyConfig;
import kotlin.Metadata;

/* compiled from: SecuritySettingConfigProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/argus/repository/SecuritySettingConfigModel;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyConfig;", "()V", "jsbAuthStrategySettingConfig", "Lcom/bytedance/ies/argus/repository/JSBAuthStrategySetting;", "getJsbAuthStrategySettingConfig", "()Lcom/bytedance/ies/argus/repository/JSBAuthStrategySetting;", "setJsbAuthStrategySettingConfig", "(Lcom/bytedance/ies/argus/repository/JSBAuthStrategySetting;)V", "lynxSignVerifyStrategyConfig", "Lcom/bytedance/ies/argus/repository/LynxSignVerifyConfig;", "getLynxSignVerifyStrategyConfig", "()Lcom/bytedance/ies/argus/repository/LynxSignVerifyConfig;", "setLynxSignVerifyStrategyConfig", "(Lcom/bytedance/ies/argus/repository/LynxSignVerifyConfig;)V", "monitorConfig", "Lcom/bytedance/ies/argus/repository/MonitorConfig;", "getMonitorConfig", "()Lcom/bytedance/ies/argus/repository/MonitorConfig;", "setMonitorConfig", "(Lcom/bytedance/ies/argus/repository/MonitorConfig;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class SecuritySettingConfigModel extends BaseStrategyConfig {
    private JSBAuthStrategySetting jsbAuthStrategySettingConfig = new JSBAuthStrategySetting();
    private LynxSignVerifyConfig lynxSignVerifyStrategyConfig = new LynxSignVerifyConfig();
    private MonitorConfig monitorConfig = new MonitorConfig();

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

    public final MonitorConfig getMonitorConfig() {
        return this.monitorConfig;
    }

    public final void setMonitorConfig(MonitorConfig monitorConfig) {
        this.monitorConfig = monitorConfig;
    }
}
