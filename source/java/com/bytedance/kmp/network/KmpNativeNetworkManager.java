package com.bytedance.kmp.network;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.kmp.network.cinterop.KmpNativeNetworkService;
import com.bytedance.kmp.network.requet.FormRequestBody;
import com.bytedance.kmp.network.requet.MultipartRequestBody;
import com.bytedance.kmp.network.requet.Request;
import com.bytedance.kmp.network.requet.RequestBody;
import com.bytedance.kmp.network.requet.RequestBodyKt;
import com.bytedance.kmp.network.requet.RequestContext;
import com.bytedance.kmp.network.response.Response;
import com.bytedance.kmp.network.response.ResponseBody;
import com.bytedance.kmp.network.response.ResponseBodyConvertor;
import com.bytedance.kmp.network.response.ResponseBodyConvertorFactory;
import com.bytedance.kmp.network.response.ResponseCallback;
import com.bytedance.pia.core.tracing.OnlineTracing;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KmpNativeNetworkManager.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJÊ\u0001\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00152\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010 J \u0010!\u001a\u0004\u0018\u0001H\"\"\u0006\b\u0000\u0010\"\u0018\u00012\u0006\u0010\t\u001a\u00020\nH\u0086H¢\u0006\u0002\u0010 J\u001e\u0010#\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010&Jt\u0010'\u001a\u0004\u0018\u0001H\"\"\u0006\b\u0000\u0010\"\u0018\u00012\u0006\u0010\f\u001a\u00020\r2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0086H¢\u0006\u0002\u0010)J\\\u0010*\u001a\u0004\u0018\u0001H\"\"\u0006\b\u0000\u0010\"\u0018\u00012\u0006\u0010\f\u001a\u00020\r2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0086H¢\u0006\u0002\u0010+J \u0001\u0010,\u001a\u0004\u0018\u0001H\"\"\u0006\b\u0000\u0010\"\u0018\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010-\u001a\u00020\r2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00152\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0086H¢\u0006\u0002\u00101Jh\u00102\u001a\u0004\u0018\u0001H\"\"\u0006\b\u0000\u0010\"\u0018\u00012\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0086H¢\u0006\u0002\u00105Jt\u00106\u001a\u0004\u0018\u0001H\"\"\u0006\b\u0000\u0010\"\u0018\u00012\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\r2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0086H¢\u0006\u0002\u00109J\u000e\u0010:\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006;"}, d2 = {"Lcom/bytedance/kmp/network/KmpNativeNetworkManager;", "", "()V", "implementation", "Lcom/bytedance/kmp/network/KmpNetworkManagerImpl;", "getImplementation", "()Lcom/bytedance/kmp/network/KmpNetworkManagerImpl;", "cancel", "", "request", "Lcom/bytedance/kmp/network/requet/Request;", "constructRequest", "url", "", "method", "queries", "", OnlineTracing.HeaderKeys.KEY_SSR_FALLBACK_HEADER, "postMultiPartType", "postMultiPartStrData", "postMultiPartSourceData", "", "Lcom/bytedance/kmp/network/requet/MultipartRequestBody$MultiSourcePart;", "postMultiParts", "Lcom/bytedance/kmp/network/requet/MultipartRequestBody$Part;", "postFormData", "postStringData", "customContentType", "requestContext", "Lcom/bytedance/kmp/network/requet/RequestContext;", "execute", "Lcom/bytedance/kmp/network/response/Response;", "(Lcom/bytedance/kmp/network/requet/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeForBody", "T", "executeStream", "callback", "Lcom/bytedance/kmp/network/response/ResponseCallback;", "(Lcom/bytedance/kmp/network/requet/Request;Lcom/bytedance/kmp/network/response/ResponseCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formPost", "data", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/requet/RequestContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", PrefetchRequestConfig.METHOD_GET, "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/requet/RequestContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "multiPartPost", "type", "strData", "sourceData", "parts", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/requet/RequestContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", PrefetchRequestConfig.METHOD_POST, "requestBody", "Lcom/bytedance/kmp/network/requet/RequestBody;", "(Ljava/lang/String;Lcom/bytedance/kmp/network/requet/RequestBody;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/requet/RequestContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postString", "contentType", "content", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/requet/RequestContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preConnect", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNativeNetworkManager {
    public static final KmpNativeNetworkManager INSTANCE = new KmpNativeNetworkManager();
    private static final KmpNetworkManagerImpl implementation = new KmpNetworkManagerImpl(new KmpNativeNetworkService());

    private KmpNativeNetworkManager() {
    }

    public final KmpNetworkManagerImpl getImplementation() {
        return implementation;
    }

    public static /* synthetic */ Object multiPartPost$default(KmpNativeNetworkManager kmpNativeNetworkManager, String str, String str2, Map map, List list, List list2, Map map2, Map map3, RequestContext requestContext, Continuation continuation, int i, Object obj) {
        Map map4 = (i & 4) != 0 ? null : map;
        List<MultipartRequestBody.MultiSourcePart> list3 = (i & 8) != 0 ? null : list;
        List list4 = (i & 16) != 0 ? null : list2;
        Map map5 = (i & 32) != 0 ? null : map2;
        Map map6 = (i & 64) != 0 ? null : map3;
        RequestContext requestContext2 = (i & 128) != 0 ? null : requestContext;
        KmpNetworkManagerImpl implementation2 = kmpNativeNetworkManager.getImplementation();
        MultipartRequestBody.Builder builder = new MultipartRequestBody.Builder();
        builder.setType(str2);
        if (map4 != null) {
            for (Map.Entry entry : map4.entrySet()) {
                builder.addFormDataPart((String) entry.getKey(), (String) entry.getValue());
                Unit unit = Unit.INSTANCE;
            }
            Unit unit2 = Unit.INSTANCE;
        }
        if (list3 != null) {
            for (MultipartRequestBody.MultiSourcePart multiSourcePart : list3) {
                builder.addFormDataPart(multiSourcePart.getName(), multiSourcePart.getFileName(), RequestBodyKt.toRequestBody$default(multiSourcePart.getSource(), null, 0L, 3, null));
                Unit unit3 = Unit.INSTANCE;
            }
            Unit unit4 = Unit.INSTANCE;
        }
        if (list4 != null) {
            Iterator it = list4.iterator();
            while (it.hasNext()) {
                builder.addPart((MultipartRequestBody.Part) it.next());
                Unit unit5 = Unit.INSTANCE;
            }
            Unit unit6 = Unit.INSTANCE;
        }
        Unit unit7 = Unit.INSTANCE;
        MultipartRequestBody build = builder.build();
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNativeNetworkManager$multiPartPost$$inlined$multiPartPost$1 kmpNativeNetworkManager$multiPartPost$$inlined$multiPartPost$1 = new KmpNativeNetworkManager$multiPartPost$$inlined$multiPartPost$1(str, map6, map5, build, requestContext2, implementation2, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNativeNetworkManager$multiPartPost$$inlined$multiPartPost$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public final /* synthetic */ <T> Object multiPartPost(String str, String str2, Map<String, String> map, List<MultipartRequestBody.MultiSourcePart> list, List<MultipartRequestBody.Part> list2, Map<String, String> map2, Map<String, String> map3, RequestContext requestContext, Continuation<? super T> continuation) {
        KmpNetworkManagerImpl implementation2 = getImplementation();
        MultipartRequestBody.Builder builder = new MultipartRequestBody.Builder();
        builder.setType(str2);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.addFormDataPart(entry.getKey(), entry.getValue());
                Unit unit = Unit.INSTANCE;
            }
            Unit unit2 = Unit.INSTANCE;
        }
        if (list != null) {
            for (MultipartRequestBody.MultiSourcePart multiSourcePart : list) {
                builder.addFormDataPart(multiSourcePart.getName(), multiSourcePart.getFileName(), RequestBodyKt.toRequestBody$default(multiSourcePart.getSource(), null, 0L, 3, null));
                Unit unit3 = Unit.INSTANCE;
            }
            Unit unit4 = Unit.INSTANCE;
        }
        if (list2 != null) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                builder.addPart((MultipartRequestBody.Part) it.next());
                Unit unit5 = Unit.INSTANCE;
            }
            Unit unit6 = Unit.INSTANCE;
        }
        Unit unit7 = Unit.INSTANCE;
        MultipartRequestBody build = builder.build();
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNativeNetworkManager$multiPartPost$$inlined$multiPartPost$1 kmpNativeNetworkManager$multiPartPost$$inlined$multiPartPost$1 = new KmpNativeNetworkManager$multiPartPost$$inlined$multiPartPost$1(str, map3, map2, build, requestContext, implementation2, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNativeNetworkManager$multiPartPost$$inlined$multiPartPost$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object formPost$default(KmpNativeNetworkManager kmpNativeNetworkManager, String str, Map map, Map map2, Map map3, RequestContext requestContext, Continuation continuation, int i, Object obj) {
        Map map4 = (i & 2) != 0 ? null : map;
        Map map5 = (i & 4) != 0 ? null : map2;
        Map map6 = (i & 8) != 0 ? null : map3;
        RequestContext requestContext2 = (i & 16) != 0 ? null : requestContext;
        KmpNetworkManagerImpl implementation2 = kmpNativeNetworkManager.getImplementation();
        FormRequestBody build = new FormRequestBody.Builder().addAll(map4).build();
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNativeNetworkManager$formPost$$inlined$formPost$1 kmpNativeNetworkManager$formPost$$inlined$formPost$1 = new KmpNativeNetworkManager$formPost$$inlined$formPost$1(str, map6, map5, build, requestContext2, implementation2, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNativeNetworkManager$formPost$$inlined$formPost$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public final /* synthetic */ <T> Object formPost(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, RequestContext requestContext, Continuation<? super T> continuation) {
        KmpNetworkManagerImpl implementation2 = getImplementation();
        FormRequestBody build = new FormRequestBody.Builder().addAll(map).build();
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNativeNetworkManager$formPost$$inlined$formPost$1 kmpNativeNetworkManager$formPost$$inlined$formPost$1 = new KmpNativeNetworkManager$formPost$$inlined$formPost$1(str, map3, map2, build, requestContext, implementation2, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNativeNetworkManager$formPost$$inlined$formPost$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public static /* synthetic */ Object postString$default(KmpNativeNetworkManager kmpNativeNetworkManager, String str, String str2, String str3, Map map, Map map2, RequestContext requestContext, Continuation continuation, int i, Object obj) {
        KmpNetworkManagerImpl$postString$2 kmpNetworkManagerImpl$postString$2 = null;
        String str4 = (i & 2) != 0 ? null : str2;
        String str5 = (i & 4) != 0 ? null : str3;
        Map map3 = (i & 8) != 0 ? null : map;
        Map map4 = (i & 16) != 0 ? null : map2;
        RequestContext requestContext2 = (i & 32) != 0 ? null : requestContext;
        KmpNetworkManagerImpl implementation2 = kmpNativeNetworkManager.getImplementation();
        if (str5 == null) {
        } else {
            kmpNetworkManagerImpl$postString$2 = new KmpNetworkManagerImpl$postString$2(str4, str5);
        }
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNativeNetworkManager$postString$$inlined$postString$1 kmpNativeNetworkManager$postString$$inlined$postString$1 = new KmpNativeNetworkManager$postString$$inlined$postString$1(str, map4, map3, kmpNetworkManagerImpl$postString$2, requestContext2, implementation2, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNativeNetworkManager$postString$$inlined$postString$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public final /* synthetic */ <T> Object postString(String str, String str2, String str3, Map<String, String> map, Map<String, String> map2, RequestContext requestContext, Continuation<? super T> continuation) {
        KmpNetworkManagerImpl$postString$2 kmpNetworkManagerImpl$postString$2;
        KmpNetworkManagerImpl implementation2 = getImplementation();
        if (str3 == null) {
            kmpNetworkManagerImpl$postString$2 = null;
        } else {
            kmpNetworkManagerImpl$postString$2 = new KmpNetworkManagerImpl$postString$2(str2, str3);
        }
        KmpNetworkManagerImpl$postString$2 kmpNetworkManagerImpl$postString$22 = kmpNetworkManagerImpl$postString$2;
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNativeNetworkManager$postString$$inlined$postString$1 kmpNativeNetworkManager$postString$$inlined$postString$1 = new KmpNativeNetworkManager$postString$$inlined$postString$1(str, map2, map, kmpNetworkManagerImpl$postString$22, requestContext, implementation2, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNativeNetworkManager$postString$$inlined$postString$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public static /* synthetic */ Object post$default(KmpNativeNetworkManager kmpNativeNetworkManager, String str, RequestBody requestBody, Map map, Map map2, RequestContext requestContext, Continuation continuation, int i, Object obj) {
        RequestBody requestBody2 = (i & 2) != 0 ? null : requestBody;
        Map map3 = (i & 4) != 0 ? null : map;
        Map map4 = (i & 8) != 0 ? null : map2;
        RequestContext requestContext2 = (i & 16) != 0 ? null : requestContext;
        KmpNetworkManagerImpl implementation2 = kmpNativeNetworkManager.getImplementation();
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNativeNetworkManager$post$$inlined$post$1 kmpNativeNetworkManager$post$$inlined$post$1 = new KmpNativeNetworkManager$post$$inlined$post$1(str, map4, map3, requestBody2, requestContext2, implementation2, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNativeNetworkManager$post$$inlined$post$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public final /* synthetic */ <T> Object post(String str, RequestBody requestBody, Map<String, String> map, Map<String, String> map2, RequestContext requestContext, Continuation<? super T> continuation) {
        KmpNetworkManagerImpl implementation2 = getImplementation();
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNativeNetworkManager$post$$inlined$post$1 kmpNativeNetworkManager$post$$inlined$post$1 = new KmpNativeNetworkManager$post$$inlined$post$1(str, map2, map, requestBody, requestContext, implementation2, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNativeNetworkManager$post$$inlined$post$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public static /* synthetic */ Object get$default(KmpNativeNetworkManager kmpNativeNetworkManager, String str, Map map, Map map2, RequestContext requestContext, Continuation continuation, int i, Object obj) {
        Map map3 = (i & 2) != 0 ? null : map;
        Map map4 = (i & 4) != 0 ? null : map2;
        RequestContext requestContext2 = (i & 8) != 0 ? null : requestContext;
        KmpNetworkManagerImpl implementation2 = kmpNativeNetworkManager.getImplementation();
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNativeNetworkManager$get$$inlined$get$1 kmpNativeNetworkManager$get$$inlined$get$1 = new KmpNativeNetworkManager$get$$inlined$get$1(str, map3, map4, requestContext2, implementation2, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNativeNetworkManager$get$$inlined$get$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public final /* synthetic */ <T> Object get(String str, Map<String, String> map, Map<String, String> map2, RequestContext requestContext, Continuation<? super T> continuation) {
        KmpNetworkManagerImpl implementation2 = getImplementation();
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNativeNetworkManager$get$$inlined$get$1 kmpNativeNetworkManager$get$$inlined$get$1 = new KmpNativeNetworkManager$get$$inlined$get$1(str, map, map2, requestContext, implementation2, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNativeNetworkManager$get$$inlined$get$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public final Request constructRequest(String url, String method, Map<String, String> queries, Map<String, String> header, String postMultiPartType, Map<String, String> postMultiPartStrData, List<MultipartRequestBody.MultiSourcePart> postMultiPartSourceData, List<MultipartRequestBody.Part> postMultiParts, Map<String, String> postFormData, String postStringData, String customContentType, RequestContext requestContext) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        return implementation.constructRequest(url, method, queries, header, postMultiPartType, postMultiPartStrData, postMultiPartSourceData, postMultiParts, postFormData, postStringData, customContentType, requestContext);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> Object executeForBody(Request request, Continuation<? super T> continuation) {
        KmpNetworkManagerImpl implementation2 = getImplementation();
        request.getKmpRequestMetrics().recordRequestStartTime();
        InlineMarker.mark(0);
        Object execute = implementation2.execute(request, false, continuation);
        InlineMarker.mark(1);
        Response response = (Response) execute;
        request.getKmpRequestMetrics().recordResponseDecodeStartTime();
        ResponseBodyConvertor<?> responseBodyConvertor = request.getReqContext().getResponseBodyConvertor();
        Object obj = null;
        if (responseBodyConvertor == null) {
            ResponseBodyConvertorFactory responseBodyConvertorFactory = ResponseBodyConvertorFactory.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, "T");
            responseBodyConvertor = responseBodyConvertorFactory.create(null);
        }
        if (response.getBody() != null) {
            ResponseBody body = response.getBody();
            InlineMarker.mark(0);
            obj = responseBodyConvertor.convert(body, continuation);
            InlineMarker.mark(1);
            Intrinsics.reifiedOperationMarker(1, "T?");
        }
        request.getKmpRequestMetrics().recordResponseDecodeEndTime();
        KmpRequestMetrics kmpRequestMetrics = request.getKmpRequestMetrics();
        InlineMarker.mark(0);
        kmpRequestMetrics.recordRequestEndTimeAndReport(request, response, continuation);
        InlineMarker.mark(1);
        return obj;
    }

    public final Object execute(Request request, Continuation<? super Response> continuation) {
        return KmpNetworkManagerImpl.execute$default(implementation, request, false, continuation, 2, null);
    }

    public final Object executeStream(Request request, ResponseCallback responseCallback, Continuation<? super Unit> continuation) {
        Object executeStream = implementation.executeStream(request, responseCallback, continuation);
        return executeStream == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? executeStream : Unit.INSTANCE;
    }

    public final void cancel(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        implementation.cancel(request);
    }

    public final void preConnect(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        implementation.preConnect(url);
    }
}
