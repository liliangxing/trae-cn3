package com.bytedance.kmp.network;

import com.bytedance.kmp.network.nqe.NQEListener;
import com.bytedance.kmp.network.nqe.NetworkQualityState;
import com.bytedance.kmp.network.requet.Request;
import com.bytedance.kmp.network.response.Response;
import com.bytedance.kmp.network.response.ResponseCallback;
import com.bytedance.kmp.spi.IKmpService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: IKmpNetworkService.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0016"}, d2 = {"Lcom/bytedance/kmp/network/IKmpNetworkService;", "Lcom/bytedance/kmp/spi/IKmpService;", "cancel", "", "request", "Lcom/bytedance/kmp/network/requet/Request;", "execute", "Lcom/bytedance/kmp/network/response/Response;", "(Lcom/bytedance/kmp/network/requet/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeStream", "callback", "Lcom/bytedance/kmp/network/response/ResponseCallback;", "(Lcom/bytedance/kmp/network/requet/Request;Lcom/bytedance/kmp/network/response/ResponseCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNetworkQualityState", "Lcom/bytedance/kmp/network/nqe/NetworkQualityState;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preConnect", "url", "", "registerNQEListener", "listener", "Lcom/bytedance/kmp/network/nqe/NQEListener;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IKmpNetworkService extends IKmpService {
    void cancel(Request request);

    Object execute(Request request, Continuation<? super Response> continuation);

    Object executeStream(Request request, ResponseCallback responseCallback, Continuation<? super Unit> continuation);

    Object getNetworkQualityState(Continuation<? super NetworkQualityState> continuation);

    void preConnect(String url);

    void registerNQEListener(NQEListener listener);
}
