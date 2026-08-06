package com.bytedance.pia.core.worker.network;

import android.net.Uri;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.pia.core.api.network.IPiaRetrofit;
import com.bytedance.pia.core.api.resource.IResourceLoader;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.api.security.ISecurityDelegate;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ResourceUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.ExpandCallback;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.vmsdk.net.INetCallback;
import com.bytedance.vmsdk.net.IReleasable;
import com.bytedance.vmsdk.net.Request;
import com.bytedance.vmsdk.net.Response;
import com.bytedance.vmsdk.worker.IWorkerDelegate;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* compiled from: WorkerDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J4\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001cH\u0016J\f\u0010 \u001a\u00020!*\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/pia/core/worker/network/WorkerDelegate;", "Lcom/bytedance/vmsdk/worker/IWorkerDelegate;", "logTag", "", "userAgent", "retrofit", "Lcom/bytedance/pia/core/api/network/IPiaRetrofit;", "resourceLoader", "Lcom/bytedance/pia/core/api/resource/IResourceLoader;", "sensitiveHeaders", "", "securityDelegate", "Lcom/bytedance/pia/core/api/security/ISecurityDelegate;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/pia/core/api/network/IPiaRetrofit;Lcom/bytedance/pia/core/api/resource/IResourceLoader;Ljava/util/Map;Lcom/bytedance/pia/core/api/security/ISecurityDelegate;)V", "createBaseUrl", "requestUri", "Landroid/net/Uri;", "fetchWithUrlSync", "url", "getContentType", "headers", "", "Lcom/bytedance/retrofit2/client/Header;", "loadAsync", "Lcom/bytedance/vmsdk/net/IReleasable;", "request", "Lcom/bytedance/vmsdk/net/Request;", "resolve", "Lcom/bytedance/vmsdk/net/INetCallback;", "Lcom/bytedance/vmsdk/net/Response;", "reject", "", "isSensitiveHeadersAllowed", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WorkerDelegate implements IWorkerDelegate {
    private static final String DefaultMimeType = "application/json";
    private static final String KeyContentType = "content-type";
    private static final String KeyFetchParam = "pia-fetch-params";
    private static final String KeyNeedCommonParam = "needCommonParams";
    private static final String KeyUserAgent = "User-Agent";
    private final String logTag;
    private final IResourceLoader resourceLoader;
    private final IPiaRetrofit retrofit;
    private final ISecurityDelegate securityDelegate;
    private final Map<String, String> sensitiveHeaders;
    private final String userAgent;

    public WorkerDelegate(String str, String str2, IPiaRetrofit iPiaRetrofit, IResourceLoader iResourceLoader, Map<String, String> map, ISecurityDelegate iSecurityDelegate) {
        Intrinsics.checkNotNullParameter(str, "logTag");
        Intrinsics.checkNotNullParameter(str2, "userAgent");
        Intrinsics.checkNotNullParameter(iPiaRetrofit, "retrofit");
        Intrinsics.checkNotNullParameter(iResourceLoader, "resourceLoader");
        this.logTag = str;
        this.userAgent = str2;
        this.retrofit = iPiaRetrofit;
        this.resourceLoader = iResourceLoader;
        this.sensitiveHeaders = map;
        this.securityDelegate = iSecurityDelegate;
    }

    public String fetchWithUrlSync(final String url) {
        Object obj;
        if (url == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            WorkerDelegate workerDelegate = this;
            obj = Result.constructor-impl(ResourceUtils.readAsString(this.resourceLoader.load(LoadFrom.Auto, new IResourceRequest() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$fetchWithUrlSync$1$1
                @Override // com.bytedance.pia.core.api.resource.IResourceRequest
                public final Uri getUrl() {
                    return Uri.parse(url);
                }
            })));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (String) (Result.isFailure-impl(obj) ? null : obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:39:0x01f1. Please report as an issue. */
    public IReleasable loadAsync(Request request, final INetCallback<Response> resolve, final INetCallback<Throwable> reject) {
        Object obj;
        JSONObject jSONObject;
        final Call<TypedInput> deleteStreamRequest;
        Logger.i$default(this.logTag + "Begin to fetch (URL: " + (request != null ? request.getUrl() : null) + ')', null, null, 6, null);
        if (request == null || resolve == null || reject == null) {
            if (reject != null) {
                reject.execute(new NullPointerException());
            }
            return null;
        }
        String str = (String) request.getHeaders().remove(KeyFetchParam);
        if (str != null) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(new JSONObject(str));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            jSONObject = (JSONObject) obj;
        } else {
            jSONObject = null;
        }
        Logger.i$default(this.logTag + "Read fetch parameter (Params: " + jSONObject + ')', null, null, 6, null);
        boolean optBoolean = jSONObject != null ? jSONObject.optBoolean(KeyNeedCommonParam, false) : false;
        if (!request.getHeaders().containsKey(KeyUserAgent)) {
            Logger.i$default(this.logTag + "Append 'User-Agent' for fetch (URL: " + request.getUrl() + ')', null, null, 6, null);
            request.getHeaders().put(KeyUserAgent, this.userAgent);
        }
        Map<String, String> map = this.sensitiveHeaders;
        if (!(map == null || map.isEmpty())) {
            String url = request.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "request.url");
            if (isSensitiveHeadersAllowed(url)) {
                Logger.i$default(this.logTag + "Append sensitive headers(Key: " + CollectionsKt.joinToString$default(this.sensitiveHeaders.keySet(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ") for fetch (URL: " + request.getUrl() + ')', null, null, 6, null);
                request.getHeaders().putAll(this.sensitiveHeaders);
            }
        }
        Uri parse = Uri.parse(request.getUrl());
        String createBaseUrl = createBaseUrl(parse);
        if (createBaseUrl == null) {
            Logger.e$default(this.logTag + "Fetch failed (Reason: Invalid url!)", null, null, 6, null);
            reject.execute(new Error("Invalid url!"));
            return null;
        }
        IWorkerRetrofitApi iWorkerRetrofitApi = (IWorkerRetrofitApi) this.retrofit.create(createBaseUrl, IWorkerRetrofitApi.class);
        Map headers = request.getHeaders();
        Intrinsics.checkNotNullExpressionValue(headers, "request.headers");
        ArrayList arrayList = new ArrayList(headers.size());
        for (Map.Entry entry : headers.entrySet()) {
            arrayList.add(new Header((String) entry.getKey(), (String) entry.getValue()));
        }
        List<Header> list = CollectionsKt.toList(arrayList);
        MediaType parse2 = MediaType.parse(getContentType(list));
        InputStream body = request.getBody();
        RequestBody create = body != null ? RequestBody.create(parse2, ByteStreamsKt.readBytes(body)) : null;
        String method = request.getMethod();
        Intrinsics.checkNotNullExpressionValue(method, "request.method");
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = method.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        switch (lowerCase.hashCode()) {
            case -1335458389:
                if (lowerCase.equals("delete")) {
                    deleteStreamRequest = iWorkerRetrofitApi.deleteStreamRequest(optBoolean, parse.toString(), list);
                    Intrinsics.checkNotNullExpressionValue(deleteStreamRequest, "api.deleteStreamRequest(… uri.toString(), headers)");
                    deleteStreamRequest.enqueue(new ExpandCallback<TypedInput>() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$loadAsync$1
                        @Override // com.bytedance.retrofit2.ExpandCallback
                        public void onAsyncPreRequest(RequestBuilder requestBuilder) {
                        }

                        @Override // com.bytedance.retrofit2.Callback
                        public void onResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                        }

                        @Override // com.bytedance.retrofit2.Callback
                        public void onFailure(Call<TypedInput> call, Throwable t) {
                            String str2;
                            StringBuilder sb = new StringBuilder();
                            str2 = WorkerDelegate.this.logTag;
                            Logger.e$default(sb.append(str2).append("Fetch failed (Reason: ").append(t != null ? t.getMessage() : null).append(')').toString(), null, null, 6, null);
                            reject.execute(t);
                        }

                        @Override // com.bytedance.retrofit2.ExpandCallback
                        public void onAsyncResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                            String contentType;
                            String str2;
                            String str3;
                            if (response == null) {
                                StringBuilder sb = new StringBuilder();
                                str3 = WorkerDelegate.this.logTag;
                                Logger.e$default(sb.append(str3).append("Fetch failed (Reason: Invalid response!)").toString(), null, null, 6, null);
                                reject.execute(new Error("Invalid response!"));
                                return;
                            }
                            String url2 = response.raw().getUrl();
                            int status = response.raw().getStatus();
                            List<Header> headers2 = response.raw().getHeaders();
                            Intrinsics.checkNotNullExpressionValue(headers2, "response.raw().headers");
                            List<Header> list2 = headers2;
                            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                            for (Header header : list2) {
                                Pair pair = new Pair(header.getName(), header.getValue());
                                linkedHashMap.put(pair.getFirst(), pair.getSecond());
                            }
                            WorkerDelegate workerDelegate = WorkerDelegate.this;
                            List<Header> headers3 = response.headers();
                            Intrinsics.checkNotNullExpressionValue(headers3, "response.headers()");
                            contentType = workerDelegate.getContentType(headers3);
                            MediaType parse3 = MediaType.parse(contentType);
                            String str4 = parse3 != null ? parse3.type() + '/' + parse3.subtype() : null;
                            Response response2 = new Response(url2, status, linkedHashMap, response.raw().getBody().mo349in(), str4 == null ? "application/json" : str4);
                            StringBuilder sb2 = new StringBuilder();
                            str2 = WorkerDelegate.this.logTag;
                            Logger.i$default(sb2.append(str2).append("Fetch successfully (URL: ").append(url2).append(')').toString(), null, null, 6, null);
                            resolve.execute(response2);
                        }
                    });
                    return new IReleasable() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$loadAsync$2
                        public final void release() {
                            deleteStreamRequest.cancel();
                        }
                    };
                }
                Logger.e$default(this.logTag + "Fetch failed (Reason: Invalid method!)", null, null, 6, null);
                reject.execute(new Error("Invalid method!"));
                return null;
            case -1249474914:
                if (lowerCase.equals("options")) {
                    deleteStreamRequest = iWorkerRetrofitApi.optionsStreamRequest(optBoolean, parse.toString(), list);
                    Intrinsics.checkNotNullExpressionValue(deleteStreamRequest, "api.optionsStreamRequest… uri.toString(), headers)");
                    deleteStreamRequest.enqueue(new ExpandCallback<TypedInput>() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$loadAsync$1
                        @Override // com.bytedance.retrofit2.ExpandCallback
                        public void onAsyncPreRequest(RequestBuilder requestBuilder) {
                        }

                        @Override // com.bytedance.retrofit2.Callback
                        public void onResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                        }

                        @Override // com.bytedance.retrofit2.Callback
                        public void onFailure(Call<TypedInput> call, Throwable t) {
                            String str2;
                            StringBuilder sb = new StringBuilder();
                            str2 = WorkerDelegate.this.logTag;
                            Logger.e$default(sb.append(str2).append("Fetch failed (Reason: ").append(t != null ? t.getMessage() : null).append(')').toString(), null, null, 6, null);
                            reject.execute(t);
                        }

                        @Override // com.bytedance.retrofit2.ExpandCallback
                        public void onAsyncResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                            String contentType;
                            String str2;
                            String str3;
                            if (response == null) {
                                StringBuilder sb = new StringBuilder();
                                str3 = WorkerDelegate.this.logTag;
                                Logger.e$default(sb.append(str3).append("Fetch failed (Reason: Invalid response!)").toString(), null, null, 6, null);
                                reject.execute(new Error("Invalid response!"));
                                return;
                            }
                            String url2 = response.raw().getUrl();
                            int status = response.raw().getStatus();
                            List<Header> headers2 = response.raw().getHeaders();
                            Intrinsics.checkNotNullExpressionValue(headers2, "response.raw().headers");
                            List<Header> list2 = headers2;
                            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                            for (Header header : list2) {
                                Pair pair = new Pair(header.getName(), header.getValue());
                                linkedHashMap.put(pair.getFirst(), pair.getSecond());
                            }
                            WorkerDelegate workerDelegate = WorkerDelegate.this;
                            List<Header> headers3 = response.headers();
                            Intrinsics.checkNotNullExpressionValue(headers3, "response.headers()");
                            contentType = workerDelegate.getContentType(headers3);
                            MediaType parse3 = MediaType.parse(contentType);
                            String str4 = parse3 != null ? parse3.type() + '/' + parse3.subtype() : null;
                            Response response2 = new Response(url2, status, linkedHashMap, response.raw().getBody().mo349in(), str4 == null ? "application/json" : str4);
                            StringBuilder sb2 = new StringBuilder();
                            str2 = WorkerDelegate.this.logTag;
                            Logger.i$default(sb2.append(str2).append("Fetch successfully (URL: ").append(url2).append(')').toString(), null, null, 6, null);
                            resolve.execute(response2);
                        }
                    });
                    return new IReleasable() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$loadAsync$2
                        public final void release() {
                            deleteStreamRequest.cancel();
                        }
                    };
                }
                Logger.e$default(this.logTag + "Fetch failed (Reason: Invalid method!)", null, null, 6, null);
                reject.execute(new Error("Invalid method!"));
                return null;
            case 102230:
                if (lowerCase.equals(PrefetchRequestConfig.METHOD_GET)) {
                    deleteStreamRequest = iWorkerRetrofitApi.getStreamRequest(optBoolean, parse.toString(), list);
                    Intrinsics.checkNotNullExpressionValue(deleteStreamRequest, "api.getStreamRequest(nee… uri.toString(), headers)");
                    deleteStreamRequest.enqueue(new ExpandCallback<TypedInput>() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$loadAsync$1
                        @Override // com.bytedance.retrofit2.ExpandCallback
                        public void onAsyncPreRequest(RequestBuilder requestBuilder) {
                        }

                        @Override // com.bytedance.retrofit2.Callback
                        public void onResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                        }

                        @Override // com.bytedance.retrofit2.Callback
                        public void onFailure(Call<TypedInput> call, Throwable t) {
                            String str2;
                            StringBuilder sb = new StringBuilder();
                            str2 = WorkerDelegate.this.logTag;
                            Logger.e$default(sb.append(str2).append("Fetch failed (Reason: ").append(t != null ? t.getMessage() : null).append(')').toString(), null, null, 6, null);
                            reject.execute(t);
                        }

                        @Override // com.bytedance.retrofit2.ExpandCallback
                        public void onAsyncResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                            String contentType;
                            String str2;
                            String str3;
                            if (response == null) {
                                StringBuilder sb = new StringBuilder();
                                str3 = WorkerDelegate.this.logTag;
                                Logger.e$default(sb.append(str3).append("Fetch failed (Reason: Invalid response!)").toString(), null, null, 6, null);
                                reject.execute(new Error("Invalid response!"));
                                return;
                            }
                            String url2 = response.raw().getUrl();
                            int status = response.raw().getStatus();
                            List<Header> headers2 = response.raw().getHeaders();
                            Intrinsics.checkNotNullExpressionValue(headers2, "response.raw().headers");
                            List<Header> list2 = headers2;
                            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                            for (Header header : list2) {
                                Pair pair = new Pair(header.getName(), header.getValue());
                                linkedHashMap.put(pair.getFirst(), pair.getSecond());
                            }
                            WorkerDelegate workerDelegate = WorkerDelegate.this;
                            List<Header> headers3 = response.headers();
                            Intrinsics.checkNotNullExpressionValue(headers3, "response.headers()");
                            contentType = workerDelegate.getContentType(headers3);
                            MediaType parse3 = MediaType.parse(contentType);
                            String str4 = parse3 != null ? parse3.type() + '/' + parse3.subtype() : null;
                            Response response2 = new Response(url2, status, linkedHashMap, response.raw().getBody().mo349in(), str4 == null ? "application/json" : str4);
                            StringBuilder sb2 = new StringBuilder();
                            str2 = WorkerDelegate.this.logTag;
                            Logger.i$default(sb2.append(str2).append("Fetch successfully (URL: ").append(url2).append(')').toString(), null, null, 6, null);
                            resolve.execute(response2);
                        }
                    });
                    return new IReleasable() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$loadAsync$2
                        public final void release() {
                            deleteStreamRequest.cancel();
                        }
                    };
                }
                Logger.e$default(this.logTag + "Fetch failed (Reason: Invalid method!)", null, null, 6, null);
                reject.execute(new Error("Invalid method!"));
                return null;
            case 111375:
                if (lowerCase.equals("put")) {
                    deleteStreamRequest = iWorkerRetrofitApi.putStreamRequest(optBoolean, parse.toString(), create, list);
                    Intrinsics.checkNotNullExpressionValue(deleteStreamRequest, "api.putStreamRequest(nee…oString(), body, headers)");
                    deleteStreamRequest.enqueue(new ExpandCallback<TypedInput>() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$loadAsync$1
                        @Override // com.bytedance.retrofit2.ExpandCallback
                        public void onAsyncPreRequest(RequestBuilder requestBuilder) {
                        }

                        @Override // com.bytedance.retrofit2.Callback
                        public void onResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                        }

                        @Override // com.bytedance.retrofit2.Callback
                        public void onFailure(Call<TypedInput> call, Throwable t) {
                            String str2;
                            StringBuilder sb = new StringBuilder();
                            str2 = WorkerDelegate.this.logTag;
                            Logger.e$default(sb.append(str2).append("Fetch failed (Reason: ").append(t != null ? t.getMessage() : null).append(')').toString(), null, null, 6, null);
                            reject.execute(t);
                        }

                        @Override // com.bytedance.retrofit2.ExpandCallback
                        public void onAsyncResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                            String contentType;
                            String str2;
                            String str3;
                            if (response == null) {
                                StringBuilder sb = new StringBuilder();
                                str3 = WorkerDelegate.this.logTag;
                                Logger.e$default(sb.append(str3).append("Fetch failed (Reason: Invalid response!)").toString(), null, null, 6, null);
                                reject.execute(new Error("Invalid response!"));
                                return;
                            }
                            String url2 = response.raw().getUrl();
                            int status = response.raw().getStatus();
                            List<Header> headers2 = response.raw().getHeaders();
                            Intrinsics.checkNotNullExpressionValue(headers2, "response.raw().headers");
                            List<Header> list2 = headers2;
                            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                            for (Header header : list2) {
                                Pair pair = new Pair(header.getName(), header.getValue());
                                linkedHashMap.put(pair.getFirst(), pair.getSecond());
                            }
                            WorkerDelegate workerDelegate = WorkerDelegate.this;
                            List<Header> headers3 = response.headers();
                            Intrinsics.checkNotNullExpressionValue(headers3, "response.headers()");
                            contentType = workerDelegate.getContentType(headers3);
                            MediaType parse3 = MediaType.parse(contentType);
                            String str4 = parse3 != null ? parse3.type() + '/' + parse3.subtype() : null;
                            Response response2 = new Response(url2, status, linkedHashMap, response.raw().getBody().mo349in(), str4 == null ? "application/json" : str4);
                            StringBuilder sb2 = new StringBuilder();
                            str2 = WorkerDelegate.this.logTag;
                            Logger.i$default(sb2.append(str2).append("Fetch successfully (URL: ").append(url2).append(')').toString(), null, null, 6, null);
                            resolve.execute(response2);
                        }
                    });
                    return new IReleasable() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$loadAsync$2
                        public final void release() {
                            deleteStreamRequest.cancel();
                        }
                    };
                }
                Logger.e$default(this.logTag + "Fetch failed (Reason: Invalid method!)", null, null, 6, null);
                reject.execute(new Error("Invalid method!"));
                return null;
            case 3198432:
                if (lowerCase.equals("head")) {
                    deleteStreamRequest = iWorkerRetrofitApi.headStreamRequest(optBoolean, parse.toString(), list);
                    Intrinsics.checkNotNullExpressionValue(deleteStreamRequest, "api.headStreamRequest(ne… uri.toString(), headers)");
                    deleteStreamRequest.enqueue(new ExpandCallback<TypedInput>() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$loadAsync$1
                        @Override // com.bytedance.retrofit2.ExpandCallback
                        public void onAsyncPreRequest(RequestBuilder requestBuilder) {
                        }

                        @Override // com.bytedance.retrofit2.Callback
                        public void onResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                        }

                        @Override // com.bytedance.retrofit2.Callback
                        public void onFailure(Call<TypedInput> call, Throwable t) {
                            String str2;
                            StringBuilder sb = new StringBuilder();
                            str2 = WorkerDelegate.this.logTag;
                            Logger.e$default(sb.append(str2).append("Fetch failed (Reason: ").append(t != null ? t.getMessage() : null).append(')').toString(), null, null, 6, null);
                            reject.execute(t);
                        }

                        @Override // com.bytedance.retrofit2.ExpandCallback
                        public void onAsyncResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                            String contentType;
                            String str2;
                            String str3;
                            if (response == null) {
                                StringBuilder sb = new StringBuilder();
                                str3 = WorkerDelegate.this.logTag;
                                Logger.e$default(sb.append(str3).append("Fetch failed (Reason: Invalid response!)").toString(), null, null, 6, null);
                                reject.execute(new Error("Invalid response!"));
                                return;
                            }
                            String url2 = response.raw().getUrl();
                            int status = response.raw().getStatus();
                            List<Header> headers2 = response.raw().getHeaders();
                            Intrinsics.checkNotNullExpressionValue(headers2, "response.raw().headers");
                            List<Header> list2 = headers2;
                            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                            for (Header header : list2) {
                                Pair pair = new Pair(header.getName(), header.getValue());
                                linkedHashMap.put(pair.getFirst(), pair.getSecond());
                            }
                            WorkerDelegate workerDelegate = WorkerDelegate.this;
                            List<Header> headers3 = response.headers();
                            Intrinsics.checkNotNullExpressionValue(headers3, "response.headers()");
                            contentType = workerDelegate.getContentType(headers3);
                            MediaType parse3 = MediaType.parse(contentType);
                            String str4 = parse3 != null ? parse3.type() + '/' + parse3.subtype() : null;
                            Response response2 = new Response(url2, status, linkedHashMap, response.raw().getBody().mo349in(), str4 == null ? "application/json" : str4);
                            StringBuilder sb2 = new StringBuilder();
                            str2 = WorkerDelegate.this.logTag;
                            Logger.i$default(sb2.append(str2).append("Fetch successfully (URL: ").append(url2).append(')').toString(), null, null, 6, null);
                            resolve.execute(response2);
                        }
                    });
                    return new IReleasable() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$loadAsync$2
                        public final void release() {
                            deleteStreamRequest.cancel();
                        }
                    };
                }
                Logger.e$default(this.logTag + "Fetch failed (Reason: Invalid method!)", null, null, 6, null);
                reject.execute(new Error("Invalid method!"));
                return null;
            case 3446944:
                if (lowerCase.equals(PrefetchRequestConfig.METHOD_POST)) {
                    deleteStreamRequest = iWorkerRetrofitApi.postStreamRequest(optBoolean, parse.toString(), create, list);
                    Intrinsics.checkNotNullExpressionValue(deleteStreamRequest, "api.postStreamRequest(ne…oString(), body, headers)");
                    deleteStreamRequest.enqueue(new ExpandCallback<TypedInput>() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$loadAsync$1
                        @Override // com.bytedance.retrofit2.ExpandCallback
                        public void onAsyncPreRequest(RequestBuilder requestBuilder) {
                        }

                        @Override // com.bytedance.retrofit2.Callback
                        public void onResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                        }

                        @Override // com.bytedance.retrofit2.Callback
                        public void onFailure(Call<TypedInput> call, Throwable t) {
                            String str2;
                            StringBuilder sb = new StringBuilder();
                            str2 = WorkerDelegate.this.logTag;
                            Logger.e$default(sb.append(str2).append("Fetch failed (Reason: ").append(t != null ? t.getMessage() : null).append(')').toString(), null, null, 6, null);
                            reject.execute(t);
                        }

                        @Override // com.bytedance.retrofit2.ExpandCallback
                        public void onAsyncResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                            String contentType;
                            String str2;
                            String str3;
                            if (response == null) {
                                StringBuilder sb = new StringBuilder();
                                str3 = WorkerDelegate.this.logTag;
                                Logger.e$default(sb.append(str3).append("Fetch failed (Reason: Invalid response!)").toString(), null, null, 6, null);
                                reject.execute(new Error("Invalid response!"));
                                return;
                            }
                            String url2 = response.raw().getUrl();
                            int status = response.raw().getStatus();
                            List<Header> headers2 = response.raw().getHeaders();
                            Intrinsics.checkNotNullExpressionValue(headers2, "response.raw().headers");
                            List<Header> list2 = headers2;
                            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                            for (Header header : list2) {
                                Pair pair = new Pair(header.getName(), header.getValue());
                                linkedHashMap.put(pair.getFirst(), pair.getSecond());
                            }
                            WorkerDelegate workerDelegate = WorkerDelegate.this;
                            List<Header> headers3 = response.headers();
                            Intrinsics.checkNotNullExpressionValue(headers3, "response.headers()");
                            contentType = workerDelegate.getContentType(headers3);
                            MediaType parse3 = MediaType.parse(contentType);
                            String str4 = parse3 != null ? parse3.type() + '/' + parse3.subtype() : null;
                            Response response2 = new Response(url2, status, linkedHashMap, response.raw().getBody().mo349in(), str4 == null ? "application/json" : str4);
                            StringBuilder sb2 = new StringBuilder();
                            str2 = WorkerDelegate.this.logTag;
                            Logger.i$default(sb2.append(str2).append("Fetch successfully (URL: ").append(url2).append(')').toString(), null, null, 6, null);
                            resolve.execute(response2);
                        }
                    });
                    return new IReleasable() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$loadAsync$2
                        public final void release() {
                            deleteStreamRequest.cancel();
                        }
                    };
                }
                Logger.e$default(this.logTag + "Fetch failed (Reason: Invalid method!)", null, null, 6, null);
                reject.execute(new Error("Invalid method!"));
                return null;
            case 106438728:
                if (lowerCase.equals("patch")) {
                    deleteStreamRequest = iWorkerRetrofitApi.patchStreamRequest(optBoolean, parse.toString(), create, list);
                    Intrinsics.checkNotNullExpressionValue(deleteStreamRequest, "api.patchStreamRequest(n…oString(), body, headers)");
                    deleteStreamRequest.enqueue(new ExpandCallback<TypedInput>() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$loadAsync$1
                        @Override // com.bytedance.retrofit2.ExpandCallback
                        public void onAsyncPreRequest(RequestBuilder requestBuilder) {
                        }

                        @Override // com.bytedance.retrofit2.Callback
                        public void onResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                        }

                        @Override // com.bytedance.retrofit2.Callback
                        public void onFailure(Call<TypedInput> call, Throwable t) {
                            String str2;
                            StringBuilder sb = new StringBuilder();
                            str2 = WorkerDelegate.this.logTag;
                            Logger.e$default(sb.append(str2).append("Fetch failed (Reason: ").append(t != null ? t.getMessage() : null).append(')').toString(), null, null, 6, null);
                            reject.execute(t);
                        }

                        @Override // com.bytedance.retrofit2.ExpandCallback
                        public void onAsyncResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                            String contentType;
                            String str2;
                            String str3;
                            if (response == null) {
                                StringBuilder sb = new StringBuilder();
                                str3 = WorkerDelegate.this.logTag;
                                Logger.e$default(sb.append(str3).append("Fetch failed (Reason: Invalid response!)").toString(), null, null, 6, null);
                                reject.execute(new Error("Invalid response!"));
                                return;
                            }
                            String url2 = response.raw().getUrl();
                            int status = response.raw().getStatus();
                            List<Header> headers2 = response.raw().getHeaders();
                            Intrinsics.checkNotNullExpressionValue(headers2, "response.raw().headers");
                            List<Header> list2 = headers2;
                            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                            for (Header header : list2) {
                                Pair pair = new Pair(header.getName(), header.getValue());
                                linkedHashMap.put(pair.getFirst(), pair.getSecond());
                            }
                            WorkerDelegate workerDelegate = WorkerDelegate.this;
                            List<Header> headers3 = response.headers();
                            Intrinsics.checkNotNullExpressionValue(headers3, "response.headers()");
                            contentType = workerDelegate.getContentType(headers3);
                            MediaType parse3 = MediaType.parse(contentType);
                            String str4 = parse3 != null ? parse3.type() + '/' + parse3.subtype() : null;
                            Response response2 = new Response(url2, status, linkedHashMap, response.raw().getBody().mo349in(), str4 == null ? "application/json" : str4);
                            StringBuilder sb2 = new StringBuilder();
                            str2 = WorkerDelegate.this.logTag;
                            Logger.i$default(sb2.append(str2).append("Fetch successfully (URL: ").append(url2).append(')').toString(), null, null, 6, null);
                            resolve.execute(response2);
                        }
                    });
                    return new IReleasable() { // from class: com.bytedance.pia.core.worker.network.WorkerDelegate$loadAsync$2
                        public final void release() {
                            deleteStreamRequest.cancel();
                        }
                    };
                }
                Logger.e$default(this.logTag + "Fetch failed (Reason: Invalid method!)", null, null, 6, null);
                reject.execute(new Error("Invalid method!"));
                return null;
            default:
                Logger.e$default(this.logTag + "Fetch failed (Reason: Invalid method!)", null, null, 6, null);
                reject.execute(new Error("Invalid method!"));
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getContentType(List<Header> headers) {
        Object obj;
        Iterator<T> it = headers.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            String name = ((Header) obj).getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
            if (name == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (Intrinsics.areEqual(lowerCase, KeyContentType)) {
                break;
            }
        }
        Header header = (Header) obj;
        String value = header != null ? header.getValue() : null;
        return value == null ? DefaultMimeType : value;
    }

    private final String createBaseUrl(Uri requestUri) {
        if ((requestUri != null ? requestUri.getHost() : null) == null || requestUri.getScheme() == null) {
            return null;
        }
        return requestUri.getScheme() + "://" + requestUri.getHost() + "/";
    }

    private final boolean isSensitiveHeadersAllowed(String str) {
        ISecurityDelegate iSecurityDelegate = this.securityDelegate;
        if (iSecurityDelegate == null) {
            return false;
        }
        return iSecurityDelegate.isAccessTokenAllowed(str);
    }
}
