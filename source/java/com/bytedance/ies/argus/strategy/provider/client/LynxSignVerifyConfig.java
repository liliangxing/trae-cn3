package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.strategy.provider.BaseStrategyConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LynxSignVerifyStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/LynxSignVerifyConfig;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyConfig;", "verifyMode", "", "disableGlobalPkSign", "", "urlDegradeList", "", "", "enableTsVerify", "blockTimestamp", "", "highRiskSceneList", "highRiskUrlDegradeList", "(ILjava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;)V", "getBlockTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDisableGlobalPkSign", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableTsVerify", "getHighRiskSceneList", "()Ljava/util/List;", "getHighRiskUrlDegradeList", "getUrlDegradeList", "getVerifyMode", "()I", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class LynxSignVerifyConfig extends BaseStrategyConfig {

    @SerializedName("block_timestamp")
    private final Long blockTimestamp;

    @SerializedName("disable_global_pk_sign")
    private final Boolean disableGlobalPkSign;

    @SerializedName("enable_ts_verify")
    private final Boolean enableTsVerify;

    @SerializedName("high_risk_scene_list")
    private final List<String> highRiskSceneList;

    @SerializedName("high_risk_url_degrade_list")
    private final List<String> highRiskUrlDegradeList;

    @SerializedName("url_degrade_list")
    private final List<String> urlDegradeList;

    @SerializedName("sign_verify_mode")
    private final int verifyMode;

    public LynxSignVerifyConfig() {
        this(0, null, null, null, null, null, null, 127, null);
    }

    public final int getVerifyMode() {
        return this.verifyMode;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LynxSignVerifyConfig(int i, Boolean bool, List list, Boolean bool2, Long l, List list2, List list3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) == 0 ? i : 0, (i2 & 2) != 0 ? r1 : bool, (i2 & 4) != 0 ? null : list, (i2 & 8) == 0 ? bool2 : false, (i2 & 16) != 0 ? null : l, (i2 & 32) != 0 ? null : list2, (i2 & 64) != 0 ? null : list3);
    }

    public final Boolean getDisableGlobalPkSign() {
        return this.disableGlobalPkSign;
    }

    public final List<String> getUrlDegradeList() {
        return this.urlDegradeList;
    }

    public final Boolean getEnableTsVerify() {
        return this.enableTsVerify;
    }

    public final Long getBlockTimestamp() {
        return this.blockTimestamp;
    }

    public final List<String> getHighRiskSceneList() {
        return this.highRiskSceneList;
    }

    public final List<String> getHighRiskUrlDegradeList() {
        return this.highRiskUrlDegradeList;
    }

    public LynxSignVerifyConfig(int i, Boolean bool, List<String> list, Boolean bool2, Long l, List<String> list2, List<String> list3) {
        this.verifyMode = i;
        this.disableGlobalPkSign = bool;
        this.urlDegradeList = list;
        this.enableTsVerify = bool2;
        this.blockTimestamp = l;
        this.highRiskSceneList = list2;
        this.highRiskUrlDegradeList = list3;
    }
}
