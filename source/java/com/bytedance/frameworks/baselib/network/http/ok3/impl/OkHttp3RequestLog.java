package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.scene.data.SceneDbContract;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingV2Monitor;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.frameworks.baselib.network.config.InsecureRequestControlConfig;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.Ipv6ConnectionManager;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch.TTMetaDispatchLog;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchActionInfo;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeInfo;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import okhttp3.CipherSuite;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class OkHttp3RequestLog {
    private static final int MAX_ABSDK_VERSION_LENGTH = 5;
    private Context context;
    private CipherSuite mCipherSuite;
    private BaseRequestContext mCtx;
    private Socket mFinalSocket;
    private TTMetaDispatchLog mMetaDispatchLog;
    private Headers mRequestHeaders;
    private Headers mResponseHeaders;
    private TlsVersion mTlsVersion;
    private BaseHttpRequestInfo requestInfo;
    private long mCallStart = -1;
    private long mDnsStart = -1;
    private long mDnsEnd = -1;
    private long mConnectStart = -1;
    private long mConnectEnd = -1;
    private long mSslStart = -1;
    private long mSslEnd = -1;
    private long mRequestHeadersStart = -1;
    private long mRequestHeadersEnd = -1;
    private long mRequestBodyStart = -1;
    private long mRequestBodyEnd = -1;
    private long mResponseHeadersStart = -1;
    private long mResponseHeadersEnd = -1;
    private long mResponseBodyStart = -1;
    private long mResponseBodyEnd = -1;
    private final AtomicLong mCallEnd = new AtomicLong(-1);
    private long mConnectionAcquired = -1;
    private long mDispatchTiming = -1;
    private final List<Pair<InetSocketAddress, Integer>> mConnectAttemptsList = new ArrayList();
    private Proxy.Type mProxyType = Proxy.Type.DIRECT;
    private HandshakeType mHandShakeType = HandshakeType.HANDSHAKE_UNKNOWN;
    private long mRequestBodyBytes = 0;
    private int mHttpCode = -1;
    private long mResponseBodyBytes = 0;
    private Protocol mProtocol = null;
    private String mFinalScheme = "";
    private boolean mIsFromCache = false;
    private boolean mIsFromNetwork = false;
    private String mRemoteIp = "";
    private String mContentType = "";
    private int mRedirectTimes = 0;
    private final List<RedirectInfo> mRedirectInfoList = new ArrayList();
    private LoadState mLoadState = LoadState.IDLE;
    private String mMethod = "";
    private int mNetError = -1;
    private Status mStatus = Status.UNKNOWN;
    private String mOriginUrl = "";
    private boolean mDispatched = false;
    private boolean mHostReplaceMaped = false;
    private final List<DispatchActionInfo> mDispatchActionChain = new ArrayList();
    private int mHostReplaceMapSize = 0;
    private String mDnsInfoJson = "";
    private final AtomicBoolean mBizCanceled = new AtomicBoolean(false);

    private static long validateAndSetDuration(long j, long j2) {
        if (j2 == -1 || j == -1) {
            return -1L;
        }
        return j - j2;
    }

    public void bizCancel() {
        this.mBizCanceled.set(true);
    }

    public OkHttp3RequestLog(BaseHttpRequestInfo baseHttpRequestInfo, Context context) {
        this.requestInfo = baseHttpRequestInfo;
        this.context = context;
    }

    private void onRequestFinished() {
        this.requestInfo.nativeRequestStartTime = -1L;
        this.requestInfo.metrics.setKernelDns(validateAndSetDuration(this.mDnsEnd, this.mDnsStart));
        this.requestInfo.metrics.setKernelTCPConnect(validateAndSetDuration(this.mSslStart, this.mConnectStart));
        this.requestInfo.metrics.setKernelTls(validateAndSetDuration(this.mSslEnd, this.mSslStart));
        this.requestInfo.metrics.setKernelSend(validateAndSetDuration(this.mRequestHeadersEnd, this.mRequestHeadersStart) + validateAndSetDuration(this.mRequestBodyEnd, this.mRequestBodyStart));
        this.requestInfo.metrics.setKernelPush(-1L);
        this.requestInfo.metrics.setKernelTTFB(-1L);
        this.requestInfo.metrics.setKernelReceiveBody(validateAndSetDuration(this.mResponseBodyEnd, this.mResponseBodyStart));
        this.requestInfo.metrics.setKernelTotal(validateAndSetDuration(this.mCallEnd.get(), this.mCallStart));
        this.requestInfo.metrics.setNetworkKernelRawRequestLog(constructRequestLog(this.context));
        this.requestInfo.remoteIp = this.mRemoteIp;
        this.requestInfo.isSocketReused = this.mConnectStart == -1 && this.mConnectionAcquired != -1;
        this.requestInfo.sentByteCount = this.mRequestBodyBytes;
        this.requestInfo.receivedByteCount = this.mResponseBodyBytes;
        this.requestInfo.responseBodyByteCount = this.mResponseBodyBytes;
        this.requestInfo.retryAttempts = -1L;
        Headers headers = this.mRequestHeaders;
        if (headers != null) {
            this.requestInfo.requestHeaders = formatJsonHeaders(headers);
            this.requestInfo.sentByteCount += this.mRequestHeaders.byteCount();
        }
        Headers headers2 = this.mResponseHeaders;
        if (headers2 != null) {
            this.requestInfo.responseHeaders = formatJsonHeaders(headers2);
            this.requestInfo.receivedByteCount += this.mResponseHeaders.byteCount();
        }
        this.requestInfo.contentType = this.mContentType;
        this.requestInfo.metrics.markNetworkKernelLogCollected();
    }

    private static String formatJsonHeaders(Headers headers) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : headers.toMultimap().entrySet()) {
                String str = (String) entry.getKey();
                List list = (List) entry.getValue();
                if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        jSONObject.put(str, (String) it.next());
                    }
                }
            }
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String constructRequestLog(Context context) {
        String str;
        boolean z;
        String str2;
        Object obj;
        long j;
        Set<String> inSecureCookies;
        Object tNCInfo;
        InetAddress inetAddress;
        Uri parse;
        Uri parse2;
        List<String> abSdkVersion;
        String[] split;
        String str3 = SSCookieHandler.COOKIE;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            String tncAbTest = URLDispatcher.inst().getTncAbTest();
            ArrayList<String> arrayList = new ArrayList();
            if (!TextUtils.isEmpty(tncAbTest) && (split = tncAbTest.split(",")) != null) {
                arrayList.addAll(Arrays.asList(split));
            }
            IOkHttpAppInfoProvider okHttpAppInfoProvider = SsOkHttp3Client.getOkHttpAppInfoProvider();
            if (okHttpAppInfoProvider != null && (abSdkVersion = okHttpAppInfoProvider.getAbSdkVersion()) != null) {
                if (abSdkVersion.size() > 5 && Logger.debug()) {
                    Logger.d("ok3log", "ab sdk version count must less than 5");
                }
                int i = 0;
                for (String str4 : abSdkVersion) {
                    i++;
                    if (i > 5) {
                        break;
                    }
                    arrayList.add(str4);
                }
            }
            JSONArray jSONArray = new JSONArray();
            for (String str5 : arrayList) {
                if (!TextUtils.isEmpty(str5)) {
                    jSONArray.put(str5);
                }
            }
            jSONObject2.put(BaseHttpRequestInfo.KEY_HIT, jSONArray);
            jSONObject.put(BaseHttpRequestInfo.KEY_ABTEST, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("load_state", this.mLoadState.ordinal());
            jSONObject3.put("method", this.mMethod);
            jSONObject3.put("is_pending", this.mStatus == Status.IO_PENDING);
            jSONObject3.put("status", this.mStatus);
            if (this.mStatus != Status.SUCCESS) {
                jSONObject3.put("net_error", this.mNetError);
            }
            if (!TextUtils.isEmpty(this.mOriginUrl) && (parse2 = Uri.parse(this.mOriginUrl)) != null && !TextUtils.isEmpty(parse2.getScheme()) && !TextUtils.isEmpty(parse2.getHost()) && parse2.getPath() != null) {
                jSONObject3.put("origin_url", parse2.getScheme() + "://" + parse2.getHost() + parse2.getPath());
            }
            jSONObject3.put("redirect_times", this.mRedirectTimes);
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = new JSONArray();
            Iterator<RedirectInfo> it = this.mRedirectInfoList.iterator();
            while (it.hasNext()) {
                RedirectInfo next = it.next();
                Iterator<RedirectInfo> it2 = it;
                JSONObject jSONObject4 = new JSONObject();
                String str6 = str3;
                jSONObject4.put("code", next.mCode);
                jSONObject4.put("method", next.mMethod);
                jSONObject4.put("internal", next.mInternal);
                if (next.mUrl != null && (parse = Uri.parse(next.mUrl)) != null && !TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getHost())) {
                    String str7 = parse.getScheme() + "://" + parse.getHost();
                    jSONArray3.put(str7);
                    if (parse.getPath() != null) {
                        str7 = str7 + parse.getPath();
                    }
                    jSONObject4.put(StreamTrafficObservable.STREAM_URL, str7);
                }
                jSONArray2.put(jSONObject4);
                it = it2;
                str3 = str6;
            }
            String str8 = str3;
            jSONObject3.put("redirect_info", jSONArray2);
            jSONObject3.put("redirecting_list", jSONArray3);
            jSONObject3.put("dispatched", this.mDispatched);
            jSONObject.put("base", jSONObject3);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("code", this.mHttpCode);
            jSONObject5.put("connection_info", transProtocolToEnum(this.mProtocol).mValue);
            Headers headers = this.mRequestHeaders;
            jSONObject5.put(StreamTrafficObservable.STREAM_SENTBYTES, this.mRequestBodyBytes + (headers != null ? headers.byteCount() : 0L));
            Headers headers2 = this.mResponseHeaders;
            jSONObject5.put(StreamTrafficObservable.STREAM_RECEIVEDBYTES, this.mResponseBodyBytes + (headers2 != null ? headers2.byteCount() : 0L));
            jSONObject5.put("cached", this.mIsFromCache);
            jSONObject5.put("network_accessed", this.mIsFromNetwork);
            jSONObject5.put("via_proxy", this.mProxyType != Proxy.Type.DIRECT);
            Headers headers3 = this.mResponseHeaders;
            if (headers3 != null) {
                List values = headers3.values("Set-Cookie");
                boolean z2 = !CollectionUtils.isEmpty(values);
                jSONObject5.put("set_cookie", z2);
                if (z2) {
                    jSONObject5.put("set_cookie_lines", values.size());
                    Iterator it3 = values.iterator();
                    long j2 = 0;
                    while (it3.hasNext()) {
                        if (((String) it3.next()) != null) {
                            j2 += r13.length();
                        }
                    }
                    jSONObject5.put("set_cookie_bytes", j2);
                }
            }
            jSONObject.put("response", jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            if (this.mResponseHeaders != null) {
                for (int i2 = 0; i2 < this.mResponseHeaders.size(); i2++) {
                    String name = this.mResponseHeaders.name(i2);
                    String value = this.mResponseHeaders.value(i2);
                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(value)) {
                        String lowerCase = name.toLowerCase();
                        if (lowerCase.startsWith("x-tt-") && !lowerCase.contains("sids") && !lowerCase.contains("session") && !lowerCase.contains("token") && !lowerCase.contains("uid") && !lowerCase.contains("sign")) {
                            jSONObject6.put(name, value);
                        }
                    }
                }
                String str9 = this.mResponseHeaders.get("tt-idc-switch");
                if (!TextUtils.isEmpty(str9)) {
                    jSONObject6.put("tt-idc-switch", str9);
                }
                str = this.mResponseHeaders.get("server-timing");
                if (!TextUtils.isEmpty(str)) {
                    jSONObject6.put("server-timing", str);
                }
                List<String> requestLogHeaderRmList = MiscConfigManager.inst().getRequestLogHeaderRmList();
                if (!CollectionUtils.isEmpty(requestLogHeaderRmList)) {
                    for (String str10 : requestLogHeaderRmList) {
                        if (!TextUtils.isEmpty(str10)) {
                            jSONObject6.remove(str10);
                        }
                    }
                }
                jSONObject.put(Constants.KEY_HEADER, jSONObject6);
            } else {
                str = "";
            }
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("libcore", "okhttp");
            jSONObject7.put("core_ver", SsOkHttp3Client.getOkVersion());
            jSONObject7.put("is_main_process", ProcessUtils.isMainProcessByProcessFlag(context));
            jSONObject7.put("ttnet_version", "4.2.243.6-doubao");
            jSONObject7.put("retry_attempts", -1);
            BaseRequestContext baseRequestContext = this.mCtx;
            if (baseRequestContext != null && baseRequestContext.okHttpRequestClientBuilderHook != null) {
                jSONObject7.put("hook", 1);
            }
            jSONObject.put("other", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("dns", validateAndSetDuration(this.mDnsEnd, this.mDnsStart));
            jSONObject9.put("tcp", validateAndSetDuration(this.mSslStart, this.mConnectStart));
            jSONObject9.put("ssl", validateAndSetDuration(this.mSslEnd, this.mSslStart));
            Object obj2 = "";
            jSONObject9.put("send", validateAndSetDuration(this.mRequestHeadersEnd, this.mRequestHeadersStart) + validateAndSetDuration(this.mRequestBodyEnd, this.mRequestBodyStart));
            long validateAndSetDuration = validateAndSetDuration(this.mResponseHeadersEnd, this.mRequestHeadersEnd);
            jSONObject9.put("ttfb", validateAndSetDuration);
            jSONObject9.put("header_recv", validateAndSetDuration(this.mResponseHeadersEnd, this.mResponseHeadersStart));
            jSONObject9.put("body_recv", validateAndSetDuration(this.mResponseBodyEnd, this.mResponseBodyStart));
            jSONObject9.put("dispatch", this.mDispatchTiming);
            getServerTimingInfo(str, jSONObject9, validateAndSetDuration);
            TTMetaDispatchLog tTMetaDispatchLog = this.mMetaDispatchLog;
            if (tTMetaDispatchLog != null && tTMetaDispatchLog.dispatchCostMs >= 0) {
                jSONObject9.put("meta_dp", this.mMetaDispatchLog.dispatchCostMs);
            }
            jSONObject8.put("detailed_duration", jSONObject9);
            JSONObject jSONObject10 = new JSONObject();
            jSONObject10.put(StrategyConstants.START_TIME, this.mCallStart);
            jSONObject10.put(DowngradeInfo.FIELD_DURATION, validateAndSetDuration(this.mCallEnd.get(), this.mCallStart));
            jSONObject10.put("request_sent_time", this.mRequestHeadersStart);
            jSONObject10.put("response_recv_time", this.mResponseHeadersStart);
            jSONObject8.put("request", jSONObject10);
            jSONObject.put("timing", jSONObject8);
            JSONObject jSONObject11 = new JSONObject();
            Socket socket = this.mFinalSocket;
            if (socket != null && (inetAddress = socket.getInetAddress()) != null) {
                AddressFamily addressFamily = AddressFamily.ADDRESS_FAMILY_UNSPECIFIED;
                if (inetAddress instanceof Inet4Address) {
                    addressFamily = AddressFamily.ADDRESS_FAMILY_IPV4;
                } else if (inetAddress instanceof Inet6Address) {
                    addressFamily = AddressFamily.ADDRESS_FAMILY_IPV6;
                }
                jSONObject11.put("address_family", addressFamily.ordinal());
                jSONObject11.put("socket_reused", this.mConnectStart == -1 && this.mConnectionAcquired != -1);
                if (inetAddress.getHostAddress() != null) {
                    jSONObject11.put("remote", inetAddress.getHostAddress());
                }
            }
            JSONArray jSONArray4 = new JSONArray();
            for (Pair<InetSocketAddress, Integer> pair : this.mConnectAttemptsList) {
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put("address", ((InetSocketAddress) pair.first).toString().substring(1));
                jSONObject12.put(StrategyConstants.RESULT, pair.second);
                jSONArray4.put(jSONObject12);
            }
            jSONObject11.put("connection_attempts", jSONArray4);
            jSONObject.put("socket", jSONObject11);
            JSONObject jSONObject13 = new JSONObject();
            jSONObject13.put("handshake_type", this.mHandShakeType.ordinal());
            jSONObject13.put("cipher_suite", this.mCipherSuite);
            jSONObject13.put("ssl_version", this.mTlsVersion);
            jSONObject.put("ssl", jSONObject13);
            JSONObject jSONObject14 = new JSONObject();
            JSONArray jSONArray5 = new JSONArray();
            String str11 = "host_replace_map";
            if (this.mHostReplaceMaped) {
                jSONObject14.put("host_replace_map", 1);
                jSONObject14.put("host_replace_map_size", this.mHostReplaceMapSize);
                z = false;
            } else {
                List<DispatchActionInfo> list = this.mDispatchActionChain;
                if (list != null) {
                    for (DispatchActionInfo dispatchActionInfo : list) {
                        JSONObject jSONObject15 = new JSONObject();
                        if (dispatchActionInfo.mActionHit) {
                            jSONObject15.put("priority", dispatchActionInfo.mPriority);
                            jSONObject15.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, dispatchActionInfo.mStrategyType);
                            jSONObject15.put("action_hit", dispatchActionInfo.mActionHit);
                            if (!TextUtils.isEmpty(dispatchActionInfo.mDispatchedUrl)) {
                                Uri parse3 = Uri.parse(dispatchActionInfo.mDispatchedUrl);
                                if (parse3.getHost() != null) {
                                    jSONObject15.put("replace_host", parse3.getHost());
                                }
                                obj = obj2;
                            } else {
                                obj = obj2;
                                jSONObject15.put("replace_host", obj);
                            }
                            jSONObject15.put("feedback", dispatchActionInfo.mNeedFeedBack);
                            if (dispatchActionInfo.mRuleid > 0) {
                                str2 = str11;
                                jSONObject15.put(StrategyConstants.RULE_ID, dispatchActionInfo.mRuleid);
                            } else {
                                str2 = str11;
                            }
                            if (!TextUtils.isEmpty(dispatchActionInfo.mServiceName)) {
                                jSONObject15.put("service_name", dispatchActionInfo.mServiceName);
                            }
                            jSONArray5.put(jSONObject15);
                        } else {
                            str2 = str11;
                            obj = obj2;
                        }
                        obj2 = obj;
                        str11 = str2;
                    }
                }
                jSONObject14.put("action_info", jSONArray5);
                jSONObject14.put("empty_action", URLDispatcher.inst().isDispatchActionsEmpty());
                z = false;
                jSONObject14.put(str11, 0);
            }
            jSONObject14.put("source", URLDispatcher.inst().getTncUpdateSource());
            jSONObject14.put("update_time", URLDispatcher.inst().getTncUpdateTime());
            jSONObject14.put("epoch", URLDispatcher.inst().getEpoch());
            jSONObject.put("url_dispatch", jSONObject14);
            if (!TextUtils.isEmpty(URLDispatcher.inst().getTncEtag())) {
                jSONObject.put("tt_tnc_etag", URLDispatcher.inst().getTncEtag());
            }
            if (this.mMetaDispatchLog != null) {
                JSONObject jSONObject16 = new JSONObject();
                if (this.mMetaDispatchLog.headerAdd != null && !this.mMetaDispatchLog.headerAdd.isEmpty()) {
                    jSONObject16.put("header_add", this.mMetaDispatchLog.headerAdd);
                }
                if (this.mMetaDispatchLog.headerRm != null && !this.mMetaDispatchLog.headerRm.isEmpty()) {
                    jSONObject16.put("header_rm", this.mMetaDispatchLog.headerRm);
                }
                if (this.mMetaDispatchLog.queryAdd != null && !this.mMetaDispatchLog.queryAdd.isEmpty()) {
                    jSONObject16.put("query_add", this.mMetaDispatchLog.queryAdd);
                }
                if (this.mMetaDispatchLog.queryRm != null && !this.mMetaDispatchLog.queryRm.isEmpty()) {
                    jSONObject16.put("query_rm", this.mMetaDispatchLog.queryRm);
                }
                if (jSONObject16.length() > 0) {
                    jSONObject.put("meta_dp", jSONObject16);
                }
            }
            if (!TextUtils.isEmpty(this.mDnsInfoJson)) {
                try {
                    jSONObject.put("dns", new JSONObject(this.mDnsInfoJson));
                } catch (JSONException unused) {
                }
            }
            JSONObject jSONObject17 = new JSONObject();
            BaseRequestContext baseRequestContext2 = this.mCtx;
            if (baseRequestContext2 != null) {
                if (baseRequestContext2.protect_timeout > 0) {
                    jSONObject17.put("protect", this.mCtx.protect_timeout);
                }
                if (this.mCtx.socket_connect_timeout > 0) {
                    jSONObject17.put("connect", this.mCtx.socket_connect_timeout);
                }
                if (this.mCtx.timeout_read > 0) {
                    jSONObject17.put(SettingV2Monitor.REPORT_TYPE_READ, this.mCtx.timeout_read);
                }
                j = 0;
                if (this.mCtx.timeout_write > 0) {
                    jSONObject17.put("write", this.mCtx.timeout_write);
                }
            } else {
                j = 0;
            }
            jSONObject.put("socket_timeout_param", jSONObject17);
            JSONObject jSONObject18 = new JSONObject();
            jSONObject18.put("ipv4_reachable", NetworkUtils.isNetworkAvailable(context));
            jSONObject18.put("ipv6_reachable", Ipv6ConnectionManager.getIpv6GloballyReachable().get());
            jSONObject.put("ifconfig", jSONObject18);
            if (SsOkHttp3Client.getOk3TncBridge() != null && (tNCInfo = SsOkHttp3Client.getOk3TncBridge().getTNCInfo()) != null) {
                jSONObject.put("tnc", tNCInfo);
            }
            if (StoreRegionManager.inst().getStoreIdcInfo() != null) {
                jSONObject.put("store_idc", StoreRegionManager.inst().getStoreIdcInfo());
            }
            if (this.mRequestHeaders != null) {
                JSONObject jSONObject19 = new JSONObject();
                List values2 = this.mRequestHeaders.values(str8);
                boolean z3 = !CollectionUtils.isEmpty(values2) ? true : z;
                jSONObject19.put(str8, z3);
                if (z3) {
                    Iterator it4 = values2.iterator();
                    long j3 = j;
                    while (it4.hasNext()) {
                        if (((String) it4.next()) != null) {
                            j3 += r5.length();
                        }
                    }
                    jSONObject19.put("add_cookie_bytes", j3);
                }
                String str12 = this.mRequestHeaders.get("x-tt-token");
                if (str12 != null && !str12.isEmpty()) {
                    jSONObject19.put("token_md5", ByteString.encodeUtf8(str12).md5().hex());
                }
                if ("http".equalsIgnoreCase(this.mFinalScheme)) {
                    if (values2 != null && !values2.isEmpty() && (inSecureCookies = InsecureRequestControlConfig.getInSecureCookies(values2)) != null) {
                        JSONArray jSONArray6 = new JSONArray();
                        Iterator<String> it5 = inSecureCookies.iterator();
                        while (it5.hasNext()) {
                            jSONArray6.put(it5.next());
                        }
                        jSONObject19.put("insecure_cookies", jSONArray6);
                    }
                    Set<String> insecureHeaders = InsecureRequestControlConfig.getInsecureHeaders(this.mRequestHeaders);
                    if (insecureHeaders != null) {
                        JSONArray jSONArray7 = new JSONArray();
                        Iterator<String> it6 = insecureHeaders.iterator();
                        while (it6.hasNext()) {
                            jSONArray7.put(it6.next());
                        }
                        jSONObject19.put("insecure_headers", jSONArray7);
                    }
                }
                jSONObject.put("session", jSONObject19);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private void getServerTimingInfo(String str, JSONObject jSONObject, long j) throws JSONException {
        String[] split;
        HashMap hashMap = new HashMap();
        ServerTimingInfo serverTimingInfo = new ServerTimingInfo();
        if (!TextUtils.isEmpty(str) && (split = str.split(",")) != null) {
            for (String str2 : split) {
                String[] split2 = str2.split(";");
                if (split2 != null && split2.length == 2 && !TextUtils.isEmpty(split2[0]) && !TextUtils.isEmpty(split2[1])) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            String trim = ((String) entry.getKey()).trim();
            String trim2 = ((String) entry.getValue()).trim();
            if (trim.equalsIgnoreCase("cdn-cache")) {
                serverTimingInfo.mPassedCdn = true;
                String[] split3 = trim2.split("=");
                if (split3.length == 2 && split3[1].equalsIgnoreCase(BaseHttpRequestInfo.KEY_HIT)) {
                    serverTimingInfo.mCdnHitCache = true;
                } else {
                    serverTimingInfo.mCdnHitCache = false;
                }
            } else if (trim.equalsIgnoreCase("edge")) {
                serverTimingInfo.mEdge = validateAndGetServerTiming(trim2);
            } else if (trim.equalsIgnoreCase(SceneDbContract.Scenes.COLUMN_ORIGIN)) {
                serverTimingInfo.mOrigin = validateAndGetServerTiming(trim2);
            } else if (trim.equalsIgnoreCase("inner")) {
                serverTimingInfo.mInner = validateAndGetServerTiming(trim2);
            } else if (!TextUtils.isEmpty(trim)) {
                jSONObject.put(trim, validateAndGetServerTiming(trim2));
            }
        }
        if (serverTimingInfo.mPassedCdn && serverTimingInfo.mCdnHitCache) {
            jSONObject.put("edge", serverTimingInfo.mEdge);
            jSONObject.put("cdn-cache", BaseHttpRequestInfo.KEY_HIT);
            if (j != -1 && j > serverTimingInfo.mEdge) {
                serverTimingInfo.mRtt = j - serverTimingInfo.mEdge;
            }
            jSONObject.put("rtt", serverTimingInfo.mRtt);
            return;
        }
        if (serverTimingInfo.mPassedCdn) {
            jSONObject.put("edge", serverTimingInfo.mEdge);
            jSONObject.put("cdn-cache", "miss");
            if (serverTimingInfo.mOrigin > serverTimingInfo.mInner) {
                jSONObject.put(SceneDbContract.Scenes.COLUMN_ORIGIN, serverTimingInfo.mOrigin - serverTimingInfo.mInner);
            } else {
                jSONObject.put(SceneDbContract.Scenes.COLUMN_ORIGIN, -1);
            }
            jSONObject.put("inner", serverTimingInfo.mInner);
            if (j != -1 && j > serverTimingInfo.mOrigin + serverTimingInfo.mEdge) {
                serverTimingInfo.mRtt = (j - serverTimingInfo.mOrigin) - serverTimingInfo.mEdge;
            }
            jSONObject.put("rtt", serverTimingInfo.mRtt);
            return;
        }
        jSONObject.put("inner", serverTimingInfo.mInner);
        if (j != -1 && j > serverTimingInfo.mInner) {
            serverTimingInfo.mRtt = j - serverTimingInfo.mInner;
        }
        jSONObject.put("rtt", serverTimingInfo.mRtt);
    }

    public void setRequestTimeout(BaseRequestContext baseRequestContext) {
        this.mCtx = baseRequestContext;
    }

    private static long validateAndGetServerTiming(String str) {
        String[] split = str.split("=");
        if (split.length != 2) {
            return -1L;
        }
        try {
            long parseLong = Long.parseLong(split[1]);
            if (parseLong < 0) {
                return -1L;
            }
            return parseLong;
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    private static ConnectionInfo transProtocolToEnum(Protocol protocol) {
        if (protocol == null) {
            return ConnectionInfo.CONNECTION_INFO_UNKNOWN;
        }
        int i = C09201.$SwitchMap$okhttp3$Protocol[protocol.ordinal()];
        if (i == 1) {
            return ConnectionInfo.CONNECTION_INFO_HTTP1_0;
        }
        if (i == 2) {
            return ConnectionInfo.CONNECTION_INFO_HTTP1_1;
        }
        if (i == 3) {
            return ConnectionInfo.CONNECTION_INFO_HTTP2;
        }
        if (i == 4) {
            return ConnectionInfo.CONNECTION_INFO_DEPRECATED_SPDY3;
        }
        if (i == 5) {
            return ConnectionInfo.CONNECTION_INFO_QUIC_UNKNOWN_VERSION;
        }
        return ConnectionInfo.CONNECTION_INFO_UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3RequestLog$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C09201 {
        static final /* synthetic */ int[] $SwitchMap$okhttp3$Protocol;

        static {
            int[] iArr = new int[Protocol.values().length];
            $SwitchMap$okhttp3$Protocol = iArr;
            try {
                iArr[Protocol.HTTP_1_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$okhttp3$Protocol[Protocol.HTTP_1_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$okhttp3$Protocol[Protocol.HTTP_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$okhttp3$Protocol[Protocol.SPDY_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$okhttp3$Protocol[Protocol.QUIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void callStart() {
        this.mCallStart = System.currentTimeMillis();
        this.mStatus = Status.IO_PENDING;
    }

    public void dnsStart() {
        this.mDnsStart = System.currentTimeMillis();
        this.mLoadState = LoadState.RESOLVING_HOST;
    }

    public void dnsEnd() {
        this.mDnsEnd = System.currentTimeMillis();
    }

    public void dnsEnd(String str) {
        this.mDnsEnd = System.currentTimeMillis();
        this.mDnsInfoJson = str;
    }

    public void connectStart() {
        this.mConnectStart = System.currentTimeMillis();
        this.mLoadState = LoadState.CONNECTING;
    }

    public void secureConnectStart() {
        this.mSslStart = System.currentTimeMillis();
        this.mLoadState = LoadState.SSL_HANDSHAKE;
    }

    public void secureConnectEnd() {
        this.mSslEnd = System.currentTimeMillis();
    }

    public void connectEnd(Proxy proxy) {
        this.mConnectEnd = System.currentTimeMillis();
        if (proxy != null) {
            this.mProxyType = proxy.type();
        }
    }

    public void connectFailed(InetSocketAddress inetSocketAddress, IOException iOException, String str) {
        this.mConnectEnd = System.currentTimeMillis();
        if (inetSocketAddress != null && this.mCallEnd.get() == -1) {
            this.mConnectAttemptsList.add(new Pair<>(inetSocketAddress, Integer.valueOf(convertExceptionToErrorCode(iOException))));
        }
        if (!TextUtils.isEmpty(this.mDnsInfoJson) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mDnsInfoJson = str;
    }

    public void connectionAcquired(Connection connection) {
        if (connection != null && this.mCallEnd.get() == -1) {
            if (connection.socket() != null && connection.socket().getInetAddress() != null && connection.socket().getInetAddress().getHostAddress() != null) {
                this.mRemoteIp = connection.socket().getInetAddress().getHostAddress();
            }
            this.mFinalSocket = connection.socket();
        }
        this.mConnectionAcquired = System.currentTimeMillis();
    }

    public void requestHeadersStart() {
        this.mLoadState = LoadState.SENDING_REQUEST;
        this.mRequestHeadersStart = System.currentTimeMillis();
    }

    public void requestHeadersEnd(Request request) {
        this.mRequestHeadersEnd = System.currentTimeMillis();
        if (request != null && this.mCallEnd.get() == -1) {
            this.mRequestHeaders = request.headers();
            if (request.url() != null) {
                this.mFinalScheme = request.url().scheme();
            }
        }
        this.mLoadState = LoadState.WAITING_FOR_RESPONSE;
    }

    public void requestBodyStart() {
        this.mRequestBodyStart = System.currentTimeMillis();
    }

    public void requestBodyEnd(long j) {
        this.mRequestBodyEnd = System.currentTimeMillis();
        this.mRequestBodyBytes = j;
    }

    public void responseHeadersStart() {
        this.mResponseHeadersStart = System.currentTimeMillis();
    }

    public void responseHeadersEnd(Response response) {
        this.mResponseHeadersEnd = System.currentTimeMillis();
        if (this.mSslEnd != -1) {
            this.mHandShakeType = HandshakeType.HANDSHAKE_FULL;
        } else {
            this.mHandShakeType = HandshakeType.HANDSHAKE_RESUME;
        }
        if (response == null || this.mCallEnd.get() != -1) {
            return;
        }
        this.mHttpCode = response.code();
        this.mProtocol = response.protocol();
        if (response.handshake() != null) {
            this.mTlsVersion = response.handshake().tlsVersion();
            this.mCipherSuite = response.handshake().cipherSuite();
        }
        if (response.isRedirect()) {
            this.mRedirectTimes++;
            RedirectInfo redirectInfo = new RedirectInfo();
            redirectInfo.mCode = response.code();
            redirectInfo.mMethod = response.request().method();
            String header = response.header("location");
            if (!TextUtils.isEmpty(header)) {
                try {
                    HttpUrl resolve = response.request().url().resolve(header);
                    if (resolve != null && !TextUtils.isEmpty(resolve.host())) {
                        redirectInfo.mUrl = resolve.toString();
                    }
                } catch (Throwable unused) {
                }
                if (TextUtils.isEmpty(redirectInfo.mUrl)) {
                    redirectInfo.mUrl = header;
                }
            }
            this.mRedirectInfoList.add(redirectInfo);
        }
        if (response.isSuccessful()) {
            String header2 = response.header("content-type");
            if (!TextUtils.isEmpty(header2)) {
                this.mContentType = header2;
            }
        }
        this.mResponseHeaders = response.headers();
    }

    public void responseBodyStart() {
        this.mLoadState = LoadState.READING_RESPONSE;
        this.mResponseBodyStart = System.currentTimeMillis();
    }

    public void responseBodyEnd(long j) {
        this.mResponseBodyEnd = System.currentTimeMillis();
        this.mResponseBodyBytes = j;
    }

    public void callFailed(IOException iOException) {
        if (this.mCallEnd.compareAndSet(-1L, System.currentTimeMillis())) {
            if (this.mBizCanceled.get()) {
                iOException = new IOException("Biz Canceled");
            }
            this.mLoadState = LoadState.IDLE;
            if (iOException != null && !TextUtils.isEmpty(iOException.getMessage()) && iOException.getMessage().contains("Canceled")) {
                this.mStatus = Status.CANCELED;
            } else {
                this.mStatus = Status.FAILED;
            }
            this.mNetError = convertExceptionToErrorCode(iOException);
            onRequestFinished();
        }
    }

    public void callEnd() {
        if (this.mCallEnd.compareAndSet(-1L, System.currentTimeMillis())) {
            this.mLoadState = LoadState.IDLE;
            this.mStatus = Status.SUCCESS;
            onRequestFinished();
        }
    }

    public void setResponseSource(Response response) {
        this.mIsFromCache = response.cacheResponse() != null;
        this.mIsFromNetwork = response.networkResponse() != null;
    }

    public void recordDispatchLog(String str, String str2, long j, boolean z, List<DispatchActionInfo> list) {
        RedirectInfo redirectInfo = new RedirectInfo();
        redirectInfo.mCode = HttpStatus.SC_TEMPORARY_REDIRECT;
        redirectInfo.mInternal = true;
        redirectInfo.mMethod = str;
        redirectInfo.mUrl = str2;
        this.mRedirectInfoList.add(redirectInfo);
        this.mRedirectTimes++;
        this.mDispatchTiming = j;
        this.mDispatched = true;
        if (z) {
            this.mHostReplaceMaped = true;
            this.mHostReplaceMapSize = URLDispatcher.inst().getHostReplaceMap().size();
        } else {
            this.mDispatchActionChain.addAll(list);
            this.mHostReplaceMaped = false;
        }
    }

    public void recordDispatchActionInfo(String str, DispatchActionInfo dispatchActionInfo, boolean z) {
        if (z) {
            RedirectInfo redirectInfo = new RedirectInfo();
            redirectInfo.mCode = HttpStatus.SC_TEMPORARY_REDIRECT;
            redirectInfo.mInternal = true;
            redirectInfo.mMethod = str;
            redirectInfo.mUrl = dispatchActionInfo.mDispatchedUrl;
            this.mRedirectInfoList.add(redirectInfo);
            this.mRedirectTimes++;
        }
        this.mDispatchActionChain.add(dispatchActionInfo);
    }

    public void recordMetaDispatchLog(TTMetaDispatchLog tTMetaDispatchLog) {
        this.mMetaDispatchLog = tTMetaDispatchLog;
    }

    public void setNetError(int i) {
        this.mNetError = i;
    }

    public void setOriginUrl(String str, String str2) {
        this.mOriginUrl = str;
        this.mMethod = str2;
    }

    public static boolean isRequestTimeout(IOException iOException) {
        Throwable cause;
        if (iOException == null) {
            return false;
        }
        if ("Canceled#Reason=-192".equals(iOException.getMessage())) {
            return true;
        }
        return (iOException instanceof InterruptedIOException) && (cause = iOException.getCause()) != null && !TextUtils.isEmpty(cause.getMessage()) && "Canceled#Reason=-192".equals(cause.getMessage());
    }

    public static int convertExceptionToErrorCode(IOException iOException) {
        if (iOException instanceof SSLHandshakeException) {
            return -148;
        }
        if (iOException instanceof SSLKeyException) {
            return -149;
        }
        if (iOException instanceof SSLProtocolException) {
            return -107;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -153;
        }
        if (iOException instanceof UnknownHostException) {
            return -105;
        }
        if (iOException instanceof ConnectException) {
            return convertConnectException(iOException, -104);
        }
        if (iOException instanceof PortUnreachableException) {
            return -108;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -109;
        }
        if (iOException instanceof BindException) {
            return -147;
        }
        if (iOException instanceof SocketException) {
            return convertConnectException(iOException, -15);
        }
        if (iOException instanceof MalformedURLException) {
            return -300;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -118;
        }
        if (iOException instanceof ProtocolException) {
            return -901;
        }
        if (!(iOException instanceof HttpRetryException)) {
            return iOException instanceof UnknownServiceException ? -902 : -1;
        }
        String message = iOException.getMessage();
        return (TextUtils.isEmpty(message) || !message.contains("Too many follow-up requests")) ? -196 : -310;
    }

    private static int convertConnectException(IOException iOException, int i) {
        if (iOException == null) {
            return i;
        }
        try {
            int convertConnectionExceptionInternal = convertConnectionExceptionInternal(iOException.getMessage(), i);
            if (convertConnectionExceptionInternal != i) {
                return convertConnectionExceptionInternal;
            }
            try {
                Throwable cause = iOException.getCause();
                if (cause == null) {
                    return convertConnectionExceptionInternal;
                }
                String message = cause.getMessage();
                return TextUtils.isEmpty(message) ? convertConnectionExceptionInternal : convertConnectionExceptionInternal(message, i);
            } catch (Throwable unused) {
                i = convertConnectionExceptionInternal;
                return i;
            }
        } catch (Throwable unused2) {
        }
    }

    private static int convertConnectionExceptionInternal(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        if (str.contains("ECONNRESET") || str.contains("Connection reset") || str.contains("reset by peer")) {
            return -101;
        }
        if (str.contains("ECONNREFUSED")) {
            return -102;
        }
        if (str.contains("CONNECTION_ABORTED") || str.contains("connection abort")) {
            return -103;
        }
        if (str.contains("ENETDOWN") || str.contains("Network is unreachable")) {
            return -106;
        }
        if (str.contains("EHOSTUNREACH") || str.contains("ENETUNREACH")) {
            return -109;
        }
        if (str.contains("EADDRNOTAVAIL")) {
            return -108;
        }
        if (str.contains("EADDRINUSE")) {
            return -147;
        }
        return i;
    }
}
