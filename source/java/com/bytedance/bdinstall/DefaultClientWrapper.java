package com.bytedance.bdinstall;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.network.TTResponse;
import com.bytedance.bdinstall.util.NetUtils;
import com.ss.android.update.UpdateDialogNewBase;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DefaultClientWrapper implements INetworkClientWrapper {
    private static final String CONTENT_TYPE = "application/json; charset=utf-8";
    private static final String[] HTTP_METHOD = {"GET", "POST"};
    private static final int LENGTH_MAX = 10240;
    private static final int METHOD_GET = 0;
    private static final int METHOD_POST = 1;

    @Override // com.bytedance.bdinstall.INetworkClientWrapper
    public TTResponse get(String str, Map<String, String> map) throws Exception {
        return http(0, str, (HashMap) map, null);
    }

    @Override // com.bytedance.bdinstall.INetworkClientWrapper
    public TTResponse post(String str, byte[] bArr, Map<String, String> map) throws Exception {
        return http(1, str, (HashMap) map, bArr);
    }

    @Override // com.bytedance.bdinstall.INetworkClientWrapper
    public TTResponse post(String str, byte[] bArr, String str2) throws Exception {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("Content-Type", str2);
        }
        return post(str, bArr, hashMap);
    }

    @Override // com.bytedance.bdinstall.INetworkClientWrapper
    public TTResponse post(String str, List<Pair<String, String>> list) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (list != null) {
            for (Pair<String, String> pair : list) {
                jSONObject.put((String) pair.first, pair.second);
            }
        }
        return post(str, jSONObject.toString().getBytes(), "application/json; charset=utf-8");
    }

    @Override // com.bytedance.bdinstall.INetworkClientWrapper
    public byte[] postStream(String str, byte[] bArr, Map<String, String> map) throws RangersHttpException {
        return httpRequestInner(1, str, map, bArr, 1).mRespByteArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class HttpResp {
        byte[] mRespByteArray;
        String mRespStr;
        int mType;

        HttpResp(int i) {
            this.mType = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01f9 A[Catch: all -> 0x01fc, TRY_ENTER, TryCatch #4 {all -> 0x01fc, blocks: (B:79:0x01e5, B:82:0x01f9, B:83:0x01fb), top: B:78:0x01e5 }] */
    /* JADX WARN: Type inference failed for: r10v18, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static HttpResp httpRequestInner(int i, String str, Map<String, String> map, byte[] bArr, int i2) throws RangersHttpException {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream3;
        RangersHttpException th;
        int responseCode;
        DataOutputStream dataOutputStream2;
        ?? r10;
        if (DrLog.DEBUG) {
            DrLog.d("http: " + str);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        DrLog.d("http headers key:" + entry.getKey() + " value:" + entry.getValue());
                    }
                }
            }
            if (bArr != null) {
                DrLog.d("http data length:" + bArr.length);
            }
        }
        HttpResp httpResp = new HttpResp(i2);
        DataOutputStream dataOutputStream3 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i == 0) {
                httpURLConnection.setDoOutput(false);
            } else if (i == 1) {
                httpURLConnection.setDoOutput(true);
            } else {
                DrLog.ysnp(null);
            }
            httpURLConnection.setRequestMethod(HTTP_METHOD[i]);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry2 : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                        httpURLConnection.addRequestProperty(entry2.getKey(), entry2.getValue());
                    } else {
                        DrLog.ysnp(null);
                    }
                }
            }
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (bArr == null || bArr.length <= 0) {
                dataOutputStream = null;
            } else {
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    byteArrayOutputStream3 = null;
                    dataOutputStream3 = dataOutputStream;
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream3;
                    byteArrayOutputStream2 = byteArrayOutputStream3;
                    try {
                        DrLog.ysnp(th);
                        if (!(th instanceof RangersHttpException)) {
                        }
                    } catch (Throwable th3) {
                        Utils.closeSafely(dataOutputStream3);
                        Utils.closeSafely(byteArrayOutputStream2);
                        Utils.closeSafely(inputStream);
                        Utils.closeSafely(byteArrayOutputStream);
                        throw th3;
                    }
                }
            }
            responseCode = httpURLConnection.getResponseCode();
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            inputStream = null;
            byteArrayOutputStream2 = null;
        }
        if (responseCode != 200) {
            throw new RangersHttpException(responseCode, httpURLConnection.getResponseMessage());
        }
        if (i2 == 0) {
            if (httpURLConnection.getContentLength() < LENGTH_MAX) {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                    r10 = new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream2)));
                } else {
                    r10 = new BufferedReader(new InputStreamReader(inputStream2));
                }
                try {
                    StringBuilder sb = new StringBuilder(inputStream2.available());
                    while (true) {
                        String readLine = r10.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine).append(UpdateDialogNewBase.TYPE);
                    }
                    httpResp.mRespStr = sb.toString();
                    JSONObject jSONObject = new JSONObject(httpResp.mRespStr);
                    jSONObject.put("Set-Cookie", httpURLConnection.getHeaderField("Set-Cookie"));
                    httpResp.mRespStr = jSONObject.toString();
                    dataOutputStream2 = r10;
                } catch (Throwable th5) {
                    inputStream = null;
                    dataOutputStream3 = dataOutputStream;
                    th = th5;
                    byteArrayOutputStream = null;
                    byteArrayOutputStream2 = r10;
                    DrLog.ysnp(th);
                    if (!(th instanceof RangersHttpException)) {
                        throw th;
                    }
                    Utils.closeSafely(dataOutputStream3);
                    Utils.closeSafely(byteArrayOutputStream2);
                    Utils.closeSafely(inputStream);
                    Utils.closeSafely(byteArrayOutputStream);
                    return httpResp;
                }
            } else {
                DrLog.ysnp(null);
                dataOutputStream2 = null;
            }
            byteArrayOutputStream = null;
            inputStream = null;
            dataOutputStream3 = dataOutputStream2;
        } else {
            inputStream = httpURLConnection.getInputStream();
            if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                inputStream = new GZIPInputStream(inputStream);
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    httpResp.mRespByteArray = byteArrayOutputStream.toByteArray();
                } catch (Throwable th6) {
                    dataOutputStream3 = dataOutputStream;
                    th = th6;
                    byteArrayOutputStream2 = null;
                    DrLog.ysnp(th);
                    if (!(th instanceof RangersHttpException)) {
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                byteArrayOutputStream3 = null;
                dataOutputStream3 = dataOutputStream;
                th = th;
                byteArrayOutputStream = byteArrayOutputStream3;
                byteArrayOutputStream2 = byteArrayOutputStream3;
                DrLog.ysnp(th);
                if (!(th instanceof RangersHttpException)) {
                }
            }
        }
        Utils.closeSafely(dataOutputStream);
        Utils.closeSafely(dataOutputStream3);
        Utils.closeSafely(inputStream);
        Utils.closeSafely(byteArrayOutputStream);
        return httpResp;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01e0 A[Catch: all -> 0x01e3, TRY_ENTER, TryCatch #4 {all -> 0x01e3, blocks: (B:92:0x01b6, B:104:0x01e0, B:105:0x01e2), top: B:91:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TTResponse http(int i, String str, HashMap<String, String> hashMap, byte[] bArr) throws RangersHttpException {
        DataOutputStream dataOutputStream;
        BufferedReader bufferedReader;
        String str2;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream2;
        RangersHttpException th;
        int responseCode;
        TTResponse tTResponse;
        if (DrLog.debug()) {
            DrLog.d("http: " + str);
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        DrLog.d("http headers key:" + entry.getKey() + " value:" + entry.getValue());
                    }
                }
            }
            if (bArr != null) {
                DrLog.d("http data length:" + bArr.length);
            }
        }
        TTResponse tTResponse2 = null;
        BufferedReader bufferedReader2 = null;
        tTResponse2 = null;
        tTResponse2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i == 0) {
                httpURLConnection.setDoOutput(false);
            } else if (i == 1) {
                httpURLConnection.setDoOutput(true);
            } else {
                DrLog.ysnp(null);
            }
            httpURLConnection.setRequestMethod(HTTP_METHOD[i]);
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry2 : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                        httpURLConnection.addRequestProperty(entry2.getKey(), entry2.getValue());
                    } else {
                        DrLog.ysnp(null);
                    }
                }
            }
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (bArr == null || bArr.length <= 0) {
                dataOutputStream2 = null;
            } else {
                dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream2.write(bArr);
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                    str2 = null;
                    RangersHttpException rangersHttpException = th;
                    dataOutputStream = dataOutputStream2;
                    th = rangersHttpException;
                    try {
                        DrLog.ysnp(th);
                        if (!(th instanceof RangersHttpException)) {
                        }
                    } finally {
                    }
                }
            }
            responseCode = httpURLConnection.getResponseCode();
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            bufferedReader = null;
            str2 = null;
        }
        if (responseCode == 200) {
            if (httpURLConnection.getContentLength() < LENGTH_MAX) {
                InputStream inputStream = httpURLConnection.getInputStream();
                if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                    bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream)));
                } else {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                }
                try {
                    StringBuilder sb = new StringBuilder(inputStream.available());
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine).append(UpdateDialogNewBase.TYPE);
                    }
                    str2 = sb.toString();
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        jSONObject.put(Api.KEY_HTTP_CODE, 200);
                        jSONObject.put("Set-Cookie", httpURLConnection.getHeaderField("Set-Cookie"));
                        List<Pair<String, String>> parseResponseHeaders = NetUtils.parseResponseHeaders(httpURLConnection.getHeaderFields());
                        str2 = jSONObject.toString();
                        tTResponse = new TTResponse(str, responseCode, parseResponseHeaders, str2);
                        bufferedReader2 = bufferedReader;
                    } catch (Throwable th4) {
                        th = th4;
                        RangersHttpException rangersHttpException2 = th;
                        dataOutputStream = dataOutputStream2;
                        th = rangersHttpException2;
                        DrLog.ysnp(th);
                        if (!(th instanceof RangersHttpException)) {
                            throw th;
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (DrLog.debug()) {
                        }
                        return tTResponse2;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str2 = null;
                }
            } else {
                DrLog.ysnp(null);
                tTResponse = null;
                str2 = null;
            }
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused4) {
                }
            }
            tTResponse2 = tTResponse;
            if (DrLog.debug()) {
                DrLog.d("http response: " + str2);
            }
            return tTResponse2;
        }
        throw new RangersHttpException(responseCode, httpURLConnection.getResponseMessage());
    }
}
