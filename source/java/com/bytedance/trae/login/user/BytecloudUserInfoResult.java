package com.bytedance.trae.login.user;

import androidx.autofill.HintConstants;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BytecloudUserInfoResult.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/trae/login/user/BytecloudUserInfoResult;", "", HintConstants.AUTOFILL_HINT_USERNAME, "", "email", "avatarUrl", "organization", "employeeId", "region", "scope", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "getEmail", "getAvatarUrl", "getOrganization", "getEmployeeId", "getRegion", "getScope", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BytecloudUserInfoResult {

    @SerializedName("AvatarUrl")
    private final String avatarUrl;

    @SerializedName("Email")
    private final String email;

    @SerializedName("EmployeeID")
    private final String employeeId;

    @SerializedName("Organization")
    private final String organization;

    @SerializedName("Region")
    private final String region;

    @SerializedName("Scope")
    private final String scope;

    @SerializedName("Username")
    private final String username;

    public BytecloudUserInfoResult() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ BytecloudUserInfoResult copy$default(BytecloudUserInfoResult bytecloudUserInfoResult, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bytecloudUserInfoResult.username;
        }
        if ((i & 2) != 0) {
            str2 = bytecloudUserInfoResult.email;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = bytecloudUserInfoResult.avatarUrl;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = bytecloudUserInfoResult.organization;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = bytecloudUserInfoResult.employeeId;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = bytecloudUserInfoResult.region;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = bytecloudUserInfoResult.scope;
        }
        return bytecloudUserInfoResult.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOrganization() {
        return this.organization;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEmployeeId() {
        return this.employeeId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* renamed from: component7, reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    public final BytecloudUserInfoResult copy(String username, String email, String avatarUrl, String organization, String employeeId, String region, String scope) {
        return new BytecloudUserInfoResult(username, email, avatarUrl, organization, employeeId, region, scope);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BytecloudUserInfoResult)) {
            return false;
        }
        BytecloudUserInfoResult bytecloudUserInfoResult = (BytecloudUserInfoResult) other;
        return Intrinsics.areEqual(this.username, bytecloudUserInfoResult.username) && Intrinsics.areEqual(this.email, bytecloudUserInfoResult.email) && Intrinsics.areEqual(this.avatarUrl, bytecloudUserInfoResult.avatarUrl) && Intrinsics.areEqual(this.organization, bytecloudUserInfoResult.organization) && Intrinsics.areEqual(this.employeeId, bytecloudUserInfoResult.employeeId) && Intrinsics.areEqual(this.region, bytecloudUserInfoResult.region) && Intrinsics.areEqual(this.scope, bytecloudUserInfoResult.scope);
    }

    public int hashCode() {
        String str = this.username;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.email;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatarUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.organization;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.employeeId;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.region;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.scope;
        return hashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "BytecloudUserInfoResult(username=" + this.username + ", email=" + this.email + ", avatarUrl=" + this.avatarUrl + ", organization=" + this.organization + ", employeeId=" + this.employeeId + ", region=" + this.region + ", scope=" + this.scope + ')';
    }

    public BytecloudUserInfoResult(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.username = str;
        this.email = str2;
        this.avatarUrl = str3;
        this.organization = str4;
        this.employeeId = str5;
        this.region = str6;
        this.scope = str7;
    }

    public /* synthetic */ BytecloudUserInfoResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getOrganization() {
        return this.organization;
    }

    public final String getEmployeeId() {
        return this.employeeId;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getScope() {
        return this.scope;
    }
}
