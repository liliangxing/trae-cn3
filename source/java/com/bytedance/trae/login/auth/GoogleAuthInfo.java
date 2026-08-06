package com.bytedance.trae.login.auth;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleAuthHelper.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jc\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006'"}, d2 = {"Lcom/bytedance/trae/login/auth/GoogleAuthInfo;", "", "platform", "", "platformAppId", IGoogleService.ResponseKey.ID_TOKEN, OnekeyLoginConstants.CT_KEY_ACCESS_TOKEN, "accessTokenSecret", "serverAuthCode", "expiresIn", "", "uid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getPlatform", "()Ljava/lang/String;", "getPlatformAppId", "getIdToken", "getAccessToken", "getAccessTokenSecret", "getServerAuthCode", "getExpiresIn", "()J", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GoogleAuthInfo {
    private final String accessToken;
    private final String accessTokenSecret;
    private final long expiresIn;
    private final String idToken;
    private final String platform;
    private final String platformAppId;
    private final String serverAuthCode;
    private final String uid;

    public GoogleAuthInfo() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPlatformAppId() {
        return this.platformAppId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getIdToken() {
        return this.idToken;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAccessTokenSecret() {
        return this.accessTokenSecret;
    }

    /* renamed from: component6, reason: from getter */
    public final String getServerAuthCode() {
        return this.serverAuthCode;
    }

    /* renamed from: component7, reason: from getter */
    public final long getExpiresIn() {
        return this.expiresIn;
    }

    /* renamed from: component8, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    public final GoogleAuthInfo copy(String platform, String platformAppId, String idToken, String accessToken, String accessTokenSecret, String serverAuthCode, long expiresIn, String uid) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(platformAppId, "platformAppId");
        return new GoogleAuthInfo(platform, platformAppId, idToken, accessToken, accessTokenSecret, serverAuthCode, expiresIn, uid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoogleAuthInfo)) {
            return false;
        }
        GoogleAuthInfo googleAuthInfo = (GoogleAuthInfo) other;
        return Intrinsics.areEqual(this.platform, googleAuthInfo.platform) && Intrinsics.areEqual(this.platformAppId, googleAuthInfo.platformAppId) && Intrinsics.areEqual(this.idToken, googleAuthInfo.idToken) && Intrinsics.areEqual(this.accessToken, googleAuthInfo.accessToken) && Intrinsics.areEqual(this.accessTokenSecret, googleAuthInfo.accessTokenSecret) && Intrinsics.areEqual(this.serverAuthCode, googleAuthInfo.serverAuthCode) && this.expiresIn == googleAuthInfo.expiresIn && Intrinsics.areEqual(this.uid, googleAuthInfo.uid);
    }

    public int hashCode() {
        int hashCode = ((this.platform.hashCode() * 31) + this.platformAppId.hashCode()) * 31;
        String str = this.idToken;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.accessToken;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.accessTokenSecret;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.serverAuthCode;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Long.hashCode(this.expiresIn)) * 31;
        String str5 = this.uid;
        return hashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "GoogleAuthInfo(platform=" + this.platform + ", platformAppId=" + this.platformAppId + ", idToken=" + this.idToken + ", accessToken=" + this.accessToken + ", accessTokenSecret=" + this.accessTokenSecret + ", serverAuthCode=" + this.serverAuthCode + ", expiresIn=" + this.expiresIn + ", uid=" + this.uid + ')';
    }

    public GoogleAuthInfo(String platform, String platformAppId, String str, String str2, String str3, String str4, long j, String str5) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(platformAppId, "platformAppId");
        this.platform = platform;
        this.platformAppId = platformAppId;
        this.idToken = str;
        this.accessToken = str2;
        this.accessTokenSecret = str3;
        this.serverAuthCode = str4;
        this.expiresIn = j;
        this.uid = str5;
    }

    public /* synthetic */ GoogleAuthInfo(String str, String str2, String str3, String str4, String str5, String str6, long j, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "google" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? 0L : j, (i & 128) == 0 ? str7 : null);
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getPlatformAppId() {
        return this.platformAppId;
    }

    public final String getIdToken() {
        return this.idToken;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final String getAccessTokenSecret() {
        return this.accessTokenSecret;
    }

    public final String getServerAuthCode() {
        return this.serverAuthCode;
    }

    public final long getExpiresIn() {
        return this.expiresIn;
    }

    public final String getUid() {
        return this.uid;
    }
}
