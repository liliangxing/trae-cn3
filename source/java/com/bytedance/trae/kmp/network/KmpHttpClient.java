package com.bytedance.trae.kmp.network;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlinx.serialization.DeserializationStrategy;

/* compiled from: KmpHttpClient.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001Jn\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000fH¦@¢\u0006\u0002\u0010\u0010Jj\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000fH¦@¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpHttpClient;", "", "getResult", "Lcom/bytedance/trae/kmp/network/KmpHttpResult;", "T", "hostType", "Lcom/bytedance/trae/kmp/network/KmpHostType;", "path", "", "headers", "", "queries", "options", "Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lcom/bytedance/trae/kmp/network/KmpHostType;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;Lkotlinx/serialization/DeserializationStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postResult", "body", "contentType", "(Lcom/bytedance/trae/kmp/network/KmpHostType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;Lkotlinx/serialization/DeserializationStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface KmpHttpClient {
    <T> Object getResult(KmpHostType kmpHostType, String str, Map<String, String> map, Map<String, String> map2, KmpHttpRequestOptions kmpHttpRequestOptions, DeserializationStrategy<? extends T> deserializationStrategy, Continuation<? super KmpHttpResult<T>> continuation);

    <T> Object postResult(KmpHostType kmpHostType, String str, String str2, String str3, Map<String, String> map, KmpHttpRequestOptions kmpHttpRequestOptions, DeserializationStrategy<? extends T> deserializationStrategy, Continuation<? super KmpHttpResult<T>> continuation);

    /* compiled from: KmpHttpClient.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getResult$default(KmpHttpClient kmpHttpClient, KmpHostType kmpHostType, String str, Map map, Map map2, KmpHttpRequestOptions kmpHttpRequestOptions, DeserializationStrategy deserializationStrategy, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                return kmpHttpClient.getResult(kmpHostType, str, (i & 4) != 0 ? MapsKt.emptyMap() : map, (i & 8) != 0 ? MapsKt.emptyMap() : map2, (i & 16) != 0 ? new KmpHttpRequestOptions(null, false, false, false, null, kmpHostType, 31, null) : kmpHttpRequestOptions, deserializationStrategy, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getResult");
        }

        public static /* synthetic */ Object postResult$default(KmpHttpClient kmpHttpClient, KmpHostType kmpHostType, String str, String str2, String str3, Map map, KmpHttpRequestOptions kmpHttpRequestOptions, DeserializationStrategy deserializationStrategy, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                return kmpHttpClient.postResult(kmpHostType, str, str2, (i & 8) != 0 ? "application/json; charset=UTF-8" : str3, (i & 16) != 0 ? MapsKt.emptyMap() : map, (i & 32) != 0 ? new KmpHttpRequestOptions(null, false, false, false, null, kmpHostType, 31, null) : kmpHttpRequestOptions, deserializationStrategy, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postResult");
        }
    }
}
