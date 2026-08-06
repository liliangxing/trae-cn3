package com.bytedance.android.sdk.bdticketguard;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: TicketGuardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/INetwork;", "", "executePost", "Lcom/bytedance/android/sdk/bdticketguard/TTResponse;", "maxLength", "", "url", "", "postParams", "", "headers", "", "Lcom/bytedance/android/sdk/bdticketguard/TTHeader;", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public interface INetwork {
    TTResponse executePost(int maxLength, String url, Map<String, String> postParams, List<TTHeader> headers) throws Exception;
}
