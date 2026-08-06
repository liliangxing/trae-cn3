package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;", "", "traceId", "", "error", "Lcom/bytedance/trae/login/traeauth/TraeResponseError;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/login/traeauth/TraeResponseError;)V", "getTraceId", "()Ljava/lang/String;", "getError", "()Lcom/bytedance/trae/login/traeauth/TraeResponseError;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TraeResponseMetadata {

    @SerializedName("Error")
    private final TraeResponseError error;

    @SerializedName("TraceID")
    private final String traceId;

    /* JADX WARN: Multi-variable type inference failed */
    public TraeResponseMetadata() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TraeResponseMetadata copy$default(TraeResponseMetadata traeResponseMetadata, String str, TraeResponseError traeResponseError, int i, Object obj) {
        if ((i & 1) != 0) {
            str = traeResponseMetadata.traceId;
        }
        if ((i & 2) != 0) {
            traeResponseError = traeResponseMetadata.error;
        }
        return traeResponseMetadata.copy(str, traeResponseError);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component2, reason: from getter */
    public final TraeResponseError getError() {
        return this.error;
    }

    public final TraeResponseMetadata copy(String traceId, TraeResponseError error) {
        return new TraeResponseMetadata(traceId, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraeResponseMetadata)) {
            return false;
        }
        TraeResponseMetadata traeResponseMetadata = (TraeResponseMetadata) other;
        return Intrinsics.areEqual(this.traceId, traeResponseMetadata.traceId) && Intrinsics.areEqual(this.error, traeResponseMetadata.error);
    }

    public int hashCode() {
        String str = this.traceId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        TraeResponseError traeResponseError = this.error;
        return hashCode + (traeResponseError != null ? traeResponseError.hashCode() : 0);
    }

    public String toString() {
        return "TraeResponseMetadata(traceId=" + this.traceId + ", error=" + this.error + ')';
    }

    public TraeResponseMetadata(String str, TraeResponseError traeResponseError) {
        this.traceId = str;
        this.error = traeResponseError;
    }

    public /* synthetic */ TraeResponseMetadata(String str, TraeResponseError traeResponseError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : traeResponseError);
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final TraeResponseError getError() {
        return this.error;
    }
}
