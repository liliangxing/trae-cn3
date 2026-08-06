package com.bytedance.iesgurd.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestPolicyManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/iesgurd/request/RequestPolicyManager;", "Lcom/bytedance/iesgurd/request/RequestPolicy;", "()V", "exceptionRequestPolicy", "Lcom/bytedance/iesgurd/request/ExceptionRequestPolicy;", "getExceptionRequestPolicy", "()Lcom/bytedance/iesgurd/request/ExceptionRequestPolicy;", "setExceptionRequestPolicy", "(Lcom/bytedance/iesgurd/request/ExceptionRequestPolicy;)V", "retryRequestPolicy", "Lcom/bytedance/iesgurd/request/RetryRequestPolicy;", "getRetryRequestPolicy", "()Lcom/bytedance/iesgurd/request/RetryRequestPolicy;", "setRetryRequestPolicy", "(Lcom/bytedance/iesgurd/request/RetryRequestPolicy;)V", "throttleRequestPolicy", "Lcom/bytedance/iesgurd/request/ThrottleRequestPolicy;", "getThrottleRequestPolicy", "()Lcom/bytedance/iesgurd/request/ThrottleRequestPolicy;", "setThrottleRequestPolicy", "(Lcom/bytedance/iesgurd/request/ThrottleRequestPolicy;)V", "prepareRequest", "", "requestFail", "requestSuccess", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RequestPolicyManager implements RequestPolicy {
    private ExceptionRequestPolicy exceptionRequestPolicy;
    private RetryRequestPolicy retryRequestPolicy;
    private ThrottleRequestPolicy throttleRequestPolicy;

    public final ThrottleRequestPolicy getThrottleRequestPolicy() {
        return this.throttleRequestPolicy;
    }

    public final void setThrottleRequestPolicy(ThrottleRequestPolicy throttleRequestPolicy) {
        this.throttleRequestPolicy = throttleRequestPolicy;
    }

    public final ExceptionRequestPolicy getExceptionRequestPolicy() {
        return this.exceptionRequestPolicy;
    }

    public final void setExceptionRequestPolicy(ExceptionRequestPolicy exceptionRequestPolicy) {
        this.exceptionRequestPolicy = exceptionRequestPolicy;
    }

    public final RetryRequestPolicy getRetryRequestPolicy() {
        return this.retryRequestPolicy;
    }

    public final void setRetryRequestPolicy(RetryRequestPolicy retryRequestPolicy) {
        this.retryRequestPolicy = retryRequestPolicy;
    }

    @Override // com.bytedance.iesgurd.request.RequestPolicy
    public void prepareRequest() throws Exception {
        ThrottleRequestPolicy throttleRequestPolicy = this.throttleRequestPolicy;
        if (throttleRequestPolicy != null) {
            if (throttleRequestPolicy == null) {
                Intrinsics.throwNpe();
            }
            throttleRequestPolicy.prepareRequest();
        }
        RetryRequestPolicy retryRequestPolicy = this.retryRequestPolicy;
        if (retryRequestPolicy != null) {
            if (retryRequestPolicy == null) {
                Intrinsics.throwNpe();
            }
            retryRequestPolicy.prepareRequest();
        }
        ExceptionRequestPolicy exceptionRequestPolicy = this.exceptionRequestPolicy;
        if (exceptionRequestPolicy != null) {
            if (exceptionRequestPolicy == null) {
                Intrinsics.throwNpe();
            }
            exceptionRequestPolicy.prepareRequest();
        }
    }

    @Override // com.bytedance.iesgurd.request.RequestPolicy
    public void requestSuccess() {
        ThrottleRequestPolicy throttleRequestPolicy = this.throttleRequestPolicy;
        if (throttleRequestPolicy != null) {
            if (throttleRequestPolicy == null) {
                Intrinsics.throwNpe();
            }
            throttleRequestPolicy.requestSuccess();
        }
        RetryRequestPolicy retryRequestPolicy = this.retryRequestPolicy;
        if (retryRequestPolicy != null) {
            if (retryRequestPolicy == null) {
                Intrinsics.throwNpe();
            }
            retryRequestPolicy.requestSuccess();
        }
        ExceptionRequestPolicy exceptionRequestPolicy = this.exceptionRequestPolicy;
        if (exceptionRequestPolicy != null) {
            if (exceptionRequestPolicy == null) {
                Intrinsics.throwNpe();
            }
            exceptionRequestPolicy.requestSuccess();
        }
    }

    @Override // com.bytedance.iesgurd.request.RequestPolicy
    public void requestFail() {
        ThrottleRequestPolicy throttleRequestPolicy = this.throttleRequestPolicy;
        if (throttleRequestPolicy != null) {
            if (throttleRequestPolicy == null) {
                Intrinsics.throwNpe();
            }
            throttleRequestPolicy.requestFail();
        }
        ExceptionRequestPolicy exceptionRequestPolicy = this.exceptionRequestPolicy;
        if (exceptionRequestPolicy != null) {
            if (exceptionRequestPolicy == null) {
                Intrinsics.throwNpe();
            }
            exceptionRequestPolicy.requestFail();
        }
        RetryRequestPolicy retryRequestPolicy = this.retryRequestPolicy;
        if (retryRequestPolicy != null) {
            if (retryRequestPolicy == null) {
                Intrinsics.throwNpe();
            }
            retryRequestPolicy.requestFail();
        }
    }
}
