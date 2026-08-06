package com.bytedance.salamander.anniex;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorCoreSLMonitorSetupConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/salamander/anniex/SLMonitorSetupConfig;", "", "()V", "settingsConfig", "Lcom/bytedance/salamander/anniex/SLHybridSettingsConfig;", "getSettingsConfig", "()Lcom/bytedance/salamander/anniex/SLHybridSettingsConfig;", "setSettingsConfig", "(Lcom/bytedance/salamander/anniex/SLHybridSettingsConfig;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class SLMonitorSetupConfig {
    private SLHybridSettingsConfig settingsConfig = new SLHybridSettingsConfig();

    public SLHybridSettingsConfig getSettingsConfig() {
        return this.settingsConfig;
    }

    public void setSettingsConfig(SLHybridSettingsConfig sLHybridSettingsConfig) {
        Intrinsics.checkNotNullParameter(sLHybridSettingsConfig, "<set-?>");
        this.settingsConfig = sLHybridSettingsConfig;
    }
}
