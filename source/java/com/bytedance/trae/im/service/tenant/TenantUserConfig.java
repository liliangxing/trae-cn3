package com.bytedance.trae.im.service.tenant;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TenantUserConfigModels.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÂ\u0003J'\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\rHÖ\u0001R\u0018\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;", "", "rawBlacklistRepos", "", "Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;", "rawBlacklistCommands", "Lcom/google/gson/JsonElement;", "<init>", "(Ljava/util/List;Lcom/google/gson/JsonElement;)V", "blacklistRepos", "getBlacklistRepos", "()Ljava/util/List;", "blacklistCommands", "", "getBlacklistCommands", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class TenantUserConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TenantUserConfig EMPTY = new TenantUserConfig(CollectionsKt.emptyList(), null);

    @SerializedName("blacklist_commands")
    private final JsonElement rawBlacklistCommands;

    @SerializedName("blacklist_repos")
    private final List<TenantUserConfigBlacklistRepo> rawBlacklistRepos;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TenantUserConfig() {
        this(r0, r0, 3, r0);
        List list = null;
    }

    private final List<TenantUserConfigBlacklistRepo> component1() {
        return this.rawBlacklistRepos;
    }

    /* renamed from: component2, reason: from getter */
    private final JsonElement getRawBlacklistCommands() {
        return this.rawBlacklistCommands;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TenantUserConfig copy$default(TenantUserConfig tenantUserConfig, List list, JsonElement jsonElement, int i, Object obj) {
        if ((i & 1) != 0) {
            list = tenantUserConfig.rawBlacklistRepos;
        }
        if ((i & 2) != 0) {
            jsonElement = tenantUserConfig.rawBlacklistCommands;
        }
        return tenantUserConfig.copy(list, jsonElement);
    }

    public final TenantUserConfig copy(List<TenantUserConfigBlacklistRepo> rawBlacklistRepos, JsonElement rawBlacklistCommands) {
        return new TenantUserConfig(rawBlacklistRepos, rawBlacklistCommands);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TenantUserConfig)) {
            return false;
        }
        TenantUserConfig tenantUserConfig = (TenantUserConfig) other;
        return Intrinsics.areEqual(this.rawBlacklistRepos, tenantUserConfig.rawBlacklistRepos) && Intrinsics.areEqual(this.rawBlacklistCommands, tenantUserConfig.rawBlacklistCommands);
    }

    public int hashCode() {
        List<TenantUserConfigBlacklistRepo> list = this.rawBlacklistRepos;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        JsonElement jsonElement = this.rawBlacklistCommands;
        return hashCode + (jsonElement != null ? jsonElement.hashCode() : 0);
    }

    public String toString() {
        return "TenantUserConfig(rawBlacklistRepos=" + this.rawBlacklistRepos + ", rawBlacklistCommands=" + this.rawBlacklistCommands + ')';
    }

    public TenantUserConfig(List<TenantUserConfigBlacklistRepo> list, JsonElement jsonElement) {
        this.rawBlacklistRepos = list;
        this.rawBlacklistCommands = jsonElement;
    }

    public /* synthetic */ TenantUserConfig(List list, JsonElement jsonElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : jsonElement);
    }

    public final List<TenantUserConfigBlacklistRepo> getBlacklistRepos() {
        List<TenantUserConfigBlacklistRepo> list = this.rawBlacklistRepos;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final List<String> getBlacklistCommands() {
        List<String> stringListFromArrayOrJsonString;
        stringListFromArrayOrJsonString = TenantUserConfigModelsKt.stringListFromArrayOrJsonString(this.rawBlacklistCommands);
        return stringListFromArrayOrJsonString;
    }

    /* compiled from: TenantUserConfigModels.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/TenantUserConfig$Companion;", "", "<init>", "()V", "EMPTY", "Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;", "getEMPTY", "()Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TenantUserConfig getEMPTY() {
            return TenantUserConfig.EMPTY;
        }
    }
}
