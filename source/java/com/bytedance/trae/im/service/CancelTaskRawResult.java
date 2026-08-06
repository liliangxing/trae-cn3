package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICancelTaskApi.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J6\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/im/service/CancelTaskRawResult;", "", "result", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/CancelTaskResponse;", "bizCode", "", "bizMsg", "", "<init>", "(Lcom/bytedance/trae/network/response/HttpDataResult;Ljava/lang/Long;Ljava/lang/String;)V", "getResult", "()Lcom/bytedance/trae/network/response/HttpDataResult;", "getBizCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBizMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Lcom/bytedance/trae/network/response/HttpDataResult;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/trae/im/service/CancelTaskRawResult;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CancelTaskRawResult {
    private final Long bizCode;
    private final String bizMsg;
    private final HttpDataResult<CancelTaskResponse> result;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CancelTaskRawResult copy$default(CancelTaskRawResult cancelTaskRawResult, HttpDataResult httpDataResult, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            httpDataResult = cancelTaskRawResult.result;
        }
        if ((i & 2) != 0) {
            l = cancelTaskRawResult.bizCode;
        }
        if ((i & 4) != 0) {
            str = cancelTaskRawResult.bizMsg;
        }
        return cancelTaskRawResult.copy(httpDataResult, l, str);
    }

    public final HttpDataResult<CancelTaskResponse> component1() {
        return this.result;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getBizCode() {
        return this.bizCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBizMsg() {
        return this.bizMsg;
    }

    public final CancelTaskRawResult copy(HttpDataResult<CancelTaskResponse> result, Long bizCode, String bizMsg) {
        Intrinsics.checkNotNullParameter(result, "result");
        return new CancelTaskRawResult(result, bizCode, bizMsg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CancelTaskRawResult)) {
            return false;
        }
        CancelTaskRawResult cancelTaskRawResult = (CancelTaskRawResult) other;
        return Intrinsics.areEqual(this.result, cancelTaskRawResult.result) && Intrinsics.areEqual(this.bizCode, cancelTaskRawResult.bizCode) && Intrinsics.areEqual(this.bizMsg, cancelTaskRawResult.bizMsg);
    }

    public int hashCode() {
        int hashCode = this.result.hashCode() * 31;
        Long l = this.bizCode;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.bizMsg;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "CancelTaskRawResult(result=" + this.result + ", bizCode=" + this.bizCode + ", bizMsg=" + this.bizMsg + ')';
    }

    public CancelTaskRawResult(HttpDataResult<CancelTaskResponse> result, Long l, String str) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.result = result;
        this.bizCode = l;
        this.bizMsg = str;
    }

    public final HttpDataResult<CancelTaskResponse> getResult() {
        return this.result;
    }

    public final Long getBizCode() {
        return this.bizCode;
    }

    public final String getBizMsg() {
        return this.bizMsg;
    }
}
