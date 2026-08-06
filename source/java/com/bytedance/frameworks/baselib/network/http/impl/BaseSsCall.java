package com.bytedance.frameworks.baselib.network.http.impl;

import android.content.Context;
import android.text.TextUtils;
import coil3.disk.DiskLruCache;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.InputStreamWrapWithMetrics;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.connectionclass.DeviceBandwidthSampler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpClient;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.InputStreamWrap;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestRetryResult;
import com.bytedance.frameworks.baselib.network.http.RotationHostRetryHandler;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.requestaudit.TTRequestAuditManager;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class BaseSsCall implements SsCall, IRequestInfo, HttpResponseProvider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static volatile boolean TNC_USE_OKIO_READ = true;
    private static volatile boolean USER_USE_OKIO_READ;
    protected boolean bypassNetworkStatusCheck;
    protected volatile boolean canceled = false;
    protected BaseHttpRequestInfo requestInfo = BaseHttpRequestInfo.createHttpRequestInfo();
    protected Request retrofitRequest;

    protected boolean bypassNetworkStatusCheck() {
        return false;
    }

    protected void checkNetworkAvailableAfterRequest(Request request, Exception exc) throws NetworkNotAvailabeException {
    }

    protected abstract void executeNetworkRequest(RetrofitMetrics retrofitMetrics) throws IOException;

    protected abstract Context getContext();

    protected int getStatusCodeFromException(IOException iOException) {
        return -1;
    }

    protected void onExecuteStart() throws IOException {
    }

    protected void onProcessExceptionStart(Exception exc) {
    }

    protected void onResponseBodyProcessed(TypedInput typedInput) {
    }

    protected abstract void prepareNetworkRequest(String str, Request request, BaseHttpRequestInfo baseHttpRequestInfo, Map<String, String> map) throws IOException;

    public static void setTncUseOkioRead(boolean z) {
        TNC_USE_OKIO_READ = z;
    }

    public static void setUseOkioRead(boolean z) {
        USER_USE_OKIO_READ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseSsCall(Request request) {
        this.bypassNetworkStatusCheck = false;
        this.retrofitRequest = request;
        if (request.getMetrics() != null) {
            this.requestInfo.attachMetrics(request.getMetrics());
        }
        this.requestInfo.metrics.ResetNetworkLibMetrics();
        this.requestInfo.metrics.retrofit.eventTs.cronetInitStart = TTNetInitMetrics.inst().createEngineStart;
        this.requestInfo.metrics.retrofit.eventTs.cronetInitEnd = TTNetInitMetrics.inst().cronetInitEnd;
        this.requestInfo.metrics.ttnetVersion = "4.2.243.6-doubao";
        this.requestInfo.downloadFile = this.retrofitRequest.isResponseStreaming();
        if (this.retrofitRequest.getExtraInfo() instanceof BaseRequestContext) {
            this.requestInfo.reqContext = (T) this.retrofitRequest.getExtraInfo();
            this.bypassNetworkStatusCheck = this.requestInfo.reqContext.bypass_network_status_check;
            List<BaseRequestContext.RotationHostRetryInfo> list = this.requestInfo.reqContext.rotationHostRetryInfoList;
            if (list == null || list.size() <= 0 || list.size() > 3) {
                return;
            }
            this.requestInfo.rotationHostPathRetryHandler = new RotationHostRetryHandler(list);
        }
    }

    public Request getRequest() {
        return this.retrofitRequest;
    }

    public Object getRequestInfo() {
        return this.requestInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0105 A[Catch: all -> 0x00f6, TRY_ENTER, TryCatch #2 {all -> 0x00f6, blocks: (B:8:0x0022, B:11:0x002f, B:13:0x0037, B:15:0x003d, B:17:0x0049, B:47:0x0105, B:49:0x010c, B:52:0x0118, B:53:0x0119, B:55:0x011d, B:57:0x0129, B:58:0x012a, B:59:0x0133, B:60:0x0134, B:80:0x00f9, B:81:0x0100), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0134 A[Catch: all -> 0x00f6, TRY_LEAVE, TryCatch #2 {all -> 0x00f6, blocks: (B:8:0x0022, B:11:0x002f, B:13:0x0037, B:15:0x003d, B:17:0x0049, B:47:0x0105, B:49:0x010c, B:52:0x0118, B:53:0x0119, B:55:0x011d, B:57:0x0129, B:58:0x012a, B:59:0x0133, B:60:0x0134, B:80:0x00f9, B:81:0x0100), top: B:7:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response execute() throws IOException {
        Exception exc;
        RetrofitMetrics retrofitMetrics;
        NetworkParams.ConnectionQualitySamplerHook connectionQualitySamplerHook;
        if (this.canceled) {
            throw new IOException("request canceled");
        }
        onExecuteStart();
        tryNecessaryInit(this.retrofitRequest, this.requestInfo);
        checkNetworkAvailableBeforeRequest();
        long nanoTime = System.nanoTime();
        try {
            this.retrofitRequest = TTRequestAuditManager.auditAndControl(this.retrofitRequest, this.requestInfo);
        } catch (Throwable unused) {
        }
        boolean z = true;
        boolean z2 = false;
        try {
            try {
                prepareNetworkRequest(this.retrofitRequest.getUrl(), this.retrofitRequest, this.requestInfo, null);
                try {
                    if (this.retrofitRequest.isResponseStreaming() || (connectionQualitySamplerHook = NetworkParams.getConnectionQualitySamplerHook()) == null || !connectionQualitySamplerHook.shouldSampling(this.retrofitRequest.getUrl())) {
                        z = false;
                    } else {
                        DeviceBandwidthSampler.getInstance().startSampling();
                    }
                } catch (Exception e) {
                    exc = e;
                    z = false;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                List<String> arrayList = new ArrayList<>();
                try {
                    try {
                        executeNetworkRequest(this.requestInfo.metrics);
                        arrayList = retryRequestOnceIfNeeded(this.retrofitRequest, this.requestInfo, this, true, false);
                        retrofitMetrics = this.requestInfo.metrics;
                    } finally {
                        this.requestInfo.metrics.setConstructConfigureAndRetryConnection(nanoTime);
                    }
                } catch (IOException e2) {
                    tryRotationHostRetryOnGetResponseCodeException(this.retrofitRequest, getStatusCodeFromException(e2), this.requestInfo, this, e2, true);
                    retrofitMetrics = this.requestInfo.metrics;
                }
                retrofitMetrics.setConstructConfigureAndRetryConnection(nanoTime);
                onFinalResponseHeaderReceived(this.requestInfo, this);
                TypedInput processResponseBody = processResponseBody(this.retrofitRequest.getUrl(), this.retrofitRequest, this.requestInfo, this, this);
                onResponseBodyProcessed(processResponseBody);
                Response response = new Response(this.retrofitRequest.getUrl(), responseCode(), responseMessage(), createHeaders(this, arrayList), processResponseBody);
                response.setExtraInfo(this.requestInfo);
                response.setTraceCode(this.requestInfo.traceCode);
                if (!this.retrofitRequest.isResponseStreaming()) {
                    safeClose();
                }
                if (!this.retrofitRequest.isResponseStreaming() && z) {
                    DeviceBandwidthSampler.getInstance().stopSampling();
                }
                return response;
            } catch (Exception e3) {
                exc = e3;
                z = false;
                if (!z) {
                }
            } catch (Throwable th2) {
                th = th2;
                z2 = z;
                if (0 != 0) {
                    updateRequestInfoWithException(this.requestInfo, this, null);
                }
                if (!this.retrofitRequest.isResponseStreaming() || 0 != 0) {
                    safeClose();
                }
                if (!this.retrofitRequest.isResponseStreaming() && z2) {
                    DeviceBandwidthSampler.getInstance().stopSampling();
                }
                throw th;
            }
        } catch (Exception e4) {
            try {
                throw e4;
            } catch (Exception e5) {
                exc = e5;
                if (!z) {
                    throw exc;
                }
                onProcessExceptionStart(exc);
                if ((exc instanceof HttpResponseException) && ((HttpResponseException) exc).getStatusCode() == 304) {
                    throw exc;
                }
                if ((exc instanceof IOException) && "Canceled".equals(exc.getMessage())) {
                    throw exc;
                }
                checkNetworkAvailableAfterRequest(this.retrofitRequest, exc);
                throw convertException(exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void tryNecessaryInit(Request request, BaseHttpRequestInfo baseHttpRequestInfo) {
        NetworkParams.tryApiProcessHookInit(baseHttpRequestInfo.metrics);
        if (NetworkParams.interceptCookie(request.getExtraInfo())) {
            return;
        }
        baseHttpRequestInfo.metrics.tryInitCookieManagerStart();
        try {
            NetworkParams.tryCookieManagerInit();
        } finally {
            baseHttpRequestInfo.metrics.tryInitCookieManagerEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Throwable, com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException] */
    public void checkNetworkAvailableBeforeRequest() throws NetworkNotAvailabeException {
        if (bypassNetworkStatusCheck() || getContext() == null || NetworkUtils.isNetworkAvailable(getContext())) {
            return;
        }
        ?? networkNotAvailabeException = new NetworkNotAvailabeException("network not available for " + this.retrofitRequest.getPath());
        networkNotAvailabeException.setInfo(false, false, this.retrofitRequest.getUrl(), "", this.requestInfo);
        throw networkNotAvailabeException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<String> retryRequestOnceIfNeeded(Request request, BaseHttpRequestInfo baseHttpRequestInfo, HttpResponseProvider httpResponseProvider, boolean z, boolean z2) throws IOException {
        RequestRetryResult shouldRetryRequestOnceTime = NetworkParams.shouldRetryRequestOnceTime(request, httpResponseProvider.responseCode(), baseHttpRequestInfo, request.getHeaders(), httpResponseProvider.responseHeaders(), z, z2);
        ArrayList arrayList = null;
        if (shouldRetryRequestOnceTime != null && shouldRetryRequestOnceTime.isRequestRetryEnabled()) {
            if (baseHttpRequestInfo.rotationHostRetry) {
                request = request.newBuilder().url(shouldRetryRequestOnceTime.getNextRetryUrl()).build();
            }
            retryCurrentRequestOneTime(request, baseHttpRequestInfo, httpResponseProvider, shouldRetryRequestOnceTime.getAddRequestHeaders());
            return null;
        }
        if (!StringUtils.isEmpty(baseHttpRequestInfo.retryByHeaderFilterKey) && (shouldRetryRequestOnceTime == null || shouldRetryRequestOnceTime.isRemoveHitResponseHeaderIfNotRetry())) {
            arrayList = new ArrayList();
            if (!StringUtils.isEmpty(baseHttpRequestInfo.retryByHeaderFilterKey)) {
                arrayList.add(baseHttpRequestInfo.retryByHeaderFilterKey);
            }
        }
        return arrayList;
    }

    protected void retryCurrentRequestOneTime(Request request, BaseHttpRequestInfo baseHttpRequestInfo, HttpResponseProvider httpResponseProvider, Map<String, String> map) throws IOException {
        httpResponseProvider.safeClose();
        baseHttpRequestInfo.requestRetryStart = System.currentTimeMillis();
        prepareNetworkRequest(request.getUrl(), request, baseHttpRequestInfo, map);
        try {
            executeNetworkRequest(baseHttpRequestInfo.metrics);
            retryRequestOnceIfNeeded(request, baseHttpRequestInfo, this, false, false);
        } catch (IOException e) {
            tryRotationHostRetryOnGetResponseCodeException(request, getStatusCodeFromException(e), baseHttpRequestInfo, httpResponseProvider, e, false);
        }
    }

    private void tryRotationHostRetryOnGetResponseCodeException(Request request, int i, BaseHttpRequestInfo baseHttpRequestInfo, HttpResponseProvider httpResponseProvider, IOException iOException, boolean z) throws IOException {
        RequestRetryResult shouldRetryRequestOnceTime = NetworkParams.shouldRetryRequestOnceTime(request, i, baseHttpRequestInfo, request.getHeaders(), null, z, false);
        if (shouldRetryRequestOnceTime != null) {
            if (!shouldRetryRequestOnceTime.isRequestRetryEnabled()) {
                throw iOException;
            }
            if (baseHttpRequestInfo.rotationHostRetry) {
                retryCurrentRequestOneTime(request.newBuilder().url(shouldRetryRequestOnceTime.getNextRetryUrl()).build(), baseHttpRequestInfo, httpResponseProvider, shouldRetryRequestOnceTime.getAddRequestHeaders());
                return;
            }
            throw iOException;
        }
        throw iOException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFinalResponseHeaderReceived(BaseHttpRequestInfo baseHttpRequestInfo, HttpResponseProvider httpResponseProvider) {
        JSONObject constructJsonLog;
        long currentTimeMillis = System.currentTimeMillis();
        baseHttpRequestInfo.responseBack = currentTimeMillis;
        baseHttpRequestInfo.completeReadResponse = currentTimeMillis;
        baseHttpRequestInfo.contentType = BaseHttpClient.getContentBaseType(httpResponseProvider.contentType());
        getRemoteIp(httpResponseProvider.responseHeaderValue(NetworkParams.PNAME_REMOTE_ADDRESS), baseHttpRequestInfo);
        if (baseHttpRequestInfo.reqContext != 0) {
            baseHttpRequestInfo.reqContext.status = httpResponseProvider.responseCode();
        }
        baseHttpRequestInfo.traceCode = httpResponseProvider.responseHeaderValue("X-TT-LOGID");
        if (baseHttpRequestInfo.traceCode == null) {
            baseHttpRequestInfo.traceCode = "";
        }
        baseHttpRequestInfo.metrics.traceCode = baseHttpRequestInfo.traceCode;
        baseHttpRequestInfo.fromCache = httpResponseProvider.fromCache();
        try {
            if (baseHttpRequestInfo.turingCallbackDuration >= 0) {
                baseHttpRequestInfo.extraInfo.put("turing_callback", baseHttpRequestInfo.turingCallbackDuration);
            }
            if (baseHttpRequestInfo.retryForAccountCallbackDuration >= 0) {
                baseHttpRequestInfo.extraInfo.put("retry_for_account_cost", baseHttpRequestInfo.retryForAccountCallbackDuration);
            }
            if (baseHttpRequestInfo.bdTuringRetry) {
                baseHttpRequestInfo.extraInfo.put("turing_retry", DiskLruCache.VERSION);
            }
            if (baseHttpRequestInfo.accountRetry) {
                baseHttpRequestInfo.extraInfo.put("account_retry", DiskLruCache.VERSION);
            }
            if (baseHttpRequestInfo.retryByHeaderFilterKey != null) {
                baseHttpRequestInfo.extraInfo.put("retry_by_header", baseHttpRequestInfo.retryByHeaderFilterKey);
            }
            if (baseHttpRequestInfo.rotationHostPathRetryHandler == null || (constructJsonLog = baseHttpRequestInfo.rotationHostPathRetryHandler.constructJsonLog()) == null || constructJsonLog.length() <= 0) {
                return;
            }
            baseHttpRequestInfo.extraInfo.put("rotation_host_retry", constructJsonLog);
            baseHttpRequestInfo.metrics.setRotationHostRetryInfo(constructJsonLog);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void getRemoteIp(String str, BaseHttpRequestInfo baseHttpRequestInfo) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        try {
            baseHttpRequestInfo.remoteIp = str;
            if (baseHttpRequestInfo.reqContext != 0) {
                baseHttpRequestInfo.reqContext.remoteIp = str;
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean is2XXRequest(Request request, HttpResponseProvider httpResponseProvider) {
        return request.isResponseStreaming() ? httpResponseProvider.responseCode() >= 200 && httpResponseProvider.responseCode() < 300 : httpResponseProvider.responseCode() == 200;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Throwable, com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException] */
    public static TypedInput processResponseBody(String str, final Request request, final BaseHttpRequestInfo baseHttpRequestInfo, final HttpResponseProvider httpResponseProvider, final SsCall ssCall) throws IOException {
        int[] iArr;
        InputStream in;
        baseHttpRequestInfo.metrics.processResponseBodyStart();
        try {
            boolean isForceHandleResponse = isForceHandleResponse(baseHttpRequestInfo);
            TypedInput typedInput = new TypedInput() { // from class: com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall.1
                private volatile InputStreamWrap inputStreamWrap = null;

                public String mimeType() {
                    return HttpResponseProvider.this.contentType();
                }

                public long length() throws IOException {
                    return HttpResponseProvider.this.contentLength();
                }

                /* renamed from: in */
                public InputStream m1291in() throws IOException {
                    if (this.inputStreamWrap == null) {
                        synchronized (this) {
                            if (this.inputStreamWrap == null) {
                                this.inputStreamWrap = getInputStreamWrap();
                            }
                        }
                    }
                    return this.inputStreamWrap;
                }

                private InputStreamWrap getInputStreamWrap() throws IOException {
                    InputStream errorStream;
                    try {
                        try {
                            errorStream = HttpResponseProvider.this.inputStream();
                        } catch (Exception unused) {
                            errorStream = HttpResponseProvider.this.errorStream();
                        }
                        if (errorStream != null) {
                            errorStream = StreamParser.processInputStream(errorStream, HttpResponseProvider.this.responseHeaders(), HttpResponseProvider.this.isGzip(), baseHttpRequestInfo.metrics);
                        }
                        if (baseHttpRequestInfo.httpClientType == 1) {
                            return new InputStreamWrapWithMetrics(errorStream, ssCall, baseHttpRequestInfo);
                        }
                        return new InputStreamWrap(errorStream, ssCall);
                    } catch (Exception e) {
                        throw new HttpResponseException(HttpResponseProvider.this.responseCode(), "reason = " + HttpResponseProvider.this.responseMessage() + ", exception = " + e.getMessage(), request.getPath(), null);
                    }
                }
            };
            if (request.isResponseStreaming() && (is2XXRequest(request, httpResponseProvider) || isForceHandleResponse)) {
                return typedInput;
            }
            baseHttpRequestInfo.metrics.markReadResponseBodyInternal();
            boolean z = TNC_USE_OKIO_READ && USER_USE_OKIO_READ;
            boolean z2 = baseHttpRequestInfo.useCronetInputStreamWithTTBuffer;
            InputStream inputStream = null;
            r15 = null;
            r15 = null;
            r15 = null;
            r15 = null;
            r15 = null;
            String str2 = null;
            try {
                iArr = new int[1];
                in = typedInput.in();
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] readResponseInternal = StreamParser.readResponseInternal(httpResponseProvider.isGzip(), request.getMaxLength(), in, iArr, baseHttpRequestInfo.metrics, z, z2);
                StreamParser.safeClose(in);
                if (!is2XXRequest(request, httpResponseProvider) && !isForceHandleResponse) {
                    if (readResponseInternal != null && readResponseInternal.length > 0 && !StringUtils.isEmpty(httpResponseProvider.contentType()) && (Logger.debug() || shouldReadErrorResponse(baseHttpRequestInfo))) {
                        try {
                            MimeType mimeType = new MimeType(httpResponseProvider.contentType());
                            if (StrategyConstants.TEXT.equalsIgnoreCase(mimeType.getPrimaryType()) || "application/json".equalsIgnoreCase(mimeType.getBaseType())) {
                                String parameter = mimeType.getParameter("charset");
                                if (StringUtils.isEmpty(parameter)) {
                                    parameter = "utf-8";
                                }
                                str2 = new String(readResponseInternal, parameter);
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    ?? httpResponseException = new HttpResponseException(httpResponseProvider.responseCode(), "", request.getPath(), str2);
                    if (request.isResponseStreaming() || httpResponseProvider.responseCode() == 304) {
                        httpResponseException.setInfo(true, false, str, baseHttpRequestInfo.traceCode, baseHttpRequestInfo);
                        throw httpResponseException;
                    }
                    throw httpResponseException;
                }
                if (StreamParser.testIsSSBinary(httpResponseProvider.contentType()) && readResponseInternal != null) {
                    StreamParser.decodeSSBinary(readResponseInternal, readResponseInternal.length);
                }
                String contentType = httpResponseProvider.contentType();
                if (readResponseInternal == null) {
                    readResponseInternal = new byte[0];
                }
                return new TypedByteArray(contentType, readResponseInternal, new String[0]);
            } catch (Throwable th3) {
                th = th3;
                inputStream = in;
                StreamParser.safeClose(inputStream);
                throw th;
            }
        } finally {
            baseHttpRequestInfo.metrics.processResponseBodyEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String processHttpErrorResponse(BaseHttpRequestInfo baseHttpRequestInfo, Map<String, List<String>> map, int i, InputStream inputStream, String str, boolean z) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            try {
                inputStream = StreamParser.processInputStream(inputStream, map, z, baseHttpRequestInfo.metrics);
                byte[] readResponseInternal = StreamParser.readResponseInternal(z, i, inputStream, new int[1], baseHttpRequestInfo.metrics, false, baseHttpRequestInfo.useCronetInputStreamWithTTBuffer);
                if (readResponseInternal == null || readResponseInternal.length <= 0 || StringUtils.isEmpty(str)) {
                    return null;
                }
                if (!Logger.debug() && !shouldReadErrorResponse(baseHttpRequestInfo)) {
                    return null;
                }
                try {
                    MimeType mimeType = new MimeType(str);
                    if (!StrategyConstants.TEXT.equalsIgnoreCase(mimeType.getPrimaryType()) && !"application/json".equalsIgnoreCase(mimeType.getBaseType())) {
                        return null;
                    }
                    String parameter = mimeType.getParameter("charset");
                    if (StringUtils.isEmpty(parameter)) {
                        parameter = "utf-8";
                    }
                    return new String(readResponseInternal, parameter);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            } catch (Exception e) {
                throw new IOException(e);
            }
        } finally {
            StreamParser.safeClose(inputStream);
        }
    }

    private static boolean shouldReadErrorResponse(BaseHttpRequestInfo baseHttpRequestInfo) {
        return (baseHttpRequestInfo == null || baseHttpRequestInfo.reqContext == 0 || !baseHttpRequestInfo.reqContext.read_error_response) ? false : true;
    }

    private static boolean isForceHandleResponse(BaseHttpRequestInfo baseHttpRequestInfo) {
        return (baseHttpRequestInfo == null || baseHttpRequestInfo.reqContext == 0 || !baseHttpRequestInfo.reqContext.force_handle_response) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<Header> createHeaders(HttpResponseProvider httpResponseProvider, List<String> list) {
        boolean z;
        Map<String, List<String>> responseHeaders = httpResponseProvider.responseHeaders();
        if (responseHeaders == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
            String key = entry.getKey();
            if (key != null && list != null && !list.isEmpty()) {
                Iterator<String> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    if (key.equalsIgnoreCase(it.next())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                }
            }
            Iterator<String> it2 = entry.getValue().iterator();
            while (it2.hasNext()) {
                arrayList.add(new Header(key, it2.next()));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void updateRequestInfoWithException(BaseHttpRequestInfo baseHttpRequestInfo, HttpResponseProvider httpResponseProvider, Exception exc) {
        try {
            String allHeaderFieldsString = getAllHeaderFieldsString(httpResponseProvider.responseHeaders());
            if (!StringUtils.isEmpty(allHeaderFieldsString)) {
                baseHttpRequestInfo.extraInfo.put(BaseHttpRequestInfo.KEY_RESPONSE_HEADERS, allHeaderFieldsString);
            }
            String message = exc.getMessage();
            Throwable cause = exc.getCause();
            if (!TextUtils.isEmpty(message) && cause != null && !TextUtils.isEmpty(cause.getMessage())) {
                message = message + ", cause = " + cause.getMessage();
            }
            baseHttpRequestInfo.extraInfo.put(BaseHttpRequestInfo.KEY_EXCEPTION, message);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (StringUtils.isEmpty(baseHttpRequestInfo.remoteIp)) {
            getRemoteIp(getHostAddress(exc), baseHttpRequestInfo);
        }
    }

    private static String getAllHeaderFieldsString(Map<String, List<String>> map) {
        List<String> value;
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                        if (entry != null) {
                            String key = entry.getKey();
                            if (!StringUtils.isEmpty(key) && (value = entry.getValue()) != null && !value.isEmpty()) {
                                StringBuilder sb = new StringBuilder();
                                int i = 0;
                                for (String str : value) {
                                    if (!StringUtils.isEmpty(str)) {
                                        if (i == 0) {
                                            sb.append(str);
                                        } else {
                                            sb.append("; ").append(str);
                                        }
                                        i++;
                                    }
                                }
                                jSONObject.put(key, sb.toString());
                            }
                        }
                    }
                    return jSONObject.toString();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    private static String getHostAddress(Exception exc) {
        String message;
        if (exc == null) {
            return "";
        }
        try {
            message = exc.getMessage();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (message != null && !TextUtils.isEmpty(exc.getMessage())) {
            String[] split = message.split("\\|");
            if (split.length >= 2) {
                return split[0];
            }
            return "";
        }
        return "";
    }

    protected IOException convertException(Exception exc) {
        return new IOException(exc.getMessage(), exc.getCause());
    }
}
