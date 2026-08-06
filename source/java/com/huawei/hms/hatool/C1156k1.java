package com.huawei.hms.hatool;

import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;

/* renamed from: com.huawei.hms.hatool.k1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class C1156k1 {
    /* renamed from: a */
    public static String m1595a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
        } catch (FileNotFoundException unused) {
        } catch (IOException unused2) {
        }
        try {
            C1145h c1145h = new C1145h(1024);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                c1145h.m1545a(bArr, read);
            }
            if (c1145h.m1547b() == 0) {
                m1597a((Closeable) fileInputStream);
                return "";
            }
            String str = new String(c1145h.m1546a(), Utf8Charset.NAME);
            m1597a((Closeable) fileInputStream);
            return str;
        } catch (FileNotFoundException unused3) {
            fileInputStream2 = fileInputStream;
            C1182v.m1786f("hmsSdk", "getInfoFromFile(): No files need to be read");
            m1597a((Closeable) fileInputStream2);
            return "";
        } catch (IOException unused4) {
            fileInputStream2 = fileInputStream;
            C1182v.m1786f("hmsSdk", "getInfoFromFile(): stream.read or new string exception");
            m1597a((Closeable) fileInputStream2);
            return "";
        } catch (Throwable th2) {
            th = th2;
            m1597a((Closeable) fileInputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static String m1596a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toString(Utf8Charset.NAME);
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            m1597a((Closeable) byteArrayOutputStream);
        }
    }

    /* renamed from: a */
    public static void m1597a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C1182v.m1786f("hmsSdk", "closeQuietly(): Exception when closing the closeable!");
            }
        }
    }

    /* renamed from: a */
    public static void m1598a(File file, String str) {
        String str2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(str.getBytes(Utf8Charset.NAME));
                    fileOutputStream.flush();
                } catch (FileNotFoundException unused) {
                    fileOutputStream2 = fileOutputStream;
                    str2 = "saveInfoToFile(): No files need to be read";
                    fileOutputStream = fileOutputStream2;
                    C1182v.m1786f("hmsSdk", str2);
                    m1597a((Closeable) fileOutputStream);
                } catch (IOException unused2) {
                    fileOutputStream2 = fileOutputStream;
                    str2 = "saveInfoToFile(): io exc from write info to file!";
                    fileOutputStream = fileOutputStream2;
                    C1182v.m1786f("hmsSdk", str2);
                    m1597a((Closeable) fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream2 = fileOutputStream;
                m1597a((Closeable) fileOutputStream2);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        } catch (IOException unused4) {
        } catch (Throwable th2) {
            th = th2;
            m1597a((Closeable) fileOutputStream2);
            throw th;
        }
        m1597a((Closeable) fileOutputStream);
    }

    /* renamed from: a */
    private static void m1599a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                C1182v.m1786f("hmsSdk", "closeStream(): Exception: close OutputStream error!");
            }
        }
    }

    /* renamed from: a */
    public static void m1600a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (Exception unused) {
            C1182v.m1786f("hmsSdk", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
        }
        httpURLConnection.disconnect();
        C1182v.m1775a("hmsSdk", " connHttp disconnect");
    }

    /* renamed from: a */
    public static byte[] m1601a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[1024];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        deflater.end();
        m1599a((OutputStream) byteArrayOutputStream);
        return byteArray;
    }
}
