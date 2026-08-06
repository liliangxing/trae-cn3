package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.ServiceType;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThirdPartyTokenRepository.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/network/ThirdPartyTokenMetaError;", "", "code", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getMessage", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ThirdPartyTokenMetaError {

    @SerializedName("Code")
    private final String code;

    @SerializedName(ServiceType.IM)
    private final String message;

    /* JADX WARN: Multi-variable type inference failed */
    public ThirdPartyTokenMetaError() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ThirdPartyTokenMetaError copy$default(ThirdPartyTokenMetaError thirdPartyTokenMetaError, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = thirdPartyTokenMetaError.code;
        }
        if ((i & 2) != 0) {
            str2 = thirdPartyTokenMetaError.message;
        }
        return thirdPartyTokenMetaError.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final ThirdPartyTokenMetaError copy(String code, String message) {
        return new ThirdPartyTokenMetaError(code, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThirdPartyTokenMetaError)) {
            return false;
        }
        ThirdPartyTokenMetaError thirdPartyTokenMetaError = (ThirdPartyTokenMetaError) other;
        return Intrinsics.areEqual(this.code, thirdPartyTokenMetaError.code) && Intrinsics.areEqual(this.message, thirdPartyTokenMetaError.message);
    }

    public int hashCode() {
        String str = this.code;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.message;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ThirdPartyTokenMetaError(code=" + this.code + ", message=" + this.message + ')';
    }

    public ThirdPartyTokenMetaError(String str, String str2) {
        this.code = str;
        this.message = str2;
    }

    public /* synthetic */ ThirdPartyTokenMetaError(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }
}
