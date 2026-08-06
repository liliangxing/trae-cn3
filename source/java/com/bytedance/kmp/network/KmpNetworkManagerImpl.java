package com.bytedance.kmp.network;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.kmp.network.cinterop.KmpNativeNetworkService;
import com.bytedance.kmp.network.p010public.BizInterceptorManager;
import com.bytedance.kmp.network.p010public.KmpNetworkSetting;
import com.bytedance.kmp.network.requet.DnsConfig;
import com.bytedance.kmp.network.requet.FormRequestBody;
import com.bytedance.kmp.network.requet.IRequestInterceptor;
import com.bytedance.kmp.network.requet.MultipartRequestBody;
import com.bytedance.kmp.network.requet.Request;
import com.bytedance.kmp.network.requet.RequestBody;
import com.bytedance.kmp.network.requet.RequestBodyKt;
import com.bytedance.kmp.network.requet.RequestBuilder;
import com.bytedance.kmp.network.requet.RequestContext;
import com.bytedance.kmp.network.response.IResponseInterceptor;
import com.bytedance.kmp.network.response.Response;
import com.bytedance.kmp.network.response.ResponseBody;
import com.bytedance.kmp.network.response.ResponseBodyConvertor;
import com.bytedance.kmp.network.response.ResponseBodyConvertorFactory;
import com.bytedance.kmp.network.response.ResponseBuilder;
import com.bytedance.kmp.network.response.ResponseCallback;
import com.bytedance.kmp.network.util.NLog;
import com.bytedance.pia.core.tracing.OnlineTracing;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.StringFormat;
import okio.BufferedSink;

/* compiled from: KmpNetworkManagerImpl.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rH\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bJÊ\u0001\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00182\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 J \u0010!\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%J \u0010&\u001a\u0004\u0018\u0001H'\"\u0006\b\u0000\u0010'\u0018\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0086H¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+H\u0086@¢\u0006\u0002\u0010,Jt\u0010-\u001a\u0004\u0018\u0001H'\"\u0006\b\u0000\u0010'\u0018\u00012\u0006\u0010\u0011\u001a\u00020\t2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0086H¢\u0006\u0002\u0010/J\\\u00100\u001a\u0004\u0018\u0001H'\"\u0006\b\u0000\u0010'\u0018\u00012\u0006\u0010\u0011\u001a\u00020\t2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0086H¢\u0006\u0002\u00101J \u0001\u00102\u001a\u0004\u0018\u0001H'\"\u0006\b\u0000\u0010'\u0018\u00012\u0006\u0010\u0011\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00182\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0086H¢\u0006\u0002\u00107Jh\u00108\u001a\u0004\u0018\u0001H'\"\u0006\b\u0000\u0010'\u0018\u00012\u0006\u0010\u0011\u001a\u00020\t2\n\b\u0002\u00109\u001a\u0004\u0018\u00010:2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0086H¢\u0006\u0002\u0010;J\u0016\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010>Jt\u0010?\u001a\u0004\u0018\u0001H'\"\u0006\b\u0000\u0010'\u0018\u00012\u0006\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0086H¢\u0006\u0002\u0010BJ\u000e\u0010C\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tJ\u0016\u0010D\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010(J\u0018\u0010E\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/bytedance/kmp/network/KmpNetworkManagerImpl;", "", "service", "Lcom/bytedance/kmp/network/IKmpNetworkService;", "(Lcom/bytedance/kmp/network/IKmpNetworkService;)V", "counter", "Lkotlinx/atomicfu/AtomicInt;", "addTTNetHeader", "", "", "request", "Lcom/bytedance/kmp/network/requet/Request;", "headers", "", "cancel", "", "constructRequest", "url", "method", "queries", OnlineTracing.HeaderKeys.KEY_SSR_FALLBACK_HEADER, "postMultiPartType", "postMultiPartStrData", "postMultiPartSourceData", "", "Lcom/bytedance/kmp/network/requet/MultipartRequestBody$MultiSourcePart;", "postMultiParts", "Lcom/bytedance/kmp/network/requet/MultipartRequestBody$Part;", "postFormData", "postStringData", "customContentType", "requestContext", "Lcom/bytedance/kmp/network/requet/RequestContext;", "execute", "Lcom/bytedance/kmp/network/response/Response;", "needReport", "", "(Lcom/bytedance/kmp/network/requet/Request;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeForBody", "T", "(Lcom/bytedance/kmp/network/requet/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeStream", "callback", "Lcom/bytedance/kmp/network/response/ResponseCallback;", "(Lcom/bytedance/kmp/network/requet/Request;Lcom/bytedance/kmp/network/response/ResponseCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formPost", "data", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/requet/RequestContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", PrefetchRequestConfig.METHOD_GET, "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/requet/RequestContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "multiPartPost", "type", "strData", "sourceData", "parts", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/requet/RequestContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", PrefetchRequestConfig.METHOD_POST, "requestBody", "Lcom/bytedance/kmp/network/requet/RequestBody;", "(Ljava/lang/String;Lcom/bytedance/kmp/network/requet/RequestBody;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/requet/RequestContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postProcessResponse", "response", "(Lcom/bytedance/kmp/network/response/Response;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postString", "contentType", "content", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/requet/RequestContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preConnect", "preprocessRequest", "replaceHost", "newHost", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNetworkManagerImpl {
    private AtomicInt counter;
    private final IKmpNetworkService service;

    /* compiled from: KmpNetworkManagerImpl.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Protocol.values().length];
            try {
                iArr[Protocol.HTTP_1_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Protocol.HTTP_1_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Protocol.HTTP_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Protocol.QUIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public KmpNetworkManagerImpl(IKmpNetworkService iKmpNetworkService) {
        Intrinsics.checkNotNullParameter(iKmpNetworkService, "service");
        this.service = iKmpNetworkService;
        this.counter = AtomicFU.atomic(0);
    }

    public static /* synthetic */ Object multiPartPost$default(KmpNetworkManagerImpl kmpNetworkManagerImpl, String str, String str2, Map map, List list, List list2, Map map2, Map map3, RequestContext requestContext, Continuation continuation, int i, Object obj) {
        Map map4 = (i & 4) != 0 ? null : map;
        List<MultipartRequestBody.MultiSourcePart> list3 = (i & 8) != 0 ? null : list;
        List list4 = (i & 16) != 0 ? null : list2;
        Map map5 = (i & 32) != 0 ? null : map2;
        Map map6 = (i & 64) != 0 ? null : map3;
        RequestContext requestContext2 = (i & 128) != 0 ? null : requestContext;
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
        KmpNetworkManagerImpl$multiPartPost$$inlined$post$1 kmpNetworkManagerImpl$multiPartPost$$inlined$post$1 = new KmpNetworkManagerImpl$multiPartPost$$inlined$post$1(str, map6, map5, build, requestContext2, kmpNetworkManagerImpl, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNetworkManagerImpl$multiPartPost$$inlined$post$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public final /* synthetic */ <T> Object multiPartPost(String str, String str2, Map<String, String> map, List<MultipartRequestBody.MultiSourcePart> list, List<MultipartRequestBody.Part> list2, Map<String, String> map2, Map<String, String> map3, RequestContext requestContext, Continuation<? super T> continuation) {
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
        KmpNetworkManagerImpl$multiPartPost$$inlined$post$1 kmpNetworkManagerImpl$multiPartPost$$inlined$post$1 = new KmpNetworkManagerImpl$multiPartPost$$inlined$post$1(str, map3, map2, build, requestContext, this, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNetworkManagerImpl$multiPartPost$$inlined$post$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object formPost$default(KmpNetworkManagerImpl kmpNetworkManagerImpl, String str, Map map, Map map2, Map map3, RequestContext requestContext, Continuation continuation, int i, Object obj) {
        Map map4 = (i & 2) != 0 ? null : map;
        Map map5 = (i & 4) != 0 ? null : map2;
        Map map6 = (i & 8) != 0 ? null : map3;
        RequestContext requestContext2 = (i & 16) != 0 ? null : requestContext;
        FormRequestBody build = new FormRequestBody.Builder().addAll(map4).build();
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNetworkManagerImpl$formPost$$inlined$post$1 kmpNetworkManagerImpl$formPost$$inlined$post$1 = new KmpNetworkManagerImpl$formPost$$inlined$post$1(str, map6, map5, build, requestContext2, kmpNetworkManagerImpl, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNetworkManagerImpl$formPost$$inlined$post$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public final /* synthetic */ <T> Object formPost(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, RequestContext requestContext, Continuation<? super T> continuation) {
        FormRequestBody build = new FormRequestBody.Builder().addAll(map).build();
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNetworkManagerImpl$formPost$$inlined$post$1 kmpNetworkManagerImpl$formPost$$inlined$post$1 = new KmpNetworkManagerImpl$formPost$$inlined$post$1(str, map3, map2, build, requestContext, this, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNetworkManagerImpl$formPost$$inlined$post$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public static /* synthetic */ Object postString$default(KmpNetworkManagerImpl kmpNetworkManagerImpl, String str, String str2, String str3, Map map, Map map2, RequestContext requestContext, Continuation continuation, int i, Object obj) {
        KmpNetworkManagerImpl$postString$2 kmpNetworkManagerImpl$postString$2 = null;
        String str4 = (i & 2) != 0 ? null : str2;
        String str5 = (i & 4) != 0 ? null : str3;
        Map map3 = (i & 8) != 0 ? null : map;
        Map map4 = (i & 16) != 0 ? null : map2;
        RequestContext requestContext2 = (i & 32) != 0 ? null : requestContext;
        if (str5 == null) {
        } else {
            kmpNetworkManagerImpl$postString$2 = new KmpNetworkManagerImpl$postString$2(str4, str5);
        }
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNetworkManagerImpl$postString$$inlined$post$1 kmpNetworkManagerImpl$postString$$inlined$post$1 = new KmpNetworkManagerImpl$postString$$inlined$post$1(str, map4, map3, kmpNetworkManagerImpl$postString$2, requestContext2, kmpNetworkManagerImpl, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNetworkManagerImpl$postString$$inlined$post$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public final /* synthetic */ <T> Object postString(String str, String str2, String str3, Map<String, String> map, Map<String, String> map2, RequestContext requestContext, Continuation<? super T> continuation) {
        KmpNetworkManagerImpl$postString$2 kmpNetworkManagerImpl$postString$2;
        if (str3 == null) {
            kmpNetworkManagerImpl$postString$2 = null;
        } else {
            kmpNetworkManagerImpl$postString$2 = new KmpNetworkManagerImpl$postString$2(str2, str3);
        }
        KmpNetworkManagerImpl$postString$2 kmpNetworkManagerImpl$postString$22 = kmpNetworkManagerImpl$postString$2;
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNetworkManagerImpl$postString$$inlined$post$1 kmpNetworkManagerImpl$postString$$inlined$post$1 = new KmpNetworkManagerImpl$postString$$inlined$post$1(str, map2, map, kmpNetworkManagerImpl$postString$22, requestContext, this, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNetworkManagerImpl$postString$$inlined$post$1, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public static /* synthetic */ Object post$default(KmpNetworkManagerImpl kmpNetworkManagerImpl, String str, RequestBody requestBody, Map map, Map map2, RequestContext requestContext, Continuation continuation, int i, Object obj) {
        RequestBody requestBody2 = (i & 2) != 0 ? null : requestBody;
        Map map3 = (i & 4) != 0 ? null : map;
        Map map4 = (i & 8) != 0 ? null : map2;
        RequestContext requestContext2 = (i & 16) != 0 ? null : requestContext;
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNetworkManagerImpl$post$2 kmpNetworkManagerImpl$post$2 = new KmpNetworkManagerImpl$post$2(str, map4, map3, requestBody2, requestContext2, kmpNetworkManagerImpl, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNetworkManagerImpl$post$2, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public final /* synthetic */ <T> Object post(String str, RequestBody requestBody, Map<String, String> map, Map<String, String> map2, RequestContext requestContext, Continuation<? super T> continuation) {
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNetworkManagerImpl$post$2 kmpNetworkManagerImpl$post$2 = new KmpNetworkManagerImpl$post$2(str, map2, map, requestBody, requestContext, this, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNetworkManagerImpl$post$2, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public static /* synthetic */ Object get$default(KmpNetworkManagerImpl kmpNetworkManagerImpl, String str, Map map, Map map2, RequestContext requestContext, Continuation continuation, int i, Object obj) {
        Map map3 = (i & 2) != 0 ? null : map;
        Map map4 = (i & 4) != 0 ? null : map2;
        RequestContext requestContext2 = (i & 8) != 0 ? null : requestContext;
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNetworkManagerImpl$get$2 kmpNetworkManagerImpl$get$2 = new KmpNetworkManagerImpl$get$2(str, map3, map4, requestContext2, kmpNetworkManagerImpl, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNetworkManagerImpl$get$2, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    public final /* synthetic */ <T> Object get(String str, Map<String, String> map, Map<String, String> map2, RequestContext requestContext, Continuation<? super T> continuation) {
        CoroutineContext io2 = Dispatchers.getIO();
        Intrinsics.needClassReification();
        KmpNetworkManagerImpl$get$2 kmpNetworkManagerImpl$get$2 = new KmpNetworkManagerImpl$get$2(str, map, map2, requestContext, this, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(io2, kmpNetworkManagerImpl$get$2, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> Object executeForBody(Request request, Continuation<? super T> continuation) {
        request.getKmpRequestMetrics().recordRequestStartTime();
        InlineMarker.mark(0);
        Object execute = execute(request, false, continuation);
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

    public static /* synthetic */ Object execute$default(KmpNetworkManagerImpl kmpNetworkManagerImpl, Request request, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return kmpNetworkManagerImpl.execute(request, z, continuation);
    }

    public final Object execute(Request request, boolean z, Continuation<? super Response> continuation) {
        NLog nLog = NLog.INSTANCE;
        NLog.Level level = NLog.Level.DEBUG;
        if (level.compareTo(nLog.getLevel()) >= 0) {
            String obj = "network_service execute".toString();
            if (obj == null) {
                obj = "null";
            }
            System.out.println((Object) ("[" + StringsKt.first(level.name()) + "][kmp-ttnet] " + obj));
        }
        return BuildersKt.withContext(Dispatchers.getIO(), new KmpNetworkManagerImpl$execute$3(request, this, z, null), continuation);
    }

    public final Object executeStream(Request request, ResponseCallback responseCallback, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new KmpNetworkManagerImpl$executeStream$2(this, request, responseCallback, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void cancel(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.service.cancel(request);
    }

    public final void preConnect(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.service.preConnect(url);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Request constructRequest(String url, String method, Map<String, String> queries, Map<String, String> header, String postMultiPartType, Map<String, String> postMultiPartStrData, List<MultipartRequestBody.MultiSourcePart> postMultiPartSourceData, List<MultipartRequestBody.Part> postMultiParts, Map<String, String> postFormData, final String postStringData, final String customContentType, RequestContext requestContext) {
        RequestBody requestBody;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "POST")) {
            String str = postMultiPartType;
            boolean z = false;
            if (!(str == null || str.length() == 0)) {
                MultipartRequestBody.Builder builder = new MultipartRequestBody.Builder();
                builder.setType(postMultiPartType);
                if (postMultiPartStrData != null) {
                    for (Map.Entry<String, String> entry : postMultiPartStrData.entrySet()) {
                        builder.addFormDataPart(entry.getKey(), entry.getValue());
                    }
                }
                if (postMultiPartSourceData != null) {
                    for (MultipartRequestBody.MultiSourcePart multiSourcePart : postMultiPartSourceData) {
                        builder.addFormDataPart(multiSourcePart.getName(), multiSourcePart.getFileName(), RequestBodyKt.toRequestBody$default(multiSourcePart.getSource(), null, 0L, 3, null));
                    }
                }
                if (postMultiParts != null) {
                    Iterator<T> it = postMultiParts.iterator();
                    while (it.hasNext()) {
                        builder.addPart((MultipartRequestBody.Part) it.next());
                    }
                }
                requestBody = builder.build();
            } else if (postFormData != null && postFormData.isEmpty()) {
                requestBody = new FormRequestBody.Builder().addAll(postFormData).build();
            } else {
                if (postStringData != null) {
                    if (postStringData.length() > 0) {
                        z = true;
                    }
                }
                if (z) {
                    requestBody = new RequestBody() { // from class: com.bytedance.kmp.network.KmpNetworkManagerImpl$constructRequest$2
                        @Override // com.bytedance.kmp.network.requet.RequestBody
                        /* renamed from: contentType, reason: from getter */
                        public String get$customContentType() {
                            return customContentType;
                        }

                        @Override // com.bytedance.kmp.network.requet.RequestBody
                        public void writeTo(BufferedSink sink) {
                            if (sink != null) {
                                sink.writeUtf8(postStringData);
                            }
                            if (sink != null) {
                                sink.flush();
                            }
                        }
                    };
                }
            }
            return new Request(UrlEncoderUtil.INSTANCE.appendUnEncodedQueryToUrl(url, queries), method, header != null ? MapsKt.emptyMap() : header, requestBody, requestContext != null ? new RequestContext() : requestContext, new KmpRequestMetrics());
        }
        requestBody = null;
        if (header != null) {
        }
        return new Request(UrlEncoderUtil.INSTANCE.appendUnEncodedQueryToUrl(url, queries), method, header != null ? MapsKt.emptyMap() : header, requestBody, requestContext != null ? new RequestContext() : requestContext, new KmpRequestMetrics());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x011c -> B:11:0x011d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object preprocessRequest(Request request, Continuation<? super Request> continuation) {
        KmpNetworkManagerImpl$preprocessRequest$1 kmpNetworkManagerImpl$preprocessRequest$1;
        int i;
        Request request2;
        Ref.ObjectRef objectRef;
        List<IRequestInterceptor> requestInterceptorList;
        String host;
        List<IRequestInterceptor> list;
        Iterator it;
        Ref.ObjectRef objectRef2;
        if (continuation instanceof KmpNetworkManagerImpl$preprocessRequest$1) {
            kmpNetworkManagerImpl$preprocessRequest$1 = (KmpNetworkManagerImpl$preprocessRequest$1) continuation;
            if ((kmpNetworkManagerImpl$preprocessRequest$1.label & Integer.MIN_VALUE) != 0) {
                kmpNetworkManagerImpl$preprocessRequest$1.label -= Integer.MIN_VALUE;
                Object obj = kmpNetworkManagerImpl$preprocessRequest$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = kmpNetworkManagerImpl$preprocessRequest$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    RequestContext reqContext = request.getReqContext();
                    reqContext.setRequestUuid(this.counter.incrementAndGet());
                    if (this.service instanceof KmpNativeNetworkService) {
                        reqContext.setCinteropRequest(true);
                    }
                    if (!KmpNetworkUtils.INSTANCE.isPureRequest(request)) {
                        BizInterceptorManager bizInterceptorManager = BizInterceptorManager.INSTANCE;
                        kmpNetworkManagerImpl$preprocessRequest$1.L$0 = request;
                        kmpNetworkManagerImpl$preprocessRequest$1.label = 1;
                        obj = bizInterceptorManager.intercept(request, kmpNetworkManagerImpl$preprocessRequest$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        request2 = request;
                        objectRef = new Ref.ObjectRef();
                        objectRef.element = request.newBuilder();
                        ((RequestBuilder) objectRef.element).headers(addTTNetHeader(request2, MapsKt.toMutableMap(request.getHeaders())));
                        requestInterceptorList = request.getReqContext().getRequestInterceptorList();
                        host = request.getReqContext().getHost();
                        list = requestInterceptorList;
                        if (list != null || list.isEmpty()) {
                            if (host.length() == 0) {
                                return ((RequestBuilder) objectRef.element).build();
                            }
                        }
                        if (host.length() > 0) {
                            ((RequestBuilder) objectRef.element).url(replaceHost(request.getUrl(), host));
                        }
                        if (requestInterceptorList != null) {
                            it = requestInterceptorList.iterator();
                            objectRef2 = objectRef;
                            if (it.hasNext()) {
                            }
                        }
                        return ((RequestBuilder) objectRef.element).build();
                    }
                } else if (i == 1) {
                    request = (Request) kmpNetworkManagerImpl$preprocessRequest$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef2 = (Ref.ObjectRef) kmpNetworkManagerImpl$preprocessRequest$1.L$2;
                    it = (Iterator) kmpNetworkManagerImpl$preprocessRequest$1.L$1;
                    Ref.ObjectRef objectRef3 = (Ref.ObjectRef) kmpNetworkManagerImpl$preprocessRequest$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    objectRef2.element = obj;
                    objectRef2 = objectRef3;
                    if (it.hasNext()) {
                        IRequestInterceptor iRequestInterceptor = (IRequestInterceptor) it.next();
                        RequestBuilder requestBuilder = (RequestBuilder) objectRef2.element;
                        kmpNetworkManagerImpl$preprocessRequest$1.L$0 = objectRef2;
                        kmpNetworkManagerImpl$preprocessRequest$1.L$1 = it;
                        kmpNetworkManagerImpl$preprocessRequest$1.L$2 = objectRef2;
                        kmpNetworkManagerImpl$preprocessRequest$1.label = 2;
                        obj = iRequestInterceptor.intercept(requestBuilder, kmpNetworkManagerImpl$preprocessRequest$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef3 = objectRef2;
                        objectRef2.element = obj;
                        objectRef2 = objectRef3;
                        if (it.hasNext()) {
                            objectRef = objectRef2;
                            return ((RequestBuilder) objectRef.element).build();
                        }
                    }
                }
                Request request3 = (Request) obj;
                request2 = request;
                request = request3;
                objectRef = new Ref.ObjectRef();
                objectRef.element = request.newBuilder();
                ((RequestBuilder) objectRef.element).headers(addTTNetHeader(request2, MapsKt.toMutableMap(request.getHeaders())));
                requestInterceptorList = request.getReqContext().getRequestInterceptorList();
                host = request.getReqContext().getHost();
                list = requestInterceptorList;
                if (list != null || list.isEmpty()) {
                }
                if (host.length() > 0) {
                }
                if (requestInterceptorList != null) {
                }
                return ((RequestBuilder) objectRef.element).build();
            }
        }
        kmpNetworkManagerImpl$preprocessRequest$1 = new KmpNetworkManagerImpl$preprocessRequest$1(this, continuation);
        Object obj2 = kmpNetworkManagerImpl$preprocessRequest$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kmpNetworkManagerImpl$preprocessRequest$1.label;
        if (i != 0) {
        }
        Request request32 = (Request) obj2;
        request2 = request;
        request = request32;
        objectRef = new Ref.ObjectRef();
        objectRef.element = request.newBuilder();
        ((RequestBuilder) objectRef.element).headers(addTTNetHeader(request2, MapsKt.toMutableMap(request.getHeaders())));
        requestInterceptorList = request.getReqContext().getRequestInterceptorList();
        host = request.getReqContext().getHost();
        list = requestInterceptorList;
        if (list != null || list.isEmpty()) {
        }
        if (host.length() > 0) {
        }
        if (requestInterceptorList != null) {
        }
        return ((RequestBuilder) objectRef.element).build();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x009e -> B:10:0x009f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object postProcessResponse(Response response, Continuation<? super Response> continuation) {
        KmpNetworkManagerImpl$postProcessResponse$1 kmpNetworkManagerImpl$postProcessResponse$1;
        int i;
        Ref.ObjectRef objectRef;
        Iterator it;
        Ref.ObjectRef objectRef2;
        if (continuation instanceof KmpNetworkManagerImpl$postProcessResponse$1) {
            kmpNetworkManagerImpl$postProcessResponse$1 = (KmpNetworkManagerImpl$postProcessResponse$1) continuation;
            if ((kmpNetworkManagerImpl$postProcessResponse$1.label & Integer.MIN_VALUE) != 0) {
                kmpNetworkManagerImpl$postProcessResponse$1.label -= Integer.MIN_VALUE;
                Object obj = kmpNetworkManagerImpl$postProcessResponse$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = kmpNetworkManagerImpl$postProcessResponse$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    List<IResponseInterceptor> responseInterceptorList = response.getRequest().getReqContext().getResponseInterceptorList();
                    if (responseInterceptorList == null || responseInterceptorList.isEmpty()) {
                        return response;
                    }
                    objectRef = new Ref.ObjectRef();
                    objectRef.element = response.newBuilder();
                    List<IResponseInterceptor> responseInterceptorList2 = response.getRequest().getReqContext().getResponseInterceptorList();
                    if (responseInterceptorList2 != null) {
                        it = responseInterceptorList2.iterator();
                        objectRef2 = objectRef;
                        if (it.hasNext()) {
                        }
                    }
                    return ((ResponseBuilder) objectRef.element).build();
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef2 = (Ref.ObjectRef) kmpNetworkManagerImpl$postProcessResponse$1.L$2;
                it = (Iterator) kmpNetworkManagerImpl$postProcessResponse$1.L$1;
                Ref.ObjectRef objectRef3 = (Ref.ObjectRef) kmpNetworkManagerImpl$postProcessResponse$1.L$0;
                ResultKt.throwOnFailure(obj);
                objectRef2.element = obj;
                objectRef2 = objectRef3;
                if (it.hasNext()) {
                    IResponseInterceptor iResponseInterceptor = (IResponseInterceptor) it.next();
                    ResponseBuilder responseBuilder = (ResponseBuilder) objectRef2.element;
                    kmpNetworkManagerImpl$postProcessResponse$1.L$0 = objectRef2;
                    kmpNetworkManagerImpl$postProcessResponse$1.L$1 = it;
                    kmpNetworkManagerImpl$postProcessResponse$1.L$2 = objectRef2;
                    kmpNetworkManagerImpl$postProcessResponse$1.label = 1;
                    obj = iResponseInterceptor.intercept(responseBuilder, kmpNetworkManagerImpl$postProcessResponse$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef3 = objectRef2;
                    objectRef2.element = obj;
                    objectRef2 = objectRef3;
                    if (it.hasNext()) {
                        objectRef = objectRef2;
                        return ((ResponseBuilder) objectRef.element).build();
                    }
                }
            }
        }
        kmpNetworkManagerImpl$postProcessResponse$1 = new KmpNetworkManagerImpl$postProcessResponse$1(this, continuation);
        Object obj2 = kmpNetworkManagerImpl$postProcessResponse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kmpNetworkManagerImpl$postProcessResponse$1.label;
        if (i != 0) {
        }
    }

    private final String replaceHost(String url, String newHost) {
        String str;
        String str2 = url;
        int indexOf$default = StringsKt.indexOf$default(str2, "://", 0, false, 6, (Object) null);
        String str3 = "";
        if (indexOf$default != -1) {
            String substring = url.substring(0, indexOf$default + 3);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            str = substring;
        } else {
            str = "";
        }
        int indexOf$default2 = StringsKt.indexOf$default(str2, '/', str.length(), false, 4, (Object) null);
        if (indexOf$default2 != -1) {
            str3 = url.substring(indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(str3, "substring(...)");
        }
        if (StringsKt.contains$default(newHost, "http", false, 2, (Object) null)) {
            return newHost + str3;
        }
        return str + newHost + str3;
    }

    private final Map<String, String> addTTNetHeader(Request request, Map<String, String> headers) {
        String str = "1";
        if (KmpNetworkSetting.INSTANCE.getDisableTTNetLogReport()) {
            headers.put("x-metasec-bypass-api-log", "1");
        }
        if (request.getReqContext().getDnsConfig() != null) {
            DnsConfigSerializable dnsConfigSerializable = new DnsConfigSerializable((String) null, (String) null, 3, (DefaultConstructorMarker) null);
            DnsConfig dnsConfig = request.getReqContext().getDnsConfig();
            Intrinsics.checkNotNull(dnsConfig);
            if (dnsConfig.getPreferIP().length() > 0) {
                DnsConfig dnsConfig2 = request.getReqContext().getDnsConfig();
                Intrinsics.checkNotNull(dnsConfig2);
                dnsConfigSerializable.setPrefer_ip(dnsConfig2.getPreferIP());
            }
            DnsConfig dnsConfig3 = request.getReqContext().getDnsConfig();
            Intrinsics.checkNotNull(dnsConfig3);
            if (dnsConfig3.getBackupIP().length() > 0) {
                DnsConfig dnsConfig4 = request.getReqContext().getDnsConfig();
                Intrinsics.checkNotNull(dnsConfig4);
                dnsConfigSerializable.setBackup_ip(dnsConfig4.getBackupIP());
            }
            StringFormat json = KmpNetworkManager.INSTANCE.getJson();
            json.getSerializersModule();
            headers.put("x-ttnet-dns-config", json.encodeToString(DnsConfigSerializable.INSTANCE.serializer(), dnsConfigSerializable));
        }
        if (request.getReqContext().getProtocol() != Protocol.UNKNOWN) {
            int i = WhenMappings.$EnumSwitchMapping$0[request.getReqContext().getProtocol().ordinal()];
            if (i != 1 && i != 2) {
                str = i != 3 ? i != 4 ? null : "3" : "2";
            }
            if (str != null) {
                headers.put("x-ttnet-http-proto-type", str);
            }
        }
        return headers;
    }
}
