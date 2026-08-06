package com.bytedance.trae.login.enterprise;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthModels.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003JB\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", "message", "", "data", "hostInfo", "Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/Object;Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getHostInfo", "()Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/String;Ljava/lang/Object;Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;)Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnterpriseResponse<T> {

    @SerializedName("code")
    private final int code;

    @SerializedName("Data")
    private final T data;

    @SerializedName("HostInfo")
    private final EnterpriseHostInfo hostInfo;

    @SerializedName("message")
    private final String message;

    public EnterpriseResponse() {
        this(0, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EnterpriseResponse copy$default(EnterpriseResponse enterpriseResponse, int i, String str, Object obj, EnterpriseHostInfo enterpriseHostInfo, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = enterpriseResponse.code;
        }
        if ((i2 & 2) != 0) {
            str = enterpriseResponse.message;
        }
        if ((i2 & 4) != 0) {
            obj = enterpriseResponse.data;
        }
        if ((i2 & 8) != 0) {
            enterpriseHostInfo = enterpriseResponse.hostInfo;
        }
        return enterpriseResponse.copy(i, str, obj, enterpriseHostInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final T component3() {
        return this.data;
    }

    /* renamed from: component4, reason: from getter */
    public final EnterpriseHostInfo getHostInfo() {
        return this.hostInfo;
    }

    public final EnterpriseResponse<T> copy(int code, String message, T data, EnterpriseHostInfo hostInfo) {
        return new EnterpriseResponse<>(code, message, data, hostInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterpriseResponse)) {
            return false;
        }
        EnterpriseResponse enterpriseResponse = (EnterpriseResponse) other;
        return this.code == enterpriseResponse.code && Intrinsics.areEqual(this.message, enterpriseResponse.message) && Intrinsics.areEqual(this.data, enterpriseResponse.data) && Intrinsics.areEqual(this.hostInfo, enterpriseResponse.hostInfo);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.code) * 31;
        String str = this.message;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t = this.data;
        int hashCode3 = (hashCode2 + (t == null ? 0 : t.hashCode())) * 31;
        EnterpriseHostInfo enterpriseHostInfo = this.hostInfo;
        return hashCode3 + (enterpriseHostInfo != null ? enterpriseHostInfo.hashCode() : 0);
    }

    public String toString() {
        return "EnterpriseResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ", hostInfo=" + this.hostInfo + ')';
    }

    public EnterpriseResponse(int i, String str, T t, EnterpriseHostInfo enterpriseHostInfo) {
        this.code = i;
        this.message = str;
        this.data = t;
        this.hostInfo = enterpriseHostInfo;
    }

    public /* synthetic */ EnterpriseResponse(int i, String str, Object obj, EnterpriseHostInfo enterpriseHostInfo, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : obj, (i2 & 8) != 0 ? null : enterpriseHostInfo);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final T getData() {
        return this.data;
    }

    public final EnterpriseHostInfo getHostInfo() {
        return this.hostInfo;
    }
}
