package com.bytedance.trae.login.enterprise;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/login/enterprise/GetCodeInfoResult;", "", "email", "", "tenantId", "tenantName", "inviteEmail", "inviteName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getTenantId", "getTenantName", "getInviteEmail", "getInviteName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GetCodeInfoResult {

    @SerializedName("Email")
    private final String email;

    @SerializedName("InviteEmail")
    private final String inviteEmail;

    @SerializedName("InviteName")
    private final String inviteName;

    @SerializedName("TenantID")
    private final String tenantId;

    @SerializedName("TenantName")
    private final String tenantName;

    public GetCodeInfoResult() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ GetCodeInfoResult copy$default(GetCodeInfoResult getCodeInfoResult, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getCodeInfoResult.email;
        }
        if ((i & 2) != 0) {
            str2 = getCodeInfoResult.tenantId;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = getCodeInfoResult.tenantName;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = getCodeInfoResult.inviteEmail;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = getCodeInfoResult.inviteName;
        }
        return getCodeInfoResult.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTenantId() {
        return this.tenantId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTenantName() {
        return this.tenantName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getInviteEmail() {
        return this.inviteEmail;
    }

    /* renamed from: component5, reason: from getter */
    public final String getInviteName() {
        return this.inviteName;
    }

    public final GetCodeInfoResult copy(String email, String tenantId, String tenantName, String inviteEmail, String inviteName) {
        return new GetCodeInfoResult(email, tenantId, tenantName, inviteEmail, inviteName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetCodeInfoResult)) {
            return false;
        }
        GetCodeInfoResult getCodeInfoResult = (GetCodeInfoResult) other;
        return Intrinsics.areEqual(this.email, getCodeInfoResult.email) && Intrinsics.areEqual(this.tenantId, getCodeInfoResult.tenantId) && Intrinsics.areEqual(this.tenantName, getCodeInfoResult.tenantName) && Intrinsics.areEqual(this.inviteEmail, getCodeInfoResult.inviteEmail) && Intrinsics.areEqual(this.inviteName, getCodeInfoResult.inviteName);
    }

    public int hashCode() {
        String str = this.email;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.tenantId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.tenantName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.inviteEmail;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.inviteName;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "GetCodeInfoResult(email=" + this.email + ", tenantId=" + this.tenantId + ", tenantName=" + this.tenantName + ", inviteEmail=" + this.inviteEmail + ", inviteName=" + this.inviteName + ')';
    }

    public GetCodeInfoResult(String str, String str2, String str3, String str4, String str5) {
        this.email = str;
        this.tenantId = str2;
        this.tenantName = str3;
        this.inviteEmail = str4;
        this.inviteName = str5;
    }

    public /* synthetic */ GetCodeInfoResult(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getTenantName() {
        return this.tenantName;
    }

    public final String getInviteEmail() {
        return this.inviteEmail;
    }

    public final String getInviteName() {
        return this.inviteName;
    }
}
