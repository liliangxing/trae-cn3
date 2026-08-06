package com.bytedance.ies.xbridge.base.runtime.network;

import com.bytedance.retrofit2.client.Client;
import com.bytedance.ttnet.retrofit.SsRetrofitClient;
import kotlin.Metadata;

/* compiled from: TTNetClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/network/TTNetClient;", "Lcom/bytedance/retrofit2/client/Client$Provider;", "()V", "get", "Lcom/bytedance/retrofit2/client/Client;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class TTNetClient implements Client.Provider {
    @Override // com.bytedance.retrofit2.client.Client.Provider
    public Client get() {
        return new SsRetrofitClient();
    }
}
