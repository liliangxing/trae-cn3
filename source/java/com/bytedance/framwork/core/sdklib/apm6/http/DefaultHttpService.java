package com.bytedance.framwork.core.sdklib.apm6.http;

import android.text.TextUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.framwork.core.sdkmonitor.MonitorNetUtil;
import com.bytedance.services.apm.api.HttpResponse;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: classes2.dex */
public class DefaultHttpService {
    private static String METHOD_POST = "POST";

    public static HttpResponse doPost(String str, byte[] bArr, Map<String, String> map) {
        return doRequest(str, bArr, METHOD_POST, map);
    }

    private static HttpResponse doRequest(String str, byte[] bArr, String str2, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        byte[] byteArray;
        if (str2 == null) {
            throw new IllegalArgumentException("request method is not null");
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (entry != null) {
                            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                }
                httpURLConnection.setDoOutput(TextUtils.equals(str2, METHOD_POST));
                httpURLConnection.setRequestMethod(str2);
                if (bArr != null && bArr.length > 0) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        String contentEncoding = httpURLConnection.getContentEncoding();
                        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.equalsIgnoreCase("gzip")) {
                            GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
                            byteArray = MonitorNetUtil.toByteArray(gZIPInputStream);
                            gZIPInputStream.close();
                        } else {
                            byteArray = MonitorNetUtil.toByteArray(inputStream);
                        }
                        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        HashMap hashMap = new HashMap();
                        for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                            String key = entry2.getKey();
                            List<String> value = entry2.getValue();
                            if (value != null && value.size() > 0) {
                                hashMap.put(key, value.get(0));
                            }
                        }
                        HttpResponse httpResponse = new HttpResponse(responseCode, hashMap, byteArray);
                        IOUtils.closeQuietly(inputStream);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                        return httpResponse;
                    } catch (Throwable unused2) {
                        IOUtils.closeQuietly(inputStream);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused3) {
                            }
                        }
                        return null;
                    }
                }
                HttpResponse httpResponse2 = new HttpResponse(responseCode, null);
                IOUtils.closeQuietly(null);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused4) {
                    }
                }
                return httpResponse2;
            } catch (Throwable unused5) {
                inputStream = null;
            }
        } catch (Throwable unused6) {
            httpURLConnection = null;
            inputStream = null;
        }
    }
}
