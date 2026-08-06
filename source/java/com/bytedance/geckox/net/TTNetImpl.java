package com.bytedance.geckox.net;

import android.net.Uri;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpEventListener;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.iesgurd.core.ResCdnCode;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: TTNetImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJF\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ.\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eJ(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00072\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/geckox/net/TTNetImpl;", "", "()V", "GET", "", "POST", "downloadFile", "Lcom/bytedance/geckox/net/NetResponse;", "url", "", "execute", "method", ReportConst.ValidationReport.BODY, "headers", "", "timeout", "", "get", "post", "reportCdnStats", "", ApmTrafficStats.TTNET_RESPONSE, "info", "Lcom/bytedance/frameworks/baselib/network/http/BaseHttpRequestInfo;", "NetApi", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TTNetImpl {
    private static final int GET = 0;
    public static final TTNetImpl INSTANCE = new TTNetImpl();
    private static final int POST = 1;

    private TTNetImpl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TTNetImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\bb\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00012\b\b\u0003\u0010\b\u001a\u00020\tH'JL\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00012\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0003\u0010\b\u001a\u00020\tH'¨\u0006\u000f"}, d2 = {"Lcom/bytedance/geckox/net/TTNetImpl$NetApi;", "", "doGet", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "url", "", "extraInfo", "addCommonParam", "", "doPost", ReportConst.ValidationReport.BODY, "Lcom/bytedance/retrofit2/mime/TypedOutput;", "headerMap", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface NetApi {
        @GET
        Call<TypedInput> doGet(@Url String url, @ExtraInfo Object extraInfo, @AddCommonParam boolean addCommonParam);

        @POST
        Call<String> doPost(@Url String url, @ExtraInfo Object extraInfo, @Body TypedOutput body, @HeaderMap Map<String, String> headerMap, @AddCommonParam boolean addCommonParam);

        /* compiled from: TTNetImpl.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ Call doGet$default(NetApi netApi, String str, Object obj, boolean z, int i, Object obj2) {
                if (obj2 != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doGet");
                }
                if ((i & 4) != 0) {
                    z = false;
                }
                return netApi.doGet(str, obj, z);
            }

            public static /* synthetic */ Call doPost$default(NetApi netApi, String str, Object obj, TypedOutput typedOutput, Map map, boolean z, int i, Object obj2) {
                if (obj2 != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doPost");
                }
                if ((i & 16) != 0) {
                    z = false;
                }
                return netApi.doPost(str, obj, typedOutput, map, z);
            }
        }
    }

    public final NetResponse get(String url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        return execute$default(this, 0, url, null, null, 0L, 28, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NetResponse post$default(TTNetImpl tTNetImpl, String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        return tTNetImpl.post(str, str2, map);
    }

    public final NetResponse post(String url, String body, Map<String, String> headers) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(body, ReportConst.ValidationReport.BODY);
        return execute(1, url, body, headers, 30L);
    }

    public final NetResponse downloadFile(String url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        return execute$default(this, 0, url, null, null, 60L, 12, null);
    }

    static /* synthetic */ NetResponse execute$default(TTNetImpl tTNetImpl, int i, String str, String str2, Map map, long j, int i2, Object obj) {
        String str3;
        Map map2;
        if ((i2 & 4) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i2 & 8) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
        return tTNetImpl.execute(i, str, str3, map2, (i2 & 16) != 0 ? 20L : j);
    }

    private final NetResponse execute(int method, String url, String body, Map<String, String> headers, long timeout) {
        Call doGet$default;
        Object obj;
        Object extraInfo;
        try {
            RequestContext requestContext = new RequestContext();
            requestContext.protect_timeout = timeout * 1000;
            NetApi netApi = (NetApi) RetrofitUtils.createSsService(url, NetApi.class);
            if (method == 0) {
                doGet$default = NetApi.DefaultImpls.doGet$default(netApi, url, requestContext, false, 4, null);
            } else {
                if (method != 1) {
                    throw new IllegalArgumentException("method not support");
                }
                if (body == null) {
                    throw new IllegalArgumentException("body is null");
                }
                Charset forName = Charset.forName(UrlUtils.UTF_8);
                Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(\"UTF-8\")");
                byte[] bytes = body.getBytes(forName);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                TypedOutput typedByteArray = new TypedByteArray("application/json", bytes, new String[0]);
                if (headers == null) {
                    headers = MapsKt.emptyMap();
                }
                doGet$default = NetApi.DefaultImpls.doPost$default(netApi, url, requestContext, typedByteArray, headers, false, 16, null);
            }
            com.bytedance.retrofit2.client.Response raw = doGet$default.execute().raw();
            Intrinsics.checkExpressionValueIsNotNull(raw, "res");
            NetResponse netResponse = new NetResponse(raw.getStatus(), raw.getReason(), raw);
            if (raw.getStatus() != 200) {
                try {
                    Result.Companion companion = Result.Companion;
                    extraInfo = raw.getExtraInfo();
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (extraInfo == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo<*>");
                }
                obj = Result.constructor-impl((BaseHttpRequestInfo) extraInfo);
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                reportCdnStats(url, netResponse, (BaseHttpRequestInfo) obj);
            }
            return netResponse;
        } catch (CronetIOException e) {
            NetResponse netResponse2 = new NetResponse(e.getStatusCode(), "CronetIOException: " + e.getMessage(), null);
            reportCdnStats(url, netResponse2, e.getRequestInfo());
            return netResponse2;
        } catch (HttpResponseException e2) {
            NetResponse netResponse3 = new NetResponse(e2.getStatusCode(), "HttpResponseException: " + e2.getMessage(), null);
            reportCdnStats$default(this, url, netResponse3, null, 4, null);
            return netResponse3;
        } catch (Throwable th2) {
            NetResponse netResponse4 = new NetResponse(ResCdnCode.CDN_UNKNOWN_ERROR.getType(), "unknownException: " + th2.getMessage(), null);
            reportCdnStats$default(this, url, netResponse4, null, 4, null);
            return netResponse4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void reportCdnStats$default(TTNetImpl tTNetImpl, String str, NetResponse netResponse, BaseHttpRequestInfo baseHttpRequestInfo, int i, Object obj) {
        if ((i & 4) != 0) {
            baseHttpRequestInfo = null;
        }
        tTNetImpl.reportCdnStats(str, netResponse, baseHttpRequestInfo);
    }

    private final void reportCdnStats(String url, NetResponse response, BaseHttpRequestInfo<?> info) {
        JSONObject jSONObject = new JSONObject();
        Uri parse = Uri.parse(url);
        jSONObject.put("url", url);
        Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
        jSONObject.put("cdn_domain", parse.getHost());
        jSONObject.put("cdn_path", parse.getPath());
        jSONObject.put("http_status", response.getCode());
        jSONObject.put("error_message", response.getMessage());
        if (info == null) {
            UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_cdn_stats", jSONObject);
            return;
        }
        jSONObject.put("server_ip", info.remoteIp);
        String str = info.requestLog;
        if (!(str == null || str.length() == 0)) {
            jSONObject.put(ApmTrafficStats.TTNET_REQUEST_LOG, info.requestLog);
            jSONObject.put("error_code", new JSONObject(info.requestLog).optLong("net_error"));
        }
        String str2 = info.responseHeaders;
        String str3 = str2;
        if (!(str3 == null || str3.length() == 0)) {
            JSONObject jSONObject2 = new JSONObject(str2);
            Object opt = jSONObject2.opt(OkHttpEventListener.X_TT_TRACE_TAG);
            if (opt != null) {
                jSONObject.put("x_tt_trace_tag", opt);
            }
            Object opt2 = jSONObject2.opt("x-response-cache");
            if (opt2 != null) {
                jSONObject.put("x_response_cache", opt2);
            }
        }
        if (info.httpClientType == 0) {
            jSONObject.put("timing_dns", info.dnsTime);
            jSONObject.put("timing_connect", info.connectTime);
            jSONObject.put("timing_send", info.sendTime);
            jSONObject.put("timing_ssl", info.sslTime);
            jSONObject.put("timing_wait", info.ttfbMs);
            jSONObject.put("timing_receive", info.receiveTime);
            jSONObject.put("timing_total", info.totalTime);
            jSONObject.put("download_duration", info.totalTime - info.sendTime);
            String valueOf = String.valueOf(info.isSocketReused);
            if (valueOf.length() > 0) {
                jSONObject.put("timing_isSocketReused", valueOf);
            }
        }
        UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_cdn_stats", jSONObject);
    }
}
