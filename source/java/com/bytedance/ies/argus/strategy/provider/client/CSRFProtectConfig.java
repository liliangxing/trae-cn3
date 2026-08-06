package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.strategy.provider.BaseStrategyConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CSRFProtectStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/CSRFProtectConfig;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyConfig;", "enableRLIntercept", "", "enableForestIntercept", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnableForestIntercept", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableRLIntercept", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class CSRFProtectConfig extends BaseStrategyConfig {

    @SerializedName("enable_forest_intercept")
    private final Boolean enableForestIntercept;

    @SerializedName("enable_rl_intercept")
    private final Boolean enableRLIntercept;

    /* JADX WARN: Multi-variable type inference failed */
    public CSRFProtectConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ CSRFProtectConfig(Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : bool, (i & 2) != 0 ? false : bool2);
    }

    public final Boolean getEnableRLIntercept() {
        return this.enableRLIntercept;
    }

    public final Boolean getEnableForestIntercept() {
        return this.enableForestIntercept;
    }

    public CSRFProtectConfig(Boolean bool, Boolean bool2) {
        this.enableRLIntercept = bool;
        this.enableForestIntercept = bool2;
    }
}
