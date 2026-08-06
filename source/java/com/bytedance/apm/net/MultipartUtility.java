package com.bytedance.apm.net;

import android.text.TextUtils;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IMultipartUploader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
class MultipartUtility implements IMultipartUploader {
    private static final int BUFFER_SIZE = 8192;
    private static final String LINE_FEED = "\r\n";
    private final String boundary;
    private String charset;
    private DataOutputStream dataOutputStream;
    private boolean gzip;
    private GZIPOutputStream gzipOutputStream;
    private Map<String, String> header;
    private HttpURLConnection httpConn;

    public MultipartUtility(String str, String str2, boolean z, Map<String, String> map) throws IOException {
        this.charset = str2;
        this.gzip = z;
        this.header = map;
        String str3 = "AAA" + System.currentTimeMillis() + "AAA";
        this.boundary = str3;
        HttpURLConnection urlConnection = NetUtils.getUrlConnection(str);
        this.httpConn = urlConnection;
        urlConnection.setUseCaches(false);
        this.httpConn.setDoOutput(true);
        this.httpConn.setDoInput(true);
        this.httpConn.setRequestMethod("POST");
        this.httpConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str3);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.httpConn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        this.httpConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.boundary);
        if (z) {
            this.httpConn.setRequestProperty("Content-Encoding", "gzip");
            this.gzipOutputStream = new GZIPOutputStream(this.httpConn.getOutputStream());
        } else {
            this.dataOutputStream = new DataOutputStream(this.httpConn.getOutputStream());
        }
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFormField(String str, String str2) {
        StringBuilder sb = new StringBuilder(100);
        sb.append("--").append(this.boundary).append("\r\nContent-Disposition: form-data; name=\"").append(str).append("\"\r\nContent-Type: text/plain; charset=").append(this.charset).append("\r\n\r\n").append(str2).append(LINE_FEED);
        try {
            if (this.gzip) {
                this.gzipOutputStream.write(sb.toString().getBytes());
            } else {
                this.dataOutputStream.write(sb.toString().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String str, File file, String str2, Map<String, String> map) throws IOException {
        String name = file.getName();
        StringBuilder sb = new StringBuilder(100);
        sb.append("--").append(this.boundary).append("\r\nContent-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(name).append("\"");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("; ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append("\r\nContent-Type: ").append(str2).append(LINE_FEED);
        }
        sb.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.gzip) {
            this.gzipOutputStream.write(sb.toString().getBytes());
        } else {
            this.dataOutputStream.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (this.gzip) {
                this.gzipOutputStream.write(bArr, 0, read);
            } else {
                this.dataOutputStream.write(bArr, 0, read);
            }
        }
        fileInputStream.close();
        if (this.gzip) {
            this.gzipOutputStream.write(LINE_FEED.getBytes());
        } else {
            this.dataOutputStream.write(LINE_FEED.getBytes());
            this.dataOutputStream.flush();
        }
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String str, String str2, String str3, Map<String, String> map) throws IOException {
        StringBuilder sb = new StringBuilder(100);
        sb.append("--").append(this.boundary).append("\r\nContent-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(str).append("\"");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("; ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append("\r\nContent-Type: ").append(str3).append(LINE_FEED);
        }
        sb.append(LINE_FEED);
        if (this.gzip) {
            this.gzipOutputStream.write(sb.toString().getBytes());
        } else {
            this.dataOutputStream.write(sb.toString().getBytes());
        }
        if (str2 == null) {
            str2 = "";
        }
        if (this.gzip) {
            this.gzipOutputStream.write(str2.getBytes());
        } else {
            this.dataOutputStream.write(str2.getBytes());
        }
        if (this.gzip) {
            this.gzipOutputStream.write(LINE_FEED.getBytes());
        } else {
            this.dataOutputStream.write(LINE_FEED.getBytes());
            this.dataOutputStream.flush();
        }
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public HttpResponse finish() throws IOException {
        ArrayList arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.boundary + "--\r\n").getBytes();
        if (this.gzip) {
            this.gzipOutputStream.write(bytes);
            this.gzipOutputStream.finish();
            this.gzipOutputStream.close();
        } else {
            this.dataOutputStream.write(bytes);
            this.dataOutputStream.flush();
            this.dataOutputStream.close();
        }
        int responseCode = this.httpConn.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.httpConn.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            this.httpConn.disconnect();
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
            }
            return new HttpResponse(responseCode, sb.toString().getBytes());
        }
        throw new IOException("Server returned non-OK status: " + responseCode);
    }
}
