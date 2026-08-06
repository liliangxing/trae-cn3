package com.bytedance.trae.login.enterprise;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthModels.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseGetRefreshTokenResult;", "", "refreshToken", "", "refreshExpireAt", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "getRefreshToken", "()Ljava/lang/String;", "getRefreshExpireAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/trae/login/enterprise/EnterpriseGetRefreshTokenResult;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnterpriseGetRefreshTokenResult {

    @SerializedName("RefreshExpireAt")
    private final Long refreshExpireAt;

    @SerializedName("RefreshToken")
    private final String refreshToken;

    /* JADX WARN: Multi-variable type inference failed */
    public EnterpriseGetRefreshTokenResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ EnterpriseGetRefreshTokenResult copy$default(EnterpriseGetRefreshTokenResult enterpriseGetRefreshTokenResult, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = enterpriseGetRefreshTokenResult.refreshToken;
        }
        if ((i & 2) != 0) {
            l = enterpriseGetRefreshTokenResult.refreshExpireAt;
        }
        return enterpriseGetRefreshTokenResult.copy(str, l);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getRefreshExpireAt() {
        return this.refreshExpireAt;
    }

    public final EnterpriseGetRefreshTokenResult copy(String refreshToken, Long refreshExpireAt) {
        return new EnterpriseGetRefreshTokenResult(refreshToken, refreshExpireAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterpriseGetRefreshTokenResult)) {
            return false;
        }
        EnterpriseGetRefreshTokenResult enterpriseGetRefreshTokenResult = (EnterpriseGetRefreshTokenResult) other;
        return Intrinsics.areEqual(this.refreshToken, enterpriseGetRefreshTokenResult.refreshToken) && Intrinsics.areEqual(this.refreshExpireAt, enterpriseGetRefreshTokenResult.refreshExpireAt);
    }

    public int hashCode() {
        String str = this.refreshToken;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.refreshExpireAt;
        return hashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "EnterpriseGetRefreshTokenResult(refreshToken=" + this.refreshToken + ", refreshExpireAt=" + this.refreshExpireAt + ')';
    }

    public EnterpriseGetRefreshTokenResult(String str, Long l) {
        this.refreshToken = str;
        this.refreshExpireAt = l;
    }

    public /* synthetic */ EnterpriseGetRefreshTokenResult(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l);
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final Long getRefreshExpireAt() {
        return this.refreshExpireAt;
    }
}
