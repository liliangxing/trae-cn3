package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.forest.model.PreloadConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BridgeCallRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003JN\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/TASMEncryptInfo;", "", "type", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/TASMVerifyType;", "totalLength", "", "appId", "", "signSuitesNumber", "signSuites", "", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/SignSuiteV2;", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/TASMVerifyType;ILjava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getAppId", "()Ljava/lang/String;", "getSignSuites", "()Ljava/util/List;", "getSignSuitesNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalLength", "()I", "getType", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/TASMVerifyType;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/TASMVerifyType;ILjava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/bytedance/sdk/xbridge/cn/auth/bean/TASMEncryptInfo;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TASMEncryptInfo {
    private final String appId;
    private final List<SignSuiteV2> signSuites;
    private final Integer signSuitesNumber;
    private final int totalLength;
    private final TASMVerifyType type;

    public static /* synthetic */ TASMEncryptInfo copy$default(TASMEncryptInfo tASMEncryptInfo, TASMVerifyType tASMVerifyType, int i, String str, Integer num, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            tASMVerifyType = tASMEncryptInfo.type;
        }
        if ((i2 & 2) != 0) {
            i = tASMEncryptInfo.totalLength;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str = tASMEncryptInfo.appId;
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            num = tASMEncryptInfo.signSuitesNumber;
        }
        Integer num2 = num;
        if ((i2 & 16) != 0) {
            list = tASMEncryptInfo.signSuites;
        }
        return tASMEncryptInfo.copy(tASMVerifyType, i3, str2, num2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final TASMVerifyType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTotalLength() {
        return this.totalLength;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getSignSuitesNumber() {
        return this.signSuitesNumber;
    }

    public final List<SignSuiteV2> component5() {
        return this.signSuites;
    }

    public final TASMEncryptInfo copy(TASMVerifyType type, int totalLength, String appId, Integer signSuitesNumber, List<SignSuiteV2> signSuites) {
        return new TASMEncryptInfo(type, totalLength, appId, signSuitesNumber, signSuites);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TASMEncryptInfo)) {
            return false;
        }
        TASMEncryptInfo tASMEncryptInfo = (TASMEncryptInfo) other;
        return this.type == tASMEncryptInfo.type && this.totalLength == tASMEncryptInfo.totalLength && Intrinsics.areEqual(this.appId, tASMEncryptInfo.appId) && Intrinsics.areEqual(this.signSuitesNumber, tASMEncryptInfo.signSuitesNumber) && Intrinsics.areEqual(this.signSuites, tASMEncryptInfo.signSuites);
    }

    public int hashCode() {
        TASMVerifyType tASMVerifyType = this.type;
        int hashCode = (((tASMVerifyType == null ? 0 : tASMVerifyType.hashCode()) * 31) + Integer.hashCode(this.totalLength)) * 31;
        String str = this.appId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.signSuitesNumber;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        List<SignSuiteV2> list = this.signSuites;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "TASMEncryptInfo(type=" + this.type + ", totalLength=" + this.totalLength + ", appId=" + this.appId + ", signSuitesNumber=" + this.signSuitesNumber + ", signSuites=" + this.signSuites + ')';
    }

    public TASMEncryptInfo(TASMVerifyType tASMVerifyType, int i, String str, Integer num, List<SignSuiteV2> list) {
        this.type = tASMVerifyType;
        this.totalLength = i;
        this.appId = str;
        this.signSuitesNumber = num;
        this.signSuites = list;
    }

    public /* synthetic */ TASMEncryptInfo(TASMVerifyType tASMVerifyType, int i, String str, Integer num, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : tASMVerifyType, i, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? null : list);
    }

    public final TASMVerifyType getType() {
        return this.type;
    }

    public final int getTotalLength() {
        return this.totalLength;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Integer getSignSuitesNumber() {
        return this.signSuitesNumber;
    }

    public final List<SignSuiteV2> getSignSuites() {
        return this.signSuites;
    }
}
