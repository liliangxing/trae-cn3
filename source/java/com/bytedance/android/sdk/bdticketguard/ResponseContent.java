package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.android.sdk.bdticketguard.ResponseParam;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/ResponseContent;", "P", "Lcom/bytedance/android/sdk/bdticketguard/ResponseParam;", "", "responseParam", "logid", "", "timing", "", "(Lcom/bytedance/android/sdk/bdticketguard/ResponseParam;Ljava/lang/String;J)V", "getLogid", "()Ljava/lang/String;", "getResponseParam", "()Lcom/bytedance/android/sdk/bdticketguard/ResponseParam;", "Lcom/bytedance/android/sdk/bdticketguard/ResponseParam;", "getTiming", "()J", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public class ResponseContent<P extends ResponseParam<?>> {
    private final String logid;
    private final P responseParam;
    private final long timing;

    public ResponseContent(P responseParam, String logid, long j) {
        Intrinsics.checkParameterIsNotNull(responseParam, "responseParam");
        Intrinsics.checkParameterIsNotNull(logid, "logid");
        this.responseParam = responseParam;
        this.logid = logid;
        this.timing = j;
    }

    public /* synthetic */ ResponseContent(ResponseParam responseParam, String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(responseParam, str, (i & 4) != 0 ? System.currentTimeMillis() : j);
    }

    public final String getLogid() {
        return this.logid;
    }

    public final P getResponseParam() {
        return this.responseParam;
    }

    public final long getTiming() {
        return this.timing;
    }
}
