package com.bytedance.trae.login.enterprise;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthModels.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/login/enterprise/GetCodeInfoRequest;", "", "code", "", "codeType", "", "<init>", "(Ljava/lang/String;I)V", "getCode", "()Ljava/lang/String;", "getCodeType", "()I", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GetCodeInfoRequest {

    @SerializedName("Code")
    private final String code;

    @SerializedName("CodeType")
    private final int codeType;

    public static /* synthetic */ GetCodeInfoRequest copy$default(GetCodeInfoRequest getCodeInfoRequest, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getCodeInfoRequest.code;
        }
        if ((i2 & 2) != 0) {
            i = getCodeInfoRequest.codeType;
        }
        return getCodeInfoRequest.copy(str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCodeType() {
        return this.codeType;
    }

    public final GetCodeInfoRequest copy(String code, int codeType) {
        Intrinsics.checkNotNullParameter(code, "code");
        return new GetCodeInfoRequest(code, codeType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetCodeInfoRequest)) {
            return false;
        }
        GetCodeInfoRequest getCodeInfoRequest = (GetCodeInfoRequest) other;
        return Intrinsics.areEqual(this.code, getCodeInfoRequest.code) && this.codeType == getCodeInfoRequest.codeType;
    }

    public int hashCode() {
        return (this.code.hashCode() * 31) + Integer.hashCode(this.codeType);
    }

    public String toString() {
        return "GetCodeInfoRequest(code=" + this.code + ", codeType=" + this.codeType + ')';
    }

    public GetCodeInfoRequest(String code, int i) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.code = code;
        this.codeType = i;
    }

    public /* synthetic */ GetCodeInfoRequest(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 5 : i);
    }

    public final String getCode() {
        return this.code;
    }

    public final int getCodeType() {
        return this.codeType;
    }
}
