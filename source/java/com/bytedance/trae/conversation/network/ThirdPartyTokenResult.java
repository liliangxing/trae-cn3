package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThirdPartyTokenRepository.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/network/ThirdPartyTokenResult;", "", "type", "", OnekeyLoginConstants.CT_KEY_ACCESS_TOKEN, "accessExpireAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getAccessToken", "getAccessExpireAt", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ThirdPartyTokenResult {

    @SerializedName("AccessExpireAt")
    private final String accessExpireAt;

    @SerializedName("AccessToken")
    private final String accessToken;

    @SerializedName("Type")
    private final String type;

    public ThirdPartyTokenResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ThirdPartyTokenResult copy$default(ThirdPartyTokenResult thirdPartyTokenResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = thirdPartyTokenResult.type;
        }
        if ((i & 2) != 0) {
            str2 = thirdPartyTokenResult.accessToken;
        }
        if ((i & 4) != 0) {
            str3 = thirdPartyTokenResult.accessExpireAt;
        }
        return thirdPartyTokenResult.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAccessExpireAt() {
        return this.accessExpireAt;
    }

    public final ThirdPartyTokenResult copy(String type, String accessToken, String accessExpireAt) {
        return new ThirdPartyTokenResult(type, accessToken, accessExpireAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThirdPartyTokenResult)) {
            return false;
        }
        ThirdPartyTokenResult thirdPartyTokenResult = (ThirdPartyTokenResult) other;
        return Intrinsics.areEqual(this.type, thirdPartyTokenResult.type) && Intrinsics.areEqual(this.accessToken, thirdPartyTokenResult.accessToken) && Intrinsics.areEqual(this.accessExpireAt, thirdPartyTokenResult.accessExpireAt);
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.accessToken;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.accessExpireAt;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ThirdPartyTokenResult(type=" + this.type + ", accessToken=" + this.accessToken + ", accessExpireAt=" + this.accessExpireAt + ')';
    }

    public ThirdPartyTokenResult(String str, String str2, String str3) {
        this.type = str;
        this.accessToken = str2;
        this.accessExpireAt = str3;
    }

    public /* synthetic */ ThirdPartyTokenResult(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getType() {
        return this.type;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final String getAccessExpireAt() {
        return this.accessExpireAt;
    }
}
