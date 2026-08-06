package com.bytedance.apm.ttnet;

import android.text.TextUtils;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.applog.et_verify.BuildConfig;
import com.bytedance.bmf_mods_lite_api.packageHandler.PackageEnum;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.ttnet.http.HttpRequestInfo;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TTNetUtils {
    public static final String TAG = "TTNetUtils";
    private static Map<String, Map<String, Integer>> errorMap = new HashMap();

    private static void buildError() {
        if (errorMap.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put(" Bad Request", 101);
            hashMap.put(" Connection timed out", 102);
            hashMap.put(" Forbidden", 103);
            hashMap.put(" Gateway Time-out", 104);
            hashMap.put(" Internal Server Error", 105);
            hashMap.put(" Not Found", 106);
            hashMap.put(" Request Time-out", 107);
            hashMap.put(" Request-URI Too Large", 108);
            errorMap.put("HttpResponseException", hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("ERR_ABORTED", 301);
            hashMap2.put("ERR_ADDRESS_UNREACHABLE", Integer.valueOf(PackageEnum.BmfParamKey.BMF_PARAM_INSTANCE_SIZE));
            hashMap2.put("ERR_CERT_AUTHORITY_INVALID", 303);
            hashMap2.put("ERR_CERT_COMMON_NAME_INVALID", 304);
            hashMap2.put("ERR_CERT_DATE_INVALID", 305);
            hashMap2.put("ERR_CONNECTION_ABORTED", 306);
            hashMap2.put("ERR_CONNECTION_CLOSED", 307);
            hashMap2.put("ERR_CONNECTION_REFUSED", 308);
            hashMap2.put("ERR_CONNECTION_RESET", 309);
            hashMap2.put("ERR_CONNECTION_TIMED_OUT", 310);
            hashMap2.put("ERR_EMPTY_RESPONSE", 311);
            hashMap2.put("ERR_HTTP2_PING_FAILED", 312);
            hashMap2.put("ERR_INCOMPLETE_CHUNKED_ENCODING", 313);
            hashMap2.put("ERR_INTERNET_DISCONNECTED", 314);
            hashMap2.put("ERR_NAME_NOT_RESOLVED", 315);
            hashMap2.put("ERR_NETWORK_ACCESS_DENIED", 316);
            hashMap2.put("ERR_PROXY_CONNECTION_FAILED", 317);
            hashMap2.put("ERR_SOCKET_NOT_CONNECTED", 318);
            hashMap2.put("ERR_SSL_BAD_RECORD_MAC_ALERT", 319);
            hashMap2.put("ERR_SSL_PROTOCOL_ERROR", 320);
            hashMap2.put("ERR_TIMED_OUT", 321);
            hashMap2.put("ERR_TTNET_APP_TIMED_OUT", 322);
            hashMap2.put("ERR_TTNET_APP_UPLOAD_EXCEPTION", Integer.valueOf(BuildConfig.VERSION_CODE));
            hashMap2.put("ERR_TUNNEL_CONNECTION_FAILED", 324);
            errorMap.put("NetworkExceptionImpl", hashMap2);
            HashMap hashMap3 = new HashMap();
            hashMap3.put("ERR_NETWORK_CHANGED", 401);
            errorMap.put("QuicExceptionImpl", hashMap3);
            HashMap hashMap4 = new HashMap();
            hashMap4.put(" Unexpected end of ZLIB input stream", 501);
            errorMap.put(EOFException.class.getSimpleName(), hashMap4);
            HashMap hashMap5 = new HashMap();
            hashMap5.put(" unexpected end of stream on Connection", 601);
            hashMap5.put(" Unexpected request usage", 602);
            errorMap.put(IOException.class.getSimpleName(), hashMap5);
            HashMap hashMap6 = new HashMap();
            hashMap6.put("Cronet internal request fail", 701);
            errorMap.put(Exception.class.getSimpleName(), hashMap6);
            HashMap hashMap7 = new HashMap();
            hashMap7.put(" Content received is less than Content-Length", 801);
            hashMap7.put(" expected bytes but received", 802);
            hashMap7.put(" unexpected end of stream", 803);
            errorMap.put(ProtocolException.class.getSimpleName(), hashMap7);
            HashMap hashMap8 = new HashMap();
            hashMap8.put(" Connection closed by peer", 901);
            hashMap8.put(" Read error", 902);
            hashMap8.put(" SSL handshake aborted", 903);
            errorMap.put(SSLException.class.getSimpleName(), hashMap8);
            HashMap hashMap9 = new HashMap();
            hashMap9.put(" Connection closed by peer", 1001);
            hashMap9.put(" Handshake failed", 1002);
            hashMap9.put(" SSL handshake aborted", Integer.valueOf(PackageEnum.BmfParamKey.BMF_PARAM_DOWNLOAD_MODEL_NAME));
            errorMap.put(SSLHandshakeException.class.getSimpleName(), hashMap9);
            HashMap hashMap10 = new HashMap();
            hashMap10.put(" Hostname not verified", 1101);
            errorMap.put(SSLPeerUnverifiedException.class.getSimpleName(), hashMap10);
            HashMap hashMap11 = new HashMap();
            hashMap11.put(" Read error", Integer.valueOf(PackageEnum.BmfParamKey.BMF_PARAM_PROCESS_MVP));
            errorMap.put(SSLProtocolException.class.getSimpleName(), hashMap11);
        }
    }

    public static void updateNetAllExtraInfo(HttpRequestInfo httpRequestInfo, JSONObject jSONObject) {
        updateRequestInfo(httpRequestInfo, jSONObject);
    }

    public static void updateNetErrorExtraInfo(HttpRequestInfo httpRequestInfo, Throwable th, JSONObject jSONObject) {
        if (jSONObject != null && th != null) {
            try {
                jSONObject.put(SlardarSettingsConsts.EXT_SUBSTATUS, getSubStatus(th));
            } catch (Throwable unused) {
            }
        }
        updateRequestInfo(httpRequestInfo, jSONObject);
    }

    private static void updateRequestInfo(HttpRequestInfo httpRequestInfo, JSONObject jSONObject) {
        if (jSONObject == null || httpRequestInfo == null) {
            return;
        }
        try {
            jSONObject.put(SlardarSettingsConsts.EXT_REQUEST_HEADER, httpRequestInfo.requestHeaders);
            jSONObject.put(SlardarSettingsConsts.EXT_RESPONSE_HEADER, httpRequestInfo.responseHeaders);
        } catch (Throwable unused) {
        }
    }

    public static int getSubStatus(Throwable th) {
        int i = -1;
        if (th == null) {
            return -1;
        }
        buildError();
        String message = th.getMessage();
        if (TextUtils.isEmpty(message)) {
            return -1;
        }
        int indexOf = message.indexOf(44);
        if (indexOf > 0) {
            message = message.substring(0, indexOf);
        }
        Map<String, Integer> map = errorMap.get(th.getClass().getSimpleName());
        if (map != null && !map.isEmpty()) {
            Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Integer> next = it.next();
                if (message.contains(next.getKey())) {
                    Integer value = next.getValue();
                    if (value != null) {
                        i = value.intValue();
                    }
                }
            }
        }
        if (i >= 0) {
            return i;
        }
        if (th instanceof HttpResponseException) {
            return 199;
        }
        if (th instanceof EOFException) {
            return 599;
        }
        if (th instanceof IOException) {
            return 699;
        }
        return i;
    }
}
