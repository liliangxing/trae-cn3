package com.bytedance.sync.p005v4.ttnet;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.RequestHandler;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sync.SyncConstants;
import com.bytedance.sync.p005v4.utils.ToolUtils;
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

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SyncNonMainProcessNetworkClient {
    public static final int CONNECT_TIMEOUT = 15000;
    public static final int IO_TIMEOUT = 15000;

    public static String get(String str, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        try {
            return getRequest(str, map);
        } catch (Throwable th) {
            if (th instanceof HttpResponseException) {
                throw new CommonHttpException(th.getStatusCode(), th.getMessage());
            }
            throw new CommonHttpException(0, th.getMessage());
        }
    }

    public static String post(String str, List<Pair<String, String>> list, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        try {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < list.size(); i++) {
                Pair<String, String> pair = list.get(i);
                sb.append(((String) pair.first) + "=" + URLEncoder.encode((String) pair.second, "UTF-8"));
                if (i < list.size() - 1) {
                    sb.append("&");
                }
            }
            byte[] bytes = sb.toString().getBytes("UTF-8");
            HashMap hashMap = new HashMap();
            reqContext.addCommonParams = true;
            return post(str, bytes, hashMap, reqContext);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonHttpException(0, e.getMessage());
        }
    }

    public static String post(String str, byte[] bArr, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        try {
            return excuteRequest(str, bArr, map, OpenNetMethod.POST, true).body;
        } catch (Throwable th) {
            if (th instanceof HttpResponseException) {
                throw new CommonHttpException(th.getStatusCode(), th.getMessage());
            }
            throw new CommonHttpException(0, th.getMessage());
        }
    }

    public static RespResult postV2(String str, byte[] bArr, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        try {
            return excuteRequest(str, bArr, map, OpenNetMethod.POST, true);
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
        return excuteRequest(str, null, map, OpenNetMethod.GET, false).body;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class RespResult {
        public String body;
        public Map<String, String> headers;

        public RespResult(Map<String, String> map, String str) {
            this.body = str;
            this.headers = map;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x01a1, code lost:
    
        r8.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01a4, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static RespResult excuteRequest(final String str, byte[] bArr, Map<String, String> map, String str2, boolean z) throws Throwable {
        HttpURLConnection httpURLConnection;
        byte[] bArr2;
        int i;
        try {
            ToolUtils.addUrlParam(str, new HashMap());
            final HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod(str2);
                httpURLConnection2.setConnectTimeout(15000);
                httpURLConnection2.setReadTimeout(15000);
                httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (!entry.getKey().isEmpty() && !entry.getValue().isEmpty()) {
                            httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (z) {
                    httpURLConnection2.setDoOutput(true);
                } else {
                    httpURLConnection2.setDoOutput(false);
                }
                if (str2 == null) {
                    throw new IllegalArgumentException("request method is not null");
                }
                if (bArr != null && bArr.length > 0) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                int responseCode = httpURLConnection2.getResponseCode();
                HashMap hashMap = new HashMap();
                if (responseCode == 200) {
                    String headerField = httpURLConnection2.getHeaderField(SyncConstants.FLAG_SYNC);
                    if (!TextUtils.isEmpty(headerField)) {
                        hashMap.put(SyncConstants.FLAG_SYNC, headerField);
                    }
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    boolean equals = "gzip".equals(httpURLConnection2.getHeaderField("Content-Encoding"));
                    String headerField2 = httpURLConnection2.getHeaderField("Content-Type");
                    boolean testIsSSBinary = StreamParser.testIsSSBinary(headerField2);
                    Pair<String, String> parseContentType = parseContentType(headerField2);
                    String str3 = (parseContentType == null || parseContentType.second == null || !Charset.isSupported((String) parseContentType.second)) ? null : (String) parseContentType.second;
                    if (str3 == null) {
                        str3 = "UTF-8";
                    }
                    int[] iArr = {0};
                    try {
                        bArr2 = (byte[]) StreamParser.class.getMethod("response2buf", Boolean.TYPE, Integer.TYPE, InputStream.class, int[].class, RequestHandler.class).invoke(null, Boolean.valueOf(equals), -1, inputStream, iArr, new RequestHandler() { // from class: com.bytedance.sync.v4.ttnet.SyncNonMainProcessNetworkClient.1
                            public URI getURI() {
                                return URI.create(str);
                            }

                            public void abort() {
                                try {
                                    HttpURLConnection httpURLConnection3 = httpURLConnection2;
                                    if (httpURLConnection3 != null) {
                                        httpURLConnection3.disconnect();
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    } catch (Throwable unused) {
                        bArr2 = (byte[]) StreamParser.class.getMethod("response2buf", Boolean.TYPE, Map.class, Integer.TYPE, InputStream.class, int[].class, RequestHandler.class).invoke(null, Boolean.valueOf(equals), null, -1, inputStream, iArr, new RequestHandler() { // from class: com.bytedance.sync.v4.ttnet.SyncNonMainProcessNetworkClient.2
                            public URI getURI() {
                                return URI.create(str);
                            }

                            public void abort() {
                                try {
                                    HttpURLConnection httpURLConnection3 = httpURLConnection2;
                                    if (httpURLConnection3 != null) {
                                        httpURLConnection3.disconnect();
                                    }
                                } catch (Throwable unused2) {
                                }
                            }
                        });
                    }
                    if (bArr2 != null && (i = iArr[0]) > 0 && i <= bArr2.length) {
                        if (testIsSSBinary) {
                            StreamParser.decodeSSBinary(bArr2, i);
                        }
                        RespResult respResult = new RespResult(hashMap, new String(bArr2, 0, iArr[0], str3));
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Exception unused2) {
                            }
                        }
                        return respResult;
                    }
                    return null;
                }
                throw new HttpResponseException(responseCode, httpURLConnection2.getResponseMessage());
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                try {
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
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
        byte[] bArr = new byte[FConstants.DOWNLOAD_BUFFER_SIZE];
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
