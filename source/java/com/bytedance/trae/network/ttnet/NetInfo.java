package com.bytedance.trae.network.ttnet;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TTNetExt.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017J`\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0004\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/bytedance/trae/network/ttnet/NetInfo;", "", "networkType", "", "isRoaming", "", "simCountry", "netCountry", "simOperatorName", "netOperatorName", "airplaneMode", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getNetworkType", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSimCountry", "getNetCountry", "getSimOperatorName", "getNetOperatorName", "getAirplaneMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/trae/network/ttnet/NetInfo;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NetInfo {
    private final Integer airplaneMode;
    private final Boolean isRoaming;
    private final String netCountry;
    private final String netOperatorName;
    private final String networkType;
    private final String simCountry;
    private final String simOperatorName;

    public static /* synthetic */ NetInfo copy$default(NetInfo netInfo, String str, Boolean bool, String str2, String str3, String str4, String str5, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = netInfo.networkType;
        }
        if ((i & 2) != 0) {
            bool = netInfo.isRoaming;
        }
        Boolean bool2 = bool;
        if ((i & 4) != 0) {
            str2 = netInfo.simCountry;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = netInfo.netCountry;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = netInfo.simOperatorName;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = netInfo.netOperatorName;
        }
        String str9 = str5;
        if ((i & 64) != 0) {
            num = netInfo.airplaneMode;
        }
        return netInfo.copy(str, bool2, str6, str7, str8, str9, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNetworkType() {
        return this.networkType;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getIsRoaming() {
        return this.isRoaming;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSimCountry() {
        return this.simCountry;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNetCountry() {
        return this.netCountry;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSimOperatorName() {
        return this.simOperatorName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getNetOperatorName() {
        return this.netOperatorName;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getAirplaneMode() {
        return this.airplaneMode;
    }

    public final NetInfo copy(String networkType, Boolean isRoaming, String simCountry, String netCountry, String simOperatorName, String netOperatorName, Integer airplaneMode) {
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        return new NetInfo(networkType, isRoaming, simCountry, netCountry, simOperatorName, netOperatorName, airplaneMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetInfo)) {
            return false;
        }
        NetInfo netInfo = (NetInfo) other;
        return Intrinsics.areEqual(this.networkType, netInfo.networkType) && Intrinsics.areEqual(this.isRoaming, netInfo.isRoaming) && Intrinsics.areEqual(this.simCountry, netInfo.simCountry) && Intrinsics.areEqual(this.netCountry, netInfo.netCountry) && Intrinsics.areEqual(this.simOperatorName, netInfo.simOperatorName) && Intrinsics.areEqual(this.netOperatorName, netInfo.netOperatorName) && Intrinsics.areEqual(this.airplaneMode, netInfo.airplaneMode);
    }

    public int hashCode() {
        int hashCode = this.networkType.hashCode() * 31;
        Boolean bool = this.isRoaming;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.simCountry;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.netCountry;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.simOperatorName;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.netOperatorName;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.airplaneMode;
        return hashCode6 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "NetInfo(networkType=" + this.networkType + ", isRoaming=" + this.isRoaming + ", simCountry=" + this.simCountry + ", netCountry=" + this.netCountry + ", simOperatorName=" + this.simOperatorName + ", netOperatorName=" + this.netOperatorName + ", airplaneMode=" + this.airplaneMode + ')';
    }

    public NetInfo(String networkType, Boolean bool, String str, String str2, String str3, String str4, Integer num) {
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        this.networkType = networkType;
        this.isRoaming = bool;
        this.simCountry = str;
        this.netCountry = str2;
        this.simOperatorName = str3;
        this.netOperatorName = str4;
        this.airplaneMode = num;
    }

    public final String getNetworkType() {
        return this.networkType;
    }

    public final Boolean isRoaming() {
        return this.isRoaming;
    }

    public final String getSimCountry() {
        return this.simCountry;
    }

    public final String getNetCountry() {
        return this.netCountry;
    }

    public final String getSimOperatorName() {
        return this.simOperatorName;
    }

    public final String getNetOperatorName() {
        return this.netOperatorName;
    }

    public final Integer getAirplaneMode() {
        return this.airplaneMode;
    }
}
