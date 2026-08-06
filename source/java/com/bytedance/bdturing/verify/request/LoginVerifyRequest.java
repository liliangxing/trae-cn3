package com.bytedance.bdturing.verify.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginVerifyRequest.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/bdturing/verify/request/LoginVerifyRequest;", "Lcom/bytedance/bdturing/verify/request/AbstractRequest;", "toastContent", "", "(Ljava/lang/String;)V", "getToastContent", "()Ljava/lang/String;", "buildUrl", "", "queryBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEventLimits", "", "getServiceType", "getType", "getVerifyType", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LoginVerifyRequest extends AbstractRequest {
    private final String toastContent;

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
        return 15;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getVerifyType() {
        return "login";
    }

    public final String getToastContent() {
        return this.toastContent;
    }

    public LoginVerifyRequest(String toastContent) {
        Intrinsics.checkNotNullParameter(toastContent, "toastContent");
        this.toastContent = toastContent;
    }
}
