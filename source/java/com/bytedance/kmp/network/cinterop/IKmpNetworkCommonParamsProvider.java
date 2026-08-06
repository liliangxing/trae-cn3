package com.bytedance.kmp.network.cinterop;

import com.bytedance.kmp.spi.IKmpService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: IKmpNetworkCommonParamsProvider.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0002\u0010\u0006J \u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/kmp/network/cinterop/IKmpNetworkCommonParamsProvider;", "Lcom/bytedance/kmp/spi/IKmpService;", "getCommonHeaders", "", "", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCommonParams", "getCommonParamsWithCacheVersion", "Lcom/bytedance/kmp/network/cinterop/KmpCommonParamsResult;", "version", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IKmpNetworkCommonParamsProvider extends IKmpService {
    Object getCommonHeaders(String str, Continuation<? super Map<String, String>> continuation);

    Object getCommonParams(String str, Continuation<? super Map<String, String>> continuation);

    Object getCommonParamsWithCacheVersion(String str, int i, Continuation<? super KmpCommonParamsResult> continuation);
}
