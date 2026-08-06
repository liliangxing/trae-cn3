package com.bytedance.trae.im.service.tenant;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TenantUserConfigModels.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÂ\u0003J'\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;", "", "repoId", "", "rawRepoUrls", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getRepoId", "()Ljava/lang/String;", "repoUrls", "getRepoUrls", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class TenantUserConfigBlacklistRepo {

    @SerializedName("repo_urls")
    private final List<String> rawRepoUrls;

    @SerializedName("repo_id")
    private final String repoId;

    /* JADX WARN: Multi-variable type inference failed */
    public TenantUserConfigBlacklistRepo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final List<String> component2() {
        return this.rawRepoUrls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TenantUserConfigBlacklistRepo copy$default(TenantUserConfigBlacklistRepo tenantUserConfigBlacklistRepo, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tenantUserConfigBlacklistRepo.repoId;
        }
        if ((i & 2) != 0) {
            list = tenantUserConfigBlacklistRepo.rawRepoUrls;
        }
        return tenantUserConfigBlacklistRepo.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRepoId() {
        return this.repoId;
    }

    public final TenantUserConfigBlacklistRepo copy(String repoId, List<String> rawRepoUrls) {
        return new TenantUserConfigBlacklistRepo(repoId, rawRepoUrls);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TenantUserConfigBlacklistRepo)) {
            return false;
        }
        TenantUserConfigBlacklistRepo tenantUserConfigBlacklistRepo = (TenantUserConfigBlacklistRepo) other;
        return Intrinsics.areEqual(this.repoId, tenantUserConfigBlacklistRepo.repoId) && Intrinsics.areEqual(this.rawRepoUrls, tenantUserConfigBlacklistRepo.rawRepoUrls);
    }

    public int hashCode() {
        String str = this.repoId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.rawRepoUrls;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "TenantUserConfigBlacklistRepo(repoId=" + this.repoId + ", rawRepoUrls=" + this.rawRepoUrls + ')';
    }

    public TenantUserConfigBlacklistRepo(String str, List<String> list) {
        this.repoId = str;
        this.rawRepoUrls = list;
    }

    public /* synthetic */ TenantUserConfigBlacklistRepo(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
    }

    public final String getRepoId() {
        return this.repoId;
    }

    public final List<String> getRepoUrls() {
        List<String> list = this.rawRepoUrls;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
