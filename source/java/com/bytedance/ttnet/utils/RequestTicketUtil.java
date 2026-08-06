package com.bytedance.ttnet.utils;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.ttnet.AppConsts;
import com.bytedance.ttnet.http.HttpRequestInfo;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RequestTicketUtil {
    public static final String HNAME_X_REQ_TICKET = "X-SS-REQ-TICKET";
    private static ICdnCacheVerifyCallback sCdnCacheVerifyProcessor = null;
    private static volatile boolean sEnabled = true;
    private static IRequestTicketProcessor sTicketProcessor;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ICdnCacheVerifyCallback {
        void onCallback(String str, HttpRequestInfo httpRequestInfo);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface IRequestTicketProcessor {
        void checkReqTicket(String str, String str2, String str3, HttpRequestInfo httpRequestInfo);

        void sendSetCookieEvent(String str, String str2, int i, boolean z, JSONObject jSONObject);
    }

    public static void tryGenReqTicket(String str, List<Header> list, RetrofitMetrics retrofitMetrics) {
        if (sEnabled) {
            retrofitMetrics.genReqTicketStart();
            try {
                String valueOf = URIUtils.safeCreateUri(str).getHost().endsWith(AppConsts.getHostSuffix()) ? String.valueOf(System.currentTimeMillis()) : null;
                if (!StringUtils.isEmpty(valueOf)) {
                    list.add(new Header(HNAME_X_REQ_TICKET, valueOf));
                }
            } catch (Throwable unused) {
            }
            retrofitMetrics.genReqTicketEnd();
        }
    }

    public static void checkReqTicket(String str, String str2, String str3, HttpRequestInfo httpRequestInfo) {
        IRequestTicketProcessor iRequestTicketProcessor = sTicketProcessor;
        if (iRequestTicketProcessor != null) {
            iRequestTicketProcessor.checkReqTicket(str, str2, str3, httpRequestInfo);
        }
    }

    public static void sendSetCookieEvent(String str, String str2, int i, boolean z, JSONObject jSONObject) {
        IRequestTicketProcessor iRequestTicketProcessor = sTicketProcessor;
        if (iRequestTicketProcessor != null) {
            iRequestTicketProcessor.sendSetCookieEvent(str, str2, i, z, jSONObject);
        }
    }

    public static IRequestTicketProcessor getRequestTicketProcessor() {
        return sTicketProcessor;
    }

    public static void setRequestTicketProcessor(IRequestTicketProcessor iRequestTicketProcessor) {
        sTicketProcessor = iRequestTicketProcessor;
    }

    public static ICdnCacheVerifyCallback getCdnCacheVerifyProcessor() {
        return sCdnCacheVerifyProcessor;
    }

    public static void setCdnCacheVerifyProcessor(ICdnCacheVerifyCallback iCdnCacheVerifyCallback) {
        sCdnCacheVerifyProcessor = iCdnCacheVerifyCallback;
    }

    public static void setEnable(boolean z) {
        sEnabled = z;
    }
}
