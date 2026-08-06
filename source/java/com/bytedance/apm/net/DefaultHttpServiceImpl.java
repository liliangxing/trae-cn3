package com.bytedance.apm.net;

import android.text.TextUtils;
import com.bytedance.apm.block.BlockConstants;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.util.FileUploadUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.apm.util.StackUtils;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DefaultHttpServiceImpl implements IHttpService {
    private static String METHOD_GET = "GET";
    private static String METHOD_POST = "POST";

    public HttpResponse doPost(String str, byte[] bArr, Map<String, String> map) throws Exception {
        return doRequest(str, bArr, METHOD_POST, map);
    }

    public HttpResponse doGet(String str, Map<String, String> map) throws Exception {
        return doRequest(str, null, METHOD_GET, map);
    }

    public HttpResponse uploadFiles(String str, List<File> list, Map<String, String> map) throws Exception {
        return FileUploadUtils.uploadFiles(str, list, map);
    }

    public IMultipartUploader buildMultipartUpload(String str, String str2, boolean z) throws IOException {
        return new MultipartUtility(str, str2, z, null);
    }

    public IMultipartUploader buildMultipartUpload(String str, String str2, boolean z, Map<String, String> map) throws Exception {
        return new MultipartUtility(str, str2, z, map);
    }

    private HttpResponse doRequest(String str, byte[] bArr, String str2, Map<String, String> map) throws Exception {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        byte[] byteArray;
        if (str2 == null) {
            throw new IllegalArgumentException("request method is not null");
        }
        try {
            httpURLConnection = NetUtils.getUrlConnection(str);
            try {
                httpURLConnection.setConnectTimeout(BlockConstants.DEFAULT_ANR);
                httpURLConnection.setReadTimeout(BlockConstants.DEFAULT_ANR);
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (entry != null) {
                            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (TextUtils.equals(str2, METHOD_POST)) {
                    httpURLConnection.setDoOutput(true);
                } else {
                    httpURLConnection.setDoOutput(false);
                }
                httpURLConnection.setRequestMethod(str2);
                if (bArr != null && bArr.length > 0) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    HttpResponse httpResponse = new HttpResponse(responseCode, (byte[]) null);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                    return httpResponse;
                }
                inputStream = httpURLConnection.getInputStream();
                try {
                    String contentEncoding = httpURLConnection.getContentEncoding();
                    if (TextUtils.isEmpty(contentEncoding) || !contentEncoding.equalsIgnoreCase("gzip")) {
                        byteArray = toByteArray(inputStream);
                    } else {
                        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
                        byteArray = toByteArray(gZIPInputStream);
                        gZIPInputStream.close();
                    }
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    HashMap hashMap = new HashMap();
                    for (String str3 : headerFields.keySet()) {
                        List<String> list = headerFields.get(str3);
                        if (list != null && !ListUtils.isEmpty(list)) {
                            hashMap.put(str3, list.get(0));
                        }
                    }
                    HttpResponse httpResponse2 = new HttpResponse(responseCode, hashMap, byteArray);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused3) {
                        }
                    }
                    return httpResponse2;
                } catch (Throwable th) {
                    th = th;
                    try {
                        ApmAlogHelper.m77i("apm_debug", "http request msg: " + th.getMessage() + " ,stack: " + StackUtils.getStackLimit(th, 10));
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused5) {
                            }
                        }
                        return null;
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            inputStream = null;
        }
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
