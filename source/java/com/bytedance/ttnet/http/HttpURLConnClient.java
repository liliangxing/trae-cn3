package com.bytedance.ttnet.http;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestHandler;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HttpURLConnClient {
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0201, code lost:
    
        r2.disconnect();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String executeGet(final String str, Map<String, String> map, Map<String, List<String>> map2, GetDomainContext getDomainContext) throws Throwable {
        final HttpURLConnection httpURLConnection;
        int i;
        Map<String, List<String>> headerFields;
        HttpURLConnection httpURLConnection2 = null;
        if (StringUtils.isEmpty(str) || getDomainContext == null || !NetworkUtils.isNetworkAvailable(TTNetInit.getTTNetDepend().getContext())) {
            return null;
        }
        try {
            if (getDomainContext.addCommonParam) {
                String addCommonParams = NetworkParams.addCommonParams(str, true, (RetrofitMetrics) null);
                if (!TextUtils.isEmpty(addCommonParams)) {
                    if (addCommonParams.equals(str)) {
                        StringBuilder sb = new StringBuilder(addCommonParams);
                        if (addCommonParams.indexOf(63) < 0) {
                            sb.append("?");
                        } else {
                            sb.append("&");
                        }
                        sb.append("aid=").append(TTNetInit.getTTNetDepend().getAppId()).append("&device_platform=android");
                        if (TTNetInit.getCronetProvider() != null) {
                            sb.append("&version_code=").append(TTNetInit.getCronetProvider().getVersionCode()).append("&channel=").append(TTNetInit.getCronetProvider().getChannel()).append(CommonConstants.KEY_DID).append(TTNetInit.getCronetProvider().getDeviceId());
                        }
                        str = sb.toString();
                    } else {
                        str = addCommonParams;
                    }
                }
            }
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(NetworkParams.getConnectTimeout());
            httpURLConnection.setReadTimeout(NetworkParams.getIoTimeout());
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            httpURLConnection.setRequestProperty("User-Agent", ForestLoader.DOWNLOAD_ENGINE_TTNET.concat(getDomainContext.useHttps ? " HttpsURLConnection" : " HttpURLConnection"));
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            getDomainContext.status = responseCode;
            if (map2 != null && httpURLConnection.getHeaderFields() != null && (headerFields = httpURLConnection.getHeaderFields()) != null) {
                for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                    String key = entry2.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        map2.put(key.toLowerCase(), entry2.getValue());
                    }
                }
            }
            if (!getDomainContext.useHttps) {
                getDomainContext.rawSign = httpURLConnection.getHeaderField("X-SS-SIGN");
            }
            getDomainContext.tncEtag = httpURLConnection.getHeaderField("x-ss-etag");
            getDomainContext.tncAbTest = httpURLConnection.getHeaderField("x-tt-tnc-abtest");
            getDomainContext.tncControl = httpURLConnection.getHeaderField("x-tt-tnc-control");
            getDomainContext.tncConfigId = httpURLConnection.getHeaderField("x-tt-tnc-config");
            getDomainContext.tncCanary = httpURLConnection.getHeaderField("x-ss-canary");
            getDomainContext.tncQueryRegion = httpURLConnection.getHeaderField("x-tt-tnc-query-region");
            getDomainContext.logid = httpURLConnection.getHeaderField("x-tt-logid");
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                boolean equals = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding"));
                String headerField = httpURLConnection.getHeaderField(XBridgeAPIRequestUtils.CONTENT_TYPE);
                boolean testIsSSBinary = StreamParser.testIsSSBinary(headerField);
                Pair<String, String> parseContentType = RetrofitUtils.parseContentType(headerField);
                String str2 = (parseContentType == null || parseContentType.second == null || !Charset.isSupported((String) parseContentType.second)) ? null : (String) parseContentType.second;
                if (str2 == null) {
                    str2 = "UTF-8";
                }
                int[] iArr = {0};
                byte[] response2buf = StreamParser.response2buf(equals, httpURLConnection.getHeaderFields(), -1, inputStream, iArr, new RequestHandler() { // from class: com.bytedance.ttnet.http.HttpURLConnClient.1
                    public URI getURI() {
                        try {
                            return URIUtils.safeCreateUri(str);
                        } catch (RuntimeException unused) {
                            return null;
                        }
                    }

                    public void abort() {
                        try {
                            HttpURLConnection httpURLConnection3 = httpURLConnection;
                            if (httpURLConnection3 != null) {
                                httpURLConnection3.disconnect();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
                if (response2buf != null && (i = iArr[0]) > 0 && i <= response2buf.length) {
                    if (testIsSSBinary) {
                        StreamParser.decodeSSBinary(response2buf, i);
                    }
                    String str3 = new String(response2buf, 0, iArr[0], str2);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                    return str3;
                }
                return null;
            }
            throw new IOException("err status = " + responseCode);
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            try {
                th.printStackTrace();
                throw th;
            } catch (Throwable th3) {
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception unused2) {
                    }
                }
                throw th3;
            }
        }
    }
}
