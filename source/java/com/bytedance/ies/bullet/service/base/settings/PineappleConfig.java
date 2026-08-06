package com.bytedance.ies.bullet.service.base.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: PineappleConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/settings/PineappleConfig;", "", "()V", "disableCodeCache", "", "getDisableCodeCache", "()Z", "setDisableCodeCache", "(Z)V", "disablePrefetch", "getDisablePrefetch", "setDisablePrefetch", "disablePreload", "getDisablePreload", "setDisablePreload", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PineappleConfig {

    @SerializedName("pineapple_disable_code_cache")
    private boolean disableCodeCache;

    @SerializedName("pineapple_disable_prefetch")
    private boolean disablePrefetch;

    @SerializedName("pineapple_disable_preload")
    private boolean disablePreload;

    public final boolean getDisablePreload() {
        return this.disablePreload;
    }

    public final void setDisablePreload(boolean z) {
        this.disablePreload = z;
    }

    public final boolean getDisablePrefetch() {
        return this.disablePrefetch;
    }

    public final void setDisablePrefetch(boolean z) {
        this.disablePrefetch = z;
    }

    public final boolean getDisableCodeCache() {
        return this.disableCodeCache;
    }

    public final void setDisableCodeCache(boolean z) {
        this.disableCodeCache = z;
    }
}
