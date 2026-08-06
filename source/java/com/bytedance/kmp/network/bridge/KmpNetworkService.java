package com.bytedance.kmp.network.bridge;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpMergedNetworkManager.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jb\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0082\u0001\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\u0006\b\u0000\u0010\u0013\u0018\u0001\"\u0006\b\u0001\u0010\u0014\u0018\u0001\"\u0006\b\u0002\u0010\u0012\u0018\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u0002H\u00132\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086H¢\u0006\u0002\u0010\u0015Jz\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0012\u0018\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086H¢\u0006\u0002\u0010\u0016J\u0086\u0001\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0012\u0018\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086H¢\u0006\u0002\u0010\u0017J.\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\u0019\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0012\u0018\u00012\u0006\u0010\u001a\u001a\u00020\u0004H\u0086H¢\u0006\u0002\u0010\u001bJ\u0088\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\u0019\"\u0006\b\u0000\u0010\u0013\u0018\u0001\"\u0006\b\u0001\u0010\u0014\u0018\u0001\"\u0006\b\u0002\u0010\u0012\u0018\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u0002H\u00132\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086H¢\u0006\u0002\u0010\u0015J\u0080\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\u0019\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0012\u0018\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086H¢\u0006\u0002\u0010\u0016J\u008c\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\u0019\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0006\b\u0001\u0010\u0012\u0018\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086H¢\u0006\u0002\u0010\u0017Jb\u0010\u001c\u001a\u0004\u0018\u0001H\u0014\"\u0006\b\u0000\u0010\u0014\u0018\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086H¢\u0006\u0002\u0010\u001dJh\u0010\u001e\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u0019\"\u0006\b\u0000\u0010\u0014\u0018\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086H¢\u0006\u0002\u0010\u001dJz\u0010\u001f\u001a\u0004\u0018\u0001H\u0014\"\u0006\b\u0000\u0010 \u0018\u0001\"\u0006\b\u0001\u0010\u0014\u0018\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u0002H 2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086H¢\u0006\u0002\u0010\u0015J\u0080\u0001\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u0019\"\u0006\b\u0000\u0010 \u0018\u0001\"\u0006\b\u0001\u0010\u0014\u0018\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u0002H 2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086H¢\u0006\u0002\u0010\u0015¨\u0006\""}, d2 = {"Lcom/bytedance/kmp/network/bridge/KmpNetworkService;", "", "()V", "buildRequest", "Lcom/bytedance/kmp/network/bridge/KmpRequest;", "host", "", "path", "method", "Lcom/bytedance/kmp/network/bridge/KmpRequestMethod;", "headers", "", "queries", "body", "Lcom/bytedance/kmp/network/bridge/KmpRequestBody;", "config", "Lcom/bytedance/kmp/network/bridge/KmpRequestConfig;", "requestForBody", "RespBody", "ReqBody", "RespDTO", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/kmp/network/bridge/KmpRequestMethod;Ljava/lang/Object;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/bridge/KmpRequestConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/kmp/network/bridge/KmpRequestMethod;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/bridge/KmpRequestConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/kmp/network/bridge/KmpRequestMethod;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/bridge/KmpRequestConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestForResponse", "Lcom/bytedance/kmp/network/bridge/KmpResponse;", "request", "(Lcom/bytedance/kmp/network/bridge/KmpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "simpleGetForBody", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/bridge/KmpRequestConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "simpleGetForResponse", "simpleRequestForBody", "ReqDTO", "simpleRequestForResponse", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNetworkService {
    public static final KmpNetworkService INSTANCE = new KmpNetworkService();

    private KmpNetworkService() {
    }

    public static /* synthetic */ Object simpleGetForBody$default(KmpNetworkService kmpNetworkService, String str, String str2, Map map, Map map2, KmpRequestConfig kmpRequestConfig, Continuation continuation, int i, Object obj) {
        String str3;
        KmpResponse kmpResponse;
        String defaultHost;
        String str4 = "";
        KmpRequest buildRequest = kmpNetworkService.buildRequest((i & 1) != 0 ? "" : str, str2, KmpRequestMethod.GET, (i & 4) != 0 ? MapsKt.emptyMap() : map, (i & 8) != 0 ? MapsKt.emptyMap() : map2, null, (i & 16) != 0 ? null : kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new KmpNetworkService$simpleGetForBody$$inlined$executeForBody$1().getType();
        String host = buildRequest.getHost();
        if (host.length() == 0) {
            IKmpNetworkBridge bridge = kmpMergedNetworkManager.getBridge();
            if (bridge != null && (defaultHost = bridge.getDefaultHost()) != null) {
                str4 = defaultHost;
            }
            str3 = str4;
        } else {
            str3 = host;
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            Object body2 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(str3, path, method, headers, queries, body2, type, reqConfig, continuation);
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

    public final /* synthetic */ <RespDTO> Object simpleGetForBody(String str, String str2, Map<String, String> map, Map<String, String> map2, KmpRequestConfig kmpRequestConfig, Continuation<? super RespDTO> continuation) {
        KmpResponse kmpResponse;
        IKmpNetworkBridge bridge;
        KmpRequest buildRequest = buildRequest(str, str2, KmpRequestMethod.GET, map, map2, null, kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new KmpNetworkService$simpleGetForBody$$inlined$executeForBody$1().getType();
        String host = buildRequest.getHost();
        if ((host.length() == 0) && ((bridge = kmpMergedNetworkManager.getBridge()) == null || (host = bridge.getDefaultHost()) == null)) {
            host = "";
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            Object body2 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(host, path, method, headers, queries, body2, type, reqConfig, continuation);
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

    public static /* synthetic */ Object simpleGetForResponse$default(KmpNetworkService kmpNetworkService, String str, String str2, Map map, Map map2, KmpRequestConfig kmpRequestConfig, Continuation continuation, int i, Object obj) {
        String str3;
        String defaultHost;
        String str4 = "";
        KmpRequest buildRequest = kmpNetworkService.buildRequest((i & 1) != 0 ? "" : str, str2, KmpRequestMethod.GET, (i & 4) != 0 ? MapsKt.emptyMap() : map, (i & 8) != 0 ? MapsKt.emptyMap() : map2, null, (i & 16) != 0 ? null : kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new C0195x618947b0().getType();
        String host = buildRequest.getHost();
        if (host.length() == 0) {
            IKmpNetworkBridge bridge = kmpMergedNetworkManager.getBridge();
            if (bridge != null && (defaultHost = bridge.getDefaultHost()) != null) {
                str4 = defaultHost;
            }
            str3 = str4;
        } else {
            str3 = host;
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            r10 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(str3, path, method, headers, queries, r10, type, reqConfig, continuation);
            InlineMarker.mark(1);
            r10 = (KmpResponse) executeForKmpResponse;
        }
        return r10;
    }

    public final /* synthetic */ <RespDTO> Object simpleGetForResponse(String str, String str2, Map<String, String> map, Map<String, String> map2, KmpRequestConfig kmpRequestConfig, Continuation<? super KmpResponse<RespDTO>> continuation) {
        IKmpNetworkBridge bridge;
        KmpRequest buildRequest = buildRequest(str, str2, KmpRequestMethod.GET, map, map2, null, kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new C0195x618947b0().getType();
        String host = buildRequest.getHost();
        if ((host.length() == 0) && ((bridge = kmpMergedNetworkManager.getBridge()) == null || (host = bridge.getDefaultHost()) == null)) {
            host = "";
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            r1 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(host, path, method, headers, queries, r1, type, reqConfig, continuation);
            InlineMarker.mark(1);
            r1 = (KmpResponse) executeForKmpResponse;
        }
        return r1;
    }

    public static /* synthetic */ Object simpleRequestForBody$default(KmpNetworkService kmpNetworkService, String str, String str2, KmpRequestMethod kmpRequestMethod, Object obj, Map map, Map map2, KmpRequestConfig kmpRequestConfig, Continuation continuation, int i, Object obj2) {
        String str3;
        KmpResponse kmpResponse;
        String defaultHost;
        String str4 = "";
        KmpRequest buildRequest = kmpNetworkService.buildRequest((i & 1) != 0 ? "" : str, str2, kmpRequestMethod, (i & 16) != 0 ? MapsKt.emptyMap() : map, (i & 32) != 0 ? MapsKt.emptyMap() : map2, new KmpRequestBody(KmpRequestBodyType.BODY_OBJECT, obj), (i & 64) != 0 ? null : kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new KmpNetworkService$simpleRequestForBody$$inlined$executeForBody$1().getType();
        String host = buildRequest.getHost();
        if (host.length() == 0) {
            IKmpNetworkBridge bridge = kmpMergedNetworkManager.getBridge();
            if (bridge != null && (defaultHost = bridge.getDefaultHost()) != null) {
                str4 = defaultHost;
            }
            str3 = str4;
        } else {
            str3 = host;
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            Object body2 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(str3, path, method, headers, queries, body2, type, reqConfig, continuation);
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

    public final /* synthetic */ <ReqDTO, RespDTO> Object simpleRequestForBody(String str, String str2, KmpRequestMethod kmpRequestMethod, ReqDTO reqdto, Map<String, String> map, Map<String, String> map2, KmpRequestConfig kmpRequestConfig, Continuation<? super RespDTO> continuation) {
        KmpResponse kmpResponse;
        IKmpNetworkBridge bridge;
        KmpRequest buildRequest = buildRequest(str, str2, kmpRequestMethod, map, map2, new KmpRequestBody(KmpRequestBodyType.BODY_OBJECT, reqdto), kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new KmpNetworkService$simpleRequestForBody$$inlined$executeForBody$1().getType();
        String host = buildRequest.getHost();
        if ((host.length() == 0) && ((bridge = kmpMergedNetworkManager.getBridge()) == null || (host = bridge.getDefaultHost()) == null)) {
            host = "";
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            Object body2 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(host, path, method, headers, queries, body2, type, reqConfig, continuation);
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

    public static /* synthetic */ Object simpleRequestForResponse$default(KmpNetworkService kmpNetworkService, String str, String str2, KmpRequestMethod kmpRequestMethod, Object obj, Map map, Map map2, KmpRequestConfig kmpRequestConfig, Continuation continuation, int i, Object obj2) {
        String str3;
        String defaultHost;
        String str4 = "";
        KmpRequest buildRequest = kmpNetworkService.buildRequest((i & 1) != 0 ? "" : str, str2, kmpRequestMethod, (i & 16) != 0 ? MapsKt.emptyMap() : map, (i & 32) != 0 ? MapsKt.emptyMap() : map2, new KmpRequestBody(KmpRequestBodyType.BODY_OBJECT, obj), (i & 64) != 0 ? null : kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new C0196x35070017().getType();
        String host = buildRequest.getHost();
        if (host.length() == 0) {
            IKmpNetworkBridge bridge = kmpMergedNetworkManager.getBridge();
            if (bridge != null && (defaultHost = bridge.getDefaultHost()) != null) {
                str4 = defaultHost;
            }
            str3 = str4;
        } else {
            str3 = host;
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            r10 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(str3, path, method, headers, queries, r10, type, reqConfig, continuation);
            InlineMarker.mark(1);
            r10 = (KmpResponse) executeForKmpResponse;
        }
        return r10;
    }

    public final /* synthetic */ <ReqDTO, RespDTO> Object simpleRequestForResponse(String str, String str2, KmpRequestMethod kmpRequestMethod, ReqDTO reqdto, Map<String, String> map, Map<String, String> map2, KmpRequestConfig kmpRequestConfig, Continuation<? super KmpResponse<RespDTO>> continuation) {
        IKmpNetworkBridge bridge;
        KmpRequest buildRequest = buildRequest(str, str2, kmpRequestMethod, map, map2, new KmpRequestBody(KmpRequestBodyType.BODY_OBJECT, reqdto), kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new C0196x35070017().getType();
        String host = buildRequest.getHost();
        if ((host.length() == 0) && ((bridge = kmpMergedNetworkManager.getBridge()) == null || (host = bridge.getDefaultHost()) == null)) {
            host = "";
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            r1 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(host, path, method, headers, queries, r1, type, reqConfig, continuation);
            InlineMarker.mark(1);
            r1 = (KmpResponse) executeForKmpResponse;
        }
        return r1;
    }

    public static /* synthetic */ Object requestForBody$default(KmpNetworkService kmpNetworkService, String str, String str2, KmpRequestMethod kmpRequestMethod, String str3, Map map, Map map2, KmpRequestConfig kmpRequestConfig, Continuation continuation, int i, Object obj) {
        String str4;
        KmpResponse kmpResponse;
        String defaultHost;
        String str5 = "";
        KmpRequest buildRequest = kmpNetworkService.buildRequest((i & 1) != 0 ? "" : str, str2, kmpRequestMethod, (i & 16) != 0 ? MapsKt.emptyMap() : map, (i & 32) != 0 ? MapsKt.emptyMap() : map2, new KmpRequestBody(KmpRequestBodyType.BODY_STRING, str3), (i & 64) != 0 ? null : kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new KmpNetworkService$requestForBody$$inlined$executeForBody$1().getType();
        String host = buildRequest.getHost();
        if (host.length() == 0) {
            IKmpNetworkBridge bridge = kmpMergedNetworkManager.getBridge();
            if (bridge != null && (defaultHost = bridge.getDefaultHost()) != null) {
                str5 = defaultHost;
            }
            str4 = str5;
        } else {
            str4 = host;
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            Object body2 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(str4, path, method, headers, queries, body2, type, reqConfig, continuation);
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

    public final /* synthetic */ <RespDTO, RespBody> Object requestForBody(String str, String str2, KmpRequestMethod kmpRequestMethod, String str3, Map<String, String> map, Map<String, String> map2, KmpRequestConfig kmpRequestConfig, Continuation<? super RespBody> continuation) {
        KmpResponse kmpResponse;
        IKmpNetworkBridge bridge;
        KmpRequest buildRequest = buildRequest(str, str2, kmpRequestMethod, map, map2, new KmpRequestBody(KmpRequestBodyType.BODY_STRING, str3), kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new KmpNetworkService$requestForBody$$inlined$executeForBody$1().getType();
        String host = buildRequest.getHost();
        if ((host.length() == 0) && ((bridge = kmpMergedNetworkManager.getBridge()) == null || (host = bridge.getDefaultHost()) == null)) {
            host = "";
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            Object body2 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(host, path, method, headers, queries, body2, type, reqConfig, continuation);
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

    public static /* synthetic */ Object requestForBody$default(KmpNetworkService kmpNetworkService, String str, String str2, KmpRequestMethod kmpRequestMethod, Map map, Map map2, Map map3, KmpRequestConfig kmpRequestConfig, Continuation continuation, int i, Object obj) {
        String str3;
        KmpResponse kmpResponse;
        String defaultHost;
        String str4 = "";
        KmpRequest buildRequest = kmpNetworkService.buildRequest((i & 1) != 0 ? "" : str, str2, kmpRequestMethod, (i & 16) != 0 ? MapsKt.emptyMap() : map2, (i & 32) != 0 ? MapsKt.emptyMap() : map3, new KmpRequestBody(KmpRequestBodyType.BODY_STRING_MAP, map), (i & 64) != 0 ? null : kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new KmpNetworkService$requestForBody$$inlined$executeForBody$2().getType();
        String host = buildRequest.getHost();
        if (host.length() == 0) {
            IKmpNetworkBridge bridge = kmpMergedNetworkManager.getBridge();
            if (bridge != null && (defaultHost = bridge.getDefaultHost()) != null) {
                str4 = defaultHost;
            }
            str3 = str4;
        } else {
            str3 = host;
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            Object body2 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(str3, path, method, headers, queries, body2, type, reqConfig, continuation);
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

    public final /* synthetic */ <RespDTO, RespBody> Object requestForBody(String str, String str2, KmpRequestMethod kmpRequestMethod, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, KmpRequestConfig kmpRequestConfig, Continuation<? super RespBody> continuation) {
        KmpResponse kmpResponse;
        IKmpNetworkBridge bridge;
        KmpRequest buildRequest = buildRequest(str, str2, kmpRequestMethod, map2, map3, new KmpRequestBody(KmpRequestBodyType.BODY_STRING_MAP, map), kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new KmpNetworkService$requestForBody$$inlined$executeForBody$2().getType();
        String host = buildRequest.getHost();
        if ((host.length() == 0) && ((bridge = kmpMergedNetworkManager.getBridge()) == null || (host = bridge.getDefaultHost()) == null)) {
            host = "";
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            Object body2 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(host, path, method, headers, queries, body2, type, reqConfig, continuation);
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

    public static /* synthetic */ Object requestForBody$default(KmpNetworkService kmpNetworkService, String str, String str2, KmpRequestMethod kmpRequestMethod, Object obj, Map map, Map map2, KmpRequestConfig kmpRequestConfig, Continuation continuation, int i, Object obj2) {
        String str3;
        KmpResponse kmpResponse;
        String defaultHost;
        String str4 = "";
        KmpRequest buildRequest = kmpNetworkService.buildRequest((i & 1) != 0 ? "" : str, str2, kmpRequestMethod, (i & 16) != 0 ? MapsKt.emptyMap() : map, (i & 32) != 0 ? MapsKt.emptyMap() : map2, new KmpRequestBody(KmpRequestBodyType.BODY_OBJECT, obj), (i & 64) != 0 ? null : kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new KmpNetworkService$requestForBody$$inlined$executeForBody$3().getType();
        String host = buildRequest.getHost();
        if (host.length() == 0) {
            IKmpNetworkBridge bridge = kmpMergedNetworkManager.getBridge();
            if (bridge != null && (defaultHost = bridge.getDefaultHost()) != null) {
                str4 = defaultHost;
            }
            str3 = str4;
        } else {
            str3 = host;
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            Object body2 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(str3, path, method, headers, queries, body2, type, reqConfig, continuation);
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

    public final /* synthetic */ <ReqBody, RespDTO, RespBody> Object requestForBody(String str, String str2, KmpRequestMethod kmpRequestMethod, ReqBody reqbody, Map<String, String> map, Map<String, String> map2, KmpRequestConfig kmpRequestConfig, Continuation<? super RespBody> continuation) {
        KmpResponse kmpResponse;
        IKmpNetworkBridge bridge;
        KmpRequest buildRequest = buildRequest(str, str2, kmpRequestMethod, map, map2, new KmpRequestBody(KmpRequestBodyType.BODY_OBJECT, reqbody), kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new KmpNetworkService$requestForBody$$inlined$executeForBody$3().getType();
        String host = buildRequest.getHost();
        if ((host.length() == 0) && ((bridge = kmpMergedNetworkManager.getBridge()) == null || (host = bridge.getDefaultHost()) == null)) {
            host = "";
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            Object body2 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(host, path, method, headers, queries, body2, type, reqConfig, continuation);
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

    public static /* synthetic */ Object requestForResponse$default(KmpNetworkService kmpNetworkService, String str, String str2, KmpRequestMethod kmpRequestMethod, String str3, Map map, Map map2, KmpRequestConfig kmpRequestConfig, Continuation continuation, int i, Object obj) {
        String str4;
        String defaultHost;
        String str5 = "";
        KmpRequest buildRequest = kmpNetworkService.buildRequest((i & 1) != 0 ? "" : str, str2, kmpRequestMethod, (i & 16) != 0 ? MapsKt.emptyMap() : map, (i & 32) != 0 ? MapsKt.emptyMap() : map2, new KmpRequestBody(KmpRequestBodyType.BODY_STRING, str3), (i & 64) != 0 ? null : kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new C0191x5fe36d85().getType();
        String host = buildRequest.getHost();
        if (host.length() == 0) {
            IKmpNetworkBridge bridge = kmpMergedNetworkManager.getBridge();
            if (bridge != null && (defaultHost = bridge.getDefaultHost()) != null) {
                str5 = defaultHost;
            }
            str4 = str5;
        } else {
            str4 = host;
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            r10 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(str4, path, method, headers, queries, r10, type, reqConfig, continuation);
            InlineMarker.mark(1);
            r10 = (KmpResponse) executeForKmpResponse;
        }
        return r10;
    }

    public final /* synthetic */ <RespDTO, RespBody> Object requestForResponse(String str, String str2, KmpRequestMethod kmpRequestMethod, String str3, Map<String, String> map, Map<String, String> map2, KmpRequestConfig kmpRequestConfig, Continuation<? super KmpResponse<RespBody>> continuation) {
        IKmpNetworkBridge bridge;
        KmpRequest buildRequest = buildRequest(str, str2, kmpRequestMethod, map, map2, new KmpRequestBody(KmpRequestBodyType.BODY_STRING, str3), kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new C0191x5fe36d85().getType();
        String host = buildRequest.getHost();
        if ((host.length() == 0) && ((bridge = kmpMergedNetworkManager.getBridge()) == null || (host = bridge.getDefaultHost()) == null)) {
            host = "";
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            r1 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(host, path, method, headers, queries, r1, type, reqConfig, continuation);
            InlineMarker.mark(1);
            r1 = (KmpResponse) executeForKmpResponse;
        }
        return r1;
    }

    public static /* synthetic */ Object requestForResponse$default(KmpNetworkService kmpNetworkService, String str, String str2, KmpRequestMethod kmpRequestMethod, Map map, Map map2, Map map3, KmpRequestConfig kmpRequestConfig, Continuation continuation, int i, Object obj) {
        String str3;
        String defaultHost;
        String str4 = "";
        KmpRequest buildRequest = kmpNetworkService.buildRequest((i & 1) != 0 ? "" : str, str2, kmpRequestMethod, (i & 16) != 0 ? MapsKt.emptyMap() : map2, (i & 32) != 0 ? MapsKt.emptyMap() : map3, new KmpRequestBody(KmpRequestBodyType.BODY_STRING_MAP, map), (i & 64) != 0 ? null : kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new C0192x5fe36d86().getType();
        String host = buildRequest.getHost();
        if (host.length() == 0) {
            IKmpNetworkBridge bridge = kmpMergedNetworkManager.getBridge();
            if (bridge != null && (defaultHost = bridge.getDefaultHost()) != null) {
                str4 = defaultHost;
            }
            str3 = str4;
        } else {
            str3 = host;
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            r10 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(str3, path, method, headers, queries, r10, type, reqConfig, continuation);
            InlineMarker.mark(1);
            r10 = (KmpResponse) executeForKmpResponse;
        }
        return r10;
    }

    public final /* synthetic */ <RespDTO, RespBody> Object requestForResponse(String str, String str2, KmpRequestMethod kmpRequestMethod, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, KmpRequestConfig kmpRequestConfig, Continuation<? super KmpResponse<RespBody>> continuation) {
        IKmpNetworkBridge bridge;
        KmpRequest buildRequest = buildRequest(str, str2, kmpRequestMethod, map2, map3, new KmpRequestBody(KmpRequestBodyType.BODY_STRING_MAP, map), kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new C0192x5fe36d86().getType();
        String host = buildRequest.getHost();
        if ((host.length() == 0) && ((bridge = kmpMergedNetworkManager.getBridge()) == null || (host = bridge.getDefaultHost()) == null)) {
            host = "";
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            r1 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(host, path, method, headers, queries, r1, type, reqConfig, continuation);
            InlineMarker.mark(1);
            r1 = (KmpResponse) executeForKmpResponse;
        }
        return r1;
    }

    public static /* synthetic */ Object requestForResponse$default(KmpNetworkService kmpNetworkService, String str, String str2, KmpRequestMethod kmpRequestMethod, Object obj, Map map, Map map2, KmpRequestConfig kmpRequestConfig, Continuation continuation, int i, Object obj2) {
        String str3;
        String defaultHost;
        String str4 = "";
        KmpRequest buildRequest = kmpNetworkService.buildRequest((i & 1) != 0 ? "" : str, str2, kmpRequestMethod, (i & 16) != 0 ? MapsKt.emptyMap() : map, (i & 32) != 0 ? MapsKt.emptyMap() : map2, new KmpRequestBody(KmpRequestBodyType.BODY_OBJECT, obj), (i & 64) != 0 ? null : kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new C0193x5fe36d87().getType();
        String host = buildRequest.getHost();
        if (host.length() == 0) {
            IKmpNetworkBridge bridge = kmpMergedNetworkManager.getBridge();
            if (bridge != null && (defaultHost = bridge.getDefaultHost()) != null) {
                str4 = defaultHost;
            }
            str3 = str4;
        } else {
            str3 = host;
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            r10 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(str3, path, method, headers, queries, r10, type, reqConfig, continuation);
            InlineMarker.mark(1);
            r10 = (KmpResponse) executeForKmpResponse;
        }
        return r10;
    }

    public final /* synthetic */ <ReqBody, RespDTO, RespBody> Object requestForResponse(String str, String str2, KmpRequestMethod kmpRequestMethod, ReqBody reqbody, Map<String, String> map, Map<String, String> map2, KmpRequestConfig kmpRequestConfig, Continuation<? super KmpResponse<RespBody>> continuation) {
        IKmpNetworkBridge bridge;
        KmpRequest buildRequest = buildRequest(str, str2, kmpRequestMethod, map, map2, new KmpRequestBody(KmpRequestBodyType.BODY_OBJECT, reqbody), kmpRequestConfig);
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new C0193x5fe36d87().getType();
        String host = buildRequest.getHost();
        if ((host.length() == 0) && ((bridge = kmpMergedNetworkManager.getBridge()) == null || (host = bridge.getDefaultHost()) == null)) {
            host = "";
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = buildRequest.getPath();
            String method = buildRequest.getMethod();
            Map<String, String> headers = buildRequest.getHeaders();
            Map<String, String> queries = buildRequest.getQueries();
            KmpRequestBody body = buildRequest.getBody();
            r1 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = buildRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(host, path, method, headers, queries, r1, type, reqConfig, continuation);
            InlineMarker.mark(1);
            r1 = (KmpResponse) executeForKmpResponse;
        }
        return r1;
    }

    public final /* synthetic */ <RespDTO, RespBody> Object requestForResponse(KmpRequest kmpRequest, Continuation<? super KmpResponse<RespBody>> continuation) {
        IKmpNetworkBridge bridge;
        KmpMergedNetworkManager kmpMergedNetworkManager = KmpMergedNetworkManager.INSTANCE;
        Intrinsics.needClassReification();
        Type type = new TypeToken<RespBody>() { // from class: com.bytedance.kmp.network.bridge.KmpNetworkService$requestForResponse$$inlined$executeForResponse$4
        }.getType();
        String host = kmpRequest.getHost();
        if ((host.length() == 0) && ((bridge = kmpMergedNetworkManager.getBridge()) == null || (host = bridge.getDefaultHost()) == null)) {
            host = "";
        }
        IKmpNetworkBridge bridge2 = kmpMergedNetworkManager.getBridge();
        if (bridge2 != null) {
            String path = kmpRequest.getPath();
            String method = kmpRequest.getMethod();
            Map<String, String> headers = kmpRequest.getHeaders();
            Map<String, String> queries = kmpRequest.getQueries();
            KmpRequestBody body = kmpRequest.getBody();
            r0 = body != null ? body.getBody() : null;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KmpRequestConfig reqConfig = kmpRequest.getReqConfig();
            InlineMarker.mark(0);
            Object executeForKmpResponse = bridge2.executeForKmpResponse(host, path, method, headers, queries, r0, type, reqConfig, continuation);
            InlineMarker.mark(1);
            r0 = (KmpResponse) executeForKmpResponse;
        }
        return r0;
    }

    public final KmpRequest buildRequest(String host, String path, KmpRequestMethod method, Map<String, String> headers, Map<String, String> queries, KmpRequestBody body, KmpRequestConfig config) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(queries, "queries");
        if (config == null) {
            return new KmpRequest(host, path, method.getTypeName(), headers, queries, body);
        }
        return new KmpRequest(host, path, method.getTypeName(), headers, queries, body, config);
    }
}
