package com.bytedance.ies.argus.plugin;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SecLinkPlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/argus/plugin/SecLinkPluginConfig;", "Lcom/bytedance/ies/argus/plugin/BasePluginConfig;", "firstLoadMaxRiskLevel", "", "redirectMaxRiskLevel", "checkScene", "", "firstUseSync", "", "redirectUseSync", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ZZ)V", "getCheckScene", "()Ljava/lang/String;", "getFirstLoadMaxRiskLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFirstUseSync", "()Z", "getRedirectMaxRiskLevel", "getRedirectUseSync", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class SecLinkPluginConfig extends BasePluginConfig {

    @SerializedName("check_scene")
    private final String checkScene;

    @SerializedName("first_load_max_risk_level")
    private final Integer firstLoadMaxRiskLevel;

    @SerializedName("first_use_sync")
    private final boolean firstUseSync;

    @SerializedName("redirect_max_risk_level")
    private final Integer redirectMaxRiskLevel;

    @SerializedName("redirect_use_sync")
    private final boolean redirectUseSync;

    public SecLinkPluginConfig() {
        this(null, null, null, false, false, 31, null);
    }

    public /* synthetic */ SecLinkPluginConfig(Integer num, Integer num2, String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 2 : num, (i & 2) != 0 ? 8 : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
    }

    public final Integer getFirstLoadMaxRiskLevel() {
        return this.firstLoadMaxRiskLevel;
    }

    public final Integer getRedirectMaxRiskLevel() {
        return this.redirectMaxRiskLevel;
    }

    public final String getCheckScene() {
        return this.checkScene;
    }

    public final boolean getFirstUseSync() {
        return this.firstUseSync;
    }

    public final boolean getRedirectUseSync() {
        return this.redirectUseSync;
    }

    public SecLinkPluginConfig(Integer num, Integer num2, String str, boolean z, boolean z2) {
        this.firstLoadMaxRiskLevel = num;
        this.redirectMaxRiskLevel = num2;
        this.checkScene = str;
        this.firstUseSync = z;
        this.redirectUseSync = z2;
    }
}
