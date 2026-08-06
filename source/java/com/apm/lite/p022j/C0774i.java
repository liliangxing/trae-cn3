package com.apm.lite.p022j;

import com.apm.lite.p020h.C0760a;
import com.apm.lite.p023k.C0784g;
import com.apm.lite.p023k.C0786i;
import com.bytedance.framwork.core.sdkmonitor.MonitorNetUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.apm.lite.j.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0774i {

    /* renamed from: a */
    private final String f554a;

    /* renamed from: b */
    private HttpURLConnection f555b;

    /* renamed from: c */
    private String f556c;

    /* renamed from: d */
    private boolean f557d;

    /* renamed from: e */
    private C0771f f558e;

    /* renamed from: f */
    private C0777l f559f;

    public C0774i(String str, String str2, Map<String, String> map, boolean z) {
        this.f556c = str2;
        this.f557d = z;
        String str3 = "AAA" + System.currentTimeMillis() + "AAA";
        this.f554a = str3;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f555b = httpURLConnection;
        C0760a.m639a(httpURLConnection);
        this.f555b.setUseCaches(false);
        this.f555b.setDoOutput(true);
        this.f555b.setDoInput(true);
        this.f555b.setRequestMethod("POST");
        this.f555b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str3);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f555b.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (!z) {
            this.f558e = new C0771f(this.f555b.getOutputStream());
        } else {
            this.f555b.setRequestProperty(MonitorNetUtil.KEY_CONTENT_ENCODING, "gzip");
            this.f559f = new C0777l(this.f555b.getOutputStream());
        }
    }

    public C0774i(String str, String str2, boolean z) {
        this(str, str2, null, z);
    }

    /* renamed from: a */
    public String m716a() {
        ArrayList arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.f554a + "--\r\n").getBytes();
        if (this.f557d) {
            this.f559f.write(bytes);
            this.f559f.m735b();
            this.f559f.m734a();
        } else {
            this.f558e.write(bytes);
            this.f558e.flush();
            this.f558e.m711a();
        }
        int responseCode = this.f555b.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f555b.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            arrayList.add(readLine);
        }
        bufferedReader.close();
        this.f555b.disconnect();
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void m717a(String str, File file, Map<String, String> map) {
        String name = file.getName();
        StringBuilder sb = new StringBuilder("--");
        sb.append(this.f554a).append("\r\nContent-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(name).append("\"");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("; ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        sb.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.f557d) {
            this.f559f.write(sb.toString().getBytes());
        } else {
            this.f558e.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (this.f557d) {
                this.f559f.write(bArr, 0, read);
            } else {
                this.f558e.write(bArr, 0, read);
            }
        }
        fileInputStream.close();
        if (this.f557d) {
            this.f559f.write("\r\n".getBytes());
        } else {
            this.f558e.write("\r\n".getBytes());
            this.f558e.flush();
        }
    }

    /* renamed from: a */
    public void m718a(String str, String str2) {
        m719a(str, str2, false);
    }

    /* renamed from: a */
    public void m719a(String str, String str2, boolean z) {
        StringBuilder sb = new StringBuilder("--");
        sb.append(this.f554a).append("\r\nContent-Disposition: form-data; name=\"").append(str).append("\"\r\nContent-Type: text/plain; charset=").append(this.f556c).append("\r\n\r\n");
        try {
            if (this.f557d) {
                this.f559f.write(sb.toString().getBytes());
            } else {
                this.f558e.write(sb.toString().getBytes());
            }
        } catch (IOException unused) {
        }
        byte[] bytes = str2.getBytes();
        if (z) {
            bytes = C0784g.m777a(bytes);
        }
        try {
            if (this.f557d) {
                this.f559f.write(bytes);
                this.f559f.write("\r\n".getBytes());
            } else {
                this.f558e.write(bytes);
                this.f558e.write("\r\n".getBytes());
            }
        } catch (IOException unused2) {
        }
    }

    /* renamed from: a */
    public void m720a(String str, Map<String, String> map, File... fileArr) {
        StringBuilder sb = new StringBuilder("--");
        sb.append(this.f554a).append("\r\nContent-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(str).append("\"");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("; ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
            }
        }
        sb.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.f557d) {
            this.f559f.write(sb.toString().getBytes());
        } else {
            this.f558e.write(sb.toString().getBytes());
        }
        C0786i.m792a(this.f557d ? this.f559f : this.f558e, fileArr);
        if (this.f557d) {
            this.f559f.write("\r\n".getBytes());
        } else {
            this.f558e.write("\r\n".getBytes());
            this.f558e.flush();
        }
    }

    /* renamed from: a */
    public void m721a(String str, File... fileArr) {
        m720a(str, (Map<String, String>) null, fileArr);
    }
}
