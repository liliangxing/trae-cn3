package okhttp3.internal.http;

import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import ms.bd.p001c.AbstractC0116c2;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.ttnet.TTConfigManager;
import okhttp3.ttnet.TTNetDnsRetryHelper;
import okhttp3.ttnet.TTNetUtils;
import okhttp3.ttnet.TTOkHttpConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final String BYPASS_DOWNGRADE_COOKIE_HEADER = "x-metasec-ok-bypass-downgrade-cookie";
    private static final String COOKIE2_HEADER = "Cookie2";
    private static final String COOKIE_HEADER = "Cookie";
    public static final String KEY_BYPASS_DISPATCH = "x-tt-bypass-dp";
    private static final int MAX_FOLLOW_UPS = 20;
    private static final List<String> SAFE_STANDARD_REQUEST_HEADERS = Util.immutableList("Accept", "Accept-Charset", "Accept-Encoding", "Accept-Language", "Authorization", "Cache-Control", "Connection", "Content-Length", "Content-Type", "Host", "If-Match", "If-Modified-Since", "If-None-Match", "If-Range", "If-Unmodified-Since", "Origin", "Pragma", "Proxy-Authorization", "Proxy-Connection", "Range", "Referer", "Transfer-Encoding", "User-Agent");
    private static final String TT_TOKEN_HEADER = "x-tt-token";
    private static final String X_SS_COOKIE_HEADER = "X-SS-Cookie";
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private final boolean forWebSocket;
    private volatile StreamAllocation streamAllocation;
    private volatile int canceledReason = TTOkHttpConstants.ERR_TTNET_UNKNOWN;
    private volatile boolean hasTriedForceHttpDns = false;

    private boolean needRedirectToPost(int i) {
        return i == 308 || i == 307;
    }

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.client = okHttpClient;
        this.forWebSocket = z;
    }

    public void cancel(int i) {
        this.canceledReason = i;
        this.canceled = true;
        StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation != null) {
            streamAllocation.cancel(i);
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean canceledReason() {
        return this.canceled;
    }

    public void setCallStackTrace(Object obj) {
        this.callStackTrace = obj;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed;
        Request followUpRequest;
        Request request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Call call = realInterceptorChain.call();
        EventListener eventListener = realInterceptorChain.eventListener();
        StreamAllocation streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(request.url()), call, eventListener, this.callStackTrace);
        this.streamAllocation = streamAllocation;
        int i = 0;
        Response response = null;
        while (!this.canceled) {
            try {
                try {
                    proceed = realInterceptorChain.proceed(request, streamAllocation, null, null);
                    if (response != null) {
                        proceed = proceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                    }
                    try {
                        followUpRequest = followUpRequest(proceed, streamAllocation.route(), call, eventListener);
                    } catch (IOException e) {
                        streamAllocation.release();
                        throw e;
                    }
                } catch (IOException e2) {
                    if (!recover(e2, streamAllocation, !(e2 instanceof ConnectionShutdownException), request)) {
                        throw e2;
                    }
                } catch (RouteException e3) {
                    if (!recover(e3.getLastConnectException(), streamAllocation, false, request)) {
                        throw e3.getFirstConnectException();
                    }
                }
                if (followUpRequest == null) {
                    streamAllocation.release();
                    return proceed;
                }
                Util.closeQuietly(proceed.body());
                int i2 = i + 1;
                if (i2 > 20) {
                    streamAllocation.release();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                }
                if (followUpRequest.body() instanceof UnrepeatableRequestBody) {
                    streamAllocation.release();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", proceed.code());
                }
                if (!sameConnection(proceed, followUpRequest.url())) {
                    streamAllocation.release();
                    streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(followUpRequest.url()), call, eventListener, this.callStackTrace);
                    this.streamAllocation = streamAllocation;
                } else if (streamAllocation.codec() != null) {
                    throw new IllegalStateException("Closing the body of " + proceed + " didn't close its backing stream. Bad interceptor?");
                }
                response = proceed;
                request = followUpRequest;
                i = i2;
            } catch (Throwable th) {
                streamAllocation.streamFailed(null);
                streamAllocation.release();
                throw th;
            }
        }
        streamAllocation.release();
        throw new IOException("Canceled#Reason=" + this.canceledReason);
    }

    private Address createAddress(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            sSLSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector(), this.client.ttnetDns());
    }

    private boolean recover(IOException iOException, StreamAllocation streamAllocation, boolean z, Request request) {
        streamAllocation.streamFailed(iOException);
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if (z && requestIsUnrepeatable(iOException, request)) {
            return false;
        }
        if (!isRecoverable(iOException, z)) {
            return shouldRetryForceHttpDnsOnError(iOException, request);
        }
        if (streamAllocation().hasMoreRoutes()) {
            return true;
        }
        return shouldRetryForceHttpDnsOnError(iOException, request);
    }

    private boolean shouldRetryForceHttpDnsOnError(IOException iOException, Request request) {
        if (this.hasTriedForceHttpDns) {
            return false;
        }
        this.hasTriedForceHttpDns = true;
        int convertExceptionToErrorCode = TTNetUtils.convertExceptionToErrorCode(iOException);
        if (!TTConfigManager.inst().shouldRetryForceHttpdnsOnError(iOException, request, convertExceptionToErrorCode)) {
            return false;
        }
        this.streamAllocation.resetRouteSelector(convertExceptionToErrorCode);
        TTNetDnsRetryHelper.inst().setForceHttpDns(request, true);
        return true;
    }

    private boolean requestIsUnrepeatable(IOException iOException, Request request) {
        return (request.body() instanceof UnrepeatableRequestBody) || (iOException instanceof FileNotFoundException);
    }

    private boolean isRecoverable(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private Request followUpRequest(Response response, Route route, Call call, EventListener eventListener) throws IOException {
        String header;
        HttpUrl resolve;
        if (response == null) {
            throw new IllegalStateException();
        }
        int code = response.code();
        String method = response.request().method();
        if (code != 307 && code != 308) {
            if (code == 401) {
                return this.client.authenticator().authenticate(route, response);
            }
            if (code == 503) {
                if ((response.priorResponse() == null || response.priorResponse().code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                }
                return null;
            }
            if (code == 407) {
                if (route.proxy().type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.client.proxyAuthenticator().authenticate(route, response);
            }
            if (code == 408) {
                if (!this.client.retryOnConnectionFailure() || (response.request().body() instanceof UnrepeatableRequestBody)) {
                    return null;
                }
                if ((response.priorResponse() == null || response.priorResponse().code() != 408) && retryAfter(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            }
            switch (code) {
                case AbstractC0116c2.COLLECT_MODE_FINANCE /* 300 */:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.client.followRedirects() || (header = response.header("Location")) == null || (resolve = response.request().url().resolve(header)) == null) {
            return null;
        }
        HttpUrl handleRedirectDispatch = handleRedirectDispatch(call, response.request(), resolve, eventListener);
        if (handleRedirectDispatch != null) {
            resolve = handleRedirectDispatch;
        }
        if (!resolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(method)) {
            boolean z = HttpMethod.redirectsWithBody(method) || needRedirectToPost(code);
            if (!needRedirectToPost(code) && HttpMethod.redirectsToGet(method)) {
                newBuilder.method("GET", null);
            } else {
                newBuilder.method(method, z ? response.request().body() : null);
            }
            if (!z) {
                newBuilder.removeHeader("Transfer-Encoding");
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!sameConnection(response, resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        handleRedirectHeaders(call, response.request(), resolve, newBuilder, eventListener);
        return newBuilder.url(resolve).build();
    }

    private int retryAfter(Response response, int i) {
        String header = response.header("Retry-After");
        if (header == null) {
            return i;
        }
        if (header.matches("\\d+")) {
            return Integer.valueOf(header).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean sameConnection(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }

    private HttpUrl handleRedirectDispatch(Call call, Request request, HttpUrl httpUrl, EventListener eventListener) {
        HttpUrl url = request == null ? null : request.url();
        if (eventListener == null || url == null || httpUrl == null) {
            return httpUrl;
        }
        String header = request.header(KEY_BYPASS_DISPATCH);
        return (TextUtils.isEmpty(header) || !"1".equals(header)) ? eventListener.callRedirectDispatch(call, url, request.method(), httpUrl) : httpUrl;
    }

    private void handleRedirectHeaders(Call call, Request request, HttpUrl httpUrl, Request.Builder builder, EventListener eventListener) {
        if (request == null || httpUrl == null || TextUtils.isEmpty(httpUrl.host()) || this.client.enableBoe()) {
            return;
        }
        if ((request.isHttps() || (request.originUrl() != null && request.originUrl().isHttps())) && !httpUrl.isHttps()) {
            tryRemoveInsecureRequestHeader(call, request, httpUrl, true, builder, eventListener);
            if (TTConfigManager.inCookieHostList(httpUrl.host())) {
                builder.addHeader(BYPASS_DOWNGRADE_COOKIE_HEADER, "1");
                return;
            }
            return;
        }
        if (TTConfigManager.inst().getRedirectRequestControlConfig().mOnlyControlWebview.get() || request.url().host().equals(httpUrl.host())) {
            return;
        }
        if ((request.originUrl() == null || !httpUrl.host().equals(request.originUrl().host())) && !isInSecureRedirectWhiteList(httpUrl.host())) {
            tryRemoveInsecureRequestHeader(call, request, httpUrl, false, builder, eventListener);
        }
    }

    private void tryRemoveInsecureRequestHeader(Call call, Request request, HttpUrl httpUrl, boolean z, Request.Builder builder, EventListener eventListener) {
        TTConfigManager.RedirectRequestControlConfig redirectRequestControlConfig = TTConfigManager.inst().getRedirectRequestControlConfig();
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        if (!redirectRequestControlConfig.mV2On.get()) {
            if (!redirectRequestControlConfig.mRmInsecureRedirectHeadersOutWhiteList.get() && !isInSecureRedirectBlackList(httpUrl.host())) {
                z2 = false;
            }
            if (!TextUtils.isEmpty(request.header(TT_TOKEN_HEADER))) {
                arrayList.add(TT_TOKEN_HEADER);
            }
            if (!TextUtils.isEmpty(request.header(COOKIE_HEADER))) {
                arrayList.add(COOKIE_HEADER);
            }
            if (!TextUtils.isEmpty(request.header(COOKIE2_HEADER))) {
                arrayList.add(COOKIE2_HEADER);
            }
            if (!TextUtils.isEmpty(request.header(X_SS_COOKIE_HEADER))) {
                arrayList.add(X_SS_COOKIE_HEADER);
            }
            Iterator<String> it = redirectRequestControlConfig.mSecureHeaders.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(request.header(next))) {
                    arrayList.add(next);
                }
            }
        } else {
            Iterator<Map.Entry<String, List<String>>> it2 = request.headers().toMultimap().entrySet().iterator();
            while (it2.hasNext()) {
                String key = it2.next().getKey();
                if (!shouldSkipRemoveHeader(key, redirectRequestControlConfig.mKeepHeadersV2, redirectRequestControlConfig.mRmStdKeepHeadersV2)) {
                    arrayList.add(key);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        boolean z3 = z2 | z;
        if (z3) {
            Iterator<String> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                builder.removeHeader(it3.next());
            }
        }
        if (redirectRequestControlConfig.mDisableReportInsecureRedirect.get()) {
            return;
        }
        reportInsecureRequestHeader(call, request, httpUrl, eventListener, z3, z, arrayList, redirectRequestControlConfig);
    }

    boolean shouldSkipRemoveHeader(String str, List<String> list, List<String> list2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        Iterator<String> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (str.equalsIgnoreCase(it2.next())) {
                return false;
            }
        }
        Iterator<String> it3 = SAFE_STANDARD_REQUEST_HEADERS.iterator();
        while (it3.hasNext()) {
            if (str.equalsIgnoreCase(it3.next())) {
                return true;
            }
        }
        return false;
    }

    private void reportInsecureRequestHeader(Call call, Request request, HttpUrl httpUrl, EventListener eventListener, boolean z, boolean z2, List<String> list, TTConfigManager.RedirectRequestControlConfig redirectRequestControlConfig) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("src", "ttok");
            if (redirectRequestControlConfig.mReportFullUrl.get()) {
                jSONObject.put("origin_url", request.url());
                jSONObject.put("rect_url", httpUrl.url());
            }
            jSONObject.put("origin_host", request.url().scheme() + "://" + request.url().host());
            jSONObject.put("rect_host", httpUrl.scheme() + "://" + httpUrl.host());
            jSONObject.put("origin_path", request.url().encodedPath());
            jSONObject.put("rect_path", httpUrl.encodedPath());
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("scy_headers", jSONArray);
            jSONObject.put("remove_scy_header", z);
            jSONObject.put("downgrade", z2);
            if (redirectRequestControlConfig.mV2On.get()) {
                jSONObject.put("ctl_ver", "v2");
            }
            if (eventListener != null) {
                eventListener.callInSecureRedirect(call, jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean isInSecureRedirectBlackList(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = TTConfigManager.inst().getRedirectRequestControlConfig().mSecureRedirectBlackList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (str.equals(next)) {
                return true;
            }
            if (!next.startsWith(".")) {
                next = "." + next;
            }
            if (str.toLowerCase().endsWith(next.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private boolean isInSecureRedirectWhiteList(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = TTConfigManager.inst().getRedirectRequestControlConfig().mSecureRedirectWhiteList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (str.equals(next)) {
                return true;
            }
            if (!next.startsWith(".")) {
                next = "." + next;
            }
            if (str.toLowerCase().endsWith(next.toLowerCase())) {
                return true;
            }
        }
        TTConfigManager.inst();
        return TTConfigManager.inCookieHostList(str);
    }

    private void removeCookieHeader(Request.Builder builder) {
        builder.removeHeader(COOKIE_HEADER);
        builder.removeHeader(COOKIE2_HEADER);
        builder.removeHeader(X_SS_COOKIE_HEADER);
    }
}
