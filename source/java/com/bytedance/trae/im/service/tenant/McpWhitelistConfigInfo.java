package com.bytedance.trae.im.service.tenant;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TenantUserConfigModels.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÂ\u0003J%\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;", "", "globalEnable", "", "rawWhitelists", "", "Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;", "<init>", "(ZLjava/util/List;)V", "getGlobalEnable", "()Z", "whitelists", "getWhitelists", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class McpWhitelistConfigInfo {

    @SerializedName("global_enable")
    private final boolean globalEnable;

    @SerializedName("whitelists")
    private final List<McpWhitelistItem> rawWhitelists;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public McpWhitelistConfigInfo() {
        this(false, r0, 3, r0);
        List list = null;
    }

    private final List<McpWhitelistItem> component2() {
        return this.rawWhitelists;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ McpWhitelistConfigInfo copy$default(McpWhitelistConfigInfo mcpWhitelistConfigInfo, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = mcpWhitelistConfigInfo.globalEnable;
        }
        if ((i & 2) != 0) {
            list = mcpWhitelistConfigInfo.rawWhitelists;
        }
        return mcpWhitelistConfigInfo.copy(z, list);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getGlobalEnable() {
        return this.globalEnable;
    }

    public final McpWhitelistConfigInfo copy(boolean globalEnable, List<McpWhitelistItem> rawWhitelists) {
        return new McpWhitelistConfigInfo(globalEnable, rawWhitelists);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof McpWhitelistConfigInfo)) {
            return false;
        }
        McpWhitelistConfigInfo mcpWhitelistConfigInfo = (McpWhitelistConfigInfo) other;
        return this.globalEnable == mcpWhitelistConfigInfo.globalEnable && Intrinsics.areEqual(this.rawWhitelists, mcpWhitelistConfigInfo.rawWhitelists);
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.globalEnable) * 31;
        List<McpWhitelistItem> list = this.rawWhitelists;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "McpWhitelistConfigInfo(globalEnable=" + this.globalEnable + ", rawWhitelists=" + this.rawWhitelists + ')';
    }

    public McpWhitelistConfigInfo(boolean z, List<McpWhitelistItem> list) {
        this.globalEnable = z;
        this.rawWhitelists = list;
    }

    public /* synthetic */ McpWhitelistConfigInfo(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : list);
    }

    public final boolean getGlobalEnable() {
        return this.globalEnable;
    }

    public final List<McpWhitelistItem> getWhitelists() {
        List<McpWhitelistItem> list = this.rawWhitelists;
        return list == null ? CollectionsKt.emptyList() : list;
    }
}
