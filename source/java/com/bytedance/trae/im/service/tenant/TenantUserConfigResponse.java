package com.bytedance.trae.im.service.tenant;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TenantUserConfigModels.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÂ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;", "", "rawConfigInfo", "Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;", "rawSecurityRules", "", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;", "mcpWhitelistConfig", "Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;", "<init>", "(Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;Ljava/util/List;Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;)V", "getMcpWhitelistConfig", "()Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;", "configInfo", "getConfigInfo", "()Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;", "securityRules", "getSecurityRules", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class TenantUserConfigResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TenantUserConfigResponse EMPTY = new TenantUserConfigResponse(TenantUserConfig.INSTANCE.getEMPTY(), CollectionsKt.emptyList(), null);

    @SerializedName("mcp_whitelist_config")
    private final McpWhitelistConfigInfo mcpWhitelistConfig;

    @SerializedName("config_info")
    private final TenantUserConfig rawConfigInfo;

    @SerializedName("security_rules")
    private final List<ContentSecurityRule> rawSecurityRules;

    public TenantUserConfigResponse() {
        this(null, null, null, 7, null);
    }

    /* renamed from: component1, reason: from getter */
    private final TenantUserConfig getRawConfigInfo() {
        return this.rawConfigInfo;
    }

    private final List<ContentSecurityRule> component2() {
        return this.rawSecurityRules;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TenantUserConfigResponse copy$default(TenantUserConfigResponse tenantUserConfigResponse, TenantUserConfig tenantUserConfig, List list, McpWhitelistConfigInfo mcpWhitelistConfigInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            tenantUserConfig = tenantUserConfigResponse.rawConfigInfo;
        }
        if ((i & 2) != 0) {
            list = tenantUserConfigResponse.rawSecurityRules;
        }
        if ((i & 4) != 0) {
            mcpWhitelistConfigInfo = tenantUserConfigResponse.mcpWhitelistConfig;
        }
        return tenantUserConfigResponse.copy(tenantUserConfig, list, mcpWhitelistConfigInfo);
    }

    /* renamed from: component3, reason: from getter */
    public final McpWhitelistConfigInfo getMcpWhitelistConfig() {
        return this.mcpWhitelistConfig;
    }

    public final TenantUserConfigResponse copy(TenantUserConfig rawConfigInfo, List<ContentSecurityRule> rawSecurityRules, McpWhitelistConfigInfo mcpWhitelistConfig) {
        return new TenantUserConfigResponse(rawConfigInfo, rawSecurityRules, mcpWhitelistConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TenantUserConfigResponse)) {
            return false;
        }
        TenantUserConfigResponse tenantUserConfigResponse = (TenantUserConfigResponse) other;
        return Intrinsics.areEqual(this.rawConfigInfo, tenantUserConfigResponse.rawConfigInfo) && Intrinsics.areEqual(this.rawSecurityRules, tenantUserConfigResponse.rawSecurityRules) && Intrinsics.areEqual(this.mcpWhitelistConfig, tenantUserConfigResponse.mcpWhitelistConfig);
    }

    public int hashCode() {
        TenantUserConfig tenantUserConfig = this.rawConfigInfo;
        int hashCode = (tenantUserConfig == null ? 0 : tenantUserConfig.hashCode()) * 31;
        List<ContentSecurityRule> list = this.rawSecurityRules;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        McpWhitelistConfigInfo mcpWhitelistConfigInfo = this.mcpWhitelistConfig;
        return hashCode2 + (mcpWhitelistConfigInfo != null ? mcpWhitelistConfigInfo.hashCode() : 0);
    }

    public String toString() {
        return "TenantUserConfigResponse(rawConfigInfo=" + this.rawConfigInfo + ", rawSecurityRules=" + this.rawSecurityRules + ", mcpWhitelistConfig=" + this.mcpWhitelistConfig + ')';
    }

    public TenantUserConfigResponse(TenantUserConfig tenantUserConfig, List<ContentSecurityRule> list, McpWhitelistConfigInfo mcpWhitelistConfigInfo) {
        this.rawConfigInfo = tenantUserConfig;
        this.rawSecurityRules = list;
        this.mcpWhitelistConfig = mcpWhitelistConfigInfo;
    }

    public /* synthetic */ TenantUserConfigResponse(TenantUserConfig tenantUserConfig, List list, McpWhitelistConfigInfo mcpWhitelistConfigInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tenantUserConfig, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : mcpWhitelistConfigInfo);
    }

    public final McpWhitelistConfigInfo getMcpWhitelistConfig() {
        return this.mcpWhitelistConfig;
    }

    public final TenantUserConfig getConfigInfo() {
        TenantUserConfig tenantUserConfig = this.rawConfigInfo;
        return tenantUserConfig == null ? TenantUserConfig.INSTANCE.getEMPTY() : tenantUserConfig;
    }

    public final List<ContentSecurityRule> getSecurityRules() {
        List<ContentSecurityRule> list = this.rawSecurityRules;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* compiled from: TenantUserConfigModels.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;", "", "<init>", "()V", "EMPTY", "Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;", "getEMPTY", "()Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TenantUserConfigResponse getEMPTY() {
            return TenantUserConfigResponse.EMPTY;
        }
    }
}
