package com.bytedance.trae.kmp.network;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.kmp.network.IKmpNetworkService;
import com.bytedance.kmp.network.NetError;
import com.bytedance.kmp.network.Protocol;
import com.bytedance.kmp.network.nqe.NQEListener;
import com.bytedance.kmp.network.nqe.NetworkQualityState;
import com.bytedance.kmp.network.requet.Request;
import com.bytedance.kmp.network.requet.RequestBody;
import com.bytedance.kmp.network.response.Response;
import com.bytedance.kmp.network.response.ResponseBody;
import com.bytedance.kmp.network.response.ResponseCallback;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.Source;

/* compiled from: TraeKmpNetworkService.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002#$B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001fH\u0002J\u0016\u0010 \u001a\u0004\u0018\u00010\u0011*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001fH\u0002J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0002¨\u0006%"}, d2 = {"Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService;", "Lcom/bytedance/kmp/network/IKmpNetworkService;", "<init>", "()V", "execute", "Lcom/bytedance/kmp/network/response/Response;", "request", "Lcom/bytedance/kmp/network/requet/Request;", "(Lcom/bytedance/kmp/network/requet/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeStream", "", "callback", "Lcom/bytedance/kmp/network/response/ResponseCallback;", "(Lcom/bytedance/kmp/network/requet/Request;Lcom/bytedance/kmp/network/response/ResponseCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "preConnect", "url", "", "registerNQEListener", "listener", "Lcom/bytedance/kmp/network/nqe/NQEListener;", "getNetworkQualityState", "Lcom/bytedance/kmp/network/nqe/NetworkQualityState;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "baseUrlOf", "readBody", "", "body", "Lcom/bytedance/kmp/network/requet/RequestBody;", "successResponse", "ssResponse", "Lcom/bytedance/retrofit2/SsResponse;", "readRawBody", "errorResponse", "message", "KmpBridgeApi", "StringResponseBody", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeKmpNetworkService implements IKmpNetworkService {
    public static final int $stable = 0;

    /* compiled from: TraeKmpNetworkService.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0001H'JB\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0001H'¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService$KmpBridgeApi;", "", PrefetchRequestConfig.METHOD_GET, "Lcom/bytedance/retrofit2/Call;", "", "url", "headers", "", "Lcom/bytedance/retrofit2/client/Header;", "extraInfo", PrefetchRequestConfig.METHOD_POST, "body", "Lcom/bytedance/retrofit2/mime/TypedByteArray;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private interface KmpBridgeApi {
        @GET
        Call<String> get(@Url String url, @HeaderList List<Header> headers, @ExtraInfo Object extraInfo);

        @POST
        Call<String> post(@Url String url, @Body TypedByteArray body, @HeaderList List<Header> headers, @ExtraInfo Object extraInfo);
    }

    @Override // com.bytedance.kmp.network.IKmpNetworkService
    public void cancel(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
    }

    @Override // com.bytedance.kmp.network.IKmpNetworkService
    public void preConnect(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // com.bytedance.kmp.network.IKmpNetworkService
    public void registerNQEListener(NQEListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.bytedance.kmp.network.IKmpNetworkService
    public Object execute(Request request, Continuation<? super Response> continuation) {
        Call<String> call;
        byte[] bArr;
        String str;
        String url = request.getUrl();
        String upperCase = request.getMethod().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        Map<String, String> headers = request.getHeaders();
        ArrayList arrayList = new ArrayList(headers.size());
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        ArrayList arrayList2 = arrayList;
        KmpBridgeApi kmpBridgeApi = (KmpBridgeApi) RetrofitUtils.createSsService(baseUrlOf(url), KmpBridgeApi.class);
        if (kmpBridgeApi == null) {
            return errorResponse(request, "TTNet not initialized");
        }
        try {
            RequestContext requestContext = new RequestContext();
            requestContext.force_handle_response = true;
            if (Intrinsics.areEqual(upperCase, "POST")) {
                RequestBody body = request.getBody();
                if (body == null || (bArr = readBody(body)) == null) {
                    bArr = new byte[0];
                }
                if (body == null || (str = body.getContentType()) == null) {
                    str = "application/json; charset=UTF-8";
                }
                call = kmpBridgeApi.post(url, new TypedByteArray(str, bArr, new String[0]), arrayList2, requestContext);
            } else {
                call = kmpBridgeApi.get(url, arrayList2, requestContext);
            }
            SsResponse<String> execute = call.execute();
            Intrinsics.checkNotNull(execute);
            return successResponse(request, execute);
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message == null) {
                message = th.toString();
            }
            return errorResponse(request, message);
        }
    }

    @Override // com.bytedance.kmp.network.IKmpNetworkService
    public Object executeStream(Request request, ResponseCallback responseCallback, Continuation<? super Unit> continuation) {
        Object onError = responseCallback.onError(errorResponse(request, "executeStream not supported"), continuation);
        return onError == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onError : Unit.INSTANCE;
    }

    @Override // com.bytedance.kmp.network.IKmpNetworkService
    public Object getNetworkQualityState(Continuation<? super NetworkQualityState> continuation) {
        return new NetworkQualityState(null, null, null, null, 15, null);
    }

    private final String baseUrlOf(String url) {
        String str = url;
        int indexOf$default = StringsKt.indexOf$default(str, "://", 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            return url;
        }
        int indexOf$default2 = StringsKt.indexOf$default(str, '/', indexOf$default + 3, false, 4, (Object) null);
        if (indexOf$default2 >= 0) {
            url = url.substring(0, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(url, "substring(...)");
        }
        return url + '/';
    }

    private final byte[] readBody(RequestBody body) {
        Buffer buffer = new Buffer();
        body.writeTo((BufferedSink) buffer);
        return buffer.readByteArray();
    }

    private final Response successResponse(Request request, SsResponse<String> ssResponse) {
        Protocol protocol = Protocol.HTTP_1_1;
        String message = ssResponse.message();
        if (message == null) {
            message = "OK";
        }
        String str = message;
        int code = ssResponse.code();
        List<Header> headers = ssResponse.headers();
        Intrinsics.checkNotNullExpressionValue(headers, "headers(...)");
        List<Header> list = headers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Header header : list) {
            String name = header.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            String value = header.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            arrayList.add(new com.bytedance.kmp.network.Header(name, value));
        }
        ArrayList arrayList2 = arrayList;
        String readRawBody = readRawBody(ssResponse);
        return new Response(request, protocol, str, code, arrayList2, readRawBody != null ? new StringResponseBody(readRawBody) : null, null, null);
    }

    private final String readRawBody(SsResponse<String> ssResponse) {
        InputStream mo349in;
        String body = ssResponse.body();
        if (body != null) {
            return body;
        }
        TypedInput errorBody = ssResponse.errorBody();
        if (errorBody == null || (mo349in = errorBody.mo349in()) == null) {
            return null;
        }
        Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String readText = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, (Throwable) null);
            return readText;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    private final Response errorResponse(Request request, String message) {
        NetError netError = new NetError();
        netError.setErrorMessage(message);
        return new Response(request, Protocol.UNKNOWN, message, -1, CollectionsKt.emptyList(), null, netError, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TraeKmpNetworkService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService$StringResponseBody;", "Lcom/bytedance/kmp/network/response/ResponseBody;", "content", "", "<init>", "(Ljava/lang/String;)V", "bytes", "", "contentType", "contentLength", "", "byteStream", "Lokio/Source;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class StringResponseBody extends ResponseBody {
        private final byte[] bytes;
        private final String content;

        @Override // com.bytedance.kmp.network.response.ResponseBody
        /* renamed from: contentType */
        public String getContentType() {
            return "application/json; charset=UTF-8";
        }

        public StringResponseBody(String str) {
            Intrinsics.checkNotNullParameter(str, "content");
            this.content = str;
            this.bytes = StringsKt.encodeToByteArray(str);
        }

        @Override // com.bytedance.kmp.network.response.ResponseBody
        public long contentLength() {
            return this.bytes.length;
        }

        @Override // com.bytedance.kmp.network.response.ResponseBody
        public Source byteStream() {
            return new Buffer().write(this.bytes);
        }
    }
}
