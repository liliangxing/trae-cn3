package com.bytedance.trae.conversation.network;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.retrofit2.SsResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemoteResponse.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001#B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0012J\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0012J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ6\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015¨\u0006$"}, d2 = {"Lcom/bytedance/trae/conversation/network/RemoteResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", "msg", "", "data", "<init>", "(JLjava/lang/String;Ljava/lang/Object;)V", "getCode", "()J", "getMsg", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "ssResponse", "Lcom/bytedance/retrofit2/SsResponse;", "isSuccess", "", "()Z", "setupSSResponse", "", "getSSResponse", "component1", "component2", "component3", "copy", "(JLjava/lang/String;Ljava/lang/Object;)Lcom/bytedance/trae/conversation/network/RemoteResponse;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RemoteResponse<T> {
    public static final long CODE_UNKNOWN = -999;

    @SerializedName("code")
    private final long code;

    @SerializedName("data")
    private final T data;

    @SerializedName("message")
    private final String msg;
    private transient SsResponse<String> ssResponse;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long[] CODE_RISK_CONTROL = {710012005, 710012021};

    public RemoteResponse() {
        this(0L, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RemoteResponse copy$default(RemoteResponse remoteResponse, long j, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            j = remoteResponse.code;
        }
        if ((i & 2) != 0) {
            str = remoteResponse.msg;
        }
        if ((i & 4) != 0) {
            obj = remoteResponse.data;
        }
        return remoteResponse.copy(j, str, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final T component3() {
        return this.data;
    }

    public final RemoteResponse<T> copy(long code, String msg, T data) {
        return new RemoteResponse<>(code, msg, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteResponse)) {
            return false;
        }
        RemoteResponse remoteResponse = (RemoteResponse) other;
        return this.code == remoteResponse.code && Intrinsics.areEqual(this.msg, remoteResponse.msg) && Intrinsics.areEqual(this.data, remoteResponse.data);
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.code) * 31;
        String str = this.msg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t = this.data;
        return hashCode2 + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        return "RemoteResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
    }

    public RemoteResponse(long j, String str, T t) {
        this.code = j;
        this.msg = str;
        this.data = t;
    }

    public /* synthetic */ RemoteResponse(long j, String str, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : obj);
    }

    public final long getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final T getData() {
        return this.data;
    }

    /* compiled from: RemoteResponse.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/network/RemoteResponse$Companion;", "", "<init>", "()V", "CODE_UNKNOWN", "", "CODE_RISK_CONTROL", "", "getCODE_RISK_CONTROL", "()[J", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long[] getCODE_RISK_CONTROL() {
            return RemoteResponse.CODE_RISK_CONTROL;
        }
    }

    public final boolean isSuccess() {
        return this.code == 0;
    }

    public final void setupSSResponse(SsResponse<String> ssResponse) {
        Intrinsics.checkNotNullParameter(ssResponse, "ssResponse");
        this.ssResponse = ssResponse;
    }

    public final SsResponse<String> getSSResponse() {
        return this.ssResponse;
    }
}
