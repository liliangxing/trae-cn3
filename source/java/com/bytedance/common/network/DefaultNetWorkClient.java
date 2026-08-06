package com.bytedance.common.network;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.ss.android.message.util.ToolUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DefaultNetWorkClient extends NetworkClient {
    public static final int CONNECT_TIMEOUT = 15000;
    public static final int IO_TIMEOUT = 15000;

    @Override // com.bytedance.common.utility.NetworkClient
    public String get(String str, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        try {
            return getRequest(str, map);
        } catch (Throwable th) {
            if (th instanceof HttpResponseException) {
                throw new CommonHttpException(th.getStatusCode(), th.getMessage());
            }
            throw new CommonHttpException(0, th.getMessage());
        }
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String str, List<Pair<String, String>> list, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        try {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < list.size(); i++) {
                Pair<String, String> pair = list.get(i);
                sb.append(((String) pair.first) + "=" + URLEncoder.encode((String) pair.second, UrlUtils.UTF_8));
                if (i < list.size() - 1) {
                    sb.append("&");
                }
            }
            byte[] bytes = sb.toString().getBytes(UrlUtils.UTF_8);
            HashMap hashMap = new HashMap();
            reqContext.addCommonParams = true;
            return post(str, bytes, hashMap, reqContext);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonHttpException(0, e.getMessage());
        }
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String str, byte[] bArr, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        try {
            return excuteRequest(str, bArr, map, "POST", true);
        } catch (Throwable th) {
            if (th instanceof HttpResponseException) {
                throw new CommonHttpException(th.getStatusCode(), th.getMessage());
            }
            throw new CommonHttpException(0, th.getMessage());
        }
    }

    public static String getRequest(String str, Map<String, String> map) throws Throwable {
        if (TextUtils.isDigitsOnly(str)) {
            return null;
        }
        return excuteRequest(str, null, map, "GET", false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f8, code lost:
    
        r2.disconnect();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String excuteRequest(final String str, byte[] bArr, Map<String, String> map, String str2, boolean z) throws Throwable {
        final HttpURLConnection httpURLConnection;
        int i;
        HttpURLConnection httpURLConnection2 = null;
        try {
            ToolUtils.addUrlParam(str, new HashMap());
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection.setRequestMethod(str2);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!entry.getKey().isEmpty() && !entry.getValue().isEmpty()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (z) {
                httpURLConnection.setDoOutput(true);
            } else {
                httpURLConnection.setDoOutput(false);
            }
            if (str2 == null) {
                throw new IllegalArgumentException("request method is not null");
            }
            if (bArr != null && bArr.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                dataOutputStream.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                boolean equals = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding"));
                String headerField = httpURLConnection.getHeaderField("Content-Type");
                boolean testIsSSBinary = StreamParser.testIsSSBinary(headerField);
                Pair<String, String> parseContentType = parseContentType(headerField);
                String str3 = (parseContentType == null || parseContentType.second == null || !Charset.isSupported((String) parseContentType.second)) ? null : (String) parseContentType.second;
                if (str3 == null) {
                    str3 = UrlUtils.UTF_8;
                }
                int[] iArr = {0};
                byte[] response2buf = StreamParser.response2buf(equals, -1, inputStream, iArr, new RequestHandler() { // from class: com.bytedance.common.network.DefaultNetWorkClient.1
                    @Override // com.bytedance.common.network.RequestHandler
                    public URI getURI() {
                        return URI.create(str);
                    }

                    @Override // com.bytedance.common.network.RequestHandler
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
                    String str4 = new String(response2buf, 0, iArr[0], str3);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                    return str4;
                }
                return null;
            }
            throw new HttpResponseException(responseCode, httpURLConnection.getResponseMessage());
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            try {
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

    public static Pair<String, String> parseContentType(String str) {
        String str2;
        String str3 = null;
        if (str == null) {
            return null;
        }
        try {
            MimeType mimeType = new MimeType(str);
            str2 = mimeType.getBaseType();
            try {
                str3 = mimeType.getParameter("charset");
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                return new Pair<>(str2, str3);
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
        }
        return new Pair<>(str2, str3);
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        if (inputStream != null) {
            inputStream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
