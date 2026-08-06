package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ICustomActivityApi.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/network/MobileActivityRequest;", "", "version", "", "<init>", "(I)V", "getVersion", "()I", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MobileActivityRequest {

    @SerializedName("version")
    private final int version;

    public MobileActivityRequest() {
        this(0, 1, null);
    }

    public static /* synthetic */ MobileActivityRequest copy$default(MobileActivityRequest mobileActivityRequest, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mobileActivityRequest.version;
        }
        return mobileActivityRequest.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final MobileActivityRequest copy(int version) {
        return new MobileActivityRequest(version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MobileActivityRequest) && this.version == ((MobileActivityRequest) other).version;
    }

    public int hashCode() {
        return Integer.hashCode(this.version);
    }

    public String toString() {
        return "MobileActivityRequest(version=" + this.version + ')';
    }

    public MobileActivityRequest(int i) {
        this.version = i;
    }

    public /* synthetic */ MobileActivityRequest(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i);
    }

    public final int getVersion() {
        return this.version;
    }
}
