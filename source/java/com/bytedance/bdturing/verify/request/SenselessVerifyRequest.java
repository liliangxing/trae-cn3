package com.bytedance.bdturing.verify.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SenselessVerifyRequest.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/bdturing/verify/request/SenselessVerifyRequest;", "Lcom/bytedance/bdturing/verify/request/AbstractRequest;", "type", "", "detail", "(Ljava/lang/String;Ljava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "setDetail", "(Ljava/lang/String;)V", "getType", "setType", "buildUrl", "", "queryBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEventLimits", "", "getServiceType", "getVerifyType", "isSyncMode", "", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SenselessVerifyRequest extends AbstractRequest {
    private String detail;
    private String type;

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public void buildUrl(StringBuilder queryBuilder) {
        Intrinsics.checkNotNullParameter(queryBuilder, "queryBuilder");
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public int getEventLimits() {
        return 6000;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getServiceType() {
        return "";
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public int getType() {
        return 18;
    }

    public SenselessVerifyRequest(String type, String detail) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(detail, "detail");
        this.type = type;
        this.detail = detail;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final String getType() {
        return this.type;
    }

    public final void setDetail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.detail = str;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getVerifyType() {
        return this.type;
    }

    public final boolean isSyncMode() {
        return Intrinsics.areEqual("nocaptcha", this.type);
    }
}
