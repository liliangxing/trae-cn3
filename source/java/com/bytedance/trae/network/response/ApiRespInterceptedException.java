package com.bytedance.trae.network.response;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ApiRespInterceptedException.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/network/response/ApiRespInterceptedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "e", "", "<init>", "(Ljava/lang/Throwable;)V", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApiRespInterceptedException extends RuntimeException {
    /* JADX WARN: Multi-variable type inference failed */
    public ApiRespInterceptedException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ApiRespInterceptedException(Throwable th) {
        super(th);
    }

    public /* synthetic */ ApiRespInterceptedException(Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : th);
    }
}
