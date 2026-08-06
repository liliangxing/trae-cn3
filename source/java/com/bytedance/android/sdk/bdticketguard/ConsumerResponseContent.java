package com.bytedance.android.sdk.bdticketguard;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApiConsumer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/ConsumerResponseContent;", "Lcom/bytedance/android/sdk/bdticketguard/ResponseContent;", "Lcom/bytedance/android/sdk/bdticketguard/HandleConsumerResponseParam;", "handleConsumerResponseParam", "logid", "", "remoteError", "(Lcom/bytedance/android/sdk/bdticketguard/HandleConsumerResponseParam;Ljava/lang/String;Ljava/lang/String;)V", "getRemoteError", "()Ljava/lang/String;", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ConsumerResponseContent extends ResponseContent<HandleConsumerResponseParam> {
    private final String remoteError;

    public final String getRemoteError() {
        return this.remoteError;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerResponseContent(HandleConsumerResponseParam handleConsumerResponseParam, String str, String str2) {
        super(handleConsumerResponseParam, str, 0L, 4, null);
        Intrinsics.checkParameterIsNotNull(handleConsumerResponseParam, "handleConsumerResponseParam");
        Intrinsics.checkParameterIsNotNull(str, "logid");
        Intrinsics.checkParameterIsNotNull(str2, "remoteError");
        this.remoteError = str2;
    }
}
