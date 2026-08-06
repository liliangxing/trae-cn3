package com.bytedance.trae.login.enterprise;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/login/enterprise/SetUserPasswordRequest;", "", "email", "", "password", "code", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getPassword", "getCode", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SetUserPasswordRequest {

    @SerializedName("Code")
    private final String code;

    @SerializedName("Email")
    private final String email;

    @SerializedName("Password")
    private final String password;

    public static /* synthetic */ SetUserPasswordRequest copy$default(SetUserPasswordRequest setUserPasswordRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = setUserPasswordRequest.email;
        }
        if ((i & 2) != 0) {
            str2 = setUserPasswordRequest.password;
        }
        if ((i & 4) != 0) {
            str3 = setUserPasswordRequest.code;
        }
        return setUserPasswordRequest.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    public final SetUserPasswordRequest copy(String email, String password, String code) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(code, "code");
        return new SetUserPasswordRequest(email, password, code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SetUserPasswordRequest)) {
            return false;
        }
        SetUserPasswordRequest setUserPasswordRequest = (SetUserPasswordRequest) other;
        return Intrinsics.areEqual(this.email, setUserPasswordRequest.email) && Intrinsics.areEqual(this.password, setUserPasswordRequest.password) && Intrinsics.areEqual(this.code, setUserPasswordRequest.code);
    }

    public int hashCode() {
        return (((this.email.hashCode() * 31) + this.password.hashCode()) * 31) + this.code.hashCode();
    }

    public String toString() {
        return "SetUserPasswordRequest(email=" + this.email + ", password=" + this.password + ", code=" + this.code + ')';
    }

    public SetUserPasswordRequest(String email, String password, String code) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(code, "code");
        this.email = email;
        this.password = password;
        this.code = code;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getCode() {
        return this.code;
    }
}
