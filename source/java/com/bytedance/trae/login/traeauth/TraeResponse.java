package com.bytedance.trae.login.traeauth;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ,\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "responseMetadata", "Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;", "result", "<init>", "(Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;Ljava/lang/Object;)V", "getResponseMetadata", "()Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;Ljava/lang/Object;)Lcom/bytedance/trae/login/traeauth/TraeResponse;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TraeResponse<T> {

    @SerializedName("ResponseMetadata")
    private final TraeResponseMetadata responseMetadata;

    @SerializedName("Result")
    private final T result;

    /* JADX WARN: Multi-variable type inference failed */
    public TraeResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TraeResponse copy$default(TraeResponse traeResponse, TraeResponseMetadata traeResponseMetadata, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            traeResponseMetadata = traeResponse.responseMetadata;
        }
        if ((i & 2) != 0) {
            obj = traeResponse.result;
        }
        return traeResponse.copy(traeResponseMetadata, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final TraeResponseMetadata getResponseMetadata() {
        return this.responseMetadata;
    }

    public final T component2() {
        return this.result;
    }

    public final TraeResponse<T> copy(TraeResponseMetadata responseMetadata, T result) {
        return new TraeResponse<>(responseMetadata, result);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraeResponse)) {
            return false;
        }
        TraeResponse traeResponse = (TraeResponse) other;
        return Intrinsics.areEqual(this.responseMetadata, traeResponse.responseMetadata) && Intrinsics.areEqual(this.result, traeResponse.result);
    }

    public int hashCode() {
        TraeResponseMetadata traeResponseMetadata = this.responseMetadata;
        int hashCode = (traeResponseMetadata == null ? 0 : traeResponseMetadata.hashCode()) * 31;
        T t = this.result;
        return hashCode + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        return "TraeResponse(responseMetadata=" + this.responseMetadata + ", result=" + this.result + ')';
    }

    public TraeResponse(TraeResponseMetadata traeResponseMetadata, T t) {
        this.responseMetadata = traeResponseMetadata;
        this.result = t;
    }

    public /* synthetic */ TraeResponse(TraeResponseMetadata traeResponseMetadata, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : traeResponseMetadata, (i & 2) != 0 ? null : obj);
    }

    public final TraeResponseMetadata getResponseMetadata() {
        return this.responseMetadata;
    }

    public final T getResult() {
        return this.result;
    }
}
