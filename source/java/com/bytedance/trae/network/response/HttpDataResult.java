package com.bytedance.trae.network.response;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.PreloadConfig;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: HttpDataResult.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/network/response/HttpDataResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "toString", "", "Success", "Error", "Lcom/bytedance/trae/network/response/HttpDataResult$Error;", "Lcom/bytedance/trae/network/response/HttpDataResult$Success;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class HttpDataResult<T> {
    public /* synthetic */ HttpDataResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private HttpDataResult() {
    }

    /* compiled from: HttpDataResult.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/network/response/HttpDataResult$Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/trae/network/response/HttpDataResult;", "bizResp", "Lcom/bytedance/trae/network/response/BizResponse;", LynxError.LYNX_THROWABLE, "", "<init>", "(Lcom/bytedance/trae/network/response/BizResponse;Ljava/lang/Throwable;)V", "getBizResp", "()Lcom/bytedance/trae/network/response/BizResponse;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Success<T> extends HttpDataResult<T> {
        private final BizResponse<T> bizResp;
        private final Throwable throwable;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, BizResponse bizResponse, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                bizResponse = success.bizResp;
            }
            if ((i & 2) != 0) {
                th = success.throwable;
            }
            return success.copy(bizResponse, th);
        }

        public final BizResponse<T> component1() {
            return this.bizResp;
        }

        /* renamed from: component2, reason: from getter */
        public final Throwable getThrowable() {
            return this.throwable;
        }

        public final Success<T> copy(BizResponse<T> bizResp, Throwable throwable) {
            Intrinsics.checkNotNullParameter(bizResp, "bizResp");
            return new Success<>(bizResp, throwable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.bizResp, success.bizResp) && Intrinsics.areEqual(this.throwable, success.throwable);
        }

        public int hashCode() {
            int hashCode = this.bizResp.hashCode() * 31;
            Throwable th = this.throwable;
            return hashCode + (th == null ? 0 : th.hashCode());
        }

        @Override // com.bytedance.trae.network.response.HttpDataResult
        public String toString() {
            return "Success(bizResp=" + this.bizResp + ", throwable=" + this.throwable + ')';
        }

        public final BizResponse<T> getBizResp() {
            return this.bizResp;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(BizResponse<T> bizResp, Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(bizResp, "bizResp");
            this.bizResp = bizResp;
            this.throwable = th;
        }
    }

    /* compiled from: HttpDataResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/network/response/HttpDataResult$Error;", "Lcom/bytedance/trae/network/response/HttpDataResult;", "", "code", "", "msg", "", LynxError.LYNX_THROWABLE, "", "errorBody", "<init>", "(ILjava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getThrowable", "()Ljava/lang/Throwable;", "getErrorBody", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Error extends HttpDataResult {
        private final int code;
        private final String errorBody;
        private final String msg;
        private final Throwable throwable;

        public static /* synthetic */ Error copy$default(Error error, int i, String str, Throwable th, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = error.code;
            }
            if ((i2 & 2) != 0) {
                str = error.msg;
            }
            if ((i2 & 4) != 0) {
                th = error.throwable;
            }
            if ((i2 & 8) != 0) {
                str2 = error.errorBody;
            }
            return error.copy(i, str, th, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        /* renamed from: component3, reason: from getter */
        public final Throwable getThrowable() {
            return this.throwable;
        }

        /* renamed from: component4, reason: from getter */
        public final String getErrorBody() {
            return this.errorBody;
        }

        public final Error copy(int code, String msg, Throwable throwable, String errorBody) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            return new Error(code, msg, throwable, errorBody);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return this.code == error.code && Intrinsics.areEqual(this.msg, error.msg) && Intrinsics.areEqual(this.throwable, error.throwable) && Intrinsics.areEqual(this.errorBody, error.errorBody);
        }

        public int hashCode() {
            int hashCode = ((Integer.hashCode(this.code) * 31) + this.msg.hashCode()) * 31;
            Throwable th = this.throwable;
            int hashCode2 = (hashCode + (th == null ? 0 : th.hashCode())) * 31;
            String str = this.errorBody;
            return hashCode2 + (str != null ? str.hashCode() : 0);
        }

        @Override // com.bytedance.trae.network.response.HttpDataResult
        public String toString() {
            return "Error(code=" + this.code + ", msg=" + this.msg + ", throwable=" + this.throwable + ", errorBody=" + this.errorBody + ')';
        }

        public /* synthetic */ Error(int i, String str, Throwable th, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, th, (i2 & 8) != 0 ? null : str2);
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public final String getErrorBody() {
            return this.errorBody;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(int i, String msg, Throwable th, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.code = i;
            this.msg = msg;
            this.throwable = th;
            this.errorBody = str;
        }
    }

    public String toString() {
        if (this instanceof Success) {
            return "Success[" + this + AbstractJsonLexerKt.END_LIST;
        }
        if (this instanceof Error) {
            return "Error[" + this + AbstractJsonLexerKt.END_LIST;
        }
        throw new NoWhenBranchMatchedException();
    }
}
