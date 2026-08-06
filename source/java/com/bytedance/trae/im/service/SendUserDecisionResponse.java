package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ISendUserDecisionApi.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/im/service/SendUserDecisionResponse;", "", "success", "", "<init>", "(Ljava/lang/Boolean;)V", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/SendUserDecisionResponse;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SendUserDecisionResponse {

    @SerializedName("success")
    private final Boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public SendUserDecisionResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SendUserDecisionResponse copy$default(SendUserDecisionResponse sendUserDecisionResponse, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = sendUserDecisionResponse.success;
        }
        return sendUserDecisionResponse.copy(bool);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    public final SendUserDecisionResponse copy(Boolean success) {
        return new SendUserDecisionResponse(success);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SendUserDecisionResponse) && Intrinsics.areEqual(this.success, ((SendUserDecisionResponse) other).success);
    }

    public int hashCode() {
        Boolean bool = this.success;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public String toString() {
        return "SendUserDecisionResponse(success=" + this.success + ')';
    }

    public SendUserDecisionResponse(Boolean bool) {
        this.success = bool;
    }

    public /* synthetic */ SendUserDecisionResponse(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool);
    }

    public final Boolean getSuccess() {
        return this.success;
    }
}
