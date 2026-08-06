package com.bytedance.pia.core.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.pia.core.api.PiaEnv;
import com.bytedance.pia.core.api.network.IPiaRetrofit;
import com.bytedance.pia.core.api.resource.IResourceLoader;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.api.utils.IReleasable;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.ExpandCallback;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okhttp3.MediaType;

/* compiled from: DefaultResourceLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001cB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J:\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eH\u0016J.\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00150\u001bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/pia/core/utils/DefaultResourceLoader;", "Lcom/bytedance/pia/core/api/resource/IResourceLoader;", "inner", "(Lcom/bytedance/pia/core/api/resource/IResourceLoader;)V", "innerLoader", "load", "Lcom/bytedance/pia/core/api/resource/IResourceResponse;", "loadFrom", "Lcom/bytedance/pia/core/api/resource/LoadFrom;", "request", "Lcom/bytedance/pia/core/api/resource/IResourceRequest;", "loadAsync", "Lcom/bytedance/pia/core/api/utils/IReleasable;", "resolve", "Lcom/bytedance/pia/core/api/utils/IConsumer;", "reject", "", "loadOnlineAsyncInternal", "loadOnlineInternal", "makeCall", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "url", "", OnlineTracing.HeaderKeys.KEY_SSR_FALLBACK_HEADER, "", "toResourceResponse", "Lcom/bytedance/retrofit2/SsResponse;", "ResourceApi", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DefaultResourceLoader implements IResourceLoader {
    private final IResourceLoader innerLoader;

    /* compiled from: DefaultResourceLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\b\u0001\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\u0012\b\u0001\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/pia/core/utils/DefaultResourceLoader$ResourceApi;", "", "doGet", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "addCommonPara", "", "relativePath", "", "queryMap", "", "headerList", "", "Lcom/bytedance/retrofit2/client/Header;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ResourceApi {
        @GET
        @Streaming
        Call<TypedInput> doGet(@AddCommonParam boolean addCommonPara, @Url String relativePath, @QueryMap(encode = true) Map<String, String> queryMap, @HeaderList List<Header> headerList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DefaultResourceLoader() {
        this(r0, 1, r0);
        IResourceLoader iResourceLoader = null;
    }

    public DefaultResourceLoader(IResourceLoader iResourceLoader) {
        this.innerLoader = iResourceLoader instanceof DefaultResourceLoader ? null : iResourceLoader;
    }

    public /* synthetic */ DefaultResourceLoader(IResourceLoader iResourceLoader, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : iResourceLoader);
    }

    @Override // com.bytedance.pia.core.api.resource.IResourceLoader
    public IResourceResponse load(LoadFrom loadFrom, IResourceRequest request) {
        Object obj;
        Intrinsics.checkNotNullParameter(loadFrom, "loadFrom");
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            Result.Companion companion = Result.Companion;
            IResourceLoader iResourceLoader = this.innerLoader;
            obj = Result.constructor-impl(iResourceLoader != null ? iResourceLoader.load(loadFrom, request) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        IResourceResponse iResourceResponse = (IResourceResponse) obj;
        if (iResourceResponse != null) {
            Logger.i$default("[Resource] Custom resource loader load success.", null, null, 6, null);
            return iResourceResponse;
        }
        return loadOnlineInternal(request);
    }

    @Override // com.bytedance.pia.core.api.resource.IResourceLoader
    public IReleasable loadAsync(LoadFrom loadFrom, final IResourceRequest request, final IConsumer<IResourceResponse> resolve, final IConsumer<Throwable> reject) {
        Intrinsics.checkNotNullParameter(loadFrom, "loadFrom");
        Intrinsics.checkNotNullParameter(request, "request");
        IResourceLoader iResourceLoader = this.innerLoader;
        if (iResourceLoader != null) {
            return iResourceLoader.loadAsync(loadFrom, request, new IConsumer() { // from class: com.bytedance.pia.core.utils.DefaultResourceLoader$loadAsync$1$1
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public final void accept(IResourceResponse iResourceResponse) {
                    if (iResourceResponse != null) {
                        Logger.i$default("[Resource] Custom resource loader load success.", null, null, 6, null);
                        IConsumer<IResourceResponse> iConsumer = resolve;
                        if (iConsumer != null) {
                            iConsumer.accept(iResourceResponse);
                            return;
                        }
                        return;
                    }
                    this.loadOnlineAsyncInternal(request, resolve, reject);
                }
            }, new IConsumer() { // from class: com.bytedance.pia.core.utils.DefaultResourceLoader$loadAsync$1$2
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public final void accept(Throwable th) {
                    DefaultResourceLoader.this.loadOnlineAsyncInternal(request, resolve, reject);
                }
            });
        }
        return loadOnlineAsyncInternal(request, resolve, reject);
    }

    public final IReleasable loadOnlineAsyncInternal(IResourceRequest request, final IConsumer<IResourceResponse> resolve, final IConsumer<Throwable> reject) {
        Intrinsics.checkNotNullParameter(request, "request");
        Logger.i$default("[Resource] Custom resource loader load failed, fallback to default resource loader.", null, null, 6, null);
        try {
            Result.Companion companion = Result.Companion;
            DefaultResourceLoader defaultResourceLoader = this;
            String uri = request.getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "request.url.toString()");
            final Call<TypedInput> makeCall = makeCall(uri, request.getRequestHeaders());
            makeCall.enqueue(new ExpandCallback<TypedInput>() { // from class: com.bytedance.pia.core.utils.DefaultResourceLoader$loadOnlineAsyncInternal$1$1
                @Override // com.bytedance.retrofit2.ExpandCallback
                public void onAsyncPreRequest(RequestBuilder requestBuilder) {
                }

                @Override // com.bytedance.retrofit2.Callback
                public void onResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                }

                @Override // com.bytedance.retrofit2.Callback
                public void onFailure(Call<TypedInput> call, Throwable t) {
                    IConsumer<Throwable> iConsumer = reject;
                    if (iConsumer != null) {
                        iConsumer.accept(t);
                    }
                }

                @Override // com.bytedance.retrofit2.ExpandCallback
                public void onAsyncResponse(Call<TypedInput> call, SsResponse<TypedInput> response) {
                    Object obj;
                    IConsumer<IResourceResponse> iConsumer;
                    IResourceResponse resourceResponse;
                    Logger.i$default("[Resource] response start.", null, null, 6, null);
                    if (response == null) {
                        IConsumer<Throwable> iConsumer2 = reject;
                        if (iConsumer2 != null) {
                            iConsumer2.accept(new NullPointerException("Response is null!"));
                            return;
                        }
                        return;
                    }
                    DefaultResourceLoader defaultResourceLoader2 = this;
                    try {
                        Result.Companion companion2 = Result.Companion;
                        resourceResponse = defaultResourceLoader2.toResourceResponse(response);
                        obj = Result.constructor-impl(resourceResponse);
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    IConsumer<Throwable> iConsumer3 = reject;
                    Throwable th2 = Result.exceptionOrNull-impl(obj);
                    if (th2 != null && iConsumer3 != null) {
                        iConsumer3.accept(th2);
                    }
                    IResourceResponse iResourceResponse = (IResourceResponse) (Result.isFailure-impl(obj) ? null : obj);
                    if (iResourceResponse == null || (iConsumer = resolve) == null) {
                        return;
                    }
                    iConsumer.accept(iResourceResponse);
                }
            });
            return new IReleasable() { // from class: com.bytedance.pia.core.utils.DefaultResourceLoader$loadOnlineAsyncInternal$1$2
                @Override // com.bytedance.pia.core.api.utils.IReleasable
                public final void release() {
                    makeCall.cancel();
                }
            };
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable th2 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            if (th2 != null && reject != null) {
                reject.accept(th2);
            }
            return new IReleasable() { // from class: com.bytedance.pia.core.utils.DefaultResourceLoader$loadOnlineAsyncInternal$3
                @Override // com.bytedance.pia.core.api.utils.IReleasable
                public final void release() {
                }
            };
        }
    }

    public final IResourceResponse loadOnlineInternal(IResourceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Logger.i$default("[Resource] Custom resource loader load failed, fallback to default resource loader.", null, null, 6, null);
        try {
            Result.Companion companion = Result.Companion;
            DefaultResourceLoader defaultResourceLoader = this;
            String uri = request.getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "request.url.toString()");
            SsResponse<TypedInput> execute = makeCall(uri, request.getRequestHeaders()).execute();
            Intrinsics.checkNotNullExpressionValue(execute, "call.execute()");
            return toResourceResponse(execute);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable th2 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            if (th2 != null) {
                Logger.i$default("[Resource] Load online failed:", th2, null, 4, null);
            }
            return null;
        }
    }

    private final Call<TypedInput> makeCall(String url, Map<String, String> header) {
        ArrayList arrayList;
        ResourceApi resourceApi;
        HashMap hashMap = new HashMap();
        Pair parseUrl = com.bytedance.frameworks.baselib.network.http.util.UrlUtils.parseUrl(url, hashMap);
        if (header != null) {
            ArrayList arrayList2 = new ArrayList(header.size());
            for (Map.Entry<String, String> entry : header.entrySet()) {
                arrayList2.add(new Header(entry.getKey(), entry.getValue()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        IFactory<IPiaRetrofit> retrofitFactory = PiaEnv.Default.getRetrofitFactory();
        IPiaRetrofit create = retrofitFactory != null ? retrofitFactory.create() : null;
        if (create == null || (resourceApi = (ResourceApi) create.create((String) parseUrl.first, ResourceApi.class)) == null) {
            resourceApi = (ResourceApi) RetrofitUtils.createSsService((String) parseUrl.first, ResourceApi.class);
        }
        return resourceApi.doGet(false, (String) parseUrl.second, hashMap, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IResourceResponse toResourceResponse(SsResponse<TypedInput> ssResponse) {
        String str;
        Charset charset;
        List<Header> headers = ssResponse.headers();
        Intrinsics.checkNotNullExpressionValue(headers, "headers()");
        List<Header> list = headers;
        final LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Header header : list) {
            kotlin.Pair pair = new kotlin.Pair(header.getName(), header.getValue());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        MediaType parse = MediaType.parse(RetrofitUtils.getHeaderValueIgnoreCase(ssResponse.headers(), XBridgeAPIRequestUtils.CONTENT_TYPE));
        final String str2 = parse == null ? "text/html" : parse.type() + '/' + parse.subtype();
        if (parse == null || (charset = parse.charset()) == null || (str = charset.toString()) == null) {
            str = "UTF-8";
        }
        final String str3 = str;
        final int code = ssResponse.code();
        final String reason = TextUtils.isEmpty(ssResponse.raw().getReason()) ? "OK" : ssResponse.raw().getReason();
        final InputStream mo349in = ssResponse.body().mo349in();
        return new IResourceResponse() { // from class: com.bytedance.pia.core.utils.DefaultResourceLoader$toResourceResponse$1
            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            /* renamed from: getMimeType, reason: from getter */
            public String get$mimeType() {
                return str2;
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            /* renamed from: getEncoding, reason: from getter */
            public String get$encoding() {
                return str3;
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            /* renamed from: getStatusCode, reason: from getter */
            public int get$statusCode() {
                return code;
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            /* renamed from: getReasonPhrase, reason: from getter */
            public String get$reasonPhrase() {
                return reason;
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            public Map<String, String> getHeaders() {
                return linkedHashMap;
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            /* renamed from: getLoadFrom */
            public LoadFrom get$from() {
                return LoadFrom.Online;
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            public InputStream getData() {
                InputStream inputStream = mo349in;
                Intrinsics.checkNotNullExpressionValue(inputStream, "stream");
                return inputStream;
            }
        };
    }
}
