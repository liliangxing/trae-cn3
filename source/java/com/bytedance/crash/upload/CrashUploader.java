package com.bytedance.crash.upload;

import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.IEncrypt;
import com.bytedance.crash.NpthCore;
import com.bytedance.crash.NpthNetworkApi;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.service.IHttpService;
import com.bytedance.crash.service.IHttpUrlConnectionInterceptor;
import com.bytedance.crash.service.IMultipartService;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.IoUtil;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CrashUploader {
    private static final String ALOG_LOG_TYPE = "alog";
    private static final String ALOG_SCENE_FOR_CRASH = "npth";
    static final int BUFFER_SIZE = 8192;
    private static final String CONTENT_ENCODING_DEFLATE = "deflate";
    private static final String CONTENT_ENCODING_GZIP = "gzip";
    private static final String METHOD_POST = "POST";
    private static final int MIN_COMPRESS_LENGTH = 128;
    private static final String TAG = "NPTH-CrashUpload";
    private static final String URL_PARAM_ENCRYPT = "tt_data=a";
    private static IRequestIntercept sRequestIntercept;
    private static IRequestPermission sRequestPermission;
    private static IHttpUrlConnectionInterceptor sUrlConnectionInterceptor;

    public static void setUrlConnectionInterceptor(IHttpUrlConnectionInterceptor iHttpUrlConnectionInterceptor) {
        sUrlConnectionInterceptor = iHttpUrlConnectionInterceptor;
    }

    public static void setRequestIntercept(IRequestIntercept iRequestIntercept) {
        sRequestIntercept = iRequestIntercept;
    }

    public static void setRequestPermission(IRequestPermission iRequestPermission) {
        sRequestPermission = iRequestPermission;
    }

    public static IRequestIntercept getRequestIntercept() {
        return sRequestIntercept;
    }

    public static Response getQuotaState(String str, String str2) {
        return uploadCrashLog(str, str2, false);
    }

    public static Response uploadCrashLog(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return doPost(str, str2.getBytes(), CompressType.GZIP, z);
            }
            return new Response(201);
        } catch (Throwable th) {
            NpthLog.m239w(th);
            return new Response(Constants.UPLOAD_HTTP_ERROR, th);
        }
    }

    public static byte[] doGet(String str) {
        return executeRequest(str, null, "gzip", "GET", false, false).getData();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Response doPost(String str, byte[] bArr, CompressType compressType, boolean z) throws IOException {
        String str2;
        String str3;
        String str4;
        byte[] bArr2;
        if (str == null || bArr == null || NpthCore.isStopUpload()) {
            return new Response(201);
        }
        int length = bArr.length;
        if (CompressType.GZIP == compressType && length > 128) {
            bArr = wrapGzipData(bArr);
            str3 = "gzip";
        } else {
            if (CompressType.DEFLATER != compressType || length <= 128) {
                str2 = null;
                if (bArr != null) {
                    return new Response(202);
                }
                byte[] encrypt = z ? RuntimeConfig.getEncryptImpl().encrypt(bArr) : null;
                if (encrypt != null) {
                    if (TextUtils.isEmpty(new URL(str).getQuery())) {
                        if (!str.endsWith("?")) {
                            str = str + "?";
                        }
                    } else if (!str.endsWith("&")) {
                        str = str + "&";
                    }
                    str4 = str + URL_PARAM_ENCRYPT;
                    bArr2 = encrypt;
                } else {
                    str4 = str;
                    bArr2 = bArr;
                }
                return executeRequest(str4, bArr2, str2, METHOD_POST, true, z);
            }
            bArr = wrapDeflateData(bArr);
            str3 = CONTENT_ENCODING_DEFLATE;
        }
        str2 = str3;
        if (bArr != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x0169 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Response executeRequest(String str, byte[] bArr, String str2, String str3, boolean z, boolean z2) {
        DataOutputStream dataOutputStream;
        Pair<Integer, byte[]> doGet;
        String str4 = str;
        NpthLog.m234i("CustomException", "executeRequest:upload:" + str4);
        HttpURLConnection httpURLConnection = null;
        try {
            IRequestIntercept requestIntercept = getRequestIntercept();
            if (requestIntercept != null) {
                try {
                    str4 = requestIntercept.requestUrlVerify(str4, bArr);
                } catch (Throwable unused) {
                }
            }
            try {
                SSLContext.getInstance("TLS").init(null, null, null);
            } catch (Throwable unused2) {
            }
            URL url = new URL(str4);
            long checkPermission = NetworkDisasterManager.checkPermission(null, url);
            try {
                if (checkPermission < 0) {
                    return new Response(Constants.UPLOAD_DISASTER_DROP);
                }
                if (checkPermission > 0) {
                    return new Response(Constants.UPLOAD_DISASTER_ESCAPE);
                }
                IHttpService httpService = NpthNetworkApi.getHttpService();
                if (httpService != null) {
                    try {
                        HashMap hashMap = new HashMap();
                        if (z2) {
                            hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
                        } else {
                            hashMap.put("Content-Type", "application/json; charset=utf-8");
                        }
                        if (str2 != null) {
                            hashMap.put("Content-Encoding", str2);
                        }
                        hashMap.put("Accept-Encoding", "gzip");
                        if (z) {
                            doGet = httpService.doPost(str4, bArr, hashMap);
                        } else {
                            doGet = httpService.doGet(str4, hashMap);
                        }
                        if (doGet == null) {
                            return new Response(Constants.UPLOAD_HTTP_ERROR, "http response code ");
                        }
                        return new Response(((Integer) doGet.first).intValue(), (byte[]) doGet.second);
                    } catch (Throwable unused3) {
                        return new Response(Constants.UPLOAD_HTTP_ERROR, "http response code ");
                    }
                }
                try {
                    INetworkCallback networkCallback = NpthNetworkApi.getNetworkCallback();
                    if (networkCallback != null) {
                        networkCallback.onCallback(INetworkCallback.TYPE_URL_CONNECTION);
                    }
                } catch (Throwable unused4) {
                }
                HttpURLConnection urlConnection = getUrlConnection(url);
                try {
                    urlConnection.setDoOutput(z);
                    if (z2) {
                        urlConnection.setRequestProperty("Content-Type", "application/octet-stream;tt-data=a");
                    } else {
                        urlConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                    }
                    if (str2 != null) {
                        urlConnection.setRequestProperty("Content-Encoding", str2);
                    }
                    urlConnection.setRequestProperty("Accept-Encoding", "gzip");
                    urlConnection.setRequestMethod(str3);
                    if (bArr != null && bArr.length > 0) {
                        try {
                            DataOutputStream dataOutputStream2 = new DataOutputStream(urlConnection.getOutputStream());
                            try {
                                dataOutputStream2.write(bArr);
                                dataOutputStream2.flush();
                                FileSystemUtils.close(dataOutputStream2);
                            } catch (Throwable th) {
                                th = th;
                                dataOutputStream = dataOutputStream2;
                                FileSystemUtils.close(dataOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            dataOutputStream = null;
                        }
                    }
                    int responseCode = urlConnection.getResponseCode();
                    Response response = new Response(0);
                    response.setServerErrorCode(responseCode);
                    response.setHeaders(urlConnection.getHeaderFields());
                    if (responseCode == 200) {
                        byte[] response2 = getResponse(urlConnection);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject = new JSONObject(new String(response2));
                        } catch (Throwable unused5) {
                        }
                        NpthLog.m234i("CustomException", "uploadEvent:upload:" + jSONObject);
                        response.setServerJson(jSONObject);
                        response.setData(response2);
                        NetworkDisasterManager.updateNetworkState(url, response);
                    } else {
                        NetworkDisasterManager.updateNetworkState(url, response);
                        response.setErrCode(Constants.UPLOAD_HTTP_ERROR);
                        response.setErrorInfo("http response code " + responseCode);
                    }
                    if (urlConnection != null) {
                        try {
                            urlConnection.disconnect();
                        } catch (Exception unused6) {
                        }
                    }
                    return response;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = urlConnection;
                    try {
                        NpthLog.m232e(th);
                        Response response3 = new Response(Constants.UPLOAD_HTTP_ERROR);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused7) {
                            }
                        }
                        return response3;
                    } catch (Throwable th4) {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused8) {
                            }
                        }
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            NpthLog.m232e(th);
            Response response32 = new Response(Constants.UPLOAD_HTTP_ERROR);
            if (httpURLConnection != null) {
            }
            return response32;
        }
    }

    private static byte[] getResponse(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        GZIPInputStream gZIPInputStream;
        byte[] byteArray;
        InputStream inputStream2 = null;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (Exception unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                try {
                    gZIPInputStream = new GZIPInputStream(inputStream);
                } catch (Throwable th2) {
                    th = th2;
                    gZIPInputStream = null;
                }
                try {
                    byteArray = HttpOutputStream.toByteArray(gZIPInputStream);
                    IoUtil.close(gZIPInputStream);
                } catch (Throwable th3) {
                    th = th3;
                    IoUtil.close(gZIPInputStream);
                    throw th;
                }
            } else {
                byteArray = HttpOutputStream.toByteArray(inputStream);
            }
            FileSystemUtils.close(inputStream);
            return byteArray;
        } catch (Exception unused2) {
            FileSystemUtils.close(inputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            inputStream2 = inputStream;
            FileSystemUtils.close(inputStream2);
            throw th;
        }
    }

    public static Response uploadCrashLogWithAttachment(String str, String str2, String str3, List<File> list) {
        String urlAppendParam;
        NpthLog.m233i("upload crashType " + str);
        NpthLog.m233i("upload url " + str2);
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            NpthLog.m233i("upload attachments " + it.next().getAbsolutePath());
        }
        if (NpthCore.isStopUpload()) {
            return new Response(201);
        }
        try {
            long checkPermission = NetworkDisasterManager.checkPermission(null, new URL(str2));
            if (checkPermission < 0) {
                return new Response(Constants.UPLOAD_DISASTER_DROP);
            }
            if (checkPermission > 0) {
                return new Response(Constants.UPLOAD_DISASTER_ESCAPE);
            }
            IHttpService httpService = NpthNetworkApi.getHttpService();
            if (httpService != null) {
                try {
                    byte[] bytes = str3.getBytes();
                    IEncrypt encryptImpl = RuntimeConfig.getEncryptImpl();
                    if (encryptImpl != null) {
                        bytes = encryptImpl.encrypt(bytes);
                        urlAppendParam = UploaderUrl.urlAppendParam(str2, "have_dump=true&encrypt=true");
                    } else {
                        urlAppendParam = UploaderUrl.urlAppendParam(str2, "have_dump=true");
                    }
                    IMultipartService buildMultipartService = httpService.buildMultipartService(urlAppendParam, UrlUtils.UTF_8, true);
                    buildMultipartService.addFormField("json", bytes);
                    buildMultipartService.addGZIPFilePart("file", list);
                    Pair<Integer, String> finish = buildMultipartService.finish();
                    Response response = getResponse(((Integer) finish.first).intValue(), (String) finish.second);
                    try {
                        NetworkDisasterManager.updateNetworkState(new URL(urlAppendParam), response);
                    } catch (Throwable unused) {
                    }
                    return response;
                } catch (Exception unused2) {
                    return new Response(Constants.UPLOAD_HTTP_ERROR);
                }
            }
            try {
                INetworkCallback networkCallback = NpthNetworkApi.getNetworkCallback();
                if (networkCallback != null) {
                    networkCallback.onCallback(INetworkCallback.TYPE_URL_CONNECTION);
                }
            } catch (Throwable unused3) {
            }
            HttpMultipart httpMultipart = new HttpMultipart(UploaderUrl.urlAppendParam(str2, "have_dump=true&encrypt=true"), true);
            httpMultipart.addFormField("json", str3, true);
            httpMultipart.addFilePartAsZip("file", list);
            httpMultipart.finish(str);
            Response response2 = httpMultipart.getResponse();
            NpthLog.m234i(TAG, "uploadCrashLogWithAttachment:" + str + " success");
            return response2;
        } catch (IOException e) {
            e.printStackTrace();
            NpthLog.m235w("err upload crash log " + e);
            return new Response(Constants.UPLOAD_HTTP_ERROR);
        }
    }

    public static boolean uploadRawFile(String str, String str2, String str3, String str4, File file) {
        Response response;
        JSONObject serverJson;
        IHttpService httpService = NpthNetworkApi.getHttpService();
        if (httpService != null) {
            try {
                IMultipartService buildMultipartService = httpService.buildMultipartService(str2, UrlUtils.UTF_8, false);
                if (buildMultipartService != null) {
                    buildMultipartService.addFormField("data", str4);
                    buildMultipartService.addFormField("header", str3);
                    buildMultipartService.addFilePart("file", file);
                    buildMultipartService.finish();
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        try {
            INetworkCallback networkCallback = NpthNetworkApi.getNetworkCallback();
            if (networkCallback != null) {
                networkCallback.onCallback(INetworkCallback.TYPE_URL_CONNECTION);
            }
        } catch (Throwable unused2) {
        }
        try {
            HttpMultipart httpMultipart = new HttpMultipart(str2, false);
            httpMultipart.addFormField("data", str4);
            httpMultipart.addFormField("header", str3);
            httpMultipart.addFilePart("file", file);
            httpMultipart.finish(str);
            try {
                response = httpMultipart.getResponse();
                serverJson = response.getServerJson();
            } catch (Exception e) {
                NpthLog.m235w("corefile responses err" + e);
            }
            if (serverJson == null) {
                return false;
            }
            if (!"success".equals(serverJson.getString("message"))) {
                NpthLog.m235w("corefile upload err msg=" + response);
                return false;
            }
            return true;
        } catch (IOException e2) {
            NpthLog.m235w("corefile upload err" + e2);
            return false;
        }
    }

    public static boolean uploadRaphealFile(File file) {
        try {
            return uploadRawFile("raphael", NetConfig.getNativeMemUrl(), Header.createEventHeader(MonitorManager.getAppMonitor(), new Date(file.lastModified()).getTime(), CrashType.ENSURE, Process.myPid()).getJson().toString(), new JSONObject().put("event_type", "raphael_file").put("timestamp", System.currentTimeMillis()).toString(), file);
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean uploadCoreFile(String str, String str2, String str3, String str4, File file) {
        Response response;
        JSONObject serverJson;
        IHttpService httpService = NpthNetworkApi.getHttpService();
        if (httpService != null) {
            try {
                IMultipartService buildMultipartService = httpService.buildMultipartService(str2, UrlUtils.UTF_8, false);
                if (buildMultipartService != null) {
                    buildMultipartService.addFormField("data", str4);
                    buildMultipartService.addFormField("header", str3);
                    buildMultipartService.addFilePart("file", file);
                    buildMultipartService.finish();
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        try {
            INetworkCallback networkCallback = NpthNetworkApi.getNetworkCallback();
            if (networkCallback != null) {
                networkCallback.onCallback(INetworkCallback.TYPE_URL_CONNECTION);
            }
        } catch (Throwable unused2) {
        }
        try {
            HttpMultipart httpMultipart = new HttpMultipart(str2, false);
            httpMultipart.addFormField("data", str4);
            httpMultipart.addFormField("header", str3);
            httpMultipart.addFilePart("file", file);
            httpMultipart.finish(str);
            try {
                response = httpMultipart.getResponse();
                serverJson = response.getServerJson();
            } catch (Exception e) {
                e.printStackTrace();
                NpthLog.m235w("corefile responses err" + e);
            }
            if (serverJson == null) {
                return false;
            }
            if (!"success".equals(serverJson.getString("message"))) {
                NpthLog.m235w("corefile upload err msg=" + response);
                return false;
            }
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            NpthLog.m235w("corefile upload err" + e2);
            return false;
        }
    }

    public static boolean uploadEvent(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && !JSONUtils.isEmpty(jSONObject)) {
            try {
                return doPost(str, jSONObject.toString().getBytes(), CompressType.GZIP, true).isSuccess();
            } catch (Throwable th) {
                NpthLog.m239w(th);
            }
        }
        return false;
    }

    public static boolean uploadEvent(String str, JSONArray jSONArray) {
        if (!TextUtils.isEmpty(str) && !JSONUtils.isEmpty(jSONArray)) {
            try {
                return doPost(str, jSONArray.toString().getBytes(), CompressType.GZIP, true).isSuccess();
            } catch (Throwable th) {
                NpthLog.m239w(th);
            }
        }
        return false;
    }

    public static boolean uploadAlogFiles(String str, int i, String str2, String str3, List<String> list) {
        IMultipartService buildMultipartService;
        JSONObject serverJson;
        if (NpthCore.isStopUpload()) {
            return false;
        }
        IHttpService httpService = NpthNetworkApi.getHttpService();
        if (httpService != null) {
            try {
                buildMultipartService = httpService.buildMultipartService(str, UrlUtils.UTF_8, false);
            } catch (Throwable unused) {
            }
            if (buildMultipartService != null) {
                buildMultipartService.addFormField("aid", String.valueOf(i));
                buildMultipartService.addFormField("device_id", str2);
                buildMultipartService.addFormField("os", "Android");
                buildMultipartService.addFormField("process_name", str3);
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    File file = new File(it.next());
                    if (file.exists()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("logtype", ALOG_LOG_TYPE);
                        hashMap.put("scene", "npth");
                        buildMultipartService.addFilePart(file, hashMap);
                    }
                }
                Pair<Integer, String> finish = buildMultipartService.finish();
                if (finish != null) {
                    if (new JSONObject((String) finish.second).optInt("errno", -1) == 200) {
                        return true;
                    }
                }
                return false;
            }
        }
        try {
            INetworkCallback networkCallback = NpthNetworkApi.getNetworkCallback();
            if (networkCallback != null) {
                networkCallback.onCallback(INetworkCallback.TYPE_URL_CONNECTION);
            }
        } catch (Throwable unused2) {
        }
        try {
            HttpMultipart httpMultipart = new HttpMultipart(str, false);
            httpMultipart.addFormField("aid", String.valueOf(i));
            httpMultipart.addFormField("device_id", str2);
            httpMultipart.addFormField("os", "Android");
            httpMultipart.addFormField("process_name", str3);
            Iterator<String> it2 = list.iterator();
            while (it2.hasNext()) {
                File file2 = new File(it2.next());
                if (file2.exists()) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("logtype", ALOG_LOG_TYPE);
                    hashMap2.put("scene", "npth");
                    httpMultipart.addFilePart(file2, hashMap2);
                }
            }
            httpMultipart.finish(ALOG_LOG_TYPE);
            try {
                serverJson = httpMultipart.getResponse().getServerJson();
            } catch (Exception unused3) {
            }
            if (serverJson == null) {
                return false;
            }
            return serverJson.optInt("errno", -1) == 200;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean uploadNativeExceptionLog(String str, String str2, File... fileArr) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            arrayList.add(file);
        }
        return uploadCrashLogWithAttachment("ensure_zip", str, str2, arrayList).isSuccess();
    }

    @Deprecated
    public static Response uploadNativeCrashLog(String str, String str2, File... fileArr) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            arrayList.add(file);
        }
        if (uploadCrashLogWithAttachment("unknown_old", str, str2, arrayList).isSuccess()) {
            return new Response(0);
        }
        return new Response(Constants.UPLOAD_HTTP_ERROR);
    }

    @Deprecated
    public static Response uploadJavaCrashLog(String str, String str2) {
        try {
            if (doPost(str, str2.toString().getBytes(), CompressType.GZIP, true).isSuccess()) {
                return new Response(0);
            }
            return new Response(Constants.UPLOAD_HTTP_ERROR);
        } catch (IOException unused) {
            return new Response(Constants.UPLOAD_HTTP_ERROR);
        }
    }

    @Deprecated
    public static String getJavaUploadUrl() {
        return NetConfig.getJavaCrashUploadUrl();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum CompressType {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        final int nativeInt;

        CompressType(int i) {
            this.nativeInt = i;
        }
    }

    private static byte[] wrapGzipData(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                NpthLog.m239w(th);
                gZIPOutputStream.close();
                return null;
            } catch (Throwable th2) {
                gZIPOutputStream.close();
                throw th2;
            }
        }
    }

    private static byte[] wrapDeflateData(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean uploadCommonFilesZip(File file) {
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor == null) {
            return false;
        }
        return uploadCommonFilesZip(NetConfig.getAlogUploadUrl(), appMonitor.getAppId(), appMonitor.getDeviceId("0"), Global.getApplication().getPackageName(), file);
    }

    public static boolean uploadCommonFile(File file) {
        AppMonitor appMonitor;
        if (file == null || !file.exists() || (appMonitor = MonitorManager.getAppMonitor()) == null) {
            return false;
        }
        String alogUploadUrl = NetConfig.getAlogUploadUrl();
        String appId = appMonitor.getAppId();
        String deviceId = appMonitor.getDeviceId("0");
        String packageName = Global.getApplication().getPackageName();
        IHttpService httpService = NpthNetworkApi.getHttpService();
        if (httpService != null) {
            try {
                IMultipartService buildMultipartService = httpService.buildMultipartService(alogUploadUrl, UrlUtils.UTF_8, false);
                buildMultipartService.addFormField("aid", appId);
                buildMultipartService.addFormField("device_id", deviceId);
                buildMultipartService.addFormField("os", "Android");
                buildMultipartService.addFormField("process_name", packageName);
                HashMap hashMap = new HashMap();
                hashMap.put("logtype", SettingsManager.COMMON_SERVICE);
                hashMap.put("scene", SettingsManager.COMMON_SERVICE);
                buildMultipartService.addFilePart(file, hashMap);
                try {
                    try {
                        if (new JSONObject((String) buildMultipartService.finish().second).optInt("errno", -1) == 200) {
                            return true;
                        }
                    } catch (Throwable unused) {
                        return false;
                    }
                } catch (JSONException unused2) {
                }
            } catch (Throwable unused3) {
                return false;
            }
        }
        try {
            INetworkCallback networkCallback = NpthNetworkApi.getNetworkCallback();
            if (networkCallback != null) {
                networkCallback.onCallback(INetworkCallback.TYPE_URL_CONNECTION);
            }
        } catch (Throwable unused4) {
        }
        try {
            HttpMultipart httpMultipart = new HttpMultipart(alogUploadUrl, false);
            httpMultipart.addFormField("aid", appId);
            httpMultipart.addFormField("device_id", deviceId);
            httpMultipart.addFormField("os", "Android");
            httpMultipart.addFormField("process_name", packageName);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("logtype", SettingsManager.COMMON_SERVICE);
            hashMap2.put("scene", SettingsManager.COMMON_SERVICE);
            httpMultipart.addFilePart(file, hashMap2);
            httpMultipart.finish("custom_common_file");
            try {
                return httpMultipart.getResponse().isSuccess();
            } catch (Throwable unused5) {
                return false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x012f A[Catch: all -> 0x0158, TryCatch #6 {all -> 0x0158, blocks: (B:30:0x00f3, B:32:0x012f, B:33:0x013d), top: B:29:0x00f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0155 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0156 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean uploadCommonFilesZip(String str, String str2, String str3, String str4, File file) {
        boolean z;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Pair<Integer, String> finish;
        String str10;
        INetworkCallback networkCallback;
        JSONObject jSONObject;
        if (NpthCore.isStopUpload()) {
            return false;
        }
        try {
            jSONObject = new JSONObject();
            jSONObject.put("aid", str2);
            jSONObject.put("device_id", str3);
            jSONObject.put("os", "Android");
            jSONObject.put("process_name", str4);
            str5 = "upload common file ";
            str6 = "aid";
            str7 = "device_id";
            str8 = " ";
            str9 = "os";
            try {
            } catch (Throwable unused) {
                z = false;
            }
        } catch (Throwable unused2) {
            z = false;
            str5 = "upload common file ";
            str6 = "aid";
            str7 = "device_id";
            str8 = " ";
            str9 = "os";
        }
        if (!checkPermission(METHOD_POST, "multipart/form-data", null, str, jSONObject.toString(), null, file, null)) {
            return false;
        }
        z = false;
        try {
            if (NetworkDisasterManager.checkPermission(str2, new URL(str)) != 0) {
                return true;
            }
        } catch (Throwable unused3) {
        }
        IHttpService httpService = NpthNetworkApi.getHttpService();
        if (httpService != null) {
            try {
                IMultipartService buildMultipartService = httpService.buildMultipartService(str, UrlUtils.UTF_8, z);
                buildMultipartService.addFormField(str6, str2);
                buildMultipartService.addFormField(str7, str3);
                buildMultipartService.addFormField(str9, "Android");
                buildMultipartService.addFormField("process_name", str4);
                if (file.exists()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("logtype", SettingsManager.COMMON_SERVICE);
                    hashMap.put("scene", SettingsManager.COMMON_SERVICE);
                    buildMultipartService.addFilePart(file, "customFile.zip", hashMap);
                }
                finish = buildMultipartService.finish();
            } catch (Throwable unused4) {
            }
            if (getResponse(((Integer) finish.first).intValue(), (String) finish.second).getServerJson().optInt("errno", -1) == 200) {
                return true;
            }
            return z;
        }
        String str11 = str6;
        String str12 = str7;
        try {
            networkCallback = NpthNetworkApi.getNetworkCallback();
        } catch (Throwable unused5) {
        }
        try {
            try {
                if (networkCallback != null) {
                    str10 = "errno";
                    try {
                        networkCallback.onCallback(INetworkCallback.TYPE_URL_CONNECTION);
                    } catch (Throwable unused6) {
                    }
                    HttpMultipart httpMultipart = new HttpMultipart(str, false);
                    httpMultipart.addFormField(str11, str2);
                    httpMultipart.addFormField(str12, str3);
                    httpMultipart.addFormField(str9, "Android");
                    httpMultipart.addFormField("process_name", str4);
                    String str13 = str8;
                    NpthLog.m233i(str5 + str2 + str13 + str3 + str13 + str4);
                    if (file.exists()) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("logtype", SettingsManager.COMMON_SERVICE);
                        hashMap2.put("scene", SettingsManager.COMMON_SERVICE);
                        httpMultipart.addFilePart(file, "customFile.zip", hashMap2);
                    }
                    httpMultipart.finish("custom_common_zip");
                    return httpMultipart.getResponse().getServerJson().optInt(str10, -1) != 200;
                }
                if (httpMultipart.getResponse().getServerJson().optInt(str10, -1) != 200) {
                }
            } catch (Throwable unused7) {
                return false;
            }
            HttpMultipart httpMultipart2 = new HttpMultipart(str, false);
            httpMultipart2.addFormField(str11, str2);
            httpMultipart2.addFormField(str12, str3);
            httpMultipart2.addFormField(str9, "Android");
            httpMultipart2.addFormField("process_name", str4);
            String str132 = str8;
            NpthLog.m233i(str5 + str2 + str132 + str3 + str132 + str4);
            if (file.exists()) {
            }
            httpMultipart2.finish("custom_common_zip");
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
        str10 = "errno";
    }

    private static boolean checkPermission(String str, String str2, String str3, String str4, String str5, byte[] bArr, File file, List<String> list) {
        if (sRequestPermission == null || !METHOD_POST.equals(str)) {
            return true;
        }
        try {
            URL url = new URL(str4);
            String host = url.getHost();
            String path = url.getPath();
            ArrayList arrayList = new ArrayList();
            if (file != null) {
                arrayList.add(file.getAbsolutePath());
            }
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Host", host);
            hashMap.put(METHOD_POST, path);
            hashMap.put("Content-Type", str2);
            if (str3 != null) {
                hashMap.put("Content-Encoding", str3);
            }
            hashMap.put("Accept-Encoding", "gzip");
            if (sRequestPermission.getRequestPermission(str4, hashMap, bArr, arrayList)) {
                return true;
            }
            NpthLog.m235w("network request is not permitted:" + str4);
            return false;
        } catch (Throwable th) {
            NpthLog.m232e(th);
            return true;
        }
    }

    public static HttpURLConnection getUrlConnection(URL url) throws IOException {
        IHttpUrlConnectionInterceptor iHttpUrlConnectionInterceptor = sUrlConnectionInterceptor;
        return iHttpUrlConnectionInterceptor == null ? (HttpURLConnection) url.openConnection() : iHttpUrlConnectionInterceptor.getUrlConnection(url);
    }

    private static Response getResponse(int i, String str) throws IOException {
        JSONObject jSONObject;
        Response response = new Response(i);
        if (i != 200) {
            response.setErrCode(Constants.UPLOAD_HTTP_ERROR);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
            response.setErrCode(Constants.UPLOAD_HTTP_ERROR);
        }
        response.setServerJson(jSONObject);
        response.setData(str.getBytes());
        return response;
    }
}
