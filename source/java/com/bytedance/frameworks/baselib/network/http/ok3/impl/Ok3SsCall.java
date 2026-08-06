package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowUseNetworkException;
import com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall;
import com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch.TTMetaDispatchLog;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch.TTMetaDispatchManager;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.framwork.core.sdkmonitor.MonitorNetUtil;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.http.HttpMethod;
import okhttp3.ttnet.TTNetUtils;
import okio.BufferedSink;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class Ok3SsCall extends BaseSsCall implements WeakHandler.IHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "Ok3SsCall";
    private static final int WAIT_REQUEST_FINISHED_TIME_MS = 500;
    OkHttpClient client;
    private final WeakHandler mHandler;
    volatile OkHttp3RequestLog okHttp3RequestLog;
    Request okRequest;
    Response okResponse;
    Call rawCall;

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public InputStream errorStream() {
        return null;
    }

    public void handleMsg(Message message) {
    }

    public boolean setThrottleNetSpeed(long j) {
        return false;
    }

    public Ok3SsCall(com.bytedance.retrofit2.client.Request request) {
        super(request);
        this.client = null;
        this.okHttp3RequestLog = null;
        try {
            this.requestInfo.httpClientType = 1;
            this.requestInfo.extraInfo.put(BaseHttpRequestInfo.KEY_HTTP_CLIENT, SsOkHttp3Client.TAG);
            this.requestInfo.extraInfo.put(BaseHttpRequestInfo.KEY_HTTP_CLIENT_VERSION, SsOkHttp3Client.getOkVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.requestInfo.fallbackReason = SsOkHttp3Client.getFallbackReason();
        this.requestInfo.fallbackMessage = SsOkHttp3Client.getFallbackMessage();
        this.requestInfo.metrics.fallbackReason = this.requestInfo.fallbackReason;
        this.requestInfo.metrics.fallbackMessage = this.requestInfo.fallbackMessage;
        this.mHandler = new WeakHandler(HttpDns.getService().getHttpDnsHandlerThread().getLooper(), this);
        String url = this.retrofitRequest.getUrl();
        this.okHttp3RequestLog = new OkHttp3RequestLog(this.requestInfo, SsOkHttp3Client.getContext());
        this.okHttp3RequestLog.setOriginUrl(url, this.retrofitRequest.getMethod());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public int responseCode() {
        Response response = this.okResponse;
        if (response != null) {
            return response.code();
        }
        return 0;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public long contentLength() {
        Response response = this.okResponse;
        if (response == null || response.body() == null) {
            return 0L;
        }
        return this.okResponse.body().contentLength();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String contentType() {
        MediaType contentType;
        Response response = this.okResponse;
        if (response == null || response.body() == null || (contentType = this.okResponse.body().contentType()) == null) {
            return null;
        }
        return contentType.toString();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public Map<String, List<String>> responseHeaders() {
        Response response = this.okResponse;
        if (response != null) {
            return response.headers().toMultimap();
        }
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String responseHeaderValue(String str) {
        Response response = this.okResponse;
        if (response != null) {
            return response.header(str);
        }
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public InputStream inputStream() {
        Response response = this.okResponse;
        if (response == null || response.body() == null) {
            return null;
        }
        return this.okResponse.body().byteStream();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String responseMessage() {
        Response response = this.okResponse;
        if (response != null) {
            return response.message();
        }
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public boolean isGzip() {
        return "gzip".equalsIgnoreCase(this.okResponse.header(MonitorNetUtil.KEY_CONTENT_ENCODING));
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public void safeClose() {
        Response response = this.okResponse;
        if (response != null && response.body() != null) {
            StreamParser.safeClose(this.okResponse.body());
        }
        Call call = this.rawCall;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public boolean fromCache() {
        Response response = this.okResponse;
        if (response == null || response.cacheResponse() == null) {
            return false;
        }
        return this.okResponse.networkResponse() == null || this.okResponse.code() == 304;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected void onExecuteStart() throws IOException {
        if (SsOkHttp3Client.getNotAllowUseNetwork()) {
            throw new NotAllowUseNetworkException("request is not allowed using network");
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected boolean bypassNetworkStatusCheck() {
        return this.bypassNetworkStatusCheck;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected Context getContext() {
        return SsOkHttp3Client.getContext();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected void prepareNetworkRequest(String str, com.bytedance.retrofit2.client.Request request, BaseHttpRequestInfo baseHttpRequestInfo, Map<String, String> map) throws IOException {
        try {
            try {
                baseHttpRequestInfo.metrics.prepareConnectionStart();
                constructOkHttpClient(baseHttpRequestInfo);
                configureOkRequest(request, baseHttpRequestInfo, map);
            } catch (Exception e) {
                throw TTNetExceptionStorage.wrapIfNeeded(e, str, baseHttpRequestInfo.traceCode, baseHttpRequestInfo);
            }
        } finally {
            baseHttpRequestInfo.metrics.prepareConnectionEnd();
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected void executeNetworkRequest(RetrofitMetrics retrofitMetrics) throws IOException {
        if (this.rawCall != null) {
            long executeConnectionStart = retrofitMetrics.executeConnectionStart();
            try {
                this.okResponse = this.rawCall.execute();
                this.okHttp3RequestLog.setResponseSource(this.okResponse);
            } finally {
                retrofitMetrics.executeConnectionEnd(executeConnectionStart);
            }
        }
    }

    private void constructOkHttpClient(BaseHttpRequestInfo baseHttpRequestInfo) {
        long j = -1;
        try {
            j = baseHttpRequestInfo.metrics.constructConnectionStart();
            this.client = SsOkHttp3Client.constructOkHttpClient();
        } finally {
            baseHttpRequestInfo.metrics.constructConnectionEnd(j);
        }
    }

    private void configureOkRequest(com.bytedance.retrofit2.client.Request request, BaseHttpRequestInfo baseHttpRequestInfo, Map<String, String> map) {
        Request.Builder method;
        String md5Stub;
        long configureConnectionStart = baseHttpRequestInfo.metrics.configureConnectionStart();
        try {
            OkHttpClient.Builder newBuilder = this.client.newBuilder();
            if (baseHttpRequestInfo.reqContext != 0) {
                newBuilder.followRedirects(baseHttpRequestInfo.reqContext.followRedirectInternal);
            }
            newBuilder.connectTimeout(NetworkParams.getConnectTimeout(), TimeUnit.MILLISECONDS);
            newBuilder.readTimeout(NetworkParams.getIoTimeout(), TimeUnit.MILLISECONDS);
            newBuilder.writeTimeout(NetworkParams.getIoTimeout(), TimeUnit.MILLISECONDS);
            newBuilder.proxy(SsOkHttp3Client.getProxy());
            newBuilder.enableBoe(BoeUtils.isOkhttpBoeProxyEnabled());
            if (baseHttpRequestInfo.reqContext != 0) {
                BaseRequestContext baseRequestContext = baseHttpRequestInfo.reqContext;
                if (baseRequestContext.timeout_connect > 0) {
                    newBuilder.connectTimeout(baseRequestContext.timeout_connect, TimeUnit.MILLISECONDS);
                }
                if (baseRequestContext.timeout_write > 0) {
                    newBuilder.writeTimeout(baseRequestContext.timeout_write, TimeUnit.MILLISECONDS);
                }
                if (baseRequestContext.timeout_read > 0) {
                    newBuilder.readTimeout(baseRequestContext.timeout_read, TimeUnit.MILLISECONDS);
                }
                if (baseRequestContext.byPassProxy) {
                    newBuilder.proxy(Proxy.NO_PROXY);
                }
                final BaseRequestContext.AuthCredentials authCredentials = baseRequestContext.authCredentials;
                if (authCredentials != null && authCredentials.username != null && authCredentials.password != null) {
                    newBuilder.proxyAuthenticator(new Authenticator() { // from class: com.bytedance.frameworks.baselib.network.http.ok3.impl.Ok3SsCall$$ExternalSyntheticLambda0
                        public final Request authenticate(Route route, Response response) {
                            return Ok3SsCall.lambda$configureOkRequest$0(BaseRequestContext.AuthCredentials.this, route, response);
                        }
                    });
                }
                BaseRequestContext.IOkHttpRequestClientBuilderHook iOkHttpRequestClientBuilderHook = baseRequestContext.okHttpRequestClientBuilderHook;
                if (iOkHttpRequestClientBuilderHook != null) {
                    iOkHttpRequestClientBuilderHook.addBuilderConfig(newBuilder);
                }
                this.okHttp3RequestLog.setRequestTimeout(baseRequestContext);
            }
            String url = request.getUrl();
            String str = null;
            newBuilder.eventListener(new OkHttp3EventListener(this.client.eventListenerFactory() != null ? this.client.eventListenerFactory().create(this.client.newCall(new Request.Builder().originUrl(url).url(url).build())) : null, this.okHttp3RequestLog));
            this.client = newBuilder.build();
            ArrayList arrayList = new ArrayList();
            if (!request.isBypassDispatch()) {
                try {
                    url = doOkHttpDispatch(url, request.getMethod(), arrayList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            List<Header> arrayList2 = new ArrayList<>();
            long uptimeMillis = SystemClock.uptimeMillis();
            TTMetaDispatchLog tTMetaDispatchLog = new TTMetaDispatchLog();
            String dispatch = TTMetaDispatchManager.getInstance().dispatch(url, request, tTMetaDispatchLog, arrayList2);
            tTMetaDispatchLog.dispatchCostMs = SystemClock.uptimeMillis() - uptimeMillis;
            this.okHttp3RequestLog.recordMetaDispatchLog(tTMetaDispatchLog);
            if (arrayList2.isEmpty()) {
                arrayList2 = request.getHeaders();
            }
            String tryAddOkhttpBoeSuffix = BoeUtils.tryAddOkhttpBoeSuffix(SsOkHttp3Client.getContext(), dispatch, arrayList2);
            Request.Builder url2 = new Request.Builder().originUrl(tryAddOkhttpBoeSuffix).url(tryAddOkhttpBoeSuffix);
            for (Header header : arrayList) {
                url2.addHeader(header.getName(), header.getValue());
            }
            if (Logger.debug()) {
                url2.addHeader("fallback-reason", SsOkHttp3Client.getFallbackReasonHeaderValue(request));
            }
            if (!HttpMethod.permitsRequestBody(request.getMethod())) {
                method = url2.method(request.getMethod(), (RequestBody) null);
            } else {
                method = url2.method(request.getMethod(), createRequestBody(request.getBody(), request.getRequestBody()));
            }
            if (request.getBody() != null && !request.isPureRequest() && (md5Stub = request.getBody().md5Stub()) != null) {
                method.addHeader("X-SS-STUB", md5Stub);
            }
            method.addHeader("Accept-Encoding", "gzip");
            for (Header header2 : arrayList2) {
                if (!StringUtils.isEmpty(header2.getName()) && !StringUtils.isEmpty(header2.getValue())) {
                    if (UrlUtils.USER_AGENT.equals(header2.getName())) {
                        str = header2.getValue();
                    }
                    method.header(header2.getName(), header2.getValue());
                }
            }
            if (StringUtils.isEmpty(str)) {
                str = NetworkParams.getUserAgent();
                if (!StringUtils.isEmpty(str)) {
                    str = str + " " + SsOkHttp3Client.getOkVersion();
                    method.header(UrlUtils.USER_AGENT, str);
                }
            }
            if (StringUtils.isEmpty(str)) {
                str = SsOkHttp3Client.getDefaultOkhttpUA();
                if (!TextUtils.isEmpty(str)) {
                    method.header(UrlUtils.USER_AGENT, str);
                }
            }
            try {
                baseHttpRequestInfo.extraInfo.put(BaseHttpRequestInfo.KEY_USER_AGENT, str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                        method.addHeader(key, value);
                    }
                }
            }
            Request build = method.build();
            this.okRequest = build;
            this.rawCall = this.client.newCall(build);
            try {
                baseHttpRequestInfo.url = new URL(tryAddOkhttpBoeSuffix);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            baseHttpRequestInfo.metrics.url = baseHttpRequestInfo.url;
        } finally {
            baseHttpRequestInfo.metrics.configureConnectionEnd(configureConnectionStart);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Request lambda$configureOkRequest$0(BaseRequestContext.AuthCredentials authCredentials, Route route, Response response) throws IOException {
        for (Challenge challenge : response.challenges()) {
            if ("Basic".equalsIgnoreCase(challenge.scheme())) {
                String basic = Credentials.basic(authCredentials.username, authCredentials.password, challenge.charset());
                if (TextUtils.equals(basic, response.request().header("Proxy-Authorization"))) {
                    return null;
                }
                return response.request().newBuilder().header("Proxy-Authorization", basic).build();
            }
        }
        return null;
    }

    private String doOkHttpDispatch(String str, String str2, List<Header> list) throws Exception {
        if (!URLDispatcher.inst().isDispatchActionsEmpty()) {
            long currentTimeMillis = System.currentTimeMillis();
            DispatchResult dispatchResultForUrl = URLDispatcher.inst().getDispatchResultForUrl(new URLRequest(str, str2, list));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (dispatchResultForUrl == null) {
                return str;
            }
            this.okHttp3RequestLog.recordDispatchLog(this.retrofitRequest.getMethod(), dispatchResultForUrl.mDispatchedURL, currentTimeMillis2 - currentTimeMillis, false, dispatchResultForUrl.mDispatchActionChain);
            if (str.equals(dispatchResultForUrl.mDispatchedURL)) {
                return str;
            }
            if (!dispatchResultForUrl.mDispatchedURL.isEmpty() || dispatchResultForUrl.mActionRuleIdList.isEmpty()) {
                return UrlUtils.isValidUrl(dispatchResultForUrl.mDispatchedURL) ? dispatchResultForUrl.mDispatchedURL : str;
            }
            this.okHttp3RequestLog.setNetError(dispatchResultForUrl.mDropCode);
            throw new Exception("ERR_TTNET_TRAFFIC_CONTROL_DROP" + (dispatchResultForUrl.mDropCode == -555 ? "" : "_" + (-dispatchResultForUrl.mDropCode)) + ", " + dispatchResultForUrl.mDropCode);
        }
        if (Logger.debug()) {
            Logger.d(TAG, "fallback to host replace map");
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        String handleHostMapping = URLDispatcher.inst().handleHostMapping(str);
        long currentTimeMillis4 = System.currentTimeMillis();
        if (str.equals(handleHostMapping) || !UrlUtils.isValidUrl(handleHostMapping)) {
            return str;
        }
        this.okHttp3RequestLog.recordDispatchLog(this.retrofitRequest.getMethod(), handleHostMapping, currentTimeMillis4 - currentTimeMillis3, true, null);
        return handleHostMapping;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected void onFinalResponseHeaderReceived(BaseHttpRequestInfo baseHttpRequestInfo, HttpResponseProvider httpResponseProvider) {
        super.onFinalResponseHeaderReceived(baseHttpRequestInfo, httpResponseProvider);
        if (SsOkHttp3Client.getOk3TncBridge() != null) {
            SsOkHttp3Client.getOk3TncBridge().onOk3Response(this.okRequest, this.okResponse);
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected void onResponseBodyProcessed(TypedInput typedInput) {
        if (typedInput == null || this.retrofitRequest.isResponseStreaming() || !(typedInput instanceof TypedByteArray)) {
            return;
        }
        this.requestInfo.metrics.postProcessBodyStart();
        try {
            StoreRegionManager.inst().updateStoreRegionForOkHttp(this.okResponse, this.retrofitRequest.getUrl(), ((TypedByteArray) typedInput).getBytes());
        } catch (Throwable unused) {
        }
        this.requestInfo.metrics.postProcessBodyEnd();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected void onProcessExceptionStart(Exception exc) {
        if (SsOkHttp3Client.getOk3TncBridge() != null) {
            SsOkHttp3Client.getOk3TncBridge().onOk3Timeout(this.okRequest, exc);
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected IOException convertException(Exception exc) {
        if (exc instanceof TTNetExceptionStorage) {
            TTNetExceptionStorage tTNetExceptionStorage = (TTNetExceptionStorage) exc;
            tTNetExceptionStorage.setInfo(false, true, this.retrofitRequest.getUrl(), this.requestInfo.traceCode, this.requestInfo);
            return tTNetExceptionStorage;
        }
        TTNetExceptionStorage tTNetExceptionStorage2 = new TTNetExceptionStorage(exc.getMessage(), exc);
        tTNetExceptionStorage2.setInfo(false, true, this.retrofitRequest.getUrl(), this.requestInfo.traceCode, this.requestInfo);
        return tTNetExceptionStorage2;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected int getStatusCodeFromException(IOException iOException) {
        return TTNetUtils.convertExceptionToErrorCode(iOException);
    }

    public void cancel() {
        Call call = this.rawCall;
        if (call == null || call.isCanceled()) {
            return;
        }
        this.okHttp3RequestLog.bizCancel();
        this.rawCall.cancel();
        this.canceled = true;
    }

    private static RequestBody createRequestBody(final TypedOutput typedOutput, RequestBody requestBody) {
        if (requestBody != null) {
            return requestBody;
        }
        if (typedOutput == null) {
            return RequestBody.create((MediaType) null, "body=null");
        }
        final MediaType parse = MediaType.parse(typedOutput.mimeType());
        return new RequestBody() { // from class: com.bytedance.frameworks.baselib.network.http.ok3.impl.Ok3SsCall.1
            public MediaType contentType() {
                return parse;
            }

            public void writeTo(BufferedSink bufferedSink) throws IOException {
                typedOutput.writeTo(bufferedSink.outputStream());
            }

            public long contentLength() {
                return typedOutput.length();
            }
        };
    }
}
