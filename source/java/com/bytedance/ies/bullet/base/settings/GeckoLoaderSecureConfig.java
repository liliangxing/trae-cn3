package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: SecuritySettingConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/GeckoLoaderSecureConfig;", "", "()V", "geckoLoaderSecureMode", "", "getGeckoLoaderSecureMode", "()I", "setGeckoLoaderSecureMode", "(I)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class GeckoLoaderSecureConfig {

    @SerializedName("gecko_loader_secure_mode")
    private int geckoLoaderSecureMode;

    public final int getGeckoLoaderSecureMode() {
        return this.geckoLoaderSecureMode;
    }

    public final void setGeckoLoaderSecureMode(int i) {
        this.geckoLoaderSecureMode = i;
    }
}
