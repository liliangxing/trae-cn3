package com.bytedance.trae.login.region;

import androidx.webkit.UserAgentMetadata;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckLoginModels.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/login/region/CheckLoginRequest;", "", "ideVersion", "", "getAIPayHost", "", "reqSource", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getIdeVersion", "()Ljava/lang/String;", "getGetAIPayHost", "()Z", "getReqSource", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CheckLoginRequest {

    @SerializedName("GetAIPayHost")
    private final boolean getAIPayHost;

    @SerializedName("IDEVersion")
    private final String ideVersion;

    @SerializedName("ReqSource")
    private final String reqSource;

    public CheckLoginRequest() {
        this(null, false, null, 7, null);
    }

    public static /* synthetic */ CheckLoginRequest copy$default(CheckLoginRequest checkLoginRequest, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkLoginRequest.ideVersion;
        }
        if ((i & 2) != 0) {
            z = checkLoginRequest.getAIPayHost;
        }
        if ((i & 4) != 0) {
            str2 = checkLoginRequest.reqSource;
        }
        return checkLoginRequest.copy(str, z, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getIdeVersion() {
        return this.ideVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getGetAIPayHost() {
        return this.getAIPayHost;
    }

    /* renamed from: component3, reason: from getter */
    public final String getReqSource() {
        return this.reqSource;
    }

    public final CheckLoginRequest copy(String ideVersion, boolean getAIPayHost, String reqSource) {
        Intrinsics.checkNotNullParameter(ideVersion, "ideVersion");
        Intrinsics.checkNotNullParameter(reqSource, "reqSource");
        return new CheckLoginRequest(ideVersion, getAIPayHost, reqSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckLoginRequest)) {
            return false;
        }
        CheckLoginRequest checkLoginRequest = (CheckLoginRequest) other;
        return Intrinsics.areEqual(this.ideVersion, checkLoginRequest.ideVersion) && this.getAIPayHost == checkLoginRequest.getAIPayHost && Intrinsics.areEqual(this.reqSource, checkLoginRequest.reqSource);
    }

    public int hashCode() {
        return (((this.ideVersion.hashCode() * 31) + Boolean.hashCode(this.getAIPayHost)) * 31) + this.reqSource.hashCode();
    }

    public String toString() {
        return "CheckLoginRequest(ideVersion=" + this.ideVersion + ", getAIPayHost=" + this.getAIPayHost + ", reqSource=" + this.reqSource + ')';
    }

    public CheckLoginRequest(String ideVersion, boolean z, String reqSource) {
        Intrinsics.checkNotNullParameter(ideVersion, "ideVersion");
        Intrinsics.checkNotNullParameter(reqSource, "reqSource");
        this.ideVersion = ideVersion;
        this.getAIPayHost = z;
        this.reqSource = reqSource;
    }

    public /* synthetic */ CheckLoginRequest(String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "0.1.0" : str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? UserAgentMetadata.FORM_FACTOR_MOBILE : str2);
    }

    public final String getIdeVersion() {
        return this.ideVersion;
    }

    public final boolean getGetAIPayHost() {
        return this.getAIPayHost;
    }

    public final String getReqSource() {
        return this.reqSource;
    }
}
