package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountCancelApi.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nHÆ\u0003JS\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nHÇ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001f\u001a\u00020\u0003H×\u0001J\t\u0010 \u001a\u00020\u0006H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;", "", "userType", "", "authType", "valueTicket", "", "oauthPlatforms", "", "platformUserNames", "", "<init>", "(IILjava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "getUserType", "()I", "getAuthType", "getValueTicket", "()Ljava/lang/String;", "getOauthPlatforms", "()Ljava/util/List;", "getPlatformUserNames", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CancelUserCheckData {
    public static final int $stable = 8;

    @SerializedName("authType")
    private final int authType;

    @SerializedName("oauth_platforms")
    private final List<String> oauthPlatforms;

    @SerializedName("platform_user_names")
    private final Map<String, String> platformUserNames;

    @SerializedName("user_type")
    private final int userType;

    @SerializedName("value_ticket")
    private final String valueTicket;

    public CancelUserCheckData() {
        this(0, 0, null, null, null, 31, null);
    }

    public static /* synthetic */ CancelUserCheckData copy$default(CancelUserCheckData cancelUserCheckData, int i, int i2, String str, List list, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = cancelUserCheckData.userType;
        }
        if ((i3 & 2) != 0) {
            i2 = cancelUserCheckData.authType;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = cancelUserCheckData.valueTicket;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            list = cancelUserCheckData.oauthPlatforms;
        }
        List list2 = list;
        if ((i3 & 16) != 0) {
            map = cancelUserCheckData.platformUserNames;
        }
        return cancelUserCheckData.copy(i, i4, str2, list2, map);
    }

    /* renamed from: component1, reason: from getter */
    public final int getUserType() {
        return this.userType;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAuthType() {
        return this.authType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getValueTicket() {
        return this.valueTicket;
    }

    public final List<String> component4() {
        return this.oauthPlatforms;
    }

    public final Map<String, String> component5() {
        return this.platformUserNames;
    }

    public final CancelUserCheckData copy(int userType, int authType, String valueTicket, List<String> oauthPlatforms, Map<String, String> platformUserNames) {
        return new CancelUserCheckData(userType, authType, valueTicket, oauthPlatforms, platformUserNames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CancelUserCheckData)) {
            return false;
        }
        CancelUserCheckData cancelUserCheckData = (CancelUserCheckData) other;
        return this.userType == cancelUserCheckData.userType && this.authType == cancelUserCheckData.authType && Intrinsics.areEqual(this.valueTicket, cancelUserCheckData.valueTicket) && Intrinsics.areEqual(this.oauthPlatforms, cancelUserCheckData.oauthPlatforms) && Intrinsics.areEqual(this.platformUserNames, cancelUserCheckData.platformUserNames);
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.userType) * 31) + Integer.hashCode(this.authType)) * 31;
        String str = this.valueTicket;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.oauthPlatforms;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Map<String, String> map = this.platformUserNames;
        return hashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "CancelUserCheckData(userType=" + this.userType + ", authType=" + this.authType + ", valueTicket=" + this.valueTicket + ", oauthPlatforms=" + this.oauthPlatforms + ", platformUserNames=" + this.platformUserNames + ')';
    }

    public CancelUserCheckData(int i, int i2, String str, List<String> list, Map<String, String> map) {
        this.userType = i;
        this.authType = i2;
        this.valueTicket = str;
        this.oauthPlatforms = list;
        this.platformUserNames = map;
    }

    public /* synthetic */ CancelUserCheckData(int i, int i2, String str, List list, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) == 0 ? i2 : 0, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : list, (i3 & 16) != 0 ? null : map);
    }

    public final int getUserType() {
        return this.userType;
    }

    public final int getAuthType() {
        return this.authType;
    }

    public final String getValueTicket() {
        return this.valueTicket;
    }

    public final List<String> getOauthPlatforms() {
        return this.oauthPlatforms;
    }

    public final Map<String, String> getPlatformUserNames() {
        return this.platformUserNames;
    }
}
