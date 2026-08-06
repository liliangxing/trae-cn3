package com.bytedance.trae.applog.impl;

import com.bytedance.applog.InitConfig;
import com.bytedance.applog.UriConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDTrackerConfigs.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;", "", "<init>", "()V", "uriConfig", "Lcom/bytedance/applog/UriConfig;", "boe", "", "getUriConfig", "configSensitiveApi", "", "config", "Lcom/bytedance/applog/InitConfig;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BDTrackerConfigs {
    public static final BDTrackerConfigs INSTANCE = new BDTrackerConfigs();

    public final void configSensitiveApi(InitConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
    }

    private BDTrackerConfigs() {
    }

    public final UriConfig uriConfig(boolean boe) {
        return getUriConfig(boe);
    }

    private final UriConfig getUriConfig(boolean boe) {
        UriConfig createUriConfig = UriConfig.createUriConfig(0);
        Intrinsics.checkNotNullExpressionValue(createUriConfig, "createUriConfig(...)");
        return createUriConfig;
    }
}
