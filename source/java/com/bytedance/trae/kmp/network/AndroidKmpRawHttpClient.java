package com.bytedance.trae.kmp.network;

import com.bytedance.kmp.network.Header;
import com.bytedance.kmp.network.KmpNetworkManager;
import com.bytedance.kmp.network.requet.Request;
import com.bytedance.kmp.network.response.Response;
import com.bytedance.kmp.network.response.ResponseBody;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: AndroidKmpRawHttpClient.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012$\b\u0002\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0004\b\n\u0010\u000bJF\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016JB\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;", "Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;", "requestFactory", "Lcom/bytedance/trae/kmp/network/AndroidKmpRequestFactory;", "executeRequest", "Lkotlin/Function2;", "Lcom/bytedance/kmp/network/requet/Request;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/kmp/network/response/Response;", "", "<init>", "(Lcom/bytedance/trae/kmp/network/AndroidKmpRequestFactory;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getRaw", "Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;", "url", "", "headers", "", "queries", "options", "Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postRaw", "body", "contentType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "request", "(Lcom/bytedance/kmp/network/requet/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidKmpRawHttpClient implements KmpRawHttpClient {
    public static final int $stable = 8;
    private final Function2<Request, Continuation<? super Response>, Object> executeRequest;
    private final AndroidKmpRequestFactory requestFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AndroidKmpRawHttpClient() {
        this(r0, r0, 3, r0);
        AndroidKmpRequestFactory androidKmpRequestFactory = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidKmpRawHttpClient(AndroidKmpRequestFactory androidKmpRequestFactory, Function2<? super Request, ? super Continuation<? super Response>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(androidKmpRequestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(function2, "executeRequest");
        this.requestFactory = androidKmpRequestFactory;
        this.executeRequest = function2;
    }

    public /* synthetic */ AndroidKmpRawHttpClient(AndroidKmpRequestFactory androidKmpRequestFactory, C08132 c08132, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new AndroidKmpRequestFactory() { // from class: com.bytedance.trae.kmp.network.AndroidKmpRawHttpClient$$ExternalSyntheticLambda0
            @Override // com.bytedance.trae.kmp.network.AndroidKmpRequestFactory
            public final Request create(AndroidKmpRequest androidKmpRequest) {
                Request _init_$lambda$0;
                _init_$lambda$0 = AndroidKmpRawHttpClient._init_$lambda$0(androidKmpRequest);
                return _init_$lambda$0;
            }
        } : androidKmpRequestFactory, (i & 2) != 0 ? new C08132(null) : c08132);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request _init_$lambda$0(AndroidKmpRequest androidKmpRequest) {
        Request constructRequest;
        Intrinsics.checkNotNullParameter(androidKmpRequest, "request");
        constructRequest = KmpNetworkManager.INSTANCE.constructRequest(androidKmpRequest.getUrl(), androidKmpRequest.getMethod(), (r29 & 4) != 0 ? null : androidKmpRequest.getQueries(), (r29 & 8) != 0 ? null : androidKmpRequest.getHeaders(), (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? null : null, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? null : null, (r29 & 512) != 0 ? null : androidKmpRequest.getBody(), (r29 & 1024) != 0 ? null : androidKmpRequest.getContentType(), (r29 & 2048) != 0 ? null : null);
        return constructRequest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AndroidKmpRawHttpClient.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/kmp/network/response/Response;", "request", "Lcom/bytedance/kmp/network/requet/Request;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.kmp.network.AndroidKmpRawHttpClient$2", f = "AndroidKmpRawHttpClient.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.kmp.network.AndroidKmpRawHttpClient$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08132 extends SuspendLambda implements Function2<Request, Continuation<? super Response>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C08132(Continuation<? super C08132> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c08132 = new C08132(continuation);
            c08132.L$0 = obj;
            return c08132;
        }

        public final Object invoke(Request request, Continuation<? super Response> continuation) {
            return create(request, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Request request = (Request) this.L$0;
                this.label = 1;
                obj = KmpNetworkManager.INSTANCE.execute(request, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Override // com.bytedance.trae.kmp.network.KmpRawHttpClient
    public Object getRaw(String str, Map<String, String> map, Map<String, String> map2, KmpHttpRequestOptions kmpHttpRequestOptions, Continuation<? super KmpRawHttpResult> continuation) {
        return execute(this.requestFactory.create(new AndroidKmpRequest(str, "GET", map, map2, null, null, 48, null)), continuation);
    }

    @Override // com.bytedance.trae.kmp.network.KmpRawHttpClient
    public Object postRaw(String str, String str2, String str3, Map<String, String> map, KmpHttpRequestOptions kmpHttpRequestOptions, Continuation<? super KmpRawHttpResult> continuation) {
        return execute(this.requestFactory.create(new AndroidKmpRequest(str, "POST", map, null, str2, str3, 8, null)), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:10:0x0026, B:11:0x0044, B:13:0x004c, B:14:0x0052, B:15:0x007c, B:17:0x0082, B:19:0x00a0, B:27:0x0039), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082 A[Catch: all -> 0x002a, LOOP:0: B:15:0x007c->B:17:0x0082, LOOP_END, TryCatch #0 {all -> 0x002a, blocks: (B:10:0x0026, B:11:0x0044, B:13:0x004c, B:14:0x0052, B:15:0x007c, B:17:0x0082, B:19:0x00a0, B:27:0x0039), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(Request request, Continuation<? super KmpRawHttpResult> continuation) {
        AndroidKmpRawHttpClient$execute$1 androidKmpRawHttpClient$execute$1;
        int i;
        Integer httpStatusCodeOrNull;
        String str;
        try {
            if (continuation instanceof AndroidKmpRawHttpClient$execute$1) {
                androidKmpRawHttpClient$execute$1 = (AndroidKmpRawHttpClient$execute$1) continuation;
                if ((androidKmpRawHttpClient$execute$1.label & Integer.MIN_VALUE) != 0) {
                    androidKmpRawHttpClient$execute$1.label -= Integer.MIN_VALUE;
                    Object obj = androidKmpRawHttpClient$execute$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = androidKmpRawHttpClient$execute$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Function2<Request, Continuation<? super Response>, Object> function2 = this.executeRequest;
                        androidKmpRawHttpClient$execute$1.label = 1;
                        obj = function2.invoke(request, androidKmpRawHttpClient$execute$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Response response = (Response) obj;
                    ResponseBody body = response.getBody();
                    String string = body == null ? body.string() : null;
                    int code = response.getCode();
                    String message = response.getMessage();
                    List<Header> headers = response.getHeaders();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(headers, 10)), 16));
                    for (Header header : headers) {
                        Pair pair = TuplesKt.to(header.getName(), header.getValue());
                        linkedHashMap.put(pair.getFirst(), pair.getSecond());
                    }
                    return new KmpRawHttpResult(string, code, message, linkedHashMap, response.getError());
                }
            }
            if (i != 0) {
            }
            Response response2 = (Response) obj;
            ResponseBody body2 = response2.getBody();
            String string2 = body2 == null ? body2.string() : null;
            int code2 = response2.getCode();
            String message2 = response2.getMessage();
            List<Header> headers2 = response2.getHeaders();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(headers2, 10)), 16));
            while (r7.hasNext()) {
            }
            return new KmpRawHttpResult(string2, code2, message2, linkedHashMap2, response2.getError());
        } catch (Throwable th) {
            httpStatusCodeOrNull = AndroidKmpRawHttpClientKt.httpStatusCodeOrNull(th);
            int intValue = httpStatusCodeOrNull != null ? httpStatusCodeOrNull.intValue() : -1;
            if (intValue > 0) {
                str = th.getMessage();
                if (str == null) {
                    str = "HTTP " + intValue;
                }
            } else {
                str = "Network Failure";
            }
            return new KmpRawHttpResult(null, intValue, str, MapsKt.emptyMap(), th);
        }
        androidKmpRawHttpClient$execute$1 = new AndroidKmpRawHttpClient$execute$1(this, continuation);
        Object obj2 = androidKmpRawHttpClient$execute$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidKmpRawHttpClient$execute$1.label;
    }
}
