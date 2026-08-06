package com.bytedance.ies.argus.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusSettingsConfigModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/argus/bean/ForceHttpsSetting;", "", "enable", "", "enableShareCookieDomainForceHttps", "forceHttpsHostList", "", "", "(ZZLjava/util/List;)V", "getEnable", "()Z", "getEnableShareCookieDomainForceHttps", "getForceHttpsHostList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ForceHttpsSetting {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_share_cookie_domain_force_https")
    private final boolean enableShareCookieDomainForceHttps;

    @SerializedName("extra_force_https_host_list")
    private final List<String> forceHttpsHostList;

    public ForceHttpsSetting() {
        this(false, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ForceHttpsSetting copy$default(ForceHttpsSetting forceHttpsSetting, boolean z, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = forceHttpsSetting.enable;
        }
        if ((i & 2) != 0) {
            z2 = forceHttpsSetting.enableShareCookieDomainForceHttps;
        }
        if ((i & 4) != 0) {
            list = forceHttpsSetting.forceHttpsHostList;
        }
        return forceHttpsSetting.copy(z, z2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEnableShareCookieDomainForceHttps() {
        return this.enableShareCookieDomainForceHttps;
    }

    public final List<String> component3() {
        return this.forceHttpsHostList;
    }

    public final ForceHttpsSetting copy(boolean enable, boolean enableShareCookieDomainForceHttps, List<String> forceHttpsHostList) {
        return new ForceHttpsSetting(enable, enableShareCookieDomainForceHttps, forceHttpsHostList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForceHttpsSetting)) {
            return false;
        }
        ForceHttpsSetting forceHttpsSetting = (ForceHttpsSetting) other;
        return this.enable == forceHttpsSetting.enable && this.enableShareCookieDomainForceHttps == forceHttpsSetting.enableShareCookieDomainForceHttps && Intrinsics.areEqual(this.forceHttpsHostList, forceHttpsSetting.forceHttpsHostList);
    }

    public int hashCode() {
        int hashCode = ((Boolean.hashCode(this.enable) * 31) + Boolean.hashCode(this.enableShareCookieDomainForceHttps)) * 31;
        List<String> list = this.forceHttpsHostList;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "ForceHttpsSetting(enable=" + this.enable + ", enableShareCookieDomainForceHttps=" + this.enableShareCookieDomainForceHttps + ", forceHttpsHostList=" + this.forceHttpsHostList + ')';
    }

    public ForceHttpsSetting(boolean z, boolean z2, List<String> list) {
        this.enable = z;
        this.enableShareCookieDomainForceHttps = z2;
        this.forceHttpsHostList = list;
    }

    public /* synthetic */ ForceHttpsSetting(boolean z, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : list);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableShareCookieDomainForceHttps() {
        return this.enableShareCookieDomainForceHttps;
    }

    public final List<String> getForceHttpsHostList() {
        return this.forceHttpsHostList;
    }
}
