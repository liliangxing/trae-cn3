package com.bytedance.trae.login.enterprise;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthModels.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/login/enterprise/SendEmailVerificationRequest;", "", "email", "", "emailType", "", "<init>", "(Ljava/lang/String;I)V", "getEmail", "()Ljava/lang/String;", "getEmailType", "()I", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SendEmailVerificationRequest {

    @SerializedName("Email")
    private final String email;

    @SerializedName("EmailType")
    private final int emailType;

    public static /* synthetic */ SendEmailVerificationRequest copy$default(SendEmailVerificationRequest sendEmailVerificationRequest, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sendEmailVerificationRequest.email;
        }
        if ((i2 & 2) != 0) {
            i = sendEmailVerificationRequest.emailType;
        }
        return sendEmailVerificationRequest.copy(str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component2, reason: from getter */
    public final int getEmailType() {
        return this.emailType;
    }

    public final SendEmailVerificationRequest copy(String email, int emailType) {
        Intrinsics.checkNotNullParameter(email, "email");
        return new SendEmailVerificationRequest(email, emailType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendEmailVerificationRequest)) {
            return false;
        }
        SendEmailVerificationRequest sendEmailVerificationRequest = (SendEmailVerificationRequest) other;
        return Intrinsics.areEqual(this.email, sendEmailVerificationRequest.email) && this.emailType == sendEmailVerificationRequest.emailType;
    }

    public int hashCode() {
        return (this.email.hashCode() * 31) + Integer.hashCode(this.emailType);
    }

    public String toString() {
        return "SendEmailVerificationRequest(email=" + this.email + ", emailType=" + this.emailType + ')';
    }

    public SendEmailVerificationRequest(String email, int i) {
        Intrinsics.checkNotNullParameter(email, "email");
        this.email = email;
        this.emailType = i;
    }

    public /* synthetic */ SendEmailVerificationRequest(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 5 : i);
    }

    public final String getEmail() {
        return this.email;
    }

    public final int getEmailType() {
        return this.emailType;
    }
}
