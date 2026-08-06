package com.bytedance.android.sdk.bdticketguard;

import android.util.Pair;
import com.bytedance.android.sdk.bdticketguard.RequestContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B1\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/ResponseParam;", "C", "Lcom/bytedance/android/sdk/bdticketguard/RequestContent;", "", "requestContent", "responseHeaders", "", "Landroid/util/Pair;", "", "timing", "", "(Lcom/bytedance/android/sdk/bdticketguard/RequestContent;Ljava/util/List;J)V", "getRequestContent", "()Lcom/bytedance/android/sdk/bdticketguard/RequestContent;", "Lcom/bytedance/android/sdk/bdticketguard/RequestContent;", "getResponseHeaders", "()Ljava/util/List;", "getTiming", "()J", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public class ResponseParam<C extends RequestContent<?>> {
    private final C requestContent;
    private final List<Pair<String, String>> responseHeaders;
    private final long timing;

    /* JADX WARN: Multi-variable type inference failed */
    public ResponseParam(C requestContent, List<? extends Pair<String, String>> responseHeaders, long j) {
        Intrinsics.checkParameterIsNotNull(requestContent, "requestContent");
        Intrinsics.checkParameterIsNotNull(responseHeaders, "responseHeaders");
        this.requestContent = requestContent;
        this.responseHeaders = responseHeaders;
        this.timing = j;
    }

    public /* synthetic */ ResponseParam(RequestContent requestContent, List list, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(requestContent, list, (i & 4) != 0 ? System.currentTimeMillis() : j);
    }

    public final C getRequestContent() {
        return this.requestContent;
    }

    public final List<Pair<String, String>> getResponseHeaders() {
        return this.responseHeaders;
    }

    public final long getTiming() {
        return this.timing;
    }
}
