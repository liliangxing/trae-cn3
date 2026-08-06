package com.bytedance.trae.login.enterprise;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;", "", "tenantId", "", "tenantName", "productType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getTenantId", "()Ljava/lang/String;", "getTenantName", "getProductType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnterpriseTenantInfo {

    @SerializedName("ProductType")
    private final Integer productType;

    @SerializedName("TenantID")
    private final String tenantId;

    @SerializedName("TenantName")
    private final String tenantName;

    public EnterpriseTenantInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ EnterpriseTenantInfo copy$default(EnterpriseTenantInfo enterpriseTenantInfo, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = enterpriseTenantInfo.tenantId;
        }
        if ((i & 2) != 0) {
            str2 = enterpriseTenantInfo.tenantName;
        }
        if ((i & 4) != 0) {
            num = enterpriseTenantInfo.productType;
        }
        return enterpriseTenantInfo.copy(str, str2, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTenantId() {
        return this.tenantId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTenantName() {
        return this.tenantName;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getProductType() {
        return this.productType;
    }

    public final EnterpriseTenantInfo copy(String tenantId, String tenantName, Integer productType) {
        return new EnterpriseTenantInfo(tenantId, tenantName, productType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterpriseTenantInfo)) {
            return false;
        }
        EnterpriseTenantInfo enterpriseTenantInfo = (EnterpriseTenantInfo) other;
        return Intrinsics.areEqual(this.tenantId, enterpriseTenantInfo.tenantId) && Intrinsics.areEqual(this.tenantName, enterpriseTenantInfo.tenantName) && Intrinsics.areEqual(this.productType, enterpriseTenantInfo.productType);
    }

    public int hashCode() {
        String str = this.tenantId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.tenantName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.productType;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "EnterpriseTenantInfo(tenantId=" + this.tenantId + ", tenantName=" + this.tenantName + ", productType=" + this.productType + ')';
    }

    public EnterpriseTenantInfo(String str, String str2, Integer num) {
        this.tenantId = str;
        this.tenantName = str2;
        this.productType = num;
    }

    public /* synthetic */ EnterpriseTenantInfo(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num);
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getTenantName() {
        return this.tenantName;
    }

    public final Integer getProductType() {
        return this.productType;
    }
}
