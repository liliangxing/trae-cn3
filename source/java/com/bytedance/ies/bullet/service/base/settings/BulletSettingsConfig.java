package com.bytedance.ies.bullet.service.base.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBulletSettingsService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/settings/BulletSettingsConfig;", "", "appInfo", "Lcom/bytedance/ies/bullet/service/base/settings/AppInfo;", "network", "Lcom/bytedance/ies/bullet/service/base/settings/IBulletSettingsNetwork;", "(Lcom/bytedance/ies/bullet/service/base/settings/AppInfo;Lcom/bytedance/ies/bullet/service/base/settings/IBulletSettingsNetwork;)V", "getAppInfo", "()Lcom/bytedance/ies/bullet/service/base/settings/AppInfo;", "getNetwork", "()Lcom/bytedance/ies/bullet/service/base/settings/IBulletSettingsNetwork;", "settingsUpdateCallbackAsync", "", "getSettingsUpdateCallbackAsync", "()Z", "setSettingsUpdateCallbackAsync", "(Z)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BulletSettingsConfig {
    private final AppInfo appInfo;
    private final IBulletSettingsNetwork network;
    private boolean settingsUpdateCallbackAsync;

    public BulletSettingsConfig(AppInfo appInfo, IBulletSettingsNetwork network) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(network, "network");
        this.appInfo = appInfo;
        this.network = network;
    }

    public final AppInfo getAppInfo() {
        return this.appInfo;
    }

    public final IBulletSettingsNetwork getNetwork() {
        return this.network;
    }

    public final boolean getSettingsUpdateCallbackAsync() {
        return this.settingsUpdateCallbackAsync;
    }

    public final void setSettingsUpdateCallbackAsync(boolean z) {
        this.settingsUpdateCallbackAsync = z;
    }
}
