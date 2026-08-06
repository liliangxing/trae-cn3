package com.bytedance.trae.conversation.imageupload;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/StsTokenData;", "", "accessKeyId", "", "secretAccessKey", "sessionToken", "expiredTimeIso", "currentTimeIso", "serviceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKeyId", "()Ljava/lang/String;", "getSecretAccessKey", "getSessionToken", "getExpiredTimeIso", "getCurrentTimeIso", "getServiceId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StsTokenData {
    private final String accessKeyId;
    private final String currentTimeIso;
    private final String expiredTimeIso;
    private final String secretAccessKey;
    private final String serviceId;
    private final String sessionToken;

    public static /* synthetic */ StsTokenData copy$default(StsTokenData stsTokenData, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stsTokenData.accessKeyId;
        }
        if ((i & 2) != 0) {
            str2 = stsTokenData.secretAccessKey;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = stsTokenData.sessionToken;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = stsTokenData.expiredTimeIso;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = stsTokenData.currentTimeIso;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = stsTokenData.serviceId;
        }
        return stsTokenData.copy(str, str7, str8, str9, str10, str6);
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
    public final String getExpiredTimeIso() {
        return this.expiredTimeIso;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCurrentTimeIso() {
        return this.currentTimeIso;
    }

    /* renamed from: component6, reason: from getter */
    public final String getServiceId() {
        return this.serviceId;
    }

    public final StsTokenData copy(String accessKeyId, String secretAccessKey, String sessionToken, String expiredTimeIso, String currentTimeIso, String serviceId) {
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(expiredTimeIso, "expiredTimeIso");
        Intrinsics.checkNotNullParameter(currentTimeIso, "currentTimeIso");
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        return new StsTokenData(accessKeyId, secretAccessKey, sessionToken, expiredTimeIso, currentTimeIso, serviceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StsTokenData)) {
            return false;
        }
        StsTokenData stsTokenData = (StsTokenData) other;
        return Intrinsics.areEqual(this.accessKeyId, stsTokenData.accessKeyId) && Intrinsics.areEqual(this.secretAccessKey, stsTokenData.secretAccessKey) && Intrinsics.areEqual(this.sessionToken, stsTokenData.sessionToken) && Intrinsics.areEqual(this.expiredTimeIso, stsTokenData.expiredTimeIso) && Intrinsics.areEqual(this.currentTimeIso, stsTokenData.currentTimeIso) && Intrinsics.areEqual(this.serviceId, stsTokenData.serviceId);
    }

    public int hashCode() {
        return (((((((((this.accessKeyId.hashCode() * 31) + this.secretAccessKey.hashCode()) * 31) + this.sessionToken.hashCode()) * 31) + this.expiredTimeIso.hashCode()) * 31) + this.currentTimeIso.hashCode()) * 31) + this.serviceId.hashCode();
    }

    public String toString() {
        return "StsTokenData(accessKeyId=" + this.accessKeyId + ", secretAccessKey=" + this.secretAccessKey + ", sessionToken=" + this.sessionToken + ", expiredTimeIso=" + this.expiredTimeIso + ", currentTimeIso=" + this.currentTimeIso + ", serviceId=" + this.serviceId + ')';
    }

    public StsTokenData(String accessKeyId, String secretAccessKey, String sessionToken, String expiredTimeIso, String currentTimeIso, String serviceId) {
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(expiredTimeIso, "expiredTimeIso");
        Intrinsics.checkNotNullParameter(currentTimeIso, "currentTimeIso");
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
        this.sessionToken = sessionToken;
        this.expiredTimeIso = expiredTimeIso;
        this.currentTimeIso = currentTimeIso;
        this.serviceId = serviceId;
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

    public final String getExpiredTimeIso() {
        return this.expiredTimeIso;
    }

    public final String getCurrentTimeIso() {
        return this.currentTimeIso;
    }

    public final String getServiceId() {
        return this.serviceId;
    }
}
