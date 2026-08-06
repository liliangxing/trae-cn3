package com.bytedance.android.sdk.bdticketguard;

import android.util.Pair;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApiProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0002\u0010\tR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/ProviderRequestContent;", "Lcom/bytedance/android/sdk/bdticketguard/RequestContent;", "Lcom/bytedance/android/sdk/bdticketguard/ProviderRequestParam;", "requestCert", "", "headers", "", "Landroid/util/Pair;", "providerRequestParam", "(Ljava/lang/String;Ljava/util/List;Lcom/bytedance/android/sdk/bdticketguard/ProviderRequestParam;)V", "getRequestCert", "()Ljava/lang/String;", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ProviderRequestContent extends RequestContent<ProviderRequestParam> {
    private final String requestCert;

    public final String getRequestCert() {
        return this.requestCert;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProviderRequestContent(String str, List<? extends Pair<String, String>> list, ProviderRequestParam providerRequestParam) {
        super(providerRequestParam, list, 0L, 4, null);
        Intrinsics.checkParameterIsNotNull(providerRequestParam, "providerRequestParam");
        this.requestCert = str;
    }
}
