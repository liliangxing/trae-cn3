package com.bytedance.ttnet.retrofit;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.parser.CookieParser;
import com.bytedance.frameworks.baselib.network.http.retrofit.BaseSsInterceptor;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.ttnet.AppConsts;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.CdnCacheVerifyUtils;
import com.bytedance.ttnet.utils.RequestTicketUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SsInterceptor extends BaseSsInterceptor {
    private static final String SET_COOKIE = "Set-Cookie";
    private static volatile boolean sEncryptQueryEnabled;
    private static volatile boolean sHttpInfoInjectedByInterceptor;

    protected Request processBeforeSendRequest(Request request) throws IOException {
        Request processBeforeSendRequest = super.processBeforeSendRequest(request);
        if (processBeforeSendRequest == null) {
            return null;
        }
        if (!sHttpInfoInjectedByInterceptor) {
            HttpRequestInfo.injectCreate();
            sHttpInfoInjectedByInterceptor = true;
        }
        Request.Builder newBuilder = processBeforeSendRequest.newBuilder();
        String url = processBeforeSendRequest.getUrl();
        ArrayList arrayList = new ArrayList();
        if (processBeforeSendRequest.getHeaders() != null) {
            arrayList.addAll(processBeforeSendRequest.getHeaders());
        }
        String tryFilterDupQuery = tryFilterDupQuery(url, processBeforeSendRequest.getMetrics());
        tryEncryptRequestHeader(tryFilterDupQuery, newBuilder, arrayList, processBeforeSendRequest.getMetrics());
        RequestTicketUtil.tryGenReqTicket(tryFilterDupQuery, arrayList, processBeforeSendRequest.getMetrics());
        CdnCacheVerifyUtils.preProcessing(tryFilterDupQuery, arrayList, processBeforeSendRequest.getMetrics());
        ClientKeyManager.inst().AddClientKeyHeader(arrayList, processBeforeSendRequest.getMetrics());
        newBuilder.url(tryFilterDupQuery);
        newBuilder.headers(arrayList);
        return newBuilder.build();
    }

    protected void processAfterReceiveResponse(Request request, SsResponse ssResponse) throws Exception {
        super.processAfterReceiveResponse(request, ssResponse);
        if (request == null || ssResponse == null) {
            return;
        }
        Response raw = ssResponse.raw();
        checkCommandHeader(request, raw);
        ClientKeyManager.inst().UpdateClientKeyAndSessionInfo(request, raw);
        checkRequestTicket(request, raw, null);
        CdnCacheVerifyUtils.postProcessing(request, raw, null);
    }

    private void tryEncryptRequestHeader(String str, Request.Builder builder, List<Header> list, RetrofitMetrics retrofitMetrics) {
        if (sEncryptQueryEnabled) {
            try {
                LinkedList<Pair> linkedList = new LinkedList();
                retrofitMetrics.encryptRequestStart();
                try {
                    String tryEncryptRequest = RequestEncryptUtils.tryEncryptRequest(str, linkedList);
                    if (tryEncryptRequest != null) {
                        builder.url(tryEncryptRequest);
                    }
                    if (linkedList.isEmpty()) {
                        return;
                    }
                    for (Pair pair : linkedList) {
                        if (pair != null) {
                            list.add(new Header((String) pair.first, (String) pair.second));
                        }
                    }
                } finally {
                    retrofitMetrics.encryptRequestEnd();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private String tryFilterDupQuery(String str, RetrofitMetrics retrofitMetrics) {
        List list;
        List list2;
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        retrofitMetrics.filterDupQueryStart();
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Pair parseUrlWithValueList = UrlUtils.parseUrlWithValueList(str, linkedHashMap);
            if (parseUrlWithValueList == null) {
                return str;
            }
            if (!linkedHashMap.isEmpty()) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (entry != null && (list2 = (List) entry.getValue()) != null && !list2.isEmpty()) {
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            String str2 = (String) it.next();
                            if (linkedHashSet.contains(str2)) {
                                it.remove();
                            } else {
                                linkedHashSet.add(str2);
                            }
                        }
                    }
                }
            }
            UrlBuilder urlBuilder = new UrlBuilder(((String) parseUrlWithValueList.first) + ((String) parseUrlWithValueList.second));
            if (!linkedHashMap.isEmpty()) {
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    if (entry2 != null && entry2.getKey() != null && (list = (List) entry2.getValue()) != null && !list.isEmpty()) {
                        Iterator it2 = list.iterator();
                        while (it2.hasNext()) {
                            urlBuilder.addParam((String) entry2.getKey(), (String) it2.next());
                        }
                    }
                }
            }
            return urlBuilder.build();
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return str;
            } finally {
                retrofitMetrics.filterDupQueryEnd();
            }
        }
    }

    private void checkCommandHeader(Request request, Response response) {
        List<Header> headers;
        if (NetworkParams.getCommandListener() != null) {
            request.getMetrics().commandListenerStart();
            try {
                String headerKey = NetworkParams.getCommandListener().getHeaderKey();
                if (!StringUtils.isEmpty(headerKey) && (headers = response.headers(headerKey)) != null && headers.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Header> it = headers.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getValue());
                    }
                    NetworkParams.getCommandListener().onCommandReceived(arrayList);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    private void checkRequestTicket(Request request, Response response, HttpRequestInfo httpRequestInfo) {
        String url;
        Uri parse;
        request.getMetrics().checkReqTicketStart();
        try {
            Object extraInfo = response.getExtraInfo();
            if (extraInfo instanceof HttpRequestInfo) {
                httpRequestInfo = (HttpRequestInfo) extraInfo;
                if (httpRequestInfo.reqContext != null) {
                    JSONObject jSONObject = new JSONObject();
                    List<Header> headers = response.getHeaders();
                    for (int i = 0; i < headers.size(); i++) {
                        try {
                            Header header = headers.get(i);
                            if (header != null && !TextUtils.isEmpty(header.getName())) {
                                jSONObject.put(header.getName().toUpperCase(), header.getValue());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (httpRequestInfo.reqContext instanceof RequestContext) {
                        ((RequestContext) httpRequestInfo.reqContext).headers = jSONObject;
                    }
                    ((RequestContext) httpRequestInfo.reqContext).status = response.getStatus();
                    ((RequestContext) httpRequestInfo.reqContext).remoteIp = httpRequestInfo.remoteIp;
                }
            }
            try {
                String url2 = response.getUrl();
                Header firstHeader = request.getFirstHeader(RequestTicketUtil.HNAME_X_REQ_TICKET);
                String value = firstHeader != null ? firstHeader.getValue() : null;
                Header firstHeader2 = response.getFirstHeader(RequestTicketUtil.HNAME_X_REQ_TICKET);
                RequestTicketUtil.checkReqTicket(url2, value, firstHeader2 != null ? firstHeader2.getValue() : null, httpRequestInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                url = request.getUrl();
                parse = Uri.parse(url);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if (parse.getHost().endsWith(AppConsts.getHostSuffix())) {
                String[] strArr = {"sessionid", "tt_sessionid"};
                List<Header> headers2 = response.headers(new String[]{SET_COOKIE}[0]);
                if (headers2 != null && headers2.size() > 0) {
                    for (Header header2 : headers2) {
                        for (int i2 = 0; i2 < 2; i2++) {
                            String specialCookie = CookieParser.getSpecialCookie(header2.getValue(), strArr[i2]);
                            if (Logger.debug()) {
                                Logger.d("SsOkHttpClient", specialCookie);
                            }
                            if (!StringUtils.isEmpty(specialCookie)) {
                                int status = response.getStatus();
                                boolean z = httpRequestInfo.reqTicketUnmatch;
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    String encodedQuery = parse.getEncodedQuery();
                                    if (!StringUtils.isEmpty(encodedQuery)) {
                                        jSONObject2.put("url_query", encodedQuery);
                                    }
                                } catch (Throwable unused) {
                                }
                                if (!StringUtils.isEmpty(httpRequestInfo.remoteIp)) {
                                    jSONObject2.put("remote_ip", httpRequestInfo.remoteIp);
                                }
                                if (response.getHeaders() != null) {
                                    jSONObject2.put("header_list", response.getHeaders().toString());
                                }
                                int indexOf = url.indexOf("?");
                                if (indexOf == -1) {
                                    indexOf = url.length();
                                }
                                RequestTicketUtil.sendSetCookieEvent("set_cookie", url.substring(0, indexOf), status, z, jSONObject2);
                            }
                        }
                    }
                }
            }
        } finally {
            request.getMetrics().checkReqTicketEnd();
        }
    }

    public static void EnableEncryptQuery(boolean z) {
        sEncryptQueryEnabled = z;
    }
}
