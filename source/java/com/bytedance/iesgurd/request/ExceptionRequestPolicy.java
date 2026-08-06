package com.bytedance.iesgurd.request;

import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.exception.ExceptionWithCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionRequestPolicy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/iesgurd/request/ExceptionRequestPolicy;", "Lcom/bytedance/iesgurd/request/RequestPolicy;", "mRequestType", "Lcom/bytedance/iesgurd/core/ReqType;", "(Lcom/bytedance/iesgurd/core/ReqType;)V", "isInterceptRequest", "", "prepareRequest", "", "requestFail", "requestSuccess", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final class ExceptionRequestPolicy implements RequestPolicy {
    private static final int CHECK_UPDATE_FAIL_INTERVAL = 60000;
    private static final int CHECK_UPDATE_FAIL_MAX_COUNT = 3;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int requestFailCount;
    private static long requestFailCountTime;
    private static long requestFailInterceptTime;
    private boolean isInterceptRequest;
    private final ReqType mRequestType;

    public ExceptionRequestPolicy(ReqType mRequestType) {
        Intrinsics.checkParameterIsNotNull(mRequestType, "mRequestType");
        this.mRequestType = mRequestType;
    }

    @Override // com.bytedance.iesgurd.request.RequestPolicy
    public synchronized void prepareRequest() throws Exception {
        long j = 60000;
        if (System.currentTimeMillis() - requestFailCountTime > j) {
            requestFailCount = 0;
        }
        if (requestFailCount == 3 && this.mRequestType == ReqType.NORMAL) {
            this.isInterceptRequest = true;
            requestFailInterceptTime = System.currentTimeMillis();
        } else {
            this.isInterceptRequest = false;
        }
        if (this.isInterceptRequest && System.currentTimeMillis() - requestFailInterceptTime <= j) {
            throw new ExceptionWithCode(601, "gecko update request failed more than 3 times");
        }
        this.isInterceptRequest = false;
    }

    @Override // com.bytedance.iesgurd.request.RequestPolicy
    public synchronized void requestSuccess() {
        requestFailCount = 0;
    }

    @Override // com.bytedance.iesgurd.request.RequestPolicy
    public synchronized void requestFail() {
        requestFailCount++;
        requestFailCountTime = System.currentTimeMillis();
    }

    /* compiled from: ExceptionRequestPolicy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/iesgurd/request/ExceptionRequestPolicy$Companion;", "", "()V", "CHECK_UPDATE_FAIL_INTERVAL", "", "CHECK_UPDATE_FAIL_MAX_COUNT", "requestFailCount", "requestFailCountTime", "", "requestFailInterceptTime", "resetForTest", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void resetForTest() {
            ExceptionRequestPolicy.requestFailCount = 0;
            ExceptionRequestPolicy.requestFailCountTime = 0L;
            ExceptionRequestPolicy.requestFailInterceptTime = 0L;
        }
    }
}
