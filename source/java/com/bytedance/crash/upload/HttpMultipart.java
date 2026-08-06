package com.bytedance.crash.upload;

import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.bytedance.crash.IEncrypt;
import com.bytedance.crash.NpthNetworkApi;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.crash.service.IRequestHeaderProvider;
import com.bytedance.crash.util.NpthLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class HttpMultipart {
    private static final int BUFFER_SIZE = 8192;
    private static final String LINE_FEED = "\r\n";
    private final String mBoundary = "AAA" + System.currentTimeMillis() + "AAA";
    private final HttpURLConnection mConnection;
    public final IEncrypt mEncryptImpl;
    private final NpthMonitor.Event mMonitor;
    private final HttpOutputStream mOutput;

    public HttpMultipart(String str, boolean z) throws IOException {
        Map<String, String> header;
        try {
            SSLContext.getInstance("TLS").init(null, null, null);
        } catch (Throwable unused) {
        }
        HttpURLConnection urlConnection = CrashUploader.getUrlConnection(new URL(str));
        this.mConnection = urlConnection;
        urlConnection.setUseCaches(false);
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.mBoundary);
        if (z) {
            urlConnection.setRequestProperty("Content-Encoding", "gzip");
        }
        try {
            IRequestHeaderProvider requestHeaderProvider = NpthNetworkApi.getRequestHeaderProvider();
            if (requestHeaderProvider != null && (header = requestHeaderProvider.getHeader(INetworkCallback.TYPE_URL_CONNECTION)) != null) {
                for (String str2 : header.keySet()) {
                    this.mConnection.setRequestProperty(str2, header.get(str2));
                }
            }
        } catch (Throwable unused2) {
        }
        this.mOutput = new HttpOutputStream(this.mConnection.getOutputStream(), z);
        this.mEncryptImpl = RuntimeConfig.getEncryptImpl();
        this.mMonitor = new NpthMonitor.Event("crash_upload_size");
    }

    public void addFormField(String str, String str2) {
        addFormField(str, str2, false);
    }

    public void addFormField(String str, String str2, boolean z) {
        long count = this.mOutput.getCount();
        StringBuilder sb = new StringBuilder("--");
        sb.append(this.mBoundary).append("\r\nContent-Disposition: form-data; name=\"").append(str).append("\"\r\nContent-Type: text/plain; charset=UTF-8\r\n\r\n");
        try {
            this.mOutput.write(sb.toString());
        } catch (IOException unused) {
        }
        byte[] bytes = str2.getBytes();
        if (z) {
            try {
                bytes = this.mEncryptImpl.encrypt(bytes);
            } catch (Throwable unused2) {
            }
        }
        try {
            this.mOutput.write(bytes);
            this.mOutput.write(LINE_FEED);
        } catch (IOException unused3) {
        }
        this.mMonitor.addMetrics(str + "_size", Long.valueOf(this.mOutput.getCount() - count));
    }

    public void addFilePart(String str, File file) throws IOException {
        long count = this.mOutput.getCount();
        addFilePartSplit(str);
        addFileContent(file);
        this.mMonitor.addMetrics(str + "_size", Long.valueOf(this.mOutput.getCount() - count));
    }

    private void addFilePartSplit(String str) throws IOException {
        addFilePartSplit(str, null);
    }

    private void addFilePartSplit(String str, Map<String, String> map) throws IOException {
        StringBuilder sb = new StringBuilder("--");
        sb.append(this.mBoundary).append("\r\nContent-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(str).append("\"");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("; ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
            }
        }
        sb.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        this.mOutput.write(sb.toString().getBytes());
    }

    public void addFilePartAsZip(String str, List<File> list) throws IOException {
        long count = this.mOutput.getCount();
        addFilePartSplit(str, null);
        this.mOutput.writeZipFiles(list);
        this.mOutput.write(LINE_FEED);
        this.mMonitor.addMetrics(str + "_size", Long.valueOf(this.mOutput.getCount() - count));
    }

    public void addFilePart(File file, Map<String, String> map) throws IOException {
        addFilePartSplit(file.getName(), map);
        addFileContent(file);
    }

    public void addFilePart(File file, String str, Map<String, String> map) throws IOException {
        addFilePartSplit(str, map);
        addFileContent(file);
    }

    private void addFileContent(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                this.mOutput.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                this.mOutput.write(LINE_FEED);
                return;
            }
        }
    }

    public void finish(String str) throws IOException {
        this.mOutput.write("\r\n--" + this.mBoundary + "--\r\n");
        this.mOutput.close();
        this.mMonitor.addCategories(CpuReportEvent.PERF_DATA_TYPE, str);
        this.mMonitor.addMetrics("total_size", Long.valueOf(this.mOutput.getCount()));
        this.mMonitor.upload();
    }

    public Response getResponse() throws IOException {
        JSONObject jSONObject;
        ArrayList arrayList = new ArrayList();
        NpthLog.m227d("getHeaderFields:" + this.mConnection.getHeaderFields());
        int responseCode = this.mConnection.getResponseCode();
        Response response = new Response(responseCode);
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.mConnection.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            this.mConnection.disconnect();
        } else {
            response.setErrCode(Constants.UPLOAD_HTTP_ERROR);
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        try {
            jSONObject = new JSONObject(sb.toString());
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
            response.setErrCode(Constants.UPLOAD_HTTP_ERROR);
        }
        response.setServerJson(jSONObject);
        try {
            NetworkDisasterManager.updateNetworkState(this.mConnection.getURL(), response);
        } catch (Throwable unused2) {
        }
        response.setData(sb.toString().getBytes());
        return response;
    }
}
