package com.bytedance.env.api;

import kotlin.Metadata;

/* compiled from: EnvManagerApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/env/api/OnEnvConfigChangeListener;", "", "onEnvConfigChanged", "", "oldConfig", "Lcom/bytedance/env/api/EnvConfig;", "newConfig", "onEnvWindowRemoved", "onGeckoConfigChanged", "Lcom/bytedance/env/api/GeckoConfig;", "env_platform_api_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public interface OnEnvConfigChangeListener {
    void onEnvConfigChanged(EnvConfig oldConfig, EnvConfig newConfig);

    void onEnvWindowRemoved();

    void onGeckoConfigChanged(GeckoConfig oldConfig, GeckoConfig newConfig);
}
