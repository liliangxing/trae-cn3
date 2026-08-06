package com.bytedance.forest.pollyfill;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.model.DefaultConfig;
import com.bytedance.forest.pollyfill.ForestNetAPI;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.OfflineUtil;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HEAD;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TTNetDepender.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0004\u0016\u0017\u0018\u0019B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0017J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u001a"}, d2 = {"Lcom/bytedance/forest/pollyfill/DefaultForestNetAPI;", "Lcom/bytedance/forest/pollyfill/ForestNetAPI;", "()V", "createHttpRequest", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpRequest;", "webResourceRequest", "Landroid/webkit/WebResourceRequest;", "sourceUrl", "", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "url", "headers", "", "get", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;", "httpRequest", "head", "reportCDNPerfInfo", "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/retrofit2/client/Response;", "Companion", "DefaultRequest", "DefaultResponse", "NetApi", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class DefaultForestNetAPI extends ForestNetAPI {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TTNetDepender.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001JJ\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00012\b\b\u0003\u0010\n\u001a\u00020\u000bH'J@\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0001H'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/forest/pollyfill/DefaultForestNetAPI$NetApi;", "", "doGet", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "url", "", "headerMap", "", "extraInfo", "addCommonParam", "", "doHead", "Ljava/lang/Void;", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface NetApi {
        @GET
        @Streaming
        Call<TypedInput> doGet(@Url String url, @HeaderMap Map<String, String> headerMap, @ExtraInfo Object extraInfo, @AddCommonParam boolean addCommonParam);

        @HEAD
        @Streaming
        Call<Void> doHead(@Url String url, @HeaderMap Map<String, String> headerMap, @ExtraInfo Object extraInfo);

        /* compiled from: TTNetDepender.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ Call doGet$default(NetApi netApi, String str, Map map, Object obj, boolean z, int i, Object obj2) {
                if (obj2 != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doGet");
                }
                if ((i & 8) != 0) {
                    z = false;
                }
                return netApi.doGet(str, map, obj, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TTNetDepender.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R \u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/forest/pollyfill/DefaultForestNetAPI$DefaultRequest;", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpRequest;", "url", "", "headers", "", "webResourceRequest", "Landroid/webkit/WebResourceRequest;", "(Ljava/lang/String;Ljava/util/Map;Landroid/webkit/WebResourceRequest;)V", JsCallParser.VALUE_CALL, "Lcom/bytedance/retrofit2/Call;", "getCall", "()Lcom/bytedance/retrofit2/Call;", "setCall", "(Lcom/bytedance/retrofit2/Call;)V", "cancel", "", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class DefaultRequest extends ForestNetAPI.HttpRequest {
        private Call<?> call;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ DefaultRequest(String str, Map map, WebResourceRequest webResourceRequest, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, map, webResourceRequest);
            if ((i & 4) != 0) {
                webResourceRequest = null;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DefaultRequest(String str, Map<String, String> map, WebResourceRequest webResourceRequest) {
            super(str, map, webResourceRequest);
            Intrinsics.checkParameterIsNotNull(str, "url");
            Intrinsics.checkParameterIsNotNull(map, "headers");
        }

        public final Call<?> getCall() {
            return this.call;
        }

        public final void setCall(Call<?> call) {
            this.call = call;
        }

        @Override // com.bytedance.forest.pollyfill.ForestNetAPI.HttpRequest
        public void cancel() {
            Unit unit;
            try {
                Result.Companion companion = Result.Companion;
                Call<?> call = this.call;
                if (call != null) {
                    call.cancel();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Result.constructor-impl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
    }

    /* compiled from: TTNetDepender.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/forest/pollyfill/DefaultForestNetAPI$Companion;", "", "()V", "toMap", "", "", "headerList", "", "Lcom/bytedance/retrofit2/client/Header;", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<String, String> toMap(List<Header> headerList) {
            Intrinsics.checkParameterIsNotNull(headerList, "headerList");
            HashMap hashMap = new HashMap();
            for (Header header : headerList) {
                String name = header.getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "header.name");
                Locale locale = Locale.ENGLISH;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ENGLISH");
                if (name == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = name.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                hashMap.put(lowerCase, header.getValue());
            }
            return hashMap;
        }
    }

    /* compiled from: TTNetDepender.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\nB?\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/forest/pollyfill/DefaultForestNetAPI$DefaultResponse;", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/retrofit2/client/Response;", "request", "Lcom/bytedance/forest/pollyfill/DefaultForestNetAPI$DefaultRequest;", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "(Lcom/bytedance/retrofit2/client/Response;Lcom/bytedance/forest/pollyfill/DefaultForestNetAPI$DefaultRequest;Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;", "(Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;Lcom/bytedance/forest/pollyfill/DefaultForestNetAPI$DefaultRequest;Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "statusCode", "", "errorMsg", "", "headers", "", "(ILjava/lang/String;Ljava/util/Map;Lcom/bytedance/forest/pollyfill/DefaultForestNetAPI$DefaultRequest;Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "getSize", "()Ljava/lang/Integer;", "provideInputStream", "Ljava/io/InputStream;", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static final class DefaultResponse extends ForestNetAPI.HttpResponse {
        private final ForestPipelineContext context;
        private Response response;

        /* synthetic */ DefaultResponse(int i, String str, Map map, DefaultRequest defaultRequest, ForestPipelineContext forestPipelineContext, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? "" : str, map, defaultRequest, forestPipelineContext);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private DefaultResponse(int i, String str, HashMap hashMap, DefaultRequest defaultRequest, ForestPipelineContext forestPipelineContext) {
            super(r10 != null ? r10.intValue() : -1, str, hashMap == null ? new HashMap() : hashMap, defaultRequest, 0L, 16, null);
            Integer valueOf = Integer.valueOf(i);
            valueOf = valueOf.intValue() != 0 ? valueOf : null;
            this.context = forestPipelineContext;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DefaultResponse(Response response, DefaultRequest defaultRequest, ForestPipelineContext forestPipelineContext) {
            this(response.getStatus(), null, r0.toMap(r1), defaultRequest, forestPipelineContext, 2, null);
            Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
            Intrinsics.checkParameterIsNotNull(defaultRequest, "request");
            Intrinsics.checkParameterIsNotNull(forestPipelineContext, "context");
            Companion companion = DefaultForestNetAPI.INSTANCE;
            List<Header> headers = response.getHeaders();
            Intrinsics.checkExpressionValueIsNotNull(headers, "response.headers");
            this.response = response;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DefaultResponse(HttpResponseException httpResponseException, DefaultRequest defaultRequest, ForestPipelineContext forestPipelineContext) {
            this(r2, r8 == null ? "" : r8, new HashMap(), defaultRequest, forestPipelineContext);
            Intrinsics.checkParameterIsNotNull(httpResponseException, ApmTrafficStats.TTNET_RESPONSE);
            Intrinsics.checkParameterIsNotNull(defaultRequest, "request");
            Intrinsics.checkParameterIsNotNull(forestPipelineContext, "context");
            int statusCode = httpResponseException.getStatusCode();
            String message = httpResponseException.getMessage();
        }

        @Override // com.bytedance.forest.pollyfill.ForestNetAPI.HttpResponse
        public InputStream provideInputStream() {
            TypedInput body;
            String str = getResponseHttpHeader().get(OfflineUtil.CONTENT_LENGTH_HEADER);
            Integer intOrNull = str != null ? StringsKt.toIntOrNull(str) : null;
            if (intOrNull != null && intOrNull.intValue() == 0) {
                return new ByteArrayInputStream(new byte[0]);
            }
            try {
                Response response = this.response;
                InputStream in = (response == null || (body = response.getBody()) == null) ? null : body.in();
                if (in == null) {
                    ForestLogger.print$default(this.context.getLogger(), 6, TTNetDepender.TAG, "response in empty when providing input stream", true, null, null, 48, null);
                }
                return in;
            } catch (Exception e) {
                ForestLogger.print$default(this.context.getLogger(), 6, TTNetDepender.TAG, "error occurs when getting input stream from response", true, e, null, 32, null);
                return null;
            }
        }

        @Override // com.bytedance.forest.pollyfill.ForestNetAPI.HttpResponse
        public Integer getSize() {
            Object obj;
            TypedInput body;
            try {
                Result.Companion companion = Result.Companion;
                Response response = this.response;
                obj = Result.constructor-impl((response == null || (body = response.getBody()) == null) ? null : Integer.valueOf((int) body.length()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Integer num = (Integer) (Result.isFailure-impl(obj) ? null : obj);
            return num != null ? num : super.getSize();
        }
    }

    @Override // com.bytedance.forest.pollyfill.ForestNetAPI
    public ForestNetAPI.HttpResponse get(ForestNetAPI.HttpRequest httpRequest, ForestPipelineContext context) {
        DefaultResponse defaultResponse;
        String message;
        Call<?> doGet$default;
        Intrinsics.checkParameterIsNotNull(httpRequest, "httpRequest");
        Intrinsics.checkParameterIsNotNull(context, "context");
        DefaultRequest defaultRequest = (DefaultRequest) (!(httpRequest instanceof DefaultRequest) ? null : httpRequest);
        if (defaultRequest != null) {
            try {
                RequestContext requestContext = new RequestContext();
                requestContext.protect_timeout = DefaultConfig.INSTANCE.getCDN_TIMEOUT();
                doGet$default = NetApi.DefaultImpls.doGet$default((NetApi) RetrofitUtils.createSsService(httpRequest.getUrl(), NetApi.class), httpRequest.getUrl(), httpRequest.getHeaders$forest_release(), requestContext, false, 8, null);
            } catch (HttpResponseException e) {
                defaultResponse = new DefaultResponse(e, (DefaultRequest) httpRequest, context);
            } catch (CronetIOException e2) {
                HttpResponseException cause = e2.getCause();
                HttpResponseException httpResponseException = cause instanceof HttpResponseException ? cause : null;
                if (httpResponseException == null) {
                    int statusCode = e2.getStatusCode();
                    Throwable cause2 = e2.getCause();
                    if (cause2 == null || (message = cause2.getMessage()) == null) {
                        message = e2.getMessage();
                    }
                    httpResponseException = new HttpResponseException(statusCode, message);
                }
                defaultResponse = new DefaultResponse(httpResponseException, (DefaultRequest) httpRequest, context);
            }
            if (doGet$default == null) {
                throw new ForestNetAPI.HttpResponse.Companion.ForestNetException("create response failed");
            }
            defaultRequest.setCall(doGet$default);
            Response raw = doGet$default.execute().raw();
            Intrinsics.checkExpressionValueIsNotNull(raw, ApmTrafficStats.TTNET_RESPONSE);
            reportCDNPerfInfo(raw, context);
            defaultResponse = new DefaultResponse(raw, (DefaultRequest) httpRequest, context);
            return defaultResponse;
        }
        throw new ForestNetAPI.HttpResponse.Companion.ForestNetException("The HTTP request is not expected type");
    }

    private final void reportCDNPerfInfo(Response response, ForestPipelineContext context) {
        Object extraInfo = response.getExtraInfo();
        if (!(extraInfo instanceof HttpRequestInfo)) {
            extraInfo = null;
        }
        HttpRequestInfo httpRequestInfo = (HttpRequestInfo) extraInfo;
        if (httpRequestInfo != null) {
            context.recordPerformanceTiming$forest_release(new String[]{"cdn_ttnet_app_level_request_start"}, Long.valueOf(httpRequestInfo.appLevelRequestStart));
            context.recordPerformanceTiming$forest_release(new String[]{"cdn_ttnet_before_all_interceptors"}, Long.valueOf(httpRequestInfo.beforeAllInterceptors));
            context.recordPerformanceTiming$forest_release(new String[]{"cdn_ttnet_request_start"}, Long.valueOf(httpRequestInfo.requestStart));
            context.recordPerformanceTiming$forest_release(new String[]{"cdn_ttnet_response_back"}, Long.valueOf(httpRequestInfo.responseBack));
        }
        List<Header> headers = response.getHeaders();
        Intrinsics.checkExpressionValueIsNotNull(headers, "response.headers");
        context.recordCDNHeaderInfo$forest_release(headers);
    }

    @Override // com.bytedance.forest.pollyfill.ForestNetAPI
    public ForestNetAPI.HttpResponse head(ForestNetAPI.HttpRequest httpRequest, ForestPipelineContext context) {
        Intrinsics.checkParameterIsNotNull(httpRequest, "httpRequest");
        Intrinsics.checkParameterIsNotNull(context, "context");
        DefaultRequest defaultRequest = (DefaultRequest) (!(httpRequest instanceof DefaultRequest) ? null : httpRequest);
        if (defaultRequest != null) {
            try {
                NetApi netApi = (NetApi) RetrofitUtils.createSsService(httpRequest.getUrl(), NetApi.class);
                String url = httpRequest.getUrl();
                ConcurrentHashMap<String, String> headers$forest_release = httpRequest.getHeaders$forest_release();
                Call<Void> doHead = netApi.doHead(url, headers$forest_release != null ? headers$forest_release : MapsKt.emptyMap(), null);
                if (doHead == null) {
                    throw new ForestNetAPI.HttpResponse.Companion.ForestNetException("create response failed");
                }
                defaultRequest.setCall(doHead);
                Response raw = doHead.execute().raw();
                Intrinsics.checkExpressionValueIsNotNull(raw, "call.execute().raw()");
                return new DefaultResponse(raw, (DefaultRequest) httpRequest, context);
            } catch (HttpResponseException e) {
                return new DefaultResponse(e, (DefaultRequest) httpRequest, context);
            }
        }
        throw new ForestNetAPI.HttpResponse.Companion.ForestNetException("The HTTP request is not expected type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r4 != null) goto L14;
     */
    @Override // com.bytedance.forest.pollyfill.ForestNetAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ForestNetAPI.HttpRequest createHttpRequest(WebResourceRequest webResourceRequest, String sourceUrl, ForestPipelineContext context) {
        Intrinsics.checkParameterIsNotNull(webResourceRequest, "webResourceRequest");
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (sourceUrl != null) {
            if (!(!StringsKt.isBlank(sourceUrl))) {
                sourceUrl = null;
            }
        }
        Uri url = webResourceRequest.getUrl();
        sourceUrl = url != null ? url.toString() : null;
        if (sourceUrl == null) {
            sourceUrl = "";
        }
        String substringBefore$default = StringsKt.substringBefore$default(sourceUrl, '#', (String) null, 2, (Object) null);
        HashMap requestHeaders = webResourceRequest.getRequestHeaders();
        requestHeaders.remove("If-Modified-Since");
        requestHeaders.remove("If-None-Match");
        if (requestHeaders == null) {
            requestHeaders = new HashMap();
        }
        return new DefaultRequest(substringBefore$default, requestHeaders, webResourceRequest);
    }

    @Override // com.bytedance.forest.pollyfill.ForestNetAPI
    public ForestNetAPI.HttpRequest createHttpRequest(String url, Map<String, String> headers, ForestPipelineContext context) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new DefaultRequest(StringsKt.substringBefore$default(url, '#', (String) null, 2, (Object) null), headers, null, 4, null);
    }
}
