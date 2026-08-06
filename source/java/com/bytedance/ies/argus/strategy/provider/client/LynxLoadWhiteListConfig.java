package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.strategy.provider.BaseStrategyConfig;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LynxLoadWhiteListStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/LynxLoadWhiteListConfig;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyConfig;", "feLimitLoadSourceConfig", "", "", "Lcom/bytedance/ies/argus/strategy/provider/client/FeLimitLoadSourceInfo;", "(Ljava/util/Map;)V", "getFeLimitLoadSourceConfig", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class LynxLoadWhiteListConfig extends BaseStrategyConfig {

    @SerializedName("fe_limit_load_source")
    private final Map<String, FeLimitLoadSourceInfo> feLimitLoadSourceConfig;

    /* JADX WARN: Multi-variable type inference failed */
    public LynxLoadWhiteListConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ LynxLoadWhiteListConfig(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map);
    }

    public final Map<String, FeLimitLoadSourceInfo> getFeLimitLoadSourceConfig() {
        return this.feLimitLoadSourceConfig;
    }

    public LynxLoadWhiteListConfig(Map<String, FeLimitLoadSourceInfo> map) {
        this.feLimitLoadSourceConfig = map;
    }
}
