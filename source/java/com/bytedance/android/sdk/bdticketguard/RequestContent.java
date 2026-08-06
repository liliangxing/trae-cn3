package com.bytedance.android.sdk.bdticketguard;

import android.util.Pair;
import com.bytedance.android.sdk.bdticketguard.RequestParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B3\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR%\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/RequestContent;", "P", "Lcom/bytedance/android/sdk/bdticketguard/RequestParam;", "", "requestParam", "headers", "", "Landroid/util/Pair;", "", "timing", "", "(Lcom/bytedance/android/sdk/bdticketguard/RequestParam;Ljava/util/List;J)V", "getHeaders", "()Ljava/util/List;", "getRequestParam", "()Lcom/bytedance/android/sdk/bdticketguard/RequestParam;", "Lcom/bytedance/android/sdk/bdticketguard/RequestParam;", "getTiming", "()J", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public class RequestContent<P extends RequestParam> {
    private final List<Pair<String, String>> headers;
    private final P requestParam;
    private final long timing;

    /* JADX WARN: Multi-variable type inference failed */
    public RequestContent(P requestParam, List<? extends Pair<String, String>> list, long j) {
        Intrinsics.checkParameterIsNotNull(requestParam, "requestParam");
        this.requestParam = requestParam;
        this.headers = list;
        this.timing = j;
    }

    public /* synthetic */ RequestContent(RequestParam requestParam, List list, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(requestParam, list, (i & 4) != 0 ? System.currentTimeMillis() : j);
    }

    public final List<Pair<String, String>> getHeaders() {
        return this.headers;
    }

    public final P getRequestParam() {
        return this.requestParam;
    }

    public final long getTiming() {
        return this.timing;
    }
}
