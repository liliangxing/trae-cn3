package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import coil3.disk.DiskLruCache;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall;
import com.bytedance.frameworks.baselib.network.http.parser.RequestTimeoutParser;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.frameworks.baselib.network.utils.ReflectWrap;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.AbsTypedOutput;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class BaseCronetSsCall extends BaseSsCall {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String BODY_CONTENT_ENCODING = "x-bd-content-encoding";
    private static final int CHUNK_SIZE = 4096;
    private static volatile boolean FIX_CANCEL_REQ_REPORT = false;
    private static final String HTTP_CONTENT_ENCODING = "content-encoding";
    private static final String INTERNET_DISCONNECTED = "net::ERR_INTERNET_DISCONNECTED";
    private static final String TAG = "BaseCronetSsCall";
    protected static volatile boolean TNC_USE_ZERO_COPY_READ = true;
    private static final String USER_DISABLE_BODY_COMPRESS = "x-metasec-bp-body-compress";
    protected static volatile boolean USER_USE_ZERO_COPY_READ = false;
    private static final String USE_TTNET_CONTENT_ENCODING = "x-metasec-content-encoding";
    protected volatile int responseCode;
    private volatile long throttleNetSpeed;

    abstract HttpURLConnection connection();

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public boolean fromCache() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public boolean isGzip() {
        return false;
    }

    void setConnection(HttpURLConnection httpURLConnection) {
    }

    public static void setTncUseZeroCopyRead(boolean z) {
        TNC_USE_ZERO_COPY_READ = z;
    }

    public static void setUseZeroCopyRead(boolean z) {
        USER_USE_ZERO_COPY_READ = z;
    }

    public static void enableFixCancelReqReport() {
        FIX_CANCEL_REQ_REPORT = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseCronetSsCall(Request request) {
        super(request);
        this.responseCode = 0;
        this.throttleNetSpeed = 0L;
        try {
            this.requestInfo.httpClientType = 0;
            this.requestInfo.extraInfo.put(BaseHttpRequestInfo.KEY_HTTP_CLIENT, SsCronetHttpClient.TAG);
            this.requestInfo.extraInfo.put(BaseHttpRequestInfo.KEY_HTTP_CLIENT_VERSION, SsCronetHttpClient.getCronetVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean setThrottleNetSpeed(long j) {
        this.throttleNetSpeed = j;
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public int responseCode() {
        return this.responseCode;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public long contentLength() {
        if (connection() != null) {
            return connection().getContentLength();
        }
        return 0L;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String contentType() {
        return responseHeaderValue("Content-Type");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public Map<String, List<String>> responseHeaders() {
        if (connection() != null) {
            return connection().getHeaderFields();
        }
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String responseHeaderValue(String str) {
        if (connection() == null) {
            return null;
        }
        String headerField = connection().getHeaderField(str);
        return TextUtils.isEmpty(headerField) ? connection().getHeaderField(str.toLowerCase()) : headerField;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public InputStream inputStream() throws IOException {
        if (connection() != null) {
            return connection().getInputStream();
        }
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public InputStream errorStream() {
        if (connection() != null) {
            return connection().getErrorStream();
        }
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String responseMessage() throws IOException {
        return connection() != null ? connection().getResponseMessage() : "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public void safeClose() {
        if (connection() != null) {
            connection().disconnect();
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected boolean bypassNetworkStatusCheck() {
        return this.bypassNetworkStatusCheck || SsCronetHttpClient.getGlobalBypassOfflineCheck();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected Context getContext() {
        return SsCronetHttpClient.getContext();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected void prepareNetworkRequest(String str, Request request, BaseHttpRequestInfo baseHttpRequestInfo, Map<String, String> map) throws IOException {
        try {
            try {
                baseHttpRequestInfo.metrics.prepareConnectionStart();
                baseHttpRequestInfo.customInputStreamSize = getCustomInputStreamBufferSize(request);
                baseHttpRequestInfo.useCronetInputStreamWithTTBuffer = TNC_USE_ZERO_COPY_READ && USER_USE_ZERO_COPY_READ && baseHttpRequestInfo.customInputStreamSize <= 0 && !request.isResponseStreaming() && request.getMaxLength() <= 0;
                if (Logger.debug()) {
                    Logger.e(TAG, "url is " + str + " useCronetInputStreamWithTTBuffer: " + baseHttpRequestInfo.useCronetInputStreamWithTTBuffer);
                }
                HttpURLConnection constructConnection = constructConnection(str, baseHttpRequestInfo);
                configureConnection(request, baseHttpRequestInfo, constructConnection, map);
                setConnection(constructConnection);
            } catch (Exception e) {
                throw TTNetExceptionStorage.wrapIfNeeded(e, str, baseHttpRequestInfo.traceCode, baseHttpRequestInfo);
            }
        } finally {
            baseHttpRequestInfo.metrics.prepareConnectionEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpURLConnection constructConnection(String str, BaseHttpRequestInfo baseHttpRequestInfo) throws IOException {
        long j = -1;
        try {
            j = baseHttpRequestInfo.metrics.constructConnectionStart();
            return SsCronetHttpClient.openConnection(str, baseHttpRequestInfo);
        } finally {
            baseHttpRequestInfo.metrics.constructConnectionEnd(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:113:0x066e A[Catch: all -> 0x060a, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x060a, blocks: (B:85:0x0622, B:88:0x0632, B:91:0x063d, B:93:0x0643, B:96:0x064e, B:98:0x0658, B:99:0x065c, B:113:0x066e, B:116:0x0678, B:117:0x0699, B:121:0x0696, B:124:0x069c, B:128:0x06b1, B:130:0x06c3, B:131:0x06c8, B:133:0x06d4, B:134:0x06e1, B:136:0x06eb, B:138:0x0703, B:140:0x0709, B:141:0x0711, B:143:0x0717, B:146:0x072f, B:149:0x0735, B:171:0x0774, B:172:0x06f9, B:173:0x06d8, B:175:0x06de, B:194:0x0606, B:185:0x05b8, B:188:0x05c1, B:191:0x05e8, B:162:0x073d, B:165:0x0745, B:168:0x0766), top: B:184:0x05b8, inners: #2, #8, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x06b0  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0717 A[Catch: all -> 0x060a, TryCatch #5 {all -> 0x060a, blocks: (B:85:0x0622, B:88:0x0632, B:91:0x063d, B:93:0x0643, B:96:0x064e, B:98:0x0658, B:99:0x065c, B:113:0x066e, B:116:0x0678, B:117:0x0699, B:121:0x0696, B:124:0x069c, B:128:0x06b1, B:130:0x06c3, B:131:0x06c8, B:133:0x06d4, B:134:0x06e1, B:136:0x06eb, B:138:0x0703, B:140:0x0709, B:141:0x0711, B:143:0x0717, B:146:0x072f, B:149:0x0735, B:171:0x0774, B:172:0x06f9, B:173:0x06d8, B:175:0x06de, B:194:0x0606, B:185:0x05b8, B:188:0x05c1, B:191:0x05e8, B:162:0x073d, B:165:0x0745, B:168:0x0766), top: B:184:0x05b8, inners: #2, #8, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x073d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x05b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0571 A[Catch: all -> 0x0591, TRY_LEAVE, TryCatch #10 {all -> 0x0591, blocks: (B:69:0x053d, B:72:0x0546, B:201:0x0571), top: B:68:0x053d, outer: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x02a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0365 A[Catch: all -> 0x03b2, TRY_ENTER, TryCatch #13 {all -> 0x03b2, blocks: (B:48:0x035c, B:51:0x0365, B:52:0x038f), top: B:47:0x035c, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x038f A[Catch: all -> 0x03b2, TRY_LEAVE, TryCatch #13 {all -> 0x03b2, blocks: (B:48:0x035c, B:51:0x0365, B:52:0x038f), top: B:47:0x035c, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0546 A[Catch: all -> 0x0591, TRY_ENTER, TryCatch #10 {all -> 0x0591, blocks: (B:69:0x053d, B:72:0x0546, B:201:0x0571), top: B:68:0x053d, outer: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0622 A[Catch: all -> 0x060a, TRY_ENTER, TryCatch #5 {all -> 0x060a, blocks: (B:85:0x0622, B:88:0x0632, B:91:0x063d, B:93:0x0643, B:96:0x064e, B:98:0x0658, B:99:0x065c, B:113:0x066e, B:116:0x0678, B:117:0x0699, B:121:0x0696, B:124:0x069c, B:128:0x06b1, B:130:0x06c3, B:131:0x06c8, B:133:0x06d4, B:134:0x06e1, B:136:0x06eb, B:138:0x0703, B:140:0x0709, B:141:0x0711, B:143:0x0717, B:146:0x072f, B:149:0x0735, B:171:0x0774, B:172:0x06f9, B:173:0x06d8, B:175:0x06de, B:194:0x0606, B:185:0x05b8, B:188:0x05c1, B:191:0x05e8, B:162:0x073d, B:165:0x0745, B:168:0x0766), top: B:184:0x05b8, inners: #2, #8, #12 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x03b4 -> B:62:0x03ba). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void configureConnection(Request request, BaseHttpRequestInfo baseHttpRequestInfo, HttpURLConnection httpURLConnection, Map<String, String> map) throws IOException {
        long j;
        Throwable th;
        long j2;
        int requestTimeout;
        int i;
        long j3;
        long j4;
        String str;
        TypedOutput body;
        int i2;
        int i3;
        int i4;
        BaseRequestContext.AuthCredentials authCredentials;
        long configureConnectionStart = baseHttpRequestInfo.metrics.configureConnectionStart();
        try {
            httpURLConnection.setRequestMethod(request.getMethod());
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(true);
            if (baseHttpRequestInfo.reqContext != 0) {
                try {
                    httpURLConnection.setInstanceFollowRedirects(baseHttpRequestInfo.reqContext.followRedirectInternal);
                } catch (Throwable th2) {
                    th = th2;
                    j = configureConnectionStart;
                    baseHttpRequestInfo.metrics.configureConnectionEnd(j);
                    throw th;
                }
            }
            int cronetOutputStreamBufferSize = SsCronetHttpClient.getCronetOutputStreamBufferSize(request.getPath(), baseHttpRequestInfo.reqContext == 0 ? 0 : baseHttpRequestInfo.reqContext.output_stream_buffer_size);
            if (cronetOutputStreamBufferSize > 0) {
                try {
                    if (NetworkParams.getOptReflection()) {
                        ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "setOutputStreamBufferSize", new Object[]{Integer.valueOf(cronetOutputStreamBufferSize)});
                    } else {
                        ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setOutputStreamBufferSize", new Class[]{Integer.TYPE}, Integer.valueOf(cronetOutputStreamBufferSize));
                    }
                    if (request.getMetrics() != null) {
                        request.getMetrics().postBodyBufferSize = cronetOutputStreamBufferSize;
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            if (baseHttpRequestInfo.metrics.isConcurrent) {
                baseHttpRequestInfo.customInputStreamSize = getCustomInputStreamBufferSize(request);
            }
            if (baseHttpRequestInfo.customInputStreamSize > 0) {
                try {
                    if (NetworkParams.getOptReflection()) {
                        ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "setInputStreamBufferSize", new Object[]{Integer.valueOf(baseHttpRequestInfo.customInputStreamSize)});
                    } else {
                        ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setInputStreamBufferSize", new Class[]{Integer.TYPE}, Integer.valueOf(baseHttpRequestInfo.customInputStreamSize));
                    }
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
            httpURLConnection.setConnectTimeout(NetworkParams.getConnectTimeout());
            httpURLConnection.setReadTimeout(NetworkParams.getIoTimeout());
            if (baseHttpRequestInfo.reqContext != 0) {
                T t = baseHttpRequestInfo.reqContext;
                if (t.timeout_connect > 0) {
                    httpURLConnection.setConnectTimeout((int) t.timeout_connect);
                }
                if (t.timeout_read > 0) {
                    httpURLConnection.setReadTimeout((int) t.timeout_read);
                }
                if (t.protect_timeout > 0) {
                    try {
                        try {
                            if (NetworkParams.getOptReflection()) {
                                ReflectWrap.ReflectAdapter m1297on = ReflectWrap.m1297on(httpURLConnection, request.getMetrics());
                                Class<?>[] clsArr = {String.class, Object[].class};
                                Object[] objArr = new Object[2];
                                objArr[0] = "setRequestTimeout";
                                Object[] objArr2 = new Object[1];
                                j2 = configureConnectionStart;
                                objArr2[0] = Integer.valueOf((int) t.protect_timeout);
                                objArr[1] = objArr2;
                                m1297on.call("configureConnection", clsArr, objArr);
                                i2 = 0;
                            } else {
                                j2 = configureConnectionStart;
                                i2 = 0;
                                ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setRequestTimeout", new Class[]{Integer.TYPE}, Integer.valueOf((int) t.protect_timeout));
                            }
                            httpURLConnection.setConnectTimeout(i2);
                            httpURLConnection.setReadTimeout(i2);
                            if (t.socket_connect_timeout > 0 || t.socket_read_timeout > 0 || t.socket_write_timeout > 0) {
                                if (NetworkParams.getOptReflection()) {
                                    ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "setSocketConnectTimeout", new Object[]{Integer.valueOf((int) t.socket_connect_timeout)});
                                    ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "setSocketReadTimeout", new Object[]{Integer.valueOf((int) t.socket_read_timeout)});
                                    ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "setSocketWriteTimeout", new Object[]{Integer.valueOf((int) t.socket_write_timeout)});
                                } else {
                                    ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setSocketConnectTimeout", new Class[]{Integer.TYPE}, Integer.valueOf((int) t.socket_connect_timeout));
                                    ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setSocketReadTimeout", new Class[]{Integer.TYPE}, Integer.valueOf((int) t.socket_read_timeout));
                                    ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setSocketWriteTimeout", new Class[]{Integer.TYPE}, Integer.valueOf((int) t.socket_write_timeout));
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                th.printStackTrace();
                                i3 = t.request_type_flags;
                                i4 = t.request_flag;
                                if (t.enable_http_cache) {
                                }
                                i4 |= 16;
                                if (t.byPassProxy) {
                                }
                                if (i4 > 0) {
                                }
                                if (t.isCustomizedCookie) {
                                }
                                if (i3 > 0) {
                                }
                                authCredentials = t.authCredentials;
                                if (authCredentials != null) {
                                    try {
                                        if (!NetworkParams.getOptReflection()) {
                                        }
                                    } catch (Throwable th6) {
                                        th6.printStackTrace();
                                    }
                                }
                                if (baseHttpRequestInfo.reqContext != 0) {
                                }
                                RequestTimeoutParser.SocketTimeoutParam socketTimeoutParam = new RequestTimeoutParser.SocketTimeoutParam();
                                requestTimeout = RequestTimeoutParser.getRequestTimeout(httpURLConnection.getURL(), socketTimeoutParam);
                                httpURLConnection.addRequestProperty("x-ttnet-bypass-to", Integer.toString(requestTimeout));
                                if (requestTimeout > 0) {
                                }
                                try {
                                    if (!NetworkParams.getOptReflection()) {
                                    }
                                } catch (Throwable th7) {
                                    th7.printStackTrace();
                                }
                                if (baseHttpRequestInfo.reqContext == 0) {
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                th = th;
                                j = j2;
                                baseHttpRequestInfo.metrics.configureConnectionEnd(j);
                                throw th;
                            }
                            try {
                                j3 = this.throttleNetSpeed;
                                j4 = 0;
                                if (j3 > j4) {
                                }
                                str = "";
                                while (r5.hasNext()) {
                                }
                                if (StringUtils.isEmpty(str)) {
                                }
                                baseHttpRequestInfo.extraInfo.put(BaseHttpRequestInfo.KEY_USER_AGENT, str);
                                body = request.getBody();
                                if (body == null) {
                                }
                                if (map != null) {
                                    while (r4.hasNext()) {
                                    }
                                }
                                if (FIX_CANCEL_REQ_REPORT) {
                                }
                                baseHttpRequestInfo.url = httpURLConnection.getURL();
                                baseHttpRequestInfo.metrics.url = baseHttpRequestInfo.url;
                                baseHttpRequestInfo.metrics.configureConnectionEnd(j2);
                            } catch (Throwable th9) {
                                th = th9;
                                j = j2;
                                th = th;
                                baseHttpRequestInfo.metrics.configureConnectionEnd(j);
                                throw th;
                            }
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        j2 = configureConnectionStart;
                    }
                } else {
                    j2 = configureConnectionStart;
                }
                i3 = t.request_type_flags;
                i4 = t.request_flag;
                if (t.enable_http_cache || (i3 & 1) <= 0) {
                    i4 |= 16;
                }
                if (t.byPassProxy) {
                    i4 |= 128;
                }
                if (i4 > 0) {
                    try {
                        if (NetworkParams.getOptReflection()) {
                            ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "setRequestFlag", new Object[]{Integer.valueOf(i4)});
                        } else {
                            ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setRequestFlag", new Class[]{Integer.TYPE}, Integer.valueOf(i4));
                        }
                    } catch (Throwable th11) {
                        th11.printStackTrace();
                    }
                }
                if (t.isCustomizedCookie) {
                    i3 |= 2;
                }
                if (i3 > 0) {
                    try {
                        if (NetworkParams.getOptReflection()) {
                            ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "setRequestTypeFlags", new Object[]{Integer.valueOf(i3)});
                        } else {
                            ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setRequestTypeFlags", new Class[]{Integer.TYPE}, Integer.valueOf(i3));
                        }
                    } catch (Throwable th12) {
                        th12.printStackTrace();
                    }
                }
                authCredentials = t.authCredentials;
                if (authCredentials != null && authCredentials.username != null && authCredentials.password != null) {
                    if (!NetworkParams.getOptReflection()) {
                        ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "setAuthCredentials", new Object[]{authCredentials.username, authCredentials.password});
                    } else {
                        ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setAuthCredentials", new Class[]{String.class, String.class}, authCredentials.username, authCredentials.password);
                    }
                }
            } else {
                j2 = configureConnectionStart;
            }
            try {
                if (baseHttpRequestInfo.reqContext != 0 || baseHttpRequestInfo.reqContext.protect_timeout <= 0) {
                    RequestTimeoutParser.SocketTimeoutParam socketTimeoutParam2 = new RequestTimeoutParser.SocketTimeoutParam();
                    requestTimeout = RequestTimeoutParser.getRequestTimeout(httpURLConnection.getURL(), socketTimeoutParam2);
                    httpURLConnection.addRequestProperty("x-ttnet-bypass-to", Integer.toString(requestTimeout));
                    if (requestTimeout > 0) {
                        try {
                            if (NetworkParams.getOptReflection()) {
                                ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "setRequestTimeout", new Object[]{Integer.valueOf(requestTimeout * 1000)});
                                i = 0;
                            } else {
                                i = 0;
                                ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setRequestTimeout", new Class[]{Integer.TYPE}, Integer.valueOf(requestTimeout * 1000));
                            }
                            httpURLConnection.setConnectTimeout(i);
                            httpURLConnection.setReadTimeout(i);
                            if (NetworkParams.getOptReflection()) {
                                if (socketTimeoutParam2.connectTimeout > 0) {
                                    ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "setSocketConnectTimeout", new Object[]{Integer.valueOf(socketTimeoutParam2.connectTimeout * 1000)});
                                }
                                if (socketTimeoutParam2.readTimeout > 0) {
                                    ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "setSocketReadTimeout", new Object[]{Integer.valueOf(socketTimeoutParam2.readTimeout * 1000)});
                                }
                                if (socketTimeoutParam2.writeTimeout > 0) {
                                    ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "setSocketWriteTimeout", new Object[]{Integer.valueOf(socketTimeoutParam2.writeTimeout * 1000)});
                                }
                            } else {
                                if (socketTimeoutParam2.connectTimeout > 0) {
                                    ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setSocketConnectTimeout", new Class[]{Integer.TYPE}, Integer.valueOf(socketTimeoutParam2.connectTimeout * 1000));
                                }
                                if (socketTimeoutParam2.readTimeout > 0) {
                                    ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setSocketReadTimeout", new Class[]{Integer.TYPE}, Integer.valueOf(socketTimeoutParam2.readTimeout * 1000));
                                }
                                if (socketTimeoutParam2.writeTimeout > 0) {
                                    ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setSocketWriteTimeout", new Class[]{Integer.TYPE}, Integer.valueOf(socketTimeoutParam2.writeTimeout * 1000));
                                }
                            }
                        } catch (Throwable th13) {
                            th13.printStackTrace();
                        }
                    }
                }
                if (!NetworkParams.getOptReflection()) {
                    ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "setRequestPriority", new Object[]{Integer.valueOf(request.getRequestPriorityLevel())});
                } else {
                    ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setRequestPriority", new Class[]{Integer.TYPE}, Integer.valueOf(request.getRequestPriorityLevel()));
                }
                if (baseHttpRequestInfo.reqContext == 0 && baseHttpRequestInfo.reqContext.throttle_net_speed > 0) {
                    j3 = baseHttpRequestInfo.reqContext.throttle_net_speed;
                    j4 = 0;
                } else {
                    j3 = this.throttleNetSpeed;
                    j4 = 0;
                }
                if (j3 > j4) {
                    try {
                        try {
                            if (NetworkParams.getOptReflection()) {
                                ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "setThrottleNetSpeed", new Object[]{Long.valueOf(j3)});
                            } else {
                                ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("setThrottleNetSpeed", new Class[]{Integer.TYPE}, Long.valueOf(j3));
                            }
                        } catch (Throwable th14) {
                            th14.printStackTrace();
                        }
                    } catch (Throwable th15) {
                        th = th15;
                        th = th;
                        j = j2;
                        baseHttpRequestInfo.metrics.configureConnectionEnd(j);
                        throw th;
                    }
                }
                str = "";
                for (Header header : request.getHeaders()) {
                    if (!StringUtils.isEmpty(header.getName()) && !StringUtils.isEmpty(header.getValue()) && (!TTRequestCompressManager.isBodyOptEnabled() || !BODY_CONTENT_ENCODING.equalsIgnoreCase(header.getName()))) {
                        if (UrlUtils.USER_AGENT.equalsIgnoreCase(header.getName())) {
                            str = header.getValue();
                        }
                        httpURLConnection.setRequestProperty(header.getName(), header.getValue());
                    }
                }
                if (StringUtils.isEmpty(str)) {
                    str = NetworkParams.getUserAgent();
                    if (!StringUtils.isEmpty(str)) {
                        try {
                            str = str + " cronet/" + SsCronetHttpClient.getCronetVersion();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        httpURLConnection.setRequestProperty(UrlUtils.USER_AGENT, str);
                    }
                }
                try {
                    baseHttpRequestInfo.extraInfo.put(BaseHttpRequestInfo.KEY_USER_AGENT, str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                body = request.getBody();
                if (body == null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestProperty("Content-Type", body.mimeType());
                    String requestBodyStub = getRequestBodyStub(body);
                    if (requestBodyStub != null) {
                        httpURLConnection.setRequestProperty("X-SS-STUB", requestBodyStub);
                    }
                    String tryCompressRequestBody = tryCompressRequestBody(body, request);
                    if (!TextUtils.isEmpty(tryCompressRequestBody)) {
                        httpURLConnection.setRequestProperty(BODY_CONTENT_ENCODING, tryCompressRequestBody);
                    } else if (TTRequestCompressManager.isBodyOptEnabled()) {
                        recordContentEncodingError(request);
                    }
                    long length = body.length();
                    if (length != -1) {
                        httpURLConnection.setFixedLengthStreamingMode((int) length);
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(length));
                    } else {
                        httpURLConnection.setChunkedStreamingMode(4096);
                    }
                }
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                            httpURLConnection.setRequestProperty(key, value);
                        }
                    }
                }
                if (FIX_CANCEL_REQ_REPORT) {
                    try {
                        if (NetworkParams.getOptReflection()) {
                            ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("configureConnection", new Class[]{String.class, Object[].class}, "enableFixCancelRequestReport", new Object[0]);
                        } else {
                            ReflectWrap.m1297on(httpURLConnection, request.getMetrics()).call("enableFixCancelRequestReport");
                        }
                    } catch (Throwable th16) {
                        th16.printStackTrace();
                    }
                }
                baseHttpRequestInfo.url = httpURLConnection.getURL();
                baseHttpRequestInfo.metrics.url = baseHttpRequestInfo.url;
                baseHttpRequestInfo.metrics.configureConnectionEnd(j2);
            } catch (Throwable th17) {
                th = th17;
            }
        } catch (Throwable th18) {
            th = th18;
            j = configureConnectionStart;
        }
    }

    private static String getRequestBodyStub(TypedOutput typedOutput) {
        if (!(typedOutput instanceof AbsTypedOutput)) {
            return typedOutput.md5Stub();
        }
        AbsTypedOutput absTypedOutput = (AbsTypedOutput) typedOutput;
        if (TextUtils.isEmpty(absTypedOutput.bodyCompressType())) {
            return typedOutput.md5Stub();
        }
        String bodyMd5Stub = absTypedOutput.getBodyMd5Stub();
        if (TextUtils.isEmpty(bodyMd5Stub)) {
            Logger.e(TAG, "Request compress body md5 shouldn't be null.");
        }
        return bodyMd5Stub;
    }

    private static void recordContentEncodingError(Request request) {
        Header firstHeader;
        JSONObject jSONObject;
        if (request.getMetrics() == null || (firstHeader = request.getFirstHeader(BODY_CONTENT_ENCODING)) == null || TextUtils.isEmpty(firstHeader.getValue()) || (jSONObject = request.getMetrics().requestCompressInfo) == null) {
            return;
        }
        try {
            jSONObject.put("encode", firstHeader.getValue());
            jSONObject.put("disableReason", TTRequestCompressManager.DisableCompress.REMOVE_ENCODING.getReason());
        } catch (JSONException unused) {
        }
    }

    private static void recordRequestCompressInfo(long j, long j2, int i, long j3, Request request, TTRequestCompressManager.CompressData compressData) {
        if (request.getMetrics() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("beforeSize", j);
            if (i != 0) {
                jSONObject.put("disableReason", i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (compressData == null) {
            request.getMetrics().requestCompressInfo = jSONObject;
            return;
        }
        try {
            if (!TextUtils.isEmpty(compressData.contentEncoding)) {
                jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, compressData.contentEncoding);
                jSONObject.put("afterSize", j2);
            }
            if (compressData.failedCode != 0) {
                jSONObject.put("disableReason", compressData.failedCode);
                if ((compressData.failedCode == TTRequestCompressManager.DisableCompress.GZIP_PREFIX_MISMATCH.getReason() || compressData.failedCode == TTRequestCompressManager.DisableCompress.ZSTD_PREFIX_MISMATCH.getReason()) && !TextUtils.isEmpty(compressData.failedPrefixData)) {
                    jSONObject.put("prefix", compressData.failedPrefixData);
                }
            }
            jSONObject.put(DowngradeInfo.FIELD_DURATION, System.currentTimeMillis() - j3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        request.getMetrics().requestCompressInfo = jSONObject;
    }

    private static String tryCompressRequestBody(TypedOutput typedOutput, Request request) {
        if (!(typedOutput instanceof AbsTypedOutput) || request == null) {
            return null;
        }
        AbsTypedOutput absTypedOutput = (AbsTypedOutput) typedOutput;
        if (!TextUtils.isEmpty(absTypedOutput.bodyCompressType())) {
            return absTypedOutput.bodyCompressType();
        }
        long length = typedOutput.length();
        if (!"POST".equalsIgnoreCase(request.getMethod())) {
            recordRequestCompressInfo(length, 0L, TTRequestCompressManager.DisableCompress.NON_POST_METHOD.getReason(), 0L, request, null);
            return null;
        }
        Header firstHeader = request.getFirstHeader(USER_DISABLE_BODY_COMPRESS);
        if (firstHeader != null && DiskLruCache.VERSION.equals(firstHeader.getValue())) {
            recordRequestCompressInfo(length, 0L, TTRequestCompressManager.DisableCompress.USER_DISABLE.getReason(), 0L, request, null);
            return null;
        }
        Header firstHeader2 = request.getFirstHeader(HTTP_CONTENT_ENCODING);
        if (firstHeader2 != null && !TextUtils.isEmpty(firstHeader2.getValue())) {
            recordRequestCompressInfo(length, 0L, TTRequestCompressManager.DisableCompress.BODY_ENCODED.getReason(), 0L, request, null);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (absTypedOutput.isBodyEncrypted() && TTRequestCompressManager.isBodyOptEnabled()) {
            recordRequestCompressInfo(length, 0L, TTRequestCompressManager.DisableCompress.BODY_ENCRYPTED.getReason(), currentTimeMillis, request, null);
            return null;
        }
        TTRequestCompressManager.CompressData compressRequestBody = absTypedOutput.compressRequestBody(request.getHost(), request.getPath(), shouldUseTTNetContentEncoding(request));
        if (compressRequestBody == null) {
            recordRequestCompressInfo(length, 0L, TTRequestCompressManager.DisableCompress.DATA_NULL.getReason(), currentTimeMillis, request, null);
            return null;
        }
        recordRequestCompressInfo(length, typedOutput.length(), 0, currentTimeMillis, request, compressRequestBody);
        return compressRequestBody.contentEncoding;
    }

    private static boolean shouldUseTTNetContentEncoding(Request request) {
        Header firstHeader = request.getFirstHeader(USE_TTNET_CONTENT_ENCODING);
        if (firstHeader == null) {
            return false;
        }
        return DiskLruCache.VERSION.equals(firstHeader.getValue());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected void executeNetworkRequest(RetrofitMetrics retrofitMetrics) throws IOException {
        long executeConnectionStart = retrofitMetrics.executeConnectionStart();
        try {
            this.responseCode = executeConnection(connection());
        } finally {
            retrofitMetrics.executeConnectionEnd(executeConnectionStart);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int executeConnection(HttpURLConnection httpURLConnection) throws IOException {
        TypedOutput body = this.retrofitRequest.getBody();
        if (body != null) {
            body.writeTo(httpURLConnection.getOutputStream());
        }
        return httpURLConnection.getResponseCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public void onResponseBodyProcessed(TypedInput typedInput) {
        if (typedInput == null || this.retrofitRequest.isResponseStreaming() || !(typedInput instanceof TypedByteArray)) {
            return;
        }
        this.requestInfo.metrics.postProcessBodyStart();
        try {
            StoreRegionManager.inst().updateStoreRegionForCronet(connection(), ((TypedByteArray) typedInput).getBytes(), new StoreRegionManager.StoreRegionCallback() { // from class: com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall$$ExternalSyntheticLambda0
                @Override // com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager.StoreRegionCallback
                public final void notifyStoreRegionUpdatedForCronet(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
                    BaseCronetSsCall.lambda$onResponseBodyProcessed$0(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
                }
            });
        } catch (Throwable unused) {
        }
        this.requestInfo.metrics.postProcessBodyEnd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onResponseBodyProcessed$0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        try {
            SsCronetHttpClient.notifyStoreRegionUpdated(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public void checkNetworkAvailableAfterRequest(Request request, Exception exc) throws NetworkNotAvailabeException {
        String message = exc.getMessage();
        if (SsCronetHttpClient.getGlobalBypassOfflineCheck() && !TextUtils.isEmpty(message) && message.contains(INTERNET_DISCONNECTED)) {
            new NetworkNotAvailabeException("network not available for " + this.retrofitRequest.getPath() + ", message:" + message).setInfo(false, true, this.retrofitRequest.getUrl(), "", this.requestInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancelInner(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null || this.canceled) {
            return;
        }
        httpURLConnection.disconnect();
        this.canceled = true;
        if (this.retrofitRequest.isResponseStreaming()) {
            StreamTrafficObservable.inst().onStreamTrafficChanged(this.retrofitRequest.getUrl(), this.requestInfo.sentByteCount, this.requestInfo.receivedByteCount, this.requestInfo.contentType, this.requestInfo.requestLog);
        }
    }

    private int getCustomInputStreamBufferSize(Request request) {
        return SsCronetHttpClient.getCronetInputstreamBuffSize(request.getPath(), this.requestInfo);
    }
}
