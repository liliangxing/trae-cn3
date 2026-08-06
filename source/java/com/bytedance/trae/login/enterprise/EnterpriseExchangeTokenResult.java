package com.bytedance.trae.login.enterprise;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthModels.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;", "", "token", "", "tokenExpireAt", "", "refreshToken", "refreshExpireAt", "tokenExpireDuration", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getToken", "()Ljava/lang/String;", "getTokenExpireAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRefreshToken", "getRefreshExpireAt", "getTokenExpireDuration", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnterpriseExchangeTokenResult {

    @SerializedName("RefreshExpireAt")
    private final Long refreshExpireAt;

    @SerializedName("RefreshToken")
    private final String refreshToken;

    @SerializedName("Token")
    private final String token;

    @SerializedName("TokenExpireAt")
    private final Long tokenExpireAt;

    @SerializedName("TokenExpireDuration")
    private final Long tokenExpireDuration;

    public EnterpriseExchangeTokenResult() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ EnterpriseExchangeTokenResult copy$default(EnterpriseExchangeTokenResult enterpriseExchangeTokenResult, String str, Long l, String str2, Long l2, Long l3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = enterpriseExchangeTokenResult.token;
        }
        if ((i & 2) != 0) {
            l = enterpriseExchangeTokenResult.tokenExpireAt;
        }
        Long l4 = l;
        if ((i & 4) != 0) {
            str2 = enterpriseExchangeTokenResult.refreshToken;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            l2 = enterpriseExchangeTokenResult.refreshExpireAt;
        }
        Long l5 = l2;
        if ((i & 16) != 0) {
            l3 = enterpriseExchangeTokenResult.tokenExpireDuration;
        }
        return enterpriseExchangeTokenResult.copy(str, l4, str3, l5, l3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getTokenExpireAt() {
        return this.tokenExpireAt;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getRefreshExpireAt() {
        return this.refreshExpireAt;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getTokenExpireDuration() {
        return this.tokenExpireDuration;
    }

    public final EnterpriseExchangeTokenResult copy(String token, Long tokenExpireAt, String refreshToken, Long refreshExpireAt, Long tokenExpireDuration) {
        return new EnterpriseExchangeTokenResult(token, tokenExpireAt, refreshToken, refreshExpireAt, tokenExpireDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterpriseExchangeTokenResult)) {
            return false;
        }
        EnterpriseExchangeTokenResult enterpriseExchangeTokenResult = (EnterpriseExchangeTokenResult) other;
        return Intrinsics.areEqual(this.token, enterpriseExchangeTokenResult.token) && Intrinsics.areEqual(this.tokenExpireAt, enterpriseExchangeTokenResult.tokenExpireAt) && Intrinsics.areEqual(this.refreshToken, enterpriseExchangeTokenResult.refreshToken) && Intrinsics.areEqual(this.refreshExpireAt, enterpriseExchangeTokenResult.refreshExpireAt) && Intrinsics.areEqual(this.tokenExpireDuration, enterpriseExchangeTokenResult.tokenExpireDuration);
    }

    public int hashCode() {
        String str = this.token;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.tokenExpireAt;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.refreshToken;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l2 = this.refreshExpireAt;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.tokenExpireDuration;
        return hashCode4 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        return "EnterpriseExchangeTokenResult(token=" + this.token + ", tokenExpireAt=" + this.tokenExpireAt + ", refreshToken=" + this.refreshToken + ", refreshExpireAt=" + this.refreshExpireAt + ", tokenExpireDuration=" + this.tokenExpireDuration + ')';
    }

    public EnterpriseExchangeTokenResult(String str, Long l, String str2, Long l2, Long l3) {
        this.token = str;
        this.tokenExpireAt = l;
        this.refreshToken = str2;
        this.refreshExpireAt = l2;
        this.tokenExpireDuration = l3;
    }

    public /* synthetic */ EnterpriseExchangeTokenResult(String str, Long l, String str2, Long l2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : l3);
    }

    public final String getToken() {
        return this.token;
    }

    public final Long getTokenExpireAt() {
        return this.tokenExpireAt;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final Long getRefreshExpireAt() {
        return this.refreshExpireAt;
    }

    public final Long getTokenExpireDuration() {
        return this.tokenExpireDuration;
    }
}
