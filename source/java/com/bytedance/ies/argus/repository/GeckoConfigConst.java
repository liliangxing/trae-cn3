package com.bytedance.ies.argus.repository;

import kotlin.Metadata;

/* compiled from: GeckoConfigFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/repository/GeckoConfigConst;", "", "()V", "CONTAINER_CONFIG_CDN_URL", "", "CONTAINER_CONFIG_CHANNEL", "DEFAULT_BUNDLE_NAME", "GLOBAL_CONFIG_CDN_URL", "GLOBAL_CONFIG_CHANNEL", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class GeckoConfigConst {
    public static final String CONTAINER_CONFIG_CDN_URL = "https://lf-normal-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/argus/security/policy/container_config/gecko.config.json";
    public static final String CONTAINER_CONFIG_CHANNEL = "container_config";
    public static final String DEFAULT_BUNDLE_NAME = "gecko.config.json";
    public static final String GLOBAL_CONFIG_CDN_URL = "https://lf-normal-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/argus/security/policy/global_config/gecko.config.json";
    public static final String GLOBAL_CONFIG_CHANNEL = "global_config";
    public static final GeckoConfigConst INSTANCE = new GeckoConfigConst();

    private GeckoConfigConst() {
    }
}
