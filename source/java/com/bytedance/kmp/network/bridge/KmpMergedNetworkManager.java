package com.bytedance.kmp.network.bridge;

import com.bytedance.kmp.spi.KmpServiceManager;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: KmpMergedNetworkManager.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0006\b\u0000\u0010\u000b\u0018\u0001\"\u0006\b\u0001\u0010\n\u0018\u00012\u0006\u0010\f\u001a\u00020\rH\u0086H¢\u0006\u0002\u0010\u000eJ.\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u0010\"\u0006\b\u0000\u0010\u000b\u0018\u0001\"\u0006\b\u0001\u0010\n\u0018\u00012\u0006\u0010\f\u001a\u00020\rH\u0086H¢\u0006\u0002\u0010\u000eR\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/kmp/network/bridge/KmpMergedNetworkManager;", "", "()V", "bridge", "Lcom/bytedance/kmp/network/bridge/IKmpNetworkBridge;", "getBridge", "()Lcom/bytedance/kmp/network/bridge/IKmpNetworkBridge;", "bridge$delegate", "Lkotlin/Lazy;", "executeForBody", "RespBody", "RespDTO", "request", "Lcom/bytedance/kmp/network/bridge/KmpRequest;", "(Lcom/bytedance/kmp/network/bridge/KmpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeForResponse", "Lcom/bytedance/kmp/network/bridge/KmpResponse;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpMergedNetworkManager {
    public static final KmpMergedNetworkManager INSTANCE = new KmpMergedNetworkManager();

    /* renamed from: bridge$delegate, reason: from kotlin metadata */
    private static final Lazy bridge = LazyKt.lazy(new Function0<IKmpNetworkBridge>() { // from class: com.bytedance.kmp.network.bridge.KmpMergedNetworkManager$bridge$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final IKmpNetworkBridge m680invoke() {
            return (IKmpNetworkBridge) KmpServiceManager.INSTANCE.get(Reflection.getOrCreateKotlinClass(IKmpNetworkBridge.class));
        }
    });

    private KmpMergedNetworkManager() {
    }

    public final IKmpNetworkBridge getBridge() {
        return (IKmpNetworkBridge) bridge.getValue();
    }

    public final /* synthetic */ <RespDTO, RespBody> Object executeForResponse(KmpRequest kmpRequest, Continuation<? super KmpResponse<RespBody>> continuation) {
        IKmpNetworkBridge bridge2;
        Intrinsics.needClassReification();
        Type type = new TypeToken<RespBody>() { // from class: com.bytedance.kmp.network.bridge.KmpMergedNetworkManager$executeForResponse$type$1
        }.getType();
        String host = kmpRequest.getHost();
        if ((host.length() == 0) && ((bridge2 = getBridge()) == null || (host = bridge2.getDefaultHost()) == null)) {
            host = "";
        }
        IKmpNetworkBridge bridge3 = getBridge();
        if (bridge3 == null) {
            return null;
        }
        String path = kmpRequest.getPath();
        String method = kmpRequest.getMethod();
        Map<String, String> headers = kmpRequest.getHeaders();
        Map<String, String> queries = kmpRequest.getQueries();
        KmpRequestBody body = kmpRequest.getBody();
        Object body2 = body != null ? body.getBody() : null;
        Intrinsics.checkNotNullExpressionValue(type, "type");
        KmpRequestConfig reqConfig = kmpRequest.getReqConfig();
        InlineMarker.mark(0);
        Object executeForKmpResponse = bridge3.executeForKmpResponse(host, path, method, headers, queries, body2, type, reqConfig, continuation);
        InlineMarker.mark(1);
        return (KmpResponse) executeForKmpResponse;
    }

    public final /* synthetic */ <RespDTO, RespBody> Object executeForBody(KmpRequest kmpRequest, Continuation<? super RespBody> continuation) {
        KmpResponse kmpResponse;
        IKmpNetworkBridge bridge2;
        Intrinsics.needClassReification();
        Type type = new TypeToken<RespBody>() { // from class: com.bytedance.kmp.network.bridge.KmpMergedNetworkManager$executeForBody$$inlined$executeForResponse$1
        }.getType();
        String host = kmpRequest.getHost();
        if ((host.length() == 0) && ((bridge2 = getBridge()) == null || (host = bridge2.getDefaultHost()) == null)) {
            host = "";
        }
        IKmpNetworkBridge bridge3 = getBridge();
        if (bridge3 != null) {
            String path = kmpRequest.getPath();
            String method = kmpRequest.getMethod();
            Map<String, String> headers = kmpRequest.getHeaders();
            Map<String, String> queries = kmpRequest.getQueries();
            KmpRequestBody body = kmpRequest.getBody();
            Object body2 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = kmpRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge3.executeForKmpResponse(host, path, method, headers, queries, body2, type, reqConfig, continuation);
            InlineMarker.mark(1);
            kmpResponse = (KmpResponse) executeForKmpResponse;
        } else {
            kmpResponse = null;
        }
        if (kmpResponse != null) {
            return kmpResponse.getBody();
        }
        return null;
    }
}
