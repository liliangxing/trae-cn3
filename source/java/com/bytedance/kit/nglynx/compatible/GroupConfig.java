package com.bytedance.kit.nglynx.compatible;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GroupConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/kit/nglynx/compatible/GroupConfig;", "", "version", "", "cardConfigs", "", "Lcom/bytedance/kit/nglynx/compatible/CardConfig;", "(Ljava/lang/String;Ljava/util/Map;)V", "getCardConfigs", "()Ljava/util/Map;", "getVersion", "()Ljava/lang/String;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class GroupConfig {
    private final Map<String, CardConfig> cardConfigs;
    private final String version;

    public GroupConfig(String version, Map<String, CardConfig> cardConfigs) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(cardConfigs, "cardConfigs");
        this.version = version;
        this.cardConfigs = cardConfigs;
    }

    public final Map<String, CardConfig> getCardConfigs() {
        return this.cardConfigs;
    }

    public final String getVersion() {
        return this.version;
    }
}
