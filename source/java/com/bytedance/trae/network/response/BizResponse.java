package com.bytedance.trae.network.response;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.retrofit2.SsResponse;
import com.google.gson.annotations.SerializedName;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BizResponse.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 0*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u00010BM\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u001e\u001a\u00020\u001f2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0018J\u0014\u0010 \u001a\u00020\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aJ\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0018J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003JZ\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u001c2\b\u0010,\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\t\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001d¨\u00061"}, d2 = {"Lcom/bytedance/trae/network/response/BizResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", "msg", "", "message", "payload", "data", "activityMessage", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getCode", "()J", "getMsg", "()Ljava/lang/String;", "getMessage", "getPayload", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getActivityMessage", "ssResponse", "Lcom/bytedance/retrofit2/SsResponse;", "successCodes", "", "isSuccess", "", "()Z", "setupSSResponse", "", "setupSuccessCodes", "codes", "getSSResponse", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Lcom/bytedance/trae/network/response/BizResponse;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "Companion", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BizResponse<T> {
    public static final long CODE_UNKNOWN = -999;

    @SerializedName("activity_message")
    private final String activityMessage;

    @SerializedName("code")
    private final long code;

    @SerializedName("data")
    private final T data;

    @SerializedName("message")
    private final String message;

    @SerializedName("msg")
    private final String msg;

    @SerializedName("payload")
    private final String payload;
    private transient SsResponse<String> ssResponse;
    private transient Set<Long> successCodes;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long[] CODE_RISK_CONTROL = {710012005, 710012021};
    private static final Set<Long> DEFAULT_SUCCESS_CODES = SetsKt.setOf(0L);

    public BizResponse() {
        this(0L, null, null, null, null, null, 63, null);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPayload() {
        return this.payload;
    }

    public final T component5() {
        return this.data;
    }

    /* renamed from: component6, reason: from getter */
    public final String getActivityMessage() {
        return this.activityMessage;
    }

    public final BizResponse<T> copy(long code, String msg, String message, String payload, T data, String activityMessage) {
        return new BizResponse<>(code, msg, message, payload, data, activityMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BizResponse)) {
            return false;
        }
        BizResponse bizResponse = (BizResponse) other;
        return this.code == bizResponse.code && Intrinsics.areEqual(this.msg, bizResponse.msg) && Intrinsics.areEqual(this.message, bizResponse.message) && Intrinsics.areEqual(this.payload, bizResponse.payload) && Intrinsics.areEqual(this.data, bizResponse.data) && Intrinsics.areEqual(this.activityMessage, bizResponse.activityMessage);
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.code) * 31;
        String str = this.msg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.message;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.payload;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        T t = this.data;
        int hashCode5 = (hashCode4 + (t == null ? 0 : t.hashCode())) * 31;
        String str4 = this.activityMessage;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "BizResponse(code=" + this.code + ", msg=" + this.msg + ", message=" + this.message + ", payload=" + this.payload + ", data=" + this.data + ", activityMessage=" + this.activityMessage + ')';
    }

    public BizResponse(long j, String str, String str2, String str3, T t, String str4) {
        this.code = j;
        this.msg = str;
        this.message = str2;
        this.payload = str3;
        this.data = t;
        this.activityMessage = str4;
        this.successCodes = DEFAULT_SUCCESS_CODES;
    }

    public /* synthetic */ BizResponse(long j, String str, String str2, String str3, Object obj, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) == 0 ? str3 : "", (i & 16) != 0 ? null : obj, (i & 32) == 0 ? str4 : null);
    }

    public final long getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final T getData() {
        return this.data;
    }

    public final String getActivityMessage() {
        return this.activityMessage;
    }

    /* compiled from: BizResponse.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/network/response/BizResponse$Companion;", "", "<init>", "()V", "CODE_UNKNOWN", "", "CODE_RISK_CONTROL", "", "getCODE_RISK_CONTROL", "()[J", "DEFAULT_SUCCESS_CODES", "", "getDEFAULT_SUCCESS_CODES", "()Ljava/util/Set;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long[] getCODE_RISK_CONTROL() {
            return BizResponse.CODE_RISK_CONTROL;
        }

        public final Set<Long> getDEFAULT_SUCCESS_CODES() {
            return BizResponse.DEFAULT_SUCCESS_CODES;
        }
    }

    public final boolean isSuccess() {
        return this.successCodes.contains(Long.valueOf(this.code));
    }

    public final void setupSSResponse(SsResponse<String> ssResponse) {
        Intrinsics.checkNotNullParameter(ssResponse, "ssResponse");
        this.ssResponse = ssResponse;
    }

    public final void setupSuccessCodes(Set<Long> codes) {
        Intrinsics.checkNotNullParameter(codes, "codes");
        Set<Long> set = codes;
        if (set.isEmpty()) {
            set = DEFAULT_SUCCESS_CODES;
        }
        this.successCodes = set;
    }

    public final SsResponse<String> getSSResponse() {
        return this.ssResponse;
    }
}
