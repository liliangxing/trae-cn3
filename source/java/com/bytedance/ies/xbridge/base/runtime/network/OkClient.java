package com.bytedance.ies.xbridge.base.runtime.network;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.tnc.TNCManager;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: OkClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/network/OkClient;", "Lcom/bytedance/retrofit2/client/Client$Provider;", "()V", PrefetchRequestConfig.METHOD_GET, "Lcom/bytedance/retrofit2/client/Client;", "OkRetrofitClient", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class OkClient implements Client.Provider {
    @Override // com.bytedance.retrofit2.client.Client.Provider
    public Client get() {
        return new OkRetrofitClient();
    }

    /* compiled from: OkClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/network/OkClient$OkRetrofitClient;", "Lcom/bytedance/retrofit2/client/Client;", "()V", "newSsCall", "Lcom/bytedance/retrofit2/client/SsCall;", "request", "Lcom/bytedance/retrofit2/client/Request;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class OkRetrofitClient implements Client {
        @Override // com.bytedance.retrofit2.client.Client
        public SsCall newSsCall(Request request) throws IOException {
            Context context = TTNetInit.getTTNetDepend().getContext();
            SsOkHttp3Client inst = SsOkHttp3Client.inst(context);
            if (ProcessUtils.isMainProcess(context)) {
                inst.setOk3TncBridge(TNCManager.getInstance());
            }
            return inst.newSsCall(request);
        }
    }
}
