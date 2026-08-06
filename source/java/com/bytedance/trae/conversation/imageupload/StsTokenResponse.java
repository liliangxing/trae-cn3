package com.bytedance.trae.conversation.imageupload;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/StsTokenResponse;", "", "accessKeyId", "", "secretAccessKey", "sessionToken", "expiredTime", "currentTime", "serviceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKeyId", "()Ljava/lang/String;", "getSecretAccessKey", "getSessionToken", "getExpiredTime", "getCurrentTime", "getServiceId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StsTokenResponse {

    @SerializedName(StrategyConstants.ACCESS_KEY_ID)
    private final String accessKeyId;

    @SerializedName("current_time")
    private final String currentTime;

    @SerializedName("expired_time")
    private final String expiredTime;

    @SerializedName(StrategyConstants.SECRET_ACCESS_KEY)
    private final String secretAccessKey;

    @SerializedName(StrategyConstants.SERVICE_ID)
    private final String serviceId;

    @SerializedName(StrategyConstants.SESSION_TOKEN)
    private final String sessionToken;

    public static /* synthetic */ StsTokenResponse copy$default(StsTokenResponse stsTokenResponse, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stsTokenResponse.accessKeyId;
        }
        if ((i & 2) != 0) {
            str2 = stsTokenResponse.secretAccessKey;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = stsTokenResponse.sessionToken;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = stsTokenResponse.expiredTime;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = stsTokenResponse.currentTime;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = stsTokenResponse.serviceId;
        }
        return stsTokenResponse.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSessionToken() {
        return this.sessionToken;
    }

    /* renamed from: component4, reason: from getter */
    public final String getExpiredTime() {
        return this.expiredTime;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCurrentTime() {
        return this.currentTime;
    }

    /* renamed from: component6, reason: from getter */
    public final String getServiceId() {
        return this.serviceId;
    }

    public final StsTokenResponse copy(String accessKeyId, String secretAccessKey, String sessionToken, String expiredTime, String currentTime, String serviceId) {
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(expiredTime, "expiredTime");
        return new StsTokenResponse(accessKeyId, secretAccessKey, sessionToken, expiredTime, currentTime, serviceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StsTokenResponse)) {
            return false;
        }
        StsTokenResponse stsTokenResponse = (StsTokenResponse) other;
        return Intrinsics.areEqual(this.accessKeyId, stsTokenResponse.accessKeyId) && Intrinsics.areEqual(this.secretAccessKey, stsTokenResponse.secretAccessKey) && Intrinsics.areEqual(this.sessionToken, stsTokenResponse.sessionToken) && Intrinsics.areEqual(this.expiredTime, stsTokenResponse.expiredTime) && Intrinsics.areEqual(this.currentTime, stsTokenResponse.currentTime) && Intrinsics.areEqual(this.serviceId, stsTokenResponse.serviceId);
    }

    public int hashCode() {
        int hashCode = ((((((this.accessKeyId.hashCode() * 31) + this.secretAccessKey.hashCode()) * 31) + this.sessionToken.hashCode()) * 31) + this.expiredTime.hashCode()) * 31;
        String str = this.currentTime;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.serviceId;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "StsTokenResponse(accessKeyId=" + this.accessKeyId + ", secretAccessKey=" + this.secretAccessKey + ", sessionToken=" + this.sessionToken + ", expiredTime=" + this.expiredTime + ", currentTime=" + this.currentTime + ", serviceId=" + this.serviceId + ')';
    }

    public StsTokenResponse(String accessKeyId, String secretAccessKey, String sessionToken, String expiredTime, String str, String str2) {
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(expiredTime, "expiredTime");
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
        this.sessionToken = sessionToken;
        this.expiredTime = expiredTime;
        this.currentTime = str;
        this.serviceId = str2;
    }

    public /* synthetic */ StsTokenResponse(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    public final String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public final String getSessionToken() {
        return this.sessionToken;
    }

    public final String getExpiredTime() {
        return this.expiredTime;
    }

    public final String getCurrentTime() {
        return this.currentTime;
    }

    public final String getServiceId() {
        return this.serviceId;
    }
}
